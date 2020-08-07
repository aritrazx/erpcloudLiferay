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

import com.liferay.famocom.erpcloud.model.Employee;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the employee service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.EmployeePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see EmployeePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EmployeePersistenceImpl
 * @generated
 */
@ProviderType
public class EmployeeUtil {
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
	public static void clearCache(Employee employee) {
		getPersistence().clearCache(employee);
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
	public static List<Employee> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Employee update(Employee employee) {
		return getPersistence().update(employee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Employee update(Employee employee,
		ServiceContext serviceContext) {
		return getPersistence().update(employee, serviceContext);
	}

	/**
	* Returns all the employees where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching employees
	*/
	public static List<Employee> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	* Returns a range of all the employees where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of matching employees
	*/
	public static List<Employee> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the employees where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching employees
	*/
	public static List<Employee> findByuserId(long userId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employees where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching employees
	*/
	public static List<Employee> findByuserId(long userId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first employee in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public static Employee findByuserId_First(long userId,
		OrderByComparator<Employee> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first employee in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchByuserId_First(long userId,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last employee in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public static Employee findByuserId_Last(long userId,
		OrderByComparator<Employee> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last employee in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchByuserId_Last(long userId,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the employees before and after the current employee in the ordered set where userId = &#63;.
	*
	* @param employeeId the primary key of the current employee
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next employee
	* @throws NoSuchEmployeeException if a employee with the primary key could not be found
	*/
	public static Employee[] findByuserId_PrevAndNext(long employeeId,
		long userId, OrderByComparator<Employee> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence()
				   .findByuserId_PrevAndNext(employeeId, userId,
			orderByComparator);
	}

	/**
	* Removes all the employees where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of employees where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching employees
	*/
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Returns all the employees where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching employees
	*/
	public static List<Employee> findBystatus(long groupId, int status) {
		return getPersistence().findBystatus(groupId, status);
	}

	/**
	* Returns a range of all the employees where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of matching employees
	*/
	public static List<Employee> findBystatus(long groupId, int status,
		int start, int end) {
		return getPersistence().findBystatus(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the employees where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching employees
	*/
	public static List<Employee> findBystatus(long groupId, int status,
		int start, int end, OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employees where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching employees
	*/
	public static List<Employee> findBystatus(long groupId, int status,
		int start, int end, OrderByComparator<Employee> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first employee in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public static Employee findBystatus_First(long groupId, int status,
		OrderByComparator<Employee> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence()
				   .findBystatus_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the first employee in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchBystatus_First(long groupId, int status,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the last employee in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public static Employee findBystatus_Last(long groupId, int status,
		OrderByComparator<Employee> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence()
				   .findBystatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last employee in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchBystatus_Last(long groupId, int status,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the employees before and after the current employee in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param employeeId the primary key of the current employee
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next employee
	* @throws NoSuchEmployeeException if a employee with the primary key could not be found
	*/
	public static Employee[] findBystatus_PrevAndNext(long employeeId,
		long groupId, int status, OrderByComparator<Employee> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence()
				   .findBystatus_PrevAndNext(employeeId, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the employees where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public static void removeBystatus(long groupId, int status) {
		getPersistence().removeBystatus(groupId, status);
	}

	/**
	* Returns the number of employees where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching employees
	*/
	public static int countBystatus(long groupId, int status) {
		return getPersistence().countBystatus(groupId, status);
	}

	/**
	* Returns the employee where userId = &#63; or throws a {@link NoSuchEmployeeException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public static Employee findByemployees(long userId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence().findByemployees(userId);
	}

	/**
	* Returns the employee where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchByemployees(long userId) {
		return getPersistence().fetchByemployees(userId);
	}

	/**
	* Returns the employee where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchByemployees(long userId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByemployees(userId, retrieveFromCache);
	}

	/**
	* Removes the employee where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the employee that was removed
	*/
	public static Employee removeByemployees(long userId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence().removeByemployees(userId);
	}

	/**
	* Returns the number of employees where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching employees
	*/
	public static int countByemployees(long userId) {
		return getPersistence().countByemployees(userId);
	}

	/**
	* Returns the employee where employeeCode = &#63; or throws a {@link NoSuchEmployeeException} if it could not be found.
	*
	* @param employeeCode the employee code
	* @return the matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public static Employee findByemployeeCode(long employeeCode)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence().findByemployeeCode(employeeCode);
	}

	/**
	* Returns the employee where employeeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeCode the employee code
	* @return the matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchByemployeeCode(long employeeCode) {
		return getPersistence().fetchByemployeeCode(employeeCode);
	}

	/**
	* Returns the employee where employeeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeCode the employee code
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchByemployeeCode(long employeeCode,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByemployeeCode(employeeCode, retrieveFromCache);
	}

	/**
	* Removes the employee where employeeCode = &#63; from the database.
	*
	* @param employeeCode the employee code
	* @return the employee that was removed
	*/
	public static Employee removeByemployeeCode(long employeeCode)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence().removeByemployeeCode(employeeCode);
	}

	/**
	* Returns the number of employees where employeeCode = &#63;.
	*
	* @param employeeCode the employee code
	* @return the number of matching employees
	*/
	public static int countByemployeeCode(long employeeCode) {
		return getPersistence().countByemployeeCode(employeeCode);
	}

	/**
	* Returns all the employees where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @return the matching employees
	*/
	public static List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long employeeId) {
		return getPersistence()
				   .findByemployeeStatusAndemployeeId(employeeStatus, employeeId);
	}

	/**
	* Returns a range of all the employees where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of matching employees
	*/
	public static List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long employeeId, int start, int end) {
		return getPersistence()
				   .findByemployeeStatusAndemployeeId(employeeStatus,
			employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the employees where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching employees
	*/
	public static List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long employeeId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .findByemployeeStatusAndemployeeId(employeeStatus,
			employeeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employees where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching employees
	*/
	public static List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long employeeId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeStatusAndemployeeId(employeeStatus,
			employeeId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first employee in the ordered set where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public static Employee findByemployeeStatusAndemployeeId_First(
		int employeeStatus, long employeeId,
		OrderByComparator<Employee> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence()
				   .findByemployeeStatusAndemployeeId_First(employeeStatus,
			employeeId, orderByComparator);
	}

	/**
	* Returns the first employee in the ordered set where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchByemployeeStatusAndemployeeId_First(
		int employeeStatus, long employeeId,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeStatusAndemployeeId_First(employeeStatus,
			employeeId, orderByComparator);
	}

	/**
	* Returns the last employee in the ordered set where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public static Employee findByemployeeStatusAndemployeeId_Last(
		int employeeStatus, long employeeId,
		OrderByComparator<Employee> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence()
				   .findByemployeeStatusAndemployeeId_Last(employeeStatus,
			employeeId, orderByComparator);
	}

	/**
	* Returns the last employee in the ordered set where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchByemployeeStatusAndemployeeId_Last(
		int employeeStatus, long employeeId,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeStatusAndemployeeId_Last(employeeStatus,
			employeeId, orderByComparator);
	}

	/**
	* Returns all the employees where employeeStatus = &#63; and employeeId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeStatus the employee status
	* @param employeeIds the employee IDs
	* @return the matching employees
	*/
	public static List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long[] employeeIds) {
		return getPersistence()
				   .findByemployeeStatusAndemployeeId(employeeStatus,
			employeeIds);
	}

	/**
	* Returns a range of all the employees where employeeStatus = &#63; and employeeId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeStatus the employee status
	* @param employeeIds the employee IDs
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of matching employees
	*/
	public static List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long[] employeeIds, int start, int end) {
		return getPersistence()
				   .findByemployeeStatusAndemployeeId(employeeStatus,
			employeeIds, start, end);
	}

	/**
	* Returns an ordered range of all the employees where employeeStatus = &#63; and employeeId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeStatus the employee status
	* @param employeeIds the employee IDs
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching employees
	*/
	public static List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long[] employeeIds, int start, int end,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .findByemployeeStatusAndemployeeId(employeeStatus,
			employeeIds, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employees where employeeStatus = &#63; and employeeId &ne; &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching employees
	*/
	public static List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long[] employeeIds, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeStatusAndemployeeId(employeeStatus,
			employeeIds, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the employees where employeeStatus = &#63; and employeeId &ne; &#63; from the database.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	*/
	public static void removeByemployeeStatusAndemployeeId(int employeeStatus,
		long employeeId) {
		getPersistence()
			.removeByemployeeStatusAndemployeeId(employeeStatus, employeeId);
	}

	/**
	* Returns the number of employees where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @return the number of matching employees
	*/
	public static int countByemployeeStatusAndemployeeId(int employeeStatus,
		long employeeId) {
		return getPersistence()
				   .countByemployeeStatusAndemployeeId(employeeStatus,
			employeeId);
	}

	/**
	* Returns the number of employees where employeeStatus = &#63; and employeeId &ne; all &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeIds the employee IDs
	* @return the number of matching employees
	*/
	public static int countByemployeeStatusAndemployeeId(int employeeStatus,
		long[] employeeIds) {
		return getPersistence()
				   .countByemployeeStatusAndemployeeId(employeeStatus,
			employeeIds);
	}

	/**
	* Returns all the employees where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @return the matching employees
	*/
	public static List<Employee> findByemployeeStatus(int employeeStatus) {
		return getPersistence().findByemployeeStatus(employeeStatus);
	}

	/**
	* Returns a range of all the employees where employeeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeStatus the employee status
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of matching employees
	*/
	public static List<Employee> findByemployeeStatus(int employeeStatus,
		int start, int end) {
		return getPersistence().findByemployeeStatus(employeeStatus, start, end);
	}

	/**
	* Returns an ordered range of all the employees where employeeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeStatus the employee status
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching employees
	*/
	public static List<Employee> findByemployeeStatus(int employeeStatus,
		int start, int end, OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .findByemployeeStatus(employeeStatus, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the employees where employeeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeStatus the employee status
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching employees
	*/
	public static List<Employee> findByemployeeStatus(int employeeStatus,
		int start, int end, OrderByComparator<Employee> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeStatus(employeeStatus, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first employee in the ordered set where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public static Employee findByemployeeStatus_First(int employeeStatus,
		OrderByComparator<Employee> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence()
				   .findByemployeeStatus_First(employeeStatus, orderByComparator);
	}

	/**
	* Returns the first employee in the ordered set where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchByemployeeStatus_First(int employeeStatus,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeStatus_First(employeeStatus,
			orderByComparator);
	}

	/**
	* Returns the last employee in the ordered set where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public static Employee findByemployeeStatus_Last(int employeeStatus,
		OrderByComparator<Employee> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence()
				   .findByemployeeStatus_Last(employeeStatus, orderByComparator);
	}

	/**
	* Returns the last employee in the ordered set where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static Employee fetchByemployeeStatus_Last(int employeeStatus,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeStatus_Last(employeeStatus, orderByComparator);
	}

	/**
	* Returns the employees before and after the current employee in the ordered set where employeeStatus = &#63;.
	*
	* @param employeeId the primary key of the current employee
	* @param employeeStatus the employee status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next employee
	* @throws NoSuchEmployeeException if a employee with the primary key could not be found
	*/
	public static Employee[] findByemployeeStatus_PrevAndNext(long employeeId,
		int employeeStatus, OrderByComparator<Employee> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence()
				   .findByemployeeStatus_PrevAndNext(employeeId,
			employeeStatus, orderByComparator);
	}

	/**
	* Removes all the employees where employeeStatus = &#63; from the database.
	*
	* @param employeeStatus the employee status
	*/
	public static void removeByemployeeStatus(int employeeStatus) {
		getPersistence().removeByemployeeStatus(employeeStatus);
	}

	/**
	* Returns the number of employees where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @return the number of matching employees
	*/
	public static int countByemployeeStatus(int employeeStatus) {
		return getPersistence().countByemployeeStatus(employeeStatus);
	}

	/**
	* Caches the employee in the entity cache if it is enabled.
	*
	* @param employee the employee
	*/
	public static void cacheResult(Employee employee) {
		getPersistence().cacheResult(employee);
	}

	/**
	* Caches the employees in the entity cache if it is enabled.
	*
	* @param employees the employees
	*/
	public static void cacheResult(List<Employee> employees) {
		getPersistence().cacheResult(employees);
	}

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param employeeId the primary key for the new employee
	* @return the new employee
	*/
	public static Employee create(long employeeId) {
		return getPersistence().create(employeeId);
	}

	/**
	* Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeId the primary key of the employee
	* @return the employee that was removed
	* @throws NoSuchEmployeeException if a employee with the primary key could not be found
	*/
	public static Employee remove(long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence().remove(employeeId);
	}

	public static Employee updateImpl(Employee employee) {
		return getPersistence().updateImpl(employee);
	}

	/**
	* Returns the employee with the primary key or throws a {@link NoSuchEmployeeException} if it could not be found.
	*
	* @param employeeId the primary key of the employee
	* @return the employee
	* @throws NoSuchEmployeeException if a employee with the primary key could not be found
	*/
	public static Employee findByPrimaryKey(long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException {
		return getPersistence().findByPrimaryKey(employeeId);
	}

	/**
	* Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param employeeId the primary key of the employee
	* @return the employee, or <code>null</code> if a employee with the primary key could not be found
	*/
	public static Employee fetchByPrimaryKey(long employeeId) {
		return getPersistence().fetchByPrimaryKey(employeeId);
	}

	public static java.util.Map<java.io.Serializable, Employee> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the employees.
	*
	* @return the employees
	*/
	public static List<Employee> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of employees
	*/
	public static List<Employee> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employees
	*/
	public static List<Employee> findAll(int start, int end,
		OrderByComparator<Employee> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of employees
	*/
	public static List<Employee> findAll(int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the employees from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of employees.
	*
	* @return the number of employees
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EmployeePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployeePersistence, EmployeePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeePersistence.class);

		ServiceTracker<EmployeePersistence, EmployeePersistence> serviceTracker = new ServiceTracker<EmployeePersistence, EmployeePersistence>(bundle.getBundleContext(),
				EmployeePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}