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

import com.liferay.famocom.erpcloud.model.ExpProofFiles;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExpProofFiles in entity cache.
 *
 * @author Samaresh
 * @see ExpProofFiles
 * @generated
 */
@ProviderType
public class ExpProofFilesCacheModel implements CacheModel<ExpProofFiles>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpProofFilesCacheModel)) {
			return false;
		}

		ExpProofFilesCacheModel expProofFilesCacheModel = (ExpProofFilesCacheModel)obj;

		if (fileId == expProofFilesCacheModel.fileId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{fileId=");
		sb.append(fileId);
		sb.append(", financialYear=");
		sb.append(financialYear);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", expenseId=");
		sb.append(expenseId);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileOrigName=");
		sb.append(fileOrigName);
		sb.append(", filePath=");
		sb.append(filePath);
		sb.append(", proofName=");
		sb.append(proofName);
		sb.append(", uploadDate=");
		sb.append(uploadDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExpProofFiles toEntityModel() {
		ExpProofFilesImpl expProofFilesImpl = new ExpProofFilesImpl();

		expProofFilesImpl.setFileId(fileId);

		if (financialYear == null) {
			expProofFilesImpl.setFinancialYear("");
		}
		else {
			expProofFilesImpl.setFinancialYear(financialYear);
		}

		expProofFilesImpl.setCompanyId(companyId);
		expProofFilesImpl.setEmployeeId(employeeId);
		expProofFilesImpl.setExpenseId(expenseId);

		if (fileName == null) {
			expProofFilesImpl.setFileName("");
		}
		else {
			expProofFilesImpl.setFileName(fileName);
		}

		if (fileOrigName == null) {
			expProofFilesImpl.setFileOrigName("");
		}
		else {
			expProofFilesImpl.setFileOrigName(fileOrigName);
		}

		if (filePath == null) {
			expProofFilesImpl.setFilePath("");
		}
		else {
			expProofFilesImpl.setFilePath(filePath);
		}

		if (proofName == null) {
			expProofFilesImpl.setProofName("");
		}
		else {
			expProofFilesImpl.setProofName(proofName);
		}

		if (uploadDate == Long.MIN_VALUE) {
			expProofFilesImpl.setUploadDate(null);
		}
		else {
			expProofFilesImpl.setUploadDate(new Date(uploadDate));
		}

		expProofFilesImpl.resetOriginalValues();

		return expProofFilesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fileId = objectInput.readLong();
		financialYear = objectInput.readUTF();

		companyId = objectInput.readLong();

		employeeId = objectInput.readLong();

		expenseId = objectInput.readLong();
		fileName = objectInput.readUTF();
		fileOrigName = objectInput.readUTF();
		filePath = objectInput.readUTF();
		proofName = objectInput.readUTF();
		uploadDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(fileId);

		if (financialYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(financialYear);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(expenseId);

		if (fileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (fileOrigName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileOrigName);
		}

		if (filePath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filePath);
		}

		if (proofName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(proofName);
		}

		objectOutput.writeLong(uploadDate);
	}

	public long fileId;
	public String financialYear;
	public long companyId;
	public long employeeId;
	public long expenseId;
	public String fileName;
	public String fileOrigName;
	public String filePath;
	public String proofName;
	public long uploadDate;
}