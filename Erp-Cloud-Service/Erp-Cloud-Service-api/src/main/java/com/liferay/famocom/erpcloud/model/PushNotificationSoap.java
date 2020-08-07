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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.PushNotificationServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.PushNotificationServiceSoap
 * @generated
 */
@ProviderType
public class PushNotificationSoap implements Serializable {
	public static PushNotificationSoap toSoapModel(PushNotification model) {
		PushNotificationSoap soapModel = new PushNotificationSoap();

		soapModel.setPushNotificationId(model.getPushNotificationId());
		soapModel.setSubject(model.getSubject());
		soapModel.setMessage(model.getMessage());
		soapModel.setFileId(model.getFileId());
		soapModel.setFileUrl(model.getFileUrl());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static PushNotificationSoap[] toSoapModels(PushNotification[] models) {
		PushNotificationSoap[] soapModels = new PushNotificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PushNotificationSoap[][] toSoapModels(
		PushNotification[][] models) {
		PushNotificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PushNotificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PushNotificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PushNotificationSoap[] toSoapModels(
		List<PushNotification> models) {
		List<PushNotificationSoap> soapModels = new ArrayList<PushNotificationSoap>(models.size());

		for (PushNotification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PushNotificationSoap[soapModels.size()]);
	}

	public PushNotificationSoap() {
	}

	public long getPrimaryKey() {
		return _pushNotificationId;
	}

	public void setPrimaryKey(long pk) {
		setPushNotificationId(pk);
	}

	public long getPushNotificationId() {
		return _pushNotificationId;
	}

	public void setPushNotificationId(long pushNotificationId) {
		_pushNotificationId = pushNotificationId;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFileUrl() {
		return _fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		_fileUrl = fileUrl;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _pushNotificationId;
	private String _subject;
	private String _message;
	private long _fileId;
	private String _fileUrl;
	private Date _createDate;
	private Date _modifiedDate;
}