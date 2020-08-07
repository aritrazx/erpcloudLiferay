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

import com.liferay.famocom.erpcloud.exception.NoSuchGoalDetailsException;
import com.liferay.famocom.erpcloud.model.GoalDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the goal details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.GoalDetailsPersistenceImpl
 * @see GoalDetailsUtil
 * @generated
 */
@ProviderType
public interface GoalDetailsPersistence extends BasePersistence<GoalDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GoalDetailsUtil} to access the goal details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the goal detailses where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @return the matching goal detailses
	*/
	public java.util.List<GoalDetails> findByGoalId(long goalId);

	/**
	* Returns a range of all the goal detailses where goalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param goalId the goal ID
	* @param start the lower bound of the range of goal detailses
	* @param end the upper bound of the range of goal detailses (not inclusive)
	* @return the range of matching goal detailses
	*/
	public java.util.List<GoalDetails> findByGoalId(long goalId, int start,
		int end);

	/**
	* Returns an ordered range of all the goal detailses where goalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param goalId the goal ID
	* @param start the lower bound of the range of goal detailses
	* @param end the upper bound of the range of goal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching goal detailses
	*/
	public java.util.List<GoalDetails> findByGoalId(long goalId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoalDetails> orderByComparator);

	/**
	* Returns an ordered range of all the goal detailses where goalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param goalId the goal ID
	* @param start the lower bound of the range of goal detailses
	* @param end the upper bound of the range of goal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching goal detailses
	*/
	public java.util.List<GoalDetails> findByGoalId(long goalId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first goal details in the ordered set where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching goal details
	* @throws NoSuchGoalDetailsException if a matching goal details could not be found
	*/
	public GoalDetails findByGoalId_First(long goalId,
		com.liferay.portal.kernel.util.OrderByComparator<GoalDetails> orderByComparator)
		throws NoSuchGoalDetailsException;

	/**
	* Returns the first goal details in the ordered set where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching goal details, or <code>null</code> if a matching goal details could not be found
	*/
	public GoalDetails fetchByGoalId_First(long goalId,
		com.liferay.portal.kernel.util.OrderByComparator<GoalDetails> orderByComparator);

	/**
	* Returns the last goal details in the ordered set where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching goal details
	* @throws NoSuchGoalDetailsException if a matching goal details could not be found
	*/
	public GoalDetails findByGoalId_Last(long goalId,
		com.liferay.portal.kernel.util.OrderByComparator<GoalDetails> orderByComparator)
		throws NoSuchGoalDetailsException;

	/**
	* Returns the last goal details in the ordered set where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching goal details, or <code>null</code> if a matching goal details could not be found
	*/
	public GoalDetails fetchByGoalId_Last(long goalId,
		com.liferay.portal.kernel.util.OrderByComparator<GoalDetails> orderByComparator);

	/**
	* Returns the goal detailses before and after the current goal details in the ordered set where goalId = &#63;.
	*
	* @param goaldetailId the primary key of the current goal details
	* @param goalId the goal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next goal details
	* @throws NoSuchGoalDetailsException if a goal details with the primary key could not be found
	*/
	public GoalDetails[] findByGoalId_PrevAndNext(long goaldetailId,
		long goalId,
		com.liferay.portal.kernel.util.OrderByComparator<GoalDetails> orderByComparator)
		throws NoSuchGoalDetailsException;

	/**
	* Removes all the goal detailses where goalId = &#63; from the database.
	*
	* @param goalId the goal ID
	*/
	public void removeByGoalId(long goalId);

	/**
	* Returns the number of goal detailses where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @return the number of matching goal detailses
	*/
	public int countByGoalId(long goalId);

	/**
	* Caches the goal details in the entity cache if it is enabled.
	*
	* @param goalDetails the goal details
	*/
	public void cacheResult(GoalDetails goalDetails);

	/**
	* Caches the goal detailses in the entity cache if it is enabled.
	*
	* @param goalDetailses the goal detailses
	*/
	public void cacheResult(java.util.List<GoalDetails> goalDetailses);

	/**
	* Creates a new goal details with the primary key. Does not add the goal details to the database.
	*
	* @param goaldetailId the primary key for the new goal details
	* @return the new goal details
	*/
	public GoalDetails create(long goaldetailId);

	/**
	* Removes the goal details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param goaldetailId the primary key of the goal details
	* @return the goal details that was removed
	* @throws NoSuchGoalDetailsException if a goal details with the primary key could not be found
	*/
	public GoalDetails remove(long goaldetailId)
		throws NoSuchGoalDetailsException;

	public GoalDetails updateImpl(GoalDetails goalDetails);

	/**
	* Returns the goal details with the primary key or throws a {@link NoSuchGoalDetailsException} if it could not be found.
	*
	* @param goaldetailId the primary key of the goal details
	* @return the goal details
	* @throws NoSuchGoalDetailsException if a goal details with the primary key could not be found
	*/
	public GoalDetails findByPrimaryKey(long goaldetailId)
		throws NoSuchGoalDetailsException;

	/**
	* Returns the goal details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param goaldetailId the primary key of the goal details
	* @return the goal details, or <code>null</code> if a goal details with the primary key could not be found
	*/
	public GoalDetails fetchByPrimaryKey(long goaldetailId);

	@Override
	public java.util.Map<java.io.Serializable, GoalDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the goal detailses.
	*
	* @return the goal detailses
	*/
	public java.util.List<GoalDetails> findAll();

	/**
	* Returns a range of all the goal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goal detailses
	* @param end the upper bound of the range of goal detailses (not inclusive)
	* @return the range of goal detailses
	*/
	public java.util.List<GoalDetails> findAll(int start, int end);

	/**
	* Returns an ordered range of all the goal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goal detailses
	* @param end the upper bound of the range of goal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of goal detailses
	*/
	public java.util.List<GoalDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoalDetails> orderByComparator);

	/**
	* Returns an ordered range of all the goal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goal detailses
	* @param end the upper bound of the range of goal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of goal detailses
	*/
	public java.util.List<GoalDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the goal detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of goal detailses.
	*
	* @return the number of goal detailses
	*/
	public int countAll();
}