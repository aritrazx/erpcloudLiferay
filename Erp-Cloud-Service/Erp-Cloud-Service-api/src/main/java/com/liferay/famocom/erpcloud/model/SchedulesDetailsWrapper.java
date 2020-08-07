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
 * This class is a wrapper for {@link SchedulesDetails}.
 * </p>
 *
 * @author Samaresh
 * @see SchedulesDetails
 * @generated
 */
@ProviderType
public class SchedulesDetailsWrapper implements SchedulesDetails,
	ModelWrapper<SchedulesDetails> {
	public SchedulesDetailsWrapper(SchedulesDetails schedulesDetails) {
		_schedulesDetails = schedulesDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return SchedulesDetails.class;
	}

	@Override
	public String getModelClassName() {
		return SchedulesDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("schedulesDetailsId", getSchedulesDetailsId());
		attributes.put("schedulesDate", getSchedulesDate());
		attributes.put("worksSchedulesId", getWorksSchedulesId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long schedulesDetailsId = (Long)attributes.get("schedulesDetailsId");

		if (schedulesDetailsId != null) {
			setSchedulesDetailsId(schedulesDetailsId);
		}

		Date schedulesDate = (Date)attributes.get("schedulesDate");

		if (schedulesDate != null) {
			setSchedulesDate(schedulesDate);
		}

		Long worksSchedulesId = (Long)attributes.get("worksSchedulesId");

		if (worksSchedulesId != null) {
			setWorksSchedulesId(worksSchedulesId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public Object clone() {
		return new SchedulesDetailsWrapper((SchedulesDetails)_schedulesDetails.clone());
	}

	@Override
	public int compareTo(SchedulesDetails schedulesDetails) {
		return _schedulesDetails.compareTo(schedulesDetails);
	}

	/**
	* Returns the company ID of this schedules details.
	*
	* @return the company ID of this schedules details
	*/
	@Override
	public long getCompanyId() {
		return _schedulesDetails.getCompanyId();
	}

	/**
	* Returns the employee ID of this schedules details.
	*
	* @return the employee ID of this schedules details
	*/
	@Override
	public long getEmployeeId() {
		return _schedulesDetails.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _schedulesDetails.getExpandoBridge();
	}

	/**
	* Returns the primary key of this schedules details.
	*
	* @return the primary key of this schedules details
	*/
	@Override
	public long getPrimaryKey() {
		return _schedulesDetails.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _schedulesDetails.getPrimaryKeyObj();
	}

	/**
	* Returns the schedules date of this schedules details.
	*
	* @return the schedules date of this schedules details
	*/
	@Override
	public Date getSchedulesDate() {
		return _schedulesDetails.getSchedulesDate();
	}

	/**
	* Returns the schedules details ID of this schedules details.
	*
	* @return the schedules details ID of this schedules details
	*/
	@Override
	public long getSchedulesDetailsId() {
		return _schedulesDetails.getSchedulesDetailsId();
	}

	/**
	* Returns the works schedules ID of this schedules details.
	*
	* @return the works schedules ID of this schedules details
	*/
	@Override
	public long getWorksSchedulesId() {
		return _schedulesDetails.getWorksSchedulesId();
	}

	@Override
	public int hashCode() {
		return _schedulesDetails.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _schedulesDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _schedulesDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _schedulesDetails.isNew();
	}

	@Override
	public void persist() {
		_schedulesDetails.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_schedulesDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this schedules details.
	*
	* @param companyId the company ID of this schedules details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_schedulesDetails.setCompanyId(companyId);
	}

	/**
	* Sets the employee ID of this schedules details.
	*
	* @param employeeId the employee ID of this schedules details
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_schedulesDetails.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_schedulesDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_schedulesDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_schedulesDetails.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_schedulesDetails.setNew(n);
	}

	/**
	* Sets the primary key of this schedules details.
	*
	* @param primaryKey the primary key of this schedules details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_schedulesDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_schedulesDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the schedules date of this schedules details.
	*
	* @param schedulesDate the schedules date of this schedules details
	*/
	@Override
	public void setSchedulesDate(Date schedulesDate) {
		_schedulesDetails.setSchedulesDate(schedulesDate);
	}

	/**
	* Sets the schedules details ID of this schedules details.
	*
	* @param schedulesDetailsId the schedules details ID of this schedules details
	*/
	@Override
	public void setSchedulesDetailsId(long schedulesDetailsId) {
		_schedulesDetails.setSchedulesDetailsId(schedulesDetailsId);
	}

	/**
	* Sets the works schedules ID of this schedules details.
	*
	* @param worksSchedulesId the works schedules ID of this schedules details
	*/
	@Override
	public void setWorksSchedulesId(long worksSchedulesId) {
		_schedulesDetails.setWorksSchedulesId(worksSchedulesId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SchedulesDetails> toCacheModel() {
		return _schedulesDetails.toCacheModel();
	}

	@Override
	public SchedulesDetails toEscapedModel() {
		return new SchedulesDetailsWrapper(_schedulesDetails.toEscapedModel());
	}

	@Override
	public String toString() {
		return _schedulesDetails.toString();
	}

	@Override
	public SchedulesDetails toUnescapedModel() {
		return new SchedulesDetailsWrapper(_schedulesDetails.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _schedulesDetails.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SchedulesDetailsWrapper)) {
			return false;
		}

		SchedulesDetailsWrapper schedulesDetailsWrapper = (SchedulesDetailsWrapper)obj;

		if (Objects.equals(_schedulesDetails,
					schedulesDetailsWrapper._schedulesDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public SchedulesDetails getWrappedModel() {
		return _schedulesDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _schedulesDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _schedulesDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_schedulesDetails.resetOriginalValues();
	}

	private final SchedulesDetails _schedulesDetails;
}