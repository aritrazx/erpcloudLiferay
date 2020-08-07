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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.TaskMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.TaskMasterServiceSoap
 * @generated
 */
@ProviderType
public class TaskMasterSoap implements Serializable {
	public static TaskMasterSoap toSoapModel(TaskMaster model) {
		TaskMasterSoap soapModel = new TaskMasterSoap();

		soapModel.setTaskId(model.getTaskId());
		soapModel.setTaskName(model.getTaskName());
		soapModel.setTaskDesc(model.getTaskDesc());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static TaskMasterSoap[] toSoapModels(TaskMaster[] models) {
		TaskMasterSoap[] soapModels = new TaskMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaskMasterSoap[][] toSoapModels(TaskMaster[][] models) {
		TaskMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaskMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaskMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaskMasterSoap[] toSoapModels(List<TaskMaster> models) {
		List<TaskMasterSoap> soapModels = new ArrayList<TaskMasterSoap>(models.size());

		for (TaskMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaskMasterSoap[soapModels.size()]);
	}

	public TaskMasterSoap() {
	}

	public long getPrimaryKey() {
		return _taskId;
	}

	public void setPrimaryKey(long pk) {
		setTaskId(pk);
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public String getTaskName() {
		return _taskName;
	}

	public void setTaskName(String taskName) {
		_taskName = taskName;
	}

	public String getTaskDesc() {
		return _taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		_taskDesc = taskDesc;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _taskId;
	private String _taskName;
	private String _taskDesc;
	private int _status;
	private Date _createDate;
}