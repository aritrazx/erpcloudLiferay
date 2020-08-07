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

import com.liferay.famocom.erpcloud.model.TimeSheetEntry;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TimeSheetEntry in entity cache.
 *
 * @author Samaresh
 * @see TimeSheetEntry
 * @generated
 */
@ProviderType
public class TimeSheetEntryCacheModel implements CacheModel<TimeSheetEntry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimeSheetEntryCacheModel)) {
			return false;
		}

		TimeSheetEntryCacheModel timeSheetEntryCacheModel = (TimeSheetEntryCacheModel)obj;

		if (timesheetId == timeSheetEntryCacheModel.timesheetId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, timesheetId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{timesheetId=");
		sb.append(timesheetId);
		sb.append(", entryDate=");
		sb.append(entryDate);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", projectTaskId=");
		sb.append(projectTaskId);
		sb.append(", hours=");
		sb.append(hours);
		sb.append(", workDescription=");
		sb.append(workDescription);
		sb.append(", timesheetParentId=");
		sb.append(timesheetParentId);
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
	public TimeSheetEntry toEntityModel() {
		TimeSheetEntryImpl timeSheetEntryImpl = new TimeSheetEntryImpl();

		timeSheetEntryImpl.setTimesheetId(timesheetId);

		if (entryDate == Long.MIN_VALUE) {
			timeSheetEntryImpl.setEntryDate(null);
		}
		else {
			timeSheetEntryImpl.setEntryDate(new Date(entryDate));
		}

		timeSheetEntryImpl.setEmployeeId(employeeId);
		timeSheetEntryImpl.setProjectId(projectId);
		timeSheetEntryImpl.setProjectTaskId(projectTaskId);
		timeSheetEntryImpl.setHours(hours);

		if (workDescription == null) {
			timeSheetEntryImpl.setWorkDescription("");
		}
		else {
			timeSheetEntryImpl.setWorkDescription(workDescription);
		}

		timeSheetEntryImpl.setTimesheetParentId(timesheetParentId);

		if (addedDate == Long.MIN_VALUE) {
			timeSheetEntryImpl.setAddedDate(null);
		}
		else {
			timeSheetEntryImpl.setAddedDate(new Date(addedDate));
		}

		timeSheetEntryImpl.setGroupId(groupId);
		timeSheetEntryImpl.setStatus(status);
		timeSheetEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			timeSheetEntryImpl.setStatusByUserName("");
		}
		else {
			timeSheetEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			timeSheetEntryImpl.setStatusDate(null);
		}
		else {
			timeSheetEntryImpl.setStatusDate(new Date(statusDate));
		}

		if (createDate == Long.MIN_VALUE) {
			timeSheetEntryImpl.setCreateDate(null);
		}
		else {
			timeSheetEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			timeSheetEntryImpl.setModifiedDate(null);
		}
		else {
			timeSheetEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		timeSheetEntryImpl.resetOriginalValues();

		return timeSheetEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		timesheetId = objectInput.readLong();
		entryDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		projectId = objectInput.readLong();

		projectTaskId = objectInput.readLong();

		hours = objectInput.readDouble();
		workDescription = objectInput.readUTF();

		timesheetParentId = objectInput.readLong();
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
		objectOutput.writeLong(timesheetId);
		objectOutput.writeLong(entryDate);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(projectTaskId);

		objectOutput.writeDouble(hours);

		if (workDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workDescription);
		}

		objectOutput.writeLong(timesheetParentId);
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

	public long timesheetId;
	public long entryDate;
	public long employeeId;
	public long projectId;
	public long projectTaskId;
	public double hours;
	public String workDescription;
	public long timesheetParentId;
	public long addedDate;
	public long groupId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long createDate;
	public long modifiedDate;
}