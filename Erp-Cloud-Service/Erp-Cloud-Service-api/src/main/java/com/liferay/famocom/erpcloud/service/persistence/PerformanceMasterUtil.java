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

import com.liferay.famocom.erpcloud.model.PerformanceMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the performance master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.PerformanceMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PerformanceMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PerformanceMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class PerformanceMasterUtil {
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
	public static void clearCache(PerformanceMaster performanceMaster) {
		getPersistence().clearCache(performanceMaster);
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
	public static List<PerformanceMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PerformanceMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PerformanceMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PerformanceMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PerformanceMaster update(PerformanceMaster performanceMaster) {
		return getPersistence().update(performanceMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PerformanceMaster update(
		PerformanceMaster performanceMaster, ServiceContext serviceContext) {
		return getPersistence().update(performanceMaster, serviceContext);
	}

	/**
	* Caches the performance master in the entity cache if it is enabled.
	*
	* @param performanceMaster the performance master
	*/
	public static void cacheResult(PerformanceMaster performanceMaster) {
		getPersistence().cacheResult(performanceMaster);
	}

	/**
	* Caches the performance masters in the entity cache if it is enabled.
	*
	* @param performanceMasters the performance masters
	*/
	public static void cacheResult(List<PerformanceMaster> performanceMasters) {
		getPersistence().cacheResult(performanceMasters);
	}

	/**
	* Creates a new performance master with the primary key. Does not add the performance master to the database.
	*
	* @param performanceId the primary key for the new performance master
	* @return the new performance master
	*/
	public static PerformanceMaster create(long performanceId) {
		return getPersistence().create(performanceId);
	}

	/**
	* Removes the performance master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param performanceId the primary key of the performance master
	* @return the performance master that was removed
	* @throws NoSuchPerformanceMasterException if a performance master with the primary key could not be found
	*/
	public static PerformanceMaster remove(long performanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPerformanceMasterException {
		return getPersistence().remove(performanceId);
	}

	public static PerformanceMaster updateImpl(
		PerformanceMaster performanceMaster) {
		return getPersistence().updateImpl(performanceMaster);
	}

	/**
	* Returns the performance master with the primary key or throws a {@link NoSuchPerformanceMasterException} if it could not be found.
	*
	* @param performanceId the primary key of the performance master
	* @return the performance master
	* @throws NoSuchPerformanceMasterException if a performance master with the primary key could not be found
	*/
	public static PerformanceMaster findByPrimaryKey(long performanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPerformanceMasterException {
		return getPersistence().findByPrimaryKey(performanceId);
	}

	/**
	* Returns the performance master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param performanceId the primary key of the performance master
	* @return the performance master, or <code>null</code> if a performance master with the primary key could not be found
	*/
	public static PerformanceMaster fetchByPrimaryKey(long performanceId) {
		return getPersistence().fetchByPrimaryKey(performanceId);
	}

	public static java.util.Map<java.io.Serializable, PerformanceMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the performance masters.
	*
	* @return the performance masters
	*/
	public static List<PerformanceMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the performance masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performance masters
	* @param end the upper bound of the range of performance masters (not inclusive)
	* @return the range of performance masters
	*/
	public static List<PerformanceMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the performance masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performance masters
	* @param end the upper bound of the range of performance masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of performance masters
	*/
	public static List<PerformanceMaster> findAll(int start, int end,
		OrderByComparator<PerformanceMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the performance masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performance masters
	* @param end the upper bound of the range of performance masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of performance masters
	*/
	public static List<PerformanceMaster> findAll(int start, int end,
		OrderByComparator<PerformanceMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the performance masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of performance masters.
	*
	* @return the number of performance masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PerformanceMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PerformanceMasterPersistence, PerformanceMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PerformanceMasterPersistence.class);

		ServiceTracker<PerformanceMasterPersistence, PerformanceMasterPersistence> serviceTracker =
			new ServiceTracker<PerformanceMasterPersistence, PerformanceMasterPersistence>(bundle.getBundleContext(),
				PerformanceMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}