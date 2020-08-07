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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.AttendanceBioServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.AttendanceBioServiceSoap
 * @generated
 */
@ProviderType
public class AttendanceBioSoap implements Serializable {
	public static AttendanceBioSoap toSoapModel(AttendanceBio model) {
		AttendanceBioSoap soapModel = new AttendanceBioSoap();

		soapModel.setAttendanceBioId(model.getAttendanceBioId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setAttDate(model.getAttDate());
		soapModel.setAttTime(model.getAttTime());
		soapModel.setUploadDate(model.getUploadDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static AttendanceBioSoap[] toSoapModels(AttendanceBio[] models) {
		AttendanceBioSoap[] soapModels = new AttendanceBioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttendanceBioSoap[][] toSoapModels(AttendanceBio[][] models) {
		AttendanceBioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AttendanceBioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttendanceBioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttendanceBioSoap[] toSoapModels(List<AttendanceBio> models) {
		List<AttendanceBioSoap> soapModels = new ArrayList<AttendanceBioSoap>(models.size());

		for (AttendanceBio model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AttendanceBioSoap[soapModels.size()]);
	}

	public AttendanceBioSoap() {
	}

	public long getPrimaryKey() {
		return _attendanceBioId;
	}

	public void setPrimaryKey(long pk) {
		setAttendanceBioId(pk);
	}

	public long getAttendanceBioId() {
		return _attendanceBioId;
	}

	public void setAttendanceBioId(long attendanceBioId) {
		_attendanceBioId = attendanceBioId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public String getAttTime() {
		return _attTime;
	}

	public void setAttTime(String attTime) {
		_attTime = attTime;
	}

	public Date getUploadDate() {
		return _uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		_uploadDate = uploadDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _attendanceBioId;
	private long _companyId;
	private long _employeeId;
	private Date _attDate;
	private String _attTime;
	private Date _uploadDate;
	private int _status;
}