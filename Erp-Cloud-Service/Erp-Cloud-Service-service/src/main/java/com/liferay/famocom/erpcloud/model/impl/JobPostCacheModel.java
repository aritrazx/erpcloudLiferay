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

import com.liferay.famocom.erpcloud.model.JobPost;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobPost in entity cache.
 *
 * @author Samaresh
 * @see JobPost
 * @generated
 */
@ProviderType
public class JobPostCacheModel implements CacheModel<JobPost>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobPostCacheModel)) {
			return false;
		}

		JobPostCacheModel jobPostCacheModel = (JobPostCacheModel)obj;

		if (jobPostId == jobPostCacheModel.jobPostId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, jobPostId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{jobPostId=");
		sb.append(jobPostId);
		sb.append(", postName=");
		sb.append(postName);
		sb.append(", postDescription=");
		sb.append(postDescription);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobPost toEntityModel() {
		JobPostImpl jobPostImpl = new JobPostImpl();

		jobPostImpl.setJobPostId(jobPostId);

		if (postName == null) {
			jobPostImpl.setPostName("");
		}
		else {
			jobPostImpl.setPostName(postName);
		}

		if (postDescription == null) {
			jobPostImpl.setPostDescription("");
		}
		else {
			jobPostImpl.setPostDescription(postDescription);
		}

		if (createdDate == Long.MIN_VALUE) {
			jobPostImpl.setCreatedDate(null);
		}
		else {
			jobPostImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobPostImpl.setModifiedDate(null);
		}
		else {
			jobPostImpl.setModifiedDate(new Date(modifiedDate));
		}

		jobPostImpl.resetOriginalValues();

		return jobPostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobPostId = objectInput.readLong();
		postName = objectInput.readUTF();
		postDescription = objectInput.readUTF();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jobPostId);

		if (postName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postName);
		}

		if (postDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postDescription);
		}

		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long jobPostId;
	public String postName;
	public String postDescription;
	public long createdDate;
	public long modifiedDate;
}