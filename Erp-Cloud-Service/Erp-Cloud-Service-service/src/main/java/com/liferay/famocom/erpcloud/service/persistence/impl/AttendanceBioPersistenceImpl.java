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

import com.liferay.famocom.erpcloud.exception.NoSuchAttendanceBioException;
import com.liferay.famocom.erpcloud.model.AttendanceBio;
import com.liferay.famocom.erpcloud.model.impl.AttendanceBioImpl;
import com.liferay.famocom.erpcloud.model.impl.AttendanceBioModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.AttendanceBioPersistence;

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
 * The persistence implementation for the attendance bio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AttendanceBioPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.AttendanceBioUtil
 * @generated
 */
@ProviderType
public class AttendanceBioPersistenceImpl extends BasePersistenceImpl<AttendanceBio>
	implements AttendanceBioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AttendanceBioUtil} to access the attendance bio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AttendanceBioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceBioModelImpl.FINDER_CACHE_ENABLED,
			AttendanceBioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceBioModelImpl.FINDER_CACHE_ENABLED,
			AttendanceBioImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceBioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID =
		new FinderPath(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceBioModelImpl.FINDER_CACHE_ENABLED,
			AttendanceBioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByempIdAndAttDateComId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID =
		new FinderPath(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceBioModelImpl.FINDER_CACHE_ENABLED,
			AttendanceBioImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByempIdAndAttDateComId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			AttendanceBioModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AttendanceBioModelImpl.COMPANYID_COLUMN_BITMASK |
			AttendanceBioModelImpl.ATTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPIDANDATTDATECOMID = new FinderPath(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceBioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempIdAndAttDateComId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			});

	/**
	 * Returns all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @return the matching attendance bios
	 */
	@Override
	public List<AttendanceBio> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate) {
		return findByempIdAndAttDateComId(employeeId, companyId, attDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param start the lower bound of the range of attendance bios
	 * @param end the upper bound of the range of attendance bios (not inclusive)
	 * @return the range of matching attendance bios
	 */
	@Override
	public List<AttendanceBio> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate, int start, int end) {
		return findByempIdAndAttDateComId(employeeId, companyId, attDate,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param start the lower bound of the range of attendance bios
	 * @param end the upper bound of the range of attendance bios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attendance bios
	 */
	@Override
	public List<AttendanceBio> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate, int start, int end,
		OrderByComparator<AttendanceBio> orderByComparator) {
		return findByempIdAndAttDateComId(employeeId, companyId, attDate,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param start the lower bound of the range of attendance bios
	 * @param end the upper bound of the range of attendance bios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching attendance bios
	 */
	@Override
	public List<AttendanceBio> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate, int start, int end,
		OrderByComparator<AttendanceBio> orderByComparator,
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

		List<AttendanceBio> list = null;

		if (retrieveFromCache) {
			list = (List<AttendanceBio>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AttendanceBio attendanceBio : list) {
					if ((employeeId != attendanceBio.getEmployeeId()) ||
							(companyId != attendanceBio.getCompanyId()) ||
							!Objects.equals(attDate, attendanceBio.getAttDate())) {
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

			query.append(_SQL_SELECT_ATTENDANCEBIO_WHERE);

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
				query.append(AttendanceBioModelImpl.ORDER_BY_JPQL);
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
					list = (List<AttendanceBio>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AttendanceBio>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attendance bio
	 * @throws NoSuchAttendanceBioException if a matching attendance bio could not be found
	 */
	@Override
	public AttendanceBio findByempIdAndAttDateComId_First(long employeeId,
		long companyId, Date attDate,
		OrderByComparator<AttendanceBio> orderByComparator)
		throws NoSuchAttendanceBioException {
		AttendanceBio attendanceBio = fetchByempIdAndAttDateComId_First(employeeId,
				companyId, attDate, orderByComparator);

		if (attendanceBio != null) {
			return attendanceBio;
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

		throw new NoSuchAttendanceBioException(msg.toString());
	}

	/**
	 * Returns the first attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attendance bio, or <code>null</code> if a matching attendance bio could not be found
	 */
	@Override
	public AttendanceBio fetchByempIdAndAttDateComId_First(long employeeId,
		long companyId, Date attDate,
		OrderByComparator<AttendanceBio> orderByComparator) {
		List<AttendanceBio> list = findByempIdAndAttDateComId(employeeId,
				companyId, attDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attendance bio
	 * @throws NoSuchAttendanceBioException if a matching attendance bio could not be found
	 */
	@Override
	public AttendanceBio findByempIdAndAttDateComId_Last(long employeeId,
		long companyId, Date attDate,
		OrderByComparator<AttendanceBio> orderByComparator)
		throws NoSuchAttendanceBioException {
		AttendanceBio attendanceBio = fetchByempIdAndAttDateComId_Last(employeeId,
				companyId, attDate, orderByComparator);

		if (attendanceBio != null) {
			return attendanceBio;
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

		throw new NoSuchAttendanceBioException(msg.toString());
	}

	/**
	 * Returns the last attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attendance bio, or <code>null</code> if a matching attendance bio could not be found
	 */
	@Override
	public AttendanceBio fetchByempIdAndAttDateComId_Last(long employeeId,
		long companyId, Date attDate,
		OrderByComparator<AttendanceBio> orderByComparator) {
		int count = countByempIdAndAttDateComId(employeeId, companyId, attDate);

		if (count == 0) {
			return null;
		}

		List<AttendanceBio> list = findByempIdAndAttDateComId(employeeId,
				companyId, attDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attendance bios before and after the current attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param attendanceBioId the primary key of the current attendance bio
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attendance bio
	 * @throws NoSuchAttendanceBioException if a attendance bio with the primary key could not be found
	 */
	@Override
	public AttendanceBio[] findByempIdAndAttDateComId_PrevAndNext(
		long attendanceBioId, long employeeId, long companyId, Date attDate,
		OrderByComparator<AttendanceBio> orderByComparator)
		throws NoSuchAttendanceBioException {
		AttendanceBio attendanceBio = findByPrimaryKey(attendanceBioId);

		Session session = null;

		try {
			session = openSession();

			AttendanceBio[] array = new AttendanceBioImpl[3];

			array[0] = getByempIdAndAttDateComId_PrevAndNext(session,
					attendanceBio, employeeId, companyId, attDate,
					orderByComparator, true);

			array[1] = attendanceBio;

			array[2] = getByempIdAndAttDateComId_PrevAndNext(session,
					attendanceBio, employeeId, companyId, attDate,
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

	protected AttendanceBio getByempIdAndAttDateComId_PrevAndNext(
		Session session, AttendanceBio attendanceBio, long employeeId,
		long companyId, Date attDate,
		OrderByComparator<AttendanceBio> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_ATTENDANCEBIO_WHERE);

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
			query.append(AttendanceBioModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(attendanceBio);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttendanceBio> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 */
	@Override
	public void removeByempIdAndAttDateComId(long employeeId, long companyId,
		Date attDate) {
		for (AttendanceBio attendanceBio : findByempIdAndAttDateComId(
				employeeId, companyId, attDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(attendanceBio);
		}
	}

	/**
	 * Returns the number of attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param attDate the att date
	 * @return the number of matching attendance bios
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

			query.append(_SQL_COUNT_ATTENDANCEBIO_WHERE);

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
		"attendanceBio.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATECOMID_COMPANYID_2 = "attendanceBio.companyId = ? AND ";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATECOMID_ATTDATE_1 = "attendanceBio.attDate IS NULL";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATECOMID_ATTDATE_2 = "attendanceBio.attDate = ?";

	public AttendanceBioPersistenceImpl() {
		setModelClass(AttendanceBio.class);
	}

	/**
	 * Caches the attendance bio in the entity cache if it is enabled.
	 *
	 * @param attendanceBio the attendance bio
	 */
	@Override
	public void cacheResult(AttendanceBio attendanceBio) {
		entityCache.putResult(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceBioImpl.class, attendanceBio.getPrimaryKey(),
			attendanceBio);

		attendanceBio.resetOriginalValues();
	}

	/**
	 * Caches the attendance bios in the entity cache if it is enabled.
	 *
	 * @param attendanceBios the attendance bios
	 */
	@Override
	public void cacheResult(List<AttendanceBio> attendanceBios) {
		for (AttendanceBio attendanceBio : attendanceBios) {
			if (entityCache.getResult(
						AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
						AttendanceBioImpl.class, attendanceBio.getPrimaryKey()) == null) {
				cacheResult(attendanceBio);
			}
			else {
				attendanceBio.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all attendance bios.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AttendanceBioImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the attendance bio.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AttendanceBio attendanceBio) {
		entityCache.removeResult(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceBioImpl.class, attendanceBio.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AttendanceBio> attendanceBios) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AttendanceBio attendanceBio : attendanceBios) {
			entityCache.removeResult(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
				AttendanceBioImpl.class, attendanceBio.getPrimaryKey());
		}
	}

	/**
	 * Creates a new attendance bio with the primary key. Does not add the attendance bio to the database.
	 *
	 * @param attendanceBioId the primary key for the new attendance bio
	 * @return the new attendance bio
	 */
	@Override
	public AttendanceBio create(long attendanceBioId) {
		AttendanceBio attendanceBio = new AttendanceBioImpl();

		attendanceBio.setNew(true);
		attendanceBio.setPrimaryKey(attendanceBioId);

		attendanceBio.setCompanyId(companyProvider.getCompanyId());

		return attendanceBio;
	}

	/**
	 * Removes the attendance bio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attendanceBioId the primary key of the attendance bio
	 * @return the attendance bio that was removed
	 * @throws NoSuchAttendanceBioException if a attendance bio with the primary key could not be found
	 */
	@Override
	public AttendanceBio remove(long attendanceBioId)
		throws NoSuchAttendanceBioException {
		return remove((Serializable)attendanceBioId);
	}

	/**
	 * Removes the attendance bio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attendance bio
	 * @return the attendance bio that was removed
	 * @throws NoSuchAttendanceBioException if a attendance bio with the primary key could not be found
	 */
	@Override
	public AttendanceBio remove(Serializable primaryKey)
		throws NoSuchAttendanceBioException {
		Session session = null;

		try {
			session = openSession();

			AttendanceBio attendanceBio = (AttendanceBio)session.get(AttendanceBioImpl.class,
					primaryKey);

			if (attendanceBio == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttendanceBioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(attendanceBio);
		}
		catch (NoSuchAttendanceBioException nsee) {
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
	protected AttendanceBio removeImpl(AttendanceBio attendanceBio) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attendanceBio)) {
				attendanceBio = (AttendanceBio)session.get(AttendanceBioImpl.class,
						attendanceBio.getPrimaryKeyObj());
			}

			if (attendanceBio != null) {
				session.delete(attendanceBio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (attendanceBio != null) {
			clearCache(attendanceBio);
		}

		return attendanceBio;
	}

	@Override
	public AttendanceBio updateImpl(AttendanceBio attendanceBio) {
		boolean isNew = attendanceBio.isNew();

		if (!(attendanceBio instanceof AttendanceBioModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(attendanceBio.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(attendanceBio);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in attendanceBio proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AttendanceBio implementation " +
				attendanceBio.getClass());
		}

		AttendanceBioModelImpl attendanceBioModelImpl = (AttendanceBioModelImpl)attendanceBio;

		Session session = null;

		try {
			session = openSession();

			if (attendanceBio.isNew()) {
				session.save(attendanceBio);

				attendanceBio.setNew(false);
			}
			else {
				attendanceBio = (AttendanceBio)session.merge(attendanceBio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AttendanceBioModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					attendanceBioModelImpl.getEmployeeId(),
					attendanceBioModelImpl.getCompanyId(),
					attendanceBioModelImpl.getAttDate()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATECOMID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((attendanceBioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attendanceBioModelImpl.getOriginalEmployeeId(),
						attendanceBioModelImpl.getOriginalCompanyId(),
						attendanceBioModelImpl.getOriginalAttDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATECOMID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID,
					args);

				args = new Object[] {
						attendanceBioModelImpl.getEmployeeId(),
						attendanceBioModelImpl.getCompanyId(),
						attendanceBioModelImpl.getAttDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATECOMID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIDANDATTDATECOMID,
					args);
			}
		}

		entityCache.putResult(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceBioImpl.class, attendanceBio.getPrimaryKey(),
			attendanceBio, false);

		attendanceBio.resetOriginalValues();

		return attendanceBio;
	}

	/**
	 * Returns the attendance bio with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the attendance bio
	 * @return the attendance bio
	 * @throws NoSuchAttendanceBioException if a attendance bio with the primary key could not be found
	 */
	@Override
	public AttendanceBio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttendanceBioException {
		AttendanceBio attendanceBio = fetchByPrimaryKey(primaryKey);

		if (attendanceBio == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttendanceBioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return attendanceBio;
	}

	/**
	 * Returns the attendance bio with the primary key or throws a {@link NoSuchAttendanceBioException} if it could not be found.
	 *
	 * @param attendanceBioId the primary key of the attendance bio
	 * @return the attendance bio
	 * @throws NoSuchAttendanceBioException if a attendance bio with the primary key could not be found
	 */
	@Override
	public AttendanceBio findByPrimaryKey(long attendanceBioId)
		throws NoSuchAttendanceBioException {
		return findByPrimaryKey((Serializable)attendanceBioId);
	}

	/**
	 * Returns the attendance bio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attendance bio
	 * @return the attendance bio, or <code>null</code> if a attendance bio with the primary key could not be found
	 */
	@Override
	public AttendanceBio fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
				AttendanceBioImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AttendanceBio attendanceBio = (AttendanceBio)serializable;

		if (attendanceBio == null) {
			Session session = null;

			try {
				session = openSession();

				attendanceBio = (AttendanceBio)session.get(AttendanceBioImpl.class,
						primaryKey);

				if (attendanceBio != null) {
					cacheResult(attendanceBio);
				}
				else {
					entityCache.putResult(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
						AttendanceBioImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
					AttendanceBioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return attendanceBio;
	}

	/**
	 * Returns the attendance bio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attendanceBioId the primary key of the attendance bio
	 * @return the attendance bio, or <code>null</code> if a attendance bio with the primary key could not be found
	 */
	@Override
	public AttendanceBio fetchByPrimaryKey(long attendanceBioId) {
		return fetchByPrimaryKey((Serializable)attendanceBioId);
	}

	@Override
	public Map<Serializable, AttendanceBio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AttendanceBio> map = new HashMap<Serializable, AttendanceBio>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AttendanceBio attendanceBio = fetchByPrimaryKey(primaryKey);

			if (attendanceBio != null) {
				map.put(primaryKey, attendanceBio);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
					AttendanceBioImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AttendanceBio)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ATTENDANCEBIO_WHERE_PKS_IN);

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

			for (AttendanceBio attendanceBio : (List<AttendanceBio>)q.list()) {
				map.put(attendanceBio.getPrimaryKeyObj(), attendanceBio);

				cacheResult(attendanceBio);

				uncachedPrimaryKeys.remove(attendanceBio.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AttendanceBioModelImpl.ENTITY_CACHE_ENABLED,
					AttendanceBioImpl.class, primaryKey, nullModel);
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
	 * Returns all the attendance bios.
	 *
	 * @return the attendance bios
	 */
	@Override
	public List<AttendanceBio> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attendance bios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attendance bios
	 * @param end the upper bound of the range of attendance bios (not inclusive)
	 * @return the range of attendance bios
	 */
	@Override
	public List<AttendanceBio> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the attendance bios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attendance bios
	 * @param end the upper bound of the range of attendance bios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attendance bios
	 */
	@Override
	public List<AttendanceBio> findAll(int start, int end,
		OrderByComparator<AttendanceBio> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attendance bios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attendance bios
	 * @param end the upper bound of the range of attendance bios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of attendance bios
	 */
	@Override
	public List<AttendanceBio> findAll(int start, int end,
		OrderByComparator<AttendanceBio> orderByComparator,
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

		List<AttendanceBio> list = null;

		if (retrieveFromCache) {
			list = (List<AttendanceBio>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ATTENDANCEBIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATTENDANCEBIO;

				if (pagination) {
					sql = sql.concat(AttendanceBioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AttendanceBio>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AttendanceBio>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the attendance bios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AttendanceBio attendanceBio : findAll()) {
			remove(attendanceBio);
		}
	}

	/**
	 * Returns the number of attendance bios.
	 *
	 * @return the number of attendance bios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ATTENDANCEBIO);

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
		return AttendanceBioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the attendance bio persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AttendanceBioImpl.class.getName());
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

	private static final String _SQL_SELECT_ATTENDANCEBIO = "SELECT attendanceBio FROM AttendanceBio attendanceBio";
	private static final String _SQL_SELECT_ATTENDANCEBIO_WHERE_PKS_IN = "SELECT attendanceBio FROM AttendanceBio attendanceBio WHERE attendanceBioId IN (";
	private static final String _SQL_SELECT_ATTENDANCEBIO_WHERE = "SELECT attendanceBio FROM AttendanceBio attendanceBio WHERE ";
	private static final String _SQL_COUNT_ATTENDANCEBIO = "SELECT COUNT(attendanceBio) FROM AttendanceBio attendanceBio";
	private static final String _SQL_COUNT_ATTENDANCEBIO_WHERE = "SELECT COUNT(attendanceBio) FROM AttendanceBio attendanceBio WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "attendanceBio.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AttendanceBio exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AttendanceBio exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AttendanceBioPersistenceImpl.class);
}