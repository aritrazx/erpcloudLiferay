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

import com.liferay.famocom.erpcloud.model.SkillSet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the skill set service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.SkillSetPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SkillSetPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.SkillSetPersistenceImpl
 * @generated
 */
@ProviderType
public class SkillSetUtil {
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
	public static void clearCache(SkillSet skillSet) {
		getPersistence().clearCache(skillSet);
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
	public static List<SkillSet> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SkillSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SkillSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SkillSet> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SkillSet update(SkillSet skillSet) {
		return getPersistence().update(skillSet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SkillSet update(SkillSet skillSet,
		ServiceContext serviceContext) {
		return getPersistence().update(skillSet, serviceContext);
	}

	/**
	* Caches the skill set in the entity cache if it is enabled.
	*
	* @param skillSet the skill set
	*/
	public static void cacheResult(SkillSet skillSet) {
		getPersistence().cacheResult(skillSet);
	}

	/**
	* Caches the skill sets in the entity cache if it is enabled.
	*
	* @param skillSets the skill sets
	*/
	public static void cacheResult(List<SkillSet> skillSets) {
		getPersistence().cacheResult(skillSets);
	}

	/**
	* Creates a new skill set with the primary key. Does not add the skill set to the database.
	*
	* @param SkillId the primary key for the new skill set
	* @return the new skill set
	*/
	public static SkillSet create(long SkillId) {
		return getPersistence().create(SkillId);
	}

	/**
	* Removes the skill set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SkillId the primary key of the skill set
	* @return the skill set that was removed
	* @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	*/
	public static SkillSet remove(long SkillId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSkillSetException {
		return getPersistence().remove(SkillId);
	}

	public static SkillSet updateImpl(SkillSet skillSet) {
		return getPersistence().updateImpl(skillSet);
	}

	/**
	* Returns the skill set with the primary key or throws a {@link NoSuchSkillSetException} if it could not be found.
	*
	* @param SkillId the primary key of the skill set
	* @return the skill set
	* @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	*/
	public static SkillSet findByPrimaryKey(long SkillId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSkillSetException {
		return getPersistence().findByPrimaryKey(SkillId);
	}

	/**
	* Returns the skill set with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SkillId the primary key of the skill set
	* @return the skill set, or <code>null</code> if a skill set with the primary key could not be found
	*/
	public static SkillSet fetchByPrimaryKey(long SkillId) {
		return getPersistence().fetchByPrimaryKey(SkillId);
	}

	public static java.util.Map<java.io.Serializable, SkillSet> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the skill sets.
	*
	* @return the skill sets
	*/
	public static List<SkillSet> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the skill sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skill sets
	* @param end the upper bound of the range of skill sets (not inclusive)
	* @return the range of skill sets
	*/
	public static List<SkillSet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the skill sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skill sets
	* @param end the upper bound of the range of skill sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of skill sets
	*/
	public static List<SkillSet> findAll(int start, int end,
		OrderByComparator<SkillSet> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the skill sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skill sets
	* @param end the upper bound of the range of skill sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of skill sets
	*/
	public static List<SkillSet> findAll(int start, int end,
		OrderByComparator<SkillSet> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the skill sets from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of skill sets.
	*
	* @return the number of skill sets
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SkillSetPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SkillSetPersistence, SkillSetPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SkillSetPersistence.class);

		ServiceTracker<SkillSetPersistence, SkillSetPersistence> serviceTracker = new ServiceTracker<SkillSetPersistence, SkillSetPersistence>(bundle.getBundleContext(),
				SkillSetPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}