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

import com.liferay.famocom.erpcloud.exception.NoSuchProjectTaskException;
import com.liferay.famocom.erpcloud.model.ProjectTask;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ProjectTaskPersistenceImpl
 * @see ProjectTaskUtil
 * @generated
 */
@ProviderType
public interface ProjectTaskPersistence extends BasePersistence<ProjectTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectTaskUtil} to access the project task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the project task in the entity cache if it is enabled.
	*
	* @param projectTask the project task
	*/
	public void cacheResult(ProjectTask projectTask);

	/**
	* Caches the project tasks in the entity cache if it is enabled.
	*
	* @param projectTasks the project tasks
	*/
	public void cacheResult(java.util.List<ProjectTask> projectTasks);

	/**
	* Creates a new project task with the primary key. Does not add the project task to the database.
	*
	* @param projectTaskId the primary key for the new project task
	* @return the new project task
	*/
	public ProjectTask create(long projectTaskId);

	/**
	* Removes the project task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task that was removed
	* @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	*/
	public ProjectTask remove(long projectTaskId)
		throws NoSuchProjectTaskException;

	public ProjectTask updateImpl(ProjectTask projectTask);

	/**
	* Returns the project task with the primary key or throws a {@link NoSuchProjectTaskException} if it could not be found.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task
	* @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	*/
	public ProjectTask findByPrimaryKey(long projectTaskId)
		throws NoSuchProjectTaskException;

	/**
	* Returns the project task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task, or <code>null</code> if a project task with the primary key could not be found
	*/
	public ProjectTask fetchByPrimaryKey(long projectTaskId);

	@Override
	public java.util.Map<java.io.Serializable, ProjectTask> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project tasks.
	*
	* @return the project tasks
	*/
	public java.util.List<ProjectTask> findAll();

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
	public java.util.List<ProjectTask> findAll(int start, int end);

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
	public java.util.List<ProjectTask> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTask> orderByComparator);

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
	public java.util.List<ProjectTask> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project tasks from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project tasks.
	*
	* @return the number of project tasks
	*/
	public int countAll();
}