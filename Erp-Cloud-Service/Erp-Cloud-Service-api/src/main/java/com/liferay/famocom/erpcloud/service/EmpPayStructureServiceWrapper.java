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
 * Provides a wrapper for {@link EmpPayStructureService}.
 *
 * @author Samaresh
 * @see EmpPayStructureService
 * @generated
 */
@ProviderType
public class EmpPayStructureServiceWrapper implements EmpPayStructureService,
	ServiceWrapper<EmpPayStructureService> {
	public EmpPayStructureServiceWrapper(
		EmpPayStructureService empPayStructureService) {
		_empPayStructureService = empPayStructureService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _empPayStructureService.getOSGiServiceIdentifier();
	}

	@Override
	public EmpPayStructureService getWrappedService() {
		return _empPayStructureService;
	}

	@Override
	public void setWrappedService(EmpPayStructureService empPayStructureService) {
		_empPayStructureService = empPayStructureService;
	}

	private EmpPayStructureService _empPayStructureService;
}