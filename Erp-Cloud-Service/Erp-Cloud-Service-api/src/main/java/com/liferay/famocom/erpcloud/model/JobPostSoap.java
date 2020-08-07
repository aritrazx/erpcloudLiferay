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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.JobPostServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.JobPostServiceSoap
 * @generated
 */
@ProviderType
public class JobPostSoap implements Serializable {
	public static JobPostSoap toSoapModel(JobPost model) {
		JobPostSoap soapModel = new JobPostSoap();

		soapModel.setJobPostId(model.getJobPostId());
		soapModel.setPostName(model.getPostName());
		soapModel.setPostDescription(model.getPostDescription());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static JobPostSoap[] toSoapModels(JobPost[] models) {
		JobPostSoap[] soapModels = new JobPostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobPostSoap[][] toSoapModels(JobPost[][] models) {
		JobPostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobPostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobPostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobPostSoap[] toSoapModels(List<JobPost> models) {
		List<JobPostSoap> soapModels = new ArrayList<JobPostSoap>(models.size());

		for (JobPost model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobPostSoap[soapModels.size()]);
	}

	public JobPostSoap() {
	}

	public long getPrimaryKey() {
		return _jobPostId;
	}

	public void setPrimaryKey(long pk) {
		setJobPostId(pk);
	}

	public long getJobPostId() {
		return _jobPostId;
	}

	public void setJobPostId(long jobPostId) {
		_jobPostId = jobPostId;
	}

	public String getPostName() {
		return _postName;
	}

	public void setPostName(String postName) {
		_postName = postName;
	}

	public String getPostDescription() {
		return _postDescription;
	}

	public void setPostDescription(String postDescription) {
		_postDescription = postDescription;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _jobPostId;
	private String _postName;
	private String _postDescription;
	private Date _createdDate;
	private Date _modifiedDate;
}