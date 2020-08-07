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
import java.util.Date;
import java.util.List;

import com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException;
import com.liferay.famocom.erpcloud.model.Attendance;
import com.liferay.famocom.erpcloud.service.base.AttendanceLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the attendance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.AttendanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see AttendanceLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.AttendanceLocalServiceUtil
 */
public class AttendanceLocalServiceImpl extends AttendanceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.AttendanceLocalServiceUtil} to access the attendance local service.
	 */
	public Attendance findByempIdAndAttDate(long employeeId, Date attDate) throws SystemException{
		Attendance attendance = null;
		try {
			attendance = getAttendancePersistence().findByempIdAndAttDate(employeeId, attDate);
		} catch (NoSuchAttendanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attendance;
		}
	
	public List<Attendance> findbyempIdAndAttDateComId(long employeeId,long companyId,Date attDate) throws SystemException{
		
		 List<Attendance> attendanceList = new ArrayList<Attendance>();
			try {
				attendanceList = getAttendancePersistence().findByempIdAndAttDateComId(employeeId, companyId, attDate);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return attendanceList;
	}
	
	public List<Attendance> findbyempId(long employeeId) throws SystemException{
		
		 List<Attendance> attendanceListById = new ArrayList<Attendance>();
			try {
				attendanceListById = getAttendancePersistence().findByempId(employeeId);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return attendanceListById;
	}
}