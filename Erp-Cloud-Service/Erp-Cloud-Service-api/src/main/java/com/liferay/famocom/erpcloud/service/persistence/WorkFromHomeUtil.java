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

import com.liferay.famocom.erpcloud.model.WorkFromHome;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the work from home service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.WorkFromHomePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see WorkFromHomePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.WorkFromHomePersistenceImpl
 * @generated
 */
@ProviderType
public class WorkFromHomeUtil {
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
	public static void clearCache(WorkFromHome workFromHome) {
		getPersistence().clearCache(workFromHome);
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
	public static List<WorkFromHome> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkFromHome> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkFromHome> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkFromHome update(WorkFromHome workFromHome) {
		return getPersistence().update(workFromHome);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkFromHome update(WorkFromHome workFromHome,
		ServiceContext serviceContext) {
		return getPersistence().update(workFromHome, serviceContext);
	}

	/**
	* Caches the work from home in the entity cache if it is enabled.
	*
	* @param workFromHome the work from home
	*/
	public static void cacheResult(WorkFromHome workFromHome) {
		getPersistence().cacheResult(workFromHome);
	}

	/**
	* Caches the work from homes in the entity cache if it is enabled.
	*
	* @param workFromHomes the work from homes
	*/
	public static void cacheResult(List<WorkFromHome> workFromHomes) {
		getPersistence().cacheResult(workFromHomes);
	}

	/**
	* Creates a new work from home with the primary key. Does not add the work from home to the database.
	*
	* @param workFromHomeId the primary key for the new work from home
	* @return the new work from home
	*/
	public static WorkFromHome create(long workFromHomeId) {
		return getPersistence().create(workFromHomeId);
	}

	/**
	* Removes the work from home with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workFromHomeId the primary key of the work from home
	* @return the work from home that was removed
	* @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	*/
	public static WorkFromHome remove(long workFromHomeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorkFromHomeException {
		return getPersistence().remove(workFromHomeId);
	}

	public static WorkFromHome updateImpl(WorkFromHome workFromHome) {
		return getPersistence().updateImpl(workFromHome);
	}

	/**
	* Returns the work from home with the primary key or throws a {@link NoSuchWorkFromHomeException} if it could not be found.
	*
	* @param workFromHomeId the primary key of the work from home
	* @return the work from home
	* @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	*/
	public static WorkFromHome findByPrimaryKey(long workFromHomeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchWorkFromHomeException {
		return getPersistence().findByPrimaryKey(workFromHomeId);
	}

	/**
	* Returns the work from home with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workFromHomeId the primary key of the work from home
	* @return the work from home, or <code>null</code> if a work from home with the primary key could not be found
	*/
	public static WorkFromHome fetchByPrimaryKey(long workFromHomeId) {
		return getPersistence().fetchByPrimaryKey(workFromHomeId);
	}

	public static java.util.Map<java.io.Serializable, WorkFromHome> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the work from homes.
	*
	* @return the work from homes
	*/
	public static List<WorkFromHome> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the work from homes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFromHomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work from homes
	* @param end the upper bound of the range of work from homes (not inclusive)
	* @return the range of work from homes
	*/
	public static List<WorkFromHome> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the work from homes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFromHomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work from homes
	* @param end the upper bound of the range of work from homes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of work from homes
	*/
	public static List<WorkFromHome> findAll(int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the work from homes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFromHomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work from homes
	* @param end the upper bound of the range of work from homes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of work from homes
	*/
	public static List<WorkFromHome> findAll(int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the work from homes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of work from homes.
	*
	* @return the number of work from homes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkFromHomePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WorkFromHomePersistence, WorkFromHomePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkFromHomePersistence.class);

		ServiceTracker<WorkFromHomePersistence, WorkFromHomePersistence> serviceTracker =
			new ServiceTracker<WorkFromHomePersistence, WorkFromHomePersistence>(bundle.getBundleContext(),
				WorkFromHomePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}