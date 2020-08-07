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

import com.liferay.famocom.erpcloud.model.HolidayCalenderManagement;
import com.liferay.famocom.erpcloud.model.HolidayCalenderManagementModel;
import com.liferay.famocom.erpcloud.model.HolidayCalenderManagementSoap;

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
 * The base model implementation for the HolidayCalenderManagement service. Represents a row in the &quot;holidayCalenderManagement&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link HolidayCalenderManagementModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HolidayCalenderManagementImpl}.
 * </p>
 *
 * @author Samaresh
 * @see HolidayCalenderManagementImpl
 * @see HolidayCalenderManagement
 * @see HolidayCalenderManagementModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class HolidayCalenderManagementModelImpl extends BaseModelImpl<HolidayCalenderManagement>
	implements HolidayCalenderManagementModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a holiday calender management model instance should use the {@link HolidayCalenderManagement} interface instead.
	 */
	public static final String TABLE_NAME = "holidayCalenderManagement";
	public static final Object[][] TABLE_COLUMNS = {
			{ "holidayId", Types.BIGINT },
			{ "holidayDate", Types.TIMESTAMP },
			{ "holidayName", Types.VARCHAR },
			{ "holidayStartDate", Types.TIMESTAMP },
			{ "holidayEndDate", Types.TIMESTAMP },
			{ "companyId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("holidayId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("holidayDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("holidayName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("holidayStartDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("holidayEndDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table holidayCalenderManagement (holidayId LONG not null primary key,holidayDate DATE null,holidayName VARCHAR(75) null,holidayStartDate DATE null,holidayEndDate DATE null,companyId LONG)";
	public static final String TABLE_SQL_DROP = "drop table holidayCalenderManagement";
	public static final String ORDER_BY_JPQL = " ORDER BY holidayCalenderManagement.holidayId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY holidayCalenderManagement.holidayId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.HolidayCalenderManagement"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.HolidayCalenderManagement"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.famocom.erpcloud.model.HolidayCalenderManagement"),
			true);
	public static final long HOLIDAYDATE_COLUMN_BITMASK = 1L;
	public static final long HOLIDAYID_COLUMN_BITMASK = 2L;
	public static final long HOLIDAYNAME_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static HolidayCalenderManagement toModel(
		HolidayCalenderManagementSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		HolidayCalenderManagement model = new HolidayCalenderManagementImpl();

		model.setHolidayId(soapModel.getHolidayId());
		model.setHolidayDate(soapModel.getHolidayDate());
		model.setHolidayName(soapModel.getHolidayName());
		model.setHolidayStartDate(soapModel.getHolidayStartDate());
		model.setHolidayEndDate(soapModel.getHolidayEndDate());
		model.setCompanyId(soapModel.getCompanyId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<HolidayCalenderManagement> toModels(
		HolidayCalenderManagementSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<HolidayCalenderManagement> models = new ArrayList<HolidayCalenderManagement>(soapModels.length);

		for (HolidayCalenderManagementSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.HolidayCalenderManagement"));

	public HolidayCalenderManagementModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _holidayId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHolidayId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _holidayId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return HolidayCalenderManagement.class;
	}

	@Override
	public String getModelClassName() {
		return HolidayCalenderManagement.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("holidayId", getHolidayId());
		attributes.put("holidayDate", getHolidayDate());
		attributes.put("holidayName", getHolidayName());
		attributes.put("holidayStartDate", getHolidayStartDate());
		attributes.put("holidayEndDate", getHolidayEndDate());
		attributes.put("companyId", getCompanyId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long holidayId = (Long)attributes.get("holidayId");

		if (holidayId != null) {
			setHolidayId(holidayId);
		}

		Date holidayDate = (Date)attributes.get("holidayDate");

		if (holidayDate != null) {
			setHolidayDate(holidayDate);
		}

		String holidayName = (String)attributes.get("holidayName");

		if (holidayName != null) {
			setHolidayName(holidayName);
		}

		Date holidayStartDate = (Date)attributes.get("holidayStartDate");

		if (holidayStartDate != null) {
			setHolidayStartDate(holidayStartDate);
		}

		Date holidayEndDate = (Date)attributes.get("holidayEndDate");

		if (holidayEndDate != null) {
			setHolidayEndDate(holidayEndDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@JSON
	@Override
	public long getHolidayId() {
		return _holidayId;
	}

	@Override
	public void setHolidayId(long holidayId) {
		_columnBitmask |= HOLIDAYID_COLUMN_BITMASK;

		if (!_setOriginalHolidayId) {
			_setOriginalHolidayId = true;

			_originalHolidayId = _holidayId;
		}

		_holidayId = holidayId;
	}

	public long getOriginalHolidayId() {
		return _originalHolidayId;
	}

	@JSON
	@Override
	public Date getHolidayDate() {
		return _holidayDate;
	}

	@Override
	public void setHolidayDate(Date holidayDate) {
		_columnBitmask |= HOLIDAYDATE_COLUMN_BITMASK;

		if (_originalHolidayDate == null) {
			_originalHolidayDate = _holidayDate;
		}

		_holidayDate = holidayDate;
	}

	public Date getOriginalHolidayDate() {
		return _originalHolidayDate;
	}

	@JSON
	@Override
	public String getHolidayName() {
		if (_holidayName == null) {
			return "";
		}
		else {
			return _holidayName;
		}
	}

	@Override
	public void setHolidayName(String holidayName) {
		_columnBitmask |= HOLIDAYNAME_COLUMN_BITMASK;

		if (_originalHolidayName == null) {
			_originalHolidayName = _holidayName;
		}

		_holidayName = holidayName;
	}

	public String getOriginalHolidayName() {
		return GetterUtil.getString(_originalHolidayName);
	}

	@JSON
	@Override
	public Date getHolidayStartDate() {
		return _holidayStartDate;
	}

	@Override
	public void setHolidayStartDate(Date holidayStartDate) {
		_holidayStartDate = holidayStartDate;
	}

	@JSON
	@Override
	public Date getHolidayEndDate() {
		return _holidayEndDate;
	}

	@Override
	public void setHolidayEndDate(Date holidayEndDate) {
		_holidayEndDate = holidayEndDate;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			HolidayCalenderManagement.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public HolidayCalenderManagement toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (HolidayCalenderManagement)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		HolidayCalenderManagementImpl holidayCalenderManagementImpl = new HolidayCalenderManagementImpl();

		holidayCalenderManagementImpl.setHolidayId(getHolidayId());
		holidayCalenderManagementImpl.setHolidayDate(getHolidayDate());
		holidayCalenderManagementImpl.setHolidayName(getHolidayName());
		holidayCalenderManagementImpl.setHolidayStartDate(getHolidayStartDate());
		holidayCalenderManagementImpl.setHolidayEndDate(getHolidayEndDate());
		holidayCalenderManagementImpl.setCompanyId(getCompanyId());

		holidayCalenderManagementImpl.resetOriginalValues();

		return holidayCalenderManagementImpl;
	}

	@Override
	public int compareTo(HolidayCalenderManagement holidayCalenderManagement) {
		long primaryKey = holidayCalenderManagement.getPrimaryKey();

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

		if (!(obj instanceof HolidayCalenderManagement)) {
			return false;
		}

		HolidayCalenderManagement holidayCalenderManagement = (HolidayCalenderManagement)obj;

		long primaryKey = holidayCalenderManagement.getPrimaryKey();

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
		HolidayCalenderManagementModelImpl holidayCalenderManagementModelImpl = this;

		holidayCalenderManagementModelImpl._originalHolidayId = holidayCalenderManagementModelImpl._holidayId;

		holidayCalenderManagementModelImpl._setOriginalHolidayId = false;

		holidayCalenderManagementModelImpl._originalHolidayDate = holidayCalenderManagementModelImpl._holidayDate;

		holidayCalenderManagementModelImpl._originalHolidayName = holidayCalenderManagementModelImpl._holidayName;

		holidayCalenderManagementModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<HolidayCalenderManagement> toCacheModel() {
		HolidayCalenderManagementCacheModel holidayCalenderManagementCacheModel = new HolidayCalenderManagementCacheModel();

		holidayCalenderManagementCacheModel.holidayId = getHolidayId();

		Date holidayDate = getHolidayDate();

		if (holidayDate != null) {
			holidayCalenderManagementCacheModel.holidayDate = holidayDate.getTime();
		}
		else {
			holidayCalenderManagementCacheModel.holidayDate = Long.MIN_VALUE;
		}

		holidayCalenderManagementCacheModel.holidayName = getHolidayName();

		String holidayName = holidayCalenderManagementCacheModel.holidayName;

		if ((holidayName != null) && (holidayName.length() == 0)) {
			holidayCalenderManagementCacheModel.holidayName = null;
		}

		Date holidayStartDate = getHolidayStartDate();

		if (holidayStartDate != null) {
			holidayCalenderManagementCacheModel.holidayStartDate = holidayStartDate.getTime();
		}
		else {
			holidayCalenderManagementCacheModel.holidayStartDate = Long.MIN_VALUE;
		}

		Date holidayEndDate = getHolidayEndDate();

		if (holidayEndDate != null) {
			holidayCalenderManagementCacheModel.holidayEndDate = holidayEndDate.getTime();
		}
		else {
			holidayCalenderManagementCacheModel.holidayEndDate = Long.MIN_VALUE;
		}

		holidayCalenderManagementCacheModel.companyId = getCompanyId();

		return holidayCalenderManagementCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{holidayId=");
		sb.append(getHolidayId());
		sb.append(", holidayDate=");
		sb.append(getHolidayDate());
		sb.append(", holidayName=");
		sb.append(getHolidayName());
		sb.append(", holidayStartDate=");
		sb.append(getHolidayStartDate());
		sb.append(", holidayEndDate=");
		sb.append(getHolidayEndDate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.famocom.erpcloud.model.HolidayCalenderManagement");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>holidayId</column-name><column-value><![CDATA[");
		sb.append(getHolidayId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>holidayDate</column-name><column-value><![CDATA[");
		sb.append(getHolidayDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>holidayName</column-name><column-value><![CDATA[");
		sb.append(getHolidayName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>holidayStartDate</column-name><column-value><![CDATA[");
		sb.append(getHolidayStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>holidayEndDate</column-name><column-value><![CDATA[");
		sb.append(getHolidayEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = HolidayCalenderManagement.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			HolidayCalenderManagement.class, ModelWrapper.class
		};
	private long _holidayId;
	private long _originalHolidayId;
	private boolean _setOriginalHolidayId;
	private Date _holidayDate;
	private Date _originalHolidayDate;
	private String _holidayName;
	private String _originalHolidayName;
	private Date _holidayStartDate;
	private Date _holidayEndDate;
	private long _companyId;
	private long _columnBitmask;
	private HolidayCalenderManagement _escapedModel;
}