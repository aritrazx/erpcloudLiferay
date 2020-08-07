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
 * This class is a wrapper for {@link AppraisalSetup}.
 * </p>
 *
 * @author Samaresh
 * @see AppraisalSetup
 * @generated
 */
@ProviderType
public class AppraisalSetupWrapper implements AppraisalSetup,
	ModelWrapper<AppraisalSetup> {
	public AppraisalSetupWrapper(AppraisalSetup appraisalSetup) {
		_appraisalSetup = appraisalSetup;
	}

	@Override
	public Class<?> getModelClass() {
		return AppraisalSetup.class;
	}

	@Override
	public String getModelClassName() {
		return AppraisalSetup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("appraisalSettingId", getAppraisalSettingId());
		attributes.put("companyId", getCompanyId());
		attributes.put("financialYear", getFinancialYear());
		attributes.put("fromDateCycle", getFromDateCycle());
		attributes.put("toDateCycle", getToDateCycle());
		attributes.put("fromDateSubmission", getFromDateSubmission());
		attributes.put("toDateSubmission", getToDateSubmission());
		attributes.put("appraisalPeriod", getAppraisalPeriod());
		attributes.put("totalEmp", getTotalEmp());
		attributes.put("beforeCtcAll", getBeforeCtcAll());
		attributes.put("appraisalEmp", getAppraisalEmp());
		attributes.put("beforeCtc", getBeforeCtc());
		attributes.put("afterCtc", getAfterCtc());
		attributes.put("totalAreas", getTotalAreas());
		attributes.put("totalBonus", getTotalBonus());
		attributes.put("totalCtcAfter", getTotalCtcAfter());
		attributes.put("isLocked", getIsLocked());
		attributes.put("isActive", getIsActive());
		attributes.put("employeeType", getEmployeeType());
		attributes.put("addedDate", getAddedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long appraisalSettingId = (Long)attributes.get("appraisalSettingId");

		if (appraisalSettingId != null) {
			setAppraisalSettingId(appraisalSettingId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String financialYear = (String)attributes.get("financialYear");

		if (financialYear != null) {
			setFinancialYear(financialYear);
		}

		Date fromDateCycle = (Date)attributes.get("fromDateCycle");

		if (fromDateCycle != null) {
			setFromDateCycle(fromDateCycle);
		}

		Date toDateCycle = (Date)attributes.get("toDateCycle");

		if (toDateCycle != null) {
			setToDateCycle(toDateCycle);
		}

		Date fromDateSubmission = (Date)attributes.get("fromDateSubmission");

		if (fromDateSubmission != null) {
			setFromDateSubmission(fromDateSubmission);
		}

		Date toDateSubmission = (Date)attributes.get("toDateSubmission");

		if (toDateSubmission != null) {
			setToDateSubmission(toDateSubmission);
		}

		Long appraisalPeriod = (Long)attributes.get("appraisalPeriod");

		if (appraisalPeriod != null) {
			setAppraisalPeriod(appraisalPeriod);
		}

		Long totalEmp = (Long)attributes.get("totalEmp");

		if (totalEmp != null) {
			setTotalEmp(totalEmp);
		}

		Long beforeCtcAll = (Long)attributes.get("beforeCtcAll");

		if (beforeCtcAll != null) {
			setBeforeCtcAll(beforeCtcAll);
		}

		Long appraisalEmp = (Long)attributes.get("appraisalEmp");

		if (appraisalEmp != null) {
			setAppraisalEmp(appraisalEmp);
		}

		Long beforeCtc = (Long)attributes.get("beforeCtc");

		if (beforeCtc != null) {
			setBeforeCtc(beforeCtc);
		}

		Long afterCtc = (Long)attributes.get("afterCtc");

		if (afterCtc != null) {
			setAfterCtc(afterCtc);
		}

		Long totalAreas = (Long)attributes.get("totalAreas");

		if (totalAreas != null) {
			setTotalAreas(totalAreas);
		}

		Long totalBonus = (Long)attributes.get("totalBonus");

		if (totalBonus != null) {
			setTotalBonus(totalBonus);
		}

		Long totalCtcAfter = (Long)attributes.get("totalCtcAfter");

		if (totalCtcAfter != null) {
			setTotalCtcAfter(totalCtcAfter);
		}

		Long isLocked = (Long)attributes.get("isLocked");

		if (isLocked != null) {
			setIsLocked(isLocked);
		}

		Long isActive = (Long)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		String employeeType = (String)attributes.get("employeeType");

		if (employeeType != null) {
			setEmployeeType(employeeType);
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
		return new AppraisalSetupWrapper((AppraisalSetup)_appraisalSetup.clone());
	}

	@Override
	public int compareTo(AppraisalSetup appraisalSetup) {
		return _appraisalSetup.compareTo(appraisalSetup);
	}

	/**
	* Returns the added date of this appraisal setup.
	*
	* @return the added date of this appraisal setup
	*/
	@Override
	public Date getAddedDate() {
		return _appraisalSetup.getAddedDate();
	}

	/**
	* Returns the after ctc of this appraisal setup.
	*
	* @return the after ctc of this appraisal setup
	*/
	@Override
	public long getAfterCtc() {
		return _appraisalSetup.getAfterCtc();
	}

	/**
	* Returns the appraisal emp of this appraisal setup.
	*
	* @return the appraisal emp of this appraisal setup
	*/
	@Override
	public long getAppraisalEmp() {
		return _appraisalSetup.getAppraisalEmp();
	}

	/**
	* Returns the appraisal period of this appraisal setup.
	*
	* @return the appraisal period of this appraisal setup
	*/
	@Override
	public long getAppraisalPeriod() {
		return _appraisalSetup.getAppraisalPeriod();
	}

	/**
	* Returns the appraisal setting ID of this appraisal setup.
	*
	* @return the appraisal setting ID of this appraisal setup
	*/
	@Override
	public long getAppraisalSettingId() {
		return _appraisalSetup.getAppraisalSettingId();
	}

	/**
	* Returns the before ctc of this appraisal setup.
	*
	* @return the before ctc of this appraisal setup
	*/
	@Override
	public long getBeforeCtc() {
		return _appraisalSetup.getBeforeCtc();
	}

	/**
	* Returns the before ctc all of this appraisal setup.
	*
	* @return the before ctc all of this appraisal setup
	*/
	@Override
	public long getBeforeCtcAll() {
		return _appraisalSetup.getBeforeCtcAll();
	}

	/**
	* Returns the company ID of this appraisal setup.
	*
	* @return the company ID of this appraisal setup
	*/
	@Override
	public long getCompanyId() {
		return _appraisalSetup.getCompanyId();
	}

	/**
	* Returns the created by of this appraisal setup.
	*
	* @return the created by of this appraisal setup
	*/
	@Override
	public long getCreatedBy() {
		return _appraisalSetup.getCreatedBy();
	}

	/**
	* Returns the employee type of this appraisal setup.
	*
	* @return the employee type of this appraisal setup
	*/
	@Override
	public String getEmployeeType() {
		return _appraisalSetup.getEmployeeType();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _appraisalSetup.getExpandoBridge();
	}

	/**
	* Returns the financial year of this appraisal setup.
	*
	* @return the financial year of this appraisal setup
	*/
	@Override
	public String getFinancialYear() {
		return _appraisalSetup.getFinancialYear();
	}

	/**
	* Returns the from date cycle of this appraisal setup.
	*
	* @return the from date cycle of this appraisal setup
	*/
	@Override
	public Date getFromDateCycle() {
		return _appraisalSetup.getFromDateCycle();
	}

	/**
	* Returns the from date submission of this appraisal setup.
	*
	* @return the from date submission of this appraisal setup
	*/
	@Override
	public Date getFromDateSubmission() {
		return _appraisalSetup.getFromDateSubmission();
	}

	/**
	* Returns the is active of this appraisal setup.
	*
	* @return the is active of this appraisal setup
	*/
	@Override
	public long getIsActive() {
		return _appraisalSetup.getIsActive();
	}

	/**
	* Returns the is locked of this appraisal setup.
	*
	* @return the is locked of this appraisal setup
	*/
	@Override
	public long getIsLocked() {
		return _appraisalSetup.getIsLocked();
	}

	/**
	* Returns the modified by of this appraisal setup.
	*
	* @return the modified by of this appraisal setup
	*/
	@Override
	public long getModifiedBy() {
		return _appraisalSetup.getModifiedBy();
	}

	/**
	* Returns the modified date of this appraisal setup.
	*
	* @return the modified date of this appraisal setup
	*/
	@Override
	public Date getModifiedDate() {
		return _appraisalSetup.getModifiedDate();
	}

	/**
	* Returns the primary key of this appraisal setup.
	*
	* @return the primary key of this appraisal setup
	*/
	@Override
	public long getPrimaryKey() {
		return _appraisalSetup.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _appraisalSetup.getPrimaryKeyObj();
	}

	/**
	* Returns the to date cycle of this appraisal setup.
	*
	* @return the to date cycle of this appraisal setup
	*/
	@Override
	public Date getToDateCycle() {
		return _appraisalSetup.getToDateCycle();
	}

	/**
	* Returns the to date submission of this appraisal setup.
	*
	* @return the to date submission of this appraisal setup
	*/
	@Override
	public Date getToDateSubmission() {
		return _appraisalSetup.getToDateSubmission();
	}

	/**
	* Returns the total areas of this appraisal setup.
	*
	* @return the total areas of this appraisal setup
	*/
	@Override
	public long getTotalAreas() {
		return _appraisalSetup.getTotalAreas();
	}

	/**
	* Returns the total bonus of this appraisal setup.
	*
	* @return the total bonus of this appraisal setup
	*/
	@Override
	public long getTotalBonus() {
		return _appraisalSetup.getTotalBonus();
	}

	/**
	* Returns the total ctc after of this appraisal setup.
	*
	* @return the total ctc after of this appraisal setup
	*/
	@Override
	public long getTotalCtcAfter() {
		return _appraisalSetup.getTotalCtcAfter();
	}

	/**
	* Returns the total emp of this appraisal setup.
	*
	* @return the total emp of this appraisal setup
	*/
	@Override
	public long getTotalEmp() {
		return _appraisalSetup.getTotalEmp();
	}

	@Override
	public int hashCode() {
		return _appraisalSetup.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _appraisalSetup.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _appraisalSetup.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _appraisalSetup.isNew();
	}

	@Override
	public void persist() {
		_appraisalSetup.persist();
	}

	/**
	* Sets the added date of this appraisal setup.
	*
	* @param addedDate the added date of this appraisal setup
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_appraisalSetup.setAddedDate(addedDate);
	}

	/**
	* Sets the after ctc of this appraisal setup.
	*
	* @param afterCtc the after ctc of this appraisal setup
	*/
	@Override
	public void setAfterCtc(long afterCtc) {
		_appraisalSetup.setAfterCtc(afterCtc);
	}

	/**
	* Sets the appraisal emp of this appraisal setup.
	*
	* @param appraisalEmp the appraisal emp of this appraisal setup
	*/
	@Override
	public void setAppraisalEmp(long appraisalEmp) {
		_appraisalSetup.setAppraisalEmp(appraisalEmp);
	}

	/**
	* Sets the appraisal period of this appraisal setup.
	*
	* @param appraisalPeriod the appraisal period of this appraisal setup
	*/
	@Override
	public void setAppraisalPeriod(long appraisalPeriod) {
		_appraisalSetup.setAppraisalPeriod(appraisalPeriod);
	}

	/**
	* Sets the appraisal setting ID of this appraisal setup.
	*
	* @param appraisalSettingId the appraisal setting ID of this appraisal setup
	*/
	@Override
	public void setAppraisalSettingId(long appraisalSettingId) {
		_appraisalSetup.setAppraisalSettingId(appraisalSettingId);
	}

	/**
	* Sets the before ctc of this appraisal setup.
	*
	* @param beforeCtc the before ctc of this appraisal setup
	*/
	@Override
	public void setBeforeCtc(long beforeCtc) {
		_appraisalSetup.setBeforeCtc(beforeCtc);
	}

	/**
	* Sets the before ctc all of this appraisal setup.
	*
	* @param beforeCtcAll the before ctc all of this appraisal setup
	*/
	@Override
	public void setBeforeCtcAll(long beforeCtcAll) {
		_appraisalSetup.setBeforeCtcAll(beforeCtcAll);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_appraisalSetup.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this appraisal setup.
	*
	* @param companyId the company ID of this appraisal setup
	*/
	@Override
	public void setCompanyId(long companyId) {
		_appraisalSetup.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this appraisal setup.
	*
	* @param createdBy the created by of this appraisal setup
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_appraisalSetup.setCreatedBy(createdBy);
	}

	/**
	* Sets the employee type of this appraisal setup.
	*
	* @param employeeType the employee type of this appraisal setup
	*/
	@Override
	public void setEmployeeType(String employeeType) {
		_appraisalSetup.setEmployeeType(employeeType);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_appraisalSetup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_appraisalSetup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_appraisalSetup.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the financial year of this appraisal setup.
	*
	* @param financialYear the financial year of this appraisal setup
	*/
	@Override
	public void setFinancialYear(String financialYear) {
		_appraisalSetup.setFinancialYear(financialYear);
	}

	/**
	* Sets the from date cycle of this appraisal setup.
	*
	* @param fromDateCycle the from date cycle of this appraisal setup
	*/
	@Override
	public void setFromDateCycle(Date fromDateCycle) {
		_appraisalSetup.setFromDateCycle(fromDateCycle);
	}

	/**
	* Sets the from date submission of this appraisal setup.
	*
	* @param fromDateSubmission the from date submission of this appraisal setup
	*/
	@Override
	public void setFromDateSubmission(Date fromDateSubmission) {
		_appraisalSetup.setFromDateSubmission(fromDateSubmission);
	}

	/**
	* Sets the is active of this appraisal setup.
	*
	* @param isActive the is active of this appraisal setup
	*/
	@Override
	public void setIsActive(long isActive) {
		_appraisalSetup.setIsActive(isActive);
	}

	/**
	* Sets the is locked of this appraisal setup.
	*
	* @param isLocked the is locked of this appraisal setup
	*/
	@Override
	public void setIsLocked(long isLocked) {
		_appraisalSetup.setIsLocked(isLocked);
	}

	/**
	* Sets the modified by of this appraisal setup.
	*
	* @param modifiedBy the modified by of this appraisal setup
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_appraisalSetup.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this appraisal setup.
	*
	* @param modifiedDate the modified date of this appraisal setup
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_appraisalSetup.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_appraisalSetup.setNew(n);
	}

	/**
	* Sets the primary key of this appraisal setup.
	*
	* @param primaryKey the primary key of this appraisal setup
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_appraisalSetup.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_appraisalSetup.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the to date cycle of this appraisal setup.
	*
	* @param toDateCycle the to date cycle of this appraisal setup
	*/
	@Override
	public void setToDateCycle(Date toDateCycle) {
		_appraisalSetup.setToDateCycle(toDateCycle);
	}

	/**
	* Sets the to date submission of this appraisal setup.
	*
	* @param toDateSubmission the to date submission of this appraisal setup
	*/
	@Override
	public void setToDateSubmission(Date toDateSubmission) {
		_appraisalSetup.setToDateSubmission(toDateSubmission);
	}

	/**
	* Sets the total areas of this appraisal setup.
	*
	* @param totalAreas the total areas of this appraisal setup
	*/
	@Override
	public void setTotalAreas(long totalAreas) {
		_appraisalSetup.setTotalAreas(totalAreas);
	}

	/**
	* Sets the total bonus of this appraisal setup.
	*
	* @param totalBonus the total bonus of this appraisal setup
	*/
	@Override
	public void setTotalBonus(long totalBonus) {
		_appraisalSetup.setTotalBonus(totalBonus);
	}

	/**
	* Sets the total ctc after of this appraisal setup.
	*
	* @param totalCtcAfter the total ctc after of this appraisal setup
	*/
	@Override
	public void setTotalCtcAfter(long totalCtcAfter) {
		_appraisalSetup.setTotalCtcAfter(totalCtcAfter);
	}

	/**
	* Sets the total emp of this appraisal setup.
	*
	* @param totalEmp the total emp of this appraisal setup
	*/
	@Override
	public void setTotalEmp(long totalEmp) {
		_appraisalSetup.setTotalEmp(totalEmp);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AppraisalSetup> toCacheModel() {
		return _appraisalSetup.toCacheModel();
	}

	@Override
	public AppraisalSetup toEscapedModel() {
		return new AppraisalSetupWrapper(_appraisalSetup.toEscapedModel());
	}

	@Override
	public String toString() {
		return _appraisalSetup.toString();
	}

	@Override
	public AppraisalSetup toUnescapedModel() {
		return new AppraisalSetupWrapper(_appraisalSetup.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _appraisalSetup.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppraisalSetupWrapper)) {
			return false;
		}

		AppraisalSetupWrapper appraisalSetupWrapper = (AppraisalSetupWrapper)obj;

		if (Objects.equals(_appraisalSetup,
					appraisalSetupWrapper._appraisalSetup)) {
			return true;
		}

		return false;
	}

	@Override
	public AppraisalSetup getWrappedModel() {
		return _appraisalSetup;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _appraisalSetup.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _appraisalSetup.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_appraisalSetup.resetOriginalValues();
	}

	private final AppraisalSetup _appraisalSetup;
}