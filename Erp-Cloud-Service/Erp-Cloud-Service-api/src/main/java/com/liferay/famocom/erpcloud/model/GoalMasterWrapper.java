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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link GoalMaster}.
 * </p>
 *
 * @author Samaresh
 * @see GoalMaster
 * @generated
 */
@ProviderType
public class GoalMasterWrapper implements GoalMaster, ModelWrapper<GoalMaster> {
	public GoalMasterWrapper(GoalMaster goalMaster) {
		_goalMaster = goalMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return GoalMaster.class;
	}

	@Override
	public String getModelClassName() {
		return GoalMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("goalId", getGoalId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("projectId", getProjectId());
		attributes.put("goalName", getGoalName());
		attributes.put("goalDescription", getGoalDescription());
		attributes.put("addedDate", getAddedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long goalId = (Long)attributes.get("goalId");

		if (goalId != null) {
			setGoalId(goalId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String goalName = (String)attributes.get("goalName");

		if (goalName != null) {
			setGoalName(goalName);
		}

		String goalDescription = (String)attributes.get("goalDescription");

		if (goalDescription != null) {
			setGoalDescription(goalDescription);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public Object clone() {
		return new GoalMasterWrapper((GoalMaster)_goalMaster.clone());
	}

	@Override
	public int compareTo(GoalMaster goalMaster) {
		return _goalMaster.compareTo(goalMaster);
	}

	/**
	* Returns the added date of this goal master.
	*
	* @return the added date of this goal master
	*/
	@Override
	public Date getAddedDate() {
		return _goalMaster.getAddedDate();
	}

	/**
	* Returns the employee ID of this goal master.
	*
	* @return the employee ID of this goal master
	*/
	@Override
	public long getEmployeeId() {
		return _goalMaster.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _goalMaster.getExpandoBridge();
	}

	/**
	* Returns the goal description of this goal master.
	*
	* @return the goal description of this goal master
	*/
	@Override
	public String getGoalDescription() {
		return _goalMaster.getGoalDescription();
	}

	/**
	* Returns the goal ID of this goal master.
	*
	* @return the goal ID of this goal master
	*/
	@Override
	public long getGoalId() {
		return _goalMaster.getGoalId();
	}

	/**
	* Returns the goal name of this goal master.
	*
	* @return the goal name of this goal master
	*/
	@Override
	public String getGoalName() {
		return _goalMaster.getGoalName();
	}

	/**
	* Returns the primary key of this goal master.
	*
	* @return the primary key of this goal master
	*/
	@Override
	public long getPrimaryKey() {
		return _goalMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _goalMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this goal master.
	*
	* @return the project ID of this goal master
	*/
	@Override
	public long getProjectId() {
		return _goalMaster.getProjectId();
	}

	@Override
	public int hashCode() {
		return _goalMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _goalMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _goalMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _goalMaster.isNew();
	}

	@Override
	public void persist() {
		_goalMaster.persist();
	}

	/**
	* Sets the added date of this goal master.
	*
	* @param addedDate the added date of this goal master
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_goalMaster.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_goalMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the employee ID of this goal master.
	*
	* @param employeeId the employee ID of this goal master
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_goalMaster.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_goalMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_goalMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_goalMaster.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the goal description of this goal master.
	*
	* @param goalDescription the goal description of this goal master
	*/
	@Override
	public void setGoalDescription(String goalDescription) {
		_goalMaster.setGoalDescription(goalDescription);
	}

	/**
	* Sets the goal ID of this goal master.
	*
	* @param goalId the goal ID of this goal master
	*/
	@Override
	public void setGoalId(long goalId) {
		_goalMaster.setGoalId(goalId);
	}

	/**
	* Sets the goal name of this goal master.
	*
	* @param goalName the goal name of this goal master
	*/
	@Override
	public void setGoalName(String goalName) {
		_goalMaster.setGoalName(goalName);
	}

	@Override
	public void setNew(boolean n) {
		_goalMaster.setNew(n);
	}

	/**
	* Sets the primary key of this goal master.
	*
	* @param primaryKey the primary key of this goal master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_goalMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_goalMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this goal master.
	*
	* @param projectId the project ID of this goal master
	*/
	@Override
	public void setProjectId(long projectId) {
		_goalMaster.setProjectId(projectId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<GoalMaster> toCacheModel() {
		return _goalMaster.toCacheModel();
	}

	@Override
	public GoalMaster toEscapedModel() {
		return new GoalMasterWrapper(_goalMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _goalMaster.toString();
	}

	@Override
	public GoalMaster toUnescapedModel() {
		return new GoalMasterWrapper(_goalMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _goalMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GoalMasterWrapper)) {
			return false;
		}

		GoalMasterWrapper goalMasterWrapper = (GoalMasterWrapper)obj;

		if (Objects.equals(_goalMaster, goalMasterWrapper._goalMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public GoalMaster getWrappedModel() {
		return _goalMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _goalMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _goalMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_goalMaster.resetOriginalValues();
	}

	private final GoalMaster _goalMaster;
}