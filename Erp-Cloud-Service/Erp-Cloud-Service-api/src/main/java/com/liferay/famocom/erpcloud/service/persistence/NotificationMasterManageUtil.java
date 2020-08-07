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

import com.liferay.famocom.erpcloud.model.NotificationMasterManage;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the notification master manage service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.NotificationMasterManagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see NotificationMasterManagePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.NotificationMasterManagePersistenceImpl
 * @generated
 */
@ProviderType
public class NotificationMasterManageUtil {
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
	public static void clearCache(
		NotificationMasterManage notificationMasterManage) {
		getPersistence().clearCache(notificationMasterManage);
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
	public static List<NotificationMasterManage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NotificationMasterManage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NotificationMasterManage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<NotificationMasterManage> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static NotificationMasterManage update(
		NotificationMasterManage notificationMasterManage) {
		return getPersistence().update(notificationMasterManage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static NotificationMasterManage update(
		NotificationMasterManage notificationMasterManage,
		ServiceContext serviceContext) {
		return getPersistence().update(notificationMasterManage, serviceContext);
	}

	/**
	* Caches the notification master manage in the entity cache if it is enabled.
	*
	* @param notificationMasterManage the notification master manage
	*/
	public static void cacheResult(
		NotificationMasterManage notificationMasterManage) {
		getPersistence().cacheResult(notificationMasterManage);
	}

	/**
	* Caches the notification master manages in the entity cache if it is enabled.
	*
	* @param notificationMasterManages the notification master manages
	*/
	public static void cacheResult(
		List<NotificationMasterManage> notificationMasterManages) {
		getPersistence().cacheResult(notificationMasterManages);
	}

	/**
	* Creates a new notification master manage with the primary key. Does not add the notification master manage to the database.
	*
	* @param notifyId the primary key for the new notification master manage
	* @return the new notification master manage
	*/
	public static NotificationMasterManage create(long notifyId) {
		return getPersistence().create(notifyId);
	}

	/**
	* Removes the notification master manage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notifyId the primary key of the notification master manage
	* @return the notification master manage that was removed
	* @throws NoSuchNotificationMasterManageException if a notification master manage with the primary key could not be found
	*/
	public static NotificationMasterManage remove(long notifyId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationMasterManageException {
		return getPersistence().remove(notifyId);
	}

	public static NotificationMasterManage updateImpl(
		NotificationMasterManage notificationMasterManage) {
		return getPersistence().updateImpl(notificationMasterManage);
	}

	/**
	* Returns the notification master manage with the primary key or throws a {@link NoSuchNotificationMasterManageException} if it could not be found.
	*
	* @param notifyId the primary key of the notification master manage
	* @return the notification master manage
	* @throws NoSuchNotificationMasterManageException if a notification master manage with the primary key could not be found
	*/
	public static NotificationMasterManage findByPrimaryKey(long notifyId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchNotificationMasterManageException {
		return getPersistence().findByPrimaryKey(notifyId);
	}

	/**
	* Returns the notification master manage with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notifyId the primary key of the notification master manage
	* @return the notification master manage, or <code>null</code> if a notification master manage with the primary key could not be found
	*/
	public static NotificationMasterManage fetchByPrimaryKey(long notifyId) {
		return getPersistence().fetchByPrimaryKey(notifyId);
	}

	public static java.util.Map<java.io.Serializable, NotificationMasterManage> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the notification master manages.
	*
	* @return the notification master manages
	*/
	public static List<NotificationMasterManage> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the notification master manages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationMasterManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification master manages
	* @param end the upper bound of the range of notification master manages (not inclusive)
	* @return the range of notification master manages
	*/
	public static List<NotificationMasterManage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the notification master manages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationMasterManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification master manages
	* @param end the upper bound of the range of notification master manages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notification master manages
	*/
	public static List<NotificationMasterManage> findAll(int start, int end,
		OrderByComparator<NotificationMasterManage> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the notification master manages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationMasterManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification master manages
	* @param end the upper bound of the range of notification master manages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of notification master manages
	*/
	public static List<NotificationMasterManage> findAll(int start, int end,
		OrderByComparator<NotificationMasterManage> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the notification master manages from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of notification master manages.
	*
	* @return the number of notification master manages
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NotificationMasterManagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NotificationMasterManagePersistence, NotificationMasterManagePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NotificationMasterManagePersistence.class);

		ServiceTracker<NotificationMasterManagePersistence, NotificationMasterManagePersistence> serviceTracker =
			new ServiceTracker<NotificationMasterManagePersistence, NotificationMasterManagePersistence>(bundle.getBundleContext(),
				NotificationMasterManagePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}