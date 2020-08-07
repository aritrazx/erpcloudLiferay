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
 * Provides a wrapper for {@link BillDocumentUploadFileService}.
 *
 * @author Samaresh
 * @see BillDocumentUploadFileService
 * @generated
 */
@ProviderType
public class BillDocumentUploadFileServiceWrapper
	implements BillDocumentUploadFileService,
		ServiceWrapper<BillDocumentUploadFileService> {
	public BillDocumentUploadFileServiceWrapper(
		BillDocumentUploadFileService billDocumentUploadFileService) {
		_billDocumentUploadFileService = billDocumentUploadFileService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _billDocumentUploadFileService.getOSGiServiceIdentifier();
	}

	@Override
	public BillDocumentUploadFileService getWrappedService() {
		return _billDocumentUploadFileService;
	}

	@Override
	public void setWrappedService(
		BillDocumentUploadFileService billDocumentUploadFileService) {
		_billDocumentUploadFileService = billDocumentUploadFileService;
	}

	private BillDocumentUploadFileService _billDocumentUploadFileService;
}