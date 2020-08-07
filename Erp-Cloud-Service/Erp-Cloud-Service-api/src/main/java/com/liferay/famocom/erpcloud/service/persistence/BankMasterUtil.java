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

import com.liferay.famocom.erpcloud.model.BankMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the bank master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.BankMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see BankMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.BankMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class BankMasterUtil {
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
	public static void clearCache(BankMaster bankMaster) {
		getPersistence().clearCache(bankMaster);
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
	public static List<BankMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BankMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BankMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BankMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BankMaster update(BankMaster bankMaster) {
		return getPersistence().update(bankMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BankMaster update(BankMaster bankMaster,
		ServiceContext serviceContext) {
		return getPersistence().update(bankMaster, serviceContext);
	}

	/**
	* Caches the bank master in the entity cache if it is enabled.
	*
	* @param bankMaster the bank master
	*/
	public static void cacheResult(BankMaster bankMaster) {
		getPersistence().cacheResult(bankMaster);
	}

	/**
	* Caches the bank masters in the entity cache if it is enabled.
	*
	* @param bankMasters the bank masters
	*/
	public static void cacheResult(List<BankMaster> bankMasters) {
		getPersistence().cacheResult(bankMasters);
	}

	/**
	* Creates a new bank master with the primary key. Does not add the bank master to the database.
	*
	* @param bankId the primary key for the new bank master
	* @return the new bank master
	*/
	public static BankMaster create(long bankId) {
		return getPersistence().create(bankId);
	}

	/**
	* Removes the bank master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bankId the primary key of the bank master
	* @return the bank master that was removed
	* @throws NoSuchBankMasterException if a bank master with the primary key could not be found
	*/
	public static BankMaster remove(long bankId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchBankMasterException {
		return getPersistence().remove(bankId);
	}

	public static BankMaster updateImpl(BankMaster bankMaster) {
		return getPersistence().updateImpl(bankMaster);
	}

	/**
	* Returns the bank master with the primary key or throws a {@link NoSuchBankMasterException} if it could not be found.
	*
	* @param bankId the primary key of the bank master
	* @return the bank master
	* @throws NoSuchBankMasterException if a bank master with the primary key could not be found
	*/
	public static BankMaster findByPrimaryKey(long bankId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchBankMasterException {
		return getPersistence().findByPrimaryKey(bankId);
	}

	/**
	* Returns the bank master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bankId the primary key of the bank master
	* @return the bank master, or <code>null</code> if a bank master with the primary key could not be found
	*/
	public static BankMaster fetchByPrimaryKey(long bankId) {
		return getPersistence().fetchByPrimaryKey(bankId);
	}

	public static java.util.Map<java.io.Serializable, BankMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the bank masters.
	*
	* @return the bank masters
	*/
	public static List<BankMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bank masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bank masters
	* @param end the upper bound of the range of bank masters (not inclusive)
	* @return the range of bank masters
	*/
	public static List<BankMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bank masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bank masters
	* @param end the upper bound of the range of bank masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bank masters
	*/
	public static List<BankMaster> findAll(int start, int end,
		OrderByComparator<BankMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bank masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bank masters
	* @param end the upper bound of the range of bank masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of bank masters
	*/
	public static List<BankMaster> findAll(int start, int end,
		OrderByComparator<BankMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the bank masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bank masters.
	*
	* @return the number of bank masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BankMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BankMasterPersistence, BankMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BankMasterPersistence.class);

		ServiceTracker<BankMasterPersistence, BankMasterPersistence> serviceTracker =
			new ServiceTracker<BankMasterPersistence, BankMasterPersistence>(bundle.getBundleContext(),
				BankMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}