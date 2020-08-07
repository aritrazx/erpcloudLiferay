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
 * This class is a wrapper for {@link Performance}.
 * </p>
 *
 * @author Samaresh
 * @see Performance
 * @generated
 */
@ProviderType
public class PerformanceWrapper implements Performance,
	ModelWrapper<Performance> {
	public PerformanceWrapper(Performance performance) {
		_performance = performance;
	}

	@Override
	public Class<?> getModelClass() {
		return Performance.class;
	}

	@Override
	public String getModelClassName() {
		return Performance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("performanceId", getPerformanceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("performanceHeading", getPerformanceHeading());
		attributes.put("performanceDescription", getPerformanceDescription());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long performanceId = (Long)attributes.get("performanceId");

		if (performanceId != null) {
			setPerformanceId(performanceId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String performanceHeading = (String)attributes.get("performanceHeading");

		if (performanceHeading != null) {
			setPerformanceHeading(performanceHeading);
		}

		String performanceDescription = (String)attributes.get(
				"performanceDescription");

		if (performanceDescription != null) {
			setPerformanceDescription(performanceDescription);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public Object clone() {
		return new PerformanceWrapper((Performance)_performance.clone());
	}

	@Override
	public int compareTo(Performance performance) {
		return _performance.compareTo(performance);
	}

	/**
	* Returns the company ID of this performance.
	*
	* @return the company ID of this performance
	*/
	@Override
	public long getCompanyId() {
		return _performance.getCompanyId();
	}

	/**
	* Returns the create date of this performance.
	*
	* @return the create date of this performance
	*/
	@Override
	public Date getCreateDate() {
		return _performance.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _performance.getExpandoBridge();
	}

	/**
	* Returns the performance description of this performance.
	*
	* @return the performance description of this performance
	*/
	@Override
	public String getPerformanceDescription() {
		return _performance.getPerformanceDescription();
	}

	/**
	* Returns the performance heading of this performance.
	*
	* @return the performance heading of this performance
	*/
	@Override
	public String getPerformanceHeading() {
		return _performance.getPerformanceHeading();
	}

	/**
	* Returns the performance ID of this performance.
	*
	* @return the performance ID of this performance
	*/
	@Override
	public long getPerformanceId() {
		return _performance.getPerformanceId();
	}

	/**
	* Returns the primary key of this performance.
	*
	* @return the primary key of this performance
	*/
	@Override
	public long getPrimaryKey() {
		return _performance.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _performance.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _performance.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _performance.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _performance.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _performance.isNew();
	}

	@Override
	public void persist() {
		_performance.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_performance.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this performance.
	*
	* @param companyId the company ID of this performance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_performance.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this performance.
	*
	* @param createDate the create date of this performance
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_performance.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_performance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_performance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_performance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_performance.setNew(n);
	}

	/**
	* Sets the performance description of this performance.
	*
	* @param performanceDescription the performance description of this performance
	*/
	@Override
	public void setPerformanceDescription(String performanceDescription) {
		_performance.setPerformanceDescription(performanceDescription);
	}

	/**
	* Sets the performance heading of this performance.
	*
	* @param performanceHeading the performance heading of this performance
	*/
	@Override
	public void setPerformanceHeading(String performanceHeading) {
		_performance.setPerformanceHeading(performanceHeading);
	}

	/**
	* Sets the performance ID of this performance.
	*
	* @param performanceId the performance ID of this performance
	*/
	@Override
	public void setPerformanceId(long performanceId) {
		_performance.setPerformanceId(performanceId);
	}

	/**
	* Sets the primary key of this performance.
	*
	* @param primaryKey the primary key of this performance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_performance.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_performance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Performance> toCacheModel() {
		return _performance.toCacheModel();
	}

	@Override
	public Performance toEscapedModel() {
		return new PerformanceWrapper(_performance.toEscapedModel());
	}

	@Override
	public String toString() {
		return _performance.toString();
	}

	@Override
	public Performance toUnescapedModel() {
		return new PerformanceWrapper(_performance.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _performance.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PerformanceWrapper)) {
			return false;
		}

		PerformanceWrapper performanceWrapper = (PerformanceWrapper)obj;

		if (Objects.equals(_performance, performanceWrapper._performance)) {
			return true;
		}

		return false;
	}

	@Override
	public Performance getWrappedModel() {
		return _performance;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _performance.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _performance.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_performance.resetOriginalValues();
	}

	private final Performance _performance;
}