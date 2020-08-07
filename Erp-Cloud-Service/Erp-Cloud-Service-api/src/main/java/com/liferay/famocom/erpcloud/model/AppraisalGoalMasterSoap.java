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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.AppraisalGoalMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.AppraisalGoalMasterServiceSoap
 * @generated
 */
@ProviderType
public class AppraisalGoalMasterSoap implements Serializable {
	public static AppraisalGoalMasterSoap toSoapModel(AppraisalGoalMaster model) {
		AppraisalGoalMasterSoap soapModel = new AppraisalGoalMasterSoap();

		soapModel.setAppraisalGoalMasterId(model.getAppraisalGoalMasterId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAppraisalId(model.getAppraisalId());
		soapModel.setAppraisalProjectId(model.getAppraisalProjectId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setEvaluationId(model.getEvaluationId());
		soapModel.setEmployeeComment(model.getEmployeeComment());
		soapModel.setEmployeeOverallRat(model.getEmployeeOverallRat());
		soapModel.setManagerComment(model.getManagerComment());
		soapModel.setManagerOverallRat(model.getManagerOverallRat());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static AppraisalGoalMasterSoap[] toSoapModels(
		AppraisalGoalMaster[] models) {
		AppraisalGoalMasterSoap[] soapModels = new AppraisalGoalMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppraisalGoalMasterSoap[][] toSoapModels(
		AppraisalGoalMaster[][] models) {
		AppraisalGoalMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AppraisalGoalMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppraisalGoalMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppraisalGoalMasterSoap[] toSoapModels(
		List<AppraisalGoalMaster> models) {
		List<AppraisalGoalMasterSoap> soapModels = new ArrayList<AppraisalGoalMasterSoap>(models.size());

		for (AppraisalGoalMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppraisalGoalMasterSoap[soapModels.size()]);
	}

	public AppraisalGoalMasterSoap() {
	}

	public long getPrimaryKey() {
		return _appraisalGoalMasterId;
	}

	public void setPrimaryKey(long pk) {
		setAppraisalGoalMasterId(pk);
	}

	public long getAppraisalGoalMasterId() {
		return _appraisalGoalMasterId;
	}

	public void setAppraisalGoalMasterId(long appraisalGoalMasterId) {
		_appraisalGoalMasterId = appraisalGoalMasterId;
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

	public long getAppraisalProjectId() {
		return _appraisalProjectId;
	}

	public void setAppraisalProjectId(long appraisalProjectId) {
		_appraisalProjectId = appraisalProjectId;
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

	public long getEvaluationId() {
		return _evaluationId;
	}

	public void setEvaluationId(long evaluationId) {
		_evaluationId = evaluationId;
	}

	public String getEmployeeComment() {
		return _employeeComment;
	}

	public void setEmployeeComment(String employeeComment) {
		_employeeComment = employeeComment;
	}

	public long getEmployeeOverallRat() {
		return _employeeOverallRat;
	}

	public void setEmployeeOverallRat(long employeeOverallRat) {
		_employeeOverallRat = employeeOverallRat;
	}

	public String getManagerComment() {
		return _managerComment;
	}

	public void setManagerComment(String managerComment) {
		_managerComment = managerComment;
	}

	public long getManagerOverallRat() {
		return _managerOverallRat;
	}

	public void setManagerOverallRat(long managerOverallRat) {
		_managerOverallRat = managerOverallRat;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
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

	private long _appraisalGoalMasterId;
	private long _companyId;
	private long _appraisalId;
	private long _appraisalProjectId;
	private long _employeeId;
	private long _projectId;
	private long _evaluationId;
	private String _employeeComment;
	private long _employeeOverallRat;
	private String _managerComment;
	private long _managerOverallRat;
	private Date _createdDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}