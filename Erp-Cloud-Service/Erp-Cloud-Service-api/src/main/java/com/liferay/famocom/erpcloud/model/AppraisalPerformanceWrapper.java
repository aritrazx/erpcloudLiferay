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
 * This class is a wrapper for {@link AppraisalPerformance}.
 * </p>
 *
 * @author Samaresh
 * @see AppraisalPerformance
 * @generated
 */
@ProviderType
public class AppraisalPerformanceWrapper implements AppraisalPerformance,
	ModelWrapper<AppraisalPerformance> {
	public AppraisalPerformanceWrapper(
		AppraisalPerformance appraisalPerformance) {
		_appraisalPerformance = appraisalPerformance;
	}

	@Override
	public Class<?> getModelClass() {
		return AppraisalPerformance.class;
	}

	@Override
	public String getModelClassName() {
		return AppraisalPerformance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("appraisalPerformanceId", getAppraisalPerformanceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("appraisalId", getAppraisalId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("appraisalSettingId", getAppraisalSettingId());
		attributes.put("performanceId", getPerformanceId());
		attributes.put("performanceComm", getPerformanceComm());
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
		Long appraisalPerformanceId = (Long)attributes.get(
				"appraisalPerformanceId");

		if (appraisalPerformanceId != null) {
			setAppraisalPerformanceId(appraisalPerformanceId);
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

		Long appraisalSettingId = (Long)attributes.get("appraisalSettingId");

		if (appraisalSettingId != null) {
			setAppraisalSettingId(appraisalSettingId);
		}

		Long performanceId = (Long)attributes.get("performanceId");

		if (performanceId != null) {
			setPerformanceId(performanceId);
		}

		String performanceComm = (String)attributes.get("performanceComm");

		if (performanceComm != null) {
			setPerformanceComm(performanceComm);
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
		return new AppraisalPerformanceWrapper((AppraisalPerformance)_appraisalPerformance.clone());
	}

	@Override
	public int compareTo(AppraisalPerformance appraisalPerformance) {
		return _appraisalPerformance.compareTo(appraisalPerformance);
	}

	/**
	* Returns the appraisal ID of this appraisal performance.
	*
	* @return the appraisal ID of this appraisal performance
	*/
	@Override
	public long getAppraisalId() {
		return _appraisalPerformance.getAppraisalId();
	}

	/**
	* Returns the appraisal performance ID of this appraisal performance.
	*
	* @return the appraisal performance ID of this appraisal performance
	*/
	@Override
	public long getAppraisalPerformanceId() {
		return _appraisalPerformance.getAppraisalPerformanceId();
	}

	/**
	* Returns the appraisal setting ID of this appraisal performance.
	*
	* @return the appraisal setting ID of this appraisal performance
	*/
	@Override
	public long getAppraisalSettingId() {
		return _appraisalPerformance.getAppraisalSettingId();
	}

	/**
	* Returns the company ID of this appraisal performance.
	*
	* @return the company ID of this appraisal performance
	*/
	@Override
	public long getCompanyId() {
		return _appraisalPerformance.getCompanyId();
	}

	/**
	* Returns the created by of this appraisal performance.
	*
	* @return the created by of this appraisal performance
	*/
	@Override
	public long getCreatedBy() {
		return _appraisalPerformance.getCreatedBy();
	}

	/**
	* Returns the created date of this appraisal performance.
	*
	* @return the created date of this appraisal performance
	*/
	@Override
	public Date getCreatedDate() {
		return _appraisalPerformance.getCreatedDate();
	}

	/**
	* Returns the employee ID of this appraisal performance.
	*
	* @return the employee ID of this appraisal performance
	*/
	@Override
	public long getEmployeeId() {
		return _appraisalPerformance.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _appraisalPerformance.getExpandoBridge();
	}

	/**
	* Returns the modified by of this appraisal performance.
	*
	* @return the modified by of this appraisal performance
	*/
	@Override
	public long getModifiedBy() {
		return _appraisalPerformance.getModifiedBy();
	}

	/**
	* Returns the modified date of this appraisal performance.
	*
	* @return the modified date of this appraisal performance
	*/
	@Override
	public Date getModifiedDate() {
		return _appraisalPerformance.getModifiedDate();
	}

	/**
	* Returns the performance comm of this appraisal performance.
	*
	* @return the performance comm of this appraisal performance
	*/
	@Override
	public String getPerformanceComm() {
		return _appraisalPerformance.getPerformanceComm();
	}

	/**
	* Returns the performance ID of this appraisal performance.
	*
	* @return the performance ID of this appraisal performance
	*/
	@Override
	public long getPerformanceId() {
		return _appraisalPerformance.getPerformanceId();
	}

	/**
	* Returns the primary key of this appraisal performance.
	*
	* @return the primary key of this appraisal performance
	*/
	@Override
	public long getPrimaryKey() {
		return _appraisalPerformance.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _appraisalPerformance.getPrimaryKeyObj();
	}

	/**
	* Returns the rating ID emp of this appraisal performance.
	*
	* @return the rating ID emp of this appraisal performance
	*/
	@Override
	public long getRatingIdEmp() {
		return _appraisalPerformance.getRatingIdEmp();
	}

	/**
	* Returns the rating ID man of this appraisal performance.
	*
	* @return the rating ID man of this appraisal performance
	*/
	@Override
	public long getRatingIdMan() {
		return _appraisalPerformance.getRatingIdMan();
	}

	@Override
	public int hashCode() {
		return _appraisalPerformance.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _appraisalPerformance.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _appraisalPerformance.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _appraisalPerformance.isNew();
	}

	@Override
	public void persist() {
		_appraisalPerformance.persist();
	}

	/**
	* Sets the appraisal ID of this appraisal performance.
	*
	* @param appraisalId the appraisal ID of this appraisal performance
	*/
	@Override
	public void setAppraisalId(long appraisalId) {
		_appraisalPerformance.setAppraisalId(appraisalId);
	}

	/**
	* Sets the appraisal performance ID of this appraisal performance.
	*
	* @param appraisalPerformanceId the appraisal performance ID of this appraisal performance
	*/
	@Override
	public void setAppraisalPerformanceId(long appraisalPerformanceId) {
		_appraisalPerformance.setAppraisalPerformanceId(appraisalPerformanceId);
	}

	/**
	* Sets the appraisal setting ID of this appraisal performance.
	*
	* @param appraisalSettingId the appraisal setting ID of this appraisal performance
	*/
	@Override
	public void setAppraisalSettingId(long appraisalSettingId) {
		_appraisalPerformance.setAppraisalSettingId(appraisalSettingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_appraisalPerformance.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this appraisal performance.
	*
	* @param companyId the company ID of this appraisal performance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_appraisalPerformance.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this appraisal performance.
	*
	* @param createdBy the created by of this appraisal performance
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_appraisalPerformance.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this appraisal performance.
	*
	* @param createdDate the created date of this appraisal performance
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_appraisalPerformance.setCreatedDate(createdDate);
	}

	/**
	* Sets the employee ID of this appraisal performance.
	*
	* @param employeeId the employee ID of this appraisal performance
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_appraisalPerformance.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_appraisalPerformance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_appraisalPerformance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_appraisalPerformance.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this appraisal performance.
	*
	* @param modifiedBy the modified by of this appraisal performance
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_appraisalPerformance.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this appraisal performance.
	*
	* @param modifiedDate the modified date of this appraisal performance
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_appraisalPerformance.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_appraisalPerformance.setNew(n);
	}

	/**
	* Sets the performance comm of this appraisal performance.
	*
	* @param performanceComm the performance comm of this appraisal performance
	*/
	@Override
	public void setPerformanceComm(String performanceComm) {
		_appraisalPerformance.setPerformanceComm(performanceComm);
	}

	/**
	* Sets the performance ID of this appraisal performance.
	*
	* @param performanceId the performance ID of this appraisal performance
	*/
	@Override
	public void setPerformanceId(long performanceId) {
		_appraisalPerformance.setPerformanceId(performanceId);
	}

	/**
	* Sets the primary key of this appraisal performance.
	*
	* @param primaryKey the primary key of this appraisal performance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_appraisalPerformance.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_appraisalPerformance.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rating ID emp of this appraisal performance.
	*
	* @param ratingIdEmp the rating ID emp of this appraisal performance
	*/
	@Override
	public void setRatingIdEmp(long ratingIdEmp) {
		_appraisalPerformance.setRatingIdEmp(ratingIdEmp);
	}

	/**
	* Sets the rating ID man of this appraisal performance.
	*
	* @param ratingIdMan the rating ID man of this appraisal performance
	*/
	@Override
	public void setRatingIdMan(long ratingIdMan) {
		_appraisalPerformance.setRatingIdMan(ratingIdMan);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AppraisalPerformance> toCacheModel() {
		return _appraisalPerformance.toCacheModel();
	}

	@Override
	public AppraisalPerformance toEscapedModel() {
		return new AppraisalPerformanceWrapper(_appraisalPerformance.toEscapedModel());
	}

	@Override
	public String toString() {
		return _appraisalPerformance.toString();
	}

	@Override
	public AppraisalPerformance toUnescapedModel() {
		return new AppraisalPerformanceWrapper(_appraisalPerformance.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _appraisalPerformance.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalPerformanceWrapper)) {
			return false;
		}

		AppraisalPerformanceWrapper appraisalPerformanceWrapper = (AppraisalPerformanceWrapper)obj;

		if (Objects.equals(_appraisalPerformance,
					appraisalPerformanceWrapper._appraisalPerformance)) {
			return true;
		}

		return false;
	}

	@Override
	public AppraisalPerformance getWrappedModel() {
		return _appraisalPerformance;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _appraisalPerformance.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _appraisalPerformance.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_appraisalPerformance.resetOriginalValues();
	}

	private final AppraisalPerformance _appraisalPerformance;
}