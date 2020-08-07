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
 * Provides a wrapper for {@link AppraisalGoalDetailsLocalService}.
 *
 * @author Samaresh
 * @see AppraisalGoalDetailsLocalService
 * @generated
 */
@ProviderType
public class AppraisalGoalDetailsLocalServiceWrapper
	implements AppraisalGoalDetailsLocalService,
		ServiceWrapper<AppraisalGoalDetailsLocalService> {
	public AppraisalGoalDetailsLocalServiceWrapper(
		AppraisalGoalDetailsLocalService appraisalGoalDetailsLocalService) {
		_appraisalGoalDetailsLocalService = appraisalGoalDetailsLocalService;
	}

	/**
	* Adds the appraisal goal details to the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalDetails the appraisal goal details
	* @return the appraisal goal details that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalDetails addAppraisalGoalDetails(
		com.liferay.famocom.erpcloud.model.AppraisalGoalDetails appraisalGoalDetails) {
		return _appraisalGoalDetailsLocalService.addAppraisalGoalDetails(appraisalGoalDetails);
	}

	/**
	* Creates a new appraisal goal details with the primary key. Does not add the appraisal goal details to the database.
	*
	* @param appraisalGoalDetailsId the primary key for the new appraisal goal details
	* @return the new appraisal goal details
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalDetails createAppraisalGoalDetails(
		long appraisalGoalDetailsId) {
		return _appraisalGoalDetailsLocalService.createAppraisalGoalDetails(appraisalGoalDetailsId);
	}

	/**
	* Deletes the appraisal goal details from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalDetails the appraisal goal details
	* @return the appraisal goal details that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalDetails deleteAppraisalGoalDetails(
		com.liferay.famocom.erpcloud.model.AppraisalGoalDetails appraisalGoalDetails) {
		return _appraisalGoalDetailsLocalService.deleteAppraisalGoalDetails(appraisalGoalDetails);
	}

	/**
	* Deletes the appraisal goal details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalDetailsId the primary key of the appraisal goal details
	* @return the appraisal goal details that was removed
	* @throws PortalException if a appraisal goal details with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalDetails deleteAppraisalGoalDetails(
		long appraisalGoalDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalGoalDetailsLocalService.deleteAppraisalGoalDetails(appraisalGoalDetailsId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalGoalDetailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalGoalDetailsLocalService.dynamicQuery();
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
		return _appraisalGoalDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _appraisalGoalDetailsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _appraisalGoalDetailsLocalService.dynamicQuery(dynamicQuery,
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
		return _appraisalGoalDetailsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _appraisalGoalDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalDetails fetchAppraisalGoalDetails(
		long appraisalGoalDetailsId) {
		return _appraisalGoalDetailsLocalService.fetchAppraisalGoalDetails(appraisalGoalDetailsId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalDetails findByApprIdEmpIdProjIdEvalIdGoalDetId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		long goaldetailId) {
		return _appraisalGoalDetailsLocalService.findByApprIdEmpIdProjIdEvalIdGoalDetId(appraisalId,
			employeeId, projectId, evaluationId, goaldetailId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _appraisalGoalDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the appraisal goal details with the primary key.
	*
	* @param appraisalGoalDetailsId the primary key of the appraisal goal details
	* @return the appraisal goal details
	* @throws PortalException if a appraisal goal details with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalDetails getAppraisalGoalDetails(
		long appraisalGoalDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalGoalDetailsLocalService.getAppraisalGoalDetails(appraisalGoalDetailsId);
	}

	/**
	* Returns a range of all the appraisal goal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal goal detailses
	* @param end the upper bound of the range of appraisal goal detailses (not inclusive)
	* @return the range of appraisal goal detailses
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.AppraisalGoalDetails> getAppraisalGoalDetailses(
		int start, int end) {
		return _appraisalGoalDetailsLocalService.getAppraisalGoalDetailses(start,
			end);
	}

	/**
	* Returns the number of appraisal goal detailses.
	*
	* @return the number of appraisal goal detailses
	*/
	@Override
	public int getAppraisalGoalDetailsesCount() {
		return _appraisalGoalDetailsLocalService.getAppraisalGoalDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _appraisalGoalDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalGoalDetailsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalGoalDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the appraisal goal details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalDetails the appraisal goal details
	* @return the appraisal goal details that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalGoalDetails updateAppraisalGoalDetails(
		com.liferay.famocom.erpcloud.model.AppraisalGoalDetails appraisalGoalDetails) {
		return _appraisalGoalDetailsLocalService.updateAppraisalGoalDetails(appraisalGoalDetails);
	}

	@Override
	public AppraisalGoalDetailsLocalService getWrappedService() {
		return _appraisalGoalDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalGoalDetailsLocalService appraisalGoalDetailsLocalService) {
		_appraisalGoalDetailsLocalService = appraisalGoalDetailsLocalService;
	}

	private AppraisalGoalDetailsLocalService _appraisalGoalDetailsLocalService;
}