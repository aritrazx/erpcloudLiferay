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

import com.liferay.famocom.erpcloud.exception.NoSuchNotificationMasterManageException;
import com.liferay.famocom.erpcloud.model.NotificationMasterManage;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the notification master manage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.NotificationMasterManagePersistenceImpl
 * @see NotificationMasterManageUtil
 * @generated
 */
@ProviderType
public interface NotificationMasterManagePersistence extends BasePersistence<NotificationMasterManage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificationMasterManageUtil} to access the notification master manage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the notification master manage in the entity cache if it is enabled.
	*
	* @param notificationMasterManage the notification master manage
	*/
	public void cacheResult(NotificationMasterManage notificationMasterManage);

	/**
	* Caches the notification master manages in the entity cache if it is enabled.
	*
	* @param notificationMasterManages the notification master manages
	*/
	public void cacheResult(
		java.util.List<NotificationMasterManage> notificationMasterManages);

	/**
	* Creates a new notification master manage with the primary key. Does not add the notification master manage to the database.
	*
	* @param notifyId the primary key for the new notification master manage
	* @return the new notification master manage
	*/
	public NotificationMasterManage create(long notifyId);

	/**
	* Removes the notification master manage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notifyId the primary key of the notification master manage
	* @return the notification master manage that was removed
	* @throws NoSuchNotificationMasterManageException if a notification master manage with the primary key could not be found
	*/
	public NotificationMasterManage remove(long notifyId)
		throws NoSuchNotificationMasterManageException;

	public NotificationMasterManage updateImpl(
		NotificationMasterManage notificationMasterManage);

	/**
	* Returns the notification master manage with the primary key or throws a {@link NoSuchNotificationMasterManageException} if it could not be found.
	*
	* @param notifyId the primary key of the notification master manage
	* @return the notification master manage
	* @throws NoSuchNotificationMasterManageException if a notification master manage with the primary key could not be found
	*/
	public NotificationMasterManage findByPrimaryKey(long notifyId)
		throws NoSuchNotificationMasterManageException;

	/**
	* Returns the notification master manage with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notifyId the primary key of the notification master manage
	* @return the notification master manage, or <code>null</code> if a notification master manage with the primary key could not be found
	*/
	public NotificationMasterManage fetchByPrimaryKey(long notifyId);

	@Override
	public java.util.Map<java.io.Serializable, NotificationMasterManage> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the notification master manages.
	*
	* @return the notification master manages
	*/
	public java.util.List<NotificationMasterManage> findAll();

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
	public java.util.List<NotificationMasterManage> findAll(int start, int end);

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
	public java.util.List<NotificationMasterManage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationMasterManage> orderByComparator);

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
	public java.util.List<NotificationMasterManage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationMasterManage> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the notification master manages from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of notification master manages.
	*
	* @return the number of notification master manages
	*/
	public int countAll();
}