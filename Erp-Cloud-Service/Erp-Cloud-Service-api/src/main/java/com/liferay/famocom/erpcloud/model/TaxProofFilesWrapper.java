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
 * This class is a wrapper for {@link TaxProofFiles}.
 * </p>
 *
 * @author Samaresh
 * @see TaxProofFiles
 * @generated
 */
@ProviderType
public class TaxProofFilesWrapper implements TaxProofFiles,
	ModelWrapper<TaxProofFiles> {
	public TaxProofFilesWrapper(TaxProofFiles taxProofFiles) {
		_taxProofFiles = taxProofFiles;
	}

	@Override
	public Class<?> getModelClass() {
		return TaxProofFiles.class;
	}

	@Override
	public String getModelClassName() {
		return TaxProofFiles.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fileId", getFileId());
		attributes.put("financialYear", getFinancialYear());
		attributes.put("companyId", getCompanyId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("taxDeclarationId", getTaxDeclarationId());
		attributes.put("fileName", getFileName());
		attributes.put("fileOrigName", getFileOrigName());
		attributes.put("filePath", getFilePath());
		attributes.put("proofName", getProofName());
		attributes.put("uploadDate", getUploadDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String financialYear = (String)attributes.get("financialYear");

		if (financialYear != null) {
			setFinancialYear(financialYear);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long taxDeclarationId = (Long)attributes.get("taxDeclarationId");

		if (taxDeclarationId != null) {
			setTaxDeclarationId(taxDeclarationId);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String fileOrigName = (String)attributes.get("fileOrigName");

		if (fileOrigName != null) {
			setFileOrigName(fileOrigName);
		}

		String filePath = (String)attributes.get("filePath");

		if (filePath != null) {
			setFilePath(filePath);
		}

		String proofName = (String)attributes.get("proofName");

		if (proofName != null) {
			setProofName(proofName);
		}

		Date uploadDate = (Date)attributes.get("uploadDate");

		if (uploadDate != null) {
			setUploadDate(uploadDate);
		}
	}

	@Override
	public Object clone() {
		return new TaxProofFilesWrapper((TaxProofFiles)_taxProofFiles.clone());
	}

	@Override
	public int compareTo(TaxProofFiles taxProofFiles) {
		return _taxProofFiles.compareTo(taxProofFiles);
	}

	/**
	* Returns the company ID of this tax proof files.
	*
	* @return the company ID of this tax proof files
	*/
	@Override
	public long getCompanyId() {
		return _taxProofFiles.getCompanyId();
	}

	/**
	* Returns the employee ID of this tax proof files.
	*
	* @return the employee ID of this tax proof files
	*/
	@Override
	public long getEmployeeId() {
		return _taxProofFiles.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _taxProofFiles.getExpandoBridge();
	}

	/**
	* Returns the file ID of this tax proof files.
	*
	* @return the file ID of this tax proof files
	*/
	@Override
	public long getFileId() {
		return _taxProofFiles.getFileId();
	}

	/**
	* Returns the file name of this tax proof files.
	*
	* @return the file name of this tax proof files
	*/
	@Override
	public String getFileName() {
		return _taxProofFiles.getFileName();
	}

	/**
	* Returns the file orig name of this tax proof files.
	*
	* @return the file orig name of this tax proof files
	*/
	@Override
	public String getFileOrigName() {
		return _taxProofFiles.getFileOrigName();
	}

	/**
	* Returns the file path of this tax proof files.
	*
	* @return the file path of this tax proof files
	*/
	@Override
	public String getFilePath() {
		return _taxProofFiles.getFilePath();
	}

	/**
	* Returns the financial year of this tax proof files.
	*
	* @return the financial year of this tax proof files
	*/
	@Override
	public String getFinancialYear() {
		return _taxProofFiles.getFinancialYear();
	}

	/**
	* Returns the primary key of this tax proof files.
	*
	* @return the primary key of this tax proof files
	*/
	@Override
	public long getPrimaryKey() {
		return _taxProofFiles.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taxProofFiles.getPrimaryKeyObj();
	}

	/**
	* Returns the proof name of this tax proof files.
	*
	* @return the proof name of this tax proof files
	*/
	@Override
	public String getProofName() {
		return _taxProofFiles.getProofName();
	}

	/**
	* Returns the tax declaration ID of this tax proof files.
	*
	* @return the tax declaration ID of this tax proof files
	*/
	@Override
	public long getTaxDeclarationId() {
		return _taxProofFiles.getTaxDeclarationId();
	}

	/**
	* Returns the upload date of this tax proof files.
	*
	* @return the upload date of this tax proof files
	*/
	@Override
	public Date getUploadDate() {
		return _taxProofFiles.getUploadDate();
	}

	@Override
	public int hashCode() {
		return _taxProofFiles.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _taxProofFiles.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _taxProofFiles.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _taxProofFiles.isNew();
	}

	@Override
	public void persist() {
		_taxProofFiles.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taxProofFiles.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this tax proof files.
	*
	* @param companyId the company ID of this tax proof files
	*/
	@Override
	public void setCompanyId(long companyId) {
		_taxProofFiles.setCompanyId(companyId);
	}

	/**
	* Sets the employee ID of this tax proof files.
	*
	* @param employeeId the employee ID of this tax proof files
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_taxProofFiles.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_taxProofFiles.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_taxProofFiles.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_taxProofFiles.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file ID of this tax proof files.
	*
	* @param fileId the file ID of this tax proof files
	*/
	@Override
	public void setFileId(long fileId) {
		_taxProofFiles.setFileId(fileId);
	}

	/**
	* Sets the file name of this tax proof files.
	*
	* @param fileName the file name of this tax proof files
	*/
	@Override
	public void setFileName(String fileName) {
		_taxProofFiles.setFileName(fileName);
	}

	/**
	* Sets the file orig name of this tax proof files.
	*
	* @param fileOrigName the file orig name of this tax proof files
	*/
	@Override
	public void setFileOrigName(String fileOrigName) {
		_taxProofFiles.setFileOrigName(fileOrigName);
	}

	/**
	* Sets the file path of this tax proof files.
	*
	* @param filePath the file path of this tax proof files
	*/
	@Override
	public void setFilePath(String filePath) {
		_taxProofFiles.setFilePath(filePath);
	}

	/**
	* Sets the financial year of this tax proof files.
	*
	* @param financialYear the financial year of this tax proof files
	*/
	@Override
	public void setFinancialYear(String financialYear) {
		_taxProofFiles.setFinancialYear(financialYear);
	}

	@Override
	public void setNew(boolean n) {
		_taxProofFiles.setNew(n);
	}

	/**
	* Sets the primary key of this tax proof files.
	*
	* @param primaryKey the primary key of this tax proof files
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taxProofFiles.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_taxProofFiles.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the proof name of this tax proof files.
	*
	* @param proofName the proof name of this tax proof files
	*/
	@Override
	public void setProofName(String proofName) {
		_taxProofFiles.setProofName(proofName);
	}

	/**
	* Sets the tax declaration ID of this tax proof files.
	*
	* @param taxDeclarationId the tax declaration ID of this tax proof files
	*/
	@Override
	public void setTaxDeclarationId(long taxDeclarationId) {
		_taxProofFiles.setTaxDeclarationId(taxDeclarationId);
	}

	/**
	* Sets the upload date of this tax proof files.
	*
	* @param uploadDate the upload date of this tax proof files
	*/
	@Override
	public void setUploadDate(Date uploadDate) {
		_taxProofFiles.setUploadDate(uploadDate);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TaxProofFiles> toCacheModel() {
		return _taxProofFiles.toCacheModel();
	}

	@Override
	public TaxProofFiles toEscapedModel() {
		return new TaxProofFilesWrapper(_taxProofFiles.toEscapedModel());
	}

	@Override
	public String toString() {
		return _taxProofFiles.toString();
	}

	@Override
	public TaxProofFiles toUnescapedModel() {
		return new TaxProofFilesWrapper(_taxProofFiles.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _taxProofFiles.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaxProofFilesWrapper)) {
			return false;
		}

		TaxProofFilesWrapper taxProofFilesWrapper = (TaxProofFilesWrapper)obj;

		if (Objects.equals(_taxProofFiles, taxProofFilesWrapper._taxProofFiles)) {
			return true;
		}

		return false;
	}

	@Override
	public TaxProofFiles getWrappedModel() {
		return _taxProofFiles;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _taxProofFiles.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _taxProofFiles.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_taxProofFiles.resetOriginalValues();
	}

	private final TaxProofFiles _taxProofFiles;
}