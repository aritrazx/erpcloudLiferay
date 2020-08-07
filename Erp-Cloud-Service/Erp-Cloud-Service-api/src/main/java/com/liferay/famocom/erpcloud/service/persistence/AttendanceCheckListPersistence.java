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

import com.liferay.famocom.erpcloud.exception.NoSuchAttendanceCheckListException;
import com.liferay.famocom.erpcloud.model.AttendanceCheckList;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the attendance check list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AttendanceCheckListPersistenceImpl
 * @see AttendanceCheckListUtil
 * @generated
 */
@ProviderType
public interface AttendanceCheckListPersistence extends BasePersistence<AttendanceCheckList> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttendanceCheckListUtil} to access the attendance check list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the attendance check list in the entity cache if it is enabled.
	*
	* @param attendanceCheckList the attendance check list
	*/
	public void cacheResult(AttendanceCheckList attendanceCheckList);

	/**
	* Caches the attendance check lists in the entity cache if it is enabled.
	*
	* @param attendanceCheckLists the attendance check lists
	*/
	public void cacheResult(
		java.util.List<AttendanceCheckList> attendanceCheckLists);

	/**
	* Creates a new attendance check list with the primary key. Does not add the attendance check list to the database.
	*
	* @param attendanceCheckListId the primary key for the new attendance check list
	* @return the new attendance check list
	*/
	public AttendanceCheckList create(long attendanceCheckListId);

	/**
	* Removes the attendance check list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceCheckListId the primary key of the attendance check list
	* @return the attendance check list that was removed
	* @throws NoSuchAttendanceCheckListException if a attendance check list with the primary key could not be found
	*/
	public AttendanceCheckList remove(long attendanceCheckListId)
		throws NoSuchAttendanceCheckListException;

	public AttendanceCheckList updateImpl(
		AttendanceCheckList attendanceCheckList);

	/**
	* Returns the attendance check list with the primary key or throws a {@link NoSuchAttendanceCheckListException} if it could not be found.
	*
	* @param attendanceCheckListId the primary key of the attendance check list
	* @return the attendance check list
	* @throws NoSuchAttendanceCheckListException if a attendance check list with the primary key could not be found
	*/
	public AttendanceCheckList findByPrimaryKey(long attendanceCheckListId)
		throws NoSuchAttendanceCheckListException;

	/**
	* Returns the attendance check list with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attendanceCheckListId the primary key of the attendance check list
	* @return the attendance check list, or <code>null</code> if a attendance check list with the primary key could not be found
	*/
	public AttendanceCheckList fetchByPrimaryKey(long attendanceCheckListId);

	@Override
	public java.util.Map<java.io.Serializable, AttendanceCheckList> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the attendance check lists.
	*
	* @return the attendance check lists
	*/
	public java.util.List<AttendanceCheckList> findAll();

	/**
	* Returns a range of all the attendance check lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceCheckListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendance check lists
	* @param end the upper bound of the range of attendance check lists (not inclusive)
	* @return the range of attendance check lists
	*/
	public java.util.List<AttendanceCheckList> findAll(int start, int end);

	/**
	* Returns an ordered range of all the attendance check lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceCheckListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendance check lists
	* @param end the upper bound of the range of attendance check lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of attendance check lists
	*/
	public java.util.List<AttendanceCheckList> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttendanceCheckList> orderByComparator);

	/**
	* Returns an ordered range of all the attendance check lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceCheckListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendance check lists
	* @param end the upper bound of the range of attendance check lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of attendance check lists
	*/
	public java.util.List<AttendanceCheckList> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttendanceCheckList> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the attendance check lists from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of attendance check lists.
	*
	* @return the number of attendance check lists
	*/
	public int countAll();
}