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

import com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationMonthlyException;
import com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the tax declaration monthly service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TaxDeclarationMonthlyPersistenceImpl
 * @see TaxDeclarationMonthlyUtil
 * @generated
 */
@ProviderType
public interface TaxDeclarationMonthlyPersistence extends BasePersistence<TaxDeclarationMonthly> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaxDeclarationMonthlyUtil} to access the tax declaration monthly persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the tax declaration monthly where monthYear = &#63; and employeeId = &#63; or throws a {@link NoSuchTaxDeclarationMonthlyException} if it could not be found.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the matching tax declaration monthly
	* @throws NoSuchTaxDeclarationMonthlyException if a matching tax declaration monthly could not be found
	*/
	public TaxDeclarationMonthly findBymonthYearAndemployeeId(long monthYear,
		long employeeId) throws NoSuchTaxDeclarationMonthlyException;

	/**
	* Returns the tax declaration monthly where monthYear = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	*/
	public TaxDeclarationMonthly fetchBymonthYearAndemployeeId(long monthYear,
		long employeeId);

	/**
	* Returns the tax declaration monthly where monthYear = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	*/
	public TaxDeclarationMonthly fetchBymonthYearAndemployeeId(long monthYear,
		long employeeId, boolean retrieveFromCache);

	/**
	* Removes the tax declaration monthly where monthYear = &#63; and employeeId = &#63; from the database.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the tax declaration monthly that was removed
	*/
	public TaxDeclarationMonthly removeBymonthYearAndemployeeId(
		long monthYear, long employeeId)
		throws NoSuchTaxDeclarationMonthlyException;

	/**
	* Returns the number of tax declaration monthlies where monthYear = &#63; and employeeId = &#63;.
	*
	* @param monthYear the month year
	* @param employeeId the employee ID
	* @return the number of matching tax declaration monthlies
	*/
	public int countBymonthYearAndemployeeId(long monthYear, long employeeId);

	/**
	* Returns all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the matching tax declaration monthlies
	*/
	public java.util.List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear);

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
	public java.util.List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end);

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
	public java.util.List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclarationMonthly> orderByComparator);

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
	public java.util.List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclarationMonthly> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tax declaration monthly
	* @throws NoSuchTaxDeclarationMonthlyException if a matching tax declaration monthly could not be found
	*/
	public TaxDeclarationMonthly findByemployeeIdAndMonthYear_First(
		long employeeId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclarationMonthly> orderByComparator)
		throws NoSuchTaxDeclarationMonthlyException;

	/**
	* Returns the first tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	*/
	public TaxDeclarationMonthly fetchByemployeeIdAndMonthYear_First(
		long employeeId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclarationMonthly> orderByComparator);

	/**
	* Returns the last tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tax declaration monthly
	* @throws NoSuchTaxDeclarationMonthlyException if a matching tax declaration monthly could not be found
	*/
	public TaxDeclarationMonthly findByemployeeIdAndMonthYear_Last(
		long employeeId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclarationMonthly> orderByComparator)
		throws NoSuchTaxDeclarationMonthlyException;

	/**
	* Returns the last tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	*/
	public TaxDeclarationMonthly fetchByemployeeIdAndMonthYear_Last(
		long employeeId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclarationMonthly> orderByComparator);

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
	public TaxDeclarationMonthly[] findByemployeeIdAndMonthYear_PrevAndNext(
		long taxDeclarationMonthlyId, long employeeId, long monthYear,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclarationMonthly> orderByComparator)
		throws NoSuchTaxDeclarationMonthlyException;

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
	public java.util.List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears);

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
	public java.util.List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end);

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
	public java.util.List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclarationMonthly> orderByComparator);

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
	public java.util.List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclarationMonthly> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	*/
	public void removeByemployeeIdAndMonthYear(long employeeId, long monthYear);

	/**
	* Returns the number of tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYear the month year
	* @return the number of matching tax declaration monthlies
	*/
	public int countByemployeeIdAndMonthYear(long employeeId, long monthYear);

	/**
	* Returns the number of tax declaration monthlies where employeeId = &#63; and monthYear = any &#63;.
	*
	* @param employeeId the employee ID
	* @param monthYears the month years
	* @return the number of matching tax declaration monthlies
	*/
	public int countByemployeeIdAndMonthYear(long employeeId, long[] monthYears);

	/**
	* Caches the tax declaration monthly in the entity cache if it is enabled.
	*
	* @param taxDeclarationMonthly the tax declaration monthly
	*/
	public void cacheResult(TaxDeclarationMonthly taxDeclarationMonthly);

	/**
	* Caches the tax declaration monthlies in the entity cache if it is enabled.
	*
	* @param taxDeclarationMonthlies the tax declaration monthlies
	*/
	public void cacheResult(
		java.util.List<TaxDeclarationMonthly> taxDeclarationMonthlies);

	/**
	* Creates a new tax declaration monthly with the primary key. Does not add the tax declaration monthly to the database.
	*
	* @param taxDeclarationMonthlyId the primary key for the new tax declaration monthly
	* @return the new tax declaration monthly
	*/
	public TaxDeclarationMonthly create(long taxDeclarationMonthlyId);

	/**
	* Removes the tax declaration monthly with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclarationMonthlyId the primary key of the tax declaration monthly
	* @return the tax declaration monthly that was removed
	* @throws NoSuchTaxDeclarationMonthlyException if a tax declaration monthly with the primary key could not be found
	*/
	public TaxDeclarationMonthly remove(long taxDeclarationMonthlyId)
		throws NoSuchTaxDeclarationMonthlyException;

	public TaxDeclarationMonthly updateImpl(
		TaxDeclarationMonthly taxDeclarationMonthly);

	/**
	* Returns the tax declaration monthly with the primary key or throws a {@link NoSuchTaxDeclarationMonthlyException} if it could not be found.
	*
	* @param taxDeclarationMonthlyId the primary key of the tax declaration monthly
	* @return the tax declaration monthly
	* @throws NoSuchTaxDeclarationMonthlyException if a tax declaration monthly with the primary key could not be found
	*/
	public TaxDeclarationMonthly findByPrimaryKey(long taxDeclarationMonthlyId)
		throws NoSuchTaxDeclarationMonthlyException;

	/**
	* Returns the tax declaration monthly with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taxDeclarationMonthlyId the primary key of the tax declaration monthly
	* @return the tax declaration monthly, or <code>null</code> if a tax declaration monthly with the primary key could not be found
	*/
	public TaxDeclarationMonthly fetchByPrimaryKey(long taxDeclarationMonthlyId);

	@Override
	public java.util.Map<java.io.Serializable, TaxDeclarationMonthly> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tax declaration monthlies.
	*
	* @return the tax declaration monthlies
	*/
	public java.util.List<TaxDeclarationMonthly> findAll();

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
	public java.util.List<TaxDeclarationMonthly> findAll(int start, int end);

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
	public java.util.List<TaxDeclarationMonthly> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclarationMonthly> orderByComparator);

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
	public java.util.List<TaxDeclarationMonthly> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclarationMonthly> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tax declaration monthlies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tax declaration monthlies.
	*
	* @return the number of tax declaration monthlies
	*/
	public int countAll();
}