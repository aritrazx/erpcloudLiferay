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
 * This class is a wrapper for {@link WorkFromHome}.
 * </p>
 *
 * @author Samaresh
 * @see WorkFromHome
 * @generated
 */
@ProviderType
public class WorkFromHomeWrapper implements WorkFromHome,
	ModelWrapper<WorkFromHome> {
	public WorkFromHomeWrapper(WorkFromHome workFromHome) {
		_workFromHome = workFromHome;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkFromHome.class;
	}

	@Override
	public String getModelClassName() {
		return WorkFromHome.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workFromHomeId", getWorkFromHomeId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("projectId", getProjectId());
		attributes.put("appliedDate", getAppliedDate());
		attributes.put("description", getDescription());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("workStatus", getWorkStatus());
		attributes.put("hrComments", getHrComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workFromHomeId = (Long)attributes.get("workFromHomeId");

		if (workFromHomeId != null) {
			setWorkFromHomeId(workFromHomeId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Date appliedDate = (Date)attributes.get("appliedDate");

		if (appliedDate != null) {
			setAppliedDate(appliedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer workStatus = (Integer)attributes.get("workStatus");

		if (workStatus != null) {
			setWorkStatus(workStatus);
		}

		String hrComments = (String)attributes.get("hrComments");

		if (hrComments != null) {
			setHrComments(hrComments);
		}
	}

	@Override
	public Object clone() {
		return new WorkFromHomeWrapper((WorkFromHome)_workFromHome.clone());
	}

	@Override
	public int compareTo(WorkFromHome workFromHome) {
		return _workFromHome.compareTo(workFromHome);
	}

	/**
	* Returns the applied date of this work from home.
	*
	* @return the applied date of this work from home
	*/
	@Override
	public Date getAppliedDate() {
		return _workFromHome.getAppliedDate();
	}

	/**
	* Returns the company ID of this work from home.
	*
	* @return the company ID of this work from home
	*/
	@Override
	public long getCompanyId() {
		return _workFromHome.getCompanyId();
	}

	/**
	* Returns the create date of this work from home.
	*
	* @return the create date of this work from home
	*/
	@Override
	public Date getCreateDate() {
		return _workFromHome.getCreateDate();
	}

	/**
	* Returns the description of this work from home.
	*
	* @return the description of this work from home
	*/
	@Override
	public String getDescription() {
		return _workFromHome.getDescription();
	}

	/**
	* Returns the employee ID of this work from home.
	*
	* @return the employee ID of this work from home
	*/
	@Override
	public long getEmployeeId() {
		return _workFromHome.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _workFromHome.getExpandoBridge();
	}

	/**
	* Returns the hr comments of this work from home.
	*
	* @return the hr comments of this work from home
	*/
	@Override
	public String getHrComments() {
		return _workFromHome.getHrComments();
	}

	/**
	* Returns the modified date of this work from home.
	*
	* @return the modified date of this work from home
	*/
	@Override
	public Date getModifiedDate() {
		return _workFromHome.getModifiedDate();
	}

	/**
	* Returns the primary key of this work from home.
	*
	* @return the primary key of this work from home
	*/
	@Override
	public long getPrimaryKey() {
		return _workFromHome.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workFromHome.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this work from home.
	*
	* @return the project ID of this work from home
	*/
	@Override
	public long getProjectId() {
		return _workFromHome.getProjectId();
	}

	/**
	* Returns the work from home ID of this work from home.
	*
	* @return the work from home ID of this work from home
	*/
	@Override
	public long getWorkFromHomeId() {
		return _workFromHome.getWorkFromHomeId();
	}

	/**
	* Returns the work status of this work from home.
	*
	* @return the work status of this work from home
	*/
	@Override
	public int getWorkStatus() {
		return _workFromHome.getWorkStatus();
	}

	@Override
	public int hashCode() {
		return _workFromHome.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _workFromHome.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _workFromHome.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _workFromHome.isNew();
	}

	@Override
	public void persist() {
		_workFromHome.persist();
	}

	/**
	* Sets the applied date of this work from home.
	*
	* @param appliedDate the applied date of this work from home
	*/
	@Override
	public void setAppliedDate(Date appliedDate) {
		_workFromHome.setAppliedDate(appliedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workFromHome.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this work from home.
	*
	* @param companyId the company ID of this work from home
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workFromHome.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this work from home.
	*
	* @param createDate the create date of this work from home
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_workFromHome.setCreateDate(createDate);
	}

	/**
	* Sets the description of this work from home.
	*
	* @param description the description of this work from home
	*/
	@Override
	public void setDescription(String description) {
		_workFromHome.setDescription(description);
	}

	/**
	* Sets the employee ID of this work from home.
	*
	* @param employeeId the employee ID of this work from home
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_workFromHome.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_workFromHome.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_workFromHome.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_workFromHome.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hr comments of this work from home.
	*
	* @param hrComments the hr comments of this work from home
	*/
	@Override
	public void setHrComments(String hrComments) {
		_workFromHome.setHrComments(hrComments);
	}

	/**
	* Sets the modified date of this work from home.
	*
	* @param modifiedDate the modified date of this work from home
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_workFromHome.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_workFromHome.setNew(n);
	}

	/**
	* Sets the primary key of this work from home.
	*
	* @param primaryKey the primary key of this work from home
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workFromHome.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_workFromHome.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this work from home.
	*
	* @param projectId the project ID of this work from home
	*/
	@Override
	public void setProjectId(long projectId) {
		_workFromHome.setProjectId(projectId);
	}

	/**
	* Sets the work from home ID of this work from home.
	*
	* @param workFromHomeId the work from home ID of this work from home
	*/
	@Override
	public void setWorkFromHomeId(long workFromHomeId) {
		_workFromHome.setWorkFromHomeId(workFromHomeId);
	}

	/**
	* Sets the work status of this work from home.
	*
	* @param workStatus the work status of this work from home
	*/
	@Override
	public void setWorkStatus(int workStatus) {
		_workFromHome.setWorkStatus(workStatus);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WorkFromHome> toCacheModel() {
		return _workFromHome.toCacheModel();
	}

	@Override
	public WorkFromHome toEscapedModel() {
		return new WorkFromHomeWrapper(_workFromHome.toEscapedModel());
	}

	@Override
	public String toString() {
		return _workFromHome.toString();
	}

	@Override
	public WorkFromHome toUnescapedModel() {
		return new WorkFromHomeWrapper(_workFromHome.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _workFromHome.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkFromHomeWrapper)) {
			return false;
		}

		WorkFromHomeWrapper workFromHomeWrapper = (WorkFromHomeWrapper)obj;

		if (Objects.equals(_workFromHome, workFromHomeWrapper._workFromHome)) {
			return true;
		}

		return false;
	}

	@Override
	public WorkFromHome getWrappedModel() {
		return _workFromHome;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _workFromHome.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _workFromHome.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_workFromHome.resetOriginalValues();
	}

	private final WorkFromHome _workFromHome;
}