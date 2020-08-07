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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.AttendanceServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.AttendanceServiceSoap
 * @generated
 */
@ProviderType
public class AttendanceSoap implements Serializable {
	public static AttendanceSoap toSoapModel(Attendance model) {
		AttendanceSoap soapModel = new AttendanceSoap();

		soapModel.setAttendanceId(model.getAttendanceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setEmployeeCode(model.getEmployeeCode());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setAttDate(model.getAttDate());
		soapModel.setInTimeHour(model.getInTimeHour());
		soapModel.setInTimeMin(model.getInTimeMin());
		soapModel.setOutTimeHour(model.getOutTimeHour());
		soapModel.setOutTimeMin(model.getOutTimeMin());
		soapModel.setInTime(model.getInTime());
		soapModel.setOutTime(model.getOutTime());
		soapModel.setInDatePc(model.getInDatePc());
		soapModel.setOutDatePc(model.getOutDatePc());
		soapModel.setTotal(model.getTotal());
		soapModel.setStatus(model.getStatus());
		soapModel.setIpPc(model.getIpPc());

		return soapModel;
	}

	public static AttendanceSoap[] toSoapModels(Attendance[] models) {
		AttendanceSoap[] soapModels = new AttendanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttendanceSoap[][] toSoapModels(Attendance[][] models) {
		AttendanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AttendanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttendanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttendanceSoap[] toSoapModels(List<Attendance> models) {
		List<AttendanceSoap> soapModels = new ArrayList<AttendanceSoap>(models.size());

		for (Attendance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AttendanceSoap[soapModels.size()]);
	}

	public AttendanceSoap() {
	}

	public long getPrimaryKey() {
		return _attendanceId;
	}

	public void setPrimaryKey(long pk) {
		setAttendanceId(pk);
	}

	public long getAttendanceId() {
		return _attendanceId;
	}

	public void setAttendanceId(long attendanceId) {
		_attendanceId = attendanceId;
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

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public Date getAttDate() {
		return _attDate;
	}

	public void setAttDate(Date attDate) {
		_attDate = attDate;
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

	public String getInTime() {
		return _inTime;
	}

	public void setInTime(String inTime) {
		_inTime = inTime;
	}

	public String getOutTime() {
		return _outTime;
	}

	public void setOutTime(String outTime) {
		_outTime = outTime;
	}

	public Date getInDatePc() {
		return _inDatePc;
	}

	public void setInDatePc(Date inDatePc) {
		_inDatePc = inDatePc;
	}

	public Date getOutDatePc() {
		return _outDatePc;
	}

	public void setOutDatePc(Date outDatePc) {
		_outDatePc = outDatePc;
	}

	public String getTotal() {
		return _total;
	}

	public void setTotal(String total) {
		_total = total;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getIpPc() {
		return _ipPc;
	}

	public void setIpPc(String ipPc) {
		_ipPc = ipPc;
	}

	private long _attendanceId;
	private long _companyId;
	private long _employeeCode;
	private long _employeeId;
	private Date _attDate;
	private String _inTimeHour;
	private String _inTimeMin;
	private String _outTimeHour;
	private String _outTimeMin;
	private String _inTime;
	private String _outTime;
	private Date _inDatePc;
	private Date _outDatePc;
	private String _total;
	private String _status;
	private String _ipPc;
}