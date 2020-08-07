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

import com.liferay.famocom.erpcloud.model.SalDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the sal details service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.SalDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SalDetailsPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.SalDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class SalDetailsUtil {
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
	public static void clearCache(SalDetails salDetails) {
		getPersistence().clearCache(salDetails);
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
	public static List<SalDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SalDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SalDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SalDetails update(SalDetails salDetails) {
		return getPersistence().update(salDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SalDetails update(SalDetails salDetails,
		ServiceContext serviceContext) {
		return getPersistence().update(salDetails, serviceContext);
	}

	/**
	* Returns all the sal detailses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching sal detailses
	*/
	public static List<SalDetails> findByemployeeId(long employeeId) {
		return getPersistence().findByemployeeId(employeeId);
	}

	/**
	* Returns a range of all the sal detailses where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeId(long employeeId, int start,
		int end) {
		return getPersistence().findByemployeeId(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findByemployeeId_First(long employeeId,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeId_First(long employeeId,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findByemployeeId_Last(long employeeId,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeId_Last(long employeeId,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the sal detailses before and after the current sal details in the ordered set where employeeId = &#63;.
	*
	* @param SalDetailsId the primary key of the current sal details
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sal details
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public static SalDetails[] findByemployeeId_PrevAndNext(long SalDetailsId,
		long employeeId, OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeId_PrevAndNext(SalDetailsId, employeeId,
			orderByComparator);
	}

	/**
	* Removes all the sal detailses where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeByemployeeId(long employeeId) {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	* Returns the number of sal detailses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching sal detailses
	*/
	public static int countByemployeeId(long employeeId) {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	* Returns all the sal detailses where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the matching sal detailses
	*/
	public static List<SalDetails> findBymonthYear(long monthYear) {
		return getPersistence().findBymonthYear(monthYear);
	}

	/**
	* Returns a range of all the sal detailses where monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of matching sal detailses
	*/
	public static List<SalDetails> findBymonthYear(long monthYear, int start,
		int end) {
		return getPersistence().findBymonthYear(monthYear, start, end);
	}

	/**
	* Returns an ordered range of all the sal detailses where monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findBymonthYear(long monthYear, int start,
		int end, OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findBymonthYear(monthYear, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses where monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findBymonthYear(long monthYear, int start,
		int end, OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBymonthYear(monthYear, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first sal details in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findBymonthYear_First(long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findBymonthYear_First(monthYear, orderByComparator);
	}

	/**
	* Returns the first sal details in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchBymonthYear_First(long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchBymonthYear_First(monthYear, orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findBymonthYear_Last(long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findBymonthYear_Last(monthYear, orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchBymonthYear_Last(long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchBymonthYear_Last(monthYear, orderByComparator);
	}

	/**
	* Returns the sal detailses before and after the current sal details in the ordered set where monthYear = &#63;.
	*
	* @param SalDetailsId the primary key of the current sal details
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sal details
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public static SalDetails[] findBymonthYear_PrevAndNext(long SalDetailsId,
		long monthYear, OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findBymonthYear_PrevAndNext(SalDetailsId, monthYear,
			orderByComparator);
	}

	/**
	* Removes all the sal detailses where monthYear = &#63; from the database.
	*
	* @param monthYear the month year
	*/
	public static void removeBymonthYear(long monthYear) {
		getPersistence().removeBymonthYear(monthYear);
	}

	/**
	* Returns the number of sal detailses where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the number of matching sal detailses
	*/
	public static int countBymonthYear(long monthYear) {
		return getPersistence().countBymonthYear(monthYear);
	}

	/**
	* Returns all the sal detailses where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the matching sal detailses
	*/
	public static List<SalDetails> findBymonthYearAndemployeeId(
		long monthYear, long employeeId) {
		return getPersistence()
				   .findBymonthYearAndemployeeId(monthYear, employeeId);
	}

	/**
	* Returns a range of all the sal detailses where monthYear = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of matching sal detailses
	*/
	public static List<SalDetails> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end) {
		return getPersistence()
				   .findBymonthYearAndemployeeId(monthYear, employeeId, start,
			end);
	}

	/**
	* Returns an ordered range of all the sal detailses where monthYear = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findBymonthYearAndemployeeId(monthYear, employeeId, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses where monthYear = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBymonthYearAndemployeeId(monthYear, employeeId, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findBymonthYearAndemployeeId_First(
		long monthYear, long employeeId,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findBymonthYearAndemployeeId_First(monthYear, employeeId,
			orderByComparator);
	}

	/**
	* Returns the first sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchBymonthYearAndemployeeId_First(
		long monthYear, long employeeId,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchBymonthYearAndemployeeId_First(monthYear, employeeId,
			orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findBymonthYearAndemployeeId_Last(long monthYear,
		long employeeId, OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findBymonthYearAndemployeeId_Last(monthYear, employeeId,
			orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchBymonthYearAndemployeeId_Last(
		long monthYear, long employeeId,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchBymonthYearAndemployeeId_Last(monthYear, employeeId,
			orderByComparator);
	}

	/**
	* Returns the sal detailses before and after the current sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param SalDetailsId the primary key of the current sal details
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sal details
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public static SalDetails[] findBymonthYearAndemployeeId_PrevAndNext(
		long SalDetailsId, long monthYear, long employeeId,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findBymonthYearAndemployeeId_PrevAndNext(SalDetailsId,
			monthYear, employeeId, orderByComparator);
	}

	/**
	* Removes all the sal detailses where monthYear = &#63; and employeeId = &#63; from the database.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	*/
	public static void removeBymonthYearAndemployeeId(long monthYear,
		long employeeId) {
		getPersistence().removeBymonthYearAndemployeeId(monthYear, employeeId);
	}

	/**
	* Returns the number of sal detailses where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the number of matching sal detailses
	*/
	public static int countBymonthYearAndemployeeId(long monthYear,
		long employeeId) {
		return getPersistence()
				   .countBymonthYearAndemployeeId(monthYear, employeeId);
	}

	/**
	* Returns all the sal detailses where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYear);
	}

	/**
	* Returns a range of all the sal detailses where employeeId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYear, start,
			end);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYear, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYear, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findByemployeeIdAndMonthYear_First(
		long employeeId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndMonthYear_First(employeeId, monthYear,
			orderByComparator);
	}

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeIdAndMonthYear_First(
		long employeeId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAndMonthYear_First(employeeId, monthYear,
			orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findByemployeeIdAndMonthYear_Last(
		long employeeId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndMonthYear_Last(employeeId, monthYear,
			orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeIdAndMonthYear_Last(
		long employeeId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAndMonthYear_Last(employeeId, monthYear,
			orderByComparator);
	}

	/**
	* Returns the sal detailses before and after the current sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param SalDetailsId the primary key of the current sal details
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sal details
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public static SalDetails[] findByemployeeIdAndMonthYear_PrevAndNext(
		long SalDetailsId, long employeeId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndMonthYear_PrevAndNext(SalDetailsId,
			employeeId, monthYear, orderByComparator);
	}

	/**
	* Returns all the sal detailses where employeeId = &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYears the month years
	* @return the matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYears);
	}

	/**
	* Returns a range of all the sal detailses where employeeId = &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYears the month years
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYears, start,
			end);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYears the month years
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYears, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYears, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the sal detailses where employeeId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	*/
	public static void removeByemployeeIdAndMonthYear(long employeeId,
		long monthYear) {
		getPersistence().removeByemployeeIdAndMonthYear(employeeId, monthYear);
	}

	/**
	* Returns the number of sal detailses where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the number of matching sal detailses
	*/
	public static int countByemployeeIdAndMonthYear(long employeeId,
		long monthYear) {
		return getPersistence()
				   .countByemployeeIdAndMonthYear(employeeId, monthYear);
	}

	/**
	* Returns the number of sal detailses where employeeId = &#63; and monthYear = any &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYears the month years
	* @return the number of matching sal detailses
	*/
	public static int countByemployeeIdAndMonthYear(long employeeId,
		long[] monthYears) {
		return getPersistence()
				   .countByemployeeIdAndMonthYear(employeeId, monthYears);
	}

	/**
	* Returns all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentId, monthYear);
	}

	/**
	* Returns a range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear, int start, int end) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentId, monthYear, start, end);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentId, monthYear, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentId, monthYear, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findByemployeeIdAndComponentIdmonthYears_First(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndComponentIdmonthYears_First(employeeId,
			componentId, monthYear, orderByComparator);
	}

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeIdAndComponentIdmonthYears_First(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAndComponentIdmonthYears_First(employeeId,
			componentId, monthYear, orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findByemployeeIdAndComponentIdmonthYears_Last(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndComponentIdmonthYears_Last(employeeId,
			componentId, monthYear, orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeIdAndComponentIdmonthYears_Last(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAndComponentIdmonthYears_Last(employeeId,
			componentId, monthYear, orderByComparator);
	}

	/**
	* Returns the sal detailses before and after the current sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param SalDetailsId the primary key of the current sal details
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sal details
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public static SalDetails[] findByemployeeIdAndComponentIdmonthYears_PrevAndNext(
		long SalDetailsId, long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndComponentIdmonthYears_PrevAndNext(SalDetailsId,
			employeeId, componentId, monthYear, orderByComparator);
	}

	/**
	* Returns all the sal detailses where employeeId = &#63; and componentId = any &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentIds the component IDs
	* @param monthYears the month years
	* @return the matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentIds, monthYears);
	}

	/**
	* Returns a range of all the sal detailses where employeeId = &#63; and componentId = any &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentIds the component IDs
	* @param monthYears the month years
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears, int start,
		int end) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentIds, monthYears, start, end);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = any &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentIds the component IDs
	* @param monthYears the month years
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears, int start,
		int end, OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentIds, monthYears, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears, int start,
		int end, OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentIds, monthYears, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Removes all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	*/
	public static void removeByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear) {
		getPersistence()
			.removeByemployeeIdAndComponentIdmonthYears(employeeId,
			componentId, monthYear);
	}

	/**
	* Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the number of matching sal detailses
	*/
	public static int countByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear) {
		return getPersistence()
				   .countByemployeeIdAndComponentIdmonthYears(employeeId,
			componentId, monthYear);
	}

	/**
	* Returns the number of sal detailses where employeeId = &#63; and componentId = any &#63; and monthYear = any &#63;.
	*
	* @param employeeId the employee ID
	* @param componentIds the component IDs
	* @param monthYears the month years
	* @return the number of matching sal detailses
	*/
	public static int countByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears) {
		return getPersistence()
				   .countByemployeeIdAndComponentIdmonthYears(employeeId,
			componentIds, monthYears);
	}

	/**
	* Returns all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @return the matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId) {
		return getPersistence()
				   .findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentId);
	}

	/**
	* Returns a range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId, int start, int end) {
		return getPersistence()
				   .findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentId, start, end);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findByemployeeIdAndMonthYearAndComponentId_First(
		long employeeId, long monthYear, long componentId,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndMonthYearAndComponentId_First(employeeId,
			monthYear, componentId, orderByComparator);
	}

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeIdAndMonthYearAndComponentId_First(
		long employeeId, long monthYear, long componentId,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAndMonthYearAndComponentId_First(employeeId,
			monthYear, componentId, orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findByemployeeIdAndMonthYearAndComponentId_Last(
		long employeeId, long monthYear, long componentId,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndMonthYearAndComponentId_Last(employeeId,
			monthYear, componentId, orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeIdAndMonthYearAndComponentId_Last(
		long employeeId, long monthYear, long componentId,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAndMonthYearAndComponentId_Last(employeeId,
			monthYear, componentId, orderByComparator);
	}

	/**
	* Returns the sal detailses before and after the current sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* @param SalDetailsId the primary key of the current sal details
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sal details
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public static SalDetails[] findByemployeeIdAndMonthYearAndComponentId_PrevAndNext(
		long SalDetailsId, long employeeId, long monthYear, long componentId,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndMonthYearAndComponentId_PrevAndNext(SalDetailsId,
			employeeId, monthYear, componentId, orderByComparator);
	}

	/**
	* Returns all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentIds the component IDs
	* @return the matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds) {
		return getPersistence()
				   .findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentIds);
	}

	/**
	* Returns a range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentIds the component IDs
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds, int start, int end) {
		return getPersistence()
				   .findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentIds, start, end);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentIds the component IDs
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds, int start,
		int end, OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentIds, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds, int start,
		int end, OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentIds, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Removes all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	*/
	public static void removeByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId) {
		getPersistence()
			.removeByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentId);
	}

	/**
	* Returns the number of sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @return the number of matching sal detailses
	*/
	public static int countByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId) {
		return getPersistence()
				   .countByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentId);
	}

	/**
	* Returns the number of sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = any &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentIds the component IDs
	* @return the number of matching sal detailses
	*/
	public static int countByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds) {
		return getPersistence()
				   .countByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentIds);
	}

	/**
	* Returns the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; or throws a {@link NoSuchSalDetailsException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYear(employeeId,
			componentId, monthYear);
	}

	/**
	* Returns the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear) {
		return getPersistence()
				   .fetchByemployeeIdAndComponentIdAndMonthYear(employeeId,
			componentId, monthYear);
	}

	/**
	* Returns the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByemployeeIdAndComponentIdAndMonthYear(employeeId,
			componentId, monthYear, retrieveFromCache);
	}

	/**
	* Removes the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the sal details that was removed
	*/
	public static SalDetails removeByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .removeByemployeeIdAndComponentIdAndMonthYear(employeeId,
			componentId, monthYear);
	}

	/**
	* Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the number of matching sal detailses
	*/
	public static int countByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear) {
		return getPersistence()
				   .countByemployeeIdAndComponentIdAndMonthYear(employeeId,
			componentId, monthYear);
	}

	/**
	* Returns all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYear);
	}

	/**
	* Returns a range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear, int start, int end) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYear, start, end);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYear, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYear, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findByemployeeIdAndComponentIdAndMonthYears_First(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYears_First(employeeId,
			componentId, monthYear, orderByComparator);
	}

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeIdAndComponentIdAndMonthYears_First(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAndComponentIdAndMonthYears_First(employeeId,
			componentId, monthYear, orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public static SalDetails findByemployeeIdAndComponentIdAndMonthYears_Last(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYears_Last(employeeId,
			componentId, monthYear, orderByComparator);
	}

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public static SalDetails fetchByemployeeIdAndComponentIdAndMonthYears_Last(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAndComponentIdAndMonthYears_Last(employeeId,
			componentId, monthYear, orderByComparator);
	}

	/**
	* Returns the sal detailses before and after the current sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param SalDetailsId the primary key of the current sal details
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sal details
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public static SalDetails[] findByemployeeIdAndComponentIdAndMonthYears_PrevAndNext(
		long SalDetailsId, long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYears_PrevAndNext(SalDetailsId,
			employeeId, componentId, monthYear, orderByComparator);
	}

	/**
	* Returns all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYears the month years
	* @return the matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYears);
	}

	/**
	* Returns a range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYears the month years
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears, int start, int end) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYears, start, end);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYears the month years
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears, int start,
		int end, OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYears, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sal detailses
	*/
	public static List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears, int start,
		int end, OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYears, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Removes all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	*/
	public static void removeByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear) {
		getPersistence()
			.removeByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYear);
	}

	/**
	* Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the number of matching sal detailses
	*/
	public static int countByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear) {
		return getPersistence()
				   .countByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYear);
	}

	/**
	* Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = any &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYears the month years
	* @return the number of matching sal detailses
	*/
	public static int countByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears) {
		return getPersistence()
				   .countByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYears);
	}

	/**
	* Caches the sal details in the entity cache if it is enabled.
	*
	* @param salDetails the sal details
	*/
	public static void cacheResult(SalDetails salDetails) {
		getPersistence().cacheResult(salDetails);
	}

	/**
	* Caches the sal detailses in the entity cache if it is enabled.
	*
	* @param salDetailses the sal detailses
	*/
	public static void cacheResult(List<SalDetails> salDetailses) {
		getPersistence().cacheResult(salDetailses);
	}

	/**
	* Creates a new sal details with the primary key. Does not add the sal details to the database.
	*
	* @param SalDetailsId the primary key for the new sal details
	* @return the new sal details
	*/
	public static SalDetails create(long SalDetailsId) {
		return getPersistence().create(SalDetailsId);
	}

	/**
	* Removes the sal details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SalDetailsId the primary key of the sal details
	* @return the sal details that was removed
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public static SalDetails remove(long SalDetailsId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence().remove(SalDetailsId);
	}

	public static SalDetails updateImpl(SalDetails salDetails) {
		return getPersistence().updateImpl(salDetails);
	}

	/**
	* Returns the sal details with the primary key or throws a {@link NoSuchSalDetailsException} if it could not be found.
	*
	* @param SalDetailsId the primary key of the sal details
	* @return the sal details
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public static SalDetails findByPrimaryKey(long SalDetailsId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getPersistence().findByPrimaryKey(SalDetailsId);
	}

	/**
	* Returns the sal details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SalDetailsId the primary key of the sal details
	* @return the sal details, or <code>null</code> if a sal details with the primary key could not be found
	*/
	public static SalDetails fetchByPrimaryKey(long SalDetailsId) {
		return getPersistence().fetchByPrimaryKey(SalDetailsId);
	}

	public static java.util.Map<java.io.Serializable, SalDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the sal detailses.
	*
	* @return the sal detailses
	*/
	public static List<SalDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of sal detailses
	*/
	public static List<SalDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sal detailses
	*/
	public static List<SalDetails> findAll(int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of sal detailses
	*/
	public static List<SalDetails> findAll(int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the sal detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sal detailses.
	*
	* @return the number of sal detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SalDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SalDetailsPersistence, SalDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SalDetailsPersistence.class);

		ServiceTracker<SalDetailsPersistence, SalDetailsPersistence> serviceTracker =
			new ServiceTracker<SalDetailsPersistence, SalDetailsPersistence>(bundle.getBundleContext(),
				SalDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}