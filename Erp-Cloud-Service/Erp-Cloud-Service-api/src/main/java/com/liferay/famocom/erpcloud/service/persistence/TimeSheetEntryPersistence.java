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

import com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetEntryException;
import com.liferay.famocom.erpcloud.model.TimeSheetEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the time sheet entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TimeSheetEntryPersistenceImpl
 * @see TimeSheetEntryUtil
 * @generated
 */
@ProviderType
public interface TimeSheetEntryPersistence extends BasePersistence<TimeSheetEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimeSheetEntryUtil} to access the time sheet entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the time sheet entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching time sheet entries
	*/
	public java.util.List<TimeSheetEntry> findBystatus(long groupId, int status);

	/**
	* Returns a range of all the time sheet entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @return the range of matching time sheet entries
	*/
	public java.util.List<TimeSheetEntry> findBystatus(long groupId,
		int status, int start, int end);

	/**
	* Returns an ordered range of all the time sheet entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching time sheet entries
	*/
	public java.util.List<TimeSheetEntry> findBystatus(long groupId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetEntry> orderByComparator);

	/**
	* Returns an ordered range of all the time sheet entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching time sheet entries
	*/
	public java.util.List<TimeSheetEntry> findBystatus(long groupId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time sheet entry
	* @throws NoSuchTimeSheetEntryException if a matching time sheet entry could not be found
	*/
	public TimeSheetEntry findBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetEntry> orderByComparator)
		throws NoSuchTimeSheetEntryException;

	/**
	* Returns the first time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time sheet entry, or <code>null</code> if a matching time sheet entry could not be found
	*/
	public TimeSheetEntry fetchBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetEntry> orderByComparator);

	/**
	* Returns the last time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time sheet entry
	* @throws NoSuchTimeSheetEntryException if a matching time sheet entry could not be found
	*/
	public TimeSheetEntry findBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetEntry> orderByComparator)
		throws NoSuchTimeSheetEntryException;

	/**
	* Returns the last time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time sheet entry, or <code>null</code> if a matching time sheet entry could not be found
	*/
	public TimeSheetEntry fetchBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetEntry> orderByComparator);

	/**
	* Returns the time sheet entries before and after the current time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param timesheetId the primary key of the current time sheet entry
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next time sheet entry
	* @throws NoSuchTimeSheetEntryException if a time sheet entry with the primary key could not be found
	*/
	public TimeSheetEntry[] findBystatus_PrevAndNext(long timesheetId,
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetEntry> orderByComparator)
		throws NoSuchTimeSheetEntryException;

	/**
	* Removes all the time sheet entries where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeBystatus(long groupId, int status);

	/**
	* Returns the number of time sheet entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching time sheet entries
	*/
	public int countBystatus(long groupId, int status);

	/**
	* Caches the time sheet entry in the entity cache if it is enabled.
	*
	* @param timeSheetEntry the time sheet entry
	*/
	public void cacheResult(TimeSheetEntry timeSheetEntry);

	/**
	* Caches the time sheet entries in the entity cache if it is enabled.
	*
	* @param timeSheetEntries the time sheet entries
	*/
	public void cacheResult(java.util.List<TimeSheetEntry> timeSheetEntries);

	/**
	* Creates a new time sheet entry with the primary key. Does not add the time sheet entry to the database.
	*
	* @param timesheetId the primary key for the new time sheet entry
	* @return the new time sheet entry
	*/
	public TimeSheetEntry create(long timesheetId);

	/**
	* Removes the time sheet entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetId the primary key of the time sheet entry
	* @return the time sheet entry that was removed
	* @throws NoSuchTimeSheetEntryException if a time sheet entry with the primary key could not be found
	*/
	public TimeSheetEntry remove(long timesheetId)
		throws NoSuchTimeSheetEntryException;

	public TimeSheetEntry updateImpl(TimeSheetEntry timeSheetEntry);

	/**
	* Returns the time sheet entry with the primary key or throws a {@link NoSuchTimeSheetEntryException} if it could not be found.
	*
	* @param timesheetId the primary key of the time sheet entry
	* @return the time sheet entry
	* @throws NoSuchTimeSheetEntryException if a time sheet entry with the primary key could not be found
	*/
	public TimeSheetEntry findByPrimaryKey(long timesheetId)
		throws NoSuchTimeSheetEntryException;

	/**
	* Returns the time sheet entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timesheetId the primary key of the time sheet entry
	* @return the time sheet entry, or <code>null</code> if a time sheet entry with the primary key could not be found
	*/
	public TimeSheetEntry fetchByPrimaryKey(long timesheetId);

	@Override
	public java.util.Map<java.io.Serializable, TimeSheetEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the time sheet entries.
	*
	* @return the time sheet entries
	*/
	public java.util.List<TimeSheetEntry> findAll();

	/**
	* Returns a range of all the time sheet entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @return the range of time sheet entries
	*/
	public java.util.List<TimeSheetEntry> findAll(int start, int end);

	/**
	* Returns an ordered range of all the time sheet entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of time sheet entries
	*/
	public java.util.List<TimeSheetEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetEntry> orderByComparator);

	/**
	* Returns an ordered range of all the time sheet entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of time sheet entries
	*/
	public java.util.List<TimeSheetEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the time sheet entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of time sheet entries.
	*
	* @return the number of time sheet entries
	*/
	public int countAll();
}