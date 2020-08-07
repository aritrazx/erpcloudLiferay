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

import com.liferay.famocom.erpcloud.model.GeoAttendance;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GeoAttendance in entity cache.
 *
 * @author Samaresh
 * @see GeoAttendance
 * @generated
 */
@ProviderType
public class GeoAttendanceCacheModel implements CacheModel<GeoAttendance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeoAttendanceCacheModel)) {
			return false;
		}

		GeoAttendanceCacheModel geoAttendanceCacheModel = (GeoAttendanceCacheModel)obj;

		if (attendanceId == geoAttendanceCacheModel.attendanceId) {
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
		StringBundler sb = new StringBundler(23);

		sb.append("{attendanceId=");
		sb.append(attendanceId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", attDate=");
		sb.append(attDate);
		sb.append(", inTime=");
		sb.append(inTime);
		sb.append(", outTime=");
		sb.append(outTime);
		sb.append(", workHour=");
		sb.append(workHour);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", outLatitude=");
		sb.append(outLatitude);
		sb.append(", outLongitude=");
		sb.append(outLongitude);
		sb.append(", geoAddress=");
		sb.append(geoAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GeoAttendance toEntityModel() {
		GeoAttendanceImpl geoAttendanceImpl = new GeoAttendanceImpl();

		geoAttendanceImpl.setAttendanceId(attendanceId);
		geoAttendanceImpl.setEmployeeId(employeeId);

		if (attDate == Long.MIN_VALUE) {
			geoAttendanceImpl.setAttDate(null);
		}
		else {
			geoAttendanceImpl.setAttDate(new Date(attDate));
		}

		if (inTime == null) {
			geoAttendanceImpl.setInTime("");
		}
		else {
			geoAttendanceImpl.setInTime(inTime);
		}

		if (outTime == null) {
			geoAttendanceImpl.setOutTime("");
		}
		else {
			geoAttendanceImpl.setOutTime(outTime);
		}

		if (workHour == null) {
			geoAttendanceImpl.setWorkHour("");
		}
		else {
			geoAttendanceImpl.setWorkHour(workHour);
		}

		if (latitude == null) {
			geoAttendanceImpl.setLatitude("");
		}
		else {
			geoAttendanceImpl.setLatitude(latitude);
		}

		if (longitude == null) {
			geoAttendanceImpl.setLongitude("");
		}
		else {
			geoAttendanceImpl.setLongitude(longitude);
		}

		if (outLatitude == null) {
			geoAttendanceImpl.setOutLatitude("");
		}
		else {
			geoAttendanceImpl.setOutLatitude(outLatitude);
		}

		if (outLongitude == null) {
			geoAttendanceImpl.setOutLongitude("");
		}
		else {
			geoAttendanceImpl.setOutLongitude(outLongitude);
		}

		if (geoAddress == null) {
			geoAttendanceImpl.setGeoAddress("");
		}
		else {
			geoAttendanceImpl.setGeoAddress(geoAddress);
		}

		geoAttendanceImpl.resetOriginalValues();

		return geoAttendanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attendanceId = objectInput.readLong();

		employeeId = objectInput.readLong();
		attDate = objectInput.readLong();
		inTime = objectInput.readUTF();
		outTime = objectInput.readUTF();
		workHour = objectInput.readUTF();
		latitude = objectInput.readUTF();
		longitude = objectInput.readUTF();
		outLatitude = objectInput.readUTF();
		outLongitude = objectInput.readUTF();
		geoAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(attendanceId);

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(attDate);

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

		if (workHour == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workHour);
		}

		if (latitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(latitude);
		}

		if (longitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(longitude);
		}

		if (outLatitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(outLatitude);
		}

		if (outLongitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(outLongitude);
		}

		if (geoAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(geoAddress);
		}
	}

	public long attendanceId;
	public long employeeId;
	public long attDate;
	public String inTime;
	public String outTime;
	public String workHour;
	public String latitude;
	public String longitude;
	public String outLatitude;
	public String outLongitude;
	public String geoAddress;
}