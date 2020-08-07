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
 * This class is a wrapper for {@link JobEvaluation}.
 * </p>
 *
 * @author Samaresh
 * @see JobEvaluation
 * @generated
 */
@ProviderType
public class JobEvaluationWrapper implements JobEvaluation,
	ModelWrapper<JobEvaluation> {
	public JobEvaluationWrapper(JobEvaluation jobEvaluation) {
		_jobEvaluation = jobEvaluation;
	}

	@Override
	public Class<?> getModelClass() {
		return JobEvaluation.class;
	}

	@Override
	public String getModelClassName() {
		return JobEvaluation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postEvaluationId", getPostEvaluationId());
		attributes.put("jobPostId", getJobPostId());
		attributes.put("evaluationName", getEvaluationName());
		attributes.put("evaluationDescription", getEvaluationDescription());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postEvaluationId = (Long)attributes.get("postEvaluationId");

		if (postEvaluationId != null) {
			setPostEvaluationId(postEvaluationId);
		}

		Long jobPostId = (Long)attributes.get("jobPostId");

		if (jobPostId != null) {
			setJobPostId(jobPostId);
		}

		String evaluationName = (String)attributes.get("evaluationName");

		if (evaluationName != null) {
			setEvaluationName(evaluationName);
		}

		String evaluationDescription = (String)attributes.get(
				"evaluationDescription");

		if (evaluationDescription != null) {
			setEvaluationDescription(evaluationDescription);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new JobEvaluationWrapper((JobEvaluation)_jobEvaluation.clone());
	}

	@Override
	public int compareTo(JobEvaluation jobEvaluation) {
		return _jobEvaluation.compareTo(jobEvaluation);
	}

	/**
	* Returns the created date of this job evaluation.
	*
	* @return the created date of this job evaluation
	*/
	@Override
	public Date getCreatedDate() {
		return _jobEvaluation.getCreatedDate();
	}

	/**
	* Returns the evaluation description of this job evaluation.
	*
	* @return the evaluation description of this job evaluation
	*/
	@Override
	public String getEvaluationDescription() {
		return _jobEvaluation.getEvaluationDescription();
	}

	/**
	* Returns the evaluation name of this job evaluation.
	*
	* @return the evaluation name of this job evaluation
	*/
	@Override
	public String getEvaluationName() {
		return _jobEvaluation.getEvaluationName();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _jobEvaluation.getExpandoBridge();
	}

	/**
	* Returns the job post ID of this job evaluation.
	*
	* @return the job post ID of this job evaluation
	*/
	@Override
	public long getJobPostId() {
		return _jobEvaluation.getJobPostId();
	}

	/**
	* Returns the modified date of this job evaluation.
	*
	* @return the modified date of this job evaluation
	*/
	@Override
	public Date getModifiedDate() {
		return _jobEvaluation.getModifiedDate();
	}

	/**
	* Returns the post evaluation ID of this job evaluation.
	*
	* @return the post evaluation ID of this job evaluation
	*/
	@Override
	public long getPostEvaluationId() {
		return _jobEvaluation.getPostEvaluationId();
	}

	/**
	* Returns the primary key of this job evaluation.
	*
	* @return the primary key of this job evaluation
	*/
	@Override
	public long getPrimaryKey() {
		return _jobEvaluation.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jobEvaluation.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _jobEvaluation.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _jobEvaluation.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _jobEvaluation.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _jobEvaluation.isNew();
	}

	@Override
	public void persist() {
		_jobEvaluation.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jobEvaluation.setCachedModel(cachedModel);
	}

	/**
	* Sets the created date of this job evaluation.
	*
	* @param createdDate the created date of this job evaluation
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_jobEvaluation.setCreatedDate(createdDate);
	}

	/**
	* Sets the evaluation description of this job evaluation.
	*
	* @param evaluationDescription the evaluation description of this job evaluation
	*/
	@Override
	public void setEvaluationDescription(String evaluationDescription) {
		_jobEvaluation.setEvaluationDescription(evaluationDescription);
	}

	/**
	* Sets the evaluation name of this job evaluation.
	*
	* @param evaluationName the evaluation name of this job evaluation
	*/
	@Override
	public void setEvaluationName(String evaluationName) {
		_jobEvaluation.setEvaluationName(evaluationName);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_jobEvaluation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_jobEvaluation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_jobEvaluation.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the job post ID of this job evaluation.
	*
	* @param jobPostId the job post ID of this job evaluation
	*/
	@Override
	public void setJobPostId(long jobPostId) {
		_jobEvaluation.setJobPostId(jobPostId);
	}

	/**
	* Sets the modified date of this job evaluation.
	*
	* @param modifiedDate the modified date of this job evaluation
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_jobEvaluation.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_jobEvaluation.setNew(n);
	}

	/**
	* Sets the post evaluation ID of this job evaluation.
	*
	* @param postEvaluationId the post evaluation ID of this job evaluation
	*/
	@Override
	public void setPostEvaluationId(long postEvaluationId) {
		_jobEvaluation.setPostEvaluationId(postEvaluationId);
	}

	/**
	* Sets the primary key of this job evaluation.
	*
	* @param primaryKey the primary key of this job evaluation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jobEvaluation.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_jobEvaluation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<JobEvaluation> toCacheModel() {
		return _jobEvaluation.toCacheModel();
	}

	@Override
	public JobEvaluation toEscapedModel() {
		return new JobEvaluationWrapper(_jobEvaluation.toEscapedModel());
	}

	@Override
	public String toString() {
		return _jobEvaluation.toString();
	}

	@Override
	public JobEvaluation toUnescapedModel() {
		return new JobEvaluationWrapper(_jobEvaluation.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _jobEvaluation.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobEvaluationWrapper)) {
			return false;
		}

		JobEvaluationWrapper jobEvaluationWrapper = (JobEvaluationWrapper)obj;

		if (Objects.equals(_jobEvaluation, jobEvaluationWrapper._jobEvaluation)) {
			return true;
		}

		return false;
	}

	@Override
	public JobEvaluation getWrappedModel() {
		return _jobEvaluation;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _jobEvaluation.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _jobEvaluation.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_jobEvaluation.resetOriginalValues();
	}

	private final JobEvaluation _jobEvaluation;
}