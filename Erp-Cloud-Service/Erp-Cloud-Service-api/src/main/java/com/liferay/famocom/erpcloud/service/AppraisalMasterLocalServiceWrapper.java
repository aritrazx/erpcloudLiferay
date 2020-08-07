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
 * Provides a wrapper for {@link AppraisalMasterLocalService}.
 *
 * @author Samaresh
 * @see AppraisalMasterLocalService
 * @generated
 */
@ProviderType
public class AppraisalMasterLocalServiceWrapper
	implements AppraisalMasterLocalService,
		ServiceWrapper<AppraisalMasterLocalService> {
	public AppraisalMasterLocalServiceWrapper(
		AppraisalMasterLocalService appraisalMasterLocalService) {
		_appraisalMasterLocalService = appraisalMasterLocalService;
	}

	/**
	* Adds the appraisal master to the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalMaster the appraisal master
	* @return the appraisal master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalMaster addAppraisalMaster(
		com.liferay.famocom.erpcloud.model.AppraisalMaster appraisalMaster) {
		return _appraisalMasterLocalService.addAppraisalMaster(appraisalMaster);
	}

	/**
	* Creates a new appraisal master with the primary key. Does not add the appraisal master to the database.
	*
	* @param appraisalId the primary key for the new appraisal master
	* @return the new appraisal master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalMaster createAppraisalMaster(
		long appraisalId) {
		return _appraisalMasterLocalService.createAppraisalMaster(appraisalId);
	}

	/**
	* Deletes the appraisal master from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalMaster the appraisal master
	* @return the appraisal master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalMaster deleteAppraisalMaster(
		com.liferay.famocom.erpcloud.model.AppraisalMaster appraisalMaster) {
		return _appraisalMasterLocalService.deleteAppraisalMaster(appraisalMaster);
	}

	/**
	* Deletes the appraisal master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalId the primary key of the appraisal master
	* @return the appraisal master that was removed
	* @throws PortalException if a appraisal master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalMaster deleteAppraisalMaster(
		long appraisalId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalMasterLocalService.deleteAppraisalMaster(appraisalId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalMasterLocalService.dynamicQuery();
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
		return _appraisalMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _appraisalMasterLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _appraisalMasterLocalService.dynamicQuery(dynamicQuery, start,
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
		return _appraisalMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _appraisalMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalMaster fetchAppraisalMaster(
		long appraisalId) {
		return _appraisalMasterLocalService.fetchAppraisalMaster(appraisalId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalMaster findBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appraisalMasterLocalService.findBySettingIdAndEmployeeId(appraisalSettingId,
			employeeId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalMaster findBySettingIdAndEmployeeIds(
		long appraisalSettingId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appraisalMasterLocalService.findBySettingIdAndEmployeeIds(appraisalSettingId,
			employeeId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appraisalMasterLocalService.findBySettingIdAndsubmitStep(appraisalSettingId,
			submitStep);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _appraisalMasterLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the appraisal master with the primary key.
	*
	* @param appraisalId the primary key of the appraisal master
	* @return the appraisal master
	* @throws PortalException if a appraisal master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalMaster getAppraisalMaster(
		long appraisalId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalMasterLocalService.getAppraisalMaster(appraisalId);
	}

	/**
	* Returns a range of all the appraisal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @return the range of appraisal masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.AppraisalMaster> getAppraisalMasters(
		int start, int end) {
		return _appraisalMasterLocalService.getAppraisalMasters(start, end);
	}

	/**
	* Returns the number of appraisal masters.
	*
	* @return the number of appraisal masters
	*/
	@Override
	public int getAppraisalMastersCount() {
		return _appraisalMasterLocalService.getAppraisalMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _appraisalMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the appraisal master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appraisalMaster the appraisal master
	* @return the appraisal master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalMaster updateAppraisalMaster(
		com.liferay.famocom.erpcloud.model.AppraisalMaster appraisalMaster) {
		return _appraisalMasterLocalService.updateAppraisalMaster(appraisalMaster);
	}

	@Override
	public AppraisalMasterLocalService getWrappedService() {
		return _appraisalMasterLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalMasterLocalService appraisalMasterLocalService) {
		_appraisalMasterLocalService = appraisalMasterLocalService;
	}

	private AppraisalMasterLocalService _appraisalMasterLocalService;
}