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

import com.liferay.famocom.erpcloud.model.TaskMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the task master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.TaskMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaskMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TaskMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class TaskMasterUtil {
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
	public static void clearCache(TaskMaster taskMaster) {
		getPersistence().clearCache(taskMaster);
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
	public static List<TaskMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaskMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaskMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaskMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaskMaster update(TaskMaster taskMaster) {
		return getPersistence().update(taskMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaskMaster update(TaskMaster taskMaster,
		ServiceContext serviceContext) {
		return getPersistence().update(taskMaster, serviceContext);
	}

	/**
	* Caches the task master in the entity cache if it is enabled.
	*
	* @param taskMaster the task master
	*/
	public static void cacheResult(TaskMaster taskMaster) {
		getPersistence().cacheResult(taskMaster);
	}

	/**
	* Caches the task masters in the entity cache if it is enabled.
	*
	* @param taskMasters the task masters
	*/
	public static void cacheResult(List<TaskMaster> taskMasters) {
		getPersistence().cacheResult(taskMasters);
	}

	/**
	* Creates a new task master with the primary key. Does not add the task master to the database.
	*
	* @param taskId the primary key for the new task master
	* @return the new task master
	*/
	public static TaskMaster create(long taskId) {
		return getPersistence().create(taskId);
	}

	/**
	* Removes the task master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the task master
	* @return the task master that was removed
	* @throws NoSuchTaskMasterException if a task master with the primary key could not be found
	*/
	public static TaskMaster remove(long taskId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaskMasterException {
		return getPersistence().remove(taskId);
	}

	public static TaskMaster updateImpl(TaskMaster taskMaster) {
		return getPersistence().updateImpl(taskMaster);
	}

	/**
	* Returns the task master with the primary key or throws a {@link NoSuchTaskMasterException} if it could not be found.
	*
	* @param taskId the primary key of the task master
	* @return the task master
	* @throws NoSuchTaskMasterException if a task master with the primary key could not be found
	*/
	public static TaskMaster findByPrimaryKey(long taskId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaskMasterException {
		return getPersistence().findByPrimaryKey(taskId);
	}

	/**
	* Returns the task master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskId the primary key of the task master
	* @return the task master, or <code>null</code> if a task master with the primary key could not be found
	*/
	public static TaskMaster fetchByPrimaryKey(long taskId) {
		return getPersistence().fetchByPrimaryKey(taskId);
	}

	public static java.util.Map<java.io.Serializable, TaskMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the task masters.
	*
	* @return the task masters
	*/
	public static List<TaskMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the task masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task masters
	* @param end the upper bound of the range of task masters (not inclusive)
	* @return the range of task masters
	*/
	public static List<TaskMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the task masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task masters
	* @param end the upper bound of the range of task masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of task masters
	*/
	public static List<TaskMaster> findAll(int start, int end,
		OrderByComparator<TaskMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the task masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task masters
	* @param end the upper bound of the range of task masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of task masters
	*/
	public static List<TaskMaster> findAll(int start, int end,
		OrderByComparator<TaskMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the task masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of task masters.
	*
	* @return the number of task masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaskMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskMasterPersistence, TaskMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskMasterPersistence.class);

		ServiceTracker<TaskMasterPersistence, TaskMasterPersistence> serviceTracker =
			new ServiceTracker<TaskMasterPersistence, TaskMasterPersistence>(bundle.getBundleContext(),
				TaskMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}