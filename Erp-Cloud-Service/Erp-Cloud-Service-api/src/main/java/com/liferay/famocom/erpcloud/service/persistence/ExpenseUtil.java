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

import com.liferay.famocom.erpcloud.model.Expense;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the expense service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ExpensePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ExpensePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ExpensePersistenceImpl
 * @generated
 */
@ProviderType
public class ExpenseUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Expense expense) {
		getPersistence().clearCache(expense);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Expense> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Expense> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Expense> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Expense> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Expense update(Expense expense) {
		return getPersistence().update(expense);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Expense update(Expense expense, ServiceContext serviceContext) {
		return getPersistence().update(expense, serviceContext);
	}

	/**
	* Returns all the expenses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching expenses
	*/
	public static List<Expense> findByempId(long employeeId) {
		return getPersistence().findByempId(employeeId);
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
	public static List<Expense> findByempId(long employeeId, int start, int end) {
		return getPersistence().findByempId(employeeId, start, end);
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
	public static List<Expense> findByempId(long employeeId, int start,
		int end, OrderByComparator<Expense> orderByComparator) {
		return getPersistence()
				   .findByempId(employeeId, start, end, orderByComparator);
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
	public static List<Expense> findByempId(long employeeId, int start,
		int end, OrderByComparator<Expense> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByempId(employeeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first expense in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense
	* @throws NoSuchExpenseException if a matching expense could not be found
	*/
	public static Expense findByempId_First(long employeeId,
		OrderByComparator<Expense> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseException {
		return getPersistence().findByempId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first expense in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense, or <code>null</code> if a matching expense could not be found
	*/
	public static Expense fetchByempId_First(long employeeId,
		OrderByComparator<Expense> orderByComparator) {
		return getPersistence().fetchByempId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last expense in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense
	* @throws NoSuchExpenseException if a matching expense could not be found
	*/
	public static Expense findByempId_Last(long employeeId,
		OrderByComparator<Expense> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseException {
		return getPersistence().findByempId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last expense in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense, or <code>null</code> if a matching expense could not be found
	*/
	public static Expense fetchByempId_Last(long employeeId,
		OrderByComparator<Expense> orderByComparator) {
		return getPersistence().fetchByempId_Last(employeeId, orderByComparator);
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
	public static Expense[] findByempId_PrevAndNext(long expenseId,
		long employeeId, OrderByComparator<Expense> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseException {
		return getPersistence()
				   .findByempId_PrevAndNext(expenseId, employeeId,
			orderByComparator);
	}

	/**
	* Removes all the expenses where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeByempId(long employeeId) {
		getPersistence().removeByempId(employeeId);
	}

	/**
	* Returns the number of expenses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching expenses
	*/
	public static int countByempId(long employeeId) {
		return getPersistence().countByempId(employeeId);
	}

	/**
	* Caches the expense in the entity cache if it is enabled.
	*
	* @param expense the expense
	*/
	public static void cacheResult(Expense expense) {
		getPersistence().cacheResult(expense);
	}

	/**
	* Caches the expenses in the entity cache if it is enabled.
	*
	* @param expenses the expenses
	*/
	public static void cacheResult(List<Expense> expenses) {
		getPersistence().cacheResult(expenses);
	}

	/**
	* Creates a new expense with the primary key. Does not add the expense to the database.
	*
	* @param expenseId the primary key for the new expense
	* @return the new expense
	*/
	public static Expense create(long expenseId) {
		return getPersistence().create(expenseId);
	}

	/**
	* Removes the expense with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseId the primary key of the expense
	* @return the expense that was removed
	* @throws NoSuchExpenseException if a expense with the primary key could not be found
	*/
	public static Expense remove(long expenseId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseException {
		return getPersistence().remove(expenseId);
	}

	public static Expense updateImpl(Expense expense) {
		return getPersistence().updateImpl(expense);
	}

	/**
	* Returns the expense with the primary key or throws a {@link NoSuchExpenseException} if it could not be found.
	*
	* @param expenseId the primary key of the expense
	* @return the expense
	* @throws NoSuchExpenseException if a expense with the primary key could not be found
	*/
	public static Expense findByPrimaryKey(long expenseId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseException {
		return getPersistence().findByPrimaryKey(expenseId);
	}

	/**
	* Returns the expense with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param expenseId the primary key of the expense
	* @return the expense, or <code>null</code> if a expense with the primary key could not be found
	*/
	public static Expense fetchByPrimaryKey(long expenseId) {
		return getPersistence().fetchByPrimaryKey(expenseId);
	}

	public static java.util.Map<java.io.Serializable, Expense> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the expenses.
	*
	* @return the expenses
	*/
	public static List<Expense> findAll() {
		return getPersistence().findAll();
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
	public static List<Expense> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Expense> findAll(int start, int end,
		OrderByComparator<Expense> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Expense> findAll(int start, int end,
		OrderByComparator<Expense> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the expenses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of expenses.
	*
	* @return the number of expenses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExpensePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExpensePersistence, ExpensePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExpensePersistence.class);

		ServiceTracker<ExpensePersistence, ExpensePersistence> serviceTracker = new ServiceTracker<ExpensePersistence, ExpensePersistence>(bundle.getBundleContext(),
				ExpensePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}