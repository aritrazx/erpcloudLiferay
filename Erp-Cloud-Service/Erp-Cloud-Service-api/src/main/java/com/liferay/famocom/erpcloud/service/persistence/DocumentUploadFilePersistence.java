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

import com.liferay.famocom.erpcloud.exception.NoSuchDocumentUploadFileException;
import com.liferay.famocom.erpcloud.model.DocumentUploadFile;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the document upload file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.DocumentUploadFilePersistenceImpl
 * @see DocumentUploadFileUtil
 * @generated
 */
@ProviderType
public interface DocumentUploadFilePersistence extends BasePersistence<DocumentUploadFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentUploadFileUtil} to access the document upload file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the document upload file in the entity cache if it is enabled.
	*
	* @param documentUploadFile the document upload file
	*/
	public void cacheResult(DocumentUploadFile documentUploadFile);

	/**
	* Caches the document upload files in the entity cache if it is enabled.
	*
	* @param documentUploadFiles the document upload files
	*/
	public void cacheResult(
		java.util.List<DocumentUploadFile> documentUploadFiles);

	/**
	* Creates a new document upload file with the primary key. Does not add the document upload file to the database.
	*
	* @param documentId the primary key for the new document upload file
	* @return the new document upload file
	*/
	public DocumentUploadFile create(long documentId);

	/**
	* Removes the document upload file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the document upload file
	* @return the document upload file that was removed
	* @throws NoSuchDocumentUploadFileException if a document upload file with the primary key could not be found
	*/
	public DocumentUploadFile remove(long documentId)
		throws NoSuchDocumentUploadFileException;

	public DocumentUploadFile updateImpl(DocumentUploadFile documentUploadFile);

	/**
	* Returns the document upload file with the primary key or throws a {@link NoSuchDocumentUploadFileException} if it could not be found.
	*
	* @param documentId the primary key of the document upload file
	* @return the document upload file
	* @throws NoSuchDocumentUploadFileException if a document upload file with the primary key could not be found
	*/
	public DocumentUploadFile findByPrimaryKey(long documentId)
		throws NoSuchDocumentUploadFileException;

	/**
	* Returns the document upload file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param documentId the primary key of the document upload file
	* @return the document upload file, or <code>null</code> if a document upload file with the primary key could not be found
	*/
	public DocumentUploadFile fetchByPrimaryKey(long documentId);

	@Override
	public java.util.Map<java.io.Serializable, DocumentUploadFile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the document upload files.
	*
	* @return the document upload files
	*/
	public java.util.List<DocumentUploadFile> findAll();

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
	public java.util.List<DocumentUploadFile> findAll(int start, int end);

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
	public java.util.List<DocumentUploadFile> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentUploadFile> orderByComparator);

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
	public java.util.List<DocumentUploadFile> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentUploadFile> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the document upload files from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of document upload files.
	*
	* @return the number of document upload files
	*/
	public int countAll();
}