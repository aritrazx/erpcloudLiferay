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
 * This class is a wrapper for {@link JobPost}.
 * </p>
 *
 * @author Samaresh
 * @see JobPost
 * @generated
 */
@ProviderType
public class JobPostWrapper implements JobPost, ModelWrapper<JobPost> {
	public JobPostWrapper(JobPost jobPost) {
		_jobPost = jobPost;
	}

	@Override
	public Class<?> getModelClass() {
		return JobPost.class;
	}

	@Override
	public String getModelClassName() {
		return JobPost.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobPostId", getJobPostId());
		attributes.put("postName", getPostName());
		attributes.put("postDescription", getPostDescription());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobPostId = (Long)attributes.get("jobPostId");

		if (jobPostId != null) {
			setJobPostId(jobPostId);
		}

		String postName = (String)attributes.get("postName");

		if (postName != null) {
			setPostName(postName);
		}

		String postDescription = (String)attributes.get("postDescription");

		if (postDescription != null) {
			setPostDescription(postDescription);
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
		return new JobPostWrapper((JobPost)_jobPost.clone());
	}

	@Override
	public int compareTo(JobPost jobPost) {
		return _jobPost.compareTo(jobPost);
	}

	/**
	* Returns the created date of this job post.
	*
	* @return the created date of this job post
	*/
	@Override
	public Date getCreatedDate() {
		return _jobPost.getCreatedDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _jobPost.getExpandoBridge();
	}

	/**
	* Returns the job post ID of this job post.
	*
	* @return the job post ID of this job post
	*/
	@Override
	public long getJobPostId() {
		return _jobPost.getJobPostId();
	}

	/**
	* Returns the modified date of this job post.
	*
	* @return the modified date of this job post
	*/
	@Override
	public Date getModifiedDate() {
		return _jobPost.getModifiedDate();
	}

	/**
	* Returns the post description of this job post.
	*
	* @return the post description of this job post
	*/
	@Override
	public String getPostDescription() {
		return _jobPost.getPostDescription();
	}

	/**
	* Returns the post name of this job post.
	*
	* @return the post name of this job post
	*/
	@Override
	public String getPostName() {
		return _jobPost.getPostName();
	}

	/**
	* Returns the primary key of this job post.
	*
	* @return the primary key of this job post
	*/
	@Override
	public long getPrimaryKey() {
		return _jobPost.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jobPost.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _jobPost.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _jobPost.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _jobPost.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _jobPost.isNew();
	}

	@Override
	public void persist() {
		_jobPost.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jobPost.setCachedModel(cachedModel);
	}

	/**
	* Sets the created date of this job post.
	*
	* @param createdDate the created date of this job post
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_jobPost.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_jobPost.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_jobPost.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_jobPost.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the job post ID of this job post.
	*
	* @param jobPostId the job post ID of this job post
	*/
	@Override
	public void setJobPostId(long jobPostId) {
		_jobPost.setJobPostId(jobPostId);
	}

	/**
	* Sets the modified date of this job post.
	*
	* @param modifiedDate the modified date of this job post
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_jobPost.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_jobPost.setNew(n);
	}

	/**
	* Sets the post description of this job post.
	*
	* @param postDescription the post description of this job post
	*/
	@Override
	public void setPostDescription(String postDescription) {
		_jobPost.setPostDescription(postDescription);
	}

	/**
	* Sets the post name of this job post.
	*
	* @param postName the post name of this job post
	*/
	@Override
	public void setPostName(String postName) {
		_jobPost.setPostName(postName);
	}

	/**
	* Sets the primary key of this job post.
	*
	* @param primaryKey the primary key of this job post
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jobPost.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_jobPost.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<JobPost> toCacheModel() {
		return _jobPost.toCacheModel();
	}

	@Override
	public JobPost toEscapedModel() {
		return new JobPostWrapper(_jobPost.toEscapedModel());
	}

	@Override
	public String toString() {
		return _jobPost.toString();
	}

	@Override
	public JobPost toUnescapedModel() {
		return new JobPostWrapper(_jobPost.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _jobPost.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobPostWrapper)) {
			return false;
		}

		JobPostWrapper jobPostWrapper = (JobPostWrapper)obj;

		if (Objects.equals(_jobPost, jobPostWrapper._jobPost)) {
			return true;
		}

		return false;
	}

	@Override
	public JobPost getWrappedModel() {
		return _jobPost;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _jobPost.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _jobPost.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_jobPost.resetOriginalValues();
	}

	private final JobPost _jobPost;
}