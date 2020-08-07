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

import com.liferay.famocom.erpcloud.model.StopPay;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the stop pay service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.StopPayPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see StopPayPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.StopPayPersistenceImpl
 * @generated
 */
@ProviderType
public class StopPayUtil {
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
	public static void clearCache(StopPay stopPay) {
		getPersistence().clearCache(stopPay);
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
	public static List<StopPay> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StopPay> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StopPay> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StopPay> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StopPay update(StopPay stopPay) {
		return getPersistence().update(stopPay);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StopPay update(StopPay stopPay, ServiceContext serviceContext) {
		return getPersistence().update(stopPay, serviceContext);
	}

	/**
	* Returns all the stop paies where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching stop paies
	*/
	public static List<StopPay> findByemployeeId(long employeeId) {
		return getPersistence().findByemployeeId(employeeId);
	}

	/**
	* Returns a range of all the stop paies where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @return the range of matching stop paies
	*/
	public static List<StopPay> findByemployeeId(long employeeId, int start,
		int end) {
		return getPersistence().findByemployeeId(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the stop paies where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stop paies
	*/
	public static List<StopPay> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<StopPay> orderByComparator) {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the stop paies where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching stop paies
	*/
	public static List<StopPay> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<StopPay> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first stop pay in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public static StopPay findByemployeeId_First(long employeeId,
		OrderByComparator<StopPay> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence()
				   .findByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first stop pay in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public static StopPay fetchByemployeeId_First(long employeeId,
		OrderByComparator<StopPay> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last stop pay in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public static StopPay findByemployeeId_Last(long employeeId,
		OrderByComparator<StopPay> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence()
				   .findByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last stop pay in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public static StopPay fetchByemployeeId_Last(long employeeId,
		OrderByComparator<StopPay> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the stop paies before and after the current stop pay in the ordered set where employeeId = &#63;.
	*
	* @param stopPayId the primary key of the current stop pay
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stop pay
	* @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	*/
	public static StopPay[] findByemployeeId_PrevAndNext(long stopPayId,
		long employeeId, OrderByComparator<StopPay> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence()
				   .findByemployeeId_PrevAndNext(stopPayId, employeeId,
			orderByComparator);
	}

	/**
	* Removes all the stop paies where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeByemployeeId(long employeeId) {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	* Returns the number of stop paies where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching stop paies
	*/
	public static int countByemployeeId(long employeeId) {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	* Returns all the stop paies where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @return the matching stop paies
	*/
	public static List<StopPay> findByMonthYearAndStatus(long monthYear,
		long status) {
		return getPersistence().findByMonthYearAndStatus(monthYear, status);
	}

	/**
	* Returns a range of all the stop paies where monthYear = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param status the status
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @return the range of matching stop paies
	*/
	public static List<StopPay> findByMonthYearAndStatus(long monthYear,
		long status, int start, int end) {
		return getPersistence()
				   .findByMonthYearAndStatus(monthYear, status, start, end);
	}

	/**
	* Returns an ordered range of all the stop paies where monthYear = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param status the status
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stop paies
	*/
	public static List<StopPay> findByMonthYearAndStatus(long monthYear,
		long status, int start, int end,
		OrderByComparator<StopPay> orderByComparator) {
		return getPersistence()
				   .findByMonthYearAndStatus(monthYear, status, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the stop paies where monthYear = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param status the status
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching stop paies
	*/
	public static List<StopPay> findByMonthYearAndStatus(long monthYear,
		long status, int start, int end,
		OrderByComparator<StopPay> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByMonthYearAndStatus(monthYear, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public static StopPay findByMonthYearAndStatus_First(long monthYear,
		long status, OrderByComparator<StopPay> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence()
				   .findByMonthYearAndStatus_First(monthYear, status,
			orderByComparator);
	}

	/**
	* Returns the first stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public static StopPay fetchByMonthYearAndStatus_First(long monthYear,
		long status, OrderByComparator<StopPay> orderByComparator) {
		return getPersistence()
				   .fetchByMonthYearAndStatus_First(monthYear, status,
			orderByComparator);
	}

	/**
	* Returns the last stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public static StopPay findByMonthYearAndStatus_Last(long monthYear,
		long status, OrderByComparator<StopPay> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence()
				   .findByMonthYearAndStatus_Last(monthYear, status,
			orderByComparator);
	}

	/**
	* Returns the last stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public static StopPay fetchByMonthYearAndStatus_Last(long monthYear,
		long status, OrderByComparator<StopPay> orderByComparator) {
		return getPersistence()
				   .fetchByMonthYearAndStatus_Last(monthYear, status,
			orderByComparator);
	}

	/**
	* Returns the stop paies before and after the current stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	*
	* @param stopPayId the primary key of the current stop pay
	* @param monthYear the month year
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stop pay
	* @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	*/
	public static StopPay[] findByMonthYearAndStatus_PrevAndNext(
		long stopPayId, long monthYear, long status,
		OrderByComparator<StopPay> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence()
				   .findByMonthYearAndStatus_PrevAndNext(stopPayId, monthYear,
			status, orderByComparator);
	}

	/**
	* Removes all the stop paies where monthYear = &#63; and status = &#63; from the database.
	*
	* @param monthYear the month year
	* @param status the status
	*/
	public static void removeByMonthYearAndStatus(long monthYear, long status) {
		getPersistence().removeByMonthYearAndStatus(monthYear, status);
	}

	/**
	* Returns the number of stop paies where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @return the number of matching stop paies
	*/
	public static int countByMonthYearAndStatus(long monthYear, long status) {
		return getPersistence().countByMonthYearAndStatus(monthYear, status);
	}

	/**
	* Returns all the stop paies where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the matching stop paies
	*/
	public static List<StopPay> findBymonthYear(long monthYear) {
		return getPersistence().findBymonthYear(monthYear);
	}

	/**
	* Returns a range of all the stop paies where monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @return the range of matching stop paies
	*/
	public static List<StopPay> findBymonthYear(long monthYear, int start,
		int end) {
		return getPersistence().findBymonthYear(monthYear, start, end);
	}

	/**
	* Returns an ordered range of all the stop paies where monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stop paies
	*/
	public static List<StopPay> findBymonthYear(long monthYear, int start,
		int end, OrderByComparator<StopPay> orderByComparator) {
		return getPersistence()
				   .findBymonthYear(monthYear, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the stop paies where monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching stop paies
	*/
	public static List<StopPay> findBymonthYear(long monthYear, int start,
		int end, OrderByComparator<StopPay> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBymonthYear(monthYear, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first stop pay in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public static StopPay findBymonthYear_First(long monthYear,
		OrderByComparator<StopPay> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence()
				   .findBymonthYear_First(monthYear, orderByComparator);
	}

	/**
	* Returns the first stop pay in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public static StopPay fetchBymonthYear_First(long monthYear,
		OrderByComparator<StopPay> orderByComparator) {
		return getPersistence()
				   .fetchBymonthYear_First(monthYear, orderByComparator);
	}

	/**
	* Returns the last stop pay in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public static StopPay findBymonthYear_Last(long monthYear,
		OrderByComparator<StopPay> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence()
				   .findBymonthYear_Last(monthYear, orderByComparator);
	}

	/**
	* Returns the last stop pay in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public static StopPay fetchBymonthYear_Last(long monthYear,
		OrderByComparator<StopPay> orderByComparator) {
		return getPersistence()
				   .fetchBymonthYear_Last(monthYear, orderByComparator);
	}

	/**
	* Returns the stop paies before and after the current stop pay in the ordered set where monthYear = &#63;.
	*
	* @param stopPayId the primary key of the current stop pay
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stop pay
	* @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	*/
	public static StopPay[] findBymonthYear_PrevAndNext(long stopPayId,
		long monthYear, OrderByComparator<StopPay> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence()
				   .findBymonthYear_PrevAndNext(stopPayId, monthYear,
			orderByComparator);
	}

	/**
	* Removes all the stop paies where monthYear = &#63; from the database.
	*
	* @param monthYear the month year
	*/
	public static void removeBymonthYear(long monthYear) {
		getPersistence().removeBymonthYear(monthYear);
	}

	/**
	* Returns the number of stop paies where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the number of matching stop paies
	*/
	public static int countBymonthYear(long monthYear) {
		return getPersistence().countBymonthYear(monthYear);
	}

	/**
	* Returns the stop pay where employeeId = &#63; and monthYear = &#63; or throws a {@link NoSuchStopPayException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public static StopPay findByemployeeIdAndMonthYear(long employeeId,
		long monthYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYear);
	}

	/**
	* Returns the stop pay where employeeId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public static StopPay fetchByemployeeIdAndMonthYear(long employeeId,
		long monthYear) {
		return getPersistence()
				   .fetchByemployeeIdAndMonthYear(employeeId, monthYear);
	}

	/**
	* Returns the stop pay where employeeId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public static StopPay fetchByemployeeIdAndMonthYear(long employeeId,
		long monthYear, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByemployeeIdAndMonthYear(employeeId, monthYear,
			retrieveFromCache);
	}

	/**
	* Removes the stop pay where employeeId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the stop pay that was removed
	*/
	public static StopPay removeByemployeeIdAndMonthYear(long employeeId,
		long monthYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence()
				   .removeByemployeeIdAndMonthYear(employeeId, monthYear);
	}

	/**
	* Returns the number of stop paies where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the number of matching stop paies
	*/
	public static int countByemployeeIdAndMonthYear(long employeeId,
		long monthYear) {
		return getPersistence()
				   .countByemployeeIdAndMonthYear(employeeId, monthYear);
	}

	/**
	* Caches the stop pay in the entity cache if it is enabled.
	*
	* @param stopPay the stop pay
	*/
	public static void cacheResult(StopPay stopPay) {
		getPersistence().cacheResult(stopPay);
	}

	/**
	* Caches the stop paies in the entity cache if it is enabled.
	*
	* @param stopPaies the stop paies
	*/
	public static void cacheResult(List<StopPay> stopPaies) {
		getPersistence().cacheResult(stopPaies);
	}

	/**
	* Creates a new stop pay with the primary key. Does not add the stop pay to the database.
	*
	* @param stopPayId the primary key for the new stop pay
	* @return the new stop pay
	*/
	public static StopPay create(long stopPayId) {
		return getPersistence().create(stopPayId);
	}

	/**
	* Removes the stop pay with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stopPayId the primary key of the stop pay
	* @return the stop pay that was removed
	* @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	*/
	public static StopPay remove(long stopPayId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence().remove(stopPayId);
	}

	public static StopPay updateImpl(StopPay stopPay) {
		return getPersistence().updateImpl(stopPay);
	}

	/**
	* Returns the stop pay with the primary key or throws a {@link NoSuchStopPayException} if it could not be found.
	*
	* @param stopPayId the primary key of the stop pay
	* @return the stop pay
	* @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	*/
	public static StopPay findByPrimaryKey(long stopPayId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return getPersistence().findByPrimaryKey(stopPayId);
	}

	/**
	* Returns the stop pay with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stopPayId the primary key of the stop pay
	* @return the stop pay, or <code>null</code> if a stop pay with the primary key could not be found
	*/
	public static StopPay fetchByPrimaryKey(long stopPayId) {
		return getPersistence().fetchByPrimaryKey(stopPayId);
	}

	public static java.util.Map<java.io.Serializable, StopPay> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the stop paies.
	*
	* @return the stop paies
	*/
	public static List<StopPay> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the stop paies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @return the range of stop paies
	*/
	public static List<StopPay> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the stop paies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stop paies
	*/
	public static List<StopPay> findAll(int start, int end,
		OrderByComparator<StopPay> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the stop paies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of stop paies
	*/
	public static List<StopPay> findAll(int start, int end,
		OrderByComparator<StopPay> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the stop paies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of stop paies.
	*
	* @return the number of stop paies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StopPayPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StopPayPersistence, StopPayPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StopPayPersistence.class);

		ServiceTracker<StopPayPersistence, StopPayPersistence> serviceTracker = new ServiceTracker<StopPayPersistence, StopPayPersistence>(bundle.getBundleContext(),
				StopPayPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}