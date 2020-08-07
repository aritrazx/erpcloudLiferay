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
 * Provides a wrapper for {@link RecruitProcessLocalService}.
 *
 * @author Samaresh
 * @see RecruitProcessLocalService
 * @generated
 */
@ProviderType
public class RecruitProcessLocalServiceWrapper
	implements RecruitProcessLocalService,
		ServiceWrapper<RecruitProcessLocalService> {
	public RecruitProcessLocalServiceWrapper(
		RecruitProcessLocalService recruitProcessLocalService) {
		_recruitProcessLocalService = recruitProcessLocalService;
	}

	/**
	* Adds the recruit process to the database. Also notifies the appropriate model listeners.
	*
	* @param recruitProcess the recruit process
	* @return the recruit process that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitProcess addRecruitProcess(
		com.liferay.famocom.erpcloud.model.RecruitProcess recruitProcess) {
		return _recruitProcessLocalService.addRecruitProcess(recruitProcess);
	}

	/**
	* Creates a new recruit process with the primary key. Does not add the recruit process to the database.
	*
	* @param recruitProcessId the primary key for the new recruit process
	* @return the new recruit process
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitProcess createRecruitProcess(
		long recruitProcessId) {
		return _recruitProcessLocalService.createRecruitProcess(recruitProcessId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _recruitProcessLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the recruit process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitProcessId the primary key of the recruit process
	* @return the recruit process that was removed
	* @throws PortalException if a recruit process with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitProcess deleteRecruitProcess(
		long recruitProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _recruitProcessLocalService.deleteRecruitProcess(recruitProcessId);
	}

	/**
	* Deletes the recruit process from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitProcess the recruit process
	* @return the recruit process that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitProcess deleteRecruitProcess(
		com.liferay.famocom.erpcloud.model.RecruitProcess recruitProcess) {
		return _recruitProcessLocalService.deleteRecruitProcess(recruitProcess);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _recruitProcessLocalService.dynamicQuery();
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
		return _recruitProcessLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _recruitProcessLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _recruitProcessLocalService.dynamicQuery(dynamicQuery, start,
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
		return _recruitProcessLocalService.dynamicQueryCount(dynamicQuery);
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
		return _recruitProcessLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.RecruitProcess fetchRecruitProcess(
		long recruitProcessId) {
		return _recruitProcessLocalService.fetchRecruitProcess(recruitProcessId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.RecruitProcess findByrecruitProcess(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitProcessLocalService.findByrecruitProcess(employeeId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.RecruitProcess> findByrecruitProcessCol(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return _recruitProcessLocalService.findByrecruitProcessCol(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _recruitProcessLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _recruitProcessLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _recruitProcessLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _recruitProcessLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the recruit process with the primary key.
	*
	* @param recruitProcessId the primary key of the recruit process
	* @return the recruit process
	* @throws PortalException if a recruit process with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitProcess getRecruitProcess(
		long recruitProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _recruitProcessLocalService.getRecruitProcess(recruitProcessId);
	}

	/**
	* Returns a range of all the recruit processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of recruit processes
	* @param end the upper bound of the range of recruit processes (not inclusive)
	* @return the range of recruit processes
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.RecruitProcess> getRecruitProcesses(
		int start, int end) {
		return _recruitProcessLocalService.getRecruitProcesses(start, end);
	}

	/**
	* Returns the number of recruit processes.
	*
	* @return the number of recruit processes
	*/
	@Override
	public int getRecruitProcessesCount() {
		return _recruitProcessLocalService.getRecruitProcessesCount();
	}

	@Override
	public java.util.Map<Long, String> getResumeFileUpload(String name,
		java.io.File file, long userId, String donaminName)
		throws java.io.IOException,
			com.liferay.portal.kernel.exception.PortalException {
		return _recruitProcessLocalService.getResumeFileUpload(name, file,
			userId, donaminName);
	}

	/**
	* Updates the recruit process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitProcess the recruit process
	* @return the recruit process that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RecruitProcess updateRecruitProcess(
		com.liferay.famocom.erpcloud.model.RecruitProcess recruitProcess) {
		return _recruitProcessLocalService.updateRecruitProcess(recruitProcess);
	}

	@Override
	public RecruitProcessLocalService getWrappedService() {
		return _recruitProcessLocalService;
	}

	@Override
	public void setWrappedService(
		RecruitProcessLocalService recruitProcessLocalService) {
		_recruitProcessLocalService = recruitProcessLocalService;
	}

	private RecruitProcessLocalService _recruitProcessLocalService;
}