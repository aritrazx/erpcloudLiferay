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
 * This class is a wrapper for {@link FormSixteenErrorFile}.
 * </p>
 *
 * @author Samaresh
 * @see FormSixteenErrorFile
 * @generated
 */
@ProviderType
public class FormSixteenErrorFileWrapper implements FormSixteenErrorFile,
	ModelWrapper<FormSixteenErrorFile> {
	public FormSixteenErrorFileWrapper(
		FormSixteenErrorFile formSixteenErrorFile) {
		_formSixteenErrorFile = formSixteenErrorFile;
	}

	@Override
	public Class<?> getModelClass() {
		return FormSixteenErrorFile.class;
	}

	@Override
	public String getModelClassName() {
		return FormSixteenErrorFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("errorId", getErrorId());
		attributes.put("fileName", getFileName());
		attributes.put("errorMsg", getErrorMsg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long errorId = (Long)attributes.get("errorId");

		if (errorId != null) {
			setErrorId(errorId);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String errorMsg = (String)attributes.get("errorMsg");

		if (errorMsg != null) {
			setErrorMsg(errorMsg);
		}
	}

	@Override
	public Object clone() {
		return new FormSixteenErrorFileWrapper((FormSixteenErrorFile)_formSixteenErrorFile.clone());
	}

	@Override
	public int compareTo(FormSixteenErrorFile formSixteenErrorFile) {
		return _formSixteenErrorFile.compareTo(formSixteenErrorFile);
	}

	/**
	* Returns the error ID of this form sixteen error file.
	*
	* @return the error ID of this form sixteen error file
	*/
	@Override
	public long getErrorId() {
		return _formSixteenErrorFile.getErrorId();
	}

	/**
	* Returns the error msg of this form sixteen error file.
	*
	* @return the error msg of this form sixteen error file
	*/
	@Override
	public String getErrorMsg() {
		return _formSixteenErrorFile.getErrorMsg();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _formSixteenErrorFile.getExpandoBridge();
	}

	/**
	* Returns the file name of this form sixteen error file.
	*
	* @return the file name of this form sixteen error file
	*/
	@Override
	public String getFileName() {
		return _formSixteenErrorFile.getFileName();
	}

	/**
	* Returns the primary key of this form sixteen error file.
	*
	* @return the primary key of this form sixteen error file
	*/
	@Override
	public long getPrimaryKey() {
		return _formSixteenErrorFile.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formSixteenErrorFile.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _formSixteenErrorFile.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _formSixteenErrorFile.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _formSixteenErrorFile.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _formSixteenErrorFile.isNew();
	}

	@Override
	public void persist() {
		_formSixteenErrorFile.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_formSixteenErrorFile.setCachedModel(cachedModel);
	}

	/**
	* Sets the error ID of this form sixteen error file.
	*
	* @param errorId the error ID of this form sixteen error file
	*/
	@Override
	public void setErrorId(long errorId) {
		_formSixteenErrorFile.setErrorId(errorId);
	}

	/**
	* Sets the error msg of this form sixteen error file.
	*
	* @param errorMsg the error msg of this form sixteen error file
	*/
	@Override
	public void setErrorMsg(String errorMsg) {
		_formSixteenErrorFile.setErrorMsg(errorMsg);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_formSixteenErrorFile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_formSixteenErrorFile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_formSixteenErrorFile.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file name of this form sixteen error file.
	*
	* @param fileName the file name of this form sixteen error file
	*/
	@Override
	public void setFileName(String fileName) {
		_formSixteenErrorFile.setFileName(fileName);
	}

	@Override
	public void setNew(boolean n) {
		_formSixteenErrorFile.setNew(n);
	}

	/**
	* Sets the primary key of this form sixteen error file.
	*
	* @param primaryKey the primary key of this form sixteen error file
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_formSixteenErrorFile.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_formSixteenErrorFile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<FormSixteenErrorFile> toCacheModel() {
		return _formSixteenErrorFile.toCacheModel();
	}

	@Override
	public FormSixteenErrorFile toEscapedModel() {
		return new FormSixteenErrorFileWrapper(_formSixteenErrorFile.toEscapedModel());
	}

	@Override
	public String toString() {
		return _formSixteenErrorFile.toString();
	}

	@Override
	public FormSixteenErrorFile toUnescapedModel() {
		return new FormSixteenErrorFileWrapper(_formSixteenErrorFile.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _formSixteenErrorFile.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormSixteenErrorFileWrapper)) {
			return false;
		}

		FormSixteenErrorFileWrapper formSixteenErrorFileWrapper = (FormSixteenErrorFileWrapper)obj;

		if (Objects.equals(_formSixteenErrorFile,
					formSixteenErrorFileWrapper._formSixteenErrorFile)) {
			return true;
		}

		return false;
	}

	@Override
	public FormSixteenErrorFile getWrappedModel() {
		return _formSixteenErrorFile;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _formSixteenErrorFile.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _formSixteenErrorFile.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_formSixteenErrorFile.resetOriginalValues();
	}

	private final FormSixteenErrorFile _formSixteenErrorFile;
}