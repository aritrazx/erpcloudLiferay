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

import com.liferay.famocom.erpcloud.model.SchedulesMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the schedules master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.SchedulesMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SchedulesMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.SchedulesMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class SchedulesMasterUtil {
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
	public static void clearCache(SchedulesMaster schedulesMaster) {
		getPersistence().clearCache(schedulesMaster);
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
	public static List<SchedulesMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SchedulesMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SchedulesMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SchedulesMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SchedulesMaster update(SchedulesMaster schedulesMaster) {
		return getPersistence().update(schedulesMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SchedulesMaster update(SchedulesMaster schedulesMaster,
		ServiceContext serviceContext) {
		return getPersistence().update(schedulesMaster, serviceContext);
	}

	/**
	* Caches the schedules master in the entity cache if it is enabled.
	*
	* @param schedulesMaster the schedules master
	*/
	public static void cacheResult(SchedulesMaster schedulesMaster) {
		getPersistence().cacheResult(schedulesMaster);
	}

	/**
	* Caches the schedules masters in the entity cache if it is enabled.
	*
	* @param schedulesMasters the schedules masters
	*/
	public static void cacheResult(List<SchedulesMaster> schedulesMasters) {
		getPersistence().cacheResult(schedulesMasters);
	}

	/**
	* Creates a new schedules master with the primary key. Does not add the schedules master to the database.
	*
	* @param schedulesId the primary key for the new schedules master
	* @return the new schedules master
	*/
	public static SchedulesMaster create(long schedulesId) {
		return getPersistence().create(schedulesId);
	}

	/**
	* Removes the schedules master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesId the primary key of the schedules master
	* @return the schedules master that was removed
	* @throws NoSuchSchedulesMasterException if a schedules master with the primary key could not be found
	*/
	public static SchedulesMaster remove(long schedulesId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesMasterException {
		return getPersistence().remove(schedulesId);
	}

	public static SchedulesMaster updateImpl(SchedulesMaster schedulesMaster) {
		return getPersistence().updateImpl(schedulesMaster);
	}

	/**
	* Returns the schedules master with the primary key or throws a {@link NoSuchSchedulesMasterException} if it could not be found.
	*
	* @param schedulesId the primary key of the schedules master
	* @return the schedules master
	* @throws NoSuchSchedulesMasterException if a schedules master with the primary key could not be found
	*/
	public static SchedulesMaster findByPrimaryKey(long schedulesId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSchedulesMasterException {
		return getPersistence().findByPrimaryKey(schedulesId);
	}

	/**
	* Returns the schedules master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param schedulesId the primary key of the schedules master
	* @return the schedules master, or <code>null</code> if a schedules master with the primary key could not be found
	*/
	public static SchedulesMaster fetchByPrimaryKey(long schedulesId) {
		return getPersistence().fetchByPrimaryKey(schedulesId);
	}

	public static java.util.Map<java.io.Serializable, SchedulesMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the schedules masters.
	*
	* @return the schedules masters
	*/
	public static List<SchedulesMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the schedules masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules masters
	* @param end the upper bound of the range of schedules masters (not inclusive)
	* @return the range of schedules masters
	*/
	public static List<SchedulesMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the schedules masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules masters
	* @param end the upper bound of the range of schedules masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of schedules masters
	*/
	public static List<SchedulesMaster> findAll(int start, int end,
		OrderByComparator<SchedulesMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the schedules masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules masters
	* @param end the upper bound of the range of schedules masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of schedules masters
	*/
	public static List<SchedulesMaster> findAll(int start, int end,
		OrderByComparator<SchedulesMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the schedules masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of schedules masters.
	*
	* @return the number of schedules masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SchedulesMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SchedulesMasterPersistence, SchedulesMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SchedulesMasterPersistence.class);

		ServiceTracker<SchedulesMasterPersistence, SchedulesMasterPersistence> serviceTracker =
			new ServiceTracker<SchedulesMasterPersistence, SchedulesMasterPersistence>(bundle.getBundleContext(),
				SchedulesMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}