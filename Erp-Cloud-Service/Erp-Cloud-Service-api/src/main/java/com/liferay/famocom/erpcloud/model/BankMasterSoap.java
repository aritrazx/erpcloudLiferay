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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.BankMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.BankMasterServiceSoap
 * @generated
 */
@ProviderType
public class BankMasterSoap implements Serializable {
	public static BankMasterSoap toSoapModel(BankMaster model) {
		BankMasterSoap soapModel = new BankMasterSoap();

		soapModel.setBankId(model.getBankId());
		soapModel.setBankName(model.getBankName());
		soapModel.setBranchName(model.getBranchName());
		soapModel.setAddress(model.getAddress());
		soapModel.setIfscCode(model.getIfscCode());
		soapModel.setStatus(model.getStatus());
		soapModel.setBankType(model.getBankType());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static BankMasterSoap[] toSoapModels(BankMaster[] models) {
		BankMasterSoap[] soapModels = new BankMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BankMasterSoap[][] toSoapModels(BankMaster[][] models) {
		BankMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BankMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BankMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BankMasterSoap[] toSoapModels(List<BankMaster> models) {
		List<BankMasterSoap> soapModels = new ArrayList<BankMasterSoap>(models.size());

		for (BankMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BankMasterSoap[soapModels.size()]);
	}

	public BankMasterSoap() {
	}

	public long getPrimaryKey() {
		return _bankId;
	}

	public void setPrimaryKey(long pk) {
		setBankId(pk);
	}

	public long getBankId() {
		return _bankId;
	}

	public void setBankId(long bankId) {
		_bankId = bankId;
	}

	public String getBankName() {
		return _bankName;
	}

	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	public String getBranchName() {
		return _branchName;
	}

	public void setBranchName(String branchName) {
		_branchName = branchName;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getIfscCode() {
		return _ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		_ifscCode = ifscCode;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getBankType() {
		return _bankType;
	}

	public void setBankType(int bankType) {
		_bankType = bankType;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _bankId;
	private String _bankName;
	private String _branchName;
	private String _address;
	private String _ifscCode;
	private int _status;
	private int _bankType;
	private long _createdBy;
	private Date _createDate;
	private Date _modifiedDate;
}