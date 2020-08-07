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

package com.liferay.famocom.erpcloud.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.DocumentUploadFile;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the document upload file service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.DocumentUploadFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see DocumentUploadFilePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.DocumentUploadFilePersistenceImpl
 * @generated
 */
@ProviderType
public class DocumentUploadFileUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DocumentUploadFile documentUploadFile) {
		getPersistence().clearCache(documentUploadFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocumentUploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocumentUploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocumentUploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocumentUploadFile> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocumentUploadFile update(
		DocumentUploadFile documentUploadFile) {
		return getPersistence().update(documentUploadFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocumentUploadFile update(
		DocumentUploadFile documentUploadFile, ServiceContext serviceContext) {
		return getPersistence().update(documentUploadFile, serviceContext);
	}

	/**
	* Caches the document upload file in the entity cache if it is enabled.
	*
	* @param documentUploadFile the document upload file
	*/
	public static void cacheResult(DocumentUploadFile documentUploadFile) {
		getPersistence().cacheResult(documentUploadFile);
	}

	/**
	* Caches the document upload files in the entity cache if it is enabled.
	*
	* @param documentUploadFiles the document upload files
	*/
	public static void cacheResult(List<DocumentUploadFile> documentUploadFiles) {
		getPersistence().cacheResult(documentUploadFiles);
	}

	/**
	* Creates a new document upload file with the primary key. Does not add the document upload file to the database.
	*
	* @param documentId the primary key for the new document upload file
	* @return the new document upload file
	*/
	public static DocumentUploadFile create(long documentId) {
		return getPersistence().create(documentId);
	}

	/**
	* Removes the document upload file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the document upload file
	* @return the document upload file that was removed
	* @throws NoSuchDocumentUploadFileException if a document upload file with the primary key could not be found
	*/
	public static DocumentUploadFile remove(long documentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchDocumentUploadFileException {
		return getPersistence().remove(documentId);
	}

	public static DocumentUploadFile updateImpl(
		DocumentUploadFile documentUploadFile) {
		return getPersistence().updateImpl(documentUploadFile);
	}

	/**
	* Returns the document upload file with the primary key or throws a {@link NoSuchDocumentUploadFileException} if it could not be found.
	*
	* @param documentId the primary key of the document upload file
	* @return the document upload file
	* @throws NoSuchDocumentUploadFileException if a document upload file with the primary key could not be found
	*/
	public static DocumentUploadFile findByPrimaryKey(long documentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchDocumentUploadFileException {
		return getPersistence().findByPrimaryKey(documentId);
	}

	/**
	* Returns the document upload file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param documentId the primary key of the document upload file
	* @return the document upload file, or <code>null</code> if a document upload file with the primary key could not be found
	*/
	public static DocumentUploadFile fetchByPrimaryKey(long documentId) {
		return getPersistence().fetchByPrimaryKey(documentId);
	}

	public static java.util.Map<java.io.Serializable, DocumentUploadFile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the document upload files.
	*
	* @return the document upload files
	*/
	public static List<DocumentUploadFile> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the document upload files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document upload files
	* @param end the upper bound of the range of document upload files (not inclusive)
	* @return the range of document upload files
	*/
	public static List<DocumentUploadFile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the document upload files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document upload files
	* @param end the upper bound of the range of document upload files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of document upload files
	*/
	public static List<DocumentUploadFile> findAll(int start, int end,
		OrderByComparator<DocumentUploadFile> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the document upload files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document upload files
	* @param end the upper bound of the range of document upload files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of document upload files
	*/
	public static List<DocumentUploadFile> findAll(int start, int end,
		OrderByComparator<DocumentUploadFile> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the document upload files from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of document upload files.
	*
	* @return the number of document upload files
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocumentUploadFilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DocumentUploadFilePersistence, DocumentUploadFilePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DocumentUploadFilePersistence.class);

		ServiceTracker<DocumentUploadFilePersistence, DocumentUploadFilePersistence> serviceTracker =
			new ServiceTracker<DocumentUploadFilePersistence, DocumentUploadFilePersistence>(bundle.getBundleContext(),
				DocumentUploadFilePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}