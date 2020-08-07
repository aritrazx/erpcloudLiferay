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

import com.liferay.famocom.erpcloud.model.TaxSetting;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaxSetting in entity cache.
 *
 * @author Samaresh
 * @see TaxSetting
 * @generated
 */
@ProviderType
public class TaxSettingCacheModel implements CacheModel<TaxSetting>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaxSettingCacheModel)) {
			return false;
		}

		TaxSettingCacheModel taxSettingCacheModel = (TaxSettingCacheModel)obj;

		if (taxSettingId == taxSettingCacheModel.taxSettingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taxSettingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{taxSettingId=");
		sb.append(taxSettingId);
		sb.append(", componentId=");
		sb.append(componentId);
		sb.append(", componentName=");
		sb.append(componentName);
		sb.append(", taxFormulla=");
		sb.append(taxFormulla);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaxSetting toEntityModel() {
		TaxSettingImpl taxSettingImpl = new TaxSettingImpl();

		taxSettingImpl.setTaxSettingId(taxSettingId);
		taxSettingImpl.setComponentId(componentId);

		if (componentName == null) {
			taxSettingImpl.setComponentName("");
		}
		else {
			taxSettingImpl.setComponentName(componentName);
		}

		if (taxFormulla == null) {
			taxSettingImpl.setTaxFormulla("");
		}
		else {
			taxSettingImpl.setTaxFormulla(taxFormulla);
		}

		taxSettingImpl.setCreatedBy(createdBy);

		if (createdDate == Long.MIN_VALUE) {
			taxSettingImpl.setCreatedDate(null);
		}
		else {
			taxSettingImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			taxSettingImpl.setModifiedDate(null);
		}
		else {
			taxSettingImpl.setModifiedDate(new Date(modifiedDate));
		}

		taxSettingImpl.resetOriginalValues();

		return taxSettingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taxSettingId = objectInput.readLong();

		componentId = objectInput.readLong();
		componentName = objectInput.readUTF();
		taxFormulla = objectInput.readUTF();

		createdBy = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(taxSettingId);

		objectOutput.writeLong(componentId);

		if (componentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(componentName);
		}

		if (taxFormulla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taxFormulla);
		}

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long taxSettingId;
	public long componentId;
	public String componentName;
	public String taxFormulla;
	public long createdBy;
	public long createdDate;
	public long modifiedDate;
}