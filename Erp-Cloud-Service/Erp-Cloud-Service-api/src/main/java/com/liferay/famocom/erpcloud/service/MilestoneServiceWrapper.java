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
 * Provides a wrapper for {@link MilestoneService}.
 *
 * @author Samaresh
 * @see MilestoneService
 * @generated
 */
@ProviderType
public class MilestoneServiceWrapper implements MilestoneService,
	ServiceWrapper<MilestoneService> {
	public MilestoneServiceWrapper(MilestoneService milestoneService) {
		_milestoneService = milestoneService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _milestoneService.getOSGiServiceIdentifier();
	}

	@Override
	public MilestoneService getWrappedService() {
		return _milestoneService;
	}

	@Override
	public void setWrappedService(MilestoneService milestoneService) {
		_milestoneService = milestoneService;
	}

	private MilestoneService _milestoneService;
}