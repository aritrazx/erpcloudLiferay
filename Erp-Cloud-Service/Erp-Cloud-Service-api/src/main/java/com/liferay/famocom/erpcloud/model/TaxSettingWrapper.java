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
 * This class is a wrapper for {@link TaxSetting}.
 * </p>
 *
 * @author Samaresh
 * @see TaxSetting
 * @generated
 */
@ProviderType
public class TaxSettingWrapper implements TaxSetting, ModelWrapper<TaxSetting> {
	public TaxSettingWrapper(TaxSetting taxSetting) {
		_taxSetting = taxSetting;
	}

	@Override
	public Class<?> getModelClass() {
		return TaxSetting.class;
	}

	@Override
	public String getModelClassName() {
		return TaxSetting.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taxSettingId", getTaxSettingId());
		attributes.put("componentId", getComponentId());
		attributes.put("componentName", getComponentName());
		attributes.put("taxFormulla", getTaxFormulla());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taxSettingId = (Long)attributes.get("taxSettingId");

		if (taxSettingId != null) {
			setTaxSettingId(taxSettingId);
		}

		Long componentId = (Long)attributes.get("componentId");

		if (componentId != null) {
			setComponentId(componentId);
		}

		String componentName = (String)attributes.get("componentName");

		if (componentName != null) {
			setComponentName(componentName);
		}

		String taxFormulla = (String)attributes.get("taxFormulla");

		if (taxFormulla != null) {
			setTaxFormulla(taxFormulla);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new TaxSettingWrapper((TaxSetting)_taxSetting.clone());
	}

	@Override
	public int compareTo(TaxSetting taxSetting) {
		return _taxSetting.compareTo(taxSetting);
	}

	/**
	* Returns the component ID of this tax setting.
	*
	* @return the component ID of this tax setting
	*/
	@Override
	public long getComponentId() {
		return _taxSetting.getComponentId();
	}

	/**
	* Returns the component name of this tax setting.
	*
	* @return the component name of this tax setting
	*/
	@Override
	public String getComponentName() {
		return _taxSetting.getComponentName();
	}

	/**
	* Returns the created by of this tax setting.
	*
	* @return the created by of this tax setting
	*/
	@Override
	public long getCreatedBy() {
		return _taxSetting.getCreatedBy();
	}

	/**
	* Returns the created date of this tax setting.
	*
	* @return the created date of this tax setting
	*/
	@Override
	public Date getCreatedDate() {
		return _taxSetting.getCreatedDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _taxSetting.getExpandoBridge();
	}

	/**
	* Returns the modified date of this tax setting.
	*
	* @return the modified date of this tax setting
	*/
	@Override
	public Date getModifiedDate() {
		return _taxSetting.getModifiedDate();
	}

	/**
	* Returns the primary key of this tax setting.
	*
	* @return the primary key of this tax setting
	*/
	@Override
	public long getPrimaryKey() {
		return _taxSetting.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taxSetting.getPrimaryKeyObj();
	}

	/**
	* Returns the tax formulla of this tax setting.
	*
	* @return the tax formulla of this tax setting
	*/
	@Override
	public String getTaxFormulla() {
		return _taxSetting.getTaxFormulla();
	}

	/**
	* Returns the tax setting ID of this tax setting.
	*
	* @return the tax setting ID of this tax setting
	*/
	@Override
	public long getTaxSettingId() {
		return _taxSetting.getTaxSettingId();
	}

	@Override
	public int hashCode() {
		return _taxSetting.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _taxSetting.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _taxSetting.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _taxSetting.isNew();
	}

	@Override
	public void persist() {
		_taxSetting.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taxSetting.setCachedModel(cachedModel);
	}

	/**
	* Sets the component ID of this tax setting.
	*
	* @param componentId the component ID of this tax setting
	*/
	@Override
	public void setComponentId(long componentId) {
		_taxSetting.setComponentId(componentId);
	}

	/**
	* Sets the component name of this tax setting.
	*
	* @param componentName the component name of this tax setting
	*/
	@Override
	public void setComponentName(String componentName) {
		_taxSetting.setComponentName(componentName);
	}

	/**
	* Sets the created by of this tax setting.
	*
	* @param createdBy the created by of this tax setting
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_taxSetting.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this tax setting.
	*
	* @param createdDate the created date of this tax setting
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_taxSetting.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_taxSetting.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_taxSetting.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_taxSetting.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this tax setting.
	*
	* @param modifiedDate the modified date of this tax setting
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_taxSetting.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_taxSetting.setNew(n);
	}

	/**
	* Sets the primary key of this tax setting.
	*
	* @param primaryKey the primary key of this tax setting
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taxSetting.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_taxSetting.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tax formulla of this tax setting.
	*
	* @param taxFormulla the tax formulla of this tax setting
	*/
	@Override
	public void setTaxFormulla(String taxFormulla) {
		_taxSetting.setTaxFormulla(taxFormulla);
	}

	/**
	* Sets the tax setting ID of this tax setting.
	*
	* @param taxSettingId the tax setting ID of this tax setting
	*/
	@Override
	public void setTaxSettingId(long taxSettingId) {
		_taxSetting.setTaxSettingId(taxSettingId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TaxSetting> toCacheModel() {
		return _taxSetting.toCacheModel();
	}

	@Override
	public TaxSetting toEscapedModel() {
		return new TaxSettingWrapper(_taxSetting.toEscapedModel());
	}

	@Override
	public String toString() {
		return _taxSetting.toString();
	}

	@Override
	public TaxSetting toUnescapedModel() {
		return new TaxSettingWrapper(_taxSetting.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _taxSetting.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaxSettingWrapper)) {
			return false;
		}

		TaxSettingWrapper taxSettingWrapper = (TaxSettingWrapper)obj;

		if (Objects.equals(_taxSetting, taxSettingWrapper._taxSetting)) {
			return true;
		}

		return false;
	}

	@Override
	public TaxSetting getWrappedModel() {
		return _taxSetting;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _taxSetting.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _taxSetting.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_taxSetting.resetOriginalValues();
	}

	private final TaxSetting _taxSetting;
}