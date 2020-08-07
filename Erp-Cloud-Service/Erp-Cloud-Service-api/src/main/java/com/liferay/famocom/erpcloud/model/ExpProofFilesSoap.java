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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ExpProofFilesServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ExpProofFilesServiceSoap
 * @generated
 */
@ProviderType
public class ExpProofFilesSoap implements Serializable {
	public static ExpProofFilesSoap toSoapModel(ExpProofFiles model) {
		ExpProofFilesSoap soapModel = new ExpProofFilesSoap();

		soapModel.setFileId(model.getFileId());
		soapModel.setFinancialYear(model.getFinancialYear());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setExpenseId(model.getExpenseId());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileOrigName(model.getFileOrigName());
		soapModel.setFilePath(model.getFilePath());
		soapModel.setProofName(model.getProofName());
		soapModel.setUploadDate(model.getUploadDate());

		return soapModel;
	}

	public static ExpProofFilesSoap[] toSoapModels(ExpProofFiles[] models) {
		ExpProofFilesSoap[] soapModels = new ExpProofFilesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpProofFilesSoap[][] toSoapModels(ExpProofFiles[][] models) {
		ExpProofFilesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExpProofFilesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpProofFilesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpProofFilesSoap[] toSoapModels(List<ExpProofFiles> models) {
		List<ExpProofFilesSoap> soapModels = new ArrayList<ExpProofFilesSoap>(models.size());

		for (ExpProofFiles model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpProofFilesSoap[soapModels.size()]);
	}

	public ExpProofFilesSoap() {
	}

	public long getPrimaryKey() {
		return _fileId;
	}

	public void setPrimaryKey(long pk) {
		setFileId(pk);
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFinancialYear() {
		return _financialYear;
	}

	public void setFinancialYear(String financialYear) {
		_financialYear = financialYear;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getExpenseId() {
		return _expenseId;
	}

	public void setExpenseId(long expenseId) {
		_expenseId = expenseId;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getFileOrigName() {
		return _fileOrigName;
	}

	public void setFileOrigName(String fileOrigName) {
		_fileOrigName = fileOrigName;
	}

	public String getFilePath() {
		return _filePath;
	}

	public void setFilePath(String filePath) {
		_filePath = filePath;
	}

	public String getProofName() {
		return _proofName;
	}

	public void setProofName(String proofName) {
		_proofName = proofName;
	}

	public Date getUploadDate() {
		return _uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		_uploadDate = uploadDate;
	}

	private long _fileId;
	private String _financialYear;
	private long _companyId;
	private long _employeeId;
	private long _expenseId;
	private String _fileName;
	private String _fileOrigName;
	private String _filePath;
	private String _proofName;
	private Date _uploadDate;
}