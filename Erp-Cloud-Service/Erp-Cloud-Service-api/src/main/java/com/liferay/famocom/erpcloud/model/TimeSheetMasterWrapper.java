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
 * This class is a wrapper for {@link TimeSheetMaster}.
 * </p>
 *
 * @author Samaresh
 * @see TimeSheetMaster
 * @generated
 */
@ProviderType
public class TimeSheetMasterWrapper implements TimeSheetMaster,
	ModelWrapper<TimeSheetMaster> {
	public TimeSheetMasterWrapper(TimeSheetMaster timeSheetMaster) {
		_timeSheetMaster = timeSheetMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return TimeSheetMaster.class;
	}

	@Override
	public String getModelClassName() {
		return TimeSheetMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("timesheetParentId", getTimesheetParentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("submitStatus", getSubmitStatus());
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
		Long timesheetParentId = (Long)attributes.get("timesheetParentId");

		if (timesheetParentId != null) {
			setTimesheetParentId(timesheetParentId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Integer submitStatus = (Integer)attributes.get("submitStatus");

		if (submitStatus != null) {
			setSubmitStatus(submitStatus);
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
		return new TimeSheetMasterWrapper((TimeSheetMaster)_timeSheetMaster.clone());
	}

	@Override
	public int compareTo(TimeSheetMaster timeSheetMaster) {
		return _timeSheetMaster.compareTo(timeSheetMaster);
	}

	/**
	* Returns the added date of this time sheet master.
	*
	* @return the added date of this time sheet master
	*/
	@Override
	public Date getAddedDate() {
		return _timeSheetMaster.getAddedDate();
	}

	/**
	* Returns the create date of this time sheet master.
	*
	* @return the create date of this time sheet master
	*/
	@Override
	public Date getCreateDate() {
		return _timeSheetMaster.getCreateDate();
	}

	/**
	* Returns the employee ID of this time sheet master.
	*
	* @return the employee ID of this time sheet master
	*/
	@Override
	public long getEmployeeId() {
		return _timeSheetMaster.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _timeSheetMaster.getExpandoBridge();
	}

	/**
	* Returns the from date of this time sheet master.
	*
	* @return the from date of this time sheet master
	*/
	@Override
	public Date getFromDate() {
		return _timeSheetMaster.getFromDate();
	}

	/**
	* Returns the group ID of this time sheet master.
	*
	* @return the group ID of this time sheet master
	*/
	@Override
	public long getGroupId() {
		return _timeSheetMaster.getGroupId();
	}

	/**
	* Returns the modified date of this time sheet master.
	*
	* @return the modified date of this time sheet master
	*/
	@Override
	public Date getModifiedDate() {
		return _timeSheetMaster.getModifiedDate();
	}

	/**
	* Returns the primary key of this time sheet master.
	*
	* @return the primary key of this time sheet master
	*/
	@Override
	public long getPrimaryKey() {
		return _timeSheetMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timeSheetMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this time sheet master.
	*
	* @return the status of this time sheet master
	*/
	@Override
	public int getStatus() {
		return _timeSheetMaster.getStatus();
	}

	/**
	* Returns the status by user ID of this time sheet master.
	*
	* @return the status by user ID of this time sheet master
	*/
	@Override
	public long getStatusByUserId() {
		return _timeSheetMaster.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this time sheet master.
	*
	* @return the status by user name of this time sheet master
	*/
	@Override
	public String getStatusByUserName() {
		return _timeSheetMaster.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this time sheet master.
	*
	* @return the status by user uuid of this time sheet master
	*/
	@Override
	public String getStatusByUserUuid() {
		return _timeSheetMaster.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this time sheet master.
	*
	* @return the status date of this time sheet master
	*/
	@Override
	public Date getStatusDate() {
		return _timeSheetMaster.getStatusDate();
	}

	/**
	* Returns the submit status of this time sheet master.
	*
	* @return the submit status of this time sheet master
	*/
	@Override
	public int getSubmitStatus() {
		return _timeSheetMaster.getSubmitStatus();
	}

	/**
	* Returns the timesheet parent ID of this time sheet master.
	*
	* @return the timesheet parent ID of this time sheet master
	*/
	@Override
	public long getTimesheetParentId() {
		return _timeSheetMaster.getTimesheetParentId();
	}

	/**
	* Returns the to date of this time sheet master.
	*
	* @return the to date of this time sheet master
	*/
	@Override
	public Date getToDate() {
		return _timeSheetMaster.getToDate();
	}

	@Override
	public int hashCode() {
		return _timeSheetMaster.hashCode();
	}

	/**
	* Returns <code>true</code> if this time sheet master is approved.
	*
	* @return <code>true</code> if this time sheet master is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _timeSheetMaster.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _timeSheetMaster.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this time sheet master is denied.
	*
	* @return <code>true</code> if this time sheet master is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _timeSheetMaster.isDenied();
	}

	/**
	* Returns <code>true</code> if this time sheet master is a draft.
	*
	* @return <code>true</code> if this time sheet master is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _timeSheetMaster.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _timeSheetMaster.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this time sheet master is expired.
	*
	* @return <code>true</code> if this time sheet master is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _timeSheetMaster.isExpired();
	}

	/**
	* Returns <code>true</code> if this time sheet master is inactive.
	*
	* @return <code>true</code> if this time sheet master is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _timeSheetMaster.isInactive();
	}

	/**
	* Returns <code>true</code> if this time sheet master is incomplete.
	*
	* @return <code>true</code> if this time sheet master is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _timeSheetMaster.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _timeSheetMaster.isNew();
	}

	/**
	* Returns <code>true</code> if this time sheet master is pending.
	*
	* @return <code>true</code> if this time sheet master is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _timeSheetMaster.isPending();
	}

	/**
	* Returns <code>true</code> if this time sheet master is scheduled.
	*
	* @return <code>true</code> if this time sheet master is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _timeSheetMaster.isScheduled();
	}

	@Override
	public void persist() {
		_timeSheetMaster.persist();
	}

	/**
	* Sets the added date of this time sheet master.
	*
	* @param addedDate the added date of this time sheet master
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_timeSheetMaster.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_timeSheetMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this time sheet master.
	*
	* @param createDate the create date of this time sheet master
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_timeSheetMaster.setCreateDate(createDate);
	}

	/**
	* Sets the employee ID of this time sheet master.
	*
	* @param employeeId the employee ID of this time sheet master
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_timeSheetMaster.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_timeSheetMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_timeSheetMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_timeSheetMaster.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the from date of this time sheet master.
	*
	* @param fromDate the from date of this time sheet master
	*/
	@Override
	public void setFromDate(Date fromDate) {
		_timeSheetMaster.setFromDate(fromDate);
	}

	/**
	* Sets the group ID of this time sheet master.
	*
	* @param groupId the group ID of this time sheet master
	*/
	@Override
	public void setGroupId(long groupId) {
		_timeSheetMaster.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this time sheet master.
	*
	* @param modifiedDate the modified date of this time sheet master
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_timeSheetMaster.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_timeSheetMaster.setNew(n);
	}

	/**
	* Sets the primary key of this time sheet master.
	*
	* @param primaryKey the primary key of this time sheet master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_timeSheetMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_timeSheetMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this time sheet master.
	*
	* @param status the status of this time sheet master
	*/
	@Override
	public void setStatus(int status) {
		_timeSheetMaster.setStatus(status);
	}

	/**
	* Sets the status by user ID of this time sheet master.
	*
	* @param statusByUserId the status by user ID of this time sheet master
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_timeSheetMaster.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this time sheet master.
	*
	* @param statusByUserName the status by user name of this time sheet master
	*/
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_timeSheetMaster.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this time sheet master.
	*
	* @param statusByUserUuid the status by user uuid of this time sheet master
	*/
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_timeSheetMaster.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this time sheet master.
	*
	* @param statusDate the status date of this time sheet master
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_timeSheetMaster.setStatusDate(statusDate);
	}

	/**
	* Sets the submit status of this time sheet master.
	*
	* @param submitStatus the submit status of this time sheet master
	*/
	@Override
	public void setSubmitStatus(int submitStatus) {
		_timeSheetMaster.setSubmitStatus(submitStatus);
	}

	/**
	* Sets the timesheet parent ID of this time sheet master.
	*
	* @param timesheetParentId the timesheet parent ID of this time sheet master
	*/
	@Override
	public void setTimesheetParentId(long timesheetParentId) {
		_timeSheetMaster.setTimesheetParentId(timesheetParentId);
	}

	/**
	* Sets the to date of this time sheet master.
	*
	* @param toDate the to date of this time sheet master
	*/
	@Override
	public void setToDate(Date toDate) {
		_timeSheetMaster.setToDate(toDate);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TimeSheetMaster> toCacheModel() {
		return _timeSheetMaster.toCacheModel();
	}

	@Override
	public TimeSheetMaster toEscapedModel() {
		return new TimeSheetMasterWrapper(_timeSheetMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _timeSheetMaster.toString();
	}

	@Override
	public TimeSheetMaster toUnescapedModel() {
		return new TimeSheetMasterWrapper(_timeSheetMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _timeSheetMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimeSheetMasterWrapper)) {
			return false;
		}

		TimeSheetMasterWrapper timeSheetMasterWrapper = (TimeSheetMasterWrapper)obj;

		if (Objects.equals(_timeSheetMaster,
					timeSheetMasterWrapper._timeSheetMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public TimeSheetMaster getWrappedModel() {
		return _timeSheetMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _timeSheetMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _timeSheetMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_timeSheetMaster.resetOriginalValues();
	}

	private final TimeSheetMaster _timeSheetMaster;
}