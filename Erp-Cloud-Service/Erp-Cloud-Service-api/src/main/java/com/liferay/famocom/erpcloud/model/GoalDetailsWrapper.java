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
 * This class is a wrapper for {@link GoalDetails}.
 * </p>
 *
 * @author Samaresh
 * @see GoalDetails
 * @generated
 */
@ProviderType
public class GoalDetailsWrapper implements GoalDetails,
	ModelWrapper<GoalDetails> {
	public GoalDetailsWrapper(GoalDetails goalDetails) {
		_goalDetails = goalDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return GoalDetails.class;
	}

	@Override
	public String getModelClassName() {
		return GoalDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("goaldetailId", getGoaldetailId());
		attributes.put("goalId", getGoalId());
		attributes.put("evaluationId", getEvaluationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("parameter", getParameter());
		attributes.put("scale", getScale());
		attributes.put("addedDate", getAddedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long goaldetailId = (Long)attributes.get("goaldetailId");

		if (goaldetailId != null) {
			setGoaldetailId(goaldetailId);
		}

		Long goalId = (Long)attributes.get("goalId");

		if (goalId != null) {
			setGoalId(goalId);
		}

		Long evaluationId = (Long)attributes.get("evaluationId");

		if (evaluationId != null) {
			setEvaluationId(evaluationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String parameter = (String)attributes.get("parameter");

		if (parameter != null) {
			setParameter(parameter);
		}

		String scale = (String)attributes.get("scale");

		if (scale != null) {
			setScale(scale);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public Object clone() {
		return new GoalDetailsWrapper((GoalDetails)_goalDetails.clone());
	}

	@Override
	public int compareTo(GoalDetails goalDetails) {
		return _goalDetails.compareTo(goalDetails);
	}

	/**
	* Returns the added date of this goal details.
	*
	* @return the added date of this goal details
	*/
	@Override
	public Date getAddedDate() {
		return _goalDetails.getAddedDate();
	}

	/**
	* Returns the company ID of this goal details.
	*
	* @return the company ID of this goal details
	*/
	@Override
	public long getCompanyId() {
		return _goalDetails.getCompanyId();
	}

	/**
	* Returns the evaluation ID of this goal details.
	*
	* @return the evaluation ID of this goal details
	*/
	@Override
	public long getEvaluationId() {
		return _goalDetails.getEvaluationId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _goalDetails.getExpandoBridge();
	}

	/**
	* Returns the goaldetail ID of this goal details.
	*
	* @return the goaldetail ID of this goal details
	*/
	@Override
	public long getGoaldetailId() {
		return _goalDetails.getGoaldetailId();
	}

	/**
	* Returns the goal ID of this goal details.
	*
	* @return the goal ID of this goal details
	*/
	@Override
	public long getGoalId() {
		return _goalDetails.getGoalId();
	}

	/**
	* Returns the parameter of this goal details.
	*
	* @return the parameter of this goal details
	*/
	@Override
	public String getParameter() {
		return _goalDetails.getParameter();
	}

	/**
	* Returns the primary key of this goal details.
	*
	* @return the primary key of this goal details
	*/
	@Override
	public long getPrimaryKey() {
		return _goalDetails.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _goalDetails.getPrimaryKeyObj();
	}

	/**
	* Returns the scale of this goal details.
	*
	* @return the scale of this goal details
	*/
	@Override
	public String getScale() {
		return _goalDetails.getScale();
	}

	@Override
	public int hashCode() {
		return _goalDetails.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _goalDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _goalDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _goalDetails.isNew();
	}

	@Override
	public void persist() {
		_goalDetails.persist();
	}

	/**
	* Sets the added date of this goal details.
	*
	* @param addedDate the added date of this goal details
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_goalDetails.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_goalDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this goal details.
	*
	* @param companyId the company ID of this goal details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_goalDetails.setCompanyId(companyId);
	}

	/**
	* Sets the evaluation ID of this goal details.
	*
	* @param evaluationId the evaluation ID of this goal details
	*/
	@Override
	public void setEvaluationId(long evaluationId) {
		_goalDetails.setEvaluationId(evaluationId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_goalDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_goalDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_goalDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the goaldetail ID of this goal details.
	*
	* @param goaldetailId the goaldetail ID of this goal details
	*/
	@Override
	public void setGoaldetailId(long goaldetailId) {
		_goalDetails.setGoaldetailId(goaldetailId);
	}

	/**
	* Sets the goal ID of this goal details.
	*
	* @param goalId the goal ID of this goal details
	*/
	@Override
	public void setGoalId(long goalId) {
		_goalDetails.setGoalId(goalId);
	}

	@Override
	public void setNew(boolean n) {
		_goalDetails.setNew(n);
	}

	/**
	* Sets the parameter of this goal details.
	*
	* @param parameter the parameter of this goal details
	*/
	@Override
	public void setParameter(String parameter) {
		_goalDetails.setParameter(parameter);
	}

	/**
	* Sets the primary key of this goal details.
	*
	* @param primaryKey the primary key of this goal details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_goalDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_goalDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the scale of this goal details.
	*
	* @param scale the scale of this goal details
	*/
	@Override
	public void setScale(String scale) {
		_goalDetails.setScale(scale);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<GoalDetails> toCacheModel() {
		return _goalDetails.toCacheModel();
	}

	@Override
	public GoalDetails toEscapedModel() {
		return new GoalDetailsWrapper(_goalDetails.toEscapedModel());
	}

	@Override
	public String toString() {
		return _goalDetails.toString();
	}

	@Override
	public GoalDetails toUnescapedModel() {
		return new GoalDetailsWrapper(_goalDetails.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _goalDetails.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GoalDetailsWrapper)) {
			return false;
		}

		GoalDetailsWrapper goalDetailsWrapper = (GoalDetailsWrapper)obj;

		if (Objects.equals(_goalDetails, goalDetailsWrapper._goalDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public GoalDetails getWrappedModel() {
		return _goalDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _goalDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _goalDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_goalDetails.resetOriginalValues();
	}

	private final GoalDetails _goalDetails;
}