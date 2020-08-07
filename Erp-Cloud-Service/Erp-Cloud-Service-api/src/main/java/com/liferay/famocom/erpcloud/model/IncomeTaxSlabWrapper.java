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
 * This class is a wrapper for {@link IncomeTaxSlab}.
 * </p>
 *
 * @author Samaresh
 * @see IncomeTaxSlab
 * @generated
 */
@ProviderType
public class IncomeTaxSlabWrapper implements IncomeTaxSlab,
	ModelWrapper<IncomeTaxSlab> {
	public IncomeTaxSlabWrapper(IncomeTaxSlab incomeTaxSlab) {
		_incomeTaxSlab = incomeTaxSlab;
	}

	@Override
	public Class<?> getModelClass() {
		return IncomeTaxSlab.class;
	}

	@Override
	public String getModelClassName() {
		return IncomeTaxSlab.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("incomeTaxSlabId", getIncomeTaxSlabId());
		attributes.put("financialYear", getFinancialYear());
		attributes.put("companyId", getCompanyId());
		attributes.put("incomeFrom", getIncomeFrom());
		attributes.put("incomeTo", getIncomeTo());
		attributes.put("taxRate", getTaxRate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long incomeTaxSlabId = (Long)attributes.get("incomeTaxSlabId");

		if (incomeTaxSlabId != null) {
			setIncomeTaxSlabId(incomeTaxSlabId);
		}

		String financialYear = (String)attributes.get("financialYear");

		if (financialYear != null) {
			setFinancialYear(financialYear);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Integer incomeFrom = (Integer)attributes.get("incomeFrom");

		if (incomeFrom != null) {
			setIncomeFrom(incomeFrom);
		}

		Integer incomeTo = (Integer)attributes.get("incomeTo");

		if (incomeTo != null) {
			setIncomeTo(incomeTo);
		}

		Double taxRate = (Double)attributes.get("taxRate");

		if (taxRate != null) {
			setTaxRate(taxRate);
		}
	}

	@Override
	public Object clone() {
		return new IncomeTaxSlabWrapper((IncomeTaxSlab)_incomeTaxSlab.clone());
	}

	@Override
	public int compareTo(IncomeTaxSlab incomeTaxSlab) {
		return _incomeTaxSlab.compareTo(incomeTaxSlab);
	}

	/**
	* Returns the company ID of this income tax slab.
	*
	* @return the company ID of this income tax slab
	*/
	@Override
	public long getCompanyId() {
		return _incomeTaxSlab.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _incomeTaxSlab.getExpandoBridge();
	}

	/**
	* Returns the financial year of this income tax slab.
	*
	* @return the financial year of this income tax slab
	*/
	@Override
	public String getFinancialYear() {
		return _incomeTaxSlab.getFinancialYear();
	}

	/**
	* Returns the income from of this income tax slab.
	*
	* @return the income from of this income tax slab
	*/
	@Override
	public int getIncomeFrom() {
		return _incomeTaxSlab.getIncomeFrom();
	}

	/**
	* Returns the income tax slab ID of this income tax slab.
	*
	* @return the income tax slab ID of this income tax slab
	*/
	@Override
	public long getIncomeTaxSlabId() {
		return _incomeTaxSlab.getIncomeTaxSlabId();
	}

	/**
	* Returns the income to of this income tax slab.
	*
	* @return the income to of this income tax slab
	*/
	@Override
	public int getIncomeTo() {
		return _incomeTaxSlab.getIncomeTo();
	}

	/**
	* Returns the primary key of this income tax slab.
	*
	* @return the primary key of this income tax slab
	*/
	@Override
	public long getPrimaryKey() {
		return _incomeTaxSlab.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _incomeTaxSlab.getPrimaryKeyObj();
	}

	/**
	* Returns the tax rate of this income tax slab.
	*
	* @return the tax rate of this income tax slab
	*/
	@Override
	public double getTaxRate() {
		return _incomeTaxSlab.getTaxRate();
	}

	@Override
	public int hashCode() {
		return _incomeTaxSlab.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _incomeTaxSlab.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _incomeTaxSlab.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _incomeTaxSlab.isNew();
	}

	@Override
	public void persist() {
		_incomeTaxSlab.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_incomeTaxSlab.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this income tax slab.
	*
	* @param companyId the company ID of this income tax slab
	*/
	@Override
	public void setCompanyId(long companyId) {
		_incomeTaxSlab.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_incomeTaxSlab.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_incomeTaxSlab.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_incomeTaxSlab.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the financial year of this income tax slab.
	*
	* @param financialYear the financial year of this income tax slab
	*/
	@Override
	public void setFinancialYear(String financialYear) {
		_incomeTaxSlab.setFinancialYear(financialYear);
	}

	/**
	* Sets the income from of this income tax slab.
	*
	* @param incomeFrom the income from of this income tax slab
	*/
	@Override
	public void setIncomeFrom(int incomeFrom) {
		_incomeTaxSlab.setIncomeFrom(incomeFrom);
	}

	/**
	* Sets the income tax slab ID of this income tax slab.
	*
	* @param incomeTaxSlabId the income tax slab ID of this income tax slab
	*/
	@Override
	public void setIncomeTaxSlabId(long incomeTaxSlabId) {
		_incomeTaxSlab.setIncomeTaxSlabId(incomeTaxSlabId);
	}

	/**
	* Sets the income to of this income tax slab.
	*
	* @param incomeTo the income to of this income tax slab
	*/
	@Override
	public void setIncomeTo(int incomeTo) {
		_incomeTaxSlab.setIncomeTo(incomeTo);
	}

	@Override
	public void setNew(boolean n) {
		_incomeTaxSlab.setNew(n);
	}

	/**
	* Sets the primary key of this income tax slab.
	*
	* @param primaryKey the primary key of this income tax slab
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_incomeTaxSlab.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_incomeTaxSlab.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tax rate of this income tax slab.
	*
	* @param taxRate the tax rate of this income tax slab
	*/
	@Override
	public void setTaxRate(double taxRate) {
		_incomeTaxSlab.setTaxRate(taxRate);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<IncomeTaxSlab> toCacheModel() {
		return _incomeTaxSlab.toCacheModel();
	}

	@Override
	public IncomeTaxSlab toEscapedModel() {
		return new IncomeTaxSlabWrapper(_incomeTaxSlab.toEscapedModel());
	}

	@Override
	public String toString() {
		return _incomeTaxSlab.toString();
	}

	@Override
	public IncomeTaxSlab toUnescapedModel() {
		return new IncomeTaxSlabWrapper(_incomeTaxSlab.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _incomeTaxSlab.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IncomeTaxSlabWrapper)) {
			return false;
		}

		IncomeTaxSlabWrapper incomeTaxSlabWrapper = (IncomeTaxSlabWrapper)obj;

		if (Objects.equals(_incomeTaxSlab, incomeTaxSlabWrapper._incomeTaxSlab)) {
			return true;
		}

		return false;
	}

	@Override
	public IncomeTaxSlab getWrappedModel() {
		return _incomeTaxSlab;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _incomeTaxSlab.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _incomeTaxSlab.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_incomeTaxSlab.resetOriginalValues();
	}

	private final IncomeTaxSlab _incomeTaxSlab;
}