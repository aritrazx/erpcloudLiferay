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
 * This class is a wrapper for {@link HolidayCalenderManagement}.
 * </p>
 *
 * @author Samaresh
 * @see HolidayCalenderManagement
 * @generated
 */
@ProviderType
public class HolidayCalenderManagementWrapper
	implements HolidayCalenderManagement,
		ModelWrapper<HolidayCalenderManagement> {
	public HolidayCalenderManagementWrapper(
		HolidayCalenderManagement holidayCalenderManagement) {
		_holidayCalenderManagement = holidayCalenderManagement;
	}

	@Override
	public Class<?> getModelClass() {
		return HolidayCalenderManagement.class;
	}

	@Override
	public String getModelClassName() {
		return HolidayCalenderManagement.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("holidayId", getHolidayId());
		attributes.put("holidayDate", getHolidayDate());
		attributes.put("holidayName", getHolidayName());
		attributes.put("holidayStartDate", getHolidayStartDate());
		attributes.put("holidayEndDate", getHolidayEndDate());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long holidayId = (Long)attributes.get("holidayId");

		if (holidayId != null) {
			setHolidayId(holidayId);
		}

		Date holidayDate = (Date)attributes.get("holidayDate");

		if (holidayDate != null) {
			setHolidayDate(holidayDate);
		}

		String holidayName = (String)attributes.get("holidayName");

		if (holidayName != null) {
			setHolidayName(holidayName);
		}

		Date holidayStartDate = (Date)attributes.get("holidayStartDate");

		if (holidayStartDate != null) {
			setHolidayStartDate(holidayStartDate);
		}

		Date holidayEndDate = (Date)attributes.get("holidayEndDate");

		if (holidayEndDate != null) {
			setHolidayEndDate(holidayEndDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public Object clone() {
		return new HolidayCalenderManagementWrapper((HolidayCalenderManagement)_holidayCalenderManagement.clone());
	}

	@Override
	public int compareTo(HolidayCalenderManagement holidayCalenderManagement) {
		return _holidayCalenderManagement.compareTo(holidayCalenderManagement);
	}

	/**
	* Returns the company ID of this holiday calender management.
	*
	* @return the company ID of this holiday calender management
	*/
	@Override
	public long getCompanyId() {
		return _holidayCalenderManagement.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _holidayCalenderManagement.getExpandoBridge();
	}

	/**
	* Returns the holiday date of this holiday calender management.
	*
	* @return the holiday date of this holiday calender management
	*/
	@Override
	public Date getHolidayDate() {
		return _holidayCalenderManagement.getHolidayDate();
	}

	/**
	* Returns the holiday end date of this holiday calender management.
	*
	* @return the holiday end date of this holiday calender management
	*/
	@Override
	public Date getHolidayEndDate() {
		return _holidayCalenderManagement.getHolidayEndDate();
	}

	/**
	* Returns the holiday ID of this holiday calender management.
	*
	* @return the holiday ID of this holiday calender management
	*/
	@Override
	public long getHolidayId() {
		return _holidayCalenderManagement.getHolidayId();
	}

	/**
	* Returns the holiday name of this holiday calender management.
	*
	* @return the holiday name of this holiday calender management
	*/
	@Override
	public String getHolidayName() {
		return _holidayCalenderManagement.getHolidayName();
	}

	/**
	* Returns the holiday start date of this holiday calender management.
	*
	* @return the holiday start date of this holiday calender management
	*/
	@Override
	public Date getHolidayStartDate() {
		return _holidayCalenderManagement.getHolidayStartDate();
	}

	/**
	* Returns the primary key of this holiday calender management.
	*
	* @return the primary key of this holiday calender management
	*/
	@Override
	public long getPrimaryKey() {
		return _holidayCalenderManagement.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _holidayCalenderManagement.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _holidayCalenderManagement.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _holidayCalenderManagement.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _holidayCalenderManagement.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _holidayCalenderManagement.isNew();
	}

	@Override
	public void persist() {
		_holidayCalenderManagement.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_holidayCalenderManagement.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this holiday calender management.
	*
	* @param companyId the company ID of this holiday calender management
	*/
	@Override
	public void setCompanyId(long companyId) {
		_holidayCalenderManagement.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_holidayCalenderManagement.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_holidayCalenderManagement.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_holidayCalenderManagement.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the holiday date of this holiday calender management.
	*
	* @param holidayDate the holiday date of this holiday calender management
	*/
	@Override
	public void setHolidayDate(Date holidayDate) {
		_holidayCalenderManagement.setHolidayDate(holidayDate);
	}

	/**
	* Sets the holiday end date of this holiday calender management.
	*
	* @param holidayEndDate the holiday end date of this holiday calender management
	*/
	@Override
	public void setHolidayEndDate(Date holidayEndDate) {
		_holidayCalenderManagement.setHolidayEndDate(holidayEndDate);
	}

	/**
	* Sets the holiday ID of this holiday calender management.
	*
	* @param holidayId the holiday ID of this holiday calender management
	*/
	@Override
	public void setHolidayId(long holidayId) {
		_holidayCalenderManagement.setHolidayId(holidayId);
	}

	/**
	* Sets the holiday name of this holiday calender management.
	*
	* @param holidayName the holiday name of this holiday calender management
	*/
	@Override
	public void setHolidayName(String holidayName) {
		_holidayCalenderManagement.setHolidayName(holidayName);
	}

	/**
	* Sets the holiday start date of this holiday calender management.
	*
	* @param holidayStartDate the holiday start date of this holiday calender management
	*/
	@Override
	public void setHolidayStartDate(Date holidayStartDate) {
		_holidayCalenderManagement.setHolidayStartDate(holidayStartDate);
	}

	@Override
	public void setNew(boolean n) {
		_holidayCalenderManagement.setNew(n);
	}

	/**
	* Sets the primary key of this holiday calender management.
	*
	* @param primaryKey the primary key of this holiday calender management
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_holidayCalenderManagement.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_holidayCalenderManagement.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<HolidayCalenderManagement> toCacheModel() {
		return _holidayCalenderManagement.toCacheModel();
	}

	@Override
	public HolidayCalenderManagement toEscapedModel() {
		return new HolidayCalenderManagementWrapper(_holidayCalenderManagement.toEscapedModel());
	}

	@Override
	public String toString() {
		return _holidayCalenderManagement.toString();
	}

	@Override
	public HolidayCalenderManagement toUnescapedModel() {
		return new HolidayCalenderManagementWrapper(_holidayCalenderManagement.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _holidayCalenderManagement.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HolidayCalenderManagementWrapper)) {
			return false;
		}

		HolidayCalenderManagementWrapper holidayCalenderManagementWrapper = (HolidayCalenderManagementWrapper)obj;

		if (Objects.equals(_holidayCalenderManagement,
					holidayCalenderManagementWrapper._holidayCalenderManagement)) {
			return true;
		}

		return false;
	}

	@Override
	public HolidayCalenderManagement getWrappedModel() {
		return _holidayCalenderManagement;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _holidayCalenderManagement.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _holidayCalenderManagement.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_holidayCalenderManagement.resetOriginalValues();
	}

	private final HolidayCalenderManagement _holidayCalenderManagement;
}