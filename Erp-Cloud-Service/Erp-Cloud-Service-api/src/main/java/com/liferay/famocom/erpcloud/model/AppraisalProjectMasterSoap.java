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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.AppraisalProjectMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.AppraisalProjectMasterServiceSoap
 * @generated
 */
@ProviderType
public class AppraisalProjectMasterSoap implements Serializable {
	public static AppraisalProjectMasterSoap toSoapModel(
		AppraisalProjectMaster model) {
		AppraisalProjectMasterSoap soapModel = new AppraisalProjectMasterSoap();

		soapModel.setAppraisalProjectId(model.getAppraisalProjectId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAppraisalId(model.getAppraisalId());
		soapModel.setAppraisalSettingId(model.getAppraisalSettingId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setProjectDescription(model.getProjectDescription());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setSubmitStep(model.getSubmitStep());
		soapModel.setAddedDate(model.getAddedDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static AppraisalProjectMasterSoap[] toSoapModels(
		AppraisalProjectMaster[] models) {
		AppraisalProjectMasterSoap[] soapModels = new AppraisalProjectMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppraisalProjectMasterSoap[][] toSoapModels(
		AppraisalProjectMaster[][] models) {
		AppraisalProjectMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AppraisalProjectMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppraisalProjectMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppraisalProjectMasterSoap[] toSoapModels(
		List<AppraisalProjectMaster> models) {
		List<AppraisalProjectMasterSoap> soapModels = new ArrayList<AppraisalProjectMasterSoap>(models.size());

		for (AppraisalProjectMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppraisalProjectMasterSoap[soapModels.size()]);
	}

	public AppraisalProjectMasterSoap() {
	}

	public long getPrimaryKey() {
		return _appraisalProjectId;
	}

	public void setPrimaryKey(long pk) {
		setAppraisalProjectId(pk);
	}

	public long getAppraisalProjectId() {
		return _appraisalProjectId;
	}

	public void setAppraisalProjectId(long appraisalProjectId) {
		_appraisalProjectId = appraisalProjectId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getAppraisalId() {
		return _appraisalId;
	}

	public void setAppraisalId(long appraisalId) {
		_appraisalId = appraisalId;
	}

	public long getAppraisalSettingId() {
		return _appraisalSettingId;
	}

	public void setAppraisalSettingId(long appraisalSettingId) {
		_appraisalSettingId = appraisalSettingId;
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

	public String getProjectDescription() {
		return _projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		_projectDescription = projectDescription;
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

	public long getSubmitStep() {
		return _submitStep;
	}

	public void setSubmitStep(long submitStep) {
		_submitStep = submitStep;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	private long _appraisalProjectId;
	private long _companyId;
	private long _appraisalId;
	private long _appraisalSettingId;
	private long _employeeId;
	private long _projectId;
	private String _projectDescription;
	private Date _startDate;
	private Date _endDate;
	private long _submitStep;
	private Date _addedDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}