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

import com.liferay.famocom.erpcloud.exception.NoSuchTaskMasterException;
import com.liferay.famocom.erpcloud.model.TaskMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the task master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TaskMasterPersistenceImpl
 * @see TaskMasterUtil
 * @generated
 */
@ProviderType
public interface TaskMasterPersistence extends BasePersistence<TaskMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskMasterUtil} to access the task master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the task master in the entity cache if it is enabled.
	*
	* @param taskMaster the task master
	*/
	public void cacheResult(TaskMaster taskMaster);

	/**
	* Caches the task masters in the entity cache if it is enabled.
	*
	* @param taskMasters the task masters
	*/
	public void cacheResult(java.util.List<TaskMaster> taskMasters);

	/**
	* Creates a new task master with the primary key. Does not add the task master to the database.
	*
	* @param taskId the primary key for the new task master
	* @return the new task master
	*/
	public TaskMaster create(long taskId);

	/**
	* Removes the task master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the task master
	* @return the task master that was removed
	* @throws NoSuchTaskMasterException if a task master with the primary key could not be found
	*/
	public TaskMaster remove(long taskId) throws NoSuchTaskMasterException;

	public TaskMaster updateImpl(TaskMaster taskMaster);

	/**
	* Returns the task master with the primary key or throws a {@link NoSuchTaskMasterException} if it could not be found.
	*
	* @param taskId the primary key of the task master
	* @return the task master
	* @throws NoSuchTaskMasterException if a task master with the primary key could not be found
	*/
	public TaskMaster findByPrimaryKey(long taskId)
		throws NoSuchTaskMasterException;

	/**
	* Returns the task master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskId the primary key of the task master
	* @return the task master, or <code>null</code> if a task master with the primary key could not be found
	*/
	public TaskMaster fetchByPrimaryKey(long taskId);

	@Override
	public java.util.Map<java.io.Serializable, TaskMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the task masters.
	*
	* @return the task masters
	*/
	public java.util.List<TaskMaster> findAll();

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
	public java.util.List<TaskMaster> findAll(int start, int end);

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
	public java.util.List<TaskMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskMaster> orderByComparator);

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
	public java.util.List<TaskMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the task masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of task masters.
	*
	* @return the number of task masters
	*/
	public int countAll();
}