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

import com.liferay.famocom.erpcloud.exception.NoSuchAttendanceBioException;
import com.liferay.famocom.erpcloud.model.AttendanceBio;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the attendance bio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AttendanceBioPersistenceImpl
 * @see AttendanceBioUtil
 * @generated
 */
@ProviderType
public interface AttendanceBioPersistence extends BasePersistence<AttendanceBio> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttendanceBioUtil} to access the attendance bio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @return the matching attendance bios
	*/
	public java.util.List<AttendanceBio> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate);

	/**
	* Returns a range of all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param start the lower bound of the range of attendance bios
	* @param end the upper bound of the range of attendance bios (not inclusive)
	* @return the range of matching attendance bios
	*/
	public java.util.List<AttendanceBio> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate, int start, int end);

	/**
	* Returns an ordered range of all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param start the lower bound of the range of attendance bios
	* @param end the upper bound of the range of attendance bios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attendance bios
	*/
	public java.util.List<AttendanceBio> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttendanceBio> orderByComparator);

	/**
	* Returns an ordered range of all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param start the lower bound of the range of attendance bios
	* @param end the upper bound of the range of attendance bios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching attendance bios
	*/
	public java.util.List<AttendanceBio> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttendanceBio> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendance bio
	* @throws NoSuchAttendanceBioException if a matching attendance bio could not be found
	*/
	public AttendanceBio findByempIdAndAttDateComId_First(long employeeId,
		long companyId, Date attDate,
		com.liferay.portal.kernel.util.OrderByComparator<AttendanceBio> orderByComparator)
		throws NoSuchAttendanceBioException;

	/**
	* Returns the first attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendance bio, or <code>null</code> if a matching attendance bio could not be found
	*/
	public AttendanceBio fetchByempIdAndAttDateComId_First(long employeeId,
		long companyId, Date attDate,
		com.liferay.portal.kernel.util.OrderByComparator<AttendanceBio> orderByComparator);

	/**
	* Returns the last attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendance bio
	* @throws NoSuchAttendanceBioException if a matching attendance bio could not be found
	*/
	public AttendanceBio findByempIdAndAttDateComId_Last(long employeeId,
		long companyId, Date attDate,
		com.liferay.portal.kernel.util.OrderByComparator<AttendanceBio> orderByComparator)
		throws NoSuchAttendanceBioException;

	/**
	* Returns the last attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendance bio, or <code>null</code> if a matching attendance bio could not be found
	*/
	public AttendanceBio fetchByempIdAndAttDateComId_Last(long employeeId,
		long companyId, Date attDate,
		com.liferay.portal.kernel.util.OrderByComparator<AttendanceBio> orderByComparator);

	/**
	* Returns the attendance bios before and after the current attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param attendanceBioId the primary key of the current attendance bio
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attendance bio
	* @throws NoSuchAttendanceBioException if a attendance bio with the primary key could not be found
	*/
	public AttendanceBio[] findByempIdAndAttDateComId_PrevAndNext(
		long attendanceBioId, long employeeId, long companyId, Date attDate,
		com.liferay.portal.kernel.util.OrderByComparator<AttendanceBio> orderByComparator)
		throws NoSuchAttendanceBioException;

	/**
	* Removes all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	*/
	public void removeByempIdAndAttDateComId(long employeeId, long companyId,
		Date attDate);

	/**
	* Returns the number of attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @return the number of matching attendance bios
	*/
	public int countByempIdAndAttDateComId(long employeeId, long companyId,
		Date attDate);

	/**
	* Caches the attendance bio in the entity cache if it is enabled.
	*
	* @param attendanceBio the attendance bio
	*/
	public void cacheResult(AttendanceBio attendanceBio);

	/**
	* Caches the attendance bios in the entity cache if it is enabled.
	*
	* @param attendanceBios the attendance bios
	*/
	public void cacheResult(java.util.List<AttendanceBio> attendanceBios);

	/**
	* Creates a new attendance bio with the primary key. Does not add the attendance bio to the database.
	*
	* @param attendanceBioId the primary key for the new attendance bio
	* @return the new attendance bio
	*/
	public AttendanceBio create(long attendanceBioId);

	/**
	* Removes the attendance bio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceBioId the primary key of the attendance bio
	* @return the attendance bio that was removed
	* @throws NoSuchAttendanceBioException if a attendance bio with the primary key could not be found
	*/
	public AttendanceBio remove(long attendanceBioId)
		throws NoSuchAttendanceBioException;

	public AttendanceBio updateImpl(AttendanceBio attendanceBio);

	/**
	* Returns the attendance bio with the primary key or throws a {@link NoSuchAttendanceBioException} if it could not be found.
	*
	* @param attendanceBioId the primary key of the attendance bio
	* @return the attendance bio
	* @throws NoSuchAttendanceBioException if a attendance bio with the primary key could not be found
	*/
	public AttendanceBio findByPrimaryKey(long attendanceBioId)
		throws NoSuchAttendanceBioException;

	/**
	* Returns the attendance bio with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attendanceBioId the primary key of the attendance bio
	* @return the attendance bio, or <code>null</code> if a attendance bio with the primary key could not be found
	*/
	public AttendanceBio fetchByPrimaryKey(long attendanceBioId);

	@Override
	public java.util.Map<java.io.Serializable, AttendanceBio> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the attendance bios.
	*
	* @return the attendance bios
	*/
	public java.util.List<AttendanceBio> findAll();

	/**
	* Returns a range of all the attendance bios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendance bios
	* @param end the upper bound of the range of attendance bios (not inclusive)
	* @return the range of attendance bios
	*/
	public java.util.List<AttendanceBio> findAll(int start, int end);

	/**
	* Returns an ordered range of all the attendance bios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendance bios
	* @param end the upper bound of the range of attendance bios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of attendance bios
	*/
	public java.util.List<AttendanceBio> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttendanceBio> orderByComparator);

	/**
	* Returns an ordered range of all the attendance bios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendance bios
	* @param end the upper bound of the range of attendance bios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of attendance bios
	*/
	public java.util.List<AttendanceBio> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttendanceBio> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the attendance bios from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of attendance bios.
	*
	* @return the number of attendance bios
	*/
	public int countAll();
}