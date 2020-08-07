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
 * This class is a wrapper for {@link CandidatePayStructureMaster}.
 * </p>
 *
 * @author Samaresh
 * @see CandidatePayStructureMaster
 * @generated
 */
@ProviderType
public class CandidatePayStructureMasterWrapper
	implements CandidatePayStructureMaster,
		ModelWrapper<CandidatePayStructureMaster> {
	public CandidatePayStructureMasterWrapper(
		CandidatePayStructureMaster candidatePayStructureMaster) {
		_candidatePayStructureMaster = candidatePayStructureMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return CandidatePayStructureMaster.class;
	}

	@Override
	public String getModelClassName() {
		return CandidatePayStructureMaster.class.getName();
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
	public Object clone() {
		return new CandidatePayStructureMasterWrapper((CandidatePayStructureMaster)_candidatePayStructureMaster.clone());
	}

	@Override
	public int compareTo(
		CandidatePayStructureMaster candidatePayStructureMaster) {
		return _candidatePayStructureMaster.compareTo(candidatePayStructureMaster);
	}

	/**
	* Returns the candidate bond of this candidate pay structure master.
	*
	* @return the candidate bond of this candidate pay structure master
	*/
	@Override
	public String getCandidateBond() {
		return _candidatePayStructureMaster.getCandidateBond();
	}

	/**
	* Returns the candidate pay structure master ID of this candidate pay structure master.
	*
	* @return the candidate pay structure master ID of this candidate pay structure master
	*/
	@Override
	public long getCandidatePayStructureMasterId() {
		return _candidatePayStructureMaster.getCandidatePayStructureMasterId();
	}

	/**
	* Returns the create date of this candidate pay structure master.
	*
	* @return the create date of this candidate pay structure master
	*/
	@Override
	public Date getCreateDate() {
		return _candidatePayStructureMaster.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _candidatePayStructureMaster.getExpandoBridge();
	}

	/**
	* Returns the joining date of this candidate pay structure master.
	*
	* @return the joining date of this candidate pay structure master
	*/
	@Override
	public Date getJoiningDate() {
		return _candidatePayStructureMaster.getJoiningDate();
	}

	/**
	* Returns the modified date of this candidate pay structure master.
	*
	* @return the modified date of this candidate pay structure master
	*/
	@Override
	public Date getModifiedDate() {
		return _candidatePayStructureMaster.getModifiedDate();
	}

	/**
	* Returns the pay master status of this candidate pay structure master.
	*
	* @return the pay master status of this candidate pay structure master
	*/
	@Override
	public int getPayMasterStatus() {
		return _candidatePayStructureMaster.getPayMasterStatus();
	}

	/**
	* Returns the primary key of this candidate pay structure master.
	*
	* @return the primary key of this candidate pay structure master
	*/
	@Override
	public long getPrimaryKey() {
		return _candidatePayStructureMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidatePayStructureMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the recruitment process ID of this candidate pay structure master.
	*
	* @return the recruitment process ID of this candidate pay structure master
	*/
	@Override
	public long getRecruitmentProcessId() {
		return _candidatePayStructureMaster.getRecruitmentProcessId();
	}

	/**
	* Returns the total amount of this candidate pay structure master.
	*
	* @return the total amount of this candidate pay structure master
	*/
	@Override
	public double getTotalAmount() {
		return _candidatePayStructureMaster.getTotalAmount();
	}

	/**
	* Returns the total bonus of this candidate pay structure master.
	*
	* @return the total bonus of this candidate pay structure master
	*/
	@Override
	public double getTotalBonus() {
		return _candidatePayStructureMaster.getTotalBonus();
	}

	@Override
	public int hashCode() {
		return _candidatePayStructureMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _candidatePayStructureMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _candidatePayStructureMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _candidatePayStructureMaster.isNew();
	}

	@Override
	public void persist() {
		_candidatePayStructureMaster.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_candidatePayStructureMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the candidate bond of this candidate pay structure master.
	*
	* @param candidateBond the candidate bond of this candidate pay structure master
	*/
	@Override
	public void setCandidateBond(String candidateBond) {
		_candidatePayStructureMaster.setCandidateBond(candidateBond);
	}

	/**
	* Sets the candidate pay structure master ID of this candidate pay structure master.
	*
	* @param candidatePayStructureMasterId the candidate pay structure master ID of this candidate pay structure master
	*/
	@Override
	public void setCandidatePayStructureMasterId(
		long candidatePayStructureMasterId) {
		_candidatePayStructureMaster.setCandidatePayStructureMasterId(candidatePayStructureMasterId);
	}

	/**
	* Sets the create date of this candidate pay structure master.
	*
	* @param createDate the create date of this candidate pay structure master
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_candidatePayStructureMaster.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_candidatePayStructureMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_candidatePayStructureMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_candidatePayStructureMaster.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the joining date of this candidate pay structure master.
	*
	* @param joiningDate the joining date of this candidate pay structure master
	*/
	@Override
	public void setJoiningDate(Date joiningDate) {
		_candidatePayStructureMaster.setJoiningDate(joiningDate);
	}

	/**
	* Sets the modified date of this candidate pay structure master.
	*
	* @param modifiedDate the modified date of this candidate pay structure master
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_candidatePayStructureMaster.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_candidatePayStructureMaster.setNew(n);
	}

	/**
	* Sets the pay master status of this candidate pay structure master.
	*
	* @param payMasterStatus the pay master status of this candidate pay structure master
	*/
	@Override
	public void setPayMasterStatus(int payMasterStatus) {
		_candidatePayStructureMaster.setPayMasterStatus(payMasterStatus);
	}

	/**
	* Sets the primary key of this candidate pay structure master.
	*
	* @param primaryKey the primary key of this candidate pay structure master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_candidatePayStructureMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_candidatePayStructureMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the recruitment process ID of this candidate pay structure master.
	*
	* @param recruitmentProcessId the recruitment process ID of this candidate pay structure master
	*/
	@Override
	public void setRecruitmentProcessId(long recruitmentProcessId) {
		_candidatePayStructureMaster.setRecruitmentProcessId(recruitmentProcessId);
	}

	/**
	* Sets the total amount of this candidate pay structure master.
	*
	* @param totalAmount the total amount of this candidate pay structure master
	*/
	@Override
	public void setTotalAmount(double totalAmount) {
		_candidatePayStructureMaster.setTotalAmount(totalAmount);
	}

	/**
	* Sets the total bonus of this candidate pay structure master.
	*
	* @param totalBonus the total bonus of this candidate pay structure master
	*/
	@Override
	public void setTotalBonus(double totalBonus) {
		_candidatePayStructureMaster.setTotalBonus(totalBonus);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CandidatePayStructureMaster> toCacheModel() {
		return _candidatePayStructureMaster.toCacheModel();
	}

	@Override
	public CandidatePayStructureMaster toEscapedModel() {
		return new CandidatePayStructureMasterWrapper(_candidatePayStructureMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _candidatePayStructureMaster.toString();
	}

	@Override
	public CandidatePayStructureMaster toUnescapedModel() {
		return new CandidatePayStructureMasterWrapper(_candidatePayStructureMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _candidatePayStructureMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidatePayStructureMasterWrapper)) {
			return false;
		}

		CandidatePayStructureMasterWrapper candidatePayStructureMasterWrapper = (CandidatePayStructureMasterWrapper)obj;

		if (Objects.equals(_candidatePayStructureMaster,
					candidatePayStructureMasterWrapper._candidatePayStructureMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public CandidatePayStructureMaster getWrappedModel() {
		return _candidatePayStructureMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _candidatePayStructureMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _candidatePayStructureMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_candidatePayStructureMaster.resetOriginalValues();
	}

	private final CandidatePayStructureMaster _candidatePayStructureMaster;
}