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

import com.liferay.famocom.erpcloud.model.EmpPayStructure;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EmpPayStructure in entity cache.
 *
 * @author Samaresh
 * @see EmpPayStructure
 * @generated
 */
@ProviderType
public class EmpPayStructureCacheModel implements CacheModel<EmpPayStructure>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpPayStructureCacheModel)) {
			return false;
		}

		EmpPayStructureCacheModel empPayStructureCacheModel = (EmpPayStructureCacheModel)obj;

		if (empPayStructureId == empPayStructureCacheModel.empPayStructureId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, empPayStructureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{empPayStructureId=");
		sb.append(empPayStructureId);
		sb.append(", payComponentId=");
		sb.append(payComponentId);
		sb.append(", componentValue=");
		sb.append(componentValue);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpPayStructure toEntityModel() {
		EmpPayStructureImpl empPayStructureImpl = new EmpPayStructureImpl();

		empPayStructureImpl.setEmpPayStructureId(empPayStructureId);
		empPayStructureImpl.setPayComponentId(payComponentId);
		empPayStructureImpl.setComponentValue(componentValue);
		empPayStructureImpl.setEmployeeId(employeeId);

		empPayStructureImpl.resetOriginalValues();

		return empPayStructureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empPayStructureId = objectInput.readLong();

		payComponentId = objectInput.readLong();

		componentValue = objectInput.readDouble();

		employeeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empPayStructureId);

		objectOutput.writeLong(payComponentId);

		objectOutput.writeDouble(componentValue);

		objectOutput.writeLong(employeeId);
	}

	public long empPayStructureId;
	public long payComponentId;
	public double componentValue;
	public long employeeId;
}