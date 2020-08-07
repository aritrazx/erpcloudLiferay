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

import com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException;
import com.liferay.famocom.erpcloud.model.TaxDeclaration;
import com.liferay.famocom.erpcloud.service.base.TaxDeclarationLocalServiceBaseImpl;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the tax declaration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.TaxDeclarationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see TaxDeclarationLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.TaxDeclarationLocalServiceUtil
 */
public class TaxDeclarationLocalServiceImpl
	extends TaxDeclarationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.TaxDeclarationLocalServiceUtil} to access the tax declaration local service.
	 */
	 public TaxDeclaration getTaxDeclarationByEmployeeId(long employeeId) throws NoSuchTaxDeclarationException{
		 TaxDeclaration declaration =getTaxDeclarationPersistence().findByemployeeId(employeeId);
		 return declaration;
	 }
	 
	 public TaxDeclaration findByemployeeIdAndFinancialYear(long employeeId, String financialYear) {
		 TaxDeclaration taxDeclaration=null;
		 if(Validator.isNotNull(employeeId)){
		 try {
		 taxDeclaration = taxDeclarationPersistence.findByemployeeIdAndFinancialYear(employeeId, financialYear);
		 } catch (NoSuchTaxDeclarationException e) {
		 // TODO Auto-generated catch block
		 } 
		 }
		 return taxDeclaration;
		 }
}