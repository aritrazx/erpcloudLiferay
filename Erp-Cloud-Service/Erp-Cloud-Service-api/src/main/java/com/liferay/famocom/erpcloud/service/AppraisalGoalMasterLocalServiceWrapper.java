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
 * Provides a wrapper for {@link AppraisalGoalMasterLocalService}.
 *
 * @author Samaresh
 * @see AppraisalGoalMasterLocalService
 * @generated
 */
@ProviderType
public class AppraisalGoalMasterLocalServiceWrapper
	implements AppraisalGoalMasterLocalService,
		ServiceWrapper<AppraisalGoalMasterLocalService> {
	public AppraisalGoalMasterLocalServiceWrapper(
		AppraisalGoalMasterLocalService appraisalGoalMasterLocalService) {
		_appraisalGoalMasterLocalService = appraisalGoalMasterLocalService;
	}

	/**
	* Adds the appraisal goal master to the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalMaster the appraisal goal master
	* @return the appraisal goal master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalMaster addAppraisalGoalMaster(
		com.liferay.famocom.erpcloud.model.AppraisalGoalMaster appraisalGoalMaster) {
		return _appraisalGoalMasterLocalService.addAppraisalGoalMaster(appraisalGoalMaster);
	}

	/**
	* Creates a new appraisal goal master with the primary key. Does not add the appraisal goal master to the database.
	*
	* @param appraisalGoalMasterId the primary key for the new appraisal goal master
	* @return the new appraisal goal master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalMaster createAppraisalGoalMaster(
		long appraisalGoalMasterId) {
		return _appraisalGoalMasterLocalService.createAppraisalGoalMaster(appraisalGoalMasterId);
	}

	/**
	* Deletes the appraisal goal master from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalMaster the appraisal goal master
	* @return the appraisal goal master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalMaster deleteAppraisalGoalMaster(
		com.liferay.famocom.erpcloud.model.AppraisalGoalMaster appraisalGoalMaster) {
		return _appraisalGoalMasterLocalService.deleteAppraisalGoalMaster(appraisalGoalMaster);
	}

	/**
	* Deletes the appraisal goal master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalMasterId the primary key of the appraisal goal master
	* @return the appraisal goal master that was removed
	* @throws PortalException if a appraisal goal master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalMaster deleteAppraisalGoalMaster(
		long appraisalGoalMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalGoalMasterLocalService.deleteAppraisalGoalMaster(appraisalGoalMasterId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalGoalMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalGoalMasterLocalService.dynamicQuery();
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
		return _appraisalGoalMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _appraisalGoalMasterLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _appraisalGoalMasterLocalService.dynamicQuery(dynamicQuery,
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
		return _appraisalGoalMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _appraisalGoalMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalMaster fetchAppraisalGoalMaster(
		long appraisalGoalMasterId) {
		return _appraisalGoalMasterLocalService.fetchAppraisalGoalMaster(appraisalGoalMasterId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalMaster findByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId) {
		return _appraisalGoalMasterLocalService.findByApprIdEmpIdProjIdEvalId(appraisalId,
			employeeId, projectId, evaluationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _appraisalGoalMasterLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the appraisal goal master with the primary key.
	*
	* @param appraisalGoalMasterId the primary key of the appraisal goal master
	* @return the appraisal goal master
	* @throws PortalException if a appraisal goal master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalMaster getAppraisalGoalMaster(
		long appraisalGoalMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalGoalMasterLocalService.getAppraisalGoalMaster(appraisalGoalMasterId);
	}

	/**
	* Returns a range of all the appraisal goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal goal masters
	* @param end the upper bound of the range of appraisal goal masters (not inclusive)
	* @return the range of appraisal goal masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.AppraisalGoalMaster> getAppraisalGoalMasters(
		int start, int end) {
		return _appraisalGoalMasterLocalService.getAppraisalGoalMasters(start,
			end);
	}

	/**
	* Returns the number of appraisal goal masters.
	*
	* @return the number of appraisal goal masters
	*/
	@Override
	public int getAppraisalGoalMastersCount() {
		return _appraisalGoalMasterLocalService.getAppraisalGoalMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _appraisalGoalMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalGoalMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalGoalMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the appraisal goal master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalMaster the appraisal goal master
	* @return the appraisal goal master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalMaster updateAppraisalGoalMaster(
		com.liferay.famocom.erpcloud.model.AppraisalGoalMaster appraisalGoalMaster) {
		return _appraisalGoalMasterLocalService.updateAppraisalGoalMaster(appraisalGoalMaster);
	}

	@Override
	public AppraisalGoalMasterLocalService getWrappedService() {
		return _appraisalGoalMasterLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalGoalMasterLocalService appraisalGoalMasterLocalService) {
		_appraisalGoalMasterLocalService = appraisalGoalMasterLocalService;
	}

	private AppraisalGoalMasterLocalService _appraisalGoalMasterLocalService;
}