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

import com.liferay.famocom.erpcloud.model.FormSixteen;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FormSixteen in entity cache.
 *
 * @author Samaresh
 * @see FormSixteen
 * @generated
 */
@ProviderType
public class FormSixteenCacheModel implements CacheModel<FormSixteen>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormSixteenCacheModel)) {
			return false;
		}

		FormSixteenCacheModel formSixteenCacheModel = (FormSixteenCacheModel)obj;

		if (id == formSixteenCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", financialYear=");
		sb.append(financialYear);
		sb.append(", fileEnteryId=");
		sb.append(fileEnteryId);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FormSixteen toEntityModel() {
		FormSixteenImpl formSixteenImpl = new FormSixteenImpl();

		formSixteenImpl.setId(id);
		formSixteenImpl.setEmployeeId(employeeId);

		if (financialYear == null) {
			formSixteenImpl.setFinancialYear("");
		}
		else {
			formSixteenImpl.setFinancialYear(financialYear);
		}

		formSixteenImpl.setFileEnteryId(fileEnteryId);

		if (addedDate == Long.MIN_VALUE) {
			formSixteenImpl.setAddedDate(null);
		}
		else {
			formSixteenImpl.setAddedDate(new Date(addedDate));
		}

		formSixteenImpl.resetOriginalValues();

		return formSixteenImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		employeeId = objectInput.readLong();
		financialYear = objectInput.readUTF();

		fileEnteryId = objectInput.readLong();
		addedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(employeeId);

		if (financialYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(financialYear);
		}

		objectOutput.writeLong(fileEnteryId);
		objectOutput.writeLong(addedDate);
	}

	public long id;
	public long employeeId;
	public String financialYear;
	public long fileEnteryId;
	public long addedDate;
}