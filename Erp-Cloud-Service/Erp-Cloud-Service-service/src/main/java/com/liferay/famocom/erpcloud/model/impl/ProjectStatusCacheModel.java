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

import com.liferay.famocom.erpcloud.model.ProjectStatus;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectStatus in entity cache.
 *
 * @author Samaresh
 * @see ProjectStatus
 * @generated
 */
@ProviderType
public class ProjectStatusCacheModel implements CacheModel<ProjectStatus>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectStatusCacheModel)) {
			return false;
		}

		ProjectStatusCacheModel projectStatusCacheModel = (ProjectStatusCacheModel)obj;

		if (projectStatusId == projectStatusCacheModel.projectStatusId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{projectStatusId=");
		sb.append(projectStatusId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", statusName=");
		sb.append(statusName);
		sb.append(", statusColor=");
		sb.append(statusColor);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectStatus toEntityModel() {
		ProjectStatusImpl projectStatusImpl = new ProjectStatusImpl();

		projectStatusImpl.setProjectStatusId(projectStatusId);
		projectStatusImpl.setCompanyId(companyId);

		if (statusName == null) {
			projectStatusImpl.setStatusName("");
		}
		else {
			projectStatusImpl.setStatusName(statusName);
		}

		if (statusColor == null) {
			projectStatusImpl.setStatusColor("");
		}
		else {
			projectStatusImpl.setStatusColor(statusColor);
		}

		if (addedDate == Long.MIN_VALUE) {
			projectStatusImpl.setAddedDate(null);
		}
		else {
			projectStatusImpl.setAddedDate(new Date(addedDate));
		}

		projectStatusImpl.resetOriginalValues();

		return projectStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectStatusId = objectInput.readLong();

		companyId = objectInput.readLong();
		statusName = objectInput.readUTF();
		statusColor = objectInput.readUTF();
		addedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectStatusId);

		objectOutput.writeLong(companyId);

		if (statusName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusName);
		}

		if (statusColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusColor);
		}

		objectOutput.writeLong(addedDate);
	}

	public long projectStatusId;
	public long companyId;
	public String statusName;
	public String statusColor;
	public long addedDate;
}