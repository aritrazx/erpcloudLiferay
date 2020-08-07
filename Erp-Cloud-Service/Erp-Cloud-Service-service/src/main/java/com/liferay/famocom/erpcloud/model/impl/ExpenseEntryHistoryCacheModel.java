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

import com.liferay.famocom.erpcloud.model.ExpenseEntryHistory;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExpenseEntryHistory in entity cache.
 *
 * @author Samaresh
 * @see ExpenseEntryHistory
 * @generated
 */
@ProviderType
public class ExpenseEntryHistoryCacheModel implements CacheModel<ExpenseEntryHistory>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpenseEntryHistoryCacheModel)) {
			return false;
		}

		ExpenseEntryHistoryCacheModel expenseEntryHistoryCacheModel = (ExpenseEntryHistoryCacheModel)obj;

		if (expenseHistoryId == expenseEntryHistoryCacheModel.expenseHistoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, expenseHistoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{expenseHistoryId=");
		sb.append(expenseHistoryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", expenseId=");
		sb.append(expenseId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", manEmployeeId=");
		sb.append(manEmployeeId);
		sb.append(", manComments=");
		sb.append(manComments);
		sb.append(", addeddate=");
		sb.append(addeddate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExpenseEntryHistory toEntityModel() {
		ExpenseEntryHistoryImpl expenseEntryHistoryImpl = new ExpenseEntryHistoryImpl();

		expenseEntryHistoryImpl.setExpenseHistoryId(expenseHistoryId);
		expenseEntryHistoryImpl.setCompanyId(companyId);
		expenseEntryHistoryImpl.setExpenseId(expenseId);
		expenseEntryHistoryImpl.setStatus(status);
		expenseEntryHistoryImpl.setManEmployeeId(manEmployeeId);

		if (manComments == null) {
			expenseEntryHistoryImpl.setManComments("");
		}
		else {
			expenseEntryHistoryImpl.setManComments(manComments);
		}

		if (addeddate == Long.MIN_VALUE) {
			expenseEntryHistoryImpl.setAddeddate(null);
		}
		else {
			expenseEntryHistoryImpl.setAddeddate(new Date(addeddate));
		}

		expenseEntryHistoryImpl.resetOriginalValues();

		return expenseEntryHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		expenseHistoryId = objectInput.readLong();

		companyId = objectInput.readLong();

		expenseId = objectInput.readLong();

		status = objectInput.readInt();

		manEmployeeId = objectInput.readLong();
		manComments = objectInput.readUTF();
		addeddate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(expenseHistoryId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(expenseId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(manEmployeeId);

		if (manComments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(manComments);
		}

		objectOutput.writeLong(addeddate);
	}

	public long expenseHistoryId;
	public long companyId;
	public long expenseId;
	public int status;
	public long manEmployeeId;
	public String manComments;
	public long addeddate;
}