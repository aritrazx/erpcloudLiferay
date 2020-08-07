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

import com.liferay.famocom.erpcloud.model.PushNotification;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PushNotification in entity cache.
 *
 * @author Samaresh
 * @see PushNotification
 * @generated
 */
@ProviderType
public class PushNotificationCacheModel implements CacheModel<PushNotification>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PushNotificationCacheModel)) {
			return false;
		}

		PushNotificationCacheModel pushNotificationCacheModel = (PushNotificationCacheModel)obj;

		if (pushNotificationId == pushNotificationCacheModel.pushNotificationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pushNotificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{pushNotificationId=");
		sb.append(pushNotificationId);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", message=");
		sb.append(message);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", fileUrl=");
		sb.append(fileUrl);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PushNotification toEntityModel() {
		PushNotificationImpl pushNotificationImpl = new PushNotificationImpl();

		pushNotificationImpl.setPushNotificationId(pushNotificationId);

		if (subject == null) {
			pushNotificationImpl.setSubject("");
		}
		else {
			pushNotificationImpl.setSubject(subject);
		}

		if (message == null) {
			pushNotificationImpl.setMessage("");
		}
		else {
			pushNotificationImpl.setMessage(message);
		}

		pushNotificationImpl.setFileId(fileId);

		if (fileUrl == null) {
			pushNotificationImpl.setFileUrl("");
		}
		else {
			pushNotificationImpl.setFileUrl(fileUrl);
		}

		if (createDate == Long.MIN_VALUE) {
			pushNotificationImpl.setCreateDate(null);
		}
		else {
			pushNotificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			pushNotificationImpl.setModifiedDate(null);
		}
		else {
			pushNotificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		pushNotificationImpl.resetOriginalValues();

		return pushNotificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		pushNotificationId = objectInput.readLong();
		subject = objectInput.readUTF();
		message = objectInput.readUTF();

		fileId = objectInput.readLong();
		fileUrl = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(pushNotificationId);

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		objectOutput.writeLong(fileId);

		if (fileUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileUrl);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long pushNotificationId;
	public String subject;
	public String message;
	public long fileId;
	public String fileUrl;
	public long createDate;
	public long modifiedDate;
}