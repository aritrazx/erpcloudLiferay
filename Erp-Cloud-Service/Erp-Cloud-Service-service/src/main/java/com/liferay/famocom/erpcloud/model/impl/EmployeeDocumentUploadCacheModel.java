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

import com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDocumentUpload in entity cache.
 *
 * @author Samaresh
 * @see EmployeeDocumentUpload
 * @generated
 */
@ProviderType
public class EmployeeDocumentUploadCacheModel implements CacheModel<EmployeeDocumentUpload>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeDocumentUploadCacheModel)) {
			return false;
		}

		EmployeeDocumentUploadCacheModel employeeDocumentUploadCacheModel = (EmployeeDocumentUploadCacheModel)obj;

		if (empDocumentId == employeeDocumentUploadCacheModel.empDocumentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, empDocumentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{empDocumentId=");
		sb.append(empDocumentId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", travelDeskDetailsId=");
		sb.append(travelDeskDetailsId);
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
	public EmployeeDocumentUpload toEntityModel() {
		EmployeeDocumentUploadImpl employeeDocumentUploadImpl = new EmployeeDocumentUploadImpl();

		employeeDocumentUploadImpl.setEmpDocumentId(empDocumentId);
		employeeDocumentUploadImpl.setEmployeeId(employeeId);
		employeeDocumentUploadImpl.setCompanyId(companyId);
		employeeDocumentUploadImpl.setFileEntryId(fileEntryId);
		employeeDocumentUploadImpl.setTravelDeskDetailsId(travelDeskDetailsId);

		if (documentName == null) {
			employeeDocumentUploadImpl.setDocumentName("");
		}
		else {
			employeeDocumentUploadImpl.setDocumentName(documentName);
		}

		if (documentPath == null) {
			employeeDocumentUploadImpl.setDocumentPath("");
		}
		else {
			employeeDocumentUploadImpl.setDocumentPath(documentPath);
		}

		if (uploadDate == Long.MIN_VALUE) {
			employeeDocumentUploadImpl.setUploadDate(null);
		}
		else {
			employeeDocumentUploadImpl.setUploadDate(new Date(uploadDate));
		}

		employeeDocumentUploadImpl.resetOriginalValues();

		return employeeDocumentUploadImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empDocumentId = objectInput.readLong();

		employeeId = objectInput.readLong();

		companyId = objectInput.readLong();

		fileEntryId = objectInput.readLong();

		travelDeskDetailsId = objectInput.readLong();
		documentName = objectInput.readUTF();
		documentPath = objectInput.readUTF();
		uploadDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empDocumentId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(fileEntryId);

		objectOutput.writeLong(travelDeskDetailsId);

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

	public long empDocumentId;
	public long employeeId;
	public long companyId;
	public long fileEntryId;
	public long travelDeskDetailsId;
	public String documentName;
	public String documentPath;
	public long uploadDate;
}