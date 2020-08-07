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
 * Provides a wrapper for {@link NotificationMasterManageService}.
 *
 * @author Samaresh
 * @see NotificationMasterManageService
 * @generated
 */
@ProviderType
public class NotificationMasterManageServiceWrapper
	implements NotificationMasterManageService,
		ServiceWrapper<NotificationMasterManageService> {
	public NotificationMasterManageServiceWrapper(
		NotificationMasterManageService notificationMasterManageService) {
		_notificationMasterManageService = notificationMasterManageService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _notificationMasterManageService.getOSGiServiceIdentifier();
	}

	@Override
	public NotificationMasterManageService getWrappedService() {
		return _notificationMasterManageService;
	}

	@Override
	public void setWrappedService(
		NotificationMasterManageService notificationMasterManageService) {
		_notificationMasterManageService = notificationMasterManageService;
	}

	private NotificationMasterManageService _notificationMasterManageService;
}