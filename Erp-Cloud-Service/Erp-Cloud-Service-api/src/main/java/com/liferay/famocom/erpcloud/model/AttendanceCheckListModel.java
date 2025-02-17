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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AttendanceCheckList service. Represents a row in the &quot;AttendanceCheckList&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.AttendanceCheckListModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.AttendanceCheckListImpl}.
 * </p>
 *
 * @author Samaresh
 * @see AttendanceCheckList
 * @see com.liferay.famocom.erpcloud.model.impl.AttendanceCheckListImpl
 * @see com.liferay.famocom.erpcloud.model.impl.AttendanceCheckListModelImpl
 * @generated
 */
@ProviderType
public interface AttendanceCheckListModel extends BaseModel<AttendanceCheckList> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a attendance check list model instance should use the {@link AttendanceCheckList} interface instead.
	 */

	/**
	 * Returns the primary key of this attendance check list.
	 *
	 * @return the primary key of this attendance check list
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this attendance check list.
	 *
	 * @param primaryKey the primary key of this attendance check list
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the attendance check list ID of this attendance check list.
	 *
	 * @return the attendance check list ID of this attendance check list
	 */
	public long getAttendanceCheckListId();

	/**
	 * Sets the attendance check list ID of this attendance check list.
	 *
	 * @param attendanceCheckListId the attendance check list ID of this attendance check list
	 */
	public void setAttendanceCheckListId(long attendanceCheckListId);

	/**
	 * Returns the att date of this attendance check list.
	 *
	 * @return the att date of this attendance check list
	 */
	public Date getAttDate();

	/**
	 * Sets the att date of this attendance check list.
	 *
	 * @param attDate the att date of this attendance check list
	 */
	public void setAttDate(Date attDate);

	/**
	 * Returns the employee code of this attendance check list.
	 *
	 * @return the employee code of this attendance check list
	 */
	public long getEmployeeCode();

	/**
	 * Sets the employee code of this attendance check list.
	 *
	 * @param employeeCode the employee code of this attendance check list
	 */
	public void setEmployeeCode(long employeeCode);

	/**
	 * Returns the full name of this attendance check list.
	 *
	 * @return the full name of this attendance check list
	 */
	@AutoEscape
	public String getFullName();

	/**
	 * Sets the full name of this attendance check list.
	 *
	 * @param fullName the full name of this attendance check list
	 */
	public void setFullName(String fullName);

	/**
	 * Returns the in time hour of this attendance check list.
	 *
	 * @return the in time hour of this attendance check list
	 */
	@AutoEscape
	public String getInTimeHour();

	/**
	 * Sets the in time hour of this attendance check list.
	 *
	 * @param inTimeHour the in time hour of this attendance check list
	 */
	public void setInTimeHour(String inTimeHour);

	/**
	 * Returns the in time min of this attendance check list.
	 *
	 * @return the in time min of this attendance check list
	 */
	@AutoEscape
	public String getInTimeMin();

	/**
	 * Sets the in time min of this attendance check list.
	 *
	 * @param inTimeMin the in time min of this attendance check list
	 */
	public void setInTimeMin(String inTimeMin);

	/**
	 * Returns the out time hour of this attendance check list.
	 *
	 * @return the out time hour of this attendance check list
	 */
	@AutoEscape
	public String getOutTimeHour();

	/**
	 * Sets the out time hour of this attendance check list.
	 *
	 * @param outTimeHour the out time hour of this attendance check list
	 */
	public void setOutTimeHour(String outTimeHour);

	/**
	 * Returns the out time min of this attendance check list.
	 *
	 * @return the out time min of this attendance check list
	 */
	@AutoEscape
	public String getOutTimeMin();

	/**
	 * Sets the out time min of this attendance check list.
	 *
	 * @param outTimeMin the out time min of this attendance check list
	 */
	public void setOutTimeMin(String outTimeMin);

	/**
	 * Returns the status of this attendance check list.
	 *
	 * @return the status of this attendance check list
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this attendance check list.
	 *
	 * @param status the status of this attendance check list
	 */
	public void setStatus(String status);

	/**
	 * Returns the msg of this attendance check list.
	 *
	 * @return the msg of this attendance check list
	 */
	@AutoEscape
	public String getMsg();

	/**
	 * Sets the msg of this attendance check list.
	 *
	 * @param msg the msg of this attendance check list
	 */
	public void setMsg(String msg);

	/**
	 * Returns the index number of this attendance check list.
	 *
	 * @return the index number of this attendance check list
	 */
	public int getIndexNumber();

	/**
	 * Sets the index number of this attendance check list.
	 *
	 * @param indexNumber the index number of this attendance check list
	 */
	public void setIndexNumber(int indexNumber);

	/**
	 * Returns the pc date and time of this attendance check list.
	 *
	 * @return the pc date and time of this attendance check list
	 */
	public Date getPcDateAndTime();

	/**
	 * Sets the pc date and time of this attendance check list.
	 *
	 * @param pcDateAndTime the pc date and time of this attendance check list
	 */
	public void setPcDateAndTime(Date pcDateAndTime);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(AttendanceCheckList attendanceCheckList);

	@Override
	public int hashCode();

	@Override
	public CacheModel<AttendanceCheckList> toCacheModel();

	@Override
	public AttendanceCheckList toEscapedModel();

	@Override
	public AttendanceCheckList toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}