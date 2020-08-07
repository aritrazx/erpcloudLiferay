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
 * This class is a wrapper for {@link AppraisalGoalDetails}.
 * </p>
 *
 * @author Samaresh
 * @see AppraisalGoalDetails
 * @generated
 */
@ProviderType
public class AppraisalGoalDetailsWrapper implements AppraisalGoalDetails,
	ModelWrapper<AppraisalGoalDetails> {
	public AppraisalGoalDetailsWrapper(
		AppraisalGoalDetails appraisalGoalDetails) {
		_appraisalGoalDetails = appraisalGoalDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return AppraisalGoalDetails.class;
	}

	@Override
	public String getModelClassName() {
		return AppraisalGoalDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("appraisalGoalDetailsId", getAppraisalGoalDetailsId());
		attributes.put("appraisalGoalMasterId", getAppraisalGoalMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("appraisalId", getAppraisalId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("projectId", getProjectId());
		attributes.put("evaluationId", getEvaluationId());
		attributes.put("goaldetailId", getGoaldetailId());
		attributes.put("ratingIdEmp", getRatingIdEmp());
		attributes.put("ratingIdMan", getRatingIdMan());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long appraisalGoalDetailsId = (Long)attributes.get(
				"appraisalGoalDetailsId");

		if (appraisalGoalDetailsId != null) {
			setAppraisalGoalDetailsId(appraisalGoalDetailsId);
		}

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

		Long goaldetailId = (Long)attributes.get("goaldetailId");

		if (goaldetailId != null) {
			setGoaldetailId(goaldetailId);
		}

		Long ratingIdEmp = (Long)attributes.get("ratingIdEmp");

		if (ratingIdEmp != null) {
			setRatingIdEmp(ratingIdEmp);
		}

		Long ratingIdMan = (Long)attributes.get("ratingIdMan");

		if (ratingIdMan != null) {
			setRatingIdMan(ratingIdMan);
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
		return new AppraisalGoalDetailsWrapper((AppraisalGoalDetails)_appraisalGoalDetails.clone());
	}

	@Override
	public int compareTo(AppraisalGoalDetails appraisalGoalDetails) {
		return _appraisalGoalDetails.compareTo(appraisalGoalDetails);
	}

	/**
	* Returns the appraisal goal details ID of this appraisal goal details.
	*
	* @return the appraisal goal details ID of this appraisal goal details
	*/
	@Override
	public long getAppraisalGoalDetailsId() {
		return _appraisalGoalDetails.getAppraisalGoalDetailsId();
	}

	/**
	* Returns the appraisal goal master ID of this appraisal goal details.
	*
	* @return the appraisal goal master ID of this appraisal goal details
	*/
	@Override
	public long getAppraisalGoalMasterId() {
		return _appraisalGoalDetails.getAppraisalGoalMasterId();
	}

	/**
	* Returns the appraisal ID of this appraisal goal details.
	*
	* @return the appraisal ID of this appraisal goal details
	*/
	@Override
	public long getAppraisalId() {
		return _appraisalGoalDetails.getAppraisalId();
	}

	/**
	* Returns the company ID of this appraisal goal details.
	*
	* @return the company ID of this appraisal goal details
	*/
	@Override
	public long getCompanyId() {
		return _appraisalGoalDetails.getCompanyId();
	}

	/**
	* Returns the created by of this appraisal goal details.
	*
	* @return the created by of this appraisal goal details
	*/
	@Override
	public long getCreatedBy() {
		return _appraisalGoalDetails.getCreatedBy();
	}

	/**
	* Returns the created date of this appraisal goal details.
	*
	* @return the created date of this appraisal goal details
	*/
	@Override
	public Date getCreatedDate() {
		return _appraisalGoalDetails.getCreatedDate();
	}

	/**
	* Returns the employee ID of this appraisal goal details.
	*
	* @return the employee ID of this appraisal goal details
	*/
	@Override
	public long getEmployeeId() {
		return _appraisalGoalDetails.getEmployeeId();
	}

	/**
	* Returns the evaluation ID of this appraisal goal details.
	*
	* @return the evaluation ID of this appraisal goal details
	*/
	@Override
	public long getEvaluationId() {
		return _appraisalGoalDetails.getEvaluationId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _appraisalGoalDetails.getExpandoBridge();
	}

	/**
	* Returns the goaldetail ID of this appraisal goal details.
	*
	* @return the goaldetail ID of this appraisal goal details
	*/
	@Override
	public long getGoaldetailId() {
		return _appraisalGoalDetails.getGoaldetailId();
	}

	/**
	* Returns the modified by of this appraisal goal details.
	*
	* @return the modified by of this appraisal goal details
	*/
	@Override
	public long getModifiedBy() {
		return _appraisalGoalDetails.getModifiedBy();
	}

	/**
	* Returns the modified date of this appraisal goal details.
	*
	* @return the modified date of this appraisal goal details
	*/
	@Override
	public Date getModifiedDate() {
		return _appraisalGoalDetails.getModifiedDate();
	}

	/**
	* Returns the primary key of this appraisal goal details.
	*
	* @return the primary key of this appraisal goal details
	*/
	@Override
	public long getPrimaryKey() {
		return _appraisalGoalDetails.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _appraisalGoalDetails.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this appraisal goal details.
	*
	* @return the project ID of this appraisal goal details
	*/
	@Override
	public long getProjectId() {
		return _appraisalGoalDetails.getProjectId();
	}

	/**
	* Returns the rating ID emp of this appraisal goal details.
	*
	* @return the rating ID emp of this appraisal goal details
	*/
	@Override
	public long getRatingIdEmp() {
		return _appraisalGoalDetails.getRatingIdEmp();
	}

	/**
	* Returns the rating ID man of this appraisal goal details.
	*
	* @return the rating ID man of this appraisal goal details
	*/
	@Override
	public long getRatingIdMan() {
		return _appraisalGoalDetails.getRatingIdMan();
	}

	@Override
	public int hashCode() {
		return _appraisalGoalDetails.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _appraisalGoalDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _appraisalGoalDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _appraisalGoalDetails.isNew();
	}

	@Override
	public void persist() {
		_appraisalGoalDetails.persist();
	}

	/**
	* Sets the appraisal goal details ID of this appraisal goal details.
	*
	* @param appraisalGoalDetailsId the appraisal goal details ID of this appraisal goal details
	*/
	@Override
	public void setAppraisalGoalDetailsId(long appraisalGoalDetailsId) {
		_appraisalGoalDetails.setAppraisalGoalDetailsId(appraisalGoalDetailsId);
	}

	/**
	* Sets the appraisal goal master ID of this appraisal goal details.
	*
	* @param appraisalGoalMasterId the appraisal goal master ID of this appraisal goal details
	*/
	@Override
	public void setAppraisalGoalMasterId(long appraisalGoalMasterId) {
		_appraisalGoalDetails.setAppraisalGoalMasterId(appraisalGoalMasterId);
	}

	/**
	* Sets the appraisal ID of this appraisal goal details.
	*
	* @param appraisalId the appraisal ID of this appraisal goal details
	*/
	@Override
	public void setAppraisalId(long appraisalId) {
		_appraisalGoalDetails.setAppraisalId(appraisalId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_appraisalGoalDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this appraisal goal details.
	*
	* @param companyId the company ID of this appraisal goal details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_appraisalGoalDetails.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this appraisal goal details.
	*
	* @param createdBy the created by of this appraisal goal details
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_appraisalGoalDetails.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this appraisal goal details.
	*
	* @param createdDate the created date of this appraisal goal details
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_appraisalGoalDetails.setCreatedDate(createdDate);
	}

	/**
	* Sets the employee ID of this appraisal goal details.
	*
	* @param employeeId the employee ID of this appraisal goal details
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_appraisalGoalDetails.setEmployeeId(employeeId);
	}

	/**
	* Sets the evaluation ID of this appraisal goal details.
	*
	* @param evaluationId the evaluation ID of this appraisal goal details
	*/
	@Override
	public void setEvaluationId(long evaluationId) {
		_appraisalGoalDetails.setEvaluationId(evaluationId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_appraisalGoalDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_appraisalGoalDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_appraisalGoalDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the goaldetail ID of this appraisal goal details.
	*
	* @param goaldetailId the goaldetail ID of this appraisal goal details
	*/
	@Override
	public void setGoaldetailId(long goaldetailId) {
		_appraisalGoalDetails.setGoaldetailId(goaldetailId);
	}

	/**
	* Sets the modified by of this appraisal goal details.
	*
	* @param modifiedBy the modified by of this appraisal goal details
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_appraisalGoalDetails.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this appraisal goal details.
	*
	* @param modifiedDate the modified date of this appraisal goal details
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_appraisalGoalDetails.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_appraisalGoalDetails.setNew(n);
	}

	/**
	* Sets the primary key of this appraisal goal details.
	*
	* @param primaryKey the primary key of this appraisal goal details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_appraisalGoalDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_appraisalGoalDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this appraisal goal details.
	*
	* @param projectId the project ID of this appraisal goal details
	*/
	@Override
	public void setProjectId(long projectId) {
		_appraisalGoalDetails.setProjectId(projectId);
	}

	/**
	* Sets the rating ID emp of this appraisal goal details.
	*
	* @param ratingIdEmp the rating ID emp of this appraisal goal details
	*/
	@Override
	public void setRatingIdEmp(long ratingIdEmp) {
		_appraisalGoalDetails.setRatingIdEmp(ratingIdEmp);
	}

	/**
	* Sets the rating ID man of this appraisal goal details.
	*
	* @param ratingIdMan the rating ID man of this appraisal goal details
	*/
	@Override
	public void setRatingIdMan(long ratingIdMan) {
		_appraisalGoalDetails.setRatingIdMan(ratingIdMan);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AppraisalGoalDetails> toCacheModel() {
		return _appraisalGoalDetails.toCacheModel();
	}

	@Override
	public AppraisalGoalDetails toEscapedModel() {
		return new AppraisalGoalDetailsWrapper(_appraisalGoalDetails.toEscapedModel());
	}

	@Override
	public String toString() {
		return _appraisalGoalDetails.toString();
	}

	@Override
	public AppraisalGoalDetails toUnescapedModel() {
		return new AppraisalGoalDetailsWrapper(_appraisalGoalDetails.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _appraisalGoalDetails.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalGoalDetailsWrapper)) {
			return false;
		}

		AppraisalGoalDetailsWrapper appraisalGoalDetailsWrapper = (AppraisalGoalDetailsWrapper)obj;

		if (Objects.equals(_appraisalGoalDetails,
					appraisalGoalDetailsWrapper._appraisalGoalDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public AppraisalGoalDetails getWrappedModel() {
		return _appraisalGoalDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _appraisalGoalDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _appraisalGoalDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_appraisalGoalDetails.resetOriginalValues();
	}

	private final AppraisalGoalDetails _appraisalGoalDetails;
}