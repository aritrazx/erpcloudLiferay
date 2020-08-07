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

import com.liferay.famocom.erpcloud.model.JobEvaluation;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobEvaluation in entity cache.
 *
 * @author Samaresh
 * @see JobEvaluation
 * @generated
 */
@ProviderType
public class JobEvaluationCacheModel implements CacheModel<JobEvaluation>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobEvaluationCacheModel)) {
			return false;
		}

		JobEvaluationCacheModel jobEvaluationCacheModel = (JobEvaluationCacheModel)obj;

		if (postEvaluationId == jobEvaluationCacheModel.postEvaluationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, postEvaluationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{postEvaluationId=");
		sb.append(postEvaluationId);
		sb.append(", jobPostId=");
		sb.append(jobPostId);
		sb.append(", evaluationName=");
		sb.append(evaluationName);
		sb.append(", evaluationDescription=");
		sb.append(evaluationDescription);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobEvaluation toEntityModel() {
		JobEvaluationImpl jobEvaluationImpl = new JobEvaluationImpl();

		jobEvaluationImpl.setPostEvaluationId(postEvaluationId);
		jobEvaluationImpl.setJobPostId(jobPostId);

		if (evaluationName == null) {
			jobEvaluationImpl.setEvaluationName("");
		}
		else {
			jobEvaluationImpl.setEvaluationName(evaluationName);
		}

		if (evaluationDescription == null) {
			jobEvaluationImpl.setEvaluationDescription("");
		}
		else {
			jobEvaluationImpl.setEvaluationDescription(evaluationDescription);
		}

		if (createdDate == Long.MIN_VALUE) {
			jobEvaluationImpl.setCreatedDate(null);
		}
		else {
			jobEvaluationImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobEvaluationImpl.setModifiedDate(null);
		}
		else {
			jobEvaluationImpl.setModifiedDate(new Date(modifiedDate));
		}

		jobEvaluationImpl.resetOriginalValues();

		return jobEvaluationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		postEvaluationId = objectInput.readLong();

		jobPostId = objectInput.readLong();
		evaluationName = objectInput.readUTF();
		evaluationDescription = objectInput.readUTF();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(postEvaluationId);

		objectOutput.writeLong(jobPostId);

		if (evaluationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(evaluationName);
		}

		if (evaluationDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(evaluationDescription);
		}

		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long postEvaluationId;
	public long jobPostId;
	public String evaluationName;
	public String evaluationDescription;
	public long createdDate;
	public long modifiedDate;
}