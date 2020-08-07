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

import com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster;

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
 * The cache model class for representing SelectedCandidatePayStructureMaster in entity cache.
 *
 * @author Samaresh
 * @see SelectedCandidatePayStructureMaster
 * @generated
 */
@ProviderType
public class SelectedCandidatePayStructureMasterCacheModel implements CacheModel<SelectedCandidatePayStructureMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SelectedCandidatePayStructureMasterCacheModel)) {
			return false;
		}

		SelectedCandidatePayStructureMasterCacheModel selectedCandidatePayStructureMasterCacheModel =
			(SelectedCandidatePayStructureMasterCacheModel)obj;

		if (candidatePayStructureMasterId == selectedCandidatePayStructureMasterCacheModel.candidatePayStructureMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, candidatePayStructureMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{candidatePayStructureMasterId=");
		sb.append(candidatePayStructureMasterId);
		sb.append(", recruitmentProcessId=");
		sb.append(recruitmentProcessId);
		sb.append(", totalAmount=");
		sb.append(totalAmount);
		sb.append(", totalBonus=");
		sb.append(totalBonus);
		sb.append(", payMasterStatus=");
		sb.append(payMasterStatus);
		sb.append(", joiningDate=");
		sb.append(joiningDate);
		sb.append(", candidateBond=");
		sb.append(candidateBond);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SelectedCandidatePayStructureMaster toEntityModel() {
		SelectedCandidatePayStructureMasterImpl selectedCandidatePayStructureMasterImpl =
			new SelectedCandidatePayStructureMasterImpl();

		selectedCandidatePayStructureMasterImpl.setCandidatePayStructureMasterId(candidatePayStructureMasterId);
		selectedCandidatePayStructureMasterImpl.setRecruitmentProcessId(recruitmentProcessId);
		selectedCandidatePayStructureMasterImpl.setTotalAmount(totalAmount);
		selectedCandidatePayStructureMasterImpl.setTotalBonus(totalBonus);
		selectedCandidatePayStructureMasterImpl.setPayMasterStatus(payMasterStatus);

		if (joiningDate == Long.MIN_VALUE) {
			selectedCandidatePayStructureMasterImpl.setJoiningDate(null);
		}
		else {
			selectedCandidatePayStructureMasterImpl.setJoiningDate(new Date(
					joiningDate));
		}

		if (candidateBond == null) {
			selectedCandidatePayStructureMasterImpl.setCandidateBond(StringPool.BLANK);
		}
		else {
			selectedCandidatePayStructureMasterImpl.setCandidateBond(candidateBond);
		}

		if (createDate == Long.MIN_VALUE) {
			selectedCandidatePayStructureMasterImpl.setCreateDate(null);
		}
		else {
			selectedCandidatePayStructureMasterImpl.setCreateDate(new Date(
					createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			selectedCandidatePayStructureMasterImpl.setModifiedDate(null);
		}
		else {
			selectedCandidatePayStructureMasterImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		selectedCandidatePayStructureMasterImpl.resetOriginalValues();

		return selectedCandidatePayStructureMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		candidatePayStructureMasterId = objectInput.readLong();

		recruitmentProcessId = objectInput.readLong();

		totalAmount = objectInput.readDouble();

		totalBonus = objectInput.readDouble();

		payMasterStatus = objectInput.readInt();
		joiningDate = objectInput.readLong();
		candidateBond = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(candidatePayStructureMasterId);

		objectOutput.writeLong(recruitmentProcessId);

		objectOutput.writeDouble(totalAmount);

		objectOutput.writeDouble(totalBonus);

		objectOutput.writeInt(payMasterStatus);
		objectOutput.writeLong(joiningDate);

		if (candidateBond == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(candidateBond);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long candidatePayStructureMasterId;
	public long recruitmentProcessId;
	public double totalAmount;
	public double totalBonus;
	public int payMasterStatus;
	public long joiningDate;
	public String candidateBond;
	public long createDate;
	public long modifiedDate;
}