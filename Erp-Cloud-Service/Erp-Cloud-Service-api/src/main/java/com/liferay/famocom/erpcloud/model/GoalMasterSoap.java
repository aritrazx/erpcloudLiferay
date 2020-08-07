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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.GoalMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.GoalMasterServiceSoap
 * @generated
 */
@ProviderType
public class GoalMasterSoap implements Serializable {
	public static GoalMasterSoap toSoapModel(GoalMaster model) {
		GoalMasterSoap soapModel = new GoalMasterSoap();

		soapModel.setGoalId(model.getGoalId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setGoalName(model.getGoalName());
		soapModel.setGoalDescription(model.getGoalDescription());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static GoalMasterSoap[] toSoapModels(GoalMaster[] models) {
		GoalMasterSoap[] soapModels = new GoalMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GoalMasterSoap[][] toSoapModels(GoalMaster[][] models) {
		GoalMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GoalMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GoalMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GoalMasterSoap[] toSoapModels(List<GoalMaster> models) {
		List<GoalMasterSoap> soapModels = new ArrayList<GoalMasterSoap>(models.size());

		for (GoalMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GoalMasterSoap[soapModels.size()]);
	}

	public GoalMasterSoap() {
	}

	public long getPrimaryKey() {
		return _goalId;
	}

	public void setPrimaryKey(long pk) {
		setGoalId(pk);
	}

	public long getGoalId() {
		return _goalId;
	}

	public void setGoalId(long goalId) {
		_goalId = goalId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public String getGoalName() {
		return _goalName;
	}

	public void setGoalName(String goalName) {
		_goalName = goalName;
	}

	public String getGoalDescription() {
		return _goalDescription;
	}

	public void setGoalDescription(String goalDescription) {
		_goalDescription = goalDescription;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _goalId;
	private long _employeeId;
	private long _projectId;
	private String _goalName;
	private String _goalDescription;
	private Date _addedDate;
}