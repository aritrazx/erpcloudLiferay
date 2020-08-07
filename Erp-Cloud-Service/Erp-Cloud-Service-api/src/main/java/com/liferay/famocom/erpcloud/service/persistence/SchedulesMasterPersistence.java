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

import com.liferay.famocom.erpcloud.exception.NoSuchSchedulesMasterException;
import com.liferay.famocom.erpcloud.model.SchedulesMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the schedules master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.SchedulesMasterPersistenceImpl
 * @see SchedulesMasterUtil
 * @generated
 */
@ProviderType
public interface SchedulesMasterPersistence extends BasePersistence<SchedulesMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SchedulesMasterUtil} to access the schedules master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the schedules master in the entity cache if it is enabled.
	*
	* @param schedulesMaster the schedules master
	*/
	public void cacheResult(SchedulesMaster schedulesMaster);

	/**
	* Caches the schedules masters in the entity cache if it is enabled.
	*
	* @param schedulesMasters the schedules masters
	*/
	public void cacheResult(java.util.List<SchedulesMaster> schedulesMasters);

	/**
	* Creates a new schedules master with the primary key. Does not add the schedules master to the database.
	*
	* @param schedulesId the primary key for the new schedules master
	* @return the new schedules master
	*/
	public SchedulesMaster create(long schedulesId);

	/**
	* Removes the schedules master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schedulesId the primary key of the schedules master
	* @return the schedules master that was removed
	* @throws NoSuchSchedulesMasterException if a schedules master with the primary key could not be found
	*/
	public SchedulesMaster remove(long schedulesId)
		throws NoSuchSchedulesMasterException;

	public SchedulesMaster updateImpl(SchedulesMaster schedulesMaster);

	/**
	* Returns the schedules master with the primary key or throws a {@link NoSuchSchedulesMasterException} if it could not be found.
	*
	* @param schedulesId the primary key of the schedules master
	* @return the schedules master
	* @throws NoSuchSchedulesMasterException if a schedules master with the primary key could not be found
	*/
	public SchedulesMaster findByPrimaryKey(long schedulesId)
		throws NoSuchSchedulesMasterException;

	/**
	* Returns the schedules master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param schedulesId the primary key of the schedules master
	* @return the schedules master, or <code>null</code> if a schedules master with the primary key could not be found
	*/
	public SchedulesMaster fetchByPrimaryKey(long schedulesId);

	@Override
	public java.util.Map<java.io.Serializable, SchedulesMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the schedules masters.
	*
	* @return the schedules masters
	*/
	public java.util.List<SchedulesMaster> findAll();

	/**
	* Returns a range of all the schedules masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules masters
	* @param end the upper bound of the range of schedules masters (not inclusive)
	* @return the range of schedules masters
	*/
	public java.util.List<SchedulesMaster> findAll(int start, int end);

	/**
	* Returns an ordered range of all the schedules masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules masters
	* @param end the upper bound of the range of schedules masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of schedules masters
	*/
	public java.util.List<SchedulesMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesMaster> orderByComparator);

	/**
	* Returns an ordered range of all the schedules masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules masters
	* @param end the upper bound of the range of schedules masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of schedules masters
	*/
	public java.util.List<SchedulesMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchedulesMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the schedules masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of schedules masters.
	*
	* @return the number of schedules masters
	*/
	public int countAll();
}