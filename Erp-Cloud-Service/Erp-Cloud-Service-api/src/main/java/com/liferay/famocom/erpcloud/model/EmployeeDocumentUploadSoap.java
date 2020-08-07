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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.EmployeeDocumentUploadServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.EmployeeDocumentUploadServiceSoap
 * @generated
 */
@ProviderType
public class EmployeeDocumentUploadSoap implements Serializable {
	public static EmployeeDocumentUploadSoap toSoapModel(
		EmployeeDocumentUpload model) {
		EmployeeDocumentUploadSoap soapModel = new EmployeeDocumentUploadSoap();

		soapModel.setEmpDocumentId(model.getEmpDocumentId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setTravelDeskDetailsId(model.getTravelDeskDetailsId());
		soapModel.setDocumentName(model.getDocumentName());
		soapModel.setDocumentPath(model.getDocumentPath());
		soapModel.setUploadDate(model.getUploadDate());

		return soapModel;
	}

	public static EmployeeDocumentUploadSoap[] toSoapModels(
		EmployeeDocumentUpload[] models) {
		EmployeeDocumentUploadSoap[] soapModels = new EmployeeDocumentUploadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDocumentUploadSoap[][] toSoapModels(
		EmployeeDocumentUpload[][] models) {
		EmployeeDocumentUploadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeDocumentUploadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeDocumentUploadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDocumentUploadSoap[] toSoapModels(
		List<EmployeeDocumentUpload> models) {
		List<EmployeeDocumentUploadSoap> soapModels = new ArrayList<EmployeeDocumentUploadSoap>(models.size());

		for (EmployeeDocumentUpload model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeDocumentUploadSoap[soapModels.size()]);
	}

	public EmployeeDocumentUploadSoap() {
	}

	public long getPrimaryKey() {
		return _empDocumentId;
	}

	public void setPrimaryKey(long pk) {
		setEmpDocumentId(pk);
	}

	public long getEmpDocumentId() {
		return _empDocumentId;
	}

	public void setEmpDocumentId(long empDocumentId) {
		_empDocumentId = empDocumentId;
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

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public long getTravelDeskDetailsId() {
		return _travelDeskDetailsId;
	}

	public void setTravelDeskDetailsId(long travelDeskDetailsId) {
		_travelDeskDetailsId = travelDeskDetailsId;
	}

	public String getDocumentName() {
		return _documentName;
	}

	public void setDocumentName(String documentName) {
		_documentName = documentName;
	}

	public String getDocumentPath() {
		return _documentPath;
	}

	public void setDocumentPath(String documentPath) {
		_documentPath = documentPath;
	}

	public Date getUploadDate() {
		return _uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		_uploadDate = uploadDate;
	}

	private long _empDocumentId;
	private long _employeeId;
	private long _companyId;
	private long _fileEntryId;
	private long _travelDeskDetailsId;
	private String _documentName;
	private String _documentPath;
	private Date _uploadDate;
}