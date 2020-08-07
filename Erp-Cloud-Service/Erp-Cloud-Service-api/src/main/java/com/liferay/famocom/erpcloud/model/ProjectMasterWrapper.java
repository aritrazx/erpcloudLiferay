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
 * This class is a wrapper for {@link ProjectMaster}.
 * </p>
 *
 * @author Samaresh
 * @see ProjectMaster
 * @generated
 */
@ProviderType
public class ProjectMasterWrapper implements ProjectMaster,
	ModelWrapper<ProjectMaster> {
	public ProjectMasterWrapper(ProjectMaster projectMaster) {
		_projectMaster = projectMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectMaster.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectId", getProjectId());
		attributes.put("companyId", getCompanyId());
		attributes.put("projectName", getProjectName());
		attributes.put("clientId", getClientId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("projectStatus", getProjectStatus());
		attributes.put("projectStatusId", getProjectStatusId());
		attributes.put("projectDesc", getProjectDesc());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("totalAmount", getTotalAmount());
		attributes.put("addedDate", getAddedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String projectName = (String)attributes.get("projectName");

		if (projectName != null) {
			setProjectName(projectName);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Integer projectStatus = (Integer)attributes.get("projectStatus");

		if (projectStatus != null) {
			setProjectStatus(projectStatus);
		}

		Long projectStatusId = (Long)attributes.get("projectStatusId");

		if (projectStatusId != null) {
			setProjectStatusId(projectStatusId);
		}

		String projectDesc = (String)attributes.get("projectDesc");

		if (projectDesc != null) {
			setProjectDesc(projectDesc);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Double totalAmount = (Double)attributes.get("totalAmount");

		if (totalAmount != null) {
			setTotalAmount(totalAmount);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public Object clone() {
		return new ProjectMasterWrapper((ProjectMaster)_projectMaster.clone());
	}

	@Override
	public int compareTo(ProjectMaster projectMaster) {
		return _projectMaster.compareTo(projectMaster);
	}

	/**
	* Returns the added date of this project master.
	*
	* @return the added date of this project master
	*/
	@Override
	public Date getAddedDate() {
		return _projectMaster.getAddedDate();
	}

	/**
	* Returns the client ID of this project master.
	*
	* @return the client ID of this project master
	*/
	@Override
	public long getClientId() {
		return _projectMaster.getClientId();
	}

	/**
	* Returns the company ID of this project master.
	*
	* @return the company ID of this project master
	*/
	@Override
	public long getCompanyId() {
		return _projectMaster.getCompanyId();
	}

	/**
	* Returns the employee ID of this project master.
	*
	* @return the employee ID of this project master
	*/
	@Override
	public long getEmployeeId() {
		return _projectMaster.getEmployeeId();
	}

	/**
	* Returns the end date of this project master.
	*
	* @return the end date of this project master
	*/
	@Override
	public Date getEndDate() {
		return _projectMaster.getEndDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectMaster.getExpandoBridge();
	}

	/**
	* Returns the primary key of this project master.
	*
	* @return the primary key of this project master
	*/
	@Override
	public long getPrimaryKey() {
		return _projectMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the project desc of this project master.
	*
	* @return the project desc of this project master
	*/
	@Override
	public String getProjectDesc() {
		return _projectMaster.getProjectDesc();
	}

	/**
	* Returns the project ID of this project master.
	*
	* @return the project ID of this project master
	*/
	@Override
	public long getProjectId() {
		return _projectMaster.getProjectId();
	}

	/**
	* Returns the project name of this project master.
	*
	* @return the project name of this project master
	*/
	@Override
	public String getProjectName() {
		return _projectMaster.getProjectName();
	}

	/**
	* Returns the project status of this project master.
	*
	* @return the project status of this project master
	*/
	@Override
	public int getProjectStatus() {
		return _projectMaster.getProjectStatus();
	}

	/**
	* Returns the project status ID of this project master.
	*
	* @return the project status ID of this project master
	*/
	@Override
	public long getProjectStatusId() {
		return _projectMaster.getProjectStatusId();
	}

	/**
	* Returns the start date of this project master.
	*
	* @return the start date of this project master
	*/
	@Override
	public Date getStartDate() {
		return _projectMaster.getStartDate();
	}

	/**
	* Returns the total amount of this project master.
	*
	* @return the total amount of this project master
	*/
	@Override
	public double getTotalAmount() {
		return _projectMaster.getTotalAmount();
	}

	@Override
	public int hashCode() {
		return _projectMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _projectMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectMaster.isNew();
	}

	@Override
	public void persist() {
		_projectMaster.persist();
	}

	/**
	* Sets the added date of this project master.
	*
	* @param addedDate the added date of this project master
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_projectMaster.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the client ID of this project master.
	*
	* @param clientId the client ID of this project master
	*/
	@Override
	public void setClientId(long clientId) {
		_projectMaster.setClientId(clientId);
	}

	/**
	* Sets the company ID of this project master.
	*
	* @param companyId the company ID of this project master
	*/
	@Override
	public void setCompanyId(long companyId) {
		_projectMaster.setCompanyId(companyId);
	}

	/**
	* Sets the employee ID of this project master.
	*
	* @param employeeId the employee ID of this project master
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_projectMaster.setEmployeeId(employeeId);
	}

	/**
	* Sets the end date of this project master.
	*
	* @param endDate the end date of this project master
	*/
	@Override
	public void setEndDate(Date endDate) {
		_projectMaster.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_projectMaster.setNew(n);
	}

	/**
	* Sets the primary key of this project master.
	*
	* @param primaryKey the primary key of this project master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project desc of this project master.
	*
	* @param projectDesc the project desc of this project master
	*/
	@Override
	public void setProjectDesc(String projectDesc) {
		_projectMaster.setProjectDesc(projectDesc);
	}

	/**
	* Sets the project ID of this project master.
	*
	* @param projectId the project ID of this project master
	*/
	@Override
	public void setProjectId(long projectId) {
		_projectMaster.setProjectId(projectId);
	}

	/**
	* Sets the project name of this project master.
	*
	* @param projectName the project name of this project master
	*/
	@Override
	public void setProjectName(String projectName) {
		_projectMaster.setProjectName(projectName);
	}

	/**
	* Sets the project status of this project master.
	*
	* @param projectStatus the project status of this project master
	*/
	@Override
	public void setProjectStatus(int projectStatus) {
		_projectMaster.setProjectStatus(projectStatus);
	}

	/**
	* Sets the project status ID of this project master.
	*
	* @param projectStatusId the project status ID of this project master
	*/
	@Override
	public void setProjectStatusId(long projectStatusId) {
		_projectMaster.setProjectStatusId(projectStatusId);
	}

	/**
	* Sets the start date of this project master.
	*
	* @param startDate the start date of this project master
	*/
	@Override
	public void setStartDate(Date startDate) {
		_projectMaster.setStartDate(startDate);
	}

	/**
	* Sets the total amount of this project master.
	*
	* @param totalAmount the total amount of this project master
	*/
	@Override
	public void setTotalAmount(double totalAmount) {
		_projectMaster.setTotalAmount(totalAmount);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectMaster> toCacheModel() {
		return _projectMaster.toCacheModel();
	}

	@Override
	public ProjectMaster toEscapedModel() {
		return new ProjectMasterWrapper(_projectMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _projectMaster.toString();
	}

	@Override
	public ProjectMaster toUnescapedModel() {
		return new ProjectMasterWrapper(_projectMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _projectMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectMasterWrapper)) {
			return false;
		}

		ProjectMasterWrapper projectMasterWrapper = (ProjectMasterWrapper)obj;

		if (Objects.equals(_projectMaster, projectMasterWrapper._projectMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectMaster getWrappedModel() {
		return _projectMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectMaster.resetOriginalValues();
	}

	private final ProjectMaster _projectMaster;
}