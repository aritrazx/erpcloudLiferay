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
 * This class is a wrapper for {@link BillDocumentUploadFile}.
 * </p>
 *
 * @author Samaresh
 * @see BillDocumentUploadFile
 * @generated
 */
@ProviderType
public class BillDocumentUploadFileWrapper implements BillDocumentUploadFile,
	ModelWrapper<BillDocumentUploadFile> {
	public BillDocumentUploadFileWrapper(
		BillDocumentUploadFile billDocumentUploadFile) {
		_billDocumentUploadFile = billDocumentUploadFile;
	}

	@Override
	public Class<?> getModelClass() {
		return BillDocumentUploadFile.class;
	}

	@Override
	public String getModelClassName() {
		return BillDocumentUploadFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentId", getDocumentId());
		attributes.put("dlFileEntryId", getDlFileEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("billingId", getBillingId());
		attributes.put("documentName", getDocumentName());
		attributes.put("documentPath", getDocumentPath());
		attributes.put("uploadDate", getUploadDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Long dlFileEntryId = (Long)attributes.get("dlFileEntryId");

		if (dlFileEntryId != null) {
			setDlFileEntryId(dlFileEntryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long billingId = (Long)attributes.get("billingId");

		if (billingId != null) {
			setBillingId(billingId);
		}

		String documentName = (String)attributes.get("documentName");

		if (documentName != null) {
			setDocumentName(documentName);
		}

		String documentPath = (String)attributes.get("documentPath");

		if (documentPath != null) {
			setDocumentPath(documentPath);
		}

		Date uploadDate = (Date)attributes.get("uploadDate");

		if (uploadDate != null) {
			setUploadDate(uploadDate);
		}
	}

	@Override
	public Object clone() {
		return new BillDocumentUploadFileWrapper((BillDocumentUploadFile)_billDocumentUploadFile.clone());
	}

	@Override
	public int compareTo(BillDocumentUploadFile billDocumentUploadFile) {
		return _billDocumentUploadFile.compareTo(billDocumentUploadFile);
	}

	/**
	* Returns the billing ID of this bill document upload file.
	*
	* @return the billing ID of this bill document upload file
	*/
	@Override
	public long getBillingId() {
		return _billDocumentUploadFile.getBillingId();
	}

	/**
	* Returns the company ID of this bill document upload file.
	*
	* @return the company ID of this bill document upload file
	*/
	@Override
	public long getCompanyId() {
		return _billDocumentUploadFile.getCompanyId();
	}

	/**
	* Returns the dl file entry ID of this bill document upload file.
	*
	* @return the dl file entry ID of this bill document upload file
	*/
	@Override
	public long getDlFileEntryId() {
		return _billDocumentUploadFile.getDlFileEntryId();
	}

	/**
	* Returns the document ID of this bill document upload file.
	*
	* @return the document ID of this bill document upload file
	*/
	@Override
	public long getDocumentId() {
		return _billDocumentUploadFile.getDocumentId();
	}

	/**
	* Returns the document name of this bill document upload file.
	*
	* @return the document name of this bill document upload file
	*/
	@Override
	public String getDocumentName() {
		return _billDocumentUploadFile.getDocumentName();
	}

	/**
	* Returns the document path of this bill document upload file.
	*
	* @return the document path of this bill document upload file
	*/
	@Override
	public String getDocumentPath() {
		return _billDocumentUploadFile.getDocumentPath();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _billDocumentUploadFile.getExpandoBridge();
	}

	/**
	* Returns the primary key of this bill document upload file.
	*
	* @return the primary key of this bill document upload file
	*/
	@Override
	public long getPrimaryKey() {
		return _billDocumentUploadFile.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _billDocumentUploadFile.getPrimaryKeyObj();
	}

	/**
	* Returns the upload date of this bill document upload file.
	*
	* @return the upload date of this bill document upload file
	*/
	@Override
	public Date getUploadDate() {
		return _billDocumentUploadFile.getUploadDate();
	}

	@Override
	public int hashCode() {
		return _billDocumentUploadFile.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _billDocumentUploadFile.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _billDocumentUploadFile.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _billDocumentUploadFile.isNew();
	}

	@Override
	public void persist() {
		_billDocumentUploadFile.persist();
	}

	/**
	* Sets the billing ID of this bill document upload file.
	*
	* @param billingId the billing ID of this bill document upload file
	*/
	@Override
	public void setBillingId(long billingId) {
		_billDocumentUploadFile.setBillingId(billingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_billDocumentUploadFile.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this bill document upload file.
	*
	* @param companyId the company ID of this bill document upload file
	*/
	@Override
	public void setCompanyId(long companyId) {
		_billDocumentUploadFile.setCompanyId(companyId);
	}

	/**
	* Sets the dl file entry ID of this bill document upload file.
	*
	* @param dlFileEntryId the dl file entry ID of this bill document upload file
	*/
	@Override
	public void setDlFileEntryId(long dlFileEntryId) {
		_billDocumentUploadFile.setDlFileEntryId(dlFileEntryId);
	}

	/**
	* Sets the document ID of this bill document upload file.
	*
	* @param documentId the document ID of this bill document upload file
	*/
	@Override
	public void setDocumentId(long documentId) {
		_billDocumentUploadFile.setDocumentId(documentId);
	}

	/**
	* Sets the document name of this bill document upload file.
	*
	* @param documentName the document name of this bill document upload file
	*/
	@Override
	public void setDocumentName(String documentName) {
		_billDocumentUploadFile.setDocumentName(documentName);
	}

	/**
	* Sets the document path of this bill document upload file.
	*
	* @param documentPath the document path of this bill document upload file
	*/
	@Override
	public void setDocumentPath(String documentPath) {
		_billDocumentUploadFile.setDocumentPath(documentPath);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_billDocumentUploadFile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_billDocumentUploadFile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_billDocumentUploadFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_billDocumentUploadFile.setNew(n);
	}

	/**
	* Sets the primary key of this bill document upload file.
	*
	* @param primaryKey the primary key of this bill document upload file
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_billDocumentUploadFile.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_billDocumentUploadFile.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the upload date of this bill document upload file.
	*
	* @param uploadDate the upload date of this bill document upload file
	*/
	@Override
	public void setUploadDate(Date uploadDate) {
		_billDocumentUploadFile.setUploadDate(uploadDate);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<BillDocumentUploadFile> toCacheModel() {
		return _billDocumentUploadFile.toCacheModel();
	}

	@Override
	public BillDocumentUploadFile toEscapedModel() {
		return new BillDocumentUploadFileWrapper(_billDocumentUploadFile.toEscapedModel());
	}

	@Override
	public String toString() {
		return _billDocumentUploadFile.toString();
	}

	@Override
	public BillDocumentUploadFile toUnescapedModel() {
		return new BillDocumentUploadFileWrapper(_billDocumentUploadFile.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _billDocumentUploadFile.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BillDocumentUploadFileWrapper)) {
			return false;
		}

		BillDocumentUploadFileWrapper billDocumentUploadFileWrapper = (BillDocumentUploadFileWrapper)obj;

		if (Objects.equals(_billDocumentUploadFile,
					billDocumentUploadFileWrapper._billDocumentUploadFile)) {
			return true;
		}

		return false;
	}

	@Override
	public BillDocumentUploadFile getWrappedModel() {
		return _billDocumentUploadFile;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _billDocumentUploadFile.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _billDocumentUploadFile.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_billDocumentUploadFile.resetOriginalValues();
	}

	private final BillDocumentUploadFile _billDocumentUploadFile;
}