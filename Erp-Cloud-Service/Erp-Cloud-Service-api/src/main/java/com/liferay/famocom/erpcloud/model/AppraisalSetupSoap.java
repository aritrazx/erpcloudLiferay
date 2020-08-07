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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.AppraisalSetupServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.AppraisalSetupServiceSoap
 * @generated
 */
@ProviderType
public class AppraisalSetupSoap implements Serializable {
	public static AppraisalSetupSoap toSoapModel(AppraisalSetup model) {
		AppraisalSetupSoap soapModel = new AppraisalSetupSoap();

		soapModel.setAppraisalSettingId(model.getAppraisalSettingId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setFinancialYear(model.getFinancialYear());
		soapModel.setFromDateCycle(model.getFromDateCycle());
		soapModel.setToDateCycle(model.getToDateCycle());
		soapModel.setFromDateSubmission(model.getFromDateSubmission());
		soapModel.setToDateSubmission(model.getToDateSubmission());
		soapModel.setAppraisalPeriod(model.getAppraisalPeriod());
		soapModel.setTotalEmp(model.getTotalEmp());
		soapModel.setBeforeCtcAll(model.getBeforeCtcAll());
		soapModel.setAppraisalEmp(model.getAppraisalEmp());
		soapModel.setBeforeCtc(model.getBeforeCtc());
		soapModel.setAfterCtc(model.getAfterCtc());
		soapModel.setTotalAreas(model.getTotalAreas());
		soapModel.setTotalBonus(model.getTotalBonus());
		soapModel.setTotalCtcAfter(model.getTotalCtcAfter());
		soapModel.setIsLocked(model.getIsLocked());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setEmployeeType(model.getEmployeeType());
		soapModel.setAddedDate(model.getAddedDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static AppraisalSetupSoap[] toSoapModels(AppraisalSetup[] models) {
		AppraisalSetupSoap[] soapModels = new AppraisalSetupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppraisalSetupSoap[][] toSoapModels(AppraisalSetup[][] models) {
		AppraisalSetupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AppraisalSetupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppraisalSetupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppraisalSetupSoap[] toSoapModels(List<AppraisalSetup> models) {
		List<AppraisalSetupSoap> soapModels = new ArrayList<AppraisalSetupSoap>(models.size());

		for (AppraisalSetup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppraisalSetupSoap[soapModels.size()]);
	}

	public AppraisalSetupSoap() {
	}

	public long getPrimaryKey() {
		return _appraisalSettingId;
	}

	public void setPrimaryKey(long pk) {
		setAppraisalSettingId(pk);
	}

	public long getAppraisalSettingId() {
		return _appraisalSettingId;
	}

	public void setAppraisalSettingId(long appraisalSettingId) {
		_appraisalSettingId = appraisalSettingId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getFinancialYear() {
		return _financialYear;
	}

	public void setFinancialYear(String financialYear) {
		_financialYear = financialYear;
	}

	public Date getFromDateCycle() {
		return _fromDateCycle;
	}

	public void setFromDateCycle(Date fromDateCycle) {
		_fromDateCycle = fromDateCycle;
	}

	public Date getToDateCycle() {
		return _toDateCycle;
	}

	public void setToDateCycle(Date toDateCycle) {
		_toDateCycle = toDateCycle;
	}

	public Date getFromDateSubmission() {
		return _fromDateSubmission;
	}

	public void setFromDateSubmission(Date fromDateSubmission) {
		_fromDateSubmission = fromDateSubmission;
	}

	public Date getToDateSubmission() {
		return _toDateSubmission;
	}

	public void setToDateSubmission(Date toDateSubmission) {
		_toDateSubmission = toDateSubmission;
	}

	public long getAppraisalPeriod() {
		return _appraisalPeriod;
	}

	public void setAppraisalPeriod(long appraisalPeriod) {
		_appraisalPeriod = appraisalPeriod;
	}

	public long getTotalEmp() {
		return _totalEmp;
	}

	public void setTotalEmp(long totalEmp) {
		_totalEmp = totalEmp;
	}

	public long getBeforeCtcAll() {
		return _beforeCtcAll;
	}

	public void setBeforeCtcAll(long beforeCtcAll) {
		_beforeCtcAll = beforeCtcAll;
	}

	public long getAppraisalEmp() {
		return _appraisalEmp;
	}

	public void setAppraisalEmp(long appraisalEmp) {
		_appraisalEmp = appraisalEmp;
	}

	public long getBeforeCtc() {
		return _beforeCtc;
	}

	public void setBeforeCtc(long beforeCtc) {
		_beforeCtc = beforeCtc;
	}

	public long getAfterCtc() {
		return _afterCtc;
	}

	public void setAfterCtc(long afterCtc) {
		_afterCtc = afterCtc;
	}

	public long getTotalAreas() {
		return _totalAreas;
	}

	public void setTotalAreas(long totalAreas) {
		_totalAreas = totalAreas;
	}

	public long getTotalBonus() {
		return _totalBonus;
	}

	public void setTotalBonus(long totalBonus) {
		_totalBonus = totalBonus;
	}

	public long getTotalCtcAfter() {
		return _totalCtcAfter;
	}

	public void setTotalCtcAfter(long totalCtcAfter) {
		_totalCtcAfter = totalCtcAfter;
	}

	public long getIsLocked() {
		return _isLocked;
	}

	public void setIsLocked(long isLocked) {
		_isLocked = isLocked;
	}

	public long getIsActive() {
		return _isActive;
	}

	public void setIsActive(long isActive) {
		_isActive = isActive;
	}

	public String getEmployeeType() {
		return _employeeType;
	}

	public void setEmployeeType(String employeeType) {
		_employeeType = employeeType;
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

	private long _appraisalSettingId;
	private long _companyId;
	private String _financialYear;
	private Date _fromDateCycle;
	private Date _toDateCycle;
	private Date _fromDateSubmission;
	private Date _toDateSubmission;
	private long _appraisalPeriod;
	private long _totalEmp;
	private long _beforeCtcAll;
	private long _appraisalEmp;
	private long _beforeCtc;
	private long _afterCtc;
	private long _totalAreas;
	private long _totalBonus;
	private long _totalCtcAfter;
	private long _isLocked;
	private long _isActive;
	private String _employeeType;
	private Date _addedDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}