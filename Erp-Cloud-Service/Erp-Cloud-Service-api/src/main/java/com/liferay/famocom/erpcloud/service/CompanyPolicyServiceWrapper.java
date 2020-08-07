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
 * Provides a wrapper for {@link CompanyPolicyService}.
 *
 * @author Samaresh
 * @see CompanyPolicyService
 * @generated
 */
@ProviderType
public class CompanyPolicyServiceWrapper implements CompanyPolicyService,
	ServiceWrapper<CompanyPolicyService> {
	public CompanyPolicyServiceWrapper(
		CompanyPolicyService companyPolicyService) {
		_companyPolicyService = companyPolicyService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _companyPolicyService.getOSGiServiceIdentifier();
	}

	@Override
	public CompanyPolicyService getWrappedService() {
		return _companyPolicyService;
	}

	@Override
	public void setWrappedService(CompanyPolicyService companyPolicyService) {
		_companyPolicyService = companyPolicyService;
	}

	private CompanyPolicyService _companyPolicyService;
}