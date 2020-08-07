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
 * This class is a wrapper for {@link DocumentUploadFile}.
 * </p>
 *
 * @author Samaresh
 * @see DocumentUploadFile
 * @generated
 */
@ProviderType
public class DocumentUploadFileWrapper implements DocumentUploadFile,
	ModelWrapper<DocumentUploadFile> {
	public DocumentUploadFileWrapper(DocumentUploadFile documentUploadFile) {
		_documentUploadFile = documentUploadFile;
	}

	@Override
	public Class<?> getModelClass() {
		return DocumentUploadFile.class;
	}

	@Override
	public String getModelClassName() {
		return DocumentUploadFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentId", getDocumentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("documentName", getDocumentName());
		attributes.put("documentPath", getDocumentPath());
		attributes.put("uploadDate", getUploadDate());
		attributes.put("travelDetailsId", getTravelDetailsId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
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

		Long travelDetailsId = (Long)attributes.get("travelDetailsId");

		if (travelDetailsId != null) {
			setTravelDetailsId(travelDetailsId);
		}
	}

	@Override
	public Object clone() {
		return new DocumentUploadFileWrapper((DocumentUploadFile)_documentUploadFile.clone());
	}

	@Override
	public int compareTo(DocumentUploadFile documentUploadFile) {
		return _documentUploadFile.compareTo(documentUploadFile);
	}

	/**
	* Returns the company ID of this document upload file.
	*
	* @return the company ID of this document upload file
	*/
	@Override
	public long getCompanyId() {
		return _documentUploadFile.getCompanyId();
	}

	/**
	* Returns the document ID of this document upload file.
	*
	* @return the document ID of this document upload file
	*/
	@Override
	public long getDocumentId() {
		return _documentUploadFile.getDocumentId();
	}

	/**
	* Returns the document name of this document upload file.
	*
	* @return the document name of this document upload file
	*/
	@Override
	public String getDocumentName() {
		return _documentUploadFile.getDocumentName();
	}

	/**
	* Returns the document path of this document upload file.
	*
	* @return the document path of this document upload file
	*/
	@Override
	public String getDocumentPath() {
		return _documentUploadFile.getDocumentPath();
	}

	/**
	* Returns the employee ID of this document upload file.
	*
	* @return the employee ID of this document upload file
	*/
	@Override
	public long getEmployeeId() {
		return _documentUploadFile.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _documentUploadFile.getExpandoBridge();
	}

	/**
	* Returns the file entry ID of this document upload file.
	*
	* @return the file entry ID of this document upload file
	*/
	@Override
	public long getFileEntryId() {
		return _documentUploadFile.getFileEntryId();
	}

	/**
	* Returns the primary key of this document upload file.
	*
	* @return the primary key of this document upload file
	*/
	@Override
	public long getPrimaryKey() {
		return _documentUploadFile.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _documentUploadFile.getPrimaryKeyObj();
	}

	/**
	* Returns the travel details ID of this document upload file.
	*
	* @return the travel details ID of this document upload file
	*/
	@Override
	public long getTravelDetailsId() {
		return _documentUploadFile.getTravelDetailsId();
	}

	/**
	* Returns the upload date of this document upload file.
	*
	* @return the upload date of this document upload file
	*/
	@Override
	public Date getUploadDate() {
		return _documentUploadFile.getUploadDate();
	}

	@Override
	public int hashCode() {
		return _documentUploadFile.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _documentUploadFile.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _documentUploadFile.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _documentUploadFile.isNew();
	}

	@Override
	public void persist() {
		_documentUploadFile.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_documentUploadFile.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this document upload file.
	*
	* @param companyId the company ID of this document upload file
	*/
	@Override
	public void setCompanyId(long companyId) {
		_documentUploadFile.setCompanyId(companyId);
	}

	/**
	* Sets the document ID of this document upload file.
	*
	* @param documentId the document ID of this document upload file
	*/
	@Override
	public void setDocumentId(long documentId) {
		_documentUploadFile.setDocumentId(documentId);
	}

	/**
	* Sets the document name of this document upload file.
	*
	* @param documentName the document name of this document upload file
	*/
	@Override
	public void setDocumentName(String documentName) {
		_documentUploadFile.setDocumentName(documentName);
	}

	/**
	* Sets the document path of this document upload file.
	*
	* @param documentPath the document path of this document upload file
	*/
	@Override
	public void setDocumentPath(String documentPath) {
		_documentUploadFile.setDocumentPath(documentPath);
	}

	/**
	* Sets the employee ID of this document upload file.
	*
	* @param employeeId the employee ID of this document upload file
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_documentUploadFile.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_documentUploadFile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_documentUploadFile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_documentUploadFile.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entry ID of this document upload file.
	*
	* @param fileEntryId the file entry ID of this document upload file
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_documentUploadFile.setFileEntryId(fileEntryId);
	}

	@Override
	public void setNew(boolean n) {
		_documentUploadFile.setNew(n);
	}

	/**
	* Sets the primary key of this document upload file.
	*
	* @param primaryKey the primary key of this document upload file
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_documentUploadFile.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_documentUploadFile.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the travel details ID of this document upload file.
	*
	* @param travelDetailsId the travel details ID of this document upload file
	*/
	@Override
	public void setTravelDetailsId(long travelDetailsId) {
		_documentUploadFile.setTravelDetailsId(travelDetailsId);
	}

	/**
	* Sets the upload date of this document upload file.
	*
	* @param uploadDate the upload date of this document upload file
	*/
	@Override
	public void setUploadDate(Date uploadDate) {
		_documentUploadFile.setUploadDate(uploadDate);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<DocumentUploadFile> toCacheModel() {
		return _documentUploadFile.toCacheModel();
	}

	@Override
	public DocumentUploadFile toEscapedModel() {
		return new DocumentUploadFileWrapper(_documentUploadFile.toEscapedModel());
	}

	@Override
	public String toString() {
		return _documentUploadFile.toString();
	}

	@Override
	public DocumentUploadFile toUnescapedModel() {
		return new DocumentUploadFileWrapper(_documentUploadFile.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _documentUploadFile.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentUploadFileWrapper)) {
			return false;
		}

		DocumentUploadFileWrapper documentUploadFileWrapper = (DocumentUploadFileWrapper)obj;

		if (Objects.equals(_documentUploadFile,
					documentUploadFileWrapper._documentUploadFile)) {
			return true;
		}

		return false;
	}

	@Override
	public DocumentUploadFile getWrappedModel() {
		return _documentUploadFile;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _documentUploadFile.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _documentUploadFile.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_documentUploadFile.resetOriginalValues();
	}

	private final DocumentUploadFile _documentUploadFile;
}