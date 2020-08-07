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
 * This class is a wrapper for {@link JobOpening}.
 * </p>
 *
 * @author Samaresh
 * @see JobOpening
 * @generated
 */
@ProviderType
public class JobOpeningWrapper implements JobOpening, ModelWrapper<JobOpening> {
	public JobOpeningWrapper(JobOpening jobOpening) {
		_jobOpening = jobOpening;
	}

	@Override
	public Class<?> getModelClass() {
		return JobOpening.class;
	}

	@Override
	public String getModelClassName() {
		return JobOpening.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobOpeningId", getJobOpeningId());
		attributes.put("jobPostId", getJobPostId());
		attributes.put("openingFor", getOpeningFor());
		attributes.put("description", getDescription());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobOpeningId = (Long)attributes.get("jobOpeningId");

		if (jobOpeningId != null) {
			setJobOpeningId(jobOpeningId);
		}

		Long jobPostId = (Long)attributes.get("jobPostId");

		if (jobPostId != null) {
			setJobPostId(jobPostId);
		}

		String openingFor = (String)attributes.get("openingFor");

		if (openingFor != null) {
			setOpeningFor(openingFor);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Object clone() {
		return new JobOpeningWrapper((JobOpening)_jobOpening.clone());
	}

	@Override
	public int compareTo(JobOpening jobOpening) {
		return _jobOpening.compareTo(jobOpening);
	}

	/**
	* Returns the created date of this job opening.
	*
	* @return the created date of this job opening
	*/
	@Override
	public Date getCreatedDate() {
		return _jobOpening.getCreatedDate();
	}

	/**
	* Returns the description of this job opening.
	*
	* @return the description of this job opening
	*/
	@Override
	public String getDescription() {
		return _jobOpening.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _jobOpening.getExpandoBridge();
	}

	/**
	* Returns the job opening ID of this job opening.
	*
	* @return the job opening ID of this job opening
	*/
	@Override
	public long getJobOpeningId() {
		return _jobOpening.getJobOpeningId();
	}

	/**
	* Returns the job post ID of this job opening.
	*
	* @return the job post ID of this job opening
	*/
	@Override
	public long getJobPostId() {
		return _jobOpening.getJobPostId();
	}

	/**
	* Returns the modified date of this job opening.
	*
	* @return the modified date of this job opening
	*/
	@Override
	public Date getModifiedDate() {
		return _jobOpening.getModifiedDate();
	}

	/**
	* Returns the opening for of this job opening.
	*
	* @return the opening for of this job opening
	*/
	@Override
	public String getOpeningFor() {
		return _jobOpening.getOpeningFor();
	}

	/**
	* Returns the primary key of this job opening.
	*
	* @return the primary key of this job opening
	*/
	@Override
	public long getPrimaryKey() {
		return _jobOpening.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jobOpening.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this job opening.
	*
	* @return the status of this job opening
	*/
	@Override
	public int getStatus() {
		return _jobOpening.getStatus();
	}

	@Override
	public int hashCode() {
		return _jobOpening.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _jobOpening.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _jobOpening.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _jobOpening.isNew();
	}

	@Override
	public void persist() {
		_jobOpening.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jobOpening.setCachedModel(cachedModel);
	}

	/**
	* Sets the created date of this job opening.
	*
	* @param createdDate the created date of this job opening
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_jobOpening.setCreatedDate(createdDate);
	}

	/**
	* Sets the description of this job opening.
	*
	* @param description the description of this job opening
	*/
	@Override
	public void setDescription(String description) {
		_jobOpening.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_jobOpening.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_jobOpening.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_jobOpening.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the job opening ID of this job opening.
	*
	* @param jobOpeningId the job opening ID of this job opening
	*/
	@Override
	public void setJobOpeningId(long jobOpeningId) {
		_jobOpening.setJobOpeningId(jobOpeningId);
	}

	/**
	* Sets the job post ID of this job opening.
	*
	* @param jobPostId the job post ID of this job opening
	*/
	@Override
	public void setJobPostId(long jobPostId) {
		_jobOpening.setJobPostId(jobPostId);
	}

	/**
	* Sets the modified date of this job opening.
	*
	* @param modifiedDate the modified date of this job opening
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_jobOpening.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_jobOpening.setNew(n);
	}

	/**
	* Sets the opening for of this job opening.
	*
	* @param openingFor the opening for of this job opening
	*/
	@Override
	public void setOpeningFor(String openingFor) {
		_jobOpening.setOpeningFor(openingFor);
	}

	/**
	* Sets the primary key of this job opening.
	*
	* @param primaryKey the primary key of this job opening
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jobOpening.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_jobOpening.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this job opening.
	*
	* @param status the status of this job opening
	*/
	@Override
	public void setStatus(int status) {
		_jobOpening.setStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<JobOpening> toCacheModel() {
		return _jobOpening.toCacheModel();
	}

	@Override
	public JobOpening toEscapedModel() {
		return new JobOpeningWrapper(_jobOpening.toEscapedModel());
	}

	@Override
	public String toString() {
		return _jobOpening.toString();
	}

	@Override
	public JobOpening toUnescapedModel() {
		return new JobOpeningWrapper(_jobOpening.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _jobOpening.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobOpeningWrapper)) {
			return false;
		}

		JobOpeningWrapper jobOpeningWrapper = (JobOpeningWrapper)obj;

		if (Objects.equals(_jobOpening, jobOpeningWrapper._jobOpening)) {
			return true;
		}

		return false;
	}

	@Override
	public JobOpening getWrappedModel() {
		return _jobOpening;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _jobOpening.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _jobOpening.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_jobOpening.resetOriginalValues();
	}

	private final JobOpening _jobOpening;
}