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

import com.liferay.famocom.erpcloud.model.LeaveApply;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveApply in entity cache.
 *
 * @author Samaresh
 * @see LeaveApply
 * @generated
 */
@ProviderType
public class LeaveApplyCacheModel implements CacheModel<LeaveApply>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveApplyCacheModel)) {
			return false;
		}

		LeaveApplyCacheModel leaveApplyCacheModel = (LeaveApplyCacheModel)obj;

		if (leaveApplyId == leaveApplyCacheModel.leaveApplyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveApplyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{leaveApplyId=");
		sb.append(leaveApplyId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", leaveTypeId=");
		sb.append(leaveTypeId);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", fromDateSession=");
		sb.append(fromDateSession);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", toDateSession=");
		sb.append(toDateSession);
		sb.append(", leaveDays=");
		sb.append(leaveDays);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", attachedFile=");
		sb.append(attachedFile);
		sb.append(", cancelReason=");
		sb.append(cancelReason);
		sb.append(", hrComments=");
		sb.append(hrComments);
		sb.append(", isApprove=");
		sb.append(isApprove);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
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
	public LeaveApply toEntityModel() {
		LeaveApplyImpl leaveApplyImpl = new LeaveApplyImpl();

		leaveApplyImpl.setLeaveApplyId(leaveApplyId);
		leaveApplyImpl.setCompanyId(companyId);
		leaveApplyImpl.setEmployeeId(employeeId);
		leaveApplyImpl.setLeaveTypeId(leaveTypeId);

		if (fromDate == Long.MIN_VALUE) {
			leaveApplyImpl.setFromDate(null);
		}
		else {
			leaveApplyImpl.setFromDate(new Date(fromDate));
		}

		if (fromDateSession == null) {
			leaveApplyImpl.setFromDateSession("");
		}
		else {
			leaveApplyImpl.setFromDateSession(fromDateSession);
		}

		if (toDate == Long.MIN_VALUE) {
			leaveApplyImpl.setToDate(null);
		}
		else {
			leaveApplyImpl.setToDate(new Date(toDate));
		}

		if (toDateSession == null) {
			leaveApplyImpl.setToDateSession("");
		}
		else {
			leaveApplyImpl.setToDateSession(toDateSession);
		}

		leaveApplyImpl.setLeaveDays(leaveDays);

		if (reason == null) {
			leaveApplyImpl.setReason("");
		}
		else {
			leaveApplyImpl.setReason(reason);
		}

		if (attachedFile == null) {
			leaveApplyImpl.setAttachedFile("");
		}
		else {
			leaveApplyImpl.setAttachedFile(attachedFile);
		}

		if (cancelReason == null) {
			leaveApplyImpl.setCancelReason("");
		}
		else {
			leaveApplyImpl.setCancelReason(cancelReason);
		}

		if (hrComments == null) {
			leaveApplyImpl.setHrComments("");
		}
		else {
			leaveApplyImpl.setHrComments(hrComments);
		}

		leaveApplyImpl.setIsApprove(isApprove);

		if (addedDate == Long.MIN_VALUE) {
			leaveApplyImpl.setAddedDate(null);
		}
		else {
			leaveApplyImpl.setAddedDate(new Date(addedDate));
		}

		leaveApplyImpl.setUserId(userId);
		leaveApplyImpl.setFileEntryId(fileEntryId);
		leaveApplyImpl.setGroupId(groupId);
		leaveApplyImpl.setStatus(status);
		leaveApplyImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			leaveApplyImpl.setStatusByUserName("");
		}
		else {
			leaveApplyImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			leaveApplyImpl.setStatusDate(null);
		}
		else {
			leaveApplyImpl.setStatusDate(new Date(statusDate));
		}

		if (createDate == Long.MIN_VALUE) {
			leaveApplyImpl.setCreateDate(null);
		}
		else {
			leaveApplyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveApplyImpl.setModifiedDate(null);
		}
		else {
			leaveApplyImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveApplyImpl.resetOriginalValues();

		return leaveApplyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveApplyId = objectInput.readLong();

		companyId = objectInput.readLong();

		employeeId = objectInput.readLong();

		leaveTypeId = objectInput.readLong();
		fromDate = objectInput.readLong();
		fromDateSession = objectInput.readUTF();
		toDate = objectInput.readLong();
		toDateSession = objectInput.readUTF();

		leaveDays = objectInput.readDouble();
		reason = objectInput.readUTF();
		attachedFile = objectInput.readUTF();
		cancelReason = objectInput.readUTF();
		hrComments = objectInput.readUTF();

		isApprove = objectInput.readInt();
		addedDate = objectInput.readLong();

		userId = objectInput.readLong();

		fileEntryId = objectInput.readLong();

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
		objectOutput.writeLong(leaveApplyId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(leaveTypeId);
		objectOutput.writeLong(fromDate);

		if (fromDateSession == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fromDateSession);
		}

		objectOutput.writeLong(toDate);

		if (toDateSession == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(toDateSession);
		}

		objectOutput.writeDouble(leaveDays);

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}

		if (attachedFile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attachedFile);
		}

		if (cancelReason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cancelReason);
		}

		if (hrComments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hrComments);
		}

		objectOutput.writeInt(isApprove);
		objectOutput.writeLong(addedDate);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(fileEntryId);

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

	public long leaveApplyId;
	public long companyId;
	public long employeeId;
	public long leaveTypeId;
	public long fromDate;
	public String fromDateSession;
	public long toDate;
	public String toDateSession;
	public double leaveDays;
	public String reason;
	public String attachedFile;
	public String cancelReason;
	public String hrComments;
	public int isApprove;
	public long addedDate;
	public long userId;
	public long fileEntryId;
	public long groupId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long createDate;
	public long modifiedDate;
}