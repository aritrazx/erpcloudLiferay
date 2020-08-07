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
 * Provides a wrapper for {@link YearSettingLocalService}.
 *
 * @author Samaresh
 * @see YearSettingLocalService
 * @generated
 */
@ProviderType
public class YearSettingLocalServiceWrapper implements YearSettingLocalService,
	ServiceWrapper<YearSettingLocalService> {
	public YearSettingLocalServiceWrapper(
		YearSettingLocalService yearSettingLocalService) {
		_yearSettingLocalService = yearSettingLocalService;
	}

	/**
	* Adds the year setting to the database. Also notifies the appropriate model listeners.
	*
	* @param yearSetting the year setting
	* @return the year setting that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.YearSetting addYearSetting(
		com.liferay.famocom.erpcloud.model.YearSetting yearSetting) {
		return _yearSettingLocalService.addYearSetting(yearSetting);
	}

	/**
	* Creates a new year setting with the primary key. Does not add the year setting to the database.
	*
	* @param yearSettingId the primary key for the new year setting
	* @return the new year setting
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.YearSetting createYearSetting(
		long yearSettingId) {
		return _yearSettingLocalService.createYearSetting(yearSettingId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _yearSettingLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the year setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param yearSettingId the primary key of the year setting
	* @return the year setting that was removed
	* @throws PortalException if a year setting with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.YearSetting deleteYearSetting(
		long yearSettingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _yearSettingLocalService.deleteYearSetting(yearSettingId);
	}

	/**
	* Deletes the year setting from the database. Also notifies the appropriate model listeners.
	*
	* @param yearSetting the year setting
	* @return the year setting that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.YearSetting deleteYearSetting(
		com.liferay.famocom.erpcloud.model.YearSetting yearSetting) {
		return _yearSettingLocalService.deleteYearSetting(yearSetting);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _yearSettingLocalService.dynamicQuery();
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
		return _yearSettingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _yearSettingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _yearSettingLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _yearSettingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _yearSettingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.YearSetting fetchYearSetting(
		long yearSettingId) {
		return _yearSettingLocalService.fetchYearSetting(yearSettingId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.YearSetting findYearSettingByisActive(
		int isActive)
		throws com.liferay.famocom.erpcloud.exception.NoSuchYearSettingException {
		return _yearSettingLocalService.findYearSettingByisActive(isActive);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _yearSettingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _yearSettingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _yearSettingLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _yearSettingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the year setting with the primary key.
	*
	* @param yearSettingId the primary key of the year setting
	* @return the year setting
	* @throws PortalException if a year setting with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.YearSetting getYearSetting(
		long yearSettingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _yearSettingLocalService.getYearSetting(yearSettingId);
	}

	/**
	* Returns a range of all the year settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of year settings
	* @param end the upper bound of the range of year settings (not inclusive)
	* @return the range of year settings
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.YearSetting> getYearSettings(
		int start, int end) {
		return _yearSettingLocalService.getYearSettings(start, end);
	}

	/**
	* Returns the number of year settings.
	*
	* @return the number of year settings
	*/
	@Override
	public int getYearSettingsCount() {
		return _yearSettingLocalService.getYearSettingsCount();
	}

	/**
	* Updates the year setting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param yearSetting the year setting
	* @return the year setting that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.YearSetting updateYearSetting(
		com.liferay.famocom.erpcloud.model.YearSetting yearSetting) {
		return _yearSettingLocalService.updateYearSetting(yearSetting);
	}

	@Override
	public YearSettingLocalService getWrappedService() {
		return _yearSettingLocalService;
	}

	@Override
	public void setWrappedService(
		YearSettingLocalService yearSettingLocalService) {
		_yearSettingLocalService = yearSettingLocalService;
	}

	private YearSettingLocalService _yearSettingLocalService;
}