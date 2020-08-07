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
 * Provides the local service utility for SchedulesDetails. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.SchedulesDetailsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see SchedulesDetailsLocalService
 * @see com.liferay.famocom.erpcloud.service.base.SchedulesDetailsLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.SchedulesDetailsLocalServiceImpl
 * @generated
 */
@ProviderType
public class SchedulesDetailsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.SchedulesDetailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the schedules details to the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesDetails the schedules details
	* @return the schedules details that was added
	*/
	public static com.liferay.famocom.erpcloud.model.SchedulesDetails addSchedulesDetails(
		com.liferay.famocom.erpcloud.model.SchedulesDetails schedulesDetails) {
		return getService().addSchedulesDetails(schedulesDetails);
	}

	/**
	* Creates a new schedules details with the primary key. Does not add the schedules details to the database.
	*
	* @param schedulesDetailsId the primary key for the new schedules details
	* @return the new schedules details
	*/
	public static com.liferay.famocom.erpcloud.model.SchedulesDetails createSchedulesDetails(
		long schedulesDetailsId) {
		return getService().createSchedulesDetails(schedulesDetailsId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the schedules details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesDetailsId the primary key of the schedules details
	* @return the schedules details that was removed
	* @throws PortalException if a schedules details with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.SchedulesDetails deleteSchedulesDetails(
		long schedulesDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSchedulesDetails(schedulesDetailsId);
	}

	/**
	* Deletes the schedules details from the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesDetails the schedules details
	* @return the schedules details that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.SchedulesDetails deleteSchedulesDetails(
		com.liferay.famocom.erpcloud.model.SchedulesDetails schedulesDetails) {
		return getService().deleteSchedulesDetails(schedulesDetails);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.SchedulesDetails fetchSchedulesDetails(
		long schedulesDetailsId) {
		return getService().fetchSchedulesDetails(schedulesDetailsId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.SchedulesDetails> findBycheckDate(
		long employeeId, long companyId, java.util.Date schedulesDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return getService().findBycheckDate(employeeId, companyId, schedulesDate);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.SchedulesDetails> findBydetailsEdit(
		long worksSchedulesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return getService().findBydetailsEdit(worksSchedulesId);
	}

	public static com.liferay.famocom.erpcloud.model.SchedulesDetails findByempIdAndAttDate(
		long employeeId, java.util.Date schedulesDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByempIdAndAttDate(employeeId, schedulesDate);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
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
	* Returns the schedules details with the primary key.
	*
	* @param schedulesDetailsId the primary key of the schedules details
	* @return the schedules details
	* @throws PortalException if a schedules details with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.SchedulesDetails getSchedulesDetails(
		long schedulesDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSchedulesDetails(schedulesDetailsId);
	}

	/**
	* Returns a range of all the schedules detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SchedulesDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules detailses
	* @param end the upper bound of the range of schedules detailses (not inclusive)
	* @return the range of schedules detailses
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.SchedulesDetails> getSchedulesDetailses(
		int start, int end) {
		return getService().getSchedulesDetailses(start, end);
	}

	/**
	* Returns the number of schedules detailses.
	*
	* @return the number of schedules detailses
	*/
	public static int getSchedulesDetailsesCount() {
		return getService().getSchedulesDetailsesCount();
	}

	/**
	* Updates the schedules details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param schedulesDetails the schedules details
	* @return the schedules details that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.SchedulesDetails updateSchedulesDetails(
		com.liferay.famocom.erpcloud.model.SchedulesDetails schedulesDetails) {
		return getService().updateSchedulesDetails(schedulesDetails);
	}

	public static SchedulesDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SchedulesDetailsLocalService, SchedulesDetailsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SchedulesDetailsLocalService.class);

		ServiceTracker<SchedulesDetailsLocalService, SchedulesDetailsLocalService> serviceTracker =
			new ServiceTracker<SchedulesDetailsLocalService, SchedulesDetailsLocalService>(bundle.getBundleContext(),
				SchedulesDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}