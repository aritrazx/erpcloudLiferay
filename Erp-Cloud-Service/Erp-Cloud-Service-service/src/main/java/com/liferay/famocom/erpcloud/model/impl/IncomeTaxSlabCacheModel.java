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

import com.liferay.famocom.erpcloud.model.IncomeTaxSlab;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing IncomeTaxSlab in entity cache.
 *
 * @author Samaresh
 * @see IncomeTaxSlab
 * @generated
 */
@ProviderType
public class IncomeTaxSlabCacheModel implements CacheModel<IncomeTaxSlab>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IncomeTaxSlabCacheModel)) {
			return false;
		}

		IncomeTaxSlabCacheModel incomeTaxSlabCacheModel = (IncomeTaxSlabCacheModel)obj;

		if (incomeTaxSlabId == incomeTaxSlabCacheModel.incomeTaxSlabId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, incomeTaxSlabId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{incomeTaxSlabId=");
		sb.append(incomeTaxSlabId);
		sb.append(", financialYear=");
		sb.append(financialYear);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", incomeFrom=");
		sb.append(incomeFrom);
		sb.append(", incomeTo=");
		sb.append(incomeTo);
		sb.append(", taxRate=");
		sb.append(taxRate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IncomeTaxSlab toEntityModel() {
		IncomeTaxSlabImpl incomeTaxSlabImpl = new IncomeTaxSlabImpl();

		incomeTaxSlabImpl.setIncomeTaxSlabId(incomeTaxSlabId);

		if (financialYear == null) {
			incomeTaxSlabImpl.setFinancialYear("");
		}
		else {
			incomeTaxSlabImpl.setFinancialYear(financialYear);
		}

		incomeTaxSlabImpl.setCompanyId(companyId);
		incomeTaxSlabImpl.setIncomeFrom(incomeFrom);
		incomeTaxSlabImpl.setIncomeTo(incomeTo);
		incomeTaxSlabImpl.setTaxRate(taxRate);

		incomeTaxSlabImpl.resetOriginalValues();

		return incomeTaxSlabImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		incomeTaxSlabId = objectInput.readLong();
		financialYear = objectInput.readUTF();

		companyId = objectInput.readLong();

		incomeFrom = objectInput.readInt();

		incomeTo = objectInput.readInt();

		taxRate = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(incomeTaxSlabId);

		if (financialYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(financialYear);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeInt(incomeFrom);

		objectOutput.writeInt(incomeTo);

		objectOutput.writeDouble(taxRate);
	}

	public long incomeTaxSlabId;
	public String financialYear;
	public long companyId;
	public int incomeFrom;
	public int incomeTo;
	public double taxRate;
}