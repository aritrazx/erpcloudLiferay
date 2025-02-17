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

import com.liferay.famocom.erpcloud.model.ClientMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the client master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ClientMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ClientMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ClientMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class ClientMasterUtil {
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
	public static void clearCache(ClientMaster clientMaster) {
		getPersistence().clearCache(clientMaster);
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
	public static List<ClientMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClientMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClientMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ClientMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ClientMaster update(ClientMaster clientMaster) {
		return getPersistence().update(clientMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ClientMaster update(ClientMaster clientMaster,
		ServiceContext serviceContext) {
		return getPersistence().update(clientMaster, serviceContext);
	}

	/**
	* Caches the client master in the entity cache if it is enabled.
	*
	* @param clientMaster the client master
	*/
	public static void cacheResult(ClientMaster clientMaster) {
		getPersistence().cacheResult(clientMaster);
	}

	/**
	* Caches the client masters in the entity cache if it is enabled.
	*
	* @param clientMasters the client masters
	*/
	public static void cacheResult(List<ClientMaster> clientMasters) {
		getPersistence().cacheResult(clientMasters);
	}

	/**
	* Creates a new client master with the primary key. Does not add the client master to the database.
	*
	* @param clientId the primary key for the new client master
	* @return the new client master
	*/
	public static ClientMaster create(long clientId) {
		return getPersistence().create(clientId);
	}

	/**
	* Removes the client master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clientId the primary key of the client master
	* @return the client master that was removed
	* @throws NoSuchClientMasterException if a client master with the primary key could not be found
	*/
	public static ClientMaster remove(long clientId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchClientMasterException {
		return getPersistence().remove(clientId);
	}

	public static ClientMaster updateImpl(ClientMaster clientMaster) {
		return getPersistence().updateImpl(clientMaster);
	}

	/**
	* Returns the client master with the primary key or throws a {@link NoSuchClientMasterException} if it could not be found.
	*
	* @param clientId the primary key of the client master
	* @return the client master
	* @throws NoSuchClientMasterException if a client master with the primary key could not be found
	*/
	public static ClientMaster findByPrimaryKey(long clientId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchClientMasterException {
		return getPersistence().findByPrimaryKey(clientId);
	}

	/**
	* Returns the client master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clientId the primary key of the client master
	* @return the client master, or <code>null</code> if a client master with the primary key could not be found
	*/
	public static ClientMaster fetchByPrimaryKey(long clientId) {
		return getPersistence().fetchByPrimaryKey(clientId);
	}

	public static java.util.Map<java.io.Serializable, ClientMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the client masters.
	*
	* @return the client masters
	*/
	public static List<ClientMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the client masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of client masters
	* @param end the upper bound of the range of client masters (not inclusive)
	* @return the range of client masters
	*/
	public static List<ClientMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the client masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of client masters
	* @param end the upper bound of the range of client masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of client masters
	*/
	public static List<ClientMaster> findAll(int start, int end,
		OrderByComparator<ClientMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the client masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of client masters
	* @param end the upper bound of the range of client masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of client masters
	*/
	public static List<ClientMaster> findAll(int start, int end,
		OrderByComparator<ClientMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the client masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of client masters.
	*
	* @return the number of client masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClientMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClientMasterPersistence, ClientMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClientMasterPersistence.class);

		ServiceTracker<ClientMasterPersistence, ClientMasterPersistence> serviceTracker =
			new ServiceTracker<ClientMasterPersistence, ClientMasterPersistence>(bundle.getBundleContext(),
				ClientMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}