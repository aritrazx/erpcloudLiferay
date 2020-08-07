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
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LeaveApply service. Represents a row in the &quot;leaveApply&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.LeaveApplyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.LeaveApplyImpl}.
 * </p>
 *
 * @author Samaresh
 * @see LeaveApply
 * @see com.liferay.famocom.erpcloud.model.impl.LeaveApplyImpl
 * @see com.liferay.famocom.erpcloud.model.impl.LeaveApplyModelImpl
 * @generated
 */
@ProviderType
public interface LeaveApplyModel extends BaseModel<LeaveApply>, ShardedModel,
	WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a leave apply model instance should use the {@link LeaveApply} interface instead.
	 */

	/**
	 * Returns the primary key of this leave apply.
	 *
	 * @return the primary key of this leave apply
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this leave apply.
	 *
	 * @param primaryKey the primary key of this leave apply
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the leave apply ID of this leave apply.
	 *
	 * @return the leave apply ID of this leave apply
	 */
	public long getLeaveApplyId();

	/**
	 * Sets the leave apply ID of this leave apply.
	 *
	 * @param leaveApplyId the leave apply ID of this leave apply
	 */
	public void setLeaveApplyId(long leaveApplyId);

	/**
	 * Returns the company ID of this leave apply.
	 *
	 * @return the company ID of this leave apply
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this leave apply.
	 *
	 * @param companyId the company ID of this leave apply
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the employee ID of this leave apply.
	 *
	 * @return the employee ID of this leave apply
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this leave apply.
	 *
	 * @param employeeId the employee ID of this leave apply
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the leave type ID of this leave apply.
	 *
	 * @return the leave type ID of this leave apply
	 */
	public long getLeaveTypeId();

	/**
	 * Sets the leave type ID of this leave apply.
	 *
	 * @param leaveTypeId the leave type ID of this leave apply
	 */
	public void setLeaveTypeId(long leaveTypeId);

	/**
	 * Returns the from date of this leave apply.
	 *
	 * @return the from date of this leave apply
	 */
	public Date getFromDate();

	/**
	 * Sets the from date of this leave apply.
	 *
	 * @param fromDate the from date of this leave apply
	 */
	public void setFromDate(Date fromDate);

	/**
	 * Returns the from date session of this leave apply.
	 *
	 * @return the from date session of this leave apply
	 */
	@AutoEscape
	public String getFromDateSession();

	/**
	 * Sets the from date session of this leave apply.
	 *
	 * @param fromDateSession the from date session of this leave apply
	 */
	public void setFromDateSession(String fromDateSession);

	/**
	 * Returns the to date of this leave apply.
	 *
	 * @return the to date of this leave apply
	 */
	public Date getToDate();

	/**
	 * Sets the to date of this leave apply.
	 *
	 * @param toDate the to date of this leave apply
	 */
	public void setToDate(Date toDate);

	/**
	 * Returns the to date session of this leave apply.
	 *
	 * @return the to date session of this leave apply
	 */
	@AutoEscape
	public String getToDateSession();

	/**
	 * Sets the to date session of this leave apply.
	 *
	 * @param toDateSession the to date session of this leave apply
	 */
	public void setToDateSession(String toDateSession);

	/**
	 * Returns the leave days of this leave apply.
	 *
	 * @return the leave days of this leave apply
	 */
	public double getLeaveDays();

	/**
	 * Sets the leave days of this leave apply.
	 *
	 * @param leaveDays the leave days of this leave apply
	 */
	public void setLeaveDays(double leaveDays);

	/**
	 * Returns the reason of this leave apply.
	 *
	 * @return the reason of this leave apply
	 */
	@AutoEscape
	public String getReason();

	/**
	 * Sets the reason of this leave apply.
	 *
	 * @param reason the reason of this leave apply
	 */
	public void setReason(String reason);

	/**
	 * Returns the attached file of this leave apply.
	 *
	 * @return the attached file of this leave apply
	 */
	@AutoEscape
	public String getAttachedFile();

	/**
	 * Sets the attached file of this leave apply.
	 *
	 * @param attachedFile the attached file of this leave apply
	 */
	public void setAttachedFile(String attachedFile);

	/**
	 * Returns the cancel reason of this leave apply.
	 *
	 * @return the cancel reason of this leave apply
	 */
	@AutoEscape
	public String getCancelReason();

	/**
	 * Sets the cancel reason of this leave apply.
	 *
	 * @param cancelReason the cancel reason of this leave apply
	 */
	public void setCancelReason(String cancelReason);

	/**
	 * Returns the hr comments of this leave apply.
	 *
	 * @return the hr comments of this leave apply
	 */
	@AutoEscape
	public String getHrComments();

	/**
	 * Sets the hr comments of this leave apply.
	 *
	 * @param hrComments the hr comments of this leave apply
	 */
	public void setHrComments(String hrComments);

	/**
	 * Returns the is approve of this leave apply.
	 *
	 * @return the is approve of this leave apply
	 */
	public int getIsApprove();

	/**
	 * Sets the is approve of this leave apply.
	 *
	 * @param isApprove the is approve of this leave apply
	 */
	public void setIsApprove(int isApprove);

	/**
	 * Returns the added date of this leave apply.
	 *
	 * @return the added date of this leave apply
	 */
	public Date getAddedDate();

	/**
	 * Sets the added date of this leave apply.
	 *
	 * @param addedDate the added date of this leave apply
	 */
	public void setAddedDate(Date addedDate);

	/**
	 * Returns the user ID of this leave apply.
	 *
	 * @return the user ID of this leave apply
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this leave apply.
	 *
	 * @param userId the user ID of this leave apply
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this leave apply.
	 *
	 * @return the user uuid of this leave apply
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this leave apply.
	 *
	 * @param userUuid the user uuid of this leave apply
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the file entry ID of this leave apply.
	 *
	 * @return the file entry ID of this leave apply
	 */
	public long getFileEntryId();

	/**
	 * Sets the file entry ID of this leave apply.
	 *
	 * @param fileEntryId the file entry ID of this leave apply
	 */
	public void setFileEntryId(long fileEntryId);

	/**
	 * Returns the group ID of this leave apply.
	 *
	 * @return the group ID of this leave apply
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this leave apply.
	 *
	 * @param groupId the group ID of this leave apply
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the status of this leave apply.
	 *
	 * @return the status of this leave apply
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this leave apply.
	 *
	 * @param status the status of this leave apply
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this leave apply.
	 *
	 * @return the status by user ID of this leave apply
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this leave apply.
	 *
	 * @param statusByUserId the status by user ID of this leave apply
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this leave apply.
	 *
	 * @return the status by user uuid of this leave apply
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this leave apply.
	 *
	 * @param statusByUserUuid the status by user uuid of this leave apply
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this leave apply.
	 *
	 * @return the status by user name of this leave apply
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this leave apply.
	 *
	 * @param statusByUserName the status by user name of this leave apply
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this leave apply.
	 *
	 * @return the status date of this leave apply
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this leave apply.
	 *
	 * @param statusDate the status date of this leave apply
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the create date of this leave apply.
	 *
	 * @return the create date of this leave apply
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this leave apply.
	 *
	 * @param createDate the create date of this leave apply
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this leave apply.
	 *
	 * @return the modified date of this leave apply
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this leave apply.
	 *
	 * @param modifiedDate the modified date of this leave apply
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns <code>true</code> if this leave apply is approved.
	 *
	 * @return <code>true</code> if this leave apply is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this leave apply is denied.
	 *
	 * @return <code>true</code> if this leave apply is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this leave apply is a draft.
	 *
	 * @return <code>true</code> if this leave apply is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this leave apply is expired.
	 *
	 * @return <code>true</code> if this leave apply is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this leave apply is inactive.
	 *
	 * @return <code>true</code> if this leave apply is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this leave apply is incomplete.
	 *
	 * @return <code>true</code> if this leave apply is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this leave apply is pending.
	 *
	 * @return <code>true</code> if this leave apply is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this leave apply is scheduled.
	 *
	 * @return <code>true</code> if this leave apply is scheduled; <code>false</code> otherwise
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
	public int compareTo(LeaveApply leaveApply);

	@Override
	public int hashCode();

	@Override
	public CacheModel<LeaveApply> toCacheModel();

	@Override
	public LeaveApply toEscapedModel();

	@Override
	public LeaveApply toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}