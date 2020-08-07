/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.famocom.erpcloud.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.exception.NoSuchGeoAttendanceException;
import com.liferay.famocom.erpcloud.model.GeoAttendance;
import com.liferay.famocom.erpcloud.model.impl.GeoAttendanceImpl;
import com.liferay.famocom.erpcloud.model.impl.GeoAttendanceModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.GeoAttendancePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the geo attendance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see GeoAttendancePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.GeoAttendanceUtil
 * @generated
 */
@ProviderType
public class GeoAttendancePersistenceImpl extends BasePersistenceImpl<GeoAttendance>
	implements GeoAttendancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeoAttendanceUtil} to access the geo attendance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeoAttendanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
			GeoAttendanceModelImpl.FINDER_CACHE_ENABLED,
			GeoAttendanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
			GeoAttendanceModelImpl.FINDER_CACHE_ENABLED,
			GeoAttendanceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
			GeoAttendanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPIDANDATTDATE = new FinderPath(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
			GeoAttendanceModelImpl.FINDER_CACHE_ENABLED,
			GeoAttendanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByempIdAndAttDate",
			new String[] { Long.class.getName(), Date.class.getName() },
			GeoAttendanceModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			GeoAttendanceModelImpl.ATTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPIDANDATTDATE = new FinderPath(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
			GeoAttendanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempIdAndAttDate",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns the geo attendance where employeeId = &#63; and attDate = &#63; or throws a {@link NoSuchGeoAttendanceException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param attDate the att date
	 * @return the matching geo attendance
	 * @throws NoSuchGeoAttendanceException if a matching geo attendance could not be found
	 */
	@Override
	public GeoAttendance findByempIdAndAttDate(long employeeId, Date attDate)
		throws NoSuchGeoAttendanceException {
		GeoAttendance geoAttendance = fetchByempIdAndAttDate(employeeId, attDate);

		if (geoAttendance == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(", attDate=");
			msg.append(attDate);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchGeoAttendanceException(msg.toString());
		}

		return geoAttendance;
	}

	/**
	 * Returns the geo attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param attDate the att date
	 * @return the matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	 */
	@Override
	public GeoAttendance fetchByempIdAndAttDate(long employeeId, Date attDate) {
		return fetchByempIdAndAttDate(employeeId, attDate, true);
	}

	/**
	 * Returns the geo attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param attDate the att date
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	 */
	@Override
	public GeoAttendance fetchByempIdAndAttDate(long employeeId, Date attDate,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { employeeId, _getTime(attDate) };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
					finderArgs, this);
		}

		if (result instanceof GeoAttendance) {
			GeoAttendance geoAttendance = (GeoAttendance)result;

			if ((employeeId != geoAttendance.getEmployeeId()) ||
					!Objects.equals(attDate, geoAttendance.getAttDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_GEOATTENDANCE_WHERE);

			query.append(_FINDER_COLUMN_EMPIDANDATTDATE_EMPLOYEEID_2);

			boolean bindAttDate = false;

			if (attDate == null) {
				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_ATTDATE_1);
			}
			else {
				bindAttDate = true;

				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_ATTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (bindAttDate) {
					qPos.add(new Timestamp(attDate.getTime()));
				}

				List<GeoAttendance> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"GeoAttendancePersistenceImpl.fetchByempIdAndAttDate(long, Date, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					GeoAttendance geoAttendance = list.get(0);

					result = geoAttendance;

					cacheResult(geoAttendance);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (GeoAttendance)result;
		}
	}

	/**
	 * Removes the geo attendance where employeeId = &#63; and attDate = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param attDate the att date
	 * @return the geo attendance that was removed
	 */
	@Override
	public GeoAttendance removeByempIdAndAttDate(long employeeId, Date attDate)
		throws NoSuchGeoAttendanceException {
		GeoAttendance geoAttendance = findByempIdAndAttDate(employeeId, attDate);

		return remove(geoAttendance);
	}

	/**
	 * Returns the number of geo attendances where employeeId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param attDate the att date
	 * @return the number of matching geo attendances
	 */
	@Override
	public int countByempIdAndAttDate(long employeeId, Date attDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPIDANDATTDATE;

		Object[] finderArgs = new Object[] { employeeId, _getTime(attDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEOATTENDANCE_WHERE);

			query.append(_FINDER_COLUMN_EMPIDANDATTDATE_EMPLOYEEID_2);

			boolean bindAttDate = false;

			if (attDate == null) {
				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_ATTDATE_1);
			}
			else {
				bindAttDate = true;

				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_ATTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (bindAttDate) {
					qPos.add(new Timestamp(attDate.getTime()));
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_EMPLOYEEID_2 = "geoAttendance.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_ATTDATE_1 = "geoAttendance.attDate IS NULL";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_ATTDATE_2 = "geoAttendance.attDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPID = new FinderPath(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
			GeoAttendanceModelImpl.FINDER_CACHE_ENABLED,
			GeoAttendanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByempId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID = new FinderPath(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
			GeoAttendanceModelImpl.FINDER_CACHE_ENABLED,
			GeoAttendanceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByempId", new String[] { Long.class.getName() },
			GeoAttendanceModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPID = new FinderPath(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
			GeoAttendanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByempId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the geo attendances where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching geo attendances
	 */
	@Override
	public List<GeoAttendance> findByempId(long employeeId) {
		return findByempId(employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the geo attendances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of geo attendances
	 * @param end the upper bound of the range of geo attendances (not inclusive)
	 * @return the range of matching geo attendances
	 */
	@Override
	public List<GeoAttendance> findByempId(long employeeId, int start, int end) {
		return findByempId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the geo attendances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of geo attendances
	 * @param end the upper bound of the range of geo attendances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geo attendances
	 */
	@Override
	public List<GeoAttendance> findByempId(long employeeId, int start, int end,
		OrderByComparator<GeoAttendance> orderByComparator) {
		return findByempId(employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the geo attendances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of geo attendances
	 * @param end the upper bound of the range of geo attendances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geo attendances
	 */
	@Override
	public List<GeoAttendance> findByempId(long employeeId, int start, int end,
		OrderByComparator<GeoAttendance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID;
			finderArgs = new Object[] { employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPID;
			finderArgs = new Object[] { employeeId, start, end, orderByComparator };
		}

		List<GeoAttendance> list = null;

		if (retrieveFromCache) {
			list = (List<GeoAttendance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GeoAttendance geoAttendance : list) {
					if ((employeeId != geoAttendance.getEmployeeId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GEOATTENDANCE_WHERE);

			query.append(_FINDER_COLUMN_EMPID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeoAttendanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<GeoAttendance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GeoAttendance>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first geo attendance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geo attendance
	 * @throws NoSuchGeoAttendanceException if a matching geo attendance could not be found
	 */
	@Override
	public GeoAttendance findByempId_First(long employeeId,
		OrderByComparator<GeoAttendance> orderByComparator)
		throws NoSuchGeoAttendanceException {
		GeoAttendance geoAttendance = fetchByempId_First(employeeId,
				orderByComparator);

		if (geoAttendance != null) {
			return geoAttendance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchGeoAttendanceException(msg.toString());
	}

	/**
	 * Returns the first geo attendance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	 */
	@Override
	public GeoAttendance fetchByempId_First(long employeeId,
		OrderByComparator<GeoAttendance> orderByComparator) {
		List<GeoAttendance> list = findByempId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geo attendance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geo attendance
	 * @throws NoSuchGeoAttendanceException if a matching geo attendance could not be found
	 */
	@Override
	public GeoAttendance findByempId_Last(long employeeId,
		OrderByComparator<GeoAttendance> orderByComparator)
		throws NoSuchGeoAttendanceException {
		GeoAttendance geoAttendance = fetchByempId_Last(employeeId,
				orderByComparator);

		if (geoAttendance != null) {
			return geoAttendance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchGeoAttendanceException(msg.toString());
	}

	/**
	 * Returns the last geo attendance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	 */
	@Override
	public GeoAttendance fetchByempId_Last(long employeeId,
		OrderByComparator<GeoAttendance> orderByComparator) {
		int count = countByempId(employeeId);

		if (count == 0) {
			return null;
		}

		List<GeoAttendance> list = findByempId(employeeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the geo attendances before and after the current geo attendance in the ordered set where employeeId = &#63;.
	 *
	 * @param attendanceId the primary key of the current geo attendance
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geo attendance
	 * @throws NoSuchGeoAttendanceException if a geo attendance with the primary key could not be found
	 */
	@Override
	public GeoAttendance[] findByempId_PrevAndNext(long attendanceId,
		long employeeId, OrderByComparator<GeoAttendance> orderByComparator)
		throws NoSuchGeoAttendanceException {
		GeoAttendance geoAttendance = findByPrimaryKey(attendanceId);

		Session session = null;

		try {
			session = openSession();

			GeoAttendance[] array = new GeoAttendanceImpl[3];

			array[0] = getByempId_PrevAndNext(session, geoAttendance,
					employeeId, orderByComparator, true);

			array[1] = geoAttendance;

			array[2] = getByempId_PrevAndNext(session, geoAttendance,
					employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GeoAttendance getByempId_PrevAndNext(Session session,
		GeoAttendance geoAttendance, long employeeId,
		OrderByComparator<GeoAttendance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEOATTENDANCE_WHERE);

		query.append(_FINDER_COLUMN_EMPID_EMPLOYEEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GeoAttendanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(geoAttendance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GeoAttendance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geo attendances where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByempId(long employeeId) {
		for (GeoAttendance geoAttendance : findByempId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(geoAttendance);
		}
	}

	/**
	 * Returns the number of geo attendances where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching geo attendances
	 */
	@Override
	public int countByempId(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEOATTENDANCE_WHERE);

			query.append(_FINDER_COLUMN_EMPID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPID_EMPLOYEEID_2 = "geoAttendance.employeeId = ?";

	public GeoAttendancePersistenceImpl() {
		setModelClass(GeoAttendance.class);
	}

	/**
	 * Caches the geo attendance in the entity cache if it is enabled.
	 *
	 * @param geoAttendance the geo attendance
	 */
	@Override
	public void cacheResult(GeoAttendance geoAttendance) {
		entityCache.putResult(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
			GeoAttendanceImpl.class, geoAttendance.getPrimaryKey(),
			geoAttendance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
			new Object[] {
				geoAttendance.getEmployeeId(), geoAttendance.getAttDate()
			}, geoAttendance);

		geoAttendance.resetOriginalValues();
	}

	/**
	 * Caches the geo attendances in the entity cache if it is enabled.
	 *
	 * @param geoAttendances the geo attendances
	 */
	@Override
	public void cacheResult(List<GeoAttendance> geoAttendances) {
		for (GeoAttendance geoAttendance : geoAttendances) {
			if (entityCache.getResult(
						GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
						GeoAttendanceImpl.class, geoAttendance.getPrimaryKey()) == null) {
				cacheResult(geoAttendance);
			}
			else {
				geoAttendance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all geo attendances.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GeoAttendanceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the geo attendance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GeoAttendance geoAttendance) {
		entityCache.removeResult(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
			GeoAttendanceImpl.class, geoAttendance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((GeoAttendanceModelImpl)geoAttendance, true);
	}

	@Override
	public void clearCache(List<GeoAttendance> geoAttendances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GeoAttendance geoAttendance : geoAttendances) {
			entityCache.removeResult(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
				GeoAttendanceImpl.class, geoAttendance.getPrimaryKey());

			clearUniqueFindersCache((GeoAttendanceModelImpl)geoAttendance, true);
		}
	}

	protected void cacheUniqueFindersCache(
		GeoAttendanceModelImpl geoAttendanceModelImpl) {
		Object[] args = new Object[] {
				geoAttendanceModelImpl.getEmployeeId(),
				_getTime(geoAttendanceModelImpl.getAttDate())
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args,
			geoAttendanceModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		GeoAttendanceModelImpl geoAttendanceModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					geoAttendanceModelImpl.getEmployeeId(),
					_getTime(geoAttendanceModelImpl.getAttDate())
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args);
		}

		if ((geoAttendanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPIDANDATTDATE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					geoAttendanceModelImpl.getOriginalEmployeeId(),
					_getTime(geoAttendanceModelImpl.getOriginalAttDate())
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args);
		}
	}

	/**
	 * Creates a new geo attendance with the primary key. Does not add the geo attendance to the database.
	 *
	 * @param attendanceId the primary key for the new geo attendance
	 * @return the new geo attendance
	 */
	@Override
	public GeoAttendance create(long attendanceId) {
		GeoAttendance geoAttendance = new GeoAttendanceImpl();

		geoAttendance.setNew(true);
		geoAttendance.setPrimaryKey(attendanceId);

		return geoAttendance;
	}

	/**
	 * Removes the geo attendance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attendanceId the primary key of the geo attendance
	 * @return the geo attendance that was removed
	 * @throws NoSuchGeoAttendanceException if a geo attendance with the primary key could not be found
	 */
	@Override
	public GeoAttendance remove(long attendanceId)
		throws NoSuchGeoAttendanceException {
		return remove((Serializable)attendanceId);
	}

	/**
	 * Removes the geo attendance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the geo attendance
	 * @return the geo attendance that was removed
	 * @throws NoSuchGeoAttendanceException if a geo attendance with the primary key could not be found
	 */
	@Override
	public GeoAttendance remove(Serializable primaryKey)
		throws NoSuchGeoAttendanceException {
		Session session = null;

		try {
			session = openSession();

			GeoAttendance geoAttendance = (GeoAttendance)session.get(GeoAttendanceImpl.class,
					primaryKey);

			if (geoAttendance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeoAttendanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(geoAttendance);
		}
		catch (NoSuchGeoAttendanceException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected GeoAttendance removeImpl(GeoAttendance geoAttendance) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(geoAttendance)) {
				geoAttendance = (GeoAttendance)session.get(GeoAttendanceImpl.class,
						geoAttendance.getPrimaryKeyObj());
			}

			if (geoAttendance != null) {
				session.delete(geoAttendance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (geoAttendance != null) {
			clearCache(geoAttendance);
		}

		return geoAttendance;
	}

	@Override
	public GeoAttendance updateImpl(GeoAttendance geoAttendance) {
		boolean isNew = geoAttendance.isNew();

		if (!(geoAttendance instanceof GeoAttendanceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(geoAttendance.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(geoAttendance);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in geoAttendance proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GeoAttendance implementation " +
				geoAttendance.getClass());
		}

		GeoAttendanceModelImpl geoAttendanceModelImpl = (GeoAttendanceModelImpl)geoAttendance;

		Session session = null;

		try {
			session = openSession();

			if (geoAttendance.isNew()) {
				session.save(geoAttendance);

				geoAttendance.setNew(false);
			}
			else {
				geoAttendance = (GeoAttendance)session.merge(geoAttendance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!GeoAttendanceModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { geoAttendanceModelImpl.getEmployeeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((geoAttendanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						geoAttendanceModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID,
					args);

				args = new Object[] { geoAttendanceModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID,
					args);
			}
		}

		entityCache.putResult(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
			GeoAttendanceImpl.class, geoAttendance.getPrimaryKey(),
			geoAttendance, false);

		clearUniqueFindersCache(geoAttendanceModelImpl, false);
		cacheUniqueFindersCache(geoAttendanceModelImpl);

		geoAttendance.resetOriginalValues();

		return geoAttendance;
	}

	/**
	 * Returns the geo attendance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the geo attendance
	 * @return the geo attendance
	 * @throws NoSuchGeoAttendanceException if a geo attendance with the primary key could not be found
	 */
	@Override
	public GeoAttendance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeoAttendanceException {
		GeoAttendance geoAttendance = fetchByPrimaryKey(primaryKey);

		if (geoAttendance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeoAttendanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return geoAttendance;
	}

	/**
	 * Returns the geo attendance with the primary key or throws a {@link NoSuchGeoAttendanceException} if it could not be found.
	 *
	 * @param attendanceId the primary key of the geo attendance
	 * @return the geo attendance
	 * @throws NoSuchGeoAttendanceException if a geo attendance with the primary key could not be found
	 */
	@Override
	public GeoAttendance findByPrimaryKey(long attendanceId)
		throws NoSuchGeoAttendanceException {
		return findByPrimaryKey((Serializable)attendanceId);
	}

	/**
	 * Returns the geo attendance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the geo attendance
	 * @return the geo attendance, or <code>null</code> if a geo attendance with the primary key could not be found
	 */
	@Override
	public GeoAttendance fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
				GeoAttendanceImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		GeoAttendance geoAttendance = (GeoAttendance)serializable;

		if (geoAttendance == null) {
			Session session = null;

			try {
				session = openSession();

				geoAttendance = (GeoAttendance)session.get(GeoAttendanceImpl.class,
						primaryKey);

				if (geoAttendance != null) {
					cacheResult(geoAttendance);
				}
				else {
					entityCache.putResult(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
						GeoAttendanceImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
					GeoAttendanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return geoAttendance;
	}

	/**
	 * Returns the geo attendance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attendanceId the primary key of the geo attendance
	 * @return the geo attendance, or <code>null</code> if a geo attendance with the primary key could not be found
	 */
	@Override
	public GeoAttendance fetchByPrimaryKey(long attendanceId) {
		return fetchByPrimaryKey((Serializable)attendanceId);
	}

	@Override
	public Map<Serializable, GeoAttendance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, GeoAttendance> map = new HashMap<Serializable, GeoAttendance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			GeoAttendance geoAttendance = fetchByPrimaryKey(primaryKey);

			if (geoAttendance != null) {
				map.put(primaryKey, geoAttendance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
					GeoAttendanceImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (GeoAttendance)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_GEOATTENDANCE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (GeoAttendance geoAttendance : (List<GeoAttendance>)q.list()) {
				map.put(geoAttendance.getPrimaryKeyObj(), geoAttendance);

				cacheResult(geoAttendance);

				uncachedPrimaryKeys.remove(geoAttendance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(GeoAttendanceModelImpl.ENTITY_CACHE_ENABLED,
					GeoAttendanceImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the geo attendances.
	 *
	 * @return the geo attendances
	 */
	@Override
	public List<GeoAttendance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the geo attendances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geo attendances
	 * @param end the upper bound of the range of geo attendances (not inclusive)
	 * @return the range of geo attendances
	 */
	@Override
	public List<GeoAttendance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the geo attendances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geo attendances
	 * @param end the upper bound of the range of geo attendances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of geo attendances
	 */
	@Override
	public List<GeoAttendance> findAll(int start, int end,
		OrderByComparator<GeoAttendance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the geo attendances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geo attendances
	 * @param end the upper bound of the range of geo attendances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of geo attendances
	 */
	@Override
	public List<GeoAttendance> findAll(int start, int end,
		OrderByComparator<GeoAttendance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<GeoAttendance> list = null;

		if (retrieveFromCache) {
			list = (List<GeoAttendance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GEOATTENDANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEOATTENDANCE;

				if (pagination) {
					sql = sql.concat(GeoAttendanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GeoAttendance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GeoAttendance>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the geo attendances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GeoAttendance geoAttendance : findAll()) {
			remove(geoAttendance);
		}
	}

	/**
	 * Returns the number of geo attendances.
	 *
	 * @return the number of geo attendances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GEOATTENDANCE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GeoAttendanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the geo attendance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(GeoAttendanceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_GEOATTENDANCE = "SELECT geoAttendance FROM GeoAttendance geoAttendance";
	private static final String _SQL_SELECT_GEOATTENDANCE_WHERE_PKS_IN = "SELECT geoAttendance FROM GeoAttendance geoAttendance WHERE attendanceId IN (";
	private static final String _SQL_SELECT_GEOATTENDANCE_WHERE = "SELECT geoAttendance FROM GeoAttendance geoAttendance WHERE ";
	private static final String _SQL_COUNT_GEOATTENDANCE = "SELECT COUNT(geoAttendance) FROM GeoAttendance geoAttendance";
	private static final String _SQL_COUNT_GEOATTENDANCE_WHERE = "SELECT COUNT(geoAttendance) FROM GeoAttendance geoAttendance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "geoAttendance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeoAttendance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GeoAttendance exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(GeoAttendancePersistenceImpl.class);
}