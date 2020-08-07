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

package com.liferay.famocom.erpcloud.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.PayrollIncrement;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the payroll increment service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.PayrollIncrementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PayrollIncrementPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PayrollIncrementPersistenceImpl
 * @generated
 */
@ProviderType
public class PayrollIncrementUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(PayrollIncrement payrollIncrement) {
		getPersistence().clearCache(payrollIncrement);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PayrollIncrement> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PayrollIncrement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PayrollIncrement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PayrollIncrement> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PayrollIncrement update(PayrollIncrement payrollIncrement) {
		return getPersistence().update(payrollIncrement);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PayrollIncrement update(PayrollIncrement payrollIncrement,
		ServiceContext serviceContext) {
		return getPersistence().update(payrollIncrement, serviceContext);
	}

	/**
	* Returns the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; or throws a {@link NoSuchPayrollIncrementException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param financialYear the financial year
	* @return the matching payroll increment
	* @throws NoSuchPayrollIncrementException if a matching payroll increment could not be found
	*/
	public static PayrollIncrement findByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayrollIncrementException {
		return getPersistence()
				   .findByemployeeIdComponentIdFinancialYear(employeeId,
			componentId, financialYear);
	}

	/**
	* Returns the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param financialYear the financial year
	* @return the matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	*/
	public static PayrollIncrement fetchByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear) {
		return getPersistence()
				   .fetchByemployeeIdComponentIdFinancialYear(employeeId,
			componentId, financialYear);
	}

