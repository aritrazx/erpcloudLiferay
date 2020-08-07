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

import com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryException;
import com.liferay.famocom.erpcloud.model.ExpenseEntry;
import com.liferay.famocom.erpcloud.model.impl.ExpenseEntryImpl;
import com.liferay.famocom.erpcloud.model.impl.ExpenseEntryModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ExpenseEntryPersistence;

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
 * The persistence implementation for the expense entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ExpenseEntryPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ExpenseEntryUtil
 * @generated
 */
@ProviderType
public class ExpenseEntryPersistenceImpl extends BasePersistenceImpl<ExpenseEntry>
	implements ExpenseEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExpenseEntryUtil} to access the expense entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExpenseEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryModelImpl.FINDER_CACHE_ENABLED, ExpenseEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryModelImpl.FINDER_CACHE_ENABLED, ExpenseEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryModelImpl.FINDER_CACHE_ENABLED, ExpenseEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryModelImpl.FINDER_CACHE_ENABLED, ExpenseEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			ExpenseEntryModelImpl.USERID_COLUMN_BITMASK |
			ExpenseEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the expense entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching expense entries
	 */
	@Override
	public List<ExpenseEntry> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of expense entries
	 * @param end the upper bound of the range of expense entries (not inclusive)
	 * @return the range of matching expense entries
	 */
	@Override
	public List<ExpenseEntry> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of expense entries
	 * @param end the upper bound of the range of expense entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense entries
	 */
	@Override
	public List<ExpenseEntry> findByuserId(long userId, int start, int end,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of expense entries
	 * @param end the upper bound of the range of expense entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching expense entries
	 */
	@Override
	public List<ExpenseEntry> findByuserId(long userId, int start, int end,
		OrderByComparator<ExpenseEntry> orderByComparator,
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

		List<ExpenseEntry> list = null;

		if (retrieveFromCache) {
			list = (List<ExpenseEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExpenseEntry expenseEntry : list) {
					if ((userId != expenseEntry.getUserId())) {
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

			query.append(_SQL_SELECT_EXPENSEENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExpenseEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<ExpenseEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExpenseEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first expense entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense entry
	 * @throws NoSuchExpenseEntryException if a matching expense entry could not be found
	 */
	@Override
	public ExpenseEntry findByuserId_First(long userId,
		OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException {
		ExpenseEntry expenseEntry = fetchByuserId_First(userId,
				orderByComparator);

		if (expenseEntry != null) {
			return expenseEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchExpenseEntryException(msg.toString());
	}

	/**
	 * Returns the first expense entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense entry, or <code>null</code> if a matching expense entry could not be found
	 */
	@Override
	public ExpenseEntry fetchByuserId_First(long userId,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		List<ExpenseEntry> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense entry
	 * @throws NoSuchExpenseEntryException if a matching expense entry could not be found
	 */
	@Override
	public ExpenseEntry findByuserId_Last(long userId,
		OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException {
		ExpenseEntry expenseEntry = fetchByuserId_Last(userId, orderByComparator);

		if (expenseEntry != null) {
			return expenseEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchExpenseEntryException(msg.toString());
	}

	/**
	 * Returns the last expense entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense entry, or <code>null</code> if a matching expense entry could not be found
	 */
	@Override
	public ExpenseEntry fetchByuserId_Last(long userId,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<ExpenseEntry> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expense entries before and after the current expense entry in the ordered set where userId = &#63;.
	 *
	 * @param expenseId the primary key of the current expense entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense entry
	 * @throws NoSuchExpenseEntryException if a expense entry with the primary key could not be found
	 */
	@Override
	public ExpenseEntry[] findByuserId_PrevAndNext(long expenseId, long userId,
		OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException {
		ExpenseEntry expenseEntry = findByPrimaryKey(expenseId);

		Session session = null;

		try {
			session = openSession();

			ExpenseEntry[] array = new ExpenseEntryImpl[3];

			array[0] = getByuserId_PrevAndNext(session, expenseEntry, userId,
					orderByComparator, true);

			array[1] = expenseEntry;

			array[2] = getByuserId_PrevAndNext(session, expenseEntry, userId,
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

	protected ExpenseEntry getByuserId_PrevAndNext(Session session,
		ExpenseEntry expenseEntry, long userId,
		OrderByComparator<ExpenseEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPENSEENTRY_WHERE);

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
			query.append(ExpenseEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(expenseEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpenseEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expense entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (ExpenseEntry expenseEntry : findByuserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(expenseEntry);
		}
	}

	/**
	 * Returns the number of expense entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching expense entries
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXPENSEENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "expenseEntry.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryModelImpl.FINDER_CACHE_ENABLED, ExpenseEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryModelImpl.FINDER_CACHE_ENABLED, ExpenseEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ExpenseEntryModelImpl.GROUPID_COLUMN_BITMASK |
			ExpenseEntryModelImpl.STATUS_COLUMN_BITMASK |
			ExpenseEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the expense entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense entries
	 */
	@Override
	public List<ExpenseEntry> findBystatus(long groupId, int status) {
		return findBystatus(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense entries
	 * @param end the upper bound of the range of expense entries (not inclusive)
	 * @return the range of matching expense entries
	 */
	@Override
	public List<ExpenseEntry> findBystatus(long groupId, int status, int start,
		int end) {
		return findBystatus(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense entries
	 * @param end the upper bound of the range of expense entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense entries
	 */
	@Override
	public List<ExpenseEntry> findBystatus(long groupId, int status, int start,
		int end, OrderByComparator<ExpenseEntry> orderByComparator) {
		return findBystatus(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense entries
	 * @param end the upper bound of the range of expense entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching expense entries
	 */
	@Override
	public List<ExpenseEntry> findBystatus(long groupId, int status, int start,
		int end, OrderByComparator<ExpenseEntry> orderByComparator,
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

		List<ExpenseEntry> list = null;

		if (retrieveFromCache) {
			list = (List<ExpenseEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExpenseEntry expenseEntry : list) {
					if ((groupId != expenseEntry.getGroupId()) ||
							(status != expenseEntry.getStatus())) {
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

			query.append(_SQL_SELECT_EXPENSEENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExpenseEntryModelImpl.ORDER_BY_JPQL);
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
					list = (List<ExpenseEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExpenseEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first expense entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense entry
	 * @throws NoSuchExpenseEntryException if a matching expense entry could not be found
	 */
	@Override
	public ExpenseEntry findBystatus_First(long groupId, int status,
		OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException {
		ExpenseEntry expenseEntry = fetchBystatus_First(groupId, status,
				orderByComparator);

		if (expenseEntry != null) {
			return expenseEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchExpenseEntryException(msg.toString());
	}

	/**
	 * Returns the first expense entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense entry, or <code>null</code> if a matching expense entry could not be found
	 */
	@Override
	public ExpenseEntry fetchBystatus_First(long groupId, int status,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		List<ExpenseEntry> list = findBystatus(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense entry
	 * @throws NoSuchExpenseEntryException if a matching expense entry could not be found
	 */
	@Override
	public ExpenseEntry findBystatus_Last(long groupId, int status,
		OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException {
		ExpenseEntry expenseEntry = fetchBystatus_Last(groupId, status,
				orderByComparator);

		if (expenseEntry != null) {
			return expenseEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchExpenseEntryException(msg.toString());
	}

	/**
	 * Returns the last expense entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense entry, or <code>null</code> if a matching expense entry could not be found
	 */
	@Override
	public ExpenseEntry fetchBystatus_Last(long groupId, int status,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		int count = countBystatus(groupId, status);

		if (count == 0) {
			return null;
		}

		List<ExpenseEntry> list = findBystatus(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expense entries before and after the current expense entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param expenseId the primary key of the current expense entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense entry
	 * @throws NoSuchExpenseEntryException if a expense entry with the primary key could not be found
	 */
	@Override
	public ExpenseEntry[] findBystatus_PrevAndNext(long expenseId,
		long groupId, int status,
		OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException {
		ExpenseEntry expenseEntry = findByPrimaryKey(expenseId);

		Session session = null;

		try {
			session = openSession();

			ExpenseEntry[] array = new ExpenseEntryImpl[3];

			array[0] = getBystatus_PrevAndNext(session, expenseEntry, groupId,
					status, orderByComparator, true);

			array[1] = expenseEntry;

			array[2] = getBystatus_PrevAndNext(session, expenseEntry, groupId,
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

	protected ExpenseEntry getBystatus_PrevAndNext(Session session,
		ExpenseEntry expenseEntry, long groupId, int status,
		OrderByComparator<ExpenseEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_EXPENSEENTRY_WHERE);

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
			query.append(ExpenseEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(expenseEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpenseEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expense entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeBystatus(long groupId, int status) {
		for (ExpenseEntry expenseEntry : findBystatus(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(expenseEntry);
		}
	}

	/**
	 * Returns the number of expense entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense entries
	 */
	@Override
	public int countBystatus(long groupId, int status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EXPENSEENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_GROUPID_2 = "expenseEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "expenseEntry.status = ?";

	public ExpenseEntryPersistenceImpl() {
		setModelClass(ExpenseEntry.class);
	}

	/**
	 * Caches the expense entry in the entity cache if it is enabled.
	 *
	 * @param expenseEntry the expense entry
	 */
	@Override
	public void cacheResult(ExpenseEntry expenseEntry) {
		entityCache.putResult(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryImpl.class, expenseEntry.getPrimaryKey(), expenseEntry);

		expenseEntry.resetOriginalValues();
	}

	/**
	 * Caches the expense entries in the entity cache if it is enabled.
	 *
	 * @param expenseEntries the expense entries
	 */
	@Override
	public void cacheResult(List<ExpenseEntry> expenseEntries) {
		for (ExpenseEntry expenseEntry : expenseEntries) {
			if (entityCache.getResult(
						ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
						ExpenseEntryImpl.class, expenseEntry.getPrimaryKey()) == null) {
				cacheResult(expenseEntry);
			}
			else {
				expenseEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all expense entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExpenseEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the expense entry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExpenseEntry expenseEntry) {
		entityCache.removeResult(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryImpl.class, expenseEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ExpenseEntry> expenseEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExpenseEntry expenseEntry : expenseEntries) {
			entityCache.removeResult(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
				ExpenseEntryImpl.class, expenseEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new expense entry with the primary key. Does not add the expense entry to the database.
	 *
	 * @param expenseId the primary key for the new expense entry
	 * @return the new expense entry
	 */
	@Override
	public ExpenseEntry create(long expenseId) {
		ExpenseEntry expenseEntry = new ExpenseEntryImpl();

		expenseEntry.setNew(true);
		expenseEntry.setPrimaryKey(expenseId);

		expenseEntry.setCompanyId(companyProvider.getCompanyId());

		return expenseEntry;
	}

	/**
	 * Removes the expense entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseId the primary key of the expense entry
	 * @return the expense entry that was removed
	 * @throws NoSuchExpenseEntryException if a expense entry with the primary key could not be found
	 */
	@Override
	public ExpenseEntry remove(long expenseId)
		throws NoSuchExpenseEntryException {
		return remove((Serializable)expenseId);
	}

	/**
	 * Removes the expense entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the expense entry
	 * @return the expense entry that was removed
	 * @throws NoSuchExpenseEntryException if a expense entry with the primary key could not be found
	 */
	@Override
	public ExpenseEntry remove(Serializable primaryKey)
		throws NoSuchExpenseEntryException {
		Session session = null;

		try {
			session = openSession();

			ExpenseEntry expenseEntry = (ExpenseEntry)session.get(ExpenseEntryImpl.class,
					primaryKey);

			if (expenseEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpenseEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(expenseEntry);
		}
		catch (NoSuchExpenseEntryException nsee) {
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
	protected ExpenseEntry removeImpl(ExpenseEntry expenseEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expenseEntry)) {
				expenseEntry = (ExpenseEntry)session.get(ExpenseEntryImpl.class,
						expenseEntry.getPrimaryKeyObj());
			}

			if (expenseEntry != null) {
				session.delete(expenseEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (expenseEntry != null) {
			clearCache(expenseEntry);
		}

		return expenseEntry;
	}

	@Override
	public ExpenseEntry updateImpl(ExpenseEntry expenseEntry) {
		boolean isNew = expenseEntry.isNew();

		if (!(expenseEntry instanceof ExpenseEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(expenseEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(expenseEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in expenseEntry proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ExpenseEntry implementation " +
				expenseEntry.getClass());
		}

		ExpenseEntryModelImpl expenseEntryModelImpl = (ExpenseEntryModelImpl)expenseEntry;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (expenseEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				expenseEntry.setCreateDate(now);
			}
			else {
				expenseEntry.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!expenseEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				expenseEntry.setModifiedDate(now);
			}
			else {
				expenseEntry.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (expenseEntry.isNew()) {
				session.save(expenseEntry);

				expenseEntry.setNew(false);
			}
			else {
				expenseEntry = (ExpenseEntry)session.merge(expenseEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ExpenseEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { expenseEntryModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
				args);

			args = new Object[] {
					expenseEntryModelImpl.getGroupId(),
					expenseEntryModelImpl.getStatus()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((expenseEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						expenseEntryModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { expenseEntryModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((expenseEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						expenseEntryModelImpl.getOriginalGroupId(),
						expenseEntryModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						expenseEntryModelImpl.getGroupId(),
						expenseEntryModelImpl.getStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryImpl.class, expenseEntry.getPrimaryKey(), expenseEntry,
			false);

		expenseEntry.resetOriginalValues();

		return expenseEntry;
	}

	/**
	 * Returns the expense entry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the expense entry
	 * @return the expense entry
	 * @throws NoSuchExpenseEntryException if a expense entry with the primary key could not be found
	 */
	@Override
	public ExpenseEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpenseEntryException {
		ExpenseEntry expenseEntry = fetchByPrimaryKey(primaryKey);

		if (expenseEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpenseEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return expenseEntry;
	}

	/**
	 * Returns the expense entry with the primary key or throws a {@link NoSuchExpenseEntryException} if it could not be found.
	 *
	 * @param expenseId the primary key of the expense entry
	 * @return the expense entry
	 * @throws NoSuchExpenseEntryException if a expense entry with the primary key could not be found
	 */
	@Override
	public ExpenseEntry findByPrimaryKey(long expenseId)
		throws NoSuchExpenseEntryException {
		return findByPrimaryKey((Serializable)expenseId);
	}

	/**
	 * Returns the expense entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the expense entry
	 * @return the expense entry, or <code>null</code> if a expense entry with the primary key could not be found
	 */
	@Override
	public ExpenseEntry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
				ExpenseEntryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ExpenseEntry expenseEntry = (ExpenseEntry)serializable;

		if (expenseEntry == null) {
			Session session = null;

			try {
				session = openSession();

				expenseEntry = (ExpenseEntry)session.get(ExpenseEntryImpl.class,
						primaryKey);

				if (expenseEntry != null) {
					cacheResult(expenseEntry);
				}
				else {
					entityCache.putResult(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
						ExpenseEntryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return expenseEntry;
	}

	/**
	 * Returns the expense entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseId the primary key of the expense entry
	 * @return the expense entry, or <code>null</code> if a expense entry with the primary key could not be found
	 */
	@Override
	public ExpenseEntry fetchByPrimaryKey(long expenseId) {
		return fetchByPrimaryKey((Serializable)expenseId);
	}

	@Override
	public Map<Serializable, ExpenseEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ExpenseEntry> map = new HashMap<Serializable, ExpenseEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ExpenseEntry expenseEntry = fetchByPrimaryKey(primaryKey);

			if (expenseEntry != null) {
				map.put(primaryKey, expenseEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseEntryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ExpenseEntry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EXPENSEENTRY_WHERE_PKS_IN);

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

			for (ExpenseEntry expenseEntry : (List<ExpenseEntry>)q.list()) {
				map.put(expenseEntry.getPrimaryKeyObj(), expenseEntry);

				cacheResult(expenseEntry);

				uncachedPrimaryKeys.remove(expenseEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ExpenseEntryModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseEntryImpl.class, primaryKey, nullModel);
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
	 * Returns all the expense entries.
	 *
	 * @return the expense entries
	 */
	@Override
	public List<ExpenseEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense entries
	 * @param end the upper bound of the range of expense entries (not inclusive)
	 * @return the range of expense entries
	 */
	@Override
	public List<ExpenseEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense entries
	 * @param end the upper bound of the range of expense entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of expense entries
	 */
	@Override
	public List<ExpenseEntry> findAll(int start, int end,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense entries
	 * @param end the upper bound of the range of expense entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of expense entries
	 */
	@Override
	public List<ExpenseEntry> findAll(int start, int end,
		OrderByComparator<ExpenseEntry> orderByComparator,
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

		List<ExpenseEntry> list = null;

		if (retrieveFromCache) {
			list = (List<ExpenseEntry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXPENSEENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXPENSEENTRY;

				if (pagination) {
					sql = sql.concat(ExpenseEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExpenseEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExpenseEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the expense entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExpenseEntry expenseEntry : findAll()) {
			remove(expenseEntry);
		}
	}

	/**
	 * Returns the number of expense entries.
	 *
	 * @return the number of expense entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXPENSEENTRY);

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
		return ExpenseEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the expense entry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ExpenseEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_EXPENSEENTRY = "SELECT expenseEntry FROM ExpenseEntry expenseEntry";
	private static final String _SQL_SELECT_EXPENSEENTRY_WHERE_PKS_IN = "SELECT expenseEntry FROM ExpenseEntry expenseEntry WHERE expenseId IN (";
	private static final String _SQL_SELECT_EXPENSEENTRY_WHERE = "SELECT expenseEntry FROM ExpenseEntry expenseEntry WHERE ";
	private static final String _SQL_COUNT_EXPENSEENTRY = "SELECT COUNT(expenseEntry) FROM ExpenseEntry expenseEntry";
	private static final String _SQL_COUNT_EXPENSEENTRY_WHERE = "SELECT COUNT(expenseEntry) FROM ExpenseEntry expenseEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "expenseEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExpenseEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExpenseEntry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ExpenseEntryPersistenceImpl.class);
}