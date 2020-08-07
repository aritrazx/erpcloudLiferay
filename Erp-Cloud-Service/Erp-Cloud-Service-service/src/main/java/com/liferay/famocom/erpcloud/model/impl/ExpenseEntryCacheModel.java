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

import com.liferay.famocom.erpcloud.model.ExpenseEntry;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExpenseEntry in entity cache.
 *
 * @author Samaresh
 * @see ExpenseEntry
 * @generated
 */
@ProviderType
public class ExpenseEntryCacheModel implements CacheModel<ExpenseEntry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpenseEntryCacheModel)) {
			return false;
		}

		ExpenseEntryCacheModel expenseEntryCacheModel = (ExpenseEntryCacheModel)obj;

		if (expenseId == expenseEntryCacheModel.expenseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, expenseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{expenseId=");
		sb.append(expenseId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", catId=");
		sb.append(catId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", expDate=");
		sb.append(expDate);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", status=");
		sb.append(status);
		sb.append(", manEmployeeId=");
		sb.append(manEmployeeId);
		sb.append(", manCommnets=");
		sb.append(manCommnets);
		sb.append(", manApprovedDate=");
		sb.append(manApprovedDate);
		sb.append(", accComments=");
		sb.append(accComments);
		sb.append(", accApprovedDate=");
		sb.append(accApprovedDate);
		sb.append(", monthYear=");
		sb.append(monthYear);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExpenseEntry toEntityModel() {
		ExpenseEntryImpl expenseEntryImpl = new ExpenseEntryImpl();

		expenseEntryImpl.setExpenseId(expenseId);
		expenseEntryImpl.setEmployeeId(employeeId);
		expenseEntryImpl.setCompanyId(companyId);
		expenseEntryImpl.setProjectId(projectId);
		expenseEntryImpl.setCatId(catId);
		expenseEntryImpl.setGroupId(groupId);
		expenseEntryImpl.setUserId(userId);

		if (userName == null) {
			expenseEntryImpl.setUserName("");
		}
		else {
			expenseEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			expenseEntryImpl.setCreateDate(null);
		}
		else {
			expenseEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			expenseEntryImpl.setModifiedDate(null);
		}
		else {
			expenseEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			expenseEntryImpl.setTitle("");
		}
		else {
			expenseEntryImpl.setTitle(title);
		}

		if (description == null) {
			expenseEntryImpl.setDescription("");
		}
		else {
			expenseEntryImpl.setDescription(description);
		}

		if (expDate == Long.MIN_VALUE) {
			expenseEntryImpl.setExpDate(null);
		}
		else {
			expenseEntryImpl.setExpDate(new Date(expDate));
		}

		expenseEntryImpl.setAmount(amount);
		expenseEntryImpl.setStatus(status);
		expenseEntryImpl.setManEmployeeId(manEmployeeId);

		if (manCommnets == null) {
			expenseEntryImpl.setManCommnets("");
		}
		else {
			expenseEntryImpl.setManCommnets(manCommnets);
		}

		if (manApprovedDate == Long.MIN_VALUE) {
			expenseEntryImpl.setManApprovedDate(null);
		}
		else {
			expenseEntryImpl.setManApprovedDate(new Date(manApprovedDate));
		}

		if (accComments == null) {
			expenseEntryImpl.setAccComments("");
		}
		else {
			expenseEntryImpl.setAccComments(accComments);
		}

		if (accApprovedDate == Long.MIN_VALUE) {
			expenseEntryImpl.setAccApprovedDate(null);
		}
		else {
			expenseEntryImpl.setAccApprovedDate(new Date(accApprovedDate));
		}

		expenseEntryImpl.setMonthYear(monthYear);
		expenseEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			expenseEntryImpl.setStatusByUserName("");
		}
		else {
			expenseEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			expenseEntryImpl.setStatusDate(null);
		}
		else {
			expenseEntryImpl.setStatusDate(new Date(statusDate));
		}

		expenseEntryImpl.resetOriginalValues();

		return expenseEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		expenseId = objectInput.readLong();

		employeeId = objectInput.readLong();

		companyId = objectInput.readLong();

		projectId = objectInput.readLong();

		catId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		expDate = objectInput.readLong();

		amount = objectInput.readDouble();

		status = objectInput.readInt();

		manEmployeeId = objectInput.readLong();
		manCommnets = objectInput.readUTF();
		manApprovedDate = objectInput.readLong();
		accComments = objectInput.readUTF();
		accApprovedDate = objectInput.readLong();

		monthYear = objectInput.readLong();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(expenseId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(catId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(expDate);

		objectOutput.writeDouble(amount);

		objectOutput.writeInt(status);

		objectOutput.writeLong(manEmployeeId);

		if (manCommnets == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(manCommnets);
		}

		objectOutput.writeLong(manApprovedDate);

		if (accComments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accComments);
		}

		objectOutput.writeLong(accApprovedDate);

		objectOutput.writeLong(monthYear);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long expenseId;
	public long employeeId;
	public long companyId;
	public long projectId;
	public long catId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public long expDate;
	public double amount;
	public int status;
	public long manEmployeeId;
	public String manCommnets;
	public long manApprovedDate;
	public String accComments;
	public long accApprovedDate;
	public long monthYear;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}