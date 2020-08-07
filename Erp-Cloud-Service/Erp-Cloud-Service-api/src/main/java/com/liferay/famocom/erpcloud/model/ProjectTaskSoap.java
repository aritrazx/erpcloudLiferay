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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ProjectTaskServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ProjectTaskServiceSoap
 * @generated
 */
@ProviderType
public class ProjectTaskSoap implements Serializable {
	public static ProjectTaskSoap toSoapModel(ProjectTask model) {
		ProjectTaskSoap soapModel = new ProjectTaskSoap();

		soapModel.setProjectTaskId(model.getProjectTaskId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setTaskId(model.getTaskId());
		soapModel.setTaskName(model.getTaskName());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setHours(model.getHours());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static ProjectTaskSoap[] toSoapModels(ProjectTask[] models) {
		ProjectTaskSoap[] soapModels = new ProjectTaskSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectTaskSoap[][] toSoapModels(ProjectTask[][] models) {
		ProjectTaskSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectTaskSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectTaskSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectTaskSoap[] toSoapModels(List<ProjectTask> models) {
		List<ProjectTaskSoap> soapModels = new ArrayList<ProjectTaskSoap>(models.size());

		for (ProjectTask model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectTaskSoap[soapModels.size()]);
	}

	public ProjectTaskSoap() {
	}

	public long getPrimaryKey() {
		return _projectTaskId;
	}

	public void setPrimaryKey(long pk) {
		setProjectTaskId(pk);
	}

	public long getProjectTaskId() {
		return _projectTaskId;
	}

	public void setProjectTaskId(long projectTaskId) {
		_projectTaskId = projectTaskId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
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

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public double getHours() {
		return _hours;
	}

	public void setHours(double hours) {
		_hours = hours;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _projectTaskId;
	private long _projectId;
	private long _employeeId;
	private long _taskId;
	private String _taskName;
	private Date _startDate;
	private Date _endDate;
	private double _hours;
	private Date _addedDate;
}