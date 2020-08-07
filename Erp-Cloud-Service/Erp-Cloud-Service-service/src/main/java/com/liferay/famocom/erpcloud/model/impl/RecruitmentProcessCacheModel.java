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

package com.liferay.famocom.erpcloud.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.RecruitmentProcess;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RecruitmentProcess in entity cache.
 *
 * @author Samaresh
 * @see RecruitmentProcess
 * @generated
 */
@ProviderType
public class RecruitmentProcessCacheModel implements CacheModel<RecruitmentProcess>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RecruitmentProcessCacheModel)) {
			return false;
		}

		RecruitmentProcessCacheModel recruitmentProcessCacheModel = (RecruitmentProcessCacheModel)obj;

		if (recruitmentProcessId == recruitmentProcessCacheModel.recruitmentProcessId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, recruitmentProcessId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{recruitmentProcessId=");
		sb.append(recruitmentProcessId);
		sb.append(", applyCandidateId=");
		sb.append(applyCandidateId);
		sb.append(", interviewDate=");
		sb.append(interviewDate);
		sb.append(", interviewTime=");
		sb.append(interviewTime);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", interviewerRemarks=");
		sb.append(interviewerRemarks);
		sb.append(", hrRemarks=");
		sb.append(hrRemarks);
		sb.append(", isSelected=");
		sb.append(isSelected);
		sb.append(", interviewerId=");
		sb.append(interviewerId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", jobPostId=");
		sb.append(jobPostId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RecruitmentProcess toEntityModel() {
		RecruitmentProcessImpl recruitmentProcessImpl = new RecruitmentProcessImpl();

		recruitmentProcessImpl.setRecruitmentProcessId(recruitmentProcessId);
		recruitmentProcessImpl.setApplyCandidateId(applyCandidateId);

		if (interviewDate == Long.MIN_VALUE) {
			recruitmentProcessImpl.setInterviewDate(null);
		}
		else {
			recruitmentProcessImpl.setInterviewDate(new Date(interviewDate));
		}

		if (interviewTime == null) {
			recruitmentProcessImpl.setInterviewTime("");
		}
		else {
			recruitmentProcessImpl.setInterviewTime(interviewTime);
		}

		recruitmentProcessImpl.setFileEntryId(fileEntryId);

		if (createDate == Long.MIN_VALUE) {
			recruitmentProcessImpl.setCreateDate(null);
		}
		else {
			recruitmentProcessImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			recruitmentProcessImpl.setModifiedDate(null);
		}
		else {
			recruitmentProcessImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (interviewerRemarks == null) {
			recruitmentProcessImpl.setInterviewerRemarks("");
		}
		else {
			recruitmentProcessImpl.setInterviewerRemarks(interviewerRemarks);
		}

		if (hrRemarks == null) {
			recruitmentProcessImpl.setHrRemarks("");
		}
		else {
			recruitmentProcessImpl.setHrRemarks(hrRemarks);
		}

		recruitmentProcessImpl.setIsSelected(isSelected);
		recruitmentProcessImpl.setInterviewerId(interviewerId);
		recruitmentProcessImpl.setCreatedBy(createdBy);
		recruitmentProcessImpl.setJobPostId(jobPostId);
		recruitmentProcessImpl.setGroupId(groupId);
		recruitmentProcessImpl.setStatus(status);
		recruitmentProcessImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			recruitmentProcessImpl.setStatusByUserName("");
		}
		else {
			recruitmentProcessImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			recruitmentProcessImpl.setStatusDate(null);
		}
		else {
			recruitmentProcessImpl.setStatusDate(new Date(statusDate));
		}

		recruitmentProcessImpl.setUserId(userId);

		recruitmentProcessImpl.resetOriginalValues();

		return recruitmentProcessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		recruitmentProcessId = objectInput.readLong();

		applyCandidateId = objectInput.readLong();
		interviewDate = objectInput.readLong();
		interviewTime = objectInput.readUTF();

		fileEntryId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		interviewerRemarks = objectInput.readUTF();
		hrRemarks = objectInput.readUTF();

		isSelected = objectInput.readBoolean();

		interviewerId = objectInput.readLong();

		createdBy = objectInput.readLong();

		jobPostId = objectInput.readLong();

		groupId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(recruitmentProcessId);

		objectOutput.writeLong(applyCandidateId);
		objectOutput.writeLong(interviewDate);

		if (interviewTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(interviewTime);
		}

		objectOutput.writeLong(fileEntryId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (interviewerRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(interviewerRemarks);
		}

		if (hrRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hrRemarks);
		}

		objectOutput.writeBoolean(isSelected);

		objectOutput.writeLong(interviewerId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(jobPostId);

		objectOutput.writeLong(groupId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(userId);
	}

	public long recruitmentProcessId;
	public long applyCandidateId;
	public long interviewDate;
	public String interviewTime;
	public long fileEntryId;
	public long createDate;
	public long modifiedDate;
	public String interviewerRemarks;
	public String hrRemarks;
	public boolean isSelected;
	public long interviewerId;
	public long createdBy;
	public long jobPostId;
	public long groupId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long userId;
}