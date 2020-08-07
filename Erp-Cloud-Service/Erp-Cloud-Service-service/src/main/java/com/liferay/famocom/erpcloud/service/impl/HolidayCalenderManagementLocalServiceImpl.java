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

import com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException;
import com.liferay.famocom.erpcloud.model.HolidayCalenderManagement;
import com.liferay.famocom.erpcloud.service.base.HolidayCalenderManagementLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the holiday calender management local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see HolidayCalenderManagementLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalServiceUtil
 */
public class HolidayCalenderManagementLocalServiceImpl extends HolidayCalenderManagementLocalServiceBaseImpl {
	public HolidayCalenderManagement findByempIdAndAttDate(Date holidayDate) throws SystemException {
		HolidayCalenderManagement holiday = null;
		try {
			holiday = getHolidayCalenderManagementPersistence().findByempIdAndAttDate(holidayDate);
		} catch (NoSuchHolidayCalenderManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return holiday;
	}

	public List<HolidayCalenderManagement> findByHoliDayCheck(Date holidayDate)
			throws SystemException, NoSuchHolidayCalenderManagementException {
		List<HolidayCalenderManagement> holidayList = null;
		System.out.println("----holidayDate-----" + holidayDate);
		try {
			holidayList = holidayCalenderManagementPersistence.findByholiDayCheck(holidayDate);
			System.out.println("------holidayList------" + holidayList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return holidayList;
	}

	public List<HolidayCalenderManagement> getHolidays(Date fromDate, Date toDate)
			throws SystemException, NoSuchHolidayCalenderManagementException {
		List<HolidayCalenderManagement> holidayList = null;
		System.out.println("----fromDate-----" + fromDate);
		System.out.println("----toDate-----" + toDate);

		DynamicQuery query = dynamicQuery();
		query.add(PropertyFactoryUtil.forName("holidayDate").ge(fromDate))
				.add(PropertyFactoryUtil.forName("holidayDate").le(toDate));
		holidayList = dynamicQuery(query);

		System.out.println("------holidayList------" + holidayList.size());
		return holidayList;
	}

	public List<HolidayCalenderManagement> findByNameAndHoliDayId(String holidayName, long holidayId)
			throws SystemException {
		List<HolidayCalenderManagement> calenderManagements = new ArrayList<HolidayCalenderManagement>();
		calenderManagements = getHolidayCalenderManagementPersistence().findBynameAndHoliDayId(holidayName, holidayId);
		return calenderManagements;
	}

	public List<HolidayCalenderManagement> findByDateAndHoliDayId(Date holidayDate, long holidayId)
			throws SystemException {
		List<HolidayCalenderManagement> payComponentsList = new ArrayList<HolidayCalenderManagement>();
		payComponentsList = getHolidayCalenderManagementPersistence().findBydateAndHoliDayId(holidayDate, holidayId);
		return payComponentsList;
	}
}