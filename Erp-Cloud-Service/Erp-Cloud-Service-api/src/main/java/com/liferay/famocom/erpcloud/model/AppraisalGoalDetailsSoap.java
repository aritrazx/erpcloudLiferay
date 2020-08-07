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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.AppraisalGoalDetailsServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.AppraisalGoalDetailsServiceSoap
 * @generated
 */
@ProviderType
public class AppraisalGoalDetailsSoap implements Serializable {
	public static AppraisalGoalDetailsSoap toSoapModel(
		AppraisalGoalDetails model) {
		AppraisalGoalDetailsSoap soapModel = new AppraisalGoalDetailsSoap();

		soapModel.setAppraisalGoalDetailsId(model.getAppraisalGoalDetailsId());
		soapModel.setAppraisalGoalMasterId(model.getAppraisalGoalMasterId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAppraisalId(model.getAppraisalId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setEvaluationId(model.getEvaluationId());
		soapModel.setGoaldetailId(model.getGoaldetailId());
		soapModel.setRatingIdEmp(model.getRatingIdEmp());
		soapModel.setRatingIdMan(model.getRatingIdMan());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static AppraisalGoalDetailsSoap[] toSoapModels(
		AppraisalGoalDetails[] models) {
		AppraisalGoalDetailsSoap[] soapModels = new AppraisalGoalDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppraisalGoalDetailsSoap[][] toSoapModels(
		AppraisalGoalDetails[][] models) {
		AppraisalGoalDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AppraisalGoalDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppraisalGoalDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppraisalGoalDetailsSoap[] toSoapModels(
		List<AppraisalGoalDetails> models) {
		List<AppraisalGoalDetailsSoap> soapModels = new ArrayList<AppraisalGoalDetailsSoap>(models.size());

		for (AppraisalGoalDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppraisalGoalDetailsSoap[soapModels.size()]);
	}

	public AppraisalGoalDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _appraisalGoalDetailsId;
	}

	public void setPrimaryKey(long pk) {
		setAppraisalGoalDetailsId(pk);
	}

	public long getAppraisalGoalDetailsId() {
		return _appraisalGoalDetailsId;
	}

	public void setAppraisalGoalDetailsId(long appraisalGoalDetailsId) {
		_appraisalGoalDetailsId = appraisalGoalDetailsId;
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

	public long getGoaldetailId() {
		return _goaldetailId;
	}

	public void setGoaldetailId(long goaldetailId) {
		_goaldetailId = goaldetailId;
	}

	public long getRatingIdEmp() {
		return _ratingIdEmp;
	}

	public void setRatingIdEmp(long ratingIdEmp) {
		_ratingIdEmp = ratingIdEmp;
	}

	public long getRatingIdMan() {
		return _ratingIdMan;
	}

	public void setRatingIdMan(long ratingIdMan) {
		_ratingIdMan = ratingIdMan;
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

	private long _appraisalGoalDetailsId;
	private long _appraisalGoalMasterId;
	private long _companyId;
	private long _appraisalId;
	private long _employeeId;
	private long _projectId;
	private long _evaluationId;
	private long _goaldetailId;
	private long _ratingIdEmp;
	private long _ratingIdMan;
	private Date _createdDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}