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

import com.liferay.famocom.erpcloud.model.TimeSheetMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TimeSheetMaster in entity cache.
 *
 * @author Samaresh
 * @see TimeSheetMaster
 * @generated
 */
@ProviderType
public class TimeSheetMasterCacheModel implements CacheModel<TimeSheetMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimeSheetMasterCacheModel)) {
			return false;
		}

		TimeSheetMasterCacheModel timeSheetMasterCacheModel = (TimeSheetMasterCacheModel)obj;

		if (timesheetParentId == timeSheetMasterCacheModel.timesheetParentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, timesheetParentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{timesheetParentId=");
		sb.append(timesheetParentId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", submitStatus=");
		sb.append(submitStatus);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TimeSheetMaster toEntityModel() {
		TimeSheetMasterImpl timeSheetMasterImpl = new TimeSheetMasterImpl();

		timeSheetMasterImpl.setTimesheetParentId(timesheetParentId);
		timeSheetMasterImpl.setEmployeeId(employeeId);

		if (fromDate == Long.MIN_VALUE) {
			timeSheetMasterImpl.setFromDate(null);
		}
		else {
			timeSheetMasterImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			timeSheetMasterImpl.setToDate(null);
		}
		else {
			timeSheetMasterImpl.setToDate(new Date(toDate));
		}

		timeSheetMasterImpl.setSubmitStatus(submitStatus);

		if (addedDate == Long.MIN_VALUE) {
			timeSheetMasterImpl.setAddedDate(null);
		}
		else {
			timeSheetMasterImpl.setAddedDate(new Date(addedDate));
		}

		timeSheetMasterImpl.setGroupId(groupId);
		timeSheetMasterImpl.setStatus(status);
		timeSheetMasterImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			timeSheetMasterImpl.setStatusByUserName("");
		}
		else {
			timeSheetMasterImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			timeSheetMasterImpl.setStatusDate(null);
		}
		else {
			timeSheetMasterImpl.setStatusDate(new Date(statusDate));
		}

		if (createDate == Long.MIN_VALUE) {
			timeSheetMasterImpl.setCreateDate(null);
		}
		else {
			timeSheetMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			timeSheetMasterImpl.setModifiedDate(null);
		}
		else {
			timeSheetMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		timeSheetMasterImpl.resetOriginalValues();

		return timeSheetMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		timesheetParentId = objectInput.readLong();

		employeeId = objectInput.readLong();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();

		submitStatus = objectInput.readInt();
		addedDate = objectInput.readLong();

		groupId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(timesheetParentId);

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		objectOutput.writeInt(submitStatus);
		objectOutput.writeLong(addedDate);

		objectOutput.writeLong(groupId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long timesheetParentId;
	public long employeeId;
	public long fromDate;
	public long toDate;
	public int submitStatus;
	public long addedDate;
	public long groupId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long createDate;
	public long modifiedDate;
}