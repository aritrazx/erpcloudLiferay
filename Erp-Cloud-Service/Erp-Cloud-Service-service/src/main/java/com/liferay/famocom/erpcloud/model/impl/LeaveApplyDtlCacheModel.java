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

import com.liferay.famocom.erpcloud.model.LeaveApplyDtl;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveApplyDtl in entity cache.
 *
 * @author Samaresh
 * @see LeaveApplyDtl
 * @generated
 */
@ProviderType
public class LeaveApplyDtlCacheModel implements CacheModel<LeaveApplyDtl>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveApplyDtlCacheModel)) {
			return false;
		}

		LeaveApplyDtlCacheModel leaveApplyDtlCacheModel = (LeaveApplyDtlCacheModel)obj;

		if (leaveApplyDtlId == leaveApplyDtlCacheModel.leaveApplyDtlId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveApplyDtlId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{leaveApplyDtlId=");
		sb.append(leaveApplyDtlId);
		sb.append(", leaveApplyId=");
		sb.append(leaveApplyId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", leaveTypeId=");
		sb.append(leaveTypeId);
		sb.append(", leaveDate=");
		sb.append(leaveDate);
		sb.append(", sessionData=");
		sb.append(sessionData);
		sb.append(", leaveDays=");
		sb.append(leaveDays);
		sb.append(", impectOnSalary=");
		sb.append(impectOnSalary);
		sb.append(", isApprove=");
		sb.append(isApprove);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveApplyDtl toEntityModel() {
		LeaveApplyDtlImpl leaveApplyDtlImpl = new LeaveApplyDtlImpl();

		leaveApplyDtlImpl.setLeaveApplyDtlId(leaveApplyDtlId);
		leaveApplyDtlImpl.setLeaveApplyId(leaveApplyId);
		leaveApplyDtlImpl.setEmployeeId(employeeId);
		leaveApplyDtlImpl.setCompanyId(companyId);
		leaveApplyDtlImpl.setLeaveTypeId(leaveTypeId);

		if (leaveDate == Long.MIN_VALUE) {
			leaveApplyDtlImpl.setLeaveDate(null);
		}
		else {
			leaveApplyDtlImpl.setLeaveDate(new Date(leaveDate));
		}

		if (sessionData == null) {
			leaveApplyDtlImpl.setSessionData("");
		}
		else {
			leaveApplyDtlImpl.setSessionData(sessionData);
		}

		leaveApplyDtlImpl.setLeaveDays(leaveDays);
		leaveApplyDtlImpl.setImpectOnSalary(impectOnSalary);
		leaveApplyDtlImpl.setIsApprove(isApprove);

		leaveApplyDtlImpl.resetOriginalValues();

		return leaveApplyDtlImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveApplyDtlId = objectInput.readLong();

		leaveApplyId = objectInput.readLong();

		employeeId = objectInput.readLong();

		companyId = objectInput.readLong();

		leaveTypeId = objectInput.readLong();
		leaveDate = objectInput.readLong();
		sessionData = objectInput.readUTF();

		leaveDays = objectInput.readDouble();

		impectOnSalary = objectInput.readInt();

		isApprove = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveApplyDtlId);

		objectOutput.writeLong(leaveApplyId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(leaveTypeId);
		objectOutput.writeLong(leaveDate);

		if (sessionData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sessionData);
		}

		objectOutput.writeDouble(leaveDays);

		objectOutput.writeInt(impectOnSalary);

		objectOutput.writeInt(isApprove);
	}

	public long leaveApplyDtlId;
	public long leaveApplyId;
	public long employeeId;
	public long companyId;
	public long leaveTypeId;
	public long leaveDate;
	public String sessionData;
	public double leaveDays;
	public int impectOnSalary;
	public int isApprove;
}