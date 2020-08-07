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
 * This class is a wrapper for {@link FormSixteen}.
 * </p>
 *
 * @author Samaresh
 * @see FormSixteen
 * @generated
 */
@ProviderType
public class FormSixteenWrapper implements FormSixteen,
	ModelWrapper<FormSixteen> {
	public FormSixteenWrapper(FormSixteen formSixteen) {
		_formSixteen = formSixteen;
	}

	@Override
	public Class<?> getModelClass() {
		return FormSixteen.class;
	}

	@Override
	public String getModelClassName() {
		return FormSixteen.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("financialYear", getFinancialYear());
		attributes.put("fileEnteryId", getFileEnteryId());
		attributes.put("addedDate", getAddedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String financialYear = (String)attributes.get("financialYear");

		if (financialYear != null) {
			setFinancialYear(financialYear);
		}

		Long fileEnteryId = (Long)attributes.get("fileEnteryId");

		if (fileEnteryId != null) {
			setFileEnteryId(fileEnteryId);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public Object clone() {
		return new FormSixteenWrapper((FormSixteen)_formSixteen.clone());
	}

	@Override
	public int compareTo(FormSixteen formSixteen) {
		return _formSixteen.compareTo(formSixteen);
	}

	/**
	* Returns the added date of this form sixteen.
	*
	* @return the added date of this form sixteen
	*/
	@Override
	public Date getAddedDate() {
		return _formSixteen.getAddedDate();
	}

	/**
	* Returns the employee ID of this form sixteen.
	*
	* @return the employee ID of this form sixteen
	*/
	@Override
	public long getEmployeeId() {
		return _formSixteen.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _formSixteen.getExpandoBridge();
	}

	/**
	* Returns the file entery ID of this form sixteen.
	*
	* @return the file entery ID of this form sixteen
	*/
	@Override
	public long getFileEnteryId() {
		return _formSixteen.getFileEnteryId();
	}

	/**
	* Returns the financial year of this form sixteen.
	*
	* @return the financial year of this form sixteen
	*/
	@Override
	public String getFinancialYear() {
		return _formSixteen.getFinancialYear();
	}

	/**
	* Returns the ID of this form sixteen.
	*
	* @return the ID of this form sixteen
	*/
	@Override
	public long getId() {
		return _formSixteen.getId();
	}

	/**
	* Returns the primary key of this form sixteen.
	*
	* @return the primary key of this form sixteen
	*/
	@Override
	public long getPrimaryKey() {
		return _formSixteen.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formSixteen.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _formSixteen.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _formSixteen.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _formSixteen.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _formSixteen.isNew();
	}

	@Override
	public void persist() {
		_formSixteen.persist();
	}

	/**
	* Sets the added date of this form sixteen.
	*
	* @param addedDate the added date of this form sixteen
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_formSixteen.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_formSixteen.setCachedModel(cachedModel);
	}

	/**
	* Sets the employee ID of this form sixteen.
	*
	* @param employeeId the employee ID of this form sixteen
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_formSixteen.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_formSixteen.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_formSixteen.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_formSixteen.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entery ID of this form sixteen.
	*
	* @param fileEnteryId the file entery ID of this form sixteen
	*/
	@Override
	public void setFileEnteryId(long fileEnteryId) {
		_formSixteen.setFileEnteryId(fileEnteryId);
	}

	/**
	* Sets the financial year of this form sixteen.
	*
	* @param financialYear the financial year of this form sixteen
	*/
	@Override
	public void setFinancialYear(String financialYear) {
		_formSixteen.setFinancialYear(financialYear);
	}

	/**
	* Sets the ID of this form sixteen.
	*
	* @param id the ID of this form sixteen
	*/
	@Override
	public void setId(long id) {
		_formSixteen.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_formSixteen.setNew(n);
	}

	/**
	* Sets the primary key of this form sixteen.
	*
	* @param primaryKey the primary key of this form sixteen
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_formSixteen.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_formSixteen.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<FormSixteen> toCacheModel() {
		return _formSixteen.toCacheModel();
	}

	@Override
	public FormSixteen toEscapedModel() {
		return new FormSixteenWrapper(_formSixteen.toEscapedModel());
	}

	@Override
	public String toString() {
		return _formSixteen.toString();
	}

	@Override
	public FormSixteen toUnescapedModel() {
		return new FormSixteenWrapper(_formSixteen.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _formSixteen.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormSixteenWrapper)) {
			return false;
		}

		FormSixteenWrapper formSixteenWrapper = (FormSixteenWrapper)obj;

		if (Objects.equals(_formSixteen, formSixteenWrapper._formSixteen)) {
			return true;
		}

		return false;
	}

	@Override
	public FormSixteen getWrappedModel() {
		return _formSixteen;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _formSixteen.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _formSixteen.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_formSixteen.resetOriginalValues();
	}

	private final FormSixteen _formSixteen;
}