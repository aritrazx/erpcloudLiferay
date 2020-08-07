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

import com.liferay.famocom.erpcloud.model.LeaveType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the leave type service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.LeaveTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveTypePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveTypePersistenceImpl
 * @generated
 */
@ProviderType
public class LeaveTypeUtil {
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
	public static void clearCache(LeaveType leaveType) {
		getPersistence().clearCache(leaveType);
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
	public static List<LeaveType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveType> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveType update(LeaveType leaveType) {
		return getPersistence().update(leaveType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveType update(LeaveType leaveType,
		ServiceContext serviceContext) {
		return getPersistence().update(leaveType, serviceContext);
	}

	/**
	* Returns the leave type where leaveName = &#63; or throws a {@link NoSuchLeaveTypeException} if it could not be found.
	*
	* @param leaveName the leave name
	* @return the matching leave type
	* @throws NoSuchLeaveTypeException if a matching leave type could not be found
	*/
	public static LeaveType findByleaveName(String leaveName)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveTypeException {
		return getPersistence().findByleaveName(leaveName);
	}

	/**
	* Returns the leave type where leaveName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param leaveName the leave name
	* @return the matching leave type, or <code>null</code> if a matching leave type could not be found
	*/
	public static LeaveType fetchByleaveName(String leaveName) {
		return getPersistence().fetchByleaveName(leaveName);
	}

	/**
	* Returns the leave type where leaveName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param leaveName the leave name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching leave type, or <code>null</code> if a matching leave type could not be found
	*/
	public static LeaveType fetchByleaveName(String leaveName,
		boolean retrieveFromCache) {
		return getPersistence().fetchByleaveName(leaveName, retrieveFromCache);
	}

	/**
	* Removes the leave type where leaveName = &#63; from the database.
	*
	* @param leaveName the leave name
	* @return the leave type that was removed
	*/
	public static LeaveType removeByleaveName(String leaveName)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveTypeException {
		return getPersistence().removeByleaveName(leaveName);
	}

	/**
	* Returns the number of leave types where leaveName = &#63;.
	*
	* @param leaveName the leave name
	* @return the number of matching leave types
	*/
	public static int countByleaveName(String leaveName) {
		return getPersistence().countByleaveName(leaveName);
	}

	/**
	* Caches the leave type in the entity cache if it is enabled.
	*
	* @param leaveType the leave type
	*/
	public static void cacheResult(LeaveType leaveType) {
		getPersistence().cacheResult(leaveType);
	}

	/**
	* Caches the leave types in the entity cache if it is enabled.
	*
	* @param leaveTypes the leave types
	*/
	public static void cacheResult(List<LeaveType> leaveTypes) {
		getPersistence().cacheResult(leaveTypes);
	}

	/**
	* Creates a new leave type with the primary key. Does not add the leave type to the database.
	*
	* @param leaveTypeId the primary key for the new leave type
	* @return the new leave type
	*/
	public static LeaveType create(long leaveTypeId) {
		return getPersistence().create(leaveTypeId);
	}

	/**
	* Removes the leave type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeId the primary key of the leave type
	* @return the leave type that was removed
	* @throws NoSuchLeaveTypeException if a leave type with the primary key could not be found
	*/
	public static LeaveType remove(long leaveTypeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveTypeException {
		return getPersistence().remove(leaveTypeId);
	}

	public static LeaveType updateImpl(LeaveType leaveType) {
		return getPersistence().updateImpl(leaveType);
	}

	/**
	* Returns the leave type with the primary key or throws a {@link NoSuchLeaveTypeException} if it could not be found.
	*
	* @param leaveTypeId the primary key of the leave type
	* @return the leave type
	* @throws NoSuchLeaveTypeException if a leave type with the primary key could not be found
	*/
	public static LeaveType findByPrimaryKey(long leaveTypeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveTypeException {
		return getPersistence().findByPrimaryKey(leaveTypeId);
	}

	/**
	* Returns the leave type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveTypeId the primary key of the leave type
	* @return the leave type, or <code>null</code> if a leave type with the primary key could not be found
	*/
	public static LeaveType fetchByPrimaryKey(long leaveTypeId) {
		return getPersistence().fetchByPrimaryKey(leaveTypeId);
	}

	public static java.util.Map<java.io.Serializable, LeaveType> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the leave types.
	*
	* @return the leave types
	*/
	public static List<LeaveType> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the leave types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave types
	* @param end the upper bound of the range of leave types (not inclusive)
	* @return the range of leave types
	*/
	public static List<LeaveType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the leave types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave types
	* @param end the upper bound of the range of leave types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave types
	*/
	public static List<LeaveType> findAll(int start, int end,
		OrderByComparator<LeaveType> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the leave types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave types
	* @param end the upper bound of the range of leave types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leave types
	*/
	public static List<LeaveType> findAll(int start, int end,
		OrderByComparator<LeaveType> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the leave types from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave types.
	*
	* @return the number of leave types
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LeaveTypePersistence, LeaveTypePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LeaveTypePersistence.class);

		ServiceTracker<LeaveTypePersistence, LeaveTypePersistence> serviceTracker =
			new ServiceTracker<LeaveTypePersistence, LeaveTypePersistence>(bundle.getBundleContext(),
				LeaveTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}