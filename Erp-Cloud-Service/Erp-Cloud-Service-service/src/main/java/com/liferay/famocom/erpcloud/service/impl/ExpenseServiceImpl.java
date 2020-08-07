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

import java.util.List;

import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.Expense;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ExpenseLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.base.ExpenseServiceBaseImpl;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

/**
 * The implementation of the expense remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.ExpenseService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Samaresh
 * @see ExpenseServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.ExpenseServiceUtil
 */
public class ExpenseServiceImpl extends ExpenseServiceBaseImpl {
	//@AccessControlled(guestAccessEnabled=true)
	
	public Expense getExpenseAll(long expenseId){
		Expense expList =null;
		try{
			expList=ExpenseLocalServiceUtil.getExpense(expenseId);
		
		}catch(Exception e){
			
		}
		return expList;
		
	}
}