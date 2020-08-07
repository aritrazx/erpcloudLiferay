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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.TimeSheetMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.TimeSheetMasterServiceSoap
 * @generated
 */
@ProviderType
public class TimeSheetMasterSoap implements Serializable {
	public static TimeSheetMasterSoap toSoapModel(TimeSheetMaster model) {
		TimeSheetMasterSoap soapModel = new TimeSheetMasterSoap();

		soapModel.setTimesheetParentId(model.getTimesheetParentId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setSubmitStatus(model.getSubmitStatus());
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

	public static TimeSheetMasterSoap[] toSoapModels(TimeSheetMaster[] models) {
		TimeSheetMasterSoap[] soapModels = new TimeSheetMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimeSheetMasterSoap[][] toSoapModels(
		TimeSheetMaster[][] models) {
		TimeSheetMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimeSheetMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimeSheetMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimeSheetMasterSoap[] toSoapModels(
		List<TimeSheetMaster> models) {
		List<TimeSheetMasterSoap> soapModels = new ArrayList<TimeSheetMasterSoap>(models.size());

		for (TimeSheetMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimeSheetMasterSoap[soapModels.size()]);
	}

	public TimeSheetMasterSoap() {
	}

	public long getPrimaryKey() {
		return _timesheetParentId;
	}

	public void setPrimaryKey(long pk) {
		setTimesheetParentId(pk);
	}

	public long getTimesheetParentId() {
		return _timesheetParentId;
	}

	public void setTimesheetParentId(long timesheetParentId) {
		_timesheetParentId = timesheetParentId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public int getSubmitStatus() {
		return _submitStatus;
	}

	public void setSubmitStatus(int submitStatus) {
		_submitStatus = submitStatus;
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

	private long _timesheetParentId;
	private long _employeeId;
	private Date _fromDate;
	private Date _toDate;
	private int _submitStatus;
	private Date _addedDate;
	private long _groupId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private Date _createDate;
	private Date _modifiedDate;
}