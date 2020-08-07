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

import com.liferay.famocom.erpcloud.model.Resignation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the resignation service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ResignationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ResignationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ResignationPersistenceImpl
 * @generated
 */
@ProviderType
public class ResignationUtil {
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
	public static void clearCache(Resignation resignation) {
		getPersistence().clearCache(resignation);
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
	public static List<Resignation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Resignation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Resignation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Resignation> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Resignation update(Resignation resignation) {
		return getPersistence().update(resignation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Resignation update(Resignation resignation,
		ServiceContext serviceContext) {
		return getPersistence().update(resignation, serviceContext);
	}

	/**
	* Caches the resignation in the entity cache if it is enabled.
	*
	* @param resignation the resignation
	*/
	public static void cacheResult(Resignation resignation) {
		getPersistence().cacheResult(resignation);
	}

	/**
	* Caches the resignations in the entity cache if it is enabled.
	*
	* @param resignations the resignations
	*/
	public static void cacheResult(List<Resignation> resignations) {
		getPersistence().cacheResult(resignations);
	}

	/**
	* Creates a new resignation with the primary key. Does not add the resignation to the database.
	*
	* @param ResignationId the primary key for the new resignation
	* @return the new resignation
	*/
	public static Resignation create(long ResignationId) {
		return getPersistence().create(ResignationId);
	}

	/**
	* Removes the resignation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ResignationId the primary key of the resignation
	* @return the resignation that was removed
	* @throws NoSuchResignationException if a resignation with the primary key could not be found
	*/
	public static Resignation remove(long ResignationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchResignationException {
		return getPersistence().remove(ResignationId);
	}

	public static Resignation updateImpl(Resignation resignation) {
		return getPersistence().updateImpl(resignation);
	}

	/**
	* Returns the resignation with the primary key or throws a {@link NoSuchResignationException} if it could not be found.
	*
	* @param ResignationId the primary key of the resignation
	* @return the resignation
	* @throws NoSuchResignationException if a resignation with the primary key could not be found
	*/
	public static Resignation findByPrimaryKey(long ResignationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchResignationException {
		return getPersistence().findByPrimaryKey(ResignationId);
	}

	/**
	* Returns the resignation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ResignationId the primary key of the resignation
	* @return the resignation, or <code>null</code> if a resignation with the primary key could not be found
	*/
	public static Resignation fetchByPrimaryKey(long ResignationId) {
		return getPersistence().fetchByPrimaryKey(ResignationId);
	}

	public static java.util.Map<java.io.Serializable, Resignation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the resignations.
	*
	* @return the resignations
	*/
	public static List<Resignation> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the resignations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ResignationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of resignations
	* @param end the upper bound of the range of resignations (not inclusive)
	* @return the range of resignations
	*/
	public static List<Resignation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the resignations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ResignationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of resignations
	* @param end the upper bound of the range of resignations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of resignations
	*/
	public static List<Resignation> findAll(int start, int end,
		OrderByComparator<Resignation> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the resignations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ResignationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of resignations
	* @param end the upper bound of the range of resignations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of resignations
	*/
	public static List<Resignation> findAll(int start, int end,
		OrderByComparator<Resignation> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the resignations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of resignations.
	*
	* @return the number of resignations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ResignationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ResignationPersistence, ResignationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ResignationPersistence.class);

		ServiceTracker<ResignationPersistence, ResignationPersistence> serviceTracker =
			new ServiceTracker<ResignationPersistence, ResignationPersistence>(bundle.getBundleContext(),
				ResignationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}