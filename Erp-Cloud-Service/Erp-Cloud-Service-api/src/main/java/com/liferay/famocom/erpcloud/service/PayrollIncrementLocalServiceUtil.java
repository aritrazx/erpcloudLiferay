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
 * Provides the local service utility for PayrollIncrement. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.PayrollIncrementLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see PayrollIncrementLocalService
 * @see com.liferay.famocom.erpcloud.service.base.PayrollIncrementLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.PayrollIncrementLocalServiceImpl
 * @generated
 */
@ProviderType
public class PayrollIncrementLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.PayrollIncrementLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the payroll increment to the database. Also notifies the appropriate model listeners.
	*
	* @param payrollIncrement the payroll increment
	* @return the payroll increment that was added
	*/
	public static com.liferay.famocom.erpcloud.model.PayrollIncrement addPayrollIncrement(
		com.liferay.famocom.erpcloud.model.PayrollIncrement payrollIncrement) {
		return getService().addPayrollIncrement(payrollIncrement);
	}

	/**
	* Creates a new payroll increment with the primary key. Does not add the payroll increment to the database.
	*
	* @param payrollIncrementId the primary key for the new payroll increment
	* @return the new payroll increment
	*/
	public static com.liferay.famocom.erpcloud.model.PayrollIncrement createPayrollIncrement(
		long payrollIncrementId) {
		return getService().createPayrollIncrement(payrollIncrementId);
	}

	/**
	* Deletes the payroll increment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param payrollIncrementId the primary key of the payroll increment
	* @return the payroll increment that was removed
	* @throws PortalException if a payroll increment with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.PayrollIncrement deletePayrollIncrement(
		long payrollIncrementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePayrollIncrement(payrollIncrementId);
	}

	/**
	* Deletes the payroll increment from the database. Also notifies the appropriate model listeners.
	*
	* @param payrollIncrement the payroll increment
	* @return the payroll increment that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.PayrollIncrement deletePayrollIncrement(
		com.liferay.famocom.erpcloud.model.PayrollIncrement payrollIncrement) {
		return getService().deletePayrollIncrement(payrollIncrement);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.PayrollIncrement fetchPayrollIncrement(
		long payrollIncrementId) {
		return getService().fetchPayrollIncrement(payrollIncrementId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
			appraisalSettingId, financialYear);
	}

	public static com.liferay.famocom.erpcloud.model.PayrollIncrement findByEmployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByEmployeeIdComponentIdFinancialYear(employeeId,
			componentId, financialYear);
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

	/**
	* Returns the payroll increment with the primary key.
	*
	* @param payrollIncrementId the primary key of the payroll increment
	* @return the payroll increment
	* @throws PortalException if a payroll increment with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.PayrollIncrement getPayrollIncrement(
		long payrollIncrementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPayrollIncrement(payrollIncrementId);
	}

	/**
	* Returns a range of all the payroll increments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payroll increments
	* @param end the upper bound of the range of payroll increments (not inclusive)
	* @return the range of payroll increments
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.PayrollIncrement> getPayrollIncrements(
		int start, int end) {
		return getService().getPayrollIncrements(start, end);
	}

	/**
	* Returns the number of payroll increments.
	*
	* @return the number of payroll increments
	*/
	public static int getPayrollIncrementsCount() {
		return getService().getPayrollIncrementsCount();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the payroll increment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param payrollIncrement the payroll increment
	* @return the payroll increment that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.PayrollIncrement updatePayrollIncrement(
		com.liferay.famocom.erpcloud.model.PayrollIncrement payrollIncrement) {
		return getService().updatePayrollIncrement(payrollIncrement);
	}

	public static PayrollIncrementLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PayrollIncrementLocalService, PayrollIncrementLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PayrollIncrementLocalService.class);

		ServiceTracker<PayrollIncrementLocalService, PayrollIncrementLocalService> serviceTracker =
			new ServiceTracker<PayrollIncrementLocalService, PayrollIncrementLocalService>(bundle.getBundleContext(),
				PayrollIncrementLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}