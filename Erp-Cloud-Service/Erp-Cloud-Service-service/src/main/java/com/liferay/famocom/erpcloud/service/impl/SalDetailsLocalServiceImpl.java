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
import java.util.List;

import com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException;
import com.liferay.famocom.erpcloud.model.SalDetails;
import com.liferay.famocom.erpcloud.service.base.SalDetailsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the sal details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.SalDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see SalDetailsLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.SalDetailsLocalServiceUtil
 */
public class SalDetailsLocalServiceImpl extends SalDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.SalDetailsLocalServiceUtil} to access the sal details local service.
	 */
	public List<SalDetails> findSalDetailsByEmployeeId(long employeeId) throws SystemException{
		List<SalDetails> salDetailsList = new ArrayList<SalDetails>();
		salDetailsList = getSalDetailsPersistence().findByemployeeId(employeeId);
		return salDetailsList;
		}
	public List<SalDetails> findSalDetailsByMonthYear(long monthYear) throws SystemException{
		List<SalDetails> salDetailsList = new ArrayList<SalDetails>();
		salDetailsList = getSalDetailsPersistence().findBymonthYear(monthYear);
		return salDetailsList;
		}
	public List<SalDetails> findSalDetailsByMonthYearAndEmployeeId(long monthYear,long employeeId) throws SystemException{
		List<SalDetails> salDetailsList = new ArrayList<SalDetails>();
		salDetailsList = getSalDetailsPersistence().findBymonthYearAndemployeeId(monthYear, employeeId);
		return salDetailsList;
		}
	public List<SalDetails> findSalDetailsByEmployeeIdAndMonthYears(long employeeId,long[] monthYears) throws SystemException{
		List<SalDetails> salDetailsList = new ArrayList<SalDetails>();
		salDetailsList = getSalDetailsPersistence().findByemployeeIdAndMonthYear(employeeId, monthYears);
		return salDetailsList;
		}
	public List<SalDetails> findSalDetailsByEmployeeIdAndComponentIdsAndmonthYears(long employeeId,long[] payComponentIds,long[] monthYears) throws SystemException{
		List<SalDetails> salDetailsList = new ArrayList<SalDetails>();
		salDetailsList = getSalDetailsPersistence().findByemployeeIdAndComponentIdmonthYears(employeeId, payComponentIds, monthYears);
		return salDetailsList;
		}
	public List<SalDetails> findSalDetailsByEmployeeIdAndMonthYearAndComponentIds(long employeeId,long monthYear,long[] payComponentIds) throws SystemException{
		List<SalDetails> salDetailsList = new ArrayList<SalDetails>();
		salDetailsList = getSalDetailsPersistence().findByemployeeIdAndMonthYearAndComponentId(employeeId, monthYear, payComponentIds);
		return salDetailsList;
		}
	public List<SalDetails> findSalDetailsByEmployeeIdAndComponentIdAndmonthYears(long employeeId,long payComponentIds,long[] monthYears) throws SystemException{
		List<SalDetails> salDetailsList = new ArrayList<SalDetails>();
		salDetailsList = getSalDetailsPersistence().findByemployeeIdAndComponentIdAndMonthYears(employeeId, payComponentIds, monthYears);
		return salDetailsList;
		}
	
	public SalDetails findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(long employeeId,long componentId,long monthYear) throws NoSuchSalDetailsException{
		
		SalDetails salDetailsList = getSalDetailsPersistence().findByemployeeIdAndComponentIdAndMonthYear(employeeId, componentId, monthYear);				
		return salDetailsList;
	}
	public List<String[]> findSalDetailsByEmployeeIdAndYear(long employeeId,int year){
		List<String[]> salDetailsList = new ArrayList<String[]>();
		salDetailsList = salDetailsFinder.getEmployeeSalaryDetailsByEmployeeIdAndYear(employeeId, year);
		return salDetailsList;
	}
}