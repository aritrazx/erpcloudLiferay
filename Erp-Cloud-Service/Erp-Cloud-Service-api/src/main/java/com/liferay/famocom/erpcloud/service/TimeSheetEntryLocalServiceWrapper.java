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
 * Provides a wrapper for {@link TimeSheetEntryLocalService}.
 *
 * @author Samaresh
 * @see TimeSheetEntryLocalService
 * @generated
 */
@ProviderType
public class TimeSheetEntryLocalServiceWrapper
	implements TimeSheetEntryLocalService,
		ServiceWrapper<TimeSheetEntryLocalService> {
	public TimeSheetEntryLocalServiceWrapper(
		TimeSheetEntryLocalService timeSheetEntryLocalService) {
		_timeSheetEntryLocalService = timeSheetEntryLocalService;
	}

	/**
	* Adds the time sheet entry to the database. Also notifies the appropriate model listeners.
	*
	* @param timeSheetEntry the time sheet entry
	* @return the time sheet entry that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetEntry addTimeSheetEntry(
		com.liferay.famocom.erpcloud.model.TimeSheetEntry timeSheetEntry) {
		return _timeSheetEntryLocalService.addTimeSheetEntry(timeSheetEntry);
	}

	/**
	* Creates a new time sheet entry with the primary key. Does not add the time sheet entry to the database.
	*
	* @param timesheetId the primary key for the new time sheet entry
	* @return the new time sheet entry
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetEntry createTimeSheetEntry(
		long timesheetId) {
		return _timeSheetEntryLocalService.createTimeSheetEntry(timesheetId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timeSheetEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the time sheet entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetId the primary key of the time sheet entry
	* @return the time sheet entry that was removed
	* @throws PortalException if a time sheet entry with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetEntry deleteTimeSheetEntry(
		long timesheetId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timeSheetEntryLocalService.deleteTimeSheetEntry(timesheetId);
	}

	/**
	* Deletes the time sheet entry from the database. Also notifies the appropriate model listeners.
	*
	* @param timeSheetEntry the time sheet entry
	* @return the time sheet entry that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetEntry deleteTimeSheetEntry(
		com.liferay.famocom.erpcloud.model.TimeSheetEntry timeSheetEntry) {
		return _timeSheetEntryLocalService.deleteTimeSheetEntry(timeSheetEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _timeSheetEntryLocalService.dynamicQuery();
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
		return _timeSheetEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timeSheetEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timeSheetEntryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _timeSheetEntryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _timeSheetEntryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetEntry fetchTimeSheetEntry(
		long timesheetId) {
		return _timeSheetEntryLocalService.fetchTimeSheetEntry(timesheetId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _timeSheetEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<Object[]> getDistinctTimesheetListByEmployeeIdAndDateRange(
		long employeeId, java.util.Date startDate, java.util.Date endDate) {
		return _timeSheetEntryLocalService.getDistinctTimesheetListByEmployeeIdAndDateRange(employeeId,
			startDate, endDate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _timeSheetEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _timeSheetEntryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timeSheetEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the time sheet entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @return the range of time sheet entries
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.TimeSheetEntry> getTimeSheetEntries(
		int start, int end) {
		return _timeSheetEntryLocalService.getTimeSheetEntries(start, end);
	}

	/**
	* Returns the number of time sheet entries.
	*
	* @return the number of time sheet entries
	*/
	@Override
	public int getTimeSheetEntriesCount() {
		return _timeSheetEntryLocalService.getTimeSheetEntriesCount();
	}

	/**
	* Returns the time sheet entry with the primary key.
	*
	* @param timesheetId the primary key of the time sheet entry
	* @return the time sheet entry
	* @throws PortalException if a time sheet entry with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetEntry getTimeSheetEntry(
		long timesheetId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timeSheetEntryLocalService.getTimeSheetEntry(timesheetId);
	}

	/**
	* Updates the time sheet entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timeSheetEntry the time sheet entry
	* @return the time sheet entry that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TimeSheetEntry updateTimeSheetEntry(
		com.liferay.famocom.erpcloud.model.TimeSheetEntry timeSheetEntry) {
		return _timeSheetEntryLocalService.updateTimeSheetEntry(timeSheetEntry);
	}

	@Override
	public TimeSheetEntryLocalService getWrappedService() {
		return _timeSheetEntryLocalService;
	}

	@Override
	public void setWrappedService(
		TimeSheetEntryLocalService timeSheetEntryLocalService) {
		_timeSheetEntryLocalService = timeSheetEntryLocalService;
	}

	private TimeSheetEntryLocalService _timeSheetEntryLocalService;
}