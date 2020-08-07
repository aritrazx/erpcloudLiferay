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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Provides the remote service interface for DocumentUploadFile. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Samaresh
 * @see DocumentUploadFileServiceUtil
 * @see com.liferay.famocom.erpcloud.service.base.DocumentUploadFileServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.DocumentUploadFileServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=erp", "json.web.service.context.path=DocumentUploadFile"}, service = DocumentUploadFileService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface DocumentUploadFileService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentUploadFileServiceUtil} to access the document upload file remote service. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.DocumentUploadFileServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<HashMap<String, String>> getFilesFromFolderName(
		String folderName) throws PortalException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();
}