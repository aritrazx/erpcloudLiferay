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

import com.liferay.famocom.erpcloud.model.TaxProofFiles;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaxProofFiles in entity cache.
 *
 * @author Samaresh
 * @see TaxProofFiles
 * @generated
 */
@ProviderType
public class TaxProofFilesCacheModel implements CacheModel<TaxProofFiles>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaxProofFilesCacheModel)) {
			return false;
		}

		TaxProofFilesCacheModel taxProofFilesCacheModel = (TaxProofFilesCacheModel)obj;

		if (fileId == taxProofFilesCacheModel.fileId) {
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
		sb.append(", taxDeclarationId=");
		sb.append(taxDeclarationId);
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
	public TaxProofFiles toEntityModel() {
		TaxProofFilesImpl taxProofFilesImpl = new TaxProofFilesImpl();

		taxProofFilesImpl.setFileId(fileId);

		if (financialYear == null) {
			taxProofFilesImpl.setFinancialYear("");
		}
		else {
			taxProofFilesImpl.setFinancialYear(financialYear);
		}

		taxProofFilesImpl.setCompanyId(companyId);
		taxProofFilesImpl.setEmployeeId(employeeId);
		taxProofFilesImpl.setTaxDeclarationId(taxDeclarationId);

		if (fileName == null) {
			taxProofFilesImpl.setFileName("");
		}
		else {
			taxProofFilesImpl.setFileName(fileName);
		}

		if (fileOrigName == null) {
			taxProofFilesImpl.setFileOrigName("");
		}
		else {
			taxProofFilesImpl.setFileOrigName(fileOrigName);
		}

		if (filePath == null) {
			taxProofFilesImpl.setFilePath("");
		}
		else {
			taxProofFilesImpl.setFilePath(filePath);
		}

		if (proofName == null) {
			taxProofFilesImpl.setProofName("");
		}
		else {
			taxProofFilesImpl.setProofName(proofName);
		}

		if (uploadDate == Long.MIN_VALUE) {
			taxProofFilesImpl.setUploadDate(null);
		}
		else {
			taxProofFilesImpl.setUploadDate(new Date(uploadDate));
		}

		taxProofFilesImpl.resetOriginalValues();

		return taxProofFilesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fileId = objectInput.readLong();
		financialYear = objectInput.readUTF();

		companyId = objectInput.readLong();

		employeeId = objectInput.readLong();

		taxDeclarationId = objectInput.readLong();
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

		objectOutput.writeLong(taxDeclarationId);

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
	public long taxDeclarationId;
	public String fileName;
	public String fileOrigName;
	public String filePath;
	public String proofName;
	public long uploadDate;
}