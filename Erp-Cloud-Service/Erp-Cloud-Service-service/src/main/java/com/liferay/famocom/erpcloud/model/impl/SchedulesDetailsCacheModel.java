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

import com.liferay.famocom.erpcloud.model.SchedulesDetails;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SchedulesDetails in entity cache.
 *
 * @author Samaresh
 * @see SchedulesDetails
 * @generated
 */
@ProviderType
public class SchedulesDetailsCacheModel implements CacheModel<SchedulesDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SchedulesDetailsCacheModel)) {
			return false;
		}

		SchedulesDetailsCacheModel schedulesDetailsCacheModel = (SchedulesDetailsCacheModel)obj;

		if (schedulesDetailsId == schedulesDetailsCacheModel.schedulesDetailsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, schedulesDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{schedulesDetailsId=");
		sb.append(schedulesDetailsId);
		sb.append(", schedulesDate=");
		sb.append(schedulesDate);
		sb.append(", worksSchedulesId=");
		sb.append(worksSchedulesId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SchedulesDetails toEntityModel() {
		SchedulesDetailsImpl schedulesDetailsImpl = new SchedulesDetailsImpl();

		schedulesDetailsImpl.setSchedulesDetailsId(schedulesDetailsId);

		if (schedulesDate == Long.MIN_VALUE) {
			schedulesDetailsImpl.setSchedulesDate(null);
		}
		else {
			schedulesDetailsImpl.setSchedulesDate(new Date(schedulesDate));
		}

		schedulesDetailsImpl.setWorksSchedulesId(worksSchedulesId);
		schedulesDetailsImpl.setEmployeeId(employeeId);
		schedulesDetailsImpl.setCompanyId(companyId);

		schedulesDetailsImpl.resetOriginalValues();

		return schedulesDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		schedulesDetailsId = objectInput.readLong();
		schedulesDate = objectInput.readLong();

		worksSchedulesId = objectInput.readLong();

		employeeId = objectInput.readLong();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(schedulesDetailsId);
		objectOutput.writeLong(schedulesDate);

		objectOutput.writeLong(worksSchedulesId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(companyId);
	}

	public long schedulesDetailsId;
	public long schedulesDate;
	public long worksSchedulesId;
	public long employeeId;
	public long companyId;
}