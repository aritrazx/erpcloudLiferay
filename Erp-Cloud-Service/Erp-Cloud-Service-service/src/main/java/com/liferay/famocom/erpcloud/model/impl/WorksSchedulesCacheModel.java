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

import com.liferay.famocom.erpcloud.model.WorksSchedules;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorksSchedules in entity cache.
 *
 * @author Samaresh
 * @see WorksSchedules
 * @generated
 */
@ProviderType
public class WorksSchedulesCacheModel implements CacheModel<WorksSchedules>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorksSchedulesCacheModel)) {
			return false;
		}

		WorksSchedulesCacheModel worksSchedulesCacheModel = (WorksSchedulesCacheModel)obj;

		if (worksSchedulesId == worksSchedulesCacheModel.worksSchedulesId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, worksSchedulesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{worksSchedulesId=");
		sb.append(worksSchedulesId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", schedulesId=");
		sb.append(schedulesId);
		sb.append(", islock=");
		sb.append(islock);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorksSchedules toEntityModel() {
		WorksSchedulesImpl worksSchedulesImpl = new WorksSchedulesImpl();

		worksSchedulesImpl.setWorksSchedulesId(worksSchedulesId);
		worksSchedulesImpl.setCompanyId(companyId);
		worksSchedulesImpl.setEmployeeId(employeeId);

		if (fromDate == Long.MIN_VALUE) {
			worksSchedulesImpl.setFromDate(null);
		}
		else {
			worksSchedulesImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			worksSchedulesImpl.setToDate(null);
		}
		else {
			worksSchedulesImpl.setToDate(new Date(toDate));
		}

		worksSchedulesImpl.setSchedulesId(schedulesId);
		worksSchedulesImpl.setIslock(islock);
		worksSchedulesImpl.setStatus(status);

		if (createDate == Long.MIN_VALUE) {
			worksSchedulesImpl.setCreateDate(null);
		}
		else {
			worksSchedulesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			worksSchedulesImpl.setModifiedDate(null);
		}
		else {
			worksSchedulesImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			worksSchedulesImpl.setDescription("");
		}
		else {
			worksSchedulesImpl.setDescription(description);
		}

		worksSchedulesImpl.resetOriginalValues();

		return worksSchedulesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		worksSchedulesId = objectInput.readLong();

		companyId = objectInput.readLong();

		employeeId = objectInput.readLong();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();

		schedulesId = objectInput.readLong();

		islock = objectInput.readInt();

		status = objectInput.readInt();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(worksSchedulesId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		objectOutput.writeLong(schedulesId);

		objectOutput.writeInt(islock);

		objectOutput.writeInt(status);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long worksSchedulesId;
	public long companyId;
	public long employeeId;
	public long fromDate;
	public long toDate;
	public long schedulesId;
	public int islock;
	public int status;
	public long createDate;
	public long modifiedDate;
	public String description;
}