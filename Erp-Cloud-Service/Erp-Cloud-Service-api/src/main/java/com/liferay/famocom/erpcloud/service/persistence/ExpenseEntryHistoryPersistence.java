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

import com.liferay.famocom.erpcloud.exception.NoSuchExpenseEntryHistoryException;
import com.liferay.famocom.erpcloud.model.ExpenseEntryHistory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the expense entry history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ExpenseEntryHistoryPersistenceImpl
 * @see ExpenseEntryHistoryUtil
 * @generated
 */
@ProviderType
public interface ExpenseEntryHistoryPersistence extends BasePersistence<ExpenseEntryHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExpenseEntryHistoryUtil} to access the expense entry history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the expense entry histories where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @return the matching expense entry histories
	*/
	public java.util.List<ExpenseEntryHistory> findByExpenceId(long expenseId);

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
	public java.util.List<ExpenseEntryHistory> findByExpenceId(long expenseId,
		int start, int end);

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
	public java.util.List<ExpenseEntryHistory> findByExpenceId(long expenseId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntryHistory> orderByComparator);

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
	public java.util.List<ExpenseEntryHistory> findByExpenceId(long expenseId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntryHistory> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first expense entry history in the ordered set where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense entry history
	* @throws NoSuchExpenseEntryHistoryException if a matching expense entry history could not be found
	*/
	public ExpenseEntryHistory findByExpenceId_First(long expenseId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntryHistory> orderByComparator)
		throws NoSuchExpenseEntryHistoryException;

	/**
	* Returns the first expense entry history in the ordered set where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expense entry history, or <code>null</code> if a matching expense entry history could not be found
	*/
	public ExpenseEntryHistory fetchByExpenceId_First(long expenseId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntryHistory> orderByComparator);

	/**
	* Returns the last expense entry history in the ordered set where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense entry history
	* @throws NoSuchExpenseEntryHistoryException if a matching expense entry history could not be found
	*/
	public ExpenseEntryHistory findByExpenceId_Last(long expenseId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntryHistory> orderByComparator)
		throws NoSuchExpenseEntryHistoryException;

	/**
	* Returns the last expense entry history in the ordered set where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expense entry history, or <code>null</code> if a matching expense entry history could not be found
	*/
	public ExpenseEntryHistory fetchByExpenceId_Last(long expenseId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntryHistory> orderByComparator);

	/**
	* Returns the expense entry histories before and after the current expense entry history in the ordered set where expenseId = &#63;.
	*
	* @param expenseHistoryId the primary key of the current expense entry history
	* @param expenseId the expense ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next expense entry history
	* @throws NoSuchExpenseEntryHistoryException if a expense entry history with the primary key could not be found
	*/
	public ExpenseEntryHistory[] findByExpenceId_PrevAndNext(
		long expenseHistoryId, long expenseId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntryHistory> orderByComparator)
		throws NoSuchExpenseEntryHistoryException;

	/**
	* Removes all the expense entry histories where expenseId = &#63; from the database.
	*
	* @param expenseId the expense ID
	*/
	public void removeByExpenceId(long expenseId);

	/**
	* Returns the number of expense entry histories where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @return the number of matching expense entry histories
	*/
	public int countByExpenceId(long expenseId);

	/**
	* Caches the expense entry history in the entity cache if it is enabled.
	*
	* @param expenseEntryHistory the expense entry history
	*/
	public void cacheResult(ExpenseEntryHistory expenseEntryHistory);

	/**
	* Caches the expense entry histories in the entity cache if it is enabled.
	*
	* @param expenseEntryHistories the expense entry histories
	*/
	public void cacheResult(
		java.util.List<ExpenseEntryHistory> expenseEntryHistories);

	/**
	* Creates a new expense entry history with the primary key. Does not add the expense entry history to the database.
	*
	* @param expenseHistoryId the primary key for the new expense entry history
	* @return the new expense entry history
	*/
	public ExpenseEntryHistory create(long expenseHistoryId);

	/**
	* Removes the expense entry history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseHistoryId the primary key of the expense entry history
	* @return the expense entry history that was removed
	* @throws NoSuchExpenseEntryHistoryException if a expense entry history with the primary key could not be found
	*/
	public ExpenseEntryHistory remove(long expenseHistoryId)
		throws NoSuchExpenseEntryHistoryException;

	public ExpenseEntryHistory updateImpl(
		ExpenseEntryHistory expenseEntryHistory);

	/**
	* Returns the expense entry history with the primary key or throws a {@link NoSuchExpenseEntryHistoryException} if it could not be found.
	*
	* @param expenseHistoryId the primary key of the expense entry history
	* @return the expense entry history
	* @throws NoSuchExpenseEntryHistoryException if a expense entry history with the primary key could not be found
	*/
	public ExpenseEntryHistory findByPrimaryKey(long expenseHistoryId)
		throws NoSuchExpenseEntryHistoryException;

	/**
	* Returns the expense entry history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param expenseHistoryId the primary key of the expense entry history
	* @return the expense entry history, or <code>null</code> if a expense entry history with the primary key could not be found
	*/
	public ExpenseEntryHistory fetchByPrimaryKey(long expenseHistoryId);

	@Override
	public java.util.Map<java.io.Serializable, ExpenseEntryHistory> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the expense entry histories.
	*
	* @return the expense entry histories
	*/
	public java.util.List<ExpenseEntryHistory> findAll();

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
	public java.util.List<ExpenseEntryHistory> findAll(int start, int end);

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
	public java.util.List<ExpenseEntryHistory> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntryHistory> orderByComparator);

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
	public java.util.List<ExpenseEntryHistory> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseEntryHistory> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the expense entry histories from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of expense entry histories.
	*
	* @return the number of expense entry histories
	*/
	public int countAll();
}