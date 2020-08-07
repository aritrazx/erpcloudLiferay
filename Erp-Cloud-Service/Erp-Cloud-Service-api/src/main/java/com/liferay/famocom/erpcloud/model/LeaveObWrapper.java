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
 * This class is a wrapper for {@link LeaveOb}.
 * </p>
 *
 * @author Samaresh
 * @see LeaveOb
 * @generated
 */
@ProviderType
public class LeaveObWrapper implements LeaveOb, ModelWrapper<LeaveOb> {
	public LeaveObWrapper(LeaveOb leaveOb) {
		_leaveOb = leaveOb;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveOb.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveOb.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveobId", getLeaveobId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("obVal", getObVal());
		attributes.put("isApprove", isIsApprove());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveobId = (Long)attributes.get("leaveobId");

		if (leaveobId != null) {
			setLeaveobId(leaveobId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long leaveTypeId = (Long)attributes.get("leaveTypeId");

		if (leaveTypeId != null) {
			setLeaveTypeId(leaveTypeId);
		}

		Integer obVal = (Integer)attributes.get("obVal");

		if (obVal != null) {
			setObVal(obVal);
		}

		Boolean isApprove = (Boolean)attributes.get("isApprove");

		if (isApprove != null) {
			setIsApprove(isApprove);
		}
	}

	@Override
	public Object clone() {
		return new LeaveObWrapper((LeaveOb)_leaveOb.clone());
	}

	@Override
	public int compareTo(LeaveOb leaveOb) {
		return _leaveOb.compareTo(leaveOb);
	}

	/**
	* Returns the employee ID of this leave ob.
	*
	* @return the employee ID of this leave ob
	*/
	@Override
	public long getEmployeeId() {
		return _leaveOb.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _leaveOb.getExpandoBridge();
	}

	/**
	* Returns the is approve of this leave ob.
	*
	* @return the is approve of this leave ob
	*/
	@Override
	public boolean getIsApprove() {
		return _leaveOb.getIsApprove();
	}

	/**
	* Returns the leaveob ID of this leave ob.
	*
	* @return the leaveob ID of this leave ob
	*/
	@Override
	public long getLeaveobId() {
		return _leaveOb.getLeaveobId();
	}

	/**
	* Returns the leave type ID of this leave ob.
	*
	* @return the leave type ID of this leave ob
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveOb.getLeaveTypeId();
	}

	/**
	* Returns the ob val of this leave ob.
	*
	* @return the ob val of this leave ob
	*/
	@Override
	public int getObVal() {
		return _leaveOb.getObVal();
	}

	/**
	* Returns the primary key of this leave ob.
	*
	* @return the primary key of this leave ob
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveOb.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveOb.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _leaveOb.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _leaveOb.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveOb.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this leave ob is is approve.
	*
	* @return <code>true</code> if this leave ob is is approve; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApprove() {
		return _leaveOb.isIsApprove();
	}

	@Override
	public boolean isNew() {
		return _leaveOb.isNew();
	}

	@Override
	public void persist() {
		_leaveOb.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveOb.setCachedModel(cachedModel);
	}

	/**
	* Sets the employee ID of this leave ob.
	*
	* @param employeeId the employee ID of this leave ob
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_leaveOb.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_leaveOb.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_leaveOb.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_leaveOb.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this leave ob is is approve.
	*
	* @param isApprove the is approve of this leave ob
	*/
	@Override
	public void setIsApprove(boolean isApprove) {
		_leaveOb.setIsApprove(isApprove);
	}

	/**
	* Sets the leaveob ID of this leave ob.
	*
	* @param leaveobId the leaveob ID of this leave ob
	*/
	@Override
	public void setLeaveobId(long leaveobId) {
		_leaveOb.setLeaveobId(leaveobId);
	}

	/**
	* Sets the leave type ID of this leave ob.
	*
	* @param leaveTypeId the leave type ID of this leave ob
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveOb.setLeaveTypeId(leaveTypeId);
	}

	@Override
	public void setNew(boolean n) {
		_leaveOb.setNew(n);
	}

	/**
	* Sets the ob val of this leave ob.
	*
	* @param obVal the ob val of this leave ob
	*/
	@Override
	public void setObVal(int obVal) {
		_leaveOb.setObVal(obVal);
	}

	/**
	* Sets the primary key of this leave ob.
	*
	* @param primaryKey the primary key of this leave ob
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveOb.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_leaveOb.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LeaveOb> toCacheModel() {
		return _leaveOb.toCacheModel();
	}

	@Override
	public LeaveOb toEscapedModel() {
		return new LeaveObWrapper(_leaveOb.toEscapedModel());
	}

	@Override
	public String toString() {
		return _leaveOb.toString();
	}

	@Override
	public LeaveOb toUnescapedModel() {
		return new LeaveObWrapper(_leaveOb.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _leaveOb.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveObWrapper)) {
			return false;
		}

		LeaveObWrapper leaveObWrapper = (LeaveObWrapper)obj;

		if (Objects.equals(_leaveOb, leaveObWrapper._leaveOb)) {
			return true;
		}

		return false;
	}

	@Override
	public LeaveOb getWrappedModel() {
		return _leaveOb;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _leaveOb.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _leaveOb.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_leaveOb.resetOriginalValues();
	}

	private final LeaveOb _leaveOb;
}