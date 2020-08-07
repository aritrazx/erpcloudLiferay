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
 * This class is a wrapper for {@link PerformanceMaster}.
 * </p>
 *
 * @author Samaresh
 * @see PerformanceMaster
 * @generated
 */
@ProviderType
public class PerformanceMasterWrapper implements PerformanceMaster,
	ModelWrapper<PerformanceMaster> {
	public PerformanceMasterWrapper(PerformanceMaster performanceMaster) {
		_performanceMaster = performanceMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return PerformanceMaster.class;
	}

	@Override
	public String getModelClassName() {
		return PerformanceMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("performanceId", getPerformanceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("performanceHeading", getPerformanceHeading());
		attributes.put("performanceDescription", getPerformanceDescription());
		attributes.put("addedDate", getAddedDate());

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

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public Object clone() {
		return new PerformanceMasterWrapper((PerformanceMaster)_performanceMaster.clone());
	}

	@Override
	public int compareTo(PerformanceMaster performanceMaster) {
		return _performanceMaster.compareTo(performanceMaster);
	}

	/**
	* Returns the added date of this performance master.
	*
	* @return the added date of this performance master
	*/
	@Override
	public Date getAddedDate() {
		return _performanceMaster.getAddedDate();
	}

	/**
	* Returns the company ID of this performance master.
	*
	* @return the company ID of this performance master
	*/
	@Override
	public long getCompanyId() {
		return _performanceMaster.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _performanceMaster.getExpandoBridge();
	}

	/**
	* Returns the performance description of this performance master.
	*
	* @return the performance description of this performance master
	*/
	@Override
	public String getPerformanceDescription() {
		return _performanceMaster.getPerformanceDescription();
	}

	/**
	* Returns the performance heading of this performance master.
	*
	* @return the performance heading of this performance master
	*/
	@Override
	public String getPerformanceHeading() {
		return _performanceMaster.getPerformanceHeading();
	}

	/**
	* Returns the performance ID of this performance master.
	*
	* @return the performance ID of this performance master
	*/
	@Override
	public long getPerformanceId() {
		return _performanceMaster.getPerformanceId();
	}

	/**
	* Returns the primary key of this performance master.
	*
	* @return the primary key of this performance master
	*/
	@Override
	public long getPrimaryKey() {
		return _performanceMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _performanceMaster.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _performanceMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _performanceMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _performanceMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _performanceMaster.isNew();
	}

	@Override
	public void persist() {
		_performanceMaster.persist();
	}

	/**
	* Sets the added date of this performance master.
	*
	* @param addedDate the added date of this performance master
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_performanceMaster.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_performanceMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this performance master.
	*
	* @param companyId the company ID of this performance master
	*/
	@Override
	public void setCompanyId(long companyId) {
		_performanceMaster.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_performanceMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_performanceMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_performanceMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_performanceMaster.setNew(n);
	}

	/**
	* Sets the performance description of this performance master.
	*
	* @param performanceDescription the performance description of this performance master
	*/
	@Override
	public void setPerformanceDescription(String performanceDescription) {
		_performanceMaster.setPerformanceDescription(performanceDescription);
	}

	/**
	* Sets the performance heading of this performance master.
	*
	* @param performanceHeading the performance heading of this performance master
	*/
	@Override
	public void setPerformanceHeading(String performanceHeading) {
		_performanceMaster.setPerformanceHeading(performanceHeading);
	}

	/**
	* Sets the performance ID of this performance master.
	*
	* @param performanceId the performance ID of this performance master
	*/
	@Override
	public void setPerformanceId(long performanceId) {
		_performanceMaster.setPerformanceId(performanceId);
	}

	/**
	* Sets the primary key of this performance master.
	*
	* @param primaryKey the primary key of this performance master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_performanceMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_performanceMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PerformanceMaster> toCacheModel() {
		return _performanceMaster.toCacheModel();
	}

	@Override
	public PerformanceMaster toEscapedModel() {
		return new PerformanceMasterWrapper(_performanceMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _performanceMaster.toString();
	}

	@Override
	public PerformanceMaster toUnescapedModel() {
		return new PerformanceMasterWrapper(_performanceMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _performanceMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PerformanceMasterWrapper)) {
			return false;
		}

		PerformanceMasterWrapper performanceMasterWrapper = (PerformanceMasterWrapper)obj;

		if (Objects.equals(_performanceMaster,
					performanceMasterWrapper._performanceMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public PerformanceMaster getWrappedModel() {
		return _performanceMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _performanceMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _performanceMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_performanceMaster.resetOriginalValues();
	}

	private final PerformanceMaster _performanceMaster;
}