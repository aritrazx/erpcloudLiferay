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
 * Provides a wrapper for {@link WorkFromHomeService}.
 *
 * @author Samaresh
 * @see WorkFromHomeService
 * @generated
 */
@ProviderType
public class WorkFromHomeServiceWrapper implements WorkFromHomeService,
	ServiceWrapper<WorkFromHomeService> {
	public WorkFromHomeServiceWrapper(WorkFromHomeService workFromHomeService) {
		_workFromHomeService = workFromHomeService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _workFromHomeService.getOSGiServiceIdentifier();
	}

	@Override
	public WorkFromHomeService getWrappedService() {
		return _workFromHomeService;
	}

	@Override
	public void setWrappedService(WorkFromHomeService workFromHomeService) {
		_workFromHomeService = workFromHomeService;
	}

	private WorkFromHomeService _workFromHomeService;
}