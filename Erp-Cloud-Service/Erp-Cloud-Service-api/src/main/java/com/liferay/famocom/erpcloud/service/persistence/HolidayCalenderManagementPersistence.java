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

import com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException;
import com.liferay.famocom.erpcloud.model.HolidayCalenderManagement;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the holiday calender management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.HolidayCalenderManagementPersistenceImpl
 * @see HolidayCalenderManagementUtil
 * @generated
 */
@ProviderType
public interface HolidayCalenderManagementPersistence extends BasePersistence<HolidayCalenderManagement> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HolidayCalenderManagementUtil} to access the holiday calender management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the holiday calender management where holidayDate = &#63; or throws a {@link NoSuchHolidayCalenderManagementException} if it could not be found.
	*
	* @param holidayDate the holiday date
	* @return the matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement findByempIdAndAttDate(Date holidayDate)
		throws NoSuchHolidayCalenderManagementException;

	/**
	* Returns the holiday calender management where holidayDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param holidayDate the holiday date
	* @return the matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement fetchByempIdAndAttDate(Date holidayDate);

	/**
	* Returns the holiday calender management where holidayDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param holidayDate the holiday date
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement fetchByempIdAndAttDate(Date holidayDate,
		boolean retrieveFromCache);

	/**
	* Removes the holiday calender management where holidayDate = &#63; from the database.
	*
	* @param holidayDate the holiday date
	* @return the holiday calender management that was removed
	*/
	public HolidayCalenderManagement removeByempIdAndAttDate(Date holidayDate)
		throws NoSuchHolidayCalenderManagementException;

	/**
	* Returns the number of holiday calender managements where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @return the number of matching holiday calender managements
	*/
	public int countByempIdAndAttDate(Date holidayDate);

	/**
	* Returns all the holiday calender managements where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @return the matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findByholiDayCheck(
		Date holidayDate);

	/**
	* Returns a range of all the holiday calender managements where holidayDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @return the range of matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findByholiDayCheck(
		Date holidayDate, int start, int end);

	/**
	* Returns an ordered range of all the holiday calender managements where holidayDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findByholiDayCheck(
		Date holidayDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator);

	/**
	* Returns an ordered range of all the holiday calender managements where holidayDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findByholiDayCheck(
		Date holidayDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first holiday calender management in the ordered set where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement findByholiDayCheck_First(
		Date holidayDate,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException;

	/**
	* Returns the first holiday calender management in the ordered set where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement fetchByholiDayCheck_First(
		Date holidayDate,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator);

	/**
	* Returns the last holiday calender management in the ordered set where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement findByholiDayCheck_Last(Date holidayDate,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException;

	/**
	* Returns the last holiday calender management in the ordered set where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement fetchByholiDayCheck_Last(
		Date holidayDate,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator);

	/**
	* Returns the holiday calender managements before and after the current holiday calender management in the ordered set where holidayDate = &#63;.
	*
	* @param holidayId the primary key of the current holiday calender management
	* @param holidayDate the holiday date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a holiday calender management with the primary key could not be found
	*/
	public HolidayCalenderManagement[] findByholiDayCheck_PrevAndNext(
		long holidayId, Date holidayDate,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException;

	/**
	* Removes all the holiday calender managements where holidayDate = &#63; from the database.
	*
	* @param holidayDate the holiday date
	*/
	public void removeByholiDayCheck(Date holidayDate);

	/**
	* Returns the number of holiday calender managements where holidayDate = &#63;.
	*
	* @param holidayDate the holiday date
	* @return the number of matching holiday calender managements
	*/
	public int countByholiDayCheck(Date holidayDate);

	/**
	* Returns all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @return the matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId);

	/**
	* Returns a range of all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @return the range of matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId, int start, int end);

	/**
	* Returns an ordered range of all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator);

	/**
	* Returns an ordered range of all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement findBynameAndHoliDayId_First(
		String holidayName, long holidayId,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException;

	/**
	* Returns the first holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement fetchBynameAndHoliDayId_First(
		String holidayName, long holidayId,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator);

	/**
	* Returns the last holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement findBynameAndHoliDayId_Last(
		String holidayName, long holidayId,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException;

	/**
	* Returns the last holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement fetchBynameAndHoliDayId_Last(
		String holidayName, long holidayId,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator);

	/**
	* Removes all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63; from the database.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	*/
	public void removeBynameAndHoliDayId(String holidayName, long holidayId);

	/**
	* Returns the number of holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayName the holiday name
	* @param holidayId the holiday ID
	* @return the number of matching holiday calender managements
	*/
	public int countBynameAndHoliDayId(String holidayName, long holidayId);

	/**
	* Returns all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @return the matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId);

	/**
	* Returns a range of all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @return the range of matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId, int start, int end);

	/**
	* Returns an ordered range of all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator);

	/**
	* Returns an ordered range of all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement findBydateAndHoliDayId_First(
		Date holidayDate, long holidayId,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException;

	/**
	* Returns the first holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement fetchBydateAndHoliDayId_First(
		Date holidayDate, long holidayId,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator);

	/**
	* Returns the last holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement findBydateAndHoliDayId_Last(
		Date holidayDate, long holidayId,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException;

	/**
	* Returns the last holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	*/
	public HolidayCalenderManagement fetchBydateAndHoliDayId_Last(
		Date holidayDate, long holidayId,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator);

	/**
	* Removes all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63; from the database.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	*/
	public void removeBydateAndHoliDayId(Date holidayDate, long holidayId);

	/**
	* Returns the number of holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	*
	* @param holidayDate the holiday date
	* @param holidayId the holiday ID
	* @return the number of matching holiday calender managements
	*/
	public int countBydateAndHoliDayId(Date holidayDate, long holidayId);

	/**
	* Caches the holiday calender management in the entity cache if it is enabled.
	*
	* @param holidayCalenderManagement the holiday calender management
	*/
	public void cacheResult(HolidayCalenderManagement holidayCalenderManagement);

	/**
	* Caches the holiday calender managements in the entity cache if it is enabled.
	*
	* @param holidayCalenderManagements the holiday calender managements
	*/
	public void cacheResult(
		java.util.List<HolidayCalenderManagement> holidayCalenderManagements);

	/**
	* Creates a new holiday calender management with the primary key. Does not add the holiday calender management to the database.
	*
	* @param holidayId the primary key for the new holiday calender management
	* @return the new holiday calender management
	*/
	public HolidayCalenderManagement create(long holidayId);

	/**
	* Removes the holiday calender management with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param holidayId the primary key of the holiday calender management
	* @return the holiday calender management that was removed
	* @throws NoSuchHolidayCalenderManagementException if a holiday calender management with the primary key could not be found
	*/
	public HolidayCalenderManagement remove(long holidayId)
		throws NoSuchHolidayCalenderManagementException;

	public HolidayCalenderManagement updateImpl(
		HolidayCalenderManagement holidayCalenderManagement);

	/**
	* Returns the holiday calender management with the primary key or throws a {@link NoSuchHolidayCalenderManagementException} if it could not be found.
	*
	* @param holidayId the primary key of the holiday calender management
	* @return the holiday calender management
	* @throws NoSuchHolidayCalenderManagementException if a holiday calender management with the primary key could not be found
	*/
	public HolidayCalenderManagement findByPrimaryKey(long holidayId)
		throws NoSuchHolidayCalenderManagementException;

	/**
	* Returns the holiday calender management with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param holidayId the primary key of the holiday calender management
	* @return the holiday calender management, or <code>null</code> if a holiday calender management with the primary key could not be found
	*/
	public HolidayCalenderManagement fetchByPrimaryKey(long holidayId);

	@Override
	public java.util.Map<java.io.Serializable, HolidayCalenderManagement> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the holiday calender managements.
	*
	* @return the holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findAll();

	/**
	* Returns a range of all the holiday calender managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @return the range of holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findAll(int start, int end);

	/**
	* Returns an ordered range of all the holiday calender managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator);

	/**
	* Returns an ordered range of all the holiday calender managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of holiday calender managements
	* @param end the upper bound of the range of holiday calender managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of holiday calender managements
	*/
	public java.util.List<HolidayCalenderManagement> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the holiday calender managements from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of holiday calender managements.
	*
	* @return the number of holiday calender managements
	*/
	public int countAll();
}