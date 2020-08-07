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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.JobEvaluationServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.JobEvaluationServiceSoap
 * @generated
 */
@ProviderType
public class JobEvaluationSoap implements Serializable {
	public static JobEvaluationSoap toSoapModel(JobEvaluation model) {
		JobEvaluationSoap soapModel = new JobEvaluationSoap();

		soapModel.setPostEvaluationId(model.getPostEvaluationId());
		soapModel.setJobPostId(model.getJobPostId());
		soapModel.setEvaluationName(model.getEvaluationName());
		soapModel.setEvaluationDescription(model.getEvaluationDescription());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static JobEvaluationSoap[] toSoapModels(JobEvaluation[] models) {
		JobEvaluationSoap[] soapModels = new JobEvaluationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobEvaluationSoap[][] toSoapModels(JobEvaluation[][] models) {
		JobEvaluationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobEvaluationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobEvaluationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobEvaluationSoap[] toSoapModels(List<JobEvaluation> models) {
		List<JobEvaluationSoap> soapModels = new ArrayList<JobEvaluationSoap>(models.size());

		for (JobEvaluation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobEvaluationSoap[soapModels.size()]);
	}

	public JobEvaluationSoap() {
	}

	public long getPrimaryKey() {
		return _postEvaluationId;
	}

	public void setPrimaryKey(long pk) {
		setPostEvaluationId(pk);
	}

	public long getPostEvaluationId() {
		return _postEvaluationId;
	}

	public void setPostEvaluationId(long postEvaluationId) {
		_postEvaluationId = postEvaluationId;
	}

	public long getJobPostId() {
		return _jobPostId;
	}

	public void setJobPostId(long jobPostId) {
		_jobPostId = jobPostId;
	}

	public String getEvaluationName() {
		return _evaluationName;
	}

	public void setEvaluationName(String evaluationName) {
		_evaluationName = evaluationName;
	}

	public String getEvaluationDescription() {
		return _evaluationDescription;
	}

	public void setEvaluationDescription(String evaluationDescription) {
		_evaluationDescription = evaluationDescription;
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

	private long _postEvaluationId;
	private long _jobPostId;
	private String _evaluationName;
	private String _evaluationDescription;
	private Date _createdDate;
	private Date _modifiedDate;
}