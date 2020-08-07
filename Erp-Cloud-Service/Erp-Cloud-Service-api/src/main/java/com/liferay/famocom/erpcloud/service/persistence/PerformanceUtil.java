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

import com.liferay.famocom.erpcloud.model.Performance;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the performance service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.PerformancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PerformancePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PerformancePersistenceImpl
 * @generated
 */
@ProviderType
public class PerformanceUtil {
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
	public static void clearCache(Performance performance) {
		getPersistence().clearCache(performance);
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
	public static List<Performance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Performance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Performance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Performance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Performance update(Performance performance) {
		return getPersistence().update(performance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Performance update(Performance performance,
		ServiceContext serviceContext) {
		return getPersistence().update(performance, serviceContext);
	}

	/**
	* Caches the performance in the entity cache if it is enabled.
	*
	* @param performance the performance
	*/
	public static void cacheResult(Performance performance) {
		getPersistence().cacheResult(performance);
	}

	/**
	* Caches the performances in the entity cache if it is enabled.
	*
	* @param performances the performances
	*/
	public static void cacheResult(List<Performance> performances) {
		getPersistence().cacheResult(performances);
	}

	/**
	* Creates a new performance with the primary key. Does not add the performance to the database.
	*
	* @param performanceId the primary key for the new performance
	* @return the new performance
	*/
	public static Performance create(long performanceId) {
		return getPersistence().create(performanceId);
	}

	/**
	* Removes the performance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param performanceId the primary key of the performance
	* @return the performance that was removed
	* @throws NoSuchPerformanceException if a performance with the primary key could not be found
	*/
	public static Performance remove(long performanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPerformanceException {
		return getPersistence().remove(performanceId);
	}

	public static Performance updateImpl(Performance performance) {
		return getPersistence().updateImpl(performance);
	}

	/**
	* Returns the performance with the primary key or throws a {@link NoSuchPerformanceException} if it could not be found.
	*
	* @param performanceId the primary key of the performance
	* @return the performance
	* @throws NoSuchPerformanceException if a performance with the primary key could not be found
	*/
	public static Performance findByPrimaryKey(long performanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPerformanceException {
		return getPersistence().findByPrimaryKey(performanceId);
	}

	/**
	* Returns the performance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param performanceId the primary key of the performance
	* @return the performance, or <code>null</code> if a performance with the primary key could not be found
	*/
	public static Performance fetchByPrimaryKey(long performanceId) {
		return getPersistence().fetchByPrimaryKey(performanceId);
	}

	public static java.util.Map<java.io.Serializable, Performance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the performances.
	*
	* @return the performances
	*/
	public static List<Performance> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performances
	* @param end the upper bound of the range of performances (not inclusive)
	* @return the range of performances
	*/
	public static List<Performance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performances
	* @param end the upper bound of the range of performances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of performances
	*/
	public static List<Performance> findAll(int start, int end,
		OrderByComparator<Performance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performances
	* @param end the upper bound of the range of performances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of performances
	*/
	public static List<Performance> findAll(int start, int end,
		OrderByComparator<Performance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the performances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of performances.
	*
	* @return the number of performances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PerformancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PerformancePersistence, PerformancePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PerformancePersistence.class);

		ServiceTracker<PerformancePersistence, PerformancePersistence> serviceTracker =
			new ServiceTracker<PerformancePersistence, PerformancePersistence>(bundle.getBundleContext(),
				PerformancePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}