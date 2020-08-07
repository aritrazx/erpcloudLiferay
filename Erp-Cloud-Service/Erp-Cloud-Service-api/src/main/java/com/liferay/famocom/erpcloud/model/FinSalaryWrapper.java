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
 * This class is a wrapper for {@link FinSalary}.
 * </p>
 *
 * @author Samaresh
 * @see FinSalary
 * @generated
 */
@ProviderType
public class FinSalaryWrapper implements FinSalary, ModelWrapper<FinSalary> {
	public FinSalaryWrapper(FinSalary finSalary) {
		_finSalary = finSalary;
	}

	@Override
	public Class<?> getModelClass() {
		return FinSalary.class;
	}

	@Override
	public String getModelClassName() {
		return FinSalary.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("finSalaryId", getFinSalaryId());
		attributes.put("monthYear", getMonthYear());
		attributes.put("totalEarning", getTotalEarning());
		attributes.put("totalDeduction", getTotalDeduction());
		attributes.put("totalAmount", getTotalAmount());
		attributes.put("isLock", getIsLock());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long finSalaryId = (Long)attributes.get("finSalaryId");

		if (finSalaryId != null) {
			setFinSalaryId(finSalaryId);
		}

		Long monthYear = (Long)attributes.get("monthYear");

		if (monthYear != null) {
			setMonthYear(monthYear);
		}

		Double totalEarning = (Double)attributes.get("totalEarning");

		if (totalEarning != null) {
			setTotalEarning(totalEarning);
		}

		Double totalDeduction = (Double)attributes.get("totalDeduction");

		if (totalDeduction != null) {
			setTotalDeduction(totalDeduction);
		}

		Double totalAmount = (Double)attributes.get("totalAmount");

		if (totalAmount != null) {
			setTotalAmount(totalAmount);
		}

		Long isLock = (Long)attributes.get("isLock");

		if (isLock != null) {
			setIsLock(isLock);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public Object clone() {
		return new FinSalaryWrapper((FinSalary)_finSalary.clone());
	}

	@Override
	public int compareTo(FinSalary finSalary) {
		return _finSalary.compareTo(finSalary);
	}

	/**
	* Returns the created by of this fin salary.
	*
	* @return the created by of this fin salary
	*/
	@Override
	public long getCreatedBy() {
		return _finSalary.getCreatedBy();
	}

	/**
	* Returns the created date of this fin salary.
	*
	* @return the created date of this fin salary
	*/
	@Override
	public Date getCreatedDate() {
		return _finSalary.getCreatedDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _finSalary.getExpandoBridge();
	}

	/**
	* Returns the fin salary ID of this fin salary.
	*
	* @return the fin salary ID of this fin salary
	*/
	@Override
	public long getFinSalaryId() {
		return _finSalary.getFinSalaryId();
	}

	/**
	* Returns the is lock of this fin salary.
	*
	* @return the is lock of this fin salary
	*/
	@Override
	public long getIsLock() {
		return _finSalary.getIsLock();
	}

	/**
	* Returns the month year of this fin salary.
	*
	* @return the month year of this fin salary
	*/
	@Override
	public long getMonthYear() {
		return _finSalary.getMonthYear();
	}

	/**
	* Returns the primary key of this fin salary.
	*
	* @return the primary key of this fin salary
	*/
	@Override
	public long getPrimaryKey() {
		return _finSalary.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _finSalary.getPrimaryKeyObj();
	}

	/**
	* Returns the total amount of this fin salary.
	*
	* @return the total amount of this fin salary
	*/
	@Override
	public double getTotalAmount() {
		return _finSalary.getTotalAmount();
	}

	/**
	* Returns the total deduction of this fin salary.
	*
	* @return the total deduction of this fin salary
	*/
	@Override
	public double getTotalDeduction() {
		return _finSalary.getTotalDeduction();
	}

	/**
	* Returns the total earning of this fin salary.
	*
	* @return the total earning of this fin salary
	*/
	@Override
	public double getTotalEarning() {
		return _finSalary.getTotalEarning();
	}

	@Override
	public int hashCode() {
		return _finSalary.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _finSalary.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _finSalary.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _finSalary.isNew();
	}

	@Override
	public void persist() {
		_finSalary.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_finSalary.setCachedModel(cachedModel);
	}

	/**
	* Sets the created by of this fin salary.
	*
	* @param createdBy the created by of this fin salary
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_finSalary.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this fin salary.
	*
	* @param createdDate the created date of this fin salary
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_finSalary.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_finSalary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_finSalary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_finSalary.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the fin salary ID of this fin salary.
	*
	* @param finSalaryId the fin salary ID of this fin salary
	*/
	@Override
	public void setFinSalaryId(long finSalaryId) {
		_finSalary.setFinSalaryId(finSalaryId);
	}

	/**
	* Sets the is lock of this fin salary.
	*
	* @param isLock the is lock of this fin salary
	*/
	@Override
	public void setIsLock(long isLock) {
		_finSalary.setIsLock(isLock);
	}

	/**
	* Sets the month year of this fin salary.
	*
	* @param monthYear the month year of this fin salary
	*/
	@Override
	public void setMonthYear(long monthYear) {
		_finSalary.setMonthYear(monthYear);
	}

	@Override
	public void setNew(boolean n) {
		_finSalary.setNew(n);
	}

	/**
	* Sets the primary key of this fin salary.
	*
	* @param primaryKey the primary key of this fin salary
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_finSalary.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_finSalary.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the total amount of this fin salary.
	*
	* @param totalAmount the total amount of this fin salary
	*/
	@Override
	public void setTotalAmount(double totalAmount) {
		_finSalary.setTotalAmount(totalAmount);
	}

	/**
	* Sets the total deduction of this fin salary.
	*
	* @param totalDeduction the total deduction of this fin salary
	*/
	@Override
	public void setTotalDeduction(double totalDeduction) {
		_finSalary.setTotalDeduction(totalDeduction);
	}

	/**
	* Sets the total earning of this fin salary.
	*
	* @param totalEarning the total earning of this fin salary
	*/
	@Override
	public void setTotalEarning(double totalEarning) {
		_finSalary.setTotalEarning(totalEarning);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<FinSalary> toCacheModel() {
		return _finSalary.toCacheModel();
	}

	@Override
	public FinSalary toEscapedModel() {
		return new FinSalaryWrapper(_finSalary.toEscapedModel());
	}

	@Override
	public String toString() {
		return _finSalary.toString();
	}

	@Override
	public FinSalary toUnescapedModel() {
		return new FinSalaryWrapper(_finSalary.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _finSalary.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FinSalaryWrapper)) {
			return false;
		}

		FinSalaryWrapper finSalaryWrapper = (FinSalaryWrapper)obj;

		if (Objects.equals(_finSalary, finSalaryWrapper._finSalary)) {
			return true;
		}

		return false;
	}

	@Override
	public FinSalary getWrappedModel() {
		return _finSalary;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _finSalary.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finSalary.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_finSalary.resetOriginalValues();
	}

	private final FinSalary _finSalary;
}