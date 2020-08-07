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

import com.liferay.famocom.erpcloud.model.HolidayCalenderManagement;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HolidayCalenderManagement in entity cache.
 *
 * @author Samaresh
 * @see HolidayCalenderManagement
 * @generated
 */
@ProviderType
public class HolidayCalenderManagementCacheModel implements CacheModel<HolidayCalenderManagement>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HolidayCalenderManagementCacheModel)) {
			return false;
		}

		HolidayCalenderManagementCacheModel holidayCalenderManagementCacheModel = (HolidayCalenderManagementCacheModel)obj;

		if (holidayId == holidayCalenderManagementCacheModel.holidayId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, holidayId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{holidayId=");
		sb.append(holidayId);
		sb.append(", holidayDate=");
		sb.append(holidayDate);
		sb.append(", holidayName=");
		sb.append(holidayName);
		sb.append(", holidayStartDate=");
		sb.append(holidayStartDate);
		sb.append(", holidayEndDate=");
		sb.append(holidayEndDate);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HolidayCalenderManagement toEntityModel() {
		HolidayCalenderManagementImpl holidayCalenderManagementImpl = new HolidayCalenderManagementImpl();

		holidayCalenderManagementImpl.setHolidayId(holidayId);

		if (holidayDate == Long.MIN_VALUE) {
			holidayCalenderManagementImpl.setHolidayDate(null);
		}
		else {
			holidayCalenderManagementImpl.setHolidayDate(new Date(holidayDate));
		}

		if (holidayName == null) {
			holidayCalenderManagementImpl.setHolidayName("");
		}
		else {
			holidayCalenderManagementImpl.setHolidayName(holidayName);
		}

		if (holidayStartDate == Long.MIN_VALUE) {
			holidayCalenderManagementImpl.setHolidayStartDate(null);
		}
		else {
			holidayCalenderManagementImpl.setHolidayStartDate(new Date(
					holidayStartDate));
		}

		if (holidayEndDate == Long.MIN_VALUE) {
			holidayCalenderManagementImpl.setHolidayEndDate(null);
		}
		else {
			holidayCalenderManagementImpl.setHolidayEndDate(new Date(
					holidayEndDate));
		}

		holidayCalenderManagementImpl.setCompanyId(companyId);

		holidayCalenderManagementImpl.resetOriginalValues();

		return holidayCalenderManagementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		holidayId = objectInput.readLong();
		holidayDate = objectInput.readLong();
		holidayName = objectInput.readUTF();
		holidayStartDate = objectInput.readLong();
		holidayEndDate = objectInput.readLong();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(holidayId);
		objectOutput.writeLong(holidayDate);

		if (holidayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(holidayName);
		}

		objectOutput.writeLong(holidayStartDate);
		objectOutput.writeLong(holidayEndDate);

		objectOutput.writeLong(companyId);
	}

	public long holidayId;
	public long holidayDate;
	public String holidayName;
	public long holidayStartDate;
	public long holidayEndDate;
	public long companyId;
}