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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.GoalDetailsServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.GoalDetailsServiceSoap
 * @generated
 */
@ProviderType
public class GoalDetailsSoap implements Serializable {
	public static GoalDetailsSoap toSoapModel(GoalDetails model) {
		GoalDetailsSoap soapModel = new GoalDetailsSoap();

		soapModel.setGoaldetailId(model.getGoaldetailId());
		soapModel.setGoalId(model.getGoalId());
		soapModel.setEvaluationId(model.getEvaluationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setParameter(model.getParameter());
		soapModel.setScale(model.getScale());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static GoalDetailsSoap[] toSoapModels(GoalDetails[] models) {
		GoalDetailsSoap[] soapModels = new GoalDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GoalDetailsSoap[][] toSoapModels(GoalDetails[][] models) {
		GoalDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GoalDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GoalDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GoalDetailsSoap[] toSoapModels(List<GoalDetails> models) {
		List<GoalDetailsSoap> soapModels = new ArrayList<GoalDetailsSoap>(models.size());

		for (GoalDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GoalDetailsSoap[soapModels.size()]);
	}

	public GoalDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _goaldetailId;
	}

	public void setPrimaryKey(long pk) {
		setGoaldetailId(pk);
	}

	public long getGoaldetailId() {
		return _goaldetailId;
	}

	public void setGoaldetailId(long goaldetailId) {
		_goaldetailId = goaldetailId;
	}

	public long getGoalId() {
		return _goalId;
	}

	public void setGoalId(long goalId) {
		_goalId = goalId;
	}

	public long getEvaluationId() {
		return _evaluationId;
	}

	public void setEvaluationId(long evaluationId) {
		_evaluationId = evaluationId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getParameter() {
		return _parameter;
	}

	public void setParameter(String parameter) {
		_parameter = parameter;
	}

	public String getScale() {
		return _scale;
	}

	public void setScale(String scale) {
		_scale = scale;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _goaldetailId;
	private long _goalId;
	private long _evaluationId;
	private long _companyId;
	private String _parameter;
	private String _scale;
	private Date _addedDate;
}