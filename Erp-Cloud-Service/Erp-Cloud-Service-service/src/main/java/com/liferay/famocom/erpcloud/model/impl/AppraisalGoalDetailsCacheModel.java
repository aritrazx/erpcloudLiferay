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

import com.liferay.famocom.erpcloud.model.AppraisalGoalDetails;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalGoalDetails in entity cache.
 *
 * @author Samaresh
 * @see AppraisalGoalDetails
 * @generated
 */
@ProviderType
public class AppraisalGoalDetailsCacheModel implements CacheModel<AppraisalGoalDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalGoalDetailsCacheModel)) {
			return false;
		}

		AppraisalGoalDetailsCacheModel appraisalGoalDetailsCacheModel = (AppraisalGoalDetailsCacheModel)obj;

		if (appraisalGoalDetailsId == appraisalGoalDetailsCacheModel.appraisalGoalDetailsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalGoalDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{appraisalGoalDetailsId=");
		sb.append(appraisalGoalDetailsId);
		sb.append(", appraisalGoalMasterId=");
		sb.append(appraisalGoalMasterId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", appraisalId=");
		sb.append(appraisalId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", evaluationId=");
		sb.append(evaluationId);
		sb.append(", goaldetailId=");
		sb.append(goaldetailId);
		sb.append(", ratingIdEmp=");
		sb.append(ratingIdEmp);
		sb.append(", ratingIdMan=");
		sb.append(ratingIdMan);
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
	public AppraisalGoalDetails toEntityModel() {
		AppraisalGoalDetailsImpl appraisalGoalDetailsImpl = new AppraisalGoalDetailsImpl();

		appraisalGoalDetailsImpl.setAppraisalGoalDetailsId(appraisalGoalDetailsId);
		appraisalGoalDetailsImpl.setAppraisalGoalMasterId(appraisalGoalMasterId);
		appraisalGoalDetailsImpl.setCompanyId(companyId);
		appraisalGoalDetailsImpl.setAppraisalId(appraisalId);
		appraisalGoalDetailsImpl.setEmployeeId(employeeId);
		appraisalGoalDetailsImpl.setProjectId(projectId);
		appraisalGoalDetailsImpl.setEvaluationId(evaluationId);
		appraisalGoalDetailsImpl.setGoaldetailId(goaldetailId);
		appraisalGoalDetailsImpl.setRatingIdEmp(ratingIdEmp);
		appraisalGoalDetailsImpl.setRatingIdMan(ratingIdMan);

		if (createdDate == Long.MIN_VALUE) {
			appraisalGoalDetailsImpl.setCreatedDate(null);
		}
		else {
			appraisalGoalDetailsImpl.setCreatedDate(new Date(createdDate));
		}

		appraisalGoalDetailsImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalGoalDetailsImpl.setModifiedDate(null);
		}
		else {
			appraisalGoalDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		appraisalGoalDetailsImpl.setModifiedBy(modifiedBy);

		appraisalGoalDetailsImpl.resetOriginalValues();

		return appraisalGoalDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		appraisalGoalDetailsId = objectInput.readLong();

		appraisalGoalMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		appraisalId = objectInput.readLong();

		employeeId = objectInput.readLong();

		projectId = objectInput.readLong();

		evaluationId = objectInput.readLong();

		goaldetailId = objectInput.readLong();

		ratingIdEmp = objectInput.readLong();

		ratingIdMan = objectInput.readLong();
		createdDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(appraisalGoalDetailsId);

		objectOutput.writeLong(appraisalGoalMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(appraisalId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(evaluationId);

		objectOutput.writeLong(goaldetailId);

		objectOutput.writeLong(ratingIdEmp);

		objectOutput.writeLong(ratingIdMan);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long appraisalGoalDetailsId;
	public long appraisalGoalMasterId;
	public long companyId;
	public long appraisalId;
	public long employeeId;
	public long projectId;
	public long evaluationId;
	public long goaldetailId;
	public long ratingIdEmp;
	public long ratingIdMan;
	public long createdDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}