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

import com.liferay.famocom.erpcloud.exception.NoSuchStopPayException;
import com.liferay.famocom.erpcloud.model.StopPay;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the stop pay service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.StopPayPersistenceImpl
 * @see StopPayUtil
 * @generated
 */
@ProviderType
public interface StopPayPersistence extends BasePersistence<StopPay> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StopPayUtil} to access the stop pay persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the stop paies where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching stop paies
	*/
	public java.util.List<StopPay> findByemployeeId(long employeeId);

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
	public java.util.List<StopPay> findByemployeeId(long employeeId, int start,
		int end);

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
	public java.util.List<StopPay> findByemployeeId(long employeeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator);

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
	public java.util.List<StopPay> findByemployeeId(long employeeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first stop pay in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public StopPay findByemployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException;

	/**
	* Returns the first stop pay in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public StopPay fetchByemployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator);

	/**
	* Returns the last stop pay in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public StopPay findByemployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException;

	/**
	* Returns the last stop pay in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public StopPay fetchByemployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator);

	/**
	* Returns the stop paies before and after the current stop pay in the ordered set where employeeId = &#63;.
	*
	* @param stopPayId the primary key of the current stop pay
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stop pay
	* @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	*/
	public StopPay[] findByemployeeId_PrevAndNext(long stopPayId,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException;

	/**
	* Removes all the stop paies where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeByemployeeId(long employeeId);

	/**
	* Returns the number of stop paies where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching stop paies
	*/
	public int countByemployeeId(long employeeId);

	/**
	* Returns all the stop paies where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @return the matching stop paies
	*/
	public java.util.List<StopPay> findByMonthYearAndStatus(long monthYear,
		long status);

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
	public java.util.List<StopPay> findByMonthYearAndStatus(long monthYear,
		long status, int start, int end);

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
	public java.util.List<StopPay> findByMonthYearAndStatus(long monthYear,
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator);

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
	public java.util.List<StopPay> findByMonthYearAndStatus(long monthYear,
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public StopPay findByMonthYearAndStatus_First(long monthYear, long status,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException;

	/**
	* Returns the first stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public StopPay fetchByMonthYearAndStatus_First(long monthYear, long status,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator);

	/**
	* Returns the last stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public StopPay findByMonthYearAndStatus_Last(long monthYear, long status,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException;

	/**
	* Returns the last stop pay in the ordered set where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public StopPay fetchByMonthYearAndStatus_Last(long monthYear, long status,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator);

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
	public StopPay[] findByMonthYearAndStatus_PrevAndNext(long stopPayId,
		long monthYear, long status,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException;

	/**
	* Removes all the stop paies where monthYear = &#63; and status = &#63; from the database.
	*
	* @param monthYear the month year
	* @param status the status
	*/
	public void removeByMonthYearAndStatus(long monthYear, long status);

	/**
	* Returns the number of stop paies where monthYear = &#63; and status = &#63;.
	*
	* @param monthYear the month year
	* @param status the status
	* @return the number of matching stop paies
	*/
	public int countByMonthYearAndStatus(long monthYear, long status);

	/**
	* Returns all the stop paies where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the matching stop paies
	*/
	public java.util.List<StopPay> findBymonthYear(long monthYear);

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
	public java.util.List<StopPay> findBymonthYear(long monthYear, int start,
		int end);

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
	public java.util.List<StopPay> findBymonthYear(long monthYear, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator);

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
	public java.util.List<StopPay> findBymonthYear(long monthYear, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first stop pay in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public StopPay findBymonthYear_First(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException;

	/**
	* Returns the first stop pay in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public StopPay fetchBymonthYear_First(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator);

	/**
	* Returns the last stop pay in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public StopPay findBymonthYear_Last(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException;

	/**
	* Returns the last stop pay in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public StopPay fetchBymonthYear_Last(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator);

	/**
	* Returns the stop paies before and after the current stop pay in the ordered set where monthYear = &#63;.
	*
	* @param stopPayId the primary key of the current stop pay
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stop pay
	* @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	*/
	public StopPay[] findBymonthYear_PrevAndNext(long stopPayId,
		long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator)
		throws NoSuchStopPayException;

	/**
	* Removes all the stop paies where monthYear = &#63; from the database.
	*
	* @param monthYear the month year
	*/
	public void removeBymonthYear(long monthYear);

	/**
	* Returns the number of stop paies where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the number of matching stop paies
	*/
	public int countBymonthYear(long monthYear);

	/**
	* Returns the stop pay where employeeId = &#63; and monthYear = &#63; or throws a {@link NoSuchStopPayException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the matching stop pay
	* @throws NoSuchStopPayException if a matching stop pay could not be found
	*/
	public StopPay findByemployeeIdAndMonthYear(long employeeId, long monthYear)
		throws NoSuchStopPayException;

	/**
	* Returns the stop pay where employeeId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public StopPay fetchByemployeeIdAndMonthYear(long employeeId, long monthYear);

	/**
	* Returns the stop pay where employeeId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching stop pay, or <code>null</code> if a matching stop pay could not be found
	*/
	public StopPay fetchByemployeeIdAndMonthYear(long employeeId,
		long monthYear, boolean retrieveFromCache);

	/**
	* Removes the stop pay where employeeId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the stop pay that was removed
	*/
	public StopPay removeByemployeeIdAndMonthYear(long employeeId,
		long monthYear) throws NoSuchStopPayException;

	/**
	* Returns the number of stop paies where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the number of matching stop paies
	*/
	public int countByemployeeIdAndMonthYear(long employeeId, long monthYear);

	/**
	* Caches the stop pay in the entity cache if it is enabled.
	*
	* @param stopPay the stop pay
	*/
	public void cacheResult(StopPay stopPay);

	/**
	* Caches the stop paies in the entity cache if it is enabled.
	*
	* @param stopPaies the stop paies
	*/
	public void cacheResult(java.util.List<StopPay> stopPaies);

	/**
	* Creates a new stop pay with the primary key. Does not add the stop pay to the database.
	*
	* @param stopPayId the primary key for the new stop pay
	* @return the new stop pay
	*/
	public StopPay create(long stopPayId);

	/**
	* Removes the stop pay with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stopPayId the primary key of the stop pay
	* @return the stop pay that was removed
	* @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	*/
	public StopPay remove(long stopPayId) throws NoSuchStopPayException;

	public StopPay updateImpl(StopPay stopPay);

	/**
	* Returns the stop pay with the primary key or throws a {@link NoSuchStopPayException} if it could not be found.
	*
	* @param stopPayId the primary key of the stop pay
	* @return the stop pay
	* @throws NoSuchStopPayException if a stop pay with the primary key could not be found
	*/
	public StopPay findByPrimaryKey(long stopPayId)
		throws NoSuchStopPayException;

	/**
	* Returns the stop pay with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stopPayId the primary key of the stop pay
	* @return the stop pay, or <code>null</code> if a stop pay with the primary key could not be found
	*/
	public StopPay fetchByPrimaryKey(long stopPayId);

	@Override
	public java.util.Map<java.io.Serializable, StopPay> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the stop paies.
	*
	* @return the stop paies
	*/
	public java.util.List<StopPay> findAll();

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
	public java.util.List<StopPay> findAll(int start, int end);

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
	public java.util.List<StopPay> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator);

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
	public java.util.List<StopPay> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StopPay> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the stop paies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of stop paies.
	*
	* @return the number of stop paies
	*/
	public int countAll();
}