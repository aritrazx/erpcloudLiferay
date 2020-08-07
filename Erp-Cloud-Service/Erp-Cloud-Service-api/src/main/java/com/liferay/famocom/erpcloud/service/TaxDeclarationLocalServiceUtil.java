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
 * Provides the local service utility for TaxDeclaration. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.TaxDeclarationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see TaxDeclarationLocalService
 * @see com.liferay.famocom.erpcloud.service.base.TaxDeclarationLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.TaxDeclarationLocalServiceImpl
 * @generated
 */
@ProviderType
public class TaxDeclarationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.TaxDeclarationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tax declaration to the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclaration the tax declaration
	* @return the tax declaration that was added
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclaration addTaxDeclaration(
		com.liferay.famocom.erpcloud.model.TaxDeclaration taxDeclaration) {
		return getService().addTaxDeclaration(taxDeclaration);
	}

	/**
	* Creates a new tax declaration with the primary key. Does not add the tax declaration to the database.
	*
	* @param taxDeclarationId the primary key for the new tax declaration
	* @return the new tax declaration
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclaration createTaxDeclaration(
		long taxDeclarationId) {
		return getService().createTaxDeclaration(taxDeclarationId);
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
	* Deletes the tax declaration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclarationId the primary key of the tax declaration
	* @return the tax declaration that was removed
	* @throws PortalException if a tax declaration with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclaration deleteTaxDeclaration(
		long taxDeclarationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTaxDeclaration(taxDeclarationId);
	}

	/**
	* Deletes the tax declaration from the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclaration the tax declaration
	* @return the tax declaration that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclaration deleteTaxDeclaration(
		com.liferay.famocom.erpcloud.model.TaxDeclaration taxDeclaration) {
		return getService().deleteTaxDeclaration(taxDeclaration);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.TaxDeclaration fetchTaxDeclaration(
		long taxDeclarationId) {
		return getService().fetchTaxDeclaration(taxDeclarationId);
	}

	public static com.liferay.famocom.erpcloud.model.TaxDeclaration findByemployeeIdAndFinancialYear(
		long employeeId, String financialYear) {
		return getService()
				   .findByemployeeIdAndFinancialYear(employeeId, financialYear);
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
	* Returns the tax declaration with the primary key.
	*
	* @param taxDeclarationId the primary key of the tax declaration
	* @return the tax declaration
	* @throws PortalException if a tax declaration with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclaration getTaxDeclaration(
		long taxDeclarationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTaxDeclaration(taxDeclarationId);
	}

	public static com.liferay.famocom.erpcloud.model.TaxDeclaration getTaxDeclarationByEmployeeId(
		long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException {
		return getService().getTaxDeclarationByEmployeeId(employeeId);
	}

	/**
	* Returns a range of all the tax declarations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declarations
	* @param end the upper bound of the range of tax declarations (not inclusive)
	* @return the range of tax declarations
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.TaxDeclaration> getTaxDeclarations(
		int start, int end) {
		return getService().getTaxDeclarations(start, end);
	}

	/**
	* Returns the number of tax declarations.
	*
	* @return the number of tax declarations
	*/
	public static int getTaxDeclarationsCount() {
		return getService().getTaxDeclarationsCount();
	}

	/**
	* Updates the tax declaration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taxDeclaration the tax declaration
	* @return the tax declaration that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.TaxDeclaration updateTaxDeclaration(
		com.liferay.famocom.erpcloud.model.TaxDeclaration taxDeclaration) {
		return getService().updateTaxDeclaration(taxDeclaration);
	}

	public static TaxDeclarationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaxDeclarationLocalService, TaxDeclarationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaxDeclarationLocalService.class);

		ServiceTracker<TaxDeclarationLocalService, TaxDeclarationLocalService> serviceTracker =
			new ServiceTracker<TaxDeclarationLocalService, TaxDeclarationLocalService>(bundle.getBundleContext(),
				TaxDeclarationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}