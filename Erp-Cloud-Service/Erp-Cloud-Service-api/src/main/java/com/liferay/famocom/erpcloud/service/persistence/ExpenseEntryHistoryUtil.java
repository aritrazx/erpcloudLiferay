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

import com.liferay.famocom.erpcloud.model.ExpenseEntryHistory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the expense entry history service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ExpenseEntryHistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ExpenseEntryHistoryPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ExpenseEntryHistoryPersistenceImpl
 * @generated
 */
@ProviderType
public class ExpenseEntryHistoryUtil {
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
	public static void clearCache(ExpenseEntryHistory expenseEntryHistory) {
		getPersistence().clearCache(expenseEntryHistory);
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
	public static List<ExpenseEntryHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExpenseEntryHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExpenseEntryHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExpenseEntryHistory> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExpenseEntryHistory update(
		ExpenseEntryHistory expenseEntryHistory) {
		return getPersistence().update(expenseEntryHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExpenseEntryHistory update(
		ExpenseEntryHistory expenseEntryHistory, ServiceContext serviceContext) {
		return getPersistence().update(expenseEntryHistory, serviceContext);
	}

	/**
	* Returns all the expense entry histories where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @return the matching expense entry histories
	*/
	public static List<ExpenseEntryHistory> findByExpenceId(long expenseId) {
		return getPersistence().findByExpenceId(expenseId);
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
	public static List<ExpenseEntryHistory> findByExpenceId(long expenseId,
		int start, int end) {
		return getPersistence().findByExpenceId(expenseId, start, end);
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
	public static List<ExpenseEntryHistory> findByExpenceId(long expenseId,
		int start, int end,
		OrderByComparator<ExpenseEntryHistory> orderByComparator) {
		return getPersistence()
				   .findByExpenceId(expenseId, start, end, orderByComparator);
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
	public static List<ExpenseEntryHistory> findByExpenceId(long expenseId,
		int start, int end,
		OrderByComparator<ExpenseEntryHistory> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByExpenceId(expenseId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first expense entry history in the ordered set where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense entry history
	* @throws NoSuchExpenseEntryHistoryException if a matching expense entry history could not be found
	*/
	public static ExpenseEntryHistory findByExpenceId_First(long expenseId,
		OrderByComparator<ExpenseEntryHistory> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryHistoryException {
		return getPersistence()
				   .findByExpenceId_First(expenseId, orderByComparator);
	}

	/**
	* Returns the first expense entry history in the ordered set where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense entry history, or <code>null</code> if a matching expense entry history could not be found
	*/
	public static ExpenseEntryHistory fetchByExpenceId_First(long expenseId,
		OrderByComparator<ExpenseEntryHistory> orderByComparator) {
		return getPersistence()
				   .fetchByExpenceId_First(expenseId, orderByComparator);
	}

	/**
	* Returns the last expense entry history in the ordered set where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense entry history
	* @throws NoSuchExpenseEntryHistoryException if a matching expense entry history could not be found
	*/
	public static ExpenseEntryHistory findByExpenceId_Last(long expenseId,
		OrderByComparator<ExpenseEntryHistory> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryHistoryException {
		return getPersistence()
				   .findByExpenceId_Last(expenseId, orderByComparator);
	}

	/**
	* Returns the last expense entry history in the ordered set where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense entry history, or <code>null</code> if a matching expense entry history could not be found
	*/
	public static ExpenseEntryHistory fetchByExpenceId_Last(long expenseId,
		OrderByComparator<ExpenseEntryHistory> orderByComparator) {
		return getPersistence()
				   .fetchByExpenceId_Last(expenseId, orderByComparator);
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
	public static ExpenseEntryHistory[] findByExpenceId_PrevAndNext(
		long expenseHistoryId, long expenseId,
		OrderByComparator<ExpenseEntryHistory> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryHistoryException {
		return getPersistence()
				   .findByExpenceId_PrevAndNext(expenseHistoryId, expenseId,
			orderByComparator);
	}

	/**
	* Removes all the expense entry histories where expenseId = &#63; from the database.
	*
	* @param expenseId the expense ID
	*/
	public static void removeByExpenceId(long expenseId) {
		getPersistence().removeByExpenceId(expenseId);
	}

	/**
	* Returns the number of expense entry histories where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @return the number of matching expense entry histories
	*/
	public static int countByExpenceId(long expenseId) {
		return getPersistence().countByExpenceId(expenseId);
	}

	/**
	* Caches the expense entry history in the entity cache if it is enabled.
	*
	* @param expenseEntryHistory the expense entry history
	*/
	public static void cacheResult(ExpenseEntryHistory expenseEntryHistory) {
		getPersistence().cacheResult(expenseEntryHistory);
	}

	/**
	* Caches the expense entry histories in the entity cache if it is enabled.
	*
	* @param expenseEntryHistories the expense entry histories
	*/
	public static void cacheResult(
		List<ExpenseEntryHistory> expenseEntryHistories) {
		getPersistence().cacheResult(expenseEntryHistories);
	}

	/**
	* Creates a new expense entry history with the primary key. Does not add the expense entry history to the database.
	*
	* @param expenseHistoryId the primary key for the new expense entry history
	* @return the new expense entry history
	*/
	public static ExpenseEntryHistory create(long expenseHistoryId) {
		return getPersistence().create(expenseHistoryId);
	}

	/**
	* Removes the expense entry history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseHistoryId the primary key of the expense entry history
	* @return the expense entry history that was removed
	* @throws NoSuchExpenseEntryHistoryException if a expense entry history with the primary key could not be found
	*/
	public static ExpenseEntryHistory remove(long expenseHistoryId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryHistoryException {
		return getPersistence().remove(expenseHistoryId);
	}

	public static ExpenseEntryHistory updateImpl(
		ExpenseEntryHistory expenseEntryHistory) {
		return getPersistence().updateImpl(expenseEntryHistory);
	}

	/**
	* Returns the expense entry history with the primary key or throws a {@link NoSuchExpenseEntryHistoryException} if it could not be found.
	*
	* @param expenseHistoryId the primary key of the expense entry history
	* @return the expense entry history
	* @throws NoSuchExpenseEntryHistoryException if a expense entry history with the primary key could not be found
	*/
	public static ExpenseEntryHistory findByPrimaryKey(long expenseHistoryId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryHistoryException {
		return getPersistence().findByPrimaryKey(expenseHistoryId);
	}

	/**
	* Returns the expense entry history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param expenseHistoryId the primary key of the expense entry history
	* @return the expense entry history, or <code>null</code> if a expense entry history with the primary key could not be found
	*/
	public static ExpenseEntryHistory fetchByPrimaryKey(long expenseHistoryId) {
		return getPersistence().fetchByPrimaryKey(expenseHistoryId);
	}

	public static java.util.Map<java.io.Serializable, ExpenseEntryHistory> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the expense entry histories.
	*
	* @return the expense entry histories
	*/
	public static List<ExpenseEntryHistory> findAll() {
		return getPersistence().findAll();
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
	public static List<ExpenseEntryHistory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ExpenseEntryHistory> findAll(int start, int end,
		OrderByComparator<ExpenseEntryHistory> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ExpenseEntryHistory> findAll(int start, int end,
		OrderByComparator<ExpenseEntryHistory> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the expense entry histories from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of expense entry histories.
	*
	* @return the number of expense entry histories
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExpenseEntryHistoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExpenseEntryHistoryPersistence, ExpenseEntryHistoryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExpenseEntryHistoryPersistence.class);

		ServiceTracker<ExpenseEntryHistoryPersistence, ExpenseEntryHistoryPersistence> serviceTracker =
			new ServiceTracker<ExpenseEntryHistoryPersistence, ExpenseEntryHistoryPersistence>(bundle.getBundleContext(),
				ExpenseEntryHistoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}