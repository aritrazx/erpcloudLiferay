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
 * Provides a wrapper for {@link RecruitmentProcessLocalService}.
 *
 * @author Samaresh
 * @see RecruitmentProcessLocalService
 * @generated
 */
@ProviderType
public class RecruitmentProcessLocalServiceWrapper
	implements RecruitmentProcessLocalService,
		ServiceWrapper<RecruitmentProcessLocalService> {
	public RecruitmentProcessLocalServiceWrapper(
		RecruitmentProcessLocalService recruitmentProcessLocalService) {
		_recruitmentProcessLocalService = recruitmentProcessLocalService;
	}

	/**
	* Adds the recruitment process to the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProcess the recruitment process
	* @return the recruitment process that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitmentProcess addRecruitmentProcess(
		com.liferay.famocom.erpcloud.model.RecruitmentProcess recruitmentProcess) {
		return _recruitmentProcessLocalService.addRecruitmentProcess(recruitmentProcess);
	}

	/**
	* Creates a new recruitment process with the primary key. Does not add the recruitment process to the database.
	*
	* @param recruitmentProcessId the primary key for the new recruitment process
	* @return the new recruitment process
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitmentProcess createRecruitmentProcess(
		long recruitmentProcessId) {
		return _recruitmentProcessLocalService.createRecruitmentProcess(recruitmentProcessId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _recruitmentProcessLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the recruitment process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProcessId the primary key of the recruitment process
	* @return the recruitment process that was removed
	* @throws PortalException if a recruitment process with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitmentProcess deleteRecruitmentProcess(
		long recruitmentProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _recruitmentProcessLocalService.deleteRecruitmentProcess(recruitmentProcessId);
	}

	/**
	* Deletes the recruitment process from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProcess the recruitment process
	* @return the recruitment process that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitmentProcess deleteRecruitmentProcess(
		com.liferay.famocom.erpcloud.model.RecruitmentProcess recruitmentProcess) {
		return _recruitmentProcessLocalService.deleteRecruitmentProcess(recruitmentProcess);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _recruitmentProcessLocalService.dynamicQuery();
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
		return _recruitmentProcessLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.RecruitmentProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _recruitmentProcessLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.RecruitmentProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _recruitmentProcessLocalService.dynamicQuery(dynamicQuery,
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
		return _recruitmentProcessLocalService.dynamicQueryCount(dynamicQuery);
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
		return _recruitmentProcessLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.RecruitmentProcess fetchRecruitmentProcess(
		long recruitmentProcessId) {
		return _recruitmentProcessLocalService.fetchRecruitmentProcess(recruitmentProcessId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _recruitmentProcessLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _recruitmentProcessLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _recruitmentProcessLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _recruitmentProcessLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the recruitment process with the primary key.
	*
	* @param recruitmentProcessId the primary key of the recruitment process
	* @return the recruitment process
	* @throws PortalException if a recruitment process with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitmentProcess getRecruitmentProcess(
		long recruitmentProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _recruitmentProcessLocalService.getRecruitmentProcess(recruitmentProcessId);
	}

	/**
	* Returns a range of all the recruitment processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.RecruitmentProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of recruitment processes
	* @param end the upper bound of the range of recruitment processes (not inclusive)
	* @return the range of recruitment processes
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.RecruitmentProcess> getRecruitmentProcesses(
		int start, int end) {
		return _recruitmentProcessLocalService.getRecruitmentProcesses(start,
			end);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.RecruitmentProcess> getRecruitmentProcessesBystatus(
		long groupId, int status) {
		return _recruitmentProcessLocalService.getRecruitmentProcessesBystatus(groupId,
			status);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.RecruitmentProcess> getRecruitmentProcessesByStatus(
		long groupId, int status, int start, int end) {
		return _recruitmentProcessLocalService.getRecruitmentProcessesByStatus(groupId,
			status, start, end);
	}

	/**
	* Returns the number of recruitment processes.
	*
	* @return the number of recruitment processes
	*/
	@Override
	public int getRecruitmentProcessesCount() {
		return _recruitmentProcessLocalService.getRecruitmentProcessesCount();
	}

	/**
	* Updates the recruitment process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProcess the recruitment process
	* @return the recruitment process that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitmentProcess updateRecruitmentProcess(
		com.liferay.famocom.erpcloud.model.RecruitmentProcess recruitmentProcess) {
		return _recruitmentProcessLocalService.updateRecruitmentProcess(recruitmentProcess);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.RecruitmentProcess updateStatus(
		long userId, long recruitmentProcessId, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return _recruitmentProcessLocalService.updateStatus(userId,
			recruitmentProcessId, status, serviceContext);
	}

	@Override
	public RecruitmentProcessLocalService getWrappedService() {
		return _recruitmentProcessLocalService;
	}

	@Override
	public void setWrappedService(
		RecruitmentProcessLocalService recruitmentProcessLocalService) {
		_recruitmentProcessLocalService = recruitmentProcessLocalService;
	}

	private RecruitmentProcessLocalService _recruitmentProcessLocalService;
}