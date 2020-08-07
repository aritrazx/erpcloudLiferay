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

import com.liferay.famocom.erpcloud.model.Milestone;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the milestone service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.MilestonePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see MilestonePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.MilestonePersistenceImpl
 * @generated
 */
@ProviderType
public class MilestoneUtil {
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
	public static void clearCache(Milestone milestone) {
		getPersistence().clearCache(milestone);
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
	public static List<Milestone> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Milestone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Milestone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Milestone> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Milestone update(Milestone milestone) {
		return getPersistence().update(milestone);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Milestone update(Milestone milestone,
		ServiceContext serviceContext) {
		return getPersistence().update(milestone, serviceContext);
	}

	/**
	* Caches the milestone in the entity cache if it is enabled.
	*
	* @param milestone the milestone
	*/
	public static void cacheResult(Milestone milestone) {
		getPersistence().cacheResult(milestone);
	}

	/**
	* Caches the milestones in the entity cache if it is enabled.
	*
	* @param milestones the milestones
	*/
	public static void cacheResult(List<Milestone> milestones) {
		getPersistence().cacheResult(milestones);
	}

	/**
	* Creates a new milestone with the primary key. Does not add the milestone to the database.
	*
	* @param milestoneId the primary key for the new milestone
	* @return the new milestone
	*/
	public static Milestone create(long milestoneId) {
		return getPersistence().create(milestoneId);
	}

	/**
	* Removes the milestone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param milestoneId the primary key of the milestone
	* @return the milestone that was removed
	* @throws NoSuchMilestoneException if a milestone with the primary key could not be found
	*/
	public static Milestone remove(long milestoneId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMilestoneException {
		return getPersistence().remove(milestoneId);
	}

	public static Milestone updateImpl(Milestone milestone) {
		return getPersistence().updateImpl(milestone);
	}

	/**
	* Returns the milestone with the primary key or throws a {@link NoSuchMilestoneException} if it could not be found.
	*
	* @param milestoneId the primary key of the milestone
	* @return the milestone
	* @throws NoSuchMilestoneException if a milestone with the primary key could not be found
	*/
	public static Milestone findByPrimaryKey(long milestoneId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchMilestoneException {
		return getPersistence().findByPrimaryKey(milestoneId);
	}

	/**
	* Returns the milestone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param milestoneId the primary key of the milestone
	* @return the milestone, or <code>null</code> if a milestone with the primary key could not be found
	*/
	public static Milestone fetchByPrimaryKey(long milestoneId) {
		return getPersistence().fetchByPrimaryKey(milestoneId);
	}

	public static java.util.Map<java.io.Serializable, Milestone> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the milestones.
	*
	* @return the milestones
	*/
	public static List<Milestone> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Milestone> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Milestone> findAll(int start, int end,
		OrderByComparator<Milestone> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Milestone> findAll(int start, int end,
		OrderByComparator<Milestone> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the milestones from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of milestones.
	*
	* @return the number of milestones
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MilestonePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MilestonePersistence, MilestonePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MilestonePersistence.class);

		ServiceTracker<MilestonePersistence, MilestonePersistence> serviceTracker =
			new ServiceTracker<MilestonePersistence, MilestonePersistence>(bundle.getBundleContext(),
				MilestonePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}