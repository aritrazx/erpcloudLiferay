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

import com.liferay.famocom.erpcloud.model.FinSalary;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FinSalary in entity cache.
 *
 * @author Samaresh
 * @see FinSalary
 * @generated
 */
@ProviderType
public class FinSalaryCacheModel implements CacheModel<FinSalary>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FinSalaryCacheModel)) {
			return false;
		}

		FinSalaryCacheModel finSalaryCacheModel = (FinSalaryCacheModel)obj;

		if (finSalaryId == finSalaryCacheModel.finSalaryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, finSalaryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{finSalaryId=");
		sb.append(finSalaryId);
		sb.append(", monthYear=");
		sb.append(monthYear);
		sb.append(", totalEarning=");
		sb.append(totalEarning);
		sb.append(", totalDeduction=");
		sb.append(totalDeduction);
		sb.append(", totalAmount=");
		sb.append(totalAmount);
		sb.append(", isLock=");
		sb.append(isLock);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FinSalary toEntityModel() {
		FinSalaryImpl finSalaryImpl = new FinSalaryImpl();

		finSalaryImpl.setFinSalaryId(finSalaryId);
		finSalaryImpl.setMonthYear(monthYear);
		finSalaryImpl.setTotalEarning(totalEarning);
		finSalaryImpl.setTotalDeduction(totalDeduction);
		finSalaryImpl.setTotalAmount(totalAmount);
		finSalaryImpl.setIsLock(isLock);
		finSalaryImpl.setCreatedBy(createdBy);

		if (createdDate == Long.MIN_VALUE) {
			finSalaryImpl.setCreatedDate(null);
		}
		else {
			finSalaryImpl.setCreatedDate(new Date(createdDate));
		}

		finSalaryImpl.resetOriginalValues();

		return finSalaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		finSalaryId = objectInput.readLong();

		monthYear = objectInput.readLong();

		totalEarning = objectInput.readDouble();

		totalDeduction = objectInput.readDouble();

		totalAmount = objectInput.readDouble();

		isLock = objectInput.readLong();

		createdBy = objectInput.readLong();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(finSalaryId);

		objectOutput.writeLong(monthYear);

		objectOutput.writeDouble(totalEarning);

		objectOutput.writeDouble(totalDeduction);

		objectOutput.writeDouble(totalAmount);

		objectOutput.writeLong(isLock);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createdDate);
	}

	public long finSalaryId;
	public long monthYear;
	public double totalEarning;
	public double totalDeduction;
	public double totalAmount;
	public long isLock;
	public long createdBy;
	public long createdDate;
}