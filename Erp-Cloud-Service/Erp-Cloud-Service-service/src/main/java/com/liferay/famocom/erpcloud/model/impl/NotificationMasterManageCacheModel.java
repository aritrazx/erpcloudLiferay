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

package com.liferay.famocom.erpcloud.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.NotificationMasterManage;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NotificationMasterManage in entity cache.
 *
 * @author Samaresh
 * @see NotificationMasterManage
 * @generated
 */
@ProviderType
public class NotificationMasterManageCacheModel implements CacheModel<NotificationMasterManage>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationMasterManageCacheModel)) {
			return false;
		}

		NotificationMasterManageCacheModel notificationMasterManageCacheModel = (NotificationMasterManageCacheModel)obj;

		if (notifyId == notificationMasterManageCacheModel.notifyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, notifyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{notifyId=");
		sb.append(notifyId);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", body=");
		sb.append(body);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", documentUrl=");
		sb.append(documentUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NotificationMasterManage toEntityModel() {
		NotificationMasterManageImpl notificationMasterManageImpl = new NotificationMasterManageImpl();

		notificationMasterManageImpl.setNotifyId(notifyId);

		if (subject == null) {
			notificationMasterManageImpl.setSubject("");
		}
		else {
			notificationMasterManageImpl.setSubject(subject);
		}

		if (body == null) {
			notificationMasterManageImpl.setBody("");
		}
		else {
			notificationMasterManageImpl.setBody(body);
		}

		if (createdBy == null) {
			notificationMasterManageImpl.setCreatedBy("");
		}
		else {
			notificationMasterManageImpl.setCreatedBy(createdBy);
		}

		if (createdDate == Long.MIN_VALUE) {
			notificationMasterManageImpl.setCreatedDate(null);
		}
		else {
			notificationMasterManageImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			notificationMasterManageImpl.setModifiedDate(null);
		}
		else {
			notificationMasterManageImpl.setModifiedDate(new Date(modifiedDate));
		}

		notificationMasterManageImpl.setDocumentId(documentId);

		if (documentUrl == null) {
			notificationMasterManageImpl.setDocumentUrl("");
		}
		else {
			notificationMasterManageImpl.setDocumentUrl(documentUrl);
		}

		notificationMasterManageImpl.resetOriginalValues();

		return notificationMasterManageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		notifyId = objectInput.readLong();
		subject = objectInput.readUTF();
		body = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		documentId = objectInput.readLong();
		documentUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(notifyId);

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (body == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(body);
		}

		if (createdBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(documentId);

		if (documentUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentUrl);
		}
	}

	public long notifyId;
	public String subject;
	public String body;
	public String createdBy;
	public long createdDate;
	public long modifiedDate;
	public long documentId;
	public String documentUrl;
}