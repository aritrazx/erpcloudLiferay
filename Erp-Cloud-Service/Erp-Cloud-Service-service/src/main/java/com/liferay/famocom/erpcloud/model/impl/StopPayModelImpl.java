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

import com.liferay.famocom.erpcloud.model.StopPay;
import com.liferay.famocom.erpcloud.model.StopPayModel;
import com.liferay.famocom.erpcloud.model.StopPaySoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the StopPay service. Represents a row in the &quot;StopPay&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link StopPayModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StopPayImpl}.
 * </p>
 *
 * @author Samaresh
 * @see StopPayImpl
 * @see StopPay
 * @see StopPayModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class StopPayModelImpl extends BaseModelImpl<StopPay>
	implements StopPayModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a stop pay model instance should use the {@link StopPay} interface instead.
	 */
	public static final String TABLE_NAME = "StopPay";
	public static final Object[][] TABLE_COLUMNS = {
			{ "stopPayId", Types.BIGINT },
			{ "monthYear", Types.BIGINT },
			{ "employeeId", Types.BIGINT },
			{ "reason", Types.VARCHAR },
			{ "createdBy", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "modifiedBy", Types.BIGINT },
			{ "status", Types.BIGINT },
			{ "isLock", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("stopPayId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("monthYear", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("reason", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createdDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("isLock", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table StopPay (stopPayId LONG not null primary key,monthYear LONG,employeeId LONG,reason VARCHAR(75) null,createdBy LONG,createdDate DATE null,modifiedDate DATE null,modifiedBy LONG,status LONG,isLock LONG)";
	public static final String TABLE_SQL_DROP = "drop table StopPay";
	public static final String ORDER_BY_JPQL = " ORDER BY stopPay.stopPayId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY StopPay.stopPayId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.StopPay"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.StopPay"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.famocom.erpcloud.model.StopPay"),
			true);
	public static final long EMPLOYEEID_COLUMN_BITMASK = 1L;
	public static final long MONTHYEAR_COLUMN_BITMASK = 2L;
	public static final long STATUS_COLUMN_BITMASK = 4L;
	public static final long STOPPAYID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static StopPay toModel(StopPaySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		StopPay model = new StopPayImpl();

		model.setStopPayId(soapModel.getStopPayId());
		model.setMonthYear(soapModel.getMonthYear());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setReason(soapModel.getReason());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setModifiedBy(soapModel.getModifiedBy());
		model.setStatus(soapModel.getStatus());
		model.setIsLock(soapModel.getIsLock());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<StopPay> toModels(StopPaySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<StopPay> models = new ArrayList<StopPay>(soapModels.length);

		for (StopPaySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.StopPay"));

	public StopPayModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _stopPayId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStopPayId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stopPayId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StopPay.class;
	}

	@Override
	public String getModelClassName() {
		return StopPay.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stopPayId", getStopPayId());
		attributes.put("monthYear", getMonthYear());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("reason", getReason());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("status", getStatus());
		attributes.put("isLock", getIsLock());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stopPayId = (Long)attributes.get("stopPayId");

		if (stopPayId != null) {
			setStopPayId(stopPayId);
		}

		Long monthYear = (Long)attributes.get("monthYear");

		if (monthYear != null) {
			setMonthYear(monthYear);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long isLock = (Long)attributes.get("isLock");

		if (isLock != null) {
			setIsLock(isLock);
		}
	}

	@JSON
	@Override
	public long getStopPayId() {
		return _stopPayId;
	}

	@Override
	public void setStopPayId(long stopPayId) {
		_stopPayId = stopPayId;
	}

	@JSON
	@Override
	public long getMonthYear() {
		return _monthYear;
	}

	@Override
	public void setMonthYear(long monthYear) {
		_columnBitmask |= MONTHYEAR_COLUMN_BITMASK;

		if (!_setOriginalMonthYear) {
			_setOriginalMonthYear = true;

			_originalMonthYear = _monthYear;
		}

		_monthYear = monthYear;
	}

	public long getOriginalMonthYear() {
		return _originalMonthYear;
	}

	@JSON
	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_columnBitmask |= EMPLOYEEID_COLUMN_BITMASK;

		if (!_setOriginalEmployeeId) {
			_setOriginalEmployeeId = true;

			_originalEmployeeId = _employeeId;
		}

		_employeeId = employeeId;
	}

	public long getOriginalEmployeeId() {
		return _originalEmployeeId;
	}

	@JSON
	@Override
	public String getReason() {
		if (_reason == null) {
			return "";
		}
		else {
			return _reason;
		}
	}

	@Override
	public void setReason(String reason) {
		_reason = reason;
	}

	@JSON
	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	@JSON
	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	@JSON
	@Override
	public long getStatus() {
		return _status;
	}

	@Override
	public void setStatus(long status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public long getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getIsLock() {
		return _isLock;
	}

	@Override
	public void setIsLock(long isLock) {
		_isLock = isLock;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			StopPay.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StopPay toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StopPay)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StopPayImpl stopPayImpl = new StopPayImpl();

		stopPayImpl.setStopPayId(getStopPayId());
		stopPayImpl.setMonthYear(getMonthYear());
		stopPayImpl.setEmployeeId(getEmployeeId());
		stopPayImpl.setReason(getReason());
		stopPayImpl.setCreatedBy(getCreatedBy());
		stopPayImpl.setCreatedDate(getCreatedDate());
		stopPayImpl.setModifiedDate(getModifiedDate());
		stopPayImpl.setModifiedBy(getModifiedBy());
		stopPayImpl.setStatus(getStatus());
		stopPayImpl.setIsLock(getIsLock());

		stopPayImpl.resetOriginalValues();

		return stopPayImpl;
	}

	@Override
	public int compareTo(StopPay stopPay) {
		long primaryKey = stopPay.getPrimaryKey();

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

		if (!(obj instanceof StopPay)) {
			return false;
		}

		StopPay stopPay = (StopPay)obj;

		long primaryKey = stopPay.getPrimaryKey();

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
		StopPayModelImpl stopPayModelImpl = this;

		stopPayModelImpl._originalMonthYear = stopPayModelImpl._monthYear;

		stopPayModelImpl._setOriginalMonthYear = false;

		stopPayModelImpl._originalEmployeeId = stopPayModelImpl._employeeId;

		stopPayModelImpl._setOriginalEmployeeId = false;

		stopPayModelImpl._originalStatus = stopPayModelImpl._status;

		stopPayModelImpl._setOriginalStatus = false;

		stopPayModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StopPay> toCacheModel() {
		StopPayCacheModel stopPayCacheModel = new StopPayCacheModel();

		stopPayCacheModel.stopPayId = getStopPayId();

		stopPayCacheModel.monthYear = getMonthYear();

		stopPayCacheModel.employeeId = getEmployeeId();

		stopPayCacheModel.reason = getReason();

		String reason = stopPayCacheModel.reason;

		if ((reason != null) && (reason.length() == 0)) {
			stopPayCacheModel.reason = null;
		}

		stopPayCacheModel.createdBy = getCreatedBy();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			stopPayCacheModel.createdDate = createdDate.getTime();
		}
		else {
			stopPayCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			stopPayCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			stopPayCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		stopPayCacheModel.modifiedBy = getModifiedBy();

		stopPayCacheModel.status = getStatus();

		stopPayCacheModel.isLock = getIsLock();

		return stopPayCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{stopPayId=");
		sb.append(getStopPayId());
		sb.append(", monthYear=");
		sb.append(getMonthYear());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", reason=");
		sb.append(getReason());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", isLock=");
		sb.append(getIsLock());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.StopPay");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stopPayId</column-name><column-value><![CDATA[");
		sb.append(getStopPayId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monthYear</column-name><column-value><![CDATA[");
		sb.append(getMonthYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reason</column-name><column-value><![CDATA[");
		sb.append(getReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isLock</column-name><column-value><![CDATA[");
		sb.append(getIsLock());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = StopPay.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			StopPay.class, ModelWrapper.class
		};
	private long _stopPayId;
	private long _monthYear;
	private long _originalMonthYear;
	private boolean _setOriginalMonthYear;
	private long _employeeId;
	private long _originalEmployeeId;
	private boolean _setOriginalEmployeeId;
	private String _reason;
	private long _createdBy;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _modifiedBy;
	private long _status;
	private long _originalStatus;
	private boolean _setOriginalStatus;
	private long _isLock;
	private long _columnBitmask;
	private StopPay _escapedModel;
}