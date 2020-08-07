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

import com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException;
import com.liferay.famocom.erpcloud.model.SchedulesDetails;
import com.liferay.famocom.erpcloud.model.impl.SchedulesDetailsImpl;
import com.liferay.famocom.erpcloud.model.impl.SchedulesDetailsModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.SchedulesDetailsPersistence;

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
 * The persistence implementation for the schedules details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SchedulesDetailsPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.SchedulesDetailsUtil
 * @generated
 */
@ProviderType
public class SchedulesDetailsPersistenceImpl extends BasePersistenceImpl<SchedulesDetails>
	implements SchedulesDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SchedulesDetailsUtil} to access the schedules details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SchedulesDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsModelImpl.FINDER_CACHE_ENABLED,
			SchedulesDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsModelImpl.FINDER_CACHE_ENABLED,
			SchedulesDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHECKDATE =
		new FinderPath(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsModelImpl.FINDER_CACHE_ENABLED,
			SchedulesDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycheckDate",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHECKDATE =
		new FinderPath(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsModelImpl.FINDER_CACHE_ENABLED,
			SchedulesDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycheckDate",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			SchedulesDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			SchedulesDetailsModelImpl.COMPANYID_COLUMN_BITMASK |
			SchedulesDetailsModelImpl.SCHEDULESDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHECKDATE = new FinderPath(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycheckDate",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			});

	/**
	 * Returns all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param schedulesDate the schedules date
	 * @return the matching schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate) {
		return findBycheckDate(employeeId, companyId, schedulesDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param schedulesDate the schedules date
	 * @param start the lower bound of the range of schedules detailses
	 * @param end the upper bound of the range of schedules detailses (not inclusive)
	 * @return the range of matching schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate, int start, int end) {
		return findBycheckDate(employeeId, companyId, schedulesDate, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param schedulesDate the schedules date
	 * @param start the lower bound of the range of schedules detailses
	 * @param end the upper bound of the range of schedules detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate, int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		return findBycheckDate(employeeId, companyId, schedulesDate, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param schedulesDate the schedules date
	 * @param start the lower bound of the range of schedules detailses
	 * @param end the upper bound of the range of schedules detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate, int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHECKDATE;
			finderArgs = new Object[] {
					employeeId, companyId, _getTime(schedulesDate)
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHECKDATE;
			finderArgs = new Object[] {
					employeeId, companyId, _getTime(schedulesDate),
					
					start, end, orderByComparator
				};
		}

		List<SchedulesDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SchedulesDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SchedulesDetails schedulesDetails : list) {
					if ((employeeId != schedulesDetails.getEmployeeId()) ||
							(companyId != schedulesDetails.getCompanyId()) ||
							!Objects.equals(schedulesDate,
								schedulesDetails.getSchedulesDate())) {
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

			query.append(_SQL_SELECT_SCHEDULESDETAILS_WHERE);

			query.append(_FINDER_COLUMN_CHECKDATE_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_CHECKDATE_COMPANYID_2);

			boolean bindSchedulesDate = false;

			if (schedulesDate == null) {
				query.append(_FINDER_COLUMN_CHECKDATE_SCHEDULESDATE_1);
			}
			else {
				bindSchedulesDate = true;

				query.append(_FINDER_COLUMN_CHECKDATE_SCHEDULESDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SchedulesDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(companyId);

				if (bindSchedulesDate) {
					qPos.add(new Timestamp(schedulesDate.getTime()));
				}

				if (!pagination) {
					list = (List<SchedulesDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SchedulesDetails>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param schedulesDate the schedules date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedules details
	 * @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	 */
	@Override
	public SchedulesDetails findBycheckDate_First(long employeeId,
		long companyId, Date schedulesDate,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException {
		SchedulesDetails schedulesDetails = fetchBycheckDate_First(employeeId,
				companyId, schedulesDate, orderByComparator);

		if (schedulesDetails != null) {
			return schedulesDetails;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", schedulesDate=");
		msg.append(schedulesDate);

		msg.append("}");

		throw new NoSuchSchedulesDetailsException(msg.toString());
	}

	/**
	 * Returns the first schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param schedulesDate the schedules date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedules details, or <code>null</code> if a matching schedules details could not be found
	 */
	@Override
	public SchedulesDetails fetchBycheckDate_First(long employeeId,
		long companyId, Date schedulesDate,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		List<SchedulesDetails> list = findBycheckDate(employeeId, companyId,
				schedulesDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param schedulesDate the schedules date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedules details
	 * @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	 */
	@Override
	public SchedulesDetails findBycheckDate_Last(long employeeId,
		long companyId, Date schedulesDate,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException {
		SchedulesDetails schedulesDetails = fetchBycheckDate_Last(employeeId,
				companyId, schedulesDate, orderByComparator);

		if (schedulesDetails != null) {
			return schedulesDetails;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", schedulesDate=");
		msg.append(schedulesDate);

		msg.append("}");

		throw new NoSuchSchedulesDetailsException(msg.toString());
	}

	/**
	 * Returns the last schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param schedulesDate the schedules date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedules details, or <code>null</code> if a matching schedules details could not be found
	 */
	@Override
	public SchedulesDetails fetchBycheckDate_Last(long employeeId,
		long companyId, Date schedulesDate,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		int count = countBycheckDate(employeeId, companyId, schedulesDate);

		if (count == 0) {
			return null;
		}

		List<SchedulesDetails> list = findBycheckDate(employeeId, companyId,
				schedulesDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the schedules detailses before and after the current schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	 *
	 * @param schedulesDetailsId the primary key of the current schedules details
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param schedulesDate the schedules date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next schedules details
	 * @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	 */
	@Override
	public SchedulesDetails[] findBycheckDate_PrevAndNext(
		long schedulesDetailsId, long employeeId, long companyId,
		Date schedulesDate,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException {
		SchedulesDetails schedulesDetails = findByPrimaryKey(schedulesDetailsId);

		Session session = null;

		try {
			session = openSession();

			SchedulesDetails[] array = new SchedulesDetailsImpl[3];

			array[0] = getBycheckDate_PrevAndNext(session, schedulesDetails,
					employeeId, companyId, schedulesDate, orderByComparator,
					true);

			array[1] = schedulesDetails;

			array[2] = getBycheckDate_PrevAndNext(session, schedulesDetails,
					employeeId, companyId, schedulesDate, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SchedulesDetails getBycheckDate_PrevAndNext(Session session,
		SchedulesDetails schedulesDetails, long employeeId, long companyId,
		Date schedulesDate,
		OrderByComparator<SchedulesDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_SCHEDULESDETAILS_WHERE);

		query.append(_FINDER_COLUMN_CHECKDATE_EMPLOYEEID_2);

		query.append(_FINDER_COLUMN_CHECKDATE_COMPANYID_2);

		boolean bindSchedulesDate = false;

		if (schedulesDate == null) {
			query.append(_FINDER_COLUMN_CHECKDATE_SCHEDULESDATE_1);
		}
		else {
			bindSchedulesDate = true;

			query.append(_FINDER_COLUMN_CHECKDATE_SCHEDULESDATE_2);
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
			query.append(SchedulesDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		qPos.add(companyId);

		if (bindSchedulesDate) {
			qPos.add(new Timestamp(schedulesDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(schedulesDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SchedulesDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param schedulesDate the schedules date
	 */
	@Override
	public void removeBycheckDate(long employeeId, long companyId,
		Date schedulesDate) {
		for (SchedulesDetails schedulesDetails : findBycheckDate(employeeId,
				companyId, schedulesDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(schedulesDetails);
		}
	}

	/**
	 * Returns the number of schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param schedulesDate the schedules date
	 * @return the number of matching schedules detailses
	 */
	@Override
	public int countBycheckDate(long employeeId, long companyId,
		Date schedulesDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHECKDATE;

		Object[] finderArgs = new Object[] {
				employeeId, companyId, _getTime(schedulesDate)
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SCHEDULESDETAILS_WHERE);

			query.append(_FINDER_COLUMN_CHECKDATE_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_CHECKDATE_COMPANYID_2);

			boolean bindSchedulesDate = false;

			if (schedulesDate == null) {
				query.append(_FINDER_COLUMN_CHECKDATE_SCHEDULESDATE_1);
			}
			else {
				bindSchedulesDate = true;

				query.append(_FINDER_COLUMN_CHECKDATE_SCHEDULESDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(companyId);

				if (bindSchedulesDate) {
					qPos.add(new Timestamp(schedulesDate.getTime()));
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

	private static final String _FINDER_COLUMN_CHECKDATE_EMPLOYEEID_2 = "schedulesDetails.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_CHECKDATE_COMPANYID_2 = "schedulesDetails.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CHECKDATE_SCHEDULESDATE_1 = "schedulesDetails.schedulesDate IS NULL";
	private static final String _FINDER_COLUMN_CHECKDATE_SCHEDULESDATE_2 = "schedulesDetails.schedulesDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DETAILSEDIT =
		new FinderPath(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsModelImpl.FINDER_CACHE_ENABLED,
			SchedulesDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydetailsEdit",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DETAILSEDIT =
		new FinderPath(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsModelImpl.FINDER_CACHE_ENABLED,
			SchedulesDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydetailsEdit",
			new String[] { Long.class.getName() },
			SchedulesDetailsModelImpl.WORKSSCHEDULESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DETAILSEDIT = new FinderPath(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydetailsEdit",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the schedules detailses where worksSchedulesId = &#63;.
	 *
	 * @param worksSchedulesId the works schedules ID
	 * @return the matching schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findBydetailsEdit(long worksSchedulesId) {
		return findBydetailsEdit(worksSchedulesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedules detailses where worksSchedulesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param worksSchedulesId the works schedules ID
	 * @param start the lower bound of the range of schedules detailses
	 * @param end the upper bound of the range of schedules detailses (not inclusive)
	 * @return the range of matching schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findBydetailsEdit(long worksSchedulesId,
		int start, int end) {
		return findBydetailsEdit(worksSchedulesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the schedules detailses where worksSchedulesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param worksSchedulesId the works schedules ID
	 * @param start the lower bound of the range of schedules detailses
	 * @param end the upper bound of the range of schedules detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findBydetailsEdit(long worksSchedulesId,
		int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		return findBydetailsEdit(worksSchedulesId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the schedules detailses where worksSchedulesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param worksSchedulesId the works schedules ID
	 * @param start the lower bound of the range of schedules detailses
	 * @param end the upper bound of the range of schedules detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findBydetailsEdit(long worksSchedulesId,
		int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DETAILSEDIT;
			finderArgs = new Object[] { worksSchedulesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DETAILSEDIT;
			finderArgs = new Object[] {
					worksSchedulesId,
					
					start, end, orderByComparator
				};
		}

		List<SchedulesDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SchedulesDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SchedulesDetails schedulesDetails : list) {
					if ((worksSchedulesId != schedulesDetails.getWorksSchedulesId())) {
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

			query.append(_SQL_SELECT_SCHEDULESDETAILS_WHERE);

			query.append(_FINDER_COLUMN_DETAILSEDIT_WORKSSCHEDULESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SchedulesDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(worksSchedulesId);

				if (!pagination) {
					list = (List<SchedulesDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SchedulesDetails>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first schedules details in the ordered set where worksSchedulesId = &#63;.
	 *
	 * @param worksSchedulesId the works schedules ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedules details
	 * @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	 */
	@Override
	public SchedulesDetails findBydetailsEdit_First(long worksSchedulesId,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException {
		SchedulesDetails schedulesDetails = fetchBydetailsEdit_First(worksSchedulesId,
				orderByComparator);

		if (schedulesDetails != null) {
			return schedulesDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("worksSchedulesId=");
		msg.append(worksSchedulesId);

		msg.append("}");

		throw new NoSuchSchedulesDetailsException(msg.toString());
	}

	/**
	 * Returns the first schedules details in the ordered set where worksSchedulesId = &#63;.
	 *
	 * @param worksSchedulesId the works schedules ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedules details, or <code>null</code> if a matching schedules details could not be found
	 */
	@Override
	public SchedulesDetails fetchBydetailsEdit_First(long worksSchedulesId,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		List<SchedulesDetails> list = findBydetailsEdit(worksSchedulesId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last schedules details in the ordered set where worksSchedulesId = &#63;.
	 *
	 * @param worksSchedulesId the works schedules ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedules details
	 * @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	 */
	@Override
	public SchedulesDetails findBydetailsEdit_Last(long worksSchedulesId,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException {
		SchedulesDetails schedulesDetails = fetchBydetailsEdit_Last(worksSchedulesId,
				orderByComparator);

		if (schedulesDetails != null) {
			return schedulesDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("worksSchedulesId=");
		msg.append(worksSchedulesId);

		msg.append("}");

		throw new NoSuchSchedulesDetailsException(msg.toString());
	}

	/**
	 * Returns the last schedules details in the ordered set where worksSchedulesId = &#63;.
	 *
	 * @param worksSchedulesId the works schedules ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedules details, or <code>null</code> if a matching schedules details could not be found
	 */
	@Override
	public SchedulesDetails fetchBydetailsEdit_Last(long worksSchedulesId,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		int count = countBydetailsEdit(worksSchedulesId);

		if (count == 0) {
			return null;
		}

		List<SchedulesDetails> list = findBydetailsEdit(worksSchedulesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the schedules detailses before and after the current schedules details in the ordered set where worksSchedulesId = &#63;.
	 *
	 * @param schedulesDetailsId the primary key of the current schedules details
	 * @param worksSchedulesId the works schedules ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next schedules details
	 * @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	 */
	@Override
	public SchedulesDetails[] findBydetailsEdit_PrevAndNext(
		long schedulesDetailsId, long worksSchedulesId,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException {
		SchedulesDetails schedulesDetails = findByPrimaryKey(schedulesDetailsId);

		Session session = null;

		try {
			session = openSession();

			SchedulesDetails[] array = new SchedulesDetailsImpl[3];

			array[0] = getBydetailsEdit_PrevAndNext(session, schedulesDetails,
					worksSchedulesId, orderByComparator, true);

			array[1] = schedulesDetails;

			array[2] = getBydetailsEdit_PrevAndNext(session, schedulesDetails,
					worksSchedulesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SchedulesDetails getBydetailsEdit_PrevAndNext(Session session,
		SchedulesDetails schedulesDetails, long worksSchedulesId,
		OrderByComparator<SchedulesDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCHEDULESDETAILS_WHERE);

		query.append(_FINDER_COLUMN_DETAILSEDIT_WORKSSCHEDULESID_2);

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
			query.append(SchedulesDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(worksSchedulesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(schedulesDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SchedulesDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the schedules detailses where worksSchedulesId = &#63; from the database.
	 *
	 * @param worksSchedulesId the works schedules ID
	 */
	@Override
	public void removeBydetailsEdit(long worksSchedulesId) {
		for (SchedulesDetails schedulesDetails : findBydetailsEdit(
				worksSchedulesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(schedulesDetails);
		}
	}

	/**
	 * Returns the number of schedules detailses where worksSchedulesId = &#63;.
	 *
	 * @param worksSchedulesId the works schedules ID
	 * @return the number of matching schedules detailses
	 */
	@Override
	public int countBydetailsEdit(long worksSchedulesId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DETAILSEDIT;

		Object[] finderArgs = new Object[] { worksSchedulesId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCHEDULESDETAILS_WHERE);

			query.append(_FINDER_COLUMN_DETAILSEDIT_WORKSSCHEDULESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(worksSchedulesId);

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

	private static final String _FINDER_COLUMN_DETAILSEDIT_WORKSSCHEDULESID_2 = "schedulesDetails.worksSchedulesId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPIDANDATTDATE = new FinderPath(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsModelImpl.FINDER_CACHE_ENABLED,
			SchedulesDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByempIdAndAttDate",
			new String[] { Long.class.getName(), Date.class.getName() },
			SchedulesDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			SchedulesDetailsModelImpl.SCHEDULESDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPIDANDATTDATE = new FinderPath(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempIdAndAttDate",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns the schedules details where employeeId = &#63; and schedulesDate = &#63; or throws a {@link NoSuchSchedulesDetailsException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param schedulesDate the schedules date
	 * @return the matching schedules details
	 * @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	 */
	@Override
	public SchedulesDetails findByempIdAndAttDate(long employeeId,
		Date schedulesDate) throws NoSuchSchedulesDetailsException {
		SchedulesDetails schedulesDetails = fetchByempIdAndAttDate(employeeId,
				schedulesDate);

		if (schedulesDetails == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(", schedulesDate=");
			msg.append(schedulesDate);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSchedulesDetailsException(msg.toString());
		}

		return schedulesDetails;
	}

	/**
	 * Returns the schedules details where employeeId = &#63; and schedulesDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param schedulesDate the schedules date
	 * @return the matching schedules details, or <code>null</code> if a matching schedules details could not be found
	 */
	@Override
	public SchedulesDetails fetchByempIdAndAttDate(long employeeId,
		Date schedulesDate) {
		return fetchByempIdAndAttDate(employeeId, schedulesDate, true);
	}

	/**
	 * Returns the schedules details where employeeId = &#63; and schedulesDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param schedulesDate the schedules date
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching schedules details, or <code>null</code> if a matching schedules details could not be found
	 */
	@Override
	public SchedulesDetails fetchByempIdAndAttDate(long employeeId,
		Date schedulesDate, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { employeeId, _getTime(schedulesDate) };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
					finderArgs, this);
		}

		if (result instanceof SchedulesDetails) {
			SchedulesDetails schedulesDetails = (SchedulesDetails)result;

			if ((employeeId != schedulesDetails.getEmployeeId()) ||
					!Objects.equals(schedulesDate,
						schedulesDetails.getSchedulesDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SCHEDULESDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPIDANDATTDATE_EMPLOYEEID_2);

			boolean bindSchedulesDate = false;

			if (schedulesDate == null) {
				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_SCHEDULESDATE_1);
			}
			else {
				bindSchedulesDate = true;

				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_SCHEDULESDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (bindSchedulesDate) {
					qPos.add(new Timestamp(schedulesDate.getTime()));
				}

				List<SchedulesDetails> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"SchedulesDetailsPersistenceImpl.fetchByempIdAndAttDate(long, Date, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SchedulesDetails schedulesDetails = list.get(0);

					result = schedulesDetails;

					cacheResult(schedulesDetails);
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
			return (SchedulesDetails)result;
		}
	}

	/**
	 * Removes the schedules details where employeeId = &#63; and schedulesDate = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param schedulesDate the schedules date
	 * @return the schedules details that was removed
	 */
	@Override
	public SchedulesDetails removeByempIdAndAttDate(long employeeId,
		Date schedulesDate) throws NoSuchSchedulesDetailsException {
		SchedulesDetails schedulesDetails = findByempIdAndAttDate(employeeId,
				schedulesDate);

		return remove(schedulesDetails);
	}

	/**
	 * Returns the number of schedules detailses where employeeId = &#63; and schedulesDate = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param schedulesDate the schedules date
	 * @return the number of matching schedules detailses
	 */
	@Override
	public int countByempIdAndAttDate(long employeeId, Date schedulesDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPIDANDATTDATE;

		Object[] finderArgs = new Object[] { employeeId, _getTime(schedulesDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCHEDULESDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPIDANDATTDATE_EMPLOYEEID_2);

			boolean bindSchedulesDate = false;

			if (schedulesDate == null) {
				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_SCHEDULESDATE_1);
			}
			else {
				bindSchedulesDate = true;

				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_SCHEDULESDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (bindSchedulesDate) {
					qPos.add(new Timestamp(schedulesDate.getTime()));
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

	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_EMPLOYEEID_2 = "schedulesDetails.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_SCHEDULESDATE_1 = "schedulesDetails.schedulesDate IS NULL";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_SCHEDULESDATE_2 = "schedulesDetails.schedulesDate = ?";

	public SchedulesDetailsPersistenceImpl() {
		setModelClass(SchedulesDetails.class);
	}

	/**
	 * Caches the schedules details in the entity cache if it is enabled.
	 *
	 * @param schedulesDetails the schedules details
	 */
	@Override
	public void cacheResult(SchedulesDetails schedulesDetails) {
		entityCache.putResult(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsImpl.class, schedulesDetails.getPrimaryKey(),
			schedulesDetails);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
			new Object[] {
				schedulesDetails.getEmployeeId(),
				schedulesDetails.getSchedulesDate()
			}, schedulesDetails);

		schedulesDetails.resetOriginalValues();
	}

	/**
	 * Caches the schedules detailses in the entity cache if it is enabled.
	 *
	 * @param schedulesDetailses the schedules detailses
	 */
	@Override
	public void cacheResult(List<SchedulesDetails> schedulesDetailses) {
		for (SchedulesDetails schedulesDetails : schedulesDetailses) {
			if (entityCache.getResult(
						SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
						SchedulesDetailsImpl.class,
						schedulesDetails.getPrimaryKey()) == null) {
				cacheResult(schedulesDetails);
			}
			else {
				schedulesDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all schedules detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SchedulesDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the schedules details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SchedulesDetails schedulesDetails) {
		entityCache.removeResult(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsImpl.class, schedulesDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SchedulesDetailsModelImpl)schedulesDetails,
			true);
	}

	@Override
	public void clearCache(List<SchedulesDetails> schedulesDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SchedulesDetails schedulesDetails : schedulesDetailses) {
			entityCache.removeResult(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
				SchedulesDetailsImpl.class, schedulesDetails.getPrimaryKey());

			clearUniqueFindersCache((SchedulesDetailsModelImpl)schedulesDetails,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		SchedulesDetailsModelImpl schedulesDetailsModelImpl) {
		Object[] args = new Object[] {
				schedulesDetailsModelImpl.getEmployeeId(),
				_getTime(schedulesDetailsModelImpl.getSchedulesDate())
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args,
			schedulesDetailsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		SchedulesDetailsModelImpl schedulesDetailsModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					schedulesDetailsModelImpl.getEmployeeId(),
					_getTime(schedulesDetailsModelImpl.getSchedulesDate())
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args);
		}

		if ((schedulesDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPIDANDATTDATE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					schedulesDetailsModelImpl.getOriginalEmployeeId(),
					_getTime(schedulesDetailsModelImpl.getOriginalSchedulesDate())
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args);
		}
	}

	/**
	 * Creates a new schedules details with the primary key. Does not add the schedules details to the database.
	 *
	 * @param schedulesDetailsId the primary key for the new schedules details
	 * @return the new schedules details
	 */
	@Override
	public SchedulesDetails create(long schedulesDetailsId) {
		SchedulesDetails schedulesDetails = new SchedulesDetailsImpl();

		schedulesDetails.setNew(true);
		schedulesDetails.setPrimaryKey(schedulesDetailsId);

		schedulesDetails.setCompanyId(companyProvider.getCompanyId());

		return schedulesDetails;
	}

	/**
	 * Removes the schedules details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param schedulesDetailsId the primary key of the schedules details
	 * @return the schedules details that was removed
	 * @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	 */
	@Override
	public SchedulesDetails remove(long schedulesDetailsId)
		throws NoSuchSchedulesDetailsException {
		return remove((Serializable)schedulesDetailsId);
	}

	/**
	 * Removes the schedules details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the schedules details
	 * @return the schedules details that was removed
	 * @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	 */
	@Override
	public SchedulesDetails remove(Serializable primaryKey)
		throws NoSuchSchedulesDetailsException {
		Session session = null;

		try {
			session = openSession();

			SchedulesDetails schedulesDetails = (SchedulesDetails)session.get(SchedulesDetailsImpl.class,
					primaryKey);

			if (schedulesDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSchedulesDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(schedulesDetails);
		}
		catch (NoSuchSchedulesDetailsException nsee) {
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
	protected SchedulesDetails removeImpl(SchedulesDetails schedulesDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(schedulesDetails)) {
				schedulesDetails = (SchedulesDetails)session.get(SchedulesDetailsImpl.class,
						schedulesDetails.getPrimaryKeyObj());
			}

			if (schedulesDetails != null) {
				session.delete(schedulesDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (schedulesDetails != null) {
			clearCache(schedulesDetails);
		}

		return schedulesDetails;
	}

	@Override
	public SchedulesDetails updateImpl(SchedulesDetails schedulesDetails) {
		boolean isNew = schedulesDetails.isNew();

		if (!(schedulesDetails instanceof SchedulesDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(schedulesDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(schedulesDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in schedulesDetails proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SchedulesDetails implementation " +
				schedulesDetails.getClass());
		}

		SchedulesDetailsModelImpl schedulesDetailsModelImpl = (SchedulesDetailsModelImpl)schedulesDetails;

		Session session = null;

		try {
			session = openSession();

			if (schedulesDetails.isNew()) {
				session.save(schedulesDetails);

				schedulesDetails.setNew(false);
			}
			else {
				schedulesDetails = (SchedulesDetails)session.merge(schedulesDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SchedulesDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					schedulesDetailsModelImpl.getEmployeeId(),
					schedulesDetailsModelImpl.getCompanyId(),
					schedulesDetailsModelImpl.getSchedulesDate()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CHECKDATE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHECKDATE,
				args);

			args = new Object[] { schedulesDetailsModelImpl.getWorksSchedulesId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DETAILSEDIT, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DETAILSEDIT,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((schedulesDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHECKDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						schedulesDetailsModelImpl.getOriginalEmployeeId(),
						schedulesDetailsModelImpl.getOriginalCompanyId(),
						schedulesDetailsModelImpl.getOriginalSchedulesDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CHECKDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHECKDATE,
					args);

				args = new Object[] {
						schedulesDetailsModelImpl.getEmployeeId(),
						schedulesDetailsModelImpl.getCompanyId(),
						schedulesDetailsModelImpl.getSchedulesDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CHECKDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHECKDATE,
					args);
			}

			if ((schedulesDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DETAILSEDIT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						schedulesDetailsModelImpl.getOriginalWorksSchedulesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DETAILSEDIT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DETAILSEDIT,
					args);

				args = new Object[] {
						schedulesDetailsModelImpl.getWorksSchedulesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DETAILSEDIT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DETAILSEDIT,
					args);
			}
		}

		entityCache.putResult(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesDetailsImpl.class, schedulesDetails.getPrimaryKey(),
			schedulesDetails, false);

		clearUniqueFindersCache(schedulesDetailsModelImpl, false);
		cacheUniqueFindersCache(schedulesDetailsModelImpl);

		schedulesDetails.resetOriginalValues();

		return schedulesDetails;
	}

	/**
	 * Returns the schedules details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the schedules details
	 * @return the schedules details
	 * @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	 */
	@Override
	public SchedulesDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSchedulesDetailsException {
		SchedulesDetails schedulesDetails = fetchByPrimaryKey(primaryKey);

		if (schedulesDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSchedulesDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return schedulesDetails;
	}

	/**
	 * Returns the schedules details with the primary key or throws a {@link NoSuchSchedulesDetailsException} if it could not be found.
	 *
	 * @param schedulesDetailsId the primary key of the schedules details
	 * @return the schedules details
	 * @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	 */
	@Override
	public SchedulesDetails findByPrimaryKey(long schedulesDetailsId)
		throws NoSuchSchedulesDetailsException {
		return findByPrimaryKey((Serializable)schedulesDetailsId);
	}

	/**
	 * Returns the schedules details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the schedules details
	 * @return the schedules details, or <code>null</code> if a schedules details with the primary key could not be found
	 */
	@Override
	public SchedulesDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
				SchedulesDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SchedulesDetails schedulesDetails = (SchedulesDetails)serializable;

		if (schedulesDetails == null) {
			Session session = null;

			try {
				session = openSession();

				schedulesDetails = (SchedulesDetails)session.get(SchedulesDetailsImpl.class,
						primaryKey);

				if (schedulesDetails != null) {
					cacheResult(schedulesDetails);
				}
				else {
					entityCache.putResult(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
						SchedulesDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
					SchedulesDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return schedulesDetails;
	}

	/**
	 * Returns the schedules details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param schedulesDetailsId the primary key of the schedules details
	 * @return the schedules details, or <code>null</code> if a schedules details with the primary key could not be found
	 */
	@Override
	public SchedulesDetails fetchByPrimaryKey(long schedulesDetailsId) {
		return fetchByPrimaryKey((Serializable)schedulesDetailsId);
	}

	@Override
	public Map<Serializable, SchedulesDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SchedulesDetails> map = new HashMap<Serializable, SchedulesDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SchedulesDetails schedulesDetails = fetchByPrimaryKey(primaryKey);

			if (schedulesDetails != null) {
				map.put(primaryKey, schedulesDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
					SchedulesDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SchedulesDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SCHEDULESDETAILS_WHERE_PKS_IN);

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

			for (SchedulesDetails schedulesDetails : (List<SchedulesDetails>)q.list()) {
				map.put(schedulesDetails.getPrimaryKeyObj(), schedulesDetails);

				cacheResult(schedulesDetails);

				uncachedPrimaryKeys.remove(schedulesDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SchedulesDetailsModelImpl.ENTITY_CACHE_ENABLED,
					SchedulesDetailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the schedules detailses.
	 *
	 * @return the schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedules detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedules detailses
	 * @param end the upper bound of the range of schedules detailses (not inclusive)
	 * @return the range of schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the schedules detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedules detailses
	 * @param end the upper bound of the range of schedules detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findAll(int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the schedules detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedules detailses
	 * @param end the upper bound of the range of schedules detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of schedules detailses
	 */
	@Override
	public List<SchedulesDetails> findAll(int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator,
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

		List<SchedulesDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SchedulesDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SCHEDULESDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCHEDULESDETAILS;

				if (pagination) {
					sql = sql.concat(SchedulesDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SchedulesDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SchedulesDetails>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the schedules detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SchedulesDetails schedulesDetails : findAll()) {
			remove(schedulesDetails);
		}
	}

	/**
	 * Returns the number of schedules detailses.
	 *
	 * @return the number of schedules detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SCHEDULESDETAILS);

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
		return SchedulesDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the schedules details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SchedulesDetailsImpl.class.getName());
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

	private static final String _SQL_SELECT_SCHEDULESDETAILS = "SELECT schedulesDetails FROM SchedulesDetails schedulesDetails";
	private static final String _SQL_SELECT_SCHEDULESDETAILS_WHERE_PKS_IN = "SELECT schedulesDetails FROM SchedulesDetails schedulesDetails WHERE schedulesDetailsId IN (";
	private static final String _SQL_SELECT_SCHEDULESDETAILS_WHERE = "SELECT schedulesDetails FROM SchedulesDetails schedulesDetails WHERE ";
	private static final String _SQL_COUNT_SCHEDULESDETAILS = "SELECT COUNT(schedulesDetails) FROM SchedulesDetails schedulesDetails";
	private static final String _SQL_COUNT_SCHEDULESDETAILS_WHERE = "SELECT COUNT(schedulesDetails) FROM SchedulesDetails schedulesDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "schedulesDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SchedulesDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SchedulesDetails exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SchedulesDetailsPersistenceImpl.class);
}