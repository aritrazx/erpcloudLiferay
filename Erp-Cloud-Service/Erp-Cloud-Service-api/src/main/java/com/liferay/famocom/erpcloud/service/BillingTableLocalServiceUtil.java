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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for BillingTable. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.BillingTableLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see BillingTableLocalService
 * @see com.liferay.famocom.erpcloud.service.base.BillingTableLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.BillingTableLocalServiceImpl
 * @generated
 */
@ProviderType
public class BillingTableLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.BillingTableLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the billing table to the database. Also notifies the appropriate model listeners.
	*
	* @param billingTable the billing table
	* @return the billing table that was added
	*/
	public static com.liferay.famocom.erpcloud.model.BillingTable addBillingTable(
		com.liferay.famocom.erpcloud.model.BillingTable billingTable) {
		return getService().addBillingTable(billingTable);
	}

	/**
	* Creates a new billing table with the primary key. Does not add the billing table to the database.
	*
	* @param billingId the primary key for the new billing table
	* @return the new billing table
	*/
	public static com.liferay.famocom.erpcloud.model.BillingTable createBillingTable(
		long billingId) {
		return getService().createBillingTable(billingId);
	}

	/**
	* Deletes the billing table from the database. Also notifies the appropriate model listeners.
	*
	* @param billingTable the billing table
	* @return the billing table that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.BillingTable deleteBillingTable(
		com.liferay.famocom.erpcloud.model.BillingTable billingTable) {
		return getService().deleteBillingTable(billingTable);
	}

	/**
	* Deletes the billing table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billingId the primary key of the billing table
	* @return the billing table that was removed
	* @throws PortalException if a billing table with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.BillingTable deleteBillingTable(
		long billingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteBillingTable(billingId);
	}

	public static com.liferay.famocom.erpcloud.model.BillingTable fetchBillingTable(
		long billingId) {
		return getService().fetchBillingTable(billingId);
	}

	/**
	* Returns the billing table with the primary key.
	*
	* @param billingId the primary key of the billing table
	* @return the billing table
	* @throws PortalException if a billing table with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.BillingTable getBillingTable(
		long billingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBillingTable(billingId);
	}

	/**
	* Updates the billing table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param billingTable the billing table
	* @return the billing table that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.BillingTable updateBillingTable(
		com.liferay.famocom.erpcloud.model.BillingTable billingTable) {
		return getService().updateBillingTable(billingTable);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of billing tables.
	*
	* @return the number of billing tables
	*/
	public static int getBillingTablesCount() {
		return getService().getBillingTablesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the billing tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing tables
	* @param end the upper bound of the range of billing tables (not inclusive)
	* @return the range of billing tables
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.BillingTable> getBillingTables(
		int start, int end) {
		return getService().getBillingTables(start, end);
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

	public static BillingTableLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BillingTableLocalService, BillingTableLocalService> _serviceTracker =
		ServiceTrackerFactory.open(BillingTableLocalService.class);
}