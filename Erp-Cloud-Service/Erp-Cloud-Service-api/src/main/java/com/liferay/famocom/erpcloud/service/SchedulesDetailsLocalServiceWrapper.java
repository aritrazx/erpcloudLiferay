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
 * Provides a wrapper for {@link SchedulesDetailsLocalService}.
 *
 * @author Samaresh
 * @see SchedulesDetailsLocalService
 * @generated
 */
@ProviderType
public class SchedulesDetailsLocalServiceWrapper
	implements SchedulesDetailsLocalService,
		ServiceWrapper<SchedulesDetailsLocalService> {
	public SchedulesDetailsLocalServiceWrapper(
		SchedulesDetailsLocalService schedulesDetailsLocalService) {
		_schedulesDetailsLocalService = schedulesDetailsLocalService;
	}

	/**
	* Adds the schedules details to the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesDetails the schedules details
	* @return the schedules details that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesDetails addSchedulesDetails(
		com.liferay.famocom.erpcloud.model.SchedulesDetails schedulesDetails) {
		return _schedulesDetailsLocalService.addSchedulesDetails(schedulesDetails);
	}

	/**
	* Creates a new schedules details with the primary key. Does not add the schedules details to the database.
	*
	* @param schedulesDetailsId the primary key for the new schedules details
	* @return the new schedules details
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesDetails createSchedulesDetails(
		long schedulesDetailsId) {
		return _schedulesDetailsLocalService.createSchedulesDetails(schedulesDetailsId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schedulesDetailsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the schedules details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesDetailsId the primary key of the schedules details
	* @return the schedules details that was removed
	* @throws PortalException if a schedules details with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesDetails deleteSchedulesDetails(
		long schedulesDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schedulesDetailsLocalService.deleteSchedulesDetails(schedulesDetailsId);
	}

	/**
	* Deletes the schedules details from the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesDetails the schedules details
	* @return the schedules details that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesDetails deleteSchedulesDetails(
		com.liferay.famocom.erpcloud.model.SchedulesDetails schedulesDetails) {
		return _schedulesDetailsLocalService.deleteSchedulesDetails(schedulesDetails);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _schedulesDetailsLocalService.dynamicQuery();
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
		return _schedulesDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _schedulesDetailsLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _schedulesDetailsLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _schedulesDetailsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _schedulesDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesDetails fetchSchedulesDetails(
		long schedulesDetailsId) {
		return _schedulesDetailsLocalService.fetchSchedulesDetails(schedulesDetailsId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SchedulesDetails> findBycheckDate(
		long employeeId, long companyId, java.util.Date schedulesDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return _schedulesDetailsLocalService.findBycheckDate(employeeId,
			companyId, schedulesDate);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SchedulesDetails> findBydetailsEdit(
		long worksSchedulesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return _schedulesDetailsLocalService.findBydetailsEdit(worksSchedulesId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesDetails findByempIdAndAttDate(
		long employeeId, java.util.Date schedulesDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schedulesDetailsLocalService.findByempIdAndAttDate(employeeId,
			schedulesDate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _schedulesDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _schedulesDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _schedulesDetailsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schedulesDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the schedules details with the primary key.
	*
	* @param schedulesDetailsId the primary key of the schedules details
	* @return the schedules details
	* @throws PortalException if a schedules details with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesDetails getSchedulesDetails(
		long schedulesDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schedulesDetailsLocalService.getSchedulesDetails(schedulesDetailsId);
	}

	/**
	* Returns a range of all the schedules detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules detailses
	* @param end the upper bound of the range of schedules detailses (not inclusive)
	* @return the range of schedules detailses
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SchedulesDetails> getSchedulesDetailses(
		int start, int end) {
		return _schedulesDetailsLocalService.getSchedulesDetailses(start, end);
	}

	/**
	* Returns the number of schedules detailses.
	*
	* @return the number of schedules detailses
	*/
	@Override
	public int getSchedulesDetailsesCount() {
		return _schedulesDetailsLocalService.getSchedulesDetailsesCount();
	}

	/**
	* Updates the schedules details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param schedulesDetails the schedules details
	* @return the schedules details that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesDetails updateSchedulesDetails(
		com.liferay.famocom.erpcloud.model.SchedulesDetails schedulesDetails) {
		return _schedulesDetailsLocalService.updateSchedulesDetails(schedulesDetails);
	}

	@Override
	public SchedulesDetailsLocalService getWrappedService() {
		return _schedulesDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		SchedulesDetailsLocalService schedulesDetailsLocalService) {
		_schedulesDetailsLocalService = schedulesDetailsLocalService;
	}

	private SchedulesDetailsLocalService _schedulesDetailsLocalService;
}