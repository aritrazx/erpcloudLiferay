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

import com.liferay.famocom.erpcloud.model.DocumentUploadFile;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DocumentUploadFile in entity cache.
 *
 * @author Samaresh
 * @see DocumentUploadFile
 * @generated
 */
@ProviderType
public class DocumentUploadFileCacheModel implements CacheModel<DocumentUploadFile>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentUploadFileCacheModel)) {
			return false;
		}

		DocumentUploadFileCacheModel documentUploadFileCacheModel = (DocumentUploadFileCacheModel)obj;

		if (documentId == documentUploadFileCacheModel.documentId) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{documentId=");
		sb.append(documentId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", documentName=");
		sb.append(documentName);
		sb.append(", documentPath=");
		sb.append(documentPath);
		sb.append(", uploadDate=");
		sb.append(uploadDate);
		sb.append(", travelDetailsId=");
		sb.append(travelDetailsId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocumentUploadFile toEntityModel() {
		DocumentUploadFileImpl documentUploadFileImpl = new DocumentUploadFileImpl();

		documentUploadFileImpl.setDocumentId(documentId);
		documentUploadFileImpl.setCompanyId(companyId);
		documentUploadFileImpl.setEmployeeId(employeeId);
		documentUploadFileImpl.setFileEntryId(fileEntryId);

		if (documentName == null) {
			documentUploadFileImpl.setDocumentName("");
		}
		else {
			documentUploadFileImpl.setDocumentName(documentName);
		}

		if (documentPath == null) {
			documentUploadFileImpl.setDocumentPath("");
		}
		else {
			documentUploadFileImpl.setDocumentPath(documentPath);
		}

		if (uploadDate == Long.MIN_VALUE) {
			documentUploadFileImpl.setUploadDate(null);
		}
		else {
			documentUploadFileImpl.setUploadDate(new Date(uploadDate));
		}

		documentUploadFileImpl.setTravelDetailsId(travelDetailsId);

		documentUploadFileImpl.resetOriginalValues();

		return documentUploadFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		documentId = objectInput.readLong();

		companyId = objectInput.readLong();

		employeeId = objectInput.readLong();

		fileEntryId = objectInput.readLong();
		documentName = objectInput.readUTF();
		documentPath = objectInput.readUTF();
		uploadDate = objectInput.readLong();

		travelDetailsId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(documentId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(fileEntryId);

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

		objectOutput.writeLong(travelDetailsId);
	}

	public long documentId;
	public long companyId;
	public long employeeId;
	public long fileEntryId;
	public String documentName;
	public String documentPath;
	public long uploadDate;
	public long travelDetailsId;
}