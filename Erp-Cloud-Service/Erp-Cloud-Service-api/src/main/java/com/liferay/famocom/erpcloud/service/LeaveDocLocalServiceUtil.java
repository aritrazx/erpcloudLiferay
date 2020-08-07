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
 * Provides the local service utility for LeaveDoc. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.LeaveDocLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see LeaveDocLocalService
 * @see com.liferay.famocom.erpcloud.service.base.LeaveDocLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.LeaveDocLocalServiceImpl
 * @generated
 */
@ProviderType
public class LeaveDocLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.LeaveDocLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the leave doc to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveDoc the leave doc
	* @return the leave doc that was added
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveDoc addLeaveDoc(
		com.liferay.famocom.erpcloud.model.LeaveDoc leaveDoc) {
		return getService().addLeaveDoc(leaveDoc);
	}

	/**
	* Creates a new leave doc with the primary key. Does not add the leave doc to the database.
	*
	* @param leaveDocId the primary key for the new leave doc
	* @return the new leave doc
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveDoc createLeaveDoc(
		long leaveDocId) {
		return getService().createLeaveDoc(leaveDocId);
	}

	/**
	* Deletes the leave doc from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveDoc the leave doc
	* @return the leave doc that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveDoc deleteLeaveDoc(
		com.liferay.famocom.erpcloud.model.LeaveDoc leaveDoc) {
		return getService().deleteLeaveDoc(leaveDoc);
	}

	/**
	* Deletes the leave doc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveDocId the primary key of the leave doc
	* @return the leave doc that was removed
	* @throws PortalException if a leave doc with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveDoc deleteLeaveDoc(
		long leaveDocId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLeaveDoc(leaveDocId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.LeaveDoc fetchLeaveDoc(
		long leaveDocId) {
		return getService().fetchLeaveDoc(leaveDocId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.LeaveDoc> getDocsByLeaveApplyId(
		long leaveApplyId) {
		return getService().getDocsByLeaveApplyId(leaveApplyId);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the leave doc with the primary key.
	*
	* @param leaveDocId the primary key of the leave doc
	* @return the leave doc
	* @throws PortalException if a leave doc with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveDoc getLeaveDoc(
		long leaveDocId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLeaveDoc(leaveDocId);
	}

	/**
	* Returns a range of all the leave docs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave docs
	* @param end the upper bound of the range of leave docs (not inclusive)
	* @return the range of leave docs
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.LeaveDoc> getLeaveDocs(
		int start, int end) {
		return getService().getLeaveDocs(start, end);
	}

	/**
	* Returns the number of leave docs.
	*
	* @return the number of leave docs
	*/
	public static int getLeaveDocsCount() {
		return getService().getLeaveDocsCount();
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
	* Updates the leave doc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveDoc the leave doc
	* @return the leave doc that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.LeaveDoc updateLeaveDoc(
		com.liferay.famocom.erpcloud.model.LeaveDoc leaveDoc) {
		return getService().updateLeaveDoc(leaveDoc);
	}

	public static LeaveDocLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LeaveDocLocalService, LeaveDocLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LeaveDocLocalService.class);

		ServiceTracker<LeaveDocLocalService, LeaveDocLocalService> serviceTracker =
			new ServiceTracker<LeaveDocLocalService, LeaveDocLocalService>(bundle.getBundleContext(),
				LeaveDocLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}