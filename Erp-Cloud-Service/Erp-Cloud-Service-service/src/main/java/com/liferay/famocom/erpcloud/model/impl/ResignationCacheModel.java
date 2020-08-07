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

import com.liferay.famocom.erpcloud.model.Resignation;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Resignation in entity cache.
 *
 * @author Samaresh
 * @see Resignation
 * @generated
 */
@ProviderType
public class ResignationCacheModel implements CacheModel<Resignation>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ResignationCacheModel)) {
			return false;
		}

		ResignationCacheModel resignationCacheModel = (ResignationCacheModel)obj;

		if (ResignationId == resignationCacheModel.ResignationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ResignationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{ResignationId=");
		sb.append(ResignationId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", resignationDate=");
		sb.append(resignationDate);
		sb.append(", resignationSubDate=");
		sb.append(resignationSubDate);
		sb.append(", Description=");
		sb.append(Description);
		sb.append(", managerId=");
		sb.append(managerId);
		sb.append(", mancomment=");
		sb.append(mancomment);
		sb.append(", mancommentdate=");
		sb.append(mancommentdate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Resignation toEntityModel() {
		ResignationImpl resignationImpl = new ResignationImpl();

		resignationImpl.setResignationId(ResignationId);
		resignationImpl.setEmployeeId(employeeId);

		if (resignationDate == Long.MIN_VALUE) {
			resignationImpl.setResignationDate(null);
		}
		else {
			resignationImpl.setResignationDate(new Date(resignationDate));
		}

		if (resignationSubDate == Long.MIN_VALUE) {
			resignationImpl.setResignationSubDate(null);
		}
		else {
			resignationImpl.setResignationSubDate(new Date(resignationSubDate));
		}

		if (Description == null) {
			resignationImpl.setDescription("");
		}
		else {
			resignationImpl.setDescription(Description);
		}

		resignationImpl.setManagerId(managerId);

		if (mancomment == null) {
			resignationImpl.setMancomment("");
		}
		else {
			resignationImpl.setMancomment(mancomment);
		}

		if (mancommentdate == Long.MIN_VALUE) {
			resignationImpl.setMancommentdate(null);
		}
		else {
			resignationImpl.setMancommentdate(new Date(mancommentdate));
		}

		resignationImpl.setStatus(status);

		resignationImpl.resetOriginalValues();

		return resignationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ResignationId = objectInput.readLong();

		employeeId = objectInput.readLong();
		resignationDate = objectInput.readLong();
		resignationSubDate = objectInput.readLong();
		Description = objectInput.readUTF();

		managerId = objectInput.readLong();
		mancomment = objectInput.readUTF();
		mancommentdate = objectInput.readLong();

		status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ResignationId);

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(resignationDate);
		objectOutput.writeLong(resignationSubDate);

		if (Description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Description);
		}

		objectOutput.writeLong(managerId);

		if (mancomment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mancomment);
		}

		objectOutput.writeLong(mancommentdate);

		objectOutput.writeBoolean(status);
	}

	public long ResignationId;
	public long employeeId;
	public long resignationDate;
	public long resignationSubDate;
	public String Description;
	public long managerId;
	public String mancomment;
	public long mancommentdate;
	public boolean status;
}