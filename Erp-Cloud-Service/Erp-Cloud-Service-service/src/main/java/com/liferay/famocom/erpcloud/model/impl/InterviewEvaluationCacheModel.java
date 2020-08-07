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

import com.liferay.famocom.erpcloud.model.InterviewEvaluation;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing InterviewEvaluation in entity cache.
 *
 * @author Samaresh
 * @see InterviewEvaluation
 * @generated
 */
@ProviderType
public class InterviewEvaluationCacheModel implements CacheModel<InterviewEvaluation>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InterviewEvaluationCacheModel)) {
			return false;
		}

		InterviewEvaluationCacheModel interviewEvaluationCacheModel = (InterviewEvaluationCacheModel)obj;

		if (evaluationId == interviewEvaluationCacheModel.evaluationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, evaluationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{evaluationId=");
		sb.append(evaluationId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", evaluationName=");
		sb.append(evaluationName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InterviewEvaluation toEntityModel() {
		InterviewEvaluationImpl interviewEvaluationImpl = new InterviewEvaluationImpl();

		interviewEvaluationImpl.setEvaluationId(evaluationId);
		interviewEvaluationImpl.setRoleId(roleId);

		if (evaluationName == null) {
			interviewEvaluationImpl.setEvaluationName("");
		}
		else {
			interviewEvaluationImpl.setEvaluationName(evaluationName);
		}

		interviewEvaluationImpl.resetOriginalValues();

		return interviewEvaluationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		evaluationId = objectInput.readLong();

		roleId = objectInput.readLong();
		evaluationName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(evaluationId);

		objectOutput.writeLong(roleId);

		if (evaluationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(evaluationName);
		}
	}

	public long evaluationId;
	public long roleId;
	public String evaluationName;
}