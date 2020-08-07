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

import com.liferay.famocom.erpcloud.model.StopPay;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StopPay in entity cache.
 *
 * @author Samaresh
 * @see StopPay
 * @generated
 */
@ProviderType
public class StopPayCacheModel implements CacheModel<StopPay>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StopPayCacheModel)) {
			return false;
		}

		StopPayCacheModel stopPayCacheModel = (StopPayCacheModel)obj;

		if (stopPayId == stopPayCacheModel.stopPayId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stopPayId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{stopPayId=");
		sb.append(stopPayId);
		sb.append(", monthYear=");
		sb.append(monthYear);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", status=");
		sb.append(status);
		sb.append(", isLock=");
		sb.append(isLock);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StopPay toEntityModel() {
		StopPayImpl stopPayImpl = new StopPayImpl();

		stopPayImpl.setStopPayId(stopPayId);
		stopPayImpl.setMonthYear(monthYear);
		stopPayImpl.setEmployeeId(employeeId);

		if (reason == null) {
			stopPayImpl.setReason("");
		}
		else {
			stopPayImpl.setReason(reason);
		}

		stopPayImpl.setCreatedBy(createdBy);

		if (createdDate == Long.MIN_VALUE) {
			stopPayImpl.setCreatedDate(null);
		}
		else {
			stopPayImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stopPayImpl.setModifiedDate(null);
		}
		else {
			stopPayImpl.setModifiedDate(new Date(modifiedDate));
		}

		stopPayImpl.setModifiedBy(modifiedBy);
		stopPayImpl.setStatus(status);
		stopPayImpl.setIsLock(isLock);

		stopPayImpl.resetOriginalValues();

		return stopPayImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stopPayId = objectInput.readLong();

		monthYear = objectInput.readLong();

		employeeId = objectInput.readLong();
		reason = objectInput.readUTF();

		createdBy = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		status = objectInput.readLong();

		isLock = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stopPayId);

		objectOutput.writeLong(monthYear);

		objectOutput.writeLong(employeeId);

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(status);

		objectOutput.writeLong(isLock);
	}

	public long stopPayId;
	public long monthYear;
	public long employeeId;
	public String reason;
	public long createdBy;
	public long createdDate;
	public long modifiedDate;
	public long modifiedBy;
	public long status;
	public long isLock;
}