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
 * This class is a wrapper for {@link ExpCategory}.
 * </p>
 *
 * @author Samaresh
 * @see ExpCategory
 * @generated
 */
@ProviderType
public class ExpCategoryWrapper implements ExpCategory,
	ModelWrapper<ExpCategory> {
	public ExpCategoryWrapper(ExpCategory expCategory) {
		_expCategory = expCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return ExpCategory.class;
	}

	@Override
	public String getModelClassName() {
		return ExpCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("catId", getCatId());
		attributes.put("companyId", getCompanyId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("frequency", getFrequency());
		attributes.put("salaryHead", getSalaryHead());
		attributes.put("finalApprovalRoleId", getFinalApprovalRoleId());
		attributes.put("attachment", isAttachment());
		attributes.put("componentId", getComponentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long catId = (Long)attributes.get("catId");

		if (catId != null) {
			setCatId(catId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String frequency = (String)attributes.get("frequency");

		if (frequency != null) {
			setFrequency(frequency);
		}

		Long salaryHead = (Long)attributes.get("salaryHead");

		if (salaryHead != null) {
			setSalaryHead(salaryHead);
		}

		Long finalApprovalRoleId = (Long)attributes.get("finalApprovalRoleId");

		if (finalApprovalRoleId != null) {
			setFinalApprovalRoleId(finalApprovalRoleId);
		}

		Boolean attachment = (Boolean)attributes.get("attachment");

		if (attachment != null) {
			setAttachment(attachment);
		}

		Long componentId = (Long)attributes.get("componentId");

		if (componentId != null) {
			setComponentId(componentId);
		}
	}

	@Override
	public Object clone() {
		return new ExpCategoryWrapper((ExpCategory)_expCategory.clone());
	}

	@Override
	public int compareTo(ExpCategory expCategory) {
		return _expCategory.compareTo(expCategory);
	}

	/**
	* Returns the attachment of this exp category.
	*
	* @return the attachment of this exp category
	*/
	@Override
	public boolean getAttachment() {
		return _expCategory.getAttachment();
	}

	/**
	* Returns the category name of this exp category.
	*
	* @return the category name of this exp category
	*/
	@Override
	public String getCategoryName() {
		return _expCategory.getCategoryName();
	}

	/**
	* Returns the cat ID of this exp category.
	*
	* @return the cat ID of this exp category
	*/
	@Override
	public long getCatId() {
		return _expCategory.getCatId();
	}

	/**
	* Returns the company ID of this exp category.
	*
	* @return the company ID of this exp category
	*/
	@Override
	public long getCompanyId() {
		return _expCategory.getCompanyId();
	}

	/**
	* Returns the component ID of this exp category.
	*
	* @return the component ID of this exp category
	*/
	@Override
	public long getComponentId() {
		return _expCategory.getComponentId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _expCategory.getExpandoBridge();
	}

	/**
	* Returns the final approval role ID of this exp category.
	*
	* @return the final approval role ID of this exp category
	*/
	@Override
	public long getFinalApprovalRoleId() {
		return _expCategory.getFinalApprovalRoleId();
	}

	/**
	* Returns the frequency of this exp category.
	*
	* @return the frequency of this exp category
	*/
	@Override
	public String getFrequency() {
		return _expCategory.getFrequency();
	}

	/**
	* Returns the primary key of this exp category.
	*
	* @return the primary key of this exp category
	*/
	@Override
	public long getPrimaryKey() {
		return _expCategory.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _expCategory.getPrimaryKeyObj();
	}

	/**
	* Returns the salary head of this exp category.
	*
	* @return the salary head of this exp category
	*/
	@Override
	public long getSalaryHead() {
		return _expCategory.getSalaryHead();
	}

	@Override
	public int hashCode() {
		return _expCategory.hashCode();
	}

	/**
	* Returns <code>true</code> if this exp category is attachment.
	*
	* @return <code>true</code> if this exp category is attachment; <code>false</code> otherwise
	*/
	@Override
	public boolean isAttachment() {
		return _expCategory.isAttachment();
	}

	@Override
	public boolean isCachedModel() {
		return _expCategory.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _expCategory.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _expCategory.isNew();
	}

	@Override
	public void persist() {
		_expCategory.persist();
	}

	/**
	* Sets whether this exp category is attachment.
	*
	* @param attachment the attachment of this exp category
	*/
	@Override
	public void setAttachment(boolean attachment) {
		_expCategory.setAttachment(attachment);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_expCategory.setCachedModel(cachedModel);
	}

	/**
	* Sets the category name of this exp category.
	*
	* @param categoryName the category name of this exp category
	*/
	@Override
	public void setCategoryName(String categoryName) {
		_expCategory.setCategoryName(categoryName);
	}

	/**
	* Sets the cat ID of this exp category.
	*
	* @param catId the cat ID of this exp category
	*/
	@Override
	public void setCatId(long catId) {
		_expCategory.setCatId(catId);
	}

	/**
	* Sets the company ID of this exp category.
	*
	* @param companyId the company ID of this exp category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_expCategory.setCompanyId(companyId);
	}

	/**
	* Sets the component ID of this exp category.
	*
	* @param componentId the component ID of this exp category
	*/
	@Override
	public void setComponentId(long componentId) {
		_expCategory.setComponentId(componentId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_expCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_expCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_expCategory.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the final approval role ID of this exp category.
	*
	* @param finalApprovalRoleId the final approval role ID of this exp category
	*/
	@Override
	public void setFinalApprovalRoleId(long finalApprovalRoleId) {
		_expCategory.setFinalApprovalRoleId(finalApprovalRoleId);
	}

	/**
	* Sets the frequency of this exp category.
	*
	* @param frequency the frequency of this exp category
	*/
	@Override
	public void setFrequency(String frequency) {
		_expCategory.setFrequency(frequency);
	}

	@Override
	public void setNew(boolean n) {
		_expCategory.setNew(n);
	}

	/**
	* Sets the primary key of this exp category.
	*
	* @param primaryKey the primary key of this exp category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_expCategory.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_expCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the salary head of this exp category.
	*
	* @param salaryHead the salary head of this exp category
	*/
	@Override
	public void setSalaryHead(long salaryHead) {
		_expCategory.setSalaryHead(salaryHead);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ExpCategory> toCacheModel() {
		return _expCategory.toCacheModel();
	}

	@Override
	public ExpCategory toEscapedModel() {
		return new ExpCategoryWrapper(_expCategory.toEscapedModel());
	}

	@Override
	public String toString() {
		return _expCategory.toString();
	}

	@Override
	public ExpCategory toUnescapedModel() {
		return new ExpCategoryWrapper(_expCategory.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _expCategory.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpCategoryWrapper)) {
			return false;
		}

		ExpCategoryWrapper expCategoryWrapper = (ExpCategoryWrapper)obj;

		if (Objects.equals(_expCategory, expCategoryWrapper._expCategory)) {
			return true;
		}

		return false;
	}

	@Override
	public ExpCategory getWrappedModel() {
		return _expCategory;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _expCategory.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _expCategory.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_expCategory.resetOriginalValues();
	}

	private final ExpCategory _expCategory;
}