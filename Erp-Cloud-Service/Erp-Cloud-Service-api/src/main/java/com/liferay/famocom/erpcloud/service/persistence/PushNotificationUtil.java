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

import com.liferay.famocom.erpcloud.model.PushNotification;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the push notification service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.PushNotificationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PushNotificationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PushNotificationPersistenceImpl
 * @generated
 */
@ProviderType
public class PushNotificationUtil {
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
	public static void clearCache(PushNotification pushNotification) {
		getPersistence().clearCache(pushNotification);
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
	public static List<PushNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PushNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PushNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PushNotification> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PushNotification update(PushNotification pushNotification) {
		return getPersistence().update(pushNotification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PushNotification update(PushNotification pushNotification,
		ServiceContext serviceContext) {
		return getPersistence().update(pushNotification, serviceContext);
	}

	/**
	* Caches the push notification in the entity cache if it is enabled.
	*
	* @param pushNotification the push notification
	*/
	public static void cacheResult(PushNotification pushNotification) {
		getPersistence().cacheResult(pushNotification);
	}

	/**
	* Caches the push notifications in the entity cache if it is enabled.
	*
	* @param pushNotifications the push notifications
	*/
	public static void cacheResult(List<PushNotification> pushNotifications) {
		getPersistence().cacheResult(pushNotifications);
	}

	/**
	* Creates a new push notification with the primary key. Does not add the push notification to the database.
	*
	* @param pushNotificationId the primary key for the new push notification
	* @return the new push notification
	*/
	public static PushNotification create(long pushNotificationId) {
		return getPersistence().create(pushNotificationId);
	}

	/**
	* Removes the push notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pushNotificationId the primary key of the push notification
	* @return the push notification that was removed
	* @throws NoSuchPushNotificationException if a push notification with the primary key could not be found
	*/
	public static PushNotification remove(long pushNotificationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPushNotificationException {
		return getPersistence().remove(pushNotificationId);
	}

	public static PushNotification updateImpl(PushNotification pushNotification) {
		return getPersistence().updateImpl(pushNotification);
	}

	/**
	* Returns the push notification with the primary key or throws a {@link NoSuchPushNotificationException} if it could not be found.
	*
	* @param pushNotificationId the primary key of the push notification
	* @return the push notification
	* @throws NoSuchPushNotificationException if a push notification with the primary key could not be found
	*/
	public static PushNotification findByPrimaryKey(long pushNotificationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPushNotificationException {
		return getPersistence().findByPrimaryKey(pushNotificationId);
	}

	/**
	* Returns the push notification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pushNotificationId the primary key of the push notification
	* @return the push notification, or <code>null</code> if a push notification with the primary key could not be found
	*/
	public static PushNotification fetchByPrimaryKey(long pushNotificationId) {
		return getPersistence().fetchByPrimaryKey(pushNotificationId);
	}

	public static java.util.Map<java.io.Serializable, PushNotification> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the push notifications.
	*
	* @return the push notifications
	*/
	public static List<PushNotification> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PushNotification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PushNotification> findAll(int start, int end,
		OrderByComparator<PushNotification> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PushNotification> findAll(int start, int end,
		OrderByComparator<PushNotification> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the push notifications from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of push notifications.
	*
	* @return the number of push notifications
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PushNotificationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PushNotificationPersistence, PushNotificationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PushNotificationPersistence.class);

		ServiceTracker<PushNotificationPersistence, PushNotificationPersistence> serviceTracker =
			new ServiceTracker<PushNotificationPersistence, PushNotificationPersistence>(bundle.getBundleContext(),
				PushNotificationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}