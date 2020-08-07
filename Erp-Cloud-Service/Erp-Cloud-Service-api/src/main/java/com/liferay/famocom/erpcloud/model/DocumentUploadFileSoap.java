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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.DocumentUploadFileServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.DocumentUploadFileServiceSoap
 * @generated
 */
@ProviderType
public class DocumentUploadFileSoap implements Serializable {
	public static DocumentUploadFileSoap toSoapModel(DocumentUploadFile model) {
		DocumentUploadFileSoap soapModel = new DocumentUploadFileSoap();

		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setDocumentName(model.getDocumentName());
		soapModel.setDocumentPath(model.getDocumentPath());
		soapModel.setUploadDate(model.getUploadDate());
		soapModel.setTravelDetailsId(model.getTravelDetailsId());

		return soapModel;
	}

	public static DocumentUploadFileSoap[] toSoapModels(
		DocumentUploadFile[] models) {
		DocumentUploadFileSoap[] soapModels = new DocumentUploadFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DocumentUploadFileSoap[][] toSoapModels(
		DocumentUploadFile[][] models) {
		DocumentUploadFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DocumentUploadFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DocumentUploadFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DocumentUploadFileSoap[] toSoapModels(
		List<DocumentUploadFile> models) {
		List<DocumentUploadFileSoap> soapModels = new ArrayList<DocumentUploadFileSoap>(models.size());

		for (DocumentUploadFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DocumentUploadFileSoap[soapModels.size()]);
	}

	public DocumentUploadFileSoap() {
	}

	public long getPrimaryKey() {
		return _documentId;
	}

	public void setPrimaryKey(long pk) {
		setDocumentId(pk);
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
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

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
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

	public long getTravelDetailsId() {
		return _travelDetailsId;
	}

	public void setTravelDetailsId(long travelDetailsId) {
		_travelDetailsId = travelDetailsId;
	}

	private long _documentId;
	private long _companyId;
	private long _employeeId;
	private long _fileEntryId;
	private String _documentName;
	private String _documentPath;
	private Date _uploadDate;
	private long _travelDetailsId;
}