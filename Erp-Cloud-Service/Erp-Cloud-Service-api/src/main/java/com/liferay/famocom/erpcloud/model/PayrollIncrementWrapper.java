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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link PayrollIncrement}.
 * </p>
 *
 * @author Samaresh
 * @see PayrollIncrement
 * @generated
 */
@ProviderType
public class PayrollIncrementWrapper implements PayrollIncrement,
	ModelWrapper<PayrollIncrement> {
	public PayrollIncrementWrapper(PayrollIncrement payrollIncrement) {
		_payrollIncrement = payrollIncrement;
	}

	@Override
	public Class<?> getModelClass() {
		return PayrollIncrement.class;
	}

	@Override
	public String getModelClassName() {
		return PayrollIncrement.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("payrollIncrementId", getPayrollIncrementId());
		attributes.put("appraisalSettingId", getAppraisalSettingId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("employeeCode", getEmployeeCode());
		attributes.put("overallRatingMan", getOverallRatingMan());
		attributes.put("preCtc", getPreCtc());
		attributes.put("postCtc", getPostCtc());
		attributes.put("componentId", getComponentId());
		attributes.put("preHeadComponentVal", getPreHeadComponentVal());
		attributes.put("postHeadComponentVal", getPostHeadComponentVal());
		attributes.put("bonusVal", getBonusVal());
		attributes.put("financialYear", getFinancialYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long payrollIncrementId = (Long)attributes.get("payrollIncrementId");

		if (payrollIncrementId != null) {
			setPayrollIncrementId(payrollIncrementId);
		}

		Long appraisalSettingId = (Long)attributes.get("appraisalSettingId");

		if (appraisalSettingId != null) {
			setAppraisalSettingId(appraisalSettingId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long employeeCode = (Long)attributes.get("employeeCode");

		if (employeeCode != null) {
			setEmployeeCode(employeeCode);
		}

		Long overallRatingMan = (Long)attributes.get("overallRatingMan");

		if (overallRatingMan != null) {
			setOverallRatingMan(overallRatingMan);
		}

		Double preCtc = (Double)attributes.get("preCtc");

		if (preCtc != null) {
			setPreCtc(preCtc);
		}

		Double postCtc = (Double)attributes.get("postCtc");

		if (postCtc != null) {
			setPostCtc(postCtc);
		}

		Long componentId = (Long)attributes.get("componentId");

		if (componentId != null) {
			setComponentId(componentId);
		}

		Double preHeadComponentVal = (Double)attributes.get(
				"preHeadComponentVal");

		if (preHeadComponentVal != null) {
			setPreHeadComponentVal(preHeadComponentVal);
		}

		Double postHeadComponentVal = (Double)attributes.get(
				"postHeadComponentVal");

		if (postHeadComponentVal != null) {
			setPostHeadComponentVal(postHeadComponentVal);
		}

		Double bonusVal = (Double)attributes.get("bonusVal");

		if (bonusVal != null) {
			setBonusVal(bonusVal);
		}

		String financialYear = (String)attributes.get("financialYear");

		if (financialYear != null) {
			setFinancialYear(financialYear);
		}
	}

	@Override
	public Object clone() {
		return new PayrollIncrementWrapper((PayrollIncrement)_payrollIncrement.clone());
	}

	@Override
	public int compareTo(PayrollIncrement payrollIncrement) {
		return _payrollIncrement.compareTo(payrollIncrement);
	}

	/**
	* Returns the appraisal setting ID of this payroll increment.
	*
	* @return the appraisal setting ID of this payroll increment
	*/
	@Override
	public long getAppraisalSettingId() {
		return _payrollIncrement.getAppraisalSettingId();
	}

	/**
	* Returns the bonus val of this payroll increment.
	*
	* @return the bonus val of this payroll increment
	*/
	@Override
	public double getBonusVal() {
		return _payrollIncrement.getBonusVal();
	}

	/**
	* Returns the company ID of this payroll increment.
	*
	* @return the company ID of this payroll increment
	*/
	@Override
	public long getCompanyId() {
		return _payrollIncrement.getCompanyId();
	}

	/**
	* Returns the component ID of this payroll increment.
	*
	* @return the component ID of this payroll increment
	*/
	@Override
	public long getComponentId() {
		return _payrollIncrement.getComponentId();
	}

	/**
	* Returns the employee code of this payroll increment.
	*
	* @return the employee code of this payroll increment
	*/
	@Override
	public long getEmployeeCode() {
		return _payrollIncrement.getEmployeeCode();
	}

	/**
	* Returns the employee ID of this payroll increment.
	*
	* @return the employee ID of this payroll increment
	*/
	@Override
	public long getEmployeeId() {
		return _payrollIncrement.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _payrollIncrement.getExpandoBridge();
	}

	/**
	* Returns the financial year of this payroll increment.
	*
	* @return the financial year of this payroll increment
	*/
	@Override
	public String getFinancialYear() {
		return _payrollIncrement.getFinancialYear();
	}

	/**
	* Returns the overall rating man of this payroll increment.
	*
	* @return the overall rating man of this payroll increment
	*/
	@Override
	public long getOverallRatingMan() {
		return _payrollIncrement.getOverallRatingMan();
	}

	/**
	* Returns the payroll increment ID of this payroll increment.
	*
	* @return the payroll increment ID of this payroll increment
	*/
	@Override
	public long getPayrollIncrementId() {
		return _payrollIncrement.getPayrollIncrementId();
	}

	/**
	* Returns the post ctc of this payroll increment.
	*
	* @return the post ctc of this payroll increment
	*/
	@Override
	public double getPostCtc() {
		return _payrollIncrement.getPostCtc();
	}

	/**
	* Returns the post head component val of this payroll increment.
	*
	* @return the post head component val of this payroll increment
	*/
	@Override
	public double getPostHeadComponentVal() {
		return _payrollIncrement.getPostHeadComponentVal();
	}

	/**
	* Returns the pre ctc of this payroll increment.
	*
	* @return the pre ctc of this payroll increment
	*/
	@Override
	public double getPreCtc() {
		return _payrollIncrement.getPreCtc();
	}

	/**
	* Returns the pre head component val of this payroll increment.
	*
	* @return the pre head component val of this payroll increment
	*/
	@Override
	public double getPreHeadComponentVal() {
		return _payrollIncrement.getPreHeadComponentVal();
	}

	/**
	* Returns the primary key of this payroll increment.
	*
	* @return the primary key of this payroll increment
	*/
	@Override
	public long getPrimaryKey() {
		return _payrollIncrement.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _payrollIncrement.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _payrollIncrement.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _payrollIncrement.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _payrollIncrement.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _payrollIncrement.isNew();
	}

	@Override
	public void persist() {
		_payrollIncrement.persist();
	}

	/**
	* Sets the appraisal setting ID of this payroll increment.
	*
	* @param appraisalSettingId the appraisal setting ID of this payroll increment
	*/
	@Override
	public void setAppraisalSettingId(long appraisalSettingId) {
		_payrollIncrement.setAppraisalSettingId(appraisalSettingId);
	}

	/**
	* Sets the bonus val of this payroll increment.
	*
	* @param bonusVal the bonus val of this payroll increment
	*/
	@Override
	public void setBonusVal(double bonusVal) {
		_payrollIncrement.setBonusVal(bonusVal);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_payrollIncrement.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this payroll increment.
	*
	* @param companyId the company ID of this payroll increment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_payrollIncrement.setCompanyId(companyId);
	}

	/**
	* Sets the component ID of this payroll increment.
	*
	* @param componentId the component ID of this payroll increment
	*/
	@Override
	public void setComponentId(long componentId) {
		_payrollIncrement.setComponentId(componentId);
	}

	/**
	* Sets the employee code of this payroll increment.
	*
	* @param employeeCode the employee code of this payroll increment
	*/
	@Override
	public void setEmployeeCode(long employeeCode) {
		_payrollIncrement.setEmployeeCode(employeeCode);
	}

	/**
	* Sets the employee ID of this payroll increment.
	*
	* @param employeeId the employee ID of this payroll increment
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_payrollIncrement.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_payrollIncrement.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_payrollIncrement.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_payrollIncrement.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the financial year of this payroll increment.
	*
	* @param financialYear the financial year of this payroll increment
	*/
	@Override
	public void setFinancialYear(String financialYear) {
		_payrollIncrement.setFinancialYear(financialYear);
	}

	@Override
	public void setNew(boolean n) {
		_payrollIncrement.setNew(n);
	}

	/**
	* Sets the overall rating man of this payroll increment.
	*
	* @param overallRatingMan the overall rating man of this payroll increment
	*/
	@Override
	public void setOverallRatingMan(long overallRatingMan) {
		_payrollIncrement.setOverallRatingMan(overallRatingMan);
	}

	/**
	* Sets the payroll increment ID of this payroll increment.
	*
	* @param payrollIncrementId the payroll increment ID of this payroll increment
	*/
	@Override
	public void setPayrollIncrementId(long payrollIncrementId) {
		_payrollIncrement.setPayrollIncrementId(payrollIncrementId);
	}

	/**
	* Sets the post ctc of this payroll increment.
	*
	* @param postCtc the post ctc of this payroll increment
	*/
	@Override
	public void setPostCtc(double postCtc) {
		_payrollIncrement.setPostCtc(postCtc);
	}

	/**
	* Sets the post head component val of this payroll increment.
	*
	* @param postHeadComponentVal the post head component val of this payroll increment
	*/
	@Override
	public void setPostHeadComponentVal(double postHeadComponentVal) {
		_payrollIncrement.setPostHeadComponentVal(postHeadComponentVal);
	}

	/**
	* Sets the pre ctc of this payroll increment.
	*
	* @param preCtc the pre ctc of this payroll increment
	*/
	@Override
	public void setPreCtc(double preCtc) {
		_payrollIncrement.setPreCtc(preCtc);
	}

	/**
	* Sets the pre head component val of this payroll increment.
	*
	* @param preHeadComponentVal the pre head component val of this payroll increment
	*/
	@Override
	public void setPreHeadComponentVal(double preHeadComponentVal) {
		_payrollIncrement.setPreHeadComponentVal(preHeadComponentVal);
	}

	/**
	* Sets the primary key of this payroll increment.
	*
	* @param primaryKey the primary key of this payroll increment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_payrollIncrement.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_payrollIncrement.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PayrollIncrement> toCacheModel() {
		return _payrollIncrement.toCacheModel();
	}

	@Override
	public PayrollIncrement toEscapedModel() {
		return new PayrollIncrementWrapper(_payrollIncrement.toEscapedModel());
	}

	@Override
	public String toString() {
		return _payrollIncrement.toString();
	}

	@Override
	public PayrollIncrement toUnescapedModel() {
		return new PayrollIncrementWrapper(_payrollIncrement.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _payrollIncrement.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayrollIncrementWrapper)) {
			return false;
		}

		PayrollIncrementWrapper payrollIncrementWrapper = (PayrollIncrementWrapper)obj;

		if (Objects.equals(_payrollIncrement,
					payrollIncrementWrapper._payrollIncrement)) {
			return true;
		}

		return false;
	}

	@Override
	public PayrollIncrement getWrappedModel() {
		return _payrollIncrement;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _payrollIncrement.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _payrollIncrement.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_payrollIncrement.resetOriginalValues();
	}

	private final PayrollIncrement _payrollIncrement;
}