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

package com.liferay.famocom.erpcloud.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExpenseService}.
 *
 * @author Samaresh
 * @see ExpenseService
 * @generated
 */
@ProviderType
public class ExpenseServiceWrapper implements ExpenseService,
	ServiceWrapper<ExpenseService> {
	public ExpenseServiceWrapper(ExpenseService expenseService) {
		_expenseService = expenseService;
	}

	@Override
	public com.liferay.famocom.erpcloud.model.Expense getExpenseAll(
		long expenseId) {
		return _expenseService.getExpenseAll(expenseId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _expenseService.getOSGiServiceIdentifier();
	}

	@Override
	public ExpenseService getWrappedService() {
		return _expenseService;
	}

	@Override
	public void setWrappedService(ExpenseService expenseService) {
		_expenseService = expenseService;
	}

	private ExpenseService _expenseService;
}