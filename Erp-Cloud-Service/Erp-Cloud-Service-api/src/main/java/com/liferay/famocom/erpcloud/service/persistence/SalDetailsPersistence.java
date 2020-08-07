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

import com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException;
import com.liferay.famocom.erpcloud.model.SalDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the sal details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.SalDetailsPersistenceImpl
 * @see SalDetailsUtil
 * @generated
 */
@ProviderType
public interface SalDetailsPersistence extends BasePersistence<SalDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalDetailsUtil} to access the sal details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the sal detailses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching sal detailses
	*/
	public java.util.List<SalDetails> findByemployeeId(long employeeId);

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
	public java.util.List<SalDetails> findByemployeeId(long employeeId,
		int start, int end);

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
	public java.util.List<SalDetails> findByemployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findByemployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public SalDetails findByemployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public SalDetails findByemployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

	/**
	* Returns the sal detailses before and after the current sal details in the ordered set where employeeId = &#63;.
	*
	* @param SalDetailsId the primary key of the current sal details
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sal details
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public SalDetails[] findByemployeeId_PrevAndNext(long SalDetailsId,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Removes all the sal detailses where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeByemployeeId(long employeeId);

	/**
	* Returns the number of sal detailses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching sal detailses
	*/
	public int countByemployeeId(long employeeId);

	/**
	* Returns all the sal detailses where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the matching sal detailses
	*/
	public java.util.List<SalDetails> findBymonthYear(long monthYear);

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
	public java.util.List<SalDetails> findBymonthYear(long monthYear,
		int start, int end);

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
	public java.util.List<SalDetails> findBymonthYear(long monthYear,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findBymonthYear(long monthYear,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sal details in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public SalDetails findBymonthYear_First(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the first sal details in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchBymonthYear_First(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

	/**
	* Returns the last sal details in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public SalDetails findBymonthYear_Last(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the last sal details in the ordered set where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchBymonthYear_Last(long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

	/**
	* Returns the sal detailses before and after the current sal details in the ordered set where monthYear = &#63;.
	*
	* @param SalDetailsId the primary key of the current sal details
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sal details
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public SalDetails[] findBymonthYear_PrevAndNext(long SalDetailsId,
		long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Removes all the sal detailses where monthYear = &#63; from the database.
	*
	* @param monthYear the month year
	*/
	public void removeBymonthYear(long monthYear);

	/**
	* Returns the number of sal detailses where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the number of matching sal detailses
	*/
	public int countBymonthYear(long monthYear);

	/**
	* Returns all the sal detailses where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the matching sal detailses
	*/
	public java.util.List<SalDetails> findBymonthYearAndemployeeId(
		long monthYear, long employeeId);

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
	public java.util.List<SalDetails> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end);

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
	public java.util.List<SalDetails> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findBymonthYearAndemployeeId(
		long monthYear, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public SalDetails findBymonthYearAndemployeeId_First(long monthYear,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the first sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchBymonthYearAndemployeeId_First(long monthYear,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

	/**
	* Returns the last sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public SalDetails findBymonthYearAndemployeeId_Last(long monthYear,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the last sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchBymonthYearAndemployeeId_Last(long monthYear,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public SalDetails[] findBymonthYearAndemployeeId_PrevAndNext(
		long SalDetailsId, long monthYear, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Removes all the sal detailses where monthYear = &#63; and employeeId = &#63; from the database.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	*/
	public void removeBymonthYearAndemployeeId(long monthYear, long employeeId);

	/**
	* Returns the number of sal detailses where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the number of matching sal detailses
	*/
	public int countBymonthYearAndemployeeId(long monthYear, long employeeId);

	/**
	* Returns all the sal detailses where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the matching sal detailses
	*/
	public java.util.List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public SalDetails findByemployeeIdAndMonthYear_First(long employeeId,
		long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeIdAndMonthYear_First(long employeeId,
		long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public SalDetails findByemployeeIdAndMonthYear_Last(long employeeId,
		long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeIdAndMonthYear_Last(long employeeId,
		long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public SalDetails[] findByemployeeIdAndMonthYear_PrevAndNext(
		long SalDetailsId, long employeeId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the sal detailses where employeeId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	*/
	public void removeByemployeeIdAndMonthYear(long employeeId, long monthYear);

	/**
	* Returns the number of sal detailses where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the number of matching sal detailses
	*/
	public int countByemployeeIdAndMonthYear(long employeeId, long monthYear);

	/**
	* Returns the number of sal detailses where employeeId = &#63; and monthYear = any &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYears the month years
	* @return the number of matching sal detailses
	*/
	public int countByemployeeIdAndMonthYear(long employeeId, long[] monthYears);

	/**
	* Returns all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the matching sal detailses
	*/
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear, int start, int end);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

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
	public SalDetails findByemployeeIdAndComponentIdmonthYears_First(
		long employeeId, long componentId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeIdAndComponentIdmonthYears_First(
		long employeeId, long componentId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public SalDetails findByemployeeIdAndComponentIdmonthYears_Last(
		long employeeId, long componentId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeIdAndComponentIdmonthYears_Last(
		long employeeId, long componentId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public SalDetails[] findByemployeeIdAndComponentIdmonthYears_PrevAndNext(
		long SalDetailsId, long employeeId, long componentId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears, int start,
		int end);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	*/
	public void removeByemployeeIdAndComponentIdmonthYears(long employeeId,
		long componentId, long monthYear);

	/**
	* Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the number of matching sal detailses
	*/
	public int countByemployeeIdAndComponentIdmonthYears(long employeeId,
		long componentId, long monthYear);

	/**
	* Returns the number of sal detailses where employeeId = &#63; and componentId = any &#63; and monthYear = any &#63;.
	*
	* @param employeeId the employee ID
	* @param componentIds the component IDs
	* @param monthYears the month years
	* @return the number of matching sal detailses
	*/
	public int countByemployeeIdAndComponentIdmonthYears(long employeeId,
		long[] componentIds, long[] monthYears);

	/**
	* Returns all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @return the matching sal detailses
	*/
	public java.util.List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId, int start, int end);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

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
	public SalDetails findByemployeeIdAndMonthYearAndComponentId_First(
		long employeeId, long monthYear, long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeIdAndMonthYearAndComponentId_First(
		long employeeId, long monthYear, long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public SalDetails findByemployeeIdAndMonthYearAndComponentId_Last(
		long employeeId, long monthYear, long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeIdAndMonthYearAndComponentId_Last(
		long employeeId, long monthYear, long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public SalDetails[] findByemployeeIdAndMonthYearAndComponentId_PrevAndNext(
		long SalDetailsId, long employeeId, long monthYear, long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds, int start, int end);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	*/
	public void removeByemployeeIdAndMonthYearAndComponentId(long employeeId,
		long monthYear, long componentId);

	/**
	* Returns the number of sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentId the component ID
	* @return the number of matching sal detailses
	*/
	public int countByemployeeIdAndMonthYearAndComponentId(long employeeId,
		long monthYear, long componentId);

	/**
	* Returns the number of sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = any &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param componentIds the component IDs
	* @return the number of matching sal detailses
	*/
	public int countByemployeeIdAndMonthYearAndComponentId(long employeeId,
		long monthYear, long[] componentIds);

	/**
	* Returns the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; or throws a {@link NoSuchSalDetailsException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the matching sal details
	* @throws NoSuchSalDetailsException if a matching sal details could not be found
	*/
	public SalDetails findByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear)
		throws NoSuchSalDetailsException;

	/**
	* Returns the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear);

	/**
	* Returns the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear,
		boolean retrieveFromCache);

	/**
	* Removes the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the sal details that was removed
	*/
	public SalDetails removeByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear)
		throws NoSuchSalDetailsException;

	/**
	* Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the number of matching sal detailses
	*/
	public int countByemployeeIdAndComponentIdAndMonthYear(long employeeId,
		long componentId, long monthYear);

	/**
	* Returns all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the matching sal detailses
	*/
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear, int start, int end);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

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
	public SalDetails findByemployeeIdAndComponentIdAndMonthYears_First(
		long employeeId, long componentId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the first sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeIdAndComponentIdAndMonthYears_First(
		long employeeId, long componentId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public SalDetails findByemployeeIdAndComponentIdAndMonthYears_Last(
		long employeeId, long componentId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

	/**
	* Returns the last sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	*/
	public SalDetails fetchByemployeeIdAndComponentIdAndMonthYears_Last(
		long employeeId, long componentId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public SalDetails[] findByemployeeIdAndComponentIdAndMonthYears_PrevAndNext(
		long SalDetailsId, long employeeId, long componentId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException;

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears, int start, int end);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	*/
	public void removeByemployeeIdAndComponentIdAndMonthYears(long employeeId,
		long componentId, long monthYear);

	/**
	* Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYear the month year
	* @return the number of matching sal detailses
	*/
	public int countByemployeeIdAndComponentIdAndMonthYears(long employeeId,
		long componentId, long monthYear);

	/**
	* Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = any &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param monthYears the month years
	* @return the number of matching sal detailses
	*/
	public int countByemployeeIdAndComponentIdAndMonthYears(long employeeId,
		long componentId, long[] monthYears);

	/**
	* Caches the sal details in the entity cache if it is enabled.
	*
	* @param salDetails the sal details
	*/
	public void cacheResult(SalDetails salDetails);

	/**
	* Caches the sal detailses in the entity cache if it is enabled.
	*
	* @param salDetailses the sal detailses
	*/
	public void cacheResult(java.util.List<SalDetails> salDetailses);

	/**
	* Creates a new sal details with the primary key. Does not add the sal details to the database.
	*
	* @param SalDetailsId the primary key for the new sal details
	* @return the new sal details
	*/
	public SalDetails create(long SalDetailsId);

	/**
	* Removes the sal details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SalDetailsId the primary key of the sal details
	* @return the sal details that was removed
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public SalDetails remove(long SalDetailsId)
		throws NoSuchSalDetailsException;

	public SalDetails updateImpl(SalDetails salDetails);

	/**
	* Returns the sal details with the primary key or throws a {@link NoSuchSalDetailsException} if it could not be found.
	*
	* @param SalDetailsId the primary key of the sal details
	* @return the sal details
	* @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	*/
	public SalDetails findByPrimaryKey(long SalDetailsId)
		throws NoSuchSalDetailsException;

	/**
	* Returns the sal details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SalDetailsId the primary key of the sal details
	* @return the sal details, or <code>null</code> if a sal details with the primary key could not be found
	*/
	public SalDetails fetchByPrimaryKey(long SalDetailsId);

	@Override
	public java.util.Map<java.io.Serializable, SalDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the sal detailses.
	*
	* @return the sal detailses
	*/
	public java.util.List<SalDetails> findAll();

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
	public java.util.List<SalDetails> findAll(int start, int end);

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
	public java.util.List<SalDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator);

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
	public java.util.List<SalDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the sal detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of sal detailses.
	*
	* @return the number of sal detailses
	*/
	public int countAll();
}