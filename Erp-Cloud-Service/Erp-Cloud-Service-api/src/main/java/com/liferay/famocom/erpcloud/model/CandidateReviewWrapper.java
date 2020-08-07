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

package com.liferay.famocom.erpcloud.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CandidateReview}.
 * </p>
 *
 * @author Samaresh
 * @see CandidateReview
 * @generated
 */
@ProviderType
public class CandidateReviewWrapper implements CandidateReview,
	ModelWrapper<CandidateReview> {
	public CandidateReviewWrapper(CandidateReview candidateReview) {
		_candidateReview = candidateReview;
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateReview.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateReview.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidateReviewId", getCandidateReviewId());
		attributes.put("recruitProcessId", getRecruitProcessId());
		attributes.put("evaluationId", getEvaluationId());
		attributes.put("scroring", getScroring());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long candidateReviewId = (Long)attributes.get("candidateReviewId");

		if (candidateReviewId != null) {
			setCandidateReviewId(candidateReviewId);
		}

		Long recruitProcessId = (Long)attributes.get("recruitProcessId");

		if (recruitProcessId != null) {
			setRecruitProcessId(recruitProcessId);
		}

		Long evaluationId = (Long)attributes.get("evaluationId");

		if (evaluationId != null) {
			setEvaluationId(evaluationId);
		}

		String scroring = (String)attributes.get("scroring");

		if (scroring != null) {
			setScroring(scroring);
		}
	}

	@Override
	public Object clone() {
		return new CandidateReviewWrapper((CandidateReview)_candidateReview.clone());
	}

	@Override
	public int compareTo(CandidateReview candidateReview) {
		return _candidateReview.compareTo(candidateReview);
	}

	/**
	* Returns the candidate review ID of this candidate review.
	*
	* @return the candidate review ID of this candidate review
	*/
	@Override
	public long getCandidateReviewId() {
		return _candidateReview.getCandidateReviewId();
	}

	/**
	* Returns the evaluation ID of this candidate review.
	*
	* @return the evaluation ID of this candidate review
	*/
	@Override
	public long getEvaluationId() {
		return _candidateReview.getEvaluationId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _candidateReview.getExpandoBridge();
	}

	/**
	* Returns the primary key of this candidate review.
	*
	* @return the primary key of this candidate review
	*/
	@Override
	public long getPrimaryKey() {
		return _candidateReview.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateReview.getPrimaryKeyObj();
	}

	/**
	* Returns the recruit process ID of this candidate review.
	*
	* @return the recruit process ID of this candidate review
	*/
	@Override
	public long getRecruitProcessId() {
		return _candidateReview.getRecruitProcessId();
	}

	/**
	* Returns the scroring of this candidate review.
	*
	* @return the scroring of this candidate review
	*/
	@Override
	public String getScroring() {
		return _candidateReview.getScroring();
	}

	@Override
	public int hashCode() {
		return _candidateReview.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _candidateReview.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _candidateReview.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _candidateReview.isNew();
	}

	@Override
	public void persist() {
		_candidateReview.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_candidateReview.setCachedModel(cachedModel);
	}

	/**
	* Sets the candidate review ID of this candidate review.
	*
	* @param candidateReviewId the candidate review ID of this candidate review
	*/
	@Override
	public void setCandidateReviewId(long candidateReviewId) {
		_candidateReview.setCandidateReviewId(candidateReviewId);
	}

	/**
	* Sets the evaluation ID of this candidate review.
	*
	* @param evaluationId the evaluation ID of this candidate review
	*/
	@Override
	public void setEvaluationId(long evaluationId) {
		_candidateReview.setEvaluationId(evaluationId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_candidateReview.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_candidateReview.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_candidateReview.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_candidateReview.setNew(n);
	}

	/**
	* Sets the primary key of this candidate review.
	*
	* @param primaryKey the primary key of this candidate review
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_candidateReview.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_candidateReview.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the recruit process ID of this candidate review.
	*
	* @param recruitProcessId the recruit process ID of this candidate review
	*/
	@Override
	public void setRecruitProcessId(long recruitProcessId) {
		_candidateReview.setRecruitProcessId(recruitProcessId);
	}

	/**
	* Sets the scroring of this candidate review.
	*
	* @param scroring the scroring of this candidate review
	*/
	@Override
	public void setScroring(String scroring) {
		_candidateReview.setScroring(scroring);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CandidateReview> toCacheModel() {
		return _candidateReview.toCacheModel();
	}

	@Override
	public CandidateReview toEscapedModel() {
		return new CandidateReviewWrapper(_candidateReview.toEscapedModel());
	}

	@Override
	public String toString() {
		return _candidateReview.toString();
	}

	@Override
	public CandidateReview toUnescapedModel() {
		return new CandidateReviewWrapper(_candidateReview.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _candidateReview.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateReviewWrapper)) {
			return false;
		}

		CandidateReviewWrapper candidateReviewWrapper = (CandidateReviewWrapper)obj;

		if (Objects.equals(_candidateReview,
					candidateReviewWrapper._candidateReview)) {
			return true;
		}

		return false;
	}

	@Override
	public CandidateReview getWrappedModel() {
		return _candidateReview;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _candidateReview.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _candidateReview.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_candidateReview.resetOriginalValues();
	}

	private final CandidateReview _candidateReview;
}