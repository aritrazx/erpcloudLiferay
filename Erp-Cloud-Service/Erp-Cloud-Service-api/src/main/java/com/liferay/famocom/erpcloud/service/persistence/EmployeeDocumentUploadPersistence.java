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

import com.liferay.famocom.erpcloud.exception.NoSuchEmployeeDocumentUploadException;
import com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the employee document upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EmployeeDocumentUploadPersistenceImpl
 * @see EmployeeDocumentUploadUtil
 * @generated
 */
@ProviderType
public interface EmployeeDocumentUploadPersistence extends BasePersistence<EmployeeDocumentUpload> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDocumentUploadUtil} to access the employee document upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the employee document upload in the entity cache if it is enabled.
	*
	* @param employeeDocumentUpload the employee document upload
	*/
	public void cacheResult(EmployeeDocumentUpload employeeDocumentUpload);

	/**
	* Caches the employee document uploads in the entity cache if it is enabled.
	*
	* @param employeeDocumentUploads the employee document uploads
	*/
	public void cacheResult(
		java.util.List<EmployeeDocumentUpload> employeeDocumentUploads);

	/**
	* Creates a new employee document upload with the primary key. Does not add the employee document upload to the database.
	*
	* @param empDocumentId the primary key for the new employee document upload
	* @return the new employee document upload
	*/
	public EmployeeDocumentUpload create(long empDocumentId);

	/**
	* Removes the employee document upload with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empDocumentId the primary key of the employee document upload
	* @return the employee document upload that was removed
	* @throws NoSuchEmployeeDocumentUploadException if a employee document upload with the primary key could not be found
	*/
	public EmployeeDocumentUpload remove(long empDocumentId)
		throws NoSuchEmployeeDocumentUploadException;

	public EmployeeDocumentUpload updateImpl(
		EmployeeDocumentUpload employeeDocumentUpload);

	/**
	* Returns the employee document upload with the primary key or throws a {@link NoSuchEmployeeDocumentUploadException} if it could not be found.
	*
	* @param empDocumentId the primary key of the employee document upload
	* @return the employee document upload
	* @throws NoSuchEmployeeDocumentUploadException if a employee document upload with the primary key could not be found
	*/
	public EmployeeDocumentUpload findByPrimaryKey(long empDocumentId)
		throws NoSuchEmployeeDocumentUploadException;

	/**
	* Returns the employee document upload with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empDocumentId the primary key of the employee document upload
	* @return the employee document upload, or <code>null</code> if a employee document upload with the primary key could not be found
	*/
	public EmployeeDocumentUpload fetchByPrimaryKey(long empDocumentId);

	@Override
	public java.util.Map<java.io.Serializable, EmployeeDocumentUpload> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the employee document uploads.
	*
	* @return the employee document uploads
	*/
	public java.util.List<EmployeeDocumentUpload> findAll();

	/**
	* Returns a range of all the employee document uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee document uploads
	* @param end the upper bound of the range of employee document uploads (not inclusive)
	* @return the range of employee document uploads
	*/
	public java.util.List<EmployeeDocumentUpload> findAll(int start, int end);

	/**
	* Returns an ordered range of all the employee document uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee document uploads
	* @param end the upper bound of the range of employee document uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employee document uploads
	*/
	public java.util.List<EmployeeDocumentUpload> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocumentUpload> orderByComparator);

	/**
	* Returns an ordered range of all the employee document uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee document uploads
	* @param end the upper bound of the range of employee document uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of employee document uploads
	*/
	public java.util.List<EmployeeDocumentUpload> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocumentUpload> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the employee document uploads from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of employee document uploads.
	*
	* @return the number of employee document uploads
	*/
	public int countAll();
}