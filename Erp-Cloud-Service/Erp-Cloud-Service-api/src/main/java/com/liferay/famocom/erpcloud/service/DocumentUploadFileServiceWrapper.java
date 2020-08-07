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
 * Provides a wrapper for {@link DocumentUploadFileService}.
 *
 * @author Samaresh
 * @see DocumentUploadFileService
 * @generated
 */
@ProviderType
public class DocumentUploadFileServiceWrapper
	implements DocumentUploadFileService,
		ServiceWrapper<DocumentUploadFileService> {
	public DocumentUploadFileServiceWrapper(
		DocumentUploadFileService documentUploadFileService) {
		_documentUploadFileService = documentUploadFileService;
	}

	@Override
	public java.util.ArrayList<java.util.HashMap<String, String>> getFilesFromFolderName(
		String folderName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _documentUploadFileService.getFilesFromFolderName(folderName);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentUploadFileService.getOSGiServiceIdentifier();
	}

	@Override
	public DocumentUploadFileService getWrappedService() {
		return _documentUploadFileService;
	}

	@Override
	public void setWrappedService(
		DocumentUploadFileService documentUploadFileService) {
		_documentUploadFileService = documentUploadFileService;
	}

	private DocumentUploadFileService _documentUploadFileService;
}