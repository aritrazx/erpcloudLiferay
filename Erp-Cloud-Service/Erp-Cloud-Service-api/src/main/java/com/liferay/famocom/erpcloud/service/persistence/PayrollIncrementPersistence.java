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

import com.liferay.famocom.erpcloud.exception.NoSuchPayrollIncrementException;
import com.liferay.famocom.erpcloud.model.PayrollIncrement;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the payroll increment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PayrollIncrementPersistenceImpl
 * @see PayrollIncrementUtil
 * @generated
 */
@ProviderType
public interface PayrollIncrementPersistence extends BasePersistence<PayrollIncrement> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayrollIncrementUtil} to access the payroll increment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; or throws a {@link NoSuchPayrollIncrementException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param financialYear the financial year
	* @return the matching payroll increment
	* @throws NoSuchPayrollIncrementException if a matching payroll increment could not be found
	*/
	public PayrollIncrement findByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear)
		throws NoSuchPayrollIncrementException;

	/**
	* Returns the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param financialYear the financial year
	* @return the matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	*/
	public PayrollIncrement fetchByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear);

	/**
	* Returns the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param financialYear the financial year
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	*/
	public PayrollIncrement fetchByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear,
		boolean retrieveFromCache);

	/**
	* Removes the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param financialYear the financial year
	* @return the payroll increment that was removed
	*/
	public PayrollIncrement removeByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear)
		throws NoSuchPayrollIncrementException;

	/**
	* Returns the number of payroll increments where employeeId = &#63; and componentId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param componentId the component ID
	* @param financialYear the financial year
	* @return the number of matching payroll increments
	*/
	public int countByemployeeIdComponentIdFinancialYear(long employeeId,
		long componentId, String financialYear);

	/**
	* Returns all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @return the matching payroll increments
	*/
	public java.util.List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear);

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
	public java.util.List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear,
		int start, int end);

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
	public java.util.List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayrollIncrement> orderByComparator);

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
	public java.util.List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayrollIncrement> orderByComparator,
		boolean retrieveFromCache);

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
	public PayrollIncrement findByemployeeIdAppraisalSettingIdFinancialYear_First(
		long employeeId, long appraisalSettingId, String financialYear,
		com.liferay.portal.kernel.util.OrderByComparator<PayrollIncrement> orderByComparator)
		throws NoSuchPayrollIncrementException;

	/**
	* Returns the first payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	*/
	public PayrollIncrement fetchByemployeeIdAppraisalSettingIdFinancialYear_First(
		long employeeId, long appraisalSettingId, String financialYear,
		com.liferay.portal.kernel.util.OrderByComparator<PayrollIncrement> orderByComparator);

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
	public PayrollIncrement findByemployeeIdAppraisalSettingIdFinancialYear_Last(
		long employeeId, long appraisalSettingId, String financialYear,
		com.liferay.portal.kernel.util.OrderByComparator<PayrollIncrement> orderByComparator)
		throws NoSuchPayrollIncrementException;

	/**
	* Returns the last payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	*/
	public PayrollIncrement fetchByemployeeIdAppraisalSettingIdFinancialYear_Last(
		long employeeId, long appraisalSettingId, String financialYear,
		com.liferay.portal.kernel.util.OrderByComparator<PayrollIncrement> orderByComparator);

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
	public PayrollIncrement[] findByemployeeIdAppraisalSettingIdFinancialYear_PrevAndNext(
		long payrollIncrementId, long employeeId, long appraisalSettingId,
		String financialYear,
		com.liferay.portal.kernel.util.OrderByComparator<PayrollIncrement> orderByComparator)
		throws NoSuchPayrollIncrementException;

	/**
	* Removes all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	*/
	public void removeByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear);

	/**
	* Returns the number of payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param appraisalSettingId the appraisal setting ID
	* @param financialYear the financial year
	* @return the number of matching payroll increments
	*/
	public int countByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear);

	/**
	* Caches the payroll increment in the entity cache if it is enabled.
	*
	* @param payrollIncrement the payroll increment
	*/
	public void cacheResult(PayrollIncrement payrollIncrement);

	/**
	* Caches the payroll increments in the entity cache if it is enabled.
	*
	* @param payrollIncrements the payroll increments
	*/
	public void cacheResult(java.util.List<PayrollIncrement> payrollIncrements);

	/**
	* Creates a new payroll increment with the primary key. Does not add the payroll increment to the database.
	*
	* @param payrollIncrementId the primary key for the new payroll increment
	* @return the new payroll increment
	*/
	public PayrollIncrement create(long payrollIncrementId);

	/**
	* Removes the payroll increment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param payrollIncrementId the primary key of the payroll increment
	* @return the payroll increment that was removed
	* @throws NoSuchPayrollIncrementException if a payroll increment with the primary key could not be found
	*/
	public PayrollIncrement remove(long payrollIncrementId)
		throws NoSuchPayrollIncrementException;

	public PayrollIncrement updateImpl(PayrollIncrement payrollIncrement);

	/**
	* Returns the payroll increment with the primary key or throws a {@link NoSuchPayrollIncrementException} if it could not be found.
	*
	* @param payrollIncrementId the primary key of the payroll increment
	* @return the payroll increment
	* @throws NoSuchPayrollIncrementException if a payroll increment with the primary key could not be found
	*/
	public PayrollIncrement findByPrimaryKey(long payrollIncrementId)
		throws NoSuchPayrollIncrementException;

	/**
	* Returns the payroll increment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param payrollIncrementId the primary key of the payroll increment
	* @return the payroll increment, or <code>null</code> if a payroll increment with the primary key could not be found
	*/
	public PayrollIncrement fetchByPrimaryKey(long payrollIncrementId);

	@Override
	public java.util.Map<java.io.Serializable, PayrollIncrement> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the payroll increments.
	*
	* @return the payroll increments
	*/
	public java.util.List<PayrollIncrement> findAll();

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
	public java.util.List<PayrollIncrement> findAll(int start, int end);

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
	public java.util.List<PayrollIncrement> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayrollIncrement> orderByComparator);

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
	public java.util.List<PayrollIncrement> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayrollIncrement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the payroll increments from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of payroll increments.
	*
	* @return the number of payroll increments
	*/
	public int countAll();
}