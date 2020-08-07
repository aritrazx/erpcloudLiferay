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

import com.liferay.famocom.erpcloud.model.TimeSheetEntry;
import com.liferay.famocom.erpcloud.service.base.TimeSheetEntryLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * The implementation of the time sheet entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see TimeSheetEntryLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil
 */
public class TimeSheetEntryLocalServiceImpl
	extends TimeSheetEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil} to access the time sheet entry local service.
	 */
	public List<Object[]> getDistinctTimesheetListByEmployeeIdAndDateRange(long  employeeId,Date startDate,Date endDate)
	{
	Session session = timeSheetEntryPersistence.openSession();
	SQLQuery sqlQuery = null;
	sqlQuery = session.createSQLQuery(
	"SELECT DISTINCT projectId,projectTaskId FROM timeSheetEntry WHERE employeeId=? AND entryDate BETWEEN ? AND ?");
	QueryPos pos = QueryPos.getInstance(sqlQuery);
	pos.add(employeeId);
	pos.add(startDate);
	pos.add(endDate);
	return sqlQuery.list();	

	}
	
	
}