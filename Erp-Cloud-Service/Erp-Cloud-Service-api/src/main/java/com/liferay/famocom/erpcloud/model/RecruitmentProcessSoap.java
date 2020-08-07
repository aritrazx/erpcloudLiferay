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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.RecruitmentProcessServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.RecruitmentProcessServiceSoap
 * @generated
 */
@ProviderType
public class RecruitmentProcessSoap implements Serializable {
	public static RecruitmentProcessSoap toSoapModel(RecruitmentProcess model) {
		RecruitmentProcessSoap soapModel = new RecruitmentProcessSoap();

		soapModel.setRecruitmentProcessId(model.getRecruitmentProcessId());
		soapModel.setApplyCandidateId(model.getApplyCandidateId());
		soapModel.setInterviewDate(model.getInterviewDate());
		soapModel.setInterviewTime(model.getInterviewTime());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setInterviewerRemarks(model.getInterviewerRemarks());
		soapModel.setHrRemarks(model.getHrRemarks());
		soapModel.setIsSelected(model.isIsSelected());
		soapModel.setInterviewerId(model.getInterviewerId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setJobPostId(model.getJobPostId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static RecruitmentProcessSoap[] toSoapModels(
		RecruitmentProcess[] models) {
		RecruitmentProcessSoap[] soapModels = new RecruitmentProcessSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentProcessSoap[][] toSoapModels(
		RecruitmentProcess[][] models) {
		RecruitmentProcessSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RecruitmentProcessSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RecruitmentProcessSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentProcessSoap[] toSoapModels(
		List<RecruitmentProcess> models) {
		List<RecruitmentProcessSoap> soapModels = new ArrayList<RecruitmentProcessSoap>(models.size());

		for (RecruitmentProcess model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RecruitmentProcessSoap[soapModels.size()]);
	}

	public RecruitmentProcessSoap() {
	}

	public long getPrimaryKey() {
		return _recruitmentProcessId;
	}

	public void setPrimaryKey(long pk) {
		setRecruitmentProcessId(pk);
	}

	public long getRecruitmentProcessId() {
		return _recruitmentProcessId;
	}

	public void setRecruitmentProcessId(long recruitmentProcessId) {
		_recruitmentProcessId = recruitmentProcessId;
	}

	public long getApplyCandidateId() {
		return _applyCandidateId;
	}

	public void setApplyCandidateId(long applyCandidateId) {
		_applyCandidateId = applyCandidateId;
	}

	public Date getInterviewDate() {
		return _interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		_interviewDate = interviewDate;
	}

	public String getInterviewTime() {
		return _interviewTime;
	}

	public void setInterviewTime(String interviewTime) {
		_interviewTime = interviewTime;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getInterviewerRemarks() {
		return _interviewerRemarks;
	}

	public void setInterviewerRemarks(String interviewerRemarks) {
		_interviewerRemarks = interviewerRemarks;
	}

	public String getHrRemarks() {
		return _hrRemarks;
	}

	public void setHrRemarks(String hrRemarks) {
		_hrRemarks = hrRemarks;
	}

	public boolean getIsSelected() {
		return _isSelected;
	}

	public boolean isIsSelected() {
		return _isSelected;
	}

	public void setIsSelected(boolean isSelected) {
		_isSelected = isSelected;
	}

	public long getInterviewerId() {
		return _interviewerId;
	}

	public void setInterviewerId(long interviewerId) {
		_interviewerId = interviewerId;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public long getJobPostId() {
		return _jobPostId;
	}

	public void setJobPostId(long jobPostId) {
		_jobPostId = jobPostId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _recruitmentProcessId;
	private long _applyCandidateId;
	private Date _interviewDate;
	private String _interviewTime;
	private long _fileEntryId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _interviewerRemarks;
	private String _hrRemarks;
	private boolean _isSelected;
	private long _interviewerId;
	private long _createdBy;
	private long _jobPostId;
	private long _groupId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _userId;
}