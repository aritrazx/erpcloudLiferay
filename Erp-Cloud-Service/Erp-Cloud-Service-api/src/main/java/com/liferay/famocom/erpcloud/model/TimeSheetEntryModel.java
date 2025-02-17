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
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TimeSheetEntry service. Represents a row in the &quot;timeSheetEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.TimeSheetEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.TimeSheetEntryImpl}.
 * </p>
 *
 * @author Samaresh
 * @see TimeSheetEntry
 * @see com.liferay.famocom.erpcloud.model.impl.TimeSheetEntryImpl
 * @see com.liferay.famocom.erpcloud.model.impl.TimeSheetEntryModelImpl
 * @generated
 */
@ProviderType
public interface TimeSheetEntryModel extends BaseModel<TimeSheetEntry>,
	WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a time sheet entry model instance should use the {@link TimeSheetEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this time sheet entry.
	 *
	 * @return the primary key of this time sheet entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this time sheet entry.
	 *
	 * @param primaryKey the primary key of this time sheet entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the timesheet ID of this time sheet entry.
	 *
	 * @return the timesheet ID of this time sheet entry
	 */
	public long getTimesheetId();

	/**
	 * Sets the timesheet ID of this time sheet entry.
	 *
	 * @param timesheetId the timesheet ID of this time sheet entry
	 */
	public void setTimesheetId(long timesheetId);

	/**
	 * Returns the entry date of this time sheet entry.
	 *
	 * @return the entry date of this time sheet entry
	 */
	public Date getEntryDate();

	/**
	 * Sets the entry date of this time sheet entry.
	 *
	 * @param entryDate the entry date of this time sheet entry
	 */
	public void setEntryDate(Date entryDate);

	/**
	 * Returns the employee ID of this time sheet entry.
	 *
	 * @return the employee ID of this time sheet entry
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this time sheet entry.
	 *
	 * @param employeeId the employee ID of this time sheet entry
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the project ID of this time sheet entry.
	 *
	 * @return the project ID of this time sheet entry
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this time sheet entry.
	 *
	 * @param projectId the project ID of this time sheet entry
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the project task ID of this time sheet entry.
	 *
	 * @return the project task ID of this time sheet entry
	 */
	public long getProjectTaskId();

	/**
	 * Sets the project task ID of this time sheet entry.
	 *
	 * @param projectTaskId the project task ID of this time sheet entry
	 */
	public void setProjectTaskId(long projectTaskId);

	/**
	 * Returns the hours of this time sheet entry.
	 *
	 * @return the hours of this time sheet entry
	 */
	public double getHours();

	/**
	 * Sets the hours of this time sheet entry.
	 *
	 * @param hours the hours of this time sheet entry
	 */
	public void setHours(double hours);

	/**
	 * Returns the work description of this time sheet entry.
	 *
	 * @return the work description of this time sheet entry
	 */
	@AutoEscape
	public String getWorkDescription();

	/**
	 * Sets the work description of this time sheet entry.
	 *
	 * @param workDescription the work description of this time sheet entry
	 */
	public void setWorkDescription(String workDescription);

	/**
	 * Returns the timesheet parent ID of this time sheet entry.
	 *
	 * @return the timesheet parent ID of this time sheet entry
	 */
	public long getTimesheetParentId();

	/**
	 * Sets the timesheet parent ID of this time sheet entry.
	 *
	 * @param timesheetParentId the timesheet parent ID of this time sheet entry
	 */
	public void setTimesheetParentId(long timesheetParentId);

	/**
	 * Returns the added date of this time sheet entry.
	 *
	 * @return the added date of this time sheet entry
	 */
	public Date getAddedDate();

	/**
	 * Sets the added date of this time sheet entry.
	 *
	 * @param addedDate the added date of this time sheet entry
	 */
	public void setAddedDate(Date addedDate);

	/**
	 * Returns the group ID of this time sheet entry.
	 *
	 * @return the group ID of this time sheet entry
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this time sheet entry.
	 *
	 * @param groupId the group ID of this time sheet entry
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the status of this time sheet entry.
	 *
	 * @return the status of this time sheet entry
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this time sheet entry.
	 *
	 * @param status the status of this time sheet entry
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this time sheet entry.
	 *
	 * @return the status by user ID of this time sheet entry
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this time sheet entry.
	 *
	 * @param statusByUserId the status by user ID of this time sheet entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this time sheet entry.
	 *
	 * @return the status by user uuid of this time sheet entry
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this time sheet entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this time sheet entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this time sheet entry.
	 *
	 * @return the status by user name of this time sheet entry
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this time sheet entry.
	 *
	 * @param statusByUserName the status by user name of this time sheet entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this time sheet entry.
	 *
	 * @return the status date of this time sheet entry
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this time sheet entry.
	 *
	 * @param statusDate the status date of this time sheet entry
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the create date of this time sheet entry.
	 *
	 * @return the create date of this time sheet entry
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this time sheet entry.
	 *
	 * @param createDate the create date of this time sheet entry
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this time sheet entry.
	 *
	 * @return the modified date of this time sheet entry
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this time sheet entry.
	 *
	 * @param modifiedDate the modified date of this time sheet entry
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns <code>true</code> if this time sheet entry is approved.
	 *
	 * @return <code>true</code> if this time sheet entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this time sheet entry is denied.
	 *
	 * @return <code>true</code> if this time sheet entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this time sheet entry is a draft.
	 *
	 * @return <code>true</code> if this time sheet entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this time sheet entry is expired.
	 *
	 * @return <code>true</code> if this time sheet entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this time sheet entry is inactive.
	 *
	 * @return <code>true</code> if this time sheet entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this time sheet entry is incomplete.
	 *
	 * @return <code>true</code> if this time sheet entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this time sheet entry is pending.
	 *
	 * @return <code>true</code> if this time sheet entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this time sheet entry is scheduled.
	 *
	 * @return <code>true</code> if this time sheet entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

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
	public int compareTo(TimeSheetEntry timeSheetEntry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<TimeSheetEntry> toCacheModel();

	@Override
	public TimeSheetEntry toEscapedModel();

	@Override
	public TimeSheetEntry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}