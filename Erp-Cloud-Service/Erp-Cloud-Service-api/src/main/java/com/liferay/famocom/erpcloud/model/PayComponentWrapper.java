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
 * This class is a wrapper for {@link PayComponent}.
 * </p>
 *
 * @author Samaresh
 * @see PayComponent
 * @generated
 */
@ProviderType
public class PayComponentWrapper implements PayComponent,
	ModelWrapper<PayComponent> {
	public PayComponentWrapper(PayComponent payComponent) {
		_payComponent = payComponent;
	}

	@Override
	public Class<?> getModelClass() {
		return PayComponent.class;
	}

	@Override
	public String getModelClassName() {
		return PayComponent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("componentId", getComponentId());
		attributes.put("employeeTypeId", getEmployeeTypeId());
		attributes.put("name", getName());
		attributes.put("abbreviation", getAbbreviation());
		attributes.put("taxStatus", getTaxStatus());
		attributes.put("payType", getPayType());
		attributes.put("componentType", getComponentType());
		attributes.put("componentValueFormula", getComponentValueFormula());
		attributes.put("partOfCtc", getPartOfCtc());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("islock", getIslock());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("amount", getAmount());
		attributes.put("payComponentOrder", getPayComponentOrder());
		attributes.put("autoAddPayStructure", getAutoAddPayStructure());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long componentId = (Long)attributes.get("componentId");

		if (componentId != null) {
			setComponentId(componentId);
		}

		Long employeeTypeId = (Long)attributes.get("employeeTypeId");

		if (employeeTypeId != null) {
			setEmployeeTypeId(employeeTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String abbreviation = (String)attributes.get("abbreviation");

		if (abbreviation != null) {
			setAbbreviation(abbreviation);
		}

		Integer taxStatus = (Integer)attributes.get("taxStatus");

		if (taxStatus != null) {
			setTaxStatus(taxStatus);
		}

		String payType = (String)attributes.get("payType");

		if (payType != null) {
			setPayType(payType);
		}

		Integer componentType = (Integer)attributes.get("componentType");

		if (componentType != null) {
			setComponentType(componentType);
		}

		String componentValueFormula = (String)attributes.get(
				"componentValueFormula");

		if (componentValueFormula != null) {
			setComponentValueFormula(componentValueFormula);
		}

		Integer partOfCtc = (Integer)attributes.get("partOfCtc");

		if (partOfCtc != null) {
			setPartOfCtc(partOfCtc);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		Long islock = (Long)attributes.get("islock");

		if (islock != null) {
			setIslock(islock);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long payComponentOrder = (Long)attributes.get("payComponentOrder");

		if (payComponentOrder != null) {
			setPayComponentOrder(payComponentOrder);
		}

		Integer autoAddPayStructure = (Integer)attributes.get(
				"autoAddPayStructure");

		if (autoAddPayStructure != null) {
			setAutoAddPayStructure(autoAddPayStructure);
		}
	}

	@Override
	public Object clone() {
		return new PayComponentWrapper((PayComponent)_payComponent.clone());
	}

	@Override
	public int compareTo(PayComponent payComponent) {
		return _payComponent.compareTo(payComponent);
	}

	/**
	* Returns the abbreviation of this pay component.
	*
	* @return the abbreviation of this pay component
	*/
	@Override
	public String getAbbreviation() {
		return _payComponent.getAbbreviation();
	}

	/**
	* Returns the amount of this pay component.
	*
	* @return the amount of this pay component
	*/
	@Override
	public double getAmount() {
		return _payComponent.getAmount();
	}

	/**
	* Returns the auto add pay structure of this pay component.
	*
	* @return the auto add pay structure of this pay component
	*/
	@Override
	public int getAutoAddPayStructure() {
		return _payComponent.getAutoAddPayStructure();
	}

	/**
	* Returns the component ID of this pay component.
	*
	* @return the component ID of this pay component
	*/
	@Override
	public long getComponentId() {
		return _payComponent.getComponentId();
	}

	/**
	* Returns the component type of this pay component.
	*
	* @return the component type of this pay component
	*/
	@Override
	public int getComponentType() {
		return _payComponent.getComponentType();
	}

	/**
	* Returns the component value formula of this pay component.
	*
	* @return the component value formula of this pay component
	*/
	@Override
	public String getComponentValueFormula() {
		return _payComponent.getComponentValueFormula();
	}

	/**
	* Returns the create date of this pay component.
	*
	* @return the create date of this pay component
	*/
	@Override
	public Date getCreateDate() {
		return _payComponent.getCreateDate();
	}

	/**
	* Returns the effective date of this pay component.
	*
	* @return the effective date of this pay component
	*/
	@Override
	public Date getEffectiveDate() {
		return _payComponent.getEffectiveDate();
	}

	/**
	* Returns the employee type ID of this pay component.
	*
	* @return the employee type ID of this pay component
	*/
	@Override
	public long getEmployeeTypeId() {
		return _payComponent.getEmployeeTypeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _payComponent.getExpandoBridge();
	}

	/**
	* Returns the islock of this pay component.
	*
	* @return the islock of this pay component
	*/
	@Override
	public long getIslock() {
		return _payComponent.getIslock();
	}

	/**
	* Returns the modified date of this pay component.
	*
	* @return the modified date of this pay component
	*/
	@Override
	public Date getModifiedDate() {
		return _payComponent.getModifiedDate();
	}

	/**
	* Returns the name of this pay component.
	*
	* @return the name of this pay component
	*/
	@Override
	public String getName() {
		return _payComponent.getName();
	}

	/**
	* Returns the part of ctc of this pay component.
	*
	* @return the part of ctc of this pay component
	*/
	@Override
	public int getPartOfCtc() {
		return _payComponent.getPartOfCtc();
	}

	/**
	* Returns the pay component order of this pay component.
	*
	* @return the pay component order of this pay component
	*/
	@Override
	public long getPayComponentOrder() {
		return _payComponent.getPayComponentOrder();
	}

	/**
	* Returns the pay type of this pay component.
	*
	* @return the pay type of this pay component
	*/
	@Override
	public String getPayType() {
		return _payComponent.getPayType();
	}

	/**
	* Returns the primary key of this pay component.
	*
	* @return the primary key of this pay component
	*/
	@Override
	public long getPrimaryKey() {
		return _payComponent.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _payComponent.getPrimaryKeyObj();
	}

	/**
	* Returns the tax status of this pay component.
	*
	* @return the tax status of this pay component
	*/
	@Override
	public int getTaxStatus() {
		return _payComponent.getTaxStatus();
	}

	@Override
	public int hashCode() {
		return _payComponent.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _payComponent.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _payComponent.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _payComponent.isNew();
	}

	@Override
	public void persist() {
		_payComponent.persist();
	}

	/**
	* Sets the abbreviation of this pay component.
	*
	* @param abbreviation the abbreviation of this pay component
	*/
	@Override
	public void setAbbreviation(String abbreviation) {
		_payComponent.setAbbreviation(abbreviation);
	}

	/**
	* Sets the amount of this pay component.
	*
	* @param amount the amount of this pay component
	*/
	@Override
	public void setAmount(double amount) {
		_payComponent.setAmount(amount);
	}

	/**
	* Sets the auto add pay structure of this pay component.
	*
	* @param autoAddPayStructure the auto add pay structure of this pay component
	*/
	@Override
	public void setAutoAddPayStructure(int autoAddPayStructure) {
		_payComponent.setAutoAddPayStructure(autoAddPayStructure);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_payComponent.setCachedModel(cachedModel);
	}

	/**
	* Sets the component ID of this pay component.
	*
	* @param componentId the component ID of this pay component
	*/
	@Override
	public void setComponentId(long componentId) {
		_payComponent.setComponentId(componentId);
	}

	/**
	* Sets the component type of this pay component.
	*
	* @param componentType the component type of this pay component
	*/
	@Override
	public void setComponentType(int componentType) {
		_payComponent.setComponentType(componentType);
	}

	/**
	* Sets the component value formula of this pay component.
	*
	* @param componentValueFormula the component value formula of this pay component
	*/
	@Override
	public void setComponentValueFormula(String componentValueFormula) {
		_payComponent.setComponentValueFormula(componentValueFormula);
	}

	/**
	* Sets the create date of this pay component.
	*
	* @param createDate the create date of this pay component
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_payComponent.setCreateDate(createDate);
	}

	/**
	* Sets the effective date of this pay component.
	*
	* @param effectiveDate the effective date of this pay component
	*/
	@Override
	public void setEffectiveDate(Date effectiveDate) {
		_payComponent.setEffectiveDate(effectiveDate);
	}

	/**
	* Sets the employee type ID of this pay component.
	*
	* @param employeeTypeId the employee type ID of this pay component
	*/
	@Override
	public void setEmployeeTypeId(long employeeTypeId) {
		_payComponent.setEmployeeTypeId(employeeTypeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_payComponent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_payComponent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_payComponent.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the islock of this pay component.
	*
	* @param islock the islock of this pay component
	*/
	@Override
	public void setIslock(long islock) {
		_payComponent.setIslock(islock);
	}

	/**
	* Sets the modified date of this pay component.
	*
	* @param modifiedDate the modified date of this pay component
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_payComponent.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this pay component.
	*
	* @param name the name of this pay component
	*/
	@Override
	public void setName(String name) {
		_payComponent.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_payComponent.setNew(n);
	}

	/**
	* Sets the part of ctc of this pay component.
	*
	* @param partOfCtc the part of ctc of this pay component
	*/
	@Override
	public void setPartOfCtc(int partOfCtc) {
		_payComponent.setPartOfCtc(partOfCtc);
	}

	/**
	* Sets the pay component order of this pay component.
	*
	* @param payComponentOrder the pay component order of this pay component
	*/
	@Override
	public void setPayComponentOrder(long payComponentOrder) {
		_payComponent.setPayComponentOrder(payComponentOrder);
	}

	/**
	* Sets the pay type of this pay component.
	*
	* @param payType the pay type of this pay component
	*/
	@Override
	public void setPayType(String payType) {
		_payComponent.setPayType(payType);
	}

	/**
	* Sets the primary key of this pay component.
	*
	* @param primaryKey the primary key of this pay component
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_payComponent.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_payComponent.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tax status of this pay component.
	*
	* @param taxStatus the tax status of this pay component
	*/
	@Override
	public void setTaxStatus(int taxStatus) {
		_payComponent.setTaxStatus(taxStatus);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PayComponent> toCacheModel() {
		return _payComponent.toCacheModel();
	}

	@Override
	public PayComponent toEscapedModel() {
		return new PayComponentWrapper(_payComponent.toEscapedModel());
	}

	@Override
	public String toString() {
		return _payComponent.toString();
	}

	@Override
	public PayComponent toUnescapedModel() {
		return new PayComponentWrapper(_payComponent.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _payComponent.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayComponentWrapper)) {
			return false;
		}

		PayComponentWrapper payComponentWrapper = (PayComponentWrapper)obj;

		if (Objects.equals(_payComponent, payComponentWrapper._payComponent)) {
			return true;
		}

		return false;
	}

	@Override
	public PayComponent getWrappedModel() {
		return _payComponent;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _payComponent.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _payComponent.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_payComponent.resetOriginalValues();
	}

	private final PayComponent _payComponent;
}