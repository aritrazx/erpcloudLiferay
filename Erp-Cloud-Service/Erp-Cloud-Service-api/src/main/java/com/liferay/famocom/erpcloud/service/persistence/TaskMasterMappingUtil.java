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

import com.liferay.famocom.erpcloud.model.TaskMasterMapping;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the task master mapping service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.TaskMasterMappingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaskMasterMappingPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TaskMasterMappingPersistenceImpl
 * @generated
 */
@ProviderType
public class TaskMasterMappingUtil {
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
	public static void clearCache(TaskMasterMapping taskMasterMapping) {
		getPersistence().clearCache(taskMasterMapping);
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
	public static List<TaskMasterMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaskMasterMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaskMasterMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaskMasterMapping> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaskMasterMapping update(TaskMasterMapping taskMasterMapping) {
		return getPersistence().update(taskMasterMapping);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaskMasterMapping update(
		TaskMasterMapping taskMasterMapping, ServiceContext serviceContext) {
		return getPersistence().update(taskMasterMapping, serviceContext);
	}

	/**
	* Caches the task master mapping in the entity cache if it is enabled.
	*
	* @param taskMasterMapping the task master mapping
	*/
	public static void cacheResult(TaskMasterMapping taskMasterMapping) {
		getPersistence().cacheResult(taskMasterMapping);
	}

	/**
	* Caches the task master mappings in the entity cache if it is enabled.
	*
	* @param taskMasterMappings the task master mappings
	*/
	public static void cacheResult(List<TaskMasterMapping> taskMasterMappings) {
		getPersistence().cacheResult(taskMasterMappings);
	}

	/**
	* Creates a new task master mapping with the primary key. Does not add the task master mapping to the database.
	*
	* @param taskMappingId the primary key for the new task master mapping
	* @return the new task master mapping
	*/
	public static TaskMasterMapping create(long taskMappingId) {
		return getPersistence().create(taskMappingId);
	}

	/**
	* Removes the task master mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskMappingId the primary key of the task master mapping
	* @return the task master mapping that was removed
	* @throws NoSuchTaskMasterMappingException if a task master mapping with the primary key could not be found
	*/
	public static TaskMasterMapping remove(long taskMappingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaskMasterMappingException {
		return getPersistence().remove(taskMappingId);
	}

	public static TaskMasterMapping updateImpl(
		TaskMasterMapping taskMasterMapping) {
		return getPersistence().updateImpl(taskMasterMapping);
	}

	/**
	* Returns the task master mapping with the primary key or throws a {@link NoSuchTaskMasterMappingException} if it could not be found.
	*
	* @param taskMappingId the primary key of the task master mapping
	* @return the task master mapping
	* @throws NoSuchTaskMasterMappingException if a task master mapping with the primary key could not be found
	*/
	public static TaskMasterMapping findByPrimaryKey(long taskMappingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaskMasterMappingException {
		return getPersistence().findByPrimaryKey(taskMappingId);
	}

	/**
	* Returns the task master mapping with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskMappingId the primary key of the task master mapping
	* @return the task master mapping, or <code>null</code> if a task master mapping with the primary key could not be found
	*/
	public static TaskMasterMapping fetchByPrimaryKey(long taskMappingId) {
		return getPersistence().fetchByPrimaryKey(taskMappingId);
	}

	public static java.util.Map<java.io.Serializable, TaskMasterMapping> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the task master mappings.
	*
	* @return the task master mappings
	*/
	public static List<TaskMasterMapping> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the task master mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task master mappings
	* @param end the upper bound of the range of task master mappings (not inclusive)
	* @return the range of task master mappings
	*/
	public static List<TaskMasterMapping> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the task master mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task master mappings
	* @param end the upper bound of the range of task master mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of task master mappings
	*/
	public static List<TaskMasterMapping> findAll(int start, int end,
		OrderByComparator<TaskMasterMapping> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the task master mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task master mappings
	* @param end the upper bound of the range of task master mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of task master mappings
	*/
	public static List<TaskMasterMapping> findAll(int start, int end,
		OrderByComparator<TaskMasterMapping> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the task master mappings from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of task master mappings.
	*
	* @return the number of task master mappings
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaskMasterMappingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskMasterMappingPersistence, TaskMasterMappingPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskMasterMappingPersistence.class);

		ServiceTracker<TaskMasterMappingPersistence, TaskMasterMappingPersistence> serviceTracker =
			new ServiceTracker<TaskMasterMappingPersistence, TaskMasterMappingPersistence>(bundle.getBundleContext(),
				TaskMasterMappingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}