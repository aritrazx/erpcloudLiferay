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

package com.liferay.famocom.erpcloud.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.exception.NoSuchExpenseException;
import com.liferay.famocom.erpcloud.model.Expense;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the expense service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ExpensePersistenceImpl
 * @see ExpenseUtil
 * @generated
 */
@ProviderType
public interface ExpensePersistence extends BasePersistence<Expense> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExpenseUtil} to access the expense persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the expenses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching expenses
	*/
	public java.util.List<Expense> findByempId(long employeeId);

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
	public java.util.List<Expense> findByempId(long employeeId, int start,
		int end);

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
	public java.util.List<Expense> findByempId(long employeeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense> orderByComparator);

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
	public java.util.List<Expense> findByempId(long employeeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first expense in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense
	* @throws NoSuchExpenseException if a matching expense could not be found
	*/
	public Expense findByempId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Expense> orderByComparator)
		throws NoSuchExpenseException;

	/**
	* Returns the first expense in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense, or <code>null</code> if a matching expense could not be found
	*/
	public Expense fetchByempId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Expense> orderByComparator);

	/**
	* Returns the last expense in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense
	* @throws NoSuchExpenseException if a matching expense could not be found
	*/
	public Expense findByempId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Expense> orderByComparator)
		throws NoSuchExpenseException;

	/**
	* Returns the last expense in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense, or <code>null</code> if a matching expense could not be found
	*/
	public Expense fetchByempId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Expense> orderByComparator);

	/**
	* Returns the expenses before and after the current expense in the ordered set where employeeId = &#63;.
	*
	* @param expenseId the primary key of the current expense
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next expense
	* @throws NoSuchExpenseException if a expense with the primary key could not be found
	*/
	public Expense[] findByempId_PrevAndNext(long expenseId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Expense> orderByComparator)
		throws NoSuchExpenseException;

	/**
	* Removes all the expenses where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeByempId(long employeeId);

	/**
	* Returns the number of expenses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching expenses
	*/
	public int countByempId(long employeeId);

	/**
	* Caches the expense in the entity cache if it is enabled.
	*
	* @param expense the expense
	*/
	public void cacheResult(Expense expense);

	/**
	* Caches the expenses in the entity cache if it is enabled.
	*
	* @param expenses the expenses
	*/
	public void cacheResult(java.util.List<Expense> expenses);

	/**
	* Creates a new expense with the primary key. Does not add the expense to the database.
	*
	* @param expenseId the primary key for the new expense
	* @return the new expense
	*/
	public Expense create(long expenseId);

	/**
	* Removes the expense with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseId the primary key of the expense
	* @return the expense that was removed
	* @throws NoSuchExpenseException if a expense with the primary key could not be found
	*/
	public Expense remove(long expenseId) throws NoSuchExpenseException;

	public Expense updateImpl(Expense expense);

	/**
	* Returns the expense with the primary key or throws a {@link NoSuchExpenseException} if it could not be found.
	*
	* @param expenseId the primary key of the expense
	* @return the expense
	* @throws NoSuchExpenseException if a expense with the primary key could not be found
	*/
	public Expense findByPrimaryKey(long expenseId)
		throws NoSuchExpenseException;

	/**
	* Returns the expense with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param expenseId the primary key of the expense
	* @return the expense, or <code>null</code> if a expense with the primary key could not be found
	*/
	public Expense fetchByPrimaryKey(long expenseId);

	@Override
	public java.util.Map<java.io.Serializable, Expense> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the expenses.
	*
	* @return the expenses
	*/
	public java.util.List<Expense> findAll();

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
	public java.util.List<Expense> findAll(int start, int end);

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
	public java.util.List<Expense> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense> orderByComparator);

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
	public java.util.List<Expense> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the expenses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of expenses.
	*
	* @return the number of expenses
	*/
	public int countAll();
}