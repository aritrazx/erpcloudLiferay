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

import com.liferay.famocom.erpcloud.model.ProjectMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectMaster in entity cache.
 *
 * @author Samaresh
 * @see ProjectMaster
 * @generated
 */
@ProviderType
public class ProjectMasterCacheModel implements CacheModel<ProjectMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectMasterCacheModel)) {
			return false;
		}

		ProjectMasterCacheModel projectMasterCacheModel = (ProjectMasterCacheModel)obj;

		if (projectId == projectMasterCacheModel.projectId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{projectId=");
		sb.append(projectId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", projectName=");
		sb.append(projectName);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", projectStatus=");
		sb.append(projectStatus);
		sb.append(", projectStatusId=");
		sb.append(projectStatusId);
		sb.append(", projectDesc=");
		sb.append(projectDesc);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", totalAmount=");
		sb.append(totalAmount);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectMaster toEntityModel() {
		ProjectMasterImpl projectMasterImpl = new ProjectMasterImpl();

		projectMasterImpl.setProjectId(projectId);
		projectMasterImpl.setCompanyId(companyId);

		if (projectName == null) {
			projectMasterImpl.setProjectName("");
		}
		else {
			projectMasterImpl.setProjectName(projectName);
		}

		projectMasterImpl.setClientId(clientId);
		projectMasterImpl.setEmployeeId(employeeId);
		projectMasterImpl.setProjectStatus(projectStatus);
		projectMasterImpl.setProjectStatusId(projectStatusId);

		if (projectDesc == null) {
			projectMasterImpl.setProjectDesc("");
		}
		else {
			projectMasterImpl.setProjectDesc(projectDesc);
		}

		if (startDate == Long.MIN_VALUE) {
			projectMasterImpl.setStartDate(null);
		}
		else {
			projectMasterImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			projectMasterImpl.setEndDate(null);
		}
		else {
			projectMasterImpl.setEndDate(new Date(endDate));
		}

		projectMasterImpl.setTotalAmount(totalAmount);

		if (addedDate == Long.MIN_VALUE) {
			projectMasterImpl.setAddedDate(null);
		}
		else {
			projectMasterImpl.setAddedDate(new Date(addedDate));
		}

		projectMasterImpl.resetOriginalValues();

		return projectMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectId = objectInput.readLong();

		companyId = objectInput.readLong();
		projectName = objectInput.readUTF();

		clientId = objectInput.readLong();

		employeeId = objectInput.readLong();

		projectStatus = objectInput.readInt();

		projectStatusId = objectInput.readLong();
		projectDesc = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		totalAmount = objectInput.readDouble();
		addedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectId);

		objectOutput.writeLong(companyId);

		if (projectName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectName);
		}

		objectOutput.writeLong(clientId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeInt(projectStatus);

		objectOutput.writeLong(projectStatusId);

		if (projectDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectDesc);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeDouble(totalAmount);
		objectOutput.writeLong(addedDate);
	}

	public long projectId;
	public long companyId;
	public String projectName;
	public long clientId;
	public long employeeId;
	public int projectStatus;
	public long projectStatusId;
	public String projectDesc;
	public long startDate;
	public long endDate;
	public double totalAmount;
	public long addedDate;
}