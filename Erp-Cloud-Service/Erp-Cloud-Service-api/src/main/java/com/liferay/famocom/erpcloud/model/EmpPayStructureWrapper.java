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
 * This class is a wrapper for {@link EmpPayStructure}.
 * </p>
 *
 * @author Samaresh
 * @see EmpPayStructure
 * @generated
 */
@ProviderType
public class EmpPayStructureWrapper implements EmpPayStructure,
	ModelWrapper<EmpPayStructure> {
	public EmpPayStructureWrapper(EmpPayStructure empPayStructure) {
		_empPayStructure = empPayStructure;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpPayStructure.class;
	}

	@Override
	public String getModelClassName() {
		return EmpPayStructure.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empPayStructureId", getEmpPayStructureId());
		attributes.put("payComponentId", getPayComponentId());
		attributes.put("componentValue", getComponentValue());
		attributes.put("employeeId", getEmployeeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empPayStructureId = (Long)attributes.get("empPayStructureId");

		if (empPayStructureId != null) {
			setEmpPayStructureId(empPayStructureId);
		}

		Long payComponentId = (Long)attributes.get("payComponentId");

		if (payComponentId != null) {
			setPayComponentId(payComponentId);
		}

		Double componentValue = (Double)attributes.get("componentValue");

		if (componentValue != null) {
			setComponentValue(componentValue);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	@Override
	public Object clone() {
		return new EmpPayStructureWrapper((EmpPayStructure)_empPayStructure.clone());
	}

	@Override
	public int compareTo(EmpPayStructure empPayStructure) {
		return _empPayStructure.compareTo(empPayStructure);
	}

	/**
	* Returns the component value of this emp pay structure.
	*
	* @return the component value of this emp pay structure
	*/
	@Override
	public double getComponentValue() {
		return _empPayStructure.getComponentValue();
	}

	/**
	* Returns the employee ID of this emp pay structure.
	*
	* @return the employee ID of this emp pay structure
	*/
	@Override
	public long getEmployeeId() {
		return _empPayStructure.getEmployeeId();
	}

	/**
	* Returns the emp pay structure ID of this emp pay structure.
	*
	* @return the emp pay structure ID of this emp pay structure
	*/
	@Override
	public long getEmpPayStructureId() {
		return _empPayStructure.getEmpPayStructureId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _empPayStructure.getExpandoBridge();
	}

	/**
	* Returns the pay component ID of this emp pay structure.
	*
	* @return the pay component ID of this emp pay structure
	*/
	@Override
	public long getPayComponentId() {
		return _empPayStructure.getPayComponentId();
	}

	/**
	* Returns the primary key of this emp pay structure.
	*
	* @return the primary key of this emp pay structure
	*/
	@Override
	public long getPrimaryKey() {
		return _empPayStructure.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empPayStructure.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _empPayStructure.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _empPayStructure.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _empPayStructure.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _empPayStructure.isNew();
	}

	@Override
	public void persist() {
		_empPayStructure.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empPayStructure.setCachedModel(cachedModel);
	}

	/**
	* Sets the component value of this emp pay structure.
	*
	* @param componentValue the component value of this emp pay structure
	*/
	@Override
	public void setComponentValue(double componentValue) {
		_empPayStructure.setComponentValue(componentValue);
	}

	/**
	* Sets the employee ID of this emp pay structure.
	*
	* @param employeeId the employee ID of this emp pay structure
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empPayStructure.setEmployeeId(employeeId);
	}

	/**
	* Sets the emp pay structure ID of this emp pay structure.
	*
	* @param empPayStructureId the emp pay structure ID of this emp pay structure
	*/
	@Override
	public void setEmpPayStructureId(long empPayStructureId) {
		_empPayStructure.setEmpPayStructureId(empPayStructureId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_empPayStructure.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_empPayStructure.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_empPayStructure.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_empPayStructure.setNew(n);
	}

	/**
	* Sets the pay component ID of this emp pay structure.
	*
	* @param payComponentId the pay component ID of this emp pay structure
	*/
	@Override
	public void setPayComponentId(long payComponentId) {
		_empPayStructure.setPayComponentId(payComponentId);
	}

	/**
	* Sets the primary key of this emp pay structure.
	*
	* @param primaryKey the primary key of this emp pay structure
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empPayStructure.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_empPayStructure.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EmpPayStructure> toCacheModel() {
		return _empPayStructure.toCacheModel();
	}

	@Override
	public EmpPayStructure toEscapedModel() {
		return new EmpPayStructureWrapper(_empPayStructure.toEscapedModel());
	}

	@Override
	public String toString() {
		return _empPayStructure.toString();
	}

	@Override
	public EmpPayStructure toUnescapedModel() {
		return new EmpPayStructureWrapper(_empPayStructure.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _empPayStructure.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpPayStructureWrapper)) {
			return false;
		}

		EmpPayStructureWrapper empPayStructureWrapper = (EmpPayStructureWrapper)obj;

		if (Objects.equals(_empPayStructure,
					empPayStructureWrapper._empPayStructure)) {
			return true;
		}

		return false;
	}

	@Override
	public EmpPayStructure getWrappedModel() {
		return _empPayStructure;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _empPayStructure.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _empPayStructure.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_empPayStructure.resetOriginalValues();
	}

	private final EmpPayStructure _empPayStructure;
}