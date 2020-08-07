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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ProjectRoleServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ProjectRoleServiceSoap
 * @generated
 */
@ProviderType
public class ProjectRoleSoap implements Serializable {
	public static ProjectRoleSoap toSoapModel(ProjectRole model) {
		ProjectRoleSoap soapModel = new ProjectRoleSoap();

		soapModel.setRoleId(model.getRoleId());
		soapModel.setRoleName(model.getRoleName());

		return soapModel;
	}

	public static ProjectRoleSoap[] toSoapModels(ProjectRole[] models) {
		ProjectRoleSoap[] soapModels = new ProjectRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectRoleSoap[][] toSoapModels(ProjectRole[][] models) {
		ProjectRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectRoleSoap[] toSoapModels(List<ProjectRole> models) {
		List<ProjectRoleSoap> soapModels = new ArrayList<ProjectRoleSoap>(models.size());

		for (ProjectRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectRoleSoap[soapModels.size()]);
	}

	public ProjectRoleSoap() {
	}

	public long getPrimaryKey() {
		return _roleId;
	}

	public void setPrimaryKey(long pk) {
		setRoleId(pk);
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public String getRoleName() {
		return _roleName;
	}

	public void setRoleName(String roleName) {
		_roleName = roleName;
	}

	private long _roleId;
	private String _roleName;
}