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

import com.liferay.famocom.erpcloud.model.BankMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BankMaster in entity cache.
 *
 * @author Samaresh
 * @see BankMaster
 * @generated
 */
@ProviderType
public class BankMasterCacheModel implements CacheModel<BankMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BankMasterCacheModel)) {
			return false;
		}

		BankMasterCacheModel bankMasterCacheModel = (BankMasterCacheModel)obj;

		if (bankId == bankMasterCacheModel.bankId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bankId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{bankId=");
		sb.append(bankId);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", branchName=");
		sb.append(branchName);
		sb.append(", address=");
		sb.append(address);
		sb.append(", ifscCode=");
		sb.append(ifscCode);
		sb.append(", status=");
		sb.append(status);
		sb.append(", bankType=");
		sb.append(bankType);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BankMaster toEntityModel() {
		BankMasterImpl bankMasterImpl = new BankMasterImpl();

		bankMasterImpl.setBankId(bankId);

		if (bankName == null) {
			bankMasterImpl.setBankName("");
		}
		else {
			bankMasterImpl.setBankName(bankName);
		}

		if (branchName == null) {
			bankMasterImpl.setBranchName("");
		}
		else {
			bankMasterImpl.setBranchName(branchName);
		}

		if (address == null) {
			bankMasterImpl.setAddress("");
		}
		else {
			bankMasterImpl.setAddress(address);
		}

		if (ifscCode == null) {
			bankMasterImpl.setIfscCode("");
		}
		else {
			bankMasterImpl.setIfscCode(ifscCode);
		}

		bankMasterImpl.setStatus(status);
		bankMasterImpl.setBankType(bankType);
		bankMasterImpl.setCreatedBy(createdBy);

		if (createDate == Long.MIN_VALUE) {
			bankMasterImpl.setCreateDate(null);
		}
		else {
			bankMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bankMasterImpl.setModifiedDate(null);
		}
		else {
			bankMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		bankMasterImpl.resetOriginalValues();

		return bankMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bankId = objectInput.readLong();
		bankName = objectInput.readUTF();
		branchName = objectInput.readUTF();
		address = objectInput.readUTF();
		ifscCode = objectInput.readUTF();

		status = objectInput.readInt();

		bankType = objectInput.readInt();

		createdBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bankId);

		if (bankName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		if (branchName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(branchName);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (ifscCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ifscCode);
		}

		objectOutput.writeInt(status);

		objectOutput.writeInt(bankType);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long bankId;
	public String bankName;
	public String branchName;
	public String address;
	public String ifscCode;
	public int status;
	public int bankType;
	public long createdBy;
	public long createDate;
	public long modifiedDate;
}