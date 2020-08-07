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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ProjectStatusServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ProjectStatusServiceSoap
 * @generated
 */
@ProviderType
public class ProjectStatusSoap implements Serializable {
	public static ProjectStatusSoap toSoapModel(ProjectStatus model) {
		ProjectStatusSoap soapModel = new ProjectStatusSoap();

		soapModel.setProjectStatusId(model.getProjectStatusId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setStatusName(model.getStatusName());
		soapModel.setStatusColor(model.getStatusColor());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static ProjectStatusSoap[] toSoapModels(ProjectStatus[] models) {
		ProjectStatusSoap[] soapModels = new ProjectStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectStatusSoap[][] toSoapModels(ProjectStatus[][] models) {
		ProjectStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectStatusSoap[] toSoapModels(List<ProjectStatus> models) {
		List<ProjectStatusSoap> soapModels = new ArrayList<ProjectStatusSoap>(models.size());

		for (ProjectStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectStatusSoap[soapModels.size()]);
	}

	public ProjectStatusSoap() {
	}

	public long getPrimaryKey() {
		return _projectStatusId;
	}

	public void setPrimaryKey(long pk) {
		setProjectStatusId(pk);
	}

	public long getProjectStatusId() {
		return _projectStatusId;
	}

	public void setProjectStatusId(long projectStatusId) {
		_projectStatusId = projectStatusId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getStatusName() {
		return _statusName;
	}

	public void setStatusName(String statusName) {
		_statusName = statusName;
	}

	public String getStatusColor() {
		return _statusColor;
	}

	public void setStatusColor(String statusColor) {
		_statusColor = statusColor;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _projectStatusId;
	private long _companyId;
	private String _statusName;
	private String _statusColor;
	private Date _addedDate;
}