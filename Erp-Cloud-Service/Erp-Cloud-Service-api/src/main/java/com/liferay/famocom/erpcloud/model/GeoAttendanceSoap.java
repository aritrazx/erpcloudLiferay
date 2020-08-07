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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.GeoAttendanceServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.GeoAttendanceServiceSoap
 * @generated
 */
@ProviderType
public class GeoAttendanceSoap implements Serializable {
	public static GeoAttendanceSoap toSoapModel(GeoAttendance model) {
		GeoAttendanceSoap soapModel = new GeoAttendanceSoap();

		soapModel.setAttendanceId(model.getAttendanceId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setAttDate(model.getAttDate());
		soapModel.setInTime(model.getInTime());
		soapModel.setOutTime(model.getOutTime());
		soapModel.setWorkHour(model.getWorkHour());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setOutLatitude(model.getOutLatitude());
		soapModel.setOutLongitude(model.getOutLongitude());
		soapModel.setGeoAddress(model.getGeoAddress());

		return soapModel;
	}

	public static GeoAttendanceSoap[] toSoapModels(GeoAttendance[] models) {
		GeoAttendanceSoap[] soapModels = new GeoAttendanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeoAttendanceSoap[][] toSoapModels(GeoAttendance[][] models) {
		GeoAttendanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeoAttendanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeoAttendanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeoAttendanceSoap[] toSoapModels(List<GeoAttendance> models) {
		List<GeoAttendanceSoap> soapModels = new ArrayList<GeoAttendanceSoap>(models.size());

		for (GeoAttendance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeoAttendanceSoap[soapModels.size()]);
	}

	public GeoAttendanceSoap() {
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

	public String getWorkHour() {
		return _workHour;
	}

	public void setWorkHour(String workHour) {
		_workHour = workHour;
	}

	public String getLatitude() {
		return _latitude;
	}

	public void setLatitude(String latitude) {
		_latitude = latitude;
	}

	public String getLongitude() {
		return _longitude;
	}

	public void setLongitude(String longitude) {
		_longitude = longitude;
	}

	public String getOutLatitude() {
		return _outLatitude;
	}

	public void setOutLatitude(String outLatitude) {
		_outLatitude = outLatitude;
	}

	public String getOutLongitude() {
		return _outLongitude;
	}

	public void setOutLongitude(String outLongitude) {
		_outLongitude = outLongitude;
	}

	public String getGeoAddress() {
		return _geoAddress;
	}

	public void setGeoAddress(String geoAddress) {
		_geoAddress = geoAddress;
	}

	private long _attendanceId;
	private long _employeeId;
	private Date _attDate;
	private String _inTime;
	private String _outTime;
	private String _workHour;
	private String _latitude;
	private String _longitude;
	private String _outLatitude;
	private String _outLongitude;
	private String _geoAddress;
}