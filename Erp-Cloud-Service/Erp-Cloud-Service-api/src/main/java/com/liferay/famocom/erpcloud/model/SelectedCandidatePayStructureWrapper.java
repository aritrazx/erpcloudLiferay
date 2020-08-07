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
 * This class is a wrapper for {@link SelectedCandidatePayStructure}.
 * </p>
 *
 * @author Samaresh
 * @see SelectedCandidatePayStructure
 * @generated
 */
@ProviderType
public class SelectedCandidatePayStructureWrapper
	implements SelectedCandidatePayStructure,
		ModelWrapper<SelectedCandidatePayStructure> {
	public SelectedCandidatePayStructureWrapper(
		SelectedCandidatePayStructure selectedCandidatePayStructure) {
		_selectedCandidatePayStructure = selectedCandidatePayStructure;
	}

	@Override
	public Class<?> getModelClass() {
		return SelectedCandidatePayStructure.class;
	}

	@Override
	public String getModelClassName() {
		return SelectedCandidatePayStructure.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidatePayStructureId", getCandidatePayStructureId());
		attributes.put("payComponentId", getPayComponentId());
		attributes.put("componentValue", getComponentValue());
		attributes.put("recruitmentProcessId", getRecruitmentProcessId());
		attributes.put("payStatus", getPayStatus());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long candidatePayStructureId = (Long)attributes.get(
				"candidatePayStructureId");

		if (candidatePayStructureId != null) {
			setCandidatePayStructureId(candidatePayStructureId);
		}

		Long payComponentId = (Long)attributes.get("payComponentId");

		if (payComponentId != null) {
			setPayComponentId(payComponentId);
		}

		Double componentValue = (Double)attributes.get("componentValue");

		if (componentValue != null) {
			setComponentValue(componentValue);
		}

		Long recruitmentProcessId = (Long)attributes.get("recruitmentProcessId");

		if (recruitmentProcessId != null) {
			setRecruitmentProcessId(recruitmentProcessId);
		}

		Integer payStatus = (Integer)attributes.get("payStatus");

		if (payStatus != null) {
			setPayStatus(payStatus);
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
		return new SelectedCandidatePayStructureWrapper((SelectedCandidatePayStructure)_selectedCandidatePayStructure.clone());
	}

	@Override
	public int compareTo(
		SelectedCandidatePayStructure selectedCandidatePayStructure) {
		return _selectedCandidatePayStructure.compareTo(selectedCandidatePayStructure);
	}

	/**
	* Returns the candidate pay structure ID of this selected candidate pay structure.
	*
	* @return the candidate pay structure ID of this selected candidate pay structure
	*/
	@Override
	public long getCandidatePayStructureId() {
		return _selectedCandidatePayStructure.getCandidatePayStructureId();
	}

	/**
	* Returns the component value of this selected candidate pay structure.
	*
	* @return the component value of this selected candidate pay structure
	*/
	@Override
	public double getComponentValue() {
		return _selectedCandidatePayStructure.getComponentValue();
	}

	/**
	* Returns the create date of this selected candidate pay structure.
	*
	* @return the create date of this selected candidate pay structure
	*/
	@Override
	public Date getCreateDate() {
		return _selectedCandidatePayStructure.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _selectedCandidatePayStructure.getExpandoBridge();
	}

	/**
	* Returns the modified date of this selected candidate pay structure.
	*
	* @return the modified date of this selected candidate pay structure
	*/
	@Override
	public Date getModifiedDate() {
		return _selectedCandidatePayStructure.getModifiedDate();
	}

	/**
	* Returns the pay component ID of this selected candidate pay structure.
	*
	* @return the pay component ID of this selected candidate pay structure
	*/
	@Override
	public long getPayComponentId() {
		return _selectedCandidatePayStructure.getPayComponentId();
	}

	/**
	* Returns the pay status of this selected candidate pay structure.
	*
	* @return the pay status of this selected candidate pay structure
	*/
	@Override
	public int getPayStatus() {
		return _selectedCandidatePayStructure.getPayStatus();
	}

	/**
	* Returns the primary key of this selected candidate pay structure.
	*
	* @return the primary key of this selected candidate pay structure
	*/
	@Override
	public long getPrimaryKey() {
		return _selectedCandidatePayStructure.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _selectedCandidatePayStructure.getPrimaryKeyObj();
	}

	/**
	* Returns the recruitment process ID of this selected candidate pay structure.
	*
	* @return the recruitment process ID of this selected candidate pay structure
	*/
	@Override
	public long getRecruitmentProcessId() {
		return _selectedCandidatePayStructure.getRecruitmentProcessId();
	}

	@Override
	public int hashCode() {
		return _selectedCandidatePayStructure.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _selectedCandidatePayStructure.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _selectedCandidatePayStructure.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _selectedCandidatePayStructure.isNew();
	}

	@Override
	public void persist() {
		_selectedCandidatePayStructure.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_selectedCandidatePayStructure.setCachedModel(cachedModel);
	}

	/**
	* Sets the candidate pay structure ID of this selected candidate pay structure.
	*
	* @param candidatePayStructureId the candidate pay structure ID of this selected candidate pay structure
	*/
	@Override
	public void setCandidatePayStructureId(long candidatePayStructureId) {
		_selectedCandidatePayStructure.setCandidatePayStructureId(candidatePayStructureId);
	}

	/**
	* Sets the component value of this selected candidate pay structure.
	*
	* @param componentValue the component value of this selected candidate pay structure
	*/
	@Override
	public void setComponentValue(double componentValue) {
		_selectedCandidatePayStructure.setComponentValue(componentValue);
	}

	/**
	* Sets the create date of this selected candidate pay structure.
	*
	* @param createDate the create date of this selected candidate pay structure
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_selectedCandidatePayStructure.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_selectedCandidatePayStructure.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_selectedCandidatePayStructure.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_selectedCandidatePayStructure.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this selected candidate pay structure.
	*
	* @param modifiedDate the modified date of this selected candidate pay structure
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_selectedCandidatePayStructure.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_selectedCandidatePayStructure.setNew(n);
	}

	/**
	* Sets the pay component ID of this selected candidate pay structure.
	*
	* @param payComponentId the pay component ID of this selected candidate pay structure
	*/
	@Override
	public void setPayComponentId(long payComponentId) {
		_selectedCandidatePayStructure.setPayComponentId(payComponentId);
	}

	/**
	* Sets the pay status of this selected candidate pay structure.
	*
	* @param payStatus the pay status of this selected candidate pay structure
	*/
	@Override
	public void setPayStatus(int payStatus) {
		_selectedCandidatePayStructure.setPayStatus(payStatus);
	}

	/**
	* Sets the primary key of this selected candidate pay structure.
	*
	* @param primaryKey the primary key of this selected candidate pay structure
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_selectedCandidatePayStructure.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_selectedCandidatePayStructure.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the recruitment process ID of this selected candidate pay structure.
	*
	* @param recruitmentProcessId the recruitment process ID of this selected candidate pay structure
	*/
	@Override
	public void setRecruitmentProcessId(long recruitmentProcessId) {
		_selectedCandidatePayStructure.setRecruitmentProcessId(recruitmentProcessId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SelectedCandidatePayStructure> toCacheModel() {
		return _selectedCandidatePayStructure.toCacheModel();
	}

	@Override
	public SelectedCandidatePayStructure toEscapedModel() {
		return new SelectedCandidatePayStructureWrapper(_selectedCandidatePayStructure.toEscapedModel());
	}

	@Override
	public String toString() {
		return _selectedCandidatePayStructure.toString();
	}

	@Override
	public SelectedCandidatePayStructure toUnescapedModel() {
		return new SelectedCandidatePayStructureWrapper(_selectedCandidatePayStructure.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _selectedCandidatePayStructure.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SelectedCandidatePayStructureWrapper)) {
			return false;
		}

		SelectedCandidatePayStructureWrapper selectedCandidatePayStructureWrapper =
			(SelectedCandidatePayStructureWrapper)obj;

		if (Objects.equals(_selectedCandidatePayStructure,
					selectedCandidatePayStructureWrapper._selectedCandidatePayStructure)) {
			return true;
		}

		return false;
	}

	@Override
	public SelectedCandidatePayStructure getWrappedModel() {
		return _selectedCandidatePayStructure;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _selectedCandidatePayStructure.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _selectedCandidatePayStructure.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_selectedCandidatePayStructure.resetOriginalValues();
	}

	private final SelectedCandidatePayStructure _selectedCandidatePayStructure;
}