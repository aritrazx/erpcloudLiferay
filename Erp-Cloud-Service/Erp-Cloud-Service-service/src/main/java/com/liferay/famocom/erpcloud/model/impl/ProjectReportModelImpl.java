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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.famocom.erpcloud.model.ProjectReport;
import com.liferay.famocom.erpcloud.model.ProjectReportModel;
import com.liferay.famocom.erpcloud.model.ProjectReportSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ProjectReport service. Represents a row in the &quot;projectReport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ProjectReportModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectReportImpl}.
 * </p>
 *
 * @author Samaresh
 * @see ProjectReportImpl
 * @see ProjectReport
 * @see ProjectReportModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ProjectReportModelImpl extends BaseModelImpl<ProjectReport>
	implements ProjectReportModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project report model instance should use the {@link ProjectReport} interface instead.
	 */
	public static final String TABLE_NAME = "projectReport";
	public static final Object[][] TABLE_COLUMNS = {
			{ "reportTemplateId", Types.BIGINT },
			{ "projectId", Types.BIGINT },
			{ "employeeId", Types.BIGINT },
			{ "timesheetId", Types.BIGINT },
			{ "projectTaskId", Types.BIGINT },
			{ "fromDate", Types.TIMESTAMP },
			{ "toDate", Types.TIMESTAMP },
			{ "templateNm", Types.VARCHAR },
			{ "addedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("reportTemplateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("timesheetId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("projectTaskId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fromDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("toDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("templateNm", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("addedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table projectReport (reportTemplateId LONG not null primary key,projectId LONG,employeeId LONG,timesheetId LONG,projectTaskId LONG,fromDate DATE null,toDate DATE null,templateNm VARCHAR(75) null,addedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table projectReport";
	public static final String ORDER_BY_JPQL = " ORDER BY projectReport.reportTemplateId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY projectReport.reportTemplateId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.ProjectReport"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.ProjectReport"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ProjectReport toModel(ProjectReportSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProjectReport model = new ProjectReportImpl();

		model.setReportTemplateId(soapModel.getReportTemplateId());
		model.setProjectId(soapModel.getProjectId());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setTimesheetId(soapModel.getTimesheetId());
		model.setProjectTaskId(soapModel.getProjectTaskId());
		model.setFromDate(soapModel.getFromDate());
		model.setToDate(soapModel.getToDate());
		model.setTemplateNm(soapModel.getTemplateNm());
		model.setAddedDate(soapModel.getAddedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ProjectReport> toModels(ProjectReportSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ProjectReport> models = new ArrayList<ProjectReport>(soapModels.length);

		for (ProjectReportSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.ProjectReport"));

	public ProjectReportModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _reportTemplateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReportTemplateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _reportTemplateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public long getReportTemplateId() {
		return _reportTemplateId;
	}

	@Override
	public void setReportTemplateId(long reportTemplateId) {
		_reportTemplateId = reportTemplateId;
	}

	@JSON
	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	@JSON
	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	@JSON
	@Override
	public long getTimesheetId() {
		return _timesheetId;
	}

	@Override
	public void setTimesheetId(long timesheetId) {
		_timesheetId = timesheetId;
	}

	@JSON
	@Override
	public long getProjectTaskId() {
		return _projectTaskId;
	}

	@Override
	public void setProjectTaskId(long projectTaskId) {
		_projectTaskId = projectTaskId;
	}

	@JSON
	@Override
	public Date getFromDate() {
		return _fromDate;
	}

	@Override
	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	@JSON
	@Override
	public Date getToDate() {
		return _toDate;
	}

	@Override
	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	@JSON
	@Override
	public String getTemplateNm() {
		if (_templateNm == null) {
			return StringPool.BLANK;
		}
		else {
			return _templateNm;
		}
	}

	@Override
	public void setTemplateNm(String templateNm) {
		_templateNm = templateNm;
	}

	@JSON
	@Override
	public Date getAddedDate() {
		return _addedDate;
	}

	@Override
	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ProjectReport.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProjectReport toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ProjectReport)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProjectReportImpl projectReportImpl = new ProjectReportImpl();

		projectReportImpl.setReportTemplateId(getReportTemplateId());
		projectReportImpl.setProjectId(getProjectId());
		projectReportImpl.setEmployeeId(getEmployeeId());
		projectReportImpl.setTimesheetId(getTimesheetId());
		projectReportImpl.setProjectTaskId(getProjectTaskId());
		projectReportImpl.setFromDate(getFromDate());
		projectReportImpl.setToDate(getToDate());
		projectReportImpl.setTemplateNm(getTemplateNm());
		projectReportImpl.setAddedDate(getAddedDate());

		projectReportImpl.resetOriginalValues();

		return projectReportImpl;
	}

	@Override
	public int compareTo(ProjectReport projectReport) {
		long primaryKey = projectReport.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectReport)) {
			return false;
		}

		ProjectReport projectReport = (ProjectReport)obj;

		long primaryKey = projectReport.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<ProjectReport> toCacheModel() {
		ProjectReportCacheModel projectReportCacheModel = new ProjectReportCacheModel();

		projectReportCacheModel.reportTemplateId = getReportTemplateId();

		projectReportCacheModel.projectId = getProjectId();

		projectReportCacheModel.employeeId = getEmployeeId();

		projectReportCacheModel.timesheetId = getTimesheetId();

		projectReportCacheModel.projectTaskId = getProjectTaskId();

		Date fromDate = getFromDate();

		if (fromDate != null) {
			projectReportCacheModel.fromDate = fromDate.getTime();
		}
		else {
			projectReportCacheModel.fromDate = Long.MIN_VALUE;
		}

		Date toDate = getToDate();

		if (toDate != null) {
			projectReportCacheModel.toDate = toDate.getTime();
		}
		else {
			projectReportCacheModel.toDate = Long.MIN_VALUE;
		}

		projectReportCacheModel.templateNm = getTemplateNm();

		String templateNm = projectReportCacheModel.templateNm;

		if ((templateNm != null) && (templateNm.length() == 0)) {
			projectReportCacheModel.templateNm = null;
		}

		Date addedDate = getAddedDate();

		if (addedDate != null) {
			projectReportCacheModel.addedDate = addedDate.getTime();
		}
		else {
			projectReportCacheModel.addedDate = Long.MIN_VALUE;
		}

		return projectReportCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{reportTemplateId=");
		sb.append(getReportTemplateId());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", timesheetId=");
		sb.append(getTimesheetId());
		sb.append(", projectTaskId=");
		sb.append(getProjectTaskId());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", templateNm=");
		sb.append(getTemplateNm());
		sb.append(", addedDate=");
		sb.append(getAddedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.ProjectReport");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>reportTemplateId</column-name><column-value><![CDATA[");
		sb.append(getReportTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timesheetId</column-name><column-value><![CDATA[");
		sb.append(getTimesheetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectTaskId</column-name><column-value><![CDATA[");
		sb.append(getProjectTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromDate</column-name><column-value><![CDATA[");
		sb.append(getFromDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toDate</column-name><column-value><![CDATA[");
		sb.append(getToDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateNm</column-name><column-value><![CDATA[");
		sb.append(getTemplateNm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addedDate</column-name><column-value><![CDATA[");
		sb.append(getAddedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ProjectReport.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ProjectReport.class
		};
	private long _reportTemplateId;
	private long _projectId;
	private long _employeeId;
	private long _timesheetId;
	private long _projectTaskId;
	private Date _fromDate;
	private Date _toDate;
	private String _templateNm;
	private Date _addedDate;
	private ProjectReport _escapedModel;
}