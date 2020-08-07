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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ClientMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ClientMasterServiceSoap
 * @generated
 */
@ProviderType
public class ClientMasterSoap implements Serializable {
	public static ClientMasterSoap toSoapModel(ClientMaster model) {
		ClientMasterSoap soapModel = new ClientMasterSoap();

		soapModel.setClientId(model.getClientId());
		soapModel.setClientName(model.getClientName());
		soapModel.setOfficeAddress(model.getOfficeAddress());
		soapModel.setBillingAddress(model.getBillingAddress());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setEmailId(model.getEmailId());
		soapModel.setContactPerson(model.getContactPerson());
		soapModel.setSkypeId(model.getSkypeId());
		soapModel.setGstNo(model.getGstNo());
		soapModel.setPanNo(model.getPanNo());
		soapModel.setBankName(model.getBankName());
		soapModel.setBranchName(model.getBranchName());
		soapModel.setBankAccountNumber(model.getBankAccountNumber());
		soapModel.setBankAccountType(model.getBankAccountType());
		soapModel.setIfscCode(model.getIfscCode());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static ClientMasterSoap[] toSoapModels(ClientMaster[] models) {
		ClientMasterSoap[] soapModels = new ClientMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClientMasterSoap[][] toSoapModels(ClientMaster[][] models) {
		ClientMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClientMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClientMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClientMasterSoap[] toSoapModels(List<ClientMaster> models) {
		List<ClientMasterSoap> soapModels = new ArrayList<ClientMasterSoap>(models.size());

		for (ClientMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClientMasterSoap[soapModels.size()]);
	}

	public ClientMasterSoap() {
	}

	public long getPrimaryKey() {
		return _clientId;
	}

	public void setPrimaryKey(long pk) {
		setClientId(pk);
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public String getClientName() {
		return _clientName;
	}

	public void setClientName(String clientName) {
		_clientName = clientName;
	}

	public String getOfficeAddress() {
		return _officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		_officeAddress = officeAddress;
	}

	public String getBillingAddress() {
		return _billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		_billingAddress = billingAddress;
	}

	public int getContactNumber() {
		return _contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		_contactNumber = contactNumber;
	}

	public String getEmailId() {
		return _emailId;
	}

	public void setEmailId(String emailId) {
		_emailId = emailId;
	}

	public String getContactPerson() {
		return _contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		_contactPerson = contactPerson;
	}

	public String getSkypeId() {
		return _skypeId;
	}

	public void setSkypeId(String skypeId) {
		_skypeId = skypeId;
	}

	public long getGstNo() {
		return _gstNo;
	}

	public void setGstNo(long gstNo) {
		_gstNo = gstNo;
	}

	public String getPanNo() {
		return _panNo;
	}

	public void setPanNo(String panNo) {
		_panNo = panNo;
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

	public long getBankAccountNumber() {
		return _bankAccountNumber;
	}

	public void setBankAccountNumber(long bankAccountNumber) {
		_bankAccountNumber = bankAccountNumber;
	}

	public String getBankAccountType() {
		return _bankAccountType;
	}

	public void setBankAccountType(String bankAccountType) {
		_bankAccountType = bankAccountType;
	}

	public String getIfscCode() {
		return _ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		_ifscCode = ifscCode;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _clientId;
	private String _clientName;
	private String _officeAddress;
	private String _billingAddress;
	private int _contactNumber;
	private String _emailId;
	private String _contactPerson;
	private String _skypeId;
	private long _gstNo;
	private String _panNo;
	private String _bankName;
	private String _branchName;
	private long _bankAccountNumber;
	private String _bankAccountType;
	private String _ifscCode;
	private Date _addedDate;
}