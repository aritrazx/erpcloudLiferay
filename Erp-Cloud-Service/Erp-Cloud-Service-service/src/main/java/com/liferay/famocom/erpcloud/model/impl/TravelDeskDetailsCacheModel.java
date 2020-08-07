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

import com.liferay.famocom.erpcloud.model.TravelDeskDetails;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TravelDeskDetails in entity cache.
 *
 * @author Samaresh
 * @see TravelDeskDetails
 * @generated
 */
@ProviderType
public class TravelDeskDetailsCacheModel implements CacheModel<TravelDeskDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TravelDeskDetailsCacheModel)) {
			return false;
		}

		TravelDeskDetailsCacheModel travelDeskDetailsCacheModel = (TravelDeskDetailsCacheModel)obj;

		if (travelDetailsId == travelDeskDetailsCacheModel.travelDetailsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travelDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{travelDetailsId=");
		sb.append(travelDetailsId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", projectTeamsId=");
		sb.append(projectTeamsId);
		sb.append(", ticketType=");
		sb.append(ticketType);
		sb.append(", hotel=");
		sb.append(hotel);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", fromTime=");
		sb.append(fromTime);
		sb.append(", toTime=");
		sb.append(toTime);
		sb.append(", location=");
		sb.append(location);
		sb.append(", purpose=");
		sb.append(purpose);
		sb.append(", specialInstraction=");
		sb.append(specialInstraction);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", managerComment=");
		sb.append(managerComment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TravelDeskDetails toEntityModel() {
		TravelDeskDetailsImpl travelDeskDetailsImpl = new TravelDeskDetailsImpl();

		travelDeskDetailsImpl.setTravelDetailsId(travelDetailsId);
		travelDeskDetailsImpl.setEmployeeId(employeeId);
		travelDeskDetailsImpl.setCompanyId(companyId);
		travelDeskDetailsImpl.setUserId(userId);
		travelDeskDetailsImpl.setProjectId(projectId);
		travelDeskDetailsImpl.setProjectTeamsId(projectTeamsId);

		if (ticketType == null) {
			travelDeskDetailsImpl.setTicketType("");
		}
		else {
			travelDeskDetailsImpl.setTicketType(ticketType);
		}

		travelDeskDetailsImpl.setHotel(hotel);

		if (fromDate == Long.MIN_VALUE) {
			travelDeskDetailsImpl.setFromDate(null);
		}
		else {
			travelDeskDetailsImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			travelDeskDetailsImpl.setToDate(null);
		}
		else {
			travelDeskDetailsImpl.setToDate(new Date(toDate));
		}

		if (fromTime == null) {
			travelDeskDetailsImpl.setFromTime("");
		}
		else {
			travelDeskDetailsImpl.setFromTime(fromTime);
		}

		if (toTime == null) {
			travelDeskDetailsImpl.setToTime("");
		}
		else {
			travelDeskDetailsImpl.setToTime(toTime);
		}

		if (location == null) {
			travelDeskDetailsImpl.setLocation("");
		}
		else {
			travelDeskDetailsImpl.setLocation(location);
		}

		if (purpose == null) {
			travelDeskDetailsImpl.setPurpose("");
		}
		else {
			travelDeskDetailsImpl.setPurpose(purpose);
		}

		if (specialInstraction == null) {
			travelDeskDetailsImpl.setSpecialInstraction("");
		}
		else {
			travelDeskDetailsImpl.setSpecialInstraction(specialInstraction);
		}

		if (createDate == Long.MIN_VALUE) {
			travelDeskDetailsImpl.setCreateDate(null);
		}
		else {
			travelDeskDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelDeskDetailsImpl.setModifiedDate(null);
		}
		else {
			travelDeskDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		travelDeskDetailsImpl.setStatus(status);

		if (managerComment == null) {
			travelDeskDetailsImpl.setManagerComment("");
		}
		else {
			travelDeskDetailsImpl.setManagerComment(managerComment);
		}

		travelDeskDetailsImpl.resetOriginalValues();

		return travelDeskDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		travelDetailsId = objectInput.readLong();

		employeeId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();

		projectId = objectInput.readLong();

		projectTeamsId = objectInput.readLong();
		ticketType = objectInput.readUTF();

		hotel = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
		fromTime = objectInput.readUTF();
		toTime = objectInput.readUTF();
		location = objectInput.readUTF();
		purpose = objectInput.readUTF();
		specialInstraction = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();
		managerComment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(travelDetailsId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(projectTeamsId);

		if (ticketType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ticketType);
		}

		objectOutput.writeBoolean(hotel);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		if (fromTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fromTime);
		}

		if (toTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(toTime);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (purpose == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(purpose);
		}

		if (specialInstraction == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specialInstraction);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		if (managerComment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(managerComment);
		}
	}

	public long travelDetailsId;
	public long employeeId;
	public long companyId;
	public long userId;
	public long projectId;
	public long projectTeamsId;
	public String ticketType;
	public boolean hotel;
	public long fromDate;
	public long toDate;
	public String fromTime;
	public String toTime;
	public String location;
	public String purpose;
	public String specialInstraction;
	public long createDate;
	public long modifiedDate;
	public int status;
	public String managerComment;
}