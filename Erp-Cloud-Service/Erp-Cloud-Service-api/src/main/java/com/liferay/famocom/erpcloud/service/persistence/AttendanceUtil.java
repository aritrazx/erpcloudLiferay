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

import com.liferay.famocom.erpcloud.model.Attendance;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the attendance service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.AttendancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AttendancePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AttendancePersistenceImpl
 * @generated
 */
@ProviderType
public class AttendanceUtil {
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
	public static void clearCache(Attendance attendance) {
		getPersistence().clearCache(attendance);
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
	public static List<Attendance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Attendance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Attendance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Attendance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Attendance update(Attendance attendance) {
		return getPersistence().update(attendance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Attendance update(Attendance attendance,
		ServiceContext serviceContext) {
		return getPersistence().update(attendance, serviceContext);
	}

	/**
	* Returns the attendance where employeeId = &#63; and attDate = &#63; or throws a {@link NoSuchAttendanceException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the matching attendance
	* @throws NoSuchAttendanceException if a matching attendance could not be found
	*/
	public static Attendance findByempIdAndAttDate(long employeeId, Date attDate)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException {
		return getPersistence().findByempIdAndAttDate(employeeId, attDate);
	}

	/**
	* Returns the attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public static Attendance fetchByempIdAndAttDate(long employeeId,
		Date attDate) {
		return getPersistence().fetchByempIdAndAttDate(employeeId, attDate);
	}

	/**
	* Returns the attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public static Attendance fetchByempIdAndAttDate(long employeeId,
		Date attDate, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByempIdAndAttDate(employeeId, attDate,
			retrieveFromCache);
	}

	/**
	* Removes the attendance where employeeId = &#63; and attDate = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the attendance that was removed
	*/
	public static Attendance removeByempIdAndAttDate(long employeeId,
		Date attDate)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException {
		return getPersistence().removeByempIdAndAttDate(employeeId, attDate);
	}

	/**
	* Returns the number of attendances where employeeId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the number of matching attendances
	*/
	public static int countByempIdAndAttDate(long employeeId, Date attDate) {
		return getPersistence().countByempIdAndAttDate(employeeId, attDate);
	}

	/**
	* Returns all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @return the matching attendances
	*/
	public static List<Attendance> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate) {
		return getPersistence()
				   .findByempIdAndAttDateComId(employeeId, companyId, attDate);
	}

	/**
	* Returns a range of all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param start the lower bound of the range of attendances
	* @param end the upper bound of the range of attendances (not inclusive)
	* @return the range of matching attendances
	*/
	public static List<Attendance> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate, int start, int end) {
		return getPersistence()
				   .findByempIdAndAttDateComId(employeeId, companyId, attDate,
			start, end);
	}

	/**
	* Returns an ordered range of all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param start the lower bound of the range of attendances
	* @param end the upper bound of the range of attendances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attendances
	*/
	public static List<Attendance> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate, int start, int end,
		OrderByComparator<Attendance> orderByComparator) {
		return getPersistence()
				   .findByempIdAndAttDateComId(employeeId, companyId, attDate,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param start the lower bound of the range of attendances
	* @param end the upper bound of the range of attendances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching attendances
	*/
	public static List<Attendance> findByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate, int start, int end,
		OrderByComparator<Attendance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByempIdAndAttDateComId(employeeId, companyId, attDate,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendance
	* @throws NoSuchAttendanceException if a matching attendance could not be found
	*/
	public static Attendance findByempIdAndAttDateComId_First(long employeeId,
		long companyId, Date attDate,
		OrderByComparator<Attendance> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException {
		return getPersistence()
				   .findByempIdAndAttDateComId_First(employeeId, companyId,
			attDate, orderByComparator);
	}

	/**
	* Returns the first attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public static Attendance fetchByempIdAndAttDateComId_First(
		long employeeId, long companyId, Date attDate,
		OrderByComparator<Attendance> orderByComparator) {
		return getPersistence()
				   .fetchByempIdAndAttDateComId_First(employeeId, companyId,
			attDate, orderByComparator);
	}

	/**
	* Returns the last attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendance
	* @throws NoSuchAttendanceException if a matching attendance could not be found
	*/
	public static Attendance findByempIdAndAttDateComId_Last(long employeeId,
		long companyId, Date attDate,
		OrderByComparator<Attendance> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException {
		return getPersistence()
				   .findByempIdAndAttDateComId_Last(employeeId, companyId,
			attDate, orderByComparator);
	}

	/**
	* Returns the last attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public static Attendance fetchByempIdAndAttDateComId_Last(long employeeId,
		long companyId, Date attDate,
		OrderByComparator<Attendance> orderByComparator) {
		return getPersistence()
				   .fetchByempIdAndAttDateComId_Last(employeeId, companyId,
			attDate, orderByComparator);
	}

	/**
	* Returns the attendances before and after the current attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param attendanceId the primary key of the current attendance
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attendance
	* @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	*/
	public static Attendance[] findByempIdAndAttDateComId_PrevAndNext(
		long attendanceId, long employeeId, long companyId, Date attDate,
		OrderByComparator<Attendance> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException {
		return getPersistence()
				   .findByempIdAndAttDateComId_PrevAndNext(attendanceId,
			employeeId, companyId, attDate, orderByComparator);
	}

	/**
	* Removes all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	*/
	public static void removeByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate) {
		getPersistence()
			.removeByempIdAndAttDateComId(employeeId, companyId, attDate);
	}

	/**
	* Returns the number of attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @return the number of matching attendances
	*/
	public static int countByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate) {
		return getPersistence()
				   .countByempIdAndAttDateComId(employeeId, companyId, attDate);
	}

	/**
	* Returns all the attendances where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching attendances
	*/
	public static List<Attendance> findByempId(long employeeId) {
		return getPersistence().findByempId(employeeId);
	}

	/**
	* Returns a range of all the attendances where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of attendances
	* @param end the upper bound of the range of attendances (not inclusive)
	* @return the range of matching attendances
	*/
	public static List<Attendance> findByempId(long employeeId, int start,
		int end) {
		return getPersistence().findByempId(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the attendances where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of attendances
	* @param end the upper bound of the range of attendances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attendances
	*/
	public static List<Attendance> findByempId(long employeeId, int start,
		int end, OrderByComparator<Attendance> orderByComparator) {
		return getPersistence()
				   .findByempId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the attendances where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of attendances
	* @param end the upper bound of the range of attendances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching attendances
	*/
	public static List<Attendance> findByempId(long employeeId, int start,
		int end, OrderByComparator<Attendance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByempId(employeeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendance
	* @throws NoSuchAttendanceException if a matching attendance could not be found
	*/
	public static Attendance findByempId_First(long employeeId,
		OrderByComparator<Attendance> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException {
		return getPersistence().findByempId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public static Attendance fetchByempId_First(long employeeId,
		OrderByComparator<Attendance> orderByComparator) {
		return getPersistence().fetchByempId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendance
	* @throws NoSuchAttendanceException if a matching attendance could not be found
	*/
	public static Attendance findByempId_Last(long employeeId,
		OrderByComparator<Attendance> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException {
		return getPersistence().findByempId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public static Attendance fetchByempId_Last(long employeeId,
		OrderByComparator<Attendance> orderByComparator) {
		return getPersistence().fetchByempId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the attendances before and after the current attendance in the ordered set where employeeId = &#63;.
	*
	* @param attendanceId the primary key of the current attendance
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attendance
	* @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	*/
	public static Attendance[] findByempId_PrevAndNext(long attendanceId,
		long employeeId, OrderByComparator<Attendance> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException {
		return getPersistence()
				   .findByempId_PrevAndNext(attendanceId, employeeId,
			orderByComparator);
	}

	/**
	* Removes all the attendances where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeByempId(long employeeId) {
		getPersistence().removeByempId(employeeId);
	}

	/**
	* Returns the number of attendances where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching attendances
	*/
	public static int countByempId(long employeeId) {
		return getPersistence().countByempId(employeeId);
	}

	/**
	* Caches the attendance in the entity cache if it is enabled.
	*
	* @param attendance the attendance
	*/
	public static void cacheResult(Attendance attendance) {
		getPersistence().cacheResult(attendance);
	}

	/**
	* Caches the attendances in the entity cache if it is enabled.
	*
	* @param attendances the attendances
	*/
	public static void cacheResult(List<Attendance> attendances) {
		getPersistence().cacheResult(attendances);
	}

	/**
	* Creates a new attendance with the primary key. Does not add the attendance to the database.
	*
	* @param attendanceId the primary key for the new attendance
	* @return the new attendance
	*/
	public static Attendance create(long attendanceId) {
		return getPersistence().create(attendanceId);
	}

	/**
	* Removes the attendance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceId the primary key of the attendance
	* @return the attendance that was removed
	* @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	*/
	public static Attendance remove(long attendanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException {
		return getPersistence().remove(attendanceId);
	}

	public static Attendance updateImpl(Attendance attendance) {
		return getPersistence().updateImpl(attendance);
	}

	/**
	* Returns the attendance with the primary key or throws a {@link NoSuchAttendanceException} if it could not be found.
	*
	* @param attendanceId the primary key of the attendance
	* @return the attendance
	* @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	*/
	public static Attendance findByPrimaryKey(long attendanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException {
		return getPersistence().findByPrimaryKey(attendanceId);
	}

	/**
	* Returns the attendance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attendanceId the primary key of the attendance
	* @return the attendance, or <code>null</code> if a attendance with the primary key could not be found
	*/
	public static Attendance fetchByPrimaryKey(long attendanceId) {
		return getPersistence().fetchByPrimaryKey(attendanceId);
	}

	public static java.util.Map<java.io.Serializable, Attendance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the attendances.
	*
	* @return the attendances
	*/
	public static List<Attendance> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the attendances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendances
	* @param end the upper bound of the range of attendances (not inclusive)
	* @return the range of attendances
	*/
	public static List<Attendance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the attendances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendances
	* @param end the upper bound of the range of attendances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of attendances
	*/
	public static List<Attendance> findAll(int start, int end,
		OrderByComparator<Attendance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the attendances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendances
	* @param end the upper bound of the range of attendances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of attendances
	*/
	public static List<Attendance> findAll(int start, int end,
		OrderByComparator<Attendance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the attendances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of attendances.
	*
	* @return the number of attendances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AttendancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AttendancePersistence, AttendancePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AttendancePersistence.class);

		ServiceTracker<AttendancePersistence, AttendancePersistence> serviceTracker =
			new ServiceTracker<AttendancePersistence, AttendancePersistence>(bundle.getBundleContext(),
				AttendancePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}