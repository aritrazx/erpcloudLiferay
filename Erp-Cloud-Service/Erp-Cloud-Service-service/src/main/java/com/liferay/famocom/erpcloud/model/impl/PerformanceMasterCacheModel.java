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

import com.liferay.famocom.erpcloud.model.PerformanceMaster;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PerformanceMaster in entity cache.
 *
 * @author Samaresh
 * @see PerformanceMaster
 * @generated
 */
@ProviderType
public class PerformanceMasterCacheModel implements CacheModel<PerformanceMaster>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PerformanceMasterCacheModel)) {
			return false;
		}

		PerformanceMasterCacheModel performanceMasterCacheModel = (PerformanceMasterCacheModel)obj;

		if (performanceId == performanceMasterCacheModel.performanceId) {
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
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PerformanceMaster toEntityModel() {
		PerformanceMasterImpl performanceMasterImpl = new PerformanceMasterImpl();

		performanceMasterImpl.setPerformanceId(performanceId);
		performanceMasterImpl.setCompanyId(companyId);

		if (performanceHeading == null) {
			performanceMasterImpl.setPerformanceHeading("");
		}
		else {
			performanceMasterImpl.setPerformanceHeading(performanceHeading);
		}

		if (performanceDescription == null) {
			performanceMasterImpl.setPerformanceDescription("");
		}
		else {
			performanceMasterImpl.setPerformanceDescription(performanceDescription);
		}

		if (addedDate == Long.MIN_VALUE) {
			performanceMasterImpl.setAddedDate(null);
		}
		else {
			performanceMasterImpl.setAddedDate(new Date(addedDate));
		}

		performanceMasterImpl.resetOriginalValues();

		return performanceMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		performanceId = objectInput.readLong();

		companyId = objectInput.readLong();
		performanceHeading = objectInput.readUTF();
		performanceDescription = objectInput.readUTF();
		addedDate = objectInput.readLong();
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

		objectOutput.writeLong(addedDate);
	}

	public long performanceId;
	public long companyId;
	public String performanceHeading;
	public String performanceDescription;
	public long addedDate;
}