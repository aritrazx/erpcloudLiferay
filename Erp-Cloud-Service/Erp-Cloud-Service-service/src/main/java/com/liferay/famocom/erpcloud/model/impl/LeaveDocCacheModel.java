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

import com.liferay.famocom.erpcloud.model.LeaveDoc;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveDoc in entity cache.
 *
 * @author Samaresh
 * @see LeaveDoc
 * @generated
 */
@ProviderType
public class LeaveDocCacheModel implements CacheModel<LeaveDoc>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveDocCacheModel)) {
			return false;
		}

		LeaveDocCacheModel leaveDocCacheModel = (LeaveDocCacheModel)obj;

		if (leaveDocId == leaveDocCacheModel.leaveDocId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveDocId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{leaveDocId=");
		sb.append(leaveDocId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", leaveApplyId=");
		sb.append(leaveApplyId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", filePath=");
		sb.append(filePath);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveDoc toEntityModel() {
		LeaveDocImpl leaveDocImpl = new LeaveDocImpl();

		leaveDocImpl.setLeaveDocId(leaveDocId);
		leaveDocImpl.setEmployeeId(employeeId);
		leaveDocImpl.setCompanyId(companyId);
		leaveDocImpl.setLeaveApplyId(leaveApplyId);
		leaveDocImpl.setFileEntryId(fileEntryId);

		if (filePath == null) {
			leaveDocImpl.setFilePath("");
		}
		else {
			leaveDocImpl.setFilePath(filePath);
		}

		if (addedDate == Long.MIN_VALUE) {
			leaveDocImpl.setAddedDate(null);
		}
		else {
			leaveDocImpl.setAddedDate(new Date(addedDate));
		}

		leaveDocImpl.resetOriginalValues();

		return leaveDocImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveDocId = objectInput.readLong();

		employeeId = objectInput.readLong();

		companyId = objectInput.readLong();

		leaveApplyId = objectInput.readLong();

		fileEntryId = objectInput.readLong();
		filePath = objectInput.readUTF();
		addedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveDocId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(leaveApplyId);

		objectOutput.writeLong(fileEntryId);

		if (filePath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filePath);
		}

		objectOutput.writeLong(addedDate);
	}

	public long leaveDocId;
	public long employeeId;
	public long companyId;
	public long leaveApplyId;
	public long fileEntryId;
	public String filePath;
	public long addedDate;
}