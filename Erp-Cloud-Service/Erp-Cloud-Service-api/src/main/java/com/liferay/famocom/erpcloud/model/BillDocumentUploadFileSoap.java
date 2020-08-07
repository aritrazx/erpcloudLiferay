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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.BillDocumentUploadFileServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.BillDocumentUploadFileServiceSoap
 * @generated
 */
@ProviderType
public class BillDocumentUploadFileSoap implements Serializable {
	public static BillDocumentUploadFileSoap toSoapModel(
		BillDocumentUploadFile model) {
		BillDocumentUploadFileSoap soapModel = new BillDocumentUploadFileSoap();

		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setDlFileEntryId(model.getDlFileEntryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setBillingId(model.getBillingId());
		soapModel.setDocumentName(model.getDocumentName());
		soapModel.setDocumentPath(model.getDocumentPath());
		soapModel.setUploadDate(model.getUploadDate());

		return soapModel;
	}

	public static BillDocumentUploadFileSoap[] toSoapModels(
		BillDocumentUploadFile[] models) {
		BillDocumentUploadFileSoap[] soapModels = new BillDocumentUploadFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BillDocumentUploadFileSoap[][] toSoapModels(
		BillDocumentUploadFile[][] models) {
		BillDocumentUploadFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BillDocumentUploadFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BillDocumentUploadFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BillDocumentUploadFileSoap[] toSoapModels(
		List<BillDocumentUploadFile> models) {
		List<BillDocumentUploadFileSoap> soapModels = new ArrayList<BillDocumentUploadFileSoap>(models.size());

		for (BillDocumentUploadFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BillDocumentUploadFileSoap[soapModels.size()]);
	}

	public BillDocumentUploadFileSoap() {
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

	public long getDlFileEntryId() {
		return _dlFileEntryId;
	}

	public void setDlFileEntryId(long dlFileEntryId) {
		_dlFileEntryId = dlFileEntryId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getBillingId() {
		return _billingId;
	}

	public void setBillingId(long billingId) {
		_billingId = billingId;
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

	private long _documentId;
	private long _dlFileEntryId;
	private long _companyId;
	private long _billingId;
	private String _documentName;
	private String _documentPath;
	private Date _uploadDate;
}