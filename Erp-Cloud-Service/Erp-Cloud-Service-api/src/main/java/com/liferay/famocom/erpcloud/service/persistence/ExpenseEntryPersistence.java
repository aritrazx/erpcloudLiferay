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

import com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryException;
import com.liferay.famocom.erpcloud.model.ExpenseEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the expense entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ExpenseEntryPersistenceImpl
 * @see ExpenseEntryUtil
 * @generated
 */
@ProviderType
public interface ExpenseEntryPersistence extends BasePersistence<ExpenseEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExpenseEntryUtil} to access the expense entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the expense entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching expense entries
	*/
	public java.util.List<ExpenseEntry> findByuserId(long userId);

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
	public java.util.List<ExpenseEntry> findByuserId(long userId, int start,
		int end);

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
	public java.util.List<ExpenseEntry> findByuserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator);

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
	public java.util.List<ExpenseEntry> findByuserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first expense entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense entry
	* @throws NoSuchExpenseEntryException if a matching expense entry could not be found
	*/
	public ExpenseEntry findByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException;

	/**
	* Returns the first expense entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense entry, or <code>null</code> if a matching expense entry could not be found
	*/
	public ExpenseEntry fetchByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator);

	/**
	* Returns the last expense entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense entry
	* @throws NoSuchExpenseEntryException if a matching expense entry could not be found
	*/
	public ExpenseEntry findByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException;

	/**
	* Returns the last expense entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense entry, or <code>null</code> if a matching expense entry could not be found
	*/
	public ExpenseEntry fetchByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator);

	/**
	* Returns the expense entries before and after the current expense entry in the ordered set where userId = &#63;.
	*
	* @param expenseId the primary key of the current expense entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next expense entry
	* @throws NoSuchExpenseEntryException if a expense entry with the primary key could not be found
	*/
	public ExpenseEntry[] findByuserId_PrevAndNext(long expenseId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException;

	/**
	* Removes all the expense entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByuserId(long userId);

	/**
	* Returns the number of expense entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching expense entries
	*/
	public int countByuserId(long userId);

	/**
	* Returns all the expense entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching expense entries
	*/
	public java.util.List<ExpenseEntry> findBystatus(long groupId, int status);

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
	public java.util.List<ExpenseEntry> findBystatus(long groupId, int status,
		int start, int end);

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
	public java.util.List<ExpenseEntry> findBystatus(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator);

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
	public java.util.List<ExpenseEntry> findBystatus(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first expense entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense entry
	* @throws NoSuchExpenseEntryException if a matching expense entry could not be found
	*/
	public ExpenseEntry findBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException;

	/**
	* Returns the first expense entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense entry, or <code>null</code> if a matching expense entry could not be found
	*/
	public ExpenseEntry fetchBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator);

	/**
	* Returns the last expense entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense entry
	* @throws NoSuchExpenseEntryException if a matching expense entry could not be found
	*/
	public ExpenseEntry findBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException;

	/**
	* Returns the last expense entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense entry, or <code>null</code> if a matching expense entry could not be found
	*/
	public ExpenseEntry fetchBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator);

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
	public ExpenseEntry[] findBystatus_PrevAndNext(long expenseId,
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator)
		throws NoSuchExpenseEntryException;

	/**
	* Removes all the expense entries where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeBystatus(long groupId, int status);

	/**
	* Returns the number of expense entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching expense entries
	*/
	public int countBystatus(long groupId, int status);

	/**
	* Caches the expense entry in the entity cache if it is enabled.
	*
	* @param expenseEntry the expense entry
	*/
	public void cacheResult(ExpenseEntry expenseEntry);

	/**
	* Caches the expense entries in the entity cache if it is enabled.
	*
	* @param expenseEntries the expense entries
	*/
	public void cacheResult(java.util.List<ExpenseEntry> expenseEntries);

	/**
	* Creates a new expense entry with the primary key. Does not add the expense entry to the database.
	*
	* @param expenseId the primary key for the new expense entry
	* @return the new expense entry
	*/
	public ExpenseEntry create(long expenseId);

	/**
	* Removes the expense entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseId the primary key of the expense entry
	* @return the expense entry that was removed
	* @throws NoSuchExpenseEntryException if a expense entry with the primary key could not be found
	*/
	public ExpenseEntry remove(long expenseId)
		throws NoSuchExpenseEntryException;

	public ExpenseEntry updateImpl(ExpenseEntry expenseEntry);

	/**
	* Returns the expense entry with the primary key or throws a {@link NoSuchExpenseEntryException} if it could not be found.
	*
	* @param expenseId the primary key of the expense entry
	* @return the expense entry
	* @throws NoSuchExpenseEntryException if a expense entry with the primary key could not be found
	*/
	public ExpenseEntry findByPrimaryKey(long expenseId)
		throws NoSuchExpenseEntryException;

	/**
	* Returns the expense entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param expenseId the primary key of the expense entry
	* @return the expense entry, or <code>null</code> if a expense entry with the primary key could not be found
	*/
	public ExpenseEntry fetchByPrimaryKey(long expenseId);

	@Override
	public java.util.Map<java.io.Serializable, ExpenseEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the expense entries.
	*
	* @return the expense entries
	*/
	public java.util.List<ExpenseEntry> findAll();

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
	public java.util.List<ExpenseEntry> findAll(int start, int end);

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
	public java.util.List<ExpenseEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator);

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
	public java.util.List<ExpenseEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the expense entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of expense entries.
	*
	* @return the number of expense entries
	*/
	public int countAll();
}