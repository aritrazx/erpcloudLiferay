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

import com.liferay.famocom.erpcloud.model.PayrollIncrement;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PayrollIncrement in entity cache.
 *
 * @author Samaresh
 * @see PayrollIncrement
 * @generated
 */
@ProviderType
public class PayrollIncrementCacheModel implements CacheModel<PayrollIncrement>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayrollIncrementCacheModel)) {
			return false;
		}

		PayrollIncrementCacheModel payrollIncrementCacheModel = (PayrollIncrementCacheModel)obj;

		if (payrollIncrementId == payrollIncrementCacheModel.payrollIncrementId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, payrollIncrementId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{payrollIncrementId=");
		sb.append(payrollIncrementId);
		sb.append(", appraisalSettingId=");
		sb.append(appraisalSettingId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", employeeCode=");
		sb.append(employeeCode);
		sb.append(", overallRatingMan=");
		sb.append(overallRatingMan);
		sb.append(", preCtc=");
		sb.append(preCtc);
		sb.append(", postCtc=");
		sb.append(postCtc);
		sb.append(", componentId=");
		sb.append(componentId);
		sb.append(", preHeadComponentVal=");
		sb.append(preHeadComponentVal);
		sb.append(", postHeadComponentVal=");
		sb.append(postHeadComponentVal);
		sb.append(", bonusVal=");
		sb.append(bonusVal);
		sb.append(", financialYear=");
		sb.append(financialYear);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PayrollIncrement toEntityModel() {
		PayrollIncrementImpl payrollIncrementImpl = new PayrollIncrementImpl();

		payrollIncrementImpl.setPayrollIncrementId(payrollIncrementId);
		payrollIncrementImpl.setAppraisalSettingId(appraisalSettingId);
		payrollIncrementImpl.setEmployeeId(employeeId);
		payrollIncrementImpl.setCompanyId(companyId);
		payrollIncrementImpl.setEmployeeCode(employeeCode);
		payrollIncrementImpl.setOverallRatingMan(overallRatingMan);
		payrollIncrementImpl.setPreCtc(preCtc);
		payrollIncrementImpl.setPostCtc(postCtc);
		payrollIncrementImpl.setComponentId(componentId);
		payrollIncrementImpl.setPreHeadComponentVal(preHeadComponentVal);
		payrollIncrementImpl.setPostHeadComponentVal(postHeadComponentVal);
		payrollIncrementImpl.setBonusVal(bonusVal);

		if (financialYear == null) {
			payrollIncrementImpl.setFinancialYear("");
		}
		else {
			payrollIncrementImpl.setFinancialYear(financialYear);
		}

		payrollIncrementImpl.resetOriginalValues();

		return payrollIncrementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		payrollIncrementId = objectInput.readLong();

		appraisalSettingId = objectInput.readLong();

		employeeId = objectInput.readLong();

		companyId = objectInput.readLong();

		employeeCode = objectInput.readLong();

		overallRatingMan = objectInput.readLong();

		preCtc = objectInput.readDouble();

		postCtc = objectInput.readDouble();

		componentId = objectInput.readLong();

		preHeadComponentVal = objectInput.readDouble();

		postHeadComponentVal = objectInput.readDouble();

		bonusVal = objectInput.readDouble();
		financialYear = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(payrollIncrementId);

		objectOutput.writeLong(appraisalSettingId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(employeeCode);

		objectOutput.writeLong(overallRatingMan);

		objectOutput.writeDouble(preCtc);

		objectOutput.writeDouble(postCtc);

		objectOutput.writeLong(componentId);

		objectOutput.writeDouble(preHeadComponentVal);

		objectOutput.writeDouble(postHeadComponentVal);

		objectOutput.writeDouble(bonusVal);

		if (financialYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(financialYear);
		}
	}

	public long payrollIncrementId;
	public long appraisalSettingId;
	public long employeeId;
	public long companyId;
	public long employeeCode;
	public long overallRatingMan;
	public double preCtc;
	public double postCtc;
	public long componentId;
	public double preHeadComponentVal;
	public double postHeadComponentVal;
	public double bonusVal;
	public String financialYear;
}