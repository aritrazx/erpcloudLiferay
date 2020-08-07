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
 * This class is a wrapper for {@link TimeSheetEntry}.
 * </p>
 *
 * @author Samaresh
 * @see TimeSheetEntry
 * @generated
 */
@ProviderType
public class TimeSheetEntryWrapper implements TimeSheetEntry,
	ModelWrapper<TimeSheetEntry> {
	public TimeSheetEntryWrapper(TimeSheetEntry timeSheetEntry) {
		_timeSheetEntry = timeSheetEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return TimeSheetEntry.class;
	}

	@Override
	public String getModelClassName() {
		return TimeSheetEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("timesheetId", getTimesheetId());
		attributes.put("entryDate", getEntryDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("projectId", getProjectId());
		attributes.put("projectTaskId", getProjectTaskId());
		attributes.put("hours", getHours());
		attributes.put("workDescription", getWorkDescription());
		attributes.put("timesheetParentId", getTimesheetParentId());
		attributes.put("addedDate", getAddedDate());
		attributes.put("groupId", getGroupId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long timesheetId = (Long)attributes.get("timesheetId");

		if (timesheetId != null) {
			setTimesheetId(timesheetId);
		}

		Date entryDate = (Date)attributes.get("entryDate");

		if (entryDate != null) {
			setEntryDate(entryDate);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long projectTaskId = (Long)attributes.get("projectTaskId");

		if (projectTaskId != null) {
			setProjectTaskId(projectTaskId);
		}

		Double hours = (Double)attributes.get("hours");

		if (hours != null) {
			setHours(hours);
		}

		String workDescription = (String)attributes.get("workDescription");

		if (workDescription != null) {
			setWorkDescription(workDescription);
		}

		Long timesheetParentId = (Long)attributes.get("timesheetParentId");

		if (timesheetParentId != null) {
			setTimesheetParentId(timesheetParentId);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new TimeSheetEntryWrapper((TimeSheetEntry)_timeSheetEntry.clone());
	}

	@Override
	public int compareTo(TimeSheetEntry timeSheetEntry) {
		return _timeSheetEntry.compareTo(timeSheetEntry);
	}

	/**
	* Returns the added date of this time sheet entry.
	*
	* @return the added date of this time sheet entry
	*/
	@Override
	public Date getAddedDate() {
		return _timeSheetEntry.getAddedDate();
	}

	/**
	* Returns the create date of this time sheet entry.
	*
	* @return the create date of this time sheet entry
	*/
	@Override
	public Date getCreateDate() {
		return _timeSheetEntry.getCreateDate();
	}

	/**
	* Returns the employee ID of this time sheet entry.
	*
	* @return the employee ID of this time sheet entry
	*/
	@Override
	public long getEmployeeId() {
		return _timeSheetEntry.getEmployeeId();
	}

	/**
	* Returns the entry date of this time sheet entry.
	*
	* @return the entry date of this time sheet entry
	*/
	@Override
	public Date getEntryDate() {
		return _timeSheetEntry.getEntryDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _timeSheetEntry.getExpandoBridge();
	}

	/**
	* Returns the group ID of this time sheet entry.
	*
	* @return the group ID of this time sheet entry
	*/
	@Override
	public long getGroupId() {
		return _timeSheetEntry.getGroupId();
	}

	/**
	* Returns the hours of this time sheet entry.
	*
	* @return the hours of this time sheet entry
	*/
	@Override
	public double getHours() {
		return _timeSheetEntry.getHours();
	}

	/**
	* Returns the modified date of this time sheet entry.
	*
	* @return the modified date of this time sheet entry
	*/
	@Override
	public Date getModifiedDate() {
		return _timeSheetEntry.getModifiedDate();
	}

	/**
	* Returns the primary key of this time sheet entry.
	*
	* @return the primary key of this time sheet entry
	*/
	@Override
	public long getPrimaryKey() {
		return _timeSheetEntry.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timeSheetEntry.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this time sheet entry.
	*
	* @return the project ID of this time sheet entry
	*/
	@Override
	public long getProjectId() {
		return _timeSheetEntry.getProjectId();
	}

	/**
	* Returns the project task ID of this time sheet entry.
	*
	* @return the project task ID of this time sheet entry
	*/
	@Override
	public long getProjectTaskId() {
		return _timeSheetEntry.getProjectTaskId();
	}

	/**
	* Returns the status of this time sheet entry.
	*
	* @return the status of this time sheet entry
	*/
	@Override
	public int getStatus() {
		return _timeSheetEntry.getStatus();
	}

	/**
	* Returns the status by user ID of this time sheet entry.
	*
	* @return the status by user ID of this time sheet entry
	*/
	@Override
	public long getStatusByUserId() {
		return _timeSheetEntry.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this time sheet entry.
	*
	* @return the status by user name of this time sheet entry
	*/
	@Override
	public String getStatusByUserName() {
		return _timeSheetEntry.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this time sheet entry.
	*
	* @return the status by user uuid of this time sheet entry
	*/
	@Override
	public String getStatusByUserUuid() {
		return _timeSheetEntry.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this time sheet entry.
	*
	* @return the status date of this time sheet entry
	*/
	@Override
	public Date getStatusDate() {
		return _timeSheetEntry.getStatusDate();
	}

	/**
	* Returns the timesheet ID of this time sheet entry.
	*
	* @return the timesheet ID of this time sheet entry
	*/
	@Override
	public long getTimesheetId() {
		return _timeSheetEntry.getTimesheetId();
	}

	/**
	* Returns the timesheet parent ID of this time sheet entry.
	*
	* @return the timesheet parent ID of this time sheet entry
	*/
	@Override
	public long getTimesheetParentId() {
		return _timeSheetEntry.getTimesheetParentId();
	}

	/**
	* Returns the work description of this time sheet entry.
	*
	* @return the work description of this time sheet entry
	*/
	@Override
	public String getWorkDescription() {
		return _timeSheetEntry.getWorkDescription();
	}

	@Override
	public int hashCode() {
		return _timeSheetEntry.hashCode();
	}

	/**
	* Returns <code>true</code> if this time sheet entry is approved.
	*
	* @return <code>true</code> if this time sheet entry is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _timeSheetEntry.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _timeSheetEntry.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this time sheet entry is denied.
	*
	* @return <code>true</code> if this time sheet entry is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _timeSheetEntry.isDenied();
	}

	/**
	* Returns <code>true</code> if this time sheet entry is a draft.
	*
	* @return <code>true</code> if this time sheet entry is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _timeSheetEntry.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _timeSheetEntry.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this time sheet entry is expired.
	*
	* @return <code>true</code> if this time sheet entry is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _timeSheetEntry.isExpired();
	}

	/**
	* Returns <code>true</code> if this time sheet entry is inactive.
	*
	* @return <code>true</code> if this time sheet entry is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _timeSheetEntry.isInactive();
	}

	/**
	* Returns <code>true</code> if this time sheet entry is incomplete.
	*
	* @return <code>true</code> if this time sheet entry is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _timeSheetEntry.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _timeSheetEntry.isNew();
	}

	/**
	* Returns <code>true</code> if this time sheet entry is pending.
	*
	* @return <code>true</code> if this time sheet entry is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _timeSheetEntry.isPending();
	}

	/**
	* Returns <code>true</code> if this time sheet entry is scheduled.
	*
	* @return <code>true</code> if this time sheet entry is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _timeSheetEntry.isScheduled();
	}

	@Override
	public void persist() {
		_timeSheetEntry.persist();
	}

	/**
	* Sets the added date of this time sheet entry.
	*
	* @param addedDate the added date of this time sheet entry
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_timeSheetEntry.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_timeSheetEntry.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this time sheet entry.
	*
	* @param createDate the create date of this time sheet entry
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_timeSheetEntry.setCreateDate(createDate);
	}

	/**
	* Sets the employee ID of this time sheet entry.
	*
	* @param employeeId the employee ID of this time sheet entry
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_timeSheetEntry.setEmployeeId(employeeId);
	}

	/**
	* Sets the entry date of this time sheet entry.
	*
	* @param entryDate the entry date of this time sheet entry
	*/
	@Override
	public void setEntryDate(Date entryDate) {
		_timeSheetEntry.setEntryDate(entryDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_timeSheetEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_timeSheetEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_timeSheetEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this time sheet entry.
	*
	* @param groupId the group ID of this time sheet entry
	*/
	@Override
	public void setGroupId(long groupId) {
		_timeSheetEntry.setGroupId(groupId);
	}

	/**
	* Sets the hours of this time sheet entry.
	*
	* @param hours the hours of this time sheet entry
	*/
	@Override
	public void setHours(double hours) {
		_timeSheetEntry.setHours(hours);
	}

	/**
	* Sets the modified date of this time sheet entry.
	*
	* @param modifiedDate the modified date of this time sheet entry
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_timeSheetEntry.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_timeSheetEntry.setNew(n);
	}

	/**
	* Sets the primary key of this time sheet entry.
	*
	* @param primaryKey the primary key of this time sheet entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_timeSheetEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_timeSheetEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this time sheet entry.
	*
	* @param projectId the project ID of this time sheet entry
	*/
	@Override
	public void setProjectId(long projectId) {
		_timeSheetEntry.setProjectId(projectId);
	}

	/**
	* Sets the project task ID of this time sheet entry.
	*
	* @param projectTaskId the project task ID of this time sheet entry
	*/
	@Override
	public void setProjectTaskId(long projectTaskId) {
		_timeSheetEntry.setProjectTaskId(projectTaskId);
	}

	/**
	* Sets the status of this time sheet entry.
	*
	* @param status the status of this time sheet entry
	*/
	@Override
	public void setStatus(int status) {
		_timeSheetEntry.setStatus(status);
	}

	/**
	* Sets the status by user ID of this time sheet entry.
	*
	* @param statusByUserId the status by user ID of this time sheet entry
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_timeSheetEntry.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this time sheet entry.
	*
	* @param statusByUserName the status by user name of this time sheet entry
	*/
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_timeSheetEntry.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this time sheet entry.
	*
	* @param statusByUserUuid the status by user uuid of this time sheet entry
	*/
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_timeSheetEntry.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this time sheet entry.
	*
	* @param statusDate the status date of this time sheet entry
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_timeSheetEntry.setStatusDate(statusDate);
	}

	/**
	* Sets the timesheet ID of this time sheet entry.
	*
	* @param timesheetId the timesheet ID of this time sheet entry
	*/
	@Override
	public void setTimesheetId(long timesheetId) {
		_timeSheetEntry.setTimesheetId(timesheetId);
	}

	/**
	* Sets the timesheet parent ID of this time sheet entry.
	*
	* @param timesheetParentId the timesheet parent ID of this time sheet entry
	*/
	@Override
	public void setTimesheetParentId(long timesheetParentId) {
		_timeSheetEntry.setTimesheetParentId(timesheetParentId);
	}

	/**
	* Sets the work description of this time sheet entry.
	*
	* @param workDescription the work description of this time sheet entry
	*/
	@Override
	public void setWorkDescription(String workDescription) {
		_timeSheetEntry.setWorkDescription(workDescription);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TimeSheetEntry> toCacheModel() {
		return _timeSheetEntry.toCacheModel();
	}

	@Override
	public TimeSheetEntry toEscapedModel() {
		return new TimeSheetEntryWrapper(_timeSheetEntry.toEscapedModel());
	}

	@Override
	public String toString() {
		return _timeSheetEntry.toString();
	}

	@Override
	public TimeSheetEntry toUnescapedModel() {
		return new TimeSheetEntryWrapper(_timeSheetEntry.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _timeSheetEntry.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimeSheetEntryWrapper)) {
			return false;
		}

		TimeSheetEntryWrapper timeSheetEntryWrapper = (TimeSheetEntryWrapper)obj;

		if (Objects.equals(_timeSheetEntry,
					timeSheetEntryWrapper._timeSheetEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public TimeSheetEntry getWrappedModel() {
		return _timeSheetEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _timeSheetEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _timeSheetEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_timeSheetEntry.resetOriginalValues();
	}

	private final TimeSheetEntry _timeSheetEntry;
}