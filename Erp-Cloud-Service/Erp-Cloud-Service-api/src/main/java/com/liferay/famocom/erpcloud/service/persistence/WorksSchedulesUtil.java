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

package com.liferay.famocom.erpcloud.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.WorksSchedules;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the works schedules service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.WorksSchedulesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see WorksSchedulesPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.WorksSchedulesPersistenceImpl
 * @generated
 */
@ProviderType
public class WorksSchedulesUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(WorksSchedules worksSchedules) {
		getPersistence().clearCache(worksSchedules);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorksSchedules> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorksSchedules> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorksSchedules> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorksSchedules> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorksSchedules update(WorksSchedules worksSchedules) {
		return getPersistence().update(worksSchedules);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorksSchedules update(WorksSchedules worksSchedules,
		ServiceContext serviceContext) {
		return getPersistence().update(worksSchedules, serviceContext);
	}

	/**
	* Returns all the works scheduleses where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @return the matching works scheduleses
	*/
	public static List<WorksSchedules> findByschedulesId(long schedulesId) {
		return getPersistence().findByschedulesId(schedulesId);
	}

	/**
	* Returns a range of all the works scheduleses where schedulesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param schedulesId the schedules ID
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @return the range of matching works scheduleses
	*/
	public static List<WorksSchedules> findByschedulesId(long schedulesId,
		int start, int end) {
		return getPersistence().findByschedulesId(schedulesId, start, end);
	}

	/**
	* Returns an ordered range of all the works scheduleses where schedulesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param schedulesId the schedules ID
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching works scheduleses
	*/
	public static List<WorksSchedules> findByschedulesId(long schedulesId,
		int start, int end, OrderByComparator<WorksSchedules> orderByComparator) {
		return getPersistence()
				   .findByschedulesId(schedulesId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the works scheduleses where schedulesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param schedulesId the schedules ID
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching works scheduleses
	*/
	public static List<WorksSchedules> findByschedulesId(long schedulesId,
		int start, int end,
		OrderByComparator<WorksSchedules> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByschedulesId(schedulesId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first works schedules in the ordered set where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public static WorksSchedules findByschedulesId_First(long schedulesId,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException {
		return getPersistence()
				   .findByschedulesId_First(schedulesId, orderByComparator);
	}

	/**
	* Returns the first works schedules in the ordered set where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public static WorksSchedules fetchByschedulesId_First(long schedulesId,
		OrderByComparator<WorksSchedules> orderByComparator) {
		return getPersistence()
				   .fetchByschedulesId_First(schedulesId, orderByComparator);
	}

	/**
	* Returns the last works schedules in the ordered set where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public static WorksSchedules findByschedulesId_Last(long schedulesId,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException {
		return getPersistence()
				   .findByschedulesId_Last(schedulesId, orderByComparator);
	}

	/**
	* Returns the last works schedules in the ordered set where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public static WorksSchedules fetchByschedulesId_Last(long schedulesId,
		OrderByComparator<WorksSchedules> orderByComparator) {
		return getPersistence()
				   .fetchByschedulesId_Last(schedulesId, orderByComparator);
	}

	/**
	* Returns the works scheduleses before and after the current works schedules in the ordered set where schedulesId = &#63;.
	*
	* @param worksSchedulesId the primary key of the current works schedules
	* @param schedulesId the schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next works schedules
	* @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	*/
	public static WorksSchedules[] findByschedulesId_PrevAndNext(
		long worksSchedulesId, long schedulesId,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException {
		return getPersistence()
				   .findByschedulesId_PrevAndNext(worksSchedulesId,
			schedulesId, orderByComparator);
	}

	/**
	* Removes all the works scheduleses where schedulesId = &#63; from the database.
	*
	* @param schedulesId the schedules ID
	*/
	public static void removeByschedulesId(long schedulesId) {
		getPersistence().removeByschedulesId(schedulesId);
	}

	/**
	* Returns the number of works scheduleses where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @return the number of matching works scheduleses
	*/
	public static int countByschedulesId(long schedulesId) {
		return getPersistence().countByschedulesId(schedulesId);
	}

	/**
	* Returns all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @return the matching works scheduleses
	*/
	public static List<WorksSchedules> findByfromToDate(Date fromDate,
		Date toDate) {
		return getPersistence().findByfromToDate(fromDate, toDate);
	}

	/**
	* Returns a range of all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @return the range of matching works scheduleses
	*/
	public static List<WorksSchedules> findByfromToDate(Date fromDate,
		Date toDate, int start, int end) {
		return getPersistence().findByfromToDate(fromDate, toDate, start, end);
	}

	/**
	* Returns an ordered range of all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching works scheduleses
	*/
	public static List<WorksSchedules> findByfromToDate(Date fromDate,
		Date toDate, int start, int end,
		OrderByComparator<WorksSchedules> orderByComparator) {
		return getPersistence()
				   .findByfromToDate(fromDate, toDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching works scheduleses
	*/
	public static List<WorksSchedules> findByfromToDate(Date fromDate,
		Date toDate, int start, int end,
		OrderByComparator<WorksSchedules> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByfromToDate(fromDate, toDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public static WorksSchedules findByfromToDate_First(Date fromDate,
		Date toDate, OrderByComparator<WorksSchedules> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException {
		return getPersistence()
				   .findByfromToDate_First(fromDate, toDate, orderByComparator);
	}

	/**
	* Returns the first works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public static WorksSchedules fetchByfromToDate_First(Date fromDate,
		Date toDate, OrderByComparator<WorksSchedules> orderByComparator) {
		return getPersistence()
				   .fetchByfromToDate_First(fromDate, toDate, orderByComparator);
	}

	/**
	* Returns the last works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public static WorksSchedules findByfromToDate_Last(Date fromDate,
		Date toDate, OrderByComparator<WorksSchedules> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException {
		return getPersistence()
				   .findByfromToDate_Last(fromDate, toDate, orderByComparator);
	}

	/**
	* Returns the last works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public static WorksSchedules fetchByfromToDate_Last(Date fromDate,
		Date toDate, OrderByComparator<WorksSchedules> orderByComparator) {
		return getPersistence()
				   .fetchByfromToDate_Last(fromDate, toDate, orderByComparator);
	}

	/**
	* Returns the works scheduleses before and after the current works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	*
	* @param worksSchedulesId the primary key of the current works schedules
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next works schedules
	* @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	*/
	public static WorksSchedules[] findByfromToDate_PrevAndNext(
		long worksSchedulesId, Date fromDate, Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException {
		return getPersistence()
				   .findByfromToDate_PrevAndNext(worksSchedulesId, fromDate,
			toDate, orderByComparator);
	}

	/**
	* Removes all the works scheduleses where fromDate = &#63; and toDate = &#63; from the database.
	*
	* @param fromDate the from date
	* @param toDate the to date
	*/
	public static void removeByfromToDate(Date fromDate, Date toDate) {
		getPersistence().removeByfromToDate(fromDate, toDate);
	}

	/**
	* Returns the number of works scheduleses where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @return the number of matching works scheduleses
	*/
	public static int countByfromToDate(Date fromDate, Date toDate) {
		return getPersistence().countByfromToDate(fromDate, toDate);
	}

	/**
	* Returns all the works scheduleses where toDate = &#63;.
	*
	* @param toDate the to date
	* @return the matching works scheduleses
	*/
	public static List<WorksSchedules> findBytoDate(Date toDate) {
		return getPersistence().findBytoDate(toDate);
	}

	/**
	* Returns a range of all the works scheduleses where toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @return the range of matching works scheduleses
	*/
	public static List<WorksSchedules> findBytoDate(Date toDate, int start,
		int end) {
		return getPersistence().findBytoDate(toDate, start, end);
	}

	/**
	* Returns an ordered range of all the works scheduleses where toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching works scheduleses
	*/
	public static List<WorksSchedules> findBytoDate(Date toDate, int start,
		int end, OrderByComparator<WorksSchedules> orderByComparator) {
		return getPersistence()
				   .findBytoDate(toDate, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the works scheduleses where toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching works scheduleses
	*/
	public static List<WorksSchedules> findBytoDate(Date toDate, int start,
		int end, OrderByComparator<WorksSchedules> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBytoDate(toDate, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first works schedules in the ordered set where toDate = &#63;.
	*
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public static WorksSchedules findBytoDate_First(Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException {
		return getPersistence().findBytoDate_First(toDate, orderByComparator);
	}

	/**
	* Returns the first works schedules in the ordered set where toDate = &#63;.
	*
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public static WorksSchedules fetchBytoDate_First(Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator) {
		return getPersistence().fetchBytoDate_First(toDate, orderByComparator);
	}

	/**
	* Returns the last works schedules in the ordered set where toDate = &#63;.
	*
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public static WorksSchedules findBytoDate_Last(Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException {
		return getPersistence().findBytoDate_Last(toDate, orderByComparator);
	}

	/**
	* Returns the last works schedules in the ordered set where toDate = &#63;.
	*
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public static WorksSchedules fetchBytoDate_Last(Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator) {
		return getPersistence().fetchBytoDate_Last(toDate, orderByComparator);
	}

	/**
	* Returns the works scheduleses before and after the current works schedules in the ordered set where toDate = &#63;.
	*
	* @param worksSchedulesId the primary key of the current works schedules
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next works schedules
	* @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	*/
	public static WorksSchedules[] findBytoDate_PrevAndNext(
		long worksSchedulesId, Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException {
		return getPersistence()
				   .findBytoDate_PrevAndNext(worksSchedulesId, toDate,
			orderByComparator);
	}

	/**
	* Removes all the works scheduleses where toDate = &#63; from the database.
	*
	* @param toDate the to date
	*/
	public static void removeBytoDate(Date toDate) {
		getPersistence().removeBytoDate(toDate);
	}

	/**
	* Returns the number of works scheduleses where toDate = &#63;.
	*
	* @param toDate the to date
	* @return the number of matching works scheduleses
	*/
	public static int countBytoDate(Date toDate) {
		return getPersistence().countBytoDate(toDate);
	}

	/**
	* Caches the works schedules in the entity cache if it is enabled.
	*
	* @param worksSchedules the works schedules
	*/
	public static void cacheResult(WorksSchedules worksSchedules) {
		getPersistence().cacheResult(worksSchedules);
	}

	/**
	* Caches the works scheduleses in the entity cache if it is enabled.
	*
	* @param worksScheduleses the works scheduleses
	*/
	public static void cacheResult(List<WorksSchedules> worksScheduleses) {
		getPersistence().cacheResult(worksScheduleses);
	}

	/**
	* Creates a new works schedules with the primary key. Does not add the works schedules to the database.
	*
	* @param worksSchedulesId the primary key for the new works schedules
	* @return the new works schedules
	*/
	public static WorksSchedules create(long worksSchedulesId) {
		return getPersistence().create(worksSchedulesId);
	}

	/**
	* Removes the works schedules with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param worksSchedulesId the primary key of the works schedules
	* @return the works schedules that was removed
	* @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	*/
	public static WorksSchedules remove(long worksSchedulesId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException {
		return getPersistence().remove(worksSchedulesId);
	}

	public static WorksSchedules updateImpl(WorksSchedules worksSchedules) {
		return getPersistence().updateImpl(worksSchedules);
	}

	/**
	* Returns the works schedules with the primary key or throws a {@link NoSuchWorksSchedulesException} if it could not be found.
	*
	* @param worksSchedulesId the primary key of the works schedules
	* @return the works schedules
	* @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	*/
	public static WorksSchedules findByPrimaryKey(long worksSchedulesId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException {
		return getPersistence().findByPrimaryKey(worksSchedulesId);
	}

	/**
	* Returns the works schedules with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param worksSchedulesId the primary key of the works schedules
	* @return the works schedules, or <code>null</code> if a works schedules with the primary key could not be found
	*/
	public static WorksSchedules fetchByPrimaryKey(long worksSchedulesId) {
		return getPersistence().fetchByPrimaryKey(worksSchedulesId);
	}

	public static java.util.Map<java.io.Serializable, WorksSchedules> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the works scheduleses.
	*
	* @return the works scheduleses
	*/
	public static List<WorksSchedules> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the works scheduleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @return the range of works scheduleses
	*/
	public static List<WorksSchedules> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the works scheduleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of works scheduleses
	*/
	public static List<WorksSchedules> findAll(int start, int end,
		OrderByComparator<WorksSchedules> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the works scheduleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of works scheduleses
	*/
	public static List<WorksSchedules> findAll(int start, int end,
		OrderByComparator<WorksSchedules> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the works scheduleses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of works scheduleses.
	*
	* @return the number of works scheduleses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorksSchedulesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WorksSchedulesPersistence, WorksSchedulesPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorksSchedulesPersistence.class);

		ServiceTracker<WorksSchedulesPersistence, WorksSchedulesPersistence> serviceTracker =
			new ServiceTracker<WorksSchedulesPersistence, WorksSchedulesPersistence>(bundle.getBundleContext(),
				WorksSchedulesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}