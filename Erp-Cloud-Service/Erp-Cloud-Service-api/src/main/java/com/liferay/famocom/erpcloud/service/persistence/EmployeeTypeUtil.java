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

import com.liferay.famocom.erpcloud.model.EmployeeType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the employee type service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.EmployeeTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see EmployeeTypePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EmployeeTypePersistenceImpl
 * @generated
 */
@ProviderType
public class EmployeeTypeUtil {
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
	public static void clearCache(EmployeeType employeeType) {
		getPersistence().clearCache(employeeType);
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
	public static List<EmployeeType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeType> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeType update(EmployeeType employeeType) {
		return getPersistence().update(employeeType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeType update(EmployeeType employeeType,
		ServiceContext serviceContext) {
		return getPersistence().update(employeeType, serviceContext);
	}

	/**
	* Caches the employee type in the entity cache if it is enabled.
	*
	* @param employeeType the employee type
	*/
	public static void cacheResult(EmployeeType employeeType) {
		getPersistence().cacheResult(employeeType);
	}

	/**
	* Caches the employee types in the entity cache if it is enabled.
	*
	* @param employeeTypes the employee types
	*/
	public static void cacheResult(List<EmployeeType> employeeTypes) {
		getPersistence().cacheResult(employeeTypes);
	}

	/**
	* Creates a new employee type with the primary key. Does not add the employee type to the database.
	*
	* @param employeetypeId the primary key for the new employee type
	* @return the new employee type
	*/
	public static EmployeeType create(long employeetypeId) {
		return getPersistence().create(employeetypeId);
	}

	/**
	* Removes the employee type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeetypeId the primary key of the employee type
	* @return the employee type that was removed
	* @throws NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	*/
	public static EmployeeType remove(long employeetypeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeTypeException {
		return getPersistence().remove(employeetypeId);
	}

	public static EmployeeType updateImpl(EmployeeType employeeType) {
		return getPersistence().updateImpl(employeeType);
	}

	/**
	* Returns the employee type with the primary key or throws a {@link NoSuchEmployeeTypeException} if it could not be found.
	*
	* @param employeetypeId the primary key of the employee type
	* @return the employee type
	* @throws NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	*/
	public static EmployeeType findByPrimaryKey(long employeetypeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeTypeException {
		return getPersistence().findByPrimaryKey(employeetypeId);
	}

	/**
	* Returns the employee type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param employeetypeId the primary key of the employee type
	* @return the employee type, or <code>null</code> if a employee type with the primary key could not be found
	*/
	public static EmployeeType fetchByPrimaryKey(long employeetypeId) {
		return getPersistence().fetchByPrimaryKey(employeetypeId);
	}

	public static java.util.Map<java.io.Serializable, EmployeeType> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the employee types.
	*
	* @return the employee types
	*/
	public static List<EmployeeType> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the employee types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee types
	* @param end the upper bound of the range of employee types (not inclusive)
	* @return the range of employee types
	*/
	public static List<EmployeeType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the employee types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee types
	* @param end the upper bound of the range of employee types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employee types
	*/
	public static List<EmployeeType> findAll(int start, int end,
		OrderByComparator<EmployeeType> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employee types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee types
	* @param end the upper bound of the range of employee types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of employee types
	*/
	public static List<EmployeeType> findAll(int start, int end,
		OrderByComparator<EmployeeType> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the employee types from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of employee types.
	*
	* @return the number of employee types
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployeeTypePersistence, EmployeeTypePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeTypePersistence.class);

		ServiceTracker<EmployeeTypePersistence, EmployeeTypePersistence> serviceTracker =
			new ServiceTracker<EmployeeTypePersistence, EmployeeTypePersistence>(bundle.getBundleContext(),
				EmployeeTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}