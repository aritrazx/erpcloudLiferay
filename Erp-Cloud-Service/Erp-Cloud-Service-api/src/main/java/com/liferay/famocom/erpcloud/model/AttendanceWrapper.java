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
 * This class is a wrapper for {@link Attendance}.
 * </p>
 *
 * @author Samaresh
 * @see Attendance
 * @generated
 */
@ProviderType
public class AttendanceWrapper implements Attendance, ModelWrapper<Attendance> {
	public AttendanceWrapper(Attendance attendance) {
		_attendance = attendance;
	}

	@Override
	public Class<?> getModelClass() {
		return Attendance.class;
	}

	@Override
	public String getModelClassName() {
		return Attendance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attendanceId", getAttendanceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("employeeCode", getEmployeeCode());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("attDate", getAttDate());
		attributes.put("inTimeHour", getInTimeHour());
		attributes.put("inTimeMin", getInTimeMin());
		attributes.put("outTimeHour", getOutTimeHour());
		attributes.put("outTimeMin", getOutTimeMin());
		attributes.put("inTime", getInTime());
		attributes.put("outTime", getOutTime());
		attributes.put("inDatePc", getInDatePc());
		attributes.put("outDatePc", getOutDatePc());
		attributes.put("total", getTotal());
		attributes.put("status", getStatus());
		attributes.put("ipPc", getIpPc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attendanceId = (Long)attributes.get("attendanceId");

		if (attendanceId != null) {
			setAttendanceId(attendanceId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long employeeCode = (Long)attributes.get("employeeCode");

		if (employeeCode != null) {
			setEmployeeCode(employeeCode);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date attDate = (Date)attributes.get("attDate");

		if (attDate != null) {
			setAttDate(attDate);
		}

		String inTimeHour = (String)attributes.get("inTimeHour");

		if (inTimeHour != null) {
			setInTimeHour(inTimeHour);
		}

		String inTimeMin = (String)attributes.get("inTimeMin");

		if (inTimeMin != null) {
			setInTimeMin(inTimeMin);
		}

		String outTimeHour = (String)attributes.get("outTimeHour");

		if (outTimeHour != null) {
			setOutTimeHour(outTimeHour);
		}

		String outTimeMin = (String)attributes.get("outTimeMin");

		if (outTimeMin != null) {
			setOutTimeMin(outTimeMin);
		}

		String inTime = (String)attributes.get("inTime");

		if (inTime != null) {
			setInTime(inTime);
		}

		String outTime = (String)attributes.get("outTime");

		if (outTime != null) {
			setOutTime(outTime);
		}

		Date inDatePc = (Date)attributes.get("inDatePc");

		if (inDatePc != null) {
			setInDatePc(inDatePc);
		}

		Date outDatePc = (Date)attributes.get("outDatePc");

		if (outDatePc != null) {
			setOutDatePc(outDatePc);
		}

		String total = (String)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String ipPc = (String)attributes.get("ipPc");

		if (ipPc != null) {
			setIpPc(ipPc);
		}
	}

	@Override
	public Object clone() {
		return new AttendanceWrapper((Attendance)_attendance.clone());
	}

	@Override
	public int compareTo(Attendance attendance) {
		return _attendance.compareTo(attendance);
	}

	/**
	* Returns the att date of this attendance.
	*
	* @return the att date of this attendance
	*/
	@Override
	public Date getAttDate() {
		return _attendance.getAttDate();
	}

	/**
	* Returns the attendance ID of this attendance.
	*
	* @return the attendance ID of this attendance
	*/
	@Override
	public long getAttendanceId() {
		return _attendance.getAttendanceId();
	}

	/**
	* Returns the company ID of this attendance.
	*
	* @return the company ID of this attendance
	*/
	@Override
	public long getCompanyId() {
		return _attendance.getCompanyId();
	}

	/**
	* Returns the employee code of this attendance.
	*
	* @return the employee code of this attendance
	*/
	@Override
	public long getEmployeeCode() {
		return _attendance.getEmployeeCode();
	}

	/**
	* Returns the employee ID of this attendance.
	*
	* @return the employee ID of this attendance
	*/
	@Override
	public long getEmployeeId() {
		return _attendance.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _attendance.getExpandoBridge();
	}

	/**
	* Returns the in date pc of this attendance.
	*
	* @return the in date pc of this attendance
	*/
	@Override
	public Date getInDatePc() {
		return _attendance.getInDatePc();
	}

	/**
	* Returns the in time of this attendance.
	*
	* @return the in time of this attendance
	*/
	@Override
	public String getInTime() {
		return _attendance.getInTime();
	}

	/**
	* Returns the in time hour of this attendance.
	*
	* @return the in time hour of this attendance
	*/
	@Override
	public String getInTimeHour() {
		return _attendance.getInTimeHour();
	}

	/**
	* Returns the in time min of this attendance.
	*
	* @return the in time min of this attendance
	*/
	@Override
	public String getInTimeMin() {
		return _attendance.getInTimeMin();
	}

	/**
	* Returns the ip pc of this attendance.
	*
	* @return the ip pc of this attendance
	*/
	@Override
	public String getIpPc() {
		return _attendance.getIpPc();
	}

	/**
	* Returns the out date pc of this attendance.
	*
	* @return the out date pc of this attendance
	*/
	@Override
	public Date getOutDatePc() {
		return _attendance.getOutDatePc();
	}

	/**
	* Returns the out time of this attendance.
	*
	* @return the out time of this attendance
	*/
	@Override
	public String getOutTime() {
		return _attendance.getOutTime();
	}

	/**
	* Returns the out time hour of this attendance.
	*
	* @return the out time hour of this attendance
	*/
	@Override
	public String getOutTimeHour() {
		return _attendance.getOutTimeHour();
	}

	/**
	* Returns the out time min of this attendance.
	*
	* @return the out time min of this attendance
	*/
	@Override
	public String getOutTimeMin() {
		return _attendance.getOutTimeMin();
	}

	/**
	* Returns the primary key of this attendance.
	*
	* @return the primary key of this attendance
	*/
	@Override
	public long getPrimaryKey() {
		return _attendance.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _attendance.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this attendance.
	*
	* @return the status of this attendance
	*/
	@Override
	public String getStatus() {
		return _attendance.getStatus();
	}

	/**
	* Returns the total of this attendance.
	*
	* @return the total of this attendance
	*/
	@Override
	public String getTotal() {
		return _attendance.getTotal();
	}

	@Override
	public int hashCode() {
		return _attendance.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _attendance.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _attendance.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _attendance.isNew();
	}

	@Override
	public void persist() {
		_attendance.persist();
	}

	/**
	* Sets the att date of this attendance.
	*
	* @param attDate the att date of this attendance
	*/
	@Override
	public void setAttDate(Date attDate) {
		_attendance.setAttDate(attDate);
	}

	/**
	* Sets the attendance ID of this attendance.
	*
	* @param attendanceId the attendance ID of this attendance
	*/
	@Override
	public void setAttendanceId(long attendanceId) {
		_attendance.setAttendanceId(attendanceId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_attendance.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this attendance.
	*
	* @param companyId the company ID of this attendance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_attendance.setCompanyId(companyId);
	}

	/**
	* Sets the employee code of this attendance.
	*
	* @param employeeCode the employee code of this attendance
	*/
	@Override
	public void setEmployeeCode(long employeeCode) {
		_attendance.setEmployeeCode(employeeCode);
	}

	/**
	* Sets the employee ID of this attendance.
	*
	* @param employeeId the employee ID of this attendance
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_attendance.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_attendance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_attendance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_attendance.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the in date pc of this attendance.
	*
	* @param inDatePc the in date pc of this attendance
	*/
	@Override
	public void setInDatePc(Date inDatePc) {
		_attendance.setInDatePc(inDatePc);
	}

	/**
	* Sets the in time of this attendance.
	*
	* @param inTime the in time of this attendance
	*/
	@Override
	public void setInTime(String inTime) {
		_attendance.setInTime(inTime);
	}

	/**
	* Sets the in time hour of this attendance.
	*
	* @param inTimeHour the in time hour of this attendance
	*/
	@Override
	public void setInTimeHour(String inTimeHour) {
		_attendance.setInTimeHour(inTimeHour);
	}

	/**
	* Sets the in time min of this attendance.
	*
	* @param inTimeMin the in time min of this attendance
	*/
	@Override
	public void setInTimeMin(String inTimeMin) {
		_attendance.setInTimeMin(inTimeMin);
	}

	/**
	* Sets the ip pc of this attendance.
	*
	* @param ipPc the ip pc of this attendance
	*/
	@Override
	public void setIpPc(String ipPc) {
		_attendance.setIpPc(ipPc);
	}

	@Override
	public void setNew(boolean n) {
		_attendance.setNew(n);
	}

	/**
	* Sets the out date pc of this attendance.
	*
	* @param outDatePc the out date pc of this attendance
	*/
	@Override
	public void setOutDatePc(Date outDatePc) {
		_attendance.setOutDatePc(outDatePc);
	}

	/**
	* Sets the out time of this attendance.
	*
	* @param outTime the out time of this attendance
	*/
	@Override
	public void setOutTime(String outTime) {
		_attendance.setOutTime(outTime);
	}

	/**
	* Sets the out time hour of this attendance.
	*
	* @param outTimeHour the out time hour of this attendance
	*/
	@Override
	public void setOutTimeHour(String outTimeHour) {
		_attendance.setOutTimeHour(outTimeHour);
	}

	/**
	* Sets the out time min of this attendance.
	*
	* @param outTimeMin the out time min of this attendance
	*/
	@Override
	public void setOutTimeMin(String outTimeMin) {
		_attendance.setOutTimeMin(outTimeMin);
	}

	/**
	* Sets the primary key of this attendance.
	*
	* @param primaryKey the primary key of this attendance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_attendance.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_attendance.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this attendance.
	*
	* @param status the status of this attendance
	*/
	@Override
	public void setStatus(String status) {
		_attendance.setStatus(status);
	}

	/**
	* Sets the total of this attendance.
	*
	* @param total the total of this attendance
	*/
	@Override
	public void setTotal(String total) {
		_attendance.setTotal(total);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Attendance> toCacheModel() {
		return _attendance.toCacheModel();
	}

	@Override
	public Attendance toEscapedModel() {
		return new AttendanceWrapper(_attendance.toEscapedModel());
	}

	@Override
	public String toString() {
		return _attendance.toString();
	}

	@Override
	public Attendance toUnescapedModel() {
		return new AttendanceWrapper(_attendance.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _attendance.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttendanceWrapper)) {
			return false;
		}

		AttendanceWrapper attendanceWrapper = (AttendanceWrapper)obj;

		if (Objects.equals(_attendance, attendanceWrapper._attendance)) {
			return true;
		}

		return false;
	}

	@Override
	public Attendance getWrappedModel() {
		return _attendance;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _attendance.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _attendance.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_attendance.resetOriginalValues();
	}

	private final Attendance _attendance;
}