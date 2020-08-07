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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.AppraisalPerformanceServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.AppraisalPerformanceServiceSoap
 * @generated
 */
@ProviderType
public class AppraisalPerformanceSoap implements Serializable {
	public static AppraisalPerformanceSoap toSoapModel(
		AppraisalPerformance model) {
		AppraisalPerformanceSoap soapModel = new AppraisalPerformanceSoap();

		soapModel.setAppraisalPerformanceId(model.getAppraisalPerformanceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAppraisalId(model.getAppraisalId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setAppraisalSettingId(model.getAppraisalSettingId());
		soapModel.setPerformanceId(model.getPerformanceId());
		soapModel.setPerformanceComm(model.getPerformanceComm());
		soapModel.setRatingIdEmp(model.getRatingIdEmp());
		soapModel.setRatingIdMan(model.getRatingIdMan());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static AppraisalPerformanceSoap[] toSoapModels(
		AppraisalPerformance[] models) {
		AppraisalPerformanceSoap[] soapModels = new AppraisalPerformanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppraisalPerformanceSoap[][] toSoapModels(
		AppraisalPerformance[][] models) {
		AppraisalPerformanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AppraisalPerformanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppraisalPerformanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppraisalPerformanceSoap[] toSoapModels(
		List<AppraisalPerformance> models) {
		List<AppraisalPerformanceSoap> soapModels = new ArrayList<AppraisalPerformanceSoap>(models.size());

		for (AppraisalPerformance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppraisalPerformanceSoap[soapModels.size()]);
	}

	public AppraisalPerformanceSoap() {
	}

	public long getPrimaryKey() {
		return _appraisalPerformanceId;
	}

	public void setPrimaryKey(long pk) {
		setAppraisalPerformanceId(pk);
	}

	public long getAppraisalPerformanceId() {
		return _appraisalPerformanceId;
	}

	public void setAppraisalPerformanceId(long appraisalPerformanceId) {
		_appraisalPerformanceId = appraisalPerformanceId;
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

	public long getAppraisalSettingId() {
		return _appraisalSettingId;
	}

	public void setAppraisalSettingId(long appraisalSettingId) {
		_appraisalSettingId = appraisalSettingId;
	}

	public long getPerformanceId() {
		return _performanceId;
	}

	public void setPerformanceId(long performanceId) {
		_performanceId = performanceId;
	}

	public String getPerformanceComm() {
		return _performanceComm;
	}

	public void setPerformanceComm(String performanceComm) {
		_performanceComm = performanceComm;
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

	private long _appraisalPerformanceId;
	private long _companyId;
	private long _appraisalId;
	private long _employeeId;
	private long _appraisalSettingId;
	private long _performanceId;
	private String _performanceComm;
	private long _ratingIdEmp;
	private long _ratingIdMan;
	private Date _createdDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}