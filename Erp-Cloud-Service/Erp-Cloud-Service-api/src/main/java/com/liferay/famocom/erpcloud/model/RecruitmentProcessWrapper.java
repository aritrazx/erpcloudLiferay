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
 * This class is a wrapper for {@link RecruitmentProcess}.
 * </p>
 *
 * @author Samaresh
 * @see RecruitmentProcess
 * @generated
 */
@ProviderType
public class RecruitmentProcessWrapper implements RecruitmentProcess,
	ModelWrapper<RecruitmentProcess> {
	public RecruitmentProcessWrapper(RecruitmentProcess recruitmentProcess) {
		_recruitmentProcess = recruitmentProcess;
	}

	@Override
	public Class<?> getModelClass() {
		return RecruitmentProcess.class;
	}

	@Override
	public String getModelClassName() {
		return RecruitmentProcess.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recruitmentProcessId", getRecruitmentProcessId());
		attributes.put("applyCandidateId", getApplyCandidateId());
		attributes.put("interviewDate", getInterviewDate());
		attributes.put("interviewTime", getInterviewTime());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("interviewerRemarks", getInterviewerRemarks());
		attributes.put("hrRemarks", getHrRemarks());
		attributes.put("isSelected", isIsSelected());
		attributes.put("interviewerId", getInterviewerId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("jobPostId", getJobPostId());
		attributes.put("groupId", getGroupId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recruitmentProcessId = (Long)attributes.get("recruitmentProcessId");

		if (recruitmentProcessId != null) {
			setRecruitmentProcessId(recruitmentProcessId);
		}

		Long applyCandidateId = (Long)attributes.get("applyCandidateId");

		if (applyCandidateId != null) {
			setApplyCandidateId(applyCandidateId);
		}

		Date interviewDate = (Date)attributes.get("interviewDate");

		if (interviewDate != null) {
			setInterviewDate(interviewDate);
		}

		String interviewTime = (String)attributes.get("interviewTime");

		if (interviewTime != null) {
			setInterviewTime(interviewTime);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String interviewerRemarks = (String)attributes.get("interviewerRemarks");

		if (interviewerRemarks != null) {
			setInterviewerRemarks(interviewerRemarks);
		}

		String hrRemarks = (String)attributes.get("hrRemarks");

		if (hrRemarks != null) {
			setHrRemarks(hrRemarks);
		}

		Boolean isSelected = (Boolean)attributes.get("isSelected");

		if (isSelected != null) {
			setIsSelected(isSelected);
		}

		Long interviewerId = (Long)attributes.get("interviewerId");

		if (interviewerId != null) {
			setInterviewerId(interviewerId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long jobPostId = (Long)attributes.get("jobPostId");

		if (jobPostId != null) {
			setJobPostId(jobPostId);
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public Object clone() {
		return new RecruitmentProcessWrapper((RecruitmentProcess)_recruitmentProcess.clone());
	}

	@Override
	public int compareTo(RecruitmentProcess recruitmentProcess) {
		return _recruitmentProcess.compareTo(recruitmentProcess);
	}

	/**
	* Returns the apply candidate ID of this recruitment process.
	*
	* @return the apply candidate ID of this recruitment process
	*/
	@Override
	public long getApplyCandidateId() {
		return _recruitmentProcess.getApplyCandidateId();
	}

	/**
	* Returns the create date of this recruitment process.
	*
	* @return the create date of this recruitment process
	*/
	@Override
	public Date getCreateDate() {
		return _recruitmentProcess.getCreateDate();
	}

	/**
	* Returns the created by of this recruitment process.
	*
	* @return the created by of this recruitment process
	*/
	@Override
	public long getCreatedBy() {
		return _recruitmentProcess.getCreatedBy();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _recruitmentProcess.getExpandoBridge();
	}

	/**
	* Returns the file entry ID of this recruitment process.
	*
	* @return the file entry ID of this recruitment process
	*/
	@Override
	public long getFileEntryId() {
		return _recruitmentProcess.getFileEntryId();
	}

	/**
	* Returns the group ID of this recruitment process.
	*
	* @return the group ID of this recruitment process
	*/
	@Override
	public long getGroupId() {
		return _recruitmentProcess.getGroupId();
	}

	/**
	* Returns the hr remarks of this recruitment process.
	*
	* @return the hr remarks of this recruitment process
	*/
	@Override
	public String getHrRemarks() {
		return _recruitmentProcess.getHrRemarks();
	}

	/**
	* Returns the interview date of this recruitment process.
	*
	* @return the interview date of this recruitment process
	*/
	@Override
	public Date getInterviewDate() {
		return _recruitmentProcess.getInterviewDate();
	}

	/**
	* Returns the interviewer ID of this recruitment process.
	*
	* @return the interviewer ID of this recruitment process
	*/
	@Override
	public long getInterviewerId() {
		return _recruitmentProcess.getInterviewerId();
	}

	/**
	* Returns the interviewer remarks of this recruitment process.
	*
	* @return the interviewer remarks of this recruitment process
	*/
	@Override
	public String getInterviewerRemarks() {
		return _recruitmentProcess.getInterviewerRemarks();
	}

	/**
	* Returns the interview time of this recruitment process.
	*
	* @return the interview time of this recruitment process
	*/
	@Override
	public String getInterviewTime() {
		return _recruitmentProcess.getInterviewTime();
	}

	/**
	* Returns the is selected of this recruitment process.
	*
	* @return the is selected of this recruitment process
	*/
	@Override
	public boolean getIsSelected() {
		return _recruitmentProcess.getIsSelected();
	}

	/**
	* Returns the job post ID of this recruitment process.
	*
	* @return the job post ID of this recruitment process
	*/
	@Override
	public long getJobPostId() {
		return _recruitmentProcess.getJobPostId();
	}

	/**
	* Returns the modified date of this recruitment process.
	*
	* @return the modified date of this recruitment process
	*/
	@Override
	public Date getModifiedDate() {
		return _recruitmentProcess.getModifiedDate();
	}

	/**
	* Returns the primary key of this recruitment process.
	*
	* @return the primary key of this recruitment process
	*/
	@Override
	public long getPrimaryKey() {
		return _recruitmentProcess.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _recruitmentProcess.getPrimaryKeyObj();
	}

	/**
	* Returns the recruitment process ID of this recruitment process.
	*
	* @return the recruitment process ID of this recruitment process
	*/
	@Override
	public long getRecruitmentProcessId() {
		return _recruitmentProcess.getRecruitmentProcessId();
	}

	/**
	* Returns the status of this recruitment process.
	*
	* @return the status of this recruitment process
	*/
	@Override
	public int getStatus() {
		return _recruitmentProcess.getStatus();
	}

	/**
	* Returns the status by user ID of this recruitment process.
	*
	* @return the status by user ID of this recruitment process
	*/
	@Override
	public long getStatusByUserId() {
		return _recruitmentProcess.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this recruitment process.
	*
	* @return the status by user name of this recruitment process
	*/
	@Override
	public String getStatusByUserName() {
		return _recruitmentProcess.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this recruitment process.
	*
	* @return the status by user uuid of this recruitment process
	*/
	@Override
	public String getStatusByUserUuid() {
		return _recruitmentProcess.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this recruitment process.
	*
	* @return the status date of this recruitment process
	*/
	@Override
	public Date getStatusDate() {
		return _recruitmentProcess.getStatusDate();
	}

	/**
	* Returns the user ID of this recruitment process.
	*
	* @return the user ID of this recruitment process
	*/
	@Override
	public long getUserId() {
		return _recruitmentProcess.getUserId();
	}

	/**
	* Returns the user uuid of this recruitment process.
	*
	* @return the user uuid of this recruitment process
	*/
	@Override
	public String getUserUuid() {
		return _recruitmentProcess.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _recruitmentProcess.hashCode();
	}

	/**
	* Returns <code>true</code> if this recruitment process is approved.
	*
	* @return <code>true</code> if this recruitment process is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _recruitmentProcess.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _recruitmentProcess.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this recruitment process is denied.
	*
	* @return <code>true</code> if this recruitment process is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _recruitmentProcess.isDenied();
	}

	/**
	* Returns <code>true</code> if this recruitment process is a draft.
	*
	* @return <code>true</code> if this recruitment process is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _recruitmentProcess.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _recruitmentProcess.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this recruitment process is expired.
	*
	* @return <code>true</code> if this recruitment process is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _recruitmentProcess.isExpired();
	}

	/**
	* Returns <code>true</code> if this recruitment process is inactive.
	*
	* @return <code>true</code> if this recruitment process is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _recruitmentProcess.isInactive();
	}

	/**
	* Returns <code>true</code> if this recruitment process is incomplete.
	*
	* @return <code>true</code> if this recruitment process is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _recruitmentProcess.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this recruitment process is is selected.
	*
	* @return <code>true</code> if this recruitment process is is selected; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsSelected() {
		return _recruitmentProcess.isIsSelected();
	}

	@Override
	public boolean isNew() {
		return _recruitmentProcess.isNew();
	}

	/**
	* Returns <code>true</code> if this recruitment process is pending.
	*
	* @return <code>true</code> if this recruitment process is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _recruitmentProcess.isPending();
	}

	/**
	* Returns <code>true</code> if this recruitment process is scheduled.
	*
	* @return <code>true</code> if this recruitment process is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _recruitmentProcess.isScheduled();
	}

	@Override
	public void persist() {
		_recruitmentProcess.persist();
	}

	/**
	* Sets the apply candidate ID of this recruitment process.
	*
	* @param applyCandidateId the apply candidate ID of this recruitment process
	*/
	@Override
	public void setApplyCandidateId(long applyCandidateId) {
		_recruitmentProcess.setApplyCandidateId(applyCandidateId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_recruitmentProcess.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this recruitment process.
	*
	* @param createDate the create date of this recruitment process
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_recruitmentProcess.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this recruitment process.
	*
	* @param createdBy the created by of this recruitment process
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_recruitmentProcess.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_recruitmentProcess.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_recruitmentProcess.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_recruitmentProcess.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entry ID of this recruitment process.
	*
	* @param fileEntryId the file entry ID of this recruitment process
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_recruitmentProcess.setFileEntryId(fileEntryId);
	}

	/**
	* Sets the group ID of this recruitment process.
	*
	* @param groupId the group ID of this recruitment process
	*/
	@Override
	public void setGroupId(long groupId) {
		_recruitmentProcess.setGroupId(groupId);
	}

	/**
	* Sets the hr remarks of this recruitment process.
	*
	* @param hrRemarks the hr remarks of this recruitment process
	*/
	@Override
	public void setHrRemarks(String hrRemarks) {
		_recruitmentProcess.setHrRemarks(hrRemarks);
	}

	/**
	* Sets the interview date of this recruitment process.
	*
	* @param interviewDate the interview date of this recruitment process
	*/
	@Override
	public void setInterviewDate(Date interviewDate) {
		_recruitmentProcess.setInterviewDate(interviewDate);
	}

	/**
	* Sets the interviewer ID of this recruitment process.
	*
	* @param interviewerId the interviewer ID of this recruitment process
	*/
	@Override
	public void setInterviewerId(long interviewerId) {
		_recruitmentProcess.setInterviewerId(interviewerId);
	}

	/**
	* Sets the interviewer remarks of this recruitment process.
	*
	* @param interviewerRemarks the interviewer remarks of this recruitment process
	*/
	@Override
	public void setInterviewerRemarks(String interviewerRemarks) {
		_recruitmentProcess.setInterviewerRemarks(interviewerRemarks);
	}

	/**
	* Sets the interview time of this recruitment process.
	*
	* @param interviewTime the interview time of this recruitment process
	*/
	@Override
	public void setInterviewTime(String interviewTime) {
		_recruitmentProcess.setInterviewTime(interviewTime);
	}

	/**
	* Sets whether this recruitment process is is selected.
	*
	* @param isSelected the is selected of this recruitment process
	*/
	@Override
	public void setIsSelected(boolean isSelected) {
		_recruitmentProcess.setIsSelected(isSelected);
	}

	/**
	* Sets the job post ID of this recruitment process.
	*
	* @param jobPostId the job post ID of this recruitment process
	*/
	@Override
	public void setJobPostId(long jobPostId) {
		_recruitmentProcess.setJobPostId(jobPostId);
	}

	/**
	* Sets the modified date of this recruitment process.
	*
	* @param modifiedDate the modified date of this recruitment process
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_recruitmentProcess.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_recruitmentProcess.setNew(n);
	}

	/**
	* Sets the primary key of this recruitment process.
	*
	* @param primaryKey the primary key of this recruitment process
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_recruitmentProcess.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_recruitmentProcess.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the recruitment process ID of this recruitment process.
	*
	* @param recruitmentProcessId the recruitment process ID of this recruitment process
	*/
	@Override
	public void setRecruitmentProcessId(long recruitmentProcessId) {
		_recruitmentProcess.setRecruitmentProcessId(recruitmentProcessId);
	}

	/**
	* Sets the status of this recruitment process.
	*
	* @param status the status of this recruitment process
	*/
	@Override
	public void setStatus(int status) {
		_recruitmentProcess.setStatus(status);
	}

	/**
	* Sets the status by user ID of this recruitment process.
	*
	* @param statusByUserId the status by user ID of this recruitment process
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_recruitmentProcess.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this recruitment process.
	*
	* @param statusByUserName the status by user name of this recruitment process
	*/
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_recruitmentProcess.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this recruitment process.
	*
	* @param statusByUserUuid the status by user uuid of this recruitment process
	*/
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_recruitmentProcess.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this recruitment process.
	*
	* @param statusDate the status date of this recruitment process
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_recruitmentProcess.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this recruitment process.
	*
	* @param userId the user ID of this recruitment process
	*/
	@Override
	public void setUserId(long userId) {
		_recruitmentProcess.setUserId(userId);
	}

	/**
	* Sets the user uuid of this recruitment process.
	*
	* @param userUuid the user uuid of this recruitment process
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_recruitmentProcess.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<RecruitmentProcess> toCacheModel() {
		return _recruitmentProcess.toCacheModel();
	}

	@Override
	public RecruitmentProcess toEscapedModel() {
		return new RecruitmentProcessWrapper(_recruitmentProcess.toEscapedModel());
	}

	@Override
	public String toString() {
		return _recruitmentProcess.toString();
	}

	@Override
	public RecruitmentProcess toUnescapedModel() {
		return new RecruitmentProcessWrapper(_recruitmentProcess.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _recruitmentProcess.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RecruitmentProcessWrapper)) {
			return false;
		}

		RecruitmentProcessWrapper recruitmentProcessWrapper = (RecruitmentProcessWrapper)obj;

		if (Objects.equals(_recruitmentProcess,
					recruitmentProcessWrapper._recruitmentProcess)) {
			return true;
		}

		return false;
	}

	@Override
	public RecruitmentProcess getWrappedModel() {
		return _recruitmentProcess;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _recruitmentProcess.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _recruitmentProcess.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_recruitmentProcess.resetOriginalValues();
	}

	private final RecruitmentProcess _recruitmentProcess;
}