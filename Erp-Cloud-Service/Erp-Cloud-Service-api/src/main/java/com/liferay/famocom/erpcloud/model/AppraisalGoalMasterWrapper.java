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
 * This class is a wrapper for {@link AppraisalGoalMaster}.
 * </p>
 *
 * @author Samaresh
 * @see AppraisalGoalMaster
 * @generated
 */
@ProviderType
public class AppraisalGoalMasterWrapper implements AppraisalGoalMaster,
	ModelWrapper<AppraisalGoalMaster> {
	public AppraisalGoalMasterWrapper(AppraisalGoalMaster appraisalGoalMaster) {
		_appraisalGoalMaster = appraisalGoalMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return AppraisalGoalMaster.class;
	}

	@Override
	public String getModelClassName() {
		return AppraisalGoalMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("appraisalGoalMasterId", getAppraisalGoalMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("appraisalId", getAppraisalId());
		attributes.put("appraisalProjectId", getAppraisalProjectId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("projectId", getProjectId());
		attributes.put("evaluationId", getEvaluationId());
		attributes.put("employeeComment", getEmployeeComment());
		attributes.put("employeeOverallRat", getEmployeeOverallRat());
		attributes.put("managerComment", getManagerComment());
		attributes.put("managerOverallRat", getManagerOverallRat());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long appraisalGoalMasterId = (Long)attributes.get(
				"appraisalGoalMasterId");

		if (appraisalGoalMasterId != null) {
			setAppraisalGoalMasterId(appraisalGoalMasterId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long appraisalId = (Long)attributes.get("appraisalId");

		if (appraisalId != null) {
			setAppraisalId(appraisalId);
		}

		Long appraisalProjectId = (Long)attributes.get("appraisalProjectId");

		if (appraisalProjectId != null) {
			setAppraisalProjectId(appraisalProjectId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long evaluationId = (Long)attributes.get("evaluationId");

		if (evaluationId != null) {
			setEvaluationId(evaluationId);
		}

		String employeeComment = (String)attributes.get("employeeComment");

		if (employeeComment != null) {
			setEmployeeComment(employeeComment);
		}

		Long employeeOverallRat = (Long)attributes.get("employeeOverallRat");

		if (employeeOverallRat != null) {
			setEmployeeOverallRat(employeeOverallRat);
		}

		String managerComment = (String)attributes.get("managerComment");

		if (managerComment != null) {
			setManagerComment(managerComment);
		}

		Long managerOverallRat = (Long)attributes.get("managerOverallRat");

		if (managerOverallRat != null) {
			setManagerOverallRat(managerOverallRat);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
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
		return new AppraisalGoalMasterWrapper((AppraisalGoalMaster)_appraisalGoalMaster.clone());
	}

	@Override
	public int compareTo(AppraisalGoalMaster appraisalGoalMaster) {
		return _appraisalGoalMaster.compareTo(appraisalGoalMaster);
	}

	/**
	* Returns the appraisal goal master ID of this appraisal goal master.
	*
	* @return the appraisal goal master ID of this appraisal goal master
	*/
	@Override
	public long getAppraisalGoalMasterId() {
		return _appraisalGoalMaster.getAppraisalGoalMasterId();
	}

	/**
	* Returns the appraisal ID of this appraisal goal master.
	*
	* @return the appraisal ID of this appraisal goal master
	*/
	@Override
	public long getAppraisalId() {
		return _appraisalGoalMaster.getAppraisalId();
	}

	/**
	* Returns the appraisal project ID of this appraisal goal master.
	*
	* @return the appraisal project ID of this appraisal goal master
	*/
	@Override
	public long getAppraisalProjectId() {
		return _appraisalGoalMaster.getAppraisalProjectId();
	}

	/**
	* Returns the company ID of this appraisal goal master.
	*
	* @return the company ID of this appraisal goal master
	*/
	@Override
	public long getCompanyId() {
		return _appraisalGoalMaster.getCompanyId();
	}

	/**
	* Returns the created by of this appraisal goal master.
	*
	* @return the created by of this appraisal goal master
	*/
	@Override
	public long getCreatedBy() {
		return _appraisalGoalMaster.getCreatedBy();
	}

	/**
	* Returns the created date of this appraisal goal master.
	*
	* @return the created date of this appraisal goal master
	*/
	@Override
	public Date getCreatedDate() {
		return _appraisalGoalMaster.getCreatedDate();
	}

	/**
	* Returns the employee comment of this appraisal goal master.
	*
	* @return the employee comment of this appraisal goal master
	*/
	@Override
	public String getEmployeeComment() {
		return _appraisalGoalMaster.getEmployeeComment();
	}

	/**
	* Returns the employee ID of this appraisal goal master.
	*
	* @return the employee ID of this appraisal goal master
	*/
	@Override
	public long getEmployeeId() {
		return _appraisalGoalMaster.getEmployeeId();
	}

	/**
	* Returns the employee overall rat of this appraisal goal master.
	*
	* @return the employee overall rat of this appraisal goal master
	*/
	@Override
	public long getEmployeeOverallRat() {
		return _appraisalGoalMaster.getEmployeeOverallRat();
	}

	/**
	* Returns the evaluation ID of this appraisal goal master.
	*
	* @return the evaluation ID of this appraisal goal master
	*/
	@Override
	public long getEvaluationId() {
		return _appraisalGoalMaster.getEvaluationId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _appraisalGoalMaster.getExpandoBridge();
	}

	/**
	* Returns the manager comment of this appraisal goal master.
	*
	* @return the manager comment of this appraisal goal master
	*/
	@Override
	public String getManagerComment() {
		return _appraisalGoalMaster.getManagerComment();
	}

	/**
	* Returns the manager overall rat of this appraisal goal master.
	*
	* @return the manager overall rat of this appraisal goal master
	*/
	@Override
	public long getManagerOverallRat() {
		return _appraisalGoalMaster.getManagerOverallRat();
	}

	/**
	* Returns the modified by of this appraisal goal master.
	*
	* @return the modified by of this appraisal goal master
	*/
	@Override
	public long getModifiedBy() {
		return _appraisalGoalMaster.getModifiedBy();
	}

	/**
	* Returns the modified date of this appraisal goal master.
	*
	* @return the modified date of this appraisal goal master
	*/
	@Override
	public Date getModifiedDate() {
		return _appraisalGoalMaster.getModifiedDate();
	}

	/**
	* Returns the primary key of this appraisal goal master.
	*
	* @return the primary key of this appraisal goal master
	*/
	@Override
	public long getPrimaryKey() {
		return _appraisalGoalMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _appraisalGoalMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this appraisal goal master.
	*
	* @return the project ID of this appraisal goal master
	*/
	@Override
	public long getProjectId() {
		return _appraisalGoalMaster.getProjectId();
	}

	@Override
	public int hashCode() {
		return _appraisalGoalMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _appraisalGoalMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _appraisalGoalMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _appraisalGoalMaster.isNew();
	}

	@Override
	public void persist() {
		_appraisalGoalMaster.persist();
	}

	/**
	* Sets the appraisal goal master ID of this appraisal goal master.
	*
	* @param appraisalGoalMasterId the appraisal goal master ID of this appraisal goal master
	*/
	@Override
	public void setAppraisalGoalMasterId(long appraisalGoalMasterId) {
		_appraisalGoalMaster.setAppraisalGoalMasterId(appraisalGoalMasterId);
	}

	/**
	* Sets the appraisal ID of this appraisal goal master.
	*
	* @param appraisalId the appraisal ID of this appraisal goal master
	*/
	@Override
	public void setAppraisalId(long appraisalId) {
		_appraisalGoalMaster.setAppraisalId(appraisalId);
	}

	/**
	* Sets the appraisal project ID of this appraisal goal master.
	*
	* @param appraisalProjectId the appraisal project ID of this appraisal goal master
	*/
	@Override
	public void setAppraisalProjectId(long appraisalProjectId) {
		_appraisalGoalMaster.setAppraisalProjectId(appraisalProjectId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_appraisalGoalMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this appraisal goal master.
	*
	* @param companyId the company ID of this appraisal goal master
	*/
	@Override
	public void setCompanyId(long companyId) {
		_appraisalGoalMaster.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this appraisal goal master.
	*
	* @param createdBy the created by of this appraisal goal master
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_appraisalGoalMaster.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this appraisal goal master.
	*
	* @param createdDate the created date of this appraisal goal master
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_appraisalGoalMaster.setCreatedDate(createdDate);
	}

	/**
	* Sets the employee comment of this appraisal goal master.
	*
	* @param employeeComment the employee comment of this appraisal goal master
	*/
	@Override
	public void setEmployeeComment(String employeeComment) {
		_appraisalGoalMaster.setEmployeeComment(employeeComment);
	}

	/**
	* Sets the employee ID of this appraisal goal master.
	*
	* @param employeeId the employee ID of this appraisal goal master
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_appraisalGoalMaster.setEmployeeId(employeeId);
	}

	/**
	* Sets the employee overall rat of this appraisal goal master.
	*
	* @param employeeOverallRat the employee overall rat of this appraisal goal master
	*/
	@Override
	public void setEmployeeOverallRat(long employeeOverallRat) {
		_appraisalGoalMaster.setEmployeeOverallRat(employeeOverallRat);
	}

	/**
	* Sets the evaluation ID of this appraisal goal master.
	*
	* @param evaluationId the evaluation ID of this appraisal goal master
	*/
	@Override
	public void setEvaluationId(long evaluationId) {
		_appraisalGoalMaster.setEvaluationId(evaluationId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_appraisalGoalMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_appraisalGoalMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_appraisalGoalMaster.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the manager comment of this appraisal goal master.
	*
	* @param managerComment the manager comment of this appraisal goal master
	*/
	@Override
	public void setManagerComment(String managerComment) {
		_appraisalGoalMaster.setManagerComment(managerComment);
	}

	/**
	* Sets the manager overall rat of this appraisal goal master.
	*
	* @param managerOverallRat the manager overall rat of this appraisal goal master
	*/
	@Override
	public void setManagerOverallRat(long managerOverallRat) {
		_appraisalGoalMaster.setManagerOverallRat(managerOverallRat);
	}

	/**
	* Sets the modified by of this appraisal goal master.
	*
	* @param modifiedBy the modified by of this appraisal goal master
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_appraisalGoalMaster.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this appraisal goal master.
	*
	* @param modifiedDate the modified date of this appraisal goal master
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_appraisalGoalMaster.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_appraisalGoalMaster.setNew(n);
	}

	/**
	* Sets the primary key of this appraisal goal master.
	*
	* @param primaryKey the primary key of this appraisal goal master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_appraisalGoalMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_appraisalGoalMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this appraisal goal master.
	*
	* @param projectId the project ID of this appraisal goal master
	*/
	@Override
	public void setProjectId(long projectId) {
		_appraisalGoalMaster.setProjectId(projectId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AppraisalGoalMaster> toCacheModel() {
		return _appraisalGoalMaster.toCacheModel();
	}

	@Override
	public AppraisalGoalMaster toEscapedModel() {
		return new AppraisalGoalMasterWrapper(_appraisalGoalMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _appraisalGoalMaster.toString();
	}

	@Override
	public AppraisalGoalMaster toUnescapedModel() {
		return new AppraisalGoalMasterWrapper(_appraisalGoalMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _appraisalGoalMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalGoalMasterWrapper)) {
			return false;
		}

		AppraisalGoalMasterWrapper appraisalGoalMasterWrapper = (AppraisalGoalMasterWrapper)obj;

		if (Objects.equals(_appraisalGoalMaster,
					appraisalGoalMasterWrapper._appraisalGoalMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public AppraisalGoalMaster getWrappedModel() {
		return _appraisalGoalMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _appraisalGoalMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _appraisalGoalMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_appraisalGoalMaster.resetOriginalValues();
	}

	private final AppraisalGoalMaster _appraisalGoalMaster;
}