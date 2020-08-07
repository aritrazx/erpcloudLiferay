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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CandidateEvaluation}.
 * </p>
 *
 * @author Samaresh
 * @see CandidateEvaluation
 * @generated
 */
@ProviderType
public class CandidateEvaluationWrapper implements CandidateEvaluation,
	ModelWrapper<CandidateEvaluation> {
	public CandidateEvaluationWrapper(CandidateEvaluation candidateEvaluation) {
		_candidateEvaluation = candidateEvaluation;
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateEvaluation.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateEvaluation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidateEvaluationId", getCandidateEvaluationId());
		attributes.put("interviewerId", getInterviewerId());
		attributes.put("jobPostId", getJobPostId());
		attributes.put("postEvaluationId", getPostEvaluationId());
		attributes.put("applyCandidateId", getApplyCandidateId());
		attributes.put("interviewerRating", getInterviewerRating());
		attributes.put("interviewerRemarks", getInterviewerRemarks());
		attributes.put("hrRemarks", getHrRemarks());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("recruitmentProcessId", getRecruitmentProcessId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long candidateEvaluationId = (Long)attributes.get(
				"candidateEvaluationId");

		if (candidateEvaluationId != null) {
			setCandidateEvaluationId(candidateEvaluationId);
		}

		Long interviewerId = (Long)attributes.get("interviewerId");

		if (interviewerId != null) {
			setInterviewerId(interviewerId);
		}

		Long jobPostId = (Long)attributes.get("jobPostId");

		if (jobPostId != null) {
			setJobPostId(jobPostId);
		}

		Long postEvaluationId = (Long)attributes.get("postEvaluationId");

		if (postEvaluationId != null) {
			setPostEvaluationId(postEvaluationId);
		}

		Long applyCandidateId = (Long)attributes.get("applyCandidateId");

		if (applyCandidateId != null) {
			setApplyCandidateId(applyCandidateId);
		}

		Integer interviewerRating = (Integer)attributes.get("interviewerRating");

		if (interviewerRating != null) {
			setInterviewerRating(interviewerRating);
		}

		String interviewerRemarks = (String)attributes.get("interviewerRemarks");

		if (interviewerRemarks != null) {
			setInterviewerRemarks(interviewerRemarks);
		}

		String hrRemarks = (String)attributes.get("hrRemarks");

		if (hrRemarks != null) {
			setHrRemarks(hrRemarks);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long recruitmentProcessId = (Long)attributes.get("recruitmentProcessId");

		if (recruitmentProcessId != null) {
			setRecruitmentProcessId(recruitmentProcessId);
		}
	}

	@Override
	public Object clone() {
		return new CandidateEvaluationWrapper((CandidateEvaluation)_candidateEvaluation.clone());
	}

	@Override
	public int compareTo(CandidateEvaluation candidateEvaluation) {
		return _candidateEvaluation.compareTo(candidateEvaluation);
	}

	/**
	* Returns the apply candidate ID of this candidate evaluation.
	*
	* @return the apply candidate ID of this candidate evaluation
	*/
	@Override
	public long getApplyCandidateId() {
		return _candidateEvaluation.getApplyCandidateId();
	}

	/**
	* Returns the candidate evaluation ID of this candidate evaluation.
	*
	* @return the candidate evaluation ID of this candidate evaluation
	*/
	@Override
	public long getCandidateEvaluationId() {
		return _candidateEvaluation.getCandidateEvaluationId();
	}

	/**
	* Returns the create date of this candidate evaluation.
	*
	* @return the create date of this candidate evaluation
	*/
	@Override
	public Date getCreateDate() {
		return _candidateEvaluation.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _candidateEvaluation.getExpandoBridge();
	}

	/**
	* Returns the hr remarks of this candidate evaluation.
	*
	* @return the hr remarks of this candidate evaluation
	*/
	@Override
	public String getHrRemarks() {
		return _candidateEvaluation.getHrRemarks();
	}

	/**
	* Returns the interviewer ID of this candidate evaluation.
	*
	* @return the interviewer ID of this candidate evaluation
	*/
	@Override
	public long getInterviewerId() {
		return _candidateEvaluation.getInterviewerId();
	}

	/**
	* Returns the interviewer rating of this candidate evaluation.
	*
	* @return the interviewer rating of this candidate evaluation
	*/
	@Override
	public int getInterviewerRating() {
		return _candidateEvaluation.getInterviewerRating();
	}

	/**
	* Returns the interviewer remarks of this candidate evaluation.
	*
	* @return the interviewer remarks of this candidate evaluation
	*/
	@Override
	public String getInterviewerRemarks() {
		return _candidateEvaluation.getInterviewerRemarks();
	}

	/**
	* Returns the job post ID of this candidate evaluation.
	*
	* @return the job post ID of this candidate evaluation
	*/
	@Override
	public long getJobPostId() {
		return _candidateEvaluation.getJobPostId();
	}

	/**
	* Returns the modified date of this candidate evaluation.
	*
	* @return the modified date of this candidate evaluation
	*/
	@Override
	public Date getModifiedDate() {
		return _candidateEvaluation.getModifiedDate();
	}

	/**
	* Returns the post evaluation ID of this candidate evaluation.
	*
	* @return the post evaluation ID of this candidate evaluation
	*/
	@Override
	public long getPostEvaluationId() {
		return _candidateEvaluation.getPostEvaluationId();
	}

	/**
	* Returns the primary key of this candidate evaluation.
	*
	* @return the primary key of this candidate evaluation
	*/
	@Override
	public long getPrimaryKey() {
		return _candidateEvaluation.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateEvaluation.getPrimaryKeyObj();
	}

	/**
	* Returns the recruitment process ID of this candidate evaluation.
	*
	* @return the recruitment process ID of this candidate evaluation
	*/
	@Override
	public long getRecruitmentProcessId() {
		return _candidateEvaluation.getRecruitmentProcessId();
	}

	@Override
	public int hashCode() {
		return _candidateEvaluation.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _candidateEvaluation.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _candidateEvaluation.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _candidateEvaluation.isNew();
	}

	@Override
	public void persist() {
		_candidateEvaluation.persist();
	}

	/**
	* Sets the apply candidate ID of this candidate evaluation.
	*
	* @param applyCandidateId the apply candidate ID of this candidate evaluation
	*/
	@Override
	public void setApplyCandidateId(long applyCandidateId) {
		_candidateEvaluation.setApplyCandidateId(applyCandidateId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_candidateEvaluation.setCachedModel(cachedModel);
	}

	/**
	* Sets the candidate evaluation ID of this candidate evaluation.
	*
	* @param candidateEvaluationId the candidate evaluation ID of this candidate evaluation
	*/
	@Override
	public void setCandidateEvaluationId(long candidateEvaluationId) {
		_candidateEvaluation.setCandidateEvaluationId(candidateEvaluationId);
	}

	/**
	* Sets the create date of this candidate evaluation.
	*
	* @param createDate the create date of this candidate evaluation
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_candidateEvaluation.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_candidateEvaluation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_candidateEvaluation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_candidateEvaluation.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hr remarks of this candidate evaluation.
	*
	* @param hrRemarks the hr remarks of this candidate evaluation
	*/
	@Override
	public void setHrRemarks(String hrRemarks) {
		_candidateEvaluation.setHrRemarks(hrRemarks);
	}

	/**
	* Sets the interviewer ID of this candidate evaluation.
	*
	* @param interviewerId the interviewer ID of this candidate evaluation
	*/
	@Override
	public void setInterviewerId(long interviewerId) {
		_candidateEvaluation.setInterviewerId(interviewerId);
	}

	/**
	* Sets the interviewer rating of this candidate evaluation.
	*
	* @param interviewerRating the interviewer rating of this candidate evaluation
	*/
	@Override
	public void setInterviewerRating(int interviewerRating) {
		_candidateEvaluation.setInterviewerRating(interviewerRating);
	}

	/**
	* Sets the interviewer remarks of this candidate evaluation.
	*
	* @param interviewerRemarks the interviewer remarks of this candidate evaluation
	*/
	@Override
	public void setInterviewerRemarks(String interviewerRemarks) {
		_candidateEvaluation.setInterviewerRemarks(interviewerRemarks);
	}

	/**
	* Sets the job post ID of this candidate evaluation.
	*
	* @param jobPostId the job post ID of this candidate evaluation
	*/
	@Override
	public void setJobPostId(long jobPostId) {
		_candidateEvaluation.setJobPostId(jobPostId);
	}

	/**
	* Sets the modified date of this candidate evaluation.
	*
	* @param modifiedDate the modified date of this candidate evaluation
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_candidateEvaluation.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_candidateEvaluation.setNew(n);
	}

	/**
	* Sets the post evaluation ID of this candidate evaluation.
	*
	* @param postEvaluationId the post evaluation ID of this candidate evaluation
	*/
	@Override
	public void setPostEvaluationId(long postEvaluationId) {
		_candidateEvaluation.setPostEvaluationId(postEvaluationId);
	}

	/**
	* Sets the primary key of this candidate evaluation.
	*
	* @param primaryKey the primary key of this candidate evaluation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_candidateEvaluation.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_candidateEvaluation.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the recruitment process ID of this candidate evaluation.
	*
	* @param recruitmentProcessId the recruitment process ID of this candidate evaluation
	*/
	@Override
	public void setRecruitmentProcessId(long recruitmentProcessId) {
		_candidateEvaluation.setRecruitmentProcessId(recruitmentProcessId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CandidateEvaluation> toCacheModel() {
		return _candidateEvaluation.toCacheModel();
	}

	@Override
	public CandidateEvaluation toEscapedModel() {
		return new CandidateEvaluationWrapper(_candidateEvaluation.toEscapedModel());
	}

	@Override
	public String toString() {
		return _candidateEvaluation.toString();
	}

	@Override
	public CandidateEvaluation toUnescapedModel() {
		return new CandidateEvaluationWrapper(_candidateEvaluation.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _candidateEvaluation.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateEvaluationWrapper)) {
			return false;
		}

		CandidateEvaluationWrapper candidateEvaluationWrapper = (CandidateEvaluationWrapper)obj;

		if (Objects.equals(_candidateEvaluation,
					candidateEvaluationWrapper._candidateEvaluation)) {
			return true;
		}

		return false;
	}

	@Override
	public CandidateEvaluation getWrappedModel() {
		return _candidateEvaluation;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _candidateEvaluation.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _candidateEvaluation.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_candidateEvaluation.resetOriginalValues();
	}

	private final CandidateEvaluation _candidateEvaluation;
}