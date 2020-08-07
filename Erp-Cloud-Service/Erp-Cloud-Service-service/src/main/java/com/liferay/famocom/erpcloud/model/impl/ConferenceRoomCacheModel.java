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

import com.liferay.famocom.erpcloud.model.ConferenceRoom;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ConferenceRoom in entity cache.
 *
 * @author Samaresh
 * @see ConferenceRoom
 * @generated
 */
@ProviderType
public class ConferenceRoomCacheModel implements CacheModel<ConferenceRoom>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConferenceRoomCacheModel)) {
			return false;
		}

		ConferenceRoomCacheModel conferenceRoomCacheModel = (ConferenceRoomCacheModel)obj;

		if (roomId == conferenceRoomCacheModel.roomId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, roomId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{roomId=");
		sb.append(roomId);
		sb.append(", roomNo=");
		sb.append(roomNo);
		sb.append(", floorNo=");
		sb.append(floorNo);
		sb.append(", capacity=");
		sb.append(capacity);
		sb.append(", openTime=");
		sb.append(openTime);
		sb.append(", closeTime=");
		sb.append(closeTime);
		sb.append(", building=");
		sb.append(building);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConferenceRoom toEntityModel() {
		ConferenceRoomImpl conferenceRoomImpl = new ConferenceRoomImpl();

		conferenceRoomImpl.setRoomId(roomId);
		conferenceRoomImpl.setRoomNo(roomNo);
		conferenceRoomImpl.setFloorNo(floorNo);
		conferenceRoomImpl.setCapacity(capacity);

		if (openTime == null) {
			conferenceRoomImpl.setOpenTime("");
		}
		else {
			conferenceRoomImpl.setOpenTime(openTime);
		}

		if (closeTime == null) {
			conferenceRoomImpl.setCloseTime("");
		}
		else {
			conferenceRoomImpl.setCloseTime(closeTime);
		}

		if (building == null) {
			conferenceRoomImpl.setBuilding("");
		}
		else {
			conferenceRoomImpl.setBuilding(building);
		}

		conferenceRoomImpl.resetOriginalValues();

		return conferenceRoomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		roomId = objectInput.readLong();

		roomNo = objectInput.readLong();

		floorNo = objectInput.readLong();

		capacity = objectInput.readLong();
		openTime = objectInput.readUTF();
		closeTime = objectInput.readUTF();
		building = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(roomId);

		objectOutput.writeLong(roomNo);

		objectOutput.writeLong(floorNo);

		objectOutput.writeLong(capacity);

		if (openTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(openTime);
		}

		if (closeTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(closeTime);
		}

		if (building == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(building);
		}
	}

	public long roomId;
	public long roomNo;
	public long floorNo;
	public long capacity;
	public String openTime;
	public String closeTime;
	public String building;
}