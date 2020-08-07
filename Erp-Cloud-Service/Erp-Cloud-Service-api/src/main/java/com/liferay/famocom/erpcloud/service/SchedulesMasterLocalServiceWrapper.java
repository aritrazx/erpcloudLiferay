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
 * Provides a wrapper for {@link SchedulesMasterLocalService}.
 *
 * @author Samaresh
 * @see SchedulesMasterLocalService
 * @generated
 */
@ProviderType
public class SchedulesMasterLocalServiceWrapper
	implements SchedulesMasterLocalService,
		ServiceWrapper<SchedulesMasterLocalService> {
	public SchedulesMasterLocalServiceWrapper(
		SchedulesMasterLocalService schedulesMasterLocalService) {
		_schedulesMasterLocalService = schedulesMasterLocalService;
	}

	/**
	* Adds the schedules master to the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesMaster the schedules master
	* @return the schedules master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesMaster addSchedulesMaster(
		com.liferay.famocom.erpcloud.model.SchedulesMaster schedulesMaster) {
		return _schedulesMasterLocalService.addSchedulesMaster(schedulesMaster);
	}

	/**
	* Creates a new schedules master with the primary key. Does not add the schedules master to the database.
	*
	* @param schedulesId the primary key for the new schedules master
	* @return the new schedules master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesMaster createSchedulesMaster(
		long schedulesId) {
		return _schedulesMasterLocalService.createSchedulesMaster(schedulesId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schedulesMasterLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the schedules master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesId the primary key of the schedules master
	* @return the schedules master that was removed
	* @throws PortalException if a schedules master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesMaster deleteSchedulesMaster(
		long schedulesId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schedulesMasterLocalService.deleteSchedulesMaster(schedulesId);
	}

	/**
	* Deletes the schedules master from the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesMaster the schedules master
	* @return the schedules master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesMaster deleteSchedulesMaster(
		com.liferay.famocom.erpcloud.model.SchedulesMaster schedulesMaster) {
		return _schedulesMasterLocalService.deleteSchedulesMaster(schedulesMaster);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _schedulesMasterLocalService.dynamicQuery();
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
		return _schedulesMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _schedulesMasterLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _schedulesMasterLocalService.dynamicQuery(dynamicQuery, start,
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
		return _schedulesMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _schedulesMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesMaster fetchSchedulesMaster(
		long schedulesId) {
		return _schedulesMasterLocalService.fetchSchedulesMaster(schedulesId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SchedulesDetails> findBycheckDate(
		long employeeId, long companyId, java.util.Date schedulesDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return _schedulesMasterLocalService.findBycheckDate(employeeId,
			companyId, schedulesDate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _schedulesMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _schedulesMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _schedulesMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schedulesMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the schedules master with the primary key.
	*
	* @param schedulesId the primary key of the schedules master
	* @return the schedules master
	* @throws PortalException if a schedules master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesMaster getSchedulesMaster(
		long schedulesId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schedulesMasterLocalService.getSchedulesMaster(schedulesId);
	}

	/**
	* Returns a range of all the schedules masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules masters
	* @param end the upper bound of the range of schedules masters (not inclusive)
	* @return the range of schedules masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SchedulesMaster> getSchedulesMasters(
		int start, int end) {
		return _schedulesMasterLocalService.getSchedulesMasters(start, end);
	}

	/**
	* Returns the number of schedules masters.
	*
	* @return the number of schedules masters
	*/
	@Override
	public int getSchedulesMastersCount() {
		return _schedulesMasterLocalService.getSchedulesMastersCount();
	}

	/**
	* Updates the schedules master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param schedulesMaster the schedules master
	* @return the schedules master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SchedulesMaster updateSchedulesMaster(
		com.liferay.famocom.erpcloud.model.SchedulesMaster schedulesMaster) {
		return _schedulesMasterLocalService.updateSchedulesMaster(schedulesMaster);
	}

	@Override
	public SchedulesMasterLocalService getWrappedService() {
		return _schedulesMasterLocalService;
	}

	@Override
	public void setWrappedService(
		SchedulesMasterLocalService schedulesMasterLocalService) {
		_schedulesMasterLocalService = schedulesMasterLocalService;
	}

	private SchedulesMasterLocalService _schedulesMasterLocalService;
}