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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.CompanyPolicyServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.CompanyPolicyServiceSoap
 * @generated
 */
@ProviderType
public class CompanyPolicySoap implements Serializable {
	public static CompanyPolicySoap toSoapModel(CompanyPolicy model) {
		CompanyPolicySoap soapModel = new CompanyPolicySoap();

		soapModel.setCompanyPolicyId(model.getCompanyPolicyId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setDaysLocking(model.getDaysLocking());
		soapModel.setCheckStatus(model.getCheckStatus());
		soapModel.setAddedDate(model.getAddedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CompanyPolicySoap[] toSoapModels(CompanyPolicy[] models) {
		CompanyPolicySoap[] soapModels = new CompanyPolicySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CompanyPolicySoap[][] toSoapModels(CompanyPolicy[][] models) {
		CompanyPolicySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CompanyPolicySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CompanyPolicySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CompanyPolicySoap[] toSoapModels(List<CompanyPolicy> models) {
		List<CompanyPolicySoap> soapModels = new ArrayList<CompanyPolicySoap>(models.size());

		for (CompanyPolicy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CompanyPolicySoap[soapModels.size()]);
	}

	public CompanyPolicySoap() {
	}

	public long getPrimaryKey() {
		return _companyPolicyId;
	}

	public void setPrimaryKey(long pk) {
		setCompanyPolicyId(pk);
	}

	public long getCompanyPolicyId() {
		return _companyPolicyId;
	}

	public void setCompanyPolicyId(long companyPolicyId) {
		_companyPolicyId = companyPolicyId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public int getDaysLocking() {
		return _daysLocking;
	}

	public void setDaysLocking(int daysLocking) {
		_daysLocking = daysLocking;
	}

	public int getCheckStatus() {
		return _checkStatus;
	}

	public void setCheckStatus(int checkStatus) {
		_checkStatus = checkStatus;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _companyPolicyId;
	private long _companyId;
	private int _daysLocking;
	private int _checkStatus;
	private Date _addedDate;
	private Date _modifiedDate;
}