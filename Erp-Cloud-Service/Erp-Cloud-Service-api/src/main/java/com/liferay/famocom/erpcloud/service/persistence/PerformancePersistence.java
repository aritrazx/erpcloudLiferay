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

import com.liferay.famocom.erpcloud.exception.NoSuchPerformanceException;
import com.liferay.famocom.erpcloud.model.Performance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the performance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PerformancePersistenceImpl
 * @see PerformanceUtil
 * @generated
 */
@ProviderType
public interface PerformancePersistence extends BasePersistence<Performance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PerformanceUtil} to access the performance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the performance in the entity cache if it is enabled.
	*
	* @param performance the performance
	*/
	public void cacheResult(Performance performance);

	/**
	* Caches the performances in the entity cache if it is enabled.
	*
	* @param performances the performances
	*/
	public void cacheResult(java.util.List<Performance> performances);

	/**
	* Creates a new performance with the primary key. Does not add the performance to the database.
	*
	* @param performanceId the primary key for the new performance
	* @return the new performance
	*/
	public Performance create(long performanceId);

	/**
	* Removes the performance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param performanceId the primary key of the performance
	* @return the performance that was removed
	* @throws NoSuchPerformanceException if a performance with the primary key could not be found
	*/
	public Performance remove(long performanceId)
		throws NoSuchPerformanceException;

	public Performance updateImpl(Performance performance);

	/**
	* Returns the performance with the primary key or throws a {@link NoSuchPerformanceException} if it could not be found.
	*
	* @param performanceId the primary key of the performance
	* @return the performance
	* @throws NoSuchPerformanceException if a performance with the primary key could not be found
	*/
	public Performance findByPrimaryKey(long performanceId)
		throws NoSuchPerformanceException;

	/**
	* Returns the performance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param performanceId the primary key of the performance
	* @return the performance, or <code>null</code> if a performance with the primary key could not be found
	*/
	public Performance fetchByPrimaryKey(long performanceId);

	@Override
	public java.util.Map<java.io.Serializable, Performance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the performances.
	*
	* @return the performances
	*/
	public java.util.List<Performance> findAll();

	/**
	* Returns a range of all the performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performances
	* @param end the upper bound of the range of performances (not inclusive)
	* @return the range of performances
	*/
	public java.util.List<Performance> findAll(int start, int end);

	/**
	* Returns an ordered range of all the performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performances
	* @param end the upper bound of the range of performances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of performances
	*/
	public java.util.List<Performance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Performance> orderByComparator);

	/**
	* Returns an ordered range of all the performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performances
	* @param end the upper bound of the range of performances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of performances
	*/
	public java.util.List<Performance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Performance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the performances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of performances.
	*
	* @return the number of performances
	*/
	public int countAll();
}