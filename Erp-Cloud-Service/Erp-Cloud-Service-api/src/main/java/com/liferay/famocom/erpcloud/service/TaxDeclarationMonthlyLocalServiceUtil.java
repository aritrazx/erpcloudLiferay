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
 * Provides the local service utility for TaxDeclarationMonthly. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.TaxDeclarationMonthlyLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see TaxDeclarationMonthlyLocalService
 * @see com.liferay.famocom.erpcloud.service.base.TaxDeclarationMonthlyLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.TaxDeclarationMonthlyLocalServiceImpl
 * @generated
 */
@ProviderType
public class TaxDeclarationMonthlyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.TaxDeclarationMonthlyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tax declaration monthly to the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclarationMonthly the tax declaration monthly
	* @return the tax declaration monthly that was added
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly addTaxDeclarationMonthly(
		com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly taxDeclarationMonthly) {
		return getService().addTaxDeclarationMonthly(taxDeclarationMonthly);
	}

	/**
	* Creates a new tax declaration monthly with the primary key. Does not add the tax declaration monthly to the database.
	*
	* @param taxDeclarationMonthlyId the primary key for the new tax declaration monthly
	* @return the new tax declaration monthly
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly createTaxDeclarationMonthly(
		long taxDeclarationMonthlyId) {
		return getService().createTaxDeclarationMonthly(taxDeclarationMonthlyId);
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
	* Deletes the tax declaration monthly with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclarationMonthlyId the primary key of the tax declaration monthly
	* @return the tax declaration monthly that was removed
	* @throws PortalException if a tax declaration monthly with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly deleteTaxDeclarationMonthly(
		long taxDeclarationMonthlyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTaxDeclarationMonthly(taxDeclarationMonthlyId);
	}

	/**
	* Deletes the tax declaration monthly from the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclarationMonthly the tax declaration monthly
	* @return the tax declaration monthly that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly deleteTaxDeclarationMonthly(
		com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly taxDeclarationMonthly) {
		return getService().deleteTaxDeclarationMonthly(taxDeclarationMonthly);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly fetchTaxDeclarationMonthly(
		long taxDeclarationMonthlyId) {
		return getService().fetchTaxDeclarationMonthly(taxDeclarationMonthlyId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly> findTaxDeclarationMonthlyByEmployeeIdAndMonthYears(
		long employeeId, long[] monthYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findTaxDeclarationMonthlyByEmployeeIdAndMonthYears(employeeId,
			monthYear);
	}

	public static com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly findTaxDeclarationMonthlyByMonthYearAndEmployeeId(
		long employeeId, long monthYear)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationMonthlyException {
		return getService()
				   .findTaxDeclarationMonthlyByMonthYearAndEmployeeId(employeeId,
			monthYear);
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
	* Returns a range of all the tax declaration monthlies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declaration monthlies
	* @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	* @return the range of tax declaration monthlies
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly> getTaxDeclarationMonthlies(
		int start, int end) {
		return getService().getTaxDeclarationMonthlies(start, end);
	}

	/**
	* Returns the number of tax declaration monthlies.
	*
	* @return the number of tax declaration monthlies
	*/
	public static int getTaxDeclarationMonthliesCount() {
		return getService().getTaxDeclarationMonthliesCount();
	}

	/**
	* Returns the tax declaration monthly with the primary key.
	*
	* @param taxDeclarationMonthlyId the primary key of the tax declaration monthly
	* @return the tax declaration monthly
	* @throws PortalException if a tax declaration monthly with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly getTaxDeclarationMonthly(
		long taxDeclarationMonthlyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTaxDeclarationMonthly(taxDeclarationMonthlyId);
	}

	/**
	* Updates the tax declaration monthly in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taxDeclarationMonthly the tax declaration monthly
	* @return the tax declaration monthly that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly updateTaxDeclarationMonthly(
		com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly taxDeclarationMonthly) {
		return getService().updateTaxDeclarationMonthly(taxDeclarationMonthly);
	}

	public static TaxDeclarationMonthlyLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaxDeclarationMonthlyLocalService, TaxDeclarationMonthlyLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaxDeclarationMonthlyLocalService.class);

		ServiceTracker<TaxDeclarationMonthlyLocalService, TaxDeclarationMonthlyLocalService> serviceTracker =
			new ServiceTracker<TaxDeclarationMonthlyLocalService, TaxDeclarationMonthlyLocalService>(bundle.getBundleContext(),
				TaxDeclarationMonthlyLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}