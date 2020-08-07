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

import com.liferay.famocom.erpcloud.model.CompanyPolicy;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CompanyPolicy in entity cache.
 *
 * @author Samaresh
 * @see CompanyPolicy
 * @generated
 */
@ProviderType
public class CompanyPolicyCacheModel implements CacheModel<CompanyPolicy>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CompanyPolicyCacheModel)) {
			return false;
		}

		CompanyPolicyCacheModel companyPolicyCacheModel = (CompanyPolicyCacheModel)obj;

		if (companyPolicyId == companyPolicyCacheModel.companyPolicyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, companyPolicyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{companyPolicyId=");
		sb.append(companyPolicyId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", daysLocking=");
		sb.append(daysLocking);
		sb.append(", checkStatus=");
		sb.append(checkStatus);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CompanyPolicy toEntityModel() {
		CompanyPolicyImpl companyPolicyImpl = new CompanyPolicyImpl();

		companyPolicyImpl.setCompanyPolicyId(companyPolicyId);
		companyPolicyImpl.setCompanyId(companyId);
		companyPolicyImpl.setDaysLocking(daysLocking);
		companyPolicyImpl.setCheckStatus(checkStatus);

		if (addedDate == Long.MIN_VALUE) {
			companyPolicyImpl.setAddedDate(null);
		}
		else {
			companyPolicyImpl.setAddedDate(new Date(addedDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			companyPolicyImpl.setModifiedDate(null);
		}
		else {
			companyPolicyImpl.setModifiedDate(new Date(modifiedDate));
		}

		companyPolicyImpl.resetOriginalValues();

		return companyPolicyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyPolicyId = objectInput.readLong();

		companyId = objectInput.readLong();

		daysLocking = objectInput.readInt();

		checkStatus = objectInput.readInt();
		addedDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(companyPolicyId);

		objectOutput.writeLong(companyId);

		objectOutput.writeInt(daysLocking);

		objectOutput.writeInt(checkStatus);
		objectOutput.writeLong(addedDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long companyPolicyId;
	public long companyId;
	public int daysLocking;
	public int checkStatus;
	public long addedDate;
	public long modifiedDate;
}