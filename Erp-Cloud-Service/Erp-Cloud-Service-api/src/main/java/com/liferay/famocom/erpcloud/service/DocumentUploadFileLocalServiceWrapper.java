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
 * Provides a wrapper for {@link DocumentUploadFileLocalService}.
 *
 * @author Samaresh
 * @see DocumentUploadFileLocalService
 * @generated
 */
@ProviderType
public class DocumentUploadFileLocalServiceWrapper
	implements DocumentUploadFileLocalService,
		ServiceWrapper<DocumentUploadFileLocalService> {
	public DocumentUploadFileLocalServiceWrapper(
		DocumentUploadFileLocalService documentUploadFileLocalService) {
		_documentUploadFileLocalService = documentUploadFileLocalService;
	}

	/**
	* Adds the document upload file to the database. Also notifies the appropriate model listeners.
	*
	* @param documentUploadFile the document upload file
	* @return the document upload file that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.DocumentUploadFile addDocumentUploadFile(
		com.liferay.famocom.erpcloud.model.DocumentUploadFile documentUploadFile) {
		return _documentUploadFileLocalService.addDocumentUploadFile(documentUploadFile);
	}

	/**
	* Creates a new document upload file with the primary key. Does not add the document upload file to the database.
	*
	* @param documentId the primary key for the new document upload file
	* @return the new document upload file
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.DocumentUploadFile createDocumentUploadFile(
		long documentId) {
		return _documentUploadFileLocalService.createDocumentUploadFile(documentId);
	}

	/**
	* Deletes the document upload file from the database. Also notifies the appropriate model listeners.
	*
	* @param documentUploadFile the document upload file
	* @return the document upload file that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.DocumentUploadFile deleteDocumentUploadFile(
		com.liferay.famocom.erpcloud.model.DocumentUploadFile documentUploadFile) {
		return _documentUploadFileLocalService.deleteDocumentUploadFile(documentUploadFile);
	}

	/**
	* Deletes the document upload file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the document upload file
	* @return the document upload file that was removed
	* @throws PortalException if a document upload file with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.DocumentUploadFile deleteDocumentUploadFile(
		long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _documentUploadFileLocalService.deleteDocumentUploadFile(documentId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _documentUploadFileLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentUploadFileLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _documentUploadFileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.DocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _documentUploadFileLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.DocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _documentUploadFileLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _documentUploadFileLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _documentUploadFileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.DocumentUploadFile fetchDocumentUploadFile(
		long documentId) {
		return _documentUploadFileLocalService.fetchDocumentUploadFile(documentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _documentUploadFileLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the document upload file with the primary key.
	*
	* @param documentId the primary key of the document upload file
	* @return the document upload file
	* @throws PortalException if a document upload file with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.DocumentUploadFile getDocumentUploadFile(
		long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _documentUploadFileLocalService.getDocumentUploadFile(documentId);
	}

	/**
	* Returns a range of all the document upload files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.DocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document upload files
	* @param end the upper bound of the range of document upload files (not inclusive)
	* @return the range of document upload files
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.DocumentUploadFile> getDocumentUploadFiles(
		int start, int end) {
		return _documentUploadFileLocalService.getDocumentUploadFiles(start, end);
	}

	/**
	* Returns the number of document upload files.
	*
	* @return the number of document upload files
	*/
	@Override
	public int getDocumentUploadFilesCount() {
		return _documentUploadFileLocalService.getDocumentUploadFilesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _documentUploadFileLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentUploadFileLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _documentUploadFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the document upload file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param documentUploadFile the document upload file
	* @return the document upload file that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.DocumentUploadFile updateDocumentUploadFile(
		com.liferay.famocom.erpcloud.model.DocumentUploadFile documentUploadFile) {
		return _documentUploadFileLocalService.updateDocumentUploadFile(documentUploadFile);
	}

	@Override
	public DocumentUploadFileLocalService getWrappedService() {
		return _documentUploadFileLocalService;
	}

	@Override
	public void setWrappedService(
		DocumentUploadFileLocalService documentUploadFileLocalService) {
		_documentUploadFileLocalService = documentUploadFileLocalService;
	}

	private DocumentUploadFileLocalService _documentUploadFileLocalService;
}