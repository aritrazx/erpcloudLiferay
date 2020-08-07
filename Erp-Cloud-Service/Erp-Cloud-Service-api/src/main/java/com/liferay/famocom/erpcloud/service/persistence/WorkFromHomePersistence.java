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

import com.liferay.famocom.erpcloud.exception.NoSuchWorkFromHomeException;
import com.liferay.famocom.erpcloud.model.WorkFromHome;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the work from home service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.WorkFromHomePersistenceImpl
 * @see WorkFromHomeUtil
 * @generated
 */
@ProviderType
public interface WorkFromHomePersistence extends BasePersistence<WorkFromHome> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkFromHomeUtil} to access the work from home persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the work from home in the entity cache if it is enabled.
	*
	* @param workFromHome the work from home
	*/
	public void cacheResult(WorkFromHome workFromHome);

	/**
	* Caches the work from homes in the entity cache if it is enabled.
	*
	* @param workFromHomes the work from homes
	*/
	public void cacheResult(java.util.List<WorkFromHome> workFromHomes);

	/**
	* Creates a new work from home with the primary key. Does not add the work from home to the database.
	*
	* @param workFromHomeId the primary key for the new work from home
	* @return the new work from home
	*/
	public WorkFromHome create(long workFromHomeId);

	/**
	* Removes the work from home with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workFromHomeId the primary key of the work from home
	* @return the work from home that was removed
	* @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	*/
	public WorkFromHome remove(long workFromHomeId)
		throws NoSuchWorkFromHomeException;

	public WorkFromHome updateImpl(WorkFromHome workFromHome);

	/**
	* Returns the work from home with the primary key or throws a {@link NoSuchWorkFromHomeException} if it could not be found.
	*
	* @param workFromHomeId the primary key of the work from home
	* @return the work from home
	* @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	*/
	public WorkFromHome findByPrimaryKey(long workFromHomeId)
		throws NoSuchWorkFromHomeException;

	/**
	* Returns the work from home with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workFromHomeId the primary key of the work from home
	* @return the work from home, or <code>null</code> if a work from home with the primary key could not be found
	*/
	public WorkFromHome fetchByPrimaryKey(long workFromHomeId);

	@Override
	public java.util.Map<java.io.Serializable, WorkFromHome> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the work from homes.
	*
	* @return the work from homes
	*/
	public java.util.List<WorkFromHome> findAll();

	/**
	* Returns a range of all the work from homes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFromHomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work from homes
	* @param end the upper bound of the range of work from homes (not inclusive)
	* @return the range of work from homes
	*/
	public java.util.List<WorkFromHome> findAll(int start, int end);

	/**
	* Returns an ordered range of all the work from homes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFromHomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work from homes
	* @param end the upper bound of the range of work from homes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of work from homes
	*/
	public java.util.List<WorkFromHome> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome> orderByComparator);

	/**
	* Returns an ordered range of all the work from homes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFromHomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work from homes
	* @param end the upper bound of the range of work from homes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of work from homes
	*/
	public java.util.List<WorkFromHome> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the work from homes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of work from homes.
	*
	* @return the number of work from homes
	*/
	public int countAll();
}