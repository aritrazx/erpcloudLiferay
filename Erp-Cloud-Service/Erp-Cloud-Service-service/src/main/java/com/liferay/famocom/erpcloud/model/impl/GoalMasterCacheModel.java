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

import com.liferay.famocom.erpcloud.model.GoalMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GoalMaster in entity cache.
 *
 * @author Samaresh
 * @see GoalMaster
 * @generated
 */
@ProviderType
public class GoalMasterCacheModel implements CacheModel<GoalMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GoalMasterCacheModel)) {
			return false;
		}

		GoalMasterCacheModel goalMasterCacheModel = (GoalMasterCacheModel)obj;

		if (goalId == goalMasterCacheModel.goalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, goalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{goalId=");
		sb.append(goalId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", goalName=");
		sb.append(goalName);
		sb.append(", goalDescription=");
		sb.append(goalDescription);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GoalMaster toEntityModel() {
		GoalMasterImpl goalMasterImpl = new GoalMasterImpl();

		goalMasterImpl.setGoalId(goalId);
		goalMasterImpl.setEmployeeId(employeeId);
		goalMasterImpl.setProjectId(projectId);

		if (goalName == null) {
			goalMasterImpl.setGoalName("");
		}
		else {
			goalMasterImpl.setGoalName(goalName);
		}

		if (goalDescription == null) {
			goalMasterImpl.setGoalDescription("");
		}
		else {
			goalMasterImpl.setGoalDescription(goalDescription);
		}

		if (addedDate == Long.MIN_VALUE) {
			goalMasterImpl.setAddedDate(null);
		}
		else {
			goalMasterImpl.setAddedDate(new Date(addedDate));
		}

		goalMasterImpl.resetOriginalValues();

		return goalMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		goalId = objectInput.readLong();

		employeeId = objectInput.readLong();

		projectId = objectInput.readLong();
		goalName = objectInput.readUTF();
		goalDescription = objectInput.readUTF();
		addedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(goalId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(projectId);

		if (goalName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(goalName);
		}

		if (goalDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(goalDescription);
		}

		objectOutput.writeLong(addedDate);
	}

	public long goalId;
	public long employeeId;
	public long projectId;
	public String goalName;
	public String goalDescription;
	public long addedDate;
}