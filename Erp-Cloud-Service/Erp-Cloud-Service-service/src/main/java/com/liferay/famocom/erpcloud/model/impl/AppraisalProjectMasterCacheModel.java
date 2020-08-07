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

import com.liferay.famocom.erpcloud.model.AppraisalProjectMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalProjectMaster in entity cache.
 *
 * @author Samaresh
 * @see AppraisalProjectMaster
 * @generated
 */
@ProviderType
public class AppraisalProjectMasterCacheModel implements CacheModel<AppraisalProjectMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalProjectMasterCacheModel)) {
			return false;
		}

		AppraisalProjectMasterCacheModel appraisalProjectMasterCacheModel = (AppraisalProjectMasterCacheModel)obj;

		if (appraisalProjectId == appraisalProjectMasterCacheModel.appraisalProjectId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalProjectId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{appraisalProjectId=");
		sb.append(appraisalProjectId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", appraisalId=");
		sb.append(appraisalId);
		sb.append(", appraisalSettingId=");
		sb.append(appraisalSettingId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", projectDescription=");
		sb.append(projectDescription);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", submitStep=");
		sb.append(submitStep);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppraisalProjectMaster toEntityModel() {
		AppraisalProjectMasterImpl appraisalProjectMasterImpl = new AppraisalProjectMasterImpl();

		appraisalProjectMasterImpl.setAppraisalProjectId(appraisalProjectId);
		appraisalProjectMasterImpl.setCompanyId(companyId);
		appraisalProjectMasterImpl.setAppraisalId(appraisalId);
		appraisalProjectMasterImpl.setAppraisalSettingId(appraisalSettingId);
		appraisalProjectMasterImpl.setEmployeeId(employeeId);
		appraisalProjectMasterImpl.setProjectId(projectId);

		if (projectDescription == null) {
			appraisalProjectMasterImpl.setProjectDescription("");
		}
		else {
			appraisalProjectMasterImpl.setProjectDescription(projectDescription);
		}

		if (startDate == Long.MIN_VALUE) {
			appraisalProjectMasterImpl.setStartDate(null);
		}
		else {
			appraisalProjectMasterImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			appraisalProjectMasterImpl.setEndDate(null);
		}
		else {
			appraisalProjectMasterImpl.setEndDate(new Date(endDate));
		}

		appraisalProjectMasterImpl.setSubmitStep(submitStep);

		if (addedDate == Long.MIN_VALUE) {
			appraisalProjectMasterImpl.setAddedDate(null);
		}
		else {
			appraisalProjectMasterImpl.setAddedDate(new Date(addedDate));
		}

		appraisalProjectMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalProjectMasterImpl.setModifiedDate(null);
		}
		else {
			appraisalProjectMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		appraisalProjectMasterImpl.setModifiedBy(modifiedBy);

		appraisalProjectMasterImpl.resetOriginalValues();

		return appraisalProjectMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		appraisalProjectId = objectInput.readLong();

		companyId = objectInput.readLong();

		appraisalId = objectInput.readLong();

		appraisalSettingId = objectInput.readLong();

		employeeId = objectInput.readLong();

		projectId = objectInput.readLong();
		projectDescription = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		submitStep = objectInput.readLong();
		addedDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(appraisalProjectId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(appraisalId);

		objectOutput.writeLong(appraisalSettingId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(projectId);

		if (projectDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectDescription);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeLong(submitStep);
		objectOutput.writeLong(addedDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long appraisalProjectId;
	public long companyId;
	public long appraisalId;
	public long appraisalSettingId;
	public long employeeId;
	public long projectId;
	public String projectDescription;
	public long startDate;
	public long endDate;
	public long submitStep;
	public long addedDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}