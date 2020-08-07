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
 * Provides the local service utility for LeaveOb. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.LeaveObLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see LeaveObLocalService
 * @see com.liferay.famocom.erpcloud.service.base.LeaveObLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.LeaveObLocalServiceImpl
 * @generated
 */
@ProviderType
public class LeaveObLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.LeaveObLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the leave ob to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveOb the leave ob
	* @return the leave ob that was added
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveOb addLeaveOb(
		com.liferay.famocom.erpcloud.model.LeaveOb leaveOb) {
		return getService().addLeaveOb(leaveOb);
	}

	/**
	* Creates a new leave ob with the primary key. Does not add the leave ob to the database.
	*
	* @param leaveobId the primary key for the new leave ob
	* @return the new leave ob
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveOb createLeaveOb(
		long leaveobId) {
		return getService().createLeaveOb(leaveobId);
	}

	/**
	* Deletes the leave ob from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveOb the leave ob
	* @return the leave ob that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveOb deleteLeaveOb(
		com.liferay.famocom.erpcloud.model.LeaveOb leaveOb) {
		return getService().deleteLeaveOb(leaveOb);
	}

	/**
	* Deletes the leave ob with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveobId the primary key of the leave ob
	* @return the leave ob that was removed
	* @throws PortalException if a leave ob with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveOb deleteLeaveOb(
		long leaveobId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLeaveOb(leaveobId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.LeaveOb fetchLeaveOb(
		long leaveobId) {
		return getService().fetchLeaveOb(leaveobId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the leave ob with the primary key.
	*
	* @param leaveobId the primary key of the leave ob
	* @return the leave ob
	* @throws PortalException if a leave ob with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveOb getLeaveOb(
		long leaveobId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLeaveOb(leaveobId);
	}

	/**
	* Returns a range of all the leave obs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave obs
	* @param end the upper bound of the range of leave obs (not inclusive)
	* @return the range of leave obs
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.LeaveOb> getLeaveObs(
		int start, int end) {
		return getService().getLeaveObs(start, end);
	}

	/**
	* Returns the number of leave obs.
	*
	* @return the number of leave obs
	*/
	public static int getLeaveObsCount() {
		return getService().getLeaveObsCount();
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

	public static com.liferay.famocom.erpcloud.model.LeaveOb openingBalance(
		long employeeId, long leaveTypeId) {
		return getService().openingBalance(employeeId, leaveTypeId);
	}

	/**
	* Updates the leave ob in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveOb the leave ob
	* @return the leave ob that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveOb updateLeaveOb(
		com.liferay.famocom.erpcloud.model.LeaveOb leaveOb) {
		return getService().updateLeaveOb(leaveOb);
	}

	public static LeaveObLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LeaveObLocalService, LeaveObLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LeaveObLocalService.class);

		ServiceTracker<LeaveObLocalService, LeaveObLocalService> serviceTracker = new ServiceTracker<LeaveObLocalService, LeaveObLocalService>(bundle.getBundleContext(),
				LeaveObLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}