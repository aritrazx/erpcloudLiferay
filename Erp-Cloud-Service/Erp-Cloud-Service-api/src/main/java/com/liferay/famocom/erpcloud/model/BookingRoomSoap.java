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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.BookingRoomServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.BookingRoomServiceSoap
 * @generated
 */
@ProviderType
public class BookingRoomSoap implements Serializable {
	public static BookingRoomSoap toSoapModel(BookingRoom model) {
		BookingRoomSoap soapModel = new BookingRoomSoap();

		soapModel.setBookingId(model.getBookingId());
		soapModel.setRoomId(model.getRoomId());
		soapModel.setBookingDate(model.getBookingDate());
		soapModel.setFromTime(model.getFromTime());
		soapModel.setToTime(model.getToTime());
		soapModel.setBookedBy(model.getBookedBy());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static BookingRoomSoap[] toSoapModels(BookingRoom[] models) {
		BookingRoomSoap[] soapModels = new BookingRoomSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BookingRoomSoap[][] toSoapModels(BookingRoom[][] models) {
		BookingRoomSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BookingRoomSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BookingRoomSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BookingRoomSoap[] toSoapModels(List<BookingRoom> models) {
		List<BookingRoomSoap> soapModels = new ArrayList<BookingRoomSoap>(models.size());

		for (BookingRoom model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BookingRoomSoap[soapModels.size()]);
	}

	public BookingRoomSoap() {
	}

	public long getPrimaryKey() {
		return _bookingId;
	}

	public void setPrimaryKey(long pk) {
		setBookingId(pk);
	}

	public long getBookingId() {
		return _bookingId;
	}

	public void setBookingId(long bookingId) {
		_bookingId = bookingId;
	}

	public long getRoomId() {
		return _roomId;
	}

	public void setRoomId(long roomId) {
		_roomId = roomId;
	}

	public Date getBookingDate() {
		return _bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		_bookingDate = bookingDate;
	}

	public String getFromTime() {
		return _fromTime;
	}

	public void setFromTime(String fromTime) {
		_fromTime = fromTime;
	}

	public String getToTime() {
		return _toTime;
	}

	public void setToTime(String toTime) {
		_toTime = toTime;
	}

	public long getBookedBy() {
		return _bookedBy;
	}

	public void setBookedBy(long bookedBy) {
		_bookedBy = bookedBy;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private long _bookingId;
	private long _roomId;
	private Date _bookingDate;
	private String _fromTime;
	private String _toTime;
	private long _bookedBy;
	private String _note;
}