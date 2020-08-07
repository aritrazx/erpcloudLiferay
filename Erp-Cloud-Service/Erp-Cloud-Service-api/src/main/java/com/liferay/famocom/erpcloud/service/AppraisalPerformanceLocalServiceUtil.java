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
 * Provides the local service utility for AppraisalPerformance. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.AppraisalPerformanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see AppraisalPerformanceLocalService
 * @see com.liferay.famocom.erpcloud.service.base.AppraisalPerformanceLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.AppraisalPerformanceLocalServiceImpl
 * @generated
 */
@ProviderType
public class AppraisalPerformanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.AppraisalPerformanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the appraisal performance to the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalPerformance the appraisal performance
	* @return the appraisal performance that was added
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalPerformance addAppraisalPerformance(
		com.liferay.famocom.erpcloud.model.AppraisalPerformance appraisalPerformance) {
		return getService().addAppraisalPerformance(appraisalPerformance);
	}

	/**
	* Creates a new appraisal performance with the primary key. Does not add the appraisal performance to the database.
	*
	* @param appraisalPerformanceId the primary key for the new appraisal performance
	* @return the new appraisal performance
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalPerformance createAppraisalPerformance(
		long appraisalPerformanceId) {
		return getService().createAppraisalPerformance(appraisalPerformanceId);
	}

	/**
	* Deletes the appraisal performance from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalPerformance the appraisal performance
	* @return the appraisal performance that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalPerformance deleteAppraisalPerformance(
		com.liferay.famocom.erpcloud.model.AppraisalPerformance appraisalPerformance) {
		return getService().deleteAppraisalPerformance(appraisalPerformance);
	}

	/**
	* Deletes the appraisal performance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalPerformanceId the primary key of the appraisal performance
	* @return the appraisal performance that was removed
	* @throws PortalException if a appraisal performance with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalPerformance deleteAppraisalPerformance(
		long appraisalPerformanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAppraisalPerformance(appraisalPerformanceId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.AppraisalPerformance fetchAppraisalPerformance(
		long appraisalPerformanceId) {
		return getService().fetchAppraisalPerformance(appraisalPerformanceId);
	}

	public static com.liferay.famocom.erpcloud.model.AppraisalPerformance findByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByApprIdSettingIdAndEmployeeIdPerformance(appraisalId,
			appraisalSettingId, employeeId);
	}

	public static com.liferay.famocom.erpcloud.model.AppraisalPerformance findByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByApprIdSettingIdAndEmployeeIdPerformId(appraisalId,
			appraisalSettingId, employeeId, performanceId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the appraisal performance with the primary key.
	*
	* @param appraisalPerformanceId the primary key of the appraisal performance
	* @return the appraisal performance
	* @throws PortalException if a appraisal performance with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalPerformance getAppraisalPerformance(
		long appraisalPerformanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAppraisalPerformance(appraisalPerformanceId);
	}

	/**
	* Returns a range of all the appraisal performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal performances
	* @param end the upper bound of the range of appraisal performances (not inclusive)
	* @return the range of appraisal performances
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.AppraisalPerformance> getAppraisalPerformances(
		int start, int end) {
		return getService().getAppraisalPerformances(start, end);
	}

	/**
	* Returns the number of appraisal performances.
	*
	* @return the number of appraisal performances
	*/
	public static int getAppraisalPerformancesCount() {
		return getService().getAppraisalPerformancesCount();
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
	* Updates the appraisal performance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appraisalPerformance the appraisal performance
	* @return the appraisal performance that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalPerformance updateAppraisalPerformance(
		com.liferay.famocom.erpcloud.model.AppraisalPerformance appraisalPerformance) {
		return getService().updateAppraisalPerformance(appraisalPerformance);
	}

	public static AppraisalPerformanceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AppraisalPerformanceLocalService, AppraisalPerformanceLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AppraisalPerformanceLocalService.class);

		ServiceTracker<AppraisalPerformanceLocalService, AppraisalPerformanceLocalService> serviceTracker =
			new ServiceTracker<AppraisalPerformanceLocalService, AppraisalPerformanceLocalService>(bundle.getBundleContext(),
				AppraisalPerformanceLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}