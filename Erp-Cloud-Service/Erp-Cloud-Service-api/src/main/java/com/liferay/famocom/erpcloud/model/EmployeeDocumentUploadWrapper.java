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
 * This class is a wrapper for {@link EmployeeDocumentUpload}.
 * </p>
 *
 * @author Samaresh
 * @see EmployeeDocumentUpload
 * @generated
 */
@ProviderType
public class EmployeeDocumentUploadWrapper implements EmployeeDocumentUpload,
	ModelWrapper<EmployeeDocumentUpload> {
	public EmployeeDocumentUploadWrapper(
		EmployeeDocumentUpload employeeDocumentUpload) {
		_employeeDocumentUpload = employeeDocumentUpload;
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeDocumentUpload.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeDocumentUpload.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empDocumentId", getEmpDocumentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("travelDeskDetailsId", getTravelDeskDetailsId());
		attributes.put("documentName", getDocumentName());
		attributes.put("documentPath", getDocumentPath());
		attributes.put("uploadDate", getUploadDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empDocumentId = (Long)attributes.get("empDocumentId");

		if (empDocumentId != null) {
			setEmpDocumentId(empDocumentId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long travelDeskDetailsId = (Long)attributes.get("travelDeskDetailsId");

		if (travelDeskDetailsId != null) {
			setTravelDeskDetailsId(travelDeskDetailsId);
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
		return new EmployeeDocumentUploadWrapper((EmployeeDocumentUpload)_employeeDocumentUpload.clone());
	}

	@Override
	public int compareTo(EmployeeDocumentUpload employeeDocumentUpload) {
		return _employeeDocumentUpload.compareTo(employeeDocumentUpload);
	}

	/**
	* Returns the company ID of this employee document upload.
	*
	* @return the company ID of this employee document upload
	*/
	@Override
	public long getCompanyId() {
		return _employeeDocumentUpload.getCompanyId();
	}

	/**
	* Returns the document name of this employee document upload.
	*
	* @return the document name of this employee document upload
	*/
	@Override
	public String getDocumentName() {
		return _employeeDocumentUpload.getDocumentName();
	}

	/**
	* Returns the document path of this employee document upload.
	*
	* @return the document path of this employee document upload
	*/
	@Override
	public String getDocumentPath() {
		return _employeeDocumentUpload.getDocumentPath();
	}

	/**
	* Returns the emp document ID of this employee document upload.
	*
	* @return the emp document ID of this employee document upload
	*/
	@Override
	public long getEmpDocumentId() {
		return _employeeDocumentUpload.getEmpDocumentId();
	}

	/**
	* Returns the employee ID of this employee document upload.
	*
	* @return the employee ID of this employee document upload
	*/
	@Override
	public long getEmployeeId() {
		return _employeeDocumentUpload.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _employeeDocumentUpload.getExpandoBridge();
	}

	/**
	* Returns the file entry ID of this employee document upload.
	*
	* @return the file entry ID of this employee document upload
	*/
	@Override
	public long getFileEntryId() {
		return _employeeDocumentUpload.getFileEntryId();
	}

	/**
	* Returns the primary key of this employee document upload.
	*
	* @return the primary key of this employee document upload
	*/
	@Override
	public long getPrimaryKey() {
		return _employeeDocumentUpload.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeDocumentUpload.getPrimaryKeyObj();
	}

	/**
	* Returns the travel desk details ID of this employee document upload.
	*
	* @return the travel desk details ID of this employee document upload
	*/
	@Override
	public long getTravelDeskDetailsId() {
		return _employeeDocumentUpload.getTravelDeskDetailsId();
	}

	/**
	* Returns the upload date of this employee document upload.
	*
	* @return the upload date of this employee document upload
	*/
	@Override
	public Date getUploadDate() {
		return _employeeDocumentUpload.getUploadDate();
	}

	@Override
	public int hashCode() {
		return _employeeDocumentUpload.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _employeeDocumentUpload.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _employeeDocumentUpload.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _employeeDocumentUpload.isNew();
	}

	@Override
	public void persist() {
		_employeeDocumentUpload.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employeeDocumentUpload.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this employee document upload.
	*
	* @param companyId the company ID of this employee document upload
	*/
	@Override
	public void setCompanyId(long companyId) {
		_employeeDocumentUpload.setCompanyId(companyId);
	}

	/**
	* Sets the document name of this employee document upload.
	*
	* @param documentName the document name of this employee document upload
	*/
	@Override
	public void setDocumentName(String documentName) {
		_employeeDocumentUpload.setDocumentName(documentName);
	}

	/**
	* Sets the document path of this employee document upload.
	*
	* @param documentPath the document path of this employee document upload
	*/
	@Override
	public void setDocumentPath(String documentPath) {
		_employeeDocumentUpload.setDocumentPath(documentPath);
	}

	/**
	* Sets the emp document ID of this employee document upload.
	*
	* @param empDocumentId the emp document ID of this employee document upload
	*/
	@Override
	public void setEmpDocumentId(long empDocumentId) {
		_employeeDocumentUpload.setEmpDocumentId(empDocumentId);
	}

	/**
	* Sets the employee ID of this employee document upload.
	*
	* @param employeeId the employee ID of this employee document upload
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_employeeDocumentUpload.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_employeeDocumentUpload.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_employeeDocumentUpload.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_employeeDocumentUpload.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entry ID of this employee document upload.
	*
	* @param fileEntryId the file entry ID of this employee document upload
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_employeeDocumentUpload.setFileEntryId(fileEntryId);
	}

	@Override
	public void setNew(boolean n) {
		_employeeDocumentUpload.setNew(n);
	}

	/**
	* Sets the primary key of this employee document upload.
	*
	* @param primaryKey the primary key of this employee document upload
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employeeDocumentUpload.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_employeeDocumentUpload.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the travel desk details ID of this employee document upload.
	*
	* @param travelDeskDetailsId the travel desk details ID of this employee document upload
	*/
	@Override
	public void setTravelDeskDetailsId(long travelDeskDetailsId) {
		_employeeDocumentUpload.setTravelDeskDetailsId(travelDeskDetailsId);
	}

	/**
	* Sets the upload date of this employee document upload.
	*
	* @param uploadDate the upload date of this employee document upload
	*/
	@Override
	public void setUploadDate(Date uploadDate) {
		_employeeDocumentUpload.setUploadDate(uploadDate);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EmployeeDocumentUpload> toCacheModel() {
		return _employeeDocumentUpload.toCacheModel();
	}

	@Override
	public EmployeeDocumentUpload toEscapedModel() {
		return new EmployeeDocumentUploadWrapper(_employeeDocumentUpload.toEscapedModel());
	}

	@Override
	public String toString() {
		return _employeeDocumentUpload.toString();
	}

	@Override
	public EmployeeDocumentUpload toUnescapedModel() {
		return new EmployeeDocumentUploadWrapper(_employeeDocumentUpload.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _employeeDocumentUpload.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeDocumentUploadWrapper)) {
			return false;
		}

		EmployeeDocumentUploadWrapper employeeDocumentUploadWrapper = (EmployeeDocumentUploadWrapper)obj;

		if (Objects.equals(_employeeDocumentUpload,
					employeeDocumentUploadWrapper._employeeDocumentUpload)) {
			return true;
		}

		return false;
	}

	@Override
	public EmployeeDocumentUpload getWrappedModel() {
		return _employeeDocumentUpload;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _employeeDocumentUpload.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _employeeDocumentUpload.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_employeeDocumentUpload.resetOriginalValues();
	}

	private final EmployeeDocumentUpload _employeeDocumentUpload;
}