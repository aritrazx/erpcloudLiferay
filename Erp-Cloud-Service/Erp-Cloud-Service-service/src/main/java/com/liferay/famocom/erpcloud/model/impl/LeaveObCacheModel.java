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

import com.liferay.famocom.erpcloud.model.LeaveOb;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LeaveOb in entity cache.
 *
 * @author Samaresh
 * @see LeaveOb
 * @generated
 */
@ProviderType
public class LeaveObCacheModel implements CacheModel<LeaveOb>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveObCacheModel)) {
			return false;
		}

		LeaveObCacheModel leaveObCacheModel = (LeaveObCacheModel)obj;

		if (leaveobId == leaveObCacheModel.leaveobId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveobId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{leaveobId=");
		sb.append(leaveobId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", leaveTypeId=");
		sb.append(leaveTypeId);
		sb.append(", obVal=");
		sb.append(obVal);
		sb.append(", isApprove=");
		sb.append(isApprove);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveOb toEntityModel() {
		LeaveObImpl leaveObImpl = new LeaveObImpl();

		leaveObImpl.setLeaveobId(leaveobId);
		leaveObImpl.setEmployeeId(employeeId);
		leaveObImpl.setLeaveTypeId(leaveTypeId);
		leaveObImpl.setObVal(obVal);
		leaveObImpl.setIsApprove(isApprove);

		leaveObImpl.resetOriginalValues();

		return leaveObImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveobId = objectInput.readLong();

		employeeId = objectInput.readLong();

		leaveTypeId = objectInput.readLong();

		obVal = objectInput.readInt();

		isApprove = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveobId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(leaveTypeId);

		objectOutput.writeInt(obVal);

		objectOutput.writeBoolean(isApprove);
	}

	public long leaveobId;
	public long employeeId;
	public long leaveTypeId;
	public int obVal;
	public boolean isApprove;
}