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

import com.liferay.famocom.erpcloud.exception.NoSuchExpenseException;
import com.liferay.famocom.erpcloud.model.Expense;
import com.liferay.famocom.erpcloud.model.impl.ExpenseImpl;
import com.liferay.famocom.erpcloud.model.impl.ExpenseModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ExpensePersistence;

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
 * The persistence implementation for the expense service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ExpensePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ExpenseUtil
 * @generated
 */
@ProviderType
public class ExpensePersistenceImpl extends BasePersistenceImpl<Expense>
	implements ExpensePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExpenseUtil} to access the expense persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExpenseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseModelImpl.FINDER_CACHE_ENABLED, ExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseModelImpl.FINDER_CACHE_ENABLED, ExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPID = new FinderPath(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseModelImpl.FINDER_CACHE_ENABLED, ExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByempId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID = new FinderPath(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseModelImpl.FINDER_CACHE_ENABLED, ExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByempId",
			new String[] { Long.class.getName() },
			ExpenseModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPID = new FinderPath(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByempId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the expenses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching expenses
	 */
	@Override
	public List<Expense> findByempId(long employeeId) {
		return findByempId(employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the expenses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of matching expenses
	 */
	@Override
	public List<Expense> findByempId(long employeeId, int start, int end) {
		return findByempId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expenses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expenses
	 */
	@Override
	public List<Expense> findByempId(long employeeId, int start, int end,
		OrderByComparator<Expense> orderByComparator) {
		return findByempId(employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expenses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching expenses
	 */
	@Override
	public List<Expense> findByempId(long employeeId, int start, int end,
		OrderByComparator<Expense> orderByComparator, boolean retrieveFromCache) {
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

		List<Expense> list = null;

		if (retrieveFromCache) {
			list = (List<Expense>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Expense expense : list) {
					if ((employeeId != expense.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EXPENSE_WHERE);

			query.append(_FINDER_COLUMN_EMPID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExpenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<Expense>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Expense>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first expense in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	@Override
	public Expense findByempId_First(long employeeId,
		OrderByComparator<Expense> orderByComparator)
		throws NoSuchExpenseException {
		Expense expense = fetchByempId_First(employeeId, orderByComparator);

		if (expense != null) {
			return expense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchExpenseException(msg.toString());
	}

	/**
	 * Returns the first expense in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense, or <code>null</code> if a matching expense could not be found
	 */
	@Override
	public Expense fetchByempId_First(long employeeId,
		OrderByComparator<Expense> orderByComparator) {
		List<Expense> list = findByempId(employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	@Override
	public Expense findByempId_Last(long employeeId,
		OrderByComparator<Expense> orderByComparator)
		throws NoSuchExpenseException {
		Expense expense = fetchByempId_Last(employeeId, orderByComparator);

		if (expense != null) {
			return expense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchExpenseException(msg.toString());
	}

	/**
	 * Returns the last expense in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense, or <code>null</code> if a matching expense could not be found
	 */
	@Override
	public Expense fetchByempId_Last(long employeeId,
		OrderByComparator<Expense> orderByComparator) {
		int count = countByempId(employeeId);

		if (count == 0) {
			return null;
		}

		List<Expense> list = findByempId(employeeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expenses before and after the current expense in the ordered set where employeeId = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	@Override
	public Expense[] findByempId_PrevAndNext(long expenseId, long employeeId,
		OrderByComparator<Expense> orderByComparator)
		throws NoSuchExpenseException {
		Expense expense = findByPrimaryKey(expenseId);

		Session session = null;

		try {
			session = openSession();

			Expense[] array = new ExpenseImpl[3];

			array[0] = getByempId_PrevAndNext(session, expense, employeeId,
					orderByComparator, true);

			array[1] = expense;

			array[2] = getByempId_PrevAndNext(session, expense, employeeId,
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

	protected Expense getByempId_PrevAndNext(Session session, Expense expense,
		long employeeId, OrderByComparator<Expense> orderByComparator,
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

		query.append(_SQL_SELECT_EXPENSE_WHERE);

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
			query.append(ExpenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(expense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Expense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expenses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByempId(long employeeId) {
		for (Expense expense : findByempId(employeeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(expense);
		}
	}

	/**
	 * Returns the number of expenses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching expenses
	 */
	@Override
	public int countByempId(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXPENSE_WHERE);

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

	private static final String _FINDER_COLUMN_EMPID_EMPLOYEEID_2 = "expense.employeeId = ?";

	public ExpensePersistenceImpl() {
		setModelClass(Expense.class);
	}

	/**
	 * Caches the expense in the entity cache if it is enabled.
	 *
	 * @param expense the expense
	 */
	@Override
	public void cacheResult(Expense expense) {
		entityCache.putResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseImpl.class, expense.getPrimaryKey(), expense);

		expense.resetOriginalValues();
	}

	/**
	 * Caches the expenses in the entity cache if it is enabled.
	 *
	 * @param expenses the expenses
	 */
	@Override
	public void cacheResult(List<Expense> expenses) {
		for (Expense expense : expenses) {
			if (entityCache.getResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
						ExpenseImpl.class, expense.getPrimaryKey()) == null) {
				cacheResult(expense);
			}
			else {
				expense.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all expenses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExpenseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the expense.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Expense expense) {
		entityCache.removeResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseImpl.class, expense.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Expense> expenses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Expense expense : expenses) {
			entityCache.removeResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
				ExpenseImpl.class, expense.getPrimaryKey());
		}
	}

	/**
	 * Creates a new expense with the primary key. Does not add the expense to the database.
	 *
	 * @param expenseId the primary key for the new expense
	 * @return the new expense
	 */
	@Override
	public Expense create(long expenseId) {
		Expense expense = new ExpenseImpl();

		expense.setNew(true);
		expense.setPrimaryKey(expenseId);

		expense.setCompanyId(companyProvider.getCompanyId());

		return expense;
	}

	/**
	 * Removes the expense with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense that was removed
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	@Override
	public Expense remove(long expenseId) throws NoSuchExpenseException {
		return remove((Serializable)expenseId);
	}

	/**
	 * Removes the expense with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the expense
	 * @return the expense that was removed
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	@Override
	public Expense remove(Serializable primaryKey)
		throws NoSuchExpenseException {
		Session session = null;

		try {
			session = openSession();

			Expense expense = (Expense)session.get(ExpenseImpl.class, primaryKey);

			if (expense == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(expense);
		}
		catch (NoSuchExpenseException nsee) {
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
	protected Expense removeImpl(Expense expense) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expense)) {
				expense = (Expense)session.get(ExpenseImpl.class,
						expense.getPrimaryKeyObj());
			}

			if (expense != null) {
				session.delete(expense);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (expense != null) {
			clearCache(expense);
		}

		return expense;
	}

	@Override
	public Expense updateImpl(Expense expense) {
		boolean isNew = expense.isNew();

		if (!(expense instanceof ExpenseModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(expense.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(expense);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in expense proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Expense implementation " +
				expense.getClass());
		}

		ExpenseModelImpl expenseModelImpl = (ExpenseModelImpl)expense;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (expense.getCreateDate() == null)) {
			if (serviceContext == null) {
				expense.setCreateDate(now);
			}
			else {
				expense.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!expenseModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				expense.setModifiedDate(now);
			}
			else {
				expense.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (expense.isNew()) {
				session.save(expense);

				expense.setNew(false);
			}
			else {
				expense = (Expense)session.merge(expense);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ExpenseModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { expenseModelImpl.getEmployeeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((expenseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						expenseModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID,
					args);

				args = new Object[] { expenseModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPID,
					args);
			}
		}

		entityCache.putResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseImpl.class, expense.getPrimaryKey(), expense, false);

		expense.resetOriginalValues();

		return expense;
	}

	/**
	 * Returns the expense with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the expense
	 * @return the expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	@Override
	public Expense findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpenseException {
		Expense expense = fetchByPrimaryKey(primaryKey);

		if (expense == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return expense;
	}

	/**
	 * Returns the expense with the primary key or throws a {@link NoSuchExpenseException} if it could not be found.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	@Override
	public Expense findByPrimaryKey(long expenseId)
		throws NoSuchExpenseException {
		return findByPrimaryKey((Serializable)expenseId);
	}

	/**
	 * Returns the expense with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the expense
	 * @return the expense, or <code>null</code> if a expense with the primary key could not be found
	 */
	@Override
	public Expense fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
				ExpenseImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Expense expense = (Expense)serializable;

		if (expense == null) {
			Session session = null;

			try {
				session = openSession();

				expense = (Expense)session.get(ExpenseImpl.class, primaryKey);

				if (expense != null) {
					cacheResult(expense);
				}
				else {
					entityCache.putResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
						ExpenseImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return expense;
	}

	/**
	 * Returns the expense with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense, or <code>null</code> if a expense with the primary key could not be found
	 */
	@Override
	public Expense fetchByPrimaryKey(long expenseId) {
		return fetchByPrimaryKey((Serializable)expenseId);
	}

	@Override
	public Map<Serializable, Expense> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Expense> map = new HashMap<Serializable, Expense>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Expense expense = fetchByPrimaryKey(primaryKey);

			if (expense != null) {
				map.put(primaryKey, expense);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Expense)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EXPENSE_WHERE_PKS_IN);

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

			for (Expense expense : (List<Expense>)q.list()) {
				map.put(expense.getPrimaryKeyObj(), expense);

				cacheResult(expense);

				uncachedPrimaryKeys.remove(expense.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseImpl.class, primaryKey, nullModel);
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
	 * Returns all the expenses.
	 *
	 * @return the expenses
	 */
	@Override
	public List<Expense> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of expenses
	 */
	@Override
	public List<Expense> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of expenses
	 */
	@Override
	public List<Expense> findAll(int start, int end,
		OrderByComparator<Expense> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of expenses
	 */
	@Override
	public List<Expense> findAll(int start, int end,
		OrderByComparator<Expense> orderByComparator, boolean retrieveFromCache) {
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

		List<Expense> list = null;

		if (retrieveFromCache) {
			list = (List<Expense>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXPENSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXPENSE;

				if (pagination) {
					sql = sql.concat(ExpenseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Expense>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Expense>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the expenses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Expense expense : findAll()) {
			remove(expense);
		}
	}

	/**
	 * Returns the number of expenses.
	 *
	 * @return the number of expenses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXPENSE);

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
		return ExpenseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the expense persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ExpenseImpl.class.getName());
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
	private static final String _SQL_SELECT_EXPENSE = "SELECT expense FROM Expense expense";
	private static final String _SQL_SELECT_EXPENSE_WHERE_PKS_IN = "SELECT expense FROM Expense expense WHERE expenseId IN (";
	private static final String _SQL_SELECT_EXPENSE_WHERE = "SELECT expense FROM Expense expense WHERE ";
	private static final String _SQL_COUNT_EXPENSE = "SELECT COUNT(expense) FROM Expense expense";
	private static final String _SQL_COUNT_EXPENSE_WHERE = "SELECT COUNT(expense) FROM Expense expense WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "expense.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Expense exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Expense exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ExpensePersistenceImpl.class);
}