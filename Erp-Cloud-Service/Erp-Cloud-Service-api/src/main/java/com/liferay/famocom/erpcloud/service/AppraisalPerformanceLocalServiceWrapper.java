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
 * Provides a wrapper for {@link AppraisalPerformanceLocalService}.
 *
 * @author Samaresh
 * @see AppraisalPerformanceLocalService
 * @generated
 */
@ProviderType
public class AppraisalPerformanceLocalServiceWrapper
	implements AppraisalPerformanceLocalService,
		ServiceWrapper<AppraisalPerformanceLocalService> {
	public AppraisalPerformanceLocalServiceWrapper(
		AppraisalPerformanceLocalService appraisalPerformanceLocalService) {
		_appraisalPerformanceLocalService = appraisalPerformanceLocalService;
	}

	/**
	* Adds the appraisal performance to the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalPerformance the appraisal performance
	* @return the appraisal performance that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalPerformance addAppraisalPerformance(
		com.liferay.famocom.erpcloud.model.AppraisalPerformance appraisalPerformance) {
		return _appraisalPerformanceLocalService.addAppraisalPerformance(appraisalPerformance);
	}

	/**
	* Creates a new appraisal performance with the primary key. Does not add the appraisal performance to the database.
	*
	* @param appraisalPerformanceId the primary key for the new appraisal performance
	* @return the new appraisal performance
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalPerformance createAppraisalPerformance(
		long appraisalPerformanceId) {
		return _appraisalPerformanceLocalService.createAppraisalPerformance(appraisalPerformanceId);
	}

	/**
	* Deletes the appraisal performance from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalPerformance the appraisal performance
	* @return the appraisal performance that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalPerformance deleteAppraisalPerformance(
		com.liferay.famocom.erpcloud.model.AppraisalPerformance appraisalPerformance) {
		return _appraisalPerformanceLocalService.deleteAppraisalPerformance(appraisalPerformance);
	}

	/**
	* Deletes the appraisal performance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalPerformanceId the primary key of the appraisal performance
	* @return the appraisal performance that was removed
	* @throws PortalException if a appraisal performance with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalPerformance deleteAppraisalPerformance(
		long appraisalPerformanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalPerformanceLocalService.deleteAppraisalPerformance(appraisalPerformanceId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalPerformanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalPerformanceLocalService.dynamicQuery();
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
		return _appraisalPerformanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _appraisalPerformanceLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _appraisalPerformanceLocalService.dynamicQuery(dynamicQuery,
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
		return _appraisalPerformanceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _appraisalPerformanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalPerformance fetchAppraisalPerformance(
		long appraisalPerformanceId) {
		return _appraisalPerformanceLocalService.fetchAppraisalPerformance(appraisalPerformanceId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalPerformance findByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appraisalPerformanceLocalService.findByApprIdSettingIdAndEmployeeIdPerformance(appraisalId,
			appraisalSettingId, employeeId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalPerformance findByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appraisalPerformanceLocalService.findByApprIdSettingIdAndEmployeeIdPerformId(appraisalId,
			appraisalSettingId, employeeId, performanceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _appraisalPerformanceLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the appraisal performance with the primary key.
	*
	* @param appraisalPerformanceId the primary key of the appraisal performance
	* @return the appraisal performance
	* @throws PortalException if a appraisal performance with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalPerformance getAppraisalPerformance(
		long appraisalPerformanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalPerformanceLocalService.getAppraisalPerformance(appraisalPerformanceId);
	}

	/**
	* Returns a range of all the appraisal performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal performances
	* @param end the upper bound of the range of appraisal performances (not inclusive)
	* @return the range of appraisal performances
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.AppraisalPerformance> getAppraisalPerformances(
		int start, int end) {
		return _appraisalPerformanceLocalService.getAppraisalPerformances(start,
			end);
	}

	/**
	* Returns the number of appraisal performances.
	*
	* @return the number of appraisal performances
	*/
	@Override
	public int getAppraisalPerformancesCount() {
		return _appraisalPerformanceLocalService.getAppraisalPerformancesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _appraisalPerformanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalPerformanceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalPerformanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the appraisal performance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appraisalPerformance the appraisal performance
	* @return the appraisal performance that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalPerformance updateAppraisalPerformance(
		com.liferay.famocom.erpcloud.model.AppraisalPerformance appraisalPerformance) {
		return _appraisalPerformanceLocalService.updateAppraisalPerformance(appraisalPerformance);
	}

	@Override
	public AppraisalPerformanceLocalService getWrappedService() {
		return _appraisalPerformanceLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalPerformanceLocalService appraisalPerformanceLocalService) {
		_appraisalPerformanceLocalService = appraisalPerformanceLocalService;
	}

	private AppraisalPerformanceLocalService _appraisalPerformanceLocalService;
}