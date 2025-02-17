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
 * The base model interface for the JobOpening service. Represents a row in the &quot;JobOpening&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.JobOpeningModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.JobOpeningImpl}.
 * </p>
 *
 * @author Samaresh
 * @see JobOpening
 * @see com.liferay.famocom.erpcloud.model.impl.JobOpeningImpl
 * @see com.liferay.famocom.erpcloud.model.impl.JobOpeningModelImpl
 * @generated
 */
@ProviderType
public interface JobOpeningModel extends BaseModel<JobOpening> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a job opening model instance should use the {@link JobOpening} interface instead.
	 */

	/**
	 * Returns the primary key of this job opening.
	 *
	 * @return the primary key of this job opening
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this job opening.
	 *
	 * @param primaryKey the primary key of this job opening
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the job opening ID of this job opening.
	 *
	 * @return the job opening ID of this job opening
	 */
	public long getJobOpeningId();

	/**
	 * Sets the job opening ID of this job opening.
	 *
	 * @param jobOpeningId the job opening ID of this job opening
	 */
	public void setJobOpeningId(long jobOpeningId);

	/**
	 * Returns the job post ID of this job opening.
	 *
	 * @return the job post ID of this job opening
	 */
	public long getJobPostId();

	/**
	 * Sets the job post ID of this job opening.
	 *
	 * @param jobPostId the job post ID of this job opening
	 */
	public void setJobPostId(long jobPostId);

	/**
	 * Returns the opening for of this job opening.
	 *
	 * @return the opening for of this job opening
	 */
	@AutoEscape
	public String getOpeningFor();

	/**
	 * Sets the opening for of this job opening.
	 *
	 * @param openingFor the opening for of this job opening
	 */
	public void setOpeningFor(String openingFor);

	/**
	 * Returns the description of this job opening.
	 *
	 * @return the description of this job opening
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this job opening.
	 *
	 * @param description the description of this job opening
	 */
	public void setDescription(String description);

	/**
	 * Returns the created date of this job opening.
	 *
	 * @return the created date of this job opening
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this job opening.
	 *
	 * @param createdDate the created date of this job opening
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified date of this job opening.
	 *
	 * @return the modified date of this job opening
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this job opening.
	 *
	 * @param modifiedDate the modified date of this job opening
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this job opening.
	 *
	 * @return the status of this job opening
	 */
	public int getStatus();

	/**
	 * Sets the status of this job opening.
	 *
	 * @param status the status of this job opening
	 */
	public void setStatus(int status);

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
	public int compareTo(JobOpening jobOpening);

	@Override
	public int hashCode();

	@Override
	public CacheModel<JobOpening> toCacheModel();

	@Override
	public JobOpening toEscapedModel();

	@Override
	public JobOpening toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}