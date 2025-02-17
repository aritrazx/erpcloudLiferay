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

import com.liferay.famocom.erpcloud.model.ProjectRole;
import com.liferay.famocom.erpcloud.model.ProjectRoleModel;
import com.liferay.famocom.erpcloud.model.ProjectRoleSoap;

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
 * The base model implementation for the ProjectRole service. Represents a row in the &quot;projectRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ProjectRoleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectRoleImpl}.
 * </p>
 *
 * @author Samaresh
 * @see ProjectRoleImpl
 * @see ProjectRole
 * @see ProjectRoleModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ProjectRoleModelImpl extends BaseModelImpl<ProjectRole>
	implements ProjectRoleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project role model instance should use the {@link ProjectRole} interface instead.
	 */
	public static final String TABLE_NAME = "projectRole";
	public static final Object[][] TABLE_COLUMNS = {
			{ "roleId", Types.BIGINT },
			{ "roleName", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("roleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("roleName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table projectRole (roleId LONG not null primary key,roleName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table projectRole";
	public static final String ORDER_BY_JPQL = " ORDER BY projectRole.roleId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY projectRole.roleId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.ProjectRole"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.ProjectRole"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ProjectRole toModel(ProjectRoleSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProjectRole model = new ProjectRoleImpl();

		model.setRoleId(soapModel.getRoleId());
		model.setRoleName(soapModel.getRoleName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ProjectRole> toModels(ProjectRoleSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ProjectRole> models = new ArrayList<ProjectRole>(soapModels.length);

		for (ProjectRoleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.ProjectRole"));

	public ProjectRoleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _roleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRoleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _roleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectRole.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roleId", getRoleId());
		attributes.put("roleName", getRoleName());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String roleName = (String)attributes.get("roleName");

		if (roleName != null) {
			setRoleName(roleName);
		}
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
	public String getRoleName() {
		if (_roleName == null) {
			return "";
		}
		else {
			return _roleName;
		}
	}

	@Override
	public void setRoleName(String roleName) {
		_roleName = roleName;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ProjectRole.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProjectRole toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ProjectRole)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProjectRoleImpl projectRoleImpl = new ProjectRoleImpl();

		projectRoleImpl.setRoleId(getRoleId());
		projectRoleImpl.setRoleName(getRoleName());

		projectRoleImpl.resetOriginalValues();

		return projectRoleImpl;
	}

	@Override
	public int compareTo(ProjectRole projectRole) {
		long primaryKey = projectRole.getPrimaryKey();

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

		if (!(obj instanceof ProjectRole)) {
			return false;
		}

		ProjectRole projectRole = (ProjectRole)obj;

		long primaryKey = projectRole.getPrimaryKey();

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
	public CacheModel<ProjectRole> toCacheModel() {
		ProjectRoleCacheModel projectRoleCacheModel = new ProjectRoleCacheModel();

		projectRoleCacheModel.roleId = getRoleId();

		projectRoleCacheModel.roleName = getRoleName();

		String roleName = projectRoleCacheModel.roleName;

		if ((roleName != null) && (roleName.length() == 0)) {
			projectRoleCacheModel.roleName = null;
		}

		return projectRoleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{roleId=");
		sb.append(getRoleId());
		sb.append(", roleName=");
		sb.append(getRoleName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.ProjectRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleName</column-name><column-value><![CDATA[");
		sb.append(getRoleName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ProjectRole.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ProjectRole.class, ModelWrapper.class
		};
	private long _roleId;
	private String _roleName;
	private ProjectRole _escapedModel;
}