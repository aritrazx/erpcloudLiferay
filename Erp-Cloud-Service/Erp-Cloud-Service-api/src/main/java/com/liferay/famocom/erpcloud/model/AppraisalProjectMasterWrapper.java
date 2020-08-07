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
 * This class is a wrapper for {@link AppraisalProjectMaster}.
 * </p>
 *
 * @author Samaresh
 * @see AppraisalProjectMaster
 * @generated
 */
@ProviderType
public class AppraisalProjectMasterWrapper implements AppraisalProjectMaster,
	ModelWrapper<AppraisalProjectMaster> {
	public AppraisalProjectMasterWrapper(
		AppraisalProjectMaster appraisalProjectMaster) {
		_appraisalProjectMaster = appraisalProjectMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return AppraisalProjectMaster.class;
	}

	@Override
	public String getModelClassName() {
		return AppraisalProjectMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("appraisalProjectId", getAppraisalProjectId());
		attributes.put("companyId", getCompanyId());
		attributes.put("appraisalId", getAppraisalId());
		attributes.put("appraisalSettingId", getAppraisalSettingId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("projectId", getProjectId());
		attributes.put("projectDescription", getProjectDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("submitStep", getSubmitStep());
		attributes.put("addedDate", getAddedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long appraisalProjectId = (Long)attributes.get("appraisalProjectId");

		if (appraisalProjectId != null) {
			setAppraisalProjectId(appraisalProjectId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long appraisalId = (Long)attributes.get("appraisalId");

		if (appraisalId != null) {
			setAppraisalId(appraisalId);
		}

		Long appraisalSettingId = (Long)attributes.get("appraisalSettingId");

		if (appraisalSettingId != null) {
			setAppraisalSettingId(appraisalSettingId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String projectDescription = (String)attributes.get("projectDescription");

		if (projectDescription != null) {
			setProjectDescription(projectDescription);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long submitStep = (Long)attributes.get("submitStep");

		if (submitStep != null) {
			setSubmitStep(submitStep);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public Object clone() {
		return new AppraisalProjectMasterWrapper((AppraisalProjectMaster)_appraisalProjectMaster.clone());
	}

	@Override
	public int compareTo(AppraisalProjectMaster appraisalProjectMaster) {
		return _appraisalProjectMaster.compareTo(appraisalProjectMaster);
	}

	/**
	* Returns the added date of this appraisal project master.
	*
	* @return the added date of this appraisal project master
	*/
	@Override
	public Date getAddedDate() {
		return _appraisalProjectMaster.getAddedDate();
	}

	/**
	* Returns the appraisal ID of this appraisal project master.
	*
	* @return the appraisal ID of this appraisal project master
	*/
	@Override
	public long getAppraisalId() {
		return _appraisalProjectMaster.getAppraisalId();
	}

	/**
	* Returns the appraisal project ID of this appraisal project master.
	*
	* @return the appraisal project ID of this appraisal project master
	*/
	@Override
	public long getAppraisalProjectId() {
		return _appraisalProjectMaster.getAppraisalProjectId();
	}

	/**
	* Returns the appraisal setting ID of this appraisal project master.
	*
	* @return the appraisal setting ID of this appraisal project master
	*/
	@Override
	public long getAppraisalSettingId() {
		return _appraisalProjectMaster.getAppraisalSettingId();
	}

	/**
	* Returns the company ID of this appraisal project master.
	*
	* @return the company ID of this appraisal project master
	*/
	@Override
	public long getCompanyId() {
		return _appraisalProjectMaster.getCompanyId();
	}

	/**
	* Returns the created by of this appraisal project master.
	*
	* @return the created by of this appraisal project master
	*/
	@Override
	public long getCreatedBy() {
		return _appraisalProjectMaster.getCreatedBy();
	}

	/**
	* Returns the employee ID of this appraisal project master.
	*
	* @return the employee ID of this appraisal project master
	*/
	@Override
	public long getEmployeeId() {
		return _appraisalProjectMaster.getEmployeeId();
	}

	/**
	* Returns the end date of this appraisal project master.
	*
	* @return the end date of this appraisal project master
	*/
	@Override
	public Date getEndDate() {
		return _appraisalProjectMaster.getEndDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _appraisalProjectMaster.getExpandoBridge();
	}

	/**
	* Returns the modified by of this appraisal project master.
	*
	* @return the modified by of this appraisal project master
	*/
	@Override
	public long getModifiedBy() {
		return _appraisalProjectMaster.getModifiedBy();
	}

	/**
	* Returns the modified date of this appraisal project master.
	*
	* @return the modified date of this appraisal project master
	*/
	@Override
	public Date getModifiedDate() {
		return _appraisalProjectMaster.getModifiedDate();
	}

	/**
	* Returns the primary key of this appraisal project master.
	*
	* @return the primary key of this appraisal project master
	*/
	@Override
	public long getPrimaryKey() {
		return _appraisalProjectMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _appraisalProjectMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the project description of this appraisal project master.
	*
	* @return the project description of this appraisal project master
	*/
	@Override
	public String getProjectDescription() {
		return _appraisalProjectMaster.getProjectDescription();
	}

	/**
	* Returns the project ID of this appraisal project master.
	*
	* @return the project ID of this appraisal project master
	*/
	@Override
	public long getProjectId() {
		return _appraisalProjectMaster.getProjectId();
	}

	/**
	* Returns the start date of this appraisal project master.
	*
	* @return the start date of this appraisal project master
	*/
	@Override
	public Date getStartDate() {
		return _appraisalProjectMaster.getStartDate();
	}

	/**
	* Returns the submit step of this appraisal project master.
	*
	* @return the submit step of this appraisal project master
	*/
	@Override
	public long getSubmitStep() {
		return _appraisalProjectMaster.getSubmitStep();
	}

	@Override
	public int hashCode() {
		return _appraisalProjectMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _appraisalProjectMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _appraisalProjectMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _appraisalProjectMaster.isNew();
	}

	@Override
	public void persist() {
		_appraisalProjectMaster.persist();
	}

	/**
	* Sets the added date of this appraisal project master.
	*
	* @param addedDate the added date of this appraisal project master
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_appraisalProjectMaster.setAddedDate(addedDate);
	}

	/**
	* Sets the appraisal ID of this appraisal project master.
	*
	* @param appraisalId the appraisal ID of this appraisal project master
	*/
	@Override
	public void setAppraisalId(long appraisalId) {
		_appraisalProjectMaster.setAppraisalId(appraisalId);
	}

	/**
	* Sets the appraisal project ID of this appraisal project master.
	*
	* @param appraisalProjectId the appraisal project ID of this appraisal project master
	*/
	@Override
	public void setAppraisalProjectId(long appraisalProjectId) {
		_appraisalProjectMaster.setAppraisalProjectId(appraisalProjectId);
	}

	/**
	* Sets the appraisal setting ID of this appraisal project master.
	*
	* @param appraisalSettingId the appraisal setting ID of this appraisal project master
	*/
	@Override
	public void setAppraisalSettingId(long appraisalSettingId) {
		_appraisalProjectMaster.setAppraisalSettingId(appraisalSettingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_appraisalProjectMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this appraisal project master.
	*
	* @param companyId the company ID of this appraisal project master
	*/
	@Override
	public void setCompanyId(long companyId) {
		_appraisalProjectMaster.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this appraisal project master.
	*
	* @param createdBy the created by of this appraisal project master
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_appraisalProjectMaster.setCreatedBy(createdBy);
	}

	/**
	* Sets the employee ID of this appraisal project master.
	*
	* @param employeeId the employee ID of this appraisal project master
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_appraisalProjectMaster.setEmployeeId(employeeId);
	}

	/**
	* Sets the end date of this appraisal project master.
	*
	* @param endDate the end date of this appraisal project master
	*/
	@Override
	public void setEndDate(Date endDate) {
		_appraisalProjectMaster.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_appraisalProjectMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_appraisalProjectMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_appraisalProjectMaster.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this appraisal project master.
	*
	* @param modifiedBy the modified by of this appraisal project master
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_appraisalProjectMaster.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this appraisal project master.
	*
	* @param modifiedDate the modified date of this appraisal project master
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_appraisalProjectMaster.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_appraisalProjectMaster.setNew(n);
	}

	/**
	* Sets the primary key of this appraisal project master.
	*
	* @param primaryKey the primary key of this appraisal project master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_appraisalProjectMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_appraisalProjectMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project description of this appraisal project master.
	*
	* @param projectDescription the project description of this appraisal project master
	*/
	@Override
	public void setProjectDescription(String projectDescription) {
		_appraisalProjectMaster.setProjectDescription(projectDescription);
	}

	/**
	* Sets the project ID of this appraisal project master.
	*
	* @param projectId the project ID of this appraisal project master
	*/
	@Override
	public void setProjectId(long projectId) {
		_appraisalProjectMaster.setProjectId(projectId);
	}

	/**
	* Sets the start date of this appraisal project master.
	*
	* @param startDate the start date of this appraisal project master
	*/
	@Override
	public void setStartDate(Date startDate) {
		_appraisalProjectMaster.setStartDate(startDate);
	}

	/**
	* Sets the submit step of this appraisal project master.
	*
	* @param submitStep the submit step of this appraisal project master
	*/
	@Override
	public void setSubmitStep(long submitStep) {
		_appraisalProjectMaster.setSubmitStep(submitStep);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AppraisalProjectMaster> toCacheModel() {
		return _appraisalProjectMaster.toCacheModel();
	}

	@Override
	public AppraisalProjectMaster toEscapedModel() {
		return new AppraisalProjectMasterWrapper(_appraisalProjectMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _appraisalProjectMaster.toString();
	}

	@Override
	public AppraisalProjectMaster toUnescapedModel() {
		return new AppraisalProjectMasterWrapper(_appraisalProjectMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _appraisalProjectMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalProjectMasterWrapper)) {
			return false;
		}

		AppraisalProjectMasterWrapper appraisalProjectMasterWrapper = (AppraisalProjectMasterWrapper)obj;

		if (Objects.equals(_appraisalProjectMaster,
					appraisalProjectMasterWrapper._appraisalProjectMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public AppraisalProjectMaster getWrappedModel() {
		return _appraisalProjectMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _appraisalProjectMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _appraisalProjectMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_appraisalProjectMaster.resetOriginalValues();
	}

	private final AppraisalProjectMaster _appraisalProjectMaster;
}