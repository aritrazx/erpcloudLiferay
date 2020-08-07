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

import com.liferay.famocom.erpcloud.model.TaxDeclaration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tax declaration service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.TaxDeclarationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaxDeclarationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TaxDeclarationPersistenceImpl
 * @generated
 */
@ProviderType
public class TaxDeclarationUtil {
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
	public static void clearCache(TaxDeclaration taxDeclaration) {
		getPersistence().clearCache(taxDeclaration);
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
	public static List<TaxDeclaration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaxDeclaration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaxDeclaration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaxDeclaration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaxDeclaration update(TaxDeclaration taxDeclaration) {
		return getPersistence().update(taxDeclaration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaxDeclaration update(TaxDeclaration taxDeclaration,
		ServiceContext serviceContext) {
		return getPersistence().update(taxDeclaration, serviceContext);
	}

	/**
	* Returns the tax declaration where employeeId = &#63; or throws a {@link NoSuchTaxDeclarationException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @return the matching tax declaration
	* @throws NoSuchTaxDeclarationException if a matching tax declaration could not be found
	*/
	public static TaxDeclaration findByemployeeId(long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException {
		return getPersistence().findByemployeeId(employeeId);
	}

	/**
	* Returns the tax declaration where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	*/
	public static TaxDeclaration fetchByemployeeId(long employeeId) {
		return getPersistence().fetchByemployeeId(employeeId);
	}

	/**
	* Returns the tax declaration where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	*/
	public static TaxDeclaration fetchByemployeeId(long employeeId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByemployeeId(employeeId, retrieveFromCache);
	}

	/**
	* Removes the tax declaration where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @return the tax declaration that was removed
	*/
	public static TaxDeclaration removeByemployeeId(long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException {
		return getPersistence().removeByemployeeId(employeeId);
	}

	/**
	* Returns the number of tax declarations where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching tax declarations
	*/
	public static int countByemployeeId(long employeeId) {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	* Returns the tax declaration where employeeId = &#63; and financialYear = &#63; or throws a {@link NoSuchTaxDeclarationException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the matching tax declaration
	* @throws NoSuchTaxDeclarationException if a matching tax declaration could not be found
	*/
	public static TaxDeclaration findByemployeeIdAndFinancialYear(
		long employeeId, String financialYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException {
		return getPersistence()
				   .findByemployeeIdAndFinancialYear(employeeId, financialYear);
	}

	/**
	* Returns the tax declaration where employeeId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	*/
	public static TaxDeclaration fetchByemployeeIdAndFinancialYear(
		long employeeId, String financialYear) {
		return getPersistence()
				   .fetchByemployeeIdAndFinancialYear(employeeId, financialYear);
	}

	/**
	* Returns the tax declaration where employeeId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	*/
	public static TaxDeclaration fetchByemployeeIdAndFinancialYear(
		long employeeId, String financialYear, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByemployeeIdAndFinancialYear(employeeId,
			financialYear, retrieveFromCache);
	}

	/**
	* Removes the tax declaration where employeeId = &#63; and financialYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the tax declaration that was removed
	*/
	public static TaxDeclaration removeByemployeeIdAndFinancialYear(
		long employeeId, String financialYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException {
		return getPersistence()
				   .removeByemployeeIdAndFinancialYear(employeeId, financialYear);
	}

	/**
	* Returns the number of tax declarations where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the number of matching tax declarations
	*/
	public static int countByemployeeIdAndFinancialYear(long employeeId,
		String financialYear) {
		return getPersistence()
				   .countByemployeeIdAndFinancialYear(employeeId, financialYear);
	}

	/**
	* Caches the tax declaration in the entity cache if it is enabled.
	*
	* @param taxDeclaration the tax declaration
	*/
	public static void cacheResult(TaxDeclaration taxDeclaration) {
		getPersistence().cacheResult(taxDeclaration);
	}

	/**
	* Caches the tax declarations in the entity cache if it is enabled.
	*
	* @param taxDeclarations the tax declarations
	*/
	public static void cacheResult(List<TaxDeclaration> taxDeclarations) {
		getPersistence().cacheResult(taxDeclarations);
	}

	/**
	* Creates a new tax declaration with the primary key. Does not add the tax declaration to the database.
	*
	* @param taxDeclarationId the primary key for the new tax declaration
	* @return the new tax declaration
	*/
	public static TaxDeclaration create(long taxDeclarationId) {
		return getPersistence().create(taxDeclarationId);
	}

	/**
	* Removes the tax declaration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclarationId the primary key of the tax declaration
	* @return the tax declaration that was removed
	* @throws NoSuchTaxDeclarationException if a tax declaration with the primary key could not be found
	*/
	public static TaxDeclaration remove(long taxDeclarationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException {
		return getPersistence().remove(taxDeclarationId);
	}

	public static TaxDeclaration updateImpl(TaxDeclaration taxDeclaration) {
		return getPersistence().updateImpl(taxDeclaration);
	}

	/**
	* Returns the tax declaration with the primary key or throws a {@link NoSuchTaxDeclarationException} if it could not be found.
	*
	* @param taxDeclarationId the primary key of the tax declaration
	* @return the tax declaration
	* @throws NoSuchTaxDeclarationException if a tax declaration with the primary key could not be found
	*/
	public static TaxDeclaration findByPrimaryKey(long taxDeclarationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException {
		return getPersistence().findByPrimaryKey(taxDeclarationId);
	}

	/**
	* Returns the tax declaration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taxDeclarationId the primary key of the tax declaration
	* @return the tax declaration, or <code>null</code> if a tax declaration with the primary key could not be found
	*/
	public static TaxDeclaration fetchByPrimaryKey(long taxDeclarationId) {
		return getPersistence().fetchByPrimaryKey(taxDeclarationId);
	}

	public static java.util.Map<java.io.Serializable, TaxDeclaration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tax declarations.
	*
	* @return the tax declarations
	*/
	public static List<TaxDeclaration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tax declarations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declarations
	* @param end the upper bound of the range of tax declarations (not inclusive)
	* @return the range of tax declarations
	*/
	public static List<TaxDeclaration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tax declarations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declarations
	* @param end the upper bound of the range of tax declarations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tax declarations
	*/
	public static List<TaxDeclaration> findAll(int start, int end,
		OrderByComparator<TaxDeclaration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tax declarations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declarations
	* @param end the upper bound of the range of tax declarations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tax declarations
	*/
	public static List<TaxDeclaration> findAll(int start, int end,
		OrderByComparator<TaxDeclaration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tax declarations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tax declarations.
	*
	* @return the number of tax declarations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaxDeclarationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaxDeclarationPersistence, TaxDeclarationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaxDeclarationPersistence.class);

		ServiceTracker<TaxDeclarationPersistence, TaxDeclarationPersistence> serviceTracker =
			new ServiceTracker<TaxDeclarationPersistence, TaxDeclarationPersistence>(bundle.getBundleContext(),
				TaxDeclarationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}