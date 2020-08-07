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

import com.liferay.famocom.erpcloud.exception.NoSuchPushNotificationException;
import com.liferay.famocom.erpcloud.model.PushNotification;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the push notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PushNotificationPersistenceImpl
 * @see PushNotificationUtil
 * @generated
 */
@ProviderType
public interface PushNotificationPersistence extends BasePersistence<PushNotification> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PushNotificationUtil} to access the push notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the push notification in the entity cache if it is enabled.
	*
	* @param pushNotification the push notification
	*/
	public void cacheResult(PushNotification pushNotification);

	/**
	* Caches the push notifications in the entity cache if it is enabled.
	*
	* @param pushNotifications the push notifications
	*/
	public void cacheResult(java.util.List<PushNotification> pushNotifications);

	/**
	* Creates a new push notification with the primary key. Does not add the push notification to the database.
	*
	* @param pushNotificationId the primary key for the new push notification
	* @return the new push notification
	*/
	public PushNotification create(long pushNotificationId);

	/**
	* Removes the push notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pushNotificationId the primary key of the push notification
	* @return the push notification that was removed
	* @throws NoSuchPushNotificationException if a push notification with the primary key could not be found
	*/
	public PushNotification remove(long pushNotificationId)
		throws NoSuchPushNotificationException;

	public PushNotification updateImpl(PushNotification pushNotification);

	/**
	* Returns the push notification with the primary key or throws a {@link NoSuchPushNotificationException} if it could not be found.
	*
	* @param pushNotificationId the primary key of the push notification
	* @return the push notification
	* @throws NoSuchPushNotificationException if a push notification with the primary key could not be found
	*/
	public PushNotification findByPrimaryKey(long pushNotificationId)
		throws NoSuchPushNotificationException;

	/**
	* Returns the push notification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pushNotificationId the primary key of the push notification
	* @return the push notification, or <code>null</code> if a push notification with the primary key could not be found
	*/
	public PushNotification fetchByPrimaryKey(long pushNotificationId);

	@Override
	public java.util.Map<java.io.Serializable, PushNotification> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the push notifications.
	*
	* @return the push notifications
	*/
	public java.util.List<PushNotification> findAll();

	/**
	* Returns a range of all the push notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PushNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of push notifications
	* @param end the upper bound of the range of push notifications (not inclusive)
	* @return the range of push notifications
	*/
	public java.util.List<PushNotification> findAll(int start, int end);

	/**
	* Returns an ordered range of all the push notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PushNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of push notifications
	* @param end the upper bound of the range of push notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of push notifications
	*/
	public java.util.List<PushNotification> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PushNotification> orderByComparator);

	/**
	* Returns an ordered range of all the push notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PushNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of push notifications
	* @param end the upper bound of the range of push notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of push notifications
	*/
	public java.util.List<PushNotification> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PushNotification> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the push notifications from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of push notifications.
	*
	* @return the number of push notifications
	*/
	public int countAll();
}