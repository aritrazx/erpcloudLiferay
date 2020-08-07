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

import com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException;
import com.liferay.famocom.erpcloud.model.Expense;
import com.liferay.famocom.erpcloud.model.SchedulesDetails;
import com.liferay.famocom.erpcloud.service.base.SchedulesMasterLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the schedules master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.SchedulesMasterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see SchedulesMasterLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.SchedulesMasterLocalServiceUtil
 */
public class SchedulesMasterLocalServiceImpl
	extends SchedulesMasterLocalServiceBaseImpl {
	public List<SchedulesDetails> findBycheckDate(long employeeId,long companyId,Date schedulesDate) throws SystemException, NoSuchRecruitProcessException{
		List<SchedulesDetails> detailsCheck=null;
		detailsCheck = getSchedulesDetailsPersistence().findBycheckDate(employeeId,companyId,schedulesDate);
		return detailsCheck;
		}
}