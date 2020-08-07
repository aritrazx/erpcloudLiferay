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
 * This class is a wrapper for {@link LeaveApplyDtl}.
 * </p>
 *
 * @author Samaresh
 * @see LeaveApplyDtl
 * @generated
 */
@ProviderType
public class LeaveApplyDtlWrapper implements LeaveApplyDtl,
	ModelWrapper<LeaveApplyDtl> {
	public LeaveApplyDtlWrapper(LeaveApplyDtl leaveApplyDtl) {
		_leaveApplyDtl = leaveApplyDtl;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveApplyDtl.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveApplyDtl.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveApplyDtlId", getLeaveApplyDtlId());
		attributes.put("leaveApplyId", getLeaveApplyId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("leaveDate", getLeaveDate());
		attributes.put("sessionData", getSessionData());
		attributes.put("leaveDays", getLeaveDays());
		attributes.put("impectOnSalary", getImpectOnSalary());
		attributes.put("isApprove", getIsApprove());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveApplyDtlId = (Long)attributes.get("leaveApplyDtlId");

		if (leaveApplyDtlId != null) {
			setLeaveApplyDtlId(leaveApplyDtlId);
		}

		Long leaveApplyId = (Long)attributes.get("leaveApplyId");

		if (leaveApplyId != null) {
			setLeaveApplyId(leaveApplyId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long leaveTypeId = (Long)attributes.get("leaveTypeId");

		if (leaveTypeId != null) {
			setLeaveTypeId(leaveTypeId);
		}

		Date leaveDate = (Date)attributes.get("leaveDate");

		if (leaveDate != null) {
			setLeaveDate(leaveDate);
		}

		String sessionData = (String)attributes.get("sessionData");

		if (sessionData != null) {
			setSessionData(sessionData);
		}

		Double leaveDays = (Double)attributes.get("leaveDays");

		if (leaveDays != null) {
			setLeaveDays(leaveDays);
		}

		Integer impectOnSalary = (Integer)attributes.get("impectOnSalary");

		if (impectOnSalary != null) {
			setImpectOnSalary(impectOnSalary);
		}

		Integer isApprove = (Integer)attributes.get("isApprove");

		if (isApprove != null) {
			setIsApprove(isApprove);
		}
	}

	@Override
	public Object clone() {
		return new LeaveApplyDtlWrapper((LeaveApplyDtl)_leaveApplyDtl.clone());
	}

	@Override
	public int compareTo(LeaveApplyDtl leaveApplyDtl) {
		return _leaveApplyDtl.compareTo(leaveApplyDtl);
	}

	/**
	* Returns the company ID of this leave apply dtl.
	*
	* @return the company ID of this leave apply dtl
	*/
	@Override
	public long getCompanyId() {
		return _leaveApplyDtl.getCompanyId();
	}

	/**
	* Returns the employee ID of this leave apply dtl.
	*
	* @return the employee ID of this leave apply dtl
	*/
	@Override
	public long getEmployeeId() {
		return _leaveApplyDtl.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _leaveApplyDtl.getExpandoBridge();
	}

	/**
	* Returns the impect on salary of this leave apply dtl.
	*
	* @return the impect on salary of this leave apply dtl
	*/
	@Override
	public int getImpectOnSalary() {
		return _leaveApplyDtl.getImpectOnSalary();
	}

	/**
	* Returns the is approve of this leave apply dtl.
	*
	* @return the is approve of this leave apply dtl
	*/
	@Override
	public int getIsApprove() {
		return _leaveApplyDtl.getIsApprove();
	}

	/**
	* Returns the leave apply dtl ID of this leave apply dtl.
	*
	* @return the leave apply dtl ID of this leave apply dtl
	*/
	@Override
	public long getLeaveApplyDtlId() {
		return _leaveApplyDtl.getLeaveApplyDtlId();
	}

	/**
	* Returns the leave apply ID of this leave apply dtl.
	*
	* @return the leave apply ID of this leave apply dtl
	*/
	@Override
	public long getLeaveApplyId() {
		return _leaveApplyDtl.getLeaveApplyId();
	}

	/**
	* Returns the leave date of this leave apply dtl.
	*
	* @return the leave date of this leave apply dtl
	*/
	@Override
	public Date getLeaveDate() {
		return _leaveApplyDtl.getLeaveDate();
	}

	/**
	* Returns the leave days of this leave apply dtl.
	*
	* @return the leave days of this leave apply dtl
	*/
	@Override
	public double getLeaveDays() {
		return _leaveApplyDtl.getLeaveDays();
	}

	/**
	* Returns the leave type ID of this leave apply dtl.
	*
	* @return the leave type ID of this leave apply dtl
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveApplyDtl.getLeaveTypeId();
	}

	/**
	* Returns the primary key of this leave apply dtl.
	*
	* @return the primary key of this leave apply dtl
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveApplyDtl.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveApplyDtl.getPrimaryKeyObj();
	}

	/**
	* Returns the session data of this leave apply dtl.
	*
	* @return the session data of this leave apply dtl
	*/
	@Override
	public String getSessionData() {
		return _leaveApplyDtl.getSessionData();
	}

	@Override
	public int hashCode() {
		return _leaveApplyDtl.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _leaveApplyDtl.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveApplyDtl.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _leaveApplyDtl.isNew();
	}

	@Override
	public void persist() {
		_leaveApplyDtl.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveApplyDtl.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this leave apply dtl.
	*
	* @param companyId the company ID of this leave apply dtl
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveApplyDtl.setCompanyId(companyId);
	}

	/**
	* Sets the employee ID of this leave apply dtl.
	*
	* @param employeeId the employee ID of this leave apply dtl
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_leaveApplyDtl.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_leaveApplyDtl.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_leaveApplyDtl.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_leaveApplyDtl.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the impect on salary of this leave apply dtl.
	*
	* @param impectOnSalary the impect on salary of this leave apply dtl
	*/
	@Override
	public void setImpectOnSalary(int impectOnSalary) {
		_leaveApplyDtl.setImpectOnSalary(impectOnSalary);
	}

	/**
	* Sets the is approve of this leave apply dtl.
	*
	* @param isApprove the is approve of this leave apply dtl
	*/
	@Override
	public void setIsApprove(int isApprove) {
		_leaveApplyDtl.setIsApprove(isApprove);
	}

	/**
	* Sets the leave apply dtl ID of this leave apply dtl.
	*
	* @param leaveApplyDtlId the leave apply dtl ID of this leave apply dtl
	*/
	@Override
	public void setLeaveApplyDtlId(long leaveApplyDtlId) {
		_leaveApplyDtl.setLeaveApplyDtlId(leaveApplyDtlId);
	}

	/**
	* Sets the leave apply ID of this leave apply dtl.
	*
	* @param leaveApplyId the leave apply ID of this leave apply dtl
	*/
	@Override
	public void setLeaveApplyId(long leaveApplyId) {
		_leaveApplyDtl.setLeaveApplyId(leaveApplyId);
	}

	/**
	* Sets the leave date of this leave apply dtl.
	*
	* @param leaveDate the leave date of this leave apply dtl
	*/
	@Override
	public void setLeaveDate(Date leaveDate) {
		_leaveApplyDtl.setLeaveDate(leaveDate);
	}

	/**
	* Sets the leave days of this leave apply dtl.
	*
	* @param leaveDays the leave days of this leave apply dtl
	*/
	@Override
	public void setLeaveDays(double leaveDays) {
		_leaveApplyDtl.setLeaveDays(leaveDays);
	}

	/**
	* Sets the leave type ID of this leave apply dtl.
	*
	* @param leaveTypeId the leave type ID of this leave apply dtl
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveApplyDtl.setLeaveTypeId(leaveTypeId);
	}

	@Override
	public void setNew(boolean n) {
		_leaveApplyDtl.setNew(n);
	}

	/**
	* Sets the primary key of this leave apply dtl.
	*
	* @param primaryKey the primary key of this leave apply dtl
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveApplyDtl.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_leaveApplyDtl.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the session data of this leave apply dtl.
	*
	* @param sessionData the session data of this leave apply dtl
	*/
	@Override
	public void setSessionData(String sessionData) {
		_leaveApplyDtl.setSessionData(sessionData);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LeaveApplyDtl> toCacheModel() {
		return _leaveApplyDtl.toCacheModel();
	}

	@Override
	public LeaveApplyDtl toEscapedModel() {
		return new LeaveApplyDtlWrapper(_leaveApplyDtl.toEscapedModel());
	}

	@Override
	public String toString() {
		return _leaveApplyDtl.toString();
	}

	@Override
	public LeaveApplyDtl toUnescapedModel() {
		return new LeaveApplyDtlWrapper(_leaveApplyDtl.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _leaveApplyDtl.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveApplyDtlWrapper)) {
			return false;
		}

		LeaveApplyDtlWrapper leaveApplyDtlWrapper = (LeaveApplyDtlWrapper)obj;

		if (Objects.equals(_leaveApplyDtl, leaveApplyDtlWrapper._leaveApplyDtl)) {
			return true;
		}

		return false;
	}

	@Override
	public LeaveApplyDtl getWrappedModel() {
		return _leaveApplyDtl;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _leaveApplyDtl.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _leaveApplyDtl.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_leaveApplyDtl.resetOriginalValues();
	}

	private final LeaveApplyDtl _leaveApplyDtl;
}