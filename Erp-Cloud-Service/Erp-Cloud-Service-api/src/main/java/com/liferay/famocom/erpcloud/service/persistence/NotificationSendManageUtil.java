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

import com.liferay.famocom.erpcloud.model.NotificationSendManage;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the notification send manage service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.NotificationSendManagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see NotificationSendManagePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.NotificationSendManagePersistenceImpl
 * @generated
 */
@ProviderType
public class NotificationSendManageUtil {
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
	public static void clearCache(NotificationSendManage notificationSendManage) {
		getPersistence().clearCache(notificationSendManage);
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
	public static List<NotificationSendManage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NotificationSendManage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NotificationSendManage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static NotificationSendManage update(
		NotificationSendManage notificationSendManage) {
		return getPersistence().update(notificationSendManage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static NotificationSendManage update(
		NotificationSendManage notificationSendManage,
		ServiceContext serviceContext) {
		return getPersistence().update(notificationSendManage, serviceContext);
	}

	/**
	* Returns all the notification send manages where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @return the matching notification send manages
	*/
	public static List<NotificationSendManage> findByBranchId(long branchId) {
		return getPersistence().findByBranchId(branchId);
	}

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
	public static List<NotificationSendManage> findByBranchId(long branchId,
		int start, int end) {
		return getPersistence().findByBranchId(branchId, start, end);
	}

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
	public static List<NotificationSendManage> findByBranchId(long branchId,
		int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		return getPersistence()
				   .findByBranchId(branchId, start, end, orderByComparator);
	}

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
	public static List<NotificationSendManage> findByBranchId(long branchId,
		int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByBranchId(branchId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first notification send manage in the ordered set where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public static NotificationSendManage findByBranchId_First(long branchId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence().findByBranchId_First(branchId, orderByComparator);
	}

	/**
	* Returns the first notification send manage in the ordered set where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public static NotificationSendManage fetchByBranchId_First(long branchId,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		return getPersistence()
				   .fetchByBranchId_First(branchId, orderByComparator);
	}

	/**
	* Returns the last notification send manage in the ordered set where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public static NotificationSendManage findByBranchId_Last(long branchId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence().findByBranchId_Last(branchId, orderByComparator);
	}

	/**
	* Returns the last notification send manage in the ordered set where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public static NotificationSendManage fetchByBranchId_Last(long branchId,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		return getPersistence().fetchByBranchId_Last(branchId, orderByComparator);
	}

	/**
	* Returns the notification send manages before and after the current notification send manage in the ordered set where branchId = &#63;.
	*
	* @param notifyIdSendId the primary key of the current notification send manage
	* @param branchId the branch ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification send manage
	* @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	*/
	public static NotificationSendManage[] findByBranchId_PrevAndNext(
		long notifyIdSendId, long branchId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence()
				   .findByBranchId_PrevAndNext(notifyIdSendId, branchId,
			orderByComparator);
	}

	/**
	* Removes all the notification send manages where branchId = &#63; from the database.
	*
	* @param branchId the branch ID
	*/
	public static void removeByBranchId(long branchId) {
		getPersistence().removeByBranchId(branchId);
	}

	/**
	* Returns the number of notification send manages where branchId = &#63;.
	*
	* @param branchId the branch ID
	* @return the number of matching notification send manages
	*/
	public static int countByBranchId(long branchId) {
		return getPersistence().countByBranchId(branchId);
	}

	/**
	* Returns the notification send manage where notificationId = &#63; or throws a {@link NoSuchNotificationSendManageException} if it could not be found.
	*
	* @param notificationId the notification ID
	* @return the matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public static NotificationSendManage findByNotificationId(
		long notificationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence().findByNotificationId(notificationId);
	}

	/**
	* Returns the notification send manage where notificationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param notificationId the notification ID
	* @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public static NotificationSendManage fetchByNotificationId(
		long notificationId) {
		return getPersistence().fetchByNotificationId(notificationId);
	}

	/**
	* Returns the notification send manage where notificationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param notificationId the notification ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public static NotificationSendManage fetchByNotificationId(
		long notificationId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByNotificationId(notificationId, retrieveFromCache);
	}

	/**
	* Removes the notification send manage where notificationId = &#63; from the database.
	*
	* @param notificationId the notification ID
	* @return the notification send manage that was removed
	*/
	public static NotificationSendManage removeByNotificationId(
		long notificationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence().removeByNotificationId(notificationId);
	}

	/**
	* Returns the number of notification send manages where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @return the number of matching notification send manages
	*/
	public static int countByNotificationId(long notificationId) {
		return getPersistence().countByNotificationId(notificationId);
	}

	/**
	* Returns all the notification send manages where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @return the matching notification send manages
	*/
	public static List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId) {
		return getPersistence().findByBranchFromNotificationId(notificationId);
	}

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
	public static List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId, int start, int end) {
		return getPersistence()
				   .findByBranchFromNotificationId(notificationId, start, end);
	}

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
	public static List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId, int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		return getPersistence()
				   .findByBranchFromNotificationId(notificationId, start, end,
			orderByComparator);
	}

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
	public static List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId, int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByBranchFromNotificationId(notificationId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first notification send manage in the ordered set where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public static NotificationSendManage findByBranchFromNotificationId_First(
		long notificationId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence()
				   .findByBranchFromNotificationId_First(notificationId,
			orderByComparator);
	}

	/**
	* Returns the first notification send manage in the ordered set where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public static NotificationSendManage fetchByBranchFromNotificationId_First(
		long notificationId,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		return getPersistence()
				   .fetchByBranchFromNotificationId_First(notificationId,
			orderByComparator);
	}

	/**
	* Returns the last notification send manage in the ordered set where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public static NotificationSendManage findByBranchFromNotificationId_Last(
		long notificationId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence()
				   .findByBranchFromNotificationId_Last(notificationId,
			orderByComparator);
	}

	/**
	* Returns the last notification send manage in the ordered set where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public static NotificationSendManage fetchByBranchFromNotificationId_Last(
		long notificationId,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		return getPersistence()
				   .fetchByBranchFromNotificationId_Last(notificationId,
			orderByComparator);
	}

	/**
	* Returns the notification send manages before and after the current notification send manage in the ordered set where notificationId = &#63;.
	*
	* @param notifyIdSendId the primary key of the current notification send manage
	* @param notificationId the notification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification send manage
	* @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	*/
	public static NotificationSendManage[] findByBranchFromNotificationId_PrevAndNext(
		long notifyIdSendId, long notificationId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence()
				   .findByBranchFromNotificationId_PrevAndNext(notifyIdSendId,
			notificationId, orderByComparator);
	}

	/**
	* Removes all the notification send manages where notificationId = &#63; from the database.
	*
	* @param notificationId the notification ID
	*/
	public static void removeByBranchFromNotificationId(long notificationId) {
		getPersistence().removeByBranchFromNotificationId(notificationId);
	}

	/**
	* Returns the number of notification send manages where notificationId = &#63;.
	*
	* @param notificationId the notification ID
	* @return the number of matching notification send manages
	*/
	public static int countByBranchFromNotificationId(long notificationId) {
		return getPersistence().countByBranchFromNotificationId(notificationId);
	}

	/**
	* Returns the notification send manage where notificationId = &#63; and branchId = &#63; or throws a {@link NoSuchNotificationSendManageException} if it could not be found.
	*
	* @param notificationId the notification ID
	* @param branchId the branch ID
	* @return the matching notification send manage
	* @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	*/
	public static NotificationSendManage findByBranchAndNotificationId(
		long notificationId, long branchId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence()
				   .findByBranchAndNotificationId(notificationId, branchId);
	}

	/**
	* Returns the notification send manage where notificationId = &#63; and branchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param notificationId the notification ID
	* @param branchId the branch ID
	* @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public static NotificationSendManage fetchByBranchAndNotificationId(
		long notificationId, long branchId) {
		return getPersistence()
				   .fetchByBranchAndNotificationId(notificationId, branchId);
	}

	/**
	* Returns the notification send manage where notificationId = &#63; and branchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param notificationId the notification ID
	* @param branchId the branch ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	*/
	public static NotificationSendManage fetchByBranchAndNotificationId(
		long notificationId, long branchId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByBranchAndNotificationId(notificationId, branchId,
			retrieveFromCache);
	}

	/**
	* Removes the notification send manage where notificationId = &#63; and branchId = &#63; from the database.
	*
	* @param notificationId the notification ID
	* @param branchId the branch ID
	* @return the notification send manage that was removed
	*/
	public static NotificationSendManage removeByBranchAndNotificationId(
		long notificationId, long branchId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence()
				   .removeByBranchAndNotificationId(notificationId, branchId);
	}

	/**
	* Returns the number of notification send manages where notificationId = &#63; and branchId = &#63;.
	*
	* @param notificationId the notification ID
	* @param branchId the branch ID
	* @return the number of matching notification send manages
	*/
	public static int countByBranchAndNotificationId(long notificationId,
		long branchId) {
		return getPersistence()
				   .countByBranchAndNotificationId(notificationId, branchId);
	}

	/**
	* Caches the notification send manage in the entity cache if it is enabled.
	*
	* @param notificationSendManage the notification send manage
	*/
	public static void cacheResult(
		NotificationSendManage notificationSendManage) {
		getPersistence().cacheResult(notificationSendManage);
	}

	/**
	* Caches the notification send manages in the entity cache if it is enabled.
	*
	* @param notificationSendManages the notification send manages
	*/
	public static void cacheResult(
		List<NotificationSendManage> notificationSendManages) {
		getPersistence().cacheResult(notificationSendManages);
	}

	/**
	* Creates a new notification send manage with the primary key. Does not add the notification send manage to the database.
	*
	* @param notifyIdSendId the primary key for the new notification send manage
	* @return the new notification send manage
	*/
	public static NotificationSendManage create(long notifyIdSendId) {
		return getPersistence().create(notifyIdSendId);
	}

	/**
	* Removes the notification send manage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notifyIdSendId the primary key of the notification send manage
	* @return the notification send manage that was removed
	* @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	*/
	public static NotificationSendManage remove(long notifyIdSendId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence().remove(notifyIdSendId);
	}

	public static NotificationSendManage updateImpl(
		NotificationSendManage notificationSendManage) {
		return getPersistence().updateImpl(notificationSendManage);
	}

	/**
	* Returns the notification send manage with the primary key or throws a {@link NoSuchNotificationSendManageException} if it could not be found.
	*
	* @param notifyIdSendId the primary key of the notification send manage
	* @return the notification send manage
	* @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	*/
	public static NotificationSendManage findByPrimaryKey(long notifyIdSendId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException {
		return getPersistence().findByPrimaryKey(notifyIdSendId);
	}

	/**
	* Returns the notification send manage with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notifyIdSendId the primary key of the notification send manage
	* @return the notification send manage, or <code>null</code> if a notification send manage with the primary key could not be found
	*/
	public static NotificationSendManage fetchByPrimaryKey(long notifyIdSendId) {
		return getPersistence().fetchByPrimaryKey(notifyIdSendId);
	}

	public static java.util.Map<java.io.Serializable, NotificationSendManage> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the notification send manages.
	*
	* @return the notification send manages
	*/
	public static List<NotificationSendManage> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<NotificationSendManage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<NotificationSendManage> findAll(int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<NotificationSendManage> findAll(int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the notification send manages from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of notification send manages.
	*
	* @return the number of notification send manages
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static NotificationSendManagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NotificationSendManagePersistence, NotificationSendManagePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NotificationSendManagePersistence.class);

		ServiceTracker<NotificationSendManagePersistence, NotificationSendManagePersistence> serviceTracker =
			new ServiceTracker<NotificationSendManagePersistence, NotificationSendManagePersistence>(bundle.getBundleContext(),
				NotificationSendManagePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}