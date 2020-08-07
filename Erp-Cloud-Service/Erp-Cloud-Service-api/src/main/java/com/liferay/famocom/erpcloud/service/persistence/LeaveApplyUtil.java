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

import com.liferay.famocom.erpcloud.model.LeaveApply;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the leave apply service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.LeaveApplyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveApplyPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveApplyPersistenceImpl
 * @generated
 */
@ProviderType
public class LeaveApplyUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(LeaveApply leaveApply) {
		getPersistence().clearCache(leaveApply);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveApply> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveApply> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveApply> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveApply> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveApply update(LeaveApply leaveApply) {
		return getPersistence().update(leaveApply);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveApply update(LeaveApply leaveApply,
		ServiceContext serviceContext) {
		return getPersistence().update(leaveApply, serviceContext);
	}

	/**
	* Returns all the leave applies where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching leave applies
	*/
	public static List<LeaveApply> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

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
	public static List<LeaveApply> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

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
	public static List<LeaveApply> findByuserId(long userId, int start,
		int end, OrderByComparator<LeaveApply> orderByComparator) {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator);
	}

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
	public static List<LeaveApply> findByuserId(long userId, int start,
		int end, OrderByComparator<LeaveApply> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first leave apply in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply
	* @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	*/
	public static LeaveApply findByuserId_First(long userId,
		OrderByComparator<LeaveApply> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyException {
		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first leave apply in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply, or <code>null</code> if a matching leave apply could not be found
	*/
	public static LeaveApply fetchByuserId_First(long userId,
		OrderByComparator<LeaveApply> orderByComparator) {
		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last leave apply in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply
	* @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	*/
	public static LeaveApply findByuserId_Last(long userId,
		OrderByComparator<LeaveApply> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyException {
		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last leave apply in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply, or <code>null</code> if a matching leave apply could not be found
	*/
	public static LeaveApply fetchByuserId_Last(long userId,
		OrderByComparator<LeaveApply> orderByComparator) {
		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the leave applies before and after the current leave apply in the ordered set where userId = &#63;.
	*
	* @param leaveApplyId the primary key of the current leave apply
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave apply
	* @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	*/
	public static LeaveApply[] findByuserId_PrevAndNext(long leaveApplyId,
		long userId, OrderByComparator<LeaveApply> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyException {
		return getPersistence()
				   .findByuserId_PrevAndNext(leaveApplyId, userId,
			orderByComparator);
	}

	/**
	* Removes all the leave applies where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of leave applies where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching leave applies
	*/
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Returns all the leave applies where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching leave applies
	*/
	public static List<LeaveApply> findBystatus(long groupId, int status) {
		return getPersistence().findBystatus(groupId, status);
	}

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
	public static List<LeaveApply> findBystatus(long groupId, int status,
		int start, int end) {
		return getPersistence().findBystatus(groupId, status, start, end);
	}

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
	public static List<LeaveApply> findBystatus(long groupId, int status,
		int start, int end, OrderByComparator<LeaveApply> orderByComparator) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end, orderByComparator);
	}

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
	public static List<LeaveApply> findBystatus(long groupId, int status,
		int start, int end, OrderByComparator<LeaveApply> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first leave apply in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply
	* @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	*/
	public static LeaveApply findBystatus_First(long groupId, int status,
		OrderByComparator<LeaveApply> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyException {
		return getPersistence()
				   .findBystatus_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the first leave apply in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply, or <code>null</code> if a matching leave apply could not be found
	*/
	public static LeaveApply fetchBystatus_First(long groupId, int status,
		OrderByComparator<LeaveApply> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the last leave apply in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply
	* @throws NoSuchLeaveApplyException if a matching leave apply could not be found
	*/
	public static LeaveApply findBystatus_Last(long groupId, int status,
		OrderByComparator<LeaveApply> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyException {
		return getPersistence()
				   .findBystatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last leave apply in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply, or <code>null</code> if a matching leave apply could not be found
	*/
	public static LeaveApply fetchBystatus_Last(long groupId, int status,
		OrderByComparator<LeaveApply> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_Last(groupId, status, orderByComparator);
	}

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
	public static LeaveApply[] findBystatus_PrevAndNext(long leaveApplyId,
		long groupId, int status,
		OrderByComparator<LeaveApply> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyException {
		return getPersistence()
				   .findBystatus_PrevAndNext(leaveApplyId, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the leave applies where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public static void removeBystatus(long groupId, int status) {
		getPersistence().removeBystatus(groupId, status);
	}

	/**
	* Returns the number of leave applies where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching leave applies
	*/
	public static int countBystatus(long groupId, int status) {
		return getPersistence().countBystatus(groupId, status);
	}

	/**
	* Caches the leave apply in the entity cache if it is enabled.
	*
	* @param leaveApply the leave apply
	*/
	public static void cacheResult(LeaveApply leaveApply) {
		getPersistence().cacheResult(leaveApply);
	}

	/**
	* Caches the leave applies in the entity cache if it is enabled.
	*
	* @param leaveApplies the leave applies
	*/
	public static void cacheResult(List<LeaveApply> leaveApplies) {
		getPersistence().cacheResult(leaveApplies);
	}

	/**
	* Creates a new leave apply with the primary key. Does not add the leave apply to the database.
	*
	* @param leaveApplyId the primary key for the new leave apply
	* @return the new leave apply
	*/
	public static LeaveApply create(long leaveApplyId) {
		return getPersistence().create(leaveApplyId);
	}

	/**
	* Removes the leave apply with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApplyId the primary key of the leave apply
	* @return the leave apply that was removed
	* @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	*/
	public static LeaveApply remove(long leaveApplyId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyException {
		return getPersistence().remove(leaveApplyId);
	}

	public static LeaveApply updateImpl(LeaveApply leaveApply) {
		return getPersistence().updateImpl(leaveApply);
	}

	/**
	* Returns the leave apply with the primary key or throws a {@link NoSuchLeaveApplyException} if it could not be found.
	*
	* @param leaveApplyId the primary key of the leave apply
	* @return the leave apply
	* @throws NoSuchLeaveApplyException if a leave apply with the primary key could not be found
	*/
	public static LeaveApply findByPrimaryKey(long leaveApplyId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyException {
		return getPersistence().findByPrimaryKey(leaveApplyId);
	}

	/**
	* Returns the leave apply with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveApplyId the primary key of the leave apply
	* @return the leave apply, or <code>null</code> if a leave apply with the primary key could not be found
	*/
	public static LeaveApply fetchByPrimaryKey(long leaveApplyId) {
		return getPersistence().fetchByPrimaryKey(leaveApplyId);
	}

	public static java.util.Map<java.io.Serializable, LeaveApply> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the leave applies.
	*
	* @return the leave applies
	*/
	public static List<LeaveApply> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<LeaveApply> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<LeaveApply> findAll(int start, int end,
		OrderByComparator<LeaveApply> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<LeaveApply> findAll(int start, int end,
		OrderByComparator<LeaveApply> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the leave applies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave applies.
	*
	* @return the number of leave applies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveApplyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LeaveApplyPersistence, LeaveApplyPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LeaveApplyPersistence.class);

		ServiceTracker<LeaveApplyPersistence, LeaveApplyPersistence> serviceTracker =
			new ServiceTracker<LeaveApplyPersistence, LeaveApplyPersistence>(bundle.getBundleContext(),
				LeaveApplyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}