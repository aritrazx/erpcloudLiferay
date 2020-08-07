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

import com.liferay.famocom.erpcloud.model.BillDocumentUploadFile;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BillDocumentUploadFile in entity cache.
 *
 * @author Samaresh
 * @see BillDocumentUploadFile
 * @generated
 */
@ProviderType
public class BillDocumentUploadFileCacheModel implements CacheModel<BillDocumentUploadFile>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BillDocumentUploadFileCacheModel)) {
			return false;
		}

		BillDocumentUploadFileCacheModel billDocumentUploadFileCacheModel = (BillDocumentUploadFileCacheModel)obj;

		if (documentId == billDocumentUploadFileCacheModel.documentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, documentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{documentId=");
		sb.append(documentId);
		sb.append(", dlFileEntryId=");
		sb.append(dlFileEntryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", billingId=");
		sb.append(billingId);
		sb.append(", documentName=");
		sb.append(documentName);
		sb.append(", documentPath=");
		sb.append(documentPath);
		sb.append(", uploadDate=");
		sb.append(uploadDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BillDocumentUploadFile toEntityModel() {
		BillDocumentUploadFileImpl billDocumentUploadFileImpl = new BillDocumentUploadFileImpl();

		billDocumentUploadFileImpl.setDocumentId(documentId);
		billDocumentUploadFileImpl.setDlFileEntryId(dlFileEntryId);
		billDocumentUploadFileImpl.setCompanyId(companyId);
		billDocumentUploadFileImpl.setBillingId(billingId);

		if (documentName == null) {
			billDocumentUploadFileImpl.setDocumentName("");
		}
		else {
			billDocumentUploadFileImpl.setDocumentName(documentName);
		}

		if (documentPath == null) {
			billDocumentUploadFileImpl.setDocumentPath("");
		}
		else {
			billDocumentUploadFileImpl.setDocumentPath(documentPath);
		}

		if (uploadDate == Long.MIN_VALUE) {
			billDocumentUploadFileImpl.setUploadDate(null);
		}
		else {
			billDocumentUploadFileImpl.setUploadDate(new Date(uploadDate));
		}

		billDocumentUploadFileImpl.resetOriginalValues();

		return billDocumentUploadFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		documentId = objectInput.readLong();

		dlFileEntryId = objectInput.readLong();

		companyId = objectInput.readLong();

		billingId = objectInput.readLong();
		documentName = objectInput.readUTF();
		documentPath = objectInput.readUTF();
		uploadDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(documentId);

		objectOutput.writeLong(dlFileEntryId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(billingId);

		if (documentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentName);
		}

		if (documentPath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentPath);
		}

		objectOutput.writeLong(uploadDate);
	}

	public long documentId;
	public long dlFileEntryId;
	public long companyId;
	public long billingId;
	public String documentName;
	public String documentPath;
	public long uploadDate;
}