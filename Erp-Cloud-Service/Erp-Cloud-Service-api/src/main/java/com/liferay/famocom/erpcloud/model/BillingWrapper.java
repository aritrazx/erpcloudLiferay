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
 * This class is a wrapper for {@link Billing}.
 * </p>
 *
 * @author Samaresh
 * @see Billing
 * @generated
 */
@ProviderType
public class BillingWrapper implements Billing, ModelWrapper<Billing> {
	public BillingWrapper(Billing billing) {
		_billing = billing;
	}

	@Override
	public Class<?> getModelClass() {
		return Billing.class;
	}

	@Override
	public String getModelClassName() {
		return Billing.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("billingId", getBillingId());
		attributes.put("milestoneId", getMilestoneId());
		attributes.put("billingNumber", getBillingNumber());
		attributes.put("billingDate", getBillingDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long billingId = (Long)attributes.get("billingId");

		if (billingId != null) {
			setBillingId(billingId);
		}

		Long milestoneId = (Long)attributes.get("milestoneId");

		if (milestoneId != null) {
			setMilestoneId(milestoneId);
		}

		String billingNumber = (String)attributes.get("billingNumber");

		if (billingNumber != null) {
			setBillingNumber(billingNumber);
		}

		String billingDate = (String)attributes.get("billingDate");

		if (billingDate != null) {
			setBillingDate(billingDate);
		}
	}

	@Override
	public Object clone() {
		return new BillingWrapper((Billing)_billing.clone());
	}

	@Override
	public int compareTo(Billing billing) {
		return _billing.compareTo(billing);
	}

	/**
	* Returns the billing date of this billing.
	*
	* @return the billing date of this billing
	*/
	@Override
	public String getBillingDate() {
		return _billing.getBillingDate();
	}

	/**
	* Returns the billing ID of this billing.
	*
	* @return the billing ID of this billing
	*/
	@Override
	public long getBillingId() {
		return _billing.getBillingId();
	}

	/**
	* Returns the billing number of this billing.
	*
	* @return the billing number of this billing
	*/
	@Override
	public String getBillingNumber() {
		return _billing.getBillingNumber();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _billing.getExpandoBridge();
	}

	/**
	* Returns the milestone ID of this billing.
	*
	* @return the milestone ID of this billing
	*/
	@Override
	public long getMilestoneId() {
		return _billing.getMilestoneId();
	}

	/**
	* Returns the primary key of this billing.
	*
	* @return the primary key of this billing
	*/
	@Override
	public long getPrimaryKey() {
		return _billing.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _billing.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _billing.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _billing.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _billing.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _billing.isNew();
	}

	@Override
	public void persist() {
		_billing.persist();
	}

	/**
	* Sets the billing date of this billing.
	*
	* @param billingDate the billing date of this billing
	*/
	@Override
	public void setBillingDate(String billingDate) {
		_billing.setBillingDate(billingDate);
	}

	/**
	* Sets the billing ID of this billing.
	*
	* @param billingId the billing ID of this billing
	*/
	@Override
	public void setBillingId(long billingId) {
		_billing.setBillingId(billingId);
	}

	/**
	* Sets the billing number of this billing.
	*
	* @param billingNumber the billing number of this billing
	*/
	@Override
	public void setBillingNumber(String billingNumber) {
		_billing.setBillingNumber(billingNumber);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_billing.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_billing.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_billing.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_billing.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the milestone ID of this billing.
	*
	* @param milestoneId the milestone ID of this billing
	*/
	@Override
	public void setMilestoneId(long milestoneId) {
		_billing.setMilestoneId(milestoneId);
	}

	@Override
	public void setNew(boolean n) {
		_billing.setNew(n);
	}

	/**
	* Sets the primary key of this billing.
	*
	* @param primaryKey the primary key of this billing
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_billing.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_billing.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Billing> toCacheModel() {
		return _billing.toCacheModel();
	}

	@Override
	public Billing toEscapedModel() {
		return new BillingWrapper(_billing.toEscapedModel());
	}

	@Override
	public String toString() {
		return _billing.toString();
	}

	@Override
	public Billing toUnescapedModel() {
		return new BillingWrapper(_billing.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _billing.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BillingWrapper)) {
			return false;
		}

		BillingWrapper billingWrapper = (BillingWrapper)obj;

		if (Objects.equals(_billing, billingWrapper._billing)) {
			return true;
		}

		return false;
	}

	@Override
	public Billing getWrappedModel() {
		return _billing;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _billing.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _billing.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_billing.resetOriginalValues();
	}

	private final Billing _billing;
}