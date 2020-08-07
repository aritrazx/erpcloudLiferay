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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.CandidateEvaluationServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.CandidateEvaluationServiceSoap
 * @generated
 */
@ProviderType
public class CandidateEvaluationSoap implements Serializable {
	public static CandidateEvaluationSoap toSoapModel(CandidateEvaluation model) {
		CandidateEvaluationSoap soapModel = new CandidateEvaluationSoap();

		soapModel.setCandidateEvaluationId(model.getCandidateEvaluationId());
		soapModel.setInterviewerId(model.getInterviewerId());
		soapModel.setJobPostId(model.getJobPostId());
		soapModel.setPostEvaluationId(model.getPostEvaluationId());
		soapModel.setApplyCandidateId(model.getApplyCandidateId());
		soapModel.setInterviewerRating(model.getInterviewerRating());
		soapModel.setInterviewerRemarks(model.getInterviewerRemarks());
		soapModel.setHrRemarks(model.getHrRemarks());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRecruitmentProcessId(model.getRecruitmentProcessId());

		return soapModel;
	}

	public static CandidateEvaluationSoap[] toSoapModels(
		CandidateEvaluation[] models) {
		CandidateEvaluationSoap[] soapModels = new CandidateEvaluationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateEvaluationSoap[][] toSoapModels(
		CandidateEvaluation[][] models) {
		CandidateEvaluationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateEvaluationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateEvaluationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateEvaluationSoap[] toSoapModels(
		List<CandidateEvaluation> models) {
		List<CandidateEvaluationSoap> soapModels = new ArrayList<CandidateEvaluationSoap>(models.size());

		for (CandidateEvaluation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateEvaluationSoap[soapModels.size()]);
	}

	public CandidateEvaluationSoap() {
	}

	public long getPrimaryKey() {
		return _candidateEvaluationId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateEvaluationId(pk);
	}

	public long getCandidateEvaluationId() {
		return _candidateEvaluationId;
	}

	public void setCandidateEvaluationId(long candidateEvaluationId) {
		_candidateEvaluationId = candidateEvaluationId;
	}

	public long getInterviewerId() {
		return _interviewerId;
	}

	public void setInterviewerId(long interviewerId) {
		_interviewerId = interviewerId;
	}

	public long getJobPostId() {
		return _jobPostId;
	}

	public void setJobPostId(long jobPostId) {
		_jobPostId = jobPostId;
	}

	public long getPostEvaluationId() {
		return _postEvaluationId;
	}

	public void setPostEvaluationId(long postEvaluationId) {
		_postEvaluationId = postEvaluationId;
	}

	public long getApplyCandidateId() {
		return _applyCandidateId;
	}

	public void setApplyCandidateId(long applyCandidateId) {
		_applyCandidateId = applyCandidateId;
	}

	public int getInterviewerRating() {
		return _interviewerRating;
	}

	public void setInterviewerRating(int interviewerRating) {
		_interviewerRating = interviewerRating;
	}

	public String getInterviewerRemarks() {
		return _interviewerRemarks;
	}

	public void setInterviewerRemarks(String interviewerRemarks) {
		_interviewerRemarks = interviewerRemarks;
	}

	public String getHrRemarks() {
		return _hrRemarks;
	}

	public void setHrRemarks(String hrRemarks) {
		_hrRemarks = hrRemarks;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getRecruitmentProcessId() {
		return _recruitmentProcessId;
	}

	public void setRecruitmentProcessId(long recruitmentProcessId) {
		_recruitmentProcessId = recruitmentProcessId;
	}

	private long _candidateEvaluationId;
	private long _interviewerId;
	private long _jobPostId;
	private long _postEvaluationId;
	private long _applyCandidateId;
	private int _interviewerRating;
	private String _interviewerRemarks;
	private String _hrRemarks;
	private Date _createDate;
	private Date _modifiedDate;
	private long _recruitmentProcessId;
}