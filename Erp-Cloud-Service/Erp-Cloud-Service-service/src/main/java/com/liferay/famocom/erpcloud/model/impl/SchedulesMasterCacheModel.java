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

import com.liferay.famocom.erpcloud.model.SchedulesMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SchedulesMaster in entity cache.
 *
 * @author Samaresh
 * @see SchedulesMaster
 * @generated
 */
@ProviderType
public class SchedulesMasterCacheModel implements CacheModel<SchedulesMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SchedulesMasterCacheModel)) {
			return false;
		}

		SchedulesMasterCacheModel schedulesMasterCacheModel = (SchedulesMasterCacheModel)obj;

		if (schedulesId == schedulesMasterCacheModel.schedulesId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, schedulesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{schedulesId=");
		sb.append(schedulesId);
		sb.append(", schedulesName=");
		sb.append(schedulesName);
		sb.append(", schedulesDescription=");
		sb.append(schedulesDescription);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SchedulesMaster toEntityModel() {
		SchedulesMasterImpl schedulesMasterImpl = new SchedulesMasterImpl();

		schedulesMasterImpl.setSchedulesId(schedulesId);

		if (schedulesName == null) {
			schedulesMasterImpl.setSchedulesName("");
		}
		else {
			schedulesMasterImpl.setSchedulesName(schedulesName);
		}

		if (schedulesDescription == null) {
			schedulesMasterImpl.setSchedulesDescription("");
		}
		else {
			schedulesMasterImpl.setSchedulesDescription(schedulesDescription);
		}

		if (createDate == Long.MIN_VALUE) {
			schedulesMasterImpl.setCreateDate(null);
		}
		else {
			schedulesMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			schedulesMasterImpl.setModifiedDate(null);
		}
		else {
			schedulesMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		schedulesMasterImpl.setStatus(status);

		schedulesMasterImpl.resetOriginalValues();

		return schedulesMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		schedulesId = objectInput.readLong();
		schedulesName = objectInput.readUTF();
		schedulesDescription = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(schedulesId);

		if (schedulesName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(schedulesName);
		}

		if (schedulesDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(schedulesDescription);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);
	}

	public long schedulesId;
	public String schedulesName;
	public String schedulesDescription;
	public long createDate;
	public long modifiedDate;
	public int status;
}