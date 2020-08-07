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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.LeaveDocServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.LeaveDocServiceSoap
 * @generated
 */
@ProviderType
public class LeaveDocSoap implements Serializable {
	public static LeaveDocSoap toSoapModel(LeaveDoc model) {
		LeaveDocSoap soapModel = new LeaveDocSoap();

		soapModel.setLeaveDocId(model.getLeaveDocId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setLeaveApplyId(model.getLeaveApplyId());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setFilePath(model.getFilePath());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static LeaveDocSoap[] toSoapModels(LeaveDoc[] models) {
		LeaveDocSoap[] soapModels = new LeaveDocSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveDocSoap[][] toSoapModels(LeaveDoc[][] models) {
		LeaveDocSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveDocSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveDocSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveDocSoap[] toSoapModels(List<LeaveDoc> models) {
		List<LeaveDocSoap> soapModels = new ArrayList<LeaveDocSoap>(models.size());

		for (LeaveDoc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveDocSoap[soapModels.size()]);
	}

	public LeaveDocSoap() {
	}

	public long getPrimaryKey() {
		return _leaveDocId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveDocId(pk);
	}

	public long getLeaveDocId() {
		return _leaveDocId;
	}

	public void setLeaveDocId(long leaveDocId) {
		_leaveDocId = leaveDocId;
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

	public long getLeaveApplyId() {
		return _leaveApplyId;
	}

	public void setLeaveApplyId(long leaveApplyId) {
		_leaveApplyId = leaveApplyId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public String getFilePath() {
		return _filePath;
	}

	public void setFilePath(String filePath) {
		_filePath = filePath;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _leaveDocId;
	private long _employeeId;
	private long _companyId;
	private long _leaveApplyId;
	private long _fileEntryId;
	private String _filePath;
	private Date _addedDate;
}