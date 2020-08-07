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

import com.liferay.famocom.erpcloud.model.TaskMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaskMaster in entity cache.
 *
 * @author Samaresh
 * @see TaskMaster
 * @generated
 */
@ProviderType
public class TaskMasterCacheModel implements CacheModel<TaskMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskMasterCacheModel)) {
			return false;
		}

		TaskMasterCacheModel taskMasterCacheModel = (TaskMasterCacheModel)obj;

		if (taskId == taskMasterCacheModel.taskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{taskId=");
		sb.append(taskId);
		sb.append(", taskName=");
		sb.append(taskName);
		sb.append(", taskDesc=");
		sb.append(taskDesc);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskMaster toEntityModel() {
		TaskMasterImpl taskMasterImpl = new TaskMasterImpl();

		taskMasterImpl.setTaskId(taskId);

		if (taskName == null) {
			taskMasterImpl.setTaskName("");
		}
		else {
			taskMasterImpl.setTaskName(taskName);
		}

		if (taskDesc == null) {
			taskMasterImpl.setTaskDesc("");
		}
		else {
			taskMasterImpl.setTaskDesc(taskDesc);
		}

		taskMasterImpl.setStatus(status);

		if (createDate == Long.MIN_VALUE) {
			taskMasterImpl.setCreateDate(null);
		}
		else {
			taskMasterImpl.setCreateDate(new Date(createDate));
		}

		taskMasterImpl.resetOriginalValues();

		return taskMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taskId = objectInput.readLong();
		taskName = objectInput.readUTF();
		taskDesc = objectInput.readUTF();

		status = objectInput.readInt();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(taskId);

		if (taskName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taskName);
		}

		if (taskDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taskDesc);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(createDate);
	}

	public long taskId;
	public String taskName;
	public String taskDesc;
	public int status;
	public long createDate;
}