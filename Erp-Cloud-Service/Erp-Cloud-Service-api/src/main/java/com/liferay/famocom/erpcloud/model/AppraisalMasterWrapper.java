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
 * This class is a wrapper for {@link AppraisalMaster}.
 * </p>
 *
 * @author Samaresh
 * @see AppraisalMaster
 * @generated
 */
@ProviderType
public class AppraisalMasterWrapper implements AppraisalMaster,
	ModelWrapper<AppraisalMaster> {
	public AppraisalMasterWrapper(AppraisalMaster appraisalMaster) {
		_appraisalMaster = appraisalMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return AppraisalMaster.class;
	}

	@Override
	public String getModelClassName() {
		return AppraisalMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("appraisalId", getAppraisalId());
		attributes.put("companyId", getCompanyId());
		attributes.put("appraisalSettingId", getAppraisalSettingId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("accomplishmentsEmp", getAccomplishmentsEmp());
		attributes.put("strengthsEmp", getStrengthsEmp());
		attributes.put("developmentEmp", getDevelopmentEmp());
		attributes.put("careerEmp", getCareerEmp());
		attributes.put("overallRatingEmp", getOverallRatingEmp());
		attributes.put("overallCommentEmp", getOverallCommentEmp());
		attributes.put("accomplishmentsMan", getAccomplishmentsMan());
		attributes.put("strengthsMan", getStrengthsMan());
		attributes.put("developmentMan", getDevelopmentMan());
		attributes.put("careerMan", getCareerMan());
		attributes.put("companyValue", getCompanyValue());
		attributes.put("developmentPlan", getDevelopmentPlan());
		attributes.put("overallRatingMan", getOverallRatingMan());
		attributes.put("overallCommentMan", getOverallCommentMan());
		attributes.put("submitStep", getSubmitStep());
		attributes.put("addedDate", getAddedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long appraisalId = (Long)attributes.get("appraisalId");

		if (appraisalId != null) {
			setAppraisalId(appraisalId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long appraisalSettingId = (Long)attributes.get("appraisalSettingId");

		if (appraisalSettingId != null) {
			setAppraisalSettingId(appraisalSettingId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String accomplishmentsEmp = (String)attributes.get("accomplishmentsEmp");

		if (accomplishmentsEmp != null) {
			setAccomplishmentsEmp(accomplishmentsEmp);
		}

		String strengthsEmp = (String)attributes.get("strengthsEmp");

		if (strengthsEmp != null) {
			setStrengthsEmp(strengthsEmp);
		}

		String developmentEmp = (String)attributes.get("developmentEmp");

		if (developmentEmp != null) {
			setDevelopmentEmp(developmentEmp);
		}

		String careerEmp = (String)attributes.get("careerEmp");

		if (careerEmp != null) {
			setCareerEmp(careerEmp);
		}

		Long overallRatingEmp = (Long)attributes.get("overallRatingEmp");

		if (overallRatingEmp != null) {
			setOverallRatingEmp(overallRatingEmp);
		}

		String overallCommentEmp = (String)attributes.get("overallCommentEmp");

		if (overallCommentEmp != null) {
			setOverallCommentEmp(overallCommentEmp);
		}

		String accomplishmentsMan = (String)attributes.get("accomplishmentsMan");

		if (accomplishmentsMan != null) {
			setAccomplishmentsMan(accomplishmentsMan);
		}

		String strengthsMan = (String)attributes.get("strengthsMan");

		if (strengthsMan != null) {
			setStrengthsMan(strengthsMan);
		}

		String developmentMan = (String)attributes.get("developmentMan");

		if (developmentMan != null) {
			setDevelopmentMan(developmentMan);
		}

		String careerMan = (String)attributes.get("careerMan");

		if (careerMan != null) {
			setCareerMan(careerMan);
		}

		String companyValue = (String)attributes.get("companyValue");

		if (companyValue != null) {
			setCompanyValue(companyValue);
		}

		String developmentPlan = (String)attributes.get("developmentPlan");

		if (developmentPlan != null) {
			setDevelopmentPlan(developmentPlan);
		}

		Long overallRatingMan = (Long)attributes.get("overallRatingMan");

		if (overallRatingMan != null) {
			setOverallRatingMan(overallRatingMan);
		}

		String overallCommentMan = (String)attributes.get("overallCommentMan");

		if (overallCommentMan != null) {
			setOverallCommentMan(overallCommentMan);
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
		return new AppraisalMasterWrapper((AppraisalMaster)_appraisalMaster.clone());
	}

	@Override
	public int compareTo(AppraisalMaster appraisalMaster) {
		return _appraisalMaster.compareTo(appraisalMaster);
	}

	/**
	* Returns the accomplishments emp of this appraisal master.
	*
	* @return the accomplishments emp of this appraisal master
	*/
	@Override
	public String getAccomplishmentsEmp() {
		return _appraisalMaster.getAccomplishmentsEmp();
	}

	/**
	* Returns the accomplishments man of this appraisal master.
	*
	* @return the accomplishments man of this appraisal master
	*/
	@Override
	public String getAccomplishmentsMan() {
		return _appraisalMaster.getAccomplishmentsMan();
	}

	/**
	* Returns the added date of this appraisal master.
	*
	* @return the added date of this appraisal master
	*/
	@Override
	public Date getAddedDate() {
		return _appraisalMaster.getAddedDate();
	}

	/**
	* Returns the appraisal ID of this appraisal master.
	*
	* @return the appraisal ID of this appraisal master
	*/
	@Override
	public long getAppraisalId() {
		return _appraisalMaster.getAppraisalId();
	}

	/**
	* Returns the appraisal setting ID of this appraisal master.
	*
	* @return the appraisal setting ID of this appraisal master
	*/
	@Override
	public long getAppraisalSettingId() {
		return _appraisalMaster.getAppraisalSettingId();
	}

	/**
	* Returns the career emp of this appraisal master.
	*
	* @return the career emp of this appraisal master
	*/
	@Override
	public String getCareerEmp() {
		return _appraisalMaster.getCareerEmp();
	}

	/**
	* Returns the career man of this appraisal master.
	*
	* @return the career man of this appraisal master
	*/
	@Override
	public String getCareerMan() {
		return _appraisalMaster.getCareerMan();
	}

	/**
	* Returns the company ID of this appraisal master.
	*
	* @return the company ID of this appraisal master
	*/
	@Override
	public long getCompanyId() {
		return _appraisalMaster.getCompanyId();
	}

	/**
	* Returns the company value of this appraisal master.
	*
	* @return the company value of this appraisal master
	*/
	@Override
	public String getCompanyValue() {
		return _appraisalMaster.getCompanyValue();
	}

	/**
	* Returns the created by of this appraisal master.
	*
	* @return the created by of this appraisal master
	*/
	@Override
	public long getCreatedBy() {
		return _appraisalMaster.getCreatedBy();
	}

	/**
	* Returns the development emp of this appraisal master.
	*
	* @return the development emp of this appraisal master
	*/
	@Override
	public String getDevelopmentEmp() {
		return _appraisalMaster.getDevelopmentEmp();
	}

	/**
	* Returns the development man of this appraisal master.
	*
	* @return the development man of this appraisal master
	*/
	@Override
	public String getDevelopmentMan() {
		return _appraisalMaster.getDevelopmentMan();
	}

	/**
	* Returns the development plan of this appraisal master.
	*
	* @return the development plan of this appraisal master
	*/
	@Override
	public String getDevelopmentPlan() {
		return _appraisalMaster.getDevelopmentPlan();
	}

	/**
	* Returns the employee ID of this appraisal master.
	*
	* @return the employee ID of this appraisal master
	*/
	@Override
	public long getEmployeeId() {
		return _appraisalMaster.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _appraisalMaster.getExpandoBridge();
	}

	/**
	* Returns the modified by of this appraisal master.
	*
	* @return the modified by of this appraisal master
	*/
	@Override
	public long getModifiedBy() {
		return _appraisalMaster.getModifiedBy();
	}

	/**
	* Returns the modified date of this appraisal master.
	*
	* @return the modified date of this appraisal master
	*/
	@Override
	public Date getModifiedDate() {
		return _appraisalMaster.getModifiedDate();
	}

	/**
	* Returns the overall comment emp of this appraisal master.
	*
	* @return the overall comment emp of this appraisal master
	*/
	@Override
	public String getOverallCommentEmp() {
		return _appraisalMaster.getOverallCommentEmp();
	}

	/**
	* Returns the overall comment man of this appraisal master.
	*
	* @return the overall comment man of this appraisal master
	*/
	@Override
	public String getOverallCommentMan() {
		return _appraisalMaster.getOverallCommentMan();
	}

	/**
	* Returns the overall rating emp of this appraisal master.
	*
	* @return the overall rating emp of this appraisal master
	*/
	@Override
	public long getOverallRatingEmp() {
		return _appraisalMaster.getOverallRatingEmp();
	}

	/**
	* Returns the overall rating man of this appraisal master.
	*
	* @return the overall rating man of this appraisal master
	*/
	@Override
	public long getOverallRatingMan() {
		return _appraisalMaster.getOverallRatingMan();
	}

	/**
	* Returns the primary key of this appraisal master.
	*
	* @return the primary key of this appraisal master
	*/
	@Override
	public long getPrimaryKey() {
		return _appraisalMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _appraisalMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the strengths emp of this appraisal master.
	*
	* @return the strengths emp of this appraisal master
	*/
	@Override
	public String getStrengthsEmp() {
		return _appraisalMaster.getStrengthsEmp();
	}

	/**
	* Returns the strengths man of this appraisal master.
	*
	* @return the strengths man of this appraisal master
	*/
	@Override
	public String getStrengthsMan() {
		return _appraisalMaster.getStrengthsMan();
	}

	/**
	* Returns the submit step of this appraisal master.
	*
	* @return the submit step of this appraisal master
	*/
	@Override
	public long getSubmitStep() {
		return _appraisalMaster.getSubmitStep();
	}

	@Override
	public int hashCode() {
		return _appraisalMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _appraisalMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _appraisalMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _appraisalMaster.isNew();
	}

	@Override
	public void persist() {
		_appraisalMaster.persist();
	}

	/**
	* Sets the accomplishments emp of this appraisal master.
	*
	* @param accomplishmentsEmp the accomplishments emp of this appraisal master
	*/
	@Override
	public void setAccomplishmentsEmp(String accomplishmentsEmp) {
		_appraisalMaster.setAccomplishmentsEmp(accomplishmentsEmp);
	}

	/**
	* Sets the accomplishments man of this appraisal master.
	*
	* @param accomplishmentsMan the accomplishments man of this appraisal master
	*/
	@Override
	public void setAccomplishmentsMan(String accomplishmentsMan) {
		_appraisalMaster.setAccomplishmentsMan(accomplishmentsMan);
	}

	/**
	* Sets the added date of this appraisal master.
	*
	* @param addedDate the added date of this appraisal master
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_appraisalMaster.setAddedDate(addedDate);
	}

	/**
	* Sets the appraisal ID of this appraisal master.
	*
	* @param appraisalId the appraisal ID of this appraisal master
	*/
	@Override
	public void setAppraisalId(long appraisalId) {
		_appraisalMaster.setAppraisalId(appraisalId);
	}

	/**
	* Sets the appraisal setting ID of this appraisal master.
	*
	* @param appraisalSettingId the appraisal setting ID of this appraisal master
	*/
	@Override
	public void setAppraisalSettingId(long appraisalSettingId) {
		_appraisalMaster.setAppraisalSettingId(appraisalSettingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_appraisalMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the career emp of this appraisal master.
	*
	* @param careerEmp the career emp of this appraisal master
	*/
	@Override
	public void setCareerEmp(String careerEmp) {
		_appraisalMaster.setCareerEmp(careerEmp);
	}

	/**
	* Sets the career man of this appraisal master.
	*
	* @param careerMan the career man of this appraisal master
	*/
	@Override
	public void setCareerMan(String careerMan) {
		_appraisalMaster.setCareerMan(careerMan);
	}

	/**
	* Sets the company ID of this appraisal master.
	*
	* @param companyId the company ID of this appraisal master
	*/
	@Override
	public void setCompanyId(long companyId) {
		_appraisalMaster.setCompanyId(companyId);
	}

	/**
	* Sets the company value of this appraisal master.
	*
	* @param companyValue the company value of this appraisal master
	*/
	@Override
	public void setCompanyValue(String companyValue) {
		_appraisalMaster.setCompanyValue(companyValue);
	}

	/**
	* Sets the created by of this appraisal master.
	*
	* @param createdBy the created by of this appraisal master
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_appraisalMaster.setCreatedBy(createdBy);
	}

	/**
	* Sets the development emp of this appraisal master.
	*
	* @param developmentEmp the development emp of this appraisal master
	*/
	@Override
	public void setDevelopmentEmp(String developmentEmp) {
		_appraisalMaster.setDevelopmentEmp(developmentEmp);
	}

	/**
	* Sets the development man of this appraisal master.
	*
	* @param developmentMan the development man of this appraisal master
	*/
	@Override
	public void setDevelopmentMan(String developmentMan) {
		_appraisalMaster.setDevelopmentMan(developmentMan);
	}

	/**
	* Sets the development plan of this appraisal master.
	*
	* @param developmentPlan the development plan of this appraisal master
	*/
	@Override
	public void setDevelopmentPlan(String developmentPlan) {
		_appraisalMaster.setDevelopmentPlan(developmentPlan);
	}

	/**
	* Sets the employee ID of this appraisal master.
	*
	* @param employeeId the employee ID of this appraisal master
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_appraisalMaster.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_appraisalMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_appraisalMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_appraisalMaster.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this appraisal master.
	*
	* @param modifiedBy the modified by of this appraisal master
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_appraisalMaster.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this appraisal master.
	*
	* @param modifiedDate the modified date of this appraisal master
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_appraisalMaster.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_appraisalMaster.setNew(n);
	}

	/**
	* Sets the overall comment emp of this appraisal master.
	*
	* @param overallCommentEmp the overall comment emp of this appraisal master
	*/
	@Override
	public void setOverallCommentEmp(String overallCommentEmp) {
		_appraisalMaster.setOverallCommentEmp(overallCommentEmp);
	}

	/**
	* Sets the overall comment man of this appraisal master.
	*
	* @param overallCommentMan the overall comment man of this appraisal master
	*/
	@Override
	public void setOverallCommentMan(String overallCommentMan) {
		_appraisalMaster.setOverallCommentMan(overallCommentMan);
	}

	/**
	* Sets the overall rating emp of this appraisal master.
	*
	* @param overallRatingEmp the overall rating emp of this appraisal master
	*/
	@Override
	public void setOverallRatingEmp(long overallRatingEmp) {
		_appraisalMaster.setOverallRatingEmp(overallRatingEmp);
	}

	/**
	* Sets the overall rating man of this appraisal master.
	*
	* @param overallRatingMan the overall rating man of this appraisal master
	*/
	@Override
	public void setOverallRatingMan(long overallRatingMan) {
		_appraisalMaster.setOverallRatingMan(overallRatingMan);
	}

	/**
	* Sets the primary key of this appraisal master.
	*
	* @param primaryKey the primary key of this appraisal master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_appraisalMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_appraisalMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the strengths emp of this appraisal master.
	*
	* @param strengthsEmp the strengths emp of this appraisal master
	*/
	@Override
	public void setStrengthsEmp(String strengthsEmp) {
		_appraisalMaster.setStrengthsEmp(strengthsEmp);
	}

	/**
	* Sets the strengths man of this appraisal master.
	*
	* @param strengthsMan the strengths man of this appraisal master
	*/
	@Override
	public void setStrengthsMan(String strengthsMan) {
		_appraisalMaster.setStrengthsMan(strengthsMan);
	}

	/**
	* Sets the submit step of this appraisal master.
	*
	* @param submitStep the submit step of this appraisal master
	*/
	@Override
	public void setSubmitStep(long submitStep) {
		_appraisalMaster.setSubmitStep(submitStep);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AppraisalMaster> toCacheModel() {
		return _appraisalMaster.toCacheModel();
	}

	@Override
	public AppraisalMaster toEscapedModel() {
		return new AppraisalMasterWrapper(_appraisalMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _appraisalMaster.toString();
	}

	@Override
	public AppraisalMaster toUnescapedModel() {
		return new AppraisalMasterWrapper(_appraisalMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _appraisalMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalMasterWrapper)) {
			return false;
		}

		AppraisalMasterWrapper appraisalMasterWrapper = (AppraisalMasterWrapper)obj;

		if (Objects.equals(_appraisalMaster,
					appraisalMasterWrapper._appraisalMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public AppraisalMaster getWrappedModel() {
		return _appraisalMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _appraisalMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _appraisalMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_appraisalMaster.resetOriginalValues();
	}

	private final AppraisalMaster _appraisalMaster;
}