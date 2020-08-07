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

import com.liferay.famocom.erpcloud.model.SalDetails;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SalDetails in entity cache.
 *
 * @author Samaresh
 * @see SalDetails
 * @generated
 */
@ProviderType
public class SalDetailsCacheModel implements CacheModel<SalDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SalDetailsCacheModel)) {
			return false;
		}

		SalDetailsCacheModel salDetailsCacheModel = (SalDetailsCacheModel)obj;

		if (SalDetailsId == salDetailsCacheModel.SalDetailsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, SalDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{SalDetailsId=");
		sb.append(SalDetailsId);
		sb.append(", monthYear=");
		sb.append(monthYear);
		sb.append(", componentId=");
		sb.append(componentId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SalDetails toEntityModel() {
		SalDetailsImpl salDetailsImpl = new SalDetailsImpl();

		salDetailsImpl.setSalDetailsId(SalDetailsId);
		salDetailsImpl.setMonthYear(monthYear);
		salDetailsImpl.setComponentId(componentId);
		salDetailsImpl.setEmployeeId(employeeId);
		salDetailsImpl.setValue(value);

		salDetailsImpl.resetOriginalValues();

		return salDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		SalDetailsId = objectInput.readLong();

		monthYear = objectInput.readLong();

		componentId = objectInput.readLong();

		employeeId = objectInput.readLong();

		value = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(SalDetailsId);

		objectOutput.writeLong(monthYear);

		objectOutput.writeLong(componentId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeDouble(value);
	}

	public long SalDetailsId;
	public long monthYear;
	public long componentId;
	public long employeeId;
	public double value;
}