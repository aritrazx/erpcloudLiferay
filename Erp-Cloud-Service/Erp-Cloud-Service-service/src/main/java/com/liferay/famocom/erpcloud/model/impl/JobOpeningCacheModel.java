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

import com.liferay.famocom.erpcloud.model.JobOpening;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobOpening in entity cache.
 *
 * @author Samaresh
 * @see JobOpening
 * @generated
 */
@ProviderType
public class JobOpeningCacheModel implements CacheModel<JobOpening>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobOpeningCacheModel)) {
			return false;
		}

		JobOpeningCacheModel jobOpeningCacheModel = (JobOpeningCacheModel)obj;

		if (jobOpeningId == jobOpeningCacheModel.jobOpeningId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, jobOpeningId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{jobOpeningId=");
		sb.append(jobOpeningId);
		sb.append(", jobPostId=");
		sb.append(jobPostId);
		sb.append(", openingFor=");
		sb.append(openingFor);
		sb.append(", description=");
		sb.append(description);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobOpening toEntityModel() {
		JobOpeningImpl jobOpeningImpl = new JobOpeningImpl();

		jobOpeningImpl.setJobOpeningId(jobOpeningId);
		jobOpeningImpl.setJobPostId(jobPostId);

		if (openingFor == null) {
			jobOpeningImpl.setOpeningFor("");
		}
		else {
			jobOpeningImpl.setOpeningFor(openingFor);
		}

		if (description == null) {
			jobOpeningImpl.setDescription("");
		}
		else {
			jobOpeningImpl.setDescription(description);
		}

		if (createdDate == Long.MIN_VALUE) {
			jobOpeningImpl.setCreatedDate(null);
		}
		else {
			jobOpeningImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobOpeningImpl.setModifiedDate(null);
		}
		else {
			jobOpeningImpl.setModifiedDate(new Date(modifiedDate));
		}

		jobOpeningImpl.setStatus(status);

		jobOpeningImpl.resetOriginalValues();

		return jobOpeningImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobOpeningId = objectInput.readLong();

		jobPostId = objectInput.readLong();
		openingFor = objectInput.readUTF();
		description = objectInput.readUTF();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jobOpeningId);

		objectOutput.writeLong(jobPostId);

		if (openingFor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(openingFor);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);
	}

	public long jobOpeningId;
	public long jobPostId;
	public String openingFor;
	public String description;
	public long createdDate;
	public long modifiedDate;
	public int status;
}