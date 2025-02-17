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

import com.liferay.famocom.erpcloud.model.TimeSheetMaster;
import com.liferay.famocom.erpcloud.model.TimeSheetMasterModel;
import com.liferay.famocom.erpcloud.model.TimeSheetMasterSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TimeSheetMaster service. Represents a row in the &quot;timeSheetMaster&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TimeSheetMasterModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TimeSheetMasterImpl}.
 * </p>
 *
 * @author Samaresh
 * @see TimeSheetMasterImpl
 * @see TimeSheetMaster
 * @see TimeSheetMasterModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TimeSheetMasterModelImpl extends BaseModelImpl<TimeSheetMaster>
	implements TimeSheetMasterModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a time sheet master model instance should use the {@link TimeSheetMaster} interface instead.
	 */
	public static final String TABLE_NAME = "timeSheetMaster";
	public static final Object[][] TABLE_COLUMNS = {
			{ "timesheetParentId", Types.BIGINT },
			{ "employeeId", Types.BIGINT },
			{ "fromDate", Types.TIMESTAMP },
			{ "toDate", Types.TIMESTAMP },
			{ "submitStatus", Types.INTEGER },
			{ "addedDate", Types.TIMESTAMP },
			{ "groupId", Types.BIGINT },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("timesheetParentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fromDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("toDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("submitStatus", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("addedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table timeSheetMaster (timesheetParentId LONG not null primary key,employeeId LONG,fromDate DATE null,toDate DATE null,submitStatus INTEGER,addedDate DATE null,groupId LONG,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table timeSheetMaster";
	public static final String ORDER_BY_JPQL = " ORDER BY timeSheetMaster.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY timeSheetMaster.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.TimeSheetMaster"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.TimeSheetMaster"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.famocom.erpcloud.model.TimeSheetMaster"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long STATUS_COLUMN_BITMASK = 2L;
	public static final long CREATEDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TimeSheetMaster toModel(TimeSheetMasterSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TimeSheetMaster model = new TimeSheetMasterImpl();

		model.setTimesheetParentId(soapModel.getTimesheetParentId());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setFromDate(soapModel.getFromDate());
		model.setToDate(soapModel.getToDate());
		model.setSubmitStatus(soapModel.getSubmitStatus());
		model.setAddedDate(soapModel.getAddedDate());
		model.setGroupId(soapModel.getGroupId());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TimeSheetMaster> toModels(
		TimeSheetMasterSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TimeSheetMaster> models = new ArrayList<TimeSheetMaster>(soapModels.length);

		for (TimeSheetMasterSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.TimeSheetMaster"));

	public TimeSheetMasterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _timesheetParentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTimesheetParentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timesheetParentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TimeSheetMaster.class;
	}

	@Override
	public String getModelClassName() {
		return TimeSheetMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("timesheetParentId", getTimesheetParentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("submitStatus", getSubmitStatus());
		attributes.put("addedDate", getAddedDate());
		attributes.put("groupId", getGroupId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long timesheetParentId = (Long)attributes.get("timesheetParentId");

		if (timesheetParentId != null) {
			setTimesheetParentId(timesheetParentId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Integer submitStatus = (Integer)attributes.get("submitStatus");

		if (submitStatus != null) {
			setSubmitStatus(submitStatus);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@JSON
	@Override
	public long getTimesheetParentId() {
		return _timesheetParentId;
	}

	@Override
	public void setTimesheetParentId(long timesheetParentId) {
		_timesheetParentId = timesheetParentId;
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
	public int getSubmitStatus() {
		return _submitStatus;
	}

	@Override
	public void setSubmitStatus(int submitStatus) {
		_submitStatus = submitStatus;
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

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TimeSheetMaster.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TimeSheetMaster toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TimeSheetMaster)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TimeSheetMasterImpl timeSheetMasterImpl = new TimeSheetMasterImpl();

		timeSheetMasterImpl.setTimesheetParentId(getTimesheetParentId());
		timeSheetMasterImpl.setEmployeeId(getEmployeeId());
		timeSheetMasterImpl.setFromDate(getFromDate());
		timeSheetMasterImpl.setToDate(getToDate());
		timeSheetMasterImpl.setSubmitStatus(getSubmitStatus());
		timeSheetMasterImpl.setAddedDate(getAddedDate());
		timeSheetMasterImpl.setGroupId(getGroupId());
		timeSheetMasterImpl.setStatus(getStatus());
		timeSheetMasterImpl.setStatusByUserId(getStatusByUserId());
		timeSheetMasterImpl.setStatusByUserName(getStatusByUserName());
		timeSheetMasterImpl.setStatusDate(getStatusDate());
		timeSheetMasterImpl.setCreateDate(getCreateDate());
		timeSheetMasterImpl.setModifiedDate(getModifiedDate());

		timeSheetMasterImpl.resetOriginalValues();

		return timeSheetMasterImpl;
	}

	@Override
	public int compareTo(TimeSheetMaster timeSheetMaster) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				timeSheetMaster.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimeSheetMaster)) {
			return false;
		}

		TimeSheetMaster timeSheetMaster = (TimeSheetMaster)obj;

		long primaryKey = timeSheetMaster.getPrimaryKey();

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
		TimeSheetMasterModelImpl timeSheetMasterModelImpl = this;

		timeSheetMasterModelImpl._originalGroupId = timeSheetMasterModelImpl._groupId;

		timeSheetMasterModelImpl._setOriginalGroupId = false;

		timeSheetMasterModelImpl._originalStatus = timeSheetMasterModelImpl._status;

		timeSheetMasterModelImpl._setOriginalStatus = false;

		timeSheetMasterModelImpl._setModifiedDate = false;

		timeSheetMasterModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TimeSheetMaster> toCacheModel() {
		TimeSheetMasterCacheModel timeSheetMasterCacheModel = new TimeSheetMasterCacheModel();

		timeSheetMasterCacheModel.timesheetParentId = getTimesheetParentId();

		timeSheetMasterCacheModel.employeeId = getEmployeeId();

		Date fromDate = getFromDate();

		if (fromDate != null) {
			timeSheetMasterCacheModel.fromDate = fromDate.getTime();
		}
		else {
			timeSheetMasterCacheModel.fromDate = Long.MIN_VALUE;
		}

		Date toDate = getToDate();

		if (toDate != null) {
			timeSheetMasterCacheModel.toDate = toDate.getTime();
		}
		else {
			timeSheetMasterCacheModel.toDate = Long.MIN_VALUE;
		}

		timeSheetMasterCacheModel.submitStatus = getSubmitStatus();

		Date addedDate = getAddedDate();

		if (addedDate != null) {
			timeSheetMasterCacheModel.addedDate = addedDate.getTime();
		}
		else {
			timeSheetMasterCacheModel.addedDate = Long.MIN_VALUE;
		}

		timeSheetMasterCacheModel.groupId = getGroupId();

		timeSheetMasterCacheModel.status = getStatus();

		timeSheetMasterCacheModel.statusByUserId = getStatusByUserId();

		timeSheetMasterCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = timeSheetMasterCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			timeSheetMasterCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			timeSheetMasterCacheModel.statusDate = statusDate.getTime();
		}
		else {
			timeSheetMasterCacheModel.statusDate = Long.MIN_VALUE;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			timeSheetMasterCacheModel.createDate = createDate.getTime();
		}
		else {
			timeSheetMasterCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			timeSheetMasterCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			timeSheetMasterCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return timeSheetMasterCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{timesheetParentId=");
		sb.append(getTimesheetParentId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", submitStatus=");
		sb.append(getSubmitStatus());
		sb.append(", addedDate=");
		sb.append(getAddedDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.TimeSheetMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>timesheetParentId</column-name><column-value><![CDATA[");
		sb.append(getTimesheetParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
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
			"<column><column-name>submitStatus</column-name><column-value><![CDATA[");
		sb.append(getSubmitStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addedDate</column-name><column-value><![CDATA[");
		sb.append(getAddedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TimeSheetMaster.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TimeSheetMaster.class, ModelWrapper.class
		};
	private long _timesheetParentId;
	private long _employeeId;
	private Date _fromDate;
	private Date _toDate;
	private int _submitStatus;
	private Date _addedDate;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private TimeSheetMaster _escapedModel;
}