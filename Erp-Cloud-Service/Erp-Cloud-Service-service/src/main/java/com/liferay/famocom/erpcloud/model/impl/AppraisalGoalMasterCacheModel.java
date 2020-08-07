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

import com.liferay.famocom.erpcloud.model.AppraisalGoalMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalGoalMaster in entity cache.
 *
 * @author Samaresh
 * @see AppraisalGoalMaster
 * @generated
 */
@ProviderType
public class AppraisalGoalMasterCacheModel implements CacheModel<AppraisalGoalMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalGoalMasterCacheModel)) {
			return false;
		}

		AppraisalGoalMasterCacheModel appraisalGoalMasterCacheModel = (AppraisalGoalMasterCacheModel)obj;

		if (appraisalGoalMasterId == appraisalGoalMasterCacheModel.appraisalGoalMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalGoalMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{appraisalGoalMasterId=");
		sb.append(appraisalGoalMasterId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", appraisalId=");
		sb.append(appraisalId);
		sb.append(", appraisalProjectId=");
		sb.append(appraisalProjectId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", evaluationId=");
		sb.append(evaluationId);
		sb.append(", employeeComment=");
		sb.append(employeeComment);
		sb.append(", employeeOverallRat=");
		sb.append(employeeOverallRat);
		sb.append(", managerComment=");
		sb.append(managerComment);
		sb.append(", managerOverallRat=");
		sb.append(managerOverallRat);
		sb.append(", createdDate=");
		sb.append(createdDate);
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
	public AppraisalGoalMaster toEntityModel() {
		AppraisalGoalMasterImpl appraisalGoalMasterImpl = new AppraisalGoalMasterImpl();

		appraisalGoalMasterImpl.setAppraisalGoalMasterId(appraisalGoalMasterId);
		appraisalGoalMasterImpl.setCompanyId(companyId);
		appraisalGoalMasterImpl.setAppraisalId(appraisalId);
		appraisalGoalMasterImpl.setAppraisalProjectId(appraisalProjectId);
		appraisalGoalMasterImpl.setEmployeeId(employeeId);
		appraisalGoalMasterImpl.setProjectId(projectId);
		appraisalGoalMasterImpl.setEvaluationId(evaluationId);

		if (employeeComment == null) {
			appraisalGoalMasterImpl.setEmployeeComment("");
		}
		else {
			appraisalGoalMasterImpl.setEmployeeComment(employeeComment);
		}

		appraisalGoalMasterImpl.setEmployeeOverallRat(employeeOverallRat);

		if (managerComment == null) {
			appraisalGoalMasterImpl.setManagerComment("");
		}
		else {
			appraisalGoalMasterImpl.setManagerComment(managerComment);
		}

		appraisalGoalMasterImpl.setManagerOverallRat(managerOverallRat);

		if (createdDate == Long.MIN_VALUE) {
			appraisalGoalMasterImpl.setCreatedDate(null);
		}
		else {
			appraisalGoalMasterImpl.setCreatedDate(new Date(createdDate));
		}

		appraisalGoalMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalGoalMasterImpl.setModifiedDate(null);
		}
		else {
			appraisalGoalMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		appraisalGoalMasterImpl.setModifiedBy(modifiedBy);

		appraisalGoalMasterImpl.resetOriginalValues();

		return appraisalGoalMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		appraisalGoalMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		appraisalId = objectInput.readLong();

		appraisalProjectId = objectInput.readLong();

		employeeId = objectInput.readLong();

		projectId = objectInput.readLong();

		evaluationId = objectInput.readLong();
		employeeComment = objectInput.readUTF();

		employeeOverallRat = objectInput.readLong();
		managerComment = objectInput.readUTF();

		managerOverallRat = objectInput.readLong();
		createdDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(appraisalGoalMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(appraisalId);

		objectOutput.writeLong(appraisalProjectId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(evaluationId);

		if (employeeComment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeComment);
		}

		objectOutput.writeLong(employeeOverallRat);

		if (managerComment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(managerComment);
		}

		objectOutput.writeLong(managerOverallRat);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long appraisalGoalMasterId;
	public long companyId;
	public long appraisalId;
	public long appraisalProjectId;
	public long employeeId;
	public long projectId;
	public long evaluationId;
	public String employeeComment;
	public long employeeOverallRat;
	public String managerComment;
	public long managerOverallRat;
	public long createdDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}