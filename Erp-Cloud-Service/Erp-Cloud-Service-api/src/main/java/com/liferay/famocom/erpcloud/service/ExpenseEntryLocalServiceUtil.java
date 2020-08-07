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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ExpenseEntry. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.ExpenseEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see ExpenseEntryLocalService
 * @see com.liferay.famocom.erpcloud.service.base.ExpenseEntryLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.ExpenseEntryLocalServiceImpl
 * @generated
 */
@ProviderType
public class ExpenseEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.ExpenseEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the expense entry to the database. Also notifies the appropriate model listeners.
	*
	* @param expenseEntry the expense entry
	* @return the expense entry that was added
	*/
	public static com.liferay.famocom.erpcloud.model.ExpenseEntry addExpenseEntry(
		com.liferay.famocom.erpcloud.model.ExpenseEntry expenseEntry) {
		return getService().addExpenseEntry(expenseEntry);
	}

	/**
	* Creates a new expense entry with the primary key. Does not add the expense entry to the database.
	*
	* @param expenseId the primary key for the new expense entry
	* @return the new expense entry
	*/
	public static com.liferay.famocom.erpcloud.model.ExpenseEntry createExpenseEntry(
		long expenseId) {
		return getService().createExpenseEntry(expenseId);
	}

	/**
	* Deletes the expense entry from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseEntry the expense entry
	* @return the expense entry that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.ExpenseEntry deleteExpenseEntry(
		com.liferay.famocom.erpcloud.model.ExpenseEntry expenseEntry) {
		return getService().deleteExpenseEntry(expenseEntry);
	}

	/**
	* Deletes the expense entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseId the primary key of the expense entry
	* @return the expense entry that was removed
	* @throws PortalException if a expense entry with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.ExpenseEntry deleteExpenseEntry(
		long expenseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteExpenseEntry(expenseId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.famocom.erpcloud.model.ExpenseEntry fetchExpenseEntry(
		long expenseId) {
		return getService().fetchExpenseEntry(expenseId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.ExpenseEntry> findByUserId(
		long userId) {
		return getService().findByUserId(userId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns a range of all the expense entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpenseEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of expense entries
	* @param end the upper bound of the range of expense entries (not inclusive)
	* @return the range of expense entries
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.ExpenseEntry> getExpenseEntries(
		int start, int end) {
		return getService().getExpenseEntries(start, end);
	}

	/**
	* Returns the number of expense entries.
	*
	* @return the number of expense entries
	*/
	public static int getExpenseEntriesCount() {
		return getService().getExpenseEntriesCount();
	}

	/**
	* Returns the expense entry with the primary key.
	*
	* @param expenseId the primary key of the expense entry
	* @return the expense entry
	* @throws PortalException if a expense entry with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.ExpenseEntry getExpenseEntry(
		long expenseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getExpenseEntry(expenseId);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.Map<String, String> getReimbursementFileUpload(
		String name, java.io.File file, long userId, String donaminName)
		throws java.io.IOException,
			com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getReimbursementFileUpload(name, file, userId, donaminName);
	}

	public static java.util.List<String> removeExpenseEntry(long expenseId) {
		return getService().removeExpenseEntry(expenseId);
	}

	/**
	* Updates the expense entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param expenseEntry the expense entry
	* @return the expense entry that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.ExpenseEntry updateExpenseEntry(
		com.liferay.famocom.erpcloud.model.ExpenseEntry expenseEntry) {
		return getService().updateExpenseEntry(expenseEntry);
	}

	public static java.util.List<String> updateExpenseEntry(long expenseId,
		long userId, long projectId, long catId, String title,
		String description, String expDate, Double amount, String name,
		String strImage, int status, String donaminName) {
		return getService()
				   .updateExpenseEntry(expenseId, userId, projectId, catId,
			title, description, expDate, amount, name, strImage, status,
			donaminName);
	}

	public static ExpenseEntryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExpenseEntryLocalService, ExpenseEntryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExpenseEntryLocalService.class);

		ServiceTracker<ExpenseEntryLocalService, ExpenseEntryLocalService> serviceTracker =
			new ServiceTracker<ExpenseEntryLocalService, ExpenseEntryLocalService>(bundle.getBundleContext(),
				ExpenseEntryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}