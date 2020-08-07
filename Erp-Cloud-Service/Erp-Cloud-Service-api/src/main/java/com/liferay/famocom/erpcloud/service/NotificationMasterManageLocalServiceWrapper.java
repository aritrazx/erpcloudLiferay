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

package com.liferay.famocom.erpcloud.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NotificationMasterManageLocalService}.
 *
 * @author Samaresh
 * @see NotificationMasterManageLocalService
 * @generated
 */
@ProviderType
public class NotificationMasterManageLocalServiceWrapper
	implements NotificationMasterManageLocalService,
		ServiceWrapper<NotificationMasterManageLocalService> {
	public NotificationMasterManageLocalServiceWrapper(
		NotificationMasterManageLocalService notificationMasterManageLocalService) {
		_notificationMasterManageLocalService = notificationMasterManageLocalService;
	}

	/**
	* Adds the notification master manage to the database. Also notifies the appropriate model listeners.
	*
	* @param notificationMasterManage the notification master manage
	* @return the notification master manage that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationMasterManage addNotificationMasterManage(
		com.liferay.famocom.erpcloud.model.NotificationMasterManage notificationMasterManage) {
		return _notificationMasterManageLocalService.addNotificationMasterManage(notificationMasterManage);
	}

	/**
	* Creates a new notification master manage with the primary key. Does not add the notification master manage to the database.
	*
	* @param notifyId the primary key for the new notification master manage
	* @return the new notification master manage
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationMasterManage createNotificationMasterManage(
		long notifyId) {
		return _notificationMasterManageLocalService.createNotificationMasterManage(notifyId);
	}

	/**
	* Deletes the notification master manage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notifyId the primary key of the notification master manage
	* @return the notification master manage that was removed
	* @throws PortalException if a notification master manage with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationMasterManage deleteNotificationMasterManage(
		long notifyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _notificationMasterManageLocalService.deleteNotificationMasterManage(notifyId);
	}

	/**
	* Deletes the notification master manage from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationMasterManage the notification master manage
	* @return the notification master manage that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationMasterManage deleteNotificationMasterManage(
		com.liferay.famocom.erpcloud.model.NotificationMasterManage notificationMasterManage) {
		return _notificationMasterManageLocalService.deleteNotificationMasterManage(notificationMasterManage);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _notificationMasterManageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _notificationMasterManageLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _notificationMasterManageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.NotificationMasterManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _notificationMasterManageLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.NotificationMasterManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _notificationMasterManageLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _notificationMasterManageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _notificationMasterManageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.NotificationMasterManage fetchNotificationMasterManage(
		long notifyId) {
		return _notificationMasterManageLocalService.fetchNotificationMasterManage(notifyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _notificationMasterManageLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _notificationMasterManageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the notification master manage with the primary key.
	*
	* @param notifyId the primary key of the notification master manage
	* @return the notification master manage
	* @throws PortalException if a notification master manage with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationMasterManage getNotificationMasterManage(
		long notifyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _notificationMasterManageLocalService.getNotificationMasterManage(notifyId);
	}

	/**
	* Returns a range of all the notification master manages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.NotificationMasterManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification master manages
	* @param end the upper bound of the range of notification master manages (not inclusive)
	* @return the range of notification master manages
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.NotificationMasterManage> getNotificationMasterManages(
		int start, int end) {
		return _notificationMasterManageLocalService.getNotificationMasterManages(start,
			end);
	}

	/**
	* Returns the number of notification master manages.
	*
	* @return the number of notification master manages
	*/
	@Override
	public int getNotificationMasterManagesCount() {
		return _notificationMasterManageLocalService.getNotificationMasterManagesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _notificationMasterManageLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _notificationMasterManageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the notification master manage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notificationMasterManage the notification master manage
	* @return the notification master manage that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationMasterManage updateNotificationMasterManage(
		com.liferay.famocom.erpcloud.model.NotificationMasterManage notificationMasterManage) {
		return _notificationMasterManageLocalService.updateNotificationMasterManage(notificationMasterManage);
	}

	@Override
	public NotificationMasterManageLocalService getWrappedService() {
		return _notificationMasterManageLocalService;
	}

	@Override
	public void setWrappedService(
		NotificationMasterManageLocalService notificationMasterManageLocalService) {
		_notificationMasterManageLocalService = notificationMasterManageLocalService;
	}

	private NotificationMasterManageLocalService _notificationMasterManageLocalService;
}