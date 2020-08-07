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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException;
import com.liferay.famocom.erpcloud.model.LeaveApplyDtl;
import com.liferay.famocom.erpcloud.model.impl.LeaveApplyDtlImpl;
import com.liferay.famocom.erpcloud.model.impl.LeaveApplyDtlModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.LeaveApplyDtlPersistence;

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
 * The persistence implementation for the leave apply dtl service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveApplyDtlPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.LeaveApplyDtlUtil
 * @generated
 */
@ProviderType
public class LeaveApplyDtlPersistenceImpl extends BasePersistenceImpl<LeaveApplyDtl>
	implements LeaveApplyDtlPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveApplyDtlUtil} to access the leave apply dtl persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveApplyDtlImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlModelImpl.FINDER_CACHE_ENABLED,
			LeaveApplyDtlImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlModelImpl.FINDER_CACHE_ENABLED,
			LeaveApplyDtlImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlModelImpl.FINDER_CACHE_ENABLED,
			LeaveApplyDtlImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlModelImpl.FINDER_CACHE_ENABLED,
			LeaveApplyDtlImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemployeeId", new String[] { Long.class.getName() },
			LeaveApplyDtlModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave apply dtls where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findByemployeeId(long employeeId) {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave apply dtls where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave apply dtls
	 * @param end the upper bound of the range of leave apply dtls (not inclusive)
	 * @return the range of matching leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findByemployeeId(long employeeId, int start,
		int end) {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave apply dtls where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave apply dtls
	 * @param end the upper bound of the range of leave apply dtls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<LeaveApplyDtl> orderByComparator) {
		return findByemployeeId(employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave apply dtls where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave apply dtls
	 * @param end the upper bound of the range of leave apply dtls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<LeaveApplyDtl> orderByComparator,
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

		List<LeaveApplyDtl> list = null;

		if (retrieveFromCache) {
			list = (List<LeaveApplyDtl>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveApplyDtl leaveApplyDtl : list) {
					if ((employeeId != leaveApplyDtl.getEmployeeId())) {
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

			query.append(_SQL_SELECT_LEAVEAPPLYDTL_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveApplyDtlModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<LeaveApplyDtl>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LeaveApplyDtl>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first leave apply dtl in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave apply dtl
	 * @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	 */
	@Override
	public LeaveApplyDtl findByemployeeId_First(long employeeId,
		OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException {
		LeaveApplyDtl leaveApplyDtl = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (leaveApplyDtl != null) {
			return leaveApplyDtl;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchLeaveApplyDtlException(msg.toString());
	}

	/**
	 * Returns the first leave apply dtl in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	 */
	@Override
	public LeaveApplyDtl fetchByemployeeId_First(long employeeId,
		OrderByComparator<LeaveApplyDtl> orderByComparator) {
		List<LeaveApplyDtl> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave apply dtl in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave apply dtl
	 * @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	 */
	@Override
	public LeaveApplyDtl findByemployeeId_Last(long employeeId,
		OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException {
		LeaveApplyDtl leaveApplyDtl = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (leaveApplyDtl != null) {
			return leaveApplyDtl;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchLeaveApplyDtlException(msg.toString());
	}

	/**
	 * Returns the last leave apply dtl in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	 */
	@Override
	public LeaveApplyDtl fetchByemployeeId_Last(long employeeId,
		OrderByComparator<LeaveApplyDtl> orderByComparator) {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<LeaveApplyDtl> list = findByemployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave apply dtls before and after the current leave apply dtl in the ordered set where employeeId = &#63;.
	 *
	 * @param leaveApplyDtlId the primary key of the current leave apply dtl
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave apply dtl
	 * @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	 */
	@Override
	public LeaveApplyDtl[] findByemployeeId_PrevAndNext(long leaveApplyDtlId,
		long employeeId, OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException {
		LeaveApplyDtl leaveApplyDtl = findByPrimaryKey(leaveApplyDtlId);

		Session session = null;

		try {
			session = openSession();

			LeaveApplyDtl[] array = new LeaveApplyDtlImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, leaveApplyDtl,
					employeeId, orderByComparator, true);

			array[1] = leaveApplyDtl;

			array[2] = getByemployeeId_PrevAndNext(session, leaveApplyDtl,
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

	protected LeaveApplyDtl getByemployeeId_PrevAndNext(Session session,
		LeaveApplyDtl leaveApplyDtl, long employeeId,
		OrderByComparator<LeaveApplyDtl> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVEAPPLYDTL_WHERE);

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
			query.append(LeaveApplyDtlModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveApplyDtl);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveApplyDtl> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave apply dtls where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByemployeeId(long employeeId) {
		for (LeaveApplyDtl leaveApplyDtl : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveApplyDtl);
		}
	}

	/**
	 * Returns the number of leave apply dtls where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching leave apply dtls
	 */
	@Override
	public int countByemployeeId(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEAVEAPPLYDTL_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "leaveApplyDtl.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVEAPPLYID =
		new FinderPath(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlModelImpl.FINDER_CACHE_ENABLED,
			LeaveApplyDtlImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByleaveApplyId",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEAPPLYID =
		new FinderPath(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlModelImpl.FINDER_CACHE_ENABLED,
			LeaveApplyDtlImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByleaveApplyId", new String[] { Date.class.getName() },
			LeaveApplyDtlModelImpl.LEAVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVEAPPLYID = new FinderPath(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByleaveApplyId",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the leave apply dtls where leaveDate = &#63;.
	 *
	 * @param leaveDate the leave date
	 * @return the matching leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate) {
		return findByleaveApplyId(leaveDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave apply dtls where leaveDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveDate the leave date
	 * @param start the lower bound of the range of leave apply dtls
	 * @param end the upper bound of the range of leave apply dtls (not inclusive)
	 * @return the range of matching leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate, int start,
		int end) {
		return findByleaveApplyId(leaveDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave apply dtls where leaveDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveDate the leave date
	 * @param start the lower bound of the range of leave apply dtls
	 * @param end the upper bound of the range of leave apply dtls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate, int start,
		int end, OrderByComparator<LeaveApplyDtl> orderByComparator) {
		return findByleaveApplyId(leaveDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave apply dtls where leaveDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveDate the leave date
	 * @param start the lower bound of the range of leave apply dtls
	 * @param end the upper bound of the range of leave apply dtls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate, int start,
		int end, OrderByComparator<LeaveApplyDtl> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEAPPLYID;
			finderArgs = new Object[] { _getTime(leaveDate) };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVEAPPLYID;
			finderArgs = new Object[] {
					_getTime(leaveDate),
					
					start, end, orderByComparator
				};
		}

		List<LeaveApplyDtl> list = null;

		if (retrieveFromCache) {
			list = (List<LeaveApplyDtl>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveApplyDtl leaveApplyDtl : list) {
					if (!Objects.equals(leaveDate, leaveApplyDtl.getLeaveDate())) {
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

			query.append(_SQL_SELECT_LEAVEAPPLYDTL_WHERE);

			boolean bindLeaveDate = false;

			if (leaveDate == null) {
				query.append(_FINDER_COLUMN_LEAVEAPPLYID_LEAVEDATE_1);
			}
			else {
				bindLeaveDate = true;

				query.append(_FINDER_COLUMN_LEAVEAPPLYID_LEAVEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveApplyDtlModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveDate) {
					qPos.add(new Timestamp(leaveDate.getTime()));
				}

				if (!pagination) {
					list = (List<LeaveApplyDtl>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LeaveApplyDtl>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first leave apply dtl in the ordered set where leaveDate = &#63;.
	 *
	 * @param leaveDate the leave date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave apply dtl
	 * @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	 */
	@Override
	public LeaveApplyDtl findByleaveApplyId_First(Date leaveDate,
		OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException {
		LeaveApplyDtl leaveApplyDtl = fetchByleaveApplyId_First(leaveDate,
				orderByComparator);

		if (leaveApplyDtl != null) {
			return leaveApplyDtl;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveDate=");
		msg.append(leaveDate);

		msg.append("}");

		throw new NoSuchLeaveApplyDtlException(msg.toString());
	}

	/**
	 * Returns the first leave apply dtl in the ordered set where leaveDate = &#63;.
	 *
	 * @param leaveDate the leave date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	 */
	@Override
	public LeaveApplyDtl fetchByleaveApplyId_First(Date leaveDate,
		OrderByComparator<LeaveApplyDtl> orderByComparator) {
		List<LeaveApplyDtl> list = findByleaveApplyId(leaveDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave apply dtl in the ordered set where leaveDate = &#63;.
	 *
	 * @param leaveDate the leave date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave apply dtl
	 * @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	 */
	@Override
	public LeaveApplyDtl findByleaveApplyId_Last(Date leaveDate,
		OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException {
		LeaveApplyDtl leaveApplyDtl = fetchByleaveApplyId_Last(leaveDate,
				orderByComparator);

		if (leaveApplyDtl != null) {
			return leaveApplyDtl;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveDate=");
		msg.append(leaveDate);

		msg.append("}");

		throw new NoSuchLeaveApplyDtlException(msg.toString());
	}

	/**
	 * Returns the last leave apply dtl in the ordered set where leaveDate = &#63;.
	 *
	 * @param leaveDate the leave date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	 */
	@Override
	public LeaveApplyDtl fetchByleaveApplyId_Last(Date leaveDate,
		OrderByComparator<LeaveApplyDtl> orderByComparator) {
		int count = countByleaveApplyId(leaveDate);

		if (count == 0) {
			return null;
		}

		List<LeaveApplyDtl> list = findByleaveApplyId(leaveDate, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave apply dtls before and after the current leave apply dtl in the ordered set where leaveDate = &#63;.
	 *
	 * @param leaveApplyDtlId the primary key of the current leave apply dtl
	 * @param leaveDate the leave date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave apply dtl
	 * @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	 */
	@Override
	public LeaveApplyDtl[] findByleaveApplyId_PrevAndNext(
		long leaveApplyDtlId, Date leaveDate,
		OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException {
		LeaveApplyDtl leaveApplyDtl = findByPrimaryKey(leaveApplyDtlId);

		Session session = null;

		try {
			session = openSession();

			LeaveApplyDtl[] array = new LeaveApplyDtlImpl[3];

			array[0] = getByleaveApplyId_PrevAndNext(session, leaveApplyDtl,
					leaveDate, orderByComparator, true);

			array[1] = leaveApplyDtl;

			array[2] = getByleaveApplyId_PrevAndNext(session, leaveApplyDtl,
					leaveDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveApplyDtl getByleaveApplyId_PrevAndNext(Session session,
		LeaveApplyDtl leaveApplyDtl, Date leaveDate,
		OrderByComparator<LeaveApplyDtl> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVEAPPLYDTL_WHERE);

		boolean bindLeaveDate = false;

		if (leaveDate == null) {
			query.append(_FINDER_COLUMN_LEAVEAPPLYID_LEAVEDATE_1);
		}
		else {
			bindLeaveDate = true;

			query.append(_FINDER_COLUMN_LEAVEAPPLYID_LEAVEDATE_2);
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
			query.append(LeaveApplyDtlModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLeaveDate) {
			qPos.add(new Timestamp(leaveDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveApplyDtl);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveApplyDtl> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave apply dtls where leaveDate = &#63; from the database.
	 *
	 * @param leaveDate the leave date
	 */
	@Override
	public void removeByleaveApplyId(Date leaveDate) {
		for (LeaveApplyDtl leaveApplyDtl : findByleaveApplyId(leaveDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveApplyDtl);
		}
	}

	/**
	 * Returns the number of leave apply dtls where leaveDate = &#63;.
	 *
	 * @param leaveDate the leave date
	 * @return the number of matching leave apply dtls
	 */
	@Override
	public int countByleaveApplyId(Date leaveDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEAVEAPPLYID;

		Object[] finderArgs = new Object[] { _getTime(leaveDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEAVEAPPLYDTL_WHERE);

			boolean bindLeaveDate = false;

			if (leaveDate == null) {
				query.append(_FINDER_COLUMN_LEAVEAPPLYID_LEAVEDATE_1);
			}
			else {
				bindLeaveDate = true;

				query.append(_FINDER_COLUMN_LEAVEAPPLYID_LEAVEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveDate) {
					qPos.add(new Timestamp(leaveDate.getTime()));
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

	private static final String _FINDER_COLUMN_LEAVEAPPLYID_LEAVEDATE_1 = "leaveApplyDtl.leaveDate IS NULL";
	private static final String _FINDER_COLUMN_LEAVEAPPLYID_LEAVEDATE_2 = "leaveApplyDtl.leaveDate = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPIDANDATTDATE = new FinderPath(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlModelImpl.FINDER_CACHE_ENABLED,
			LeaveApplyDtlImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByempIdAndAttDate",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName()
			},
			LeaveApplyDtlModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			LeaveApplyDtlModelImpl.LEAVEDATE_COLUMN_BITMASK |
			LeaveApplyDtlModelImpl.ISAPPROVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPIDANDATTDATE = new FinderPath(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempIdAndAttDate",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; or throws a {@link NoSuchLeaveApplyDtlException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param leaveDate the leave date
	 * @param isApprove the is approve
	 * @return the matching leave apply dtl
	 * @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	 */
	@Override
	public LeaveApplyDtl findByempIdAndAttDate(long employeeId, Date leaveDate,
		int isApprove) throws NoSuchLeaveApplyDtlException {
		LeaveApplyDtl leaveApplyDtl = fetchByempIdAndAttDate(employeeId,
				leaveDate, isApprove);

		if (leaveApplyDtl == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(", leaveDate=");
			msg.append(leaveDate);

			msg.append(", isApprove=");
			msg.append(isApprove);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLeaveApplyDtlException(msg.toString());
		}

		return leaveApplyDtl;
	}

	/**
	 * Returns the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveDate the leave date
	 * @param isApprove the is approve
	 * @return the matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	 */
	@Override
	public LeaveApplyDtl fetchByempIdAndAttDate(long employeeId,
		Date leaveDate, int isApprove) {
		return fetchByempIdAndAttDate(employeeId, leaveDate, isApprove, true);
	}

	/**
	 * Returns the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveDate the leave date
	 * @param isApprove the is approve
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	 */
	@Override
	public LeaveApplyDtl fetchByempIdAndAttDate(long employeeId,
		Date leaveDate, int isApprove, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				employeeId, _getTime(leaveDate), isApprove
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
					finderArgs, this);
		}

		if (result instanceof LeaveApplyDtl) {
			LeaveApplyDtl leaveApplyDtl = (LeaveApplyDtl)result;

			if ((employeeId != leaveApplyDtl.getEmployeeId()) ||
					!Objects.equals(leaveDate, leaveApplyDtl.getLeaveDate()) ||
					(isApprove != leaveApplyDtl.getIsApprove())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_LEAVEAPPLYDTL_WHERE);

			query.append(_FINDER_COLUMN_EMPIDANDATTDATE_EMPLOYEEID_2);

			boolean bindLeaveDate = false;

			if (leaveDate == null) {
				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_LEAVEDATE_1);
			}
			else {
				bindLeaveDate = true;

				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_LEAVEDATE_2);
			}

			query.append(_FINDER_COLUMN_EMPIDANDATTDATE_ISAPPROVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (bindLeaveDate) {
					qPos.add(new Timestamp(leaveDate.getTime()));
				}

				qPos.add(isApprove);

				List<LeaveApplyDtl> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LeaveApplyDtlPersistenceImpl.fetchByempIdAndAttDate(long, Date, int, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveApplyDtl leaveApplyDtl = list.get(0);

					result = leaveApplyDtl;

					cacheResult(leaveApplyDtl);
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
			return (LeaveApplyDtl)result;
		}
	}

	/**
	 * Removes the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param leaveDate the leave date
	 * @param isApprove the is approve
	 * @return the leave apply dtl that was removed
	 */
	@Override
	public LeaveApplyDtl removeByempIdAndAttDate(long employeeId,
		Date leaveDate, int isApprove) throws NoSuchLeaveApplyDtlException {
		LeaveApplyDtl leaveApplyDtl = findByempIdAndAttDate(employeeId,
				leaveDate, isApprove);

		return remove(leaveApplyDtl);
	}

	/**
	 * Returns the number of leave apply dtls where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param leaveDate the leave date
	 * @param isApprove the is approve
	 * @return the number of matching leave apply dtls
	 */
	@Override
	public int countByempIdAndAttDate(long employeeId, Date leaveDate,
		int isApprove) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPIDANDATTDATE;

		Object[] finderArgs = new Object[] {
				employeeId, _getTime(leaveDate), isApprove
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEAVEAPPLYDTL_WHERE);

			query.append(_FINDER_COLUMN_EMPIDANDATTDATE_EMPLOYEEID_2);

			boolean bindLeaveDate = false;

			if (leaveDate == null) {
				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_LEAVEDATE_1);
			}
			else {
				bindLeaveDate = true;

				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_LEAVEDATE_2);
			}

			query.append(_FINDER_COLUMN_EMPIDANDATTDATE_ISAPPROVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (bindLeaveDate) {
					qPos.add(new Timestamp(leaveDate.getTime()));
				}

				qPos.add(isApprove);

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

	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_EMPLOYEEID_2 = "leaveApplyDtl.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_LEAVEDATE_1 = "leaveApplyDtl.leaveDate IS NULL AND ";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_LEAVEDATE_2 = "leaveApplyDtl.leaveDate = ? AND ";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_ISAPPROVE_2 = "leaveApplyDtl.isApprove = ?";

	public LeaveApplyDtlPersistenceImpl() {
		setModelClass(LeaveApplyDtl.class);
	}

	/**
	 * Caches the leave apply dtl in the entity cache if it is enabled.
	 *
	 * @param leaveApplyDtl the leave apply dtl
	 */
	@Override
	public void cacheResult(LeaveApplyDtl leaveApplyDtl) {
		entityCache.putResult(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlImpl.class, leaveApplyDtl.getPrimaryKey(),
			leaveApplyDtl);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
			new Object[] {
				leaveApplyDtl.getEmployeeId(), leaveApplyDtl.getLeaveDate(),
				leaveApplyDtl.getIsApprove()
			}, leaveApplyDtl);

		leaveApplyDtl.resetOriginalValues();
	}

	/**
	 * Caches the leave apply dtls in the entity cache if it is enabled.
	 *
	 * @param leaveApplyDtls the leave apply dtls
	 */
	@Override
	public void cacheResult(List<LeaveApplyDtl> leaveApplyDtls) {
		for (LeaveApplyDtl leaveApplyDtl : leaveApplyDtls) {
			if (entityCache.getResult(
						LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
						LeaveApplyDtlImpl.class, leaveApplyDtl.getPrimaryKey()) == null) {
				cacheResult(leaveApplyDtl);
			}
			else {
				leaveApplyDtl.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave apply dtls.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveApplyDtlImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave apply dtl.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveApplyDtl leaveApplyDtl) {
		entityCache.removeResult(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlImpl.class, leaveApplyDtl.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LeaveApplyDtlModelImpl)leaveApplyDtl, true);
	}

	@Override
	public void clearCache(List<LeaveApplyDtl> leaveApplyDtls) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveApplyDtl leaveApplyDtl : leaveApplyDtls) {
			entityCache.removeResult(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
				LeaveApplyDtlImpl.class, leaveApplyDtl.getPrimaryKey());

			clearUniqueFindersCache((LeaveApplyDtlModelImpl)leaveApplyDtl, true);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveApplyDtlModelImpl leaveApplyDtlModelImpl) {
		Object[] args = new Object[] {
				leaveApplyDtlModelImpl.getEmployeeId(),
				_getTime(leaveApplyDtlModelImpl.getLeaveDate()),
				leaveApplyDtlModelImpl.getIsApprove()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args,
			leaveApplyDtlModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LeaveApplyDtlModelImpl leaveApplyDtlModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					leaveApplyDtlModelImpl.getEmployeeId(),
					_getTime(leaveApplyDtlModelImpl.getLeaveDate()),
					leaveApplyDtlModelImpl.getIsApprove()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args);
		}

		if ((leaveApplyDtlModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPIDANDATTDATE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					leaveApplyDtlModelImpl.getOriginalEmployeeId(),
					_getTime(leaveApplyDtlModelImpl.getOriginalLeaveDate()),
					leaveApplyDtlModelImpl.getOriginalIsApprove()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args);
		}
	}

	/**
	 * Creates a new leave apply dtl with the primary key. Does not add the leave apply dtl to the database.
	 *
	 * @param leaveApplyDtlId the primary key for the new leave apply dtl
	 * @return the new leave apply dtl
	 */
	@Override
	public LeaveApplyDtl create(long leaveApplyDtlId) {
		LeaveApplyDtl leaveApplyDtl = new LeaveApplyDtlImpl();

		leaveApplyDtl.setNew(true);
		leaveApplyDtl.setPrimaryKey(leaveApplyDtlId);

		leaveApplyDtl.setCompanyId(companyProvider.getCompanyId());

		return leaveApplyDtl;
	}

	/**
	 * Removes the leave apply dtl with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveApplyDtlId the primary key of the leave apply dtl
	 * @return the leave apply dtl that was removed
	 * @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	 */
	@Override
	public LeaveApplyDtl remove(long leaveApplyDtlId)
		throws NoSuchLeaveApplyDtlException {
		return remove((Serializable)leaveApplyDtlId);
	}

	/**
	 * Removes the leave apply dtl with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave apply dtl
	 * @return the leave apply dtl that was removed
	 * @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	 */
	@Override
	public LeaveApplyDtl remove(Serializable primaryKey)
		throws NoSuchLeaveApplyDtlException {
		Session session = null;

		try {
			session = openSession();

			LeaveApplyDtl leaveApplyDtl = (LeaveApplyDtl)session.get(LeaveApplyDtlImpl.class,
					primaryKey);

			if (leaveApplyDtl == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveApplyDtlException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveApplyDtl);
		}
		catch (NoSuchLeaveApplyDtlException nsee) {
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
	protected LeaveApplyDtl removeImpl(LeaveApplyDtl leaveApplyDtl) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveApplyDtl)) {
				leaveApplyDtl = (LeaveApplyDtl)session.get(LeaveApplyDtlImpl.class,
						leaveApplyDtl.getPrimaryKeyObj());
			}

			if (leaveApplyDtl != null) {
				session.delete(leaveApplyDtl);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveApplyDtl != null) {
			clearCache(leaveApplyDtl);
		}

		return leaveApplyDtl;
	}

	@Override
	public LeaveApplyDtl updateImpl(LeaveApplyDtl leaveApplyDtl) {
		boolean isNew = leaveApplyDtl.isNew();

		if (!(leaveApplyDtl instanceof LeaveApplyDtlModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveApplyDtl.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(leaveApplyDtl);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveApplyDtl proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveApplyDtl implementation " +
				leaveApplyDtl.getClass());
		}

		LeaveApplyDtlModelImpl leaveApplyDtlModelImpl = (LeaveApplyDtlModelImpl)leaveApplyDtl;

		Session session = null;

		try {
			session = openSession();

			if (leaveApplyDtl.isNew()) {
				session.save(leaveApplyDtl);

				leaveApplyDtl.setNew(false);
			}
			else {
				leaveApplyDtl = (LeaveApplyDtl)session.merge(leaveApplyDtl);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LeaveApplyDtlModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { leaveApplyDtlModelImpl.getEmployeeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
				args);

			args = new Object[] { leaveApplyDtlModelImpl.getLeaveDate() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LEAVEAPPLYID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEAPPLYID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((leaveApplyDtlModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveApplyDtlModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { leaveApplyDtlModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}

			if ((leaveApplyDtlModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEAPPLYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveApplyDtlModelImpl.getOriginalLeaveDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LEAVEAPPLYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEAPPLYID,
					args);

				args = new Object[] { leaveApplyDtlModelImpl.getLeaveDate() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LEAVEAPPLYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVEAPPLYID,
					args);
			}
		}

		entityCache.putResult(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyDtlImpl.class, leaveApplyDtl.getPrimaryKey(),
			leaveApplyDtl, false);

		clearUniqueFindersCache(leaveApplyDtlModelImpl, false);
		cacheUniqueFindersCache(leaveApplyDtlModelImpl);

		leaveApplyDtl.resetOriginalValues();

		return leaveApplyDtl;
	}

	/**
	 * Returns the leave apply dtl with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave apply dtl
	 * @return the leave apply dtl
	 * @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	 */
	@Override
	public LeaveApplyDtl findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveApplyDtlException {
		LeaveApplyDtl leaveApplyDtl = fetchByPrimaryKey(primaryKey);

		if (leaveApplyDtl == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveApplyDtlException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveApplyDtl;
	}

	/**
	 * Returns the leave apply dtl with the primary key or throws a {@link NoSuchLeaveApplyDtlException} if it could not be found.
	 *
	 * @param leaveApplyDtlId the primary key of the leave apply dtl
	 * @return the leave apply dtl
	 * @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	 */
	@Override
	public LeaveApplyDtl findByPrimaryKey(long leaveApplyDtlId)
		throws NoSuchLeaveApplyDtlException {
		return findByPrimaryKey((Serializable)leaveApplyDtlId);
	}

	/**
	 * Returns the leave apply dtl with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave apply dtl
	 * @return the leave apply dtl, or <code>null</code> if a leave apply dtl with the primary key could not be found
	 */
	@Override
	public LeaveApplyDtl fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
				LeaveApplyDtlImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LeaveApplyDtl leaveApplyDtl = (LeaveApplyDtl)serializable;

		if (leaveApplyDtl == null) {
			Session session = null;

			try {
				session = openSession();

				leaveApplyDtl = (LeaveApplyDtl)session.get(LeaveApplyDtlImpl.class,
						primaryKey);

				if (leaveApplyDtl != null) {
					cacheResult(leaveApplyDtl);
				}
				else {
					entityCache.putResult(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
						LeaveApplyDtlImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
					LeaveApplyDtlImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveApplyDtl;
	}

	/**
	 * Returns the leave apply dtl with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveApplyDtlId the primary key of the leave apply dtl
	 * @return the leave apply dtl, or <code>null</code> if a leave apply dtl with the primary key could not be found
	 */
	@Override
	public LeaveApplyDtl fetchByPrimaryKey(long leaveApplyDtlId) {
		return fetchByPrimaryKey((Serializable)leaveApplyDtlId);
	}

	@Override
	public Map<Serializable, LeaveApplyDtl> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LeaveApplyDtl> map = new HashMap<Serializable, LeaveApplyDtl>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LeaveApplyDtl leaveApplyDtl = fetchByPrimaryKey(primaryKey);

			if (leaveApplyDtl != null) {
				map.put(primaryKey, leaveApplyDtl);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
					LeaveApplyDtlImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LeaveApplyDtl)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LEAVEAPPLYDTL_WHERE_PKS_IN);

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

			for (LeaveApplyDtl leaveApplyDtl : (List<LeaveApplyDtl>)q.list()) {
				map.put(leaveApplyDtl.getPrimaryKeyObj(), leaveApplyDtl);

				cacheResult(leaveApplyDtl);

				uncachedPrimaryKeys.remove(leaveApplyDtl.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LeaveApplyDtlModelImpl.ENTITY_CACHE_ENABLED,
					LeaveApplyDtlImpl.class, primaryKey, nullModel);
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
	 * Returns all the leave apply dtls.
	 *
	 * @return the leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave apply dtls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave apply dtls
	 * @param end the upper bound of the range of leave apply dtls (not inclusive)
	 * @return the range of leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave apply dtls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave apply dtls
	 * @param end the upper bound of the range of leave apply dtls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findAll(int start, int end,
		OrderByComparator<LeaveApplyDtl> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave apply dtls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave apply dtls
	 * @param end the upper bound of the range of leave apply dtls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of leave apply dtls
	 */
	@Override
	public List<LeaveApplyDtl> findAll(int start, int end,
		OrderByComparator<LeaveApplyDtl> orderByComparator,
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

		List<LeaveApplyDtl> list = null;

		if (retrieveFromCache) {
			list = (List<LeaveApplyDtl>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEAVEAPPLYDTL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEAPPLYDTL;

				if (pagination) {
					sql = sql.concat(LeaveApplyDtlModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveApplyDtl>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LeaveApplyDtl>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leave apply dtls from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveApplyDtl leaveApplyDtl : findAll()) {
			remove(leaveApplyDtl);
		}
	}

	/**
	 * Returns the number of leave apply dtls.
	 *
	 * @return the number of leave apply dtls
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEAVEAPPLYDTL);

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
		return LeaveApplyDtlModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave apply dtl persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LeaveApplyDtlImpl.class.getName());
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

	private static final String _SQL_SELECT_LEAVEAPPLYDTL = "SELECT leaveApplyDtl FROM LeaveApplyDtl leaveApplyDtl";
	private static final String _SQL_SELECT_LEAVEAPPLYDTL_WHERE_PKS_IN = "SELECT leaveApplyDtl FROM LeaveApplyDtl leaveApplyDtl WHERE leaveApplyDtlId IN (";
	private static final String _SQL_SELECT_LEAVEAPPLYDTL_WHERE = "SELECT leaveApplyDtl FROM LeaveApplyDtl leaveApplyDtl WHERE ";
	private static final String _SQL_COUNT_LEAVEAPPLYDTL = "SELECT COUNT(leaveApplyDtl) FROM LeaveApplyDtl leaveApplyDtl";
	private static final String _SQL_COUNT_LEAVEAPPLYDTL_WHERE = "SELECT COUNT(leaveApplyDtl) FROM LeaveApplyDtl leaveApplyDtl WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveApplyDtl.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveApplyDtl exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveApplyDtl exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LeaveApplyDtlPersistenceImpl.class);
}