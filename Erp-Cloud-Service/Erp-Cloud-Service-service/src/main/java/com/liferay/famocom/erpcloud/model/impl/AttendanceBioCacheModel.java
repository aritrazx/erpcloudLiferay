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

import com.liferay.famocom.erpcloud.model.AttendanceBio;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AttendanceBio in entity cache.
 *
 * @author Samaresh
 * @see AttendanceBio
 * @generated
 */
@ProviderType
public class AttendanceBioCacheModel implements CacheModel<AttendanceBio>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttendanceBioCacheModel)) {
			return false;
		}

		AttendanceBioCacheModel attendanceBioCacheModel = (AttendanceBioCacheModel)obj;

		if (attendanceBioId == attendanceBioCacheModel.attendanceBioId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, attendanceBioId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{attendanceBioId=");
		sb.append(attendanceBioId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", attDate=");
		sb.append(attDate);
		sb.append(", attTime=");
		sb.append(attTime);
		sb.append(", uploadDate=");
		sb.append(uploadDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AttendanceBio toEntityModel() {
		AttendanceBioImpl attendanceBioImpl = new AttendanceBioImpl();

		attendanceBioImpl.setAttendanceBioId(attendanceBioId);
		attendanceBioImpl.setCompanyId(companyId);
		attendanceBioImpl.setEmployeeId(employeeId);

		if (attDate == Long.MIN_VALUE) {
			attendanceBioImpl.setAttDate(null);
		}
		else {
			attendanceBioImpl.setAttDate(new Date(attDate));
		}

		if (attTime == null) {
			attendanceBioImpl.setAttTime("");
		}
		else {
			attendanceBioImpl.setAttTime(attTime);
		}

		if (uploadDate == Long.MIN_VALUE) {
			attendanceBioImpl.setUploadDate(null);
		}
		else {
			attendanceBioImpl.setUploadDate(new Date(uploadDate));
		}

		attendanceBioImpl.setStatus(status);

		attendanceBioImpl.resetOriginalValues();

		return attendanceBioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attendanceBioId = objectInput.readLong();

		companyId = objectInput.readLong();

		employeeId = objectInput.readLong();
		attDate = objectInput.readLong();
		attTime = objectInput.readUTF();
		uploadDate = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(attendanceBioId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(attDate);

		if (attTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attTime);
		}

		objectOutput.writeLong(uploadDate);

		objectOutput.writeInt(status);
	}

	public long attendanceBioId;
	public long companyId;
	public long employeeId;
	public long attDate;
	public String attTime;
	public long uploadDate;
	public int status;
}