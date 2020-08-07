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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveManagementException;
import com.liferay.famocom.erpcloud.model.LeaveManagement;
import com.liferay.famocom.erpcloud.service.base.LeaveManagementLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the leave management local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.LeaveManagementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see LeaveManagementLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.LeaveManagementLocalServiceUtil
 */
public class LeaveManagementLocalServiceImpl
	extends LeaveManagementLocalServiceBaseImpl {

	public LeaveManagement findByleaveName(String leaveName) throws SystemException {
	LeaveManagement leaveManagement = null;
	try {
	leaveManagement = getLeaveManagementPersistence().findByleaveName(leaveName);
	} catch (NoSuchLeaveManagementException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return leaveManagement;
	}
}