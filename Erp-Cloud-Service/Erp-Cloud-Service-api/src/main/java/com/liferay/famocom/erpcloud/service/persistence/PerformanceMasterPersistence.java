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

import com.liferay.famocom.erpcloud.exception.NoSuchPerformanceMasterException;
import com.liferay.famocom.erpcloud.model.PerformanceMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the performance master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PerformanceMasterPersistenceImpl
 * @see PerformanceMasterUtil
 * @generated
 */
@ProviderType
public interface PerformanceMasterPersistence extends BasePersistence<PerformanceMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PerformanceMasterUtil} to access the performance master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the performance master in the entity cache if it is enabled.
	*
	* @param performanceMaster the performance master
	*/
	public void cacheResult(PerformanceMaster performanceMaster);

	/**
	* Caches the performance masters in the entity cache if it is enabled.
	*
	* @param performanceMasters the performance masters
	*/
	public void cacheResult(
		java.util.List<PerformanceMaster> performanceMasters);

	/**
	* Creates a new performance master with the primary key. Does not add the performance master to the database.
	*
	* @param performanceId the primary key for the new performance master
	* @return the new performance master
	*/
	public PerformanceMaster create(long performanceId);

	/**
	* Removes the performance master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param performanceId the primary key of the performance master
	* @return the performance master that was removed
	* @throws NoSuchPerformanceMasterException if a performance master with the primary key could not be found
	*/
	public PerformanceMaster remove(long performanceId)
		throws NoSuchPerformanceMasterException;

	public PerformanceMaster updateImpl(PerformanceMaster performanceMaster);

	/**
	* Returns the performance master with the primary key or throws a {@link NoSuchPerformanceMasterException} if it could not be found.
	*
	* @param performanceId the primary key of the performance master
	* @return the performance master
	* @throws NoSuchPerformanceMasterException if a performance master with the primary key could not be found
	*/
	public PerformanceMaster findByPrimaryKey(long performanceId)
		throws NoSuchPerformanceMasterException;

	/**
	* Returns the performance master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param performanceId the primary key of the performance master
	* @return the performance master, or <code>null</code> if a performance master with the primary key could not be found
	*/
	public PerformanceMaster fetchByPrimaryKey(long performanceId);

	@Override
	public java.util.Map<java.io.Serializable, PerformanceMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the performance masters.
	*
	* @return the performance masters
	*/
	public java.util.List<PerformanceMaster> findAll();

	/**
	* Returns a range of all the performance masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performance masters
	* @param end the upper bound of the range of performance masters (not inclusive)
	* @return the range of performance masters
	*/
	public java.util.List<PerformanceMaster> findAll(int start, int end);

	/**
	* Returns an ordered range of all the performance masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performance masters
	* @param end the upper bound of the range of performance masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of performance masters
	*/
	public java.util.List<PerformanceMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PerformanceMaster> orderByComparator);

	/**
	* Returns an ordered range of all the performance masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performance masters
	* @param end the upper bound of the range of performance masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of performance masters
	*/
	public java.util.List<PerformanceMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PerformanceMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the performance masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of performance masters.
	*
	* @return the number of performance masters
	*/
	public int countAll();
}