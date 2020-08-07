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

import com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CandidatePayStructureMaster in entity cache.
 *
 * @author Samaresh
 * @see CandidatePayStructureMaster
 * @generated
 */
@ProviderType
public class CandidatePayStructureMasterCacheModel implements CacheModel<CandidatePayStructureMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidatePayStructureMasterCacheModel)) {
			return false;
		}

		CandidatePayStructureMasterCacheModel candidatePayStructureMasterCacheModel =
			(CandidatePayStructureMasterCacheModel)obj;

		if (candidatePayStructureMasterId == candidatePayStructureMasterCacheModel.candidatePayStructureMasterId) {
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
	public CandidatePayStructureMaster toEntityModel() {
		CandidatePayStructureMasterImpl candidatePayStructureMasterImpl = new CandidatePayStructureMasterImpl();

		candidatePayStructureMasterImpl.setCandidatePayStructureMasterId(candidatePayStructureMasterId);
		candidatePayStructureMasterImpl.setRecruitmentProcessId(recruitmentProcessId);
		candidatePayStructureMasterImpl.setTotalAmount(totalAmount);
		candidatePayStructureMasterImpl.setTotalBonus(totalBonus);
		candidatePayStructureMasterImpl.setPayMasterStatus(payMasterStatus);

		if (joiningDate == Long.MIN_VALUE) {
			candidatePayStructureMasterImpl.setJoiningDate(null);
		}
		else {
			candidatePayStructureMasterImpl.setJoiningDate(new Date(joiningDate));
		}

		if (candidateBond == null) {
			candidatePayStructureMasterImpl.setCandidateBond("");
		}
		else {
			candidatePayStructureMasterImpl.setCandidateBond(candidateBond);
		}

		if (createDate == Long.MIN_VALUE) {
			candidatePayStructureMasterImpl.setCreateDate(null);
		}
		else {
			candidatePayStructureMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			candidatePayStructureMasterImpl.setModifiedDate(null);
		}
		else {
			candidatePayStructureMasterImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		candidatePayStructureMasterImpl.resetOriginalValues();

		return candidatePayStructureMasterImpl;
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
			objectOutput.writeUTF("");
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