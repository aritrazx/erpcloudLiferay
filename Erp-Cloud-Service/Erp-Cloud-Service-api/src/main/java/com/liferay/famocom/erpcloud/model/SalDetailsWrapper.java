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
 * This class is a wrapper for {@link SalDetails}.
 * </p>
 *
 * @author Samaresh
 * @see SalDetails
 * @generated
 */
@ProviderType
public class SalDetailsWrapper implements SalDetails, ModelWrapper<SalDetails> {
	public SalDetailsWrapper(SalDetails salDetails) {
		_salDetails = salDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return SalDetails.class;
	}

	@Override
	public String getModelClassName() {
		return SalDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("SalDetailsId", getSalDetailsId());
		attributes.put("monthYear", getMonthYear());
		attributes.put("componentId", getComponentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long SalDetailsId = (Long)attributes.get("SalDetailsId");

		if (SalDetailsId != null) {
			setSalDetailsId(SalDetailsId);
		}

		Long monthYear = (Long)attributes.get("monthYear");

		if (monthYear != null) {
			setMonthYear(monthYear);
		}

		Long componentId = (Long)attributes.get("componentId");

		if (componentId != null) {
			setComponentId(componentId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Double value = (Double)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public Object clone() {
		return new SalDetailsWrapper((SalDetails)_salDetails.clone());
	}

	@Override
	public int compareTo(SalDetails salDetails) {
		return _salDetails.compareTo(salDetails);
	}

	/**
	* Returns the component ID of this sal details.
	*
	* @return the component ID of this sal details
	*/
	@Override
	public long getComponentId() {
		return _salDetails.getComponentId();
	}

	/**
	* Returns the employee ID of this sal details.
	*
	* @return the employee ID of this sal details
	*/
	@Override
	public long getEmployeeId() {
		return _salDetails.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _salDetails.getExpandoBridge();
	}

	/**
	* Returns the month year of this sal details.
	*
	* @return the month year of this sal details
	*/
	@Override
	public long getMonthYear() {
		return _salDetails.getMonthYear();
	}

	/**
	* Returns the primary key of this sal details.
	*
	* @return the primary key of this sal details
	*/
	@Override
	public long getPrimaryKey() {
		return _salDetails.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _salDetails.getPrimaryKeyObj();
	}

	/**
	* Returns the sal details ID of this sal details.
	*
	* @return the sal details ID of this sal details
	*/
	@Override
	public long getSalDetailsId() {
		return _salDetails.getSalDetailsId();
	}

	/**
	* Returns the value of this sal details.
	*
	* @return the value of this sal details
	*/
	@Override
	public double getValue() {
		return _salDetails.getValue();
	}

	@Override
	public int hashCode() {
		return _salDetails.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _salDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _salDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _salDetails.isNew();
	}

	@Override
	public void persist() {
		_salDetails.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_salDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the component ID of this sal details.
	*
	* @param componentId the component ID of this sal details
	*/
	@Override
	public void setComponentId(long componentId) {
		_salDetails.setComponentId(componentId);
	}

	/**
	* Sets the employee ID of this sal details.
	*
	* @param employeeId the employee ID of this sal details
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_salDetails.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_salDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_salDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_salDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the month year of this sal details.
	*
	* @param monthYear the month year of this sal details
	*/
	@Override
	public void setMonthYear(long monthYear) {
		_salDetails.setMonthYear(monthYear);
	}

	@Override
	public void setNew(boolean n) {
		_salDetails.setNew(n);
	}

	/**
	* Sets the primary key of this sal details.
	*
	* @param primaryKey the primary key of this sal details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_salDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_salDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the sal details ID of this sal details.
	*
	* @param SalDetailsId the sal details ID of this sal details
	*/
	@Override
	public void setSalDetailsId(long SalDetailsId) {
		_salDetails.setSalDetailsId(SalDetailsId);
	}

	/**
	* Sets the value of this sal details.
	*
	* @param value the value of this sal details
	*/
	@Override
	public void setValue(double value) {
		_salDetails.setValue(value);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SalDetails> toCacheModel() {
		return _salDetails.toCacheModel();
	}

	@Override
	public SalDetails toEscapedModel() {
		return new SalDetailsWrapper(_salDetails.toEscapedModel());
	}

	@Override
	public String toString() {
		return _salDetails.toString();
	}

	@Override
	public SalDetails toUnescapedModel() {
		return new SalDetailsWrapper(_salDetails.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _salDetails.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SalDetailsWrapper)) {
			return false;
		}

		SalDetailsWrapper salDetailsWrapper = (SalDetailsWrapper)obj;

		if (Objects.equals(_salDetails, salDetailsWrapper._salDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public SalDetails getWrappedModel() {
		return _salDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _salDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _salDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_salDetails.resetOriginalValues();
	}

	private final SalDetails _salDetails;
}