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
 * Provides a wrapper for {@link TimeSheetMasterLocalService}.
 *
 * @author Samaresh
 * @see TimeSheetMasterLocalService
 * @generated
 */
@ProviderType
public class TimeSheetMasterLocalServiceWrapper
	implements TimeSheetMasterLocalService,
		ServiceWrapper<TimeSheetMasterLocalService> {
	public TimeSheetMasterLocalServiceWrapper(
		TimeSheetMasterLocalService timeSheetMasterLocalService) {
		_timeSheetMasterLocalService = timeSheetMasterLocalService;
	}

	/**
	* Adds the time sheet master to the database. Also notifies the appropriate model listeners.
	*
	* @param timeSheetMaster the time sheet master
	* @return the time sheet master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetMaster addTimeSheetMaster(
		com.liferay.famocom.erpcloud.model.TimeSheetMaster timeSheetMaster) {
		return _timeSheetMasterLocalService.addTimeSheetMaster(timeSheetMaster);
	}

	/**
	* Creates a new time sheet master with the primary key. Does not add the time sheet master to the database.
	*
	* @param timesheetParentId the primary key for the new time sheet master
	* @return the new time sheet master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetMaster createTimeSheetMaster(
		long timesheetParentId) {
		return _timeSheetMasterLocalService.createTimeSheetMaster(timesheetParentId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timeSheetMasterLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the time sheet master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetParentId the primary key of the time sheet master
	* @return the time sheet master that was removed
	* @throws PortalException if a time sheet master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetMaster deleteTimeSheetMaster(
		long timesheetParentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timeSheetMasterLocalService.deleteTimeSheetMaster(timesheetParentId);
	}

	/**
	* Deletes the time sheet master from the database. Also notifies the appropriate model listeners.
	*
	* @param timeSheetMaster the time sheet master
	* @return the time sheet master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetMaster deleteTimeSheetMaster(
		com.liferay.famocom.erpcloud.model.TimeSheetMaster timeSheetMaster) {
		return _timeSheetMasterLocalService.deleteTimeSheetMaster(timeSheetMaster);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _timeSheetMasterLocalService.dynamicQuery();
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
		return _timeSheetMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timeSheetMasterLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timeSheetMasterLocalService.dynamicQuery(dynamicQuery, start,
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
		return _timeSheetMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _timeSheetMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetMaster fetchTimeSheetMaster(
		long timesheetParentId) {
		return _timeSheetMasterLocalService.fetchTimeSheetMaster(timesheetParentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _timeSheetMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _timeSheetMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _timeSheetMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timeSheetMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the time sheet master with the primary key.
	*
	* @param timesheetParentId the primary key of the time sheet master
	* @return the time sheet master
	* @throws PortalException if a time sheet master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetMaster getTimeSheetMaster(
		long timesheetParentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timeSheetMasterLocalService.getTimeSheetMaster(timesheetParentId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.TimeSheetMaster> getTimeSheetMasterBystatus(
		long groupId, int status) {
		return _timeSheetMasterLocalService.getTimeSheetMasterBystatus(groupId,
			status);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.TimeSheetMaster> getTimeSheetMasterByStatus(
		long groupId, int status, int start, int end) {
		return _timeSheetMasterLocalService.getTimeSheetMasterByStatus(groupId,
			status, start, end);
	}

	/**
	* Returns a range of all the time sheet masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @return the range of time sheet masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.TimeSheetMaster> getTimeSheetMasters(
		int start, int end) {
		return _timeSheetMasterLocalService.getTimeSheetMasters(start, end);
	}

	/**
	* Returns the number of time sheet masters.
	*
	* @return the number of time sheet masters
	*/
	@Override
	public int getTimeSheetMastersCount() {
		return _timeSheetMasterLocalService.getTimeSheetMastersCount();
	}

	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetMaster updateStatus(
		long userId, long timesheetParentId, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return _timeSheetMasterLocalService.updateStatus(userId,
			timesheetParentId, status, serviceContext);
	}

	/**
	* Updates the time sheet master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timeSheetMaster the time sheet master
	* @return the time sheet master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetMaster updateTimeSheetMaster(
		com.liferay.famocom.erpcloud.model.TimeSheetMaster timeSheetMaster) {
		return _timeSheetMasterLocalService.updateTimeSheetMaster(timeSheetMaster);
	}

	@Override
	public TimeSheetMasterLocalService getWrappedService() {
		return _timeSheetMasterLocalService;
	}

	@Override
	public void setWrappedService(
		TimeSheetMasterLocalService timeSheetMasterLocalService) {
		_timeSheetMasterLocalService = timeSheetMasterLocalService;
	}

	private TimeSheetMasterLocalService _timeSheetMasterLocalService;
}