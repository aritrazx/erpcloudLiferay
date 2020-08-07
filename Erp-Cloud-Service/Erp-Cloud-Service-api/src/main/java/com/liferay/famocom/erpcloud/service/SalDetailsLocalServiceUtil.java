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
 * Provides the local service utility for SalDetails. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.SalDetailsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see SalDetailsLocalService
 * @see com.liferay.famocom.erpcloud.service.base.SalDetailsLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.SalDetailsLocalServiceImpl
 * @generated
 */
@ProviderType
public class SalDetailsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.SalDetailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the sal details to the database. Also notifies the appropriate model listeners.
	*
	* @param salDetails the sal details
	* @return the sal details that was added
	*/
	public static com.liferay.famocom.erpcloud.model.SalDetails addSalDetails(
		com.liferay.famocom.erpcloud.model.SalDetails salDetails) {
		return getService().addSalDetails(salDetails);
	}

	/**
	* Creates a new sal details with the primary key. Does not add the sal details to the database.
	*
	* @param SalDetailsId the primary key for the new sal details
	* @return the new sal details
	*/
	public static com.liferay.famocom.erpcloud.model.SalDetails createSalDetails(
		long SalDetailsId) {
		return getService().createSalDetails(SalDetailsId);
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
	* Deletes the sal details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SalDetailsId the primary key of the sal details
	* @return the sal details that was removed
	* @throws PortalException if a sal details with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.SalDetails deleteSalDetails(
		long SalDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSalDetails(SalDetailsId);
	}

	/**
	* Deletes the sal details from the database. Also notifies the appropriate model listeners.
	*
	* @param salDetails the sal details
	* @return the sal details that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.SalDetails deleteSalDetails(
		com.liferay.famocom.erpcloud.model.SalDetails salDetails) {
		return getService().deleteSalDetails(salDetails);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.SalDetails fetchSalDetails(
		long SalDetailsId) {
		return getService().fetchSalDetails(SalDetailsId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByEmployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findSalDetailsByEmployeeId(employeeId);
	}

	public static com.liferay.famocom.erpcloud.model.SalDetails findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return getService()
				   .findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(employeeId,
			componentId, monthYear);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByEmployeeIdAndComponentIdAndmonthYears(
		long employeeId, long payComponentIds, long[] monthYears)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findSalDetailsByEmployeeIdAndComponentIdAndmonthYears(employeeId,
			payComponentIds, monthYears);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByEmployeeIdAndComponentIdsAndmonthYears(
		long employeeId, long[] payComponentIds, long[] monthYears)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findSalDetailsByEmployeeIdAndComponentIdsAndmonthYears(employeeId,
			payComponentIds, monthYears);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByEmployeeIdAndMonthYearAndComponentIds(
		long employeeId, long monthYear, long[] payComponentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findSalDetailsByEmployeeIdAndMonthYearAndComponentIds(employeeId,
			monthYear, payComponentIds);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByEmployeeIdAndMonthYears(
		long employeeId, long[] monthYears)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findSalDetailsByEmployeeIdAndMonthYears(employeeId,
			monthYears);
	}

	public static java.util.List<String[]> findSalDetailsByEmployeeIdAndYear(
		long employeeId, int year) {
		return getService().findSalDetailsByEmployeeIdAndYear(employeeId, year);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByMonthYear(
		long monthYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findSalDetailsByMonthYear(monthYear);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByMonthYearAndEmployeeId(
		long monthYear, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findSalDetailsByMonthYearAndEmployeeId(monthYear, employeeId);
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
	* Returns the sal details with the primary key.
	*
	* @param SalDetailsId the primary key of the sal details
	* @return the sal details
	* @throws PortalException if a sal details with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.SalDetails getSalDetails(
		long SalDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSalDetails(SalDetailsId);
	}

	/**
	* Returns a range of all the sal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of sal detailses
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> getSalDetailses(
		int start, int end) {
		return getService().getSalDetailses(start, end);
	}

	/**
	* Returns the number of sal detailses.
	*
	* @return the number of sal detailses
	*/
	public static int getSalDetailsesCount() {
		return getService().getSalDetailsesCount();
	}

	/**
	* Updates the sal details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param salDetails the sal details
	* @return the sal details that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.SalDetails updateSalDetails(
		com.liferay.famocom.erpcloud.model.SalDetails salDetails) {
		return getService().updateSalDetails(salDetails);
	}

	public static SalDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SalDetailsLocalService, SalDetailsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SalDetailsLocalService.class);

		ServiceTracker<SalDetailsLocalService, SalDetailsLocalService> serviceTracker =
			new ServiceTracker<SalDetailsLocalService, SalDetailsLocalService>(bundle.getBundleContext(),
				SalDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}