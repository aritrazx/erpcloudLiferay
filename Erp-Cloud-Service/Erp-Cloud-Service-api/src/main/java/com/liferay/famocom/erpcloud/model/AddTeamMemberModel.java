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

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AddTeamMember service. Represents a row in the &quot;addTeamMember&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.AddTeamMemberModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.AddTeamMemberImpl}.
 * </p>
 *
 * @author Samaresh
 * @see AddTeamMember
 * @see com.liferay.famocom.erpcloud.model.impl.AddTeamMemberImpl
 * @see com.liferay.famocom.erpcloud.model.impl.AddTeamMemberModelImpl
 * @generated
 */
@ProviderType
public interface AddTeamMemberModel extends BaseModel<AddTeamMember>,
	ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a add team member model instance should use the {@link AddTeamMember} interface instead.
	 */

	/**
	 * Returns the primary key of this add team member.
	 *
	 * @return the primary key of this add team member
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this add team member.
	 *
	 * @param primaryKey the primary key of this add team member
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the project teams ID of this add team member.
	 *
	 * @return the project teams ID of this add team member
	 */
	public long getProjectTeamsId();

	/**
	 * Sets the project teams ID of this add team member.
	 *
	 * @param projectTeamsId the project teams ID of this add team member
	 */
	public void setProjectTeamsId(long projectTeamsId);

	/**
	 * Returns the employee ID of this add team member.
	 *
	 * @return the employee ID of this add team member
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this add team member.
	 *
	 * @param employeeId the employee ID of this add team member
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the project ID of this add team member.
	 *
	 * @return the project ID of this add team member
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this add team member.
	 *
	 * @param projectId the project ID of this add team member
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the company ID of this add team member.
	 *
	 * @return the company ID of this add team member
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this add team member.
	 *
	 * @param companyId the company ID of this add team member
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the role ID of this add team member.
	 *
	 * @return the role ID of this add team member
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this add team member.
	 *
	 * @param roleId the role ID of this add team member
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the added date of this add team member.
	 *
	 * @return the added date of this add team member
	 */
	public Date getAddedDate();

	/**
	 * Sets the added date of this add team member.
	 *
	 * @param addedDate the added date of this add team member
	 */
	public void setAddedDate(Date addedDate);

	/**
	 * Returns the is project manager of this add team member.
	 *
	 * @return the is project manager of this add team member
	 */
	public boolean getIsProjectManager();

	/**
	 * Returns <code>true</code> if this add team member is is project manager.
	 *
	 * @return <code>true</code> if this add team member is is project manager; <code>false</code> otherwise
	 */
	public boolean isIsProjectManager();

	/**
	 * Sets whether this add team member is is project manager.
	 *
	 * @param isProjectManager the is project manager of this add team member
	 */
	public void setIsProjectManager(boolean isProjectManager);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(AddTeamMember addTeamMember);

	@Override
	public int hashCode();

	@Override
	public CacheModel<AddTeamMember> toCacheModel();

	@Override
	public AddTeamMember toEscapedModel();

	@Override
	public AddTeamMember toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}