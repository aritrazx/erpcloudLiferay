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

import com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationMonthlyException;
import com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly;
import com.liferay.famocom.erpcloud.service.base.TaxDeclarationMonthlyLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the tax declaration monthly local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see TaxDeclarationMonthlyLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalServiceUtil
 */
public class TaxDeclarationMonthlyLocalServiceImpl
	extends TaxDeclarationMonthlyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalServiceUtil} to access the tax declaration monthly local service.
	 */
	public List<TaxDeclarationMonthly> findTaxDeclarationMonthlyByEmployeeIdAndMonthYears(long employeeId,long [] monthYear) throws SystemException{
		List<TaxDeclarationMonthly> taxDeclarationMonthlyList = new ArrayList<TaxDeclarationMonthly>();
		taxDeclarationMonthlyList = getTaxDeclarationMonthlyPersistence().findByemployeeIdAndMonthYear(employeeId, monthYear );
		return taxDeclarationMonthlyList;
		}
	public TaxDeclarationMonthly findTaxDeclarationMonthlyByMonthYearAndEmployeeId(long employeeId,long monthYear) throws SystemException, NoSuchTaxDeclarationMonthlyException{		
		TaxDeclarationMonthly taxDeclarationMonthlyList = getTaxDeclarationMonthlyPersistence().findBymonthYearAndemployeeId(monthYear, employeeId);
		return taxDeclarationMonthlyList;
		}
}