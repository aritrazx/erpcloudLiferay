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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.WorkFromHomeServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.WorkFromHomeServiceSoap
 * @generated
 */
@ProviderType
public class WorkFromHomeSoap implements Serializable {
	public static WorkFromHomeSoap toSoapModel(WorkFromHome model) {
		WorkFromHomeSoap soapModel = new WorkFromHomeSoap();

		soapModel.setWorkFromHomeId(model.getWorkFromHomeId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setAppliedDate(model.getAppliedDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setWorkStatus(model.getWorkStatus());
		soapModel.setHrComments(model.getHrComments());

		return soapModel;
	}

	public static WorkFromHomeSoap[] toSoapModels(WorkFromHome[] models) {
		WorkFromHomeSoap[] soapModels = new WorkFromHomeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkFromHomeSoap[][] toSoapModels(WorkFromHome[][] models) {
		WorkFromHomeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkFromHomeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkFromHomeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkFromHomeSoap[] toSoapModels(List<WorkFromHome> models) {
		List<WorkFromHomeSoap> soapModels = new ArrayList<WorkFromHomeSoap>(models.size());

		for (WorkFromHome model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkFromHomeSoap[soapModels.size()]);
	}

	public WorkFromHomeSoap() {
	}

	public long getPrimaryKey() {
		return _workFromHomeId;
	}

	public void setPrimaryKey(long pk) {
		setWorkFromHomeId(pk);
	}

	public long getWorkFromHomeId() {
		return _workFromHomeId;
	}

	public void setWorkFromHomeId(long workFromHomeId) {
		_workFromHomeId = workFromHomeId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public Date getAppliedDate() {
		return _appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		_appliedDate = appliedDate;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public int getWorkStatus() {
		return _workStatus;
	}

	public void setWorkStatus(int workStatus) {
		_workStatus = workStatus;
	}

	public String getHrComments() {
		return _hrComments;
	}

	public void setHrComments(String hrComments) {
		_hrComments = hrComments;
	}

	private long _workFromHomeId;
	private long _employeeId;
	private long _companyId;
	private long _projectId;
	private Date _appliedDate;
	private String _description;
	private Date _createDate;
	private Date _modifiedDate;
	private int _workStatus;
	private String _hrComments;
}