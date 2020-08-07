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

import com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetMasterException;
import com.liferay.famocom.erpcloud.model.TimeSheetMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the time sheet master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TimeSheetMasterPersistenceImpl
 * @see TimeSheetMasterUtil
 * @generated
 */
@ProviderType
public interface TimeSheetMasterPersistence extends BasePersistence<TimeSheetMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimeSheetMasterUtil} to access the time sheet master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the time sheet masters where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching time sheet masters
	*/
	public java.util.List<TimeSheetMaster> findBystatus(long groupId, int status);

	/**
	* Returns a range of all the time sheet masters where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @return the range of matching time sheet masters
	*/
	public java.util.List<TimeSheetMaster> findBystatus(long groupId,
		int status, int start, int end);

	/**
	* Returns an ordered range of all the time sheet masters where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching time sheet masters
	*/
	public java.util.List<TimeSheetMaster> findBystatus(long groupId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetMaster> orderByComparator);

	/**
	* Returns an ordered range of all the time sheet masters where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching time sheet masters
	*/
	public java.util.List<TimeSheetMaster> findBystatus(long groupId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time sheet master
	* @throws NoSuchTimeSheetMasterException if a matching time sheet master could not be found
	*/
	public TimeSheetMaster findBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetMaster> orderByComparator)
		throws NoSuchTimeSheetMasterException;

	/**
	* Returns the first time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time sheet master, or <code>null</code> if a matching time sheet master could not be found
	*/
	public TimeSheetMaster fetchBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetMaster> orderByComparator);

	/**
	* Returns the last time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time sheet master
	* @throws NoSuchTimeSheetMasterException if a matching time sheet master could not be found
	*/
	public TimeSheetMaster findBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetMaster> orderByComparator)
		throws NoSuchTimeSheetMasterException;

	/**
	* Returns the last time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time sheet master, or <code>null</code> if a matching time sheet master could not be found
	*/
	public TimeSheetMaster fetchBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetMaster> orderByComparator);

	/**
	* Returns the time sheet masters before and after the current time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param timesheetParentId the primary key of the current time sheet master
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next time sheet master
	* @throws NoSuchTimeSheetMasterException if a time sheet master with the primary key could not be found
	*/
	public TimeSheetMaster[] findBystatus_PrevAndNext(long timesheetParentId,
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetMaster> orderByComparator)
		throws NoSuchTimeSheetMasterException;

	/**
	* Removes all the time sheet masters where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeBystatus(long groupId, int status);

	/**
	* Returns the number of time sheet masters where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching time sheet masters
	*/
	public int countBystatus(long groupId, int status);

	/**
	* Caches the time sheet master in the entity cache if it is enabled.
	*
	* @param timeSheetMaster the time sheet master
	*/
	public void cacheResult(TimeSheetMaster timeSheetMaster);

	/**
	* Caches the time sheet masters in the entity cache if it is enabled.
	*
	* @param timeSheetMasters the time sheet masters
	*/
	public void cacheResult(java.util.List<TimeSheetMaster> timeSheetMasters);

	/**
	* Creates a new time sheet master with the primary key. Does not add the time sheet master to the database.
	*
	* @param timesheetParentId the primary key for the new time sheet master
	* @return the new time sheet master
	*/
	public TimeSheetMaster create(long timesheetParentId);

	/**
	* Removes the time sheet master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetParentId the primary key of the time sheet master
	* @return the time sheet master that was removed
	* @throws NoSuchTimeSheetMasterException if a time sheet master with the primary key could not be found
	*/
	public TimeSheetMaster remove(long timesheetParentId)
		throws NoSuchTimeSheetMasterException;

	public TimeSheetMaster updateImpl(TimeSheetMaster timeSheetMaster);

	/**
	* Returns the time sheet master with the primary key or throws a {@link NoSuchTimeSheetMasterException} if it could not be found.
	*
	* @param timesheetParentId the primary key of the time sheet master
	* @return the time sheet master
	* @throws NoSuchTimeSheetMasterException if a time sheet master with the primary key could not be found
	*/
	public TimeSheetMaster findByPrimaryKey(long timesheetParentId)
		throws NoSuchTimeSheetMasterException;

	/**
	* Returns the time sheet master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timesheetParentId the primary key of the time sheet master
	* @return the time sheet master, or <code>null</code> if a time sheet master with the primary key could not be found
	*/
	public TimeSheetMaster fetchByPrimaryKey(long timesheetParentId);

	@Override
	public java.util.Map<java.io.Serializable, TimeSheetMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the time sheet masters.
	*
	* @return the time sheet masters
	*/
	public java.util.List<TimeSheetMaster> findAll();

	/**
	* Returns a range of all the time sheet masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @return the range of time sheet masters
	*/
	public java.util.List<TimeSheetMaster> findAll(int start, int end);

	/**
	* Returns an ordered range of all the time sheet masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of time sheet masters
	*/
	public java.util.List<TimeSheetMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetMaster> orderByComparator);

	/**
	* Returns an ordered range of all the time sheet masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of time sheet masters
	*/
	public java.util.List<TimeSheetMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeSheetMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the time sheet masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of time sheet masters.
	*
	* @return the number of time sheet masters
	*/
	public int countAll();
}