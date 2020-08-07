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

import com.liferay.famocom.erpcloud.exception.NoSuchTaskMasterMappingException;
import com.liferay.famocom.erpcloud.model.TaskMasterMapping;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the task master mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TaskMasterMappingPersistenceImpl
 * @see TaskMasterMappingUtil
 * @generated
 */
@ProviderType
public interface TaskMasterMappingPersistence extends BasePersistence<TaskMasterMapping> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskMasterMappingUtil} to access the task master mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the task master mapping in the entity cache if it is enabled.
	*
	* @param taskMasterMapping the task master mapping
	*/
	public void cacheResult(TaskMasterMapping taskMasterMapping);

	/**
	* Caches the task master mappings in the entity cache if it is enabled.
	*
	* @param taskMasterMappings the task master mappings
	*/
	public void cacheResult(
		java.util.List<TaskMasterMapping> taskMasterMappings);

	/**
	* Creates a new task master mapping with the primary key. Does not add the task master mapping to the database.
	*
	* @param taskMappingId the primary key for the new task master mapping
	* @return the new task master mapping
	*/
	public TaskMasterMapping create(long taskMappingId);

	/**
	* Removes the task master mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskMappingId the primary key of the task master mapping
	* @return the task master mapping that was removed
	* @throws NoSuchTaskMasterMappingException if a task master mapping with the primary key could not be found
	*/
	public TaskMasterMapping remove(long taskMappingId)
		throws NoSuchTaskMasterMappingException;

	public TaskMasterMapping updateImpl(TaskMasterMapping taskMasterMapping);

	/**
	* Returns the task master mapping with the primary key or throws a {@link NoSuchTaskMasterMappingException} if it could not be found.
	*
	* @param taskMappingId the primary key of the task master mapping
	* @return the task master mapping
	* @throws NoSuchTaskMasterMappingException if a task master mapping with the primary key could not be found
	*/
	public TaskMasterMapping findByPrimaryKey(long taskMappingId)
		throws NoSuchTaskMasterMappingException;

	/**
	* Returns the task master mapping with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskMappingId the primary key of the task master mapping
	* @return the task master mapping, or <code>null</code> if a task master mapping with the primary key could not be found
	*/
	public TaskMasterMapping fetchByPrimaryKey(long taskMappingId);

	@Override
	public java.util.Map<java.io.Serializable, TaskMasterMapping> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the task master mappings.
	*
	* @return the task master mappings
	*/
	public java.util.List<TaskMasterMapping> findAll();

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
	public java.util.List<TaskMasterMapping> findAll(int start, int end);

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
	public java.util.List<TaskMasterMapping> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskMasterMapping> orderByComparator);

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
	public java.util.List<TaskMasterMapping> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskMasterMapping> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the task master mappings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of task master mappings.
	*
	* @return the number of task master mappings
	*/
	public int countAll();
}