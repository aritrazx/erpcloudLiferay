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

import com.liferay.famocom.erpcloud.model.Expense;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Expense in entity cache.
 *
 * @author Samaresh
 * @see Expense
 * @generated
 */
@ProviderType
public class ExpenseCacheModel implements CacheModel<Expense>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpenseCacheModel)) {
			return false;
		}

		ExpenseCacheModel expenseCacheModel = (ExpenseCacheModel)obj;

		if (expenseId == expenseCacheModel.expenseId) {
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
		StringBundler sb = new StringBundler(43);

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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Expense toEntityModel() {
		ExpenseImpl expenseImpl = new ExpenseImpl();

		expenseImpl.setExpenseId(expenseId);
		expenseImpl.setEmployeeId(employeeId);
		expenseImpl.setCompanyId(companyId);
		expenseImpl.setProjectId(projectId);
		expenseImpl.setCatId(catId);
		expenseImpl.setGroupId(groupId);
		expenseImpl.setUserId(userId);

		if (userName == null) {
			expenseImpl.setUserName("");
		}
		else {
			expenseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			expenseImpl.setCreateDate(null);
		}
		else {
			expenseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			expenseImpl.setModifiedDate(null);
		}
		else {
			expenseImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			expenseImpl.setTitle("");
		}
		else {
			expenseImpl.setTitle(title);
		}

		if (description == null) {
			expenseImpl.setDescription("");
		}
		else {
			expenseImpl.setDescription(description);
		}

		if (expDate == Long.MIN_VALUE) {
			expenseImpl.setExpDate(null);
		}
		else {
			expenseImpl.setExpDate(new Date(expDate));
		}

		expenseImpl.setAmount(amount);
		expenseImpl.setStatus(status);
		expenseImpl.setManEmployeeId(manEmployeeId);

		if (manCommnets == null) {
			expenseImpl.setManCommnets("");
		}
		else {
			expenseImpl.setManCommnets(manCommnets);
		}

		if (manApprovedDate == Long.MIN_VALUE) {
			expenseImpl.setManApprovedDate(null);
		}
		else {
			expenseImpl.setManApprovedDate(new Date(manApprovedDate));
		}

		if (accComments == null) {
			expenseImpl.setAccComments("");
		}
		else {
			expenseImpl.setAccComments(accComments);
		}

		if (accApprovedDate == Long.MIN_VALUE) {
			expenseImpl.setAccApprovedDate(null);
		}
		else {
			expenseImpl.setAccApprovedDate(new Date(accApprovedDate));
		}

		expenseImpl.setMonthYear(monthYear);

		expenseImpl.resetOriginalValues();

		return expenseImpl;
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
}