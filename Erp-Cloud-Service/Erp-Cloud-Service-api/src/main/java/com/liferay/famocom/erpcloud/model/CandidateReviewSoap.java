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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.CandidateReviewServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.CandidateReviewServiceSoap
 * @generated
 */
@ProviderType
public class CandidateReviewSoap implements Serializable {
	public static CandidateReviewSoap toSoapModel(CandidateReview model) {
		CandidateReviewSoap soapModel = new CandidateReviewSoap();

		soapModel.setCandidateReviewId(model.getCandidateReviewId());
		soapModel.setRecruitProcessId(model.getRecruitProcessId());
		soapModel.setEvaluationId(model.getEvaluationId());
		soapModel.setScroring(model.getScroring());

		return soapModel;
	}

	public static CandidateReviewSoap[] toSoapModels(CandidateReview[] models) {
		CandidateReviewSoap[] soapModels = new CandidateReviewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateReviewSoap[][] toSoapModels(
		CandidateReview[][] models) {
		CandidateReviewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateReviewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateReviewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateReviewSoap[] toSoapModels(
		List<CandidateReview> models) {
		List<CandidateReviewSoap> soapModels = new ArrayList<CandidateReviewSoap>(models.size());

		for (CandidateReview model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateReviewSoap[soapModels.size()]);
	}

	public CandidateReviewSoap() {
	}

	public long getPrimaryKey() {
		return _candidateReviewId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateReviewId(pk);
	}

	public long getCandidateReviewId() {
		return _candidateReviewId;
	}

	public void setCandidateReviewId(long candidateReviewId) {
		_candidateReviewId = candidateReviewId;
	}

	public long getRecruitProcessId() {
		return _recruitProcessId;
	}

	public void setRecruitProcessId(long recruitProcessId) {
		_recruitProcessId = recruitProcessId;
	}

	public long getEvaluationId() {
		return _evaluationId;
	}

	public void setEvaluationId(long evaluationId) {
		_evaluationId = evaluationId;
	}

	public String getScroring() {
		return _scroring;
	}

	public void setScroring(String scroring) {
		_scroring = scroring;
	}

	private long _candidateReviewId;
	private long _recruitProcessId;
	private long _evaluationId;
	private String _scroring;
}