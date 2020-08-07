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
 * Provides a wrapper for {@link BankMasterService}.
 *
 * @author Samaresh
 * @see BankMasterService
 * @generated
 */
@ProviderType
public class BankMasterServiceWrapper implements BankMasterService,
	ServiceWrapper<BankMasterService> {
	public BankMasterServiceWrapper(BankMasterService bankMasterService) {
		_bankMasterService = bankMasterService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _bankMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public BankMasterService getWrappedService() {
		return _bankMasterService;
	}

	@Override
	public void setWrappedService(BankMasterService bankMasterService) {
		_bankMasterService = bankMasterService;
	}

	private BankMasterService _bankMasterService;
}