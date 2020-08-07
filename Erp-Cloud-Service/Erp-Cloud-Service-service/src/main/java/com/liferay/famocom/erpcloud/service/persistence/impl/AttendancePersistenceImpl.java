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

import com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException;
import com.liferay.famocom.erpcloud.model.Attendance;
import com.liferay.famocom.erpcloud.model.impl.AttendanceImpl;
import com.liferay.famocom.erpcloud.model.impl.AttendanceModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.AttendancePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
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
 * The persistence implementation for the attendance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AttendancePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.AttendanceUtil
 * @generated
 */
@ProviderType
public class AttendancePersistenceImpl extends BasePersistenceImpl<Attendance>
	implements AttendancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AttendanceUtil} to access the attendance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AttendanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceModelImpl.FINDER_CACHE_ENABLED, AttendanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceModelImpl.FINDER_CACHE_ENABLED, AttendanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPIDANDATTDATE = new FinderPath(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceModelImpl.FINDER_CACHE_ENABLED, AttendanceImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByempIdAndAttDate",
			new String[] { Long.class.getName(), Date.class.getName() },
			AttendanceModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AttendanceModelImpl.ATTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPIDANDATTDATE = new FinderPath(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempIdAndAttDate",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns the attendance where employeeId = &#63; and attDate = &#63; or throws a {@link NoSuchAttendanceException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param attDate the att date
	 * @return the matching attendance
	 * @throws NoSuchAttendanceException if a matching attendance could not be found
	 */
	@Override
	public Attendance findByempIdAndAttDate(long employeeId, Date attDate)
		throws NoSuchAttendanceException {
		Attendance attendance = fetchByempIdAndAttDate(employeeId, attDate);

		if (attendance == null) {
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

			throw new NoSuchAttendanceException(msg.toString());
		}

		return attendance;
	}

	/**
	 * Returns the attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param attDate the att date
	 * @return the matching attendance, or <code>null</code> if a matching attendance could not be found
	 */
	@Override
	public Attendance fetchByempIdAndAttDate(long employeeId, Date attDate) {
		return fetchByempIdAndAttDate(employeeId, attDate, true);
	}

	/**
	 * Returns the attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param attDate the att date
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching attendance, or <code>null</code> if a matching attendance could not be found
	 */
	@Override
	public Attendance fetchByempIdAndAttDate(long employeeId, Date attDate,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { employeeId, _getTime(attDate) };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
					finderArgs, this);
		}

		if (result instanceof Attendance) {
			Attendance attendance = (Attendance)result;

			if ((employeeId != attendance.getEmployeeId()) ||
					!Objects.equals(attDate, attendance.getAttDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ATTENDANCE_WHERE);

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

				List<Attendance> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AttendancePersistenceImpl.fetchByempIdAndAttDate(long, Date, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Attendance attendance = list.get(0);

					result = attendance;

					cacheResult(attendance);
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
			return (Attendance)result;
		}
	}

	/**
	 * Removes the attendance where employeeId = &#63; and attDate = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param attDate the att date
	 * @return the attendance that was removed
	 */
	@Override
	public Attendance removeByempIdAndAttDate(long employeeId, Date attDate)
		throws NoSuchAttendanceException {
		Attendance attendance = findByempIdAndAttDate(employeeId, attDate);

		return remove(attendance);
	}

	/**
	 * Returns the number of attendances where employeeId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param attDate the att date
	 * @return the number of matching attendances
	 */
	@Override
	public int countByempIdAndAttDate(long employeeId, Date attDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPIDANDATTDATE;

		Object[] finderArgs = new Object[] { employeeId, _getTime(attDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ATTENDANCE_WHERE);

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

	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_EMPLOYEEID_2 = "attendance.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_ATTDATE_1 = "attendance.attDate IS NULL";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_ATTDATE_2 = "attendance.attDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID =
		new FinderPath(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceModelImpl.FINDER_CACHE_ENABLED, AttendanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByempIdAndAttDateComId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID =
		new FinderPath(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceModelImpl.FINDER_CACHE_ENABLED, AttendanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByempIdAndAttDateComId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			AttendanceModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AttendanceModelImpl.COMPANYID_COLUMN_BITMASK |
			AttendanceModelImpl.ATTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPIDANDATTDATECOMID = new FinderPath(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempIdAndAttDateComId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			});

	/**
	 * Returns all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @return the matching attendances
	 */
	@Override
	public List<Attendance> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate) {
		return findByempIdAndAttDateComId(employeeId, companyId, attDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param start the lower bound of the range of attendances
	 * @param end the upper bound of the range of attendances (not inclusive)
	 * @return the range of matching attendances
	 */
	@Override
	public List<Attendance> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate, int start, int end) {
		return findByempIdAndAttDateComId(employeeId, companyId, attDate,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param start the lower bound of the range of attendances
	 * @param end the upper bound of the range of attendances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attendances
	 */
	@Override
	public List<Attendance> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate, int start, int end,
		OrderByComparator<Attendance> orderByComparator) {
		return findByempIdAndAttDateComId(employeeId, companyId, attDate,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param start the lower bound of the range of attendances
	 * @param end the upper bound of the range of attendances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching attendances
	 */
	@Override
	public List<Attendance> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate, int start, int end,
		OrderByComparator<Attendance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID;
			finderArgs = new Object[] { employeeId, companyId, _getTime(attDate) };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID;
			finderArgs = new Object[] {
					employeeId, companyId, _getTime(attDate),
					
					start, end, orderByComparator
				};
		}

		List<Attendance> list = null;

		if (retrieveFromCache) {
			list = (List<Attendance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Attendance attendance : list) {
					if ((employeeId != attendance.getEmployeeId()) ||
							(companyId != attendance.getCompanyId()) ||
							!Objects.equals(attDate, attendance.getAttDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ATTENDANCE_WHERE);

			query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_COMPANYID_2);

			boolean bindAttDate = false;

			if (attDate == null) {
				query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_ATTDATE_1);
			}
			else {
				bindAttDate = true;

				query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_ATTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttendanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(companyId);

				if (bindAttDate) {
					qPos.add(new Timestamp(attDate.getTime()));
				}

				if (!pagination) {
					list = (List<Attendance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Attendance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attendance
	 * @throws NoSuchAttendanceException if a matching attendance could not be found
	 */
	@Override
	public Attendance findByempIdAndAttDateComId_First(long employeeId,
		long companyId, Date attDate,
		OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException {
		Attendance attendance = fetchByempIdAndAttDateComId_First(employeeId,
				companyId, attDate, orderByComparator);

		if (attendance != null) {
			return attendance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", attDate=");
		msg.append(attDate);

		msg.append("}");

		throw new NoSuchAttendanceException(msg.toString());
	}

	/**
	 * Returns the first attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attendance, or <code>null</code> if a matching attendance could not be found
	 */
	@Override
	public Attendance fetchByempIdAndAttDateComId_First(long employeeId,
		long companyId, Date attDate,
		OrderByComparator<Attendance> orderByComparator) {
		List<Attendance> list = findByempIdAndAttDateComId(employeeId,
				companyId, attDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attendance
	 * @throws NoSuchAttendanceException if a matching attendance could not be found
	 */
	@Override
	public Attendance findByempIdAndAttDateComId_Last(long employeeId,
		long companyId, Date attDate,
		OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException {
		Attendance attendance = fetchByempIdAndAttDateComId_Last(employeeId,
				companyId, attDate, orderByComparator);

		if (attendance != null) {
			return attendance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", attDate=");
		msg.append(attDate);

		msg.append("}");

		throw new NoSuchAttendanceException(msg.toString());
	}

	/**
	 * Returns the last attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attendance, or <code>null</code> if a matching attendance could not be found
	 */
	@Override
	public Attendance fetchByempIdAndAttDateComId_Last(long employeeId,
		long companyId, Date attDate,
		OrderByComparator<Attendance> orderByComparator) {
		int count = countByempIdAndAttDateComId(employeeId, companyId, attDate);

		if (count == 0) {
			return null;
		}

		List<Attendance> list = findByempIdAndAttDateComId(employeeId,
				companyId, attDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attendances before and after the current attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param attendanceId the primary key of the current attendance
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attendance
	 * @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	 */
	@Override
	public Attendance[] findByempIdAndAttDateComId_PrevAndNext(
		long attendanceId, long employeeId, long companyId, Date attDate,
		OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException {
		Attendance attendance = findByPrimaryKey(attendanceId);

		Session session = null;

		try {
			session = openSession();

			Attendance[] array = new AttendanceImpl[3];

			array[0] = getByempIdAndAttDateComId_PrevAndNext(session,
					attendance, employeeId, companyId, attDate,
					orderByComparator, true);

			array[1] = attendance;

			array[2] = getByempIdAndAttDateComId_PrevAndNext(session,
					attendance, employeeId, companyId, attDate,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Attendance getByempIdAndAttDateComId_PrevAndNext(
		Session session, Attendance attendance, long employeeId,
		long companyId, Date attDate,
		OrderByComparator<Attendance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_ATTENDANCE_WHERE);

		query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_EMPLOYEEID_2);

		query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_COMPANYID_2);

		boolean bindAttDate = false;

		if (attDate == null) {
			query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_ATTDATE_1);
		}
		else {
			bindAttDate = true;

			query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_ATTDATE_2);
		}

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
			query.append(AttendanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		qPos.add(companyId);

		if (bindAttDate) {
			qPos.add(new Timestamp(attDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attendance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Attendance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 */
	@Override
	public void removeByempIdAndAttDateComId(long employeeId, long companyId,
		Date attDate) {
		for (Attendance attendance : findByempIdAndAttDateComId(employeeId,
				companyId, attDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(attendance);
		}
	}

	/**
	 * Returns the number of attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @return the number of matching attendances
	 */
	@Override
	public int countByempIdAndAttDateComId(long employeeId, long companyId,
		Date attDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPIDANDATTDATECOMID;

		Object[] finderArgs = new Object[] {
				employeeId, companyId, _getTime(attDate)
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ATTENDANCE_WHERE);

			query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_COMPANYID_2);

			boolean bindAttDate = false;

			if (attDate == null) {
				query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_ATTDATE_1);
			}
			else {
				bindAttDate = true;

				query.append(_FINDER_COLUMN_EMPIDANDATTDATECOMID_ATTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_EMPIDANDATTDATECOMID_EMPLOYEEID_2 =
		"attendance.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATECOMID_COMPANYID_2 = "attendance.companyId = ? AND ";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATECOMID_ATTDATE_1 = "attendance.attDate IS NULL";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATECOMID_ATTDATE_2 = "attendance.attDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPID = new FinderPath(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceModelImpl.FINDER_CACHE_ENABLED, AttendanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByempId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID = new FinderPath(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceModelImpl.FINDER_CACHE_ENABLED, AttendanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByempId",
			new String[] { Long.class.getName() },
			AttendanceModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPID = new FinderPath(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByempId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the attendances where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching attendances
	 */
	@Override
	public List<Attendance> findByempId(long employeeId) {
		return findByempId(employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the attendances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of attendances
	 * @param end the upper bound of the range of attendances (not inclusive)
	 * @return the range of matching attendances
	 */
	@Override
	public List<Attendance> findByempId(long employeeId, int start, int end) {
		return findByempId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attendances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of attendances
	 * @param end the upper bound of the range of attendances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attendances
	 */
	@Override
	public List<Attendance> findByempId(long employeeId, int start, int end,
		OrderByComparator<Attendance> orderByComparator) {
		return findByempId(employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attendances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of attendances
	 * @param end the upper bound of the range of attendances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching attendances
	 */
	@Override
	public List<Attendance> findByempId(long employeeId, int start, int end,
		OrderByComparator<Attendance> orderByComparator,
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

		List<Attendance> list = null;

		if (retrieveFromCache) {
			list = (List<Attendance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Attendance attendance : list) {
					if ((employeeId != attendance.getEmployeeId())) {
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

			query.append(_SQL_SELECT_ATTENDANCE_WHERE);

			query.append(_FINDER_COLUMN_EMPID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttendanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<Attendance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Attendance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first attendance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attendance
	 * @throws NoSuchAttendanceException if a matching attendance could not be found
	 */
	@Override
	public Attendance findByempId_First(long employeeId,
		OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException {
		Attendance attendance = fetchByempId_First(employeeId, orderByComparator);

		if (attendance != null) {
			return attendance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchAttendanceException(msg.toString());
	}

	/**
	 * Returns the first attendance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attendance, or <code>null</code> if a matching attendance could not be found
	 */
	@Override
	public Attendance fetchByempId_First(long employeeId,
		OrderByComparator<Attendance> orderByComparator) {
		List<Attendance> list = findByempId(employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attendance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attendance
	 * @throws NoSuchAttendanceException if a matching attendance could not be found
	 */
	@Override
	public Attendance findByempId_Last(long employeeId,
		OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException {
		Attendance attendance = fetchByempId_Last(employeeId, orderByComparator);

		if (attendance != null) {
			return attendance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchAttendanceException(msg.toString());
	}

	/**
	 * Returns the last attendance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attendance, or <code>null</code> if a matching attendance could not be found
	 */
	@Override
	public Attendance fetchByempId_Last(long employeeId,
		OrderByComparator<Attendance> orderByComparator) {
		int count = countByempId(employeeId);

		if (count == 0) {
			return null;
		}

		List<Attendance> list = findByempId(employeeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attendances before and after the current attendance in the ordered set where employeeId = &#63;.
	 *
	 * @param attendanceId the primary key of the current attendance
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attendance
	 * @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	 */
	@Override
	public Attendance[] findByempId_PrevAndNext(long attendanceId,
		long employeeId, OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException {
		Attendance attendance = findByPrimaryKey(attendanceId);

		Session session = null;

		try {
			session = openSession();

			Attendance[] array = new AttendanceImpl[3];

			array[0] = getByempId_PrevAndNext(session, attendance, employeeId,
					orderByComparator, true);

			array[1] = attendance;

			array[2] = getByempId_PrevAndNext(session, attendance, employeeId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Attendance getByempId_PrevAndNext(Session session,
		Attendance attendance, long employeeId,
		OrderByComparator<Attendance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTENDANCE_WHERE);

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
			query.append(AttendanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attendance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Attendance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attendances where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByempId(long employeeId) {
		for (Attendance attendance : findByempId(employeeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(attendance);
		}
	}

	/**
	 * Returns the number of attendances where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching attendances
	 */
	@Override
	public int countByempId(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ATTENDANCE_WHERE);

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

	private static final String _FINDER_COLUMN_EMPID_EMPLOYEEID_2 = "attendance.employeeId = ?";

	public AttendancePersistenceImpl() {
		setModelClass(Attendance.class);
	}

	/**
	 * Caches the attendance in the entity cache if it is enabled.
	 *
	 * @param attendance the attendance
	 */
	@Override
	public void cacheResult(Attendance attendance) {
		entityCache.putResult(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceImpl.class, attendance.getPrimaryKey(), attendance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
			new Object[] { attendance.getEmployeeId(), attendance.getAttDate() },
			attendance);

		attendance.resetOriginalValues();
	}

	/**
	 * Caches the attendances in the entity cache if it is enabled.
	 *
	 * @param attendances the attendances
	 */
	@Override
	public void cacheResult(List<Attendance> attendances) {
		for (Attendance attendance : attendances) {
			if (entityCache.getResult(
						AttendanceModelImpl.ENTITY_CACHE_ENABLED,
						AttendanceImpl.class, attendance.getPrimaryKey()) == null) {
				cacheResult(attendance);
			}
			else {
				attendance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all attendances.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AttendanceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the attendance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Attendance attendance) {
		entityCache.removeResult(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceImpl.class, attendance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AttendanceModelImpl)attendance, true);
	}

	@Override
	public void clearCache(List<Attendance> attendances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Attendance attendance : attendances) {
			entityCache.removeResult(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
				AttendanceImpl.class, attendance.getPrimaryKey());

			clearUniqueFindersCache((AttendanceModelImpl)attendance, true);
		}
	}

	protected void cacheUniqueFindersCache(
		AttendanceModelImpl attendanceModelImpl) {
		Object[] args = new Object[] {
				attendanceModelImpl.getEmployeeId(),
				_getTime(attendanceModelImpl.getAttDate())
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args,
			attendanceModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AttendanceModelImpl attendanceModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					attendanceModelImpl.getEmployeeId(),
					_getTime(attendanceModelImpl.getAttDate())
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args);
		}

		if ((attendanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPIDANDATTDATE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					attendanceModelImpl.getOriginalEmployeeId(),
					_getTime(attendanceModelImpl.getOriginalAttDate())
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args);
		}
	}

	/**
	 * Creates a new attendance with the primary key. Does not add the attendance to the database.
	 *
	 * @param attendanceId the primary key for the new attendance
	 * @return the new attendance
	 */
	@Override
	public Attendance create(long attendanceId) {
		Attendance attendance = new AttendanceImpl();

		attendance.setNew(true);
		attendance.setPrimaryKey(attendanceId);

		attendance.setCompanyId(companyProvider.getCompanyId());

		return attendance;
	}

	/**
	 * Removes the attendance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attendanceId the primary key of the attendance
	 * @return the attendance that was removed
	 * @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	 */
	@Override
	public Attendance remove(long attendanceId)
		throws NoSuchAttendanceException {
		return remove((Serializable)attendanceId);
	}

	/**
	 * Removes the attendance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attendance
	 * @return the attendance that was removed
	 * @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	 */
	@Override
	public Attendance remove(Serializable primaryKey)
		throws NoSuchAttendanceException {
		Session session = null;

		try {
			session = openSession();

			Attendance attendance = (Attendance)session.get(AttendanceImpl.class,
					primaryKey);

			if (attendance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttendanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(attendance);
		}
		catch (NoSuchAttendanceException nsee) {
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
	protected Attendance removeImpl(Attendance attendance) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attendance)) {
				attendance = (Attendance)session.get(AttendanceImpl.class,
						attendance.getPrimaryKeyObj());
			}

			if (attendance != null) {
				session.delete(attendance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (attendance != null) {
			clearCache(attendance);
		}

		return attendance;
	}

	@Override
	public Attendance updateImpl(Attendance attendance) {
		boolean isNew = attendance.isNew();

		if (!(attendance instanceof AttendanceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(attendance.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(attendance);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in attendance proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Attendance implementation " +
				attendance.getClass());
		}

		AttendanceModelImpl attendanceModelImpl = (AttendanceModelImpl)attendance;

		Session session = null;

		try {
			session = openSession();

			if (attendance.isNew()) {
				session.save(attendance);

				attendance.setNew(false);
			}
			else {
				attendance = (Attendance)session.merge(attendance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AttendanceModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					attendanceModelImpl.getEmployeeId(),
					attendanceModelImpl.getCompanyId(),
					attendanceModelImpl.getAttDate()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATECOMID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID,
				args);

			args = new Object[] { attendanceModelImpl.getEmployeeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((attendanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attendanceModelImpl.getOriginalEmployeeId(),
						attendanceModelImpl.getOriginalCompanyId(),
						attendanceModelImpl.getOriginalAttDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATECOMID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID,
					args);

				args = new Object[] {
						attendanceModelImpl.getEmployeeId(),
						attendanceModelImpl.getCompanyId(),
						attendanceModelImpl.getAttDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATECOMID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID,
					args);
			}

			if ((attendanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attendanceModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID,
					args);

				args = new Object[] { attendanceModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID,
					args);
			}
		}

		entityCache.putResult(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceImpl.class, attendance.getPrimaryKey(), attendance, false);

		clearUniqueFindersCache(attendanceModelImpl, false);
		cacheUniqueFindersCache(attendanceModelImpl);

		attendance.resetOriginalValues();

		return attendance;
	}

	/**
	 * Returns the attendance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the attendance
	 * @return the attendance
	 * @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	 */
	@Override
	public Attendance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttendanceException {
		Attendance attendance = fetchByPrimaryKey(primaryKey);

		if (attendance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttendanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return attendance;
	}

	/**
	 * Returns the attendance with the primary key or throws a {@link NoSuchAttendanceException} if it could not be found.
	 *
	 * @param attendanceId the primary key of the attendance
	 * @return the attendance
	 * @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	 */
	@Override
	public Attendance findByPrimaryKey(long attendanceId)
		throws NoSuchAttendanceException {
		return findByPrimaryKey((Serializable)attendanceId);
	}

	/**
	 * Returns the attendance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attendance
	 * @return the attendance, or <code>null</code> if a attendance with the primary key could not be found
	 */
	@Override
	public Attendance fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
				AttendanceImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Attendance attendance = (Attendance)serializable;

		if (attendance == null) {
			Session session = null;

			try {
				session = openSession();

				attendance = (Attendance)session.get(AttendanceImpl.class,
						primaryKey);

				if (attendance != null) {
					cacheResult(attendance);
				}
				else {
					entityCache.putResult(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
						AttendanceImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
					AttendanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return attendance;
	}

	/**
	 * Returns the attendance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attendanceId the primary key of the attendance
	 * @return the attendance, or <code>null</code> if a attendance with the primary key could not be found
	 */
	@Override
	public Attendance fetchByPrimaryKey(long attendanceId) {
		return fetchByPrimaryKey((Serializable)attendanceId);
	}

	@Override
	public Map<Serializable, Attendance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Attendance> map = new HashMap<Serializable, Attendance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Attendance attendance = fetchByPrimaryKey(primaryKey);

			if (attendance != null) {
				map.put(primaryKey, attendance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
					AttendanceImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Attendance)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ATTENDANCE_WHERE_PKS_IN);

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

			for (Attendance attendance : (List<Attendance>)q.list()) {
				map.put(attendance.getPrimaryKeyObj(), attendance);

				cacheResult(attendance);

				uncachedPrimaryKeys.remove(attendance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AttendanceModelImpl.ENTITY_CACHE_ENABLED,
					AttendanceImpl.class, primaryKey, nullModel);
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
	 * Returns all the attendances.
	 *
	 * @return the attendances
	 */
	@Override
	public List<Attendance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attendances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attendances
	 * @param end the upper bound of the range of attendances (not inclusive)
	 * @return the range of attendances
	 */
	@Override
	public List<Attendance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the attendances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attendances
	 * @param end the upper bound of the range of attendances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attendances
	 */
	@Override
	public List<Attendance> findAll(int start, int end,
		OrderByComparator<Attendance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attendances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attendances
	 * @param end the upper bound of the range of attendances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of attendances
	 */
	@Override
	public List<Attendance> findAll(int start, int end,
		OrderByComparator<Attendance> orderByComparator,
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

		List<Attendance> list = null;

		if (retrieveFromCache) {
			list = (List<Attendance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ATTENDANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATTENDANCE;

				if (pagination) {
					sql = sql.concat(AttendanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Attendance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Attendance>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the attendances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Attendance attendance : findAll()) {
			remove(attendance);
		}
	}

	/**
	 * Returns the number of attendances.
	 *
	 * @return the number of attendances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ATTENDANCE);

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
		return AttendanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the attendance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AttendanceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
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

	private static final String _SQL_SELECT_ATTENDANCE = "SELECT attendance FROM Attendance attendance";
	private static final String _SQL_SELECT_ATTENDANCE_WHERE_PKS_IN = "SELECT attendance FROM Attendance attendance WHERE attendanceId IN (";
	private static final String _SQL_SELECT_ATTENDANCE_WHERE = "SELECT attendance FROM Attendance attendance WHERE ";
	private static final String _SQL_COUNT_ATTENDANCE = "SELECT COUNT(attendance) FROM Attendance attendance";
	private static final String _SQL_COUNT_ATTENDANCE_WHERE = "SELECT COUNT(attendance) FROM Attendance attendance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "attendance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Attendance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Attendance exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AttendancePersistenceImpl.class);
}