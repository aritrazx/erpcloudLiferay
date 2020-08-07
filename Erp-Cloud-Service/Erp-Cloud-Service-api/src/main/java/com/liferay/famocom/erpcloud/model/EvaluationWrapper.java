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
 * This class is a wrapper for {@link Evaluation}.
 * </p>
 *
 * @author Samaresh
 * @see Evaluation
 * @generated
 */
@ProviderType
public class EvaluationWrapper implements Evaluation, ModelWrapper<Evaluation> {
	public EvaluationWrapper(Evaluation evaluation) {
		_evaluation = evaluation;
	}

	@Override
	public Class<?> getModelClass() {
		return Evaluation.class;
	}

	@Override
	public String getModelClassName() {
		return Evaluation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("evaluationId", getEvaluationId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("evaluatedBy", getEvaluatedBy());
		attributes.put("evalMessage", getEvalMessage());
		attributes.put("evalDate", getEvalDate());
		attributes.put("evalRating", getEvalRating());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long evaluationId = (Long)attributes.get("evaluationId");

		if (evaluationId != null) {
			setEvaluationId(evaluationId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long evaluatedBy = (Long)attributes.get("evaluatedBy");

		if (evaluatedBy != null) {
			setEvaluatedBy(evaluatedBy);
		}

		String evalMessage = (String)attributes.get("evalMessage");

		if (evalMessage != null) {
			setEvalMessage(evalMessage);
		}

		Date evalDate = (Date)attributes.get("evalDate");

		if (evalDate != null) {
			setEvalDate(evalDate);
		}

		Integer evalRating = (Integer)attributes.get("evalRating");

		if (evalRating != null) {
			setEvalRating(evalRating);
		}
	}

	@Override
	public Object clone() {
		return new EvaluationWrapper((Evaluation)_evaluation.clone());
	}

	@Override
	public int compareTo(Evaluation evaluation) {
		return _evaluation.compareTo(evaluation);
	}

	/**
	* Returns the employee ID of this evaluation.
	*
	* @return the employee ID of this evaluation
	*/
	@Override
	public long getEmployeeId() {
		return _evaluation.getEmployeeId();
	}

	/**
	* Returns the eval date of this evaluation.
	*
	* @return the eval date of this evaluation
	*/
	@Override
	public Date getEvalDate() {
		return _evaluation.getEvalDate();
	}

	/**
	* Returns the eval message of this evaluation.
	*
	* @return the eval message of this evaluation
	*/
	@Override
	public String getEvalMessage() {
		return _evaluation.getEvalMessage();
	}

	/**
	* Returns the eval rating of this evaluation.
	*
	* @return the eval rating of this evaluation
	*/
	@Override
	public int getEvalRating() {
		return _evaluation.getEvalRating();
	}

	/**
	* Returns the evaluated by of this evaluation.
	*
	* @return the evaluated by of this evaluation
	*/
	@Override
	public long getEvaluatedBy() {
		return _evaluation.getEvaluatedBy();
	}

	/**
	* Returns the evaluation ID of this evaluation.
	*
	* @return the evaluation ID of this evaluation
	*/
	@Override
	public long getEvaluationId() {
		return _evaluation.getEvaluationId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _evaluation.getExpandoBridge();
	}

	/**
	* Returns the primary key of this evaluation.
	*
	* @return the primary key of this evaluation
	*/
	@Override
	public long getPrimaryKey() {
		return _evaluation.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _evaluation.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _evaluation.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _evaluation.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _evaluation.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _evaluation.isNew();
	}

	@Override
	public void persist() {
		_evaluation.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_evaluation.setCachedModel(cachedModel);
	}

	/**
	* Sets the employee ID of this evaluation.
	*
	* @param employeeId the employee ID of this evaluation
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_evaluation.setEmployeeId(employeeId);
	}

	/**
	* Sets the eval date of this evaluation.
	*
	* @param evalDate the eval date of this evaluation
	*/
	@Override
	public void setEvalDate(Date evalDate) {
		_evaluation.setEvalDate(evalDate);
	}

	/**
	* Sets the eval message of this evaluation.
	*
	* @param evalMessage the eval message of this evaluation
	*/
	@Override
	public void setEvalMessage(String evalMessage) {
		_evaluation.setEvalMessage(evalMessage);
	}

	/**
	* Sets the eval rating of this evaluation.
	*
	* @param evalRating the eval rating of this evaluation
	*/
	@Override
	public void setEvalRating(int evalRating) {
		_evaluation.setEvalRating(evalRating);
	}

	/**
	* Sets the evaluated by of this evaluation.
	*
	* @param evaluatedBy the evaluated by of this evaluation
	*/
	@Override
	public void setEvaluatedBy(long evaluatedBy) {
		_evaluation.setEvaluatedBy(evaluatedBy);
	}

	/**
	* Sets the evaluation ID of this evaluation.
	*
	* @param evaluationId the evaluation ID of this evaluation
	*/
	@Override
	public void setEvaluationId(long evaluationId) {
		_evaluation.setEvaluationId(evaluationId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_evaluation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_evaluation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_evaluation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_evaluation.setNew(n);
	}

	/**
	* Sets the primary key of this evaluation.
	*
	* @param primaryKey the primary key of this evaluation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_evaluation.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_evaluation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Evaluation> toCacheModel() {
		return _evaluation.toCacheModel();
	}

	@Override
	public Evaluation toEscapedModel() {
		return new EvaluationWrapper(_evaluation.toEscapedModel());
	}

	@Override
	public String toString() {
		return _evaluation.toString();
	}

	@Override
	public Evaluation toUnescapedModel() {
		return new EvaluationWrapper(_evaluation.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _evaluation.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EvaluationWrapper)) {
			return false;
		}

		EvaluationWrapper evaluationWrapper = (EvaluationWrapper)obj;

		if (Objects.equals(_evaluation, evaluationWrapper._evaluation)) {
			return true;
		}

		return false;
	}

	@Override
	public Evaluation getWrappedModel() {
		return _evaluation;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _evaluation.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _evaluation.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_evaluation.resetOriginalValues();
	}

	private final Evaluation _evaluation;
}