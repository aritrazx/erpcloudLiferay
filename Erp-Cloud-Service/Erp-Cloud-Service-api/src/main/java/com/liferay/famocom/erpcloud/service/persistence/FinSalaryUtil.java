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

import com.liferay.famocom.erpcloud.model.FinSalary;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the fin salary service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.FinSalaryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see FinSalaryPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.FinSalaryPersistenceImpl
 * @generated
 */
@ProviderType
public class FinSalaryUtil {
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
	public static void clearCache(FinSalary finSalary) {
		getPersistence().clearCache(finSalary);
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
	public static List<FinSalary> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FinSalary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FinSalary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FinSalary> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FinSalary update(FinSalary finSalary) {
		return getPersistence().update(finSalary);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FinSalary update(FinSalary finSalary,
		ServiceContext serviceContext) {
		return getPersistence().update(finSalary, serviceContext);
	}

	/**
	* Returns the fin salary where monthYear = &#63; or throws a {@link NoSuchFinSalaryException} if it could not be found.
	*
	* @param monthYear the month year
	* @return the matching fin salary
	* @throws NoSuchFinSalaryException if a matching fin salary could not be found
	*/
	public static FinSalary findBymonthYear(long monthYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFinSalaryException {
		return getPersistence().findBymonthYear(monthYear);
	}

	/**
	* Returns the fin salary where monthYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param monthYear the month year
	* @return the matching fin salary, or <code>null</code> if a matching fin salary could not be found
	*/
	public static FinSalary fetchBymonthYear(long monthYear) {
		return getPersistence().fetchBymonthYear(monthYear);
	}

	/**
	* Returns the fin salary where monthYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param monthYear the month year
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching fin salary, or <code>null</code> if a matching fin salary could not be found
	*/
	public static FinSalary fetchBymonthYear(long monthYear,
		boolean retrieveFromCache) {
		return getPersistence().fetchBymonthYear(monthYear, retrieveFromCache);
	}

	/**
	* Removes the fin salary where monthYear = &#63; from the database.
	*
	* @param monthYear the month year
	* @return the fin salary that was removed
	*/
	public static FinSalary removeBymonthYear(long monthYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFinSalaryException {
		return getPersistence().removeBymonthYear(monthYear);
	}

	/**
	* Returns the number of fin salaries where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the number of matching fin salaries
	*/
	public static int countBymonthYear(long monthYear) {
		return getPersistence().countBymonthYear(monthYear);
	}

	/**
	* Caches the fin salary in the entity cache if it is enabled.
	*
	* @param finSalary the fin salary
	*/
	public static void cacheResult(FinSalary finSalary) {
		getPersistence().cacheResult(finSalary);
	}

	/**
	* Caches the fin salaries in the entity cache if it is enabled.
	*
	* @param finSalaries the fin salaries
	*/
	public static void cacheResult(List<FinSalary> finSalaries) {
		getPersistence().cacheResult(finSalaries);
	}

	/**
	* Creates a new fin salary with the primary key. Does not add the fin salary to the database.
	*
	* @param finSalaryId the primary key for the new fin salary
	* @return the new fin salary
	*/
	public static FinSalary create(long finSalaryId) {
		return getPersistence().create(finSalaryId);
	}

	/**
	* Removes the fin salary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param finSalaryId the primary key of the fin salary
	* @return the fin salary that was removed
	* @throws NoSuchFinSalaryException if a fin salary with the primary key could not be found
	*/
	public static FinSalary remove(long finSalaryId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFinSalaryException {
		return getPersistence().remove(finSalaryId);
	}

	public static FinSalary updateImpl(FinSalary finSalary) {
		return getPersistence().updateImpl(finSalary);
	}

	/**
	* Returns the fin salary with the primary key or throws a {@link NoSuchFinSalaryException} if it could not be found.
	*
	* @param finSalaryId the primary key of the fin salary
	* @return the fin salary
	* @throws NoSuchFinSalaryException if a fin salary with the primary key could not be found
	*/
	public static FinSalary findByPrimaryKey(long finSalaryId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFinSalaryException {
		return getPersistence().findByPrimaryKey(finSalaryId);
	}

	/**
	* Returns the fin salary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param finSalaryId the primary key of the fin salary
	* @return the fin salary, or <code>null</code> if a fin salary with the primary key could not be found
	*/
	public static FinSalary fetchByPrimaryKey(long finSalaryId) {
		return getPersistence().fetchByPrimaryKey(finSalaryId);
	}

	public static java.util.Map<java.io.Serializable, FinSalary> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the fin salaries.
	*
	* @return the fin salaries
	*/
	public static List<FinSalary> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fin salaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fin salaries
	* @param end the upper bound of the range of fin salaries (not inclusive)
	* @return the range of fin salaries
	*/
	public static List<FinSalary> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fin salaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fin salaries
	* @param end the upper bound of the range of fin salaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fin salaries
	*/
	public static List<FinSalary> findAll(int start, int end,
		OrderByComparator<FinSalary> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fin salaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fin salaries
	* @param end the upper bound of the range of fin salaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of fin salaries
	*/
	public static List<FinSalary> findAll(int start, int end,
		OrderByComparator<FinSalary> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the fin salaries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fin salaries.
	*
	* @return the number of fin salaries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FinSalaryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FinSalaryPersistence, FinSalaryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FinSalaryPersistence.class);

		ServiceTracker<FinSalaryPersistence, FinSalaryPersistence> serviceTracker =
			new ServiceTracker<FinSalaryPersistence, FinSalaryPersistence>(bundle.getBundleContext(),
				FinSalaryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}