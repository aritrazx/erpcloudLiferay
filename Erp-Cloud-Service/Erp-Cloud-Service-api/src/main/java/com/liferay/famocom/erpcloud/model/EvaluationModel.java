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

import java.util.Date;

/**
 * The base model interface for the Evaluation service. Represents a row in the &quot;evaluation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.EvaluationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.EvaluationImpl}.
 * </p>
 *
 * @author Samaresh
 * @see Evaluation
 * @see com.liferay.famocom.erpcloud.model.impl.EvaluationImpl
 * @see com.liferay.famocom.erpcloud.model.impl.EvaluationModelImpl
 * @generated
 */
@ProviderType
public interface EvaluationModel extends BaseModel<Evaluation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a evaluation model instance should use the {@link Evaluation} interface instead.
	 */

	/**
	 * Returns the primary key of this evaluation.
	 *
	 * @return the primary key of this evaluation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this evaluation.
	 *
	 * @param primaryKey the primary key of this evaluation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the evaluation ID of this evaluation.
	 *
	 * @return the evaluation ID of this evaluation
	 */
	public long getEvaluationId();

	/**
	 * Sets the evaluation ID of this evaluation.
	 *
	 * @param evaluationId the evaluation ID of this evaluation
	 */
	public void setEvaluationId(long evaluationId);

	/**
	 * Returns the employee ID of this evaluation.
	 *
	 * @return the employee ID of this evaluation
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this evaluation.
	 *
	 * @param employeeId the employee ID of this evaluation
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the evaluated by of this evaluation.
	 *
	 * @return the evaluated by of this evaluation
	 */
	public long getEvaluatedBy();

	/**
	 * Sets the evaluated by of this evaluation.
	 *
	 * @param evaluatedBy the evaluated by of this evaluation
	 */
	public void setEvaluatedBy(long evaluatedBy);

	/**
	 * Returns the eval message of this evaluation.
	 *
	 * @return the eval message of this evaluation
	 */
	@AutoEscape
	public String getEvalMessage();

	/**
	 * Sets the eval message of this evaluation.
	 *
	 * @param evalMessage the eval message of this evaluation
	 */
	public void setEvalMessage(String evalMessage);

	/**
	 * Returns the eval date of this evaluation.
	 *
	 * @return the eval date of this evaluation
	 */
	public Date getEvalDate();

	/**
	 * Sets the eval date of this evaluation.
	 *
	 * @param evalDate the eval date of this evaluation
	 */
	public void setEvalDate(Date evalDate);

	/**
	 * Returns the eval rating of this evaluation.
	 *
	 * @return the eval rating of this evaluation
	 */
	public int getEvalRating();

	/**
	 * Sets the eval rating of this evaluation.
	 *
	 * @param evalRating the eval rating of this evaluation
	 */
	public void setEvalRating(int evalRating);

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
	public int compareTo(Evaluation evaluation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Evaluation> toCacheModel();

	@Override
	public Evaluation toEscapedModel();

	@Override
	public Evaluation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}