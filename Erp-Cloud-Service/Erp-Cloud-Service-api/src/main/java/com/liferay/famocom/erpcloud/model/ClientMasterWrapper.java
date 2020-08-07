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
 * This class is a wrapper for {@link ClientMaster}.
 * </p>
 *
 * @author Samaresh
 * @see ClientMaster
 * @generated
 */
@ProviderType
public class ClientMasterWrapper implements ClientMaster,
	ModelWrapper<ClientMaster> {
	public ClientMasterWrapper(ClientMaster clientMaster) {
		_clientMaster = clientMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return ClientMaster.class;
	}

	@Override
	public String getModelClassName() {
		return ClientMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clientId", getClientId());
		attributes.put("clientName", getClientName());
		attributes.put("officeAddress", getOfficeAddress());
		attributes.put("billingAddress", getBillingAddress());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("emailId", getEmailId());
		attributes.put("contactPerson", getContactPerson());
		attributes.put("skypeId", getSkypeId());
		attributes.put("gstNo", getGstNo());
		attributes.put("panNo", getPanNo());
		attributes.put("bankName", getBankName());
		attributes.put("branchName", getBranchName());
		attributes.put("bankAccountNumber", getBankAccountNumber());
		attributes.put("bankAccountType", getBankAccountType());
		attributes.put("ifscCode", getIfscCode());
		attributes.put("addedDate", getAddedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String clientName = (String)attributes.get("clientName");

		if (clientName != null) {
			setClientName(clientName);
		}

		String officeAddress = (String)attributes.get("officeAddress");

		if (officeAddress != null) {
			setOfficeAddress(officeAddress);
		}

		String billingAddress = (String)attributes.get("billingAddress");

		if (billingAddress != null) {
			setBillingAddress(billingAddress);
		}

		Integer contactNumber = (Integer)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String emailId = (String)attributes.get("emailId");

		if (emailId != null) {
			setEmailId(emailId);
		}

		String contactPerson = (String)attributes.get("contactPerson");

		if (contactPerson != null) {
			setContactPerson(contactPerson);
		}

		String skypeId = (String)attributes.get("skypeId");

		if (skypeId != null) {
			setSkypeId(skypeId);
		}

		Long gstNo = (Long)attributes.get("gstNo");

		if (gstNo != null) {
			setGstNo(gstNo);
		}

		String panNo = (String)attributes.get("panNo");

		if (panNo != null) {
			setPanNo(panNo);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String branchName = (String)attributes.get("branchName");

		if (branchName != null) {
			setBranchName(branchName);
		}

		Long bankAccountNumber = (Long)attributes.get("bankAccountNumber");

		if (bankAccountNumber != null) {
			setBankAccountNumber(bankAccountNumber);
		}

		String bankAccountType = (String)attributes.get("bankAccountType");

		if (bankAccountType != null) {
			setBankAccountType(bankAccountType);
		}

		String ifscCode = (String)attributes.get("ifscCode");

		if (ifscCode != null) {
			setIfscCode(ifscCode);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public Object clone() {
		return new ClientMasterWrapper((ClientMaster)_clientMaster.clone());
	}

	@Override
	public int compareTo(ClientMaster clientMaster) {
		return _clientMaster.compareTo(clientMaster);
	}

	/**
	* Returns the added date of this client master.
	*
	* @return the added date of this client master
	*/
	@Override
	public Date getAddedDate() {
		return _clientMaster.getAddedDate();
	}

	/**
	* Returns the bank account number of this client master.
	*
	* @return the bank account number of this client master
	*/
	@Override
	public long getBankAccountNumber() {
		return _clientMaster.getBankAccountNumber();
	}

	/**
	* Returns the bank account type of this client master.
	*
	* @return the bank account type of this client master
	*/
	@Override
	public String getBankAccountType() {
		return _clientMaster.getBankAccountType();
	}

	/**
	* Returns the bank name of this client master.
	*
	* @return the bank name of this client master
	*/
	@Override
	public String getBankName() {
		return _clientMaster.getBankName();
	}

	/**
	* Returns the billing address of this client master.
	*
	* @return the billing address of this client master
	*/
	@Override
	public String getBillingAddress() {
		return _clientMaster.getBillingAddress();
	}

	/**
	* Returns the branch name of this client master.
	*
	* @return the branch name of this client master
	*/
	@Override
	public String getBranchName() {
		return _clientMaster.getBranchName();
	}

	/**
	* Returns the client ID of this client master.
	*
	* @return the client ID of this client master
	*/
	@Override
	public long getClientId() {
		return _clientMaster.getClientId();
	}

	/**
	* Returns the client name of this client master.
	*
	* @return the client name of this client master
	*/
	@Override
	public String getClientName() {
		return _clientMaster.getClientName();
	}

	/**
	* Returns the contact number of this client master.
	*
	* @return the contact number of this client master
	*/
	@Override
	public int getContactNumber() {
		return _clientMaster.getContactNumber();
	}

	/**
	* Returns the contact person of this client master.
	*
	* @return the contact person of this client master
	*/
	@Override
	public String getContactPerson() {
		return _clientMaster.getContactPerson();
	}

	/**
	* Returns the email ID of this client master.
	*
	* @return the email ID of this client master
	*/
	@Override
	public String getEmailId() {
		return _clientMaster.getEmailId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _clientMaster.getExpandoBridge();
	}

	/**
	* Returns the gst no of this client master.
	*
	* @return the gst no of this client master
	*/
	@Override
	public long getGstNo() {
		return _clientMaster.getGstNo();
	}

	/**
	* Returns the ifsc code of this client master.
	*
	* @return the ifsc code of this client master
	*/
	@Override
	public String getIfscCode() {
		return _clientMaster.getIfscCode();
	}

	/**
	* Returns the office address of this client master.
	*
	* @return the office address of this client master
	*/
	@Override
	public String getOfficeAddress() {
		return _clientMaster.getOfficeAddress();
	}

	/**
	* Returns the pan no of this client master.
	*
	* @return the pan no of this client master
	*/
	@Override
	public String getPanNo() {
		return _clientMaster.getPanNo();
	}

	/**
	* Returns the primary key of this client master.
	*
	* @return the primary key of this client master
	*/
	@Override
	public long getPrimaryKey() {
		return _clientMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _clientMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the skype ID of this client master.
	*
	* @return the skype ID of this client master
	*/
	@Override
	public String getSkypeId() {
		return _clientMaster.getSkypeId();
	}

	@Override
	public int hashCode() {
		return _clientMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _clientMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _clientMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _clientMaster.isNew();
	}

	@Override
	public void persist() {
		_clientMaster.persist();
	}

	/**
	* Sets the added date of this client master.
	*
	* @param addedDate the added date of this client master
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_clientMaster.setAddedDate(addedDate);
	}

	/**
	* Sets the bank account number of this client master.
	*
	* @param bankAccountNumber the bank account number of this client master
	*/
	@Override
	public void setBankAccountNumber(long bankAccountNumber) {
		_clientMaster.setBankAccountNumber(bankAccountNumber);
	}

	/**
	* Sets the bank account type of this client master.
	*
	* @param bankAccountType the bank account type of this client master
	*/
	@Override
	public void setBankAccountType(String bankAccountType) {
		_clientMaster.setBankAccountType(bankAccountType);
	}

	/**
	* Sets the bank name of this client master.
	*
	* @param bankName the bank name of this client master
	*/
	@Override
	public void setBankName(String bankName) {
		_clientMaster.setBankName(bankName);
	}

	/**
	* Sets the billing address of this client master.
	*
	* @param billingAddress the billing address of this client master
	*/
	@Override
	public void setBillingAddress(String billingAddress) {
		_clientMaster.setBillingAddress(billingAddress);
	}

	/**
	* Sets the branch name of this client master.
	*
	* @param branchName the branch name of this client master
	*/
	@Override
	public void setBranchName(String branchName) {
		_clientMaster.setBranchName(branchName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_clientMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the client ID of this client master.
	*
	* @param clientId the client ID of this client master
	*/
	@Override
	public void setClientId(long clientId) {
		_clientMaster.setClientId(clientId);
	}

	/**
	* Sets the client name of this client master.
	*
	* @param clientName the client name of this client master
	*/
	@Override
	public void setClientName(String clientName) {
		_clientMaster.setClientName(clientName);
	}

	/**
	* Sets the contact number of this client master.
	*
	* @param contactNumber the contact number of this client master
	*/
	@Override
	public void setContactNumber(int contactNumber) {
		_clientMaster.setContactNumber(contactNumber);
	}

	/**
	* Sets the contact person of this client master.
	*
	* @param contactPerson the contact person of this client master
	*/
	@Override
	public void setContactPerson(String contactPerson) {
		_clientMaster.setContactPerson(contactPerson);
	}

	/**
	* Sets the email ID of this client master.
	*
	* @param emailId the email ID of this client master
	*/
	@Override
	public void setEmailId(String emailId) {
		_clientMaster.setEmailId(emailId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_clientMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_clientMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_clientMaster.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gst no of this client master.
	*
	* @param gstNo the gst no of this client master
	*/
	@Override
	public void setGstNo(long gstNo) {
		_clientMaster.setGstNo(gstNo);
	}

	/**
	* Sets the ifsc code of this client master.
	*
	* @param ifscCode the ifsc code of this client master
	*/
	@Override
	public void setIfscCode(String ifscCode) {
		_clientMaster.setIfscCode(ifscCode);
	}

	@Override
	public void setNew(boolean n) {
		_clientMaster.setNew(n);
	}

	/**
	* Sets the office address of this client master.
	*
	* @param officeAddress the office address of this client master
	*/
	@Override
	public void setOfficeAddress(String officeAddress) {
		_clientMaster.setOfficeAddress(officeAddress);
	}

	/**
	* Sets the pan no of this client master.
	*
	* @param panNo the pan no of this client master
	*/
	@Override
	public void setPanNo(String panNo) {
		_clientMaster.setPanNo(panNo);
	}

	/**
	* Sets the primary key of this client master.
	*
	* @param primaryKey the primary key of this client master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_clientMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_clientMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the skype ID of this client master.
	*
	* @param skypeId the skype ID of this client master
	*/
	@Override
	public void setSkypeId(String skypeId) {
		_clientMaster.setSkypeId(skypeId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ClientMaster> toCacheModel() {
		return _clientMaster.toCacheModel();
	}

	@Override
	public ClientMaster toEscapedModel() {
		return new ClientMasterWrapper(_clientMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _clientMaster.toString();
	}

	@Override
	public ClientMaster toUnescapedModel() {
		return new ClientMasterWrapper(_clientMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _clientMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientMasterWrapper)) {
			return false;
		}

		ClientMasterWrapper clientMasterWrapper = (ClientMasterWrapper)obj;

		if (Objects.equals(_clientMaster, clientMasterWrapper._clientMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public ClientMaster getWrappedModel() {
		return _clientMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _clientMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _clientMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_clientMaster.resetOriginalValues();
	}

	private final ClientMaster _clientMaster;
}