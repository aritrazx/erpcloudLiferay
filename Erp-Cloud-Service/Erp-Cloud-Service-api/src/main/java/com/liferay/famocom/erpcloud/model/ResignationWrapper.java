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
 * This class is a wrapper for {@link Resignation}.
 * </p>
 *
 * @author Samaresh
 * @see Resignation
 * @generated
 */
@ProviderType
public class ResignationWrapper implements Resignation,
	ModelWrapper<Resignation> {
	public ResignationWrapper(Resignation resignation) {
		_resignation = resignation;
	}

	@Override
	public Class<?> getModelClass() {
		return Resignation.class;
	}

	@Override
	public String getModelClassName() {
		return Resignation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ResignationId", getResignationId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("resignationDate", getResignationDate());
		attributes.put("resignationSubDate", getResignationSubDate());
		attributes.put("Description", getDescription());
		attributes.put("managerId", getManagerId());
		attributes.put("mancomment", getMancomment());
		attributes.put("mancommentdate", getMancommentdate());
		attributes.put("status", isStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ResignationId = (Long)attributes.get("ResignationId");

		if (ResignationId != null) {
			setResignationId(ResignationId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date resignationDate = (Date)attributes.get("resignationDate");

		if (resignationDate != null) {
			setResignationDate(resignationDate);
		}

		Date resignationSubDate = (Date)attributes.get("resignationSubDate");

		if (resignationSubDate != null) {
			setResignationSubDate(resignationSubDate);
		}

		String Description = (String)attributes.get("Description");

		if (Description != null) {
			setDescription(Description);
		}

		Long managerId = (Long)attributes.get("managerId");

		if (managerId != null) {
			setManagerId(managerId);
		}

		String mancomment = (String)attributes.get("mancomment");

		if (mancomment != null) {
			setMancomment(mancomment);
		}

		Date mancommentdate = (Date)attributes.get("mancommentdate");

		if (mancommentdate != null) {
			setMancommentdate(mancommentdate);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Object clone() {
		return new ResignationWrapper((Resignation)_resignation.clone());
	}

	@Override
	public int compareTo(Resignation resignation) {
		return _resignation.compareTo(resignation);
	}

	/**
	* Returns the description of this resignation.
	*
	* @return the description of this resignation
	*/
	@Override
	public String getDescription() {
		return _resignation.getDescription();
	}

	/**
	* Returns the employee ID of this resignation.
	*
	* @return the employee ID of this resignation
	*/
	@Override
	public long getEmployeeId() {
		return _resignation.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _resignation.getExpandoBridge();
	}

	/**
	* Returns the manager ID of this resignation.
	*
	* @return the manager ID of this resignation
	*/
	@Override
	public long getManagerId() {
		return _resignation.getManagerId();
	}

	/**
	* Returns the mancomment of this resignation.
	*
	* @return the mancomment of this resignation
	*/
	@Override
	public String getMancomment() {
		return _resignation.getMancomment();
	}

	/**
	* Returns the mancommentdate of this resignation.
	*
	* @return the mancommentdate of this resignation
	*/
	@Override
	public Date getMancommentdate() {
		return _resignation.getMancommentdate();
	}

	/**
	* Returns the primary key of this resignation.
	*
	* @return the primary key of this resignation
	*/
	@Override
	public long getPrimaryKey() {
		return _resignation.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _resignation.getPrimaryKeyObj();
	}

	/**
	* Returns the resignation date of this resignation.
	*
	* @return the resignation date of this resignation
	*/
	@Override
	public Date getResignationDate() {
		return _resignation.getResignationDate();
	}

	/**
	* Returns the resignation ID of this resignation.
	*
	* @return the resignation ID of this resignation
	*/
	@Override
	public long getResignationId() {
		return _resignation.getResignationId();
	}

	/**
	* Returns the resignation sub date of this resignation.
	*
	* @return the resignation sub date of this resignation
	*/
	@Override
	public Date getResignationSubDate() {
		return _resignation.getResignationSubDate();
	}

	/**
	* Returns the status of this resignation.
	*
	* @return the status of this resignation
	*/
	@Override
	public boolean getStatus() {
		return _resignation.getStatus();
	}

	@Override
	public int hashCode() {
		return _resignation.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _resignation.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _resignation.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _resignation.isNew();
	}

	/**
	* Returns <code>true</code> if this resignation is status.
	*
	* @return <code>true</code> if this resignation is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _resignation.isStatus();
	}

	@Override
	public void persist() {
		_resignation.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_resignation.setCachedModel(cachedModel);
	}

	/**
	* Sets the description of this resignation.
	*
	* @param Description the description of this resignation
	*/
	@Override
	public void setDescription(String Description) {
		_resignation.setDescription(Description);
	}

	/**
	* Sets the employee ID of this resignation.
	*
	* @param employeeId the employee ID of this resignation
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_resignation.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_resignation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_resignation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_resignation.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the manager ID of this resignation.
	*
	* @param managerId the manager ID of this resignation
	*/
	@Override
	public void setManagerId(long managerId) {
		_resignation.setManagerId(managerId);
	}

	/**
	* Sets the mancomment of this resignation.
	*
	* @param mancomment the mancomment of this resignation
	*/
	@Override
	public void setMancomment(String mancomment) {
		_resignation.setMancomment(mancomment);
	}

	/**
	* Sets the mancommentdate of this resignation.
	*
	* @param mancommentdate the mancommentdate of this resignation
	*/
	@Override
	public void setMancommentdate(Date mancommentdate) {
		_resignation.setMancommentdate(mancommentdate);
	}

	@Override
	public void setNew(boolean n) {
		_resignation.setNew(n);
	}

	/**
	* Sets the primary key of this resignation.
	*
	* @param primaryKey the primary key of this resignation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_resignation.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_resignation.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the resignation date of this resignation.
	*
	* @param resignationDate the resignation date of this resignation
	*/
	@Override
	public void setResignationDate(Date resignationDate) {
		_resignation.setResignationDate(resignationDate);
	}

	/**
	* Sets the resignation ID of this resignation.
	*
	* @param ResignationId the resignation ID of this resignation
	*/
	@Override
	public void setResignationId(long ResignationId) {
		_resignation.setResignationId(ResignationId);
	}

	/**
	* Sets the resignation sub date of this resignation.
	*
	* @param resignationSubDate the resignation sub date of this resignation
	*/
	@Override
	public void setResignationSubDate(Date resignationSubDate) {
		_resignation.setResignationSubDate(resignationSubDate);
	}

	/**
	* Sets whether this resignation is status.
	*
	* @param status the status of this resignation
	*/
	@Override
	public void setStatus(boolean status) {
		_resignation.setStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Resignation> toCacheModel() {
		return _resignation.toCacheModel();
	}

	@Override
	public Resignation toEscapedModel() {
		return new ResignationWrapper(_resignation.toEscapedModel());
	}

	@Override
	public String toString() {
		return _resignation.toString();
	}

	@Override
	public Resignation toUnescapedModel() {
		return new ResignationWrapper(_resignation.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _resignation.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ResignationWrapper)) {
			return false;
		}

		ResignationWrapper resignationWrapper = (ResignationWrapper)obj;

		if (Objects.equals(_resignation, resignationWrapper._resignation)) {
			return true;
		}

		return false;
	}

	@Override
	public Resignation getWrappedModel() {
		return _resignation;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _resignation.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _resignation.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_resignation.resetOriginalValues();
	}

	private final Resignation _resignation;
}