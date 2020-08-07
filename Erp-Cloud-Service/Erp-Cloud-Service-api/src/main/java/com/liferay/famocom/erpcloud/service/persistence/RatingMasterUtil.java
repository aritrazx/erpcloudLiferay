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

import com.liferay.famocom.erpcloud.model.RatingMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the rating master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.RatingMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see RatingMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.RatingMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class RatingMasterUtil {
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
	public static void clearCache(RatingMaster ratingMaster) {
		getPersistence().clearCache(ratingMaster);
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
	public static List<RatingMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RatingMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RatingMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RatingMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RatingMaster update(RatingMaster ratingMaster) {
		return getPersistence().update(ratingMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RatingMaster update(RatingMaster ratingMaster,
		ServiceContext serviceContext) {
		return getPersistence().update(ratingMaster, serviceContext);
	}

	/**
	* Caches the rating master in the entity cache if it is enabled.
	*
	* @param ratingMaster the rating master
	*/
	public static void cacheResult(RatingMaster ratingMaster) {
		getPersistence().cacheResult(ratingMaster);
	}

	/**
	* Caches the rating masters in the entity cache if it is enabled.
	*
	* @param ratingMasters the rating masters
	*/
	public static void cacheResult(List<RatingMaster> ratingMasters) {
		getPersistence().cacheResult(ratingMasters);
	}

	/**
	* Creates a new rating master with the primary key. Does not add the rating master to the database.
	*
	* @param ratingId the primary key for the new rating master
	* @return the new rating master
	*/
	public static RatingMaster create(long ratingId) {
		return getPersistence().create(ratingId);
	}

	/**
	* Removes the rating master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingId the primary key of the rating master
	* @return the rating master that was removed
	* @throws NoSuchRatingMasterException if a rating master with the primary key could not be found
	*/
	public static RatingMaster remove(long ratingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRatingMasterException {
		return getPersistence().remove(ratingId);
	}

	public static RatingMaster updateImpl(RatingMaster ratingMaster) {
		return getPersistence().updateImpl(ratingMaster);
	}

	/**
	* Returns the rating master with the primary key or throws a {@link NoSuchRatingMasterException} if it could not be found.
	*
	* @param ratingId the primary key of the rating master
	* @return the rating master
	* @throws NoSuchRatingMasterException if a rating master with the primary key could not be found
	*/
	public static RatingMaster findByPrimaryKey(long ratingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRatingMasterException {
		return getPersistence().findByPrimaryKey(ratingId);
	}

	/**
	* Returns the rating master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ratingId the primary key of the rating master
	* @return the rating master, or <code>null</code> if a rating master with the primary key could not be found
	*/
	public static RatingMaster fetchByPrimaryKey(long ratingId) {
		return getPersistence().fetchByPrimaryKey(ratingId);
	}

	public static java.util.Map<java.io.Serializable, RatingMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the rating masters.
	*
	* @return the rating masters
	*/
	public static List<RatingMaster> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<RatingMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<RatingMaster> findAll(int start, int end,
		OrderByComparator<RatingMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<RatingMaster> findAll(int start, int end,
		OrderByComparator<RatingMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the rating masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rating masters.
	*
	* @return the number of rating masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RatingMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RatingMasterPersistence, RatingMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RatingMasterPersistence.class);

		ServiceTracker<RatingMasterPersistence, RatingMasterPersistence> serviceTracker =
			new ServiceTracker<RatingMasterPersistence, RatingMasterPersistence>(bundle.getBundleContext(),
				RatingMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}