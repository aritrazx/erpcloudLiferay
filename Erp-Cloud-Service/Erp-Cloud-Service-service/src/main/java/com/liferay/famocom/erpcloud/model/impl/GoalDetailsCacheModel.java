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

import com.liferay.famocom.erpcloud.model.GoalDetails;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GoalDetails in entity cache.
 *
 * @author Samaresh
 * @see GoalDetails
 * @generated
 */
@ProviderType
public class GoalDetailsCacheModel implements CacheModel<GoalDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GoalDetailsCacheModel)) {
			return false;
		}

		GoalDetailsCacheModel goalDetailsCacheModel = (GoalDetailsCacheModel)obj;

		if (goaldetailId == goalDetailsCacheModel.goaldetailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, goaldetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{goaldetailId=");
		sb.append(goaldetailId);
		sb.append(", goalId=");
		sb.append(goalId);
		sb.append(", evaluationId=");
		sb.append(evaluationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", parameter=");
		sb.append(parameter);
		sb.append(", scale=");
		sb.append(scale);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GoalDetails toEntityModel() {
		GoalDetailsImpl goalDetailsImpl = new GoalDetailsImpl();

		goalDetailsImpl.setGoaldetailId(goaldetailId);
		goalDetailsImpl.setGoalId(goalId);
		goalDetailsImpl.setEvaluationId(evaluationId);
		goalDetailsImpl.setCompanyId(companyId);

		if (parameter == null) {
			goalDetailsImpl.setParameter("");
		}
		else {
			goalDetailsImpl.setParameter(parameter);
		}

		if (scale == null) {
			goalDetailsImpl.setScale("");
		}
		else {
			goalDetailsImpl.setScale(scale);
		}

		if (addedDate == Long.MIN_VALUE) {
			goalDetailsImpl.setAddedDate(null);
		}
		else {
			goalDetailsImpl.setAddedDate(new Date(addedDate));
		}

		goalDetailsImpl.resetOriginalValues();

		return goalDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		goaldetailId = objectInput.readLong();

		goalId = objectInput.readLong();

		evaluationId = objectInput.readLong();

		companyId = objectInput.readLong();
		parameter = objectInput.readUTF();
		scale = objectInput.readUTF();
		addedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(goaldetailId);

		objectOutput.writeLong(goalId);

		objectOutput.writeLong(evaluationId);

		objectOutput.writeLong(companyId);

		if (parameter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(parameter);
		}

		if (scale == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(scale);
		}

		objectOutput.writeLong(addedDate);
	}

	public long goaldetailId;
	public long goalId;
	public long evaluationId;
	public long companyId;
	public String parameter;
	public String scale;
	public long addedDate;
}