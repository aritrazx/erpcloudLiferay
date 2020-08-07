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
 * This class is a wrapper for {@link Milestone}.
 * </p>
 *
 * @author Samaresh
 * @see Milestone
 * @generated
 */
@ProviderType
public class MilestoneWrapper implements Milestone, ModelWrapper<Milestone> {
	public MilestoneWrapper(Milestone milestone) {
		_milestone = milestone;
	}

	@Override
	public Class<?> getModelClass() {
		return Milestone.class;
	}

	@Override
	public String getModelClassName() {
		return Milestone.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("milestoneId", getMilestoneId());
		attributes.put("projectId", getProjectId());
		attributes.put("clientId", getClientId());
		attributes.put("milestoneName", getMilestoneName());
		attributes.put("dueDate", getDueDate());
		attributes.put("checkGST", getCheckGST());
		attributes.put("amount", getAmount());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long milestoneId = (Long)attributes.get("milestoneId");

		if (milestoneId != null) {
			setMilestoneId(milestoneId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String milestoneName = (String)attributes.get("milestoneName");

		if (milestoneName != null) {
			setMilestoneName(milestoneName);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Integer checkGST = (Integer)attributes.get("checkGST");

		if (checkGST != null) {
			setCheckGST(checkGST);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Object clone() {
		return new MilestoneWrapper((Milestone)_milestone.clone());
	}

	@Override
	public int compareTo(Milestone milestone) {
		return _milestone.compareTo(milestone);
	}

	/**
	* Returns the amount of this milestone.
	*
	* @return the amount of this milestone
	*/
	@Override
	public double getAmount() {
		return _milestone.getAmount();
	}

	/**
	* Returns the check gst of this milestone.
	*
	* @return the check gst of this milestone
	*/
	@Override
	public int getCheckGST() {
		return _milestone.getCheckGST();
	}

	/**
	* Returns the client ID of this milestone.
	*
	* @return the client ID of this milestone
	*/
	@Override
	public long getClientId() {
		return _milestone.getClientId();
	}

	/**
	* Returns the due date of this milestone.
	*
	* @return the due date of this milestone
	*/
	@Override
	public Date getDueDate() {
		return _milestone.getDueDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _milestone.getExpandoBridge();
	}

	/**
	* Returns the milestone ID of this milestone.
	*
	* @return the milestone ID of this milestone
	*/
	@Override
	public long getMilestoneId() {
		return _milestone.getMilestoneId();
	}

	/**
	* Returns the milestone name of this milestone.
	*
	* @return the milestone name of this milestone
	*/
	@Override
	public String getMilestoneName() {
		return _milestone.getMilestoneName();
	}

	/**
	* Returns the primary key of this milestone.
	*
	* @return the primary key of this milestone
	*/
	@Override
	public long getPrimaryKey() {
		return _milestone.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _milestone.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this milestone.
	*
	* @return the project ID of this milestone
	*/
	@Override
	public long getProjectId() {
		return _milestone.getProjectId();
	}

	/**
	* Returns the status of this milestone.
	*
	* @return the status of this milestone
	*/
	@Override
	public int getStatus() {
		return _milestone.getStatus();
	}

	@Override
	public int hashCode() {
		return _milestone.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _milestone.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _milestone.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _milestone.isNew();
	}

	@Override
	public void persist() {
		_milestone.persist();
	}

	/**
	* Sets the amount of this milestone.
	*
	* @param amount the amount of this milestone
	*/
	@Override
	public void setAmount(double amount) {
		_milestone.setAmount(amount);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_milestone.setCachedModel(cachedModel);
	}

	/**
	* Sets the check gst of this milestone.
	*
	* @param checkGST the check gst of this milestone
	*/
	@Override
	public void setCheckGST(int checkGST) {
		_milestone.setCheckGST(checkGST);
	}

	/**
	* Sets the client ID of this milestone.
	*
	* @param clientId the client ID of this milestone
	*/
	@Override
	public void setClientId(long clientId) {
		_milestone.setClientId(clientId);
	}

	/**
	* Sets the due date of this milestone.
	*
	* @param dueDate the due date of this milestone
	*/
	@Override
	public void setDueDate(Date dueDate) {
		_milestone.setDueDate(dueDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_milestone.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_milestone.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_milestone.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the milestone ID of this milestone.
	*
	* @param milestoneId the milestone ID of this milestone
	*/
	@Override
	public void setMilestoneId(long milestoneId) {
		_milestone.setMilestoneId(milestoneId);
	}

	/**
	* Sets the milestone name of this milestone.
	*
	* @param milestoneName the milestone name of this milestone
	*/
	@Override
	public void setMilestoneName(String milestoneName) {
		_milestone.setMilestoneName(milestoneName);
	}

	@Override
	public void setNew(boolean n) {
		_milestone.setNew(n);
	}

	/**
	* Sets the primary key of this milestone.
	*
	* @param primaryKey the primary key of this milestone
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_milestone.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_milestone.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this milestone.
	*
	* @param projectId the project ID of this milestone
	*/
	@Override
	public void setProjectId(long projectId) {
		_milestone.setProjectId(projectId);
	}

	/**
	* Sets the status of this milestone.
	*
	* @param status the status of this milestone
	*/
	@Override
	public void setStatus(int status) {
		_milestone.setStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Milestone> toCacheModel() {
		return _milestone.toCacheModel();
	}

	@Override
	public Milestone toEscapedModel() {
		return new MilestoneWrapper(_milestone.toEscapedModel());
	}

	@Override
	public String toString() {
		return _milestone.toString();
	}

	@Override
	public Milestone toUnescapedModel() {
		return new MilestoneWrapper(_milestone.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _milestone.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MilestoneWrapper)) {
			return false;
		}

		MilestoneWrapper milestoneWrapper = (MilestoneWrapper)obj;

		if (Objects.equals(_milestone, milestoneWrapper._milestone)) {
			return true;
		}

		return false;
	}

	@Override
	public Milestone getWrappedModel() {
		return _milestone;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _milestone.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _milestone.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_milestone.resetOriginalValues();
	}

	private final Milestone _milestone;
}