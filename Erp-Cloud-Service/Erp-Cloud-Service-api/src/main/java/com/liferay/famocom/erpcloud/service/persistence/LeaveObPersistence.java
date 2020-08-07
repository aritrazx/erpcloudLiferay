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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveObException;
import com.liferay.famocom.erpcloud.model.LeaveOb;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the leave ob service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveObPersistenceImpl
 * @see LeaveObUtil
 * @generated
 */
@ProviderType
public interface LeaveObPersistence extends BasePersistence<LeaveOb> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveObUtil} to access the leave ob persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the leave ob where employeeId = &#63; and leaveTypeId = &#63; or throws a {@link NoSuchLeaveObException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param leaveTypeId the leave type ID
	* @return the matching leave ob
	* @throws NoSuchLeaveObException if a matching leave ob could not be found
	*/
	public LeaveOb findByopeningBalance(long employeeId, long leaveTypeId)
		throws NoSuchLeaveObException;

	/**
	* Returns the leave ob where employeeId = &#63; and leaveTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param leaveTypeId the leave type ID
	* @return the matching leave ob, or <code>null</code> if a matching leave ob could not be found
	*/
	public LeaveOb fetchByopeningBalance(long employeeId, long leaveTypeId);

	/**
	* Returns the leave ob where employeeId = &#63; and leaveTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param leaveTypeId the leave type ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching leave ob, or <code>null</code> if a matching leave ob could not be found
	*/
	public LeaveOb fetchByopeningBalance(long employeeId, long leaveTypeId,
		boolean retrieveFromCache);

	/**
	* Removes the leave ob where employeeId = &#63; and leaveTypeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param leaveTypeId the leave type ID
	* @return the leave ob that was removed
	*/
	public LeaveOb removeByopeningBalance(long employeeId, long leaveTypeId)
		throws NoSuchLeaveObException;

	/**
	* Returns the number of leave obs where employeeId = &#63; and leaveTypeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param leaveTypeId the leave type ID
	* @return the number of matching leave obs
	*/
	public int countByopeningBalance(long employeeId, long leaveTypeId);

	/**
	* Caches the leave ob in the entity cache if it is enabled.
	*
	* @param leaveOb the leave ob
	*/
	public void cacheResult(LeaveOb leaveOb);

	/**
	* Caches the leave obs in the entity cache if it is enabled.
	*
	* @param leaveObs the leave obs
	*/
	public void cacheResult(java.util.List<LeaveOb> leaveObs);

	/**
	* Creates a new leave ob with the primary key. Does not add the leave ob to the database.
	*
	* @param leaveobId the primary key for the new leave ob
	* @return the new leave ob
	*/
	public LeaveOb create(long leaveobId);

	/**
	* Removes the leave ob with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveobId the primary key of the leave ob
	* @return the leave ob that was removed
	* @throws NoSuchLeaveObException if a leave ob with the primary key could not be found
	*/
	public LeaveOb remove(long leaveobId) throws NoSuchLeaveObException;

	public LeaveOb updateImpl(LeaveOb leaveOb);

	/**
	* Returns the leave ob with the primary key or throws a {@link NoSuchLeaveObException} if it could not be found.
	*
	* @param leaveobId the primary key of the leave ob
	* @return the leave ob
	* @throws NoSuchLeaveObException if a leave ob with the primary key could not be found
	*/
	public LeaveOb findByPrimaryKey(long leaveobId)
		throws NoSuchLeaveObException;

	/**
	* Returns the leave ob with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveobId the primary key of the leave ob
	* @return the leave ob, or <code>null</code> if a leave ob with the primary key could not be found
	*/
	public LeaveOb fetchByPrimaryKey(long leaveobId);

	@Override
	public java.util.Map<java.io.Serializable, LeaveOb> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the leave obs.
	*
	* @return the leave obs
	*/
	public java.util.List<LeaveOb> findAll();

	/**
	* Returns a range of all the leave obs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave obs
	* @param end the upper bound of the range of leave obs (not inclusive)
	* @return the range of leave obs
	*/
	public java.util.List<LeaveOb> findAll(int start, int end);

	/**
	* Returns an ordered range of all the leave obs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave obs
	* @param end the upper bound of the range of leave obs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave obs
	*/
	public java.util.List<LeaveOb> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveOb> orderByComparator);

	/**
	* Returns an ordered range of all the leave obs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave obs
	* @param end the upper bound of the range of leave obs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leave obs
	*/
	public java.util.List<LeaveOb> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveOb> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the leave obs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of leave obs.
	*
	* @return the number of leave obs
	*/
	public int countAll();
}