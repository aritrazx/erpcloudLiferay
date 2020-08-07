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

import com.liferay.famocom.erpcloud.model.ProjectStatus;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project status service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ProjectStatusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ProjectStatusPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ProjectStatusPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectStatusUtil {
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
	public static void clearCache(ProjectStatus projectStatus) {
		getPersistence().clearCache(projectStatus);
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
	public static List<ProjectStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectStatus update(ProjectStatus projectStatus) {
		return getPersistence().update(projectStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectStatus update(ProjectStatus projectStatus,
		ServiceContext serviceContext) {
		return getPersistence().update(projectStatus, serviceContext);
	}

	/**
	* Caches the project status in the entity cache if it is enabled.
	*
	* @param projectStatus the project status
	*/
	public static void cacheResult(ProjectStatus projectStatus) {
		getPersistence().cacheResult(projectStatus);
	}

	/**
	* Caches the project statuses in the entity cache if it is enabled.
	*
	* @param projectStatuses the project statuses
	*/
	public static void cacheResult(List<ProjectStatus> projectStatuses) {
		getPersistence().cacheResult(projectStatuses);
	}

	/**
	* Creates a new project status with the primary key. Does not add the project status to the database.
	*
	* @param projectStatusId the primary key for the new project status
	* @return the new project status
	*/
	public static ProjectStatus create(long projectStatusId) {
		return getPersistence().create(projectStatusId);
	}

	/**
	* Removes the project status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectStatusId the primary key of the project status
	* @return the project status that was removed
	* @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	*/
	public static ProjectStatus remove(long projectStatusId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectStatusException {
		return getPersistence().remove(projectStatusId);
	}

	public static ProjectStatus updateImpl(ProjectStatus projectStatus) {
		return getPersistence().updateImpl(projectStatus);
	}

	/**
	* Returns the project status with the primary key or throws a {@link NoSuchProjectStatusException} if it could not be found.
	*
	* @param projectStatusId the primary key of the project status
	* @return the project status
	* @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	*/
	public static ProjectStatus findByPrimaryKey(long projectStatusId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectStatusException {
		return getPersistence().findByPrimaryKey(projectStatusId);
	}

	/**
	* Returns the project status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectStatusId the primary key of the project status
	* @return the project status, or <code>null</code> if a project status with the primary key could not be found
	*/
	public static ProjectStatus fetchByPrimaryKey(long projectStatusId) {
		return getPersistence().fetchByPrimaryKey(projectStatusId);
	}

	public static java.util.Map<java.io.Serializable, ProjectStatus> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project statuses.
	*
	* @return the project statuses
	*/
	public static List<ProjectStatus> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project statuses
	* @param end the upper bound of the range of project statuses (not inclusive)
	* @return the range of project statuses
	*/
	public static List<ProjectStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project statuses
	* @param end the upper bound of the range of project statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project statuses
	*/
	public static List<ProjectStatus> findAll(int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project statuses
	* @param end the upper bound of the range of project statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project statuses
	*/
	public static List<ProjectStatus> findAll(int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project statuses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project statuses.
	*
	* @return the number of project statuses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectStatusPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectStatusPersistence, ProjectStatusPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectStatusPersistence.class);

		ServiceTracker<ProjectStatusPersistence, ProjectStatusPersistence> serviceTracker =
			new ServiceTracker<ProjectStatusPersistence, ProjectStatusPersistence>(bundle.getBundleContext(),
				ProjectStatusPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}