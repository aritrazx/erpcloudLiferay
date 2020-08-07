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

import com.liferay.famocom.erpcloud.model.Evaluation;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Evaluation in entity cache.
 *
 * @author Samaresh
 * @see Evaluation
 * @generated
 */
@ProviderType
public class EvaluationCacheModel implements CacheModel<Evaluation>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EvaluationCacheModel)) {
			return false;
		}

		EvaluationCacheModel evaluationCacheModel = (EvaluationCacheModel)obj;

		if (evaluationId == evaluationCacheModel.evaluationId) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{evaluationId=");
		sb.append(evaluationId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", evaluatedBy=");
		sb.append(evaluatedBy);
		sb.append(", evalMessage=");
		sb.append(evalMessage);
		sb.append(", evalDate=");
		sb.append(evalDate);
		sb.append(", evalRating=");
		sb.append(evalRating);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Evaluation toEntityModel() {
		EvaluationImpl evaluationImpl = new EvaluationImpl();

		evaluationImpl.setEvaluationId(evaluationId);
		evaluationImpl.setEmployeeId(employeeId);
		evaluationImpl.setEvaluatedBy(evaluatedBy);

		if (evalMessage == null) {
			evaluationImpl.setEvalMessage("");
		}
		else {
			evaluationImpl.setEvalMessage(evalMessage);
		}

		if (evalDate == Long.MIN_VALUE) {
			evaluationImpl.setEvalDate(null);
		}
		else {
			evaluationImpl.setEvalDate(new Date(evalDate));
		}

		evaluationImpl.setEvalRating(evalRating);

		evaluationImpl.resetOriginalValues();

		return evaluationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		evaluationId = objectInput.readLong();

		employeeId = objectInput.readLong();

		evaluatedBy = objectInput.readLong();
		evalMessage = objectInput.readUTF();
		evalDate = objectInput.readLong();

		evalRating = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(evaluationId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(evaluatedBy);

		if (evalMessage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(evalMessage);
		}

		objectOutput.writeLong(evalDate);

		objectOutput.writeInt(evalRating);
	}

	public long evaluationId;
	public long employeeId;
	public long evaluatedBy;
	public String evalMessage;
	public long evalDate;
	public int evalRating;
}