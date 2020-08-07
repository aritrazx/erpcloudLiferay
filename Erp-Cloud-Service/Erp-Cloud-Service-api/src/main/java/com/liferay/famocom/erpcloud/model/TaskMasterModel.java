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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TaskMaster service. Represents a row in the &quot;taskMaster&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.TaskMasterModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.TaskMasterImpl}.
 * </p>
 *
 * @author Samaresh
 * @see TaskMaster
 * @see com.liferay.famocom.erpcloud.model.impl.TaskMasterImpl
 * @see com.liferay.famocom.erpcloud.model.impl.TaskMasterModelImpl
 * @generated
 */
@ProviderType
public interface TaskMasterModel extends BaseModel<TaskMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a task master model instance should use the {@link TaskMaster} interface instead.
	 */

	/**
	 * Returns the primary key of this task master.
	 *
	 * @return the primary key of this task master
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this task master.
	 *
	 * @param primaryKey the primary key of this task master
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the task ID of this task master.
	 *
	 * @return the task ID of this task master
	 */
	public long getTaskId();

	/**
	 * Sets the task ID of this task master.
	 *
	 * @param taskId the task ID of this task master
	 */
	public void setTaskId(long taskId);

	/**
	 * Returns the task name of this task master.
	 *
	 * @return the task name of this task master
	 */
	@AutoEscape
	public String getTaskName();

	/**
	 * Sets the task name of this task master.
	 *
	 * @param taskName the task name of this task master
	 */
	public void setTaskName(String taskName);

	/**
	 * Returns the task desc of this task master.
	 *
	 * @return the task desc of this task master
	 */
	@AutoEscape
	public String getTaskDesc();

	/**
	 * Sets the task desc of this task master.
	 *
	 * @param taskDesc the task desc of this task master
	 */
	public void setTaskDesc(String taskDesc);

	/**
	 * Returns the status of this task master.
	 *
	 * @return the status of this task master
	 */
	public int getStatus();

	/**
	 * Sets the status of this task master.
	 *
	 * @param status the status of this task master
	 */
	public void setStatus(int status);

	/**
	 * Returns the create date of this task master.
	 *
	 * @return the create date of this task master
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this task master.
	 *
	 * @param createDate the create date of this task master
	 */
	public void setCreateDate(Date createDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(TaskMaster taskMaster);

	@Override
	public int hashCode();

	@Override
	public CacheModel<TaskMaster> toCacheModel();

	@Override
	public TaskMaster toEscapedModel();

	@Override
	public TaskMaster toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}