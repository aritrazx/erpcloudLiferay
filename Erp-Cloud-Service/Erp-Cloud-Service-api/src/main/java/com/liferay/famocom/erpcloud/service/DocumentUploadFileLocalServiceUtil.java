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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for DocumentUploadFile. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.DocumentUploadFileLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see DocumentUploadFileLocalService
 * @see com.liferay.famocom.erpcloud.service.base.DocumentUploadFileLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.DocumentUploadFileLocalServiceImpl
 * @generated
 */
@ProviderType
public class DocumentUploadFileLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.DocumentUploadFileLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the document upload file to the database. Also notifies the appropriate model listeners.
	*
	* @param documentUploadFile the document upload file
	* @return the document upload file that was added
	*/
	public static com.liferay.famocom.erpcloud.model.DocumentUploadFile addDocumentUploadFile(
		com.liferay.famocom.erpcloud.model.DocumentUploadFile documentUploadFile) {
		return getService().addDocumentUploadFile(documentUploadFile);
	}

	/**
	* Creates a new document upload file with the primary key. Does not add the document upload file to the database.
	*
	* @param documentId the primary key for the new document upload file
	* @return the new document upload file
	*/
	public static com.liferay.famocom.erpcloud.model.DocumentUploadFile createDocumentUploadFile(
		long documentId) {
		return getService().createDocumentUploadFile(documentId);
	}

	/**
	* Deletes the document upload file from the database. Also notifies the appropriate model listeners.
	*
	* @param documentUploadFile the document upload file
	* @return the document upload file that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.DocumentUploadFile deleteDocumentUploadFile(
		com.liferay.famocom.erpcloud.model.DocumentUploadFile documentUploadFile) {
		return getService().deleteDocumentUploadFile(documentUploadFile);
	}

	/**
	* Deletes the document upload file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the document upload file
	* @return the document upload file that was removed
	* @throws PortalException if a document upload file with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.DocumentUploadFile deleteDocumentUploadFile(
		long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteDocumentUploadFile(documentId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.famocom.erpcloud.model.DocumentUploadFile fetchDocumentUploadFile(
		long documentId) {
		return getService().fetchDocumentUploadFile(documentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the document upload file with the primary key.
	*
	* @param documentId the primary key of the document upload file
	* @return the document upload file
	* @throws PortalException if a document upload file with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.DocumentUploadFile getDocumentUploadFile(
		long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getDocumentUploadFile(documentId);
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
	public static java.util.List<com.liferay.famocom.erpcloud.model.DocumentUploadFile> getDocumentUploadFiles(
		int start, int end) {
		return getService().getDocumentUploadFiles(start, end);
	}

	/**
	* Returns the number of document upload files.
	*
	* @return the number of document upload files
	*/
	public static int getDocumentUploadFilesCount() {
		return getService().getDocumentUploadFilesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the document upload file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param documentUploadFile the document upload file
	* @return the document upload file that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.DocumentUploadFile updateDocumentUploadFile(
		com.liferay.famocom.erpcloud.model.DocumentUploadFile documentUploadFile) {
		return getService().updateDocumentUploadFile(documentUploadFile);
	}

	public static DocumentUploadFileLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DocumentUploadFileLocalService, DocumentUploadFileLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DocumentUploadFileLocalService.class);

		ServiceTracker<DocumentUploadFileLocalService, DocumentUploadFileLocalService> serviceTracker =
			new ServiceTracker<DocumentUploadFileLocalService, DocumentUploadFileLocalService>(bundle.getBundleContext(),
				DocumentUploadFileLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}