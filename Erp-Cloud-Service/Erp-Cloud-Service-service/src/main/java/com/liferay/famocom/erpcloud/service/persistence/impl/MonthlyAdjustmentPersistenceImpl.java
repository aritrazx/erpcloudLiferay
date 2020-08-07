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

import com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException;
import com.liferay.famocom.erpcloud.model.MonthlyAdjustment;
import com.liferay.famocom.erpcloud.model.impl.MonthlyAdjustmentImpl;
import com.liferay.famocom.erpcloud.model.impl.MonthlyAdjustmentModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.MonthlyAdjustmentPersistence;

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
 * The persistence implementation for the monthly adjustment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see MonthlyAdjustmentPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.MonthlyAdjustmentUtil
 * @generated
 */
@ProviderType
public class MonthlyAdjustmentPersistenceImpl extends BasePersistenceImpl<MonthlyAdjustment>
	implements MonthlyAdjustmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MonthlyAdjustmentUtil} to access the monthly adjustment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MonthlyAdjustmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			MonthlyAdjustmentModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the monthly adjustments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findByemployeeId(long employeeId) {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the monthly adjustments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @return the range of matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findByemployeeId(long employeeId, int start,
		int end) {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the monthly adjustments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return findByemployeeId(employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the monthly adjustments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<MonthlyAdjustment> orderByComparator,
		boolean retrieveFromCache) {
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

		List<MonthlyAdjustment> list = null;

		if (retrieveFromCache) {
			list = (List<MonthlyAdjustment>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MonthlyAdjustment monthlyAdjustment : list) {
					if ((employeeId != monthlyAdjustment.getEmployeeId())) {
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

			query.append(_SQL_SELECT_MONTHLYADJUSTMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MonthlyAdjustmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<MonthlyAdjustment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MonthlyAdjustment>)QueryUtil.list(q,
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
	 * Returns the first monthly adjustment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment findByemployeeId_First(long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (monthlyAdjustment != null) {
			return monthlyAdjustment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchMonthlyAdjustmentException(msg.toString());
	}

	/**
	 * Returns the first monthly adjustment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment fetchByemployeeId_First(long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		List<MonthlyAdjustment> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last monthly adjustment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment findByemployeeId_Last(long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (monthlyAdjustment != null) {
			return monthlyAdjustment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchMonthlyAdjustmentException(msg.toString());
	}

	/**
	 * Returns the last monthly adjustment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment fetchByemployeeId_Last(long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<MonthlyAdjustment> list = findByemployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the monthly adjustments before and after the current monthly adjustment in the ordered set where employeeId = &#63;.
	 *
	 * @param monthlyAdjustmentId the primary key of the current monthly adjustment
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	 */
	@Override
	public MonthlyAdjustment[] findByemployeeId_PrevAndNext(
		long monthlyAdjustmentId, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = findByPrimaryKey(monthlyAdjustmentId);

		Session session = null;

		try {
			session = openSession();

			MonthlyAdjustment[] array = new MonthlyAdjustmentImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, monthlyAdjustment,
					employeeId, orderByComparator, true);

			array[1] = monthlyAdjustment;

			array[2] = getByemployeeId_PrevAndNext(session, monthlyAdjustment,
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

	protected MonthlyAdjustment getByemployeeId_PrevAndNext(Session session,
		MonthlyAdjustment monthlyAdjustment, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MONTHLYADJUSTMENT_WHERE);

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
			query.append(MonthlyAdjustmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(monthlyAdjustment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MonthlyAdjustment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the monthly adjustments where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByemployeeId(long employeeId) {
		for (MonthlyAdjustment monthlyAdjustment : findByemployeeId(
				employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(monthlyAdjustment);
		}
	}

	/**
	 * Returns the number of monthly adjustments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching monthly adjustments
	 */
	@Override
	public int countByemployeeId(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MONTHLYADJUSTMENT_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "monthlyAdjustment.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHYEAR =
		new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymonthYear",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR =
		new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymonthYear",
			new String[] { Long.class.getName() },
			MonthlyAdjustmentModelImpl.MONTHYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHYEAR = new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymonthYear",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the monthly adjustments where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @return the matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findBymonthYear(long monthYear) {
		return findBymonthYear(monthYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the monthly adjustments where monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @return the range of matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findBymonthYear(long monthYear, int start,
		int end) {
		return findBymonthYear(monthYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the monthly adjustments where monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findBymonthYear(long monthYear, int start,
		int end, OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return findBymonthYear(monthYear, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the monthly adjustments where monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findBymonthYear(long monthYear, int start,
		int end, OrderByComparator<MonthlyAdjustment> orderByComparator,
		boolean retrieveFromCache) {
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

		List<MonthlyAdjustment> list = null;

		if (retrieveFromCache) {
			list = (List<MonthlyAdjustment>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MonthlyAdjustment monthlyAdjustment : list) {
					if ((monthYear != monthlyAdjustment.getMonthYear())) {
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

			query.append(_SQL_SELECT_MONTHLYADJUSTMENT_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MonthlyAdjustmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				if (!pagination) {
					list = (List<MonthlyAdjustment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MonthlyAdjustment>)QueryUtil.list(q,
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
	 * Returns the first monthly adjustment in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment findBymonthYear_First(long monthYear,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = fetchBymonthYear_First(monthYear,
				orderByComparator);

		if (monthlyAdjustment != null) {
			return monthlyAdjustment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchMonthlyAdjustmentException(msg.toString());
	}

	/**
	 * Returns the first monthly adjustment in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment fetchBymonthYear_First(long monthYear,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		List<MonthlyAdjustment> list = findBymonthYear(monthYear, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last monthly adjustment in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment findBymonthYear_Last(long monthYear,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = fetchBymonthYear_Last(monthYear,
				orderByComparator);

		if (monthlyAdjustment != null) {
			return monthlyAdjustment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchMonthlyAdjustmentException(msg.toString());
	}

	/**
	 * Returns the last monthly adjustment in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment fetchBymonthYear_Last(long monthYear,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		int count = countBymonthYear(monthYear);

		if (count == 0) {
			return null;
		}

		List<MonthlyAdjustment> list = findBymonthYear(monthYear, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the monthly adjustments before and after the current monthly adjustment in the ordered set where monthYear = &#63;.
	 *
	 * @param monthlyAdjustmentId the primary key of the current monthly adjustment
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	 */
	@Override
	public MonthlyAdjustment[] findBymonthYear_PrevAndNext(
		long monthlyAdjustmentId, long monthYear,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = findByPrimaryKey(monthlyAdjustmentId);

		Session session = null;

		try {
			session = openSession();

			MonthlyAdjustment[] array = new MonthlyAdjustmentImpl[3];

			array[0] = getBymonthYear_PrevAndNext(session, monthlyAdjustment,
					monthYear, orderByComparator, true);

			array[1] = monthlyAdjustment;

			array[2] = getBymonthYear_PrevAndNext(session, monthlyAdjustment,
					monthYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MonthlyAdjustment getBymonthYear_PrevAndNext(Session session,
		MonthlyAdjustment monthlyAdjustment, long monthYear,
		OrderByComparator<MonthlyAdjustment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MONTHLYADJUSTMENT_WHERE);

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
			query.append(MonthlyAdjustmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(monthYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(monthlyAdjustment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MonthlyAdjustment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the monthly adjustments where monthYear = &#63; from the database.
	 *
	 * @param monthYear the month year
	 */
	@Override
	public void removeBymonthYear(long monthYear) {
		for (MonthlyAdjustment monthlyAdjustment : findBymonthYear(monthYear,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(monthlyAdjustment);
		}
	}

	/**
	 * Returns the number of monthly adjustments where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @return the number of matching monthly adjustments
	 */
	@Override
	public int countBymonthYear(long monthYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MONTHYEAR;

		Object[] finderArgs = new Object[] { monthYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MONTHLYADJUSTMENT_WHERE);

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

	private static final String _FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2 = "monthlyAdjustment.monthYear = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID =
		new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBymonthYearAndemployeeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID =
		new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBymonthYearAndemployeeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			MonthlyAdjustmentModelImpl.MONTHYEAR_COLUMN_BITMASK |
			MonthlyAdjustmentModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID = new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBymonthYearAndemployeeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @return the matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId) {
		return findBymonthYearAndemployeeId(monthYear, employeeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @return the range of matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end) {
		return findBymonthYearAndemployeeId(monthYear, employeeId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return findBymonthYearAndemployeeId(monthYear, employeeId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID;
			finderArgs = new Object[] { monthYear, employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID;
			finderArgs = new Object[] {
					monthYear, employeeId,
					
					start, end, orderByComparator
				};
		}

		List<MonthlyAdjustment> list = null;

		if (retrieveFromCache) {
			list = (List<MonthlyAdjustment>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MonthlyAdjustment monthlyAdjustment : list) {
					if ((monthYear != monthlyAdjustment.getMonthYear()) ||
							(employeeId != monthlyAdjustment.getEmployeeId())) {
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

			query.append(_SQL_SELECT_MONTHLYADJUSTMENT_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_MONTHYEAR_2);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MonthlyAdjustmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<MonthlyAdjustment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MonthlyAdjustment>)QueryUtil.list(q,
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
	 * Returns the first monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment findBymonthYearAndemployeeId_First(
		long monthYear, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = fetchBymonthYearAndemployeeId_First(monthYear,
				employeeId, orderByComparator);

		if (monthlyAdjustment != null) {
			return monthlyAdjustment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append(", employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchMonthlyAdjustmentException(msg.toString());
	}

	/**
	 * Returns the first monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment fetchBymonthYearAndemployeeId_First(
		long monthYear, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		List<MonthlyAdjustment> list = findBymonthYearAndemployeeId(monthYear,
				employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment findBymonthYearAndemployeeId_Last(long monthYear,
		long employeeId, OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = fetchBymonthYearAndemployeeId_Last(monthYear,
				employeeId, orderByComparator);

		if (monthlyAdjustment != null) {
			return monthlyAdjustment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append(", employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchMonthlyAdjustmentException(msg.toString());
	}

	/**
	 * Returns the last monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment fetchBymonthYearAndemployeeId_Last(
		long monthYear, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		int count = countBymonthYearAndemployeeId(monthYear, employeeId);

		if (count == 0) {
			return null;
		}

		List<MonthlyAdjustment> list = findBymonthYearAndemployeeId(monthYear,
				employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the monthly adjustments before and after the current monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthlyAdjustmentId the primary key of the current monthly adjustment
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	 */
	@Override
	public MonthlyAdjustment[] findBymonthYearAndemployeeId_PrevAndNext(
		long monthlyAdjustmentId, long monthYear, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = findByPrimaryKey(monthlyAdjustmentId);

		Session session = null;

		try {
			session = openSession();

			MonthlyAdjustment[] array = new MonthlyAdjustmentImpl[3];

			array[0] = getBymonthYearAndemployeeId_PrevAndNext(session,
					monthlyAdjustment, monthYear, employeeId,
					orderByComparator, true);

			array[1] = monthlyAdjustment;

			array[2] = getBymonthYearAndemployeeId_PrevAndNext(session,
					monthlyAdjustment, monthYear, employeeId,
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

	protected MonthlyAdjustment getBymonthYearAndemployeeId_PrevAndNext(
		Session session, MonthlyAdjustment monthlyAdjustment, long monthYear,
		long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_MONTHLYADJUSTMENT_WHERE);

		query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_MONTHYEAR_2);

		query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_EMPLOYEEID_2);

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
			query.append(MonthlyAdjustmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(monthYear);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(monthlyAdjustment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MonthlyAdjustment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the monthly adjustments where monthYear = &#63; and employeeId = &#63; from the database.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeBymonthYearAndemployeeId(long monthYear, long employeeId) {
		for (MonthlyAdjustment monthlyAdjustment : findBymonthYearAndemployeeId(
				monthYear, employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(monthlyAdjustment);
		}
	}

	/**
	 * Returns the number of monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @return the number of matching monthly adjustments
	 */
	@Override
	public int countBymonthYearAndemployeeId(long monthYear, long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID;

		Object[] finderArgs = new Object[] { monthYear, employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MONTHLYADJUSTMENT_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_MONTHYEAR_2);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

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

	private static final String _FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_MONTHYEAR_2 =
		"monthlyAdjustment.monthYear = ? AND ";
	private static final String _FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_EMPLOYEEID_2 =
		"monthlyAdjustment.employeeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID =
		new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBymonthYearAndemployeeIdAndpayComponentId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			MonthlyAdjustmentModelImpl.MONTHYEAR_COLUMN_BITMASK |
			MonthlyAdjustmentModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			MonthlyAdjustmentModelImpl.PAYCOMPONENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID =
		new FinderPath(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBymonthYearAndemployeeIdAndpayComponentId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; or throws a {@link NoSuchMonthlyAdjustmentException} if it could not be found.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param payComponentId the pay component ID
	 * @return the matching monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment findBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = fetchBymonthYearAndemployeeIdAndpayComponentId(monthYear,
				employeeId, payComponentId);

		if (monthlyAdjustment == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("monthYear=");
			msg.append(monthYear);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append(", payComponentId=");
			msg.append(payComponentId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchMonthlyAdjustmentException(msg.toString());
		}

		return monthlyAdjustment;
	}

	/**
	 * Returns the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param payComponentId the pay component ID
	 * @return the matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment fetchBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId) {
		return fetchBymonthYearAndemployeeIdAndpayComponentId(monthYear,
			employeeId, payComponentId, true);
	}

	/**
	 * Returns the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param payComponentId the pay component ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	 */
	@Override
	public MonthlyAdjustment fetchBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { monthYear, employeeId, payComponentId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID,
					finderArgs, this);
		}

		if (result instanceof MonthlyAdjustment) {
			MonthlyAdjustment monthlyAdjustment = (MonthlyAdjustment)result;

			if ((monthYear != monthlyAdjustment.getMonthYear()) ||
					(employeeId != monthlyAdjustment.getEmployeeId()) ||
					(payComponentId != monthlyAdjustment.getPayComponentId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_MONTHLYADJUSTMENT_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID_MONTHYEAR_2);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID_PAYCOMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				qPos.add(employeeId);

				qPos.add(payComponentId);

				List<MonthlyAdjustment> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"MonthlyAdjustmentPersistenceImpl.fetchBymonthYearAndemployeeIdAndpayComponentId(long, long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MonthlyAdjustment monthlyAdjustment = list.get(0);

					result = monthlyAdjustment;

					cacheResult(monthlyAdjustment);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID,
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
			return (MonthlyAdjustment)result;
		}
	}

	/**
	 * Removes the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; from the database.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param payComponentId the pay component ID
	 * @return the monthly adjustment that was removed
	 */
	@Override
	public MonthlyAdjustment removeBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = findBymonthYearAndemployeeIdAndpayComponentId(monthYear,
				employeeId, payComponentId);

		return remove(monthlyAdjustment);
	}

	/**
	 * Returns the number of monthly adjustments where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param payComponentId the pay component ID
	 * @return the number of matching monthly adjustments
	 */
	@Override
	public int countBymonthYearAndemployeeIdAndpayComponentId(long monthYear,
		long employeeId, long payComponentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID;

		Object[] finderArgs = new Object[] { monthYear, employeeId, payComponentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MONTHLYADJUSTMENT_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID_MONTHYEAR_2);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID_PAYCOMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				qPos.add(employeeId);

				qPos.add(payComponentId);

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

	private static final String _FINDER_COLUMN_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID_MONTHYEAR_2 =
		"monthlyAdjustment.monthYear = ? AND ";
	private static final String _FINDER_COLUMN_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID_EMPLOYEEID_2 =
		"monthlyAdjustment.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID_PAYCOMPONENTID_2 =
		"monthlyAdjustment.payComponentId = ?";

	public MonthlyAdjustmentPersistenceImpl() {
		setModelClass(MonthlyAdjustment.class);
	}

	/**
	 * Caches the monthly adjustment in the entity cache if it is enabled.
	 *
	 * @param monthlyAdjustment the monthly adjustment
	 */
	@Override
	public void cacheResult(MonthlyAdjustment monthlyAdjustment) {
		entityCache.putResult(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class, monthlyAdjustment.getPrimaryKey(),
			monthlyAdjustment);

		finderCache.putResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID,
			new Object[] {
				monthlyAdjustment.getMonthYear(),
				monthlyAdjustment.getEmployeeId(),
				monthlyAdjustment.getPayComponentId()
			}, monthlyAdjustment);

		monthlyAdjustment.resetOriginalValues();
	}

	/**
	 * Caches the monthly adjustments in the entity cache if it is enabled.
	 *
	 * @param monthlyAdjustments the monthly adjustments
	 */
	@Override
	public void cacheResult(List<MonthlyAdjustment> monthlyAdjustments) {
		for (MonthlyAdjustment monthlyAdjustment : monthlyAdjustments) {
			if (entityCache.getResult(
						MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
						MonthlyAdjustmentImpl.class,
						monthlyAdjustment.getPrimaryKey()) == null) {
				cacheResult(monthlyAdjustment);
			}
			else {
				monthlyAdjustment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all monthly adjustments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MonthlyAdjustmentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the monthly adjustment.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MonthlyAdjustment monthlyAdjustment) {
		entityCache.removeResult(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class, monthlyAdjustment.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MonthlyAdjustmentModelImpl)monthlyAdjustment,
			true);
	}

	@Override
	public void clearCache(List<MonthlyAdjustment> monthlyAdjustments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MonthlyAdjustment monthlyAdjustment : monthlyAdjustments) {
			entityCache.removeResult(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
				MonthlyAdjustmentImpl.class, monthlyAdjustment.getPrimaryKey());

			clearUniqueFindersCache((MonthlyAdjustmentModelImpl)monthlyAdjustment,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		MonthlyAdjustmentModelImpl monthlyAdjustmentModelImpl) {
		Object[] args = new Object[] {
				monthlyAdjustmentModelImpl.getMonthYear(),
				monthlyAdjustmentModelImpl.getEmployeeId(),
				monthlyAdjustmentModelImpl.getPayComponentId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID,
			args, monthlyAdjustmentModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		MonthlyAdjustmentModelImpl monthlyAdjustmentModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					monthlyAdjustmentModelImpl.getMonthYear(),
					monthlyAdjustmentModelImpl.getEmployeeId(),
					monthlyAdjustmentModelImpl.getPayComponentId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID,
				args);
		}

		if ((monthlyAdjustmentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					monthlyAdjustmentModelImpl.getOriginalMonthYear(),
					monthlyAdjustmentModelImpl.getOriginalEmployeeId(),
					monthlyAdjustmentModelImpl.getOriginalPayComponentId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEIDANDPAYCOMPONENTID,
				args);
		}
	}

	/**
	 * Creates a new monthly adjustment with the primary key. Does not add the monthly adjustment to the database.
	 *
	 * @param monthlyAdjustmentId the primary key for the new monthly adjustment
	 * @return the new monthly adjustment
	 */
	@Override
	public MonthlyAdjustment create(long monthlyAdjustmentId) {
		MonthlyAdjustment monthlyAdjustment = new MonthlyAdjustmentImpl();

		monthlyAdjustment.setNew(true);
		monthlyAdjustment.setPrimaryKey(monthlyAdjustmentId);

		return monthlyAdjustment;
	}

	/**
	 * Removes the monthly adjustment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param monthlyAdjustmentId the primary key of the monthly adjustment
	 * @return the monthly adjustment that was removed
	 * @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	 */
	@Override
	public MonthlyAdjustment remove(long monthlyAdjustmentId)
		throws NoSuchMonthlyAdjustmentException {
		return remove((Serializable)monthlyAdjustmentId);
	}

	/**
	 * Removes the monthly adjustment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the monthly adjustment
	 * @return the monthly adjustment that was removed
	 * @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	 */
	@Override
	public MonthlyAdjustment remove(Serializable primaryKey)
		throws NoSuchMonthlyAdjustmentException {
		Session session = null;

		try {
			session = openSession();

			MonthlyAdjustment monthlyAdjustment = (MonthlyAdjustment)session.get(MonthlyAdjustmentImpl.class,
					primaryKey);

			if (monthlyAdjustment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMonthlyAdjustmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(monthlyAdjustment);
		}
		catch (NoSuchMonthlyAdjustmentException nsee) {
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
	protected MonthlyAdjustment removeImpl(MonthlyAdjustment monthlyAdjustment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(monthlyAdjustment)) {
				monthlyAdjustment = (MonthlyAdjustment)session.get(MonthlyAdjustmentImpl.class,
						monthlyAdjustment.getPrimaryKeyObj());
			}

			if (monthlyAdjustment != null) {
				session.delete(monthlyAdjustment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (monthlyAdjustment != null) {
			clearCache(monthlyAdjustment);
		}

		return monthlyAdjustment;
	}

	@Override
	public MonthlyAdjustment updateImpl(MonthlyAdjustment monthlyAdjustment) {
		boolean isNew = monthlyAdjustment.isNew();

		if (!(monthlyAdjustment instanceof MonthlyAdjustmentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(monthlyAdjustment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(monthlyAdjustment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in monthlyAdjustment proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MonthlyAdjustment implementation " +
				monthlyAdjustment.getClass());
		}

		MonthlyAdjustmentModelImpl monthlyAdjustmentModelImpl = (MonthlyAdjustmentModelImpl)monthlyAdjustment;

		Session session = null;

		try {
			session = openSession();

			if (monthlyAdjustment.isNew()) {
				session.save(monthlyAdjustment);

				monthlyAdjustment.setNew(false);
			}
			else {
				monthlyAdjustment = (MonthlyAdjustment)session.merge(monthlyAdjustment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MonthlyAdjustmentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					monthlyAdjustmentModelImpl.getEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
				args);

			args = new Object[] { monthlyAdjustmentModelImpl.getMonthYear() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR,
				args);

			args = new Object[] {
					monthlyAdjustmentModelImpl.getMonthYear(),
					monthlyAdjustmentModelImpl.getEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((monthlyAdjustmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						monthlyAdjustmentModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { monthlyAdjustmentModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}

			if ((monthlyAdjustmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						monthlyAdjustmentModelImpl.getOriginalMonthYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR,
					args);

				args = new Object[] { monthlyAdjustmentModelImpl.getMonthYear() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR,
					args);
			}

			if ((monthlyAdjustmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						monthlyAdjustmentModelImpl.getOriginalMonthYear(),
						monthlyAdjustmentModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID,
					args);

				args = new Object[] {
						monthlyAdjustmentModelImpl.getMonthYear(),
						monthlyAdjustmentModelImpl.getEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID,
					args);
			}
		}

		entityCache.putResult(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyAdjustmentImpl.class, monthlyAdjustment.getPrimaryKey(),
			monthlyAdjustment, false);

		clearUniqueFindersCache(monthlyAdjustmentModelImpl, false);
		cacheUniqueFindersCache(monthlyAdjustmentModelImpl);

		monthlyAdjustment.resetOriginalValues();

		return monthlyAdjustment;
	}

	/**
	 * Returns the monthly adjustment with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the monthly adjustment
	 * @return the monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	 */
	@Override
	public MonthlyAdjustment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMonthlyAdjustmentException {
		MonthlyAdjustment monthlyAdjustment = fetchByPrimaryKey(primaryKey);

		if (monthlyAdjustment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMonthlyAdjustmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return monthlyAdjustment;
	}

	/**
	 * Returns the monthly adjustment with the primary key or throws a {@link NoSuchMonthlyAdjustmentException} if it could not be found.
	 *
	 * @param monthlyAdjustmentId the primary key of the monthly adjustment
	 * @return the monthly adjustment
	 * @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	 */
	@Override
	public MonthlyAdjustment findByPrimaryKey(long monthlyAdjustmentId)
		throws NoSuchMonthlyAdjustmentException {
		return findByPrimaryKey((Serializable)monthlyAdjustmentId);
	}

	/**
	 * Returns the monthly adjustment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the monthly adjustment
	 * @return the monthly adjustment, or <code>null</code> if a monthly adjustment with the primary key could not be found
	 */
	@Override
	public MonthlyAdjustment fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
				MonthlyAdjustmentImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MonthlyAdjustment monthlyAdjustment = (MonthlyAdjustment)serializable;

		if (monthlyAdjustment == null) {
			Session session = null;

			try {
				session = openSession();

				monthlyAdjustment = (MonthlyAdjustment)session.get(MonthlyAdjustmentImpl.class,
						primaryKey);

				if (monthlyAdjustment != null) {
					cacheResult(monthlyAdjustment);
				}
				else {
					entityCache.putResult(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
						MonthlyAdjustmentImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
					MonthlyAdjustmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return monthlyAdjustment;
	}

	/**
	 * Returns the monthly adjustment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param monthlyAdjustmentId the primary key of the monthly adjustment
	 * @return the monthly adjustment, or <code>null</code> if a monthly adjustment with the primary key could not be found
	 */
	@Override
	public MonthlyAdjustment fetchByPrimaryKey(long monthlyAdjustmentId) {
		return fetchByPrimaryKey((Serializable)monthlyAdjustmentId);
	}

	@Override
	public Map<Serializable, MonthlyAdjustment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MonthlyAdjustment> map = new HashMap<Serializable, MonthlyAdjustment>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MonthlyAdjustment monthlyAdjustment = fetchByPrimaryKey(primaryKey);

			if (monthlyAdjustment != null) {
				map.put(primaryKey, monthlyAdjustment);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
					MonthlyAdjustmentImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MonthlyAdjustment)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MONTHLYADJUSTMENT_WHERE_PKS_IN);

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

			for (MonthlyAdjustment monthlyAdjustment : (List<MonthlyAdjustment>)q.list()) {
				map.put(monthlyAdjustment.getPrimaryKeyObj(), monthlyAdjustment);

				cacheResult(monthlyAdjustment);

				uncachedPrimaryKeys.remove(monthlyAdjustment.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MonthlyAdjustmentModelImpl.ENTITY_CACHE_ENABLED,
					MonthlyAdjustmentImpl.class, primaryKey, nullModel);
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
	 * Returns all the monthly adjustments.
	 *
	 * @return the monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the monthly adjustments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @return the range of monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the monthly adjustments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findAll(int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the monthly adjustments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly adjustments
	 * @param end the upper bound of the range of monthly adjustments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of monthly adjustments
	 */
	@Override
	public List<MonthlyAdjustment> findAll(int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator,
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

		List<MonthlyAdjustment> list = null;

		if (retrieveFromCache) {
			list = (List<MonthlyAdjustment>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MONTHLYADJUSTMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MONTHLYADJUSTMENT;

				if (pagination) {
					sql = sql.concat(MonthlyAdjustmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MonthlyAdjustment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MonthlyAdjustment>)QueryUtil.list(q,
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
	 * Removes all the monthly adjustments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MonthlyAdjustment monthlyAdjustment : findAll()) {
			remove(monthlyAdjustment);
		}
	}

	/**
	 * Returns the number of monthly adjustments.
	 *
	 * @return the number of monthly adjustments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MONTHLYADJUSTMENT);

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
		return MonthlyAdjustmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the monthly adjustment persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MonthlyAdjustmentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MONTHLYADJUSTMENT = "SELECT monthlyAdjustment FROM MonthlyAdjustment monthlyAdjustment";
	private static final String _SQL_SELECT_MONTHLYADJUSTMENT_WHERE_PKS_IN = "SELECT monthlyAdjustment FROM MonthlyAdjustment monthlyAdjustment WHERE monthlyAdjustmentId IN (";
	private static final String _SQL_SELECT_MONTHLYADJUSTMENT_WHERE = "SELECT monthlyAdjustment FROM MonthlyAdjustment monthlyAdjustment WHERE ";
	private static final String _SQL_COUNT_MONTHLYADJUSTMENT = "SELECT COUNT(monthlyAdjustment) FROM MonthlyAdjustment monthlyAdjustment";
	private static final String _SQL_COUNT_MONTHLYADJUSTMENT_WHERE = "SELECT COUNT(monthlyAdjustment) FROM MonthlyAdjustment monthlyAdjustment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "monthlyAdjustment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MonthlyAdjustment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MonthlyAdjustment exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MonthlyAdjustmentPersistenceImpl.class);
}