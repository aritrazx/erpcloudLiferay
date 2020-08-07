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

import com.liferay.famocom.erpcloud.exception.NoSuchAttendanceException;
import com.liferay.famocom.erpcloud.model.Attendance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the attendance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AttendancePersistenceImpl
 * @see AttendanceUtil
 * @generated
 */
@ProviderType
public interface AttendancePersistence extends BasePersistence<Attendance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttendanceUtil} to access the attendance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the attendance where employeeId = &#63; and attDate = &#63; or throws a {@link NoSuchAttendanceException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the matching attendance
	* @throws NoSuchAttendanceException if a matching attendance could not be found
	*/
	public Attendance findByempIdAndAttDate(long employeeId, Date attDate)
		throws NoSuchAttendanceException;

	/**
	* Returns the attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public Attendance fetchByempIdAndAttDate(long employeeId, Date attDate);

	/**
	* Returns the attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public Attendance fetchByempIdAndAttDate(long employeeId, Date attDate,
		boolean retrieveFromCache);

	/**
	* Removes the attendance where employeeId = &#63; and attDate = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the attendance that was removed
	*/
	public Attendance removeByempIdAndAttDate(long employeeId, Date attDate)
		throws NoSuchAttendanceException;

	/**
	* Returns the number of attendances where employeeId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the number of matching attendances
	*/
	public int countByempIdAndAttDate(long employeeId, Date attDate);

	/**
	* Returns all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @return the matching attendances
	*/
	public java.util.List<Attendance> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate);

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
	public java.util.List<Attendance> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate, int start, int end);

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
	public java.util.List<Attendance> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator);

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
	public java.util.List<Attendance> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator,
		boolean retrieveFromCache);

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
	public Attendance findByempIdAndAttDateComId_First(long employeeId,
		long companyId, Date attDate,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException;

	/**
	* Returns the first attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public Attendance fetchByempIdAndAttDateComId_First(long employeeId,
		long companyId, Date attDate,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator);

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
	public Attendance findByempIdAndAttDateComId_Last(long employeeId,
		long companyId, Date attDate,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException;

	/**
	* Returns the last attendance in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public Attendance fetchByempIdAndAttDateComId_Last(long employeeId,
		long companyId, Date attDate,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator);

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
	public Attendance[] findByempIdAndAttDateComId_PrevAndNext(
		long attendanceId, long employeeId, long companyId, Date attDate,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException;

	/**
	* Removes all the attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	*/
	public void removeByempIdAndAttDateComId(long employeeId, long companyId,
		Date attDate);

	/**
	* Returns the number of attendances where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @return the number of matching attendances
	*/
	public int countByempIdAndAttDateComId(long employeeId, long companyId,
		Date attDate);

	/**
	* Returns all the attendances where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching attendances
	*/
	public java.util.List<Attendance> findByempId(long employeeId);

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
	public java.util.List<Attendance> findByempId(long employeeId, int start,
		int end);

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
	public java.util.List<Attendance> findByempId(long employeeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator);

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
	public java.util.List<Attendance> findByempId(long employeeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendance
	* @throws NoSuchAttendanceException if a matching attendance could not be found
	*/
	public Attendance findByempId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException;

	/**
	* Returns the first attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public Attendance fetchByempId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator);

	/**
	* Returns the last attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendance
	* @throws NoSuchAttendanceException if a matching attendance could not be found
	*/
	public Attendance findByempId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException;

	/**
	* Returns the last attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendance, or <code>null</code> if a matching attendance could not be found
	*/
	public Attendance fetchByempId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator);

	/**
	* Returns the attendances before and after the current attendance in the ordered set where employeeId = &#63;.
	*
	* @param attendanceId the primary key of the current attendance
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attendance
	* @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	*/
	public Attendance[] findByempId_PrevAndNext(long attendanceId,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator)
		throws NoSuchAttendanceException;

	/**
	* Removes all the attendances where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeByempId(long employeeId);

	/**
	* Returns the number of attendances where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching attendances
	*/
	public int countByempId(long employeeId);

	/**
	* Caches the attendance in the entity cache if it is enabled.
	*
	* @param attendance the attendance
	*/
	public void cacheResult(Attendance attendance);

	/**
	* Caches the attendances in the entity cache if it is enabled.
	*
	* @param attendances the attendances
	*/
	public void cacheResult(java.util.List<Attendance> attendances);

	/**
	* Creates a new attendance with the primary key. Does not add the attendance to the database.
	*
	* @param attendanceId the primary key for the new attendance
	* @return the new attendance
	*/
	public Attendance create(long attendanceId);

	/**
	* Removes the attendance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceId the primary key of the attendance
	* @return the attendance that was removed
	* @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	*/
	public Attendance remove(long attendanceId)
		throws NoSuchAttendanceException;

	public Attendance updateImpl(Attendance attendance);

	/**
	* Returns the attendance with the primary key or throws a {@link NoSuchAttendanceException} if it could not be found.
	*
	* @param attendanceId the primary key of the attendance
	* @return the attendance
	* @throws NoSuchAttendanceException if a attendance with the primary key could not be found
	*/
	public Attendance findByPrimaryKey(long attendanceId)
		throws NoSuchAttendanceException;

	/**
	* Returns the attendance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attendanceId the primary key of the attendance
	* @return the attendance, or <code>null</code> if a attendance with the primary key could not be found
	*/
	public Attendance fetchByPrimaryKey(long attendanceId);

	@Override
	public java.util.Map<java.io.Serializable, Attendance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the attendances.
	*
	* @return the attendances
	*/
	public java.util.List<Attendance> findAll();

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
	public java.util.List<Attendance> findAll(int start, int end);

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
	public java.util.List<Attendance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator);

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
	public java.util.List<Attendance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attendance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the attendances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of attendances.
	*
	* @return the number of attendances
	*/
	public int countAll();
}