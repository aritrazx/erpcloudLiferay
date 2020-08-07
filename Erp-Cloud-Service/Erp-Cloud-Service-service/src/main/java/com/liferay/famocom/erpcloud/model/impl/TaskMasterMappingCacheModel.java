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

import com.liferay.famocom.erpcloud.model.TaskMasterMapping;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaskMasterMapping in entity cache.
 *
 * @author Samaresh
 * @see TaskMasterMapping
 * @generated
 */
@ProviderType
public class TaskMasterMappingCacheModel implements CacheModel<TaskMasterMapping>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskMasterMappingCacheModel)) {
			return false;
		}

		TaskMasterMappingCacheModel taskMasterMappingCacheModel = (TaskMasterMappingCacheModel)obj;

		if (taskMappingId == taskMasterMappingCacheModel.taskMappingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskMappingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{taskMappingId=");
		sb.append(taskMappingId);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskMasterMapping toEntityModel() {
		TaskMasterMappingImpl taskMasterMappingImpl = new TaskMasterMappingImpl();

		taskMasterMappingImpl.setTaskMappingId(taskMappingId);
		taskMasterMappingImpl.setTaskId(taskId);
		taskMasterMappingImpl.setProjectId(projectId);

		if (createDate == Long.MIN_VALUE) {
			taskMasterMappingImpl.setCreateDate(null);
		}
		else {
			taskMasterMappingImpl.setCreateDate(new Date(createDate));
		}

		taskMasterMappingImpl.resetOriginalValues();

		return taskMasterMappingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taskMappingId = objectInput.readLong();

		taskId = objectInput.readLong();

		projectId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(taskMappingId);

		objectOutput.writeLong(taskId);

		objectOutput.writeLong(projectId);
		objectOutput.writeLong(createDate);
	}

	public long taskMappingId;
	public long taskId;
	public long projectId;
	public long createDate;
}