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

import com.liferay.famocom.erpcloud.model.HolidayCalenderManagement;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the holiday calender management service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.HolidayCalenderManagementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see HolidayCalenderManagementPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.HolidayCalenderManagementPersistenceImpl
 * @generated
 */
@ProviderType
public class HolidayCalenderManagementUtil {
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
	public static void clearCache(
		HolidayCalenderManagement holidayCalenderManagement) {
		getPersistence().clearCache(holidayCalenderManagement);
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
	public static List<HolidayCalenderManagement> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HolidayCalenderManagement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HolidayCalenderManagement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HolidayCalenderManagement update(
		HolidayCalenderManagement holidayCalenderManagement) {
		return getPersistence().update(holidayCalenderManagement);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HolidayCalenderManagement update(
		HolidayCalenderManagement holidayCalenderManagement,
		ServiceContext serviceContext) {
		return getPersistence().update(holidayCalenderManagement, serviceContext);
	}

	/**
	* Returns the holiday calender management where holidayDate = &#63; or throws a {@link NoSuchHolidayCalenderManagementException} if it could not be found.
	*
	* @param holidayDate the holiday date
	* @return the matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement findByempIdAndAttDate(
		Date holidayDate)
		throws com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return getPersistence().findByempIdAndAttDate(holidayDate);
	}

	/**
	* Returns the holiday calender management where holidayDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param holidayDate the holiday date
	* @return the matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement fetchByempIdAndAttDate(
		Date holidayDate) {
		return getPersistence().fetchByempIdAndAttDate(holidayDate);
	}

	/**
	* Returns the holiday calender management where holidayDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param holidayDate the holiday date
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement fetchByempIdAndAttDate(
		Date holidayDate, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByempIdAndAttDate(holidayDate, retrieveFromCache);
	}

	/**
	* Removes the holiday calender management where holidayDate = &#63; from the database.
	*
	* @param holidayDate the holiday date
	* @return the holiday calender management that was removed
	*/
	public static HolidayCalenderManagement removeByempIdAndAttDate(
		Date holidayDate)
		throws com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return getPersistence().removeByempIdAndAttDate(holidayDate);
	}

	/**
	* Returns the number of holiday calender managements where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @return the number of matching holiday calender managements
	*/
	public static int countByempIdAndAttDate(Date holidayDate) {
		return getPersistence().countByempIdAndAttDate(holidayDate);
	}

	/**
	* Returns all the holiday calender managements where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @return the matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findByholiDayCheck(
		Date holidayDate) {
		return getPersistence().findByholiDayCheck(holidayDate);
	}

	/**
	* Returns a range of all the holiday calender managements where holidayDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @return the range of matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findByholiDayCheck(
		Date holidayDate, int start, int end) {
		return getPersistence().findByholiDayCheck(holidayDate, start, end);
	}

	/**
	* Returns an ordered range of all the holiday calender managements where holidayDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findByholiDayCheck(
		Date holidayDate, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return getPersistence()
				   .findByholiDayCheck(holidayDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the holiday calender managements where holidayDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findByholiDayCheck(
		Date holidayDate, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByholiDayCheck(holidayDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first holiday calender management in the ordered set where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement findByholiDayCheck_First(
		Date holidayDate,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return getPersistence()
				   .findByholiDayCheck_First(holidayDate, orderByComparator);
	}

	/**
	* Returns the first holiday calender management in the ordered set where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement fetchByholiDayCheck_First(
		Date holidayDate,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return getPersistence()
				   .fetchByholiDayCheck_First(holidayDate, orderByComparator);
	}

	/**
	* Returns the last holiday calender management in the ordered set where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement findByholiDayCheck_Last(
		Date holidayDate,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return getPersistence()
				   .findByholiDayCheck_Last(holidayDate, orderByComparator);
	}

	/**
	* Returns the last holiday calender management in the ordered set where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement fetchByholiDayCheck_Last(
		Date holidayDate,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return getPersistence()
				   .fetchByholiDayCheck_Last(holidayDate, orderByComparator);
	}

	/**
	* Returns the holiday calender managements before and after the current holiday calender management in the ordered set where holidayDate = &#63;.
	*
	* @param holidayId the primary key of the current holiday calender management
	* @param holidayDate the holiday date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a holiday calender management with the primary key could not be found
	*/
	public static HolidayCalenderManagement[] findByholiDayCheck_PrevAndNext(
		long holidayId, Date holidayDate,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return getPersistence()
				   .findByholiDayCheck_PrevAndNext(holidayId, holidayDate,
			orderByComparator);
	}

	/**
	* Removes all the holiday calender managements where holidayDate = &#63; from the database.
	*
	* @param holidayDate the holiday date
	*/
	public static void removeByholiDayCheck(Date holidayDate) {
		getPersistence().removeByholiDayCheck(holidayDate);
	}

	/**
	* Returns the number of holiday calender managements where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @return the number of matching holiday calender managements
	*/
	public static int countByholiDayCheck(Date holidayDate) {
		return getPersistence().countByholiDayCheck(holidayDate);
	}

	/**
	* Returns all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @return the matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId) {
		return getPersistence().findBynameAndHoliDayId(holidayName, holidayId);
	}

	/**
	* Returns a range of all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @return the range of matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId, int start, int end) {
		return getPersistence()
				   .findBynameAndHoliDayId(holidayName, holidayId, start, end);
	}

	/**
	* Returns an ordered range of all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return getPersistence()
				   .findBynameAndHoliDayId(holidayName, holidayId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBynameAndHoliDayId(holidayName, holidayId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement findBynameAndHoliDayId_First(
		String holidayName, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return getPersistence()
				   .findBynameAndHoliDayId_First(holidayName, holidayId,
			orderByComparator);
	}

	/**
	* Returns the first holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement fetchBynameAndHoliDayId_First(
		String holidayName, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return getPersistence()
				   .fetchBynameAndHoliDayId_First(holidayName, holidayId,
			orderByComparator);
	}

	/**
	* Returns the last holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement findBynameAndHoliDayId_Last(
		String holidayName, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return getPersistence()
				   .findBynameAndHoliDayId_Last(holidayName, holidayId,
			orderByComparator);
	}

	/**
	* Returns the last holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement fetchBynameAndHoliDayId_Last(
		String holidayName, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return getPersistence()
				   .fetchBynameAndHoliDayId_Last(holidayName, holidayId,
			orderByComparator);
	}

	/**
	* Removes all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63; from the database.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	*/
	public static void removeBynameAndHoliDayId(String holidayName,
		long holidayId) {
		getPersistence().removeBynameAndHoliDayId(holidayName, holidayId);
	}

	/**
	* Returns the number of holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @return the number of matching holiday calender managements
	*/
	public static int countBynameAndHoliDayId(String holidayName, long holidayId) {
		return getPersistence().countBynameAndHoliDayId(holidayName, holidayId);
	}

	/**
	* Returns all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @return the matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId) {
		return getPersistence().findBydateAndHoliDayId(holidayDate, holidayId);
	}

	/**
	* Returns a range of all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @return the range of matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId, int start, int end) {
		return getPersistence()
				   .findBydateAndHoliDayId(holidayDate, holidayId, start, end);
	}

	/**
	* Returns an ordered range of all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return getPersistence()
				   .findBydateAndHoliDayId(holidayDate, holidayId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBydateAndHoliDayId(holidayDate, holidayId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement findBydateAndHoliDayId_First(
		Date holidayDate, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return getPersistence()
				   .findBydateAndHoliDayId_First(holidayDate, holidayId,
			orderByComparator);
	}

	/**
	* Returns the first holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement fetchBydateAndHoliDayId_First(
		Date holidayDate, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return getPersistence()
				   .fetchBydateAndHoliDayId_First(holidayDate, holidayId,
			orderByComparator);
	}

	/**
	* Returns the last holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement findBydateAndHoliDayId_Last(
		Date holidayDate, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return getPersistence()
				   .findBydateAndHoliDayId_Last(holidayDate, holidayId,
			orderByComparator);
	}

	/**
	* Returns the last holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public static HolidayCalenderManagement fetchBydateAndHoliDayId_Last(
		Date holidayDate, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return getPersistence()
				   .fetchBydateAndHoliDayId_Last(holidayDate, holidayId,
			orderByComparator);
	}

	/**
	* Removes all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63; from the database.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	*/
	public static void removeBydateAndHoliDayId(Date holidayDate, long holidayId) {
		getPersistence().removeBydateAndHoliDayId(holidayDate, holidayId);
	}

	/**
	* Returns the number of holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @return the number of matching holiday calender managements
	*/
	public static int countBydateAndHoliDayId(Date holidayDate, long holidayId) {
		return getPersistence().countBydateAndHoliDayId(holidayDate, holidayId);
	}

	/**
	* Caches the holiday calender management in the entity cache if it is enabled.
	*
	* @param holidayCalenderManagement the holiday calender management
	*/
	public static void cacheResult(
		HolidayCalenderManagement holidayCalenderManagement) {
		getPersistence().cacheResult(holidayCalenderManagement);
	}

	/**
	* Caches the holiday calender managements in the entity cache if it is enabled.
	*
	* @param holidayCalenderManagements the holiday calender managements
	*/
	public static void cacheResult(
		List<HolidayCalenderManagement> holidayCalenderManagements) {
		getPersistence().cacheResult(holidayCalenderManagements);
	}

	/**
	* Creates a new holiday calender management with the primary key. Does not add the holiday calender management to the database.
	*
	* @param holidayId the primary key for the new holiday calender management
	* @return the new holiday calender management
	*/
	public static HolidayCalenderManagement create(long holidayId) {
		return getPersistence().create(holidayId);
	}

	/**
	* Removes the holiday calender management with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param holidayId the primary key of the holiday calender management
	* @return the holiday calender management that was removed
	* @throws NoSuchHolidayCalenderManagementException if a holiday calender management with the primary key could not be found
	*/
	public static HolidayCalenderManagement remove(long holidayId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return getPersistence().remove(holidayId);
	}

	public static HolidayCalenderManagement updateImpl(
		HolidayCalenderManagement holidayCalenderManagement) {
		return getPersistence().updateImpl(holidayCalenderManagement);
	}

	/**
	* Returns the holiday calender management with the primary key or throws a {@link NoSuchHolidayCalenderManagementException} if it could not be found.
	*
	* @param holidayId the primary key of the holiday calender management
	* @return the holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a holiday calender management with the primary key could not be found
	*/
	public static HolidayCalenderManagement findByPrimaryKey(long holidayId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException {
		return getPersistence().findByPrimaryKey(holidayId);
	}

	/**
	* Returns the holiday calender management with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param holidayId the primary key of the holiday calender management
	* @return the holiday calender management, or <code>null</code> if a holiday calender management with the primary key could not be found
	*/
	public static HolidayCalenderManagement fetchByPrimaryKey(long holidayId) {
		return getPersistence().fetchByPrimaryKey(holidayId);
	}

	public static java.util.Map<java.io.Serializable, HolidayCalenderManagement> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the holiday calender managements.
	*
	* @return the holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the holiday calender managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @return the range of holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the holiday calender managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findAll(int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the holiday calender managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of holiday calender managements
	*/
	public static List<HolidayCalenderManagement> findAll(int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the holiday calender managements from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of holiday calender managements.
	*
	* @return the number of holiday calender managements
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HolidayCalenderManagementPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<HolidayCalenderManagementPersistence, HolidayCalenderManagementPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(HolidayCalenderManagementPersistence.class);

		ServiceTracker<HolidayCalenderManagementPersistence, HolidayCalenderManagementPersistence> serviceTracker =
			new ServiceTracker<HolidayCalenderManagementPersistence, HolidayCalenderManagementPersistence>(bundle.getBundleContext(),
				HolidayCalenderManagementPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}