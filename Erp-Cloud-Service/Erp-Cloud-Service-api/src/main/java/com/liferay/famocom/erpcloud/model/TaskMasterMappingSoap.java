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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.TaskMasterMappingServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.TaskMasterMappingServiceSoap
 * @generated
 */
@ProviderType
public class TaskMasterMappingSoap implements Serializable {
	public static TaskMasterMappingSoap toSoapModel(TaskMasterMapping model) {
		TaskMasterMappingSoap soapModel = new TaskMasterMappingSoap();

		soapModel.setTaskMappingId(model.getTaskMappingId());
		soapModel.setTaskId(model.getTaskId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static TaskMasterMappingSoap[] toSoapModels(
		TaskMasterMapping[] models) {
		TaskMasterMappingSoap[] soapModels = new TaskMasterMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaskMasterMappingSoap[][] toSoapModels(
		TaskMasterMapping[][] models) {
		TaskMasterMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaskMasterMappingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaskMasterMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaskMasterMappingSoap[] toSoapModels(
		List<TaskMasterMapping> models) {
		List<TaskMasterMappingSoap> soapModels = new ArrayList<TaskMasterMappingSoap>(models.size());

		for (TaskMasterMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaskMasterMappingSoap[soapModels.size()]);
	}

	public TaskMasterMappingSoap() {
	}

	public long getPrimaryKey() {
		return _taskMappingId;
	}

	public void setPrimaryKey(long pk) {
		setTaskMappingId(pk);
	}

	public long getTaskMappingId() {
		return _taskMappingId;
	}

	public void setTaskMappingId(long taskMappingId) {
		_taskMappingId = taskMappingId;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _taskMappingId;
	private long _taskId;
	private long _projectId;
	private Date _createDate;
}