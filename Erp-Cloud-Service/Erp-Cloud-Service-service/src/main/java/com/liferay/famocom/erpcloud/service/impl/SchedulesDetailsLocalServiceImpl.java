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

import java.util.Date;
import java.util.List;

import com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException;
import com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException;
import com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException;
import com.liferay.famocom.erpcloud.model.Attendance;
import com.liferay.famocom.erpcloud.model.SchedulesDetails;
import com.liferay.famocom.erpcloud.service.base.SchedulesDetailsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the schedules details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see SchedulesDetailsLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalServiceUtil
 */
public class SchedulesDetailsLocalServiceImpl
	extends SchedulesDetailsLocalServiceBaseImpl {
	
	public List<SchedulesDetails> findBycheckDate(long employeeId,long companyId,Date schedulesDate) throws SystemException, NoSuchRecruitProcessException{
		List<SchedulesDetails> detailsCheck=null;
		detailsCheck = getSchedulesDetailsPersistence().findBycheckDate(employeeId,companyId,schedulesDate);
		return detailsCheck;
		}
	
	public List<SchedulesDetails> findBydetailsEdit(long worksSchedulesId) throws SystemException, NoSuchRecruitProcessException{
		List<SchedulesDetails> detailsCheck=null;
		detailsCheck = getSchedulesDetailsPersistence().findBydetailsEdit(worksSchedulesId);
		return detailsCheck;
		}
	
	public SchedulesDetails findByempIdAndAttDate(long employeeId, Date schedulesDate) throws SystemException{
		SchedulesDetails schedulesDetails = null;
		try {
			schedulesDetails = getSchedulesDetailsPersistence().findByempIdAndAttDate(employeeId, schedulesDate);
		} catch (NoSuchSchedulesDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schedulesDetails;
		}
}