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

import com.liferay.famocom.erpcloud.exception.NoSuchSchedulesDetailsException;
import com.liferay.famocom.erpcloud.model.SchedulesDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the schedules details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.SchedulesDetailsPersistenceImpl
 * @see SchedulesDetailsUtil
 * @generated
 */
@ProviderType
public interface SchedulesDetailsPersistence extends BasePersistence<SchedulesDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SchedulesDetailsUtil} to access the schedules details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @return the matching schedules detailses
	*/
	public java.util.List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate);

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
	public java.util.List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate, int start, int end);

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
	public java.util.List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator);

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
	public java.util.List<SchedulesDetails> findBycheckDate(long employeeId,
		long companyId, Date schedulesDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator,
		boolean retrieveFromCache);

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
	public SchedulesDetails findBycheckDate_First(long employeeId,
		long companyId, Date schedulesDate,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException;

	/**
	* Returns the first schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public SchedulesDetails fetchBycheckDate_First(long employeeId,
		long companyId, Date schedulesDate,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator);

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
	public SchedulesDetails findBycheckDate_Last(long employeeId,
		long companyId, Date schedulesDate,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException;

	/**
	* Returns the last schedules details in the ordered set where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public SchedulesDetails fetchBycheckDate_Last(long employeeId,
		long companyId, Date schedulesDate,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator);

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
	public SchedulesDetails[] findBycheckDate_PrevAndNext(
		long schedulesDetailsId, long employeeId, long companyId,
		Date schedulesDate,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException;

	/**
	* Removes all the schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	*/
	public void removeBycheckDate(long employeeId, long companyId,
		Date schedulesDate);

	/**
	* Returns the number of schedules detailses where employeeId = &#63; and companyId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param schedulesDate the schedules date
	* @return the number of matching schedules detailses
	*/
	public int countBycheckDate(long employeeId, long companyId,
		Date schedulesDate);

	/**
	* Returns all the schedules detailses where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @return the matching schedules detailses
	*/
	public java.util.List<SchedulesDetails> findBydetailsEdit(
		long worksSchedulesId);

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
	public java.util.List<SchedulesDetails> findBydetailsEdit(
		long worksSchedulesId, int start, int end);

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
	public java.util.List<SchedulesDetails> findBydetailsEdit(
		long worksSchedulesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator);

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
	public java.util.List<SchedulesDetails> findBydetailsEdit(
		long worksSchedulesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first schedules details in the ordered set where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedules details
	* @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	*/
	public SchedulesDetails findBydetailsEdit_First(long worksSchedulesId,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException;

	/**
	* Returns the first schedules details in the ordered set where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public SchedulesDetails fetchBydetailsEdit_First(long worksSchedulesId,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator);

	/**
	* Returns the last schedules details in the ordered set where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedules details
	* @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	*/
	public SchedulesDetails findBydetailsEdit_Last(long worksSchedulesId,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException;

	/**
	* Returns the last schedules details in the ordered set where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public SchedulesDetails fetchBydetailsEdit_Last(long worksSchedulesId,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator);

	/**
	* Returns the schedules detailses before and after the current schedules details in the ordered set where worksSchedulesId = &#63;.
	*
	* @param schedulesDetailsId the primary key of the current schedules details
	* @param worksSchedulesId the works schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next schedules details
	* @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	*/
	public SchedulesDetails[] findBydetailsEdit_PrevAndNext(
		long schedulesDetailsId, long worksSchedulesId,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator)
		throws NoSuchSchedulesDetailsException;

	/**
	* Removes all the schedules detailses where worksSchedulesId = &#63; from the database.
	*
	* @param worksSchedulesId the works schedules ID
	*/
	public void removeBydetailsEdit(long worksSchedulesId);

	/**
	* Returns the number of schedules detailses where worksSchedulesId = &#63;.
	*
	* @param worksSchedulesId the works schedules ID
	* @return the number of matching schedules detailses
	*/
	public int countBydetailsEdit(long worksSchedulesId);

	/**
	* Returns the schedules details where employeeId = &#63; and schedulesDate = &#63; or throws a {@link NoSuchSchedulesDetailsException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param schedulesDate the schedules date
	* @return the matching schedules details
	* @throws NoSuchSchedulesDetailsException if a matching schedules details could not be found
	*/
	public SchedulesDetails findByempIdAndAttDate(long employeeId,
		Date schedulesDate) throws NoSuchSchedulesDetailsException;

	/**
	* Returns the schedules details where employeeId = &#63; and schedulesDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param schedulesDate the schedules date
	* @return the matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public SchedulesDetails fetchByempIdAndAttDate(long employeeId,
		Date schedulesDate);

	/**
	* Returns the schedules details where employeeId = &#63; and schedulesDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param schedulesDate the schedules date
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching schedules details, or <code>null</code> if a matching schedules details could not be found
	*/
	public SchedulesDetails fetchByempIdAndAttDate(long employeeId,
		Date schedulesDate, boolean retrieveFromCache);

	/**
	* Removes the schedules details where employeeId = &#63; and schedulesDate = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param schedulesDate the schedules date
	* @return the schedules details that was removed
	*/
	public SchedulesDetails removeByempIdAndAttDate(long employeeId,
		Date schedulesDate) throws NoSuchSchedulesDetailsException;

	/**
	* Returns the number of schedules detailses where employeeId = &#63; and schedulesDate = &#63;.
	*
	* @param employeeId the employee ID
	* @param schedulesDate the schedules date
	* @return the number of matching schedules detailses
	*/
	public int countByempIdAndAttDate(long employeeId, Date schedulesDate);

	/**
	* Caches the schedules details in the entity cache if it is enabled.
	*
	* @param schedulesDetails the schedules details
	*/
	public void cacheResult(SchedulesDetails schedulesDetails);

	/**
	* Caches the schedules detailses in the entity cache if it is enabled.
	*
	* @param schedulesDetailses the schedules detailses
	*/
	public void cacheResult(java.util.List<SchedulesDetails> schedulesDetailses);

	/**
	* Creates a new schedules details with the primary key. Does not add the schedules details to the database.
	*
	* @param schedulesDetailsId the primary key for the new schedules details
	* @return the new schedules details
	*/
	public SchedulesDetails create(long schedulesDetailsId);

	/**
	* Removes the schedules details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesDetailsId the primary key of the schedules details
	* @return the schedules details that was removed
	* @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	*/
	public SchedulesDetails remove(long schedulesDetailsId)
		throws NoSuchSchedulesDetailsException;

	public SchedulesDetails updateImpl(SchedulesDetails schedulesDetails);

	/**
	* Returns the schedules details with the primary key or throws a {@link NoSuchSchedulesDetailsException} if it could not be found.
	*
	* @param schedulesDetailsId the primary key of the schedules details
	* @return the schedules details
	* @throws NoSuchSchedulesDetailsException if a schedules details with the primary key could not be found
	*/
	public SchedulesDetails findByPrimaryKey(long schedulesDetailsId)
		throws NoSuchSchedulesDetailsException;

	/**
	* Returns the schedules details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param schedulesDetailsId the primary key of the schedules details
	* @return the schedules details, or <code>null</code> if a schedules details with the primary key could not be found
	*/
	public SchedulesDetails fetchByPrimaryKey(long schedulesDetailsId);

	@Override
	public java.util.Map<java.io.Serializable, SchedulesDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the schedules detailses.
	*
	* @return the schedules detailses
	*/
	public java.util.List<SchedulesDetails> findAll();

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
	public java.util.List<SchedulesDetails> findAll(int start, int end);

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
	public java.util.List<SchedulesDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator);

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
	public java.util.List<SchedulesDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the schedules detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of schedules detailses.
	*
	* @return the number of schedules detailses
	*/
	public int countAll();
}