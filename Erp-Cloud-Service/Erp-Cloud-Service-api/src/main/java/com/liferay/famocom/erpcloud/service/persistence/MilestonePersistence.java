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

import com.liferay.famocom.erpcloud.exception.NoSuchMilestoneException;
import com.liferay.famocom.erpcloud.model.Milestone;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the milestone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.MilestonePersistenceImpl
 * @see MilestoneUtil
 * @generated
 */
@ProviderType
public interface MilestonePersistence extends BasePersistence<Milestone> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MilestoneUtil} to access the milestone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the milestone in the entity cache if it is enabled.
	*
	* @param milestone the milestone
	*/
	public void cacheResult(Milestone milestone);

	/**
	* Caches the milestones in the entity cache if it is enabled.
	*
	* @param milestones the milestones
	*/
	public void cacheResult(java.util.List<Milestone> milestones);

	/**
	* Creates a new milestone with the primary key. Does not add the milestone to the database.
	*
	* @param milestoneId the primary key for the new milestone
	* @return the new milestone
	*/
	public Milestone create(long milestoneId);

	/**
	* Removes the milestone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param milestoneId the primary key of the milestone
	* @return the milestone that was removed
	* @throws NoSuchMilestoneException if a milestone with the primary key could not be found
	*/
	public Milestone remove(long milestoneId) throws NoSuchMilestoneException;

	public Milestone updateImpl(Milestone milestone);

	/**
	* Returns the milestone with the primary key or throws a {@link NoSuchMilestoneException} if it could not be found.
	*
	* @param milestoneId the primary key of the milestone
	* @return the milestone
	* @throws NoSuchMilestoneException if a milestone with the primary key could not be found
	*/
	public Milestone findByPrimaryKey(long milestoneId)
		throws NoSuchMilestoneException;

	/**
	* Returns the milestone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param milestoneId the primary key of the milestone
	* @return the milestone, or <code>null</code> if a milestone with the primary key could not be found
	*/
	public Milestone fetchByPrimaryKey(long milestoneId);

	@Override
	public java.util.Map<java.io.Serializable, Milestone> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the milestones.
	*
	* @return the milestones
	*/
	public java.util.List<Milestone> findAll();

	/**
	* Returns a range of all the milestones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MilestoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of milestones
	* @param end the upper bound of the range of milestones (not inclusive)
	* @return the range of milestones
	*/
	public java.util.List<Milestone> findAll(int start, int end);

	/**
	* Returns an ordered range of all the milestones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MilestoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of milestones
	* @param end the upper bound of the range of milestones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of milestones
	*/
	public java.util.List<Milestone> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Milestone> orderByComparator);

	/**
	* Returns an ordered range of all the milestones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MilestoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of milestones
	* @param end the upper bound of the range of milestones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of milestones
	*/
	public java.util.List<Milestone> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Milestone> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the milestones from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of milestones.
	*
	* @return the number of milestones
	*/
	public int countAll();
}