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
 * Provides the local service utility for LeaveManagement. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.LeaveManagementLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see LeaveManagementLocalService
 * @see com.liferay.famocom.erpcloud.service.base.LeaveManagementLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.LeaveManagementLocalServiceImpl
 * @generated
 */
@ProviderType
public class LeaveManagementLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.LeaveManagementLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the leave management to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveManagement the leave management
	* @return the leave management that was added
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveManagement addLeaveManagement(
		com.liferay.famocom.erpcloud.model.LeaveManagement leaveManagement) {
		return getService().addLeaveManagement(leaveManagement);
	}

	/**
	* Creates a new leave management with the primary key. Does not add the leave management to the database.
	*
	* @param leaveId the primary key for the new leave management
	* @return the new leave management
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveManagement createLeaveManagement(
		long leaveId) {
		return getService().createLeaveManagement(leaveId);
	}

	/**
	* Deletes the leave management from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveManagement the leave management
	* @return the leave management that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveManagement deleteLeaveManagement(
		com.liferay.famocom.erpcloud.model.LeaveManagement leaveManagement) {
		return getService().deleteLeaveManagement(leaveManagement);
	}

	/**
	* Deletes the leave management with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveId the primary key of the leave management
	* @return the leave management that was removed
	* @throws PortalException if a leave management with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveManagement deleteLeaveManagement(
		long leaveId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLeaveManagement(leaveId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.LeaveManagement fetchLeaveManagement(
		long leaveId) {
		return getService().fetchLeaveManagement(leaveId);
	}

	public static com.liferay.famocom.erpcloud.model.LeaveManagement findByleaveName(
		String leaveName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByleaveName(leaveName);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the leave management with the primary key.
	*
	* @param leaveId the primary key of the leave management
	* @return the leave management
	* @throws PortalException if a leave management with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveManagement getLeaveManagement(
		long leaveId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLeaveManagement(leaveId);
	}

	/**
	* Returns a range of all the leave managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave managements
	* @param end the upper bound of the range of leave managements (not inclusive)
	* @return the range of leave managements
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.LeaveManagement> getLeaveManagements(
		int start, int end) {
		return getService().getLeaveManagements(start, end);
	}

	/**
	* Returns the number of leave managements.
	*
	* @return the number of leave managements
	*/
	public static int getLeaveManagementsCount() {
		return getService().getLeaveManagementsCount();
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
	* Updates the leave management in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveManagement the leave management
	* @return the leave management that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveManagement updateLeaveManagement(
		com.liferay.famocom.erpcloud.model.LeaveManagement leaveManagement) {
		return getService().updateLeaveManagement(leaveManagement);
	}

	public static LeaveManagementLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LeaveManagementLocalService, LeaveManagementLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LeaveManagementLocalService.class);

		ServiceTracker<LeaveManagementLocalService, LeaveManagementLocalService> serviceTracker =
			new ServiceTracker<LeaveManagementLocalService, LeaveManagementLocalService>(bundle.getBundleContext(),
				LeaveManagementLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}