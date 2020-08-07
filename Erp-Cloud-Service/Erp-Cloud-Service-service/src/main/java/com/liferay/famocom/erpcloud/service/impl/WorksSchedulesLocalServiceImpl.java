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

import com.liferay.famocom.erpcloud.model.Attendance;
import com.liferay.famocom.erpcloud.model.WorksSchedules;
import com.liferay.famocom.erpcloud.service.base.WorksSchedulesLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the works schedules local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.WorksSchedulesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see WorksSchedulesLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.WorksSchedulesLocalServiceUtil
 */
public class WorksSchedulesLocalServiceImpl
	extends WorksSchedulesLocalServiceBaseImpl {
	public List<WorksSchedules> findbyschedulesId(long schedulesId) throws SystemException{
		
		 List<WorksSchedules> WorksSchedulesId = new ArrayList<WorksSchedules>();
			try {
				WorksSchedulesId = getWorksSchedulesPersistence().findByschedulesId(schedulesId);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return WorksSchedulesId;
	}
	public List<WorksSchedules> findbyfromToDate(Date fromDate,Date toDate) throws SystemException{
		
		 List<WorksSchedules> schedulesFromToDate = new ArrayList<WorksSchedules>();
			try {
				schedulesFromToDate = getWorksSchedulesPersistence().findByfromToDate(fromDate, toDate);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return schedulesFromToDate;
	}
	public List<WorksSchedules> findbytoDate(Date toDate) throws SystemException{
		
		 List<WorksSchedules> schedulesToDate = new ArrayList<WorksSchedules>();
			try {
				schedulesToDate = getWorksSchedulesPersistence().findBytoDate(toDate);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return schedulesToDate;
	}
}