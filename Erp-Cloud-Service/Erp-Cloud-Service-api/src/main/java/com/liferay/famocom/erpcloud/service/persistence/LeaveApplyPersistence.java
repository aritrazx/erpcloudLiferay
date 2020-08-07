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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyException;
import com.liferay.famocom.erpcloud.model.LeaveApply;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the leave apply service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveApplyPersistenceImpl
 * @see LeaveApplyUtil
 * @generated
 */
@ProviderType
public interface LeaveApplyPersistence extends BasePersistence<LeaveApply> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveApplyUtil} to access the leave apply persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the leave applies where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching leave applies
	*/
	public java.util.List<LeaveApply> findByuserId(long userId);

	/**
	* Returns a range of all the leave applies where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of leave applies
	* @param end the upper bound of the range of leave applies (not inclusive)
	* @return the range of matching leave applies
	*/
	public java.util.List<LeaveApply> findByuserId(long userId, int start,
		int end);

	/**
	* Returns an ordered range of all the leave applies where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of leave applies
	* @param end the upper bound of the range of leave applies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave applies
	*/
	public java.util.List<LeaveApply> findByuserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator);

	/**
	* Returns an ordered range of all the leave applies where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of leave applies
	* @param end the upper bound of the range of leave applies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching leave applies
	*/
	public java.util.List<LeaveApply> findByuserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first leave apply in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply
	* @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	*/
	public LeaveApply findByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException;

	/**
	* Returns the first leave apply in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply, or <code>null</code> if a matching leave apply could not be found
	*/
	public LeaveApply fetchByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator);

	/**
	* Returns the last leave apply in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply
	* @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	*/
	public LeaveApply findByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException;

	/**
	* Returns the last leave apply in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply, or <code>null</code> if a matching leave apply could not be found
	*/
	public LeaveApply fetchByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator);

	/**
	* Returns the leave applies before and after the current leave apply in the ordered set where userId = &#63;.
	*
	* @param leaveApplyId the primary key of the current leave apply
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave apply
	* @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	*/
	public LeaveApply[] findByuserId_PrevAndNext(long leaveApplyId,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException;

	/**
	* Removes all the leave applies where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByuserId(long userId);

	/**
	* Returns the number of leave applies where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching leave applies
	*/
	public int countByuserId(long userId);

	/**
	* Returns all the leave applies where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching leave applies
	*/
	public java.util.List<LeaveApply> findBystatus(long groupId, int status);

	/**
	* Returns a range of all the leave applies where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of leave applies
	* @param end the upper bound of the range of leave applies (not inclusive)
	* @return the range of matching leave applies
	*/
	public java.util.List<LeaveApply> findBystatus(long groupId, int status,
		int start, int end);

	/**
	* Returns an ordered range of all the leave applies where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of leave applies
	* @param end the upper bound of the range of leave applies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave applies
	*/
	public java.util.List<LeaveApply> findBystatus(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator);

	/**
	* Returns an ordered range of all the leave applies where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of leave applies
	* @param end the upper bound of the range of leave applies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching leave applies
	*/
	public java.util.List<LeaveApply> findBystatus(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first leave apply in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply
	* @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	*/
	public LeaveApply findBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException;

	/**
	* Returns the first leave apply in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply, or <code>null</code> if a matching leave apply could not be found
	*/
	public LeaveApply fetchBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator);

	/**
	* Returns the last leave apply in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply
	* @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	*/
	public LeaveApply findBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException;

	/**
	* Returns the last leave apply in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply, or <code>null</code> if a matching leave apply could not be found
	*/
	public LeaveApply fetchBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator);

	/**
	* Returns the leave applies before and after the current leave apply in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param leaveApplyId the primary key of the current leave apply
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave apply
	* @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	*/
	public LeaveApply[] findBystatus_PrevAndNext(long leaveApplyId,
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator)
		throws NoSuchLeaveApplyException;

	/**
	* Removes all the leave applies where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeBystatus(long groupId, int status);

	/**
	* Returns the number of leave applies where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching leave applies
	*/
	public int countBystatus(long groupId, int status);

	/**
	* Caches the leave apply in the entity cache if it is enabled.
	*
	* @param leaveApply the leave apply
	*/
	public void cacheResult(LeaveApply leaveApply);

	/**
	* Caches the leave applies in the entity cache if it is enabled.
	*
	* @param leaveApplies the leave applies
	*/
	public void cacheResult(java.util.List<LeaveApply> leaveApplies);

	/**
	* Creates a new leave apply with the primary key. Does not add the leave apply to the database.
	*
	* @param leaveApplyId the primary key for the new leave apply
	* @return the new leave apply
	*/
	public LeaveApply create(long leaveApplyId);

	/**
	* Removes the leave apply with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApplyId the primary key of the leave apply
	* @return the leave apply that was removed
	* @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	*/
	public LeaveApply remove(long leaveApplyId)
		throws NoSuchLeaveApplyException;

	public LeaveApply updateImpl(LeaveApply leaveApply);

	/**
	* Returns the leave apply with the primary key or throws a {@link NoSuchLeaveApplyException} if it could not be found.
	*
	* @param leaveApplyId the primary key of the leave apply
	* @return the leave apply
	* @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	*/
	public LeaveApply findByPrimaryKey(long leaveApplyId)
		throws NoSuchLeaveApplyException;

	/**
	* Returns the leave apply with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveApplyId the primary key of the leave apply
	* @return the leave apply, or <code>null</code> if a leave apply with the primary key could not be found
	*/
	public LeaveApply fetchByPrimaryKey(long leaveApplyId);

	@Override
	public java.util.Map<java.io.Serializable, LeaveApply> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the leave applies.
	*
	* @return the leave applies
	*/
	public java.util.List<LeaveApply> findAll();

	/**
	* Returns a range of all the leave applies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave applies
	* @param end the upper bound of the range of leave applies (not inclusive)
	* @return the range of leave applies
	*/
	public java.util.List<LeaveApply> findAll(int start, int end);

	/**
	* Returns an ordered range of all the leave applies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave applies
	* @param end the upper bound of the range of leave applies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave applies
	*/
	public java.util.List<LeaveApply> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator);

	/**
	* Returns an ordered range of all the leave applies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave applies
	* @param end the upper bound of the range of leave applies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leave applies
	*/
	public java.util.List<LeaveApply> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApply> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the leave applies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of leave applies.
	*
	* @return the number of leave applies
	*/
	public int countAll();
}