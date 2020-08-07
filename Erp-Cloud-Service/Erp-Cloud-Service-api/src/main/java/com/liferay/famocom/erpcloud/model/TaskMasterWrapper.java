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
 * This class is a wrapper for {@link TaskMaster}.
 * </p>
 *
 * @author Samaresh
 * @see TaskMaster
 * @generated
 */
@ProviderType
public class TaskMasterWrapper implements TaskMaster, ModelWrapper<TaskMaster> {
	public TaskMasterWrapper(TaskMaster taskMaster) {
		_taskMaster = taskMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return TaskMaster.class;
	}

	@Override
	public String getModelClassName() {
		return TaskMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskId", getTaskId());
		attributes.put("taskName", getTaskName());
		attributes.put("taskDesc", getTaskDesc());
		attributes.put("status", getStatus());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		String taskName = (String)attributes.get("taskName");

		if (taskName != null) {
			setTaskName(taskName);
		}

		String taskDesc = (String)attributes.get("taskDesc");

		if (taskDesc != null) {
			setTaskDesc(taskDesc);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public Object clone() {
		return new TaskMasterWrapper((TaskMaster)_taskMaster.clone());
	}

	@Override
	public int compareTo(TaskMaster taskMaster) {
		return _taskMaster.compareTo(taskMaster);
	}

	/**
	* Returns the create date of this task master.
	*
	* @return the create date of this task master
	*/
	@Override
	public Date getCreateDate() {
		return _taskMaster.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _taskMaster.getExpandoBridge();
	}

	/**
	* Returns the primary key of this task master.
	*
	* @return the primary key of this task master
	*/
	@Override
	public long getPrimaryKey() {
		return _taskMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taskMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this task master.
	*
	* @return the status of this task master
	*/
	@Override
	public int getStatus() {
		return _taskMaster.getStatus();
	}

	/**
	* Returns the task desc of this task master.
	*
	* @return the task desc of this task master
	*/
	@Override
	public String getTaskDesc() {
		return _taskMaster.getTaskDesc();
	}

	/**
	* Returns the task ID of this task master.
	*
	* @return the task ID of this task master
	*/
	@Override
	public long getTaskId() {
		return _taskMaster.getTaskId();
	}

	/**
	* Returns the task name of this task master.
	*
	* @return the task name of this task master
	*/
	@Override
	public String getTaskName() {
		return _taskMaster.getTaskName();
	}

	@Override
	public int hashCode() {
		return _taskMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _taskMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _taskMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _taskMaster.isNew();
	}

	@Override
	public void persist() {
		_taskMaster.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taskMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this task master.
	*
	* @param createDate the create date of this task master
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_taskMaster.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_taskMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_taskMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_taskMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_taskMaster.setNew(n);
	}

	/**
	* Sets the primary key of this task master.
	*
	* @param primaryKey the primary key of this task master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taskMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_taskMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this task master.
	*
	* @param status the status of this task master
	*/
	@Override
	public void setStatus(int status) {
		_taskMaster.setStatus(status);
	}

	/**
	* Sets the task desc of this task master.
	*
	* @param taskDesc the task desc of this task master
	*/
	@Override
	public void setTaskDesc(String taskDesc) {
		_taskMaster.setTaskDesc(taskDesc);
	}

	/**
	* Sets the task ID of this task master.
	*
	* @param taskId the task ID of this task master
	*/
	@Override
	public void setTaskId(long taskId) {
		_taskMaster.setTaskId(taskId);
	}

	/**
	* Sets the task name of this task master.
	*
	* @param taskName the task name of this task master
	*/
	@Override
	public void setTaskName(String taskName) {
		_taskMaster.setTaskName(taskName);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TaskMaster> toCacheModel() {
		return _taskMaster.toCacheModel();
	}

	@Override
	public TaskMaster toEscapedModel() {
		return new TaskMasterWrapper(_taskMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _taskMaster.toString();
	}

	@Override
	public TaskMaster toUnescapedModel() {
		return new TaskMasterWrapper(_taskMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _taskMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskMasterWrapper)) {
			return false;
		}

		TaskMasterWrapper taskMasterWrapper = (TaskMasterWrapper)obj;

		if (Objects.equals(_taskMaster, taskMasterWrapper._taskMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public TaskMaster getWrappedModel() {
		return _taskMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _taskMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _taskMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_taskMaster.resetOriginalValues();
	}

	private final TaskMaster _taskMaster;
}