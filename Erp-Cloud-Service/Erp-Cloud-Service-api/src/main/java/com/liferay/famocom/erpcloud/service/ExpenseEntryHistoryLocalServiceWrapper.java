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

package com.liferay.famocom.erpcloud.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExpenseEntryHistoryLocalService}.
 *
 * @author Samaresh
 * @see ExpenseEntryHistoryLocalService
 * @generated
 */
@ProviderType
public class ExpenseEntryHistoryLocalServiceWrapper
	implements ExpenseEntryHistoryLocalService,
		ServiceWrapper<ExpenseEntryHistoryLocalService> {
	public ExpenseEntryHistoryLocalServiceWrapper(
		ExpenseEntryHistoryLocalService expenseEntryHistoryLocalService) {
		_expenseEntryHistoryLocalService = expenseEntryHistoryLocalService;
	}

	/**
	* Adds the expense entry history to the database. Also notifies the appropriate model listeners.
	*
	* @param expenseEntryHistory the expense entry history
	* @return the expense entry history that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpenseEntryHistory addExpenseEntryHistory(
		com.liferay.famocom.erpcloud.model.ExpenseEntryHistory expenseEntryHistory) {
		return _expenseEntryHistoryLocalService.addExpenseEntryHistory(expenseEntryHistory);
	}

	/**
	* Creates a new expense entry history with the primary key. Does not add the expense entry history to the database.
	*
	* @param expenseHistoryId the primary key for the new expense entry history
	* @return the new expense entry history
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpenseEntryHistory createExpenseEntryHistory(
		long expenseHistoryId) {
		return _expenseEntryHistoryLocalService.createExpenseEntryHistory(expenseHistoryId);
	}

	/**
	* Deletes the expense entry history from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseEntryHistory the expense entry history
	* @return the expense entry history that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpenseEntryHistory deleteExpenseEntryHistory(
		com.liferay.famocom.erpcloud.model.ExpenseEntryHistory expenseEntryHistory) {
		return _expenseEntryHistoryLocalService.deleteExpenseEntryHistory(expenseEntryHistory);
	}

	/**
	* Deletes the expense entry history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseHistoryId the primary key of the expense entry history
	* @return the expense entry history that was removed
	* @throws PortalException if a expense entry history with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpenseEntryHistory deleteExpenseEntryHistory(
		long expenseHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expenseEntryHistoryLocalService.deleteExpenseEntryHistory(expenseHistoryId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expenseEntryHistoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _expenseEntryHistoryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _expenseEntryHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpenseEntryHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _expenseEntryHistoryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpenseEntryHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _expenseEntryHistoryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _expenseEntryHistoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _expenseEntryHistoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.ExpenseEntryHistory fetchExpenseEntryHistory(
		long expenseHistoryId) {
		return _expenseEntryHistoryLocalService.fetchExpenseEntryHistory(expenseHistoryId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ExpenseEntryHistory> findByExpenceId(
		long expenceId) {
		return _expenseEntryHistoryLocalService.findByExpenceId(expenceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _expenseEntryHistoryLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns a range of all the expense entry histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpenseEntryHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of expense entry histories
	* @param end the upper bound of the range of expense entry histories (not inclusive)
	* @return the range of expense entry histories
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ExpenseEntryHistory> getExpenseEntryHistories(
		int start, int end) {
		return _expenseEntryHistoryLocalService.getExpenseEntryHistories(start,
			end);
	}

	/**
	* Returns the number of expense entry histories.
	*
	* @return the number of expense entry histories
	*/
	@Override
	public int getExpenseEntryHistoriesCount() {
		return _expenseEntryHistoryLocalService.getExpenseEntryHistoriesCount();
	}

	/**
	* Returns the expense entry history with the primary key.
	*
	* @param expenseHistoryId the primary key of the expense entry history
	* @return the expense entry history
	* @throws PortalException if a expense entry history with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpenseEntryHistory getExpenseEntryHistory(
		long expenseHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expenseEntryHistoryLocalService.getExpenseEntryHistory(expenseHistoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _expenseEntryHistoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _expenseEntryHistoryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expenseEntryHistoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the expense entry history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param expenseEntryHistory the expense entry history
	* @return the expense entry history that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpenseEntryHistory updateExpenseEntryHistory(
		com.liferay.famocom.erpcloud.model.ExpenseEntryHistory expenseEntryHistory) {
		return _expenseEntryHistoryLocalService.updateExpenseEntryHistory(expenseEntryHistory);
	}

	@Override
	public ExpenseEntryHistoryLocalService getWrappedService() {
		return _expenseEntryHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		ExpenseEntryHistoryLocalService expenseEntryHistoryLocalService) {
		_expenseEntryHistoryLocalService = expenseEntryHistoryLocalService;
	}

	private ExpenseEntryHistoryLocalService _expenseEntryHistoryLocalService;
}