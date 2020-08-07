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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.InterviewEvaluationServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.InterviewEvaluationServiceSoap
 * @generated
 */
@ProviderType
public class InterviewEvaluationSoap implements Serializable {
	public static InterviewEvaluationSoap toSoapModel(InterviewEvaluation model) {
		InterviewEvaluationSoap soapModel = new InterviewEvaluationSoap();

		soapModel.setEvaluationId(model.getEvaluationId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setEvaluationName(model.getEvaluationName());

		return soapModel;
	}

	public static InterviewEvaluationSoap[] toSoapModels(
		InterviewEvaluation[] models) {
		InterviewEvaluationSoap[] soapModels = new InterviewEvaluationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InterviewEvaluationSoap[][] toSoapModels(
		InterviewEvaluation[][] models) {
		InterviewEvaluationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InterviewEvaluationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InterviewEvaluationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InterviewEvaluationSoap[] toSoapModels(
		List<InterviewEvaluation> models) {
		List<InterviewEvaluationSoap> soapModels = new ArrayList<InterviewEvaluationSoap>(models.size());

		for (InterviewEvaluation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InterviewEvaluationSoap[soapModels.size()]);
	}

	public InterviewEvaluationSoap() {
	}

	public long getPrimaryKey() {
		return _evaluationId;
	}

	public void setPrimaryKey(long pk) {
		setEvaluationId(pk);
	}

	public long getEvaluationId() {
		return _evaluationId;
	}

	public void setEvaluationId(long evaluationId) {
		_evaluationId = evaluationId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public String getEvaluationName() {
		return _evaluationName;
	}

	public void setEvaluationName(String evaluationName) {
		_evaluationName = evaluationName;
	}

	private long _evaluationId;
	private long _roleId;
	private String _evaluationName;
}