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

import com.liferay.famocom.erpcloud.model.TaxSetting;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tax setting service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.TaxSettingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaxSettingPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TaxSettingPersistenceImpl
 * @generated
 */
@ProviderType
public class TaxSettingUtil {
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
	public static void clearCache(TaxSetting taxSetting) {
		getPersistence().clearCache(taxSetting);
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
	public static List<TaxSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaxSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaxSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaxSetting> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaxSetting update(TaxSetting taxSetting) {
		return getPersistence().update(taxSetting);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaxSetting update(TaxSetting taxSetting,
		ServiceContext serviceContext) {
		return getPersistence().update(taxSetting, serviceContext);
	}

	/**
	* Returns all the tax settings where componentId = &#63;.
	*
	* @param componentId the component ID
	* @return the matching tax settings
	*/
	public static List<TaxSetting> findBycomponentId(long componentId) {
		return getPersistence().findBycomponentId(componentId);
	}

	/**
	* Returns a range of all the tax settings where componentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentId the component ID
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @return the range of matching tax settings
	*/
	public static List<TaxSetting> findBycomponentId(long componentId,
		int start, int end) {
		return getPersistence().findBycomponentId(componentId, start, end);
	}

	/**
	* Returns an ordered range of all the tax settings where componentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentId the component ID
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tax settings
	*/
	public static List<TaxSetting> findBycomponentId(long componentId,
		int start, int end, OrderByComparator<TaxSetting> orderByComparator) {
		return getPersistence()
				   .findBycomponentId(componentId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tax settings where componentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentId the component ID
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tax settings
	*/
	public static List<TaxSetting> findBycomponentId(long componentId,
		int start, int end, OrderByComparator<TaxSetting> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBycomponentId(componentId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tax setting in the ordered set where componentId = &#63;.
	*
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tax setting
	* @throws NoSuchTaxSettingException if a matching tax setting could not be found
	*/
	public static TaxSetting findBycomponentId_First(long componentId,
		OrderByComparator<TaxSetting> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxSettingException {
		return getPersistence()
				   .findBycomponentId_First(componentId, orderByComparator);
	}

	/**
	* Returns the first tax setting in the ordered set where componentId = &#63;.
	*
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tax setting, or <code>null</code> if a matching tax setting could not be found
	*/
	public static TaxSetting fetchBycomponentId_First(long componentId,
		OrderByComparator<TaxSetting> orderByComparator) {
		return getPersistence()
				   .fetchBycomponentId_First(componentId, orderByComparator);
	}

	/**
	* Returns the last tax setting in the ordered set where componentId = &#63;.
	*
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tax setting
	* @throws NoSuchTaxSettingException if a matching tax setting could not be found
	*/
	public static TaxSetting findBycomponentId_Last(long componentId,
		OrderByComparator<TaxSetting> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxSettingException {
		return getPersistence()
				   .findBycomponentId_Last(componentId, orderByComparator);
	}

	/**
	* Returns the last tax setting in the ordered set where componentId = &#63;.
	*
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tax setting, or <code>null</code> if a matching tax setting could not be found
	*/
	public static TaxSetting fetchBycomponentId_Last(long componentId,
		OrderByComparator<TaxSetting> orderByComparator) {
		return getPersistence()
				   .fetchBycomponentId_Last(componentId, orderByComparator);
	}

	/**
	* Returns the tax settings before and after the current tax setting in the ordered set where componentId = &#63;.
	*
	* @param taxSettingId the primary key of the current tax setting
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tax setting
	* @throws NoSuchTaxSettingException if a tax setting with the primary key could not be found
	*/
	public static TaxSetting[] findBycomponentId_PrevAndNext(
		long taxSettingId, long componentId,
		OrderByComparator<TaxSetting> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxSettingException {
		return getPersistence()
				   .findBycomponentId_PrevAndNext(taxSettingId, componentId,
			orderByComparator);
	}

	/**
	* Removes all the tax settings where componentId = &#63; from the database.
	*
	* @param componentId the component ID
	*/
	public static void removeBycomponentId(long componentId) {
		getPersistence().removeBycomponentId(componentId);
	}

	/**
	* Returns the number of tax settings where componentId = &#63;.
	*
	* @param componentId the component ID
	* @return the number of matching tax settings
	*/
	public static int countBycomponentId(long componentId) {
		return getPersistence().countBycomponentId(componentId);
	}

	/**
	* Caches the tax setting in the entity cache if it is enabled.
	*
	* @param taxSetting the tax setting
	*/
	public static void cacheResult(TaxSetting taxSetting) {
		getPersistence().cacheResult(taxSetting);
	}

	/**
	* Caches the tax settings in the entity cache if it is enabled.
	*
	* @param taxSettings the tax settings
	*/
	public static void cacheResult(List<TaxSetting> taxSettings) {
		getPersistence().cacheResult(taxSettings);
	}

	/**
	* Creates a new tax setting with the primary key. Does not add the tax setting to the database.
	*
	* @param taxSettingId the primary key for the new tax setting
	* @return the new tax setting
	*/
	public static TaxSetting create(long taxSettingId) {
		return getPersistence().create(taxSettingId);
	}

	/**
	* Removes the tax setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxSettingId the primary key of the tax setting
	* @return the tax setting that was removed
	* @throws NoSuchTaxSettingException if a tax setting with the primary key could not be found
	*/
	public static TaxSetting remove(long taxSettingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxSettingException {
		return getPersistence().remove(taxSettingId);
	}

	public static TaxSetting updateImpl(TaxSetting taxSetting) {
		return getPersistence().updateImpl(taxSetting);
	}

	/**
	* Returns the tax setting with the primary key or throws a {@link NoSuchTaxSettingException} if it could not be found.
	*
	* @param taxSettingId the primary key of the tax setting
	* @return the tax setting
	* @throws NoSuchTaxSettingException if a tax setting with the primary key could not be found
	*/
	public static TaxSetting findByPrimaryKey(long taxSettingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxSettingException {
		return getPersistence().findByPrimaryKey(taxSettingId);
	}

	/**
	* Returns the tax setting with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taxSettingId the primary key of the tax setting
	* @return the tax setting, or <code>null</code> if a tax setting with the primary key could not be found
	*/
	public static TaxSetting fetchByPrimaryKey(long taxSettingId) {
		return getPersistence().fetchByPrimaryKey(taxSettingId);
	}

	public static java.util.Map<java.io.Serializable, TaxSetting> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tax settings.
	*
	* @return the tax settings
	*/
	public static List<TaxSetting> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tax settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @return the range of tax settings
	*/
	public static List<TaxSetting> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tax settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tax settings
	*/
	public static List<TaxSetting> findAll(int start, int end,
		OrderByComparator<TaxSetting> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tax settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tax settings
	*/
	public static List<TaxSetting> findAll(int start, int end,
		OrderByComparator<TaxSetting> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tax settings from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tax settings.
	*
	* @return the number of tax settings
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaxSettingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaxSettingPersistence, TaxSettingPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaxSettingPersistence.class);

		ServiceTracker<TaxSettingPersistence, TaxSettingPersistence> serviceTracker =
			new ServiceTracker<TaxSettingPersistence, TaxSettingPersistence>(bundle.getBundleContext(),
				TaxSettingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}