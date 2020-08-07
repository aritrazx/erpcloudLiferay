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
 * This class is a wrapper for {@link StopPay}.
 * </p>
 *
 * @author Samaresh
 * @see StopPay
 * @generated
 */
@ProviderType
public class StopPayWrapper implements StopPay, ModelWrapper<StopPay> {
	public StopPayWrapper(StopPay stopPay) {
		_stopPay = stopPay;
	}

	@Override
	public Class<?> getModelClass() {
		return StopPay.class;
	}

	@Override
	public String getModelClassName() {
		return StopPay.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stopPayId", getStopPayId());
		attributes.put("monthYear", getMonthYear());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("reason", getReason());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("status", getStatus());
		attributes.put("isLock", getIsLock());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stopPayId = (Long)attributes.get("stopPayId");

		if (stopPayId != null) {
			setStopPayId(stopPayId);
		}

		Long monthYear = (Long)attributes.get("monthYear");

		if (monthYear != null) {
			setMonthYear(monthYear);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long isLock = (Long)attributes.get("isLock");

		if (isLock != null) {
			setIsLock(isLock);
		}
	}

	@Override
	public Object clone() {
		return new StopPayWrapper((StopPay)_stopPay.clone());
	}

	@Override
	public int compareTo(StopPay stopPay) {
		return _stopPay.compareTo(stopPay);
	}

	/**
	* Returns the created by of this stop pay.
	*
	* @return the created by of this stop pay
	*/
	@Override
	public long getCreatedBy() {
		return _stopPay.getCreatedBy();
	}

	/**
	* Returns the created date of this stop pay.
	*
	* @return the created date of this stop pay
	*/
	@Override
	public Date getCreatedDate() {
		return _stopPay.getCreatedDate();
	}

	/**
	* Returns the employee ID of this stop pay.
	*
	* @return the employee ID of this stop pay
	*/
	@Override
	public long getEmployeeId() {
		return _stopPay.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _stopPay.getExpandoBridge();
	}

	/**
	* Returns the is lock of this stop pay.
	*
	* @return the is lock of this stop pay
	*/
	@Override
	public long getIsLock() {
		return _stopPay.getIsLock();
	}

	/**
	* Returns the modified by of this stop pay.
	*
	* @return the modified by of this stop pay
	*/
	@Override
	public long getModifiedBy() {
		return _stopPay.getModifiedBy();
	}

	/**
	* Returns the modified date of this stop pay.
	*
	* @return the modified date of this stop pay
	*/
	@Override
	public Date getModifiedDate() {
		return _stopPay.getModifiedDate();
	}

	/**
	* Returns the month year of this stop pay.
	*
	* @return the month year of this stop pay
	*/
	@Override
	public long getMonthYear() {
		return _stopPay.getMonthYear();
	}

	/**
	* Returns the primary key of this stop pay.
	*
	* @return the primary key of this stop pay
	*/
	@Override
	public long getPrimaryKey() {
		return _stopPay.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stopPay.getPrimaryKeyObj();
	}

	/**
	* Returns the reason of this stop pay.
	*
	* @return the reason of this stop pay
	*/
	@Override
	public String getReason() {
		return _stopPay.getReason();
	}

	/**
	* Returns the status of this stop pay.
	*
	* @return the status of this stop pay
	*/
	@Override
	public long getStatus() {
		return _stopPay.getStatus();
	}

	/**
	* Returns the stop pay ID of this stop pay.
	*
	* @return the stop pay ID of this stop pay
	*/
	@Override
	public long getStopPayId() {
		return _stopPay.getStopPayId();
	}

	@Override
	public int hashCode() {
		return _stopPay.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _stopPay.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _stopPay.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _stopPay.isNew();
	}

	@Override
	public void persist() {
		_stopPay.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_stopPay.setCachedModel(cachedModel);
	}

	/**
	* Sets the created by of this stop pay.
	*
	* @param createdBy the created by of this stop pay
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_stopPay.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this stop pay.
	*
	* @param createdDate the created date of this stop pay
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_stopPay.setCreatedDate(createdDate);
	}

	/**
	* Sets the employee ID of this stop pay.
	*
	* @param employeeId the employee ID of this stop pay
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_stopPay.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_stopPay.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_stopPay.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_stopPay.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the is lock of this stop pay.
	*
	* @param isLock the is lock of this stop pay
	*/
	@Override
	public void setIsLock(long isLock) {
		_stopPay.setIsLock(isLock);
	}

	/**
	* Sets the modified by of this stop pay.
	*
	* @param modifiedBy the modified by of this stop pay
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_stopPay.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this stop pay.
	*
	* @param modifiedDate the modified date of this stop pay
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_stopPay.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the month year of this stop pay.
	*
	* @param monthYear the month year of this stop pay
	*/
	@Override
	public void setMonthYear(long monthYear) {
		_stopPay.setMonthYear(monthYear);
	}

	@Override
	public void setNew(boolean n) {
		_stopPay.setNew(n);
	}

	/**
	* Sets the primary key of this stop pay.
	*
	* @param primaryKey the primary key of this stop pay
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_stopPay.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_stopPay.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the reason of this stop pay.
	*
	* @param reason the reason of this stop pay
	*/
	@Override
	public void setReason(String reason) {
		_stopPay.setReason(reason);
	}

	/**
	* Sets the status of this stop pay.
	*
	* @param status the status of this stop pay
	*/
	@Override
	public void setStatus(long status) {
		_stopPay.setStatus(status);
	}

	/**
	* Sets the stop pay ID of this stop pay.
	*
	* @param stopPayId the stop pay ID of this stop pay
	*/
	@Override
	public void setStopPayId(long stopPayId) {
		_stopPay.setStopPayId(stopPayId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<StopPay> toCacheModel() {
		return _stopPay.toCacheModel();
	}

	@Override
	public StopPay toEscapedModel() {
		return new StopPayWrapper(_stopPay.toEscapedModel());
	}

	@Override
	public String toString() {
		return _stopPay.toString();
	}

	@Override
	public StopPay toUnescapedModel() {
		return new StopPayWrapper(_stopPay.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _stopPay.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StopPayWrapper)) {
			return false;
		}

		StopPayWrapper stopPayWrapper = (StopPayWrapper)obj;

		if (Objects.equals(_stopPay, stopPayWrapper._stopPay)) {
			return true;
		}

		return false;
	}

	@Override
	public StopPay getWrappedModel() {
		return _stopPay;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _stopPay.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _stopPay.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_stopPay.resetOriginalValues();
	}

	private final StopPay _stopPay;
}