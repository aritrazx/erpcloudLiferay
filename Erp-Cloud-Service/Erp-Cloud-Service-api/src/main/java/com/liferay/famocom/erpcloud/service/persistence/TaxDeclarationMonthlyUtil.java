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

import com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tax declaration monthly service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.TaxDeclarationMonthlyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaxDeclarationMonthlyPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TaxDeclarationMonthlyPersistenceImpl
 * @generated
 */
@ProviderType
public class TaxDeclarationMonthlyUtil {
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
	public static void clearCache(TaxDeclarationMonthly taxDeclarationMonthly) {
		getPersistence().clearCache(taxDeclarationMonthly);
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
	public static List<TaxDeclarationMonthly> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaxDeclarationMonthly> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaxDeclarationMonthly> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaxDeclarationMonthly update(
		TaxDeclarationMonthly taxDeclarationMonthly) {
		return getPersistence().update(taxDeclarationMonthly);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaxDeclarationMonthly update(
		TaxDeclarationMonthly taxDeclarationMonthly,
		ServiceContext serviceContext) {
		return getPersistence().update(taxDeclarationMonthly, serviceContext);
	}

	/**
	* Returns the tax declaration monthly where monthYear = &#63; and employeeId = &#63; or throws a {@link NoSuchTaxDeclarationMonthlyException} if it could not be found.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the matching tax declaration monthly
	* @throws NoSuchTaxDeclarationMonthlyException if a matching tax declaration monthly could not be found
	*/
	public static TaxDeclarationMonthly findBymonthYearAndemployeeId(
		long monthYear, long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationMonthlyException {
		return getPersistence()
				   .findBymonthYearAndemployeeId(monthYear, employeeId);
	}

	/**
	* Returns the tax declaration monthly where monthYear = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	*/
	public static TaxDeclarationMonthly fetchBymonthYearAndemployeeId(
		long monthYear, long employeeId) {
		return getPersistence()
				   .fetchBymonthYearAndemployeeId(monthYear, employeeId);
	}

	/**
	* Returns the tax declaration monthly where monthYear = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	*/
	public static TaxDeclarationMonthly fetchBymonthYearAndemployeeId(
		long monthYear, long employeeId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBymonthYearAndemployeeId(monthYear, employeeId,
			retrieveFromCache);
	}

	/**
	* Removes the tax declaration monthly where monthYear = &#63; and employeeId = &#63; from the database.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the tax declaration monthly that was removed
	*/
	public static TaxDeclarationMonthly removeBymonthYearAndemployeeId(
		long monthYear, long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationMonthlyException {
		return getPersistence()
				   .removeBymonthYearAndemployeeId(monthYear, employeeId);
	}

	/**
	* Returns the number of tax declaration monthlies where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the number of matching tax declaration monthlies
	*/
	public static int countBymonthYearAndemployeeId(long monthYear,
		long employeeId) {
		return getPersistence()
				   .countBymonthYearAndemployeeId(monthYear, employeeId);
	}

	/**
	* Returns all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the matching tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYear);
	}

	/**
	* Returns a range of all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param start the lower bound of the range of tax declaration monthlies
	* @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	* @return the range of matching tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYear, start,
			end);
	}

	/**
	* Returns an ordered range of all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param start the lower bound of the range of tax declaration monthlies
	* @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYear, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param start the lower bound of the range of tax declaration monthlies
	* @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYear, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tax declaration monthly
	* @throws NoSuchTaxDeclarationMonthlyException if a matching tax declaration monthly could not be found
	*/
	public static TaxDeclarationMonthly findByemployeeIdAndMonthYear_First(
		long employeeId, long monthYear,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationMonthlyException {
		return getPersistence()
				   .findByemployeeIdAndMonthYear_First(employeeId, monthYear,
			orderByComparator);
	}

	/**
	* Returns the first tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	*/
	public static TaxDeclarationMonthly fetchByemployeeIdAndMonthYear_First(
		long employeeId, long monthYear,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAndMonthYear_First(employeeId, monthYear,
			orderByComparator);
	}

	/**
	* Returns the last tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tax declaration monthly
	* @throws NoSuchTaxDeclarationMonthlyException if a matching tax declaration monthly could not be found
	*/
	public static TaxDeclarationMonthly findByemployeeIdAndMonthYear_Last(
		long employeeId, long monthYear,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationMonthlyException {
		return getPersistence()
				   .findByemployeeIdAndMonthYear_Last(employeeId, monthYear,
			orderByComparator);
	}

	/**
	* Returns the last tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	*/
	public static TaxDeclarationMonthly fetchByemployeeIdAndMonthYear_Last(
		long employeeId, long monthYear,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeIdAndMonthYear_Last(employeeId, monthYear,
			orderByComparator);
	}

	/**
	* Returns the tax declaration monthlies before and after the current tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param taxDeclarationMonthlyId the primary key of the current tax declaration monthly
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tax declaration monthly
	* @throws NoSuchTaxDeclarationMonthlyException if a tax declaration monthly with the primary key could not be found
	*/
	public static TaxDeclarationMonthly[] findByemployeeIdAndMonthYear_PrevAndNext(
		long taxDeclarationMonthlyId, long employeeId, long monthYear,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationMonthlyException {
		return getPersistence()
				   .findByemployeeIdAndMonthYear_PrevAndNext(taxDeclarationMonthlyId,
			employeeId, monthYear, orderByComparator);
	}

	/**
	* Returns all the tax declaration monthlies where employeeId = &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYears the month years
	* @return the matching tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYears);
	}

	/**
	* Returns a range of all the tax declaration monthlies where employeeId = &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYears the month years
	* @param start the lower bound of the range of tax declaration monthlies
	* @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	* @return the range of matching tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYears, start,
			end);
	}

	/**
	* Returns an ordered range of all the tax declaration monthlies where employeeId = &#63; and monthYear = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYears the month years
	* @param start the lower bound of the range of tax declaration monthlies
	* @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYears, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param start the lower bound of the range of tax declaration monthlies
	* @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeIdAndMonthYear(employeeId, monthYears, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	*/
	public static void removeByemployeeIdAndMonthYear(long employeeId,
		long monthYear) {
		getPersistence().removeByemployeeIdAndMonthYear(employeeId, monthYear);
	}

	/**
	* Returns the number of tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the number of matching tax declaration monthlies
	*/
	public static int countByemployeeIdAndMonthYear(long employeeId,
		long monthYear) {
		return getPersistence()
				   .countByemployeeIdAndMonthYear(employeeId, monthYear);
	}

	/**
	* Returns the number of tax declaration monthlies where employeeId = &#63; and monthYear = any &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYears the month years
	* @return the number of matching tax declaration monthlies
	*/
	public static int countByemployeeIdAndMonthYear(long employeeId,
		long[] monthYears) {
		return getPersistence()
				   .countByemployeeIdAndMonthYear(employeeId, monthYears);
	}

	/**
	* Caches the tax declaration monthly in the entity cache if it is enabled.
	*
	* @param taxDeclarationMonthly the tax declaration monthly
	*/
	public static void cacheResult(TaxDeclarationMonthly taxDeclarationMonthly) {
		getPersistence().cacheResult(taxDeclarationMonthly);
	}

	/**
	* Caches the tax declaration monthlies in the entity cache if it is enabled.
	*
	* @param taxDeclarationMonthlies the tax declaration monthlies
	*/
	public static void cacheResult(
		List<TaxDeclarationMonthly> taxDeclarationMonthlies) {
		getPersistence().cacheResult(taxDeclarationMonthlies);
	}

	/**
	* Creates a new tax declaration monthly with the primary key. Does not add the tax declaration monthly to the database.
	*
	* @param taxDeclarationMonthlyId the primary key for the new tax declaration monthly
	* @return the new tax declaration monthly
	*/
	public static TaxDeclarationMonthly create(long taxDeclarationMonthlyId) {
		return getPersistence().create(taxDeclarationMonthlyId);
	}

	/**
	* Removes the tax declaration monthly with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclarationMonthlyId the primary key of the tax declaration monthly
	* @return the tax declaration monthly that was removed
	* @throws NoSuchTaxDeclarationMonthlyException if a tax declaration monthly with the primary key could not be found
	*/
	public static TaxDeclarationMonthly remove(long taxDeclarationMonthlyId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationMonthlyException {
		return getPersistence().remove(taxDeclarationMonthlyId);
	}

	public static TaxDeclarationMonthly updateImpl(
		TaxDeclarationMonthly taxDeclarationMonthly) {
		return getPersistence().updateImpl(taxDeclarationMonthly);
	}

	/**
	* Returns the tax declaration monthly with the primary key or throws a {@link NoSuchTaxDeclarationMonthlyException} if it could not be found.
	*
	* @param taxDeclarationMonthlyId the primary key of the tax declaration monthly
	* @return the tax declaration monthly
	* @throws NoSuchTaxDeclarationMonthlyException if a tax declaration monthly with the primary key could not be found
	*/
	public static TaxDeclarationMonthly findByPrimaryKey(
		long taxDeclarationMonthlyId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationMonthlyException {
		return getPersistence().findByPrimaryKey(taxDeclarationMonthlyId);
	}

	/**
	* Returns the tax declaration monthly with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taxDeclarationMonthlyId the primary key of the tax declaration monthly
	* @return the tax declaration monthly, or <code>null</code> if a tax declaration monthly with the primary key could not be found
	*/
	public static TaxDeclarationMonthly fetchByPrimaryKey(
		long taxDeclarationMonthlyId) {
		return getPersistence().fetchByPrimaryKey(taxDeclarationMonthlyId);
	}

	public static java.util.Map<java.io.Serializable, TaxDeclarationMonthly> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tax declaration monthlies.
	*
	* @return the tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tax declaration monthlies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declaration monthlies
	* @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	* @return the range of tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tax declaration monthlies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declaration monthlies
	* @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findAll(int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tax declaration monthlies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declaration monthlies
	* @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tax declaration monthlies
	*/
	public static List<TaxDeclarationMonthly> findAll(int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tax declaration monthlies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tax declaration monthlies.
	*
	* @return the number of tax declaration monthlies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaxDeclarationMonthlyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaxDeclarationMonthlyPersistence, TaxDeclarationMonthlyPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaxDeclarationMonthlyPersistence.class);

		ServiceTracker<TaxDeclarationMonthlyPersistence, TaxDeclarationMonthlyPersistence> serviceTracker =
			new ServiceTracker<TaxDeclarationMonthlyPersistence, TaxDeclarationMonthlyPersistence>(bundle.getBundleContext(),
				TaxDeclarationMonthlyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}