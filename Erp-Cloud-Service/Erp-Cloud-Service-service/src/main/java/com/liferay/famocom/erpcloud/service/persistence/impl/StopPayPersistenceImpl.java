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

import com.liferay.famocom.erpcloud.exception.NoSuchStopPayException;
import com.liferay.famocom.erpcloud.model.StopPay;
import com.liferay.famocom.erpcloud.model.impl.StopPayImpl;
import com.liferay.famocom.erpcloud.model.impl.StopPayModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.StopPayPersistence;

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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the stop pay service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see StopPayPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.StopPayUtil
 * @generated
 */
@ProviderType
public class StopPayPersistenceImpl extends BasePersistenceImpl<StopPay>
	implements StopPayPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StopPayUtil} to access the stop pay persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StopPayImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, StopPayImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, StopPayImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, StopPayImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, StopPayImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			StopPayModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the stop paies where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching stop paies
	 */
	@Override
	public List<StopPay> findByemployeeId(long employeeId) {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stop paies where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @return the range of matching stop paies
	 */
	@Override
	public List<StopPay> findByemployeeId(long employeeId, int start, int end) {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stop paies where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stop paies
	 */
	@Override
	public List<StopPay> findByemployeeId(long employeeId, int start, int end,
		OrderByComparator<StopPay> orderByComparator) {
		return findByemployeeId(employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stop paies where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stop paies
	 */
	@Override
	public List<StopPay> findByemployeeId(long employeeId, int start, int end,
		OrderByComparator<StopPay> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId, start, end, orderByComparator };
		}

		List<StopPay> list = null;

		if (retrieveFromCache) {
			list = (List<StopPay>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (StopPay stopPay : list) {
					if ((employeeId != stopPay.getEmployeeId())) {
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

			query.append(_SQL_SELECT_STOPPAY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StopPayModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<StopPay>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StopPay>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first stop pay in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop pay
	 * @throws NoSuchStopPayException if a matching stop pay could not be found
	 */
	@Override
	public StopPay findByemployeeId_First(long employeeId,
		OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException {
		StopPay stopPay = fetchByemployeeId_First(employeeId, orderByComparator);

		if (stopPay != null) {
			return stopPay;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchStopPayException(msg.toString());
	}

	/**
	 * Returns the first stop pay in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop pay, or <code>null</code> if a matching stop pay could not be found
	 */
	@Override
	public StopPay fetchByemployeeId_First(long employeeId,
		OrderByComparator<StopPay> orderByComparator) {
		List<StopPay> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stop pay in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop pay
	 * @throws NoSuchStopPayException if a matching stop pay could not be found
	 */
	@Override
	public StopPay findByemployeeId_Last(long employeeId,
		OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException {
		StopPay stopPay = fetchByemployeeId_Last(employeeId, orderByComparator);

		if (stopPay != null) {
			return stopPay;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchStopPayException(msg.toString());
	}

	/**
	 * Returns the last stop pay in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop pay, or <code>null</code> if a matching stop pay could not be found
	 */
	@Override
	public StopPay fetchByemployeeId_Last(long employeeId,
		OrderByComparator<StopPay> orderByComparator) {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<StopPay> list = findByemployeeId(employeeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stop paies before and after the current stop pay in the ordered set where employeeId = &#63;.
	 *
	 * @param stopPayId the primary key of the current stop pay
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stop pay
	 * @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	 */
	@Override
	public StopPay[] findByemployeeId_PrevAndNext(long stopPayId,
		long employeeId, OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException {
		StopPay stopPay = findByPrimaryKey(stopPayId);

		Session session = null;

		try {
			session = openSession();

			StopPay[] array = new StopPayImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, stopPay,
					employeeId, orderByComparator, true);

			array[1] = stopPay;

			array[2] = getByemployeeId_PrevAndNext(session, stopPay,
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

	protected StopPay getByemployeeId_PrevAndNext(Session session,
		StopPay stopPay, long employeeId,
		OrderByComparator<StopPay> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STOPPAY_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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
			query.append(StopPayModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(stopPay);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StopPay> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stop paies where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByemployeeId(long employeeId) {
		for (StopPay stopPay : findByemployeeId(employeeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(stopPay);
		}
	}

	/**
	 * Returns the number of stop paies where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching stop paies
	 */
	@Override
	public int countByemployeeId(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STOPPAY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "stopPay.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHYEARANDSTATUS =
		new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, StopPayImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMonthYearAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDSTATUS =
		new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, StopPayImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMonthYearAndStatus",
			new String[] { Long.class.getName(), Long.class.getName() },
			StopPayModelImpl.MONTHYEAR_COLUMN_BITMASK |
			StopPayModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHYEARANDSTATUS = new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMonthYearAndStatus",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the stop paies where monthYear = &#63; and status = &#63;.
	 *
	 * @param monthYear the month year
	 * @param status the status
	 * @return the matching stop paies
	 */
	@Override
	public List<StopPay> findByMonthYearAndStatus(long monthYear, long status) {
		return findByMonthYearAndStatus(monthYear, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stop paies where monthYear = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param status the status
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @return the range of matching stop paies
	 */
	@Override
	public List<StopPay> findByMonthYearAndStatus(long monthYear, long status,
		int start, int end) {
		return findByMonthYearAndStatus(monthYear, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stop paies where monthYear = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param status the status
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stop paies
	 */
	@Override
	public List<StopPay> findByMonthYearAndStatus(long monthYear, long status,
		int start, int end, OrderByComparator<StopPay> orderByComparator) {
		return findByMonthYearAndStatus(monthYear, status, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stop paies where monthYear = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param status the status
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stop paies
	 */
	@Override
	public List<StopPay> findByMonthYearAndStatus(long monthYear, long status,
		int start, int end, OrderByComparator<StopPay> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDSTATUS;
			finderArgs = new Object[] { monthYear, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHYEARANDSTATUS;
			finderArgs = new Object[] {
					monthYear, status,
					
					start, end, orderByComparator
				};
		}

		List<StopPay> list = null;

		if (retrieveFromCache) {
			list = (List<StopPay>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (StopPay stopPay : list) {
					if ((monthYear != stopPay.getMonthYear()) ||
							(status != stopPay.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STOPPAY_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEARANDSTATUS_MONTHYEAR_2);

			query.append(_FINDER_COLUMN_MONTHYEARANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StopPayModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				qPos.add(status);

				if (!pagination) {
					list = (List<StopPay>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StopPay>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	 *
	 * @param monthYear the month year
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop pay
	 * @throws NoSuchStopPayException if a matching stop pay could not be found
	 */
	@Override
	public StopPay findByMonthYearAndStatus_First(long monthYear, long status,
		OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException {
		StopPay stopPay = fetchByMonthYearAndStatus_First(monthYear, status,
				orderByComparator);

		if (stopPay != null) {
			return stopPay;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchStopPayException(msg.toString());
	}

	/**
	 * Returns the first stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	 *
	 * @param monthYear the month year
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop pay, or <code>null</code> if a matching stop pay could not be found
	 */
	@Override
	public StopPay fetchByMonthYearAndStatus_First(long monthYear, long status,
		OrderByComparator<StopPay> orderByComparator) {
		List<StopPay> list = findByMonthYearAndStatus(monthYear, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	 *
	 * @param monthYear the month year
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop pay
	 * @throws NoSuchStopPayException if a matching stop pay could not be found
	 */
	@Override
	public StopPay findByMonthYearAndStatus_Last(long monthYear, long status,
		OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException {
		StopPay stopPay = fetchByMonthYearAndStatus_Last(monthYear, status,
				orderByComparator);

		if (stopPay != null) {
			return stopPay;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchStopPayException(msg.toString());
	}

	/**
	 * Returns the last stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	 *
	 * @param monthYear the month year
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop pay, or <code>null</code> if a matching stop pay could not be found
	 */
	@Override
	public StopPay fetchByMonthYearAndStatus_Last(long monthYear, long status,
		OrderByComparator<StopPay> orderByComparator) {
		int count = countByMonthYearAndStatus(monthYear, status);

		if (count == 0) {
			return null;
		}

		List<StopPay> list = findByMonthYearAndStatus(monthYear, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stop paies before and after the current stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	 *
	 * @param stopPayId the primary key of the current stop pay
	 * @param monthYear the month year
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stop pay
	 * @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	 */
	@Override
	public StopPay[] findByMonthYearAndStatus_PrevAndNext(long stopPayId,
		long monthYear, long status,
		OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException {
		StopPay stopPay = findByPrimaryKey(stopPayId);

		Session session = null;

		try {
			session = openSession();

			StopPay[] array = new StopPayImpl[3];

			array[0] = getByMonthYearAndStatus_PrevAndNext(session, stopPay,
					monthYear, status, orderByComparator, true);

			array[1] = stopPay;

			array[2] = getByMonthYearAndStatus_PrevAndNext(session, stopPay,
					monthYear, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StopPay getByMonthYearAndStatus_PrevAndNext(Session session,
		StopPay stopPay, long monthYear, long status,
		OrderByComparator<StopPay> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_STOPPAY_WHERE);

		query.append(_FINDER_COLUMN_MONTHYEARANDSTATUS_MONTHYEAR_2);

		query.append(_FINDER_COLUMN_MONTHYEARANDSTATUS_STATUS_2);

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
			query.append(StopPayModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(monthYear);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(stopPay);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StopPay> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stop paies where monthYear = &#63; and status = &#63; from the database.
	 *
	 * @param monthYear the month year
	 * @param status the status
	 */
	@Override
	public void removeByMonthYearAndStatus(long monthYear, long status) {
		for (StopPay stopPay : findByMonthYearAndStatus(monthYear, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(stopPay);
		}
	}

	/**
	 * Returns the number of stop paies where monthYear = &#63; and status = &#63;.
	 *
	 * @param monthYear the month year
	 * @param status the status
	 * @return the number of matching stop paies
	 */
	@Override
	public int countByMonthYearAndStatus(long monthYear, long status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MONTHYEARANDSTATUS;

		Object[] finderArgs = new Object[] { monthYear, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STOPPAY_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEARANDSTATUS_MONTHYEAR_2);

			query.append(_FINDER_COLUMN_MONTHYEARANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_MONTHYEARANDSTATUS_MONTHYEAR_2 = "stopPay.monthYear = ? AND ";
	private static final String _FINDER_COLUMN_MONTHYEARANDSTATUS_STATUS_2 = "stopPay.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHYEAR =
		new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, StopPayImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymonthYear",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR =
		new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, StopPayImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymonthYear",
			new String[] { Long.class.getName() },
			StopPayModelImpl.MONTHYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHYEAR = new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymonthYear",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the stop paies where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @return the matching stop paies
	 */
	@Override
	public List<StopPay> findBymonthYear(long monthYear) {
		return findBymonthYear(monthYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the stop paies where monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @return the range of matching stop paies
	 */
	@Override
	public List<StopPay> findBymonthYear(long monthYear, int start, int end) {
		return findBymonthYear(monthYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stop paies where monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stop paies
	 */
	@Override
	public List<StopPay> findBymonthYear(long monthYear, int start, int end,
		OrderByComparator<StopPay> orderByComparator) {
		return findBymonthYear(monthYear, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stop paies where monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stop paies
	 */
	@Override
	public List<StopPay> findBymonthYear(long monthYear, int start, int end,
		OrderByComparator<StopPay> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR;
			finderArgs = new Object[] { monthYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHYEAR;
			finderArgs = new Object[] { monthYear, start, end, orderByComparator };
		}

		List<StopPay> list = null;

		if (retrieveFromCache) {
			list = (List<StopPay>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (StopPay stopPay : list) {
					if ((monthYear != stopPay.getMonthYear())) {
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

			query.append(_SQL_SELECT_STOPPAY_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StopPayModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				if (!pagination) {
					list = (List<StopPay>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StopPay>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first stop pay in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop pay
	 * @throws NoSuchStopPayException if a matching stop pay could not be found
	 */
	@Override
	public StopPay findBymonthYear_First(long monthYear,
		OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException {
		StopPay stopPay = fetchBymonthYear_First(monthYear, orderByComparator);

		if (stopPay != null) {
			return stopPay;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchStopPayException(msg.toString());
	}

	/**
	 * Returns the first stop pay in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop pay, or <code>null</code> if a matching stop pay could not be found
	 */
	@Override
	public StopPay fetchBymonthYear_First(long monthYear,
		OrderByComparator<StopPay> orderByComparator) {
		List<StopPay> list = findBymonthYear(monthYear, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stop pay in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop pay
	 * @throws NoSuchStopPayException if a matching stop pay could not be found
	 */
	@Override
	public StopPay findBymonthYear_Last(long monthYear,
		OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException {
		StopPay stopPay = fetchBymonthYear_Last(monthYear, orderByComparator);

		if (stopPay != null) {
			return stopPay;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchStopPayException(msg.toString());
	}

	/**
	 * Returns the last stop pay in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop pay, or <code>null</code> if a matching stop pay could not be found
	 */
	@Override
	public StopPay fetchBymonthYear_Last(long monthYear,
		OrderByComparator<StopPay> orderByComparator) {
		int count = countBymonthYear(monthYear);

		if (count == 0) {
			return null;
		}

		List<StopPay> list = findBymonthYear(monthYear, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stop paies before and after the current stop pay in the ordered set where monthYear = &#63;.
	 *
	 * @param stopPayId the primary key of the current stop pay
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stop pay
	 * @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	 */
	@Override
	public StopPay[] findBymonthYear_PrevAndNext(long stopPayId,
		long monthYear, OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException {
		StopPay stopPay = findByPrimaryKey(stopPayId);

		Session session = null;

		try {
			session = openSession();

			StopPay[] array = new StopPayImpl[3];

			array[0] = getBymonthYear_PrevAndNext(session, stopPay, monthYear,
					orderByComparator, true);

			array[1] = stopPay;

			array[2] = getBymonthYear_PrevAndNext(session, stopPay, monthYear,
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

	protected StopPay getBymonthYear_PrevAndNext(Session session,
		StopPay stopPay, long monthYear,
		OrderByComparator<StopPay> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STOPPAY_WHERE);

		query.append(_FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2);

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
			query.append(StopPayModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(monthYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(stopPay);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StopPay> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stop paies where monthYear = &#63; from the database.
	 *
	 * @param monthYear the month year
	 */
	@Override
	public void removeBymonthYear(long monthYear) {
		for (StopPay stopPay : findBymonthYear(monthYear, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(stopPay);
		}
	}

	/**
	 * Returns the number of stop paies where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @return the number of matching stop paies
	 */
	@Override
	public int countBymonthYear(long monthYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MONTHYEAR;

		Object[] finderArgs = new Object[] { monthYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STOPPAY_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

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

	private static final String _FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2 = "stopPay.monthYear = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEIDANDMONTHYEAR = new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, StopPayImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByemployeeIdAndMonthYear",
			new String[] { Long.class.getName(), Long.class.getName() },
			StopPayModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			StopPayModelImpl.MONTHYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR = new FinderPath(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeIdAndMonthYear",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the stop pay where employeeId = &#63; and monthYear = &#63; or throws a {@link NoSuchStopPayException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @return the matching stop pay
	 * @throws NoSuchStopPayException if a matching stop pay could not be found
	 */
	@Override
	public StopPay findByemployeeIdAndMonthYear(long employeeId, long monthYear)
		throws NoSuchStopPayException {
		StopPay stopPay = fetchByemployeeIdAndMonthYear(employeeId, monthYear);

		if (stopPay == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(", monthYear=");
			msg.append(monthYear);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchStopPayException(msg.toString());
		}

		return stopPay;
	}

	/**
	 * Returns the stop pay where employeeId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @return the matching stop pay, or <code>null</code> if a matching stop pay could not be found
	 */
	@Override
	public StopPay fetchByemployeeIdAndMonthYear(long employeeId, long monthYear) {
		return fetchByemployeeIdAndMonthYear(employeeId, monthYear, true);
	}

	/**
	 * Returns the stop pay where employeeId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching stop pay, or <code>null</code> if a matching stop pay could not be found
	 */
	@Override
	public StopPay fetchByemployeeIdAndMonthYear(long employeeId,
		long monthYear, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { employeeId, monthYear };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDMONTHYEAR,
					finderArgs, this);
		}

		if (result instanceof StopPay) {
			StopPay stopPay = (StopPay)result;

			if ((employeeId != stopPay.getEmployeeId()) ||
					(monthYear != stopPay.getMonthYear())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_STOPPAY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(monthYear);

				List<StopPay> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDMONTHYEAR,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"StopPayPersistenceImpl.fetchByemployeeIdAndMonthYear(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					StopPay stopPay = list.get(0);

					result = stopPay;

					cacheResult(stopPay);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDMONTHYEAR,
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
			return (StopPay)result;
		}
	}

	/**
	 * Removes the stop pay where employeeId = &#63; and monthYear = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @return the stop pay that was removed
	 */
	@Override
	public StopPay removeByemployeeIdAndMonthYear(long employeeId,
		long monthYear) throws NoSuchStopPayException {
		StopPay stopPay = findByemployeeIdAndMonthYear(employeeId, monthYear);

		return remove(stopPay);
	}

	/**
	 * Returns the number of stop paies where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @return the number of matching stop paies
	 */
	@Override
	public int countByemployeeIdAndMonthYear(long employeeId, long monthYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR;

		Object[] finderArgs = new Object[] { employeeId, monthYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STOPPAY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(monthYear);

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

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_EMPLOYEEID_2 =
		"stopPay.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_2 =
		"stopPay.monthYear = ?";

	public StopPayPersistenceImpl() {
		setModelClass(StopPay.class);
	}

	/**
	 * Caches the stop pay in the entity cache if it is enabled.
	 *
	 * @param stopPay the stop pay
	 */
	@Override
	public void cacheResult(StopPay stopPay) {
		entityCache.putResult(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayImpl.class, stopPay.getPrimaryKey(), stopPay);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDMONTHYEAR,
			new Object[] { stopPay.getEmployeeId(), stopPay.getMonthYear() },
			stopPay);

		stopPay.resetOriginalValues();
	}

	/**
	 * Caches the stop paies in the entity cache if it is enabled.
	 *
	 * @param stopPaies the stop paies
	 */
	@Override
	public void cacheResult(List<StopPay> stopPaies) {
		for (StopPay stopPay : stopPaies) {
			if (entityCache.getResult(StopPayModelImpl.ENTITY_CACHE_ENABLED,
						StopPayImpl.class, stopPay.getPrimaryKey()) == null) {
				cacheResult(stopPay);
			}
			else {
				stopPay.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stop paies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StopPayImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stop pay.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StopPay stopPay) {
		entityCache.removeResult(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayImpl.class, stopPay.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((StopPayModelImpl)stopPay, true);
	}

	@Override
	public void clearCache(List<StopPay> stopPaies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StopPay stopPay : stopPaies) {
			entityCache.removeResult(StopPayModelImpl.ENTITY_CACHE_ENABLED,
				StopPayImpl.class, stopPay.getPrimaryKey());

			clearUniqueFindersCache((StopPayModelImpl)stopPay, true);
		}
	}

	protected void cacheUniqueFindersCache(StopPayModelImpl stopPayModelImpl) {
		Object[] args = new Object[] {
				stopPayModelImpl.getEmployeeId(),
				stopPayModelImpl.getMonthYear()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDMONTHYEAR,
			args, stopPayModelImpl, false);
	}

	protected void clearUniqueFindersCache(StopPayModelImpl stopPayModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					stopPayModelImpl.getEmployeeId(),
					stopPayModelImpl.getMonthYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDMONTHYEAR,
				args);
		}

		if ((stopPayModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEIDANDMONTHYEAR.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					stopPayModelImpl.getOriginalEmployeeId(),
					stopPayModelImpl.getOriginalMonthYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDMONTHYEAR,
				args);
		}
	}

	/**
	 * Creates a new stop pay with the primary key. Does not add the stop pay to the database.
	 *
	 * @param stopPayId the primary key for the new stop pay
	 * @return the new stop pay
	 */
	@Override
	public StopPay create(long stopPayId) {
		StopPay stopPay = new StopPayImpl();

		stopPay.setNew(true);
		stopPay.setPrimaryKey(stopPayId);

		return stopPay;
	}

	/**
	 * Removes the stop pay with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stopPayId the primary key of the stop pay
	 * @return the stop pay that was removed
	 * @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	 */
	@Override
	public StopPay remove(long stopPayId) throws NoSuchStopPayException {
		return remove((Serializable)stopPayId);
	}

	/**
	 * Removes the stop pay with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stop pay
	 * @return the stop pay that was removed
	 * @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	 */
	@Override
	public StopPay remove(Serializable primaryKey)
		throws NoSuchStopPayException {
		Session session = null;

		try {
			session = openSession();

			StopPay stopPay = (StopPay)session.get(StopPayImpl.class, primaryKey);

			if (stopPay == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStopPayException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(stopPay);
		}
		catch (NoSuchStopPayException nsee) {
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
	protected StopPay removeImpl(StopPay stopPay) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stopPay)) {
				stopPay = (StopPay)session.get(StopPayImpl.class,
						stopPay.getPrimaryKeyObj());
			}

			if (stopPay != null) {
				session.delete(stopPay);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (stopPay != null) {
			clearCache(stopPay);
		}

		return stopPay;
	}

	@Override
	public StopPay updateImpl(StopPay stopPay) {
		boolean isNew = stopPay.isNew();

		if (!(stopPay instanceof StopPayModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stopPay.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(stopPay);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stopPay proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StopPay implementation " +
				stopPay.getClass());
		}

		StopPayModelImpl stopPayModelImpl = (StopPayModelImpl)stopPay;

		Session session = null;

		try {
			session = openSession();

			if (stopPay.isNew()) {
				session.save(stopPay);

				stopPay.setNew(false);
			}
			else {
				stopPay = (StopPay)session.merge(stopPay);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!StopPayModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { stopPayModelImpl.getEmployeeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
				args);

			args = new Object[] {
					stopPayModelImpl.getMonthYear(),
					stopPayModelImpl.getStatus()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDSTATUS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDSTATUS,
				args);

			args = new Object[] { stopPayModelImpl.getMonthYear() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((stopPayModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						stopPayModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { stopPayModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}

			if ((stopPayModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						stopPayModelImpl.getOriginalMonthYear(),
						stopPayModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDSTATUS,
					args);

				args = new Object[] {
						stopPayModelImpl.getMonthYear(),
						stopPayModelImpl.getStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDSTATUS,
					args);
			}

			if ((stopPayModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						stopPayModelImpl.getOriginalMonthYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR,
					args);

				args = new Object[] { stopPayModelImpl.getMonthYear() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR,
					args);
			}
		}

		entityCache.putResult(StopPayModelImpl.ENTITY_CACHE_ENABLED,
			StopPayImpl.class, stopPay.getPrimaryKey(), stopPay, false);

		clearUniqueFindersCache(stopPayModelImpl, false);
		cacheUniqueFindersCache(stopPayModelImpl);

		stopPay.resetOriginalValues();

		return stopPay;
	}

	/**
	 * Returns the stop pay with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stop pay
	 * @return the stop pay
	 * @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	 */
	@Override
	public StopPay findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStopPayException {
		StopPay stopPay = fetchByPrimaryKey(primaryKey);

		if (stopPay == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStopPayException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return stopPay;
	}

	/**
	 * Returns the stop pay with the primary key or throws a {@link NoSuchStopPayException} if it could not be found.
	 *
	 * @param stopPayId the primary key of the stop pay
	 * @return the stop pay
	 * @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	 */
	@Override
	public StopPay findByPrimaryKey(long stopPayId)
		throws NoSuchStopPayException {
		return findByPrimaryKey((Serializable)stopPayId);
	}

	/**
	 * Returns the stop pay with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stop pay
	 * @return the stop pay, or <code>null</code> if a stop pay with the primary key could not be found
	 */
	@Override
	public StopPay fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StopPayModelImpl.ENTITY_CACHE_ENABLED,
				StopPayImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StopPay stopPay = (StopPay)serializable;

		if (stopPay == null) {
			Session session = null;

			try {
				session = openSession();

				stopPay = (StopPay)session.get(StopPayImpl.class, primaryKey);

				if (stopPay != null) {
					cacheResult(stopPay);
				}
				else {
					entityCache.putResult(StopPayModelImpl.ENTITY_CACHE_ENABLED,
						StopPayImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StopPayModelImpl.ENTITY_CACHE_ENABLED,
					StopPayImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return stopPay;
	}

	/**
	 * Returns the stop pay with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stopPayId the primary key of the stop pay
	 * @return the stop pay, or <code>null</code> if a stop pay with the primary key could not be found
	 */
	@Override
	public StopPay fetchByPrimaryKey(long stopPayId) {
		return fetchByPrimaryKey((Serializable)stopPayId);
	}

	@Override
	public Map<Serializable, StopPay> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StopPay> map = new HashMap<Serializable, StopPay>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StopPay stopPay = fetchByPrimaryKey(primaryKey);

			if (stopPay != null) {
				map.put(primaryKey, stopPay);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StopPayModelImpl.ENTITY_CACHE_ENABLED,
					StopPayImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StopPay)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STOPPAY_WHERE_PKS_IN);

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

			for (StopPay stopPay : (List<StopPay>)q.list()) {
				map.put(stopPay.getPrimaryKeyObj(), stopPay);

				cacheResult(stopPay);

				uncachedPrimaryKeys.remove(stopPay.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StopPayModelImpl.ENTITY_CACHE_ENABLED,
					StopPayImpl.class, primaryKey, nullModel);
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
	 * Returns all the stop paies.
	 *
	 * @return the stop paies
	 */
	@Override
	public List<StopPay> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stop paies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @return the range of stop paies
	 */
	@Override
	public List<StopPay> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stop paies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stop paies
	 */
	@Override
	public List<StopPay> findAll(int start, int end,
		OrderByComparator<StopPay> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stop paies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stop paies
	 * @param end the upper bound of the range of stop paies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of stop paies
	 */
	@Override
	public List<StopPay> findAll(int start, int end,
		OrderByComparator<StopPay> orderByComparator, boolean retrieveFromCache) {
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

		List<StopPay> list = null;

		if (retrieveFromCache) {
			list = (List<StopPay>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STOPPAY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STOPPAY;

				if (pagination) {
					sql = sql.concat(StopPayModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StopPay>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StopPay>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the stop paies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StopPay stopPay : findAll()) {
			remove(stopPay);
		}
	}

	/**
	 * Returns the number of stop paies.
	 *
	 * @return the number of stop paies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STOPPAY);

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
		return StopPayModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stop pay persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StopPayImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STOPPAY = "SELECT stopPay FROM StopPay stopPay";
	private static final String _SQL_SELECT_STOPPAY_WHERE_PKS_IN = "SELECT stopPay FROM StopPay stopPay WHERE stopPayId IN (";
	private static final String _SQL_SELECT_STOPPAY_WHERE = "SELECT stopPay FROM StopPay stopPay WHERE ";
	private static final String _SQL_COUNT_STOPPAY = "SELECT COUNT(stopPay) FROM StopPay stopPay";
	private static final String _SQL_COUNT_STOPPAY_WHERE = "SELECT COUNT(stopPay) FROM StopPay stopPay WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "stopPay.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StopPay exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StopPay exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StopPayPersistenceImpl.class);
}