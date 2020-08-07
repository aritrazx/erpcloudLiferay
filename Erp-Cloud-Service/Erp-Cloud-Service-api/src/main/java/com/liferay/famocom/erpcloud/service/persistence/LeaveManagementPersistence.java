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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveManagementException;
import com.liferay.famocom.erpcloud.model.LeaveManagement;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the leave management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveManagementPersistenceImpl
 * @see LeaveManagementUtil
 * @generated
 */
@ProviderType
public interface LeaveManagementPersistence extends BasePersistence<LeaveManagement> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveManagementUtil} to access the leave management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the leave management where leaveName = &#63; or throws a {@link NoSuchLeaveManagementException} if it could not be found.
	*
	* @param leaveName the leave name
	* @return the matching leave management
	* @throws NoSuchLeaveManagementException if a matching leave management could not be found
	*/
	public LeaveManagement findByleaveName(String leaveName)
		throws NoSuchLeaveManagementException;

	/**
	* Returns the leave management where leaveName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param leaveName the leave name
	* @return the matching leave management, or <code>null</code> if a matching leave management could not be found
	*/
	public LeaveManagement fetchByleaveName(String leaveName);

	/**
	* Returns the leave management where leaveName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param leaveName the leave name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching leave management, or <code>null</code> if a matching leave management could not be found
	*/
	public LeaveManagement fetchByleaveName(String leaveName,
		boolean retrieveFromCache);

	/**
	* Removes the leave management where leaveName = &#63; from the database.
	*
	* @param leaveName the leave name
	* @return the leave management that was removed
	*/
	public LeaveManagement removeByleaveName(String leaveName)
		throws NoSuchLeaveManagementException;

	/**
	* Returns the number of leave managements where leaveName = &#63;.
	*
	* @param leaveName the leave name
	* @return the number of matching leave managements
	*/
	public int countByleaveName(String leaveName);

	/**
	* Caches the leave management in the entity cache if it is enabled.
	*
	* @param leaveManagement the leave management
	*/
	public void cacheResult(LeaveManagement leaveManagement);

	/**
	* Caches the leave managements in the entity cache if it is enabled.
	*
	* @param leaveManagements the leave managements
	*/
	public void cacheResult(java.util.List<LeaveManagement> leaveManagements);

	/**
	* Creates a new leave management with the primary key. Does not add the leave management to the database.
	*
	* @param leaveId the primary key for the new leave management
	* @return the new leave management
	*/
	public LeaveManagement create(long leaveId);

	/**
	* Removes the leave management with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveId the primary key of the leave management
	* @return the leave management that was removed
	* @throws NoSuchLeaveManagementException if a leave management with the primary key could not be found
	*/
	public LeaveManagement remove(long leaveId)
		throws NoSuchLeaveManagementException;

	public LeaveManagement updateImpl(LeaveManagement leaveManagement);

	/**
	* Returns the leave management with the primary key or throws a {@link NoSuchLeaveManagementException} if it could not be found.
	*
	* @param leaveId the primary key of the leave management
	* @return the leave management
	* @throws NoSuchLeaveManagementException if a leave management with the primary key could not be found
	*/
	public LeaveManagement findByPrimaryKey(long leaveId)
		throws NoSuchLeaveManagementException;

	/**
	* Returns the leave management with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveId the primary key of the leave management
	* @return the leave management, or <code>null</code> if a leave management with the primary key could not be found
	*/
	public LeaveManagement fetchByPrimaryKey(long leaveId);

	@Override
	public java.util.Map<java.io.Serializable, LeaveManagement> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the leave managements.
	*
	* @return the leave managements
	*/
	public java.util.List<LeaveManagement> findAll();

	/**
	* Returns a range of all the leave managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave managements
	* @param end the upper bound of the range of leave managements (not inclusive)
	* @return the range of leave managements
	*/
	public java.util.List<LeaveManagement> findAll(int start, int end);

	/**
	* Returns an ordered range of all the leave managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave managements
	* @param end the upper bound of the range of leave managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave managements
	*/
	public java.util.List<LeaveManagement> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveManagement> orderByComparator);

	/**
	* Returns an ordered range of all the leave managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave managements
	* @param end the upper bound of the range of leave managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leave managements
	*/
	public java.util.List<LeaveManagement> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveManagement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the leave managements from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of leave managements.
	*
	* @return the number of leave managements
	*/
	public int countAll();
}