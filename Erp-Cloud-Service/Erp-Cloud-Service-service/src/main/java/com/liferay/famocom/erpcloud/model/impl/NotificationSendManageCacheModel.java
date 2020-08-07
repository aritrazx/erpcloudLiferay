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

import com.liferay.famocom.erpcloud.model.NotificationSendManage;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NotificationSendManage in entity cache.
 *
 * @author Samaresh
 * @see NotificationSendManage
 * @generated
 */
@ProviderType
public class NotificationSendManageCacheModel implements CacheModel<NotificationSendManage>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationSendManageCacheModel)) {
			return false;
		}

		NotificationSendManageCacheModel notificationSendManageCacheModel = (NotificationSendManageCacheModel)obj;

		if (notifyIdSendId == notificationSendManageCacheModel.notifyIdSendId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, notifyIdSendId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{notifyIdSendId=");
		sb.append(notifyIdSendId);
		sb.append(", notificationId=");
		sb.append(notificationId);
		sb.append(", branchId=");
		sb.append(branchId);
		sb.append(", sendingDate=");
		sb.append(sendingDate);
		sb.append(", sendBy=");
		sb.append(sendBy);
		sb.append(", isOpen=");
		sb.append(isOpen);
		sb.append(", openBy=");
		sb.append(openBy);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", isApproved=");
		sb.append(isApproved);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", documentUrl=");
		sb.append(documentUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NotificationSendManage toEntityModel() {
		NotificationSendManageImpl notificationSendManageImpl = new NotificationSendManageImpl();

		notificationSendManageImpl.setNotifyIdSendId(notifyIdSendId);
		notificationSendManageImpl.setNotificationId(notificationId);
		notificationSendManageImpl.setBranchId(branchId);

		if (sendingDate == Long.MIN_VALUE) {
			notificationSendManageImpl.setSendingDate(null);
		}
		else {
			notificationSendManageImpl.setSendingDate(new Date(sendingDate));
		}

		if (sendBy == null) {
			notificationSendManageImpl.setSendBy("");
		}
		else {
			notificationSendManageImpl.setSendBy(sendBy);
		}

		notificationSendManageImpl.setIsOpen(isOpen);

		if (openBy == null) {
			notificationSendManageImpl.setOpenBy("");
		}
		else {
			notificationSendManageImpl.setOpenBy(openBy);
		}

		notificationSendManageImpl.setDocumentId(documentId);
		notificationSendManageImpl.setIsApproved(isApproved);

		if (comment == null) {
			notificationSendManageImpl.setComment("");
		}
		else {
			notificationSendManageImpl.setComment(comment);
		}

		if (documentUrl == null) {
			notificationSendManageImpl.setDocumentUrl("");
		}
		else {
			notificationSendManageImpl.setDocumentUrl(documentUrl);
		}

		notificationSendManageImpl.resetOriginalValues();

		return notificationSendManageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		notifyIdSendId = objectInput.readLong();

		notificationId = objectInput.readLong();

		branchId = objectInput.readLong();
		sendingDate = objectInput.readLong();
		sendBy = objectInput.readUTF();

		isOpen = objectInput.readBoolean();
		openBy = objectInput.readUTF();

		documentId = objectInput.readLong();

		isApproved = objectInput.readInt();
		comment = objectInput.readUTF();
		documentUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(notifyIdSendId);

		objectOutput.writeLong(notificationId);

		objectOutput.writeLong(branchId);
		objectOutput.writeLong(sendingDate);

		if (sendBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sendBy);
		}

		objectOutput.writeBoolean(isOpen);

		if (openBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(openBy);
		}

		objectOutput.writeLong(documentId);

		objectOutput.writeInt(isApproved);

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}

		if (documentUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentUrl);
		}
	}

	public long notifyIdSendId;
	public long notificationId;
	public long branchId;
	public long sendingDate;
	public String sendBy;
	public boolean isOpen;
	public String openBy;
	public long documentId;
	public int isApproved;
	public String comment;
	public String documentUrl;
}