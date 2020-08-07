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

package com.liferay.famocom.erpcloud.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.ClientMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ClientMaster in entity cache.
 *
 * @author Samaresh
 * @see ClientMaster
 * @generated
 */
@ProviderType
public class ClientMasterCacheModel implements CacheModel<ClientMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientMasterCacheModel)) {
			return false;
		}

		ClientMasterCacheModel clientMasterCacheModel = (ClientMasterCacheModel)obj;

		if (clientId == clientMasterCacheModel.clientId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clientId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{clientId=");
		sb.append(clientId);
		sb.append(", clientName=");
		sb.append(clientName);
		sb.append(", officeAddress=");
		sb.append(officeAddress);
		sb.append(", billingAddress=");
		sb.append(billingAddress);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", emailId=");
		sb.append(emailId);
		sb.append(", contactPerson=");
		sb.append(contactPerson);
		sb.append(", skypeId=");
		sb.append(skypeId);
		sb.append(", gstNo=");
		sb.append(gstNo);
		sb.append(", panNo=");
		sb.append(panNo);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", branchName=");
		sb.append(branchName);
		sb.append(", bankAccountNumber=");
		sb.append(bankAccountNumber);
		sb.append(", bankAccountType=");
		sb.append(bankAccountType);
		sb.append(", ifscCode=");
		sb.append(ifscCode);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClientMaster toEntityModel() {
		ClientMasterImpl clientMasterImpl = new ClientMasterImpl();

		clientMasterImpl.setClientId(clientId);

		if (clientName == null) {
			clientMasterImpl.setClientName("");
		}
		else {
			clientMasterImpl.setClientName(clientName);
		}

		if (officeAddress == null) {
			clientMasterImpl.setOfficeAddress("");
		}
		else {
			clientMasterImpl.setOfficeAddress(officeAddress);
		}

		if (billingAddress == null) {
			clientMasterImpl.setBillingAddress("");
		}
		else {
			clientMasterImpl.setBillingAddress(billingAddress);
		}

		clientMasterImpl.setContactNumber(contactNumber);

		if (emailId == null) {
			clientMasterImpl.setEmailId("");
		}
		else {
			clientMasterImpl.setEmailId(emailId);
		}

		if (contactPerson == null) {
			clientMasterImpl.setContactPerson("");
		}
		else {
			clientMasterImpl.setContactPerson(contactPerson);
		}

		if (skypeId == null) {
			clientMasterImpl.setSkypeId("");
		}
		else {
			clientMasterImpl.setSkypeId(skypeId);
		}

		clientMasterImpl.setGstNo(gstNo);

		if (panNo == null) {
			clientMasterImpl.setPanNo("");
		}
		else {
			clientMasterImpl.setPanNo(panNo);
		}

		if (bankName == null) {
			clientMasterImpl.setBankName("");
		}
		else {
			clientMasterImpl.setBankName(bankName);
		}

		if (branchName == null) {
			clientMasterImpl.setBranchName("");
		}
		else {
			clientMasterImpl.setBranchName(branchName);
		}

		clientMasterImpl.setBankAccountNumber(bankAccountNumber);

		if (bankAccountType == null) {
			clientMasterImpl.setBankAccountType("");
		}
		else {
			clientMasterImpl.setBankAccountType(bankAccountType);
		}

		if (ifscCode == null) {
			clientMasterImpl.setIfscCode("");
		}
		else {
			clientMasterImpl.setIfscCode(ifscCode);
		}

		if (addedDate == Long.MIN_VALUE) {
			clientMasterImpl.setAddedDate(null);
		}
		else {
			clientMasterImpl.setAddedDate(new Date(addedDate));
		}

		clientMasterImpl.resetOriginalValues();

		return clientMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		clientId = objectInput.readLong();
		clientName = objectInput.readUTF();
		officeAddress = objectInput.readUTF();
		billingAddress = objectInput.readUTF();

		contactNumber = objectInput.readInt();
		emailId = objectInput.readUTF();
		contactPerson = objectInput.readUTF();
		skypeId = objectInput.readUTF();

		gstNo = objectInput.readLong();
		panNo = objectInput.readUTF();
		bankName = objectInput.readUTF();
		branchName = objectInput.readUTF();

		bankAccountNumber = objectInput.readLong();
		bankAccountType = objectInput.readUTF();
		ifscCode = objectInput.readUTF();
		addedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(clientId);

		if (clientName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientName);
		}

		if (officeAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(officeAddress);
		}

		if (billingAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(billingAddress);
		}

		objectOutput.writeInt(contactNumber);

		if (emailId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailId);
		}

		if (contactPerson == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactPerson);
		}

		if (skypeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skypeId);
		}

		objectOutput.writeLong(gstNo);

		if (panNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(panNo);
		}

		if (bankName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		if (branchName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(branchName);
		}

		objectOutput.writeLong(bankAccountNumber);

		if (bankAccountType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankAccountType);
		}

		if (ifscCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ifscCode);
		}

		objectOutput.writeLong(addedDate);
	}

	public long clientId;
	public String clientName;
	public String officeAddress;
	public String billingAddress;
	public int contactNumber;
	public String emailId;
	public String contactPerson;
	public String skypeId;
	public long gstNo;
	public String panNo;
	public String bankName;
	public String branchName;
	public long bankAccountNumber;
	public String bankAccountType;
	public String ifscCode;
	public long addedDate;
}