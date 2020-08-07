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

import com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SelectedCandidatePayStructure in entity cache.
 *
 * @author Samaresh
 * @see SelectedCandidatePayStructure
 * @generated
 */
@ProviderType
public class SelectedCandidatePayStructureCacheModel implements CacheModel<SelectedCandidatePayStructure>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SelectedCandidatePayStructureCacheModel)) {
			return false;
		}

		SelectedCandidatePayStructureCacheModel selectedCandidatePayStructureCacheModel =
			(SelectedCandidatePayStructureCacheModel)obj;

		if (candidatePayStructureId == selectedCandidatePayStructureCacheModel.candidatePayStructureId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, candidatePayStructureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{candidatePayStructureId=");
		sb.append(candidatePayStructureId);
		sb.append(", payComponentId=");
		sb.append(payComponentId);
		sb.append(", componentValue=");
		sb.append(componentValue);
		sb.append(", recruitmentProcessId=");
		sb.append(recruitmentProcessId);
		sb.append(", payStatus=");
		sb.append(payStatus);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SelectedCandidatePayStructure toEntityModel() {
		SelectedCandidatePayStructureImpl selectedCandidatePayStructureImpl = new SelectedCandidatePayStructureImpl();

		selectedCandidatePayStructureImpl.setCandidatePayStructureId(candidatePayStructureId);
		selectedCandidatePayStructureImpl.setPayComponentId(payComponentId);
		selectedCandidatePayStructureImpl.setComponentValue(componentValue);
		selectedCandidatePayStructureImpl.setRecruitmentProcessId(recruitmentProcessId);
		selectedCandidatePayStructureImpl.setPayStatus(payStatus);

		if (createDate == Long.MIN_VALUE) {
			selectedCandidatePayStructureImpl.setCreateDate(null);
		}
		else {
			selectedCandidatePayStructureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			selectedCandidatePayStructureImpl.setModifiedDate(null);
		}
		else {
			selectedCandidatePayStructureImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		selectedCandidatePayStructureImpl.resetOriginalValues();

		return selectedCandidatePayStructureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		candidatePayStructureId = objectInput.readLong();

		payComponentId = objectInput.readLong();

		componentValue = objectInput.readDouble();

		recruitmentProcessId = objectInput.readLong();

		payStatus = objectInput.readInt();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(candidatePayStructureId);

		objectOutput.writeLong(payComponentId);

		objectOutput.writeDouble(componentValue);

		objectOutput.writeLong(recruitmentProcessId);

		objectOutput.writeInt(payStatus);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long candidatePayStructureId;
	public long payComponentId;
	public double componentValue;
	public long recruitmentProcessId;
	public int payStatus;
	public long createDate;
	public long modifiedDate;
}