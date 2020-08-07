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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ConferenceRoom}.
 * </p>
 *
 * @author Samaresh
 * @see ConferenceRoom
 * @generated
 */
@ProviderType
public class ConferenceRoomWrapper implements ConferenceRoom,
	ModelWrapper<ConferenceRoom> {
	public ConferenceRoomWrapper(ConferenceRoom conferenceRoom) {
		_conferenceRoom = conferenceRoom;
	}

	@Override
	public Class<?> getModelClass() {
		return ConferenceRoom.class;
	}

	@Override
	public String getModelClassName() {
		return ConferenceRoom.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roomId", getRoomId());
		attributes.put("roomNo", getRoomNo());
		attributes.put("floorNo", getFloorNo());
		attributes.put("capacity", getCapacity());
		attributes.put("openTime", getOpenTime());
		attributes.put("closeTime", getCloseTime());
		attributes.put("building", getBuilding());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long roomId = (Long)attributes.get("roomId");

		if (roomId != null) {
			setRoomId(roomId);
		}

		Long roomNo = (Long)attributes.get("roomNo");

		if (roomNo != null) {
			setRoomNo(roomNo);
		}

		Long floorNo = (Long)attributes.get("floorNo");

		if (floorNo != null) {
			setFloorNo(floorNo);
		}

		Long capacity = (Long)attributes.get("capacity");

		if (capacity != null) {
			setCapacity(capacity);
		}

		String openTime = (String)attributes.get("openTime");

		if (openTime != null) {
			setOpenTime(openTime);
		}

		String closeTime = (String)attributes.get("closeTime");

		if (closeTime != null) {
			setCloseTime(closeTime);
		}

		String building = (String)attributes.get("building");

		if (building != null) {
			setBuilding(building);
		}
	}

	@Override
	public Object clone() {
		return new ConferenceRoomWrapper((ConferenceRoom)_conferenceRoom.clone());
	}

	@Override
	public int compareTo(ConferenceRoom conferenceRoom) {
		return _conferenceRoom.compareTo(conferenceRoom);
	}

	/**
	* Returns the building of this conference room.
	*
	* @return the building of this conference room
	*/
	@Override
	public String getBuilding() {
		return _conferenceRoom.getBuilding();
	}

	/**
	* Returns the capacity of this conference room.
	*
	* @return the capacity of this conference room
	*/
	@Override
	public long getCapacity() {
		return _conferenceRoom.getCapacity();
	}

	/**
	* Returns the close time of this conference room.
	*
	* @return the close time of this conference room
	*/
	@Override
	public String getCloseTime() {
		return _conferenceRoom.getCloseTime();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _conferenceRoom.getExpandoBridge();
	}

	/**
	* Returns the floor no of this conference room.
	*
	* @return the floor no of this conference room
	*/
	@Override
	public long getFloorNo() {
		return _conferenceRoom.getFloorNo();
	}

	/**
	* Returns the open time of this conference room.
	*
	* @return the open time of this conference room
	*/
	@Override
	public String getOpenTime() {
		return _conferenceRoom.getOpenTime();
	}

	/**
	* Returns the primary key of this conference room.
	*
	* @return the primary key of this conference room
	*/
	@Override
	public long getPrimaryKey() {
		return _conferenceRoom.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _conferenceRoom.getPrimaryKeyObj();
	}

	/**
	* Returns the room ID of this conference room.
	*
	* @return the room ID of this conference room
	*/
	@Override
	public long getRoomId() {
		return _conferenceRoom.getRoomId();
	}

	/**
	* Returns the room no of this conference room.
	*
	* @return the room no of this conference room
	*/
	@Override
	public long getRoomNo() {
		return _conferenceRoom.getRoomNo();
	}

	@Override
	public int hashCode() {
		return _conferenceRoom.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _conferenceRoom.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _conferenceRoom.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _conferenceRoom.isNew();
	}

	@Override
	public void persist() {
		_conferenceRoom.persist();
	}

	/**
	* Sets the building of this conference room.
	*
	* @param building the building of this conference room
	*/
	@Override
	public void setBuilding(String building) {
		_conferenceRoom.setBuilding(building);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_conferenceRoom.setCachedModel(cachedModel);
	}

	/**
	* Sets the capacity of this conference room.
	*
	* @param capacity the capacity of this conference room
	*/
	@Override
	public void setCapacity(long capacity) {
		_conferenceRoom.setCapacity(capacity);
	}

	/**
	* Sets the close time of this conference room.
	*
	* @param closeTime the close time of this conference room
	*/
	@Override
	public void setCloseTime(String closeTime) {
		_conferenceRoom.setCloseTime(closeTime);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_conferenceRoom.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_conferenceRoom.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_conferenceRoom.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the floor no of this conference room.
	*
	* @param floorNo the floor no of this conference room
	*/
	@Override
	public void setFloorNo(long floorNo) {
		_conferenceRoom.setFloorNo(floorNo);
	}

	@Override
	public void setNew(boolean n) {
		_conferenceRoom.setNew(n);
	}

	/**
	* Sets the open time of this conference room.
	*
	* @param openTime the open time of this conference room
	*/
	@Override
	public void setOpenTime(String openTime) {
		_conferenceRoom.setOpenTime(openTime);
	}

	/**
	* Sets the primary key of this conference room.
	*
	* @param primaryKey the primary key of this conference room
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_conferenceRoom.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_conferenceRoom.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the room ID of this conference room.
	*
	* @param roomId the room ID of this conference room
	*/
	@Override
	public void setRoomId(long roomId) {
		_conferenceRoom.setRoomId(roomId);
	}

	/**
	* Sets the room no of this conference room.
	*
	* @param roomNo the room no of this conference room
	*/
	@Override
	public void setRoomNo(long roomNo) {
		_conferenceRoom.setRoomNo(roomNo);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ConferenceRoom> toCacheModel() {
		return _conferenceRoom.toCacheModel();
	}

	@Override
	public ConferenceRoom toEscapedModel() {
		return new ConferenceRoomWrapper(_conferenceRoom.toEscapedModel());
	}

	@Override
	public String toString() {
		return _conferenceRoom.toString();
	}

	@Override
	public ConferenceRoom toUnescapedModel() {
		return new ConferenceRoomWrapper(_conferenceRoom.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _conferenceRoom.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConferenceRoomWrapper)) {
			return false;
		}

		ConferenceRoomWrapper conferenceRoomWrapper = (ConferenceRoomWrapper)obj;

		if (Objects.equals(_conferenceRoom,
					conferenceRoomWrapper._conferenceRoom)) {
			return true;
		}

		return false;
	}

	@Override
	public ConferenceRoom getWrappedModel() {
		return _conferenceRoom;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _conferenceRoom.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _conferenceRoom.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_conferenceRoom.resetOriginalValues();
	}

	private final ConferenceRoom _conferenceRoom;
}