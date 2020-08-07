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
 * This class is a wrapper for {@link TaskMasterMapping}.
 * </p>
 *
 * @author Samaresh
 * @see TaskMasterMapping
 * @generated
 */
@ProviderType
public class TaskMasterMappingWrapper implements TaskMasterMapping,
	ModelWrapper<TaskMasterMapping> {
	public TaskMasterMappingWrapper(TaskMasterMapping taskMasterMapping) {
		_taskMasterMapping = taskMasterMapping;
	}

	@Override
	public Class<?> getModelClass() {
		return TaskMasterMapping.class;
	}

	@Override
	public String getModelClassName() {
		return TaskMasterMapping.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskMappingId", getTaskMappingId());
		attributes.put("taskId", getTaskId());
		attributes.put("projectId", getProjectId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskMappingId = (Long)attributes.get("taskMappingId");

		if (taskMappingId != null) {
			setTaskMappingId(taskMappingId);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public Object clone() {
		return new TaskMasterMappingWrapper((TaskMasterMapping)_taskMasterMapping.clone());
	}

	@Override
	public int compareTo(TaskMasterMapping taskMasterMapping) {
		return _taskMasterMapping.compareTo(taskMasterMapping);
	}

	/**
	* Returns the create date of this task master mapping.
	*
	* @return the create date of this task master mapping
	*/
	@Override
	public Date getCreateDate() {
		return _taskMasterMapping.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _taskMasterMapping.getExpandoBridge();
	}

	/**
	* Returns the primary key of this task master mapping.
	*
	* @return the primary key of this task master mapping
	*/
	@Override
	public long getPrimaryKey() {
		return _taskMasterMapping.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taskMasterMapping.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this task master mapping.
	*
	* @return the project ID of this task master mapping
	*/
	@Override
	public long getProjectId() {
		return _taskMasterMapping.getProjectId();
	}

	/**
	* Returns the task ID of this task master mapping.
	*
	* @return the task ID of this task master mapping
	*/
	@Override
	public long getTaskId() {
		return _taskMasterMapping.getTaskId();
	}

	/**
	* Returns the task mapping ID of this task master mapping.
	*
	* @return the task mapping ID of this task master mapping
	*/
	@Override
	public long getTaskMappingId() {
		return _taskMasterMapping.getTaskMappingId();
	}

	@Override
	public int hashCode() {
		return _taskMasterMapping.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _taskMasterMapping.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _taskMasterMapping.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _taskMasterMapping.isNew();
	}

	@Override
	public void persist() {
		_taskMasterMapping.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taskMasterMapping.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this task master mapping.
	*
	* @param createDate the create date of this task master mapping
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_taskMasterMapping.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_taskMasterMapping.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_taskMasterMapping.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_taskMasterMapping.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_taskMasterMapping.setNew(n);
	}

	/**
	* Sets the primary key of this task master mapping.
	*
	* @param primaryKey the primary key of this task master mapping
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taskMasterMapping.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_taskMasterMapping.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this task master mapping.
	*
	* @param projectId the project ID of this task master mapping
	*/
	@Override
	public void setProjectId(long projectId) {
		_taskMasterMapping.setProjectId(projectId);
	}

	/**
	* Sets the task ID of this task master mapping.
	*
	* @param taskId the task ID of this task master mapping
	*/
	@Override
	public void setTaskId(long taskId) {
		_taskMasterMapping.setTaskId(taskId);
	}

	/**
	* Sets the task mapping ID of this task master mapping.
	*
	* @param taskMappingId the task mapping ID of this task master mapping
	*/
	@Override
	public void setTaskMappingId(long taskMappingId) {
		_taskMasterMapping.setTaskMappingId(taskMappingId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TaskMasterMapping> toCacheModel() {
		return _taskMasterMapping.toCacheModel();
	}

	@Override
	public TaskMasterMapping toEscapedModel() {
		return new TaskMasterMappingWrapper(_taskMasterMapping.toEscapedModel());
	}

	@Override
	public String toString() {
		return _taskMasterMapping.toString();
	}

	@Override
	public TaskMasterMapping toUnescapedModel() {
		return new TaskMasterMappingWrapper(_taskMasterMapping.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _taskMasterMapping.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskMasterMappingWrapper)) {
			return false;
		}

		TaskMasterMappingWrapper taskMasterMappingWrapper = (TaskMasterMappingWrapper)obj;

		if (Objects.equals(_taskMasterMapping,
					taskMasterMappingWrapper._taskMasterMapping)) {
			return true;
		}

		return false;
	}

	@Override
	public TaskMasterMapping getWrappedModel() {
		return _taskMasterMapping;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _taskMasterMapping.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _taskMasterMapping.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_taskMasterMapping.resetOriginalValues();
	}

	private final TaskMasterMapping _taskMasterMapping;
}