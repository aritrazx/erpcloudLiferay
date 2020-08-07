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

import com.liferay.famocom.erpcloud.model.SchedulesDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the schedules details service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.SchedulesDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SchedulesDetailsPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.SchedulesDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class SchedulesDetailsUtil {
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
	public static void clearCache(SchedulesDetails schedulesDetails) {
		getPersistence().clearCache(schedulesDetails);
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
	public static List<SchedulesDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SchedulesDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SchedulesDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SchedulesDetails update(SchedulesDetails schedulesDetails) {
		return getPersistence().update(schedulesDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SchedulesDetails update(SchedulesDetails schedulesDetails,
		ServiceContext serviceContext) {
		return getPersistence().update(schedulesDetails, serviceContext);
	}

	/**
	* Returns all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @return the matching schedules detailses
	*/
	public static List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate) {
		return getPersistence()
				   .findBycheckDate(employeeId, companyId, schedulesDate);
	}

	/**
	* Returns a range of all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @param start the lower bound of the range of schedules detailses
	* @param end the upper bound of the range of schedules detailses (not inclusive)
	* @return the range of matching schedules detailses
	*/
	public static List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate, int start, int end) {
		return getPersistence()
				   .findBycheckDate(employeeId, companyId, schedulesDate,
			start, end);
	}

	/**
	* Returns an ordered range of all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @param start the lower bound of the range of schedules detailses
	* @param end the upper bound of the range of schedules detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching schedules detailses
	*/
	public static List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate, int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		return getPersistence()
				   .findBycheckDate(employeeId, companyId, schedulesDate,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @param start the lower bound of the range of schedules detailses
	* @param end the upper bound of the range of schedules detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching schedules detailses
	*/
	public static List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate, int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBycheckDate(employeeId, companyId, schedulesDate,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedules details
	* @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	*/
	public static SchedulesDetails findBycheckDate_First(long employeeId,
		long companyId, Date schedulesDate,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException {
		return getPersistence()
				   .findBycheckDate_First(employeeId, companyId, schedulesDate,
			orderByComparator);
	}

	/**
	* Returns the first schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public static SchedulesDetails fetchBycheckDate_First(long employeeId,
		long companyId, Date schedulesDate,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		return getPersistence()
				   .fetchBycheckDate_First(employeeId, companyId,
			schedulesDate, orderByComparator);
	}

	/**
	* Returns the last schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedules details
	* @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	*/
	public static SchedulesDetails findBycheckDate_Last(long employeeId,
		long companyId, Date schedulesDate,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException {
		return getPersistence()
				   .findBycheckDate_Last(employeeId, companyId, schedulesDate,
			orderByComparator);
	}

	/**
	* Returns the last schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public static SchedulesDetails fetchBycheckDate_Last(long employeeId,
		long companyId, Date schedulesDate,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		return getPersistence()
				   .fetchBycheckDate_Last(employeeId, companyId, schedulesDate,
			orderByComparator);
	}

	/**
	* Returns the schedules detailses before and after the current schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* @param schedulesDetailsId the primary key of the current schedules details
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next schedules details
	* @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	*/
	public static SchedulesDetails[] findBycheckDate_PrevAndNext(
		long schedulesDetailsId, long employeeId, long companyId,
		Date schedulesDate,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException {
		return getPersistence()
				   .findBycheckDate_PrevAndNext(schedulesDetailsId, employeeId,
			companyId, schedulesDate, orderByComparator);
	}

	/**
	* Removes all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	*/
	public static void removeBycheckDate(long employeeId, long companyId,
		Date schedulesDate) {
		getPersistence().removeBycheckDate(employeeId, companyId, schedulesDate);
	}

	/**
	* Returns the number of schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @return the number of matching schedules detailses
	*/
	public static int countBycheckDate(long employeeId, long companyId,
		Date schedulesDate) {
		return getPersistence()
				   .countBycheckDate(employeeId, companyId, schedulesDate);
	}

	/**
	* Returns all the schedules detailses where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @return the matching schedules detailses
	*/
	public static List<SchedulesDetails> findBydetailsEdit(
		long worksSchedulesId) {
		return getPersistence().findBydetailsEdit(worksSchedulesId);
	}

	/**
	* Returns a range of all the schedules detailses where worksSchedulesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param worksSchedulesId the works schedules ID
	* @param start the lower bound of the range of schedules detailses
	* @param end the upper bound of the range of schedules detailses (not inclusive)
	* @return the range of matching schedules detailses
	*/
	public static List<SchedulesDetails> findBydetailsEdit(
		long worksSchedulesId, int start, int end) {
		return getPersistence().findBydetailsEdit(worksSchedulesId, start, end);
	}

	/**
	* Returns an ordered range of all the schedules detailses where worksSchedulesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param worksSchedulesId the works schedules ID
	* @param start the lower bound of the range of schedules detailses
	* @param end the upper bound of the range of schedules detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching schedules detailses
	*/
	public static List<SchedulesDetails> findBydetailsEdit(
		long worksSchedulesId, int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		return getPersistence()
				   .findBydetailsEdit(worksSchedulesId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the schedules detailses where worksSchedulesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param worksSchedulesId the works schedules ID
	* @param start the lower bound of the range of schedules detailses
	* @param end the upper bound of the range of schedules detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching schedules detailses
	*/
	public static List<SchedulesDetails> findBydetailsEdit(
		long worksSchedulesId, int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBydetailsEdit(worksSchedulesId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first schedules details in the ordered set where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedules details
	* @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	*/
	public static SchedulesDetails findBydetailsEdit_First(
		long worksSchedulesId,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException {
		return getPersistence()
				   .findBydetailsEdit_First(worksSchedulesId, orderByComparator);
	}

	/**
	* Returns the first schedules details in the ordered set where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public static SchedulesDetails fetchBydetailsEdit_First(
		long worksSchedulesId,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		return getPersistence()
				   .fetchBydetailsEdit_First(worksSchedulesId, orderByComparator);
	}

	/**
	* Returns the last schedules details in the ordered set where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedules details
	* @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	*/
	public static SchedulesDetails findBydetailsEdit_Last(
		long worksSchedulesId,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException {
		return getPersistence()
				   .findBydetailsEdit_Last(worksSchedulesId, orderByComparator);
	}

	/**
	* Returns the last schedules details in the ordered set where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public static SchedulesDetails fetchBydetailsEdit_Last(
		long worksSchedulesId,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		return getPersistence()
				   .fetchBydetailsEdit_Last(worksSchedulesId, orderByComparator);
	}

	/**
	* Returns the schedules detailses before and after the current schedules details in the ordered set where worksSchedulesId = &#63;.
	*
	* @param schedulesDetailsId the primary key of the current schedules details
	* @param worksSchedulesId the works schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next schedules details
	* @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	*/
	public static SchedulesDetails[] findBydetailsEdit_PrevAndNext(
		long schedulesDetailsId, long worksSchedulesId,
		OrderByComparator<SchedulesDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException {
		return getPersistence()
				   .findBydetailsEdit_PrevAndNext(schedulesDetailsId,
			worksSchedulesId, orderByComparator);
	}

	/**
	* Removes all the schedules detailses where worksSchedulesId = &#63; from the database.
	*
	* @param worksSchedulesId the works schedules ID
	*/
	public static void removeBydetailsEdit(long worksSchedulesId) {
		getPersistence().removeBydetailsEdit(worksSchedulesId);
	}

	/**
	* Returns the number of schedules detailses where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @return the number of matching schedules detailses
	*/
	public static int countBydetailsEdit(long worksSchedulesId) {
		return getPersistence().countBydetailsEdit(worksSchedulesId);
	}

	/**
	* Returns the schedules details where employeeId = &#63; and schedulesDate = &#63; or throws a {@link NoSuchSchedulesDetailsException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param schedulesDate the schedules date
	* @return the matching schedules details
	* @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	*/
	public static SchedulesDetails findByempIdAndAttDate(long employeeId,
		Date schedulesDate)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException {
		return getPersistence().findByempIdAndAttDate(employeeId, schedulesDate);
	}

	/**
	* Returns the schedules details where employeeId = &#63; and schedulesDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param schedulesDate the schedules date
	* @return the matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public static SchedulesDetails fetchByempIdAndAttDate(long employeeId,
		Date schedulesDate) {
		return getPersistence().fetchByempIdAndAttDate(employeeId, schedulesDate);
	}

	/**
	* Returns the schedules details where employeeId = &#63; and schedulesDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param schedulesDate the schedules date
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public static SchedulesDetails fetchByempIdAndAttDate(long employeeId,
		Date schedulesDate, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByempIdAndAttDate(employeeId, schedulesDate,
			retrieveFromCache);
	}

	/**
	* Removes the schedules details where employeeId = &#63; and schedulesDate = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param schedulesDate the schedules date
	* @return the schedules details that was removed
	*/
	public static SchedulesDetails removeByempIdAndAttDate(long employeeId,
		Date schedulesDate)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException {
		return getPersistence()
				   .removeByempIdAndAttDate(employeeId, schedulesDate);
	}

	/**
	* Returns the number of schedules detailses where employeeId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param schedulesDate the schedules date
	* @return the number of matching schedules detailses
	*/
	public static int countByempIdAndAttDate(long employeeId, Date schedulesDate) {
		return getPersistence().countByempIdAndAttDate(employeeId, schedulesDate);
	}

	/**
	* Caches the schedules details in the entity cache if it is enabled.
	*
	* @param schedulesDetails the schedules details
	*/
	public static void cacheResult(SchedulesDetails schedulesDetails) {
		getPersistence().cacheResult(schedulesDetails);
	}

	/**
	* Caches the schedules detailses in the entity cache if it is enabled.
	*
	* @param schedulesDetailses the schedules detailses
	*/
	public static void cacheResult(List<SchedulesDetails> schedulesDetailses) {
		getPersistence().cacheResult(schedulesDetailses);
	}

	/**
	* Creates a new schedules details with the primary key. Does not add the schedules details to the database.
	*
	* @param schedulesDetailsId the primary key for the new schedules details
	* @return the new schedules details
	*/
	public static SchedulesDetails create(long schedulesDetailsId) {
		return getPersistence().create(schedulesDetailsId);
	}

	/**
	* Removes the schedules details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesDetailsId the primary key of the schedules details
	* @return the schedules details that was removed
	* @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	*/
	public static SchedulesDetails remove(long schedulesDetailsId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException {
		return getPersistence().remove(schedulesDetailsId);
	}

	public static SchedulesDetails updateImpl(SchedulesDetails schedulesDetails) {
		return getPersistence().updateImpl(schedulesDetails);
	}

	/**
	* Returns the schedules details with the primary key or throws a {@link NoSuchSchedulesDetailsException} if it could not be found.
	*
	* @param schedulesDetailsId the primary key of the schedules details
	* @return the schedules details
	* @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	*/
	public static SchedulesDetails findByPrimaryKey(long schedulesDetailsId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException {
		return getPersistence().findByPrimaryKey(schedulesDetailsId);
	}

	/**
	* Returns the schedules details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param schedulesDetailsId the primary key of the schedules details
	* @return the schedules details, or <code>null</code> if a schedules details with the primary key could not be found
	*/
	public static SchedulesDetails fetchByPrimaryKey(long schedulesDetailsId) {
		return getPersistence().fetchByPrimaryKey(schedulesDetailsId);
	}

	public static java.util.Map<java.io.Serializable, SchedulesDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the schedules detailses.
	*
	* @return the schedules detailses
	*/
	public static List<SchedulesDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the schedules detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules detailses
	* @param end the upper bound of the range of schedules detailses (not inclusive)
	* @return the range of schedules detailses
	*/
	public static List<SchedulesDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the schedules detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules detailses
	* @param end the upper bound of the range of schedules detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of schedules detailses
	*/
	public static List<SchedulesDetails> findAll(int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the schedules detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules detailses
	* @param end the upper bound of the range of schedules detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of schedules detailses
	*/
	public static List<SchedulesDetails> findAll(int start, int end,
		OrderByComparator<SchedulesDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the schedules detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of schedules detailses.
	*
	* @return the number of schedules detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SchedulesDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SchedulesDetailsPersistence, SchedulesDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SchedulesDetailsPersistence.class);

		ServiceTracker<SchedulesDetailsPersistence, SchedulesDetailsPersistence> serviceTracker =
			new ServiceTracker<SchedulesDetailsPersistence, SchedulesDetailsPersistence>(bundle.getBundleContext(),
				SchedulesDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}