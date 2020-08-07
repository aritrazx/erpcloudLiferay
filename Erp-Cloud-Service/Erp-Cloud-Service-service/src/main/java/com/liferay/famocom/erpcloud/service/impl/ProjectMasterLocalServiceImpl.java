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

import java.util.ArrayList;
import java.util.List;

import com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException;
import com.liferay.famocom.erpcloud.model.ProjectMaster;
import com.liferay.famocom.erpcloud.service.base.ProjectMasterLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the project master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.famocom.erpcloud.service.ProjectMasterLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see ProjectMasterLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil
 */
public class ProjectMasterLocalServiceImpl extends ProjectMasterLocalServiceBaseImpl {
	public List<ProjectMaster> findByprojectId(long employeeId, long companyId)
			throws SystemException, NoSuchRecruitProcessException {
		List<ProjectMaster> projectMaster = null;
		projectMaster = getProjectMasterPersistence().findByprojectId(employeeId, companyId);
		return projectMaster;
	}

	public List<ProjectMaster> findByEmployeeId(long employeeId) {
		List<ProjectMaster> projectMasters = new ArrayList<ProjectMaster>();
		if (employeeId > 0) {
			try {
				projectMasters = projectMasterPersistence.findByEmployeeId(employeeId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		return projectMasters;
	}
}