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

import com.liferay.famocom.erpcloud.model.Performance;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Performance in entity cache.
 *
 * @author Samaresh
 * @see Performance
 * @generated
 */
@ProviderType
public class PerformanceCacheModel implements CacheModel<Performance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PerformanceCacheModel)) {
			return false;
		}

		PerformanceCacheModel performanceCacheModel = (PerformanceCacheModel)obj;

		if (performanceId == performanceCacheModel.performanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, performanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{performanceId=");
		sb.append(performanceId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", performanceHeading=");
		sb.append(performanceHeading);
		sb.append(", performanceDescription=");
		sb.append(performanceDescription);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Performance toEntityModel() {
		PerformanceImpl performanceImpl = new PerformanceImpl();

		performanceImpl.setPerformanceId(performanceId);
		performanceImpl.setCompanyId(companyId);

		if (performanceHeading == null) {
			performanceImpl.setPerformanceHeading("");
		}
		else {
			performanceImpl.setPerformanceHeading(performanceHeading);
		}

		if (performanceDescription == null) {
			performanceImpl.setPerformanceDescription("");
		}
		else {
			performanceImpl.setPerformanceDescription(performanceDescription);
		}

		if (createDate == Long.MIN_VALUE) {
			performanceImpl.setCreateDate(null);
		}
		else {
			performanceImpl.setCreateDate(new Date(createDate));
		}

		performanceImpl.resetOriginalValues();

		return performanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		performanceId = objectInput.readLong();

		companyId = objectInput.readLong();
		performanceHeading = objectInput.readUTF();
		performanceDescription = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(performanceId);

		objectOutput.writeLong(companyId);

		if (performanceHeading == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(performanceHeading);
		}

		if (performanceDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(performanceDescription);
		}

		objectOutput.writeLong(createDate);
	}

	public long performanceId;
	public long companyId;
	public String performanceHeading;
	public String performanceDescription;
	public long createDate;
}