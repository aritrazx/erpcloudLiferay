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

import com.liferay.famocom.erpcloud.model.AddTeamMember;
import com.liferay.famocom.erpcloud.model.AddTeamMemberModel;
import com.liferay.famocom.erpcloud.model.AddTeamMemberSoap;

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
 * The base model implementation for the AddTeamMember service. Represents a row in the &quot;addTeamMember&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link AddTeamMemberModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AddTeamMemberImpl}.
 * </p>
 *
 * @author Samaresh
 * @see AddTeamMemberImpl
 * @see AddTeamMember
 * @see AddTeamMemberModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class AddTeamMemberModelImpl extends BaseModelImpl<AddTeamMember>
	implements AddTeamMemberModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a add team member model instance should use the {@link AddTeamMember} interface instead.
	 */
	public static final String TABLE_NAME = "addTeamMember";
	public static final Object[][] TABLE_COLUMNS = {
			{ "projectTeamsId", Types.BIGINT },
			{ "employeeId", Types.BIGINT },
			{ "projectId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "roleId", Types.BIGINT },
			{ "addedDate", Types.TIMESTAMP },
			{ "isProjectManager", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("projectTeamsId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("roleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("addedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("isProjectManager", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table addTeamMember (projectTeamsId LONG not null primary key,employeeId LONG,projectId LONG,companyId LONG,roleId LONG,addedDate DATE null,isProjectManager BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table addTeamMember";
	public static final String ORDER_BY_JPQL = " ORDER BY addTeamMember.projectTeamsId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY addTeamMember.projectTeamsId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.AddTeamMember"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.AddTeamMember"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.famocom.erpcloud.model.AddTeamMember"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long EMPLOYEEID_COLUMN_BITMASK = 2L;
	public static final long ISPROJECTMANAGER_COLUMN_BITMASK = 4L;
	public static final long PROJECTID_COLUMN_BITMASK = 8L;
	public static final long PROJECTTEAMSID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AddTeamMember toModel(AddTeamMemberSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AddTeamMember model = new AddTeamMemberImpl();

		model.setProjectTeamsId(soapModel.getProjectTeamsId());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setProjectId(soapModel.getProjectId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setRoleId(soapModel.getRoleId());
		model.setAddedDate(soapModel.getAddedDate());
		model.setIsProjectManager(soapModel.isIsProjectManager());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AddTeamMember> toModels(AddTeamMemberSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AddTeamMember> models = new ArrayList<AddTeamMember>(soapModels.length);

		for (AddTeamMemberSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.AddTeamMember"));

	public AddTeamMemberModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _projectTeamsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectTeamsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectTeamsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AddTeamMember.class;
	}

	@Override
	public String getModelClassName() {
		return AddTeamMember.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectTeamsId", getProjectTeamsId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("projectId", getProjectId());
		attributes.put("companyId", getCompanyId());
		attributes.put("roleId", getRoleId());
		attributes.put("addedDate", getAddedDate());
		attributes.put("isProjectManager", isIsProjectManager());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectTeamsId = (Long)attributes.get("projectTeamsId");

		if (projectTeamsId != null) {
			setProjectTeamsId(projectTeamsId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}

		Boolean isProjectManager = (Boolean)attributes.get("isProjectManager");

		if (isProjectManager != null) {
			setIsProjectManager(isProjectManager);
		}
	}

	@JSON
	@Override
	public long getProjectTeamsId() {
		return _projectTeamsId;
	}

	@Override
	public void setProjectTeamsId(long projectTeamsId) {
		_projectTeamsId = projectTeamsId;
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
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_columnBitmask |= PROJECTID_COLUMN_BITMASK;

		if (!_setOriginalProjectId) {
			_setOriginalProjectId = true;

			_originalProjectId = _projectId;
		}

		_projectId = projectId;
	}

	public long getOriginalProjectId() {
		return _originalProjectId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_roleId = roleId;
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
	public boolean getIsProjectManager() {
		return _isProjectManager;
	}

	@JSON
	@Override
	public boolean isIsProjectManager() {
		return _isProjectManager;
	}

	@Override
	public void setIsProjectManager(boolean isProjectManager) {
		_columnBitmask |= ISPROJECTMANAGER_COLUMN_BITMASK;

		if (!_setOriginalIsProjectManager) {
			_setOriginalIsProjectManager = true;

			_originalIsProjectManager = _isProjectManager;
		}

		_isProjectManager = isProjectManager;
	}

	public boolean getOriginalIsProjectManager() {
		return _originalIsProjectManager;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			AddTeamMember.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AddTeamMember toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AddTeamMember)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AddTeamMemberImpl addTeamMemberImpl = new AddTeamMemberImpl();

		addTeamMemberImpl.setProjectTeamsId(getProjectTeamsId());
		addTeamMemberImpl.setEmployeeId(getEmployeeId());
		addTeamMemberImpl.setProjectId(getProjectId());
		addTeamMemberImpl.setCompanyId(getCompanyId());
		addTeamMemberImpl.setRoleId(getRoleId());
		addTeamMemberImpl.setAddedDate(getAddedDate());
		addTeamMemberImpl.setIsProjectManager(isIsProjectManager());

		addTeamMemberImpl.resetOriginalValues();

		return addTeamMemberImpl;
	}

	@Override
	public int compareTo(AddTeamMember addTeamMember) {
		long primaryKey = addTeamMember.getPrimaryKey();

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

		if (!(obj instanceof AddTeamMember)) {
			return false;
		}

		AddTeamMember addTeamMember = (AddTeamMember)obj;

		long primaryKey = addTeamMember.getPrimaryKey();

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
		AddTeamMemberModelImpl addTeamMemberModelImpl = this;

		addTeamMemberModelImpl._originalEmployeeId = addTeamMemberModelImpl._employeeId;

		addTeamMemberModelImpl._setOriginalEmployeeId = false;

		addTeamMemberModelImpl._originalProjectId = addTeamMemberModelImpl._projectId;

		addTeamMemberModelImpl._setOriginalProjectId = false;

		addTeamMemberModelImpl._originalCompanyId = addTeamMemberModelImpl._companyId;

		addTeamMemberModelImpl._setOriginalCompanyId = false;

		addTeamMemberModelImpl._originalIsProjectManager = addTeamMemberModelImpl._isProjectManager;

		addTeamMemberModelImpl._setOriginalIsProjectManager = false;

		addTeamMemberModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AddTeamMember> toCacheModel() {
		AddTeamMemberCacheModel addTeamMemberCacheModel = new AddTeamMemberCacheModel();

		addTeamMemberCacheModel.projectTeamsId = getProjectTeamsId();

		addTeamMemberCacheModel.employeeId = getEmployeeId();

		addTeamMemberCacheModel.projectId = getProjectId();

		addTeamMemberCacheModel.companyId = getCompanyId();

		addTeamMemberCacheModel.roleId = getRoleId();

		Date addedDate = getAddedDate();

		if (addedDate != null) {
			addTeamMemberCacheModel.addedDate = addedDate.getTime();
		}
		else {
			addTeamMemberCacheModel.addedDate = Long.MIN_VALUE;
		}

		addTeamMemberCacheModel.isProjectManager = isIsProjectManager();

		return addTeamMemberCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{projectTeamsId=");
		sb.append(getProjectTeamsId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", addedDate=");
		sb.append(getAddedDate());
		sb.append(", isProjectManager=");
		sb.append(isIsProjectManager());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.AddTeamMember");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectTeamsId</column-name><column-value><![CDATA[");
		sb.append(getProjectTeamsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addedDate</column-name><column-value><![CDATA[");
		sb.append(getAddedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isProjectManager</column-name><column-value><![CDATA[");
		sb.append(isIsProjectManager());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = AddTeamMember.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			AddTeamMember.class, ModelWrapper.class
		};
	private long _projectTeamsId;
	private long _employeeId;
	private long _originalEmployeeId;
	private boolean _setOriginalEmployeeId;
	private long _projectId;
	private long _originalProjectId;
	private boolean _setOriginalProjectId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _roleId;
	private Date _addedDate;
	private boolean _isProjectManager;
	private boolean _originalIsProjectManager;
	private boolean _setOriginalIsProjectManager;
	private long _columnBitmask;
	private AddTeamMember _escapedModel;
}