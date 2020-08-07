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

import com.liferay.famocom.erpcloud.model.WorkFromHome;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkFromHome in entity cache.
 *
 * @author Samaresh
 * @see WorkFromHome
 * @generated
 */
@ProviderType
public class WorkFromHomeCacheModel implements CacheModel<WorkFromHome>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkFromHomeCacheModel)) {
			return false;
		}

		WorkFromHomeCacheModel workFromHomeCacheModel = (WorkFromHomeCacheModel)obj;

		if (workFromHomeId == workFromHomeCacheModel.workFromHomeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workFromHomeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{workFromHomeId=");
		sb.append(workFromHomeId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", appliedDate=");
		sb.append(appliedDate);
		sb.append(", description=");
		sb.append(description);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", workStatus=");
		sb.append(workStatus);
		sb.append(", hrComments=");
		sb.append(hrComments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkFromHome toEntityModel() {
		WorkFromHomeImpl workFromHomeImpl = new WorkFromHomeImpl();

		workFromHomeImpl.setWorkFromHomeId(workFromHomeId);
		workFromHomeImpl.setEmployeeId(employeeId);
		workFromHomeImpl.setCompanyId(companyId);
		workFromHomeImpl.setProjectId(projectId);

		if (appliedDate == Long.MIN_VALUE) {
			workFromHomeImpl.setAppliedDate(null);
		}
		else {
			workFromHomeImpl.setAppliedDate(new Date(appliedDate));
		}

		if (description == null) {
			workFromHomeImpl.setDescription("");
		}
		else {
			workFromHomeImpl.setDescription(description);
		}

		if (createDate == Long.MIN_VALUE) {
			workFromHomeImpl.setCreateDate(null);
		}
		else {
			workFromHomeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workFromHomeImpl.setModifiedDate(null);
		}
		else {
			workFromHomeImpl.setModifiedDate(new Date(modifiedDate));
		}

		workFromHomeImpl.setWorkStatus(workStatus);

		if (hrComments == null) {
			workFromHomeImpl.setHrComments("");
		}
		else {
			workFromHomeImpl.setHrComments(hrComments);
		}

		workFromHomeImpl.resetOriginalValues();

		return workFromHomeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workFromHomeId = objectInput.readLong();

		employeeId = objectInput.readLong();

		companyId = objectInput.readLong();

		projectId = objectInput.readLong();
		appliedDate = objectInput.readLong();
		description = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		workStatus = objectInput.readInt();
		hrComments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workFromHomeId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(projectId);
		objectOutput.writeLong(appliedDate);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(workStatus);

		if (hrComments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hrComments);
		}
	}

	public long workFromHomeId;
	public long employeeId;
	public long companyId;
	public long projectId;
	public long appliedDate;
	public String description;
	public long createDate;
	public long modifiedDate;
	public int workStatus;
	public String hrComments;
}