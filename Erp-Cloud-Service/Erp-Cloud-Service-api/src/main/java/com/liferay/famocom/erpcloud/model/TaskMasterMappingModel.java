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

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TaskMasterMapping service. Represents a row in the &quot;taskMasterMapping&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.TaskMasterMappingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.TaskMasterMappingImpl}.
 * </p>
 *
 * @author Samaresh
 * @see TaskMasterMapping
 * @see com.liferay.famocom.erpcloud.model.impl.TaskMasterMappingImpl
 * @see com.liferay.famocom.erpcloud.model.impl.TaskMasterMappingModelImpl
 * @generated
 */
@ProviderType
public interface TaskMasterMappingModel extends BaseModel<TaskMasterMapping> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a task master mapping model instance should use the {@link TaskMasterMapping} interface instead.
	 */

	/**
	 * Returns the primary key of this task master mapping.
	 *
	 * @return the primary key of this task master mapping
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this task master mapping.
	 *
	 * @param primaryKey the primary key of this task master mapping
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the task mapping ID of this task master mapping.
	 *
	 * @return the task mapping ID of this task master mapping
	 */
	public long getTaskMappingId();

	/**
	 * Sets the task mapping ID of this task master mapping.
	 *
	 * @param taskMappingId the task mapping ID of this task master mapping
	 */
	public void setTaskMappingId(long taskMappingId);

	/**
	 * Returns the task ID of this task master mapping.
	 *
	 * @return the task ID of this task master mapping
	 */
	public long getTaskId();

	/**
	 * Sets the task ID of this task master mapping.
	 *
	 * @param taskId the task ID of this task master mapping
	 */
	public void setTaskId(long taskId);

	/**
	 * Returns the project ID of this task master mapping.
	 *
	 * @return the project ID of this task master mapping
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this task master mapping.
	 *
	 * @param projectId the project ID of this task master mapping
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the create date of this task master mapping.
	 *
	 * @return the create date of this task master mapping
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this task master mapping.
	 *
	 * @param createDate the create date of this task master mapping
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
	public int compareTo(TaskMasterMapping taskMasterMapping);

	@Override
	public int hashCode();

	@Override
	public CacheModel<TaskMasterMapping> toCacheModel();

	@Override
	public TaskMasterMapping toEscapedModel();

	@Override
	public TaskMasterMapping toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}