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

import com.liferay.famocom.erpcloud.exception.NoSuchGeoAttendanceException;
import com.liferay.famocom.erpcloud.model.GeoAttendance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the geo attendance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.GeoAttendancePersistenceImpl
 * @see GeoAttendanceUtil
 * @generated
 */
@ProviderType
public interface GeoAttendancePersistence extends BasePersistence<GeoAttendance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeoAttendanceUtil} to access the geo attendance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the geo attendance where employeeId = &#63; and attDate = &#63; or throws a {@link NoSuchGeoAttendanceException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the matching geo attendance
	* @throws NoSuchGeoAttendanceException if a matching geo attendance could not be found
	*/
	public GeoAttendance findByempIdAndAttDate(long employeeId, Date attDate)
		throws NoSuchGeoAttendanceException;

	/**
	* Returns the geo attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	*/
	public GeoAttendance fetchByempIdAndAttDate(long employeeId, Date attDate);

	/**
	* Returns the geo attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	*/
	public GeoAttendance fetchByempIdAndAttDate(long employeeId, Date attDate,
		boolean retrieveFromCache);

	/**
	* Removes the geo attendance where employeeId = &#63; and attDate = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the geo attendance that was removed
	*/
	public GeoAttendance removeByempIdAndAttDate(long employeeId, Date attDate)
		throws NoSuchGeoAttendanceException;

	/**
	* Returns the number of geo attendances where employeeId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the number of matching geo attendances
	*/
	public int countByempIdAndAttDate(long employeeId, Date attDate);

	/**
	* Returns all the geo attendances where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching geo attendances
	*/
	public java.util.List<GeoAttendance> findByempId(long employeeId);

	/**
	* Returns a range of all the geo attendances where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of geo attendances
	* @param end the upper bound of the range of geo attendances (not inclusive)
	* @return the range of matching geo attendances
	*/
	public java.util.List<GeoAttendance> findByempId(long employeeId,
		int start, int end);

	/**
	* Returns an ordered range of all the geo attendances where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of geo attendances
	* @param end the upper bound of the range of geo attendances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching geo attendances
	*/
	public java.util.List<GeoAttendance> findByempId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GeoAttendance> orderByComparator);

	/**
	* Returns an ordered range of all the geo attendances where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of geo attendances
	* @param end the upper bound of the range of geo attendances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching geo attendances
	*/
	public java.util.List<GeoAttendance> findByempId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GeoAttendance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first geo attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geo attendance
	* @throws NoSuchGeoAttendanceException if a matching geo attendance could not be found
	*/
	public GeoAttendance findByempId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<GeoAttendance> orderByComparator)
		throws NoSuchGeoAttendanceException;

	/**
	* Returns the first geo attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	*/
	public GeoAttendance fetchByempId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<GeoAttendance> orderByComparator);

	/**
	* Returns the last geo attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geo attendance
	* @throws NoSuchGeoAttendanceException if a matching geo attendance could not be found
	*/
	public GeoAttendance findByempId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<GeoAttendance> orderByComparator)
		throws NoSuchGeoAttendanceException;

	/**
	* Returns the last geo attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	*/
	public GeoAttendance fetchByempId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<GeoAttendance> orderByComparator);

	/**
	* Returns the geo attendances before and after the current geo attendance in the ordered set where employeeId = &#63;.
	*
	* @param attendanceId the primary key of the current geo attendance
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geo attendance
	* @throws NoSuchGeoAttendanceException if a geo attendance with the primary key could not be found
	*/
	public GeoAttendance[] findByempId_PrevAndNext(long attendanceId,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<GeoAttendance> orderByComparator)
		throws NoSuchGeoAttendanceException;

	/**
	* Removes all the geo attendances where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeByempId(long employeeId);

	/**
	* Returns the number of geo attendances where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching geo attendances
	*/
	public int countByempId(long employeeId);

	/**
	* Caches the geo attendance in the entity cache if it is enabled.
	*
	* @param geoAttendance the geo attendance
	*/
	public void cacheResult(GeoAttendance geoAttendance);

	/**
	* Caches the geo attendances in the entity cache if it is enabled.
	*
	* @param geoAttendances the geo attendances
	*/
	public void cacheResult(java.util.List<GeoAttendance> geoAttendances);

	/**
	* Creates a new geo attendance with the primary key. Does not add the geo attendance to the database.
	*
	* @param attendanceId the primary key for the new geo attendance
	* @return the new geo attendance
	*/
	public GeoAttendance create(long attendanceId);

	/**
	* Removes the geo attendance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceId the primary key of the geo attendance
	* @return the geo attendance that was removed
	* @throws NoSuchGeoAttendanceException if a geo attendance with the primary key could not be found
	*/
	public GeoAttendance remove(long attendanceId)
		throws NoSuchGeoAttendanceException;

	public GeoAttendance updateImpl(GeoAttendance geoAttendance);

	/**
	* Returns the geo attendance with the primary key or throws a {@link NoSuchGeoAttendanceException} if it could not be found.
	*
	* @param attendanceId the primary key of the geo attendance
	* @return the geo attendance
	* @throws NoSuchGeoAttendanceException if a geo attendance with the primary key could not be found
	*/
	public GeoAttendance findByPrimaryKey(long attendanceId)
		throws NoSuchGeoAttendanceException;

	/**
	* Returns the geo attendance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attendanceId the primary key of the geo attendance
	* @return the geo attendance, or <code>null</code> if a geo attendance with the primary key could not be found
	*/
	public GeoAttendance fetchByPrimaryKey(long attendanceId);

	@Override
	public java.util.Map<java.io.Serializable, GeoAttendance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the geo attendances.
	*
	* @return the geo attendances
	*/
	public java.util.List<GeoAttendance> findAll();

	/**
	* Returns a range of all the geo attendances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geo attendances
	* @param end the upper bound of the range of geo attendances (not inclusive)
	* @return the range of geo attendances
	*/
	public java.util.List<GeoAttendance> findAll(int start, int end);

	/**
	* Returns an ordered range of all the geo attendances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geo attendances
	* @param end the upper bound of the range of geo attendances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of geo attendances
	*/
	public java.util.List<GeoAttendance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GeoAttendance> orderByComparator);

	/**
	* Returns an ordered range of all the geo attendances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geo attendances
	* @param end the upper bound of the range of geo attendances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of geo attendances
	*/
	public java.util.List<GeoAttendance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GeoAttendance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the geo attendances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of geo attendances.
	*
	* @return the number of geo attendances
	*/
	public int countAll();
}