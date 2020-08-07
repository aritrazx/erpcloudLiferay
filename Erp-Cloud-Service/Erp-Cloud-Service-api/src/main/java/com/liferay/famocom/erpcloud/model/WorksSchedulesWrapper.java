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
 * This class is a wrapper for {@link WorksSchedules}.
 * </p>
 *
 * @author Samaresh
 * @see WorksSchedules
 * @generated
 */
@ProviderType
public class WorksSchedulesWrapper implements WorksSchedules,
	ModelWrapper<WorksSchedules> {
	public WorksSchedulesWrapper(WorksSchedules worksSchedules) {
		_worksSchedules = worksSchedules;
	}

	@Override
	public Class<?> getModelClass() {
		return WorksSchedules.class;
	}

	@Override
	public String getModelClassName() {
		return WorksSchedules.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("worksSchedulesId", getWorksSchedulesId());
		attributes.put("companyId", getCompanyId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("schedulesId", getSchedulesId());
		attributes.put("islock", getIslock());
		attributes.put("status", getStatus());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long worksSchedulesId = (Long)attributes.get("worksSchedulesId");

		if (worksSchedulesId != null) {
			setWorksSchedulesId(worksSchedulesId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Long schedulesId = (Long)attributes.get("schedulesId");

		if (schedulesId != null) {
			setSchedulesId(schedulesId);
		}

		Integer islock = (Integer)attributes.get("islock");

		if (islock != null) {
			setIslock(islock);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public Object clone() {
		return new WorksSchedulesWrapper((WorksSchedules)_worksSchedules.clone());
	}

	@Override
	public int compareTo(WorksSchedules worksSchedules) {
		return _worksSchedules.compareTo(worksSchedules);
	}

	/**
	* Returns the company ID of this works schedules.
	*
	* @return the company ID of this works schedules
	*/
	@Override
	public long getCompanyId() {
		return _worksSchedules.getCompanyId();
	}

	/**
	* Returns the create date of this works schedules.
	*
	* @return the create date of this works schedules
	*/
	@Override
	public Date getCreateDate() {
		return _worksSchedules.getCreateDate();
	}

	/**
	* Returns the description of this works schedules.
	*
	* @return the description of this works schedules
	*/
	@Override
	public String getDescription() {
		return _worksSchedules.getDescription();
	}

	/**
	* Returns the employee ID of this works schedules.
	*
	* @return the employee ID of this works schedules
	*/
	@Override
	public long getEmployeeId() {
		return _worksSchedules.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _worksSchedules.getExpandoBridge();
	}

	/**
	* Returns the from date of this works schedules.
	*
	* @return the from date of this works schedules
	*/
	@Override
	public Date getFromDate() {
		return _worksSchedules.getFromDate();
	}

	/**
	* Returns the islock of this works schedules.
	*
	* @return the islock of this works schedules
	*/
	@Override
	public int getIslock() {
		return _worksSchedules.getIslock();
	}

	/**
	* Returns the modified date of this works schedules.
	*
	* @return the modified date of this works schedules
	*/
	@Override
	public Date getModifiedDate() {
		return _worksSchedules.getModifiedDate();
	}

	/**
	* Returns the primary key of this works schedules.
	*
	* @return the primary key of this works schedules
	*/
	@Override
	public long getPrimaryKey() {
		return _worksSchedules.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _worksSchedules.getPrimaryKeyObj();
	}

	/**
	* Returns the schedules ID of this works schedules.
	*
	* @return the schedules ID of this works schedules
	*/
	@Override
	public long getSchedulesId() {
		return _worksSchedules.getSchedulesId();
	}

	/**
	* Returns the status of this works schedules.
	*
	* @return the status of this works schedules
	*/
	@Override
	public int getStatus() {
		return _worksSchedules.getStatus();
	}

	/**
	* Returns the to date of this works schedules.
	*
	* @return the to date of this works schedules
	*/
	@Override
	public Date getToDate() {
		return _worksSchedules.getToDate();
	}

	/**
	* Returns the works schedules ID of this works schedules.
	*
	* @return the works schedules ID of this works schedules
	*/
	@Override
	public long getWorksSchedulesId() {
		return _worksSchedules.getWorksSchedulesId();
	}

	@Override
	public int hashCode() {
		return _worksSchedules.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _worksSchedules.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _worksSchedules.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _worksSchedules.isNew();
	}

	@Override
	public void persist() {
		_worksSchedules.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_worksSchedules.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this works schedules.
	*
	* @param companyId the company ID of this works schedules
	*/
	@Override
	public void setCompanyId(long companyId) {
		_worksSchedules.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this works schedules.
	*
	* @param createDate the create date of this works schedules
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_worksSchedules.setCreateDate(createDate);
	}

	/**
	* Sets the description of this works schedules.
	*
	* @param description the description of this works schedules
	*/
	@Override
	public void setDescription(String description) {
		_worksSchedules.setDescription(description);
	}

	/**
	* Sets the employee ID of this works schedules.
	*
	* @param employeeId the employee ID of this works schedules
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_worksSchedules.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_worksSchedules.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_worksSchedules.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_worksSchedules.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the from date of this works schedules.
	*
	* @param fromDate the from date of this works schedules
	*/
	@Override
	public void setFromDate(Date fromDate) {
		_worksSchedules.setFromDate(fromDate);
	}

	/**
	* Sets the islock of this works schedules.
	*
	* @param islock the islock of this works schedules
	*/
	@Override
	public void setIslock(int islock) {
		_worksSchedules.setIslock(islock);
	}

	/**
	* Sets the modified date of this works schedules.
	*
	* @param modifiedDate the modified date of this works schedules
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_worksSchedules.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_worksSchedules.setNew(n);
	}

	/**
	* Sets the primary key of this works schedules.
	*
	* @param primaryKey the primary key of this works schedules
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_worksSchedules.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_worksSchedules.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the schedules ID of this works schedules.
	*
	* @param schedulesId the schedules ID of this works schedules
	*/
	@Override
	public void setSchedulesId(long schedulesId) {
		_worksSchedules.setSchedulesId(schedulesId);
	}

	/**
	* Sets the status of this works schedules.
	*
	* @param status the status of this works schedules
	*/
	@Override
	public void setStatus(int status) {
		_worksSchedules.setStatus(status);
	}

	/**
	* Sets the to date of this works schedules.
	*
	* @param toDate the to date of this works schedules
	*/
	@Override
	public void setToDate(Date toDate) {
		_worksSchedules.setToDate(toDate);
	}

	/**
	* Sets the works schedules ID of this works schedules.
	*
	* @param worksSchedulesId the works schedules ID of this works schedules
	*/
	@Override
	public void setWorksSchedulesId(long worksSchedulesId) {
		_worksSchedules.setWorksSchedulesId(worksSchedulesId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WorksSchedules> toCacheModel() {
		return _worksSchedules.toCacheModel();
	}

	@Override
	public WorksSchedules toEscapedModel() {
		return new WorksSchedulesWrapper(_worksSchedules.toEscapedModel());
	}

	@Override
	public String toString() {
		return _worksSchedules.toString();
	}

	@Override
	public WorksSchedules toUnescapedModel() {
		return new WorksSchedulesWrapper(_worksSchedules.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _worksSchedules.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorksSchedulesWrapper)) {
			return false;
		}

		WorksSchedulesWrapper worksSchedulesWrapper = (WorksSchedulesWrapper)obj;

		if (Objects.equals(_worksSchedules,
					worksSchedulesWrapper._worksSchedules)) {
			return true;
		}

		return false;
	}

	@Override
	public WorksSchedules getWrappedModel() {
		return _worksSchedules;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _worksSchedules.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _worksSchedules.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_worksSchedules.resetOriginalValues();
	}

	private final WorksSchedules _worksSchedules;
}