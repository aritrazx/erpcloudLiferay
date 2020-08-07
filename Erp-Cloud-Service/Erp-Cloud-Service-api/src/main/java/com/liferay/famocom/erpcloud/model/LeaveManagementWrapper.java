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
 * This class is a wrapper for {@link LeaveManagement}.
 * </p>
 *
 * @author Samaresh
 * @see LeaveManagement
 * @generated
 */
@ProviderType
public class LeaveManagementWrapper implements LeaveManagement,
	ModelWrapper<LeaveManagement> {
	public LeaveManagementWrapper(LeaveManagement leaveManagement) {
		_leaveManagement = leaveManagement;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveManagement.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveManagement.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveId", getLeaveId());
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
		Long leaveId = (Long)attributes.get("leaveId");

		if (leaveId != null) {
			setLeaveId(leaveId);
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
		return new LeaveManagementWrapper((LeaveManagement)_leaveManagement.clone());
	}

	@Override
	public int compareTo(LeaveManagement leaveManagement) {
		return _leaveManagement.compareTo(leaveManagement);
	}

	/**
	* Returns the abb of this leave management.
	*
	* @return the abb of this leave management
	*/
	@Override
	public String getAbb() {
		return _leaveManagement.getAbb();
	}

	/**
	* Returns the added date of this leave management.
	*
	* @return the added date of this leave management
	*/
	@Override
	public Date getAddedDate() {
		return _leaveManagement.getAddedDate();
	}

	/**
	* Returns the company ID of this leave management.
	*
	* @return the company ID of this leave management
	*/
	@Override
	public long getCompanyId() {
		return _leaveManagement.getCompanyId();
	}

	/**
	* Returns the employeetype ID of this leave management.
	*
	* @return the employeetype ID of this leave management
	*/
	@Override
	public long getEmployeetypeId() {
		return _leaveManagement.getEmployeetypeId();
	}

	/**
	* Returns the encashment day of this leave management.
	*
	* @return the encashment day of this leave management
	*/
	@Override
	public int getEncashmentDay() {
		return _leaveManagement.getEncashmentDay();
	}

	/**
	* Returns the encashment per of this leave management.
	*
	* @return the encashment per of this leave management
	*/
	@Override
	public int getEncashmentPer() {
		return _leaveManagement.getEncashmentPer();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _leaveManagement.getExpandoBridge();
	}

	/**
	* Returns the forward day of this leave management.
	*
	* @return the forward day of this leave management
	*/
	@Override
	public int getForwardDay() {
		return _leaveManagement.getForwardDay();
	}

	/**
	* Returns the gender of this leave management.
	*
	* @return the gender of this leave management
	*/
	@Override
	public String getGender() {
		return _leaveManagement.getGender();
	}

	/**
	* Returns the impect on salary of this leave management.
	*
	* @return the impect on salary of this leave management
	*/
	@Override
	public int getImpectOnSalary() {
		return _leaveManagement.getImpectOnSalary();
	}

	/**
	* Returns the leave ID of this leave management.
	*
	* @return the leave ID of this leave management
	*/
	@Override
	public long getLeaveId() {
		return _leaveManagement.getLeaveId();
	}

	/**
	* Returns the leave name of this leave management.
	*
	* @return the leave name of this leave management
	*/
	@Override
	public String getLeaveName() {
		return _leaveManagement.getLeaveName();
	}

	/**
	* Returns the leave status of this leave management.
	*
	* @return the leave status of this leave management
	*/
	@Override
	public boolean getLeaveStatus() {
		return _leaveManagement.getLeaveStatus();
	}

	/**
	* Returns the marital status of this leave management.
	*
	* @return the marital status of this leave management
	*/
	@Override
	public String getMaritalStatus() {
		return _leaveManagement.getMaritalStatus();
	}

	/**
	* Returns the max credit day of this leave management.
	*
	* @return the max credit day of this leave management
	*/
	@Override
	public int getMaxCreditDay() {
		return _leaveManagement.getMaxCreditDay();
	}

	/**
	* Returns the min service day of this leave management.
	*
	* @return the min service day of this leave management
	*/
	@Override
	public int getMinServiceDay() {
		return _leaveManagement.getMinServiceDay();
	}

	/**
	* Returns the notice day of this leave management.
	*
	* @return the notice day of this leave management
	*/
	@Override
	public int getNoticeDay() {
		return _leaveManagement.getNoticeDay();
	}

	/**
	* Returns the primary key of this leave management.
	*
	* @return the primary key of this leave management
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveManagement.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveManagement.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _leaveManagement.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _leaveManagement.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveManagement.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this leave management is leave status.
	*
	* @return <code>true</code> if this leave management is leave status; <code>false</code> otherwise
	*/
	@Override
	public boolean isLeaveStatus() {
		return _leaveManagement.isLeaveStatus();
	}

	@Override
	public boolean isNew() {
		return _leaveManagement.isNew();
	}

	@Override
	public void persist() {
		_leaveManagement.persist();
	}

	/**
	* Sets the abb of this leave management.
	*
	* @param abb the abb of this leave management
	*/
	@Override
	public void setAbb(String abb) {
		_leaveManagement.setAbb(abb);
	}

	/**
	* Sets the added date of this leave management.
	*
	* @param addedDate the added date of this leave management
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_leaveManagement.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveManagement.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this leave management.
	*
	* @param companyId the company ID of this leave management
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveManagement.setCompanyId(companyId);
	}

	/**
	* Sets the employeetype ID of this leave management.
	*
	* @param employeetypeId the employeetype ID of this leave management
	*/
	@Override
	public void setEmployeetypeId(long employeetypeId) {
		_leaveManagement.setEmployeetypeId(employeetypeId);
	}

	/**
	* Sets the encashment day of this leave management.
	*
	* @param encashmentDay the encashment day of this leave management
	*/
	@Override
	public void setEncashmentDay(int encashmentDay) {
		_leaveManagement.setEncashmentDay(encashmentDay);
	}

	/**
	* Sets the encashment per of this leave management.
	*
	* @param encashmentPer the encashment per of this leave management
	*/
	@Override
	public void setEncashmentPer(int encashmentPer) {
		_leaveManagement.setEncashmentPer(encashmentPer);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_leaveManagement.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_leaveManagement.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_leaveManagement.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the forward day of this leave management.
	*
	* @param forwardDay the forward day of this leave management
	*/
	@Override
	public void setForwardDay(int forwardDay) {
		_leaveManagement.setForwardDay(forwardDay);
	}

	/**
	* Sets the gender of this leave management.
	*
	* @param gender the gender of this leave management
	*/
	@Override
	public void setGender(String gender) {
		_leaveManagement.setGender(gender);
	}

	/**
	* Sets the impect on salary of this leave management.
	*
	* @param impectOnSalary the impect on salary of this leave management
	*/
	@Override
	public void setImpectOnSalary(int impectOnSalary) {
		_leaveManagement.setImpectOnSalary(impectOnSalary);
	}

	/**
	* Sets the leave ID of this leave management.
	*
	* @param leaveId the leave ID of this leave management
	*/
	@Override
	public void setLeaveId(long leaveId) {
		_leaveManagement.setLeaveId(leaveId);
	}

	/**
	* Sets the leave name of this leave management.
	*
	* @param leaveName the leave name of this leave management
	*/
	@Override
	public void setLeaveName(String leaveName) {
		_leaveManagement.setLeaveName(leaveName);
	}

	/**
	* Sets whether this leave management is leave status.
	*
	* @param leaveStatus the leave status of this leave management
	*/
	@Override
	public void setLeaveStatus(boolean leaveStatus) {
		_leaveManagement.setLeaveStatus(leaveStatus);
	}

	/**
	* Sets the marital status of this leave management.
	*
	* @param maritalStatus the marital status of this leave management
	*/
	@Override
	public void setMaritalStatus(String maritalStatus) {
		_leaveManagement.setMaritalStatus(maritalStatus);
	}

	/**
	* Sets the max credit day of this leave management.
	*
	* @param maxCreditDay the max credit day of this leave management
	*/
	@Override
	public void setMaxCreditDay(int maxCreditDay) {
		_leaveManagement.setMaxCreditDay(maxCreditDay);
	}

	/**
	* Sets the min service day of this leave management.
	*
	* @param minServiceDay the min service day of this leave management
	*/
	@Override
	public void setMinServiceDay(int minServiceDay) {
		_leaveManagement.setMinServiceDay(minServiceDay);
	}

	@Override
	public void setNew(boolean n) {
		_leaveManagement.setNew(n);
	}

	/**
	* Sets the notice day of this leave management.
	*
	* @param noticeDay the notice day of this leave management
	*/
	@Override
	public void setNoticeDay(int noticeDay) {
		_leaveManagement.setNoticeDay(noticeDay);
	}

	/**
	* Sets the primary key of this leave management.
	*
	* @param primaryKey the primary key of this leave management
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveManagement.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_leaveManagement.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LeaveManagement> toCacheModel() {
		return _leaveManagement.toCacheModel();
	}

	@Override
	public LeaveManagement toEscapedModel() {
		return new LeaveManagementWrapper(_leaveManagement.toEscapedModel());
	}

	@Override
	public String toString() {
		return _leaveManagement.toString();
	}

	@Override
	public LeaveManagement toUnescapedModel() {
		return new LeaveManagementWrapper(_leaveManagement.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _leaveManagement.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveManagementWrapper)) {
			return false;
		}

		LeaveManagementWrapper leaveManagementWrapper = (LeaveManagementWrapper)obj;

		if (Objects.equals(_leaveManagement,
					leaveManagementWrapper._leaveManagement)) {
			return true;
		}

		return false;
	}

	@Override
	public LeaveManagement getWrappedModel() {
		return _leaveManagement;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _leaveManagement.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _leaveManagement.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_leaveManagement.resetOriginalValues();
	}

	private final LeaveManagement _leaveManagement;
}