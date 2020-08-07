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

import com.liferay.famocom.erpcloud.model.LeaveOb;
import com.liferay.famocom.erpcloud.service.base.LeaveObLocalServiceBaseImpl;

/**
 * The implementation of the leave ob local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.LeaveObLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see LeaveObLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.LeaveObLocalServiceUtil
 */
public class LeaveObLocalServiceImpl extends LeaveObLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.LeaveObLocalServiceUtil} to access the leave ob local service.
	 */
	
	public LeaveOb openingBalance(long employeeId,long leaveTypeId) {
		LeaveOb leaveOb =null;
		try{
		leaveOb = leaveObPersistence.findByopeningBalance(employeeId, leaveTypeId);
		}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		}
		System.out.println(":::::leaveOb::::::"+leaveOb);
		return leaveOb;
		}
}