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

import com.liferay.famocom.erpcloud.model.LeaveOb;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the leave ob service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.LeaveObPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveObPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveObPersistenceImpl
 * @generated
 */
@ProviderType
public class LeaveObUtil {
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
	public static void clearCache(LeaveOb leaveOb) {
		getPersistence().clearCache(leaveOb);
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
	public static List<LeaveOb> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveOb> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveOb> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveOb> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveOb update(LeaveOb leaveOb) {
		return getPersistence().update(leaveOb);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveOb update(LeaveOb leaveOb, ServiceContext serviceContext) {
		return getPersistence().update(leaveOb, serviceContext);
	}

	/**
	* Returns the leave ob where employeeId = &#63; and leaveTypeId = &#63; or throws a {@link NoSuchLeaveObException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param leaveTypeId the leave type ID
	* @return the matching leave ob
	* @throws NoSuchLeaveObException if a matching leave ob could not be found
	*/
	public static LeaveOb findByopeningBalance(long employeeId, long leaveTypeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveObException {
		return getPersistence().findByopeningBalance(employeeId, leaveTypeId);
	}

	/**
	* Returns the leave ob where employeeId = &#63; and leaveTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param leaveTypeId the leave type ID
	* @return the matching leave ob, or <code>null</code> if a matching leave ob could not be found
	*/
	public static LeaveOb fetchByopeningBalance(long employeeId,
		long leaveTypeId) {
		return getPersistence().fetchByopeningBalance(employeeId, leaveTypeId);
	}

	/**
	* Returns the leave ob where employeeId = &#63; and leaveTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param leaveTypeId the leave type ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching leave ob, or <code>null</code> if a matching leave ob could not be found
	*/
	public static LeaveOb fetchByopeningBalance(long employeeId,
		long leaveTypeId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByopeningBalance(employeeId, leaveTypeId,
			retrieveFromCache);
	}

	/**
	* Removes the leave ob where employeeId = &#63; and leaveTypeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param leaveTypeId the leave type ID
	* @return the leave ob that was removed
	*/
	public static LeaveOb removeByopeningBalance(long employeeId,
		long leaveTypeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveObException {
		return getPersistence().removeByopeningBalance(employeeId, leaveTypeId);
	}

	/**
	* Returns the number of leave obs where employeeId = &#63; and leaveTypeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param leaveTypeId the leave type ID
	* @return the number of matching leave obs
	*/
	public static int countByopeningBalance(long employeeId, long leaveTypeId) {
		return getPersistence().countByopeningBalance(employeeId, leaveTypeId);
	}

	/**
	* Caches the leave ob in the entity cache if it is enabled.
	*
	* @param leaveOb the leave ob
	*/
	public static void cacheResult(LeaveOb leaveOb) {
		getPersistence().cacheResult(leaveOb);
	}

	/**
	* Caches the leave obs in the entity cache if it is enabled.
	*
	* @param leaveObs the leave obs
	*/
	public static void cacheResult(List<LeaveOb> leaveObs) {
		getPersistence().cacheResult(leaveObs);
	}

	/**
	* Creates a new leave ob with the primary key. Does not add the leave ob to the database.
	*
	* @param leaveobId the primary key for the new leave ob
	* @return the new leave ob
	*/
	public static LeaveOb create(long leaveobId) {
		return getPersistence().create(leaveobId);
	}

	/**
	* Removes the leave ob with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveobId the primary key of the leave ob
	* @return the leave ob that was removed
	* @throws NoSuchLeaveObException if a leave ob with the primary key could not be found
	*/
	public static LeaveOb remove(long leaveobId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveObException {
		return getPersistence().remove(leaveobId);
	}

	public static LeaveOb updateImpl(LeaveOb leaveOb) {
		return getPersistence().updateImpl(leaveOb);
	}

	/**
	* Returns the leave ob with the primary key or throws a {@link NoSuchLeaveObException} if it could not be found.
	*
	* @param leaveobId the primary key of the leave ob
	* @return the leave ob
	* @throws NoSuchLeaveObException if a leave ob with the primary key could not be found
	*/
	public static LeaveOb findByPrimaryKey(long leaveobId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveObException {
		return getPersistence().findByPrimaryKey(leaveobId);
	}

	/**
	* Returns the leave ob with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveobId the primary key of the leave ob
	* @return the leave ob, or <code>null</code> if a leave ob with the primary key could not be found
	*/
	public static LeaveOb fetchByPrimaryKey(long leaveobId) {
		return getPersistence().fetchByPrimaryKey(leaveobId);
	}

	public static java.util.Map<java.io.Serializable, LeaveOb> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the leave obs.
	*
	* @return the leave obs
	*/
	public static List<LeaveOb> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the leave obs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave obs
	* @param end the upper bound of the range of leave obs (not inclusive)
	* @return the range of leave obs
	*/
	public static List<LeaveOb> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the leave obs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave obs
	* @param end the upper bound of the range of leave obs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave obs
	*/
	public static List<LeaveOb> findAll(int start, int end,
		OrderByComparator<LeaveOb> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the leave obs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave obs
	* @param end the upper bound of the range of leave obs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leave obs
	*/
	public static List<LeaveOb> findAll(int start, int end,
		OrderByComparator<LeaveOb> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the leave obs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave obs.
	*
	* @return the number of leave obs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveObPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LeaveObPersistence, LeaveObPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LeaveObPersistence.class);

		ServiceTracker<LeaveObPersistence, LeaveObPersistence> serviceTracker = new ServiceTracker<LeaveObPersistence, LeaveObPersistence>(bundle.getBundleContext(),
				LeaveObPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}