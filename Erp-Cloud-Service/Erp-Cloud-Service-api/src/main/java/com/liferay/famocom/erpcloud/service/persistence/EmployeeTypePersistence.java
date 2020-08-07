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

import com.liferay.famocom.erpcloud.exception.NoSuchEmployeeTypeException;
import com.liferay.famocom.erpcloud.model.EmployeeType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the employee type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EmployeeTypePersistenceImpl
 * @see EmployeeTypeUtil
 * @generated
 */
@ProviderType
public interface EmployeeTypePersistence extends BasePersistence<EmployeeType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeTypeUtil} to access the employee type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the employee type in the entity cache if it is enabled.
	*
	* @param employeeType the employee type
	*/
	public void cacheResult(EmployeeType employeeType);

	/**
	* Caches the employee types in the entity cache if it is enabled.
	*
	* @param employeeTypes the employee types
	*/
	public void cacheResult(java.util.List<EmployeeType> employeeTypes);

	/**
	* Creates a new employee type with the primary key. Does not add the employee type to the database.
	*
	* @param employeetypeId the primary key for the new employee type
	* @return the new employee type
	*/
	public EmployeeType create(long employeetypeId);

	/**
	* Removes the employee type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeetypeId the primary key of the employee type
	* @return the employee type that was removed
	* @throws NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	*/
	public EmployeeType remove(long employeetypeId)
		throws NoSuchEmployeeTypeException;

	public EmployeeType updateImpl(EmployeeType employeeType);

	/**
	* Returns the employee type with the primary key or throws a {@link NoSuchEmployeeTypeException} if it could not be found.
	*
	* @param employeetypeId the primary key of the employee type
	* @return the employee type
	* @throws NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	*/
	public EmployeeType findByPrimaryKey(long employeetypeId)
		throws NoSuchEmployeeTypeException;

	/**
	* Returns the employee type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param employeetypeId the primary key of the employee type
	* @return the employee type, or <code>null</code> if a employee type with the primary key could not be found
	*/
	public EmployeeType fetchByPrimaryKey(long employeetypeId);

	@Override
	public java.util.Map<java.io.Serializable, EmployeeType> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the employee types.
	*
	* @return the employee types
	*/
	public java.util.List<EmployeeType> findAll();

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
	public java.util.List<EmployeeType> findAll(int start, int end);

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
	public java.util.List<EmployeeType> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeType> orderByComparator);

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
	public java.util.List<EmployeeType> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeType> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the employee types from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of employee types.
	*
	* @return the number of employee types
	*/
	public int countAll();
}