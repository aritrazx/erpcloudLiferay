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

import com.liferay.famocom.erpcloud.model.AttendanceCheckList;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AttendanceCheckList in entity cache.
 *
 * @author Samaresh
 * @see AttendanceCheckList
 * @generated
 */
@ProviderType
public class AttendanceCheckListCacheModel implements CacheModel<AttendanceCheckList>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttendanceCheckListCacheModel)) {
			return false;
		}

		AttendanceCheckListCacheModel attendanceCheckListCacheModel = (AttendanceCheckListCacheModel)obj;

		if (attendanceCheckListId == attendanceCheckListCacheModel.attendanceCheckListId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, attendanceCheckListId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{attendanceCheckListId=");
		sb.append(attendanceCheckListId);
		sb.append(", attDate=");
		sb.append(attDate);
		sb.append(", employeeCode=");
		sb.append(employeeCode);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", inTimeHour=");
		sb.append(inTimeHour);
		sb.append(", inTimeMin=");
		sb.append(inTimeMin);
		sb.append(", outTimeHour=");
		sb.append(outTimeHour);
		sb.append(", outTimeMin=");
		sb.append(outTimeMin);
		sb.append(", status=");
		sb.append(status);
		sb.append(", msg=");
		sb.append(msg);
		sb.append(", indexNumber=");
		sb.append(indexNumber);
		sb.append(", pcDateAndTime=");
		sb.append(pcDateAndTime);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AttendanceCheckList toEntityModel() {
		AttendanceCheckListImpl attendanceCheckListImpl = new AttendanceCheckListImpl();

		attendanceCheckListImpl.setAttendanceCheckListId(attendanceCheckListId);

		if (attDate == Long.MIN_VALUE) {
			attendanceCheckListImpl.setAttDate(null);
		}
		else {
			attendanceCheckListImpl.setAttDate(new Date(attDate));
		}

		attendanceCheckListImpl.setEmployeeCode(employeeCode);

		if (fullName == null) {
			attendanceCheckListImpl.setFullName("");
		}
		else {
			attendanceCheckListImpl.setFullName(fullName);
		}

		if (inTimeHour == null) {
			attendanceCheckListImpl.setInTimeHour("");
		}
		else {
			attendanceCheckListImpl.setInTimeHour(inTimeHour);
		}

		if (inTimeMin == null) {
			attendanceCheckListImpl.setInTimeMin("");
		}
		else {
			attendanceCheckListImpl.setInTimeMin(inTimeMin);
		}

		if (outTimeHour == null) {
			attendanceCheckListImpl.setOutTimeHour("");
		}
		else {
			attendanceCheckListImpl.setOutTimeHour(outTimeHour);
		}

		if (outTimeMin == null) {
			attendanceCheckListImpl.setOutTimeMin("");
		}
		else {
			attendanceCheckListImpl.setOutTimeMin(outTimeMin);
		}

		if (status == null) {
			attendanceCheckListImpl.setStatus("");
		}
		else {
			attendanceCheckListImpl.setStatus(status);
		}

		if (msg == null) {
			attendanceCheckListImpl.setMsg("");
		}
		else {
			attendanceCheckListImpl.setMsg(msg);
		}

		attendanceCheckListImpl.setIndexNumber(indexNumber);

		if (pcDateAndTime == Long.MIN_VALUE) {
			attendanceCheckListImpl.setPcDateAndTime(null);
		}
		else {
			attendanceCheckListImpl.setPcDateAndTime(new Date(pcDateAndTime));
		}

		attendanceCheckListImpl.resetOriginalValues();

		return attendanceCheckListImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attendanceCheckListId = objectInput.readLong();
		attDate = objectInput.readLong();

		employeeCode = objectInput.readLong();
		fullName = objectInput.readUTF();
		inTimeHour = objectInput.readUTF();
		inTimeMin = objectInput.readUTF();
		outTimeHour = objectInput.readUTF();
		outTimeMin = objectInput.readUTF();
		status = objectInput.readUTF();
		msg = objectInput.readUTF();

		indexNumber = objectInput.readInt();
		pcDateAndTime = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(attendanceCheckListId);
		objectOutput.writeLong(attDate);

		objectOutput.writeLong(employeeCode);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (inTimeHour == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(inTimeHour);
		}

		if (inTimeMin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(inTimeMin);
		}

		if (outTimeHour == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(outTimeHour);
		}

		if (outTimeMin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(outTimeMin);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (msg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(msg);
		}

		objectOutput.writeInt(indexNumber);
		objectOutput.writeLong(pcDateAndTime);
	}

	public long attendanceCheckListId;
	public long attDate;
	public long employeeCode;
	public String fullName;
	public String inTimeHour;
	public String inTimeMin;
	public String outTimeHour;
	public String outTimeMin;
	public String status;
	public String msg;
	public int indexNumber;
	public long pcDateAndTime;
}