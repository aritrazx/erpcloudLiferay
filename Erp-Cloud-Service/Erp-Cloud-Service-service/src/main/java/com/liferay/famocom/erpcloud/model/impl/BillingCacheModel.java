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

import com.liferay.famocom.erpcloud.model.Billing;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Billing in entity cache.
 *
 * @author Samaresh
 * @see Billing
 * @generated
 */
@ProviderType
public class BillingCacheModel implements CacheModel<Billing>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BillingCacheModel)) {
			return false;
		}

		BillingCacheModel billingCacheModel = (BillingCacheModel)obj;

		if (billingId == billingCacheModel.billingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, billingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{billingId=");
		sb.append(billingId);
		sb.append(", milestoneId=");
		sb.append(milestoneId);
		sb.append(", billingNumber=");
		sb.append(billingNumber);
		sb.append(", billingDate=");
		sb.append(billingDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Billing toEntityModel() {
		BillingImpl billingImpl = new BillingImpl();

		billingImpl.setBillingId(billingId);
		billingImpl.setMilestoneId(milestoneId);

		if (billingNumber == null) {
			billingImpl.setBillingNumber("");
		}
		else {
			billingImpl.setBillingNumber(billingNumber);
		}

		if (billingDate == null) {
			billingImpl.setBillingDate("");
		}
		else {
			billingImpl.setBillingDate(billingDate);
		}

		billingImpl.resetOriginalValues();

		return billingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		billingId = objectInput.readLong();

		milestoneId = objectInput.readLong();
		billingNumber = objectInput.readUTF();
		billingDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(billingId);

		objectOutput.writeLong(milestoneId);

		if (billingNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(billingNumber);
		}

		if (billingDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(billingDate);
		}
	}

	public long billingId;
	public long milestoneId;
	public String billingNumber;
	public String billingDate;
}