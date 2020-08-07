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

package com.liferay.famocom.erpcloud.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.famocom.erpcloud.exception.NoSuchEmployeeException;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.service.base.EmployeeLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.EmployeeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see EmployeeLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil
 */
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil} to access the employee local service.
	 */
	public List<Employee> getEmployeeByStatus(long groupId, int status){
		return employeePersistence.findBystatus(groupId, status);
	}
	
	public List<Employee> getEmployeeByStatus(long groupId, int status, int start, int end){
		return employeePersistence.findBystatus(groupId, status, start, end);
	}
	
	public Employee findByemployees(long userId) throws SystemException{
		Employee employee = null;
		try {
		employee = getEmployeePersistence().findByemployees(userId);
		} catch (NoSuchEmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
		}
	
	public Employee findByemployeeCode(long employeeCode) throws SystemException{
		Employee employee = null;
		try {
		employee = getEmployeePersistence().findByemployeeCode(employeeCode);
		} catch (NoSuchEmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
		}
	public Employee updateStatus(long userId,long employeeId,int status,ServiceContext serviceContext){
		System.out.println("call updateStatus"); 
		Employee employee = employeePersistence.fetchByPrimaryKey(employeeId);
		employee.setStatus(status);
		employee.setStatusByUserId(userId);
		employee.setStatusDate(new Date());
		 User user = null;
		 try {
		      user = userLocalService.getUser(userId);
		      employee.setStatusByUserName(user.getFullName());
		      employee.setStatusByUserUuid(user.getUserUuid());
		 } catch (PortalException e) {
		     e.printStackTrace();
		 }
		 employee = employeePersistence.update(employee);
		 try {
		 if (status == WorkflowConstants.STATUS_APPROVED) {  
		     // update the asset status to visibile
		    assetEntryLocalService.updateEntry(Employee.class.getName(), employeeId, new Date(),null, true, true);
		 } else {
		     // set leave entity status to false
		     assetEntryLocalService.updateVisible(Employee.class.getName(), employeeId, false);  
		 }
		 } catch (Exception e) {
		     e.printStackTrace();
		 }
		 return employee;
		 }	
		 
	public List<Employee> findEmoployeeByStatus(int status){
	  List<Employee> employees = new ArrayList<Employee>();
	  try{
		  employees = getEmployeePersistence().findByemployeeStatus(status);
	  }catch (Exception e) {
		// TODO: handle exception
		  e.printStackTrace();
	}	  
	   return employees;
	}
	public List<Employee> findEmployeeByStatusAndEmployeeIdNotIn(int employeeStatus,long[] employeeIds){
		 List<Employee> employees = new ArrayList<Employee>();
		 try{
			 employees = getEmployeePersistence().findByemployeeStatusAndemployeeId(employeeStatus, employeeIds);
		 }catch (Exception e) {
			// TODO: handle exception
		}
		 return employees;
	}
	public  List<String[]> getEmployeeByEmployeeStatusAndNotStopPayAndBankName(long employeeStatus, String employeeIds){
		List<String[]> empLists = new ArrayList<String[]>();
		empLists = employeeFinder.getEmployeeByEmployeeStatusAndNotStopPayAndBankName(employeeStatus, employeeIds);
		return empLists;
	}
	
}