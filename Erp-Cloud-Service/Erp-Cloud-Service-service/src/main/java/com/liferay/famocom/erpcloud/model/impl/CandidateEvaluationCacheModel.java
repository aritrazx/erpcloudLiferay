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

import com.liferay.famocom.erpcloud.model.CandidateEvaluation;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CandidateEvaluation in entity cache.
 *
 * @author Samaresh
 * @see CandidateEvaluation
 * @generated
 */
@ProviderType
public class CandidateEvaluationCacheModel implements CacheModel<CandidateEvaluation>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateEvaluationCacheModel)) {
			return false;
		}

		CandidateEvaluationCacheModel candidateEvaluationCacheModel = (CandidateEvaluationCacheModel)obj;

		if (candidateEvaluationId == candidateEvaluationCacheModel.candidateEvaluationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, candidateEvaluationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{candidateEvaluationId=");
		sb.append(candidateEvaluationId);
		sb.append(", interviewerId=");
		sb.append(interviewerId);
		sb.append(", jobPostId=");
		sb.append(jobPostId);
		sb.append(", postEvaluationId=");
		sb.append(postEvaluationId);
		sb.append(", applyCandidateId=");
		sb.append(applyCandidateId);
		sb.append(", interviewerRating=");
		sb.append(interviewerRating);
		sb.append(", interviewerRemarks=");
		sb.append(interviewerRemarks);
		sb.append(", hrRemarks=");
		sb.append(hrRemarks);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", recruitmentProcessId=");
		sb.append(recruitmentProcessId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CandidateEvaluation toEntityModel() {
		CandidateEvaluationImpl candidateEvaluationImpl = new CandidateEvaluationImpl();

		candidateEvaluationImpl.setCandidateEvaluationId(candidateEvaluationId);
		candidateEvaluationImpl.setInterviewerId(interviewerId);
		candidateEvaluationImpl.setJobPostId(jobPostId);
		candidateEvaluationImpl.setPostEvaluationId(postEvaluationId);
		candidateEvaluationImpl.setApplyCandidateId(applyCandidateId);
		candidateEvaluationImpl.setInterviewerRating(interviewerRating);

		if (interviewerRemarks == null) {
			candidateEvaluationImpl.setInterviewerRemarks("");
		}
		else {
			candidateEvaluationImpl.setInterviewerRemarks(interviewerRemarks);
		}

		if (hrRemarks == null) {
			candidateEvaluationImpl.setHrRemarks("");
		}
		else {
			candidateEvaluationImpl.setHrRemarks(hrRemarks);
		}

		if (createDate == Long.MIN_VALUE) {
			candidateEvaluationImpl.setCreateDate(null);
		}
		else {
			candidateEvaluationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			candidateEvaluationImpl.setModifiedDate(null);
		}
		else {
			candidateEvaluationImpl.setModifiedDate(new Date(modifiedDate));
		}

		candidateEvaluationImpl.setRecruitmentProcessId(recruitmentProcessId);

		candidateEvaluationImpl.resetOriginalValues();

		return candidateEvaluationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		candidateEvaluationId = objectInput.readLong();

		interviewerId = objectInput.readLong();

		jobPostId = objectInput.readLong();

		postEvaluationId = objectInput.readLong();

		applyCandidateId = objectInput.readLong();

		interviewerRating = objectInput.readInt();
		interviewerRemarks = objectInput.readUTF();
		hrRemarks = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		recruitmentProcessId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(candidateEvaluationId);

		objectOutput.writeLong(interviewerId);

		objectOutput.writeLong(jobPostId);

		objectOutput.writeLong(postEvaluationId);

		objectOutput.writeLong(applyCandidateId);

		objectOutput.writeInt(interviewerRating);

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

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(recruitmentProcessId);
	}

	public long candidateEvaluationId;
	public long interviewerId;
	public long jobPostId;
	public long postEvaluationId;
	public long applyCandidateId;
	public int interviewerRating;
	public String interviewerRemarks;
	public String hrRemarks;
	public long createDate;
	public long modifiedDate;
	public long recruitmentProcessId;
}