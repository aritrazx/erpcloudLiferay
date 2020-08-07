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

import com.liferay.famocom.erpcloud.model.ExpCategory;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ExpCategory in entity cache.
 *
 * @author Samaresh
 * @see ExpCategory
 * @generated
 */
@ProviderType
public class ExpCategoryCacheModel implements CacheModel<ExpCategory>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpCategoryCacheModel)) {
			return false;
		}

		ExpCategoryCacheModel expCategoryCacheModel = (ExpCategoryCacheModel)obj;

		if (catId == expCategoryCacheModel.catId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, catId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{catId=");
		sb.append(catId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", frequency=");
		sb.append(frequency);
		sb.append(", salaryHead=");
		sb.append(salaryHead);
		sb.append(", finalApprovalRoleId=");
		sb.append(finalApprovalRoleId);
		sb.append(", attachment=");
		sb.append(attachment);
		sb.append(", componentId=");
		sb.append(componentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExpCategory toEntityModel() {
		ExpCategoryImpl expCategoryImpl = new ExpCategoryImpl();

		expCategoryImpl.setCatId(catId);
		expCategoryImpl.setCompanyId(companyId);

		if (categoryName == null) {
			expCategoryImpl.setCategoryName("");
		}
		else {
			expCategoryImpl.setCategoryName(categoryName);
		}

		if (frequency == null) {
			expCategoryImpl.setFrequency("");
		}
		else {
			expCategoryImpl.setFrequency(frequency);
		}

		expCategoryImpl.setSalaryHead(salaryHead);
		expCategoryImpl.setFinalApprovalRoleId(finalApprovalRoleId);
		expCategoryImpl.setAttachment(attachment);
		expCategoryImpl.setComponentId(componentId);

		expCategoryImpl.resetOriginalValues();

		return expCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		catId = objectInput.readLong();

		companyId = objectInput.readLong();
		categoryName = objectInput.readUTF();
		frequency = objectInput.readUTF();

		salaryHead = objectInput.readLong();

		finalApprovalRoleId = objectInput.readLong();

		attachment = objectInput.readBoolean();

		componentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(catId);

		objectOutput.writeLong(companyId);

		if (categoryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoryName);
		}

		if (frequency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(frequency);
		}

		objectOutput.writeLong(salaryHead);

		objectOutput.writeLong(finalApprovalRoleId);

		objectOutput.writeBoolean(attachment);

		objectOutput.writeLong(componentId);
	}

	public long catId;
	public long companyId;
	public String categoryName;
	public String frequency;
	public long salaryHead;
	public long finalApprovalRoleId;
	public boolean attachment;
	public long componentId;
}