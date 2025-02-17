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

import com.liferay.famocom.erpcloud.model.EmployeeType;
import com.liferay.famocom.erpcloud.model.EmployeeTypeModel;
import com.liferay.famocom.erpcloud.model.EmployeeTypeSoap;

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
 * The base model implementation for the EmployeeType service. Represents a row in the &quot;employeeType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link EmployeeTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeTypeImpl}.
 * </p>
 *
 * @author Samaresh
 * @see EmployeeTypeImpl
 * @see EmployeeType
 * @see EmployeeTypeModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class EmployeeTypeModelImpl extends BaseModelImpl<EmployeeType>
	implements EmployeeTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee type model instance should use the {@link EmployeeType} interface instead.
	 */
	public static final String TABLE_NAME = "employeeType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "employeetypeId", Types.BIGINT },
			{ "typeName", Types.VARCHAR },
			{ "pfDeduct", Types.BIGINT },
			{ "status", Types.INTEGER },
			{ "companyId", Types.BIGINT },
			{ "addeddate", Types.TIMESTAMP },
			{ "description", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employeetypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("typeName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pfDeduct", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("addeddate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table employeeType (employeetypeId LONG not null primary key,typeName VARCHAR(75) null,pfDeduct LONG,status INTEGER,companyId LONG,addeddate DATE null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table employeeType";
	public static final String ORDER_BY_JPQL = " ORDER BY employeeType.employeetypeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY employeeType.employeetypeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.EmployeeType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.EmployeeType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static EmployeeType toModel(EmployeeTypeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EmployeeType model = new EmployeeTypeImpl();

		model.setEmployeetypeId(soapModel.getEmployeetypeId());
		model.setTypeName(soapModel.getTypeName());
		model.setPfDeduct(soapModel.getPfDeduct());
		model.setStatus(soapModel.getStatus());
		model.setCompanyId(soapModel.getCompanyId());
		model.setAddeddate(soapModel.getAddeddate());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<EmployeeType> toModels(EmployeeTypeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<EmployeeType> models = new ArrayList<EmployeeType>(soapModels.length);

		for (EmployeeTypeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.EmployeeType"));

	public EmployeeTypeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeetypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeetypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeetypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeType.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeetypeId", getEmployeetypeId());
		attributes.put("typeName", getTypeName());
		attributes.put("pfDeduct", getPfDeduct());
		attributes.put("status", getStatus());
		attributes.put("companyId", getCompanyId());
		attributes.put("addeddate", getAddeddate());
		attributes.put("description", getDescription());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeetypeId = (Long)attributes.get("employeetypeId");

		if (employeetypeId != null) {
			setEmployeetypeId(employeetypeId);
		}

		String typeName = (String)attributes.get("typeName");

		if (typeName != null) {
			setTypeName(typeName);
		}

		Long pfDeduct = (Long)attributes.get("pfDeduct");

		if (pfDeduct != null) {
			setPfDeduct(pfDeduct);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date addeddate = (Date)attributes.get("addeddate");

		if (addeddate != null) {
			setAddeddate(addeddate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@JSON
	@Override
	public long getEmployeetypeId() {
		return _employeetypeId;
	}

	@Override
	public void setEmployeetypeId(long employeetypeId) {
		_employeetypeId = employeetypeId;
	}

	@JSON
	@Override
	public String getTypeName() {
		if (_typeName == null) {
			return "";
		}
		else {
			return _typeName;
		}
	}

	@Override
	public void setTypeName(String typeName) {
		_typeName = typeName;
	}

	@JSON
	@Override
	public long getPfDeduct() {
		return _pfDeduct;
	}

	@Override
	public void setPfDeduct(long pfDeduct) {
		_pfDeduct = pfDeduct;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
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

	@JSON
	@Override
	public Date getAddeddate() {
		return _addeddate;
	}

	@Override
	public void setAddeddate(Date addeddate) {
		_addeddate = addeddate;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			EmployeeType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeeType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (EmployeeType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EmployeeTypeImpl employeeTypeImpl = new EmployeeTypeImpl();

		employeeTypeImpl.setEmployeetypeId(getEmployeetypeId());
		employeeTypeImpl.setTypeName(getTypeName());
		employeeTypeImpl.setPfDeduct(getPfDeduct());
		employeeTypeImpl.setStatus(getStatus());
		employeeTypeImpl.setCompanyId(getCompanyId());
		employeeTypeImpl.setAddeddate(getAddeddate());
		employeeTypeImpl.setDescription(getDescription());

		employeeTypeImpl.resetOriginalValues();

		return employeeTypeImpl;
	}

	@Override
	public int compareTo(EmployeeType employeeType) {
		long primaryKey = employeeType.getPrimaryKey();

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

		if (!(obj instanceof EmployeeType)) {
			return false;
		}

		EmployeeType employeeType = (EmployeeType)obj;

		long primaryKey = employeeType.getPrimaryKey();

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
	public CacheModel<EmployeeType> toCacheModel() {
		EmployeeTypeCacheModel employeeTypeCacheModel = new EmployeeTypeCacheModel();

		employeeTypeCacheModel.employeetypeId = getEmployeetypeId();

		employeeTypeCacheModel.typeName = getTypeName();

		String typeName = employeeTypeCacheModel.typeName;

		if ((typeName != null) && (typeName.length() == 0)) {
			employeeTypeCacheModel.typeName = null;
		}

		employeeTypeCacheModel.pfDeduct = getPfDeduct();

		employeeTypeCacheModel.status = getStatus();

		employeeTypeCacheModel.companyId = getCompanyId();

		Date addeddate = getAddeddate();

		if (addeddate != null) {
			employeeTypeCacheModel.addeddate = addeddate.getTime();
		}
		else {
			employeeTypeCacheModel.addeddate = Long.MIN_VALUE;
		}

		employeeTypeCacheModel.description = getDescription();

		String description = employeeTypeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			employeeTypeCacheModel.description = null;
		}

		return employeeTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{employeetypeId=");
		sb.append(getEmployeetypeId());
		sb.append(", typeName=");
		sb.append(getTypeName());
		sb.append(", pfDeduct=");
		sb.append(getPfDeduct());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", addeddate=");
		sb.append(getAddeddate());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.EmployeeType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>employeetypeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeetypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeName</column-name><column-value><![CDATA[");
		sb.append(getTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pfDeduct</column-name><column-value><![CDATA[");
		sb.append(getPfDeduct());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addeddate</column-name><column-value><![CDATA[");
		sb.append(getAddeddate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = EmployeeType.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			EmployeeType.class, ModelWrapper.class
		};
	private long _employeetypeId;
	private String _typeName;
	private long _pfDeduct;
	private int _status;
	private long _companyId;
	private Date _addeddate;
	private String _description;
	private EmployeeType _escapedModel;
}