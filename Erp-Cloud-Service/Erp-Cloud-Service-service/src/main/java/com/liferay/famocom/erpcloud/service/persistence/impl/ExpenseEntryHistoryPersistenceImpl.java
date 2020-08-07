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

import com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryHistoryException;
import com.liferay.famocom.erpcloud.model.ExpenseEntryHistory;
import com.liferay.famocom.erpcloud.model.impl.ExpenseEntryHistoryImpl;
import com.liferay.famocom.erpcloud.model.impl.ExpenseEntryHistoryModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ExpenseEntryHistoryPersistence;

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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the expense entry history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ExpenseEntryHistoryPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ExpenseEntryHistoryUtil
 * @generated
 */
@ProviderType
public class ExpenseEntryHistoryPersistenceImpl extends BasePersistenceImpl<ExpenseEntryHistory>
	implements ExpenseEntryHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExpenseEntryHistoryUtil} to access the expense entry history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExpenseEntryHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryHistoryModelImpl.FINDER_CACHE_ENABLED,
			ExpenseEntryHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryHistoryModelImpl.FINDER_CACHE_ENABLED,
			ExpenseEntryHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXPENCEID =
		new FinderPath(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryHistoryModelImpl.FINDER_CACHE_ENABLED,
			ExpenseEntryHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExpenceId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPENCEID =
		new FinderPath(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryHistoryModelImpl.FINDER_CACHE_ENABLED,
			ExpenseEntryHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExpenceId",
			new String[] { Long.class.getName() },
			ExpenseEntryHistoryModelImpl.EXPENSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXPENCEID = new FinderPath(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExpenceId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the expense entry histories where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @return the matching expense entry histories
	 */
	@Override
	public List<ExpenseEntryHistory> findByExpenceId(long expenseId) {
		return findByExpenceId(expenseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the expense entry histories where expenseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param expenseId the expense ID
	 * @param start the lower bound of the range of expense entry histories
	 * @param end the upper bound of the range of expense entry histories (not inclusive)
	 * @return the range of matching expense entry histories
	 */
	@Override
	public List<ExpenseEntryHistory> findByExpenceId(long expenseId, int start,
		int end) {
		return findByExpenceId(expenseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense entry histories where expenseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param expenseId the expense ID
	 * @param start the lower bound of the range of expense entry histories
	 * @param end the upper bound of the range of expense entry histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense entry histories
	 */
	@Override
	public List<ExpenseEntryHistory> findByExpenceId(long expenseId, int start,
		int end, OrderByComparator<ExpenseEntryHistory> orderByComparator) {
		return findByExpenceId(expenseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense entry histories where expenseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param expenseId the expense ID
	 * @param start the lower bound of the range of expense entry histories
	 * @param end the upper bound of the range of expense entry histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching expense entry histories
	 */
	@Override
	public List<ExpenseEntryHistory> findByExpenceId(long expenseId, int start,
		int end, OrderByComparator<ExpenseEntryHistory> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPENCEID;
			finderArgs = new Object[] { expenseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXPENCEID;
			finderArgs = new Object[] { expenseId, start, end, orderByComparator };
		}

		List<ExpenseEntryHistory> list = null;

		if (retrieveFromCache) {
			list = (List<ExpenseEntryHistory>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExpenseEntryHistory expenseEntryHistory : list) {
					if ((expenseId != expenseEntryHistory.getExpenseId())) {
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

			query.append(_SQL_SELECT_EXPENSEENTRYHISTORY_WHERE);

			query.append(_FINDER_COLUMN_EXPENCEID_EXPENSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExpenseEntryHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(expenseId);

				if (!pagination) {
					list = (List<ExpenseEntryHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExpenseEntryHistory>)QueryUtil.list(q,
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
	 * Returns the first expense entry history in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense entry history
	 * @throws NoSuchExpenseEntryHistoryException if a matching expense entry history could not be found
	 */
	@Override
	public ExpenseEntryHistory findByExpenceId_First(long expenseId,
		OrderByComparator<ExpenseEntryHistory> orderByComparator)
		throws NoSuchExpenseEntryHistoryException {
		ExpenseEntryHistory expenseEntryHistory = fetchByExpenceId_First(expenseId,
				orderByComparator);

		if (expenseEntryHistory != null) {
			return expenseEntryHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("expenseId=");
		msg.append(expenseId);

		msg.append("}");

		throw new NoSuchExpenseEntryHistoryException(msg.toString());
	}

	/**
	 * Returns the first expense entry history in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense entry history, or <code>null</code> if a matching expense entry history could not be found
	 */
	@Override
	public ExpenseEntryHistory fetchByExpenceId_First(long expenseId,
		OrderByComparator<ExpenseEntryHistory> orderByComparator) {
		List<ExpenseEntryHistory> list = findByExpenceId(expenseId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense entry history in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense entry history
	 * @throws NoSuchExpenseEntryHistoryException if a matching expense entry history could not be found
	 */
	@Override
	public ExpenseEntryHistory findByExpenceId_Last(long expenseId,
		OrderByComparator<ExpenseEntryHistory> orderByComparator)
		throws NoSuchExpenseEntryHistoryException {
		ExpenseEntryHistory expenseEntryHistory = fetchByExpenceId_Last(expenseId,
				orderByComparator);

		if (expenseEntryHistory != null) {
			return expenseEntryHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("expenseId=");
		msg.append(expenseId);

		msg.append("}");

		throw new NoSuchExpenseEntryHistoryException(msg.toString());
	}

	/**
	 * Returns the last expense entry history in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense entry history, or <code>null</code> if a matching expense entry history could not be found
	 */
	@Override
	public ExpenseEntryHistory fetchByExpenceId_Last(long expenseId,
		OrderByComparator<ExpenseEntryHistory> orderByComparator) {
		int count = countByExpenceId(expenseId);

		if (count == 0) {
			return null;
		}

		List<ExpenseEntryHistory> list = findByExpenceId(expenseId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expense entry histories before and after the current expense entry history in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseHistoryId the primary key of the current expense entry history
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense entry history
	 * @throws NoSuchExpenseEntryHistoryException if a expense entry history with the primary key could not be found
	 */
	@Override
	public ExpenseEntryHistory[] findByExpenceId_PrevAndNext(
		long expenseHistoryId, long expenseId,
		OrderByComparator<ExpenseEntryHistory> orderByComparator)
		throws NoSuchExpenseEntryHistoryException {
		ExpenseEntryHistory expenseEntryHistory = findByPrimaryKey(expenseHistoryId);

		Session session = null;

		try {
			session = openSession();

			ExpenseEntryHistory[] array = new ExpenseEntryHistoryImpl[3];

			array[0] = getByExpenceId_PrevAndNext(session, expenseEntryHistory,
					expenseId, orderByComparator, true);

			array[1] = expenseEntryHistory;

			array[2] = getByExpenceId_PrevAndNext(session, expenseEntryHistory,
					expenseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpenseEntryHistory getByExpenceId_PrevAndNext(Session session,
		ExpenseEntryHistory expenseEntryHistory, long expenseId,
		OrderByComparator<ExpenseEntryHistory> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPENSEENTRYHISTORY_WHERE);

		query.append(_FINDER_COLUMN_EXPENCEID_EXPENSEID_2);

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
			query.append(ExpenseEntryHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(expenseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(expenseEntryHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpenseEntryHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expense entry histories where expenseId = &#63; from the database.
	 *
	 * @param expenseId the expense ID
	 */
	@Override
	public void removeByExpenceId(long expenseId) {
		for (ExpenseEntryHistory expenseEntryHistory : findByExpenceId(
				expenseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(expenseEntryHistory);
		}
	}

	/**
	 * Returns the number of expense entry histories where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @return the number of matching expense entry histories
	 */
	@Override
	public int countByExpenceId(long expenseId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EXPENCEID;

		Object[] finderArgs = new Object[] { expenseId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXPENSEENTRYHISTORY_WHERE);

			query.append(_FINDER_COLUMN_EXPENCEID_EXPENSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(expenseId);

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

	private static final String _FINDER_COLUMN_EXPENCEID_EXPENSEID_2 = "expenseEntryHistory.expenseId = ?";

	public ExpenseEntryHistoryPersistenceImpl() {
		setModelClass(ExpenseEntryHistory.class);
	}

	/**
	 * Caches the expense entry history in the entity cache if it is enabled.
	 *
	 * @param expenseEntryHistory the expense entry history
	 */
	@Override
	public void cacheResult(ExpenseEntryHistory expenseEntryHistory) {
		entityCache.putResult(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryHistoryImpl.class, expenseEntryHistory.getPrimaryKey(),
			expenseEntryHistory);

		expenseEntryHistory.resetOriginalValues();
	}

	/**
	 * Caches the expense entry histories in the entity cache if it is enabled.
	 *
	 * @param expenseEntryHistories the expense entry histories
	 */
	@Override
	public void cacheResult(List<ExpenseEntryHistory> expenseEntryHistories) {
		for (ExpenseEntryHistory expenseEntryHistory : expenseEntryHistories) {
			if (entityCache.getResult(
						ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
						ExpenseEntryHistoryImpl.class,
						expenseEntryHistory.getPrimaryKey()) == null) {
				cacheResult(expenseEntryHistory);
			}
			else {
				expenseEntryHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all expense entry histories.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExpenseEntryHistoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the expense entry history.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExpenseEntryHistory expenseEntryHistory) {
		entityCache.removeResult(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryHistoryImpl.class, expenseEntryHistory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ExpenseEntryHistory> expenseEntryHistories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExpenseEntryHistory expenseEntryHistory : expenseEntryHistories) {
			entityCache.removeResult(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
				ExpenseEntryHistoryImpl.class,
				expenseEntryHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new expense entry history with the primary key. Does not add the expense entry history to the database.
	 *
	 * @param expenseHistoryId the primary key for the new expense entry history
	 * @return the new expense entry history
	 */
	@Override
	public ExpenseEntryHistory create(long expenseHistoryId) {
		ExpenseEntryHistory expenseEntryHistory = new ExpenseEntryHistoryImpl();

		expenseEntryHistory.setNew(true);
		expenseEntryHistory.setPrimaryKey(expenseHistoryId);

		expenseEntryHistory.setCompanyId(companyProvider.getCompanyId());

		return expenseEntryHistory;
	}

	/**
	 * Removes the expense entry history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseHistoryId the primary key of the expense entry history
	 * @return the expense entry history that was removed
	 * @throws NoSuchExpenseEntryHistoryException if a expense entry history with the primary key could not be found
	 */
	@Override
	public ExpenseEntryHistory remove(long expenseHistoryId)
		throws NoSuchExpenseEntryHistoryException {
		return remove((Serializable)expenseHistoryId);
	}

	/**
	 * Removes the expense entry history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the expense entry history
	 * @return the expense entry history that was removed
	 * @throws NoSuchExpenseEntryHistoryException if a expense entry history with the primary key could not be found
	 */
	@Override
	public ExpenseEntryHistory remove(Serializable primaryKey)
		throws NoSuchExpenseEntryHistoryException {
		Session session = null;

		try {
			session = openSession();

			ExpenseEntryHistory expenseEntryHistory = (ExpenseEntryHistory)session.get(ExpenseEntryHistoryImpl.class,
					primaryKey);

			if (expenseEntryHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpenseEntryHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(expenseEntryHistory);
		}
		catch (NoSuchExpenseEntryHistoryException nsee) {
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
	protected ExpenseEntryHistory removeImpl(
		ExpenseEntryHistory expenseEntryHistory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expenseEntryHistory)) {
				expenseEntryHistory = (ExpenseEntryHistory)session.get(ExpenseEntryHistoryImpl.class,
						expenseEntryHistory.getPrimaryKeyObj());
			}

			if (expenseEntryHistory != null) {
				session.delete(expenseEntryHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (expenseEntryHistory != null) {
			clearCache(expenseEntryHistory);
		}

		return expenseEntryHistory;
	}

	@Override
	public ExpenseEntryHistory updateImpl(
		ExpenseEntryHistory expenseEntryHistory) {
		boolean isNew = expenseEntryHistory.isNew();

		if (!(expenseEntryHistory instanceof ExpenseEntryHistoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(expenseEntryHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(expenseEntryHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in expenseEntryHistory proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ExpenseEntryHistory implementation " +
				expenseEntryHistory.getClass());
		}

		ExpenseEntryHistoryModelImpl expenseEntryHistoryModelImpl = (ExpenseEntryHistoryModelImpl)expenseEntryHistory;

		Session session = null;

		try {
			session = openSession();

			if (expenseEntryHistory.isNew()) {
				session.save(expenseEntryHistory);

				expenseEntryHistory.setNew(false);
			}
			else {
				expenseEntryHistory = (ExpenseEntryHistory)session.merge(expenseEntryHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ExpenseEntryHistoryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					expenseEntryHistoryModelImpl.getExpenseId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EXPENCEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPENCEID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((expenseEntryHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPENCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						expenseEntryHistoryModelImpl.getOriginalExpenseId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EXPENCEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPENCEID,
					args);

				args = new Object[] { expenseEntryHistoryModelImpl.getExpenseId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EXPENCEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPENCEID,
					args);
			}
		}

		entityCache.putResult(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseEntryHistoryImpl.class, expenseEntryHistory.getPrimaryKey(),
			expenseEntryHistory, false);

		expenseEntryHistory.resetOriginalValues();

		return expenseEntryHistory;
	}

	/**
	 * Returns the expense entry history with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the expense entry history
	 * @return the expense entry history
	 * @throws NoSuchExpenseEntryHistoryException if a expense entry history with the primary key could not be found
	 */
	@Override
	public ExpenseEntryHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpenseEntryHistoryException {
		ExpenseEntryHistory expenseEntryHistory = fetchByPrimaryKey(primaryKey);

		if (expenseEntryHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpenseEntryHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return expenseEntryHistory;
	}

	/**
	 * Returns the expense entry history with the primary key or throws a {@link NoSuchExpenseEntryHistoryException} if it could not be found.
	 *
	 * @param expenseHistoryId the primary key of the expense entry history
	 * @return the expense entry history
	 * @throws NoSuchExpenseEntryHistoryException if a expense entry history with the primary key could not be found
	 */
	@Override
	public ExpenseEntryHistory findByPrimaryKey(long expenseHistoryId)
		throws NoSuchExpenseEntryHistoryException {
		return findByPrimaryKey((Serializable)expenseHistoryId);
	}

	/**
	 * Returns the expense entry history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the expense entry history
	 * @return the expense entry history, or <code>null</code> if a expense entry history with the primary key could not be found
	 */
	@Override
	public ExpenseEntryHistory fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
				ExpenseEntryHistoryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ExpenseEntryHistory expenseEntryHistory = (ExpenseEntryHistory)serializable;

		if (expenseEntryHistory == null) {
			Session session = null;

			try {
				session = openSession();

				expenseEntryHistory = (ExpenseEntryHistory)session.get(ExpenseEntryHistoryImpl.class,
						primaryKey);

				if (expenseEntryHistory != null) {
					cacheResult(expenseEntryHistory);
				}
				else {
					entityCache.putResult(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
						ExpenseEntryHistoryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseEntryHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return expenseEntryHistory;
	}

	/**
	 * Returns the expense entry history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseHistoryId the primary key of the expense entry history
	 * @return the expense entry history, or <code>null</code> if a expense entry history with the primary key could not be found
	 */
	@Override
	public ExpenseEntryHistory fetchByPrimaryKey(long expenseHistoryId) {
		return fetchByPrimaryKey((Serializable)expenseHistoryId);
	}

	@Override
	public Map<Serializable, ExpenseEntryHistory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ExpenseEntryHistory> map = new HashMap<Serializable, ExpenseEntryHistory>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ExpenseEntryHistory expenseEntryHistory = fetchByPrimaryKey(primaryKey);

			if (expenseEntryHistory != null) {
				map.put(primaryKey, expenseEntryHistory);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseEntryHistoryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ExpenseEntryHistory)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EXPENSEENTRYHISTORY_WHERE_PKS_IN);

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

			for (ExpenseEntryHistory expenseEntryHistory : (List<ExpenseEntryHistory>)q.list()) {
				map.put(expenseEntryHistory.getPrimaryKeyObj(),
					expenseEntryHistory);

				cacheResult(expenseEntryHistory);

				uncachedPrimaryKeys.remove(expenseEntryHistory.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ExpenseEntryHistoryModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseEntryHistoryImpl.class, primaryKey, nullModel);
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
	 * Returns all the expense entry histories.
	 *
	 * @return the expense entry histories
	 */
	@Override
	public List<ExpenseEntryHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense entry histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense entry histories
	 * @param end the upper bound of the range of expense entry histories (not inclusive)
	 * @return the range of expense entry histories
	 */
	@Override
	public List<ExpenseEntryHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense entry histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense entry histories
	 * @param end the upper bound of the range of expense entry histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of expense entry histories
	 */
	@Override
	public List<ExpenseEntryHistory> findAll(int start, int end,
		OrderByComparator<ExpenseEntryHistory> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense entry histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseEntryHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense entry histories
	 * @param end the upper bound of the range of expense entry histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of expense entry histories
	 */
	@Override
	public List<ExpenseEntryHistory> findAll(int start, int end,
		OrderByComparator<ExpenseEntryHistory> orderByComparator,
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

		List<ExpenseEntryHistory> list = null;

		if (retrieveFromCache) {
			list = (List<ExpenseEntryHistory>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXPENSEENTRYHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXPENSEENTRYHISTORY;

				if (pagination) {
					sql = sql.concat(ExpenseEntryHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExpenseEntryHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExpenseEntryHistory>)QueryUtil.list(q,
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
	 * Removes all the expense entry histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExpenseEntryHistory expenseEntryHistory : findAll()) {
			remove(expenseEntryHistory);
		}
	}

	/**
	 * Returns the number of expense entry histories.
	 *
	 * @return the number of expense entry histories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXPENSEENTRYHISTORY);

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
		return ExpenseEntryHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the expense entry history persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ExpenseEntryHistoryImpl.class.getName());
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
	private static final String _SQL_SELECT_EXPENSEENTRYHISTORY = "SELECT expenseEntryHistory FROM ExpenseEntryHistory expenseEntryHistory";
	private static final String _SQL_SELECT_EXPENSEENTRYHISTORY_WHERE_PKS_IN = "SELECT expenseEntryHistory FROM ExpenseEntryHistory expenseEntryHistory WHERE expenseHistoryId IN (";
	private static final String _SQL_SELECT_EXPENSEENTRYHISTORY_WHERE = "SELECT expenseEntryHistory FROM ExpenseEntryHistory expenseEntryHistory WHERE ";
	private static final String _SQL_COUNT_EXPENSEENTRYHISTORY = "SELECT COUNT(expenseEntryHistory) FROM ExpenseEntryHistory expenseEntryHistory";
	private static final String _SQL_COUNT_EXPENSEENTRYHISTORY_WHERE = "SELECT COUNT(expenseEntryHistory) FROM ExpenseEntryHistory expenseEntryHistory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "expenseEntryHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExpenseEntryHistory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExpenseEntryHistory exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ExpenseEntryHistoryPersistenceImpl.class);
}