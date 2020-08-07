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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for NotificationSendManage. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.NotificationSendManageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see NotificationSendManageLocalService
 * @see com.liferay.famocom.erpcloud.service.base.NotificationSendManageLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.NotificationSendManageLocalServiceImpl
 * @generated
 */
@ProviderType
public class NotificationSendManageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.NotificationSendManageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the notification send manage to the database. Also notifies the appropriate model listeners.
	*
	* @param notificationSendManage the notification send manage
	* @return the notification send manage that was added
	*/
	public static com.liferay.famocom.erpcloud.model.NotificationSendManage addNotificationSendManage(
		com.liferay.famocom.erpcloud.model.NotificationSendManage notificationSendManage) {
		return getService().addNotificationSendManage(notificationSendManage);
	}

	/**
	* Creates a new notification send manage with the primary key. Does not add the notification send manage to the database.
	*
	* @param notifyIdSendId the primary key for the new notification send manage
	* @return the new notification send manage
	*/
	public static com.liferay.famocom.erpcloud.model.NotificationSendManage createNotificationSendManage(
		long notifyIdSendId) {
		return getService().createNotificationSendManage(notifyIdSendId);
	}

	/**
	* Deletes the notification send manage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notifyIdSendId the primary key of the notification send manage
	* @return the notification send manage that was removed
	* @throws PortalException if a notification send manage with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.NotificationSendManage deleteNotificationSendManage(
		long notifyIdSendId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteNotificationSendManage(notifyIdSendId);
	}

	/**
	* Deletes the notification send manage from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationSendManage the notification send manage
	* @return the notification send manage that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.NotificationSendManage deleteNotificationSendManage(
		com.liferay.famocom.erpcloud.model.NotificationSendManage notificationSendManage) {
		return getService().deleteNotificationSendManage(notificationSendManage);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.famocom.erpcloud.model.NotificationSendManage fetchNotificationSendManage(
		long notifyIdSendId) {
		return getService().fetchNotificationSendManage(notifyIdSendId);
	}

	public static com.liferay.famocom.erpcloud.model.NotificationSendManage findByBranchAndNotificationId(
		long notificationId, long branchId) throws Exception {
		return getService()
				   .findByBranchAndNotificationId(notificationId, branchId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.NotificationSendManage> findByBranchId(
		long branchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByBranchId(branchId);
	}

	public static com.liferay.famocom.erpcloud.model.NotificationSendManage findByNotificationId(
		long notificationId) throws Exception {
		return getService().findByNotificationId(notificationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the notification send manage with the primary key.
	*
	* @param notifyIdSendId the primary key of the notification send manage
	* @return the notification send manage
	* @throws PortalException if a notification send manage with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.NotificationSendManage getNotificationSendManage(
		long notifyIdSendId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getNotificationSendManage(notifyIdSendId);
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
	public static java.util.List<com.liferay.famocom.erpcloud.model.NotificationSendManage> getNotificationSendManages(
		int start, int end) {
		return getService().getNotificationSendManages(start, end);
	}

	/**
	* Returns the number of notification send manages.
	*
	* @return the number of notification send manages
	*/
	public static int getNotificationSendManagesCount() {
		return getService().getNotificationSendManagesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the notification send manage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notificationSendManage the notification send manage
	* @return the notification send manage that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.NotificationSendManage updateNotificationSendManage(
		com.liferay.famocom.erpcloud.model.NotificationSendManage notificationSendManage) {
		return getService().updateNotificationSendManage(notificationSendManage);
	}

	public static NotificationSendManageLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NotificationSendManageLocalService, NotificationSendManageLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NotificationSendManageLocalService.class);

		ServiceTracker<NotificationSendManageLocalService, NotificationSendManageLocalService> serviceTracker =
			new ServiceTracker<NotificationSendManageLocalService, NotificationSendManageLocalService>(bundle.getBundleContext(),
				NotificationSendManageLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}