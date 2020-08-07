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
 * Provides a wrapper for {@link TaxSettingLocalService}.
 *
 * @author Samaresh
 * @see TaxSettingLocalService
 * @generated
 */
@ProviderType
public class TaxSettingLocalServiceWrapper implements TaxSettingLocalService,
	ServiceWrapper<TaxSettingLocalService> {
	public TaxSettingLocalServiceWrapper(
		TaxSettingLocalService taxSettingLocalService) {
		_taxSettingLocalService = taxSettingLocalService;
	}

	/**
	* Adds the tax setting to the database. Also notifies the appropriate model listeners.
	*
	* @param taxSetting the tax setting
	* @return the tax setting that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxSetting addTaxSetting(
		com.liferay.famocom.erpcloud.model.TaxSetting taxSetting) {
		return _taxSettingLocalService.addTaxSetting(taxSetting);
	}

	/**
	* Creates a new tax setting with the primary key. Does not add the tax setting to the database.
	*
	* @param taxSettingId the primary key for the new tax setting
	* @return the new tax setting
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxSetting createTaxSetting(
		long taxSettingId) {
		return _taxSettingLocalService.createTaxSetting(taxSettingId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taxSettingLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tax setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxSettingId the primary key of the tax setting
	* @return the tax setting that was removed
	* @throws PortalException if a tax setting with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxSetting deleteTaxSetting(
		long taxSettingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taxSettingLocalService.deleteTaxSetting(taxSettingId);
	}

	/**
	* Deletes the tax setting from the database. Also notifies the appropriate model listeners.
	*
	* @param taxSetting the tax setting
	* @return the tax setting that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxSetting deleteTaxSetting(
		com.liferay.famocom.erpcloud.model.TaxSetting taxSetting) {
		return _taxSettingLocalService.deleteTaxSetting(taxSetting);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taxSettingLocalService.dynamicQuery();
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
		return _taxSettingLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _taxSettingLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _taxSettingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _taxSettingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _taxSettingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.TaxSetting fetchTaxSetting(
		long taxSettingId) {
		return _taxSettingLocalService.fetchTaxSetting(taxSettingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _taxSettingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _taxSettingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _taxSettingLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taxSettingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tax setting with the primary key.
	*
	* @param taxSettingId the primary key of the tax setting
	* @return the tax setting
	* @throws PortalException if a tax setting with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxSetting getTaxSetting(
		long taxSettingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taxSettingLocalService.getTaxSetting(taxSettingId);
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
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.TaxSetting> getTaxSettings(
		int start, int end) {
		return _taxSettingLocalService.getTaxSettings(start, end);
	}

	/**
	* Returns the number of tax settings.
	*
	* @return the number of tax settings
	*/
	@Override
	public int getTaxSettingsCount() {
		return _taxSettingLocalService.getTaxSettingsCount();
	}

	/**
	* Updates the tax setting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taxSetting the tax setting
	* @return the tax setting that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxSetting updateTaxSetting(
		com.liferay.famocom.erpcloud.model.TaxSetting taxSetting) {
		return _taxSettingLocalService.updateTaxSetting(taxSetting);
	}

	@Override
	public TaxSettingLocalService getWrappedService() {
		return _taxSettingLocalService;
	}

	@Override
	public void setWrappedService(TaxSettingLocalService taxSettingLocalService) {
		_taxSettingLocalService = taxSettingLocalService;
	}

	private TaxSettingLocalService _taxSettingLocalService;
}