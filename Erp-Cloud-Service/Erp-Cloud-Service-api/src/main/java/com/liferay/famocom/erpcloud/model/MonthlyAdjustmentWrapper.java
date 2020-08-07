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
 * This class is a wrapper for {@link MonthlyAdjustment}.
 * </p>
 *
 * @author Samaresh
 * @see MonthlyAdjustment
 * @generated
 */
@ProviderType
public class MonthlyAdjustmentWrapper implements MonthlyAdjustment,
	ModelWrapper<MonthlyAdjustment> {
	public MonthlyAdjustmentWrapper(MonthlyAdjustment monthlyAdjustment) {
		_monthlyAdjustment = monthlyAdjustment;
	}

	@Override
	public Class<?> getModelClass() {
		return MonthlyAdjustment.class;
	}

	@Override
	public String getModelClassName() {
		return MonthlyAdjustment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("monthlyAdjustmentId", getMonthlyAdjustmentId());
		attributes.put("payComponentId", getPayComponentId());
		attributes.put("amount", getAmount());
		attributes.put("monthYear", getMonthYear());
		attributes.put("employeeId", getEmployeeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long monthlyAdjustmentId = (Long)attributes.get("monthlyAdjustmentId");

		if (monthlyAdjustmentId != null) {
			setMonthlyAdjustmentId(monthlyAdjustmentId);
		}

		Long payComponentId = (Long)attributes.get("payComponentId");

		if (payComponentId != null) {
			setPayComponentId(payComponentId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long monthYear = (Long)attributes.get("monthYear");

		if (monthYear != null) {
			setMonthYear(monthYear);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	@Override
	public Object clone() {
		return new MonthlyAdjustmentWrapper((MonthlyAdjustment)_monthlyAdjustment.clone());
	}

	@Override
	public int compareTo(MonthlyAdjustment monthlyAdjustment) {
		return _monthlyAdjustment.compareTo(monthlyAdjustment);
	}

	/**
	* Returns the amount of this monthly adjustment.
	*
	* @return the amount of this monthly adjustment
	*/
	@Override
	public double getAmount() {
		return _monthlyAdjustment.getAmount();
	}

	/**
	* Returns the employee ID of this monthly adjustment.
	*
	* @return the employee ID of this monthly adjustment
	*/
	@Override
	public long getEmployeeId() {
		return _monthlyAdjustment.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _monthlyAdjustment.getExpandoBridge();
	}

	/**
	* Returns the monthly adjustment ID of this monthly adjustment.
	*
	* @return the monthly adjustment ID of this monthly adjustment
	*/
	@Override
	public long getMonthlyAdjustmentId() {
		return _monthlyAdjustment.getMonthlyAdjustmentId();
	}

	/**
	* Returns the month year of this monthly adjustment.
	*
	* @return the month year of this monthly adjustment
	*/
	@Override
	public long getMonthYear() {
		return _monthlyAdjustment.getMonthYear();
	}

	/**
	* Returns the pay component ID of this monthly adjustment.
	*
	* @return the pay component ID of this monthly adjustment
	*/
	@Override
	public long getPayComponentId() {
		return _monthlyAdjustment.getPayComponentId();
	}

	/**
	* Returns the primary key of this monthly adjustment.
	*
	* @return the primary key of this monthly adjustment
	*/
	@Override
	public long getPrimaryKey() {
		return _monthlyAdjustment.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _monthlyAdjustment.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _monthlyAdjustment.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _monthlyAdjustment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _monthlyAdjustment.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _monthlyAdjustment.isNew();
	}

	@Override
	public void persist() {
		_monthlyAdjustment.persist();
	}

	/**
	* Sets the amount of this monthly adjustment.
	*
	* @param amount the amount of this monthly adjustment
	*/
	@Override
	public void setAmount(double amount) {
		_monthlyAdjustment.setAmount(amount);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_monthlyAdjustment.setCachedModel(cachedModel);
	}

	/**
	* Sets the employee ID of this monthly adjustment.
	*
	* @param employeeId the employee ID of this monthly adjustment
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_monthlyAdjustment.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_monthlyAdjustment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_monthlyAdjustment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_monthlyAdjustment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the monthly adjustment ID of this monthly adjustment.
	*
	* @param monthlyAdjustmentId the monthly adjustment ID of this monthly adjustment
	*/
	@Override
	public void setMonthlyAdjustmentId(long monthlyAdjustmentId) {
		_monthlyAdjustment.setMonthlyAdjustmentId(monthlyAdjustmentId);
	}

	/**
	* Sets the month year of this monthly adjustment.
	*
	* @param monthYear the month year of this monthly adjustment
	*/
	@Override
	public void setMonthYear(long monthYear) {
		_monthlyAdjustment.setMonthYear(monthYear);
	}

	@Override
	public void setNew(boolean n) {
		_monthlyAdjustment.setNew(n);
	}

	/**
	* Sets the pay component ID of this monthly adjustment.
	*
	* @param payComponentId the pay component ID of this monthly adjustment
	*/
	@Override
	public void setPayComponentId(long payComponentId) {
		_monthlyAdjustment.setPayComponentId(payComponentId);
	}

	/**
	* Sets the primary key of this monthly adjustment.
	*
	* @param primaryKey the primary key of this monthly adjustment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_monthlyAdjustment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_monthlyAdjustment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MonthlyAdjustment> toCacheModel() {
		return _monthlyAdjustment.toCacheModel();
	}

	@Override
	public MonthlyAdjustment toEscapedModel() {
		return new MonthlyAdjustmentWrapper(_monthlyAdjustment.toEscapedModel());
	}

	@Override
	public String toString() {
		return _monthlyAdjustment.toString();
	}

	@Override
	public MonthlyAdjustment toUnescapedModel() {
		return new MonthlyAdjustmentWrapper(_monthlyAdjustment.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _monthlyAdjustment.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MonthlyAdjustmentWrapper)) {
			return false;
		}

		MonthlyAdjustmentWrapper monthlyAdjustmentWrapper = (MonthlyAdjustmentWrapper)obj;

		if (Objects.equals(_monthlyAdjustment,
					monthlyAdjustmentWrapper._monthlyAdjustment)) {
			return true;
		}

		return false;
	}

	@Override
	public MonthlyAdjustment getWrappedModel() {
		return _monthlyAdjustment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _monthlyAdjustment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _monthlyAdjustment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_monthlyAdjustment.resetOriginalValues();
	}

	private final MonthlyAdjustment _monthlyAdjustment;
}