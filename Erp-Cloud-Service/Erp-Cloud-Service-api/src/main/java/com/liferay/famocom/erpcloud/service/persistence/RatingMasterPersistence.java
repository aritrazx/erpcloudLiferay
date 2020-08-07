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

import com.liferay.famocom.erpcloud.exception.NoSuchRatingMasterException;
import com.liferay.famocom.erpcloud.model.RatingMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the rating master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.RatingMasterPersistenceImpl
 * @see RatingMasterUtil
 * @generated
 */
@ProviderType
public interface RatingMasterPersistence extends BasePersistence<RatingMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RatingMasterUtil} to access the rating master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the rating master in the entity cache if it is enabled.
	*
	* @param ratingMaster the rating master
	*/
	public void cacheResult(RatingMaster ratingMaster);

	/**
	* Caches the rating masters in the entity cache if it is enabled.
	*
	* @param ratingMasters the rating masters
	*/
	public void cacheResult(java.util.List<RatingMaster> ratingMasters);

	/**
	* Creates a new rating master with the primary key. Does not add the rating master to the database.
	*
	* @param ratingId the primary key for the new rating master
	* @return the new rating master
	*/
	public RatingMaster create(long ratingId);

	/**
	* Removes the rating master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingId the primary key of the rating master
	* @return the rating master that was removed
	* @throws NoSuchRatingMasterException if a rating master with the primary key could not be found
	*/
	public RatingMaster remove(long ratingId)
		throws NoSuchRatingMasterException;

	public RatingMaster updateImpl(RatingMaster ratingMaster);

	/**
	* Returns the rating master with the primary key or throws a {@link NoSuchRatingMasterException} if it could not be found.
	*
	* @param ratingId the primary key of the rating master
	* @return the rating master
	* @throws NoSuchRatingMasterException if a rating master with the primary key could not be found
	*/
	public RatingMaster findByPrimaryKey(long ratingId)
		throws NoSuchRatingMasterException;

	/**
	* Returns the rating master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ratingId the primary key of the rating master
	* @return the rating master, or <code>null</code> if a rating master with the primary key could not be found
	*/
	public RatingMaster fetchByPrimaryKey(long ratingId);

	@Override
	public java.util.Map<java.io.Serializable, RatingMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the rating masters.
	*
	* @return the rating masters
	*/
	public java.util.List<RatingMaster> findAll();

	/**
	* Returns a range of all the rating masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RatingMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rating masters
	* @param end the upper bound of the range of rating masters (not inclusive)
	* @return the range of rating masters
	*/
	public java.util.List<RatingMaster> findAll(int start, int end);

	/**
	* Returns an ordered range of all the rating masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RatingMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rating masters
	* @param end the upper bound of the range of rating masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rating masters
	*/
	public java.util.List<RatingMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RatingMaster> orderByComparator);

	/**
	* Returns an ordered range of all the rating masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RatingMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rating masters
	* @param end the upper bound of the range of rating masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of rating masters
	*/
	public java.util.List<RatingMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RatingMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the rating masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of rating masters.
	*
	* @return the number of rating masters
	*/
	public int countAll();
}