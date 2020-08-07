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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.StopPayServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.StopPayServiceSoap
 * @generated
 */
@ProviderType
public class StopPaySoap implements Serializable {
	public static StopPaySoap toSoapModel(StopPay model) {
		StopPaySoap soapModel = new StopPaySoap();

		soapModel.setStopPayId(model.getStopPayId());
		soapModel.setMonthYear(model.getMonthYear());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setReason(model.getReason());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setStatus(model.getStatus());
		soapModel.setIsLock(model.getIsLock());

		return soapModel;
	}

	public static StopPaySoap[] toSoapModels(StopPay[] models) {
		StopPaySoap[] soapModels = new StopPaySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StopPaySoap[][] toSoapModels(StopPay[][] models) {
		StopPaySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StopPaySoap[models.length][models[0].length];
		}
		else {
			soapModels = new StopPaySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StopPaySoap[] toSoapModels(List<StopPay> models) {
		List<StopPaySoap> soapModels = new ArrayList<StopPaySoap>(models.size());

		for (StopPay model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StopPaySoap[soapModels.size()]);
	}

	public StopPaySoap() {
	}

	public long getPrimaryKey() {
		return _stopPayId;
	}

	public void setPrimaryKey(long pk) {
		setStopPayId(pk);
	}

	public long getStopPayId() {
		return _stopPayId;
	}

	public void setStopPayId(long stopPayId) {
		_stopPayId = stopPayId;
	}

	public long getMonthYear() {
		return _monthYear;
	}

	public void setMonthYear(long monthYear) {
		_monthYear = monthYear;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
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

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public long getIsLock() {
		return _isLock;
	}

	public void setIsLock(long isLock) {
		_isLock = isLock;
	}

	private long _stopPayId;
	private long _monthYear;
	private long _employeeId;
	private String _reason;
	private long _createdBy;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _modifiedBy;
	private long _status;
	private long _isLock;
}