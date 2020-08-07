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

import com.liferay.famocom.erpcloud.model.RatingMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RatingMaster in entity cache.
 *
 * @author Samaresh
 * @see RatingMaster
 * @generated
 */
@ProviderType
public class RatingMasterCacheModel implements CacheModel<RatingMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RatingMasterCacheModel)) {
			return false;
		}

		RatingMasterCacheModel ratingMasterCacheModel = (RatingMasterCacheModel)obj;

		if (ratingId == ratingMasterCacheModel.ratingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ratingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{ratingId=");
		sb.append(ratingId);
		sb.append(", ratingNum=");
		sb.append(ratingNum);
		sb.append(", ratingKey=");
		sb.append(ratingKey);
		sb.append(", ratingDescription=");
		sb.append(ratingDescription);
		sb.append(", salaryPercentage=");
		sb.append(salaryPercentage);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RatingMaster toEntityModel() {
		RatingMasterImpl ratingMasterImpl = new RatingMasterImpl();

		ratingMasterImpl.setRatingId(ratingId);

		if (ratingNum == null) {
			ratingMasterImpl.setRatingNum("");
		}
		else {
			ratingMasterImpl.setRatingNum(ratingNum);
		}

		if (ratingKey == null) {
			ratingMasterImpl.setRatingKey("");
		}
		else {
			ratingMasterImpl.setRatingKey(ratingKey);
		}

		if (ratingDescription == null) {
			ratingMasterImpl.setRatingDescription("");
		}
		else {
			ratingMasterImpl.setRatingDescription(ratingDescription);
		}

		ratingMasterImpl.setSalaryPercentage(salaryPercentage);
		ratingMasterImpl.setCompanyId(companyId);

		if (addedDate == Long.MIN_VALUE) {
			ratingMasterImpl.setAddedDate(null);
		}
		else {
			ratingMasterImpl.setAddedDate(new Date(addedDate));
		}

		ratingMasterImpl.resetOriginalValues();

		return ratingMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ratingId = objectInput.readLong();
		ratingNum = objectInput.readUTF();
		ratingKey = objectInput.readUTF();
		ratingDescription = objectInput.readUTF();

		salaryPercentage = objectInput.readLong();

		companyId = objectInput.readLong();
		addedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ratingId);

		if (ratingNum == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ratingNum);
		}

		if (ratingKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ratingKey);
		}

		if (ratingDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ratingDescription);
		}

		objectOutput.writeLong(salaryPercentage);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(addedDate);
	}

	public long ratingId;
	public String ratingNum;
	public String ratingKey;
	public String ratingDescription;
	public long salaryPercentage;
	public long companyId;
	public long addedDate;
}