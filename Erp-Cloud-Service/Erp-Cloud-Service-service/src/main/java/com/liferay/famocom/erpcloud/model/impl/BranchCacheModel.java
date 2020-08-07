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

import com.liferay.famocom.erpcloud.model.Branch;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Branch in entity cache.
 *
 * @author Samaresh
 * @see Branch
 * @generated
 */
@ProviderType
public class BranchCacheModel implements CacheModel<Branch>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BranchCacheModel)) {
			return false;
		}

		BranchCacheModel branchCacheModel = (BranchCacheModel)obj;

		if (branchId == branchCacheModel.branchId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, branchId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{branchId=");
		sb.append(branchId);
		sb.append(", branchName=");
		sb.append(branchName);
		sb.append(", branchAddress=");
		sb.append(branchAddress);
		sb.append(", status=");
		sb.append(status);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdById=");
		sb.append(createdById);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Branch toEntityModel() {
		BranchImpl branchImpl = new BranchImpl();

		branchImpl.setBranchId(branchId);

		if (branchName == null) {
			branchImpl.setBranchName("");
		}
		else {
			branchImpl.setBranchName(branchName);
		}

		if (branchAddress == null) {
			branchImpl.setBranchAddress("");
		}
		else {
			branchImpl.setBranchAddress(branchAddress);
		}

		branchImpl.setStatus(status);

		if (modifiedDate == Long.MIN_VALUE) {
			branchImpl.setModifiedDate(null);
		}
		else {
			branchImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (createDate == Long.MIN_VALUE) {
			branchImpl.setCreateDate(null);
		}
		else {
			branchImpl.setCreateDate(new Date(createDate));
		}

		branchImpl.setCreatedById(createdById);

		branchImpl.resetOriginalValues();

		return branchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		branchId = objectInput.readLong();
		branchName = objectInput.readUTF();
		branchAddress = objectInput.readUTF();

		status = objectInput.readInt();
		modifiedDate = objectInput.readLong();
		createDate = objectInput.readLong();

		createdById = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(branchId);

		if (branchName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(branchName);
		}

		if (branchAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(branchAddress);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdById);
	}

	public long branchId;
	public String branchName;
	public String branchAddress;
	public int status;
	public long modifiedDate;
	public long createDate;
	public long createdById;
}