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

import com.liferay.famocom.erpcloud.model.ProjectTask;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project task service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ProjectTaskPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ProjectTaskPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ProjectTaskPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectTaskUtil {
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
	public static void clearCache(ProjectTask projectTask) {
		getPersistence().clearCache(projectTask);
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
	public static List<ProjectTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectTask update(ProjectTask projectTask) {
		return getPersistence().update(projectTask);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectTask update(ProjectTask projectTask,
		ServiceContext serviceContext) {
		return getPersistence().update(projectTask, serviceContext);
	}

	/**
	* Caches the project task in the entity cache if it is enabled.
	*
	* @param projectTask the project task
	*/
	public static void cacheResult(ProjectTask projectTask) {
		getPersistence().cacheResult(projectTask);
	}

	/**
	* Caches the project tasks in the entity cache if it is enabled.
	*
	* @param projectTasks the project tasks
	*/
	public static void cacheResult(List<ProjectTask> projectTasks) {
		getPersistence().cacheResult(projectTasks);
	}

	/**
	* Creates a new project task with the primary key. Does not add the project task to the database.
	*
	* @param projectTaskId the primary key for the new project task
	* @return the new project task
	*/
	public static ProjectTask create(long projectTaskId) {
		return getPersistence().create(projectTaskId);
	}

	/**
	* Removes the project task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task that was removed
	* @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	*/
	public static ProjectTask remove(long projectTaskId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectTaskException {
		return getPersistence().remove(projectTaskId);
	}

	public static ProjectTask updateImpl(ProjectTask projectTask) {
		return getPersistence().updateImpl(projectTask);
	}

	/**
	* Returns the project task with the primary key or throws a {@link NoSuchProjectTaskException} if it could not be found.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task
	* @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	*/
	public static ProjectTask findByPrimaryKey(long projectTaskId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectTaskException {
		return getPersistence().findByPrimaryKey(projectTaskId);
	}

	/**
	* Returns the project task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task, or <code>null</code> if a project task with the primary key could not be found
	*/
	public static ProjectTask fetchByPrimaryKey(long projectTaskId) {
		return getPersistence().fetchByPrimaryKey(projectTaskId);
	}

	public static java.util.Map<java.io.Serializable, ProjectTask> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project tasks.
	*
	* @return the project tasks
	*/
	public static List<ProjectTask> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @return the range of project tasks
	*/
	public static List<ProjectTask> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project tasks
	*/
	public static List<ProjectTask> findAll(int start, int end,
		OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project tasks
	*/
	public static List<ProjectTask> findAll(int start, int end,
		OrderByComparator<ProjectTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project tasks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project tasks.
	*
	* @return the number of project tasks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectTaskPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectTaskPersistence, ProjectTaskPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectTaskPersistence.class);

		ServiceTracker<ProjectTaskPersistence, ProjectTaskPersistence> serviceTracker =
			new ServiceTracker<ProjectTaskPersistence, ProjectTaskPersistence>(bundle.getBundleContext(),
				ProjectTaskPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}