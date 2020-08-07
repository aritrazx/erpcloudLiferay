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

import com.liferay.famocom.erpcloud.exception.NoSuchProjectRoleException;
import com.liferay.famocom.erpcloud.model.ProjectRole;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ProjectRolePersistenceImpl
 * @see ProjectRoleUtil
 * @generated
 */
@ProviderType
public interface ProjectRolePersistence extends BasePersistence<ProjectRole> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectRoleUtil} to access the project role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the project role in the entity cache if it is enabled.
	*
	* @param projectRole the project role
	*/
	public void cacheResult(ProjectRole projectRole);

	/**
	* Caches the project roles in the entity cache if it is enabled.
	*
	* @param projectRoles the project roles
	*/
	public void cacheResult(java.util.List<ProjectRole> projectRoles);

	/**
	* Creates a new project role with the primary key. Does not add the project role to the database.
	*
	* @param roleId the primary key for the new project role
	* @return the new project role
	*/
	public ProjectRole create(long roleId);

	/**
	* Removes the project role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roleId the primary key of the project role
	* @return the project role that was removed
	* @throws NoSuchProjectRoleException if a project role with the primary key could not be found
	*/
	public ProjectRole remove(long roleId) throws NoSuchProjectRoleException;

	public ProjectRole updateImpl(ProjectRole projectRole);

	/**
	* Returns the project role with the primary key or throws a {@link NoSuchProjectRoleException} if it could not be found.
	*
	* @param roleId the primary key of the project role
	* @return the project role
	* @throws NoSuchProjectRoleException if a project role with the primary key could not be found
	*/
	public ProjectRole findByPrimaryKey(long roleId)
		throws NoSuchProjectRoleException;

	/**
	* Returns the project role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param roleId the primary key of the project role
	* @return the project role, or <code>null</code> if a project role with the primary key could not be found
	*/
	public ProjectRole fetchByPrimaryKey(long roleId);

	@Override
	public java.util.Map<java.io.Serializable, ProjectRole> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project roles.
	*
	* @return the project roles
	*/
	public java.util.List<ProjectRole> findAll();

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
	public java.util.List<ProjectRole> findAll(int start, int end);

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
	public java.util.List<ProjectRole> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRole> orderByComparator);

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
	public java.util.List<ProjectRole> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRole> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project roles from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project roles.
	*
	* @return the number of project roles
	*/
	public int countAll();
}