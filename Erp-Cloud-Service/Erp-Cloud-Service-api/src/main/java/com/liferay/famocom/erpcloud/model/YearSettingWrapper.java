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
 * This class is a wrapper for {@link YearSetting}.
 * </p>
 *
 * @author Samaresh
 * @see YearSetting
 * @generated
 */
@ProviderType
public class YearSettingWrapper implements YearSetting,
	ModelWrapper<YearSetting> {
	public YearSettingWrapper(YearSetting yearSetting) {
		_yearSetting = yearSetting;
	}

	@Override
	public Class<?> getModelClass() {
		return YearSetting.class;
	}

	@Override
	public String getModelClassName() {
		return YearSetting.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("yearSettingId", getYearSettingId());
		attributes.put("financialYearStartDate", getFinancialYearStartDate());
		attributes.put("financialYearEndDate", getFinancialYearEndDate());
		attributes.put("calendarStartDate", getCalendarStartDate());
		attributes.put("calendarEndDate", getCalendarEndDate());
		attributes.put("isActive", getIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long yearSettingId = (Long)attributes.get("yearSettingId");

		if (yearSettingId != null) {
			setYearSettingId(yearSettingId);
		}

		Date financialYearStartDate = (Date)attributes.get(
				"financialYearStartDate");

		if (financialYearStartDate != null) {
			setFinancialYearStartDate(financialYearStartDate);
		}

		Date financialYearEndDate = (Date)attributes.get("financialYearEndDate");

		if (financialYearEndDate != null) {
			setFinancialYearEndDate(financialYearEndDate);
		}

		Date calendarStartDate = (Date)attributes.get("calendarStartDate");

		if (calendarStartDate != null) {
			setCalendarStartDate(calendarStartDate);
		}

		Date calendarEndDate = (Date)attributes.get("calendarEndDate");

		if (calendarEndDate != null) {
			setCalendarEndDate(calendarEndDate);
		}

		Integer isActive = (Integer)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	@Override
	public Object clone() {
		return new YearSettingWrapper((YearSetting)_yearSetting.clone());
	}

	@Override
	public int compareTo(YearSetting yearSetting) {
		return _yearSetting.compareTo(yearSetting);
	}

	/**
	* Returns the calendar end date of this year setting.
	*
	* @return the calendar end date of this year setting
	*/
	@Override
	public Date getCalendarEndDate() {
		return _yearSetting.getCalendarEndDate();
	}

	/**
	* Returns the calendar start date of this year setting.
	*
	* @return the calendar start date of this year setting
	*/
	@Override
	public Date getCalendarStartDate() {
		return _yearSetting.getCalendarStartDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _yearSetting.getExpandoBridge();
	}

	/**
	* Returns the financial year end date of this year setting.
	*
	* @return the financial year end date of this year setting
	*/
	@Override
	public Date getFinancialYearEndDate() {
		return _yearSetting.getFinancialYearEndDate();
	}

	/**
	* Returns the financial year start date of this year setting.
	*
	* @return the financial year start date of this year setting
	*/
	@Override
	public Date getFinancialYearStartDate() {
		return _yearSetting.getFinancialYearStartDate();
	}

	/**
	* Returns the is active of this year setting.
	*
	* @return the is active of this year setting
	*/
	@Override
	public int getIsActive() {
		return _yearSetting.getIsActive();
	}

	/**
	* Returns the primary key of this year setting.
	*
	* @return the primary key of this year setting
	*/
	@Override
	public long getPrimaryKey() {
		return _yearSetting.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _yearSetting.getPrimaryKeyObj();
	}

	/**
	* Returns the year setting ID of this year setting.
	*
	* @return the year setting ID of this year setting
	*/
	@Override
	public long getYearSettingId() {
		return _yearSetting.getYearSettingId();
	}

	@Override
	public int hashCode() {
		return _yearSetting.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _yearSetting.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _yearSetting.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _yearSetting.isNew();
	}

	@Override
	public void persist() {
		_yearSetting.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_yearSetting.setCachedModel(cachedModel);
	}

	/**
	* Sets the calendar end date of this year setting.
	*
	* @param calendarEndDate the calendar end date of this year setting
	*/
	@Override
	public void setCalendarEndDate(Date calendarEndDate) {
		_yearSetting.setCalendarEndDate(calendarEndDate);
	}

	/**
	* Sets the calendar start date of this year setting.
	*
	* @param calendarStartDate the calendar start date of this year setting
	*/
	@Override
	public void setCalendarStartDate(Date calendarStartDate) {
		_yearSetting.setCalendarStartDate(calendarStartDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_yearSetting.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_yearSetting.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_yearSetting.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the financial year end date of this year setting.
	*
	* @param financialYearEndDate the financial year end date of this year setting
	*/
	@Override
	public void setFinancialYearEndDate(Date financialYearEndDate) {
		_yearSetting.setFinancialYearEndDate(financialYearEndDate);
	}

	/**
	* Sets the financial year start date of this year setting.
	*
	* @param financialYearStartDate the financial year start date of this year setting
	*/
	@Override
	public void setFinancialYearStartDate(Date financialYearStartDate) {
		_yearSetting.setFinancialYearStartDate(financialYearStartDate);
	}

	/**
	* Sets the is active of this year setting.
	*
	* @param isActive the is active of this year setting
	*/
	@Override
	public void setIsActive(int isActive) {
		_yearSetting.setIsActive(isActive);
	}

	@Override
	public void setNew(boolean n) {
		_yearSetting.setNew(n);
	}

	/**
	* Sets the primary key of this year setting.
	*
	* @param primaryKey the primary key of this year setting
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_yearSetting.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_yearSetting.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the year setting ID of this year setting.
	*
	* @param yearSettingId the year setting ID of this year setting
	*/
	@Override
	public void setYearSettingId(long yearSettingId) {
		_yearSetting.setYearSettingId(yearSettingId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<YearSetting> toCacheModel() {
		return _yearSetting.toCacheModel();
	}

	@Override
	public YearSetting toEscapedModel() {
		return new YearSettingWrapper(_yearSetting.toEscapedModel());
	}

	@Override
	public String toString() {
		return _yearSetting.toString();
	}

	@Override
	public YearSetting toUnescapedModel() {
		return new YearSettingWrapper(_yearSetting.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _yearSetting.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof YearSettingWrapper)) {
			return false;
		}

		YearSettingWrapper yearSettingWrapper = (YearSettingWrapper)obj;

		if (Objects.equals(_yearSetting, yearSettingWrapper._yearSetting)) {
			return true;
		}

		return false;
	}

	@Override
	public YearSetting getWrappedModel() {
		return _yearSetting;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _yearSetting.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _yearSetting.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_yearSetting.resetOriginalValues();
	}

	private final YearSetting _yearSetting;
}