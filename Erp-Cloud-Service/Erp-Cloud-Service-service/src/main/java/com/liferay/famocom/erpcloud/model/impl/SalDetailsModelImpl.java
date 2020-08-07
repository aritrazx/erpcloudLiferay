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

import com.liferay.famocom.erpcloud.model.SalDetails;
import com.liferay.famocom.erpcloud.model.SalDetailsModel;
import com.liferay.famocom.erpcloud.model.SalDetailsSoap;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the SalDetails service. Represents a row in the &quot;payDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link SalDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SalDetailsImpl}.
 * </p>
 *
 * @author Samaresh
 * @see SalDetailsImpl
 * @see SalDetails
 * @see SalDetailsModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class SalDetailsModelImpl extends BaseModelImpl<SalDetails>
	implements SalDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sal details model instance should use the {@link SalDetails} interface instead.
	 */
	public static final String TABLE_NAME = "payDetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "SalDetailsId", Types.BIGINT },
			{ "monthYear", Types.BIGINT },
			{ "componentId", Types.BIGINT },
			{ "employeeId", Types.BIGINT },
			{ "value", Types.DOUBLE }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("SalDetailsId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("monthYear", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("componentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("value", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE = "create table payDetails (SalDetailsId LONG not null primary key,monthYear LONG,componentId LONG,employeeId LONG,value DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table payDetails";
	public static final String ORDER_BY_JPQL = " ORDER BY salDetails.SalDetailsId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY payDetails.SalDetailsId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.SalDetails"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.SalDetails"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.famocom.erpcloud.model.SalDetails"),
			true);
	public static final long COMPONENTID_COLUMN_BITMASK = 1L;
	public static final long EMPLOYEEID_COLUMN_BITMASK = 2L;
	public static final long MONTHYEAR_COLUMN_BITMASK = 4L;
	public static final long SALDETAILSID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SalDetails toModel(SalDetailsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SalDetails model = new SalDetailsImpl();

		model.setSalDetailsId(soapModel.getSalDetailsId());
		model.setMonthYear(soapModel.getMonthYear());
		model.setComponentId(soapModel.getComponentId());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setValue(soapModel.getValue());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SalDetails> toModels(SalDetailsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SalDetails> models = new ArrayList<SalDetails>(soapModels.length);

		for (SalDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.SalDetails"));

	public SalDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _SalDetailsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSalDetailsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _SalDetailsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SalDetails.class;
	}

	@Override
	public String getModelClassName() {
		return SalDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("SalDetailsId", getSalDetailsId());
		attributes.put("monthYear", getMonthYear());
		attributes.put("componentId", getComponentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("value", getValue());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long SalDetailsId = (Long)attributes.get("SalDetailsId");

		if (SalDetailsId != null) {
			setSalDetailsId(SalDetailsId);
		}

		Long monthYear = (Long)attributes.get("monthYear");

		if (monthYear != null) {
			setMonthYear(monthYear);
		}

		Long componentId = (Long)attributes.get("componentId");

		if (componentId != null) {
			setComponentId(componentId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Double value = (Double)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@JSON
	@Override
	public long getSalDetailsId() {
		return _SalDetailsId;
	}

	@Override
	public void setSalDetailsId(long SalDetailsId) {
		_SalDetailsId = SalDetailsId;
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
	public long getComponentId() {
		return _componentId;
	}

	@Override
	public void setComponentId(long componentId) {
		_columnBitmask |= COMPONENTID_COLUMN_BITMASK;

		if (!_setOriginalComponentId) {
			_setOriginalComponentId = true;

			_originalComponentId = _componentId;
		}

		_componentId = componentId;
	}

	public long getOriginalComponentId() {
		return _originalComponentId;
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
	public double getValue() {
		return _value;
	}

	@Override
	public void setValue(double value) {
		_value = value;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SalDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SalDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SalDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SalDetailsImpl salDetailsImpl = new SalDetailsImpl();

		salDetailsImpl.setSalDetailsId(getSalDetailsId());
		salDetailsImpl.setMonthYear(getMonthYear());
		salDetailsImpl.setComponentId(getComponentId());
		salDetailsImpl.setEmployeeId(getEmployeeId());
		salDetailsImpl.setValue(getValue());

		salDetailsImpl.resetOriginalValues();

		return salDetailsImpl;
	}

	@Override
	public int compareTo(SalDetails salDetails) {
		long primaryKey = salDetails.getPrimaryKey();

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

		if (!(obj instanceof SalDetails)) {
			return false;
		}

		SalDetails salDetails = (SalDetails)obj;

		long primaryKey = salDetails.getPrimaryKey();

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
		SalDetailsModelImpl salDetailsModelImpl = this;

		salDetailsModelImpl._originalMonthYear = salDetailsModelImpl._monthYear;

		salDetailsModelImpl._setOriginalMonthYear = false;

		salDetailsModelImpl._originalComponentId = salDetailsModelImpl._componentId;

		salDetailsModelImpl._setOriginalComponentId = false;

		salDetailsModelImpl._originalEmployeeId = salDetailsModelImpl._employeeId;

		salDetailsModelImpl._setOriginalEmployeeId = false;

		salDetailsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SalDetails> toCacheModel() {
		SalDetailsCacheModel salDetailsCacheModel = new SalDetailsCacheModel();

		salDetailsCacheModel.SalDetailsId = getSalDetailsId();

		salDetailsCacheModel.monthYear = getMonthYear();

		salDetailsCacheModel.componentId = getComponentId();

		salDetailsCacheModel.employeeId = getEmployeeId();

		salDetailsCacheModel.value = getValue();

		return salDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{SalDetailsId=");
		sb.append(getSalDetailsId());
		sb.append(", monthYear=");
		sb.append(getMonthYear());
		sb.append(", componentId=");
		sb.append(getComponentId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.SalDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>SalDetailsId</column-name><column-value><![CDATA[");
		sb.append(getSalDetailsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monthYear</column-name><column-value><![CDATA[");
		sb.append(getMonthYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>componentId</column-name><column-value><![CDATA[");
		sb.append(getComponentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = SalDetails.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			SalDetails.class, ModelWrapper.class
		};
	private long _SalDetailsId;
	private long _monthYear;
	private long _originalMonthYear;
	private boolean _setOriginalMonthYear;
	private long _componentId;
	private long _originalComponentId;
	private boolean _setOriginalComponentId;
	private long _employeeId;
	private long _originalEmployeeId;
	private boolean _setOriginalEmployeeId;
	private double _value;
	private long _columnBitmask;
	private SalDetails _escapedModel;
}