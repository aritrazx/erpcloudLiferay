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

import com.liferay.famocom.erpcloud.model.ProjectRole;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project role service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ProjectRolePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ProjectRolePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ProjectRolePersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectRoleUtil {
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
	public static void clearCache(ProjectRole projectRole) {
		getPersistence().clearCache(projectRole);
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
	public static List<ProjectRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectRole> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectRole update(ProjectRole projectRole) {
		return getPersistence().update(projectRole);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectRole update(ProjectRole projectRole,
		ServiceContext serviceContext) {
		return getPersistence().update(projectRole, serviceContext);
	}

	/**
	* Caches the project role in the entity cache if it is enabled.
	*
	* @param projectRole the project role
	*/
	public static void cacheResult(ProjectRole projectRole) {
		getPersistence().cacheResult(projectRole);
	}

	/**
	* Caches the project roles in the entity cache if it is enabled.
	*
	* @param projectRoles the project roles
	*/
	public static void cacheResult(List<ProjectRole> projectRoles) {
		getPersistence().cacheResult(projectRoles);
	}

	/**
	* Creates a new project role with the primary key. Does not add the project role to the database.
	*
	* @param roleId the primary key for the new project role
	* @return the new project role
	*/
	public static ProjectRole create(long roleId) {
		return getPersistence().create(roleId);
	}

	/**
	* Removes the project role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roleId the primary key of the project role
	* @return the project role that was removed
	* @throws NoSuchProjectRoleException if a project role with the primary key could not be found
	*/
	public static ProjectRole remove(long roleId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectRoleException {
		return getPersistence().remove(roleId);
	}

	public static ProjectRole updateImpl(ProjectRole projectRole) {
		return getPersistence().updateImpl(projectRole);
	}

	/**
	* Returns the project role with the primary key or throws a {@link NoSuchProjectRoleException} if it could not be found.
	*
	* @param roleId the primary key of the project role
	* @return the project role
	* @throws NoSuchProjectRoleException if a project role with the primary key could not be found
	*/
	public static ProjectRole findByPrimaryKey(long roleId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectRoleException {
		return getPersistence().findByPrimaryKey(roleId);
	}

	/**
	* Returns the project role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param roleId the primary key of the project role
	* @return the project role, or <code>null</code> if a project role with the primary key could not be found
	*/
	public static ProjectRole fetchByPrimaryKey(long roleId) {
		return getPersistence().fetchByPrimaryKey(roleId);
	}

	public static java.util.Map<java.io.Serializable, ProjectRole> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project roles.
	*
	* @return the project roles
	*/
	public static List<ProjectRole> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project roles
	* @param end the upper bound of the range of project roles (not inclusive)
	* @return the range of project roles
	*/
	public static List<ProjectRole> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project roles
	* @param end the upper bound of the range of project roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project roles
	*/
	public static List<ProjectRole> findAll(int start, int end,
		OrderByComparator<ProjectRole> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project roles
	* @param end the upper bound of the range of project roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project roles
	*/
	public static List<ProjectRole> findAll(int start, int end,
		OrderByComparator<ProjectRole> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project roles from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project roles.
	*
	* @return the number of project roles
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectRolePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectRolePersistence, ProjectRolePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectRolePersistence.class);

		ServiceTracker<ProjectRolePersistence, ProjectRolePersistence> serviceTracker =
			new ServiceTracker<ProjectRolePersistence, ProjectRolePersistence>(bundle.getBundleContext(),
				ProjectRolePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}