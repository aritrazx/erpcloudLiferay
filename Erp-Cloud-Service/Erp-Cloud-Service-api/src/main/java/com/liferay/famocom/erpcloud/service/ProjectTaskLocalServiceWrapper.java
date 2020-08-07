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
 * Provides a wrapper for {@link ProjectTaskLocalService}.
 *
 * @author Samaresh
 * @see ProjectTaskLocalService
 * @generated
 */
@ProviderType
public class ProjectTaskLocalServiceWrapper implements ProjectTaskLocalService,
	ServiceWrapper<ProjectTaskLocalService> {
	public ProjectTaskLocalServiceWrapper(
		ProjectTaskLocalService projectTaskLocalService) {
		_projectTaskLocalService = projectTaskLocalService;
	}

	/**
	* Adds the project task to the database. Also notifies the appropriate model listeners.
	*
	* @param projectTask the project task
	* @return the project task that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectTask addProjectTask(
		com.liferay.famocom.erpcloud.model.ProjectTask projectTask) {
		return _projectTaskLocalService.addProjectTask(projectTask);
	}

	/**
	* Creates a new project task with the primary key. Does not add the project task to the database.
	*
	* @param projectTaskId the primary key for the new project task
	* @return the new project task
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectTask createProjectTask(
		long projectTaskId) {
		return _projectTaskLocalService.createProjectTask(projectTaskId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectTaskLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the project task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task that was removed
	* @throws PortalException if a project task with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectTask deleteProjectTask(
		long projectTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectTaskLocalService.deleteProjectTask(projectTaskId);
	}

	/**
	* Deletes the project task from the database. Also notifies the appropriate model listeners.
	*
	* @param projectTask the project task
	* @return the project task that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectTask deleteProjectTask(
		com.liferay.famocom.erpcloud.model.ProjectTask projectTask) {
		return _projectTaskLocalService.deleteProjectTask(projectTask);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectTaskLocalService.dynamicQuery();
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
		return _projectTaskLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectTaskLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectTaskLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _projectTaskLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectTaskLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.ProjectTask fetchProjectTask(
		long projectTaskId) {
		return _projectTaskLocalService.fetchProjectTask(projectTaskId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _projectTaskLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _projectTaskLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectTaskLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectTaskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the project task with the primary key.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task
	* @throws PortalException if a project task with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectTask getProjectTask(
		long projectTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectTaskLocalService.getProjectTask(projectTaskId);
	}

	/**
	* Returns a range of all the project tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @return the range of project tasks
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ProjectTask> getProjectTasks(
		int start, int end) {
		return _projectTaskLocalService.getProjectTasks(start, end);
	}

	/**
	* Returns the number of project tasks.
	*
	* @return the number of project tasks
	*/
	@Override
	public int getProjectTasksCount() {
		return _projectTaskLocalService.getProjectTasksCount();
	}

	/**
	* Updates the project task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectTask the project task
	* @return the project task that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectTask updateProjectTask(
		com.liferay.famocom.erpcloud.model.ProjectTask projectTask) {
		return _projectTaskLocalService.updateProjectTask(projectTask);
	}

	@Override
	public ProjectTaskLocalService getWrappedService() {
		return _projectTaskLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectTaskLocalService projectTaskLocalService) {
		_projectTaskLocalService = projectTaskLocalService;
	}

	private ProjectTaskLocalService _projectTaskLocalService;
}