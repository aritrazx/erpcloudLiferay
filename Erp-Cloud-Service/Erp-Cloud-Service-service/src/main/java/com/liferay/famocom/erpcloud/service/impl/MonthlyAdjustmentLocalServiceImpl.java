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

import com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException;
import com.liferay.famocom.erpcloud.model.MonthlyAdjustment;
import com.liferay.famocom.erpcloud.service.base.MonthlyAdjustmentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the monthly adjustment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see MonthlyAdjustmentLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalServiceUtil
 */
public class MonthlyAdjustmentLocalServiceImpl
	extends MonthlyAdjustmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalServiceUtil} to access the monthly adjustment local service.
	 */
	public List<MonthlyAdjustment> findMonthlyAdjustmentByEmployeeId(long employeeId) throws SystemException{
		List<MonthlyAdjustment> monthlyAdjustments = new ArrayList<MonthlyAdjustment>();
		monthlyAdjustments = getMonthlyAdjustmentPersistence().findByemployeeId(employeeId);
		return monthlyAdjustments;
		}
	public List<MonthlyAdjustment> findMonthlyAdjustmentByMonthYear(long monthYear) throws SystemException{
		List<MonthlyAdjustment> monthlyAdjustments = new ArrayList<MonthlyAdjustment>();
		monthlyAdjustments = getMonthlyAdjustmentPersistence().findBymonthYear(monthYear);
		return monthlyAdjustments;
		}
	public List<MonthlyAdjustment> findMonthlyAdjustmentByMonthYearAndEmployeeId(long monthYear,long employeeId) throws SystemException{
		List<MonthlyAdjustment> monthlyAdjustments = new ArrayList<MonthlyAdjustment>();
		monthlyAdjustments = getMonthlyAdjustmentPersistence().findBymonthYearAndemployeeId(monthYear, employeeId);
		return monthlyAdjustments;
		}
	public MonthlyAdjustment findMonthlyAdjustmentByMonthYearAndEmployeeIdAndPayComponentId(long monthYear,long employeeId,long payComponentId) throws SystemException, NoSuchMonthlyAdjustmentException{
		MonthlyAdjustment monthlyAdjustment = getMonthlyAdjustmentPersistence().findBymonthYearAndemployeeIdAndpayComponentId(monthYear, employeeId, payComponentId);
		return monthlyAdjustment;
		}
	
}