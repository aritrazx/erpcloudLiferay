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

import com.liferay.famocom.erpcloud.model.BookingRoom;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BookingRoom in entity cache.
 *
 * @author Samaresh
 * @see BookingRoom
 * @generated
 */
@ProviderType
public class BookingRoomCacheModel implements CacheModel<BookingRoom>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookingRoomCacheModel)) {
			return false;
		}

		BookingRoomCacheModel bookingRoomCacheModel = (BookingRoomCacheModel)obj;

		if (bookingId == bookingRoomCacheModel.bookingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{bookingId=");
		sb.append(bookingId);
		sb.append(", roomId=");
		sb.append(roomId);
		sb.append(", bookingDate=");
		sb.append(bookingDate);
		sb.append(", fromTime=");
		sb.append(fromTime);
		sb.append(", toTime=");
		sb.append(toTime);
		sb.append(", bookedBy=");
		sb.append(bookedBy);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BookingRoom toEntityModel() {
		BookingRoomImpl bookingRoomImpl = new BookingRoomImpl();

		bookingRoomImpl.setBookingId(bookingId);
		bookingRoomImpl.setRoomId(roomId);

		if (bookingDate == Long.MIN_VALUE) {
			bookingRoomImpl.setBookingDate(null);
		}
		else {
			bookingRoomImpl.setBookingDate(new Date(bookingDate));
		}

		if (fromTime == null) {
			bookingRoomImpl.setFromTime("");
		}
		else {
			bookingRoomImpl.setFromTime(fromTime);
		}

		if (toTime == null) {
			bookingRoomImpl.setToTime("");
		}
		else {
			bookingRoomImpl.setToTime(toTime);
		}

		bookingRoomImpl.setBookedBy(bookedBy);

		if (note == null) {
			bookingRoomImpl.setNote("");
		}
		else {
			bookingRoomImpl.setNote(note);
		}

		bookingRoomImpl.resetOriginalValues();

		return bookingRoomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookingId = objectInput.readLong();

		roomId = objectInput.readLong();
		bookingDate = objectInput.readLong();
		fromTime = objectInput.readUTF();
		toTime = objectInput.readUTF();

		bookedBy = objectInput.readLong();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bookingId);

		objectOutput.writeLong(roomId);
		objectOutput.writeLong(bookingDate);

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

		objectOutput.writeLong(bookedBy);

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public long bookingId;
	public long roomId;
	public long bookingDate;
	public String fromTime;
	public String toTime;
	public long bookedBy;
	public String note;
}