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

import com.liferay.famocom.erpcloud.model.ProjectTask;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectTask in entity cache.
 *
 * @author Samaresh
 * @see ProjectTask
 * @generated
 */
@ProviderType
public class ProjectTaskCacheModel implements CacheModel<ProjectTask>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectTaskCacheModel)) {
			return false;
		}

		ProjectTaskCacheModel projectTaskCacheModel = (ProjectTaskCacheModel)obj;

		if (projectTaskId == projectTaskCacheModel.projectTaskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectTaskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{projectTaskId=");
		sb.append(projectTaskId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", taskName=");
		sb.append(taskName);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", hours=");
		sb.append(hours);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectTask toEntityModel() {
		ProjectTaskImpl projectTaskImpl = new ProjectTaskImpl();

		projectTaskImpl.setProjectTaskId(projectTaskId);
		projectTaskImpl.setProjectId(projectId);
		projectTaskImpl.setEmployeeId(employeeId);
		projectTaskImpl.setTaskId(taskId);

		if (taskName == null) {
			projectTaskImpl.setTaskName("");
		}
		else {
			projectTaskImpl.setTaskName(taskName);
		}

		if (startDate == Long.MIN_VALUE) {
			projectTaskImpl.setStartDate(null);
		}
		else {
			projectTaskImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			projectTaskImpl.setEndDate(null);
		}
		else {
			projectTaskImpl.setEndDate(new Date(endDate));
		}

		projectTaskImpl.setHours(hours);

		if (addedDate == Long.MIN_VALUE) {
			projectTaskImpl.setAddedDate(null);
		}
		else {
			projectTaskImpl.setAddedDate(new Date(addedDate));
		}

		projectTaskImpl.resetOriginalValues();

		return projectTaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectTaskId = objectInput.readLong();

		projectId = objectInput.readLong();

		employeeId = objectInput.readLong();

		taskId = objectInput.readLong();
		taskName = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		hours = objectInput.readDouble();
		addedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectTaskId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(taskId);

		if (taskName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taskName);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeDouble(hours);
		objectOutput.writeLong(addedDate);
	}

	public long projectTaskId;
	public long projectId;
	public long employeeId;
	public long taskId;
	public String taskName;
	public long startDate;
	public long endDate;
	public double hours;
	public long addedDate;
}