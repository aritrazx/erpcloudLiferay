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

import com.liferay.famocom.erpcloud.model.ProjectRole;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProjectRole in entity cache.
 *
 * @author Samaresh
 * @see ProjectRole
 * @generated
 */
@ProviderType
public class ProjectRoleCacheModel implements CacheModel<ProjectRole>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectRoleCacheModel)) {
			return false;
		}

		ProjectRoleCacheModel projectRoleCacheModel = (ProjectRoleCacheModel)obj;

		if (roleId == projectRoleCacheModel.roleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, roleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{roleId=");
		sb.append(roleId);
		sb.append(", roleName=");
		sb.append(roleName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectRole toEntityModel() {
		ProjectRoleImpl projectRoleImpl = new ProjectRoleImpl();

		projectRoleImpl.setRoleId(roleId);

		if (roleName == null) {
			projectRoleImpl.setRoleName("");
		}
		else {
			projectRoleImpl.setRoleName(roleName);
		}

		projectRoleImpl.resetOriginalValues();

		return projectRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		roleId = objectInput.readLong();
		roleName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(roleId);

		if (roleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(roleName);
		}
	}

	public long roleId;
	public String roleName;
}