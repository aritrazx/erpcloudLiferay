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
 * Provides the local service utility for TaxSetting. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.TaxSettingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see TaxSettingLocalService
 * @see com.liferay.famocom.erpcloud.service.base.TaxSettingLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.TaxSettingLocalServiceImpl
 * @generated
 */
@ProviderType
public class TaxSettingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.TaxSettingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tax setting to the database. Also notifies the appropriate model listeners.
	*
	* @param taxSetting the tax setting
	* @return the tax setting that was added
	*/
	public static com.liferay.famocom.erpcloud.model.TaxSetting addTaxSetting(
		com.liferay.famocom.erpcloud.model.TaxSetting taxSetting) {
		return getService().addTaxSetting(taxSetting);
	}

	/**
	* Creates a new tax setting with the primary key. Does not add the tax setting to the database.
	*
	* @param taxSettingId the primary key for the new tax setting
	* @return the new tax setting
	*/
	public static com.liferay.famocom.erpcloud.model.TaxSetting createTaxSetting(
		long taxSettingId) {
		return getService().createTaxSetting(taxSettingId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tax setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxSettingId the primary key of the tax setting
	* @return the tax setting that was removed
	* @throws PortalException if a tax setting with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.TaxSetting deleteTaxSetting(
		long taxSettingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTaxSetting(taxSettingId);
	}

	/**
	* Deletes the tax setting from the database. Also notifies the appropriate model listeners.
	*
	* @param taxSetting the tax setting
	* @return the tax setting that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.TaxSetting deleteTaxSetting(
		com.liferay.famocom.erpcloud.model.TaxSetting taxSetting) {
		return getService().deleteTaxSetting(taxSetting);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.TaxSetting fetchTaxSetting(
		long taxSettingId) {
		return getService().fetchTaxSetting(taxSettingId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
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

	/**
	* Returns the tax setting with the primary key.
	*
	* @param taxSettingId the primary key of the tax setting
	* @return the tax setting
	* @throws PortalException if a tax setting with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.TaxSetting getTaxSetting(
		long taxSettingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTaxSetting(taxSettingId);
	}

	/**
	* Returns a range of all the tax settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @return the range of tax settings
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.TaxSetting> getTaxSettings(
		int start, int end) {
		return getService().getTaxSettings(start, end);
	}

	/**
	* Returns the number of tax settings.
	*
	* @return the number of tax settings
	*/
	public static int getTaxSettingsCount() {
		return getService().getTaxSettingsCount();
	}

	/**
	* Updates the tax setting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taxSetting the tax setting
	* @return the tax setting that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.TaxSetting updateTaxSetting(
		com.liferay.famocom.erpcloud.model.TaxSetting taxSetting) {
		return getService().updateTaxSetting(taxSetting);
	}

	public static TaxSettingLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaxSettingLocalService, TaxSettingLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaxSettingLocalService.class);

		ServiceTracker<TaxSettingLocalService, TaxSettingLocalService> serviceTracker =
			new ServiceTracker<TaxSettingLocalService, TaxSettingLocalService>(bundle.getBundleContext(),
				TaxSettingLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}