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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.EvaluationServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.EvaluationServiceSoap
 * @generated
 */
@ProviderType
public class EvaluationSoap implements Serializable {
	public static EvaluationSoap toSoapModel(Evaluation model) {
		EvaluationSoap soapModel = new EvaluationSoap();

		soapModel.setEvaluationId(model.getEvaluationId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setEvaluatedBy(model.getEvaluatedBy());
		soapModel.setEvalMessage(model.getEvalMessage());
		soapModel.setEvalDate(model.getEvalDate());
		soapModel.setEvalRating(model.getEvalRating());

		return soapModel;
	}

	public static EvaluationSoap[] toSoapModels(Evaluation[] models) {
		EvaluationSoap[] soapModels = new EvaluationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EvaluationSoap[][] toSoapModels(Evaluation[][] models) {
		EvaluationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EvaluationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EvaluationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EvaluationSoap[] toSoapModels(List<Evaluation> models) {
		List<EvaluationSoap> soapModels = new ArrayList<EvaluationSoap>(models.size());

		for (Evaluation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EvaluationSoap[soapModels.size()]);
	}

	public EvaluationSoap() {
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

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getEvaluatedBy() {
		return _evaluatedBy;
	}

	public void setEvaluatedBy(long evaluatedBy) {
		_evaluatedBy = evaluatedBy;
	}

	public String getEvalMessage() {
		return _evalMessage;
	}

	public void setEvalMessage(String evalMessage) {
		_evalMessage = evalMessage;
	}

	public Date getEvalDate() {
		return _evalDate;
	}

	public void setEvalDate(Date evalDate) {
		_evalDate = evalDate;
	}

	public int getEvalRating() {
		return _evalRating;
	}

	public void setEvalRating(int evalRating) {
		_evalRating = evalRating;
	}

	private long _evaluationId;
	private long _employeeId;
	private long _evaluatedBy;
	private String _evalMessage;
	private Date _evalDate;
	private int _evalRating;
}