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
 * The base model interface for the WorksSchedules service. Represents a row in the &quot;worksSchedules&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.WorksSchedulesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.WorksSchedulesImpl}.
 * </p>
 *
 * @author Samaresh
 * @see WorksSchedules
 * @see com.liferay.famocom.erpcloud.model.impl.WorksSchedulesImpl
 * @see com.liferay.famocom.erpcloud.model.impl.WorksSchedulesModelImpl
 * @generated
 */
@ProviderType
public interface WorksSchedulesModel extends BaseModel<WorksSchedules>,
	ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a works schedules model instance should use the {@link WorksSchedules} interface instead.
	 */

	/**
	 * Returns the primary key of this works schedules.
	 *
	 * @return the primary key of this works schedules
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this works schedules.
	 *
	 * @param primaryKey the primary key of this works schedules
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the works schedules ID of this works schedules.
	 *
	 * @return the works schedules ID of this works schedules
	 */
	public long getWorksSchedulesId();

	/**
	 * Sets the works schedules ID of this works schedules.
	 *
	 * @param worksSchedulesId the works schedules ID of this works schedules
	 */
	public void setWorksSchedulesId(long worksSchedulesId);

	/**
	 * Returns the company ID of this works schedules.
	 *
	 * @return the company ID of this works schedules
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this works schedules.
	 *
	 * @param companyId the company ID of this works schedules
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the employee ID of this works schedules.
	 *
	 * @return the employee ID of this works schedules
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this works schedules.
	 *
	 * @param employeeId the employee ID of this works schedules
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the from date of this works schedules.
	 *
	 * @return the from date of this works schedules
	 */
	public Date getFromDate();

	/**
	 * Sets the from date of this works schedules.
	 *
	 * @param fromDate the from date of this works schedules
	 */
	public void setFromDate(Date fromDate);

	/**
	 * Returns the to date of this works schedules.
	 *
	 * @return the to date of this works schedules
	 */
	public Date getToDate();

	/**
	 * Sets the to date of this works schedules.
	 *
	 * @param toDate the to date of this works schedules
	 */
	public void setToDate(Date toDate);

	/**
	 * Returns the schedules ID of this works schedules.
	 *
	 * @return the schedules ID of this works schedules
	 */
	public long getSchedulesId();

	/**
	 * Sets the schedules ID of this works schedules.
	 *
	 * @param schedulesId the schedules ID of this works schedules
	 */
	public void setSchedulesId(long schedulesId);

	/**
	 * Returns the islock of this works schedules.
	 *
	 * @return the islock of this works schedules
	 */
	public int getIslock();

	/**
	 * Sets the islock of this works schedules.
	 *
	 * @param islock the islock of this works schedules
	 */
	public void setIslock(int islock);

	/**
	 * Returns the status of this works schedules.
	 *
	 * @return the status of this works schedules
	 */
	public int getStatus();

	/**
	 * Sets the status of this works schedules.
	 *
	 * @param status the status of this works schedules
	 */
	public void setStatus(int status);

	/**
	 * Returns the create date of this works schedules.
	 *
	 * @return the create date of this works schedules
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this works schedules.
	 *
	 * @param createDate the create date of this works schedules
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this works schedules.
	 *
	 * @return the modified date of this works schedules
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this works schedules.
	 *
	 * @param modifiedDate the modified date of this works schedules
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the description of this works schedules.
	 *
	 * @return the description of this works schedules
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this works schedules.
	 *
	 * @param description the description of this works schedules
	 */
	public void setDescription(String description);

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
	public int compareTo(WorksSchedules worksSchedules);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WorksSchedules> toCacheModel();

	@Override
	public WorksSchedules toEscapedModel();

	@Override
	public WorksSchedules toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}