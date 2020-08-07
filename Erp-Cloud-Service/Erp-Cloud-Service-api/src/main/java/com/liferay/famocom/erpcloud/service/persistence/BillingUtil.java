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

import com.liferay.famocom.erpcloud.model.Billing;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the billing service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.BillingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see BillingPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.BillingPersistenceImpl
 * @generated
 */
@ProviderType
public class BillingUtil {
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
	public static void clearCache(Billing billing) {
		getPersistence().clearCache(billing);
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
	public static List<Billing> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Billing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Billing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Billing> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Billing update(Billing billing) {
		return getPersistence().update(billing);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Billing update(Billing billing, ServiceContext serviceContext) {
		return getPersistence().update(billing, serviceContext);
	}

	/**
	* Caches the billing in the entity cache if it is enabled.
	*
	* @param billing the billing
	*/
	public static void cacheResult(Billing billing) {
		getPersistence().cacheResult(billing);
	}

	/**
	* Caches the billings in the entity cache if it is enabled.
	*
	* @param billings the billings
	*/
	public static void cacheResult(List<Billing> billings) {
		getPersistence().cacheResult(billings);
	}

	/**
	* Creates a new billing with the primary key. Does not add the billing to the database.
	*
	* @param billingId the primary key for the new billing
	* @return the new billing
	*/
	public static Billing create(long billingId) {
		return getPersistence().create(billingId);
	}

	/**
	* Removes the billing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billingId the primary key of the billing
	* @return the billing that was removed
	* @throws NoSuchBillingException if a billing with the primary key could not be found
	*/
	public static Billing remove(long billingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchBillingException {
		return getPersistence().remove(billingId);
	}

	public static Billing updateImpl(Billing billing) {
		return getPersistence().updateImpl(billing);
	}

	/**
	* Returns the billing with the primary key or throws a {@link NoSuchBillingException} if it could not be found.
	*
	* @param billingId the primary key of the billing
	* @return the billing
	* @throws NoSuchBillingException if a billing with the primary key could not be found
	*/
	public static Billing findByPrimaryKey(long billingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchBillingException {
		return getPersistence().findByPrimaryKey(billingId);
	}

	/**
	* Returns the billing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param billingId the primary key of the billing
	* @return the billing, or <code>null</code> if a billing with the primary key could not be found
	*/
	public static Billing fetchByPrimaryKey(long billingId) {
		return getPersistence().fetchByPrimaryKey(billingId);
	}

	public static java.util.Map<java.io.Serializable, Billing> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the billings.
	*
	* @return the billings
	*/
	public static List<Billing> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the billings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billings
	* @param end the upper bound of the range of billings (not inclusive)
	* @return the range of billings
	*/
	public static List<Billing> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the billings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billings
	* @param end the upper bound of the range of billings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of billings
	*/
	public static List<Billing> findAll(int start, int end,
		OrderByComparator<Billing> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the billings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billings
	* @param end the upper bound of the range of billings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of billings
	*/
	public static List<Billing> findAll(int start, int end,
		OrderByComparator<Billing> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the billings from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of billings.
	*
	* @return the number of billings
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BillingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BillingPersistence, BillingPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BillingPersistence.class);

		ServiceTracker<BillingPersistence, BillingPersistence> serviceTracker = new ServiceTracker<BillingPersistence, BillingPersistence>(bundle.getBundleContext(),
				BillingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}