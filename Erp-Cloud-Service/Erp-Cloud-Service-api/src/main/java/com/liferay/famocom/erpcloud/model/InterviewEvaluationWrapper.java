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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link InterviewEvaluation}.
 * </p>
 *
 * @author Samaresh
 * @see InterviewEvaluation
 * @generated
 */
@ProviderType
public class InterviewEvaluationWrapper implements InterviewEvaluation,
	ModelWrapper<InterviewEvaluation> {
	public InterviewEvaluationWrapper(InterviewEvaluation interviewEvaluation) {
		_interviewEvaluation = interviewEvaluation;
	}

	@Override
	public Class<?> getModelClass() {
		return InterviewEvaluation.class;
	}

	@Override
	public String getModelClassName() {
		return InterviewEvaluation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("evaluationId", getEvaluationId());
		attributes.put("roleId", getRoleId());
		attributes.put("evaluationName", getEvaluationName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long evaluationId = (Long)attributes.get("evaluationId");

		if (evaluationId != null) {
			setEvaluationId(evaluationId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String evaluationName = (String)attributes.get("evaluationName");

		if (evaluationName != null) {
			setEvaluationName(evaluationName);
		}
	}

	@Override
	public Object clone() {
		return new InterviewEvaluationWrapper((InterviewEvaluation)_interviewEvaluation.clone());
	}

	@Override
	public int compareTo(InterviewEvaluation interviewEvaluation) {
		return _interviewEvaluation.compareTo(interviewEvaluation);
	}

	/**
	* Returns the evaluation ID of this interview evaluation.
	*
	* @return the evaluation ID of this interview evaluation
	*/
	@Override
	public long getEvaluationId() {
		return _interviewEvaluation.getEvaluationId();
	}

	/**
	* Returns the evaluation name of this interview evaluation.
	*
	* @return the evaluation name of this interview evaluation
	*/
	@Override
	public String getEvaluationName() {
		return _interviewEvaluation.getEvaluationName();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _interviewEvaluation.getExpandoBridge();
	}

	/**
	* Returns the primary key of this interview evaluation.
	*
	* @return the primary key of this interview evaluation
	*/
	@Override
	public long getPrimaryKey() {
		return _interviewEvaluation.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _interviewEvaluation.getPrimaryKeyObj();
	}

	/**
	* Returns the role ID of this interview evaluation.
	*
	* @return the role ID of this interview evaluation
	*/
	@Override
	public long getRoleId() {
		return _interviewEvaluation.getRoleId();
	}

	@Override
	public int hashCode() {
		return _interviewEvaluation.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _interviewEvaluation.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _interviewEvaluation.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _interviewEvaluation.isNew();
	}

	@Override
	public void persist() {
		_interviewEvaluation.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_interviewEvaluation.setCachedModel(cachedModel);
	}

	/**
	* Sets the evaluation ID of this interview evaluation.
	*
	* @param evaluationId the evaluation ID of this interview evaluation
	*/
	@Override
	public void setEvaluationId(long evaluationId) {
		_interviewEvaluation.setEvaluationId(evaluationId);
	}

	/**
	* Sets the evaluation name of this interview evaluation.
	*
	* @param evaluationName the evaluation name of this interview evaluation
	*/
	@Override
	public void setEvaluationName(String evaluationName) {
		_interviewEvaluation.setEvaluationName(evaluationName);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_interviewEvaluation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_interviewEvaluation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_interviewEvaluation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_interviewEvaluation.setNew(n);
	}

	/**
	* Sets the primary key of this interview evaluation.
	*
	* @param primaryKey the primary key of this interview evaluation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_interviewEvaluation.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_interviewEvaluation.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the role ID of this interview evaluation.
	*
	* @param roleId the role ID of this interview evaluation
	*/
	@Override
	public void setRoleId(long roleId) {
		_interviewEvaluation.setRoleId(roleId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<InterviewEvaluation> toCacheModel() {
		return _interviewEvaluation.toCacheModel();
	}

	@Override
	public InterviewEvaluation toEscapedModel() {
		return new InterviewEvaluationWrapper(_interviewEvaluation.toEscapedModel());
	}

	@Override
	public String toString() {
		return _interviewEvaluation.toString();
	}

	@Override
	public InterviewEvaluation toUnescapedModel() {
		return new InterviewEvaluationWrapper(_interviewEvaluation.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _interviewEvaluation.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InterviewEvaluationWrapper)) {
			return false;
		}

		InterviewEvaluationWrapper interviewEvaluationWrapper = (InterviewEvaluationWrapper)obj;

		if (Objects.equals(_interviewEvaluation,
					interviewEvaluationWrapper._interviewEvaluation)) {
			return true;
		}

		return false;
	}

	@Override
	public InterviewEvaluation getWrappedModel() {
		return _interviewEvaluation;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _interviewEvaluation.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _interviewEvaluation.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_interviewEvaluation.resetOriginalValues();
	}

	private final InterviewEvaluation _interviewEvaluation;
}