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
 * This class is a wrapper for {@link CompanyPolicy}.
 * </p>
 *
 * @author Samaresh
 * @see CompanyPolicy
 * @generated
 */
@ProviderType
public class CompanyPolicyWrapper implements CompanyPolicy,
	ModelWrapper<CompanyPolicy> {
	public CompanyPolicyWrapper(CompanyPolicy companyPolicy) {
		_companyPolicy = companyPolicy;
	}

	@Override
	public Class<?> getModelClass() {
		return CompanyPolicy.class;
	}

	@Override
	public String getModelClassName() {
		return CompanyPolicy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyPolicyId", getCompanyPolicyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("daysLocking", getDaysLocking());
		attributes.put("checkStatus", getCheckStatus());
		attributes.put("addedDate", getAddedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyPolicyId = (Long)attributes.get("companyPolicyId");

		if (companyPolicyId != null) {
			setCompanyPolicyId(companyPolicyId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Integer daysLocking = (Integer)attributes.get("daysLocking");

		if (daysLocking != null) {
			setDaysLocking(daysLocking);
		}

		Integer checkStatus = (Integer)attributes.get("checkStatus");

		if (checkStatus != null) {
			setCheckStatus(checkStatus);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new CompanyPolicyWrapper((CompanyPolicy)_companyPolicy.clone());
	}

	@Override
	public int compareTo(CompanyPolicy companyPolicy) {
		return _companyPolicy.compareTo(companyPolicy);
	}

	/**
	* Returns the added date of this company policy.
	*
	* @return the added date of this company policy
	*/
	@Override
	public Date getAddedDate() {
		return _companyPolicy.getAddedDate();
	}

	/**
	* Returns the check status of this company policy.
	*
	* @return the check status of this company policy
	*/
	@Override
	public int getCheckStatus() {
		return _companyPolicy.getCheckStatus();
	}

	/**
	* Returns the company ID of this company policy.
	*
	* @return the company ID of this company policy
	*/
	@Override
	public long getCompanyId() {
		return _companyPolicy.getCompanyId();
	}

	/**
	* Returns the company policy ID of this company policy.
	*
	* @return the company policy ID of this company policy
	*/
	@Override
	public long getCompanyPolicyId() {
		return _companyPolicy.getCompanyPolicyId();
	}

	/**
	* Returns the days locking of this company policy.
	*
	* @return the days locking of this company policy
	*/
	@Override
	public int getDaysLocking() {
		return _companyPolicy.getDaysLocking();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _companyPolicy.getExpandoBridge();
	}

	/**
	* Returns the modified date of this company policy.
	*
	* @return the modified date of this company policy
	*/
	@Override
	public Date getModifiedDate() {
		return _companyPolicy.getModifiedDate();
	}

	/**
	* Returns the primary key of this company policy.
	*
	* @return the primary key of this company policy
	*/
	@Override
	public long getPrimaryKey() {
		return _companyPolicy.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _companyPolicy.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _companyPolicy.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _companyPolicy.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _companyPolicy.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _companyPolicy.isNew();
	}

	@Override
	public void persist() {
		_companyPolicy.persist();
	}

	/**
	* Sets the added date of this company policy.
	*
	* @param addedDate the added date of this company policy
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_companyPolicy.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_companyPolicy.setCachedModel(cachedModel);
	}

	/**
	* Sets the check status of this company policy.
	*
	* @param checkStatus the check status of this company policy
	*/
	@Override
	public void setCheckStatus(int checkStatus) {
		_companyPolicy.setCheckStatus(checkStatus);
	}

	/**
	* Sets the company ID of this company policy.
	*
	* @param companyId the company ID of this company policy
	*/
	@Override
	public void setCompanyId(long companyId) {
		_companyPolicy.setCompanyId(companyId);
	}

	/**
	* Sets the company policy ID of this company policy.
	*
	* @param companyPolicyId the company policy ID of this company policy
	*/
	@Override
	public void setCompanyPolicyId(long companyPolicyId) {
		_companyPolicy.setCompanyPolicyId(companyPolicyId);
	}

	/**
	* Sets the days locking of this company policy.
	*
	* @param daysLocking the days locking of this company policy
	*/
	@Override
	public void setDaysLocking(int daysLocking) {
		_companyPolicy.setDaysLocking(daysLocking);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_companyPolicy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_companyPolicy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_companyPolicy.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this company policy.
	*
	* @param modifiedDate the modified date of this company policy
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_companyPolicy.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_companyPolicy.setNew(n);
	}

	/**
	* Sets the primary key of this company policy.
	*
	* @param primaryKey the primary key of this company policy
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_companyPolicy.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_companyPolicy.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CompanyPolicy> toCacheModel() {
		return _companyPolicy.toCacheModel();
	}

	@Override
	public CompanyPolicy toEscapedModel() {
		return new CompanyPolicyWrapper(_companyPolicy.toEscapedModel());
	}

	@Override
	public String toString() {
		return _companyPolicy.toString();
	}

	@Override
	public CompanyPolicy toUnescapedModel() {
		return new CompanyPolicyWrapper(_companyPolicy.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _companyPolicy.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CompanyPolicyWrapper)) {
			return false;
		}

		CompanyPolicyWrapper companyPolicyWrapper = (CompanyPolicyWrapper)obj;

		if (Objects.equals(_companyPolicy, companyPolicyWrapper._companyPolicy)) {
			return true;
		}

		return false;
	}

	@Override
	public CompanyPolicy getWrappedModel() {
		return _companyPolicy;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _companyPolicy.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _companyPolicy.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_companyPolicy.resetOriginalValues();
	}

	private final CompanyPolicy _companyPolicy;
}