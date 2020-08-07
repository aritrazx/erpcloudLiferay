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
 * Provides a wrapper for {@link LeaveApplyLocalService}.
 *
 * @author Samaresh
 * @see LeaveApplyLocalService
 * @generated
 */
@ProviderType
public class LeaveApplyLocalServiceWrapper implements LeaveApplyLocalService,
	ServiceWrapper<LeaveApplyLocalService> {
	public LeaveApplyLocalServiceWrapper(
		LeaveApplyLocalService leaveApplyLocalService) {
		_leaveApplyLocalService = leaveApplyLocalService;
	}

	/**
	* Adds the leave apply to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApply the leave apply
	* @return the leave apply that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveApply addLeaveApply(
		com.liferay.famocom.erpcloud.model.LeaveApply leaveApply) {
		return _leaveApplyLocalService.addLeaveApply(leaveApply);
	}

	/**
	* Creates a new leave apply with the primary key. Does not add the leave apply to the database.
	*
	* @param leaveApplyId the primary key for the new leave apply
	* @return the new leave apply
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveApply createLeaveApply(
		long leaveApplyId) {
		return _leaveApplyLocalService.createLeaveApply(leaveApplyId);
	}

	/**
	* Deletes the leave apply from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApply the leave apply
	* @return the leave apply that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveApply deleteLeaveApply(
		com.liferay.famocom.erpcloud.model.LeaveApply leaveApply) {
		return _leaveApplyLocalService.deleteLeaveApply(leaveApply);
	}

	/**
	* Deletes the leave apply with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApplyId the primary key of the leave apply
	* @return the leave apply that was removed
	* @throws PortalException if a leave apply with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveApply deleteLeaveApply(
		long leaveApplyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveApplyLocalService.deleteLeaveApply(leaveApplyId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveApplyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveApplyLocalService.dynamicQuery();
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
		return _leaveApplyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveApplyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveApplyLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _leaveApplyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leaveApplyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.LeaveApply fetchLeaveApply(
		long leaveApplyId) {
		return _leaveApplyLocalService.fetchLeaveApply(leaveApplyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _leaveApplyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _leaveApplyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns a range of all the leave applies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave applies
	* @param end the upper bound of the range of leave applies (not inclusive)
	* @return the range of leave applies
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.LeaveApply> getLeaveApplies(
		int start, int end) {
		return _leaveApplyLocalService.getLeaveApplies(start, end);
	}

	/**
	* Returns the number of leave applies.
	*
	* @return the number of leave applies
	*/
	@Override
	public int getLeaveAppliesCount() {
		return _leaveApplyLocalService.getLeaveAppliesCount();
	}

	/**
	* Returns the leave apply with the primary key.
	*
	* @param leaveApplyId the primary key of the leave apply
	* @return the leave apply
	* @throws PortalException if a leave apply with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveApply getLeaveApply(
		long leaveApplyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveApplyLocalService.getLeaveApply(leaveApplyId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveApplyLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveApplyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the leave apply in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveApply the leave apply
	* @return the leave apply that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.LeaveApply updateLeaveApply(
		com.liferay.famocom.erpcloud.model.LeaveApply leaveApply) {
		return _leaveApplyLocalService.updateLeaveApply(leaveApply);
	}

	@Override
	public LeaveApplyLocalService getWrappedService() {
		return _leaveApplyLocalService;
	}

	@Override
	public void setWrappedService(LeaveApplyLocalService leaveApplyLocalService) {
		_leaveApplyLocalService = leaveApplyLocalService;
	}

	private LeaveApplyLocalService _leaveApplyLocalService;
}