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

import com.liferay.famocom.erpcloud.model.LeaveType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveType in entity cache.
 *
 * @author Samaresh
 * @see LeaveType
 * @generated
 */
@ProviderType
public class LeaveTypeCacheModel implements CacheModel<LeaveType>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveTypeCacheModel)) {
			return false;
		}

		LeaveTypeCacheModel leaveTypeCacheModel = (LeaveTypeCacheModel)obj;

		if (leaveTypeId == leaveTypeCacheModel.leaveTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{leaveTypeId=");
		sb.append(leaveTypeId);
		sb.append(", leaveName=");
		sb.append(leaveName);
		sb.append(", abb=");
		sb.append(abb);
		sb.append(", encashmentDay=");
		sb.append(encashmentDay);
		sb.append(", forwardDay=");
		sb.append(forwardDay);
		sb.append(", leaveStatus=");
		sb.append(leaveStatus);
		sb.append(", encashmentPer=");
		sb.append(encashmentPer);
		sb.append(", minServiceDay=");
		sb.append(minServiceDay);
		sb.append(", noticeDay=");
		sb.append(noticeDay);
		sb.append(", employeetypeId=");
		sb.append(employeetypeId);
		sb.append(", maxCreditDay=");
		sb.append(maxCreditDay);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", impectOnSalary=");
		sb.append(impectOnSalary);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveType toEntityModel() {
		LeaveTypeImpl leaveTypeImpl = new LeaveTypeImpl();

		leaveTypeImpl.setLeaveTypeId(leaveTypeId);

		if (leaveName == null) {
			leaveTypeImpl.setLeaveName("");
		}
		else {
			leaveTypeImpl.setLeaveName(leaveName);
		}

		if (abb == null) {
			leaveTypeImpl.setAbb("");
		}
		else {
			leaveTypeImpl.setAbb(abb);
		}

		leaveTypeImpl.setEncashmentDay(encashmentDay);
		leaveTypeImpl.setForwardDay(forwardDay);
		leaveTypeImpl.setLeaveStatus(leaveStatus);
		leaveTypeImpl.setEncashmentPer(encashmentPer);
		leaveTypeImpl.setMinServiceDay(minServiceDay);
		leaveTypeImpl.setNoticeDay(noticeDay);
		leaveTypeImpl.setEmployeetypeId(employeetypeId);
		leaveTypeImpl.setMaxCreditDay(maxCreditDay);

		if (gender == null) {
			leaveTypeImpl.setGender("");
		}
		else {
			leaveTypeImpl.setGender(gender);
		}

		if (maritalStatus == null) {
			leaveTypeImpl.setMaritalStatus("");
		}
		else {
			leaveTypeImpl.setMaritalStatus(maritalStatus);
		}

		leaveTypeImpl.setImpectOnSalary(impectOnSalary);
		leaveTypeImpl.setCompanyId(companyId);

		if (addedDate == Long.MIN_VALUE) {
			leaveTypeImpl.setAddedDate(null);
		}
		else {
			leaveTypeImpl.setAddedDate(new Date(addedDate));
		}

		leaveTypeImpl.resetOriginalValues();

		return leaveTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveTypeId = objectInput.readLong();
		leaveName = objectInput.readUTF();
		abb = objectInput.readUTF();

		encashmentDay = objectInput.readInt();

		forwardDay = objectInput.readInt();

		leaveStatus = objectInput.readBoolean();

		encashmentPer = objectInput.readInt();

		minServiceDay = objectInput.readInt();

		noticeDay = objectInput.readInt();

		employeetypeId = objectInput.readLong();

		maxCreditDay = objectInput.readInt();
		gender = objectInput.readUTF();
		maritalStatus = objectInput.readUTF();

		impectOnSalary = objectInput.readInt();

		companyId = objectInput.readLong();
		addedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveTypeId);

		if (leaveName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(leaveName);
		}

		if (abb == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(abb);
		}

		objectOutput.writeInt(encashmentDay);

		objectOutput.writeInt(forwardDay);

		objectOutput.writeBoolean(leaveStatus);

		objectOutput.writeInt(encashmentPer);

		objectOutput.writeInt(minServiceDay);

		objectOutput.writeInt(noticeDay);

		objectOutput.writeLong(employeetypeId);

		objectOutput.writeInt(maxCreditDay);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (maritalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maritalStatus);
		}

		objectOutput.writeInt(impectOnSalary);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(addedDate);
	}

	public long leaveTypeId;
	public String leaveName;
	public String abb;
	public int encashmentDay;
	public int forwardDay;
	public boolean leaveStatus;
	public int encashmentPer;
	public int minServiceDay;
	public int noticeDay;
	public long employeetypeId;
	public int maxCreditDay;
	public String gender;
	public String maritalStatus;
	public int impectOnSalary;
	public long companyId;
	public long addedDate;
}