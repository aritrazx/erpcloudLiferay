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
 * This class is a wrapper for {@link GeoAttendance}.
 * </p>
 *
 * @author Samaresh
 * @see GeoAttendance
 * @generated
 */
@ProviderType
public class GeoAttendanceWrapper implements GeoAttendance,
	ModelWrapper<GeoAttendance> {
	public GeoAttendanceWrapper(GeoAttendance geoAttendance) {
		_geoAttendance = geoAttendance;
	}

	@Override
	public Class<?> getModelClass() {
		return GeoAttendance.class;
	}

	@Override
	public String getModelClassName() {
		return GeoAttendance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attendanceId", getAttendanceId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("attDate", getAttDate());
		attributes.put("inTime", getInTime());
		attributes.put("outTime", getOutTime());
		attributes.put("workHour", getWorkHour());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("outLatitude", getOutLatitude());
		attributes.put("outLongitude", getOutLongitude());
		attributes.put("geoAddress", getGeoAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attendanceId = (Long)attributes.get("attendanceId");

		if (attendanceId != null) {
			setAttendanceId(attendanceId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date attDate = (Date)attributes.get("attDate");

		if (attDate != null) {
			setAttDate(attDate);
		}

		String inTime = (String)attributes.get("inTime");

		if (inTime != null) {
			setInTime(inTime);
		}

		String outTime = (String)attributes.get("outTime");

		if (outTime != null) {
			setOutTime(outTime);
		}

		String workHour = (String)attributes.get("workHour");

		if (workHour != null) {
			setWorkHour(workHour);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String outLatitude = (String)attributes.get("outLatitude");

		if (outLatitude != null) {
			setOutLatitude(outLatitude);
		}

		String outLongitude = (String)attributes.get("outLongitude");

		if (outLongitude != null) {
			setOutLongitude(outLongitude);
		}

		String geoAddress = (String)attributes.get("geoAddress");

		if (geoAddress != null) {
			setGeoAddress(geoAddress);
		}
	}

	@Override
	public Object clone() {
		return new GeoAttendanceWrapper((GeoAttendance)_geoAttendance.clone());
	}

	@Override
	public int compareTo(GeoAttendance geoAttendance) {
		return _geoAttendance.compareTo(geoAttendance);
	}

	/**
	* Returns the att date of this geo attendance.
	*
	* @return the att date of this geo attendance
	*/
	@Override
	public Date getAttDate() {
		return _geoAttendance.getAttDate();
	}

	/**
	* Returns the attendance ID of this geo attendance.
	*
	* @return the attendance ID of this geo attendance
	*/
	@Override
	public long getAttendanceId() {
		return _geoAttendance.getAttendanceId();
	}

	/**
	* Returns the employee ID of this geo attendance.
	*
	* @return the employee ID of this geo attendance
	*/
	@Override
	public long getEmployeeId() {
		return _geoAttendance.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _geoAttendance.getExpandoBridge();
	}

	/**
	* Returns the geo address of this geo attendance.
	*
	* @return the geo address of this geo attendance
	*/
	@Override
	public String getGeoAddress() {
		return _geoAttendance.getGeoAddress();
	}

	/**
	* Returns the in time of this geo attendance.
	*
	* @return the in time of this geo attendance
	*/
	@Override
	public String getInTime() {
		return _geoAttendance.getInTime();
	}

	/**
	* Returns the latitude of this geo attendance.
	*
	* @return the latitude of this geo attendance
	*/
	@Override
	public String getLatitude() {
		return _geoAttendance.getLatitude();
	}

	/**
	* Returns the longitude of this geo attendance.
	*
	* @return the longitude of this geo attendance
	*/
	@Override
	public String getLongitude() {
		return _geoAttendance.getLongitude();
	}

	/**
	* Returns the out latitude of this geo attendance.
	*
	* @return the out latitude of this geo attendance
	*/
	@Override
	public String getOutLatitude() {
		return _geoAttendance.getOutLatitude();
	}

	/**
	* Returns the out longitude of this geo attendance.
	*
	* @return the out longitude of this geo attendance
	*/
	@Override
	public String getOutLongitude() {
		return _geoAttendance.getOutLongitude();
	}

	/**
	* Returns the out time of this geo attendance.
	*
	* @return the out time of this geo attendance
	*/
	@Override
	public String getOutTime() {
		return _geoAttendance.getOutTime();
	}

	/**
	* Returns the primary key of this geo attendance.
	*
	* @return the primary key of this geo attendance
	*/
	@Override
	public long getPrimaryKey() {
		return _geoAttendance.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _geoAttendance.getPrimaryKeyObj();
	}

	/**
	* Returns the work hour of this geo attendance.
	*
	* @return the work hour of this geo attendance
	*/
	@Override
	public String getWorkHour() {
		return _geoAttendance.getWorkHour();
	}

	@Override
	public int hashCode() {
		return _geoAttendance.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _geoAttendance.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _geoAttendance.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _geoAttendance.isNew();
	}

	@Override
	public void persist() {
		_geoAttendance.persist();
	}

	/**
	* Sets the att date of this geo attendance.
	*
	* @param attDate the att date of this geo attendance
	*/
	@Override
	public void setAttDate(Date attDate) {
		_geoAttendance.setAttDate(attDate);
	}

	/**
	* Sets the attendance ID of this geo attendance.
	*
	* @param attendanceId the attendance ID of this geo attendance
	*/
	@Override
	public void setAttendanceId(long attendanceId) {
		_geoAttendance.setAttendanceId(attendanceId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_geoAttendance.setCachedModel(cachedModel);
	}

	/**
	* Sets the employee ID of this geo attendance.
	*
	* @param employeeId the employee ID of this geo attendance
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_geoAttendance.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_geoAttendance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_geoAttendance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_geoAttendance.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the geo address of this geo attendance.
	*
	* @param geoAddress the geo address of this geo attendance
	*/
	@Override
	public void setGeoAddress(String geoAddress) {
		_geoAttendance.setGeoAddress(geoAddress);
	}

	/**
	* Sets the in time of this geo attendance.
	*
	* @param inTime the in time of this geo attendance
	*/
	@Override
	public void setInTime(String inTime) {
		_geoAttendance.setInTime(inTime);
	}

	/**
	* Sets the latitude of this geo attendance.
	*
	* @param latitude the latitude of this geo attendance
	*/
	@Override
	public void setLatitude(String latitude) {
		_geoAttendance.setLatitude(latitude);
	}

	/**
	* Sets the longitude of this geo attendance.
	*
	* @param longitude the longitude of this geo attendance
	*/
	@Override
	public void setLongitude(String longitude) {
		_geoAttendance.setLongitude(longitude);
	}

	@Override
	public void setNew(boolean n) {
		_geoAttendance.setNew(n);
	}

	/**
	* Sets the out latitude of this geo attendance.
	*
	* @param outLatitude the out latitude of this geo attendance
	*/
	@Override
	public void setOutLatitude(String outLatitude) {
		_geoAttendance.setOutLatitude(outLatitude);
	}

	/**
	* Sets the out longitude of this geo attendance.
	*
	* @param outLongitude the out longitude of this geo attendance
	*/
	@Override
	public void setOutLongitude(String outLongitude) {
		_geoAttendance.setOutLongitude(outLongitude);
	}

	/**
	* Sets the out time of this geo attendance.
	*
	* @param outTime the out time of this geo attendance
	*/
	@Override
	public void setOutTime(String outTime) {
		_geoAttendance.setOutTime(outTime);
	}

	/**
	* Sets the primary key of this geo attendance.
	*
	* @param primaryKey the primary key of this geo attendance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_geoAttendance.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_geoAttendance.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the work hour of this geo attendance.
	*
	* @param workHour the work hour of this geo attendance
	*/
	@Override
	public void setWorkHour(String workHour) {
		_geoAttendance.setWorkHour(workHour);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<GeoAttendance> toCacheModel() {
		return _geoAttendance.toCacheModel();
	}

	@Override
	public GeoAttendance toEscapedModel() {
		return new GeoAttendanceWrapper(_geoAttendance.toEscapedModel());
	}

	@Override
	public String toString() {
		return _geoAttendance.toString();
	}

	@Override
	public GeoAttendance toUnescapedModel() {
		return new GeoAttendanceWrapper(_geoAttendance.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _geoAttendance.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeoAttendanceWrapper)) {
			return false;
		}

		GeoAttendanceWrapper geoAttendanceWrapper = (GeoAttendanceWrapper)obj;

		if (Objects.equals(_geoAttendance, geoAttendanceWrapper._geoAttendance)) {
			return true;
		}

		return false;
	}

	@Override
	public GeoAttendance getWrappedModel() {
		return _geoAttendance;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _geoAttendance.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _geoAttendance.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_geoAttendance.resetOriginalValues();
	}

	private final GeoAttendance _geoAttendance;
}