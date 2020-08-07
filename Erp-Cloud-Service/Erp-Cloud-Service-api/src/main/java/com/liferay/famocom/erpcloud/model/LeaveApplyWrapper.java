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
 * This class is a wrapper for {@link LeaveApply}.
 * </p>
 *
 * @author Samaresh
 * @see LeaveApply
 * @generated
 */
@ProviderType
public class LeaveApplyWrapper implements LeaveApply, ModelWrapper<LeaveApply> {
	public LeaveApplyWrapper(LeaveApply leaveApply) {
		_leaveApply = leaveApply;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveApply.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveApply.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveApplyId", getLeaveApplyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("fromDate", getFromDate());
		attributes.put("fromDateSession", getFromDateSession());
		attributes.put("toDate", getToDate());
		attributes.put("toDateSession", getToDateSession());
		attributes.put("leaveDays", getLeaveDays());
		attributes.put("reason", getReason());
		attributes.put("attachedFile", getAttachedFile());
		attributes.put("cancelReason", getCancelReason());
		attributes.put("hrComments", getHrComments());
		attributes.put("isApprove", getIsApprove());
		attributes.put("addedDate", getAddedDate());
		attributes.put("userId", getUserId());
		attributes.put("fileEntryId", getFileEntryId());
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
		Long leaveApplyId = (Long)attributes.get("leaveApplyId");

		if (leaveApplyId != null) {
			setLeaveApplyId(leaveApplyId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long leaveTypeId = (Long)attributes.get("leaveTypeId");

		if (leaveTypeId != null) {
			setLeaveTypeId(leaveTypeId);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		String fromDateSession = (String)attributes.get("fromDateSession");

		if (fromDateSession != null) {
			setFromDateSession(fromDateSession);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		String toDateSession = (String)attributes.get("toDateSession");

		if (toDateSession != null) {
			setToDateSession(toDateSession);
		}

		Double leaveDays = (Double)attributes.get("leaveDays");

		if (leaveDays != null) {
			setLeaveDays(leaveDays);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		String attachedFile = (String)attributes.get("attachedFile");

		if (attachedFile != null) {
			setAttachedFile(attachedFile);
		}

		String cancelReason = (String)attributes.get("cancelReason");

		if (cancelReason != null) {
			setCancelReason(cancelReason);
		}

		String hrComments = (String)attributes.get("hrComments");

		if (hrComments != null) {
			setHrComments(hrComments);
		}

		Integer isApprove = (Integer)attributes.get("isApprove");

		if (isApprove != null) {
			setIsApprove(isApprove);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
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
		return new LeaveApplyWrapper((LeaveApply)_leaveApply.clone());
	}

	@Override
	public int compareTo(LeaveApply leaveApply) {
		return _leaveApply.compareTo(leaveApply);
	}

	/**
	* Returns the added date of this leave apply.
	*
	* @return the added date of this leave apply
	*/
	@Override
	public Date getAddedDate() {
		return _leaveApply.getAddedDate();
	}

	/**
	* Returns the attached file of this leave apply.
	*
	* @return the attached file of this leave apply
	*/
	@Override
	public String getAttachedFile() {
		return _leaveApply.getAttachedFile();
	}

	/**
	* Returns the cancel reason of this leave apply.
	*
	* @return the cancel reason of this leave apply
	*/
	@Override
	public String getCancelReason() {
		return _leaveApply.getCancelReason();
	}

	/**
	* Returns the company ID of this leave apply.
	*
	* @return the company ID of this leave apply
	*/
	@Override
	public long getCompanyId() {
		return _leaveApply.getCompanyId();
	}

	/**
	* Returns the create date of this leave apply.
	*
	* @return the create date of this leave apply
	*/
	@Override
	public Date getCreateDate() {
		return _leaveApply.getCreateDate();
	}

	/**
	* Returns the employee ID of this leave apply.
	*
	* @return the employee ID of this leave apply
	*/
	@Override
	public long getEmployeeId() {
		return _leaveApply.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _leaveApply.getExpandoBridge();
	}

	/**
	* Returns the file entry ID of this leave apply.
	*
	* @return the file entry ID of this leave apply
	*/
	@Override
	public long getFileEntryId() {
		return _leaveApply.getFileEntryId();
	}

	/**
	* Returns the from date of this leave apply.
	*
	* @return the from date of this leave apply
	*/
	@Override
	public Date getFromDate() {
		return _leaveApply.getFromDate();
	}

	/**
	* Returns the from date session of this leave apply.
	*
	* @return the from date session of this leave apply
	*/
	@Override
	public String getFromDateSession() {
		return _leaveApply.getFromDateSession();
	}

	/**
	* Returns the group ID of this leave apply.
	*
	* @return the group ID of this leave apply
	*/
	@Override
	public long getGroupId() {
		return _leaveApply.getGroupId();
	}

	/**
	* Returns the hr comments of this leave apply.
	*
	* @return the hr comments of this leave apply
	*/
	@Override
	public String getHrComments() {
		return _leaveApply.getHrComments();
	}

	/**
	* Returns the is approve of this leave apply.
	*
	* @return the is approve of this leave apply
	*/
	@Override
	public int getIsApprove() {
		return _leaveApply.getIsApprove();
	}

	/**
	* Returns the leave apply ID of this leave apply.
	*
	* @return the leave apply ID of this leave apply
	*/
	@Override
	public long getLeaveApplyId() {
		return _leaveApply.getLeaveApplyId();
	}

	/**
	* Returns the leave days of this leave apply.
	*
	* @return the leave days of this leave apply
	*/
	@Override
	public double getLeaveDays() {
		return _leaveApply.getLeaveDays();
	}

	/**
	* Returns the leave type ID of this leave apply.
	*
	* @return the leave type ID of this leave apply
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveApply.getLeaveTypeId();
	}

	/**
	* Returns the modified date of this leave apply.
	*
	* @return the modified date of this leave apply
	*/
	@Override
	public Date getModifiedDate() {
		return _leaveApply.getModifiedDate();
	}

	/**
	* Returns the primary key of this leave apply.
	*
	* @return the primary key of this leave apply
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveApply.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveApply.getPrimaryKeyObj();
	}

	/**
	* Returns the reason of this leave apply.
	*
	* @return the reason of this leave apply
	*/
	@Override
	public String getReason() {
		return _leaveApply.getReason();
	}

	/**
	* Returns the status of this leave apply.
	*
	* @return the status of this leave apply
	*/
	@Override
	public int getStatus() {
		return _leaveApply.getStatus();
	}

	/**
	* Returns the status by user ID of this leave apply.
	*
	* @return the status by user ID of this leave apply
	*/
	@Override
	public long getStatusByUserId() {
		return _leaveApply.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this leave apply.
	*
	* @return the status by user name of this leave apply
	*/
	@Override
	public String getStatusByUserName() {
		return _leaveApply.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this leave apply.
	*
	* @return the status by user uuid of this leave apply
	*/
	@Override
	public String getStatusByUserUuid() {
		return _leaveApply.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this leave apply.
	*
	* @return the status date of this leave apply
	*/
	@Override
	public Date getStatusDate() {
		return _leaveApply.getStatusDate();
	}

	/**
	* Returns the to date of this leave apply.
	*
	* @return the to date of this leave apply
	*/
	@Override
	public Date getToDate() {
		return _leaveApply.getToDate();
	}

	/**
	* Returns the to date session of this leave apply.
	*
	* @return the to date session of this leave apply
	*/
	@Override
	public String getToDateSession() {
		return _leaveApply.getToDateSession();
	}

	/**
	* Returns the user ID of this leave apply.
	*
	* @return the user ID of this leave apply
	*/
	@Override
	public long getUserId() {
		return _leaveApply.getUserId();
	}

	/**
	* Returns the user uuid of this leave apply.
	*
	* @return the user uuid of this leave apply
	*/
	@Override
	public String getUserUuid() {
		return _leaveApply.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _leaveApply.hashCode();
	}

	/**
	* Returns <code>true</code> if this leave apply is approved.
	*
	* @return <code>true</code> if this leave apply is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _leaveApply.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _leaveApply.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this leave apply is denied.
	*
	* @return <code>true</code> if this leave apply is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _leaveApply.isDenied();
	}

	/**
	* Returns <code>true</code> if this leave apply is a draft.
	*
	* @return <code>true</code> if this leave apply is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _leaveApply.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveApply.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this leave apply is expired.
	*
	* @return <code>true</code> if this leave apply is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _leaveApply.isExpired();
	}

	/**
	* Returns <code>true</code> if this leave apply is inactive.
	*
	* @return <code>true</code> if this leave apply is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _leaveApply.isInactive();
	}

	/**
	* Returns <code>true</code> if this leave apply is incomplete.
	*
	* @return <code>true</code> if this leave apply is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _leaveApply.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _leaveApply.isNew();
	}

	/**
	* Returns <code>true</code> if this leave apply is pending.
	*
	* @return <code>true</code> if this leave apply is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _leaveApply.isPending();
	}

	/**
	* Returns <code>true</code> if this leave apply is scheduled.
	*
	* @return <code>true</code> if this leave apply is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _leaveApply.isScheduled();
	}

	@Override
	public void persist() {
		_leaveApply.persist();
	}

	/**
	* Sets the added date of this leave apply.
	*
	* @param addedDate the added date of this leave apply
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_leaveApply.setAddedDate(addedDate);
	}

	/**
	* Sets the attached file of this leave apply.
	*
	* @param attachedFile the attached file of this leave apply
	*/
	@Override
	public void setAttachedFile(String attachedFile) {
		_leaveApply.setAttachedFile(attachedFile);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveApply.setCachedModel(cachedModel);
	}

	/**
	* Sets the cancel reason of this leave apply.
	*
	* @param cancelReason the cancel reason of this leave apply
	*/
	@Override
	public void setCancelReason(String cancelReason) {
		_leaveApply.setCancelReason(cancelReason);
	}

	/**
	* Sets the company ID of this leave apply.
	*
	* @param companyId the company ID of this leave apply
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveApply.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this leave apply.
	*
	* @param createDate the create date of this leave apply
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_leaveApply.setCreateDate(createDate);
	}

	/**
	* Sets the employee ID of this leave apply.
	*
	* @param employeeId the employee ID of this leave apply
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_leaveApply.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_leaveApply.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_leaveApply.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_leaveApply.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entry ID of this leave apply.
	*
	* @param fileEntryId the file entry ID of this leave apply
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_leaveApply.setFileEntryId(fileEntryId);
	}

	/**
	* Sets the from date of this leave apply.
	*
	* @param fromDate the from date of this leave apply
	*/
	@Override
	public void setFromDate(Date fromDate) {
		_leaveApply.setFromDate(fromDate);
	}

	/**
	* Sets the from date session of this leave apply.
	*
	* @param fromDateSession the from date session of this leave apply
	*/
	@Override
	public void setFromDateSession(String fromDateSession) {
		_leaveApply.setFromDateSession(fromDateSession);
	}

	/**
	* Sets the group ID of this leave apply.
	*
	* @param groupId the group ID of this leave apply
	*/
	@Override
	public void setGroupId(long groupId) {
		_leaveApply.setGroupId(groupId);
	}

	/**
	* Sets the hr comments of this leave apply.
	*
	* @param hrComments the hr comments of this leave apply
	*/
	@Override
	public void setHrComments(String hrComments) {
		_leaveApply.setHrComments(hrComments);
	}

	/**
	* Sets the is approve of this leave apply.
	*
	* @param isApprove the is approve of this leave apply
	*/
	@Override
	public void setIsApprove(int isApprove) {
		_leaveApply.setIsApprove(isApprove);
	}

	/**
	* Sets the leave apply ID of this leave apply.
	*
	* @param leaveApplyId the leave apply ID of this leave apply
	*/
	@Override
	public void setLeaveApplyId(long leaveApplyId) {
		_leaveApply.setLeaveApplyId(leaveApplyId);
	}

	/**
	* Sets the leave days of this leave apply.
	*
	* @param leaveDays the leave days of this leave apply
	*/
	@Override
	public void setLeaveDays(double leaveDays) {
		_leaveApply.setLeaveDays(leaveDays);
	}

	/**
	* Sets the leave type ID of this leave apply.
	*
	* @param leaveTypeId the leave type ID of this leave apply
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveApply.setLeaveTypeId(leaveTypeId);
	}

	/**
	* Sets the modified date of this leave apply.
	*
	* @param modifiedDate the modified date of this leave apply
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_leaveApply.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_leaveApply.setNew(n);
	}

	/**
	* Sets the primary key of this leave apply.
	*
	* @param primaryKey the primary key of this leave apply
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveApply.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_leaveApply.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the reason of this leave apply.
	*
	* @param reason the reason of this leave apply
	*/
	@Override
	public void setReason(String reason) {
		_leaveApply.setReason(reason);
	}

	/**
	* Sets the status of this leave apply.
	*
	* @param status the status of this leave apply
	*/
	@Override
	public void setStatus(int status) {
		_leaveApply.setStatus(status);
	}

	/**
	* Sets the status by user ID of this leave apply.
	*
	* @param statusByUserId the status by user ID of this leave apply
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_leaveApply.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this leave apply.
	*
	* @param statusByUserName the status by user name of this leave apply
	*/
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_leaveApply.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this leave apply.
	*
	* @param statusByUserUuid the status by user uuid of this leave apply
	*/
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_leaveApply.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this leave apply.
	*
	* @param statusDate the status date of this leave apply
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_leaveApply.setStatusDate(statusDate);
	}

	/**
	* Sets the to date of this leave apply.
	*
	* @param toDate the to date of this leave apply
	*/
	@Override
	public void setToDate(Date toDate) {
		_leaveApply.setToDate(toDate);
	}

	/**
	* Sets the to date session of this leave apply.
	*
	* @param toDateSession the to date session of this leave apply
	*/
	@Override
	public void setToDateSession(String toDateSession) {
		_leaveApply.setToDateSession(toDateSession);
	}

	/**
	* Sets the user ID of this leave apply.
	*
	* @param userId the user ID of this leave apply
	*/
	@Override
	public void setUserId(long userId) {
		_leaveApply.setUserId(userId);
	}

	/**
	* Sets the user uuid of this leave apply.
	*
	* @param userUuid the user uuid of this leave apply
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_leaveApply.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LeaveApply> toCacheModel() {
		return _leaveApply.toCacheModel();
	}

	@Override
	public LeaveApply toEscapedModel() {
		return new LeaveApplyWrapper(_leaveApply.toEscapedModel());
	}

	@Override
	public String toString() {
		return _leaveApply.toString();
	}

	@Override
	public LeaveApply toUnescapedModel() {
		return new LeaveApplyWrapper(_leaveApply.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _leaveApply.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveApplyWrapper)) {
			return false;
		}

		LeaveApplyWrapper leaveApplyWrapper = (LeaveApplyWrapper)obj;

		if (Objects.equals(_leaveApply, leaveApplyWrapper._leaveApply)) {
			return true;
		}

		return false;
	}

	@Override
	public LeaveApply getWrappedModel() {
		return _leaveApply;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _leaveApply.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _leaveApply.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_leaveApply.resetOriginalValues();
	}

	private final LeaveApply _leaveApply;
}