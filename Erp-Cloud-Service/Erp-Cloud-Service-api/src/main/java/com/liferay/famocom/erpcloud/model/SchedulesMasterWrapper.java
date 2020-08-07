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
 * This class is a wrapper for {@link SchedulesMaster}.
 * </p>
 *
 * @author Samaresh
 * @see SchedulesMaster
 * @generated
 */
@ProviderType
public class SchedulesMasterWrapper implements SchedulesMaster,
	ModelWrapper<SchedulesMaster> {
	public SchedulesMasterWrapper(SchedulesMaster schedulesMaster) {
		_schedulesMaster = schedulesMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return SchedulesMaster.class;
	}

	@Override
	public String getModelClassName() {
		return SchedulesMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("schedulesId", getSchedulesId());
		attributes.put("schedulesName", getSchedulesName());
		attributes.put("schedulesDescription", getSchedulesDescription());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long schedulesId = (Long)attributes.get("schedulesId");

		if (schedulesId != null) {
			setSchedulesId(schedulesId);
		}

		String schedulesName = (String)attributes.get("schedulesName");

		if (schedulesName != null) {
			setSchedulesName(schedulesName);
		}

		String schedulesDescription = (String)attributes.get(
				"schedulesDescription");

		if (schedulesDescription != null) {
			setSchedulesDescription(schedulesDescription);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Object clone() {
		return new SchedulesMasterWrapper((SchedulesMaster)_schedulesMaster.clone());
	}

	@Override
	public int compareTo(SchedulesMaster schedulesMaster) {
		return _schedulesMaster.compareTo(schedulesMaster);
	}

	/**
	* Returns the create date of this schedules master.
	*
	* @return the create date of this schedules master
	*/
	@Override
	public Date getCreateDate() {
		return _schedulesMaster.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _schedulesMaster.getExpandoBridge();
	}

	/**
	* Returns the modified date of this schedules master.
	*
	* @return the modified date of this schedules master
	*/
	@Override
	public Date getModifiedDate() {
		return _schedulesMaster.getModifiedDate();
	}

	/**
	* Returns the primary key of this schedules master.
	*
	* @return the primary key of this schedules master
	*/
	@Override
	public long getPrimaryKey() {
		return _schedulesMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _schedulesMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the schedules description of this schedules master.
	*
	* @return the schedules description of this schedules master
	*/
	@Override
	public String getSchedulesDescription() {
		return _schedulesMaster.getSchedulesDescription();
	}

	/**
	* Returns the schedules ID of this schedules master.
	*
	* @return the schedules ID of this schedules master
	*/
	@Override
	public long getSchedulesId() {
		return _schedulesMaster.getSchedulesId();
	}

	/**
	* Returns the schedules name of this schedules master.
	*
	* @return the schedules name of this schedules master
	*/
	@Override
	public String getSchedulesName() {
		return _schedulesMaster.getSchedulesName();
	}

	/**
	* Returns the status of this schedules master.
	*
	* @return the status of this schedules master
	*/
	@Override
	public int getStatus() {
		return _schedulesMaster.getStatus();
	}

	@Override
	public int hashCode() {
		return _schedulesMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _schedulesMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _schedulesMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _schedulesMaster.isNew();
	}

	@Override
	public void persist() {
		_schedulesMaster.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_schedulesMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this schedules master.
	*
	* @param createDate the create date of this schedules master
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_schedulesMaster.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_schedulesMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_schedulesMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_schedulesMaster.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this schedules master.
	*
	* @param modifiedDate the modified date of this schedules master
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_schedulesMaster.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_schedulesMaster.setNew(n);
	}

	/**
	* Sets the primary key of this schedules master.
	*
	* @param primaryKey the primary key of this schedules master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_schedulesMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_schedulesMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the schedules description of this schedules master.
	*
	* @param schedulesDescription the schedules description of this schedules master
	*/
	@Override
	public void setSchedulesDescription(String schedulesDescription) {
		_schedulesMaster.setSchedulesDescription(schedulesDescription);
	}

	/**
	* Sets the schedules ID of this schedules master.
	*
	* @param schedulesId the schedules ID of this schedules master
	*/
	@Override
	public void setSchedulesId(long schedulesId) {
		_schedulesMaster.setSchedulesId(schedulesId);
	}

	/**
	* Sets the schedules name of this schedules master.
	*
	* @param schedulesName the schedules name of this schedules master
	*/
	@Override
	public void setSchedulesName(String schedulesName) {
		_schedulesMaster.setSchedulesName(schedulesName);
	}

	/**
	* Sets the status of this schedules master.
	*
	* @param status the status of this schedules master
	*/
	@Override
	public void setStatus(int status) {
		_schedulesMaster.setStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SchedulesMaster> toCacheModel() {
		return _schedulesMaster.toCacheModel();
	}

	@Override
	public SchedulesMaster toEscapedModel() {
		return new SchedulesMasterWrapper(_schedulesMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _schedulesMaster.toString();
	}

	@Override
	public SchedulesMaster toUnescapedModel() {
		return new SchedulesMasterWrapper(_schedulesMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _schedulesMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SchedulesMasterWrapper)) {
			return false;
		}

		SchedulesMasterWrapper schedulesMasterWrapper = (SchedulesMasterWrapper)obj;

		if (Objects.equals(_schedulesMaster,
					schedulesMasterWrapper._schedulesMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public SchedulesMaster getWrappedModel() {
		return _schedulesMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _schedulesMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _schedulesMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_schedulesMaster.resetOriginalValues();
	}

	private final SchedulesMaster _schedulesMaster;
}