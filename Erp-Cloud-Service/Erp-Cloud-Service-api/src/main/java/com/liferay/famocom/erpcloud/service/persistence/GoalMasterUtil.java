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

import com.liferay.famocom.erpcloud.model.GoalMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the goal master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.GoalMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see GoalMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.GoalMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class GoalMasterUtil {
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
	public static void clearCache(GoalMaster goalMaster) {
		getPersistence().clearCache(goalMaster);
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
	public static List<GoalMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GoalMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GoalMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GoalMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GoalMaster update(GoalMaster goalMaster) {
		return getPersistence().update(goalMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GoalMaster update(GoalMaster goalMaster,
		ServiceContext serviceContext) {
		return getPersistence().update(goalMaster, serviceContext);
	}

	/**
	* Caches the goal master in the entity cache if it is enabled.
	*
	* @param goalMaster the goal master
	*/
	public static void cacheResult(GoalMaster goalMaster) {
		getPersistence().cacheResult(goalMaster);
	}

	/**
	* Caches the goal masters in the entity cache if it is enabled.
	*
	* @param goalMasters the goal masters
	*/
	public static void cacheResult(List<GoalMaster> goalMasters) {
		getPersistence().cacheResult(goalMasters);
	}

	/**
	* Creates a new goal master with the primary key. Does not add the goal master to the database.
	*
	* @param goalId the primary key for the new goal master
	* @return the new goal master
	*/
	public static GoalMaster create(long goalId) {
		return getPersistence().create(goalId);
	}

	/**
	* Removes the goal master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param goalId the primary key of the goal master
	* @return the goal master that was removed
	* @throws NoSuchGoalMasterException if a goal master with the primary key could not be found
	*/
	public static GoalMaster remove(long goalId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGoalMasterException {
		return getPersistence().remove(goalId);
	}

	public static GoalMaster updateImpl(GoalMaster goalMaster) {
		return getPersistence().updateImpl(goalMaster);
	}

	/**
	* Returns the goal master with the primary key or throws a {@link NoSuchGoalMasterException} if it could not be found.
	*
	* @param goalId the primary key of the goal master
	* @return the goal master
	* @throws NoSuchGoalMasterException if a goal master with the primary key could not be found
	*/
	public static GoalMaster findByPrimaryKey(long goalId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGoalMasterException {
		return getPersistence().findByPrimaryKey(goalId);
	}

	/**
	* Returns the goal master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param goalId the primary key of the goal master
	* @return the goal master, or <code>null</code> if a goal master with the primary key could not be found
	*/
	public static GoalMaster fetchByPrimaryKey(long goalId) {
		return getPersistence().fetchByPrimaryKey(goalId);
	}

	public static java.util.Map<java.io.Serializable, GoalMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the goal masters.
	*
	* @return the goal masters
	*/
	public static List<GoalMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goal masters
	* @param end the upper bound of the range of goal masters (not inclusive)
	* @return the range of goal masters
	*/
	public static List<GoalMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goal masters
	* @param end the upper bound of the range of goal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of goal masters
	*/
	public static List<GoalMaster> findAll(int start, int end,
		OrderByComparator<GoalMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goal masters
	* @param end the upper bound of the range of goal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of goal masters
	*/
	public static List<GoalMaster> findAll(int start, int end,
		OrderByComparator<GoalMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the goal masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of goal masters.
	*
	* @return the number of goal masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GoalMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GoalMasterPersistence, GoalMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GoalMasterPersistence.class);

		ServiceTracker<GoalMasterPersistence, GoalMasterPersistence> serviceTracker =
			new ServiceTracker<GoalMasterPersistence, GoalMasterPersistence>(bundle.getBundleContext(),
				GoalMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}