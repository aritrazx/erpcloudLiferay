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

import com.liferay.famocom.erpcloud.model.ProjectMaster;
import com.liferay.famocom.erpcloud.service.PerformanceMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ProjectMasterServiceUtil;
import com.liferay.famocom.erpcloud.service.base.ProjectMasterServiceBaseImpl;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

/**
 * The implementation of the project master remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.ProjectMasterService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Samaresh
 * @see ProjectMasterServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.ProjectMasterServiceUtil
 */
public class ProjectMasterServiceImpl extends ProjectMasterServiceBaseImpl {
	@AccessControlled(guestAccessEnabled=true)
	public List<ProjectMaster> getAllProject(){
		List<ProjectMaster> projectList = ProjectMasterLocalServiceUtil.getProjectMasters(-1,-1);
		return projectList;
	}
}