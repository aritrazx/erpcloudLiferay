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

import com.liferay.famocom.erpcloud.model.EmployeeType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeType in entity cache.
 *
 * @author Samaresh
 * @see EmployeeType
 * @generated
 */
@ProviderType
public class EmployeeTypeCacheModel implements CacheModel<EmployeeType>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeTypeCacheModel)) {
			return false;
		}

		EmployeeTypeCacheModel employeeTypeCacheModel = (EmployeeTypeCacheModel)obj;

		if (employeetypeId == employeeTypeCacheModel.employeetypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeetypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{employeetypeId=");
		sb.append(employeetypeId);
		sb.append(", typeName=");
		sb.append(typeName);
		sb.append(", pfDeduct=");
		sb.append(pfDeduct);
		sb.append(", status=");
		sb.append(status);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", addeddate=");
		sb.append(addeddate);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeType toEntityModel() {
		EmployeeTypeImpl employeeTypeImpl = new EmployeeTypeImpl();

		employeeTypeImpl.setEmployeetypeId(employeetypeId);

		if (typeName == null) {
			employeeTypeImpl.setTypeName("");
		}
		else {
			employeeTypeImpl.setTypeName(typeName);
		}

		employeeTypeImpl.setPfDeduct(pfDeduct);
		employeeTypeImpl.setStatus(status);
		employeeTypeImpl.setCompanyId(companyId);

		if (addeddate == Long.MIN_VALUE) {
			employeeTypeImpl.setAddeddate(null);
		}
		else {
			employeeTypeImpl.setAddeddate(new Date(addeddate));
		}

		if (description == null) {
			employeeTypeImpl.setDescription("");
		}
		else {
			employeeTypeImpl.setDescription(description);
		}

		employeeTypeImpl.resetOriginalValues();

		return employeeTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeetypeId = objectInput.readLong();
		typeName = objectInput.readUTF();

		pfDeduct = objectInput.readLong();

		status = objectInput.readInt();

		companyId = objectInput.readLong();
		addeddate = objectInput.readLong();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(employeetypeId);

		if (typeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeName);
		}

		objectOutput.writeLong(pfDeduct);

		objectOutput.writeInt(status);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(addeddate);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long employeetypeId;
	public String typeName;
	public long pfDeduct;
	public int status;
	public long companyId;
	public long addeddate;
	public String description;
}