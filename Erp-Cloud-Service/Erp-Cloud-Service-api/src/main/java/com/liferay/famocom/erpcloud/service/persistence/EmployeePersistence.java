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

import com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException;
import com.liferay.famocom.erpcloud.model.Employee;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EmployeePersistenceImpl
 * @see EmployeeUtil
 * @generated
 */
@ProviderType
public interface EmployeePersistence extends BasePersistence<Employee> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeUtil} to access the employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the employees where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching employees
	*/
	public java.util.List<Employee> findByuserId(long userId);

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
	public java.util.List<Employee> findByuserId(long userId, int start, int end);

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
	public java.util.List<Employee> findByuserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

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
	public java.util.List<Employee> findByuserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first employee in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public Employee findByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException;

	/**
	* Returns the first employee in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

	/**
	* Returns the last employee in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public Employee findByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException;

	/**
	* Returns the last employee in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

	/**
	* Returns the employees before and after the current employee in the ordered set where userId = &#63;.
	*
	* @param employeeId the primary key of the current employee
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next employee
	* @throws NoSuchEmployeeException if a employee with the primary key could not be found
	*/
	public Employee[] findByuserId_PrevAndNext(long employeeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException;

	/**
	* Removes all the employees where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByuserId(long userId);

	/**
	* Returns the number of employees where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching employees
	*/
	public int countByuserId(long userId);

	/**
	* Returns all the employees where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching employees
	*/
	public java.util.List<Employee> findBystatus(long groupId, int status);

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
	public java.util.List<Employee> findBystatus(long groupId, int status,
		int start, int end);

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
	public java.util.List<Employee> findBystatus(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

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
	public java.util.List<Employee> findBystatus(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first employee in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public Employee findBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException;

	/**
	* Returns the first employee in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

	/**
	* Returns the last employee in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public Employee findBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException;

	/**
	* Returns the last employee in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

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
	public Employee[] findBystatus_PrevAndNext(long employeeId, long groupId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException;

	/**
	* Removes all the employees where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeBystatus(long groupId, int status);

	/**
	* Returns the number of employees where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching employees
	*/
	public int countBystatus(long groupId, int status);

	/**
	* Returns the employee where userId = &#63; or throws a {@link NoSuchEmployeeException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public Employee findByemployees(long userId) throws NoSuchEmployeeException;

	/**
	* Returns the employee where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchByemployees(long userId);

	/**
	* Returns the employee where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchByemployees(long userId, boolean retrieveFromCache);

	/**
	* Removes the employee where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the employee that was removed
	*/
	public Employee removeByemployees(long userId)
		throws NoSuchEmployeeException;

	/**
	* Returns the number of employees where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching employees
	*/
	public int countByemployees(long userId);

	/**
	* Returns the employee where employeeCode = &#63; or throws a {@link NoSuchEmployeeException} if it could not be found.
	*
	* @param employeeCode the employee code
	* @return the matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public Employee findByemployeeCode(long employeeCode)
		throws NoSuchEmployeeException;

	/**
	* Returns the employee where employeeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeCode the employee code
	* @return the matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchByemployeeCode(long employeeCode);

	/**
	* Returns the employee where employeeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeCode the employee code
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchByemployeeCode(long employeeCode,
		boolean retrieveFromCache);

	/**
	* Removes the employee where employeeCode = &#63; from the database.
	*
	* @param employeeCode the employee code
	* @return the employee that was removed
	*/
	public Employee removeByemployeeCode(long employeeCode)
		throws NoSuchEmployeeException;

	/**
	* Returns the number of employees where employeeCode = &#63;.
	*
	* @param employeeCode the employee code
	* @return the number of matching employees
	*/
	public int countByemployeeCode(long employeeCode);

	/**
	* Returns all the employees where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @return the matching employees
	*/
	public java.util.List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long employeeId);

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
	public java.util.List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long employeeId, int start, int end);

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
	public java.util.List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

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
	public java.util.List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first employee in the ordered set where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public Employee findByemployeeStatusAndemployeeId_First(
		int employeeStatus, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException;

	/**
	* Returns the first employee in the ordered set where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchByemployeeStatusAndemployeeId_First(
		int employeeStatus, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

	/**
	* Returns the last employee in the ordered set where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public Employee findByemployeeStatusAndemployeeId_Last(int employeeStatus,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException;

	/**
	* Returns the last employee in the ordered set where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchByemployeeStatusAndemployeeId_Last(
		int employeeStatus, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

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
	public java.util.List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long[] employeeIds);

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
	public java.util.List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long[] employeeIds, int start, int end);

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
	public java.util.List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long[] employeeIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

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
	public java.util.List<Employee> findByemployeeStatusAndemployeeId(
		int employeeStatus, long[] employeeIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the employees where employeeStatus = &#63; and employeeId &ne; &#63; from the database.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	*/
	public void removeByemployeeStatusAndemployeeId(int employeeStatus,
		long employeeId);

	/**
	* Returns the number of employees where employeeStatus = &#63; and employeeId &ne; &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeId the employee ID
	* @return the number of matching employees
	*/
	public int countByemployeeStatusAndemployeeId(int employeeStatus,
		long employeeId);

	/**
	* Returns the number of employees where employeeStatus = &#63; and employeeId &ne; all &#63;.
	*
	* @param employeeStatus the employee status
	* @param employeeIds the employee IDs
	* @return the number of matching employees
	*/
	public int countByemployeeStatusAndemployeeId(int employeeStatus,
		long[] employeeIds);

	/**
	* Returns all the employees where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @return the matching employees
	*/
	public java.util.List<Employee> findByemployeeStatus(int employeeStatus);

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
	public java.util.List<Employee> findByemployeeStatus(int employeeStatus,
		int start, int end);

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
	public java.util.List<Employee> findByemployeeStatus(int employeeStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

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
	public java.util.List<Employee> findByemployeeStatus(int employeeStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first employee in the ordered set where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public Employee findByemployeeStatus_First(int employeeStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException;

	/**
	* Returns the first employee in the ordered set where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchByemployeeStatus_First(int employeeStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

	/**
	* Returns the last employee in the ordered set where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee
	* @throws NoSuchEmployeeException if a matching employee could not be found
	*/
	public Employee findByemployeeStatus_Last(int employeeStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException;

	/**
	* Returns the last employee in the ordered set where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public Employee fetchByemployeeStatus_Last(int employeeStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

	/**
	* Returns the employees before and after the current employee in the ordered set where employeeStatus = &#63;.
	*
	* @param employeeId the primary key of the current employee
	* @param employeeStatus the employee status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next employee
	* @throws NoSuchEmployeeException if a employee with the primary key could not be found
	*/
	public Employee[] findByemployeeStatus_PrevAndNext(long employeeId,
		int employeeStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException;

	/**
	* Removes all the employees where employeeStatus = &#63; from the database.
	*
	* @param employeeStatus the employee status
	*/
	public void removeByemployeeStatus(int employeeStatus);

	/**
	* Returns the number of employees where employeeStatus = &#63;.
	*
	* @param employeeStatus the employee status
	* @return the number of matching employees
	*/
	public int countByemployeeStatus(int employeeStatus);

	/**
	* Caches the employee in the entity cache if it is enabled.
	*
	* @param employee the employee
	*/
	public void cacheResult(Employee employee);

	/**
	* Caches the employees in the entity cache if it is enabled.
	*
	* @param employees the employees
	*/
	public void cacheResult(java.util.List<Employee> employees);

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param employeeId the primary key for the new employee
	* @return the new employee
	*/
	public Employee create(long employeeId);

	/**
	* Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeId the primary key of the employee
	* @return the employee that was removed
	* @throws NoSuchEmployeeException if a employee with the primary key could not be found
	*/
	public Employee remove(long employeeId) throws NoSuchEmployeeException;

	public Employee updateImpl(Employee employee);

	/**
	* Returns the employee with the primary key or throws a {@link NoSuchEmployeeException} if it could not be found.
	*
	* @param employeeId the primary key of the employee
	* @return the employee
	* @throws NoSuchEmployeeException if a employee with the primary key could not be found
	*/
	public Employee findByPrimaryKey(long employeeId)
		throws NoSuchEmployeeException;

	/**
	* Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param employeeId the primary key of the employee
	* @return the employee, or <code>null</code> if a employee with the primary key could not be found
	*/
	public Employee fetchByPrimaryKey(long employeeId);

	@Override
	public java.util.Map<java.io.Serializable, Employee> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the employees.
	*
	* @return the employees
	*/
	public java.util.List<Employee> findAll();

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
	public java.util.List<Employee> findAll(int start, int end);

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
	public java.util.List<Employee> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator);

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
	public java.util.List<Employee> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the employees from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of employees.
	*
	* @return the number of employees
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}