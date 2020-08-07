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

import com.liferay.famocom.erpcloud.model.PayrollSlabs;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PayrollSlabs in entity cache.
 *
 * @author Samaresh
 * @see PayrollSlabs
 * @generated
 */
@ProviderType
public class PayrollSlabsCacheModel implements CacheModel<PayrollSlabs>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayrollSlabsCacheModel)) {
			return false;
		}

		PayrollSlabsCacheModel payrollSlabsCacheModel = (PayrollSlabsCacheModel)obj;

		if (payrollSlabsId == payrollSlabsCacheModel.payrollSlabsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, payrollSlabsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{payrollSlabsId=");
		sb.append(payrollSlabsId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", appraisalSettingId=");
		sb.append(appraisalSettingId);
		sb.append(", ratingId=");
		sb.append(ratingId);
		sb.append(", payrollPercentage=");
		sb.append(payrollPercentage);
		sb.append(", bonusPercentage=");
		sb.append(bonusPercentage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PayrollSlabs toEntityModel() {
		PayrollSlabsImpl payrollSlabsImpl = new PayrollSlabsImpl();

		payrollSlabsImpl.setPayrollSlabsId(payrollSlabsId);
		payrollSlabsImpl.setCompanyId(companyId);
		payrollSlabsImpl.setAppraisalSettingId(appraisalSettingId);
		payrollSlabsImpl.setRatingId(ratingId);
		payrollSlabsImpl.setPayrollPercentage(payrollPercentage);
		payrollSlabsImpl.setBonusPercentage(bonusPercentage);

		payrollSlabsImpl.resetOriginalValues();

		return payrollSlabsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		payrollSlabsId = objectInput.readLong();

		companyId = objectInput.readLong();

		appraisalSettingId = objectInput.readLong();

		ratingId = objectInput.readLong();

		payrollPercentage = objectInput.readDouble();

		bonusPercentage = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(payrollSlabsId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(appraisalSettingId);

		objectOutput.writeLong(ratingId);

		objectOutput.writeDouble(payrollPercentage);

		objectOutput.writeDouble(bonusPercentage);
	}

	public long payrollSlabsId;
	public long companyId;
	public long appraisalSettingId;
	public long ratingId;
	public double payrollPercentage;
	public double bonusPercentage;
}