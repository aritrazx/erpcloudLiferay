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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ConferenceRoomServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ConferenceRoomServiceSoap
 * @generated
 */
@ProviderType
public class ConferenceRoomSoap implements Serializable {
	public static ConferenceRoomSoap toSoapModel(ConferenceRoom model) {
		ConferenceRoomSoap soapModel = new ConferenceRoomSoap();

		soapModel.setRoomId(model.getRoomId());
		soapModel.setRoomNo(model.getRoomNo());
		soapModel.setFloorNo(model.getFloorNo());
		soapModel.setCapacity(model.getCapacity());
		soapModel.setOpenTime(model.getOpenTime());
		soapModel.setCloseTime(model.getCloseTime());
		soapModel.setBuilding(model.getBuilding());

		return soapModel;
	}

	public static ConferenceRoomSoap[] toSoapModels(ConferenceRoom[] models) {
		ConferenceRoomSoap[] soapModels = new ConferenceRoomSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConferenceRoomSoap[][] toSoapModels(ConferenceRoom[][] models) {
		ConferenceRoomSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConferenceRoomSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConferenceRoomSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConferenceRoomSoap[] toSoapModels(List<ConferenceRoom> models) {
		List<ConferenceRoomSoap> soapModels = new ArrayList<ConferenceRoomSoap>(models.size());

		for (ConferenceRoom model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConferenceRoomSoap[soapModels.size()]);
	}

	public ConferenceRoomSoap() {
	}

	public long getPrimaryKey() {
		return _roomId;
	}

	public void setPrimaryKey(long pk) {
		setRoomId(pk);
	}

	public long getRoomId() {
		return _roomId;
	}

	public void setRoomId(long roomId) {
		_roomId = roomId;
	}

	public long getRoomNo() {
		return _roomNo;
	}

	public void setRoomNo(long roomNo) {
		_roomNo = roomNo;
	}

	public long getFloorNo() {
		return _floorNo;
	}

	public void setFloorNo(long floorNo) {
		_floorNo = floorNo;
	}

	public long getCapacity() {
		return _capacity;
	}

	public void setCapacity(long capacity) {
		_capacity = capacity;
	}

	public String getOpenTime() {
		return _openTime;
	}

	public void setOpenTime(String openTime) {
		_openTime = openTime;
	}

	public String getCloseTime() {
		return _closeTime;
	}

	public void setCloseTime(String closeTime) {
		_closeTime = closeTime;
	}

	public String getBuilding() {
		return _building;
	}

	public void setBuilding(String building) {
		_building = building;
	}

	private long _roomId;
	private long _roomNo;
	private long _floorNo;
	private long _capacity;
	private String _openTime;
	private String _closeTime;
	private String _building;
}