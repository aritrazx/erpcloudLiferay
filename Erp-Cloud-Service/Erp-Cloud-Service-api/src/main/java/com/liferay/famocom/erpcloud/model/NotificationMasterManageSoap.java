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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.NotificationMasterManageServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.NotificationMasterManageServiceSoap
 * @generated
 */
@ProviderType
public class NotificationMasterManageSoap implements Serializable {
	public static NotificationMasterManageSoap toSoapModel(
		NotificationMasterManage model) {
		NotificationMasterManageSoap soapModel = new NotificationMasterManageSoap();

		soapModel.setNotifyId(model.getNotifyId());
		soapModel.setSubject(model.getSubject());
		soapModel.setBody(model.getBody());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setDocumentUrl(model.getDocumentUrl());

		return soapModel;
	}

	public static NotificationMasterManageSoap[] toSoapModels(
		NotificationMasterManage[] models) {
		NotificationMasterManageSoap[] soapModels = new NotificationMasterManageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NotificationMasterManageSoap[][] toSoapModels(
		NotificationMasterManage[][] models) {
		NotificationMasterManageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NotificationMasterManageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NotificationMasterManageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NotificationMasterManageSoap[] toSoapModels(
		List<NotificationMasterManage> models) {
		List<NotificationMasterManageSoap> soapModels = new ArrayList<NotificationMasterManageSoap>(models.size());

		for (NotificationMasterManage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NotificationMasterManageSoap[soapModels.size()]);
	}

	public NotificationMasterManageSoap() {
	}

	public long getPrimaryKey() {
		return _notifyId;
	}

	public void setPrimaryKey(long pk) {
		setNotifyId(pk);
	}

	public long getNotifyId() {
		return _notifyId;
	}

	public void setNotifyId(long notifyId) {
		_notifyId = notifyId;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getBody() {
		return _body;
	}

	public void setBody(String body) {
		_body = body;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	public String getDocumentUrl() {
		return _documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		_documentUrl = documentUrl;
	}

	private long _notifyId;
	private String _subject;
	private String _body;
	private String _createdBy;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _documentId;
	private String _documentUrl;
}