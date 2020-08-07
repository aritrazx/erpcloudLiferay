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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.TimeSheetEntryServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.TimeSheetEntryServiceSoap
 * @generated
 */
@ProviderType
public class TimeSheetEntrySoap implements Serializable {
	public static TimeSheetEntrySoap toSoapModel(TimeSheetEntry model) {
		TimeSheetEntrySoap soapModel = new TimeSheetEntrySoap();

		soapModel.setTimesheetId(model.getTimesheetId());
		soapModel.setEntryDate(model.getEntryDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setProjectTaskId(model.getProjectTaskId());
		soapModel.setHours(model.getHours());
		soapModel.setWorkDescription(model.getWorkDescription());
		soapModel.setTimesheetParentId(model.getTimesheetParentId());
		soapModel.setAddedDate(model.getAddedDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TimeSheetEntrySoap[] toSoapModels(TimeSheetEntry[] models) {
		TimeSheetEntrySoap[] soapModels = new TimeSheetEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimeSheetEntrySoap[][] toSoapModels(TimeSheetEntry[][] models) {
		TimeSheetEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimeSheetEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimeSheetEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimeSheetEntrySoap[] toSoapModels(List<TimeSheetEntry> models) {
		List<TimeSheetEntrySoap> soapModels = new ArrayList<TimeSheetEntrySoap>(models.size());

		for (TimeSheetEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimeSheetEntrySoap[soapModels.size()]);
	}

	public TimeSheetEntrySoap() {
	}

	public long getPrimaryKey() {
		return _timesheetId;
	}

	public void setPrimaryKey(long pk) {
		setTimesheetId(pk);
	}

	public long getTimesheetId() {
		return _timesheetId;
	}

	public void setTimesheetId(long timesheetId) {
		_timesheetId = timesheetId;
	}

	public Date getEntryDate() {
		return _entryDate;
	}

	public void setEntryDate(Date entryDate) {
		_entryDate = entryDate;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getProjectTaskId() {
		return _projectTaskId;
	}

	public void setProjectTaskId(long projectTaskId) {
		_projectTaskId = projectTaskId;
	}

	public double getHours() {
		return _hours;
	}

	public void setHours(double hours) {
		_hours = hours;
	}

	public String getWorkDescription() {
		return _workDescription;
	}

	public void setWorkDescription(String workDescription) {
		_workDescription = workDescription;
	}

	public long getTimesheetParentId() {
		return _timesheetParentId;
	}

	public void setTimesheetParentId(long timesheetParentId) {
		_timesheetParentId = timesheetParentId;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _timesheetId;
	private Date _entryDate;
	private long _employeeId;
	private long _projectId;
	private long _projectTaskId;
	private double _hours;
	private String _workDescription;
	private long _timesheetParentId;
	private Date _addedDate;
	private long _groupId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private Date _createDate;
	private Date _modifiedDate;
}