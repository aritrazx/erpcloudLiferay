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
 * This class is a wrapper for {@link ProjectRole}.
 * </p>
 *
 * @author Samaresh
 * @see ProjectRole
 * @generated
 */
@ProviderType
public class ProjectRoleWrapper implements ProjectRole,
	ModelWrapper<ProjectRole> {
	public ProjectRoleWrapper(ProjectRole projectRole) {
		_projectRole = projectRole;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectRole.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roleId", getRoleId());
		attributes.put("roleName", getRoleName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String roleName = (String)attributes.get("roleName");

		if (roleName != null) {
			setRoleName(roleName);
		}
	}

	@Override
	public Object clone() {
		return new ProjectRoleWrapper((ProjectRole)_projectRole.clone());
	}

	@Override
	public int compareTo(ProjectRole projectRole) {
		return _projectRole.compareTo(projectRole);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectRole.getExpandoBridge();
	}

	/**
	* Returns the primary key of this project role.
	*
	* @return the primary key of this project role
	*/
	@Override
	public long getPrimaryKey() {
		return _projectRole.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectRole.getPrimaryKeyObj();
	}

	/**
	* Returns the role ID of this project role.
	*
	* @return the role ID of this project role
	*/
	@Override
	public long getRoleId() {
		return _projectRole.getRoleId();
	}

	/**
	* Returns the role name of this project role.
	*
	* @return the role name of this project role
	*/
	@Override
	public String getRoleName() {
		return _projectRole.getRoleName();
	}

	@Override
	public int hashCode() {
		return _projectRole.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _projectRole.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectRole.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectRole.isNew();
	}

	@Override
	public void persist() {
		_projectRole.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectRole.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectRole.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectRole.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectRole.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_projectRole.setNew(n);
	}

	/**
	* Sets the primary key of this project role.
	*
	* @param primaryKey the primary key of this project role
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectRole.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectRole.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the role ID of this project role.
	*
	* @param roleId the role ID of this project role
	*/
	@Override
	public void setRoleId(long roleId) {
		_projectRole.setRoleId(roleId);
	}

	/**
	* Sets the role name of this project role.
	*
	* @param roleName the role name of this project role
	*/
	@Override
	public void setRoleName(String roleName) {
		_projectRole.setRoleName(roleName);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectRole> toCacheModel() {
		return _projectRole.toCacheModel();
	}

	@Override
	public ProjectRole toEscapedModel() {
		return new ProjectRoleWrapper(_projectRole.toEscapedModel());
	}

	@Override
	public String toString() {
		return _projectRole.toString();
	}

	@Override
	public ProjectRole toUnescapedModel() {
		return new ProjectRoleWrapper(_projectRole.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _projectRole.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectRoleWrapper)) {
			return false;
		}

		ProjectRoleWrapper projectRoleWrapper = (ProjectRoleWrapper)obj;

		if (Objects.equals(_projectRole, projectRoleWrapper._projectRole)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectRole getWrappedModel() {
		return _projectRole;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectRole.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectRole.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectRole.resetOriginalValues();
	}

	private final ProjectRole _projectRole;
}