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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveTypeException;
import com.liferay.famocom.erpcloud.model.LeaveType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the leave type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveTypePersistenceImpl
 * @see LeaveTypeUtil
 * @generated
 */
@ProviderType
public interface LeaveTypePersistence extends BasePersistence<LeaveType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveTypeUtil} to access the leave type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the leave type where leaveName = &#63; or throws a {@link NoSuchLeaveTypeException} if it could not be found.
	*
	* @param leaveName the leave name
	* @return the matching leave type
	* @throws NoSuchLeaveTypeException if a matching leave type could not be found
	*/
	public LeaveType findByleaveName(String leaveName)
		throws NoSuchLeaveTypeException;

	/**
	* Returns the leave type where leaveName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param leaveName the leave name
	* @return the matching leave type, or <code>null</code> if a matching leave type could not be found
	*/
	public LeaveType fetchByleaveName(String leaveName);

	/**
	* Returns the leave type where leaveName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param leaveName the leave name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching leave type, or <code>null</code> if a matching leave type could not be found
	*/
	public LeaveType fetchByleaveName(String leaveName,
		boolean retrieveFromCache);

	/**
	* Removes the leave type where leaveName = &#63; from the database.
	*
	* @param leaveName the leave name
	* @return the leave type that was removed
	*/
	public LeaveType removeByleaveName(String leaveName)
		throws NoSuchLeaveTypeException;

	/**
	* Returns the number of leave types where leaveName = &#63;.
	*
	* @param leaveName the leave name
	* @return the number of matching leave types
	*/
	public int countByleaveName(String leaveName);

	/**
	* Caches the leave type in the entity cache if it is enabled.
	*
	* @param leaveType the leave type
	*/
	public void cacheResult(LeaveType leaveType);

	/**
	* Caches the leave types in the entity cache if it is enabled.
	*
	* @param leaveTypes the leave types
	*/
	public void cacheResult(java.util.List<LeaveType> leaveTypes);

	/**
	* Creates a new leave type with the primary key. Does not add the leave type to the database.
	*
	* @param leaveTypeId the primary key for the new leave type
	* @return the new leave type
	*/
	public LeaveType create(long leaveTypeId);

	/**
	* Removes the leave type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeId the primary key of the leave type
	* @return the leave type that was removed
	* @throws NoSuchLeaveTypeException if a leave type with the primary key could not be found
	*/
	public LeaveType remove(long leaveTypeId) throws NoSuchLeaveTypeException;

	public LeaveType updateImpl(LeaveType leaveType);

	/**
	* Returns the leave type with the primary key or throws a {@link NoSuchLeaveTypeException} if it could not be found.
	*
	* @param leaveTypeId the primary key of the leave type
	* @return the leave type
	* @throws NoSuchLeaveTypeException if a leave type with the primary key could not be found
	*/
	public LeaveType findByPrimaryKey(long leaveTypeId)
		throws NoSuchLeaveTypeException;

	/**
	* Returns the leave type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveTypeId the primary key of the leave type
	* @return the leave type, or <code>null</code> if a leave type with the primary key could not be found
	*/
	public LeaveType fetchByPrimaryKey(long leaveTypeId);

	@Override
	public java.util.Map<java.io.Serializable, LeaveType> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the leave types.
	*
	* @return the leave types
	*/
	public java.util.List<LeaveType> findAll();

	/**
	* Returns a range of all the leave types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave types
	* @param end the upper bound of the range of leave types (not inclusive)
	* @return the range of leave types
	*/
	public java.util.List<LeaveType> findAll(int start, int end);

	/**
	* Returns an ordered range of all the leave types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave types
	* @param end the upper bound of the range of leave types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave types
	*/
	public java.util.List<LeaveType> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveType> orderByComparator);

	/**
	* Returns an ordered range of all the leave types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave types
	* @param end the upper bound of the range of leave types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leave types
	*/
	public java.util.List<LeaveType> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveType> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the leave types from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of leave types.
	*
	* @return the number of leave types
	*/
	public int countAll();
}