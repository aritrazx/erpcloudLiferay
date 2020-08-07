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
 * Provides a wrapper for {@link RecruitProcessService}.
 *
 * @author Samaresh
 * @see RecruitProcessService
 * @generated
 */
@ProviderType
public class RecruitProcessServiceWrapper implements RecruitProcessService,
	ServiceWrapper<RecruitProcessService> {
	public RecruitProcessServiceWrapper(
		RecruitProcessService recruitProcessService) {
		_recruitProcessService = recruitProcessService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _recruitProcessService.getOSGiServiceIdentifier();
	}

	@Override
	public RecruitProcessService getWrappedService() {
		return _recruitProcessService;
	}

	@Override
	public void setWrappedService(RecruitProcessService recruitProcessService) {
		_recruitProcessService = recruitProcessService;
	}

	private RecruitProcessService _recruitProcessService;
}