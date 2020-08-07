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
 * This class is a wrapper for {@link PayrollSlabs}.
 * </p>
 *
 * @author Samaresh
 * @see PayrollSlabs
 * @generated
 */
@ProviderType
public class PayrollSlabsWrapper implements PayrollSlabs,
	ModelWrapper<PayrollSlabs> {
	public PayrollSlabsWrapper(PayrollSlabs payrollSlabs) {
		_payrollSlabs = payrollSlabs;
	}

	@Override
	public Class<?> getModelClass() {
		return PayrollSlabs.class;
	}

	@Override
	public String getModelClassName() {
		return PayrollSlabs.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("payrollSlabsId", getPayrollSlabsId());
		attributes.put("companyId", getCompanyId());
		attributes.put("appraisalSettingId", getAppraisalSettingId());
		attributes.put("ratingId", getRatingId());
		attributes.put("payrollPercentage", getPayrollPercentage());
		attributes.put("bonusPercentage", getBonusPercentage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long payrollSlabsId = (Long)attributes.get("payrollSlabsId");

		if (payrollSlabsId != null) {
			setPayrollSlabsId(payrollSlabsId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long appraisalSettingId = (Long)attributes.get("appraisalSettingId");

		if (appraisalSettingId != null) {
			setAppraisalSettingId(appraisalSettingId);
		}

		Long ratingId = (Long)attributes.get("ratingId");

		if (ratingId != null) {
			setRatingId(ratingId);
		}

		Double payrollPercentage = (Double)attributes.get("payrollPercentage");

		if (payrollPercentage != null) {
			setPayrollPercentage(payrollPercentage);
		}

		Double bonusPercentage = (Double)attributes.get("bonusPercentage");

		if (bonusPercentage != null) {
			setBonusPercentage(bonusPercentage);
		}
	}

	@Override
	public Object clone() {
		return new PayrollSlabsWrapper((PayrollSlabs)_payrollSlabs.clone());
	}

	@Override
	public int compareTo(PayrollSlabs payrollSlabs) {
		return _payrollSlabs.compareTo(payrollSlabs);
	}

	/**
	* Returns the appraisal setting ID of this payroll slabs.
	*
	* @return the appraisal setting ID of this payroll slabs
	*/
	@Override
	public long getAppraisalSettingId() {
		return _payrollSlabs.getAppraisalSettingId();
	}

	/**
	* Returns the bonus percentage of this payroll slabs.
	*
	* @return the bonus percentage of this payroll slabs
	*/
	@Override
	public double getBonusPercentage() {
		return _payrollSlabs.getBonusPercentage();
	}

	/**
	* Returns the company ID of this payroll slabs.
	*
	* @return the company ID of this payroll slabs
	*/
	@Override
	public long getCompanyId() {
		return _payrollSlabs.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _payrollSlabs.getExpandoBridge();
	}

	/**
	* Returns the payroll percentage of this payroll slabs.
	*
	* @return the payroll percentage of this payroll slabs
	*/
	@Override
	public double getPayrollPercentage() {
		return _payrollSlabs.getPayrollPercentage();
	}

	/**
	* Returns the payroll slabs ID of this payroll slabs.
	*
	* @return the payroll slabs ID of this payroll slabs
	*/
	@Override
	public long getPayrollSlabsId() {
		return _payrollSlabs.getPayrollSlabsId();
	}

	/**
	* Returns the primary key of this payroll slabs.
	*
	* @return the primary key of this payroll slabs
	*/
	@Override
	public long getPrimaryKey() {
		return _payrollSlabs.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _payrollSlabs.getPrimaryKeyObj();
	}

	/**
	* Returns the rating ID of this payroll slabs.
	*
	* @return the rating ID of this payroll slabs
	*/
	@Override
	public long getRatingId() {
		return _payrollSlabs.getRatingId();
	}

	@Override
	public int hashCode() {
		return _payrollSlabs.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _payrollSlabs.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _payrollSlabs.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _payrollSlabs.isNew();
	}

	@Override
	public void persist() {
		_payrollSlabs.persist();
	}

	/**
	* Sets the appraisal setting ID of this payroll slabs.
	*
	* @param appraisalSettingId the appraisal setting ID of this payroll slabs
	*/
	@Override
	public void setAppraisalSettingId(long appraisalSettingId) {
		_payrollSlabs.setAppraisalSettingId(appraisalSettingId);
	}

	/**
	* Sets the bonus percentage of this payroll slabs.
	*
	* @param bonusPercentage the bonus percentage of this payroll slabs
	*/
	@Override
	public void setBonusPercentage(double bonusPercentage) {
		_payrollSlabs.setBonusPercentage(bonusPercentage);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_payrollSlabs.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this payroll slabs.
	*
	* @param companyId the company ID of this payroll slabs
	*/
	@Override
	public void setCompanyId(long companyId) {
		_payrollSlabs.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_payrollSlabs.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_payrollSlabs.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_payrollSlabs.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_payrollSlabs.setNew(n);
	}

	/**
	* Sets the payroll percentage of this payroll slabs.
	*
	* @param payrollPercentage the payroll percentage of this payroll slabs
	*/
	@Override
	public void setPayrollPercentage(double payrollPercentage) {
		_payrollSlabs.setPayrollPercentage(payrollPercentage);
	}

	/**
	* Sets the payroll slabs ID of this payroll slabs.
	*
	* @param payrollSlabsId the payroll slabs ID of this payroll slabs
	*/
	@Override
	public void setPayrollSlabsId(long payrollSlabsId) {
		_payrollSlabs.setPayrollSlabsId(payrollSlabsId);
	}

	/**
	* Sets the primary key of this payroll slabs.
	*
	* @param primaryKey the primary key of this payroll slabs
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_payrollSlabs.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_payrollSlabs.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rating ID of this payroll slabs.
	*
	* @param ratingId the rating ID of this payroll slabs
	*/
	@Override
	public void setRatingId(long ratingId) {
		_payrollSlabs.setRatingId(ratingId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PayrollSlabs> toCacheModel() {
		return _payrollSlabs.toCacheModel();
	}

	@Override
	public PayrollSlabs toEscapedModel() {
		return new PayrollSlabsWrapper(_payrollSlabs.toEscapedModel());
	}

	@Override
	public String toString() {
		return _payrollSlabs.toString();
	}

	@Override
	public PayrollSlabs toUnescapedModel() {
		return new PayrollSlabsWrapper(_payrollSlabs.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _payrollSlabs.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayrollSlabsWrapper)) {
			return false;
		}

		PayrollSlabsWrapper payrollSlabsWrapper = (PayrollSlabsWrapper)obj;

		if (Objects.equals(_payrollSlabs, payrollSlabsWrapper._payrollSlabs)) {
			return true;
		}

		return false;
	}

	@Override
	public PayrollSlabs getWrappedModel() {
		return _payrollSlabs;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _payrollSlabs.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _payrollSlabs.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_payrollSlabs.resetOriginalValues();
	}

	private final PayrollSlabs _payrollSlabs;
}