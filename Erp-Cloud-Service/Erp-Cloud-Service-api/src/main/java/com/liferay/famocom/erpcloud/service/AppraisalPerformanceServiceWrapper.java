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
 * Provides a wrapper for {@link AppraisalPerformanceService}.
 *
 * @author Samaresh
 * @see AppraisalPerformanceService
 * @generated
 */
@ProviderType
public class AppraisalPerformanceServiceWrapper
	implements AppraisalPerformanceService,
		ServiceWrapper<AppraisalPerformanceService> {
	public AppraisalPerformanceServiceWrapper(
		AppraisalPerformanceService appraisalPerformanceService) {
		_appraisalPerformanceService = appraisalPerformanceService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalPerformanceService.getOSGiServiceIdentifier();
	}

	@Override
	public AppraisalPerformanceService getWrappedService() {
		return _appraisalPerformanceService;
	}

	@Override
	public void setWrappedService(
		AppraisalPerformanceService appraisalPerformanceService) {
		_appraisalPerformanceService = appraisalPerformanceService;
	}

	private AppraisalPerformanceService _appraisalPerformanceService;
}