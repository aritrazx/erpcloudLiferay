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

import com.liferay.famocom.erpcloud.model.ExpCategory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the exp category service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ExpCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ExpCategoryPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ExpCategoryPersistenceImpl
 * @generated
 */
@ProviderType
public class ExpCategoryUtil {
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
	public static void clearCache(ExpCategory expCategory) {
		getPersistence().clearCache(expCategory);
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
	public static List<ExpCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExpCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExpCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExpCategory> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExpCategory update(ExpCategory expCategory) {
		return getPersistence().update(expCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExpCategory update(ExpCategory expCategory,
		ServiceContext serviceContext) {
		return getPersistence().update(expCategory, serviceContext);
	}

	/**
	* Caches the exp category in the entity cache if it is enabled.
	*
	* @param expCategory the exp category
	*/
	public static void cacheResult(ExpCategory expCategory) {
		getPersistence().cacheResult(expCategory);
	}

	/**
	* Caches the exp categories in the entity cache if it is enabled.
	*
	* @param expCategories the exp categories
	*/
	public static void cacheResult(List<ExpCategory> expCategories) {
		getPersistence().cacheResult(expCategories);
	}

	/**
	* Creates a new exp category with the primary key. Does not add the exp category to the database.
	*
	* @param catId the primary key for the new exp category
	* @return the new exp category
	*/
	public static ExpCategory create(long catId) {
		return getPersistence().create(catId);
	}

	/**
	* Removes the exp category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catId the primary key of the exp category
	* @return the exp category that was removed
	* @throws NoSuchExpCategoryException if a exp category with the primary key could not be found
	*/
	public static ExpCategory remove(long catId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpCategoryException {
		return getPersistence().remove(catId);
	}

	public static ExpCategory updateImpl(ExpCategory expCategory) {
		return getPersistence().updateImpl(expCategory);
	}

	/**
	* Returns the exp category with the primary key or throws a {@link NoSuchExpCategoryException} if it could not be found.
	*
	* @param catId the primary key of the exp category
	* @return the exp category
	* @throws NoSuchExpCategoryException if a exp category with the primary key could not be found
	*/
	public static ExpCategory findByPrimaryKey(long catId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpCategoryException {
		return getPersistence().findByPrimaryKey(catId);
	}

	/**
	* Returns the exp category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param catId the primary key of the exp category
	* @return the exp category, or <code>null</code> if a exp category with the primary key could not be found
	*/
	public static ExpCategory fetchByPrimaryKey(long catId) {
		return getPersistence().fetchByPrimaryKey(catId);
	}

	public static java.util.Map<java.io.Serializable, ExpCategory> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the exp categories.
	*
	* @return the exp categories
	*/
	public static List<ExpCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the exp categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp categories
	* @param end the upper bound of the range of exp categories (not inclusive)
	* @return the range of exp categories
	*/
	public static List<ExpCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the exp categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp categories
	* @param end the upper bound of the range of exp categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of exp categories
	*/
	public static List<ExpCategory> findAll(int start, int end,
		OrderByComparator<ExpCategory> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the exp categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp categories
	* @param end the upper bound of the range of exp categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of exp categories
	*/
	public static List<ExpCategory> findAll(int start, int end,
		OrderByComparator<ExpCategory> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the exp categories from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of exp categories.
	*
	* @return the number of exp categories
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExpCategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExpCategoryPersistence, ExpCategoryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExpCategoryPersistence.class);

		ServiceTracker<ExpCategoryPersistence, ExpCategoryPersistence> serviceTracker =
			new ServiceTracker<ExpCategoryPersistence, ExpCategoryPersistence>(bundle.getBundleContext(),
				ExpCategoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}