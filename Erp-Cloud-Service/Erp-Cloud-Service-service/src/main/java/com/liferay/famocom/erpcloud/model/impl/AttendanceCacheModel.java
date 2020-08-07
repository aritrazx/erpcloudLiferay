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

import com.liferay.famocom.erpcloud.model.Attendance;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Attendance in entity cache.
 *
 * @author Samaresh
 * @see Attendance
 * @generated
 */
@ProviderType
public class AttendanceCacheModel implements CacheModel<Attendance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttendanceCacheModel)) {
			return false;
		}

		AttendanceCacheModel attendanceCacheModel = (AttendanceCacheModel)obj;

		if (attendanceId == attendanceCacheModel.attendanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, attendanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{attendanceId=");
		sb.append(attendanceId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", employeeCode=");
		sb.append(employeeCode);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", attDate=");
		sb.append(attDate);
		sb.append(", inTimeHour=");
		sb.append(inTimeHour);
		sb.append(", inTimeMin=");
		sb.append(inTimeMin);
		sb.append(", outTimeHour=");
		sb.append(outTimeHour);
		sb.append(", outTimeMin=");
		sb.append(outTimeMin);
		sb.append(", inTime=");
		sb.append(inTime);
		sb.append(", outTime=");
		sb.append(outTime);
		sb.append(", inDatePc=");
		sb.append(inDatePc);
		sb.append(", outDatePc=");
		sb.append(outDatePc);
		sb.append(", total=");
		sb.append(total);
		sb.append(", status=");
		sb.append(status);
		sb.append(", ipPc=");
		sb.append(ipPc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Attendance toEntityModel() {
		AttendanceImpl attendanceImpl = new AttendanceImpl();

		attendanceImpl.setAttendanceId(attendanceId);
		attendanceImpl.setCompanyId(companyId);
		attendanceImpl.setEmployeeCode(employeeCode);
		attendanceImpl.setEmployeeId(employeeId);

		if (attDate == Long.MIN_VALUE) {
			attendanceImpl.setAttDate(null);
		}
		else {
			attendanceImpl.setAttDate(new Date(attDate));
		}

		if (inTimeHour == null) {
			attendanceImpl.setInTimeHour("");
		}
		else {
			attendanceImpl.setInTimeHour(inTimeHour);
		}

		if (inTimeMin == null) {
			attendanceImpl.setInTimeMin("");
		}
		else {
			attendanceImpl.setInTimeMin(inTimeMin);
		}

		if (outTimeHour == null) {
			attendanceImpl.setOutTimeHour("");
		}
		else {
			attendanceImpl.setOutTimeHour(outTimeHour);
		}

		if (outTimeMin == null) {
			attendanceImpl.setOutTimeMin("");
		}
		else {
			attendanceImpl.setOutTimeMin(outTimeMin);
		}

		if (inTime == null) {
			attendanceImpl.setInTime("");
		}
		else {
			attendanceImpl.setInTime(inTime);
		}

		if (outTime == null) {
			attendanceImpl.setOutTime("");
		}
		else {
			attendanceImpl.setOutTime(outTime);
		}

		if (inDatePc == Long.MIN_VALUE) {
			attendanceImpl.setInDatePc(null);
		}
		else {
			attendanceImpl.setInDatePc(new Date(inDatePc));
		}

		if (outDatePc == Long.MIN_VALUE) {
			attendanceImpl.setOutDatePc(null);
		}
		else {
			attendanceImpl.setOutDatePc(new Date(outDatePc));
		}

		if (total == null) {
			attendanceImpl.setTotal("");
		}
		else {
			attendanceImpl.setTotal(total);
		}

		if (status == null) {
			attendanceImpl.setStatus("");
		}
		else {
			attendanceImpl.setStatus(status);
		}

		if (ipPc == null) {
			attendanceImpl.setIpPc("");
		}
		else {
			attendanceImpl.setIpPc(ipPc);
		}

		attendanceImpl.resetOriginalValues();

		return attendanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attendanceId = objectInput.readLong();

		companyId = objectInput.readLong();

		employeeCode = objectInput.readLong();

		employeeId = objectInput.readLong();
		attDate = objectInput.readLong();
		inTimeHour = objectInput.readUTF();
		inTimeMin = objectInput.readUTF();
		outTimeHour = objectInput.readUTF();
		outTimeMin = objectInput.readUTF();
		inTime = objectInput.readUTF();
		outTime = objectInput.readUTF();
		inDatePc = objectInput.readLong();
		outDatePc = objectInput.readLong();
		total = objectInput.readUTF();
		status = objectInput.readUTF();
		ipPc = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(attendanceId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(employeeCode);

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(attDate);

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

		if (inTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(inTime);
		}

		if (outTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(outTime);
		}

		objectOutput.writeLong(inDatePc);
		objectOutput.writeLong(outDatePc);

		if (total == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(total);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (ipPc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ipPc);
		}
	}

	public long attendanceId;
	public long companyId;
	public long employeeCode;
	public long employeeId;
	public long attDate;
	public String inTimeHour;
	public String inTimeMin;
	public String outTimeHour;
	public String outTimeMin;
	public String inTime;
	public String outTime;
	public long inDatePc;
	public long outDatePc;
	public String total;
	public String status;
	public String ipPc;
}