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

package com.liferay.famocom.erpcloud.service.impl;

import java.util.List;

import com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException;
import com.liferay.famocom.erpcloud.model.AddTeamMember;
import com.liferay.famocom.erpcloud.model.ProjectMaster;
import com.liferay.famocom.erpcloud.service.base.AddTeamMemberLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the add team member local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.famocom.erpcloud.service.AddTeamMemberLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see AddTeamMemberLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil
 */
public class AddTeamMemberLocalServiceImpl extends AddTeamMemberLocalServiceBaseImpl {
	public List<AddTeamMember> findBygetProjectId(long employeeId, long companyId)
			throws SystemException, NoSuchRecruitProcessException {
		List<AddTeamMember> teamMember = null;
		teamMember = getAddTeamMemberPersistence().findBygetProjectId(employeeId, companyId);
		return teamMember;
	}

	public List<AddTeamMember> findByprojectManager(boolean isProjectManager)
			throws SystemException, NoSuchRecruitProcessException {
		List<AddTeamMember> teamMember = null;
		teamMember = getAddTeamMemberPersistence().findByprojectManager(isProjectManager);
		return teamMember;
	}

	public List<AddTeamMember> findByprojectMember(long projectId)
			throws SystemException, NoSuchRecruitProcessException {
		List<AddTeamMember> teamMember = null;
		teamMember = getAddTeamMemberPersistence().findByprojectMember(projectId);
		return teamMember;
	}

	public AddTeamMember findByGetProjectManager(long employeeId, long projectId) {
		AddTeamMember getPM = null;
		if (employeeId > 0 && projectId > 0) {
			try {
				getPM = addTeamMemberPersistence.findBygetProjectManager(employeeId, projectId);
			} catch (Exception e) {
			}
		}
		return getPM;
	}

	public List<AddTeamMember> findByGetProjectManagerProjectList(long employeeId, boolean isProjectManager)
			throws SystemException, NoSuchRecruitProcessException {
		List<AddTeamMember> teamMember = null;
		teamMember = getAddTeamMemberPersistence().findBygetProjectManagerProjectList(employeeId, isProjectManager);
		return teamMember;
	}

	public AddTeamMember findByGetProjectManager(long projectId, long employeeId, boolean isProjectManager) {
		AddTeamMember getPM = null;
		if (projectId > 0 && isProjectManager) {
			try {
				getPM = addTeamMemberPersistence.findBygetProjectManagerProject(projectId, employeeId, isProjectManager);
			} catch (Exception e) {
			}
		}
		return getPM;
	}
}