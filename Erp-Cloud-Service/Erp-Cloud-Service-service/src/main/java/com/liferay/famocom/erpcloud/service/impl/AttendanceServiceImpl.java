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

import com.liferay.famocom.erpcloud.model.Attendance;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.service.AttendanceLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.base.AttendanceServiceBaseImpl;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

/**
 * The implementation of the attendance remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.AttendanceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Samaresh
 * @see AttendanceServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.AttendanceServiceUtil
 */
public class AttendanceServiceImpl extends AttendanceServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.AttendanceServiceUtil} to access the attendance remote service.
	 */
	@AccessControlled(guestAccessEnabled=true)
	public List<Attendance> attendanceById(long userId){
		List<Attendance> attendanceList=null;
		try{
		Employee empId = EmployeeLocalServiceUtil.findByemployees(userId);
		System.out.println("empId.getEmployeeId()"+empId.getEmployeeId());
		
		attendanceList = AttendanceLocalServiceUtil.findbyempId(empId.getEmployeeId());
		System.out.println("attendanceList:---"+attendanceList);
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return attendanceList;
	}
}