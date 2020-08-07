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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.PayrollIncrementServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.PayrollIncrementServiceSoap
 * @generated
 */
@ProviderType
public class PayrollIncrementSoap implements Serializable {
	public static PayrollIncrementSoap toSoapModel(PayrollIncrement model) {
		PayrollIncrementSoap soapModel = new PayrollIncrementSoap();

		soapModel.setPayrollIncrementId(model.getPayrollIncrementId());
		soapModel.setAppraisalSettingId(model.getAppraisalSettingId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setEmployeeCode(model.getEmployeeCode());
		soapModel.setOverallRatingMan(model.getOverallRatingMan());
		soapModel.setPreCtc(model.getPreCtc());
		soapModel.setPostCtc(model.getPostCtc());
		soapModel.setComponentId(model.getComponentId());
		soapModel.setPreHeadComponentVal(model.getPreHeadComponentVal());
		soapModel.setPostHeadComponentVal(model.getPostHeadComponentVal());
		soapModel.setBonusVal(model.getBonusVal());
		soapModel.setFinancialYear(model.getFinancialYear());

		return soapModel;
	}

	public static PayrollIncrementSoap[] toSoapModels(PayrollIncrement[] models) {
		PayrollIncrementSoap[] soapModels = new PayrollIncrementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PayrollIncrementSoap[][] toSoapModels(
		PayrollIncrement[][] models) {
		PayrollIncrementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PayrollIncrementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PayrollIncrementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PayrollIncrementSoap[] toSoapModels(
		List<PayrollIncrement> models) {
		List<PayrollIncrementSoap> soapModels = new ArrayList<PayrollIncrementSoap>(models.size());

		for (PayrollIncrement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PayrollIncrementSoap[soapModels.size()]);
	}

	public PayrollIncrementSoap() {
	}

	public long getPrimaryKey() {
		return _payrollIncrementId;
	}

	public void setPrimaryKey(long pk) {
		setPayrollIncrementId(pk);
	}

	public long getPayrollIncrementId() {
		return _payrollIncrementId;
	}

	public void setPayrollIncrementId(long payrollIncrementId) {
		_payrollIncrementId = payrollIncrementId;
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getEmployeeCode() {
		return _employeeCode;
	}

	public void setEmployeeCode(long employeeCode) {
		_employeeCode = employeeCode;
	}

	public long getOverallRatingMan() {
		return _overallRatingMan;
	}

	public void setOverallRatingMan(long overallRatingMan) {
		_overallRatingMan = overallRatingMan;
	}

	public double getPreCtc() {
		return _preCtc;
	}

	public void setPreCtc(double preCtc) {
		_preCtc = preCtc;
	}

	public double getPostCtc() {
		return _postCtc;
	}

	public void setPostCtc(double postCtc) {
		_postCtc = postCtc;
	}

	public long getComponentId() {
		return _componentId;
	}

	public void setComponentId(long componentId) {
		_componentId = componentId;
	}

	public double getPreHeadComponentVal() {
		return _preHeadComponentVal;
	}

	public void setPreHeadComponentVal(double preHeadComponentVal) {
		_preHeadComponentVal = preHeadComponentVal;
	}

	public double getPostHeadComponentVal() {
		return _postHeadComponentVal;
	}

	public void setPostHeadComponentVal(double postHeadComponentVal) {
		_postHeadComponentVal = postHeadComponentVal;
	}

	public double getBonusVal() {
		return _bonusVal;
	}

	public void setBonusVal(double bonusVal) {
		_bonusVal = bonusVal;
	}

	public String getFinancialYear() {
		return _financialYear;
	}

	public void setFinancialYear(String financialYear) {
		_financialYear = financialYear;
	}

	private long _payrollIncrementId;
	private long _appraisalSettingId;
	private long _employeeId;
	private long _companyId;
	private long _employeeCode;
	private long _overallRatingMan;
	private double _preCtc;
	private double _postCtc;
	private long _componentId;
	private double _preHeadComponentVal;
	private double _postHeadComponentVal;
	private double _bonusVal;
	private String _financialYear;
}