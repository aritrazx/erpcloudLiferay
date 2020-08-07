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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the JobEvaluation service. Represents a row in the &quot;JobEvaluation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.JobEvaluationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.JobEvaluationImpl}.
 * </p>
 *
 * @author Samaresh
 * @see JobEvaluation
 * @see com.liferay.famocom.erpcloud.model.impl.JobEvaluationImpl
 * @see com.liferay.famocom.erpcloud.model.impl.JobEvaluationModelImpl
 * @generated
 */
@ProviderType
public interface JobEvaluationModel extends BaseModel<JobEvaluation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a job evaluation model instance should use the {@link JobEvaluation} interface instead.
	 */

	/**
	 * Returns the primary key of this job evaluation.
	 *
	 * @return the primary key of this job evaluation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this job evaluation.
	 *
	 * @param primaryKey the primary key of this job evaluation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the post evaluation ID of this job evaluation.
	 *
	 * @return the post evaluation ID of this job evaluation
	 */
	public long getPostEvaluationId();

	/**
	 * Sets the post evaluation ID of this job evaluation.
	 *
	 * @param postEvaluationId the post evaluation ID of this job evaluation
	 */
	public void setPostEvaluationId(long postEvaluationId);

	/**
	 * Returns the job post ID of this job evaluation.
	 *
	 * @return the job post ID of this job evaluation
	 */
	public long getJobPostId();

	/**
	 * Sets the job post ID of this job evaluation.
	 *
	 * @param jobPostId the job post ID of this job evaluation
	 */
	public void setJobPostId(long jobPostId);

	/**
	 * Returns the evaluation name of this job evaluation.
	 *
	 * @return the evaluation name of this job evaluation
	 */
	@AutoEscape
	public String getEvaluationName();

	/**
	 * Sets the evaluation name of this job evaluation.
	 *
	 * @param evaluationName the evaluation name of this job evaluation
	 */
	public void setEvaluationName(String evaluationName);

	/**
	 * Returns the evaluation description of this job evaluation.
	 *
	 * @return the evaluation description of this job evaluation
	 */
	@AutoEscape
	public String getEvaluationDescription();

	/**
	 * Sets the evaluation description of this job evaluation.
	 *
	 * @param evaluationDescription the evaluation description of this job evaluation
	 */
	public void setEvaluationDescription(String evaluationDescription);

	/**
	 * Returns the created date of this job evaluation.
	 *
	 * @return the created date of this job evaluation
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this job evaluation.
	 *
	 * @param createdDate the created date of this job evaluation
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified date of this job evaluation.
	 *
	 * @return the modified date of this job evaluation
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this job evaluation.
	 *
	 * @param modifiedDate the modified date of this job evaluation
	 */
	public void setModifiedDate(Date modifiedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(JobEvaluation jobEvaluation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<JobEvaluation> toCacheModel();

	@Override
	public JobEvaluation toEscapedModel();

	@Override
	public JobEvaluation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}