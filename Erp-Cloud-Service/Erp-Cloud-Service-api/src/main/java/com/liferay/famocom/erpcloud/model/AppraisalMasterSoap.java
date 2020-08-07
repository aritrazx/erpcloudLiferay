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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.AppraisalMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.AppraisalMasterServiceSoap
 * @generated
 */
@ProviderType
public class AppraisalMasterSoap implements Serializable {
	public static AppraisalMasterSoap toSoapModel(AppraisalMaster model) {
		AppraisalMasterSoap soapModel = new AppraisalMasterSoap();

		soapModel.setAppraisalId(model.getAppraisalId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAppraisalSettingId(model.getAppraisalSettingId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setAccomplishmentsEmp(model.getAccomplishmentsEmp());
		soapModel.setStrengthsEmp(model.getStrengthsEmp());
		soapModel.setDevelopmentEmp(model.getDevelopmentEmp());
		soapModel.setCareerEmp(model.getCareerEmp());
		soapModel.setOverallRatingEmp(model.getOverallRatingEmp());
		soapModel.setOverallCommentEmp(model.getOverallCommentEmp());
		soapModel.setAccomplishmentsMan(model.getAccomplishmentsMan());
		soapModel.setStrengthsMan(model.getStrengthsMan());
		soapModel.setDevelopmentMan(model.getDevelopmentMan());
		soapModel.setCareerMan(model.getCareerMan());
		soapModel.setCompanyValue(model.getCompanyValue());
		soapModel.setDevelopmentPlan(model.getDevelopmentPlan());
		soapModel.setOverallRatingMan(model.getOverallRatingMan());
		soapModel.setOverallCommentMan(model.getOverallCommentMan());
		soapModel.setSubmitStep(model.getSubmitStep());
		soapModel.setAddedDate(model.getAddedDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static AppraisalMasterSoap[] toSoapModels(AppraisalMaster[] models) {
		AppraisalMasterSoap[] soapModels = new AppraisalMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppraisalMasterSoap[][] toSoapModels(
		AppraisalMaster[][] models) {
		AppraisalMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AppraisalMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppraisalMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppraisalMasterSoap[] toSoapModels(
		List<AppraisalMaster> models) {
		List<AppraisalMasterSoap> soapModels = new ArrayList<AppraisalMasterSoap>(models.size());

		for (AppraisalMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppraisalMasterSoap[soapModels.size()]);
	}

	public AppraisalMasterSoap() {
	}

	public long getPrimaryKey() {
		return _appraisalId;
	}

	public void setPrimaryKey(long pk) {
		setAppraisalId(pk);
	}

	public long getAppraisalId() {
		return _appraisalId;
	}

	public void setAppraisalId(long appraisalId) {
		_appraisalId = appraisalId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public String getAccomplishmentsEmp() {
		return _accomplishmentsEmp;
	}

	public void setAccomplishmentsEmp(String accomplishmentsEmp) {
		_accomplishmentsEmp = accomplishmentsEmp;
	}

	public String getStrengthsEmp() {
		return _strengthsEmp;
	}

	public void setStrengthsEmp(String strengthsEmp) {
		_strengthsEmp = strengthsEmp;
	}

	public String getDevelopmentEmp() {
		return _developmentEmp;
	}

	public void setDevelopmentEmp(String developmentEmp) {
		_developmentEmp = developmentEmp;
	}

	public String getCareerEmp() {
		return _careerEmp;
	}

	public void setCareerEmp(String careerEmp) {
		_careerEmp = careerEmp;
	}

	public long getOverallRatingEmp() {
		return _overallRatingEmp;
	}

	public void setOverallRatingEmp(long overallRatingEmp) {
		_overallRatingEmp = overallRatingEmp;
	}

	public String getOverallCommentEmp() {
		return _overallCommentEmp;
	}

	public void setOverallCommentEmp(String overallCommentEmp) {
		_overallCommentEmp = overallCommentEmp;
	}

	public String getAccomplishmentsMan() {
		return _accomplishmentsMan;
	}

	public void setAccomplishmentsMan(String accomplishmentsMan) {
		_accomplishmentsMan = accomplishmentsMan;
	}

	public String getStrengthsMan() {
		return _strengthsMan;
	}

	public void setStrengthsMan(String strengthsMan) {
		_strengthsMan = strengthsMan;
	}

	public String getDevelopmentMan() {
		return _developmentMan;
	}

	public void setDevelopmentMan(String developmentMan) {
		_developmentMan = developmentMan;
	}

	public String getCareerMan() {
		return _careerMan;
	}

	public void setCareerMan(String careerMan) {
		_careerMan = careerMan;
	}

	public String getCompanyValue() {
		return _companyValue;
	}

	public void setCompanyValue(String companyValue) {
		_companyValue = companyValue;
	}

	public String getDevelopmentPlan() {
		return _developmentPlan;
	}

	public void setDevelopmentPlan(String developmentPlan) {
		_developmentPlan = developmentPlan;
	}

	public long getOverallRatingMan() {
		return _overallRatingMan;
	}

	public void setOverallRatingMan(long overallRatingMan) {
		_overallRatingMan = overallRatingMan;
	}

	public String getOverallCommentMan() {
		return _overallCommentMan;
	}

	public void setOverallCommentMan(String overallCommentMan) {
		_overallCommentMan = overallCommentMan;
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

	private long _appraisalId;
	private long _companyId;
	private long _appraisalSettingId;
	private long _employeeId;
	private String _accomplishmentsEmp;
	private String _strengthsEmp;
	private String _developmentEmp;
	private String _careerEmp;
	private long _overallRatingEmp;
	private String _overallCommentEmp;
	private String _accomplishmentsMan;
	private String _strengthsMan;
	private String _developmentMan;
	private String _careerMan;
	private String _companyValue;
	private String _developmentPlan;
	private long _overallRatingMan;
	private String _overallCommentMan;
	private long _submitStep;
	private Date _addedDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}