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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the InterviewEvaluation service. Represents a row in the &quot;interviewEvaluation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.InterviewEvaluationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.InterviewEvaluationImpl}.
 * </p>
 *
 * @author Samaresh
 * @see InterviewEvaluation
 * @see com.liferay.famocom.erpcloud.model.impl.InterviewEvaluationImpl
 * @see com.liferay.famocom.erpcloud.model.impl.InterviewEvaluationModelImpl
 * @generated
 */
@ProviderType
public interface InterviewEvaluationModel extends BaseModel<InterviewEvaluation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a interview evaluation model instance should use the {@link InterviewEvaluation} interface instead.
	 */

	/**
	 * Returns the primary key of this interview evaluation.
	 *
	 * @return the primary key of this interview evaluation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this interview evaluation.
	 *
	 * @param primaryKey the primary key of this interview evaluation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the evaluation ID of this interview evaluation.
	 *
	 * @return the evaluation ID of this interview evaluation
	 */
	public long getEvaluationId();

	/**
	 * Sets the evaluation ID of this interview evaluation.
	 *
	 * @param evaluationId the evaluation ID of this interview evaluation
	 */
	public void setEvaluationId(long evaluationId);

	/**
	 * Returns the role ID of this interview evaluation.
	 *
	 * @return the role ID of this interview evaluation
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this interview evaluation.
	 *
	 * @param roleId the role ID of this interview evaluation
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the evaluation name of this interview evaluation.
	 *
	 * @return the evaluation name of this interview evaluation
	 */
	@AutoEscape
	public String getEvaluationName();

	/**
	 * Sets the evaluation name of this interview evaluation.
	 *
	 * @param evaluationName the evaluation name of this interview evaluation
	 */
	public void setEvaluationName(String evaluationName);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(InterviewEvaluation interviewEvaluation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<InterviewEvaluation> toCacheModel();

	@Override
	public InterviewEvaluation toEscapedModel();

	@Override
	public InterviewEvaluation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}