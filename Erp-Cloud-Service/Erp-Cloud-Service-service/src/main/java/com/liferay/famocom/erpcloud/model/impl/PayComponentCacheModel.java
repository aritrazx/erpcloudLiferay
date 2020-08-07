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

import com.liferay.famocom.erpcloud.model.PayComponent;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PayComponent in entity cache.
 *
 * @author Samaresh
 * @see PayComponent
 * @generated
 */
@ProviderType
public class PayComponentCacheModel implements CacheModel<PayComponent>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayComponentCacheModel)) {
			return false;
		}

		PayComponentCacheModel payComponentCacheModel = (PayComponentCacheModel)obj;

		if (componentId == payComponentCacheModel.componentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, componentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{componentId=");
		sb.append(componentId);
		sb.append(", employeeTypeId=");
		sb.append(employeeTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", abbreviation=");
		sb.append(abbreviation);
		sb.append(", taxStatus=");
		sb.append(taxStatus);
		sb.append(", payType=");
		sb.append(payType);
		sb.append(", componentType=");
		sb.append(componentType);
		sb.append(", componentValueFormula=");
		sb.append(componentValueFormula);
		sb.append(", partOfCtc=");
		sb.append(partOfCtc);
		sb.append(", effectiveDate=");
		sb.append(effectiveDate);
		sb.append(", islock=");
		sb.append(islock);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", payComponentOrder=");
		sb.append(payComponentOrder);
		sb.append(", autoAddPayStructure=");
		sb.append(autoAddPayStructure);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PayComponent toEntityModel() {
		PayComponentImpl payComponentImpl = new PayComponentImpl();

		payComponentImpl.setComponentId(componentId);
		payComponentImpl.setEmployeeTypeId(employeeTypeId);

		if (name == null) {
			payComponentImpl.setName("");
		}
		else {
			payComponentImpl.setName(name);
		}

		if (abbreviation == null) {
			payComponentImpl.setAbbreviation("");
		}
		else {
			payComponentImpl.setAbbreviation(abbreviation);
		}

		payComponentImpl.setTaxStatus(taxStatus);

		if (payType == null) {
			payComponentImpl.setPayType("");
		}
		else {
			payComponentImpl.setPayType(payType);
		}

		payComponentImpl.setComponentType(componentType);

		if (componentValueFormula == null) {
			payComponentImpl.setComponentValueFormula("");
		}
		else {
			payComponentImpl.setComponentValueFormula(componentValueFormula);
		}

		payComponentImpl.setPartOfCtc(partOfCtc);

		if (effectiveDate == Long.MIN_VALUE) {
			payComponentImpl.setEffectiveDate(null);
		}
		else {
			payComponentImpl.setEffectiveDate(new Date(effectiveDate));
		}

		payComponentImpl.setIslock(islock);

		if (createDate == Long.MIN_VALUE) {
			payComponentImpl.setCreateDate(null);
		}
		else {
			payComponentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			payComponentImpl.setModifiedDate(null);
		}
		else {
			payComponentImpl.setModifiedDate(new Date(modifiedDate));
		}

		payComponentImpl.setAmount(amount);
		payComponentImpl.setPayComponentOrder(payComponentOrder);
		payComponentImpl.setAutoAddPayStructure(autoAddPayStructure);

		payComponentImpl.resetOriginalValues();

		return payComponentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		componentId = objectInput.readLong();

		employeeTypeId = objectInput.readLong();
		name = objectInput.readUTF();
		abbreviation = objectInput.readUTF();

		taxStatus = objectInput.readInt();
		payType = objectInput.readUTF();

		componentType = objectInput.readInt();
		componentValueFormula = objectInput.readUTF();

		partOfCtc = objectInput.readInt();
		effectiveDate = objectInput.readLong();

		islock = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		amount = objectInput.readDouble();

		payComponentOrder = objectInput.readLong();

		autoAddPayStructure = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(componentId);

		objectOutput.writeLong(employeeTypeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (abbreviation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(abbreviation);
		}

		objectOutput.writeInt(taxStatus);

		if (payType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(payType);
		}

		objectOutput.writeInt(componentType);

		if (componentValueFormula == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(componentValueFormula);
		}

		objectOutput.writeInt(partOfCtc);
		objectOutput.writeLong(effectiveDate);

		objectOutput.writeLong(islock);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeDouble(amount);

		objectOutput.writeLong(payComponentOrder);

		objectOutput.writeInt(autoAddPayStructure);
	}

	public long componentId;
	public long employeeTypeId;
	public String name;
	public String abbreviation;
	public int taxStatus;
	public String payType;
	public int componentType;
	public String componentValueFormula;
	public int partOfCtc;
	public long effectiveDate;
	public long islock;
	public long createDate;
	public long modifiedDate;
	public double amount;
	public long payComponentOrder;
	public int autoAddPayStructure;
}