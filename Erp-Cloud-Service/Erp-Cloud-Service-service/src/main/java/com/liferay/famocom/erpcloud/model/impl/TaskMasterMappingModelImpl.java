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

package com.liferay.famocom.erpcloud.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.famocom.erpcloud.model.TaskMasterMapping;
import com.liferay.famocom.erpcloud.model.TaskMasterMappingModel;
import com.liferay.famocom.erpcloud.model.TaskMasterMappingSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TaskMasterMapping service. Represents a row in the &quot;taskMasterMapping&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TaskMasterMappingModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TaskMasterMappingImpl}.
 * </p>
 *
 * @author Samaresh
 * @see TaskMasterMappingImpl
 * @see TaskMasterMapping
 * @see TaskMasterMappingModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TaskMasterMappingModelImpl extends BaseModelImpl<TaskMasterMapping>
	implements TaskMasterMappingModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a task master mapping model instance should use the {@link TaskMasterMapping} interface instead.
	 */
	public static final String TABLE_NAME = "taskMasterMapping";
	public static final Object[][] TABLE_COLUMNS = {
			{ "taskMappingId", Types.BIGINT },
			{ "taskId", Types.BIGINT },
			{ "projectId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("taskMappingId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("taskId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table taskMasterMapping (taskMappingId LONG not null primary key,taskId LONG,projectId LONG,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table taskMasterMapping";
	public static final String ORDER_BY_JPQL = " ORDER BY taskMasterMapping.taskMappingId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY taskMasterMapping.taskMappingId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.TaskMasterMapping"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.TaskMasterMapping"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TaskMasterMapping toModel(TaskMasterMappingSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TaskMasterMapping model = new TaskMasterMappingImpl();

		model.setTaskMappingId(soapModel.getTaskMappingId());
		model.setTaskId(soapModel.getTaskId());
		model.setProjectId(soapModel.getProjectId());
		model.setCreateDate(soapModel.getCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TaskMasterMapping> toModels(
		TaskMasterMappingSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TaskMasterMapping> models = new ArrayList<TaskMasterMapping>(soapModels.length);

		for (TaskMasterMappingSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.TaskMasterMapping"));

	public TaskMasterMappingModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _taskMappingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTaskMappingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taskMappingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public long getTaskMappingId() {
		return _taskMappingId;
	}

	@Override
	public void setTaskMappingId(long taskMappingId) {
		_taskMappingId = taskMappingId;
	}

	@JSON
	@Override
	public long getTaskId() {
		return _taskId;
	}

	@Override
	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	@JSON
	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TaskMasterMapping.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TaskMasterMapping toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TaskMasterMapping)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TaskMasterMappingImpl taskMasterMappingImpl = new TaskMasterMappingImpl();

		taskMasterMappingImpl.setTaskMappingId(getTaskMappingId());
		taskMasterMappingImpl.setTaskId(getTaskId());
		taskMasterMappingImpl.setProjectId(getProjectId());
		taskMasterMappingImpl.setCreateDate(getCreateDate());

		taskMasterMappingImpl.resetOriginalValues();

		return taskMasterMappingImpl;
	}

	@Override
	public int compareTo(TaskMasterMapping taskMasterMapping) {
		long primaryKey = taskMasterMapping.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskMasterMapping)) {
			return false;
		}

		TaskMasterMapping taskMasterMapping = (TaskMasterMapping)obj;

		long primaryKey = taskMasterMapping.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<TaskMasterMapping> toCacheModel() {
		TaskMasterMappingCacheModel taskMasterMappingCacheModel = new TaskMasterMappingCacheModel();

		taskMasterMappingCacheModel.taskMappingId = getTaskMappingId();

		taskMasterMappingCacheModel.taskId = getTaskId();

		taskMasterMappingCacheModel.projectId = getProjectId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			taskMasterMappingCacheModel.createDate = createDate.getTime();
		}
		else {
			taskMasterMappingCacheModel.createDate = Long.MIN_VALUE;
		}

		return taskMasterMappingCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{taskMappingId=");
		sb.append(getTaskMappingId());
		sb.append(", taskId=");
		sb.append(getTaskId());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.TaskMasterMapping");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>taskMappingId</column-name><column-value><![CDATA[");
		sb.append(getTaskMappingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskId</column-name><column-value><![CDATA[");
		sb.append(getTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TaskMasterMapping.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TaskMasterMapping.class, ModelWrapper.class
		};
	private long _taskMappingId;
	private long _taskId;
	private long _projectId;
	private Date _createDate;
	private TaskMasterMapping _escapedModel;
}