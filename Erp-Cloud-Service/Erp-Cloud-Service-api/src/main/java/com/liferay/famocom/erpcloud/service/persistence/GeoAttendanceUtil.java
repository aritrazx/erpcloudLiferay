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

import com.liferay.famocom.erpcloud.model.GeoAttendance;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the geo attendance service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.GeoAttendancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see GeoAttendancePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.GeoAttendancePersistenceImpl
 * @generated
 */
@ProviderType
public class GeoAttendanceUtil {
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
	public static void clearCache(GeoAttendance geoAttendance) {
		getPersistence().clearCache(geoAttendance);
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
	public static List<GeoAttendance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GeoAttendance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GeoAttendance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GeoAttendance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GeoAttendance update(GeoAttendance geoAttendance) {
		return getPersistence().update(geoAttendance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GeoAttendance update(GeoAttendance geoAttendance,
		ServiceContext serviceContext) {
		return getPersistence().update(geoAttendance, serviceContext);
	}

	/**
	* Returns the geo attendance where employeeId = &#63; and attDate = &#63; or throws a {@link NoSuchGeoAttendanceException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the matching geo attendance
	* @throws NoSuchGeoAttendanceException if a matching geo attendance could not be found
	*/
	public static GeoAttendance findByempIdAndAttDate(long employeeId,
		Date attDate)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGeoAttendanceException {
		return getPersistence().findByempIdAndAttDate(employeeId, attDate);
	}

	/**
	* Returns the geo attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	*/
	public static GeoAttendance fetchByempIdAndAttDate(long employeeId,
		Date attDate) {
		return getPersistence().fetchByempIdAndAttDate(employeeId, attDate);
	}

	/**
	* Returns the geo attendance where employeeId = &#63; and attDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	*/
	public static GeoAttendance fetchByempIdAndAttDate(long employeeId,
		Date attDate, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByempIdAndAttDate(employeeId, attDate,
			retrieveFromCache);
	}

	/**
	* Removes the geo attendance where employeeId = &#63; and attDate = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the geo attendance that was removed
	*/
	public static GeoAttendance removeByempIdAndAttDate(long employeeId,
		Date attDate)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGeoAttendanceException {
		return getPersistence().removeByempIdAndAttDate(employeeId, attDate);
	}

	/**
	* Returns the number of geo attendances where employeeId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param attDate the att date
	* @return the number of matching geo attendances
	*/
	public static int countByempIdAndAttDate(long employeeId, Date attDate) {
		return getPersistence().countByempIdAndAttDate(employeeId, attDate);
	}

	/**
	* Returns all the geo attendances where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching geo attendances
	*/
	public static List<GeoAttendance> findByempId(long employeeId) {
		return getPersistence().findByempId(employeeId);
	}

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
	public static List<GeoAttendance> findByempId(long employeeId, int start,
		int end) {
		return getPersistence().findByempId(employeeId, start, end);
	}

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
	public static List<GeoAttendance> findByempId(long employeeId, int start,
		int end, OrderByComparator<GeoAttendance> orderByComparator) {
		return getPersistence()
				   .findByempId(employeeId, start, end, orderByComparator);
	}

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
	public static List<GeoAttendance> findByempId(long employeeId, int start,
		int end, OrderByComparator<GeoAttendance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByempId(employeeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first geo attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geo attendance
	* @throws NoSuchGeoAttendanceException if a matching geo attendance could not be found
	*/
	public static GeoAttendance findByempId_First(long employeeId,
		OrderByComparator<GeoAttendance> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGeoAttendanceException {
		return getPersistence().findByempId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first geo attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	*/
	public static GeoAttendance fetchByempId_First(long employeeId,
		OrderByComparator<GeoAttendance> orderByComparator) {
		return getPersistence().fetchByempId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last geo attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geo attendance
	* @throws NoSuchGeoAttendanceException if a matching geo attendance could not be found
	*/
	public static GeoAttendance findByempId_Last(long employeeId,
		OrderByComparator<GeoAttendance> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGeoAttendanceException {
		return getPersistence().findByempId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last geo attendance in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geo attendance, or <code>null</code> if a matching geo attendance could not be found
	*/
	public static GeoAttendance fetchByempId_Last(long employeeId,
		OrderByComparator<GeoAttendance> orderByComparator) {
		return getPersistence().fetchByempId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the geo attendances before and after the current geo attendance in the ordered set where employeeId = &#63;.
	*
	* @param attendanceId the primary key of the current geo attendance
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geo attendance
	* @throws NoSuchGeoAttendanceException if a geo attendance with the primary key could not be found
	*/
	public static GeoAttendance[] findByempId_PrevAndNext(long attendanceId,
		long employeeId, OrderByComparator<GeoAttendance> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGeoAttendanceException {
		return getPersistence()
				   .findByempId_PrevAndNext(attendanceId, employeeId,
			orderByComparator);
	}

	/**
	* Removes all the geo attendances where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeByempId(long employeeId) {
		getPersistence().removeByempId(employeeId);
	}

	/**
	* Returns the number of geo attendances where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching geo attendances
	*/
	public static int countByempId(long employeeId) {
		return getPersistence().countByempId(employeeId);
	}

	/**
	* Caches the geo attendance in the entity cache if it is enabled.
	*
	* @param geoAttendance the geo attendance
	*/
	public static void cacheResult(GeoAttendance geoAttendance) {
		getPersistence().cacheResult(geoAttendance);
	}

	/**
	* Caches the geo attendances in the entity cache if it is enabled.
	*
	* @param geoAttendances the geo attendances
	*/
	public static void cacheResult(List<GeoAttendance> geoAttendances) {
		getPersistence().cacheResult(geoAttendances);
	}

	/**
	* Creates a new geo attendance with the primary key. Does not add the geo attendance to the database.
	*
	* @param attendanceId the primary key for the new geo attendance
	* @return the new geo attendance
	*/
	public static GeoAttendance create(long attendanceId) {
		return getPersistence().create(attendanceId);
	}

	/**
	* Removes the geo attendance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceId the primary key of the geo attendance
	* @return the geo attendance that was removed
	* @throws NoSuchGeoAttendanceException if a geo attendance with the primary key could not be found
	*/
	public static GeoAttendance remove(long attendanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGeoAttendanceException {
		return getPersistence().remove(attendanceId);
	}

	public static GeoAttendance updateImpl(GeoAttendance geoAttendance) {
		return getPersistence().updateImpl(geoAttendance);
	}

	/**
	* Returns the geo attendance with the primary key or throws a {@link NoSuchGeoAttendanceException} if it could not be found.
	*
	* @param attendanceId the primary key of the geo attendance
	* @return the geo attendance
	* @throws NoSuchGeoAttendanceException if a geo attendance with the primary key could not be found
	*/
	public static GeoAttendance findByPrimaryKey(long attendanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGeoAttendanceException {
		return getPersistence().findByPrimaryKey(attendanceId);
	}

	/**
	* Returns the geo attendance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attendanceId the primary key of the geo attendance
	* @return the geo attendance, or <code>null</code> if a geo attendance with the primary key could not be found
	*/
	public static GeoAttendance fetchByPrimaryKey(long attendanceId) {
		return getPersistence().fetchByPrimaryKey(attendanceId);
	}

	public static java.util.Map<java.io.Serializable, GeoAttendance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the geo attendances.
	*
	* @return the geo attendances
	*/
	public static List<GeoAttendance> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<GeoAttendance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<GeoAttendance> findAll(int start, int end,
		OrderByComparator<GeoAttendance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<GeoAttendance> findAll(int start, int end,
		OrderByComparator<GeoAttendance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the geo attendances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of geo attendances.
	*
	* @return the number of geo attendances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GeoAttendancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GeoAttendancePersistence, GeoAttendancePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GeoAttendancePersistence.class);

		ServiceTracker<GeoAttendancePersistence, GeoAttendancePersistence> serviceTracker =
			new ServiceTracker<GeoAttendancePersistence, GeoAttendancePersistence>(bundle.getBundleContext(),
				GeoAttendancePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}