	/**
	* Returns the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param financialYear the financial year
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	*/
	public static PayrollIncrement fetchByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByemployeeIdComponentIdFinancialYear(employeeId,
			componentId, financialYear, retrieveFromCache);
	}

	/**
	* Removes the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param financialYear the financial year
	* @return the payroll increment that was removed
	*/
	public static PayrollIncrement removeByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayrollIncrementException {
		return getPersistence()
				   .removeByemployeeIdComponentIdFinancialYear(employeeId,
			componentId, financialYear);
	}

	/**
	* Returns the number of payroll increments where employeeId = &#63; and componentId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param financialYear the financial year
	* @return the number of matching payroll increments
	*/
	public static int countByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear) {
		return getPersistence()
				   .countByemployeeIdComponentIdFinancialYear(employeeId,
			componentId, financialYear);
	}

	/**
	* Returns all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @return the matching payroll increments
	*/
	public static List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear) {
		return getPersistence()
				   .findByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
			appraisalSettingId, financialYear);
	}

	/**
	* Returns a range of all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @param start the lower bound of the range of payroll increments
	* @param end the upper bound of the range of payroll increments (not inclusive)
	* @return the range of matching payroll increments
	*/
	public static List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear,
		int start, int end) {
		return getPersistence()
				   .findByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
			appraisalSettingId, financialYear, start, end);
	}

	/**
	* Returns an ordered range of all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @param start the lower bound of the range of payroll increments
	* @param end the upper bound of the range of payroll increments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching payroll increments
	*/
	public static List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear,
		int start, int end,
		OrderByComparator<PayrollIncrement> orderByComparator) {
		return getPersistence()
				   .findByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
			appraisalSettingId, financialYear, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @param start the lower bound of the range of payroll increments
	* @param end the upper bound of the range of payroll increments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching payroll increments
	*/
	public static List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear,
		int start, int end,
		OrderByComparator<PayrollIncrement> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
			appraisalSettingId, financialYear, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payroll increment
	* @throws NoSuchPayrollIncrementException if a matching payroll increment could not be found
	*/
	public static PayrollIncrement findByemployeeIdAppraisalSettingIdFinancialYear_First(
		long employeeId, long appraisalSettingId, String financialYear,
		OrderByComparator<PayrollIncrement> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayrollIncrementException {
		return getPersistence()
				   .findByemployeeIdAppraisalSettingIdFinancialYear_First(employeeId,
			appraisalSettingId, financialYear, orderByComparator);
	}

	/**
	* Returns the first payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	*/
	public static PayrollIncrement fetchByemployeeIdAppraisalSettingIdFinancialYear_First(
		long employeeId, long appraisalSettingId, String financialYear,
		OrderByComparator<PayrollIncrement> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAppraisalSettingIdFinancialYear_First(employeeId,
			appraisalSettingId, financialYear, orderByComparator);
	}

	/**
	* Returns the last payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payroll increment
	* @throws NoSuchPayrollIncrementException if a matching payroll increment could not be found
	*/
	public static PayrollIncrement findByemployeeIdAppraisalSettingIdFinancialYear_Last(
		long employeeId, long appraisalSettingId, String financialYear,
		OrderByComparator<PayrollIncrement> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayrollIncrementException {
		return getPersistence()
				   .findByemployeeIdAppraisalSettingIdFinancialYear_Last(employeeId,
			appraisalSettingId, financialYear, orderByComparator);
	}

	/**
	* Returns the last payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	*/
	public static PayrollIncrement fetchByemployeeIdAppraisalSettingIdFinancialYear_Last(
		long employeeId, long appraisalSettingId, String financialYear,
		OrderByComparator<PayrollIncrement> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAppraisalSettingIdFinancialYear_Last(employeeId,
			appraisalSettingId, financialYear, orderByComparator);
	}

	/**
	* Returns the payroll increments before and after the current payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* @param payrollIncrementId the primary key of the current payroll increment
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next payroll increment
	* @throws NoSuchPayrollIncrementException if a payroll increment with the primary key could not be found
	*/
	public static PayrollIncrement[] findByemployeeIdAppraisalSettingIdFinancialYear_PrevAndNext(
		long payrollIncrementId, long employeeId, long appraisalSettingId,
		String financialYear,
		OrderByComparator<PayrollIncrement> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayrollIncrementException {
		return getPersistence()
				   .findByemployeeIdAppraisalSettingIdFinancialYear_PrevAndNext(payrollIncrementId,
			employeeId, appraisalSettingId, financialYear, orderByComparator);
	}

	/**
	* Removes all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	*/
	public static void removeByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear) {
		getPersistence()
			.removeByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
			appraisalSettingId, financialYear);
	}

	/**
	* Returns the number of payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @return the number of matching payroll increments
	*/
	public static int countByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear) {
		return getPersistence()
				   .countByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
			appraisalSettingId, financialYear);
	}

	/**
	* Caches the payroll increment in the entity cache if it is enabled.
	*
	* @param payrollIncrement the payroll increment
	*/
	public static void cacheResult(PayrollIncrement payrollIncrement) {
		getPersistence().cacheResult(payrollIncrement);
	}

	/**
	* Caches the payroll increments in the entity cache if it is enabled.
	*
	* @param payrollIncrements the payroll increments
	*/
	public static void cacheResult(List<PayrollIncrement> payrollIncrements) {
		getPersistence().cacheResult(payrollIncrements);
	}

	/**
	* Creates a new payroll increment with the primary key. Does not add the payroll increment to the database.
	*
	* @param payrollIncrementId the primary key for the new payroll increment
	* @return the new payroll increment
	*/
	public static PayrollIncrement create(long payrollIncrementId) {
		return getPersistence().create(payrollIncrementId);
	}

	/**
	* Removes the payroll increment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param payrollIncrementId the primary key of the payroll increment
	* @return the payroll increment that was removed
	* @throws NoSuchPayrollIncrementException if a payroll increment with the primary key could not be found
	*/
	public static PayrollIncrement remove(long payrollIncrementId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayrollIncrementException {
		return getPersistence().remove(payrollIncrementId);
	}

	public static PayrollIncrement updateImpl(PayrollIncrement payrollIncrement) {
		return getPersistence().updateImpl(payrollIncrement);
	}

	/**
	* Returns the payroll increment with the primary key or throws a {@link NoSuchPayrollIncrementException} if it could not be found.
	*
	* @param payrollIncrementId the primary key of the payroll increment
	* @return the payroll increment
	* @throws NoSuchPayrollIncrementException if a payroll increment with the primary key could not be found
	*/
	public static PayrollIncrement findByPrimaryKey(long payrollIncrementId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayrollIncrementException {
		return getPersistence().findByPrimaryKey(payrollIncrementId);
	}

	/**
	* Returns the payroll increment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param payrollIncrementId the primary key of the payroll increment
	* @return the payroll increment, or <code>null</code> if a payroll increment with the primary key could not be found
	*/
	public static PayrollIncrement fetchByPrimaryKey(long payrollIncrementId) {
		return getPersistence().fetchByPrimaryKey(payrollIncrementId);
	}

	public static java.util.Map<java.io.Serializable, PayrollIncrement> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the payroll increments.
	*
	* @return the payroll increments
	*/
	public static List<PayrollIncrement> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the payroll increments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payroll increments
	* @param end the upper bound of the range of payroll increments (not inclusive)
	* @return the range of payroll increments
	*/
	public static List<PayrollIncrement> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the payroll increments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payroll increments
	* @param end the upper bound of the range of payroll increments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of payroll increments
	*/
	public static List<PayrollIncrement> findAll(int start, int end,
		OrderByComparator<PayrollIncrement> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the payroll increments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payroll increments
	* @param end the upper bound of the range of payroll increments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of payroll increments
	*/
	public static List<PayrollIncrement> findAll(int start, int end,
		OrderByComparator<PayrollIncrement> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the payroll increments from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of payroll increments.
	*
	* @return the number of payroll increments
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PayrollIncrementPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PayrollIncrementPersistence, PayrollIncrementPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PayrollIncrementPersistence.class);

		ServiceTracker<PayrollIncrementPersistence, PayrollIncrementPersistence> serviceTracker =
			new ServiceTracker<PayrollIncrementPersistence, PayrollIncrementPersistence>(bundle.getBundleContext(),
				PayrollIncrementPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}