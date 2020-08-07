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

import com.liferay.famocom.erpcloud.exception.NoSuchProjectStatusException;
import com.liferay.famocom.erpcloud.model.ProjectStatus;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ProjectStatusPersistenceImpl
 * @see ProjectStatusUtil
 * @generated
 */
@ProviderType
public interface ProjectStatusPersistence extends BasePersistence<ProjectStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectStatusUtil} to access the project status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the project status in the entity cache if it is enabled.
	*
	* @param projectStatus the project status
	*/
	public void cacheResult(ProjectStatus projectStatus);

	/**
	* Caches the project statuses in the entity cache if it is enabled.
	*
	* @param projectStatuses the project statuses
	*/
	public void cacheResult(java.util.List<ProjectStatus> projectStatuses);

	/**
	* Creates a new project status with the primary key. Does not add the project status to the database.
	*
	* @param projectStatusId the primary key for the new project status
	* @return the new project status
	*/
	public ProjectStatus create(long projectStatusId);

	/**
	* Removes the project status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectStatusId the primary key of the project status
	* @return the project status that was removed
	* @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	*/
	public ProjectStatus remove(long projectStatusId)
		throws NoSuchProjectStatusException;

	public ProjectStatus updateImpl(ProjectStatus projectStatus);

	/**
	* Returns the project status with the primary key or throws a {@link NoSuchProjectStatusException} if it could not be found.
	*
	* @param projectStatusId the primary key of the project status
	* @return the project status
	* @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	*/
	public ProjectStatus findByPrimaryKey(long projectStatusId)
		throws NoSuchProjectStatusException;

	/**
	* Returns the project status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectStatusId the primary key of the project status
	* @return the project status, or <code>null</code> if a project status with the primary key could not be found
	*/
	public ProjectStatus fetchByPrimaryKey(long projectStatusId);

	@Override
	public java.util.Map<java.io.Serializable, ProjectStatus> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project statuses.
	*
	* @return the project statuses
	*/
	public java.util.List<ProjectStatus> findAll();

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
	public java.util.List<ProjectStatus> findAll(int start, int end);

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
	public java.util.List<ProjectStatus> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectStatus> orderByComparator);

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
	public java.util.List<ProjectStatus> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectStatus> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project statuses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project statuses.
	*
	* @return the number of project statuses
	*/
	public int countAll();
}