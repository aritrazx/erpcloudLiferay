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

import com.liferay.famocom.erpcloud.model.CandidateReview;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CandidateReview in entity cache.
 *
 * @author Samaresh
 * @see CandidateReview
 * @generated
 */
@ProviderType
public class CandidateReviewCacheModel implements CacheModel<CandidateReview>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateReviewCacheModel)) {
			return false;
		}

		CandidateReviewCacheModel candidateReviewCacheModel = (CandidateReviewCacheModel)obj;

		if (candidateReviewId == candidateReviewCacheModel.candidateReviewId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, candidateReviewId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{candidateReviewId=");
		sb.append(candidateReviewId);
		sb.append(", recruitProcessId=");
		sb.append(recruitProcessId);
		sb.append(", evaluationId=");
		sb.append(evaluationId);
		sb.append(", scroring=");
		sb.append(scroring);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CandidateReview toEntityModel() {
		CandidateReviewImpl candidateReviewImpl = new CandidateReviewImpl();

		candidateReviewImpl.setCandidateReviewId(candidateReviewId);
		candidateReviewImpl.setRecruitProcessId(recruitProcessId);
		candidateReviewImpl.setEvaluationId(evaluationId);

		if (scroring == null) {
			candidateReviewImpl.setScroring("");
		}
		else {
			candidateReviewImpl.setScroring(scroring);
		}

		candidateReviewImpl.resetOriginalValues();

		return candidateReviewImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		candidateReviewId = objectInput.readLong();

		recruitProcessId = objectInput.readLong();

		evaluationId = objectInput.readLong();
		scroring = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(candidateReviewId);

		objectOutput.writeLong(recruitProcessId);

		objectOutput.writeLong(evaluationId);

		if (scroring == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(scroring);
		}
	}

	public long candidateReviewId;
	public long recruitProcessId;
	public long evaluationId;
	public String scroring;
}