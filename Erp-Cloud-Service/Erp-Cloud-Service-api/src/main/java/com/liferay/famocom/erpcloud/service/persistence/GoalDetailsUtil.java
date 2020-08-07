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

import com.liferay.famocom.erpcloud.model.GoalDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the goal details service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.GoalDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see GoalDetailsPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.GoalDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class GoalDetailsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(GoalDetails goalDetails) {
		getPersistence().clearCache(goalDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GoalDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GoalDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GoalDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GoalDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GoalDetails update(GoalDetails goalDetails) {
		return getPersistence().update(goalDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GoalDetails update(GoalDetails goalDetails,
		ServiceContext serviceContext) {
		return getPersistence().update(goalDetails, serviceContext);
	}

	/**
	* Returns all the goal detailses where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @return the matching goal detailses
	*/
	public static List<GoalDetails> findByGoalId(long goalId) {
		return getPersistence().findByGoalId(goalId);
	}

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
	public static List<GoalDetails> findByGoalId(long goalId, int start, int end) {
		return getPersistence().findByGoalId(goalId, start, end);
	}

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
	public static List<GoalDetails> findByGoalId(long goalId, int start,
		int end, OrderByComparator<GoalDetails> orderByComparator) {
		return getPersistence()
				   .findByGoalId(goalId, start, end, orderByComparator);
	}

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
	public static List<GoalDetails> findByGoalId(long goalId, int start,
		int end, OrderByComparator<GoalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGoalId(goalId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first goal details in the ordered set where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching goal details
	* @throws NoSuchGoalDetailsException if a matching goal details could not be found
	*/
	public static GoalDetails findByGoalId_First(long goalId,
		OrderByComparator<GoalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGoalDetailsException {
		return getPersistence().findByGoalId_First(goalId, orderByComparator);
	}

	/**
	* Returns the first goal details in the ordered set where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching goal details, or <code>null</code> if a matching goal details could not be found
	*/
	public static GoalDetails fetchByGoalId_First(long goalId,
		OrderByComparator<GoalDetails> orderByComparator) {
		return getPersistence().fetchByGoalId_First(goalId, orderByComparator);
	}

	/**
	* Returns the last goal details in the ordered set where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching goal details
	* @throws NoSuchGoalDetailsException if a matching goal details could not be found
	*/
	public static GoalDetails findByGoalId_Last(long goalId,
		OrderByComparator<GoalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGoalDetailsException {
		return getPersistence().findByGoalId_Last(goalId, orderByComparator);
	}

	/**
	* Returns the last goal details in the ordered set where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching goal details, or <code>null</code> if a matching goal details could not be found
	*/
	public static GoalDetails fetchByGoalId_Last(long goalId,
		OrderByComparator<GoalDetails> orderByComparator) {
		return getPersistence().fetchByGoalId_Last(goalId, orderByComparator);
	}

	/**
	* Returns the goal detailses before and after the current goal details in the ordered set where goalId = &#63;.
	*
	* @param goaldetailId the primary key of the current goal details
	* @param goalId the goal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next goal details
	* @throws NoSuchGoalDetailsException if a goal details with the primary key could not be found
	*/
	public static GoalDetails[] findByGoalId_PrevAndNext(long goaldetailId,
		long goalId, OrderByComparator<GoalDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGoalDetailsException {
		return getPersistence()
				   .findByGoalId_PrevAndNext(goaldetailId, goalId,
			orderByComparator);
	}

	/**
	* Removes all the goal detailses where goalId = &#63; from the database.
	*
	* @param goalId the goal ID
	*/
	public static void removeByGoalId(long goalId) {
		getPersistence().removeByGoalId(goalId);
	}

	/**
	* Returns the number of goal detailses where goalId = &#63;.
	*
	* @param goalId the goal ID
	* @return the number of matching goal detailses
	*/
	public static int countByGoalId(long goalId) {
		return getPersistence().countByGoalId(goalId);
	}

	/**
	* Caches the goal details in the entity cache if it is enabled.
	*
	* @param goalDetails the goal details
	*/
	public static void cacheResult(GoalDetails goalDetails) {
		getPersistence().cacheResult(goalDetails);
	}

	/**
	* Caches the goal detailses in the entity cache if it is enabled.
	*
	* @param goalDetailses the goal detailses
	*/
	public static void cacheResult(List<GoalDetails> goalDetailses) {
		getPersistence().cacheResult(goalDetailses);
	}

	/**
	* Creates a new goal details with the primary key. Does not add the goal details to the database.
	*
	* @param goaldetailId the primary key for the new goal details
	* @return the new goal details
	*/
	public static GoalDetails create(long goaldetailId) {
		return getPersistence().create(goaldetailId);
	}

	/**
	* Removes the goal details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param goaldetailId the primary key of the goal details
	* @return the goal details that was removed
	* @throws NoSuchGoalDetailsException if a goal details with the primary key could not be found
	*/
	public static GoalDetails remove(long goaldetailId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGoalDetailsException {
		return getPersistence().remove(goaldetailId);
	}

	public static GoalDetails updateImpl(GoalDetails goalDetails) {
		return getPersistence().updateImpl(goalDetails);
	}

	/**
	* Returns the goal details with the primary key or throws a {@link NoSuchGoalDetailsException} if it could not be found.
	*
	* @param goaldetailId the primary key of the goal details
	* @return the goal details
	* @throws NoSuchGoalDetailsException if a goal details with the primary key could not be found
	*/
	public static GoalDetails findByPrimaryKey(long goaldetailId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchGoalDetailsException {
		return getPersistence().findByPrimaryKey(goaldetailId);
	}

	/**
	* Returns the goal details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param goaldetailId the primary key of the goal details
	* @return the goal details, or <code>null</code> if a goal details with the primary key could not be found
	*/
	public static GoalDetails fetchByPrimaryKey(long goaldetailId) {
		return getPersistence().fetchByPrimaryKey(goaldetailId);
	}

	public static java.util.Map<java.io.Serializable, GoalDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the goal detailses.
	*
	* @return the goal detailses
	*/
	public static List<GoalDetails> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<GoalDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<GoalDetails> findAll(int start, int end,
		OrderByComparator<GoalDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<GoalDetails> findAll(int start, int end,
		OrderByComparator<GoalDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the goal detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of goal detailses.
	*
	* @return the number of goal detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GoalDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GoalDetailsPersistence, GoalDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GoalDetailsPersistence.class);

		ServiceTracker<GoalDetailsPersistence, GoalDetailsPersistence> serviceTracker =
			new ServiceTracker<GoalDetailsPersistence, GoalDetailsPersistence>(bundle.getBundleContext(),
				GoalDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}