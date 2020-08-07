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

import com.liferay.famocom.erpcloud.model.BillingTable;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BillingTable in entity cache.
 *
 * @author Samaresh
 * @see BillingTable
 * @generated
 */
@ProviderType
public class BillingTableCacheModel implements CacheModel<BillingTable>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BillingTableCacheModel)) {
			return false;
		}

		BillingTableCacheModel billingTableCacheModel = (BillingTableCacheModel)obj;

		if (billingId == billingTableCacheModel.billingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, billingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{billingId=");
		sb.append(billingId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", milestoneName=");
		sb.append(milestoneName);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", checkGST=");
		sb.append(checkGST);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BillingTable toEntityModel() {
		BillingTableImpl billingTableImpl = new BillingTableImpl();

		billingTableImpl.setBillingId(billingId);
		billingTableImpl.setProjectId(projectId);
		billingTableImpl.setClientId(clientId);

		if (milestoneName == null) {
			billingTableImpl.setMilestoneName(StringPool.BLANK);
		}
		else {
			billingTableImpl.setMilestoneName(milestoneName);
		}

		if (dueDate == Long.MIN_VALUE) {
			billingTableImpl.setDueDate(null);
		}
		else {
			billingTableImpl.setDueDate(new Date(dueDate));
		}

		billingTableImpl.setCheckGST(checkGST);
		billingTableImpl.setAmount(amount);
		billingTableImpl.setFileId(fileId);

		if (fileName == null) {
			billingTableImpl.setFileName(StringPool.BLANK);
		}
		else {
			billingTableImpl.setFileName(fileName);
		}

		billingTableImpl.setStatus(status);

		billingTableImpl.resetOriginalValues();

		return billingTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		billingId = objectInput.readLong();

		projectId = objectInput.readLong();

		clientId = objectInput.readLong();
		milestoneName = objectInput.readUTF();
		dueDate = objectInput.readLong();

		checkGST = objectInput.readInt();

		amount = objectInput.readDouble();

		fileId = objectInput.readLong();
		fileName = objectInput.readUTF();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(billingId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(clientId);

		if (milestoneName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(milestoneName);
		}

		objectOutput.writeLong(dueDate);

		objectOutput.writeInt(checkGST);

		objectOutput.writeDouble(amount);

		objectOutput.writeLong(fileId);

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		objectOutput.writeInt(status);
	}

	public long billingId;
	public long projectId;
	public long clientId;
	public String milestoneName;
	public long dueDate;
	public int checkGST;
	public double amount;
	public long fileId;
	public String fileName;
	public int status;
}