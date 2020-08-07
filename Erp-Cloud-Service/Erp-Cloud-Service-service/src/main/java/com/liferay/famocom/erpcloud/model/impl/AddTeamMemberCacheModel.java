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

import com.liferay.famocom.erpcloud.model.AddTeamMember;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AddTeamMember in entity cache.
 *
 * @author Samaresh
 * @see AddTeamMember
 * @generated
 */
@ProviderType
public class AddTeamMemberCacheModel implements CacheModel<AddTeamMember>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddTeamMemberCacheModel)) {
			return false;
		}

		AddTeamMemberCacheModel addTeamMemberCacheModel = (AddTeamMemberCacheModel)obj;

		if (projectTeamsId == addTeamMemberCacheModel.projectTeamsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectTeamsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{projectTeamsId=");
		sb.append(projectTeamsId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append(", isProjectManager=");
		sb.append(isProjectManager);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AddTeamMember toEntityModel() {
		AddTeamMemberImpl addTeamMemberImpl = new AddTeamMemberImpl();

		addTeamMemberImpl.setProjectTeamsId(projectTeamsId);
		addTeamMemberImpl.setEmployeeId(employeeId);
		addTeamMemberImpl.setProjectId(projectId);
		addTeamMemberImpl.setCompanyId(companyId);
		addTeamMemberImpl.setRoleId(roleId);

		if (addedDate == Long.MIN_VALUE) {
			addTeamMemberImpl.setAddedDate(null);
		}
		else {
			addTeamMemberImpl.setAddedDate(new Date(addedDate));
		}

		addTeamMemberImpl.setIsProjectManager(isProjectManager);

		addTeamMemberImpl.resetOriginalValues();

		return addTeamMemberImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectTeamsId = objectInput.readLong();

		employeeId = objectInput.readLong();

		projectId = objectInput.readLong();

		companyId = objectInput.readLong();

		roleId = objectInput.readLong();
		addedDate = objectInput.readLong();

		isProjectManager = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectTeamsId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(roleId);
		objectOutput.writeLong(addedDate);

		objectOutput.writeBoolean(isProjectManager);
	}

	public long projectTeamsId;
	public long employeeId;
	public long projectId;
	public long companyId;
	public long roleId;
	public long addedDate;
	public boolean isProjectManager;
}