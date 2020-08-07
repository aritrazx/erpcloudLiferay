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
 * This class is a wrapper for {@link AttendanceCheckList}.
 * </p>
 *
 * @author Samaresh
 * @see AttendanceCheckList
 * @generated
 */
@ProviderType
public class AttendanceCheckListWrapper implements AttendanceCheckList,
	ModelWrapper<AttendanceCheckList> {
	public AttendanceCheckListWrapper(AttendanceCheckList attendanceCheckList) {
		_attendanceCheckList = attendanceCheckList;
	}

	@Override
	public Class<?> getModelClass() {
		return AttendanceCheckList.class;
	}

	@Override
	public String getModelClassName() {
		return AttendanceCheckList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attendanceCheckListId", getAttendanceCheckListId());
		attributes.put("attDate", getAttDate());
		attributes.put("employeeCode", getEmployeeCode());
		attributes.put("fullName", getFullName());
		attributes.put("inTimeHour", getInTimeHour());
		attributes.put("inTimeMin", getInTimeMin());
		attributes.put("outTimeHour", getOutTimeHour());
		attributes.put("outTimeMin", getOutTimeMin());
		attributes.put("status", getStatus());
		attributes.put("msg", getMsg());
		attributes.put("indexNumber", getIndexNumber());
		attributes.put("pcDateAndTime", getPcDateAndTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attendanceCheckListId = (Long)attributes.get(
				"attendanceCheckListId");

		if (attendanceCheckListId != null) {
			setAttendanceCheckListId(attendanceCheckListId);
		}

		Date attDate = (Date)attributes.get("attDate");

		if (attDate != null) {
			setAttDate(attDate);
		}

		Long employeeCode = (Long)attributes.get("employeeCode");

		if (employeeCode != null) {
			setEmployeeCode(employeeCode);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
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

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String msg = (String)attributes.get("msg");

		if (msg != null) {
			setMsg(msg);
		}

		Integer indexNumber = (Integer)attributes.get("indexNumber");

		if (indexNumber != null) {
			setIndexNumber(indexNumber);
		}

		Date pcDateAndTime = (Date)attributes.get("pcDateAndTime");

		if (pcDateAndTime != null) {
			setPcDateAndTime(pcDateAndTime);
		}
	}

	@Override
	public Object clone() {
		return new AttendanceCheckListWrapper((AttendanceCheckList)_attendanceCheckList.clone());
	}

	@Override
	public int compareTo(AttendanceCheckList attendanceCheckList) {
		return _attendanceCheckList.compareTo(attendanceCheckList);
	}

	/**
	* Returns the att date of this attendance check list.
	*
	* @return the att date of this attendance check list
	*/
	@Override
	public Date getAttDate() {
		return _attendanceCheckList.getAttDate();
	}

	/**
	* Returns the attendance check list ID of this attendance check list.
	*
	* @return the attendance check list ID of this attendance check list
	*/
	@Override
	public long getAttendanceCheckListId() {
		return _attendanceCheckList.getAttendanceCheckListId();
	}

	/**
	* Returns the employee code of this attendance check list.
	*
	* @return the employee code of this attendance check list
	*/
	@Override
	public long getEmployeeCode() {
		return _attendanceCheckList.getEmployeeCode();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _attendanceCheckList.getExpandoBridge();
	}

	/**
	* Returns the full name of this attendance check list.
	*
	* @return the full name of this attendance check list
	*/
	@Override
	public String getFullName() {
		return _attendanceCheckList.getFullName();
	}

	/**
	* Returns the index number of this attendance check list.
	*
	* @return the index number of this attendance check list
	*/
	@Override
	public int getIndexNumber() {
		return _attendanceCheckList.getIndexNumber();
	}

	/**
	* Returns the in time hour of this attendance check list.
	*
	* @return the in time hour of this attendance check list
	*/
	@Override
	public String getInTimeHour() {
		return _attendanceCheckList.getInTimeHour();
	}

	/**
	* Returns the in time min of this attendance check list.
	*
	* @return the in time min of this attendance check list
	*/
	@Override
	public String getInTimeMin() {
		return _attendanceCheckList.getInTimeMin();
	}

	/**
	* Returns the msg of this attendance check list.
	*
	* @return the msg of this attendance check list
	*/
	@Override
	public String getMsg() {
		return _attendanceCheckList.getMsg();
	}

	/**
	* Returns the out time hour of this attendance check list.
	*
	* @return the out time hour of this attendance check list
	*/
	@Override
	public String getOutTimeHour() {
		return _attendanceCheckList.getOutTimeHour();
	}

	/**
	* Returns the out time min of this attendance check list.
	*
	* @return the out time min of this attendance check list
	*/
	@Override
	public String getOutTimeMin() {
		return _attendanceCheckList.getOutTimeMin();
	}

	/**
	* Returns the pc date and time of this attendance check list.
	*
	* @return the pc date and time of this attendance check list
	*/
	@Override
	public Date getPcDateAndTime() {
		return _attendanceCheckList.getPcDateAndTime();
	}

	/**
	* Returns the primary key of this attendance check list.
	*
	* @return the primary key of this attendance check list
	*/
	@Override
	public long getPrimaryKey() {
		return _attendanceCheckList.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _attendanceCheckList.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this attendance check list.
	*
	* @return the status of this attendance check list
	*/
	@Override
	public String getStatus() {
		return _attendanceCheckList.getStatus();
	}

	@Override
	public int hashCode() {
		return _attendanceCheckList.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _attendanceCheckList.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _attendanceCheckList.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _attendanceCheckList.isNew();
	}

	@Override
	public void persist() {
		_attendanceCheckList.persist();
	}

	/**
	* Sets the att date of this attendance check list.
	*
	* @param attDate the att date of this attendance check list
	*/
	@Override
	public void setAttDate(Date attDate) {
		_attendanceCheckList.setAttDate(attDate);
	}

	/**
	* Sets the attendance check list ID of this attendance check list.
	*
	* @param attendanceCheckListId the attendance check list ID of this attendance check list
	*/
	@Override
	public void setAttendanceCheckListId(long attendanceCheckListId) {
		_attendanceCheckList.setAttendanceCheckListId(attendanceCheckListId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_attendanceCheckList.setCachedModel(cachedModel);
	}

	/**
	* Sets the employee code of this attendance check list.
	*
	* @param employeeCode the employee code of this attendance check list
	*/
	@Override
	public void setEmployeeCode(long employeeCode) {
		_attendanceCheckList.setEmployeeCode(employeeCode);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_attendanceCheckList.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_attendanceCheckList.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_attendanceCheckList.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the full name of this attendance check list.
	*
	* @param fullName the full name of this attendance check list
	*/
	@Override
	public void setFullName(String fullName) {
		_attendanceCheckList.setFullName(fullName);
	}

	/**
	* Sets the index number of this attendance check list.
	*
	* @param indexNumber the index number of this attendance check list
	*/
	@Override
	public void setIndexNumber(int indexNumber) {
		_attendanceCheckList.setIndexNumber(indexNumber);
	}

	/**
	* Sets the in time hour of this attendance check list.
	*
	* @param inTimeHour the in time hour of this attendance check list
	*/
	@Override
	public void setInTimeHour(String inTimeHour) {
		_attendanceCheckList.setInTimeHour(inTimeHour);
	}

	/**
	* Sets the in time min of this attendance check list.
	*
	* @param inTimeMin the in time min of this attendance check list
	*/
	@Override
	public void setInTimeMin(String inTimeMin) {
		_attendanceCheckList.setInTimeMin(inTimeMin);
	}

	/**
	* Sets the msg of this attendance check list.
	*
	* @param msg the msg of this attendance check list
	*/
	@Override
	public void setMsg(String msg) {
		_attendanceCheckList.setMsg(msg);
	}

	@Override
	public void setNew(boolean n) {
		_attendanceCheckList.setNew(n);
	}

	/**
	* Sets the out time hour of this attendance check list.
	*
	* @param outTimeHour the out time hour of this attendance check list
	*/
	@Override
	public void setOutTimeHour(String outTimeHour) {
		_attendanceCheckList.setOutTimeHour(outTimeHour);
	}

	/**
	* Sets the out time min of this attendance check list.
	*
	* @param outTimeMin the out time min of this attendance check list
	*/
	@Override
	public void setOutTimeMin(String outTimeMin) {
		_attendanceCheckList.setOutTimeMin(outTimeMin);
	}

	/**
	* Sets the pc date and time of this attendance check list.
	*
	* @param pcDateAndTime the pc date and time of this attendance check list
	*/
	@Override
	public void setPcDateAndTime(Date pcDateAndTime) {
		_attendanceCheckList.setPcDateAndTime(pcDateAndTime);
	}

	/**
	* Sets the primary key of this attendance check list.
	*
	* @param primaryKey the primary key of this attendance check list
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_attendanceCheckList.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_attendanceCheckList.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this attendance check list.
	*
	* @param status the status of this attendance check list
	*/
	@Override
	public void setStatus(String status) {
		_attendanceCheckList.setStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AttendanceCheckList> toCacheModel() {
		return _attendanceCheckList.toCacheModel();
	}

	@Override
	public AttendanceCheckList toEscapedModel() {
		return new AttendanceCheckListWrapper(_attendanceCheckList.toEscapedModel());
	}

	@Override
	public String toString() {
		return _attendanceCheckList.toString();
	}

	@Override
	public AttendanceCheckList toUnescapedModel() {
		return new AttendanceCheckListWrapper(_attendanceCheckList.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _attendanceCheckList.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttendanceCheckListWrapper)) {
			return false;
		}

		AttendanceCheckListWrapper attendanceCheckListWrapper = (AttendanceCheckListWrapper)obj;

		if (Objects.equals(_attendanceCheckList,
					attendanceCheckListWrapper._attendanceCheckList)) {
			return true;
		}

		return false;
	}

	@Override
	public AttendanceCheckList getWrappedModel() {
		return _attendanceCheckList;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _attendanceCheckList.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _attendanceCheckList.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_attendanceCheckList.resetOriginalValues();
	}

	private final AttendanceCheckList _attendanceCheckList;
}