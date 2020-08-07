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
 * This class is a wrapper for {@link SelectedCandidatePayStructureMaster}.
 * </p>
 *
 * @author Samaresh
 * @see SelectedCandidatePayStructureMaster
 * @generated
 */
@ProviderType
public class SelectedCandidatePayStructureMasterWrapper
	implements SelectedCandidatePayStructureMaster,
		ModelWrapper<SelectedCandidatePayStructureMaster> {
	public SelectedCandidatePayStructureMasterWrapper(
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		_selectedCandidatePayStructureMaster = selectedCandidatePayStructureMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return SelectedCandidatePayStructureMaster.class;
	}

	@Override
	public String getModelClassName() {
		return SelectedCandidatePayStructureMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidatePayStructureMasterId",
			getCandidatePayStructureMasterId());
		attributes.put("recruitmentProcessId", getRecruitmentProcessId());
		attributes.put("totalAmount", getTotalAmount());
		attributes.put("totalBonus", getTotalBonus());
		attributes.put("payMasterStatus", getPayMasterStatus());
		attributes.put("joiningDate", getJoiningDate());
		attributes.put("candidateBond", getCandidateBond());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long candidatePayStructureMasterId = (Long)attributes.get(
				"candidatePayStructureMasterId");

		if (candidatePayStructureMasterId != null) {
			setCandidatePayStructureMasterId(candidatePayStructureMasterId);
		}

		Long recruitmentProcessId = (Long)attributes.get("recruitmentProcessId");

		if (recruitmentProcessId != null) {
			setRecruitmentProcessId(recruitmentProcessId);
		}

		Double totalAmount = (Double)attributes.get("totalAmount");

		if (totalAmount != null) {
			setTotalAmount(totalAmount);
		}

		Double totalBonus = (Double)attributes.get("totalBonus");

		if (totalBonus != null) {
			setTotalBonus(totalBonus);
		}

		Integer payMasterStatus = (Integer)attributes.get("payMasterStatus");

		if (payMasterStatus != null) {
			setPayMasterStatus(payMasterStatus);
		}

		Date joiningDate = (Date)attributes.get("joiningDate");

		if (joiningDate != null) {
			setJoiningDate(joiningDate);
		}

		String candidateBond = (String)attributes.get("candidateBond");

		if (candidateBond != null) {
			setCandidateBond(candidateBond);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public SelectedCandidatePayStructureMaster toEscapedModel() {
		return new SelectedCandidatePayStructureMasterWrapper(_selectedCandidatePayStructureMaster.toEscapedModel());
	}

	@Override
	public SelectedCandidatePayStructureMaster toUnescapedModel() {
		return new SelectedCandidatePayStructureMasterWrapper(_selectedCandidatePayStructureMaster.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _selectedCandidatePayStructureMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _selectedCandidatePayStructureMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _selectedCandidatePayStructureMaster.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _selectedCandidatePayStructureMaster.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SelectedCandidatePayStructureMaster> toCacheModel() {
		return _selectedCandidatePayStructureMaster.toCacheModel();
	}

	/**
	* Returns the total amount of this selected candidate pay structure master.
	*
	* @return the total amount of this selected candidate pay structure master
	*/
	@Override
	public double getTotalAmount() {
		return _selectedCandidatePayStructureMaster.getTotalAmount();
	}

	/**
	* Returns the total bonus of this selected candidate pay structure master.
	*
	* @return the total bonus of this selected candidate pay structure master
	*/
	@Override
	public double getTotalBonus() {
		return _selectedCandidatePayStructureMaster.getTotalBonus();
	}

	@Override
	public int compareTo(
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		return _selectedCandidatePayStructureMaster.compareTo(selectedCandidatePayStructureMaster);
	}

	/**
	* Returns the pay master status of this selected candidate pay structure master.
	*
	* @return the pay master status of this selected candidate pay structure master
	*/
	@Override
	public int getPayMasterStatus() {
		return _selectedCandidatePayStructureMaster.getPayMasterStatus();
	}

	@Override
	public int hashCode() {
		return _selectedCandidatePayStructureMaster.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _selectedCandidatePayStructureMaster.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SelectedCandidatePayStructureMasterWrapper((SelectedCandidatePayStructureMaster)_selectedCandidatePayStructureMaster.clone());
	}

	/**
	* Returns the candidate bond of this selected candidate pay structure master.
	*
	* @return the candidate bond of this selected candidate pay structure master
	*/
	@Override
	public java.lang.String getCandidateBond() {
		return _selectedCandidatePayStructureMaster.getCandidateBond();
	}

	@Override
	public java.lang.String toString() {
		return _selectedCandidatePayStructureMaster.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _selectedCandidatePayStructureMaster.toXmlString();
	}

	/**
	* Returns the create date of this selected candidate pay structure master.
	*
	* @return the create date of this selected candidate pay structure master
	*/
	@Override
	public Date getCreateDate() {
		return _selectedCandidatePayStructureMaster.getCreateDate();
	}

	/**
	* Returns the joining date of this selected candidate pay structure master.
	*
	* @return the joining date of this selected candidate pay structure master
	*/
	@Override
	public Date getJoiningDate() {
		return _selectedCandidatePayStructureMaster.getJoiningDate();
	}

	/**
	* Returns the modified date of this selected candidate pay structure master.
	*
	* @return the modified date of this selected candidate pay structure master
	*/
	@Override
	public Date getModifiedDate() {
		return _selectedCandidatePayStructureMaster.getModifiedDate();
	}

	/**
	* Returns the candidate pay structure master ID of this selected candidate pay structure master.
	*
	* @return the candidate pay structure master ID of this selected candidate pay structure master
	*/
	@Override
	public long getCandidatePayStructureMasterId() {
		return _selectedCandidatePayStructureMaster.getCandidatePayStructureMasterId();
	}

	/**
	* Returns the primary key of this selected candidate pay structure master.
	*
	* @return the primary key of this selected candidate pay structure master
	*/
	@Override
	public long getPrimaryKey() {
		return _selectedCandidatePayStructureMaster.getPrimaryKey();
	}

	/**
	* Returns the recruitment process ID of this selected candidate pay structure master.
	*
	* @return the recruitment process ID of this selected candidate pay structure master
	*/
	@Override
	public long getRecruitmentProcessId() {
		return _selectedCandidatePayStructureMaster.getRecruitmentProcessId();
	}

	@Override
	public void persist() {
		_selectedCandidatePayStructureMaster.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_selectedCandidatePayStructureMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the candidate bond of this selected candidate pay structure master.
	*
	* @param candidateBond the candidate bond of this selected candidate pay structure master
	*/
	@Override
	public void setCandidateBond(java.lang.String candidateBond) {
		_selectedCandidatePayStructureMaster.setCandidateBond(candidateBond);
	}

	/**
	* Sets the candidate pay structure master ID of this selected candidate pay structure master.
	*
	* @param candidatePayStructureMasterId the candidate pay structure master ID of this selected candidate pay structure master
	*/
	@Override
	public void setCandidatePayStructureMasterId(
		long candidatePayStructureMasterId) {
		_selectedCandidatePayStructureMaster.setCandidatePayStructureMasterId(candidatePayStructureMasterId);
	}

	/**
	* Sets the create date of this selected candidate pay structure master.
	*
	* @param createDate the create date of this selected candidate pay structure master
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_selectedCandidatePayStructureMaster.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_selectedCandidatePayStructureMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_selectedCandidatePayStructureMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_selectedCandidatePayStructureMaster.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the joining date of this selected candidate pay structure master.
	*
	* @param joiningDate the joining date of this selected candidate pay structure master
	*/
	@Override
	public void setJoiningDate(Date joiningDate) {
		_selectedCandidatePayStructureMaster.setJoiningDate(joiningDate);
	}

	/**
	* Sets the modified date of this selected candidate pay structure master.
	*
	* @param modifiedDate the modified date of this selected candidate pay structure master
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_selectedCandidatePayStructureMaster.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_selectedCandidatePayStructureMaster.setNew(n);
	}

	/**
	* Sets the pay master status of this selected candidate pay structure master.
	*
	* @param payMasterStatus the pay master status of this selected candidate pay structure master
	*/
	@Override
	public void setPayMasterStatus(int payMasterStatus) {
		_selectedCandidatePayStructureMaster.setPayMasterStatus(payMasterStatus);
	}

	/**
	* Sets the primary key of this selected candidate pay structure master.
	*
	* @param primaryKey the primary key of this selected candidate pay structure master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_selectedCandidatePayStructureMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_selectedCandidatePayStructureMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the recruitment process ID of this selected candidate pay structure master.
	*
	* @param recruitmentProcessId the recruitment process ID of this selected candidate pay structure master
	*/
	@Override
	public void setRecruitmentProcessId(long recruitmentProcessId) {
		_selectedCandidatePayStructureMaster.setRecruitmentProcessId(recruitmentProcessId);
	}

	/**
	* Sets the total amount of this selected candidate pay structure master.
	*
	* @param totalAmount the total amount of this selected candidate pay structure master
	*/
	@Override
	public void setTotalAmount(double totalAmount) {
		_selectedCandidatePayStructureMaster.setTotalAmount(totalAmount);
	}

	/**
	* Sets the total bonus of this selected candidate pay structure master.
	*
	* @param totalBonus the total bonus of this selected candidate pay structure master
	*/
	@Override
	public void setTotalBonus(double totalBonus) {
		_selectedCandidatePayStructureMaster.setTotalBonus(totalBonus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SelectedCandidatePayStructureMasterWrapper)) {
			return false;
		}

		SelectedCandidatePayStructureMasterWrapper selectedCandidatePayStructureMasterWrapper =
			(SelectedCandidatePayStructureMasterWrapper)obj;

		if (Objects.equals(_selectedCandidatePayStructureMaster,
					selectedCandidatePayStructureMasterWrapper._selectedCandidatePayStructureMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public SelectedCandidatePayStructureMaster getWrappedModel() {
		return _selectedCandidatePayStructureMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _selectedCandidatePayStructureMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _selectedCandidatePayStructureMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_selectedCandidatePayStructureMaster.resetOriginalValues();
	}

	private final SelectedCandidatePayStructureMaster _selectedCandidatePayStructureMaster;
}