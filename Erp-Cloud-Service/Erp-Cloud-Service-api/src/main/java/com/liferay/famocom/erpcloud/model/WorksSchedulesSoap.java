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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.WorksSchedulesServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.WorksSchedulesServiceSoap
 * @generated
 */
@ProviderType
public class WorksSchedulesSoap implements Serializable {
	public static WorksSchedulesSoap toSoapModel(WorksSchedules model) {
		WorksSchedulesSoap soapModel = new WorksSchedulesSoap();

		soapModel.setWorksSchedulesId(model.getWorksSchedulesId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setSchedulesId(model.getSchedulesId());
		soapModel.setIslock(model.getIslock());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static WorksSchedulesSoap[] toSoapModels(WorksSchedules[] models) {
		WorksSchedulesSoap[] soapModels = new WorksSchedulesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorksSchedulesSoap[][] toSoapModels(WorksSchedules[][] models) {
		WorksSchedulesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorksSchedulesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorksSchedulesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorksSchedulesSoap[] toSoapModels(List<WorksSchedules> models) {
		List<WorksSchedulesSoap> soapModels = new ArrayList<WorksSchedulesSoap>(models.size());

		for (WorksSchedules model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorksSchedulesSoap[soapModels.size()]);
	}

	public WorksSchedulesSoap() {
	}

	public long getPrimaryKey() {
		return _worksSchedulesId;
	}

	public void setPrimaryKey(long pk) {
		setWorksSchedulesId(pk);
	}

	public long getWorksSchedulesId() {
		return _worksSchedulesId;
	}

	public void setWorksSchedulesId(long worksSchedulesId) {
		_worksSchedulesId = worksSchedulesId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getSchedulesId() {
		return _schedulesId;
	}

	public void setSchedulesId(long schedulesId) {
		_schedulesId = schedulesId;
	}

	public int getIslock() {
		return _islock;
	}

	public void setIslock(int islock) {
		_islock = islock;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _worksSchedulesId;
	private long _companyId;
	private long _employeeId;
	private Date _fromDate;
	private Date _toDate;
	private long _schedulesId;
	private int _islock;
	private int _status;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
}