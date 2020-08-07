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

import com.liferay.famocom.erpcloud.model.Milestone;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Milestone in entity cache.
 *
 * @author Samaresh
 * @see Milestone
 * @generated
 */
@ProviderType
public class MilestoneCacheModel implements CacheModel<Milestone>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MilestoneCacheModel)) {
			return false;
		}

		MilestoneCacheModel milestoneCacheModel = (MilestoneCacheModel)obj;

		if (milestoneId == milestoneCacheModel.milestoneId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, milestoneId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{milestoneId=");
		sb.append(milestoneId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Milestone toEntityModel() {
		MilestoneImpl milestoneImpl = new MilestoneImpl();

		milestoneImpl.setMilestoneId(milestoneId);
		milestoneImpl.setProjectId(projectId);
		milestoneImpl.setClientId(clientId);

		if (milestoneName == null) {
			milestoneImpl.setMilestoneName("");
		}
		else {
			milestoneImpl.setMilestoneName(milestoneName);
		}

		if (dueDate == Long.MIN_VALUE) {
			milestoneImpl.setDueDate(null);
		}
		else {
			milestoneImpl.setDueDate(new Date(dueDate));
		}

		milestoneImpl.setCheckGST(checkGST);
		milestoneImpl.setAmount(amount);
		milestoneImpl.setStatus(status);

		milestoneImpl.resetOriginalValues();

		return milestoneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		milestoneId = objectInput.readLong();

		projectId = objectInput.readLong();

		clientId = objectInput.readLong();
		milestoneName = objectInput.readUTF();
		dueDate = objectInput.readLong();

		checkGST = objectInput.readInt();

		amount = objectInput.readDouble();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(milestoneId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(clientId);

		if (milestoneName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(milestoneName);
		}

		objectOutput.writeLong(dueDate);

		objectOutput.writeInt(checkGST);

		objectOutput.writeDouble(amount);

		objectOutput.writeInt(status);
	}

	public long milestoneId;
	public long projectId;
	public long clientId;
	public String milestoneName;
	public long dueDate;
	public int checkGST;
	public double amount;
	public int status;
}