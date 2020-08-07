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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ProjectReport}.
 * </p>
 *
 * @author Samaresh
 * @see ProjectReport
 * @generated
 */
@ProviderType
public class ProjectReportWrapper implements ProjectReport,
	ModelWrapper<ProjectReport> {
	public ProjectReportWrapper(ProjectReport projectReport) {
		_projectReport = projectReport;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectReport.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectReport.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportTemplateId", getReportTemplateId());
		attributes.put("projectId", getProjectId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("timesheetId", getTimesheetId());
		attributes.put("projectTaskId", getProjectTaskId());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("templateNm", getTemplateNm());
		attributes.put("addedDate", getAddedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportTemplateId = (Long)attributes.get("reportTemplateId");

		if (reportTemplateId != null) {
			setReportTemplateId(reportTemplateId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long timesheetId = (Long)attributes.get("timesheetId");

		if (timesheetId != null) {
			setTimesheetId(timesheetId);
		}

		Long projectTaskId = (Long)attributes.get("projectTaskId");

		if (projectTaskId != null) {
			setProjectTaskId(projectTaskId);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		String templateNm = (String)attributes.get("templateNm");

		if (templateNm != null) {
			setTemplateNm(templateNm);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public ProjectReport toEscapedModel() {
		return new ProjectReportWrapper(_projectReport.toEscapedModel());
	}

	@Override
	public ProjectReport toUnescapedModel() {
		return new ProjectReportWrapper(_projectReport.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _projectReport.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectReport.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectReport.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectReport.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectReport> toCacheModel() {
		return _projectReport.toCacheModel();
	}

	@Override
	public int compareTo(ProjectReport projectReport) {
		return _projectReport.compareTo(projectReport);
	}

	@Override
	public int hashCode() {
		return _projectReport.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectReport.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectReportWrapper((ProjectReport)_projectReport.clone());
	}

	/**
	* Returns the template nm of this project report.
	*
	* @return the template nm of this project report
	*/
	@Override
	public java.lang.String getTemplateNm() {
		return _projectReport.getTemplateNm();
	}

	@Override
	public java.lang.String toString() {
		return _projectReport.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectReport.toXmlString();
	}

	/**
	* Returns the added date of this project report.
	*
	* @return the added date of this project report
	*/
	@Override
	public Date getAddedDate() {
		return _projectReport.getAddedDate();
	}

	/**
	* Returns the from date of this project report.
	*
	* @return the from date of this project report
	*/
	@Override
	public Date getFromDate() {
		return _projectReport.getFromDate();
	}

	/**
	* Returns the to date of this project report.
	*
	* @return the to date of this project report
	*/
	@Override
	public Date getToDate() {
		return _projectReport.getToDate();
	}

	/**
	* Returns the employee ID of this project report.
	*
	* @return the employee ID of this project report
	*/
	@Override
	public long getEmployeeId() {
		return _projectReport.getEmployeeId();
	}

	/**
	* Returns the primary key of this project report.
	*
	* @return the primary key of this project report
	*/
	@Override
	public long getPrimaryKey() {
		return _projectReport.getPrimaryKey();
	}

	/**
	* Returns the project ID of this project report.
	*
	* @return the project ID of this project report
	*/
	@Override
	public long getProjectId() {
		return _projectReport.getProjectId();
	}

	/**
	* Returns the project task ID of this project report.
	*
	* @return the project task ID of this project report
	*/
	@Override
	public long getProjectTaskId() {
		return _projectReport.getProjectTaskId();
	}

	/**
	* Returns the report template ID of this project report.
	*
	* @return the report template ID of this project report
	*/
	@Override
	public long getReportTemplateId() {
		return _projectReport.getReportTemplateId();
	}

	/**
	* Returns the timesheet ID of this project report.
	*
	* @return the timesheet ID of this project report
	*/
	@Override
	public long getTimesheetId() {
		return _projectReport.getTimesheetId();
	}

	@Override
	public void persist() {
		_projectReport.persist();
	}

	/**
	* Sets the added date of this project report.
	*
	* @param addedDate the added date of this project report
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_projectReport.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectReport.setCachedModel(cachedModel);
	}

	/**
	* Sets the employee ID of this project report.
	*
	* @param employeeId the employee ID of this project report
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_projectReport.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectReport.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectReport.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectReport.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the from date of this project report.
	*
	* @param fromDate the from date of this project report
	*/
	@Override
	public void setFromDate(Date fromDate) {
		_projectReport.setFromDate(fromDate);
	}

	@Override
	public void setNew(boolean n) {
		_projectReport.setNew(n);
	}

	/**
	* Sets the primary key of this project report.
	*
	* @param primaryKey the primary key of this project report
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectReport.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectReport.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this project report.
	*
	* @param projectId the project ID of this project report
	*/
	@Override
	public void setProjectId(long projectId) {
		_projectReport.setProjectId(projectId);
	}

	/**
	* Sets the project task ID of this project report.
	*
	* @param projectTaskId the project task ID of this project report
	*/
	@Override
	public void setProjectTaskId(long projectTaskId) {
		_projectReport.setProjectTaskId(projectTaskId);
	}

	/**
	* Sets the report template ID of this project report.
	*
	* @param reportTemplateId the report template ID of this project report
	*/
	@Override
	public void setReportTemplateId(long reportTemplateId) {
		_projectReport.setReportTemplateId(reportTemplateId);
	}

	/**
	* Sets the template nm of this project report.
	*
	* @param templateNm the template nm of this project report
	*/
	@Override
	public void setTemplateNm(java.lang.String templateNm) {
		_projectReport.setTemplateNm(templateNm);
	}

	/**
	* Sets the timesheet ID of this project report.
	*
	* @param timesheetId the timesheet ID of this project report
	*/
	@Override
	public void setTimesheetId(long timesheetId) {
		_projectReport.setTimesheetId(timesheetId);
	}

	/**
	* Sets the to date of this project report.
	*
	* @param toDate the to date of this project report
	*/
	@Override
	public void setToDate(Date toDate) {
		_projectReport.setToDate(toDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectReportWrapper)) {
			return false;
		}

		ProjectReportWrapper projectReportWrapper = (ProjectReportWrapper)obj;

		if (Objects.equals(_projectReport, projectReportWrapper._projectReport)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectReport getWrappedModel() {
		return _projectReport;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectReport.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectReport.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectReport.resetOriginalValues();
	}

	private final ProjectReport _projectReport;
}