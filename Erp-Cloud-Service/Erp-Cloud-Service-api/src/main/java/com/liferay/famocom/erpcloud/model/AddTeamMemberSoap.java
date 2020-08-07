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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.AddTeamMemberServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.AddTeamMemberServiceSoap
 * @generated
 */
@ProviderType
public class AddTeamMemberSoap implements Serializable {
	public static AddTeamMemberSoap toSoapModel(AddTeamMember model) {
		AddTeamMemberSoap soapModel = new AddTeamMemberSoap();

		soapModel.setProjectTeamsId(model.getProjectTeamsId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setAddedDate(model.getAddedDate());
		soapModel.setIsProjectManager(model.isIsProjectManager());

		return soapModel;
	}

	public static AddTeamMemberSoap[] toSoapModels(AddTeamMember[] models) {
		AddTeamMemberSoap[] soapModels = new AddTeamMemberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddTeamMemberSoap[][] toSoapModels(AddTeamMember[][] models) {
		AddTeamMemberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddTeamMemberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddTeamMemberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddTeamMemberSoap[] toSoapModels(List<AddTeamMember> models) {
		List<AddTeamMemberSoap> soapModels = new ArrayList<AddTeamMemberSoap>(models.size());

		for (AddTeamMember model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddTeamMemberSoap[soapModels.size()]);
	}

	public AddTeamMemberSoap() {
	}

	public long getPrimaryKey() {
		return _projectTeamsId;
	}

	public void setPrimaryKey(long pk) {
		setProjectTeamsId(pk);
	}

	public long getProjectTeamsId() {
		return _projectTeamsId;
	}

	public void setProjectTeamsId(long projectTeamsId) {
		_projectTeamsId = projectTeamsId;
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	public boolean getIsProjectManager() {
		return _isProjectManager;
	}

	public boolean isIsProjectManager() {
		return _isProjectManager;
	}

	public void setIsProjectManager(boolean isProjectManager) {
		_isProjectManager = isProjectManager;
	}

	private long _projectTeamsId;
	private long _employeeId;
	private long _projectId;
	private long _companyId;
	private long _roleId;
	private Date _addedDate;
	private boolean _isProjectManager;
}