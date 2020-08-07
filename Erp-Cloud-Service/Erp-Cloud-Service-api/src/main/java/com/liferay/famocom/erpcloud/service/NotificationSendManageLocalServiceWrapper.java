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
 * Provides a wrapper for {@link NotificationSendManageLocalService}.
 *
 * @author Samaresh
 * @see NotificationSendManageLocalService
 * @generated
 */
@ProviderType
public class NotificationSendManageLocalServiceWrapper
	implements NotificationSendManageLocalService,
		ServiceWrapper<NotificationSendManageLocalService> {
	public NotificationSendManageLocalServiceWrapper(
		NotificationSendManageLocalService notificationSendManageLocalService) {
		_notificationSendManageLocalService = notificationSendManageLocalService;
	}

	/**
	* Adds the notification send manage to the database. Also notifies the appropriate model listeners.
	*
	* @param notificationSendManage the notification send manage
	* @return the notification send manage that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationSendManage addNotificationSendManage(
		com.liferay.famocom.erpcloud.model.NotificationSendManage notificationSendManage) {
		return _notificationSendManageLocalService.addNotificationSendManage(notificationSendManage);
	}

	/**
	* Creates a new notification send manage with the primary key. Does not add the notification send manage to the database.
	*
	* @param notifyIdSendId the primary key for the new notification send manage
	* @return the new notification send manage
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationSendManage createNotificationSendManage(
		long notifyIdSendId) {
		return _notificationSendManageLocalService.createNotificationSendManage(notifyIdSendId);
	}

	/**
	* Deletes the notification send manage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notifyIdSendId the primary key of the notification send manage
	* @return the notification send manage that was removed
	* @throws PortalException if a notification send manage with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationSendManage deleteNotificationSendManage(
		long notifyIdSendId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _notificationSendManageLocalService.deleteNotificationSendManage(notifyIdSendId);
	}

	/**
	* Deletes the notification send manage from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationSendManage the notification send manage
	* @return the notification send manage that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationSendManage deleteNotificationSendManage(
		com.liferay.famocom.erpcloud.model.NotificationSendManage notificationSendManage) {
		return _notificationSendManageLocalService.deleteNotificationSendManage(notificationSendManage);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _notificationSendManageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _notificationSendManageLocalService.dynamicQuery();
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
		return _notificationSendManageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _notificationSendManageLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _notificationSendManageLocalService.dynamicQuery(dynamicQuery,
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
		return _notificationSendManageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _notificationSendManageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.NotificationSendManage fetchNotificationSendManage(
		long notifyIdSendId) {
		return _notificationSendManageLocalService.fetchNotificationSendManage(notifyIdSendId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.NotificationSendManage findByBranchAndNotificationId(
		long notificationId, long branchId) throws Exception {
		return _notificationSendManageLocalService.findByBranchAndNotificationId(notificationId,
			branchId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.NotificationSendManage> findByBranchId(
		long branchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationSendManageLocalService.findByBranchId(branchId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.NotificationSendManage findByNotificationId(
		long notificationId) throws Exception {
		return _notificationSendManageLocalService.findByNotificationId(notificationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _notificationSendManageLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _notificationSendManageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the notification send manage with the primary key.
	*
	* @param notifyIdSendId the primary key of the notification send manage
	* @return the notification send manage
	* @throws PortalException if a notification send manage with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationSendManage getNotificationSendManage(
		long notifyIdSendId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _notificationSendManageLocalService.getNotificationSendManage(notifyIdSendId);
	}

	/**
	* Returns a range of all the notification send manages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification send manages
	* @param end the upper bound of the range of notification send manages (not inclusive)
	* @return the range of notification send manages
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.NotificationSendManage> getNotificationSendManages(
		int start, int end) {
		return _notificationSendManageLocalService.getNotificationSendManages(start,
			end);
	}

	/**
	* Returns the number of notification send manages.
	*
	* @return the number of notification send manages
	*/
	@Override
	public int getNotificationSendManagesCount() {
		return _notificationSendManageLocalService.getNotificationSendManagesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _notificationSendManageLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _notificationSendManageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the notification send manage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notificationSendManage the notification send manage
	* @return the notification send manage that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.NotificationSendManage updateNotificationSendManage(
		com.liferay.famocom.erpcloud.model.NotificationSendManage notificationSendManage) {
		return _notificationSendManageLocalService.updateNotificationSendManage(notificationSendManage);
	}

	@Override
	public NotificationSendManageLocalService getWrappedService() {
		return _notificationSendManageLocalService;
	}

	@Override
	public void setWrappedService(
		NotificationSendManageLocalService notificationSendManageLocalService) {
		_notificationSendManageLocalService = notificationSendManageLocalService;
	}

	private NotificationSendManageLocalService _notificationSendManageLocalService;
}