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

import com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException;
import com.liferay.famocom.erpcloud.model.NotificationSendManage;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the notification send manage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.NotificationSendManagePersistenceImpl
 * @see NotificationSendManageUtil
 * @generated
 */
@ProviderType
public interface NotificationSendManagePersistence extends BasePersistence<NotificationSendManage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificationSendManageUtil} to access the notification send manage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the notification send manages where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @return the matching notification send manages
	*/
	public java.util.List<NotificationSendManage> findByBranchId(long branchId);

	/**
	* Returns a range of all the notification send manages where branchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param branchId the branch ID
	* @param start the lower bound of the range of notification send manages
	* @param end the upper bound of the range of notification send manages (not inclusive)
	* @return the range of matching notification send manages
	*/
	public java.util.List<NotificationSendManage> findByBranchId(
		long branchId, int start, int end);

	/**
	* Returns an ordered range of all the notification send manages where branchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param branchId the branch ID
	* @param start the lower bound of the range of notification send manages
	* @param end the upper bound of the range of notification send manages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notification send manages
	*/
	public java.util.List<NotificationSendManage> findByBranchId(
		long branchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator);

	/**
	* Returns an ordered range of all the notification send manages where branchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param branchId the branch ID
	* @param start the lower bound of the range of notification send manages
	* @param end the upper bound of the range of notification send manages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching notification send manages
	*/
	public java.util.List<NotificationSendManage> findByBranchId(
		long branchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first notification send manage in the ordered set where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public NotificationSendManage findByBranchId_First(long branchId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException;

	/**
	* Returns the first notification send manage in the ordered set where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public NotificationSendManage fetchByBranchId_First(long branchId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator);

	/**
	* Returns the last notification send manage in the ordered set where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public NotificationSendManage findByBranchId_Last(long branchId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException;

	/**
	* Returns the last notification send manage in the ordered set where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public NotificationSendManage fetchByBranchId_Last(long branchId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator);

	/**
	* Returns the notification send manages before and after the current notification send manage in the ordered set where branchId = &#63;.
	*
	* @param notifyIdSendId the primary key of the current notification send manage
	* @param branchId the branch ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification send manage
	* @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	*/
	public NotificationSendManage[] findByBranchId_PrevAndNext(
		long notifyIdSendId, long branchId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException;

	/**
	* Removes all the notification send manages where branchId = &#63; from the database.
	*
	* @param branchId the branch ID
	*/
	public void removeByBranchId(long branchId);

	/**
	* Returns the number of notification send manages where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @return the number of matching notification send manages
	*/
	public int countByBranchId(long branchId);

	/**
	* Returns the notification send manage where notificationId = &#63; or throws a {@link NoSuchNotificationSendManageException} if it could not be found.
	*
	* @param notificationId the notification ID
	* @return the matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public NotificationSendManage findByNotificationId(long notificationId)
		throws NoSuchNotificationSendManageException;

	/**
	* Returns the notification send manage where notificationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param notificationId the notification ID
	* @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public NotificationSendManage fetchByNotificationId(long notificationId);

	/**
	* Returns the notification send manage where notificationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param notificationId the notification ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public NotificationSendManage fetchByNotificationId(long notificationId,
		boolean retrieveFromCache);

	/**
	* Removes the notification send manage where notificationId = &#63; from the database.
	*
	* @param notificationId the notification ID
	* @return the notification send manage that was removed
	*/
	public NotificationSendManage removeByNotificationId(long notificationId)
		throws NoSuchNotificationSendManageException;

	/**
	* Returns the number of notification send manages where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @return the number of matching notification send manages
	*/
	public int countByNotificationId(long notificationId);

	/**
	* Returns all the notification send manages where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @return the matching notification send manages
	*/
	public java.util.List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId);

	/**
	* Returns a range of all the notification send manages where notificationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param notificationId the notification ID
	* @param start the lower bound of the range of notification send manages
	* @param end the upper bound of the range of notification send manages (not inclusive)
	* @return the range of matching notification send manages
	*/
	public java.util.List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId, int start, int end);

	/**
	* Returns an ordered range of all the notification send manages where notificationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param notificationId the notification ID
	* @param start the lower bound of the range of notification send manages
	* @param end the upper bound of the range of notification send manages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notification send manages
	*/
	public java.util.List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator);

	/**
	* Returns an ordered range of all the notification send manages where notificationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param notificationId the notification ID
	* @param start the lower bound of the range of notification send manages
	* @param end the upper bound of the range of notification send manages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching notification send manages
	*/
	public java.util.List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first notification send manage in the ordered set where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public NotificationSendManage findByBranchFromNotificationId_First(
		long notificationId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException;

	/**
	* Returns the first notification send manage in the ordered set where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public NotificationSendManage fetchByBranchFromNotificationId_First(
		long notificationId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator);

	/**
	* Returns the last notification send manage in the ordered set where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public NotificationSendManage findByBranchFromNotificationId_Last(
		long notificationId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException;

	/**
	* Returns the last notification send manage in the ordered set where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public NotificationSendManage fetchByBranchFromNotificationId_Last(
		long notificationId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator);

	/**
	* Returns the notification send manages before and after the current notification send manage in the ordered set where notificationId = &#63;.
	*
	* @param notifyIdSendId the primary key of the current notification send manage
	* @param notificationId the notification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification send manage
	* @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	*/
	public NotificationSendManage[] findByBranchFromNotificationId_PrevAndNext(
		long notifyIdSendId, long notificationId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException;

	/**
	* Removes all the notification send manages where notificationId = &#63; from the database.
	*
	* @param notificationId the notification ID
	*/
	public void removeByBranchFromNotificationId(long notificationId);

	/**
	* Returns the number of notification send manages where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @return the number of matching notification send manages
	*/
	public int countByBranchFromNotificationId(long notificationId);

	/**
	* Returns the notification send manage where notificationId = &#63; and branchId = &#63; or throws a {@link NoSuchNotificationSendManageException} if it could not be found.
	*
	* @param notificationId the notification ID
	* @param branchId the branch ID
	* @return the matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public NotificationSendManage findByBranchAndNotificationId(
		long notificationId, long branchId)
		throws NoSuchNotificationSendManageException;

	/**
	* Returns the notification send manage where notificationId = &#63; and branchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param notificationId the notification ID
	* @param branchId the branch ID
	* @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public NotificationSendManage fetchByBranchAndNotificationId(
		long notificationId, long branchId);

	/**
	* Returns the notification send manage where notificationId = &#63; and branchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param notificationId the notification ID
	* @param branchId the branch ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public NotificationSendManage fetchByBranchAndNotificationId(
		long notificationId, long branchId, boolean retrieveFromCache);

	/**
	* Removes the notification send manage where notificationId = &#63; and branchId = &#63; from the database.
	*
	* @param notificationId the notification ID
	* @param branchId the branch ID
	* @return the notification send manage that was removed
	*/
	public NotificationSendManage removeByBranchAndNotificationId(
		long notificationId, long branchId)
		throws NoSuchNotificationSendManageException;

	/**
	* Returns the number of notification send manages where notificationId = &#63; and branchId = &#63;.
	*
	* @param notificationId the notification ID
	* @param branchId the branch ID
	* @return the number of matching notification send manages
	*/
	public int countByBranchAndNotificationId(long notificationId, long branchId);

	/**
	* Caches the notification send manage in the entity cache if it is enabled.
	*
	* @param notificationSendManage the notification send manage
	*/
	public void cacheResult(NotificationSendManage notificationSendManage);

	/**
	* Caches the notification send manages in the entity cache if it is enabled.
	*
	* @param notificationSendManages the notification send manages
	*/
	public void cacheResult(
		java.util.List<NotificationSendManage> notificationSendManages);

	/**
	* Creates a new notification send manage with the primary key. Does not add the notification send manage to the database.
	*
	* @param notifyIdSendId the primary key for the new notification send manage
	* @return the new notification send manage
	*/
	public NotificationSendManage create(long notifyIdSendId);

	/**
	* Removes the notification send manage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notifyIdSendId the primary key of the notification send manage
	* @return the notification send manage that was removed
	* @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	*/
	public NotificationSendManage remove(long notifyIdSendId)
		throws NoSuchNotificationSendManageException;

	public NotificationSendManage updateImpl(
		NotificationSendManage notificationSendManage);

	/**
	* Returns the notification send manage with the primary key or throws a {@link NoSuchNotificationSendManageException} if it could not be found.
	*
	* @param notifyIdSendId the primary key of the notification send manage
	* @return the notification send manage
	* @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	*/
	public NotificationSendManage findByPrimaryKey(long notifyIdSendId)
		throws NoSuchNotificationSendManageException;

	/**
	* Returns the notification send manage with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notifyIdSendId the primary key of the notification send manage
	* @return the notification send manage, or <code>null</code> if a notification send manage with the primary key could not be found
	*/
	public NotificationSendManage fetchByPrimaryKey(long notifyIdSendId);

	@Override
	public java.util.Map<java.io.Serializable, NotificationSendManage> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the notification send manages.
	*
	* @return the notification send manages
	*/
	public java.util.List<NotificationSendManage> findAll();

	/**
	* Returns a range of all the notification send manages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification send manages
	* @param end the upper bound of the range of notification send manages (not inclusive)
	* @return the range of notification send manages
	*/
	public java.util.List<NotificationSendManage> findAll(int start, int end);

	/**
	* Returns an ordered range of all the notification send manages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification send manages
	* @param end the upper bound of the range of notification send manages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notification send manages
	*/
	public java.util.List<NotificationSendManage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator);

	/**
	* Returns an ordered range of all the notification send manages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification send manages
	* @param end the upper bound of the range of notification send manages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of notification send manages
	*/
	public java.util.List<NotificationSendManage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationSendManage> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the notification send manages from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of notification send manages.
	*
	* @return the number of notification send manages
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}