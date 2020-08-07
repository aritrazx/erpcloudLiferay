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

import com.liferay.famocom.erpcloud.model.ExpenseEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the expense entry service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ExpenseEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ExpenseEntryPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ExpenseEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class ExpenseEntryUtil {
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
	public static void clearCache(ExpenseEntry expenseEntry) {
		getPersistence().clearCache(expenseEntry);
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
	public static List<ExpenseEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExpenseEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExpenseEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExpenseEntry update(ExpenseEntry expenseEntry) {
		return getPersistence().update(expenseEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExpenseEntry update(ExpenseEntry expenseEntry,
		ServiceContext serviceContext) {
		return getPersistence().update(expenseEntry, serviceContext);
	}

	/**
	* Returns all the expense entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching expense entries
	*/
	public static List<ExpenseEntry> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
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
	public static List<ExpenseEntry> findByuserId(long userId, int start,
		int end) {
		return getPersistence().findByuserId(userId, start, end);
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
	public static List<ExpenseEntry> findByuserId(long userId, int start,
		int end, OrderByComparator<ExpenseEntry> orderByComparator) {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator);
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
	public static List<ExpenseEntry> findByuserId(long userId, int start,
		int end, OrderByComparator<ExpenseEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first expense entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense entry
	* @throws NoSuchExpenseEntryException if a matching expense entry could not be found
	*/
	public static ExpenseEntry findByuserId_First(long userId,
		OrderByComparator<ExpenseEntry> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryException {
		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first expense entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense entry, or <code>null</code> if a matching expense entry could not be found
	*/
	public static ExpenseEntry fetchByuserId_First(long userId,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last expense entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense entry
	* @throws NoSuchExpenseEntryException if a matching expense entry could not be found
	*/
	public static ExpenseEntry findByuserId_Last(long userId,
		OrderByComparator<ExpenseEntry> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryException {
		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last expense entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense entry, or <code>null</code> if a matching expense entry could not be found
	*/
	public static ExpenseEntry fetchByuserId_Last(long userId,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
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
	public static ExpenseEntry[] findByuserId_PrevAndNext(long expenseId,
		long userId, OrderByComparator<ExpenseEntry> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryException {
		return getPersistence()
				   .findByuserId_PrevAndNext(expenseId, userId,
			orderByComparator);
	}

	/**
	* Removes all the expense entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of expense entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching expense entries
	*/
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Returns all the expense entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching expense entries
	*/
	public static List<ExpenseEntry> findBystatus(long groupId, int status) {
		return getPersistence().findBystatus(groupId, status);
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
	public static List<ExpenseEntry> findBystatus(long groupId, int status,
		int start, int end) {
		return getPersistence().findBystatus(groupId, status, start, end);
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
	public static List<ExpenseEntry> findBystatus(long groupId, int status,
		int start, int end, OrderByComparator<ExpenseEntry> orderByComparator) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end, orderByComparator);
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
	public static List<ExpenseEntry> findBystatus(long groupId, int status,
		int start, int end, OrderByComparator<ExpenseEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end,
			orderByComparator, retrieveFromCache);
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
	public static ExpenseEntry findBystatus_First(long groupId, int status,
		OrderByComparator<ExpenseEntry> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryException {
		return getPersistence()
				   .findBystatus_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the first expense entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense entry, or <code>null</code> if a matching expense entry could not be found
	*/
	public static ExpenseEntry fetchBystatus_First(long groupId, int status,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_First(groupId, status, orderByComparator);
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
	public static ExpenseEntry findBystatus_Last(long groupId, int status,
		OrderByComparator<ExpenseEntry> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryException {
		return getPersistence()
				   .findBystatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last expense entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense entry, or <code>null</code> if a matching expense entry could not be found
	*/
	public static ExpenseEntry fetchBystatus_Last(long groupId, int status,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_Last(groupId, status, orderByComparator);
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
	public static ExpenseEntry[] findBystatus_PrevAndNext(long expenseId,
		long groupId, int status,
		OrderByComparator<ExpenseEntry> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryException {
		return getPersistence()
				   .findBystatus_PrevAndNext(expenseId, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the expense entries where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public static void removeBystatus(long groupId, int status) {
		getPersistence().removeBystatus(groupId, status);
	}

	/**
	* Returns the number of expense entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching expense entries
	*/
	public static int countBystatus(long groupId, int status) {
		return getPersistence().countBystatus(groupId, status);
	}

	/**
	* Caches the expense entry in the entity cache if it is enabled.
	*
	* @param expenseEntry the expense entry
	*/
	public static void cacheResult(ExpenseEntry expenseEntry) {
		getPersistence().cacheResult(expenseEntry);
	}

	/**
	* Caches the expense entries in the entity cache if it is enabled.
	*
	* @param expenseEntries the expense entries
	*/
	public static void cacheResult(List<ExpenseEntry> expenseEntries) {
		getPersistence().cacheResult(expenseEntries);
	}

	/**
	* Creates a new expense entry with the primary key. Does not add the expense entry to the database.
	*
	* @param expenseId the primary key for the new expense entry
	* @return the new expense entry
	*/
	public static ExpenseEntry create(long expenseId) {
		return getPersistence().create(expenseId);
	}

	/**
	* Removes the expense entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseId the primary key of the expense entry
	* @return the expense entry that was removed
	* @throws NoSuchExpenseEntryException if a expense entry with the primary key could not be found
	*/
	public static ExpenseEntry remove(long expenseId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryException {
		return getPersistence().remove(expenseId);
	}

	public static ExpenseEntry updateImpl(ExpenseEntry expenseEntry) {
		return getPersistence().updateImpl(expenseEntry);
	}

	/**
	* Returns the expense entry with the primary key or throws a {@link NoSuchExpenseEntryException} if it could not be found.
	*
	* @param expenseId the primary key of the expense entry
	* @return the expense entry
	* @throws NoSuchExpenseEntryException if a expense entry with the primary key could not be found
	*/
	public static ExpenseEntry findByPrimaryKey(long expenseId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryException {
		return getPersistence().findByPrimaryKey(expenseId);
	}

	/**
	* Returns the expense entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param expenseId the primary key of the expense entry
	* @return the expense entry, or <code>null</code> if a expense entry with the primary key could not be found
	*/
	public static ExpenseEntry fetchByPrimaryKey(long expenseId) {
		return getPersistence().fetchByPrimaryKey(expenseId);
	}

	public static java.util.Map<java.io.Serializable, ExpenseEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the expense entries.
	*
	* @return the expense entries
	*/
	public static List<ExpenseEntry> findAll() {
		return getPersistence().findAll();
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
	public static List<ExpenseEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ExpenseEntry> findAll(int start, int end,
		OrderByComparator<ExpenseEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ExpenseEntry> findAll(int start, int end,
		OrderByComparator<ExpenseEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the expense entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of expense entries.
	*
	* @return the number of expense entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExpenseEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExpenseEntryPersistence, ExpenseEntryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExpenseEntryPersistence.class);

		ServiceTracker<ExpenseEntryPersistence, ExpenseEntryPersistence> serviceTracker =
			new ServiceTracker<ExpenseEntryPersistence, ExpenseEntryPersistence>(bundle.getBundleContext(),
				ExpenseEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}