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
 * Provides a wrapper for {@link ProjectMasterLocalService}.
 *
 * @author Samaresh
 * @see ProjectMasterLocalService
 * @generated
 */
@ProviderType
public class ProjectMasterLocalServiceWrapper
	implements ProjectMasterLocalService,
		ServiceWrapper<ProjectMasterLocalService> {
	public ProjectMasterLocalServiceWrapper(
		ProjectMasterLocalService projectMasterLocalService) {
		_projectMasterLocalService = projectMasterLocalService;
	}

	/**
	* Adds the project master to the database. Also notifies the appropriate model listeners.
	*
	* @param projectMaster the project master
	* @return the project master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectMaster addProjectMaster(
		com.liferay.famocom.erpcloud.model.ProjectMaster projectMaster) {
		return _projectMasterLocalService.addProjectMaster(projectMaster);
	}

	/**
	* Creates a new project master with the primary key. Does not add the project master to the database.
	*
	* @param projectId the primary key for the new project master
	* @return the new project master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectMaster createProjectMaster(
		long projectId) {
		return _projectMasterLocalService.createProjectMaster(projectId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectMasterLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the project master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the project master
	* @return the project master that was removed
	* @throws PortalException if a project master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectMaster deleteProjectMaster(
		long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectMasterLocalService.deleteProjectMaster(projectId);
	}

	/**
	* Deletes the project master from the database. Also notifies the appropriate model listeners.
	*
	* @param projectMaster the project master
	* @return the project master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectMaster deleteProjectMaster(
		com.liferay.famocom.erpcloud.model.ProjectMaster projectMaster) {
		return _projectMasterLocalService.deleteProjectMaster(projectMaster);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectMasterLocalService.dynamicQuery();
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
		return _projectMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectMasterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectMasterLocalService.dynamicQuery(dynamicQuery, start,
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
		return _projectMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.ProjectMaster fetchProjectMaster(
		long projectId) {
		return _projectMasterLocalService.fetchProjectMaster(projectId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ProjectMaster> findByEmployeeId(
		long employeeId) {
		return _projectMasterLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ProjectMaster> findByprojectId(
		long employeeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return _projectMasterLocalService.findByprojectId(employeeId, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _projectMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _projectMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the project master with the primary key.
	*
	* @param projectId the primary key of the project master
	* @return the project master
	* @throws PortalException if a project master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectMaster getProjectMaster(
		long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectMasterLocalService.getProjectMaster(projectId);
	}

	/**
	* Returns a range of all the project masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project masters
	* @param end the upper bound of the range of project masters (not inclusive)
	* @return the range of project masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ProjectMaster> getProjectMasters(
		int start, int end) {
		return _projectMasterLocalService.getProjectMasters(start, end);
	}

	/**
	* Returns the number of project masters.
	*
	* @return the number of project masters
	*/
	@Override
	public int getProjectMastersCount() {
		return _projectMasterLocalService.getProjectMastersCount();
	}

	/**
	* Updates the project master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectMaster the project master
	* @return the project master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectMaster updateProjectMaster(
		com.liferay.famocom.erpcloud.model.ProjectMaster projectMaster) {
		return _projectMasterLocalService.updateProjectMaster(projectMaster);
	}

	@Override
	public ProjectMasterLocalService getWrappedService() {
		return _projectMasterLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectMasterLocalService projectMasterLocalService) {
		_projectMasterLocalService = projectMasterLocalService;
	}

	private ProjectMasterLocalService _projectMasterLocalService;
}