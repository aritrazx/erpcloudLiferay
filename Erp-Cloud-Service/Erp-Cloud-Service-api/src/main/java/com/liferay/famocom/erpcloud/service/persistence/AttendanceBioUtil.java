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

import com.liferay.famocom.erpcloud.model.AttendanceBio;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the attendance bio service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.AttendanceBioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AttendanceBioPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AttendanceBioPersistenceImpl
 * @generated
 */
@ProviderType
public class AttendanceBioUtil {
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
	public static void clearCache(AttendanceBio attendanceBio) {
		getPersistence().clearCache(attendanceBio);
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
	public static List<AttendanceBio> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AttendanceBio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AttendanceBio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AttendanceBio> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AttendanceBio update(AttendanceBio attendanceBio) {
		return getPersistence().update(attendanceBio);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AttendanceBio update(AttendanceBio attendanceBio,
		ServiceContext serviceContext) {
		return getPersistence().update(attendanceBio, serviceContext);
	}

	/**
	* Returns all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @return the matching attendance bios
	*/
	public static List<AttendanceBio> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate) {
		return getPersistence()
				   .findByempIdAndAttDateComId(employeeId, companyId, attDate);
	}

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
	public static List<AttendanceBio> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate, int start, int end) {
		return getPersistence()
				   .findByempIdAndAttDateComId(employeeId, companyId, attDate,
			start, end);
	}

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
	public static List<AttendanceBio> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate, int start, int end,
		OrderByComparator<AttendanceBio> orderByComparator) {
		return getPersistence()
				   .findByempIdAndAttDateComId(employeeId, companyId, attDate,
			start, end, orderByComparator);
	}

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
	public static List<AttendanceBio> findByempIdAndAttDateComId(
		long employeeId, long companyId, Date attDate, int start, int end,
		OrderByComparator<AttendanceBio> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByempIdAndAttDateComId(employeeId, companyId, attDate,
			start, end, orderByComparator, retrieveFromCache);
	}

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
	public static AttendanceBio findByempIdAndAttDateComId_First(
		long employeeId, long companyId, Date attDate,
		OrderByComparator<AttendanceBio> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceBioException {
		return getPersistence()
				   .findByempIdAndAttDateComId_First(employeeId, companyId,
			attDate, orderByComparator);
	}

	/**
	* Returns the first attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendance bio, or <code>null</code> if a matching attendance bio could not be found
	*/
	public static AttendanceBio fetchByempIdAndAttDateComId_First(
		long employeeId, long companyId, Date attDate,
		OrderByComparator<AttendanceBio> orderByComparator) {
		return getPersistence()
				   .fetchByempIdAndAttDateComId_First(employeeId, companyId,
			attDate, orderByComparator);
	}

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
	public static AttendanceBio findByempIdAndAttDateComId_Last(
		long employeeId, long companyId, Date attDate,
		OrderByComparator<AttendanceBio> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceBioException {
		return getPersistence()
				   .findByempIdAndAttDateComId_Last(employeeId, companyId,
			attDate, orderByComparator);
	}

	/**
	* Returns the last attendance bio in the ordered set where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendance bio, or <code>null</code> if a matching attendance bio could not be found
	*/
	public static AttendanceBio fetchByempIdAndAttDateComId_Last(
		long employeeId, long companyId, Date attDate,
		OrderByComparator<AttendanceBio> orderByComparator) {
		return getPersistence()
				   .fetchByempIdAndAttDateComId_Last(employeeId, companyId,
			attDate, orderByComparator);
	}

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
	public static AttendanceBio[] findByempIdAndAttDateComId_PrevAndNext(
		long attendanceBioId, long employeeId, long companyId, Date attDate,
		OrderByComparator<AttendanceBio> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceBioException {
		return getPersistence()
				   .findByempIdAndAttDateComId_PrevAndNext(attendanceBioId,
			employeeId, companyId, attDate, orderByComparator);
	}

	/**
	* Removes all the attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63; from the database.
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
	* Returns the number of attendance bios where employeeId = &#63; and companyId = &#63; and attDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param attDate the att date
	* @return the number of matching attendance bios
	*/
	public static int countByempIdAndAttDateComId(long employeeId,
		long companyId, Date attDate) {
		return getPersistence()
				   .countByempIdAndAttDateComId(employeeId, companyId, attDate);
	}

	/**
	* Caches the attendance bio in the entity cache if it is enabled.
	*
	* @param attendanceBio the attendance bio
	*/
	public static void cacheResult(AttendanceBio attendanceBio) {
		getPersistence().cacheResult(attendanceBio);
	}

	/**
	* Caches the attendance bios in the entity cache if it is enabled.
	*
	* @param attendanceBios the attendance bios
	*/
	public static void cacheResult(List<AttendanceBio> attendanceBios) {
		getPersistence().cacheResult(attendanceBios);
	}

	/**
	* Creates a new attendance bio with the primary key. Does not add the attendance bio to the database.
	*
	* @param attendanceBioId the primary key for the new attendance bio
	* @return the new attendance bio
	*/
	public static AttendanceBio create(long attendanceBioId) {
		return getPersistence().create(attendanceBioId);
	}

	/**
	* Removes the attendance bio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceBioId the primary key of the attendance bio
	* @return the attendance bio that was removed
	* @throws NoSuchAttendanceBioException if a attendance bio with the primary key could not be found
	*/
	public static AttendanceBio remove(long attendanceBioId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceBioException {
		return getPersistence().remove(attendanceBioId);
	}

	public static AttendanceBio updateImpl(AttendanceBio attendanceBio) {
		return getPersistence().updateImpl(attendanceBio);
	}

	/**
	* Returns the attendance bio with the primary key or throws a {@link NoSuchAttendanceBioException} if it could not be found.
	*
	* @param attendanceBioId the primary key of the attendance bio
	* @return the attendance bio
	* @throws NoSuchAttendanceBioException if a attendance bio with the primary key could not be found
	*/
	public static AttendanceBio findByPrimaryKey(long attendanceBioId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceBioException {
		return getPersistence().findByPrimaryKey(attendanceBioId);
	}

	/**
	* Returns the attendance bio with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attendanceBioId the primary key of the attendance bio
	* @return the attendance bio, or <code>null</code> if a attendance bio with the primary key could not be found
	*/
	public static AttendanceBio fetchByPrimaryKey(long attendanceBioId) {
		return getPersistence().fetchByPrimaryKey(attendanceBioId);
	}

	public static java.util.Map<java.io.Serializable, AttendanceBio> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the attendance bios.
	*
	* @return the attendance bios
	*/
	public static List<AttendanceBio> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AttendanceBio> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AttendanceBio> findAll(int start, int end,
		OrderByComparator<AttendanceBio> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AttendanceBio> findAll(int start, int end,
		OrderByComparator<AttendanceBio> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the attendance bios from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of attendance bios.
	*
	* @return the number of attendance bios
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AttendanceBioPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AttendanceBioPersistence, AttendanceBioPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AttendanceBioPersistence.class);

		ServiceTracker<AttendanceBioPersistence, AttendanceBioPersistence> serviceTracker =
			new ServiceTracker<AttendanceBioPersistence, AttendanceBioPersistence>(bundle.getBundleContext(),
				AttendanceBioPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}