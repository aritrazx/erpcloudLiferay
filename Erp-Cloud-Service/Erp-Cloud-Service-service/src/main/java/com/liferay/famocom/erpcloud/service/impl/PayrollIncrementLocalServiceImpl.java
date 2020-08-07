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

import com.liferay.famocom.erpcloud.exception.NoSuchPayrollIncrementException;
import com.liferay.famocom.erpcloud.model.PayrollIncrement;
import com.liferay.famocom.erpcloud.service.base.PayrollIncrementLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the payroll increment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.PayrollIncrementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see PayrollIncrementLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.PayrollIncrementLocalServiceUtil
 */
public class PayrollIncrementLocalServiceImpl
	extends PayrollIncrementLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.PayrollIncrementLocalServiceUtil} to access the payroll increment local service.
	 */
	
	public PayrollIncrement findByEmployeeIdComponentIdFinancialYear(long employeeId, long componentId,
			String financialYear) throws SystemException {
		PayrollIncrement payrollIncrement = null;
		try {
			payrollIncrement = payrollIncrementPersistence.findByemployeeIdComponentIdFinancialYear(employeeId,
					componentId, financialYear);
		} catch (NoSuchPayrollIncrementException e) {
			// TODO Auto-generated catch block
		}
		return payrollIncrement;
	}

	public List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(long employeeId,
			long appraisalSettingId, String financialYear) throws SystemException {
		List<PayrollIncrement> PayrollIncrementList = new ArrayList<PayrollIncrement>();
		PayrollIncrementList = getPayrollIncrementPersistence()
				.findByemployeeIdAppraisalSettingIdFinancialYear(employeeId, appraisalSettingId, financialYear);
		return PayrollIncrementList;
	}
}