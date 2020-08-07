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
 * This class is a wrapper for {@link EmployeeType}.
 * </p>
 *
 * @author Samaresh
 * @see EmployeeType
 * @generated
 */
@ProviderType
public class EmployeeTypeWrapper implements EmployeeType,
	ModelWrapper<EmployeeType> {
	public EmployeeTypeWrapper(EmployeeType employeeType) {
		_employeeType = employeeType;
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeType.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeetypeId", getEmployeetypeId());
		attributes.put("typeName", getTypeName());
		attributes.put("pfDeduct", getPfDeduct());
		attributes.put("status", getStatus());
		attributes.put("companyId", getCompanyId());
		attributes.put("addeddate", getAddeddate());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeetypeId = (Long)attributes.get("employeetypeId");

		if (employeetypeId != null) {
			setEmployeetypeId(employeetypeId);
		}

		String typeName = (String)attributes.get("typeName");

		if (typeName != null) {
			setTypeName(typeName);
		}

		Long pfDeduct = (Long)attributes.get("pfDeduct");

		if (pfDeduct != null) {
			setPfDeduct(pfDeduct);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date addeddate = (Date)attributes.get("addeddate");

		if (addeddate != null) {
			setAddeddate(addeddate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public Object clone() {
		return new EmployeeTypeWrapper((EmployeeType)_employeeType.clone());
	}

	@Override
	public int compareTo(EmployeeType employeeType) {
		return _employeeType.compareTo(employeeType);
	}

	/**
	* Returns the addeddate of this employee type.
	*
	* @return the addeddate of this employee type
	*/
	@Override
	public Date getAddeddate() {
		return _employeeType.getAddeddate();
	}

	/**
	* Returns the company ID of this employee type.
	*
	* @return the company ID of this employee type
	*/
	@Override
	public long getCompanyId() {
		return _employeeType.getCompanyId();
	}

	/**
	* Returns the description of this employee type.
	*
	* @return the description of this employee type
	*/
	@Override
	public String getDescription() {
		return _employeeType.getDescription();
	}

	/**
	* Returns the employeetype ID of this employee type.
	*
	* @return the employeetype ID of this employee type
	*/
	@Override
	public long getEmployeetypeId() {
		return _employeeType.getEmployeetypeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _employeeType.getExpandoBridge();
	}

	/**
	* Returns the pf deduct of this employee type.
	*
	* @return the pf deduct of this employee type
	*/
	@Override
	public long getPfDeduct() {
		return _employeeType.getPfDeduct();
	}

	/**
	* Returns the primary key of this employee type.
	*
	* @return the primary key of this employee type
	*/
	@Override
	public long getPrimaryKey() {
		return _employeeType.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeType.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this employee type.
	*
	* @return the status of this employee type
	*/
	@Override
	public int getStatus() {
		return _employeeType.getStatus();
	}

	/**
	* Returns the type name of this employee type.
	*
	* @return the type name of this employee type
	*/
	@Override
	public String getTypeName() {
		return _employeeType.getTypeName();
	}

	@Override
	public int hashCode() {
		return _employeeType.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _employeeType.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _employeeType.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _employeeType.isNew();
	}

	@Override
	public void persist() {
		_employeeType.persist();
	}

	/**
	* Sets the addeddate of this employee type.
	*
	* @param addeddate the addeddate of this employee type
	*/
	@Override
	public void setAddeddate(Date addeddate) {
		_employeeType.setAddeddate(addeddate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employeeType.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this employee type.
	*
	* @param companyId the company ID of this employee type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_employeeType.setCompanyId(companyId);
	}

	/**
	* Sets the description of this employee type.
	*
	* @param description the description of this employee type
	*/
	@Override
	public void setDescription(String description) {
		_employeeType.setDescription(description);
	}

	/**
	* Sets the employeetype ID of this employee type.
	*
	* @param employeetypeId the employeetype ID of this employee type
	*/
	@Override
	public void setEmployeetypeId(long employeetypeId) {
		_employeeType.setEmployeetypeId(employeetypeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_employeeType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_employeeType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_employeeType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_employeeType.setNew(n);
	}

	/**
	* Sets the pf deduct of this employee type.
	*
	* @param pfDeduct the pf deduct of this employee type
	*/
	@Override
	public void setPfDeduct(long pfDeduct) {
		_employeeType.setPfDeduct(pfDeduct);
	}

	/**
	* Sets the primary key of this employee type.
	*
	* @param primaryKey the primary key of this employee type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employeeType.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_employeeType.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this employee type.
	*
	* @param status the status of this employee type
	*/
	@Override
	public void setStatus(int status) {
		_employeeType.setStatus(status);
	}

	/**
	* Sets the type name of this employee type.
	*
	* @param typeName the type name of this employee type
	*/
	@Override
	public void setTypeName(String typeName) {
		_employeeType.setTypeName(typeName);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EmployeeType> toCacheModel() {
		return _employeeType.toCacheModel();
	}

	@Override
	public EmployeeType toEscapedModel() {
		return new EmployeeTypeWrapper(_employeeType.toEscapedModel());
	}

	@Override
	public String toString() {
		return _employeeType.toString();
	}

	@Override
	public EmployeeType toUnescapedModel() {
		return new EmployeeTypeWrapper(_employeeType.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _employeeType.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeTypeWrapper)) {
			return false;
		}

		EmployeeTypeWrapper employeeTypeWrapper = (EmployeeTypeWrapper)obj;

		if (Objects.equals(_employeeType, employeeTypeWrapper._employeeType)) {
			return true;
		}

		return false;
	}

	@Override
	public EmployeeType getWrappedModel() {
		return _employeeType;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _employeeType.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _employeeType.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_employeeType.resetOriginalValues();
	}

	private final EmployeeType _employeeType;
}