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

import com.liferay.famocom.erpcloud.exception.NoSuchMonthlyAdjustmentException;
import com.liferay.famocom.erpcloud.model.MonthlyAdjustment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the monthly adjustment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.MonthlyAdjustmentPersistenceImpl
 * @see MonthlyAdjustmentUtil
 * @generated
 */
@ProviderType
public interface MonthlyAdjustmentPersistence extends BasePersistence<MonthlyAdjustment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MonthlyAdjustmentUtil} to access the monthly adjustment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the monthly adjustments where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching monthly adjustments
	*/
	public java.util.List<MonthlyAdjustment> findByemployeeId(long employeeId);

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
	public java.util.List<MonthlyAdjustment> findByemployeeId(long employeeId,
		int start, int end);

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
	public java.util.List<MonthlyAdjustment> findByemployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator);

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
	public java.util.List<MonthlyAdjustment> findByemployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first monthly adjustment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment findByemployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Returns the first monthly adjustment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment fetchByemployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator);

	/**
	* Returns the last monthly adjustment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment findByemployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Returns the last monthly adjustment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment fetchByemployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator);

	/**
	* Returns the monthly adjustments before and after the current monthly adjustment in the ordered set where employeeId = &#63;.
	*
	* @param monthlyAdjustmentId the primary key of the current monthly adjustment
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	*/
	public MonthlyAdjustment[] findByemployeeId_PrevAndNext(
		long monthlyAdjustmentId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Removes all the monthly adjustments where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeByemployeeId(long employeeId);

	/**
	* Returns the number of monthly adjustments where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching monthly adjustments
	*/
	public int countByemployeeId(long employeeId);

	/**
	* Returns all the monthly adjustments where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the matching monthly adjustments
	*/
	public java.util.List<MonthlyAdjustment> findBymonthYear(long monthYear);

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
	public java.util.List<MonthlyAdjustment> findBymonthYear(long monthYear,
		int start, int end);

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
	public java.util.List<MonthlyAdjustment> findBymonthYear(long monthYear,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator);

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
	public java.util.List<MonthlyAdjustment> findBymonthYear(long monthYear,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first monthly adjustment in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment findBymonthYear_First(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Returns the first monthly adjustment in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment fetchBymonthYear_First(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator);

	/**
	* Returns the last monthly adjustment in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment findBymonthYear_Last(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Returns the last monthly adjustment in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment fetchBymonthYear_Last(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator);

	/**
	* Returns the monthly adjustments before and after the current monthly adjustment in the ordered set where monthYear = &#63;.
	*
	* @param monthlyAdjustmentId the primary key of the current monthly adjustment
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	*/
	public MonthlyAdjustment[] findBymonthYear_PrevAndNext(
		long monthlyAdjustmentId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Removes all the monthly adjustments where monthYear = &#63; from the database.
	*
	* @param monthYear the month year
	*/
	public void removeBymonthYear(long monthYear);

	/**
	* Returns the number of monthly adjustments where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the number of matching monthly adjustments
	*/
	public int countBymonthYear(long monthYear);

	/**
	* Returns all the monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the matching monthly adjustments
	*/
	public java.util.List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId);

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
	public java.util.List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end);

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
	public java.util.List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator);

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
	public java.util.List<MonthlyAdjustment> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment findBymonthYearAndemployeeId_First(
		long monthYear, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Returns the first monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment fetchBymonthYearAndemployeeId_First(
		long monthYear, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator);

	/**
	* Returns the last monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment findBymonthYearAndemployeeId_Last(long monthYear,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Returns the last monthly adjustment in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment fetchBymonthYearAndemployeeId_Last(
		long monthYear, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator);

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
	public MonthlyAdjustment[] findBymonthYearAndemployeeId_PrevAndNext(
		long monthlyAdjustmentId, long monthYear, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Removes all the monthly adjustments where monthYear = &#63; and employeeId = &#63; from the database.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	*/
	public void removeBymonthYearAndemployeeId(long monthYear, long employeeId);

	/**
	* Returns the number of monthly adjustments where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the number of matching monthly adjustments
	*/
	public int countBymonthYearAndemployeeId(long monthYear, long employeeId);

	/**
	* Returns the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; or throws a {@link NoSuchMonthlyAdjustmentException} if it could not be found.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the matching monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment findBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Returns the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment fetchBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId);

	/**
	* Returns the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching monthly adjustment, or <code>null</code> if a matching monthly adjustment could not be found
	*/
	public MonthlyAdjustment fetchBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId,
		boolean retrieveFromCache);

	/**
	* Removes the monthly adjustment where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63; from the database.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the monthly adjustment that was removed
	*/
	public MonthlyAdjustment removeBymonthYearAndemployeeIdAndpayComponentId(
		long monthYear, long employeeId, long payComponentId)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Returns the number of monthly adjustments where monthYear = &#63; and employeeId = &#63; and payComponentId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the number of matching monthly adjustments
	*/
	public int countBymonthYearAndemployeeIdAndpayComponentId(long monthYear,
		long employeeId, long payComponentId);

	/**
	* Caches the monthly adjustment in the entity cache if it is enabled.
	*
	* @param monthlyAdjustment the monthly adjustment
	*/
	public void cacheResult(MonthlyAdjustment monthlyAdjustment);

	/**
	* Caches the monthly adjustments in the entity cache if it is enabled.
	*
	* @param monthlyAdjustments the monthly adjustments
	*/
	public void cacheResult(
		java.util.List<MonthlyAdjustment> monthlyAdjustments);

	/**
	* Creates a new monthly adjustment with the primary key. Does not add the monthly adjustment to the database.
	*
	* @param monthlyAdjustmentId the primary key for the new monthly adjustment
	* @return the new monthly adjustment
	*/
	public MonthlyAdjustment create(long monthlyAdjustmentId);

	/**
	* Removes the monthly adjustment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param monthlyAdjustmentId the primary key of the monthly adjustment
	* @return the monthly adjustment that was removed
	* @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	*/
	public MonthlyAdjustment remove(long monthlyAdjustmentId)
		throws NoSuchMonthlyAdjustmentException;

	public MonthlyAdjustment updateImpl(MonthlyAdjustment monthlyAdjustment);

	/**
	* Returns the monthly adjustment with the primary key or throws a {@link NoSuchMonthlyAdjustmentException} if it could not be found.
	*
	* @param monthlyAdjustmentId the primary key of the monthly adjustment
	* @return the monthly adjustment
	* @throws NoSuchMonthlyAdjustmentException if a monthly adjustment with the primary key could not be found
	*/
	public MonthlyAdjustment findByPrimaryKey(long monthlyAdjustmentId)
		throws NoSuchMonthlyAdjustmentException;

	/**
	* Returns the monthly adjustment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param monthlyAdjustmentId the primary key of the monthly adjustment
	* @return the monthly adjustment, or <code>null</code> if a monthly adjustment with the primary key could not be found
	*/
	public MonthlyAdjustment fetchByPrimaryKey(long monthlyAdjustmentId);

	@Override
	public java.util.Map<java.io.Serializable, MonthlyAdjustment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the monthly adjustments.
	*
	* @return the monthly adjustments
	*/
	public java.util.List<MonthlyAdjustment> findAll();

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
	public java.util.List<MonthlyAdjustment> findAll(int start, int end);

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
	public java.util.List<MonthlyAdjustment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator);

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
	public java.util.List<MonthlyAdjustment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyAdjustment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the monthly adjustments from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of monthly adjustments.
	*
	* @return the number of monthly adjustments
	*/
	public int countAll();
}