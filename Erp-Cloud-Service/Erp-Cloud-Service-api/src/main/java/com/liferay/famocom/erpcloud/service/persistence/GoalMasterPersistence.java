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

import com.liferay.famocom.erpcloud.exception.NoSuchGoalMasterException;
import com.liferay.famocom.erpcloud.model.GoalMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the goal master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.GoalMasterPersistenceImpl
 * @see GoalMasterUtil
 * @generated
 */
@ProviderType
public interface GoalMasterPersistence extends BasePersistence<GoalMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GoalMasterUtil} to access the goal master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the goal master in the entity cache if it is enabled.
	*
	* @param goalMaster the goal master
	*/
	public void cacheResult(GoalMaster goalMaster);

	/**
	* Caches the goal masters in the entity cache if it is enabled.
	*
	* @param goalMasters the goal masters
	*/
	public void cacheResult(java.util.List<GoalMaster> goalMasters);

	/**
	* Creates a new goal master with the primary key. Does not add the goal master to the database.
	*
	* @param goalId the primary key for the new goal master
	* @return the new goal master
	*/
	public GoalMaster create(long goalId);

	/**
	* Removes the goal master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param goalId the primary key of the goal master
	* @return the goal master that was removed
	* @throws NoSuchGoalMasterException if a goal master with the primary key could not be found
	*/
	public GoalMaster remove(long goalId) throws NoSuchGoalMasterException;

	public GoalMaster updateImpl(GoalMaster goalMaster);

	/**
	* Returns the goal master with the primary key or throws a {@link NoSuchGoalMasterException} if it could not be found.
	*
	* @param goalId the primary key of the goal master
	* @return the goal master
	* @throws NoSuchGoalMasterException if a goal master with the primary key could not be found
	*/
	public GoalMaster findByPrimaryKey(long goalId)
		throws NoSuchGoalMasterException;

	/**
	* Returns the goal master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param goalId the primary key of the goal master
	* @return the goal master, or <code>null</code> if a goal master with the primary key could not be found
	*/
	public GoalMaster fetchByPrimaryKey(long goalId);

	@Override
	public java.util.Map<java.io.Serializable, GoalMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the goal masters.
	*
	* @return the goal masters
	*/
	public java.util.List<GoalMaster> findAll();

	/**
	* Returns a range of all the goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goal masters
	* @param end the upper bound of the range of goal masters (not inclusive)
	* @return the range of goal masters
	*/
	public java.util.List<GoalMaster> findAll(int start, int end);

	/**
	* Returns an ordered range of all the goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goal masters
	* @param end the upper bound of the range of goal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of goal masters
	*/
	public java.util.List<GoalMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoalMaster> orderByComparator);

	/**
	* Returns an ordered range of all the goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goal masters
	* @param end the upper bound of the range of goal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of goal masters
	*/
	public java.util.List<GoalMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoalMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the goal masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of goal masters.
	*
	* @return the number of goal masters
	*/
	public int countAll();
}