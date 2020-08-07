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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.JobOpeningServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.JobOpeningServiceSoap
 * @generated
 */
@ProviderType
public class JobOpeningSoap implements Serializable {
	public static JobOpeningSoap toSoapModel(JobOpening model) {
		JobOpeningSoap soapModel = new JobOpeningSoap();

		soapModel.setJobOpeningId(model.getJobOpeningId());
		soapModel.setJobPostId(model.getJobPostId());
		soapModel.setOpeningFor(model.getOpeningFor());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static JobOpeningSoap[] toSoapModels(JobOpening[] models) {
		JobOpeningSoap[] soapModels = new JobOpeningSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobOpeningSoap[][] toSoapModels(JobOpening[][] models) {
		JobOpeningSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobOpeningSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobOpeningSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobOpeningSoap[] toSoapModels(List<JobOpening> models) {
		List<JobOpeningSoap> soapModels = new ArrayList<JobOpeningSoap>(models.size());

		for (JobOpening model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobOpeningSoap[soapModels.size()]);
	}

	public JobOpeningSoap() {
	}

	public long getPrimaryKey() {
		return _jobOpeningId;
	}

	public void setPrimaryKey(long pk) {
		setJobOpeningId(pk);
	}

	public long getJobOpeningId() {
		return _jobOpeningId;
	}

	public void setJobOpeningId(long jobOpeningId) {
		_jobOpeningId = jobOpeningId;
	}

	public long getJobPostId() {
		return _jobPostId;
	}

	public void setJobPostId(long jobPostId) {
		_jobPostId = jobPostId;
	}

	public String getOpeningFor() {
		return _openingFor;
	}

	public void setOpeningFor(String openingFor) {
		_openingFor = openingFor;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _jobOpeningId;
	private long _jobPostId;
	private String _openingFor;
	private String _description;
	private Date _createdDate;
	private Date _modifiedDate;
	private int _status;
}