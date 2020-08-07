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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.AttendanceCheckListServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.AttendanceCheckListServiceSoap
 * @generated
 */
@ProviderType
public class AttendanceCheckListSoap implements Serializable {
	public static AttendanceCheckListSoap toSoapModel(AttendanceCheckList model) {
		AttendanceCheckListSoap soapModel = new AttendanceCheckListSoap();

		soapModel.setAttendanceCheckListId(model.getAttendanceCheckListId());
		soapModel.setAttDate(model.getAttDate());
		soapModel.setEmployeeCode(model.getEmployeeCode());
		soapModel.setFullName(model.getFullName());
		soapModel.setInTimeHour(model.getInTimeHour());
		soapModel.setInTimeMin(model.getInTimeMin());
		soapModel.setOutTimeHour(model.getOutTimeHour());
		soapModel.setOutTimeMin(model.getOutTimeMin());
		soapModel.setStatus(model.getStatus());
		soapModel.setMsg(model.getMsg());
		soapModel.setIndexNumber(model.getIndexNumber());
		soapModel.setPcDateAndTime(model.getPcDateAndTime());

		return soapModel;
	}

	public static AttendanceCheckListSoap[] toSoapModels(
		AttendanceCheckList[] models) {
		AttendanceCheckListSoap[] soapModels = new AttendanceCheckListSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttendanceCheckListSoap[][] toSoapModels(
		AttendanceCheckList[][] models) {
		AttendanceCheckListSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AttendanceCheckListSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttendanceCheckListSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttendanceCheckListSoap[] toSoapModels(
		List<AttendanceCheckList> models) {
		List<AttendanceCheckListSoap> soapModels = new ArrayList<AttendanceCheckListSoap>(models.size());

		for (AttendanceCheckList model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AttendanceCheckListSoap[soapModels.size()]);
	}

	public AttendanceCheckListSoap() {
	}

	public long getPrimaryKey() {
		return _attendanceCheckListId;
	}

	public void setPrimaryKey(long pk) {
		setAttendanceCheckListId(pk);
	}

	public long getAttendanceCheckListId() {
		return _attendanceCheckListId;
	}

	public void setAttendanceCheckListId(long attendanceCheckListId) {
		_attendanceCheckListId = attendanceCheckListId;
	}

	public Date getAttDate() {
		return _attDate;
	}

	public void setAttDate(Date attDate) {
		_attDate = attDate;
	}

	public long getEmployeeCode() {
		return _employeeCode;
	}

	public void setEmployeeCode(long employeeCode) {
		_employeeCode = employeeCode;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getInTimeHour() {
		return _inTimeHour;
	}

	public void setInTimeHour(String inTimeHour) {
		_inTimeHour = inTimeHour;
	}

	public String getInTimeMin() {
		return _inTimeMin;
	}

	public void setInTimeMin(String inTimeMin) {
		_inTimeMin = inTimeMin;
	}

	public String getOutTimeHour() {
		return _outTimeHour;
	}

	public void setOutTimeHour(String outTimeHour) {
		_outTimeHour = outTimeHour;
	}

	public String getOutTimeMin() {
		return _outTimeMin;
	}

	public void setOutTimeMin(String outTimeMin) {
		_outTimeMin = outTimeMin;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getMsg() {
		return _msg;
	}

	public void setMsg(String msg) {
		_msg = msg;
	}

	public int getIndexNumber() {
		return _indexNumber;
	}

	public void setIndexNumber(int indexNumber) {
		_indexNumber = indexNumber;
	}

	public Date getPcDateAndTime() {
		return _pcDateAndTime;
	}

	public void setPcDateAndTime(Date pcDateAndTime) {
		_pcDateAndTime = pcDateAndTime;
	}

	private long _attendanceCheckListId;
	private Date _attDate;
	private long _employeeCode;
	private String _fullName;
	private String _inTimeHour;
	private String _inTimeMin;
	private String _outTimeHour;
	private String _outTimeMin;
	private String _status;
	private String _msg;
	private int _indexNumber;
	private Date _pcDateAndTime;
}