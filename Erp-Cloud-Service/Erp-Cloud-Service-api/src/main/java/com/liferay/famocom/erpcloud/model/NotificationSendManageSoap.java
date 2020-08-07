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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.NotificationSendManageServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.NotificationSendManageServiceSoap
 * @generated
 */
@ProviderType
public class NotificationSendManageSoap implements Serializable {
	public static NotificationSendManageSoap toSoapModel(
		NotificationSendManage model) {
		NotificationSendManageSoap soapModel = new NotificationSendManageSoap();

		soapModel.setNotifyIdSendId(model.getNotifyIdSendId());
		soapModel.setNotificationId(model.getNotificationId());
		soapModel.setBranchId(model.getBranchId());
		soapModel.setSendingDate(model.getSendingDate());
		soapModel.setSendBy(model.getSendBy());
		soapModel.setIsOpen(model.isIsOpen());
		soapModel.setOpenBy(model.getOpenBy());
		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setIsApproved(model.getIsApproved());
		soapModel.setComment(model.getComment());
		soapModel.setDocumentUrl(model.getDocumentUrl());

		return soapModel;
	}

	public static NotificationSendManageSoap[] toSoapModels(
		NotificationSendManage[] models) {
		NotificationSendManageSoap[] soapModels = new NotificationSendManageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NotificationSendManageSoap[][] toSoapModels(
		NotificationSendManage[][] models) {
		NotificationSendManageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NotificationSendManageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NotificationSendManageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NotificationSendManageSoap[] toSoapModels(
		List<NotificationSendManage> models) {
		List<NotificationSendManageSoap> soapModels = new ArrayList<NotificationSendManageSoap>(models.size());

		for (NotificationSendManage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NotificationSendManageSoap[soapModels.size()]);
	}

	public NotificationSendManageSoap() {
	}

	public long getPrimaryKey() {
		return _notifyIdSendId;
	}

	public void setPrimaryKey(long pk) {
		setNotifyIdSendId(pk);
	}

	public long getNotifyIdSendId() {
		return _notifyIdSendId;
	}

	public void setNotifyIdSendId(long notifyIdSendId) {
		_notifyIdSendId = notifyIdSendId;
	}

	public long getNotificationId() {
		return _notificationId;
	}

	public void setNotificationId(long notificationId) {
		_notificationId = notificationId;
	}

	public long getBranchId() {
		return _branchId;
	}

	public void setBranchId(long branchId) {
		_branchId = branchId;
	}

	public Date getSendingDate() {
		return _sendingDate;
	}

	public void setSendingDate(Date sendingDate) {
		_sendingDate = sendingDate;
	}

	public String getSendBy() {
		return _sendBy;
	}

	public void setSendBy(String sendBy) {
		_sendBy = sendBy;
	}

	public boolean getIsOpen() {
		return _isOpen;
	}

	public boolean isIsOpen() {
		return _isOpen;
	}

	public void setIsOpen(boolean isOpen) {
		_isOpen = isOpen;
	}

	public String getOpenBy() {
		return _openBy;
	}

	public void setOpenBy(String openBy) {
		_openBy = openBy;
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	public int getIsApproved() {
		return _isApproved;
	}

	public void setIsApproved(int isApproved) {
		_isApproved = isApproved;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public String getDocumentUrl() {
		return _documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		_documentUrl = documentUrl;
	}

	private long _notifyIdSendId;
	private long _notificationId;
	private long _branchId;
	private Date _sendingDate;
	private String _sendBy;
	private boolean _isOpen;
	private String _openBy;
	private long _documentId;
	private int _isApproved;
	private String _comment;
	private String _documentUrl;
}