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

package com.liferay.famocom.erpcloud.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ProjectReportServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ProjectReportServiceSoap
 * @generated
 */
@ProviderType
public class ProjectReportSoap implements Serializable {
	public static ProjectReportSoap toSoapModel(ProjectReport model) {
		ProjectReportSoap soapModel = new ProjectReportSoap();

		soapModel.setReportTemplateId(model.getReportTemplateId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setTimesheetId(model.getTimesheetId());
		soapModel.setProjectTaskId(model.getProjectTaskId());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setTemplateNm(model.getTemplateNm());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static ProjectReportSoap[] toSoapModels(ProjectReport[] models) {
		ProjectReportSoap[] soapModels = new ProjectReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectReportSoap[][] toSoapModels(ProjectReport[][] models) {
		ProjectReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectReportSoap[] toSoapModels(List<ProjectReport> models) {
		List<ProjectReportSoap> soapModels = new ArrayList<ProjectReportSoap>(models.size());

		for (ProjectReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectReportSoap[soapModels.size()]);
	}

	public ProjectReportSoap() {
	}

	public long getPrimaryKey() {
		return _reportTemplateId;
	}

	public void setPrimaryKey(long pk) {
		setReportTemplateId(pk);
	}

	public long getReportTemplateId() {
		return _reportTemplateId;
	}

	public void setReportTemplateId(long reportTemplateId) {
		_reportTemplateId = reportTemplateId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getTimesheetId() {
		return _timesheetId;
	}

	public void setTimesheetId(long timesheetId) {
		_timesheetId = timesheetId;
	}

	public long getProjectTaskId() {
		return _projectTaskId;
	}

	public void setProjectTaskId(long projectTaskId) {
		_projectTaskId = projectTaskId;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public String getTemplateNm() {
		return _templateNm;
	}

	public void setTemplateNm(String templateNm) {
		_templateNm = templateNm;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _reportTemplateId;
	private long _projectId;
	private long _employeeId;
	private long _timesheetId;
	private long _projectTaskId;
	private Date _fromDate;
	private Date _toDate;
	private String _templateNm;
	private Date _addedDate;
}