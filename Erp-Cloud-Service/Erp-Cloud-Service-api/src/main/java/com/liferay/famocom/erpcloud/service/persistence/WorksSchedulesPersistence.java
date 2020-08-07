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

import com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException;
import com.liferay.famocom.erpcloud.model.WorksSchedules;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the works schedules service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.WorksSchedulesPersistenceImpl
 * @see WorksSchedulesUtil
 * @generated
 */
@ProviderType
public interface WorksSchedulesPersistence extends BasePersistence<WorksSchedules> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorksSchedulesUtil} to access the works schedules persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the works scheduleses where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @return the matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findByschedulesId(long schedulesId);

	/**
	* Returns a range of all the works scheduleses where schedulesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param schedulesId the schedules ID
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @return the range of matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findByschedulesId(long schedulesId,
		int start, int end);

	/**
	* Returns an ordered range of all the works scheduleses where schedulesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param schedulesId the schedules ID
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findByschedulesId(long schedulesId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator);

	/**
	* Returns an ordered range of all the works scheduleses where schedulesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param schedulesId the schedules ID
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findByschedulesId(long schedulesId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first works schedules in the ordered set where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public WorksSchedules findByschedulesId_First(long schedulesId,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException;

	/**
	* Returns the first works schedules in the ordered set where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public WorksSchedules fetchByschedulesId_First(long schedulesId,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator);

	/**
	* Returns the last works schedules in the ordered set where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public WorksSchedules findByschedulesId_Last(long schedulesId,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException;

	/**
	* Returns the last works schedules in the ordered set where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public WorksSchedules fetchByschedulesId_Last(long schedulesId,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator);

	/**
	* Returns the works scheduleses before and after the current works schedules in the ordered set where schedulesId = &#63;.
	*
	* @param worksSchedulesId the primary key of the current works schedules
	* @param schedulesId the schedules ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next works schedules
	* @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	*/
	public WorksSchedules[] findByschedulesId_PrevAndNext(
		long worksSchedulesId, long schedulesId,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException;

	/**
	* Removes all the works scheduleses where schedulesId = &#63; from the database.
	*
	* @param schedulesId the schedules ID
	*/
	public void removeByschedulesId(long schedulesId);

	/**
	* Returns the number of works scheduleses where schedulesId = &#63;.
	*
	* @param schedulesId the schedules ID
	* @return the number of matching works scheduleses
	*/
	public int countByschedulesId(long schedulesId);

	/**
	* Returns all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @return the matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findByfromToDate(Date fromDate,
		Date toDate);

	/**
	* Returns a range of all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @return the range of matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findByfromToDate(Date fromDate,
		Date toDate, int start, int end);

	/**
	* Returns an ordered range of all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findByfromToDate(Date fromDate,
		Date toDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator);

	/**
	* Returns an ordered range of all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findByfromToDate(Date fromDate,
		Date toDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public WorksSchedules findByfromToDate_First(Date fromDate, Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException;

	/**
	* Returns the first works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public WorksSchedules fetchByfromToDate_First(Date fromDate, Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator);

	/**
	* Returns the last works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public WorksSchedules findByfromToDate_Last(Date fromDate, Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException;

	/**
	* Returns the last works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public WorksSchedules fetchByfromToDate_Last(Date fromDate, Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator);

	/**
	* Returns the works scheduleses before and after the current works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	*
	* @param worksSchedulesId the primary key of the current works schedules
	* @param fromDate the from date
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next works schedules
	* @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	*/
	public WorksSchedules[] findByfromToDate_PrevAndNext(
		long worksSchedulesId, Date fromDate, Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException;

	/**
	* Removes all the works scheduleses where fromDate = &#63; and toDate = &#63; from the database.
	*
	* @param fromDate the from date
	* @param toDate the to date
	*/
	public void removeByfromToDate(Date fromDate, Date toDate);

	/**
	* Returns the number of works scheduleses where fromDate = &#63; and toDate = &#63;.
	*
	* @param fromDate the from date
	* @param toDate the to date
	* @return the number of matching works scheduleses
	*/
	public int countByfromToDate(Date fromDate, Date toDate);

	/**
	* Returns all the works scheduleses where toDate = &#63;.
	*
	* @param toDate the to date
	* @return the matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findBytoDate(Date toDate);

	/**
	* Returns a range of all the works scheduleses where toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @return the range of matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findBytoDate(Date toDate, int start,
		int end);

	/**
	* Returns an ordered range of all the works scheduleses where toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findBytoDate(Date toDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator);

	/**
	* Returns an ordered range of all the works scheduleses where toDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toDate the to date
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching works scheduleses
	*/
	public java.util.List<WorksSchedules> findBytoDate(Date toDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first works schedules in the ordered set where toDate = &#63;.
	*
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public WorksSchedules findBytoDate_First(Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException;

	/**
	* Returns the first works schedules in the ordered set where toDate = &#63;.
	*
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public WorksSchedules fetchBytoDate_First(Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator);

	/**
	* Returns the last works schedules in the ordered set where toDate = &#63;.
	*
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules
	* @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	*/
	public WorksSchedules findBytoDate_Last(Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException;

	/**
	* Returns the last works schedules in the ordered set where toDate = &#63;.
	*
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching works schedules, or <code>null</code> if a matching works schedules could not be found
	*/
	public WorksSchedules fetchBytoDate_Last(Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator);

	/**
	* Returns the works scheduleses before and after the current works schedules in the ordered set where toDate = &#63;.
	*
	* @param worksSchedulesId the primary key of the current works schedules
	* @param toDate the to date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next works schedules
	* @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	*/
	public WorksSchedules[] findBytoDate_PrevAndNext(long worksSchedulesId,
		Date toDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException;

	/**
	* Removes all the works scheduleses where toDate = &#63; from the database.
	*
	* @param toDate the to date
	*/
	public void removeBytoDate(Date toDate);

	/**
	* Returns the number of works scheduleses where toDate = &#63;.
	*
	* @param toDate the to date
	* @return the number of matching works scheduleses
	*/
	public int countBytoDate(Date toDate);

	/**
	* Caches the works schedules in the entity cache if it is enabled.
	*
	* @param worksSchedules the works schedules
	*/
	public void cacheResult(WorksSchedules worksSchedules);

	/**
	* Caches the works scheduleses in the entity cache if it is enabled.
	*
	* @param worksScheduleses the works scheduleses
	*/
	public void cacheResult(java.util.List<WorksSchedules> worksScheduleses);

	/**
	* Creates a new works schedules with the primary key. Does not add the works schedules to the database.
	*
	* @param worksSchedulesId the primary key for the new works schedules
	* @return the new works schedules
	*/
	public WorksSchedules create(long worksSchedulesId);

	/**
	* Removes the works schedules with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param worksSchedulesId the primary key of the works schedules
	* @return the works schedules that was removed
	* @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	*/
	public WorksSchedules remove(long worksSchedulesId)
		throws NoSuchWorksSchedulesException;

	public WorksSchedules updateImpl(WorksSchedules worksSchedules);

	/**
	* Returns the works schedules with the primary key or throws a {@link NoSuchWorksSchedulesException} if it could not be found.
	*
	* @param worksSchedulesId the primary key of the works schedules
	* @return the works schedules
	* @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	*/
	public WorksSchedules findByPrimaryKey(long worksSchedulesId)
		throws NoSuchWorksSchedulesException;

	/**
	* Returns the works schedules with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param worksSchedulesId the primary key of the works schedules
	* @return the works schedules, or <code>null</code> if a works schedules with the primary key could not be found
	*/
	public WorksSchedules fetchByPrimaryKey(long worksSchedulesId);

	@Override
	public java.util.Map<java.io.Serializable, WorksSchedules> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the works scheduleses.
	*
	* @return the works scheduleses
	*/
	public java.util.List<WorksSchedules> findAll();

	/**
	* Returns a range of all the works scheduleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @return the range of works scheduleses
	*/
	public java.util.List<WorksSchedules> findAll(int start, int end);

	/**
	* Returns an ordered range of all the works scheduleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of works scheduleses
	*/
	public java.util.List<WorksSchedules> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator);

	/**
	* Returns an ordered range of all the works scheduleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of works scheduleses
	*/
	public java.util.List<WorksSchedules> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorksSchedules> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the works scheduleses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of works scheduleses.
	*
	* @return the number of works scheduleses
	*/
	public int countAll();
}