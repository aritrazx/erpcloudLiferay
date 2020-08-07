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
 * Provides a wrapper for {@link ProjectRoleLocalService}.
 *
 * @author Samaresh
 * @see ProjectRoleLocalService
 * @generated
 */
@ProviderType
public class ProjectRoleLocalServiceWrapper implements ProjectRoleLocalService,
	ServiceWrapper<ProjectRoleLocalService> {
	public ProjectRoleLocalServiceWrapper(
		ProjectRoleLocalService projectRoleLocalService) {
		_projectRoleLocalService = projectRoleLocalService;
	}

	/**
	* Adds the project role to the database. Also notifies the appropriate model listeners.
	*
	* @param projectRole the project role
	* @return the project role that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectRole addProjectRole(
		com.liferay.famocom.erpcloud.model.ProjectRole projectRole) {
		return _projectRoleLocalService.addProjectRole(projectRole);
	}

	/**
	* Creates a new project role with the primary key. Does not add the project role to the database.
	*
	* @param roleId the primary key for the new project role
	* @return the new project role
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectRole createProjectRole(
		long roleId) {
		return _projectRoleLocalService.createProjectRole(roleId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectRoleLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the project role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roleId the primary key of the project role
	* @return the project role that was removed
	* @throws PortalException if a project role with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectRole deleteProjectRole(
		long roleId) throws com.liferay.portal.kernel.exception.PortalException {
		return _projectRoleLocalService.deleteProjectRole(roleId);
	}

	/**
	* Deletes the project role from the database. Also notifies the appropriate model listeners.
	*
	* @param projectRole the project role
	* @return the project role that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectRole deleteProjectRole(
		com.liferay.famocom.erpcloud.model.ProjectRole projectRole) {
		return _projectRoleLocalService.deleteProjectRole(projectRole);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectRoleLocalService.dynamicQuery();
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
		return _projectRoleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectRoleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectRoleLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _projectRoleLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectRoleLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.ProjectRole fetchProjectRole(
		long roleId) {
		return _projectRoleLocalService.fetchProjectRole(roleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _projectRoleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _projectRoleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectRoleLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectRoleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the project role with the primary key.
	*
	* @param roleId the primary key of the project role
	* @return the project role
	* @throws PortalException if a project role with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectRole getProjectRole(
		long roleId) throws com.liferay.portal.kernel.exception.PortalException {
		return _projectRoleLocalService.getProjectRole(roleId);
	}

	/**
	* Returns a range of all the project roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project roles
	* @param end the upper bound of the range of project roles (not inclusive)
	* @return the range of project roles
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ProjectRole> getProjectRoles(
		int start, int end) {
		return _projectRoleLocalService.getProjectRoles(start, end);
	}

	/**
	* Returns the number of project roles.
	*
	* @return the number of project roles
	*/
	@Override
	public int getProjectRolesCount() {
		return _projectRoleLocalService.getProjectRolesCount();
	}

	/**
	* Updates the project role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectRole the project role
	* @return the project role that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectRole updateProjectRole(
		com.liferay.famocom.erpcloud.model.ProjectRole projectRole) {
		return _projectRoleLocalService.updateProjectRole(projectRole);
	}

	@Override
	public ProjectRoleLocalService getWrappedService() {
		return _projectRoleLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectRoleLocalService projectRoleLocalService) {
		_projectRoleLocalService = projectRoleLocalService;
	}

	private ProjectRoleLocalService _projectRoleLocalService;
}