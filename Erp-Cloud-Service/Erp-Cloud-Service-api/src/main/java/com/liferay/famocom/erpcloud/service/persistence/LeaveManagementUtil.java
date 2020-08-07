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

import com.liferay.famocom.erpcloud.model.LeaveManagement;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the leave management service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.LeaveManagementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveManagementPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveManagementPersistenceImpl
 * @generated
 */
@ProviderType
public class LeaveManagementUtil {
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
	public static void clearCache(LeaveManagement leaveManagement) {
		getPersistence().clearCache(leaveManagement);
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
	public static List<LeaveManagement> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveManagement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveManagement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveManagement> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveManagement update(LeaveManagement leaveManagement) {
		return getPersistence().update(leaveManagement);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveManagement update(LeaveManagement leaveManagement,
		ServiceContext serviceContext) {
		return getPersistence().update(leaveManagement, serviceContext);
	}

	/**
	* Returns the leave management where leaveName = &#63; or throws a {@link NoSuchLeaveManagementException} if it could not be found.
	*
	* @param leaveName the leave name
	* @return the matching leave management
	* @throws NoSuchLeaveManagementException if a matching leave management could not be found
	*/
	public static LeaveManagement findByleaveName(String leaveName)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveManagementException {
		return getPersistence().findByleaveName(leaveName);
	}

	/**
	* Returns the leave management where leaveName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param leaveName the leave name
	* @return the matching leave management, or <code>null</code> if a matching leave management could not be found
	*/
	public static LeaveManagement fetchByleaveName(String leaveName) {
		return getPersistence().fetchByleaveName(leaveName);
	}

	/**
	* Returns the leave management where leaveName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param leaveName the leave name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching leave management, or <code>null</code> if a matching leave management could not be found
	*/
	public static LeaveManagement fetchByleaveName(String leaveName,
		boolean retrieveFromCache) {
		return getPersistence().fetchByleaveName(leaveName, retrieveFromCache);
	}

	/**
	* Removes the leave management where leaveName = &#63; from the database.
	*
	* @param leaveName the leave name
	* @return the leave management that was removed
	*/
	public static LeaveManagement removeByleaveName(String leaveName)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveManagementException {
		return getPersistence().removeByleaveName(leaveName);
	}

	/**
	* Returns the number of leave managements where leaveName = &#63;.
	*
	* @param leaveName the leave name
	* @return the number of matching leave managements
	*/
	public static int countByleaveName(String leaveName) {
		return getPersistence().countByleaveName(leaveName);
	}

	/**
	* Caches the leave management in the entity cache if it is enabled.
	*
	* @param leaveManagement the leave management
	*/
	public static void cacheResult(LeaveManagement leaveManagement) {
		getPersistence().cacheResult(leaveManagement);
	}

	/**
	* Caches the leave managements in the entity cache if it is enabled.
	*
	* @param leaveManagements the leave managements
	*/
	public static void cacheResult(List<LeaveManagement> leaveManagements) {
		getPersistence().cacheResult(leaveManagements);
	}

	/**
	* Creates a new leave management with the primary key. Does not add the leave management to the database.
	*
	* @param leaveId the primary key for the new leave management
	* @return the new leave management
	*/
	public static LeaveManagement create(long leaveId) {
		return getPersistence().create(leaveId);
	}

	/**
	* Removes the leave management with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveId the primary key of the leave management
	* @return the leave management that was removed
	* @throws NoSuchLeaveManagementException if a leave management with the primary key could not be found
	*/
	public static LeaveManagement remove(long leaveId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveManagementException {
		return getPersistence().remove(leaveId);
	}

	public static LeaveManagement updateImpl(LeaveManagement leaveManagement) {
		return getPersistence().updateImpl(leaveManagement);
	}

	/**
	* Returns the leave management with the primary key or throws a {@link NoSuchLeaveManagementException} if it could not be found.
	*
	* @param leaveId the primary key of the leave management
	* @return the leave management
	* @throws NoSuchLeaveManagementException if a leave management with the primary key could not be found
	*/
	public static LeaveManagement findByPrimaryKey(long leaveId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveManagementException {
		return getPersistence().findByPrimaryKey(leaveId);
	}

	/**
	* Returns the leave management with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveId the primary key of the leave management
	* @return the leave management, or <code>null</code> if a leave management with the primary key could not be found
	*/
	public static LeaveManagement fetchByPrimaryKey(long leaveId) {
		return getPersistence().fetchByPrimaryKey(leaveId);
	}

	public static java.util.Map<java.io.Serializable, LeaveManagement> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the leave managements.
	*
	* @return the leave managements
	*/
	public static List<LeaveManagement> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the leave managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave managements
	* @param end the upper bound of the range of leave managements (not inclusive)
	* @return the range of leave managements
	*/
	public static List<LeaveManagement> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the leave managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave managements
	* @param end the upper bound of the range of leave managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave managements
	*/
	public static List<LeaveManagement> findAll(int start, int end,
		OrderByComparator<LeaveManagement> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the leave managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave managements
	* @param end the upper bound of the range of leave managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leave managements
	*/
	public static List<LeaveManagement> findAll(int start, int end,
		OrderByComparator<LeaveManagement> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the leave managements from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave managements.
	*
	* @return the number of leave managements
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveManagementPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LeaveManagementPersistence, LeaveManagementPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LeaveManagementPersistence.class);

		ServiceTracker<LeaveManagementPersistence, LeaveManagementPersistence> serviceTracker =
			new ServiceTracker<LeaveManagementPersistence, LeaveManagementPersistence>(bundle.getBundleContext(),
				LeaveManagementPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}