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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyException;
import com.liferay.famocom.erpcloud.model.LeaveApply;
import com.liferay.famocom.erpcloud.model.impl.LeaveApplyImpl;
import com.liferay.famocom.erpcloud.model.impl.LeaveApplyModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.LeaveApplyPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the leave apply service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveApplyPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.LeaveApplyUtil
 * @generated
 */
@ProviderType
public class LeaveApplyPersistenceImpl extends BasePersistenceImpl<LeaveApply>
	implements LeaveApplyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveApplyUtil} to access the leave apply persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveApplyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyModelImpl.FINDER_CACHE_ENABLED, LeaveApplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyModelImpl.FINDER_CACHE_ENABLED, LeaveApplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyModelImpl.FINDER_CACHE_ENABLED, LeaveApplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyModelImpl.FINDER_CACHE_ENABLED, LeaveApplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			LeaveApplyModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave applies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching leave applies
	 */
	@Override
	public List<LeaveApply> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave applies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of leave applies
	 * @param end the upper bound of the range of leave applies (not inclusive)
	 * @return the range of matching leave applies
	 */
	@Override
	public List<LeaveApply> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave applies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of leave applies
	 * @param end the upper bound of the range of leave applies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave applies
	 */
	@Override
	public List<LeaveApply> findByuserId(long userId, int start, int end,
		OrderByComparator<LeaveApply> orderByComparator) {
		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave applies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of leave applies
	 * @param end the upper bound of the range of leave applies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching leave applies
	 */
	@Override
	public List<LeaveApply> findByuserId(long userId, int start, int end,
		OrderByComparator<LeaveApply> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<LeaveApply> list = null;

		if (retrieveFromCache) {
			list = (List<LeaveApply>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveApply leaveApply : list) {
					if ((userId != leaveApply.getUserId())) {
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

			query.append(_SQL_SELECT_LEAVEAPPLY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveApplyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<LeaveApply>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LeaveApply>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first leave apply in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave apply
	 * @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	 */
	@Override
	public LeaveApply findByuserId_First(long userId,
		OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException {
		LeaveApply leaveApply = fetchByuserId_First(userId, orderByComparator);

		if (leaveApply != null) {
			return leaveApply;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchLeaveApplyException(msg.toString());
	}

	/**
	 * Returns the first leave apply in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave apply, or <code>null</code> if a matching leave apply could not be found
	 */
	@Override
	public LeaveApply fetchByuserId_First(long userId,
		OrderByComparator<LeaveApply> orderByComparator) {
		List<LeaveApply> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave apply in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave apply
	 * @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	 */
	@Override
	public LeaveApply findByuserId_Last(long userId,
		OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException {
		LeaveApply leaveApply = fetchByuserId_Last(userId, orderByComparator);

		if (leaveApply != null) {
			return leaveApply;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchLeaveApplyException(msg.toString());
	}

	/**
	 * Returns the last leave apply in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave apply, or <code>null</code> if a matching leave apply could not be found
	 */
	@Override
	public LeaveApply fetchByuserId_Last(long userId,
		OrderByComparator<LeaveApply> orderByComparator) {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<LeaveApply> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave applies before and after the current leave apply in the ordered set where userId = &#63;.
	 *
	 * @param leaveApplyId the primary key of the current leave apply
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave apply
	 * @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	 */
	@Override
	public LeaveApply[] findByuserId_PrevAndNext(long leaveApplyId,
		long userId, OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException {
		LeaveApply leaveApply = findByPrimaryKey(leaveApplyId);

		Session session = null;

		try {
			session = openSession();

			LeaveApply[] array = new LeaveApplyImpl[3];

			array[0] = getByuserId_PrevAndNext(session, leaveApply, userId,
					orderByComparator, true);

			array[1] = leaveApply;

			array[2] = getByuserId_PrevAndNext(session, leaveApply, userId,
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

	protected LeaveApply getByuserId_PrevAndNext(Session session,
		LeaveApply leaveApply, long userId,
		OrderByComparator<LeaveApply> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVEAPPLY_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(LeaveApplyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveApply);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveApply> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave applies where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (LeaveApply leaveApply : findByuserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(leaveApply);
		}
	}

	/**
	 * Returns the number of leave applies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching leave applies
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEAVEAPPLY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "leaveApply.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyModelImpl.FINDER_CACHE_ENABLED, LeaveApplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyModelImpl.FINDER_CACHE_ENABLED, LeaveApplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			LeaveApplyModelImpl.GROUPID_COLUMN_BITMASK |
			LeaveApplyModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the leave applies where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching leave applies
	 */
	@Override
	public List<LeaveApply> findBystatus(long groupId, int status) {
		return findBystatus(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave applies where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of leave applies
	 * @param end the upper bound of the range of leave applies (not inclusive)
	 * @return the range of matching leave applies
	 */
	@Override
	public List<LeaveApply> findBystatus(long groupId, int status, int start,
		int end) {
		return findBystatus(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave applies where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of leave applies
	 * @param end the upper bound of the range of leave applies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave applies
	 */
	@Override
	public List<LeaveApply> findBystatus(long groupId, int status, int start,
		int end, OrderByComparator<LeaveApply> orderByComparator) {
		return findBystatus(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave applies where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of leave applies
	 * @param end the upper bound of the range of leave applies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching leave applies
	 */
	@Override
	public List<LeaveApply> findBystatus(long groupId, int status, int start,
		int end, OrderByComparator<LeaveApply> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] {
					groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<LeaveApply> list = null;

		if (retrieveFromCache) {
			list = (List<LeaveApply>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveApply leaveApply : list) {
					if ((groupId != leaveApply.getGroupId()) ||
							(status != leaveApply.getStatus())) {
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

			query.append(_SQL_SELECT_LEAVEAPPLY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveApplyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<LeaveApply>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LeaveApply>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first leave apply in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave apply
	 * @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	 */
	@Override
	public LeaveApply findBystatus_First(long groupId, int status,
		OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException {
		LeaveApply leaveApply = fetchBystatus_First(groupId, status,
				orderByComparator);

		if (leaveApply != null) {
			return leaveApply;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchLeaveApplyException(msg.toString());
	}

	/**
	 * Returns the first leave apply in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave apply, or <code>null</code> if a matching leave apply could not be found
	 */
	@Override
	public LeaveApply fetchBystatus_First(long groupId, int status,
		OrderByComparator<LeaveApply> orderByComparator) {
		List<LeaveApply> list = findBystatus(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave apply in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave apply
	 * @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	 */
	@Override
	public LeaveApply findBystatus_Last(long groupId, int status,
		OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException {
		LeaveApply leaveApply = fetchBystatus_Last(groupId, status,
				orderByComparator);

		if (leaveApply != null) {
			return leaveApply;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchLeaveApplyException(msg.toString());
	}

	/**
	 * Returns the last leave apply in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave apply, or <code>null</code> if a matching leave apply could not be found
	 */
	@Override
	public LeaveApply fetchBystatus_Last(long groupId, int status,
		OrderByComparator<LeaveApply> orderByComparator) {
		int count = countBystatus(groupId, status);

		if (count == 0) {
			return null;
		}

		List<LeaveApply> list = findBystatus(groupId, status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave applies before and after the current leave apply in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param leaveApplyId the primary key of the current leave apply
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave apply
	 * @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	 */
	@Override
	public LeaveApply[] findBystatus_PrevAndNext(long leaveApplyId,
		long groupId, int status,
		OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException {
		LeaveApply leaveApply = findByPrimaryKey(leaveApplyId);

		Session session = null;

		try {
			session = openSession();

			LeaveApply[] array = new LeaveApplyImpl[3];

			array[0] = getBystatus_PrevAndNext(session, leaveApply, groupId,
					status, orderByComparator, true);

			array[1] = leaveApply;

			array[2] = getBystatus_PrevAndNext(session, leaveApply, groupId,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveApply getBystatus_PrevAndNext(Session session,
		LeaveApply leaveApply, long groupId, int status,
		OrderByComparator<LeaveApply> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEAVEAPPLY_WHERE);

		query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(LeaveApplyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveApply);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveApply> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave applies where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeBystatus(long groupId, int status) {
		for (LeaveApply leaveApply : findBystatus(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveApply);
		}
	}

	/**
	 * Returns the number of leave applies where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching leave applies
	 */
	@Override
	public int countBystatus(long groupId, int status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEAVEAPPLY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_STATUS_GROUPID_2 = "leaveApply.groupId = ? AND ";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "leaveApply.status = ?";

	public LeaveApplyPersistenceImpl() {
		setModelClass(LeaveApply.class);
	}

	/**
	 * Caches the leave apply in the entity cache if it is enabled.
	 *
	 * @param leaveApply the leave apply
	 */
	@Override
	public void cacheResult(LeaveApply leaveApply) {
		entityCache.putResult(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyImpl.class, leaveApply.getPrimaryKey(), leaveApply);

		leaveApply.resetOriginalValues();
	}

	/**
	 * Caches the leave applies in the entity cache if it is enabled.
	 *
	 * @param leaveApplies the leave applies
	 */
	@Override
	public void cacheResult(List<LeaveApply> leaveApplies) {
		for (LeaveApply leaveApply : leaveApplies) {
			if (entityCache.getResult(
						LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
						LeaveApplyImpl.class, leaveApply.getPrimaryKey()) == null) {
				cacheResult(leaveApply);
			}
			else {
				leaveApply.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave applies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveApplyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave apply.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveApply leaveApply) {
		entityCache.removeResult(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyImpl.class, leaveApply.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LeaveApply> leaveApplies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveApply leaveApply : leaveApplies) {
			entityCache.removeResult(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
				LeaveApplyImpl.class, leaveApply.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave apply with the primary key. Does not add the leave apply to the database.
	 *
	 * @param leaveApplyId the primary key for the new leave apply
	 * @return the new leave apply
	 */
	@Override
	public LeaveApply create(long leaveApplyId) {
		LeaveApply leaveApply = new LeaveApplyImpl();

		leaveApply.setNew(true);
		leaveApply.setPrimaryKey(leaveApplyId);

		leaveApply.setCompanyId(companyProvider.getCompanyId());

		return leaveApply;
	}

	/**
	 * Removes the leave apply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveApplyId the primary key of the leave apply
	 * @return the leave apply that was removed
	 * @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	 */
	@Override
	public LeaveApply remove(long leaveApplyId)
		throws NoSuchLeaveApplyException {
		return remove((Serializable)leaveApplyId);
	}

	/**
	 * Removes the leave apply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave apply
	 * @return the leave apply that was removed
	 * @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	 */
	@Override
	public LeaveApply remove(Serializable primaryKey)
		throws NoSuchLeaveApplyException {
		Session session = null;

		try {
			session = openSession();

			LeaveApply leaveApply = (LeaveApply)session.get(LeaveApplyImpl.class,
					primaryKey);

			if (leaveApply == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveApplyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveApply);
		}
		catch (NoSuchLeaveApplyException nsee) {
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
	protected LeaveApply removeImpl(LeaveApply leaveApply) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveApply)) {
				leaveApply = (LeaveApply)session.get(LeaveApplyImpl.class,
						leaveApply.getPrimaryKeyObj());
			}

			if (leaveApply != null) {
				session.delete(leaveApply);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveApply != null) {
			clearCache(leaveApply);
		}

		return leaveApply;
	}

	@Override
	public LeaveApply updateImpl(LeaveApply leaveApply) {
		boolean isNew = leaveApply.isNew();

		if (!(leaveApply instanceof LeaveApplyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveApply.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(leaveApply);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveApply proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveApply implementation " +
				leaveApply.getClass());
		}

		LeaveApplyModelImpl leaveApplyModelImpl = (LeaveApplyModelImpl)leaveApply;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (leaveApply.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveApply.setCreateDate(now);
			}
			else {
				leaveApply.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!leaveApplyModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveApply.setModifiedDate(now);
			}
			else {
				leaveApply.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (leaveApply.isNew()) {
				session.save(leaveApply);

				leaveApply.setNew(false);
			}
			else {
				leaveApply = (LeaveApply)session.merge(leaveApply);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LeaveApplyModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { leaveApplyModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
				args);

			args = new Object[] {
					leaveApplyModelImpl.getGroupId(),
					leaveApplyModelImpl.getStatus()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((leaveApplyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveApplyModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { leaveApplyModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((leaveApplyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveApplyModelImpl.getOriginalGroupId(),
						leaveApplyModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						leaveApplyModelImpl.getGroupId(),
						leaveApplyModelImpl.getStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveApplyImpl.class, leaveApply.getPrimaryKey(), leaveApply, false);

		leaveApply.resetOriginalValues();

		return leaveApply;
	}

	/**
	 * Returns the leave apply with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave apply
	 * @return the leave apply
	 * @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	 */
	@Override
	public LeaveApply findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveApplyException {
		LeaveApply leaveApply = fetchByPrimaryKey(primaryKey);

		if (leaveApply == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveApplyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveApply;
	}

	/**
	 * Returns the leave apply with the primary key or throws a {@link NoSuchLeaveApplyException} if it could not be found.
	 *
	 * @param leaveApplyId the primary key of the leave apply
	 * @return the leave apply
	 * @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	 */
	@Override
	public LeaveApply findByPrimaryKey(long leaveApplyId)
		throws NoSuchLeaveApplyException {
		return findByPrimaryKey((Serializable)leaveApplyId);
	}

	/**
	 * Returns the leave apply with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave apply
	 * @return the leave apply, or <code>null</code> if a leave apply with the primary key could not be found
	 */
	@Override
	public LeaveApply fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
				LeaveApplyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LeaveApply leaveApply = (LeaveApply)serializable;

		if (leaveApply == null) {
			Session session = null;

			try {
				session = openSession();

				leaveApply = (LeaveApply)session.get(LeaveApplyImpl.class,
						primaryKey);

				if (leaveApply != null) {
					cacheResult(leaveApply);
				}
				else {
					entityCache.putResult(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
						LeaveApplyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
					LeaveApplyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveApply;
	}

	/**
	 * Returns the leave apply with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveApplyId the primary key of the leave apply
	 * @return the leave apply, or <code>null</code> if a leave apply with the primary key could not be found
	 */
	@Override
	public LeaveApply fetchByPrimaryKey(long leaveApplyId) {
		return fetchByPrimaryKey((Serializable)leaveApplyId);
	}

	@Override
	public Map<Serializable, LeaveApply> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LeaveApply> map = new HashMap<Serializable, LeaveApply>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LeaveApply leaveApply = fetchByPrimaryKey(primaryKey);

			if (leaveApply != null) {
				map.put(primaryKey, leaveApply);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
					LeaveApplyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LeaveApply)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LEAVEAPPLY_WHERE_PKS_IN);

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

			for (LeaveApply leaveApply : (List<LeaveApply>)q.list()) {
				map.put(leaveApply.getPrimaryKeyObj(), leaveApply);

				cacheResult(leaveApply);

				uncachedPrimaryKeys.remove(leaveApply.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LeaveApplyModelImpl.ENTITY_CACHE_ENABLED,
					LeaveApplyImpl.class, primaryKey, nullModel);
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
	 * Returns all the leave applies.
	 *
	 * @return the leave applies
	 */
	@Override
	public List<LeaveApply> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave applies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave applies
	 * @param end the upper bound of the range of leave applies (not inclusive)
	 * @return the range of leave applies
	 */
	@Override
	public List<LeaveApply> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave applies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave applies
	 * @param end the upper bound of the range of leave applies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave applies
	 */
	@Override
	public List<LeaveApply> findAll(int start, int end,
		OrderByComparator<LeaveApply> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave applies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave applies
	 * @param end the upper bound of the range of leave applies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of leave applies
	 */
	@Override
	public List<LeaveApply> findAll(int start, int end,
		OrderByComparator<LeaveApply> orderByComparator,
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

		List<LeaveApply> list = null;

		if (retrieveFromCache) {
			list = (List<LeaveApply>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEAVEAPPLY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEAPPLY;

				if (pagination) {
					sql = sql.concat(LeaveApplyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveApply>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LeaveApply>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leave applies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveApply leaveApply : findAll()) {
			remove(leaveApply);
		}
	}

	/**
	 * Returns the number of leave applies.
	 *
	 * @return the number of leave applies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEAVEAPPLY);

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
		return LeaveApplyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave apply persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LeaveApplyImpl.class.getName());
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
	private static final String _SQL_SELECT_LEAVEAPPLY = "SELECT leaveApply FROM LeaveApply leaveApply";
	private static final String _SQL_SELECT_LEAVEAPPLY_WHERE_PKS_IN = "SELECT leaveApply FROM LeaveApply leaveApply WHERE leaveApplyId IN (";
	private static final String _SQL_SELECT_LEAVEAPPLY_WHERE = "SELECT leaveApply FROM LeaveApply leaveApply WHERE ";
	private static final String _SQL_COUNT_LEAVEAPPLY = "SELECT COUNT(leaveApply) FROM LeaveApply leaveApply";
	private static final String _SQL_COUNT_LEAVEAPPLY_WHERE = "SELECT COUNT(leaveApply) FROM LeaveApply leaveApply WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveApply.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveApply exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveApply exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LeaveApplyPersistenceImpl.class);
}