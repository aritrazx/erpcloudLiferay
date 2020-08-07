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
 * Provides a wrapper for {@link TaskMasterMappingLocalService}.
 *
 * @author Samaresh
 * @see TaskMasterMappingLocalService
 * @generated
 */
@ProviderType
public class TaskMasterMappingLocalServiceWrapper
	implements TaskMasterMappingLocalService,
		ServiceWrapper<TaskMasterMappingLocalService> {
	public TaskMasterMappingLocalServiceWrapper(
		TaskMasterMappingLocalService taskMasterMappingLocalService) {
		_taskMasterMappingLocalService = taskMasterMappingLocalService;
	}

	/**
	* Adds the task master mapping to the database. Also notifies the appropriate model listeners.
	*
	* @param taskMasterMapping the task master mapping
	* @return the task master mapping that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaskMasterMapping addTaskMasterMapping(
		com.liferay.famocom.erpcloud.model.TaskMasterMapping taskMasterMapping) {
		return _taskMasterMappingLocalService.addTaskMasterMapping(taskMasterMapping);
	}

	/**
	* Creates a new task master mapping with the primary key. Does not add the task master mapping to the database.
	*
	* @param taskMappingId the primary key for the new task master mapping
	* @return the new task master mapping
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaskMasterMapping createTaskMasterMapping(
		long taskMappingId) {
		return _taskMasterMappingLocalService.createTaskMasterMapping(taskMappingId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskMasterMappingLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the task master mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskMappingId the primary key of the task master mapping
	* @return the task master mapping that was removed
	* @throws PortalException if a task master mapping with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaskMasterMapping deleteTaskMasterMapping(
		long taskMappingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskMasterMappingLocalService.deleteTaskMasterMapping(taskMappingId);
	}

	/**
	* Deletes the task master mapping from the database. Also notifies the appropriate model listeners.
	*
	* @param taskMasterMapping the task master mapping
	* @return the task master mapping that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaskMasterMapping deleteTaskMasterMapping(
		com.liferay.famocom.erpcloud.model.TaskMasterMapping taskMasterMapping) {
		return _taskMasterMappingLocalService.deleteTaskMasterMapping(taskMasterMapping);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taskMasterMappingLocalService.dynamicQuery();
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
		return _taskMasterMappingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaskMasterMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taskMasterMappingLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaskMasterMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taskMasterMappingLocalService.dynamicQuery(dynamicQuery, start,
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
		return _taskMasterMappingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _taskMasterMappingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.TaskMasterMapping fetchTaskMasterMapping(
		long taskMappingId) {
		return _taskMasterMappingLocalService.fetchTaskMasterMapping(taskMappingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _taskMasterMappingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _taskMasterMappingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskMasterMappingLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskMasterMappingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the task master mapping with the primary key.
	*
	* @param taskMappingId the primary key of the task master mapping
	* @return the task master mapping
	* @throws PortalException if a task master mapping with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaskMasterMapping getTaskMasterMapping(
		long taskMappingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskMasterMappingLocalService.getTaskMasterMapping(taskMappingId);
	}

	/**
	* Returns a range of all the task master mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaskMasterMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task master mappings
	* @param end the upper bound of the range of task master mappings (not inclusive)
	* @return the range of task master mappings
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.TaskMasterMapping> getTaskMasterMappings(
		int start, int end) {
		return _taskMasterMappingLocalService.getTaskMasterMappings(start, end);
	}

	/**
	* Returns the number of task master mappings.
	*
	* @return the number of task master mappings
	*/
	@Override
	public int getTaskMasterMappingsCount() {
		return _taskMasterMappingLocalService.getTaskMasterMappingsCount();
	}

	/**
	* Updates the task master mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taskMasterMapping the task master mapping
	* @return the task master mapping that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaskMasterMapping updateTaskMasterMapping(
		com.liferay.famocom.erpcloud.model.TaskMasterMapping taskMasterMapping) {
		return _taskMasterMappingLocalService.updateTaskMasterMapping(taskMasterMapping);
	}

	@Override
	public TaskMasterMappingLocalService getWrappedService() {
		return _taskMasterMappingLocalService;
	}

	@Override
	public void setWrappedService(
		TaskMasterMappingLocalService taskMasterMappingLocalService) {
		_taskMasterMappingLocalService = taskMasterMappingLocalService;
	}

	private TaskMasterMappingLocalService _taskMasterMappingLocalService;
}