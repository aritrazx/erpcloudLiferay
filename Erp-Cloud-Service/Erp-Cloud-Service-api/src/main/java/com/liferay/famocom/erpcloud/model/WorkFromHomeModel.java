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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WorkFromHome service. Represents a row in the &quot;workFromHome&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.WorkFromHomeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.WorkFromHomeImpl}.
 * </p>
 *
 * @author Samaresh
 * @see WorkFromHome
 * @see com.liferay.famocom.erpcloud.model.impl.WorkFromHomeImpl
 * @see com.liferay.famocom.erpcloud.model.impl.WorkFromHomeModelImpl
 * @generated
 */
@ProviderType
public interface WorkFromHomeModel extends BaseModel<WorkFromHome>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a work from home model instance should use the {@link WorkFromHome} interface instead.
	 */

	/**
	 * Returns the primary key of this work from home.
	 *
	 * @return the primary key of this work from home
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this work from home.
	 *
	 * @param primaryKey the primary key of this work from home
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the work from home ID of this work from home.
	 *
	 * @return the work from home ID of this work from home
	 */
	public long getWorkFromHomeId();

	/**
	 * Sets the work from home ID of this work from home.
	 *
	 * @param workFromHomeId the work from home ID of this work from home
	 */
	public void setWorkFromHomeId(long workFromHomeId);

	/**
	 * Returns the employee ID of this work from home.
	 *
	 * @return the employee ID of this work from home
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this work from home.
	 *
	 * @param employeeId the employee ID of this work from home
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the company ID of this work from home.
	 *
	 * @return the company ID of this work from home
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this work from home.
	 *
	 * @param companyId the company ID of this work from home
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the project ID of this work from home.
	 *
	 * @return the project ID of this work from home
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this work from home.
	 *
	 * @param projectId the project ID of this work from home
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the applied date of this work from home.
	 *
	 * @return the applied date of this work from home
	 */
	public Date getAppliedDate();

	/**
	 * Sets the applied date of this work from home.
	 *
	 * @param appliedDate the applied date of this work from home
	 */
	public void setAppliedDate(Date appliedDate);

	/**
	 * Returns the description of this work from home.
	 *
	 * @return the description of this work from home
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this work from home.
	 *
	 * @param description the description of this work from home
	 */
	public void setDescription(String description);

	/**
	 * Returns the create date of this work from home.
	 *
	 * @return the create date of this work from home
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this work from home.
	 *
	 * @param createDate the create date of this work from home
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this work from home.
	 *
	 * @return the modified date of this work from home
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this work from home.
	 *
	 * @param modifiedDate the modified date of this work from home
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the work status of this work from home.
	 *
	 * @return the work status of this work from home
	 */
	public int getWorkStatus();

	/**
	 * Sets the work status of this work from home.
	 *
	 * @param workStatus the work status of this work from home
	 */
	public void setWorkStatus(int workStatus);

	/**
	 * Returns the hr comments of this work from home.
	 *
	 * @return the hr comments of this work from home
	 */
	@AutoEscape
	public String getHrComments();

	/**
	 * Sets the hr comments of this work from home.
	 *
	 * @param hrComments the hr comments of this work from home
	 */
	public void setHrComments(String hrComments);

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
	public int compareTo(WorkFromHome workFromHome);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WorkFromHome> toCacheModel();

	@Override
	public WorkFromHome toEscapedModel();

	@Override
	public WorkFromHome toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}