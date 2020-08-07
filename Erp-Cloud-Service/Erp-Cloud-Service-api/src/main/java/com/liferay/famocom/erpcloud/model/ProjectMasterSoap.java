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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ProjectMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ProjectMasterServiceSoap
 * @generated
 */
@ProviderType
public class ProjectMasterSoap implements Serializable {
	public static ProjectMasterSoap toSoapModel(ProjectMaster model) {
		ProjectMasterSoap soapModel = new ProjectMasterSoap();

		soapModel.setProjectId(model.getProjectId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setProjectName(model.getProjectName());
		soapModel.setClientId(model.getClientId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProjectStatus(model.getProjectStatus());
		soapModel.setProjectStatusId(model.getProjectStatusId());
		soapModel.setProjectDesc(model.getProjectDesc());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setTotalAmount(model.getTotalAmount());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static ProjectMasterSoap[] toSoapModels(ProjectMaster[] models) {
		ProjectMasterSoap[] soapModels = new ProjectMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectMasterSoap[][] toSoapModels(ProjectMaster[][] models) {
		ProjectMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectMasterSoap[] toSoapModels(List<ProjectMaster> models) {
		List<ProjectMasterSoap> soapModels = new ArrayList<ProjectMasterSoap>(models.size());

		for (ProjectMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectMasterSoap[soapModels.size()]);
	}

	public ProjectMasterSoap() {
	}

	public long getPrimaryKey() {
		return _projectId;
	}

	public void setPrimaryKey(long pk) {
		setProjectId(pk);
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getProjectName() {
		return _projectName;
	}

	public void setProjectName(String projectName) {
		_projectName = projectName;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public int getProjectStatus() {
		return _projectStatus;
	}

	public void setProjectStatus(int projectStatus) {
		_projectStatus = projectStatus;
	}

	public long getProjectStatusId() {
		return _projectStatusId;
	}

	public void setProjectStatusId(long projectStatusId) {
		_projectStatusId = projectStatusId;
	}

	public String getProjectDesc() {
		return _projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		_projectDesc = projectDesc;
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

	public double getTotalAmount() {
		return _totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		_totalAmount = totalAmount;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _projectId;
	private long _companyId;
	private String _projectName;
	private long _clientId;
	private long _employeeId;
	private int _projectStatus;
	private long _projectStatusId;
	private String _projectDesc;
	private Date _startDate;
	private Date _endDate;
	private double _totalAmount;
	private Date _addedDate;
}