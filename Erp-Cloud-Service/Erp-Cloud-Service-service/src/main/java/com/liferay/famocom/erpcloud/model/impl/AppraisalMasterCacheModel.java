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

import com.liferay.famocom.erpcloud.model.AppraisalMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalMaster in entity cache.
 *
 * @author Samaresh
 * @see AppraisalMaster
 * @generated
 */
@ProviderType
public class AppraisalMasterCacheModel implements CacheModel<AppraisalMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalMasterCacheModel)) {
			return false;
		}

		AppraisalMasterCacheModel appraisalMasterCacheModel = (AppraisalMasterCacheModel)obj;

		if (appraisalId == appraisalMasterCacheModel.appraisalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{appraisalId=");
		sb.append(appraisalId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", appraisalSettingId=");
		sb.append(appraisalSettingId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", accomplishmentsEmp=");
		sb.append(accomplishmentsEmp);
		sb.append(", strengthsEmp=");
		sb.append(strengthsEmp);
		sb.append(", developmentEmp=");
		sb.append(developmentEmp);
		sb.append(", careerEmp=");
		sb.append(careerEmp);
		sb.append(", overallRatingEmp=");
		sb.append(overallRatingEmp);
		sb.append(", overallCommentEmp=");
		sb.append(overallCommentEmp);
		sb.append(", accomplishmentsMan=");
		sb.append(accomplishmentsMan);
		sb.append(", strengthsMan=");
		sb.append(strengthsMan);
		sb.append(", developmentMan=");
		sb.append(developmentMan);
		sb.append(", careerMan=");
		sb.append(careerMan);
		sb.append(", companyValue=");
		sb.append(companyValue);
		sb.append(", developmentPlan=");
		sb.append(developmentPlan);
		sb.append(", overallRatingMan=");
		sb.append(overallRatingMan);
		sb.append(", overallCommentMan=");
		sb.append(overallCommentMan);
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
	public AppraisalMaster toEntityModel() {
		AppraisalMasterImpl appraisalMasterImpl = new AppraisalMasterImpl();

		appraisalMasterImpl.setAppraisalId(appraisalId);
		appraisalMasterImpl.setCompanyId(companyId);
		appraisalMasterImpl.setAppraisalSettingId(appraisalSettingId);
		appraisalMasterImpl.setEmployeeId(employeeId);

		if (accomplishmentsEmp == null) {
			appraisalMasterImpl.setAccomplishmentsEmp("");
		}
		else {
			appraisalMasterImpl.setAccomplishmentsEmp(accomplishmentsEmp);
		}

		if (strengthsEmp == null) {
			appraisalMasterImpl.setStrengthsEmp("");
		}
		else {
			appraisalMasterImpl.setStrengthsEmp(strengthsEmp);
		}

		if (developmentEmp == null) {
			appraisalMasterImpl.setDevelopmentEmp("");
		}
		else {
			appraisalMasterImpl.setDevelopmentEmp(developmentEmp);
		}

		if (careerEmp == null) {
			appraisalMasterImpl.setCareerEmp("");
		}
		else {
			appraisalMasterImpl.setCareerEmp(careerEmp);
		}

		appraisalMasterImpl.setOverallRatingEmp(overallRatingEmp);

		if (overallCommentEmp == null) {
			appraisalMasterImpl.setOverallCommentEmp("");
		}
		else {
			appraisalMasterImpl.setOverallCommentEmp(overallCommentEmp);
		}

		if (accomplishmentsMan == null) {
			appraisalMasterImpl.setAccomplishmentsMan("");
		}
		else {
			appraisalMasterImpl.setAccomplishmentsMan(accomplishmentsMan);
		}

		if (strengthsMan == null) {
			appraisalMasterImpl.setStrengthsMan("");
		}
		else {
			appraisalMasterImpl.setStrengthsMan(strengthsMan);
		}

		if (developmentMan == null) {
			appraisalMasterImpl.setDevelopmentMan("");
		}
		else {
			appraisalMasterImpl.setDevelopmentMan(developmentMan);
		}

		if (careerMan == null) {
			appraisalMasterImpl.setCareerMan("");
		}
		else {
			appraisalMasterImpl.setCareerMan(careerMan);
		}

		if (companyValue == null) {
			appraisalMasterImpl.setCompanyValue("");
		}
		else {
			appraisalMasterImpl.setCompanyValue(companyValue);
		}

		if (developmentPlan == null) {
			appraisalMasterImpl.setDevelopmentPlan("");
		}
		else {
			appraisalMasterImpl.setDevelopmentPlan(developmentPlan);
		}

		appraisalMasterImpl.setOverallRatingMan(overallRatingMan);

		if (overallCommentMan == null) {
			appraisalMasterImpl.setOverallCommentMan("");
		}
		else {
			appraisalMasterImpl.setOverallCommentMan(overallCommentMan);
		}

		appraisalMasterImpl.setSubmitStep(submitStep);

		if (addedDate == Long.MIN_VALUE) {
			appraisalMasterImpl.setAddedDate(null);
		}
		else {
			appraisalMasterImpl.setAddedDate(new Date(addedDate));
		}

		appraisalMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalMasterImpl.setModifiedDate(null);
		}
		else {
			appraisalMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		appraisalMasterImpl.setModifiedBy(modifiedBy);

		appraisalMasterImpl.resetOriginalValues();

		return appraisalMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		appraisalId = objectInput.readLong();

		companyId = objectInput.readLong();

		appraisalSettingId = objectInput.readLong();

		employeeId = objectInput.readLong();
		accomplishmentsEmp = objectInput.readUTF();
		strengthsEmp = objectInput.readUTF();
		developmentEmp = objectInput.readUTF();
		careerEmp = objectInput.readUTF();

		overallRatingEmp = objectInput.readLong();
		overallCommentEmp = objectInput.readUTF();
		accomplishmentsMan = objectInput.readUTF();
		strengthsMan = objectInput.readUTF();
		developmentMan = objectInput.readUTF();
		careerMan = objectInput.readUTF();
		companyValue = objectInput.readUTF();
		developmentPlan = objectInput.readUTF();

		overallRatingMan = objectInput.readLong();
		overallCommentMan = objectInput.readUTF();

		submitStep = objectInput.readLong();
		addedDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(appraisalId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(appraisalSettingId);

		objectOutput.writeLong(employeeId);

		if (accomplishmentsEmp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accomplishmentsEmp);
		}

		if (strengthsEmp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(strengthsEmp);
		}

		if (developmentEmp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(developmentEmp);
		}

		if (careerEmp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(careerEmp);
		}

		objectOutput.writeLong(overallRatingEmp);

		if (overallCommentEmp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(overallCommentEmp);
		}

		if (accomplishmentsMan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accomplishmentsMan);
		}

		if (strengthsMan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(strengthsMan);
		}

		if (developmentMan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(developmentMan);
		}

		if (careerMan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(careerMan);
		}

		if (companyValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(companyValue);
		}

		if (developmentPlan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(developmentPlan);
		}

		objectOutput.writeLong(overallRatingMan);

		if (overallCommentMan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(overallCommentMan);
		}

		objectOutput.writeLong(submitStep);
		objectOutput.writeLong(addedDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long appraisalId;
	public long companyId;
	public long appraisalSettingId;
	public long employeeId;
	public String accomplishmentsEmp;
	public String strengthsEmp;
	public String developmentEmp;
	public String careerEmp;
	public long overallRatingEmp;
	public String overallCommentEmp;
	public String accomplishmentsMan;
	public String strengthsMan;
	public String developmentMan;
	public String careerMan;
	public String companyValue;
	public String developmentPlan;
	public long overallRatingMan;
	public String overallCommentMan;
	public long submitStep;
	public long addedDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}