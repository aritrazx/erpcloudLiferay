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

import com.liferay.famocom.erpcloud.model.MonthlyAdjustment;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the monthly adjustment service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.MonthlyAdjustmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see MonthlyAdjustmentPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.MonthlyAdjustmentPersistenceImpl
 * @generated
 */
@ProviderType
public class MonthlyAdjustmentUtil {
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
	public static void clearCache(MonthlyAdjustment monthlyAdjustment) {
		getPersistence().clearCache(monthlyAdjustment);
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
	public static List<MonthlyAdjustment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MonthlyAdjustment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MonthlyAdjustment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MonthlyAdjustment update(MonthlyAdjustment monthlyAdjustment) {
		return getPersistence().update(monthlyAdjustment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MonthlyAdjustment update(
		MonthlyAdjustment monthlyAdjustment, ServiceContext serviceContext) {
		return getPersistence().update(monthlyAdjustment, serviceContext);
	}

	/**
	* Returns all the monthly adjustments where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findByemployeeId(long employeeId) {
		return getPersistence().findByemployeeId(employeeId);
	}

	/**
	* Returns a range of all the monthly adjustments where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @return the range of matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findByemployeeId(long employeeId,
		int start, int end) {
		return getPersistence().findByemployeeId(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the monthly adjustments where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findByemployeeId(long employeeId,
		int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the monthly adjustments where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findByemployeeId(long employeeId,
		int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first monthly adjustment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment findByemployeeId_First(long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence()
				   .findByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first monthly adjustment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment fetchByemployeeId_First(long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last monthly adjustment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment findByemployeeId_Last(long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence()
				   .findByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last monthly adjustment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment fetchByemployeeId_Last(long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the monthly adjustments before and after the current monthly adjustment in the ordered set where employeeId = &#63;.
	*
	* @param monthlyAdjustmentId the primary key of the current monthly adjustment
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	*/
	public static MonthlyAdjustment[] findByemployeeId_PrevAndNext(
		long monthlyAdjustmentId, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence()
				   .findByemployeeId_PrevAndNext(monthlyAdjustmentId,
			employeeId, orderByComparator);
	}

	/**
	* Removes all the monthly adjustments where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeByemployeeId(long employeeId) {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	* Returns the number of monthly adjustments where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching monthly adjustments
	*/
	public static int countByemployeeId(long employeeId) {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	* Returns all the monthly adjustments where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findBymonthYear(long monthYear) {
		return getPersistence().findBymonthYear(monthYear);
	}

	/**
	* Returns a range of all the monthly adjustments where monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @return the range of matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findBymonthYear(long monthYear,
		int start, int end) {
		return getPersistence().findBymonthYear(monthYear, start, end);
	}

	/**
	* Returns an ordered range of all the monthly adjustments where monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findBymonthYear(long monthYear,
		int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return getPersistence()
				   .findBymonthYear(monthYear, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the monthly adjustments where monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findBymonthYear(long monthYear,
		int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBymonthYear(monthYear, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first monthly adjustment in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment findBymonthYear_First(long monthYear,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence()
				   .findBymonthYear_First(monthYear, orderByComparator);
	}

	/**
	* Returns the first monthly adjustment in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment fetchBymonthYear_First(long monthYear,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return getPersistence()
				   .fetchBymonthYear_First(monthYear, orderByComparator);
	}

	/**
	* Returns the last monthly adjustment in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment findBymonthYear_Last(long monthYear,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence()
				   .findBymonthYear_Last(monthYear, orderByComparator);
	}

	/**
	* Returns the last monthly adjustment in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment fetchBymonthYear_Last(long monthYear,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return getPersistence()
				   .fetchBymonthYear_Last(monthYear, orderByComparator);
	}

	/**
	* Returns the monthly adjustments before and after the current monthly adjustment in the ordered set where monthYear = &#63;.
	*
	* @param monthlyAdjustmentId the primary key of the current monthly adjustment
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	*/
	public static MonthlyAdjustment[] findBymonthYear_PrevAndNext(
		long monthlyAdjustmentId, long monthYear,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence()
				   .findBymonthYear_PrevAndNext(monthlyAdjustmentId, monthYear,
			orderByComparator);
	}

	/**
	* Removes all the monthly adjustments where monthYear = &#63; from the database.
	*
	* @param monthYear the month year
	*/
	public static void removeBymonthYear(long monthYear) {
		getPersistence().removeBymonthYear(monthYear);
	}

	/**
	* Returns the number of monthly adjustments where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the number of matching monthly adjustments
	*/
	public static int countBymonthYear(long monthYear) {
		return getPersistence().countBymonthYear(monthYear);
	}

	/**
	* Returns all the monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId) {
		return getPersistence()
				   .findBymonthYearAndemployeeId(monthYear, employeeId);
	}

	/**
	* Returns a range of all the monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @return the range of matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end) {
		return getPersistence()
				   .findBymonthYearAndemployeeId(monthYear, employeeId, start,
			end);
	}

	/**
	* Returns an ordered range of all the monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return getPersistence()
				   .findBymonthYearAndemployeeId(monthYear, employeeId, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching monthly adjustments
	*/
	public static List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBymonthYearAndemployeeId(monthYear, employeeId, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment findBymonthYearAndemployeeId_First(
		long monthYear, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence()
				   .findBymonthYearAndemployeeId_First(monthYear, employeeId,
			orderByComparator);
	}

	/**
	* Returns the first monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment fetchBymonthYearAndemployeeId_First(
		long monthYear, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return getPersistence()
				   .fetchBymonthYearAndemployeeId_First(monthYear, employeeId,
			orderByComparator);
	}

	/**
	* Returns the last monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment findBymonthYearAndemployeeId_Last(
		long monthYear, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence()
				   .findBymonthYearAndemployeeId_Last(monthYear, employeeId,
			orderByComparator);
	}

	/**
	* Returns the last monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment fetchBymonthYearAndemployeeId_Last(
		long monthYear, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return getPersistence()
				   .fetchBymonthYearAndemployeeId_Last(monthYear, employeeId,
			orderByComparator);
	}

	/**
	* Returns the monthly adjustments before and after the current monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthlyAdjustmentId the primary key of the current monthly adjustment
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	*/
	public static MonthlyAdjustment[] findBymonthYearAndemployeeId_PrevAndNext(
		long monthlyAdjustmentId, long monthYear, long employeeId,
		OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence()
				   .findBymonthYearAndemployeeId_PrevAndNext(monthlyAdjustmentId,
			monthYear, employeeId, orderByComparator);
	}

	/**
	* Removes all the monthly adjustments where monthYear = &#63; and employeeId = &#63; from the database.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	*/
	public static void removeBymonthYearAndemployeeId(long monthYear,
		long employeeId) {
		getPersistence().removeBymonthYearAndemployeeId(monthYear, employeeId);
	}

	/**
	* Returns the number of monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the number of matching monthly adjustments
	*/
	public static int countBymonthYearAndemployeeId(long monthYear,
		long employeeId) {
		return getPersistence()
				   .countBymonthYearAndemployeeId(monthYear, employeeId);
	}

	/**
	* Returns the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; or throws a {@link NoSuchMonthlyAdjustmentException} if it could not be found.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment findBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence()
				   .findBymonthYearAndemployeeIdAndpayComponentId(monthYear,
			employeeId, payComponentId);
	}

	/**
	* Returns the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment fetchBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId) {
		return getPersistence()
				   .fetchBymonthYearAndemployeeIdAndpayComponentId(monthYear,
			employeeId, payComponentId);
	}

	/**
	* Returns the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public static MonthlyAdjustment fetchBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBymonthYearAndemployeeIdAndpayComponentId(monthYear,
			employeeId, payComponentId, retrieveFromCache);
	}

	/**
	* Removes the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; from the database.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the monthly adjustment that was removed
	*/
	public static MonthlyAdjustment removeBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence()
				   .removeBymonthYearAndemployeeIdAndpayComponentId(monthYear,
			employeeId, payComponentId);
	}

	/**
	* Returns the number of monthly adjustments where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the number of matching monthly adjustments
	*/
	public static int countBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId) {
		return getPersistence()
				   .countBymonthYearAndemployeeIdAndpayComponentId(monthYear,
			employeeId, payComponentId);
	}

	/**
	* Caches the monthly adjustment in the entity cache if it is enabled.
	*
	* @param monthlyAdjustment the monthly adjustment
	*/
	public static void cacheResult(MonthlyAdjustment monthlyAdjustment) {
		getPersistence().cacheResult(monthlyAdjustment);
	}

	/**
	* Caches the monthly adjustments in the entity cache if it is enabled.
	*
	* @param monthlyAdjustments the monthly adjustments
	*/
	public static void cacheResult(List<MonthlyAdjustment> monthlyAdjustments) {
		getPersistence().cacheResult(monthlyAdjustments);
	}

	/**
	* Creates a new monthly adjustment with the primary key. Does not add the monthly adjustment to the database.
	*
	* @param monthlyAdjustmentId the primary key for the new monthly adjustment
	* @return the new monthly adjustment
	*/
	public static MonthlyAdjustment create(long monthlyAdjustmentId) {
		return getPersistence().create(monthlyAdjustmentId);
	}

	/**
	* Removes the monthly adjustment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param monthlyAdjustmentId the primary key of the monthly adjustment
	* @return the monthly adjustment that was removed
	* @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	*/
	public static MonthlyAdjustment remove(long monthlyAdjustmentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence().remove(monthlyAdjustmentId);
	}

	public static MonthlyAdjustment updateImpl(
		MonthlyAdjustment monthlyAdjustment) {
		return getPersistence().updateImpl(monthlyAdjustment);
	}

	/**
	* Returns the monthly adjustment with the primary key or throws a {@link NoSuchMonthlyAdjustmentException} if it could not be found.
	*
	* @param monthlyAdjustmentId the primary key of the monthly adjustment
	* @return the monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	*/
	public static MonthlyAdjustment findByPrimaryKey(long monthlyAdjustmentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException {
		return getPersistence().findByPrimaryKey(monthlyAdjustmentId);
	}

	/**
	* Returns the monthly adjustment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param monthlyAdjustmentId the primary key of the monthly adjustment
	* @return the monthly adjustment, or <code>null</code> if a monthly adjustment with the primary key could not be found
	*/
	public static MonthlyAdjustment fetchByPrimaryKey(long monthlyAdjustmentId) {
		return getPersistence().fetchByPrimaryKey(monthlyAdjustmentId);
	}

	public static java.util.Map<java.io.Serializable, MonthlyAdjustment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the monthly adjustments.
	*
	* @return the monthly adjustments
	*/
	public static List<MonthlyAdjustment> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the monthly adjustments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @return the range of monthly adjustments
	*/
	public static List<MonthlyAdjustment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the monthly adjustments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of monthly adjustments
	*/
	public static List<MonthlyAdjustment> findAll(int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the monthly adjustments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyAdjustmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of monthly adjustments
	* @param end the upper bound of the range of monthly adjustments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of monthly adjustments
	*/
	public static List<MonthlyAdjustment> findAll(int start, int end,
		OrderByComparator<MonthlyAdjustment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the monthly adjustments from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of monthly adjustments.
	*
	* @return the number of monthly adjustments
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MonthlyAdjustmentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MonthlyAdjustmentPersistence, MonthlyAdjustmentPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MonthlyAdjustmentPersistence.class);

		ServiceTracker<MonthlyAdjustmentPersistence, MonthlyAdjustmentPersistence> serviceTracker =
			new ServiceTracker<MonthlyAdjustmentPersistence, MonthlyAdjustmentPersistence>(bundle.getBundleContext(),
				MonthlyAdjustmentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}