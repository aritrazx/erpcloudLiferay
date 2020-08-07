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
 * This class is a wrapper for {@link ProjectStatus}.
 * </p>
 *
 * @author Samaresh
 * @see ProjectStatus
 * @generated
 */
@ProviderType
public class ProjectStatusWrapper implements ProjectStatus,
	ModelWrapper<ProjectStatus> {
	public ProjectStatusWrapper(ProjectStatus projectStatus) {
		_projectStatus = projectStatus;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectStatus.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectStatusId", getProjectStatusId());
		attributes.put("companyId", getCompanyId());
		attributes.put("statusName", getStatusName());
		attributes.put("statusColor", getStatusColor());
		attributes.put("addedDate", getAddedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectStatusId = (Long)attributes.get("projectStatusId");

		if (projectStatusId != null) {
			setProjectStatusId(projectStatusId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String statusName = (String)attributes.get("statusName");

		if (statusName != null) {
			setStatusName(statusName);
		}

		String statusColor = (String)attributes.get("statusColor");

		if (statusColor != null) {
			setStatusColor(statusColor);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public Object clone() {
		return new ProjectStatusWrapper((ProjectStatus)_projectStatus.clone());
	}

	@Override
	public int compareTo(ProjectStatus projectStatus) {
		return _projectStatus.compareTo(projectStatus);
	}

	/**
	* Returns the added date of this project status.
	*
	* @return the added date of this project status
	*/
	@Override
	public Date getAddedDate() {
		return _projectStatus.getAddedDate();
	}

	/**
	* Returns the company ID of this project status.
	*
	* @return the company ID of this project status
	*/
	@Override
	public long getCompanyId() {
		return _projectStatus.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectStatus.getExpandoBridge();
	}

	/**
	* Returns the primary key of this project status.
	*
	* @return the primary key of this project status
	*/
	@Override
	public long getPrimaryKey() {
		return _projectStatus.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectStatus.getPrimaryKeyObj();
	}

	/**
	* Returns the project status ID of this project status.
	*
	* @return the project status ID of this project status
	*/
	@Override
	public long getProjectStatusId() {
		return _projectStatus.getProjectStatusId();
	}

	/**
	* Returns the status color of this project status.
	*
	* @return the status color of this project status
	*/
	@Override
	public String getStatusColor() {
		return _projectStatus.getStatusColor();
	}

	/**
	* Returns the status name of this project status.
	*
	* @return the status name of this project status
	*/
	@Override
	public String getStatusName() {
		return _projectStatus.getStatusName();
	}

	@Override
	public int hashCode() {
		return _projectStatus.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _projectStatus.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectStatus.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectStatus.isNew();
	}

	@Override
	public void persist() {
		_projectStatus.persist();
	}

	/**
	* Sets the added date of this project status.
	*
	* @param addedDate the added date of this project status
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_projectStatus.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectStatus.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this project status.
	*
	* @param companyId the company ID of this project status
	*/
	@Override
	public void setCompanyId(long companyId) {
		_projectStatus.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectStatus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectStatus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectStatus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_projectStatus.setNew(n);
	}

	/**
	* Sets the primary key of this project status.
	*
	* @param primaryKey the primary key of this project status
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectStatus.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project status ID of this project status.
	*
	* @param projectStatusId the project status ID of this project status
	*/
	@Override
	public void setProjectStatusId(long projectStatusId) {
		_projectStatus.setProjectStatusId(projectStatusId);
	}

	/**
	* Sets the status color of this project status.
	*
	* @param statusColor the status color of this project status
	*/
	@Override
	public void setStatusColor(String statusColor) {
		_projectStatus.setStatusColor(statusColor);
	}

	/**
	* Sets the status name of this project status.
	*
	* @param statusName the status name of this project status
	*/
	@Override
	public void setStatusName(String statusName) {
		_projectStatus.setStatusName(statusName);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectStatus> toCacheModel() {
		return _projectStatus.toCacheModel();
	}

	@Override
	public ProjectStatus toEscapedModel() {
		return new ProjectStatusWrapper(_projectStatus.toEscapedModel());
	}

	@Override
	public String toString() {
		return _projectStatus.toString();
	}

	@Override
	public ProjectStatus toUnescapedModel() {
		return new ProjectStatusWrapper(_projectStatus.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _projectStatus.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectStatusWrapper)) {
			return false;
		}

		ProjectStatusWrapper projectStatusWrapper = (ProjectStatusWrapper)obj;

		if (Objects.equals(_projectStatus, projectStatusWrapper._projectStatus)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectStatus getWrappedModel() {
		return _projectStatus;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectStatus.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectStatus.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectStatus.resetOriginalValues();
	}

	private final ProjectStatus _projectStatus;
}