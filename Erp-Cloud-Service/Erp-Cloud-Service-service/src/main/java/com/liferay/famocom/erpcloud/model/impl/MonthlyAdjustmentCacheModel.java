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

import com.liferay.famocom.erpcloud.model.MonthlyAdjustment;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MonthlyAdjustment in entity cache.
 *
 * @author Samaresh
 * @see MonthlyAdjustment
 * @generated
 */
@ProviderType
public class MonthlyAdjustmentCacheModel implements CacheModel<MonthlyAdjustment>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MonthlyAdjustmentCacheModel)) {
			return false;
		}

		MonthlyAdjustmentCacheModel monthlyAdjustmentCacheModel = (MonthlyAdjustmentCacheModel)obj;

		if (monthlyAdjustmentId == monthlyAdjustmentCacheModel.monthlyAdjustmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, monthlyAdjustmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{monthlyAdjustmentId=");
		sb.append(monthlyAdjustmentId);
		sb.append(", payComponentId=");
		sb.append(payComponentId);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", monthYear=");
		sb.append(monthYear);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MonthlyAdjustment toEntityModel() {
		MonthlyAdjustmentImpl monthlyAdjustmentImpl = new MonthlyAdjustmentImpl();

		monthlyAdjustmentImpl.setMonthlyAdjustmentId(monthlyAdjustmentId);
		monthlyAdjustmentImpl.setPayComponentId(payComponentId);
		monthlyAdjustmentImpl.setAmount(amount);
		monthlyAdjustmentImpl.setMonthYear(monthYear);
		monthlyAdjustmentImpl.setEmployeeId(employeeId);

		monthlyAdjustmentImpl.resetOriginalValues();

		return monthlyAdjustmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		monthlyAdjustmentId = objectInput.readLong();

		payComponentId = objectInput.readLong();

		amount = objectInput.readDouble();

		monthYear = objectInput.readLong();

		employeeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(monthlyAdjustmentId);

		objectOutput.writeLong(payComponentId);

		objectOutput.writeDouble(amount);

		objectOutput.writeLong(monthYear);

		objectOutput.writeLong(employeeId);
	}

	public long monthlyAdjustmentId;
	public long payComponentId;
	public double amount;
	public long monthYear;
	public long employeeId;
}