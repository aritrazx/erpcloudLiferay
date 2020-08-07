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

import com.liferay.famocom.erpcloud.model.YearSetting;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing YearSetting in entity cache.
 *
 * @author Samaresh
 * @see YearSetting
 * @generated
 */
@ProviderType
public class YearSettingCacheModel implements CacheModel<YearSetting>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof YearSettingCacheModel)) {
			return false;
		}

		YearSettingCacheModel yearSettingCacheModel = (YearSettingCacheModel)obj;

		if (yearSettingId == yearSettingCacheModel.yearSettingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, yearSettingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{yearSettingId=");
		sb.append(yearSettingId);
		sb.append(", financialYearStartDate=");
		sb.append(financialYearStartDate);
		sb.append(", financialYearEndDate=");
		sb.append(financialYearEndDate);
		sb.append(", calendarStartDate=");
		sb.append(calendarStartDate);
		sb.append(", calendarEndDate=");
		sb.append(calendarEndDate);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public YearSetting toEntityModel() {
		YearSettingImpl yearSettingImpl = new YearSettingImpl();

		yearSettingImpl.setYearSettingId(yearSettingId);

		if (financialYearStartDate == Long.MIN_VALUE) {
			yearSettingImpl.setFinancialYearStartDate(null);
		}
		else {
			yearSettingImpl.setFinancialYearStartDate(new Date(
					financialYearStartDate));
		}

		if (financialYearEndDate == Long.MIN_VALUE) {
			yearSettingImpl.setFinancialYearEndDate(null);
		}
		else {
			yearSettingImpl.setFinancialYearEndDate(new Date(
					financialYearEndDate));
		}

		if (calendarStartDate == Long.MIN_VALUE) {
			yearSettingImpl.setCalendarStartDate(null);
		}
		else {
			yearSettingImpl.setCalendarStartDate(new Date(calendarStartDate));
		}

		if (calendarEndDate == Long.MIN_VALUE) {
			yearSettingImpl.setCalendarEndDate(null);
		}
		else {
			yearSettingImpl.setCalendarEndDate(new Date(calendarEndDate));
		}

		yearSettingImpl.setIsActive(isActive);

		yearSettingImpl.resetOriginalValues();

		return yearSettingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		yearSettingId = objectInput.readLong();
		financialYearStartDate = objectInput.readLong();
		financialYearEndDate = objectInput.readLong();
		calendarStartDate = objectInput.readLong();
		calendarEndDate = objectInput.readLong();

		isActive = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(yearSettingId);
		objectOutput.writeLong(financialYearStartDate);
		objectOutput.writeLong(financialYearEndDate);
		objectOutput.writeLong(calendarStartDate);
		objectOutput.writeLong(calendarEndDate);

		objectOutput.writeInt(isActive);
	}

	public long yearSettingId;
	public long financialYearStartDate;
	public long financialYearEndDate;
	public long calendarStartDate;
	public long calendarEndDate;
	public int isActive;
}