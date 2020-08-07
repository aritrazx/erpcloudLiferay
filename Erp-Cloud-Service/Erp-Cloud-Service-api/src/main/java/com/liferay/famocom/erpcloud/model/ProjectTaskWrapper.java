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

package com.liferay.famocom.erpcloud.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ProjectTask}.
 * </p>
 *
 * @author Samaresh
 * @see ProjectTask
 * @generated
 */
@ProviderType
public class ProjectTaskWrapper implements ProjectTask,
	ModelWrapper<ProjectTask> {
	public ProjectTaskWrapper(ProjectTask projectTask) {
		_projectTask = projectTask;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectTask.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectTask.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectTaskId", getProjectTaskId());
		attributes.put("projectId", getProjectId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("taskId", getTaskId());
		attributes.put("taskName", getTaskName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("hours", getHours());
		attributes.put("addedDate", getAddedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectTaskId = (Long)attributes.get("projectTaskId");

		if (projectTaskId != null) {
			setProjectTaskId(projectTaskId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		String taskName = (String)attributes.get("taskName");

		if (taskName != null) {
			setTaskName(taskName);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Double hours = (Double)attributes.get("hours");

		if (hours != null) {
			setHours(hours);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public Object clone() {
		return new ProjectTaskWrapper((ProjectTask)_projectTask.clone());
	}

	@Override
	public int compareTo(ProjectTask projectTask) {
		return _projectTask.compareTo(projectTask);
	}

	/**
	* Returns the added date of this project task.
	*
	* @return the added date of this project task
	*/
	@Override
	public Date getAddedDate() {
		return _projectTask.getAddedDate();
	}

	/**
	* Returns the employee ID of this project task.
	*
	* @return the employee ID of this project task
	*/
	@Override
	public long getEmployeeId() {
		return _projectTask.getEmployeeId();
	}

	/**
	* Returns the end date of this project task.
	*
	* @return the end date of this project task
	*/
	@Override
	public Date getEndDate() {
		return _projectTask.getEndDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectTask.getExpandoBridge();
	}

	/**
	* Returns the hours of this project task.
	*
	* @return the hours of this project task
	*/
	@Override
	public double getHours() {
		return _projectTask.getHours();
	}

	/**
	* Returns the primary key of this project task.
	*
	* @return the primary key of this project task
	*/
	@Override
	public long getPrimaryKey() {
		return _projectTask.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectTask.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this project task.
	*
	* @return the project ID of this project task
	*/
	@Override
	public long getProjectId() {
		return _projectTask.getProjectId();
	}

	/**
	* Returns the project task ID of this project task.
	*
	* @return the project task ID of this project task
	*/
	@Override
	public long getProjectTaskId() {
		return _projectTask.getProjectTaskId();
	}

	/**
	* Returns the start date of this project task.
	*
	* @return the start date of this project task
	*/
	@Override
	public Date getStartDate() {
		return _projectTask.getStartDate();
	}

	/**
	* Returns the task ID of this project task.
	*
	* @return the task ID of this project task
	*/
	@Override
	public long getTaskId() {
		return _projectTask.getTaskId();
	}

	/**
	* Returns the task name of this project task.
	*
	* @return the task name of this project task
	*/
	@Override
	public String getTaskName() {
		return _projectTask.getTaskName();
	}

	@Override
	public int hashCode() {
		return _projectTask.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _projectTask.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectTask.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectTask.isNew();
	}

	@Override
	public void persist() {
		_projectTask.persist();
	}

	/**
	* Sets the added date of this project task.
	*
	* @param addedDate the added date of this project task
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_projectTask.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectTask.setCachedModel(cachedModel);
	}

	/**
	* Sets the employee ID of this project task.
	*
	* @param employeeId the employee ID of this project task
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_projectTask.setEmployeeId(employeeId);
	}

	/**
	* Sets the end date of this project task.
	*
	* @param endDate the end date of this project task
	*/
	@Override
	public void setEndDate(Date endDate) {
		_projectTask.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectTask.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectTask.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectTask.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hours of this project task.
	*
	* @param hours the hours of this project task
	*/
	@Override
	public void setHours(double hours) {
		_projectTask.setHours(hours);
	}

	@Override
	public void setNew(boolean n) {
		_projectTask.setNew(n);
	}

	/**
	* Sets the primary key of this project task.
	*
	* @param primaryKey the primary key of this project task
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectTask.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectTask.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this project task.
	*
	* @param projectId the project ID of this project task
	*/
	@Override
	public void setProjectId(long projectId) {
		_projectTask.setProjectId(projectId);
	}

	/**
	* Sets the project task ID of this project task.
	*
	* @param projectTaskId the project task ID of this project task
	*/
	@Override
	public void setProjectTaskId(long projectTaskId) {
		_projectTask.setProjectTaskId(projectTaskId);
	}

	/**
	* Sets the start date of this project task.
	*
	* @param startDate the start date of this project task
	*/
	@Override
	public void setStartDate(Date startDate) {
		_projectTask.setStartDate(startDate);
	}

	/**
	* Sets the task ID of this project task.
	*
	* @param taskId the task ID of this project task
	*/
	@Override
	public void setTaskId(long taskId) {
		_projectTask.setTaskId(taskId);
	}

	/**
	* Sets the task name of this project task.
	*
	* @param taskName the task name of this project task
	*/
	@Override
	public void setTaskName(String taskName) {
		_projectTask.setTaskName(taskName);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectTask> toCacheModel() {
		return _projectTask.toCacheModel();
	}

	@Override
	public ProjectTask toEscapedModel() {
		return new ProjectTaskWrapper(_projectTask.toEscapedModel());
	}

	@Override
	public String toString() {
		return _projectTask.toString();
	}

	@Override
	public ProjectTask toUnescapedModel() {
		return new ProjectTaskWrapper(_projectTask.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _projectTask.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectTaskWrapper)) {
			return false;
		}

		ProjectTaskWrapper projectTaskWrapper = (ProjectTaskWrapper)obj;

		if (Objects.equals(_projectTask, projectTaskWrapper._projectTask)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectTask getWrappedModel() {
		return _projectTask;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectTask.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectTask.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectTask.resetOriginalValues();
	}

	private final ProjectTask _projectTask;
}