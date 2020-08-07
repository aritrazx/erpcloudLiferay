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

import com.liferay.famocom.erpcloud.model.YearSetting;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the year setting service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.YearSettingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see YearSettingPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.YearSettingPersistenceImpl
 * @generated
 */
@ProviderType
public class YearSettingUtil {
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
	public static void clearCache(YearSetting yearSetting) {
		getPersistence().clearCache(yearSetting);
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
	public static List<YearSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<YearSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<YearSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<YearSetting> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static YearSetting update(YearSetting yearSetting) {
		return getPersistence().update(yearSetting);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static YearSetting update(YearSetting yearSetting,
		ServiceContext serviceContext) {
		return getPersistence().update(yearSetting, serviceContext);
	}

	/**
	* Returns the year setting where isActive = &#63; or throws a {@link NoSuchYearSettingException} if it could not be found.
	*
	* @param isActive the is active
	* @return the matching year setting
	* @throws NoSuchYearSettingException if a matching year setting could not be found
	*/
	public static YearSetting findByisActive(int isActive)
		throws com.liferay.famocom.erpcloud.exception.NoSuchYearSettingException {
		return getPersistence().findByisActive(isActive);
	}

	/**
	* Returns the year setting where isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param isActive the is active
	* @return the matching year setting, or <code>null</code> if a matching year setting could not be found
	*/
	public static YearSetting fetchByisActive(int isActive) {
		return getPersistence().fetchByisActive(isActive);
	}

	/**
	* Returns the year setting where isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param isActive the is active
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching year setting, or <code>null</code> if a matching year setting could not be found
	*/
	public static YearSetting fetchByisActive(int isActive,
		boolean retrieveFromCache) {
		return getPersistence().fetchByisActive(isActive, retrieveFromCache);
	}

	/**
	* Removes the year setting where isActive = &#63; from the database.
	*
	* @param isActive the is active
	* @return the year setting that was removed
	*/
	public static YearSetting removeByisActive(int isActive)
		throws com.liferay.famocom.erpcloud.exception.NoSuchYearSettingException {
		return getPersistence().removeByisActive(isActive);
	}

	/**
	* Returns the number of year settings where isActive = &#63;.
	*
	* @param isActive the is active
	* @return the number of matching year settings
	*/
	public static int countByisActive(int isActive) {
		return getPersistence().countByisActive(isActive);
	}

	/**
	* Caches the year setting in the entity cache if it is enabled.
	*
	* @param yearSetting the year setting
	*/
	public static void cacheResult(YearSetting yearSetting) {
		getPersistence().cacheResult(yearSetting);
	}

	/**
	* Caches the year settings in the entity cache if it is enabled.
	*
	* @param yearSettings the year settings
	*/
	public static void cacheResult(List<YearSetting> yearSettings) {
		getPersistence().cacheResult(yearSettings);
	}

	/**
	* Creates a new year setting with the primary key. Does not add the year setting to the database.
	*
	* @param yearSettingId the primary key for the new year setting
	* @return the new year setting
	*/
	public static YearSetting create(long yearSettingId) {
		return getPersistence().create(yearSettingId);
	}

	/**
	* Removes the year setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param yearSettingId the primary key of the year setting
	* @return the year setting that was removed
	* @throws NoSuchYearSettingException if a year setting with the primary key could not be found
	*/
	public static YearSetting remove(long yearSettingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchYearSettingException {
		return getPersistence().remove(yearSettingId);
	}

	public static YearSetting updateImpl(YearSetting yearSetting) {
		return getPersistence().updateImpl(yearSetting);
	}

	/**
	* Returns the year setting with the primary key or throws a {@link NoSuchYearSettingException} if it could not be found.
	*
	* @param yearSettingId the primary key of the year setting
	* @return the year setting
	* @throws NoSuchYearSettingException if a year setting with the primary key could not be found
	*/
	public static YearSetting findByPrimaryKey(long yearSettingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchYearSettingException {
		return getPersistence().findByPrimaryKey(yearSettingId);
	}

	/**
	* Returns the year setting with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param yearSettingId the primary key of the year setting
	* @return the year setting, or <code>null</code> if a year setting with the primary key could not be found
	*/
	public static YearSetting fetchByPrimaryKey(long yearSettingId) {
		return getPersistence().fetchByPrimaryKey(yearSettingId);
	}

	public static java.util.Map<java.io.Serializable, YearSetting> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the year settings.
	*
	* @return the year settings
	*/
	public static List<YearSetting> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the year settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of year settings
	* @param end the upper bound of the range of year settings (not inclusive)
	* @return the range of year settings
	*/
	public static List<YearSetting> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the year settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of year settings
	* @param end the upper bound of the range of year settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of year settings
	*/
	public static List<YearSetting> findAll(int start, int end,
		OrderByComparator<YearSetting> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the year settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of year settings
	* @param end the upper bound of the range of year settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of year settings
	*/
	public static List<YearSetting> findAll(int start, int end,
		OrderByComparator<YearSetting> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the year settings from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of year settings.
	*
	* @return the number of year settings
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static YearSettingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<YearSettingPersistence, YearSettingPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(YearSettingPersistence.class);

		ServiceTracker<YearSettingPersistence, YearSettingPersistence> serviceTracker =
			new ServiceTracker<YearSettingPersistence, YearSettingPersistence>(bundle.getBundleContext(),
				YearSettingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}