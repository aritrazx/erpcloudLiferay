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

import com.liferay.famocom.erpcloud.model.ProjectReport;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectReport in entity cache.
 *
 * @author Samaresh
 * @see ProjectReport
 * @generated
 */
@ProviderType
public class ProjectReportCacheModel implements CacheModel<ProjectReport>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectReportCacheModel)) {
			return false;
		}

		ProjectReportCacheModel projectReportCacheModel = (ProjectReportCacheModel)obj;

		if (reportTemplateId == projectReportCacheModel.reportTemplateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, reportTemplateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{reportTemplateId=");
		sb.append(reportTemplateId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", timesheetId=");
		sb.append(timesheetId);
		sb.append(", projectTaskId=");
		sb.append(projectTaskId);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", templateNm=");
		sb.append(templateNm);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectReport toEntityModel() {
		ProjectReportImpl projectReportImpl = new ProjectReportImpl();

		projectReportImpl.setReportTemplateId(reportTemplateId);
		projectReportImpl.setProjectId(projectId);
		projectReportImpl.setEmployeeId(employeeId);
		projectReportImpl.setTimesheetId(timesheetId);
		projectReportImpl.setProjectTaskId(projectTaskId);

		if (fromDate == Long.MIN_VALUE) {
			projectReportImpl.setFromDate(null);
		}
		else {
			projectReportImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			projectReportImpl.setToDate(null);
		}
		else {
			projectReportImpl.setToDate(new Date(toDate));
		}

		if (templateNm == null) {
			projectReportImpl.setTemplateNm(StringPool.BLANK);
		}
		else {
			projectReportImpl.setTemplateNm(templateNm);
		}

		if (addedDate == Long.MIN_VALUE) {
			projectReportImpl.setAddedDate(null);
		}
		else {
			projectReportImpl.setAddedDate(new Date(addedDate));
		}

		projectReportImpl.resetOriginalValues();

		return projectReportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reportTemplateId = objectInput.readLong();

		projectId = objectInput.readLong();

		employeeId = objectInput.readLong();

		timesheetId = objectInput.readLong();

		projectTaskId = objectInput.readLong();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
		templateNm = objectInput.readUTF();
		addedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(reportTemplateId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(timesheetId);

		objectOutput.writeLong(projectTaskId);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		if (templateNm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateNm);
		}

		objectOutput.writeLong(addedDate);
	}

	public long reportTemplateId;
	public long projectId;
	public long employeeId;
	public long timesheetId;
	public long projectTaskId;
	public long fromDate;
	public long toDate;
	public String templateNm;
	public long addedDate;
}