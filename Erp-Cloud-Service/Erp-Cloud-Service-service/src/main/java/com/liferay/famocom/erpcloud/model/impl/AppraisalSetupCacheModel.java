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

import com.liferay.famocom.erpcloud.model.AppraisalSetup;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalSetup in entity cache.
 *
 * @author Samaresh
 * @see AppraisalSetup
 * @generated
 */
@ProviderType
public class AppraisalSetupCacheModel implements CacheModel<AppraisalSetup>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalSetupCacheModel)) {
			return false;
		}

		AppraisalSetupCacheModel appraisalSetupCacheModel = (AppraisalSetupCacheModel)obj;

		if (appraisalSettingId == appraisalSetupCacheModel.appraisalSettingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalSettingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{appraisalSettingId=");
		sb.append(appraisalSettingId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", financialYear=");
		sb.append(financialYear);
		sb.append(", fromDateCycle=");
		sb.append(fromDateCycle);
		sb.append(", toDateCycle=");
		sb.append(toDateCycle);
		sb.append(", fromDateSubmission=");
		sb.append(fromDateSubmission);
		sb.append(", toDateSubmission=");
		sb.append(toDateSubmission);
		sb.append(", appraisalPeriod=");
		sb.append(appraisalPeriod);
		sb.append(", totalEmp=");
		sb.append(totalEmp);
		sb.append(", beforeCtcAll=");
		sb.append(beforeCtcAll);
		sb.append(", appraisalEmp=");
		sb.append(appraisalEmp);
		sb.append(", beforeCtc=");
		sb.append(beforeCtc);
		sb.append(", afterCtc=");
		sb.append(afterCtc);
		sb.append(", totalAreas=");
		sb.append(totalAreas);
		sb.append(", totalBonus=");
		sb.append(totalBonus);
		sb.append(", totalCtcAfter=");
		sb.append(totalCtcAfter);
		sb.append(", isLocked=");
		sb.append(isLocked);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", employeeType=");
		sb.append(employeeType);
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
	public AppraisalSetup toEntityModel() {
		AppraisalSetupImpl appraisalSetupImpl = new AppraisalSetupImpl();

		appraisalSetupImpl.setAppraisalSettingId(appraisalSettingId);
		appraisalSetupImpl.setCompanyId(companyId);

		if (financialYear == null) {
			appraisalSetupImpl.setFinancialYear("");
		}
		else {
			appraisalSetupImpl.setFinancialYear(financialYear);
		}

		if (fromDateCycle == Long.MIN_VALUE) {
			appraisalSetupImpl.setFromDateCycle(null);
		}
		else {
			appraisalSetupImpl.setFromDateCycle(new Date(fromDateCycle));
		}

		if (toDateCycle == Long.MIN_VALUE) {
			appraisalSetupImpl.setToDateCycle(null);
		}
		else {
			appraisalSetupImpl.setToDateCycle(new Date(toDateCycle));
		}

		if (fromDateSubmission == Long.MIN_VALUE) {
			appraisalSetupImpl.setFromDateSubmission(null);
		}
		else {
			appraisalSetupImpl.setFromDateSubmission(new Date(
					fromDateSubmission));
		}

		if (toDateSubmission == Long.MIN_VALUE) {
			appraisalSetupImpl.setToDateSubmission(null);
		}
		else {
			appraisalSetupImpl.setToDateSubmission(new Date(toDateSubmission));
		}

		appraisalSetupImpl.setAppraisalPeriod(appraisalPeriod);
		appraisalSetupImpl.setTotalEmp(totalEmp);
		appraisalSetupImpl.setBeforeCtcAll(beforeCtcAll);
		appraisalSetupImpl.setAppraisalEmp(appraisalEmp);
		appraisalSetupImpl.setBeforeCtc(beforeCtc);
		appraisalSetupImpl.setAfterCtc(afterCtc);
		appraisalSetupImpl.setTotalAreas(totalAreas);
		appraisalSetupImpl.setTotalBonus(totalBonus);
		appraisalSetupImpl.setTotalCtcAfter(totalCtcAfter);
		appraisalSetupImpl.setIsLocked(isLocked);
		appraisalSetupImpl.setIsActive(isActive);

		if (employeeType == null) {
			appraisalSetupImpl.setEmployeeType("");
		}
		else {
			appraisalSetupImpl.setEmployeeType(employeeType);
		}

		if (addedDate == Long.MIN_VALUE) {
			appraisalSetupImpl.setAddedDate(null);
		}
		else {
			appraisalSetupImpl.setAddedDate(new Date(addedDate));
		}

		appraisalSetupImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalSetupImpl.setModifiedDate(null);
		}
		else {
			appraisalSetupImpl.setModifiedDate(new Date(modifiedDate));
		}

		appraisalSetupImpl.setModifiedBy(modifiedBy);

		appraisalSetupImpl.resetOriginalValues();

		return appraisalSetupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		appraisalSettingId = objectInput.readLong();

		companyId = objectInput.readLong();
		financialYear = objectInput.readUTF();
		fromDateCycle = objectInput.readLong();
		toDateCycle = objectInput.readLong();
		fromDateSubmission = objectInput.readLong();
		toDateSubmission = objectInput.readLong();

		appraisalPeriod = objectInput.readLong();

		totalEmp = objectInput.readLong();

		beforeCtcAll = objectInput.readLong();

		appraisalEmp = objectInput.readLong();

		beforeCtc = objectInput.readLong();

		afterCtc = objectInput.readLong();

		totalAreas = objectInput.readLong();

		totalBonus = objectInput.readLong();

		totalCtcAfter = objectInput.readLong();

		isLocked = objectInput.readLong();

		isActive = objectInput.readLong();
		employeeType = objectInput.readUTF();
		addedDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(appraisalSettingId);

		objectOutput.writeLong(companyId);

		if (financialYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(financialYear);
		}

		objectOutput.writeLong(fromDateCycle);
		objectOutput.writeLong(toDateCycle);
		objectOutput.writeLong(fromDateSubmission);
		objectOutput.writeLong(toDateSubmission);

		objectOutput.writeLong(appraisalPeriod);

		objectOutput.writeLong(totalEmp);

		objectOutput.writeLong(beforeCtcAll);

		objectOutput.writeLong(appraisalEmp);

		objectOutput.writeLong(beforeCtc);

		objectOutput.writeLong(afterCtc);

		objectOutput.writeLong(totalAreas);

		objectOutput.writeLong(totalBonus);

		objectOutput.writeLong(totalCtcAfter);

		objectOutput.writeLong(isLocked);

		objectOutput.writeLong(isActive);

		if (employeeType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeType);
		}

		objectOutput.writeLong(addedDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long appraisalSettingId;
	public long companyId;
	public String financialYear;
	public long fromDateCycle;
	public long toDateCycle;
	public long fromDateSubmission;
	public long toDateSubmission;
	public long appraisalPeriod;
	public long totalEmp;
	public long beforeCtcAll;
	public long appraisalEmp;
	public long beforeCtc;
	public long afterCtc;
	public long totalAreas;
	public long totalBonus;
	public long totalCtcAfter;
	public long isLocked;
	public long isActive;
	public String employeeType;
	public long addedDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}