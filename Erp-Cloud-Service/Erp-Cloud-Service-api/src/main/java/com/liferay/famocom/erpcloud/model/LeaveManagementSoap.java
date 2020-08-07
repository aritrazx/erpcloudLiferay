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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.LeaveManagementServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.LeaveManagementServiceSoap
 * @generated
 */
@ProviderType
public class LeaveManagementSoap implements Serializable {
	public static LeaveManagementSoap toSoapModel(LeaveManagement model) {
		LeaveManagementSoap soapModel = new LeaveManagementSoap();

		soapModel.setLeaveId(model.getLeaveId());
		soapModel.setLeaveName(model.getLeaveName());
		soapModel.setAbb(model.getAbb());
		soapModel.setEncashmentDay(model.getEncashmentDay());
		soapModel.setForwardDay(model.getForwardDay());
		soapModel.setLeaveStatus(model.isLeaveStatus());
		soapModel.setEncashmentPer(model.getEncashmentPer());
		soapModel.setMinServiceDay(model.getMinServiceDay());
		soapModel.setNoticeDay(model.getNoticeDay());
		soapModel.setEmployeetypeId(model.getEmployeetypeId());
		soapModel.setMaxCreditDay(model.getMaxCreditDay());
		soapModel.setGender(model.getGender());
		soapModel.setMaritalStatus(model.getMaritalStatus());
		soapModel.setImpectOnSalary(model.getImpectOnSalary());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static LeaveManagementSoap[] toSoapModels(LeaveManagement[] models) {
		LeaveManagementSoap[] soapModels = new LeaveManagementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveManagementSoap[][] toSoapModels(
		LeaveManagement[][] models) {
		LeaveManagementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveManagementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveManagementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveManagementSoap[] toSoapModels(
		List<LeaveManagement> models) {
		List<LeaveManagementSoap> soapModels = new ArrayList<LeaveManagementSoap>(models.size());

		for (LeaveManagement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveManagementSoap[soapModels.size()]);
	}

	public LeaveManagementSoap() {
	}

	public long getPrimaryKey() {
		return _leaveId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveId(pk);
	}

	public long getLeaveId() {
		return _leaveId;
	}

	public void setLeaveId(long leaveId) {
		_leaveId = leaveId;
	}

	public String getLeaveName() {
		return _leaveName;
	}

	public void setLeaveName(String leaveName) {
		_leaveName = leaveName;
	}

	public String getAbb() {
		return _abb;
	}

	public void setAbb(String abb) {
		_abb = abb;
	}

	public int getEncashmentDay() {
		return _encashmentDay;
	}

	public void setEncashmentDay(int encashmentDay) {
		_encashmentDay = encashmentDay;
	}

	public int getForwardDay() {
		return _forwardDay;
	}

	public void setForwardDay(int forwardDay) {
		_forwardDay = forwardDay;
	}

	public boolean getLeaveStatus() {
		return _leaveStatus;
	}

	public boolean isLeaveStatus() {
		return _leaveStatus;
	}

	public void setLeaveStatus(boolean leaveStatus) {
		_leaveStatus = leaveStatus;
	}

	public int getEncashmentPer() {
		return _encashmentPer;
	}

	public void setEncashmentPer(int encashmentPer) {
		_encashmentPer = encashmentPer;
	}

	public int getMinServiceDay() {
		return _minServiceDay;
	}

	public void setMinServiceDay(int minServiceDay) {
		_minServiceDay = minServiceDay;
	}

	public int getNoticeDay() {
		return _noticeDay;
	}

	public void setNoticeDay(int noticeDay) {
		_noticeDay = noticeDay;
	}

	public long getEmployeetypeId() {
		return _employeetypeId;
	}

	public void setEmployeetypeId(long employeetypeId) {
		_employeetypeId = employeetypeId;
	}

	public int getMaxCreditDay() {
		return _maxCreditDay;
	}

	public void setMaxCreditDay(int maxCreditDay) {
		_maxCreditDay = maxCreditDay;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getMaritalStatus() {
		return _maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		_maritalStatus = maritalStatus;
	}

	public int getImpectOnSalary() {
		return _impectOnSalary;
	}

	public void setImpectOnSalary(int impectOnSalary) {
		_impectOnSalary = impectOnSalary;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _leaveId;
	private String _leaveName;
	private String _abb;
	private int _encashmentDay;
	private int _forwardDay;
	private boolean _leaveStatus;
	private int _encashmentPer;
	private int _minServiceDay;
	private int _noticeDay;
	private long _employeetypeId;
	private int _maxCreditDay;
	private String _gender;
	private String _maritalStatus;
	private int _impectOnSalary;
	private long _companyId;
	private Date _addedDate;
}