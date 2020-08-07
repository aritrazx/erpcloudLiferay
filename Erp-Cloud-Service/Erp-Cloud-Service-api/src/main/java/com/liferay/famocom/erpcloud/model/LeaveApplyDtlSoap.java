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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.LeaveApplyDtlServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.LeaveApplyDtlServiceSoap
 * @generated
 */
@ProviderType
public class LeaveApplyDtlSoap implements Serializable {
	public static LeaveApplyDtlSoap toSoapModel(LeaveApplyDtl model) {
		LeaveApplyDtlSoap soapModel = new LeaveApplyDtlSoap();

		soapModel.setLeaveApplyDtlId(model.getLeaveApplyDtlId());
		soapModel.setLeaveApplyId(model.getLeaveApplyId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setLeaveTypeId(model.getLeaveTypeId());
		soapModel.setLeaveDate(model.getLeaveDate());
		soapModel.setSessionData(model.getSessionData());
		soapModel.setLeaveDays(model.getLeaveDays());
		soapModel.setImpectOnSalary(model.getImpectOnSalary());
		soapModel.setIsApprove(model.getIsApprove());

		return soapModel;
	}

	public static LeaveApplyDtlSoap[] toSoapModels(LeaveApplyDtl[] models) {
		LeaveApplyDtlSoap[] soapModels = new LeaveApplyDtlSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveApplyDtlSoap[][] toSoapModels(LeaveApplyDtl[][] models) {
		LeaveApplyDtlSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveApplyDtlSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveApplyDtlSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveApplyDtlSoap[] toSoapModels(List<LeaveApplyDtl> models) {
		List<LeaveApplyDtlSoap> soapModels = new ArrayList<LeaveApplyDtlSoap>(models.size());

		for (LeaveApplyDtl model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveApplyDtlSoap[soapModels.size()]);
	}

	public LeaveApplyDtlSoap() {
	}

	public long getPrimaryKey() {
		return _leaveApplyDtlId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveApplyDtlId(pk);
	}

	public long getLeaveApplyDtlId() {
		return _leaveApplyDtlId;
	}

	public void setLeaveApplyDtlId(long leaveApplyDtlId) {
		_leaveApplyDtlId = leaveApplyDtlId;
	}

	public long getLeaveApplyId() {
		return _leaveApplyId;
	}

	public void setLeaveApplyId(long leaveApplyId) {
		_leaveApplyId = leaveApplyId;
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

	public long getLeaveTypeId() {
		return _leaveTypeId;
	}

	public void setLeaveTypeId(long leaveTypeId) {
		_leaveTypeId = leaveTypeId;
	}

	public Date getLeaveDate() {
		return _leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		_leaveDate = leaveDate;
	}

	public String getSessionData() {
		return _sessionData;
	}

	public void setSessionData(String sessionData) {
		_sessionData = sessionData;
	}

	public double getLeaveDays() {
		return _leaveDays;
	}

	public void setLeaveDays(double leaveDays) {
		_leaveDays = leaveDays;
	}

	public int getImpectOnSalary() {
		return _impectOnSalary;
	}

	public void setImpectOnSalary(int impectOnSalary) {
		_impectOnSalary = impectOnSalary;
	}

	public int getIsApprove() {
		return _isApprove;
	}

	public void setIsApprove(int isApprove) {
		_isApprove = isApprove;
	}

	private long _leaveApplyDtlId;
	private long _leaveApplyId;
	private long _employeeId;
	private long _companyId;
	private long _leaveTypeId;
	private Date _leaveDate;
	private String _sessionData;
	private double _leaveDays;
	private int _impectOnSalary;
	private int _isApprove;
}