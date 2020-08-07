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

import com.liferay.famocom.erpcloud.model.LeaveManagement;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveManagement in entity cache.
 *
 * @author Samaresh
 * @see LeaveManagement
 * @generated
 */
@ProviderType
public class LeaveManagementCacheModel implements CacheModel<LeaveManagement>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveManagementCacheModel)) {
			return false;
		}

		LeaveManagementCacheModel leaveManagementCacheModel = (LeaveManagementCacheModel)obj;

		if (leaveId == leaveManagementCacheModel.leaveId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{leaveId=");
		sb.append(leaveId);
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
	public LeaveManagement toEntityModel() {
		LeaveManagementImpl leaveManagementImpl = new LeaveManagementImpl();

		leaveManagementImpl.setLeaveId(leaveId);

		if (leaveName == null) {
			leaveManagementImpl.setLeaveName("");
		}
		else {
			leaveManagementImpl.setLeaveName(leaveName);
		}

		if (abb == null) {
			leaveManagementImpl.setAbb("");
		}
		else {
			leaveManagementImpl.setAbb(abb);
		}

		leaveManagementImpl.setEncashmentDay(encashmentDay);
		leaveManagementImpl.setForwardDay(forwardDay);
		leaveManagementImpl.setLeaveStatus(leaveStatus);
		leaveManagementImpl.setEncashmentPer(encashmentPer);
		leaveManagementImpl.setMinServiceDay(minServiceDay);
		leaveManagementImpl.setNoticeDay(noticeDay);
		leaveManagementImpl.setEmployeetypeId(employeetypeId);
		leaveManagementImpl.setMaxCreditDay(maxCreditDay);

		if (gender == null) {
			leaveManagementImpl.setGender("");
		}
		else {
			leaveManagementImpl.setGender(gender);
		}

		if (maritalStatus == null) {
			leaveManagementImpl.setMaritalStatus("");
		}
		else {
			leaveManagementImpl.setMaritalStatus(maritalStatus);
		}

		leaveManagementImpl.setImpectOnSalary(impectOnSalary);
		leaveManagementImpl.setCompanyId(companyId);

		if (addedDate == Long.MIN_VALUE) {
			leaveManagementImpl.setAddedDate(null);
		}
		else {
			leaveManagementImpl.setAddedDate(new Date(addedDate));
		}

		leaveManagementImpl.resetOriginalValues();

		return leaveManagementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveId = objectInput.readLong();
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
		objectOutput.writeLong(leaveId);

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

	public long leaveId;
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