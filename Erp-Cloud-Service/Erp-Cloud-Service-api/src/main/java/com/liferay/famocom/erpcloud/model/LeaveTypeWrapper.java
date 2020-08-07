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
 * This class is a wrapper for {@link LeaveType}.
 * </p>
 *
 * @author Samaresh
 * @see LeaveType
 * @generated
 */
@ProviderType
public class LeaveTypeWrapper implements LeaveType, ModelWrapper<LeaveType> {
	public LeaveTypeWrapper(LeaveType leaveType) {
		_leaveType = leaveType;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveType.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("leaveName", getLeaveName());
		attributes.put("abb", getAbb());
		attributes.put("encashmentDay", getEncashmentDay());
		attributes.put("forwardDay", getForwardDay());
		attributes.put("leaveStatus", isLeaveStatus());
		attributes.put("encashmentPer", getEncashmentPer());
		attributes.put("minServiceDay", getMinServiceDay());
		attributes.put("noticeDay", getNoticeDay());
		attributes.put("employeetypeId", getEmployeetypeId());
		attributes.put("maxCreditDay", getMaxCreditDay());
		attributes.put("gender", getGender());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("impectOnSalary", getImpectOnSalary());
		attributes.put("companyId", getCompanyId());
		attributes.put("addedDate", getAddedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveTypeId = (Long)attributes.get("leaveTypeId");

		if (leaveTypeId != null) {
			setLeaveTypeId(leaveTypeId);
		}

		String leaveName = (String)attributes.get("leaveName");

		if (leaveName != null) {
			setLeaveName(leaveName);
		}

		String abb = (String)attributes.get("abb");

		if (abb != null) {
			setAbb(abb);
		}

		Integer encashmentDay = (Integer)attributes.get("encashmentDay");

		if (encashmentDay != null) {
			setEncashmentDay(encashmentDay);
		}

		Integer forwardDay = (Integer)attributes.get("forwardDay");

		if (forwardDay != null) {
			setForwardDay(forwardDay);
		}

		Boolean leaveStatus = (Boolean)attributes.get("leaveStatus");

		if (leaveStatus != null) {
			setLeaveStatus(leaveStatus);
		}

		Integer encashmentPer = (Integer)attributes.get("encashmentPer");

		if (encashmentPer != null) {
			setEncashmentPer(encashmentPer);
		}

		Integer minServiceDay = (Integer)attributes.get("minServiceDay");

		if (minServiceDay != null) {
			setMinServiceDay(minServiceDay);
		}

		Integer noticeDay = (Integer)attributes.get("noticeDay");

		if (noticeDay != null) {
			setNoticeDay(noticeDay);
		}

		Long employeetypeId = (Long)attributes.get("employeetypeId");

		if (employeetypeId != null) {
			setEmployeetypeId(employeetypeId);
		}

		Integer maxCreditDay = (Integer)attributes.get("maxCreditDay");

		if (maxCreditDay != null) {
			setMaxCreditDay(maxCreditDay);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Integer impectOnSalary = (Integer)attributes.get("impectOnSalary");

		if (impectOnSalary != null) {
			setImpectOnSalary(impectOnSalary);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public Object clone() {
		return new LeaveTypeWrapper((LeaveType)_leaveType.clone());
	}

	@Override
	public int compareTo(LeaveType leaveType) {
		return _leaveType.compareTo(leaveType);
	}

	/**
	* Returns the abb of this leave type.
	*
	* @return the abb of this leave type
	*/
	@Override
	public String getAbb() {
		return _leaveType.getAbb();
	}

	/**
	* Returns the added date of this leave type.
	*
	* @return the added date of this leave type
	*/
	@Override
	public Date getAddedDate() {
		return _leaveType.getAddedDate();
	}

	/**
	* Returns the company ID of this leave type.
	*
	* @return the company ID of this leave type
	*/
	@Override
	public long getCompanyId() {
		return _leaveType.getCompanyId();
	}

	/**
	* Returns the employeetype ID of this leave type.
	*
	* @return the employeetype ID of this leave type
	*/
	@Override
	public long getEmployeetypeId() {
		return _leaveType.getEmployeetypeId();
	}

	/**
	* Returns the encashment day of this leave type.
	*
	* @return the encashment day of this leave type
	*/
	@Override
	public int getEncashmentDay() {
		return _leaveType.getEncashmentDay();
	}

	/**
	* Returns the encashment per of this leave type.
	*
	* @return the encashment per of this leave type
	*/
	@Override
	public int getEncashmentPer() {
		return _leaveType.getEncashmentPer();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _leaveType.getExpandoBridge();
	}

	/**
	* Returns the forward day of this leave type.
	*
	* @return the forward day of this leave type
	*/
	@Override
	public int getForwardDay() {
		return _leaveType.getForwardDay();
	}

	/**
	* Returns the gender of this leave type.
	*
	* @return the gender of this leave type
	*/
	@Override
	public String getGender() {
		return _leaveType.getGender();
	}

	/**
	* Returns the impect on salary of this leave type.
	*
	* @return the impect on salary of this leave type
	*/
	@Override
	public int getImpectOnSalary() {
		return _leaveType.getImpectOnSalary();
	}

	/**
	* Returns the leave name of this leave type.
	*
	* @return the leave name of this leave type
	*/
	@Override
	public String getLeaveName() {
		return _leaveType.getLeaveName();
	}

	/**
	* Returns the leave status of this leave type.
	*
	* @return the leave status of this leave type
	*/
	@Override
	public boolean getLeaveStatus() {
		return _leaveType.getLeaveStatus();
	}

	/**
	* Returns the leave type ID of this leave type.
	*
	* @return the leave type ID of this leave type
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveType.getLeaveTypeId();
	}

	/**
	* Returns the marital status of this leave type.
	*
	* @return the marital status of this leave type
	*/
	@Override
	public String getMaritalStatus() {
		return _leaveType.getMaritalStatus();
	}

	/**
	* Returns the max credit day of this leave type.
	*
	* @return the max credit day of this leave type
	*/
	@Override
	public int getMaxCreditDay() {
		return _leaveType.getMaxCreditDay();
	}

	/**
	* Returns the min service day of this leave type.
	*
	* @return the min service day of this leave type
	*/
	@Override
	public int getMinServiceDay() {
		return _leaveType.getMinServiceDay();
	}

	/**
	* Returns the notice day of this leave type.
	*
	* @return the notice day of this leave type
	*/
	@Override
	public int getNoticeDay() {
		return _leaveType.getNoticeDay();
	}

	/**
	* Returns the primary key of this leave type.
	*
	* @return the primary key of this leave type
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveType.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveType.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _leaveType.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _leaveType.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveType.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this leave type is leave status.
	*
	* @return <code>true</code> if this leave type is leave status; <code>false</code> otherwise
	*/
	@Override
	public boolean isLeaveStatus() {
		return _leaveType.isLeaveStatus();
	}

	@Override
	public boolean isNew() {
		return _leaveType.isNew();
	}

	@Override
	public void persist() {
		_leaveType.persist();
	}

	/**
	* Sets the abb of this leave type.
	*
	* @param abb the abb of this leave type
	*/
	@Override
	public void setAbb(String abb) {
		_leaveType.setAbb(abb);
	}

	/**
	* Sets the added date of this leave type.
	*
	* @param addedDate the added date of this leave type
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_leaveType.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveType.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this leave type.
	*
	* @param companyId the company ID of this leave type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveType.setCompanyId(companyId);
	}

	/**
	* Sets the employeetype ID of this leave type.
	*
	* @param employeetypeId the employeetype ID of this leave type
	*/
	@Override
	public void setEmployeetypeId(long employeetypeId) {
		_leaveType.setEmployeetypeId(employeetypeId);
	}

	/**
	* Sets the encashment day of this leave type.
	*
	* @param encashmentDay the encashment day of this leave type
	*/
	@Override
	public void setEncashmentDay(int encashmentDay) {
		_leaveType.setEncashmentDay(encashmentDay);
	}

	/**
	* Sets the encashment per of this leave type.
	*
	* @param encashmentPer the encashment per of this leave type
	*/
	@Override
	public void setEncashmentPer(int encashmentPer) {
		_leaveType.setEncashmentPer(encashmentPer);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_leaveType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_leaveType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_leaveType.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the forward day of this leave type.
	*
	* @param forwardDay the forward day of this leave type
	*/
	@Override
	public void setForwardDay(int forwardDay) {
		_leaveType.setForwardDay(forwardDay);
	}

	/**
	* Sets the gender of this leave type.
	*
	* @param gender the gender of this leave type
	*/
	@Override
	public void setGender(String gender) {
		_leaveType.setGender(gender);
	}

	/**
	* Sets the impect on salary of this leave type.
	*
	* @param impectOnSalary the impect on salary of this leave type
	*/
	@Override
	public void setImpectOnSalary(int impectOnSalary) {
		_leaveType.setImpectOnSalary(impectOnSalary);
	}

	/**
	* Sets the leave name of this leave type.
	*
	* @param leaveName the leave name of this leave type
	*/
	@Override
	public void setLeaveName(String leaveName) {
		_leaveType.setLeaveName(leaveName);
	}

	/**
	* Sets whether this leave type is leave status.
	*
	* @param leaveStatus the leave status of this leave type
	*/
	@Override
	public void setLeaveStatus(boolean leaveStatus) {
		_leaveType.setLeaveStatus(leaveStatus);
	}

	/**
	* Sets the leave type ID of this leave type.
	*
	* @param leaveTypeId the leave type ID of this leave type
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveType.setLeaveTypeId(leaveTypeId);
	}

	/**
	* Sets the marital status of this leave type.
	*
	* @param maritalStatus the marital status of this leave type
	*/
	@Override
	public void setMaritalStatus(String maritalStatus) {
		_leaveType.setMaritalStatus(maritalStatus);
	}

	/**
	* Sets the max credit day of this leave type.
	*
	* @param maxCreditDay the max credit day of this leave type
	*/
	@Override
	public void setMaxCreditDay(int maxCreditDay) {
		_leaveType.setMaxCreditDay(maxCreditDay);
	}

	/**
	* Sets the min service day of this leave type.
	*
	* @param minServiceDay the min service day of this leave type
	*/
	@Override
	public void setMinServiceDay(int minServiceDay) {
		_leaveType.setMinServiceDay(minServiceDay);
	}

	@Override
	public void setNew(boolean n) {
		_leaveType.setNew(n);
	}

	/**
	* Sets the notice day of this leave type.
	*
	* @param noticeDay the notice day of this leave type
	*/
	@Override
	public void setNoticeDay(int noticeDay) {
		_leaveType.setNoticeDay(noticeDay);
	}

	/**
	* Sets the primary key of this leave type.
	*
	* @param primaryKey the primary key of this leave type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveType.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_leaveType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LeaveType> toCacheModel() {
		return _leaveType.toCacheModel();
	}

	@Override
	public LeaveType toEscapedModel() {
		return new LeaveTypeWrapper(_leaveType.toEscapedModel());
	}

	@Override
	public String toString() {
		return _leaveType.toString();
	}

	@Override
	public LeaveType toUnescapedModel() {
		return new LeaveTypeWrapper(_leaveType.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _leaveType.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveTypeWrapper)) {
			return false;
		}

		LeaveTypeWrapper leaveTypeWrapper = (LeaveTypeWrapper)obj;

		if (Objects.equals(_leaveType, leaveTypeWrapper._leaveType)) {
			return true;
		}

		return false;
	}

	@Override
	public LeaveType getWrappedModel() {
		return _leaveType;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _leaveType.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _leaveType.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_leaveType.resetOriginalValues();
	}

	private final LeaveType _leaveType;
}