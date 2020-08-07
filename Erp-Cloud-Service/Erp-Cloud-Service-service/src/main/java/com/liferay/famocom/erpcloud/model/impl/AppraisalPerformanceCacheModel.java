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

import com.liferay.famocom.erpcloud.model.AppraisalPerformance;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalPerformance in entity cache.
 *
 * @author Samaresh
 * @see AppraisalPerformance
 * @generated
 */
@ProviderType
public class AppraisalPerformanceCacheModel implements CacheModel<AppraisalPerformance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalPerformanceCacheModel)) {
			return false;
		}

		AppraisalPerformanceCacheModel appraisalPerformanceCacheModel = (AppraisalPerformanceCacheModel)obj;

		if (appraisalPerformanceId == appraisalPerformanceCacheModel.appraisalPerformanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalPerformanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{appraisalPerformanceId=");
		sb.append(appraisalPerformanceId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", appraisalId=");
		sb.append(appraisalId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", appraisalSettingId=");
		sb.append(appraisalSettingId);
		sb.append(", performanceId=");
		sb.append(performanceId);
		sb.append(", performanceComm=");
		sb.append(performanceComm);
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
	public AppraisalPerformance toEntityModel() {
		AppraisalPerformanceImpl appraisalPerformanceImpl = new AppraisalPerformanceImpl();

		appraisalPerformanceImpl.setAppraisalPerformanceId(appraisalPerformanceId);
		appraisalPerformanceImpl.setCompanyId(companyId);
		appraisalPerformanceImpl.setAppraisalId(appraisalId);
		appraisalPerformanceImpl.setEmployeeId(employeeId);
		appraisalPerformanceImpl.setAppraisalSettingId(appraisalSettingId);
		appraisalPerformanceImpl.setPerformanceId(performanceId);

		if (performanceComm == null) {
			appraisalPerformanceImpl.setPerformanceComm("");
		}
		else {
			appraisalPerformanceImpl.setPerformanceComm(performanceComm);
		}

		appraisalPerformanceImpl.setRatingIdEmp(ratingIdEmp);
		appraisalPerformanceImpl.setRatingIdMan(ratingIdMan);

		if (createdDate == Long.MIN_VALUE) {
			appraisalPerformanceImpl.setCreatedDate(null);
		}
		else {
			appraisalPerformanceImpl.setCreatedDate(new Date(createdDate));
		}

		appraisalPerformanceImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalPerformanceImpl.setModifiedDate(null);
		}
		else {
			appraisalPerformanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		appraisalPerformanceImpl.setModifiedBy(modifiedBy);

		appraisalPerformanceImpl.resetOriginalValues();

		return appraisalPerformanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		appraisalPerformanceId = objectInput.readLong();

		companyId = objectInput.readLong();

		appraisalId = objectInput.readLong();

		employeeId = objectInput.readLong();

		appraisalSettingId = objectInput.readLong();

		performanceId = objectInput.readLong();
		performanceComm = objectInput.readUTF();

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
		objectOutput.writeLong(appraisalPerformanceId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(appraisalId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(appraisalSettingId);

		objectOutput.writeLong(performanceId);

		if (performanceComm == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(performanceComm);
		}

		objectOutput.writeLong(ratingIdEmp);

		objectOutput.writeLong(ratingIdMan);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long appraisalPerformanceId;
	public long companyId;
	public long appraisalId;
	public long employeeId;
	public long appraisalSettingId;
	public long performanceId;
	public String performanceComm;
	public long ratingIdEmp;
	public long ratingIdMan;
	public long createdDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}