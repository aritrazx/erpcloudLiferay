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

import com.liferay.famocom.erpcloud.exception.NoSuchStopPayException;
import com.liferay.famocom.erpcloud.model.StopPay;
import com.liferay.famocom.erpcloud.service.base.StopPayLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the stop pay local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.StopPayLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see StopPayLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.StopPayLocalServiceUtil
 */
public class StopPayLocalServiceImpl extends StopPayLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.StopPayLocalServiceUtil} to access the stop pay local service.
	 */

	public List<StopPay> findStopPayByEmployeeId(long employeeId) throws SystemException{
		List<StopPay> payList = new ArrayList<StopPay>();
		payList = getStopPayPersistence().findByemployeeId(employeeId);
		return payList;
		}
	public List<StopPay> findStopPayByMonthYear(long monthYear) throws SystemException{
		List<StopPay> payList = new ArrayList<StopPay>();
		payList = getStopPayPersistence().findBymonthYear(monthYear);
		return payList;
		}
	public List<StopPay>  findStopPayByMonthYearAndStatus(long monthYear,long status) throws NoSuchStopPayException{
		List<StopPay> payList = new ArrayList<StopPay>();
		payList = getStopPayPersistence().findByMonthYearAndStatus(monthYear, status);
		return payList;
	}
	
	public StopPay  findStopPayByEmployeeIdAndMonthYear(long employeeId,long monthYear) throws NoSuchStopPayException{
		StopPay paStopPay = getStopPayPersistence().findByemployeeIdAndMonthYear(employeeId, monthYear);
		return paStopPay;
		}
}