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

package com.liferay.famocom.erpcloud.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link BookingRoom}.
 * </p>
 *
 * @author Samaresh
 * @see BookingRoom
 * @generated
 */
@ProviderType
public class BookingRoomWrapper implements BookingRoom,
	ModelWrapper<BookingRoom> {
	public BookingRoomWrapper(BookingRoom bookingRoom) {
		_bookingRoom = bookingRoom;
	}

	@Override
	public Class<?> getModelClass() {
		return BookingRoom.class;
	}

	@Override
	public String getModelClassName() {
		return BookingRoom.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookingId", getBookingId());
		attributes.put("roomId", getRoomId());
		attributes.put("bookingDate", getBookingDate());
		attributes.put("fromTime", getFromTime());
		attributes.put("toTime", getToTime());
		attributes.put("bookedBy", getBookedBy());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		Long roomId = (Long)attributes.get("roomId");

		if (roomId != null) {
			setRoomId(roomId);
		}

		Date bookingDate = (Date)attributes.get("bookingDate");

		if (bookingDate != null) {
			setBookingDate(bookingDate);
		}

		String fromTime = (String)attributes.get("fromTime");

		if (fromTime != null) {
			setFromTime(fromTime);
		}

		String toTime = (String)attributes.get("toTime");

		if (toTime != null) {
			setToTime(toTime);
		}

		Long bookedBy = (Long)attributes.get("bookedBy");

		if (bookedBy != null) {
			setBookedBy(bookedBy);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@Override
	public Object clone() {
		return new BookingRoomWrapper((BookingRoom)_bookingRoom.clone());
	}

	@Override
	public int compareTo(BookingRoom bookingRoom) {
		return _bookingRoom.compareTo(bookingRoom);
	}

	/**
	* Returns the booked by of this booking room.
	*
	* @return the booked by of this booking room
	*/
	@Override
	public long getBookedBy() {
		return _bookingRoom.getBookedBy();
	}

	/**
	* Returns the booking date of this booking room.
	*
	* @return the booking date of this booking room
	*/
	@Override
	public Date getBookingDate() {
		return _bookingRoom.getBookingDate();
	}

	/**
	* Returns the booking ID of this booking room.
	*
	* @return the booking ID of this booking room
	*/
	@Override
	public long getBookingId() {
		return _bookingRoom.getBookingId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bookingRoom.getExpandoBridge();
	}

	/**
	* Returns the from time of this booking room.
	*
	* @return the from time of this booking room
	*/
	@Override
	public String getFromTime() {
		return _bookingRoom.getFromTime();
	}

	/**
	* Returns the note of this booking room.
	*
	* @return the note of this booking room
	*/
	@Override
	public String getNote() {
		return _bookingRoom.getNote();
	}

	/**
	* Returns the primary key of this booking room.
	*
	* @return the primary key of this booking room
	*/
	@Override
	public long getPrimaryKey() {
		return _bookingRoom.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bookingRoom.getPrimaryKeyObj();
	}

	/**
	* Returns the room ID of this booking room.
	*
	* @return the room ID of this booking room
	*/
	@Override
	public long getRoomId() {
		return _bookingRoom.getRoomId();
	}

	/**
	* Returns the to time of this booking room.
	*
	* @return the to time of this booking room
	*/
	@Override
	public String getToTime() {
		return _bookingRoom.getToTime();
	}

	@Override
	public int hashCode() {
		return _bookingRoom.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _bookingRoom.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bookingRoom.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bookingRoom.isNew();
	}

	@Override
	public void persist() {
		_bookingRoom.persist();
	}

	/**
	* Sets the booked by of this booking room.
	*
	* @param bookedBy the booked by of this booking room
	*/
	@Override
	public void setBookedBy(long bookedBy) {
		_bookingRoom.setBookedBy(bookedBy);
	}

	/**
	* Sets the booking date of this booking room.
	*
	* @param bookingDate the booking date of this booking room
	*/
	@Override
	public void setBookingDate(Date bookingDate) {
		_bookingRoom.setBookingDate(bookingDate);
	}

	/**
	* Sets the booking ID of this booking room.
	*
	* @param bookingId the booking ID of this booking room
	*/
	@Override
	public void setBookingId(long bookingId) {
		_bookingRoom.setBookingId(bookingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bookingRoom.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_bookingRoom.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bookingRoom.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bookingRoom.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the from time of this booking room.
	*
	* @param fromTime the from time of this booking room
	*/
	@Override
	public void setFromTime(String fromTime) {
		_bookingRoom.setFromTime(fromTime);
	}

	@Override
	public void setNew(boolean n) {
		_bookingRoom.setNew(n);
	}

	/**
	* Sets the note of this booking room.
	*
	* @param note the note of this booking room
	*/
	@Override
	public void setNote(String note) {
		_bookingRoom.setNote(note);
	}

	/**
	* Sets the primary key of this booking room.
	*
	* @param primaryKey the primary key of this booking room
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bookingRoom.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bookingRoom.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the room ID of this booking room.
	*
	* @param roomId the room ID of this booking room
	*/
	@Override
	public void setRoomId(long roomId) {
		_bookingRoom.setRoomId(roomId);
	}

	/**
	* Sets the to time of this booking room.
	*
	* @param toTime the to time of this booking room
	*/
	@Override
	public void setToTime(String toTime) {
		_bookingRoom.setToTime(toTime);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<BookingRoom> toCacheModel() {
		return _bookingRoom.toCacheModel();
	}

	@Override
	public BookingRoom toEscapedModel() {
		return new BookingRoomWrapper(_bookingRoom.toEscapedModel());
	}

	@Override
	public String toString() {
		return _bookingRoom.toString();
	}

	@Override
	public BookingRoom toUnescapedModel() {
		return new BookingRoomWrapper(_bookingRoom.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _bookingRoom.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookingRoomWrapper)) {
			return false;
		}

		BookingRoomWrapper bookingRoomWrapper = (BookingRoomWrapper)obj;

		if (Objects.equals(_bookingRoom, bookingRoomWrapper._bookingRoom)) {
			return true;
		}

		return false;
	}

	@Override
	public BookingRoom getWrappedModel() {
		return _bookingRoom;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bookingRoom.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bookingRoom.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bookingRoom.resetOriginalValues();
	}

	private final BookingRoom _bookingRoom;
}