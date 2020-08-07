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
 * Provides a wrapper for {@link HolidayCalenderManagementLocalService}.
 *
 * @author Samaresh
 * @see HolidayCalenderManagementLocalService
 * @generated
 */
@ProviderType
public class HolidayCalenderManagementLocalServiceWrapper
	implements HolidayCalenderManagementLocalService,
		ServiceWrapper<HolidayCalenderManagementLocalService> {
	public HolidayCalenderManagementLocalServiceWrapper(
		HolidayCalenderManagementLocalService holidayCalenderManagementLocalService) {
		_holidayCalenderManagementLocalService = holidayCalenderManagementLocalService;
	}

	/**
	* Adds the holiday calender management to the database. Also notifies the appropriate model listeners.
	*
	* @param holidayCalenderManagement the holiday calender management
	* @return the holiday calender management that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.HolidayCalenderManagement addHolidayCalenderManagement(
		com.liferay.famocom.erpcloud.model.HolidayCalenderManagement holidayCalenderManagement) {
		return _holidayCalenderManagementLocalService.addHolidayCalenderManagement(holidayCalenderManagement);
	}

	/**
	* Creates a new holiday calender management with the primary key. Does not add the holiday calender management to the database.
	*
	* @param holidayId the primary key for the new holiday calender management
	* @return the new holiday calender management
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.HolidayCalenderManagement createHolidayCalenderManagement(
		long holidayId) {
		return _holidayCalenderManagementLocalService.createHolidayCalenderManagement(holidayId);
	}

	/**
	* Deletes the holiday calender management from the database. Also notifies the appropriate model listeners.
	*
	* @param holidayCalenderManagement the holiday calender management
	* @return the holiday calender management that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.HolidayCalenderManagement deleteHolidayCalenderManagement(
		com.liferay.famocom.erpcloud.model.HolidayCalenderManagement holidayCalenderManagement) {
		return _holidayCalenderManagementLocalService.deleteHolidayCalenderManagement(holidayCalenderManagement);
	}

	/**
	* Deletes the holiday calender management with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param holidayId the primary key of the holiday calender management
	* @return the holiday calender management that was removed
	* @throws PortalException if a holiday calender management with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.HolidayCalenderManagement deleteHolidayCalenderManagement(
		long holidayId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _holidayCalenderManagementLocalService.deleteHolidayCalenderManagement(holidayId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _holidayCalenderManagementLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _holidayCalenderManagementLocalService.dynamicQuery();
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
		return _holidayCalenderManagementLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _holidayCalenderManagementLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _holidayCalenderManagementLocalService.dynamicQuery(dynamicQuery,
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
		return _holidayCalenderManagementLocalService.dynamicQueryCount(dynamicQuery);
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
		return _holidayCalenderManagementLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.HolidayCalenderManagement fetchHolidayCalenderManagement(
		long holidayId) {
		return _holidayCalenderManagementLocalService.fetchHolidayCalenderManagement(holidayId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.HolidayCalenderManagement> findByDateAndHoliDayId(
		java.util.Date holidayDate, long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayCalenderManagementLocalService.findByDateAndHoliDayId(holidayDate,
			holidayId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.HolidayCalenderManagement findByempIdAndAttDate(
		java.util.Date holidayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayCalenderManagementLocalService.findByempIdAndAttDate(holidayDate);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.HolidayCalenderManagement> findByHoliDayCheck(
		java.util.Date holidayDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return _holidayCalenderManagementLocalService.findByHoliDayCheck(holidayDate);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.HolidayCalenderManagement> findByNameAndHoliDayId(
		String holidayName, long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayCalenderManagementLocalService.findByNameAndHoliDayId(holidayName,
			holidayId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _holidayCalenderManagementLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the holiday calender management with the primary key.
	*
	* @param holidayId the primary key of the holiday calender management
	* @return the holiday calender management
	* @throws PortalException if a holiday calender management with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.HolidayCalenderManagement getHolidayCalenderManagement(
		long holidayId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _holidayCalenderManagementLocalService.getHolidayCalenderManagement(holidayId);
	}

	/**
	* Returns a range of all the holiday calender managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @return the range of holiday calender managements
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.HolidayCalenderManagement> getHolidayCalenderManagements(
		int start, int end) {
		return _holidayCalenderManagementLocalService.getHolidayCalenderManagements(start,
			end);
	}

	/**
	* Returns the number of holiday calender managements.
	*
	* @return the number of holiday calender managements
	*/
	@Override
	public int getHolidayCalenderManagementsCount() {
		return _holidayCalenderManagementLocalService.getHolidayCalenderManagementsCount();
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.HolidayCalenderManagement> getHolidays(
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return _holidayCalenderManagementLocalService.getHolidays(fromDate,
			toDate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _holidayCalenderManagementLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _holidayCalenderManagementLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _holidayCalenderManagementLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the holiday calender management in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param holidayCalenderManagement the holiday calender management
	* @return the holiday calender management that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.HolidayCalenderManagement updateHolidayCalenderManagement(
		com.liferay.famocom.erpcloud.model.HolidayCalenderManagement holidayCalenderManagement) {
		return _holidayCalenderManagementLocalService.updateHolidayCalenderManagement(holidayCalenderManagement);
	}

	@Override
	public HolidayCalenderManagementLocalService getWrappedService() {
		return _holidayCalenderManagementLocalService;
	}

	@Override
	public void setWrappedService(
		HolidayCalenderManagementLocalService holidayCalenderManagementLocalService) {
		_holidayCalenderManagementLocalService = holidayCalenderManagementLocalService;
	}

	private HolidayCalenderManagementLocalService _holidayCalenderManagementLocalService;
}