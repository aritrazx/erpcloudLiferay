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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.PayrollSlabsServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.PayrollSlabsServiceSoap
 * @generated
 */
@ProviderType
public class PayrollSlabsSoap implements Serializable {
	public static PayrollSlabsSoap toSoapModel(PayrollSlabs model) {
		PayrollSlabsSoap soapModel = new PayrollSlabsSoap();

		soapModel.setPayrollSlabsId(model.getPayrollSlabsId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAppraisalSettingId(model.getAppraisalSettingId());
		soapModel.setRatingId(model.getRatingId());
		soapModel.setPayrollPercentage(model.getPayrollPercentage());
		soapModel.setBonusPercentage(model.getBonusPercentage());

		return soapModel;
	}

	public static PayrollSlabsSoap[] toSoapModels(PayrollSlabs[] models) {
		PayrollSlabsSoap[] soapModels = new PayrollSlabsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PayrollSlabsSoap[][] toSoapModels(PayrollSlabs[][] models) {
		PayrollSlabsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PayrollSlabsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PayrollSlabsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PayrollSlabsSoap[] toSoapModels(List<PayrollSlabs> models) {
		List<PayrollSlabsSoap> soapModels = new ArrayList<PayrollSlabsSoap>(models.size());

		for (PayrollSlabs model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PayrollSlabsSoap[soapModels.size()]);
	}

	public PayrollSlabsSoap() {
	}

	public long getPrimaryKey() {
		return _payrollSlabsId;
	}

	public void setPrimaryKey(long pk) {
		setPayrollSlabsId(pk);
	}

	public long getPayrollSlabsId() {
		return _payrollSlabsId;
	}

	public void setPayrollSlabsId(long payrollSlabsId) {
		_payrollSlabsId = payrollSlabsId;
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

	public long getRatingId() {
		return _ratingId;
	}

	public void setRatingId(long ratingId) {
		_ratingId = ratingId;
	}

	public double getPayrollPercentage() {
		return _payrollPercentage;
	}

	public void setPayrollPercentage(double payrollPercentage) {
		_payrollPercentage = payrollPercentage;
	}

	public double getBonusPercentage() {
		return _bonusPercentage;
	}

	public void setBonusPercentage(double bonusPercentage) {
		_bonusPercentage = bonusPercentage;
	}

	private long _payrollSlabsId;
	private long _companyId;
	private long _appraisalSettingId;
	private long _ratingId;
	private double _payrollPercentage;
	private double _bonusPercentage;
}