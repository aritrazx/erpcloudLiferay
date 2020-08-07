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
 * This class is a wrapper for {@link AddTeamMember}.
 * </p>
 *
 * @author Samaresh
 * @see AddTeamMember
 * @generated
 */
@ProviderType
public class AddTeamMemberWrapper implements AddTeamMember,
	ModelWrapper<AddTeamMember> {
	public AddTeamMemberWrapper(AddTeamMember addTeamMember) {
		_addTeamMember = addTeamMember;
	}

	@Override
	public Class<?> getModelClass() {
		return AddTeamMember.class;
	}

	@Override
	public String getModelClassName() {
		return AddTeamMember.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectTeamsId", getProjectTeamsId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("projectId", getProjectId());
		attributes.put("companyId", getCompanyId());
		attributes.put("roleId", getRoleId());
		attributes.put("addedDate", getAddedDate());
		attributes.put("isProjectManager", isIsProjectManager());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectTeamsId = (Long)attributes.get("projectTeamsId");

		if (projectTeamsId != null) {
			setProjectTeamsId(projectTeamsId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}

		Boolean isProjectManager = (Boolean)attributes.get("isProjectManager");

		if (isProjectManager != null) {
			setIsProjectManager(isProjectManager);
		}
	}

	@Override
	public Object clone() {
		return new AddTeamMemberWrapper((AddTeamMember)_addTeamMember.clone());
	}

	@Override
	public int compareTo(AddTeamMember addTeamMember) {
		return _addTeamMember.compareTo(addTeamMember);
	}

	/**
	* Returns the added date of this add team member.
	*
	* @return the added date of this add team member
	*/
	@Override
	public Date getAddedDate() {
		return _addTeamMember.getAddedDate();
	}

	/**
	* Returns the company ID of this add team member.
	*
	* @return the company ID of this add team member
	*/
	@Override
	public long getCompanyId() {
		return _addTeamMember.getCompanyId();
	}

	/**
	* Returns the employee ID of this add team member.
	*
	* @return the employee ID of this add team member
	*/
	@Override
	public long getEmployeeId() {
		return _addTeamMember.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _addTeamMember.getExpandoBridge();
	}

	/**
	* Returns the is project manager of this add team member.
	*
	* @return the is project manager of this add team member
	*/
	@Override
	public boolean getIsProjectManager() {
		return _addTeamMember.getIsProjectManager();
	}

	/**
	* Returns the primary key of this add team member.
	*
	* @return the primary key of this add team member
	*/
	@Override
	public long getPrimaryKey() {
		return _addTeamMember.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _addTeamMember.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this add team member.
	*
	* @return the project ID of this add team member
	*/
	@Override
	public long getProjectId() {
		return _addTeamMember.getProjectId();
	}

	/**
	* Returns the project teams ID of this add team member.
	*
	* @return the project teams ID of this add team member
	*/
	@Override
	public long getProjectTeamsId() {
		return _addTeamMember.getProjectTeamsId();
	}

	/**
	* Returns the role ID of this add team member.
	*
	* @return the role ID of this add team member
	*/
	@Override
	public long getRoleId() {
		return _addTeamMember.getRoleId();
	}

	@Override
	public int hashCode() {
		return _addTeamMember.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _addTeamMember.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _addTeamMember.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this add team member is is project manager.
	*
	* @return <code>true</code> if this add team member is is project manager; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsProjectManager() {
		return _addTeamMember.isIsProjectManager();
	}

	@Override
	public boolean isNew() {
		return _addTeamMember.isNew();
	}

	@Override
	public void persist() {
		_addTeamMember.persist();
	}

	/**
	* Sets the added date of this add team member.
	*
	* @param addedDate the added date of this add team member
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_addTeamMember.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_addTeamMember.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this add team member.
	*
	* @param companyId the company ID of this add team member
	*/
	@Override
	public void setCompanyId(long companyId) {
		_addTeamMember.setCompanyId(companyId);
	}

	/**
	* Sets the employee ID of this add team member.
	*
	* @param employeeId the employee ID of this add team member
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_addTeamMember.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_addTeamMember.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_addTeamMember.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_addTeamMember.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this add team member is is project manager.
	*
	* @param isProjectManager the is project manager of this add team member
	*/
	@Override
	public void setIsProjectManager(boolean isProjectManager) {
		_addTeamMember.setIsProjectManager(isProjectManager);
	}

	@Override
	public void setNew(boolean n) {
		_addTeamMember.setNew(n);
	}

	/**
	* Sets the primary key of this add team member.
	*
	* @param primaryKey the primary key of this add team member
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_addTeamMember.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_addTeamMember.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this add team member.
	*
	* @param projectId the project ID of this add team member
	*/
	@Override
	public void setProjectId(long projectId) {
		_addTeamMember.setProjectId(projectId);
	}

	/**
	* Sets the project teams ID of this add team member.
	*
	* @param projectTeamsId the project teams ID of this add team member
	*/
	@Override
	public void setProjectTeamsId(long projectTeamsId) {
		_addTeamMember.setProjectTeamsId(projectTeamsId);
	}

	/**
	* Sets the role ID of this add team member.
	*
	* @param roleId the role ID of this add team member
	*/
	@Override
	public void setRoleId(long roleId) {
		_addTeamMember.setRoleId(roleId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AddTeamMember> toCacheModel() {
		return _addTeamMember.toCacheModel();
	}

	@Override
	public AddTeamMember toEscapedModel() {
		return new AddTeamMemberWrapper(_addTeamMember.toEscapedModel());
	}

	@Override
	public String toString() {
		return _addTeamMember.toString();
	}

	@Override
	public AddTeamMember toUnescapedModel() {
		return new AddTeamMemberWrapper(_addTeamMember.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _addTeamMember.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddTeamMemberWrapper)) {
			return false;
		}

		AddTeamMemberWrapper addTeamMemberWrapper = (AddTeamMemberWrapper)obj;

		if (Objects.equals(_addTeamMember, addTeamMemberWrapper._addTeamMember)) {
			return true;
		}

		return false;
	}

	@Override
	public AddTeamMember getWrappedModel() {
		return _addTeamMember;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _addTeamMember.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _addTeamMember.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_addTeamMember.resetOriginalValues();
	}

	private final AddTeamMember _addTeamMember;
}