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
 * This class is a wrapper for {@link ExpProofFiles}.
 * </p>
 *
 * @author Samaresh
 * @see ExpProofFiles
 * @generated
 */
@ProviderType
public class ExpProofFilesWrapper implements ExpProofFiles,
	ModelWrapper<ExpProofFiles> {
	public ExpProofFilesWrapper(ExpProofFiles expProofFiles) {
		_expProofFiles = expProofFiles;
	}

	@Override
	public Class<?> getModelClass() {
		return ExpProofFiles.class;
	}

	@Override
	public String getModelClassName() {
		return ExpProofFiles.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fileId", getFileId());
		attributes.put("financialYear", getFinancialYear());
		attributes.put("companyId", getCompanyId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("expenseId", getExpenseId());
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

		Long expenseId = (Long)attributes.get("expenseId");

		if (expenseId != null) {
			setExpenseId(expenseId);
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
		return new ExpProofFilesWrapper((ExpProofFiles)_expProofFiles.clone());
	}

	@Override
	public int compareTo(ExpProofFiles expProofFiles) {
		return _expProofFiles.compareTo(expProofFiles);
	}

	/**
	* Returns the company ID of this exp proof files.
	*
	* @return the company ID of this exp proof files
	*/
	@Override
	public long getCompanyId() {
		return _expProofFiles.getCompanyId();
	}

	/**
	* Returns the employee ID of this exp proof files.
	*
	* @return the employee ID of this exp proof files
	*/
	@Override
	public long getEmployeeId() {
		return _expProofFiles.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _expProofFiles.getExpandoBridge();
	}

	/**
	* Returns the expense ID of this exp proof files.
	*
	* @return the expense ID of this exp proof files
	*/
	@Override
	public long getExpenseId() {
		return _expProofFiles.getExpenseId();
	}

	/**
	* Returns the file ID of this exp proof files.
	*
	* @return the file ID of this exp proof files
	*/
	@Override
	public long getFileId() {
		return _expProofFiles.getFileId();
	}

	/**
	* Returns the file name of this exp proof files.
	*
	* @return the file name of this exp proof files
	*/
	@Override
	public String getFileName() {
		return _expProofFiles.getFileName();
	}

	/**
	* Returns the file orig name of this exp proof files.
	*
	* @return the file orig name of this exp proof files
	*/
	@Override
	public String getFileOrigName() {
		return _expProofFiles.getFileOrigName();
	}

	/**
	* Returns the file path of this exp proof files.
	*
	* @return the file path of this exp proof files
	*/
	@Override
	public String getFilePath() {
		return _expProofFiles.getFilePath();
	}

	/**
	* Returns the financial year of this exp proof files.
	*
	* @return the financial year of this exp proof files
	*/
	@Override
	public String getFinancialYear() {
		return _expProofFiles.getFinancialYear();
	}

	/**
	* Returns the primary key of this exp proof files.
	*
	* @return the primary key of this exp proof files
	*/
	@Override
	public long getPrimaryKey() {
		return _expProofFiles.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _expProofFiles.getPrimaryKeyObj();
	}

	/**
	* Returns the proof name of this exp proof files.
	*
	* @return the proof name of this exp proof files
	*/
	@Override
	public String getProofName() {
		return _expProofFiles.getProofName();
	}

	/**
	* Returns the upload date of this exp proof files.
	*
	* @return the upload date of this exp proof files
	*/
	@Override
	public Date getUploadDate() {
		return _expProofFiles.getUploadDate();
	}

	@Override
	public int hashCode() {
		return _expProofFiles.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _expProofFiles.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _expProofFiles.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _expProofFiles.isNew();
	}

	@Override
	public void persist() {
		_expProofFiles.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_expProofFiles.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this exp proof files.
	*
	* @param companyId the company ID of this exp proof files
	*/
	@Override
	public void setCompanyId(long companyId) {
		_expProofFiles.setCompanyId(companyId);
	}

	/**
	* Sets the employee ID of this exp proof files.
	*
	* @param employeeId the employee ID of this exp proof files
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_expProofFiles.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_expProofFiles.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_expProofFiles.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_expProofFiles.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the expense ID of this exp proof files.
	*
	* @param expenseId the expense ID of this exp proof files
	*/
	@Override
	public void setExpenseId(long expenseId) {
		_expProofFiles.setExpenseId(expenseId);
	}

	/**
	* Sets the file ID of this exp proof files.
	*
	* @param fileId the file ID of this exp proof files
	*/
	@Override
	public void setFileId(long fileId) {
		_expProofFiles.setFileId(fileId);
	}

	/**
	* Sets the file name of this exp proof files.
	*
	* @param fileName the file name of this exp proof files
	*/
	@Override
	public void setFileName(String fileName) {
		_expProofFiles.setFileName(fileName);
	}

	/**
	* Sets the file orig name of this exp proof files.
	*
	* @param fileOrigName the file orig name of this exp proof files
	*/
	@Override
	public void setFileOrigName(String fileOrigName) {
		_expProofFiles.setFileOrigName(fileOrigName);
	}

	/**
	* Sets the file path of this exp proof files.
	*
	* @param filePath the file path of this exp proof files
	*/
	@Override
	public void setFilePath(String filePath) {
		_expProofFiles.setFilePath(filePath);
	}

	/**
	* Sets the financial year of this exp proof files.
	*
	* @param financialYear the financial year of this exp proof files
	*/
	@Override
	public void setFinancialYear(String financialYear) {
		_expProofFiles.setFinancialYear(financialYear);
	}

	@Override
	public void setNew(boolean n) {
		_expProofFiles.setNew(n);
	}

	/**
	* Sets the primary key of this exp proof files.
	*
	* @param primaryKey the primary key of this exp proof files
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_expProofFiles.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_expProofFiles.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the proof name of this exp proof files.
	*
	* @param proofName the proof name of this exp proof files
	*/
	@Override
	public void setProofName(String proofName) {
		_expProofFiles.setProofName(proofName);
	}

	/**
	* Sets the upload date of this exp proof files.
	*
	* @param uploadDate the upload date of this exp proof files
	*/
	@Override
	public void setUploadDate(Date uploadDate) {
		_expProofFiles.setUploadDate(uploadDate);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ExpProofFiles> toCacheModel() {
		return _expProofFiles.toCacheModel();
	}

	@Override
	public ExpProofFiles toEscapedModel() {
		return new ExpProofFilesWrapper(_expProofFiles.toEscapedModel());
	}

	@Override
	public String toString() {
		return _expProofFiles.toString();
	}

	@Override
	public ExpProofFiles toUnescapedModel() {
		return new ExpProofFilesWrapper(_expProofFiles.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _expProofFiles.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpProofFilesWrapper)) {
			return false;
		}

		ExpProofFilesWrapper expProofFilesWrapper = (ExpProofFilesWrapper)obj;

		if (Objects.equals(_expProofFiles, expProofFilesWrapper._expProofFiles)) {
			return true;
		}

		return false;
	}

	@Override
	public ExpProofFiles getWrappedModel() {
		return _expProofFiles;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _expProofFiles.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _expProofFiles.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_expProofFiles.resetOriginalValues();
	}

	private final ExpProofFiles _expProofFiles;
}