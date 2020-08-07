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
 * Provides a wrapper for {@link LeaveObLocalService}.
 *
 * @author Samaresh
 * @see LeaveObLocalService
 * @generated
 */
@ProviderType
public class LeaveObLocalServiceWrapper implements LeaveObLocalService,
	ServiceWrapper<LeaveObLocalService> {
	public LeaveObLocalServiceWrapper(LeaveObLocalService leaveObLocalService) {
		_leaveObLocalService = leaveObLocalService;
	}

	/**
	* Adds the leave ob to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveOb the leave ob
	* @return the leave ob that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveOb addLeaveOb(
		com.liferay.famocom.erpcloud.model.LeaveOb leaveOb) {
		return _leaveObLocalService.addLeaveOb(leaveOb);
	}

	/**
	* Creates a new leave ob with the primary key. Does not add the leave ob to the database.
	*
	* @param leaveobId the primary key for the new leave ob
	* @return the new leave ob
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveOb createLeaveOb(
		long leaveobId) {
		return _leaveObLocalService.createLeaveOb(leaveobId);
	}

	/**
	* Deletes the leave ob from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveOb the leave ob
	* @return the leave ob that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveOb deleteLeaveOb(
		com.liferay.famocom.erpcloud.model.LeaveOb leaveOb) {
		return _leaveObLocalService.deleteLeaveOb(leaveOb);
	}

	/**
	* Deletes the leave ob with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveobId the primary key of the leave ob
	* @return the leave ob that was removed
	* @throws PortalException if a leave ob with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveOb deleteLeaveOb(
		long leaveobId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveObLocalService.deleteLeaveOb(leaveobId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveObLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveObLocalService.dynamicQuery();
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
		return _leaveObLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveObLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveObLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _leaveObLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leaveObLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.LeaveOb fetchLeaveOb(
		long leaveobId) {
		return _leaveObLocalService.fetchLeaveOb(leaveobId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _leaveObLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _leaveObLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the leave ob with the primary key.
	*
	* @param leaveobId the primary key of the leave ob
	* @return the leave ob
	* @throws PortalException if a leave ob with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveOb getLeaveOb(long leaveobId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveObLocalService.getLeaveOb(leaveobId);
	}

	/**
	* Returns a range of all the leave obs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave obs
	* @param end the upper bound of the range of leave obs (not inclusive)
	* @return the range of leave obs
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.LeaveOb> getLeaveObs(
		int start, int end) {
		return _leaveObLocalService.getLeaveObs(start, end);
	}

	/**
	* Returns the number of leave obs.
	*
	* @return the number of leave obs
	*/
	@Override
	public int getLeaveObsCount() {
		return _leaveObLocalService.getLeaveObsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveObLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveObLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.LeaveOb openingBalance(
		long employeeId, long leaveTypeId) {
		return _leaveObLocalService.openingBalance(employeeId, leaveTypeId);
	}

	/**
	* Updates the leave ob in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveOb the leave ob
	* @return the leave ob that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveOb updateLeaveOb(
		com.liferay.famocom.erpcloud.model.LeaveOb leaveOb) {
		return _leaveObLocalService.updateLeaveOb(leaveOb);
	}

	@Override
	public LeaveObLocalService getWrappedService() {
		return _leaveObLocalService;
	}

	@Override
	public void setWrappedService(LeaveObLocalService leaveObLocalService) {
		_leaveObLocalService = leaveObLocalService;
	}

	private LeaveObLocalService _leaveObLocalService;
}