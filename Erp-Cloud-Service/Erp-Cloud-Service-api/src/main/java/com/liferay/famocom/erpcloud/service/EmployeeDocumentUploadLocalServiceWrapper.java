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
 * Provides a wrapper for {@link EmployeeDocumentUploadLocalService}.
 *
 * @author Samaresh
 * @see EmployeeDocumentUploadLocalService
 * @generated
 */
@ProviderType
public class EmployeeDocumentUploadLocalServiceWrapper
	implements EmployeeDocumentUploadLocalService,
		ServiceWrapper<EmployeeDocumentUploadLocalService> {
	public EmployeeDocumentUploadLocalServiceWrapper(
		EmployeeDocumentUploadLocalService employeeDocumentUploadLocalService) {
		_employeeDocumentUploadLocalService = employeeDocumentUploadLocalService;
	}

	/**
	* Adds the employee document upload to the database. Also notifies the appropriate model listeners.
	*
	* @param employeeDocumentUpload the employee document upload
	* @return the employee document upload that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload addEmployeeDocumentUpload(
		com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload employeeDocumentUpload) {
		return _employeeDocumentUploadLocalService.addEmployeeDocumentUpload(employeeDocumentUpload);
	}

	/**
	* Creates a new employee document upload with the primary key. Does not add the employee document upload to the database.
	*
	* @param empDocumentId the primary key for the new employee document upload
	* @return the new employee document upload
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload createEmployeeDocumentUpload(
		long empDocumentId) {
		return _employeeDocumentUploadLocalService.createEmployeeDocumentUpload(empDocumentId);
	}

	/**
	* Deletes the employee document upload from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeDocumentUpload the employee document upload
	* @return the employee document upload that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload deleteEmployeeDocumentUpload(
		com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload employeeDocumentUpload) {
		return _employeeDocumentUploadLocalService.deleteEmployeeDocumentUpload(employeeDocumentUpload);
	}

	/**
	* Deletes the employee document upload with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empDocumentId the primary key of the employee document upload
	* @return the employee document upload that was removed
	* @throws PortalException if a employee document upload with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload deleteEmployeeDocumentUpload(
		long empDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDocumentUploadLocalService.deleteEmployeeDocumentUpload(empDocumentId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDocumentUploadLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDocumentUploadLocalService.dynamicQuery();
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
		return _employeeDocumentUploadLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _employeeDocumentUploadLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _employeeDocumentUploadLocalService.dynamicQuery(dynamicQuery,
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
		return _employeeDocumentUploadLocalService.dynamicQueryCount(dynamicQuery);
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
		return _employeeDocumentUploadLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload fetchEmployeeDocumentUpload(
		long empDocumentId) {
		return _employeeDocumentUploadLocalService.fetchEmployeeDocumentUpload(empDocumentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _employeeDocumentUploadLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the employee document upload with the primary key.
	*
	* @param empDocumentId the primary key of the employee document upload
	* @return the employee document upload
	* @throws PortalException if a employee document upload with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload getEmployeeDocumentUpload(
		long empDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDocumentUploadLocalService.getEmployeeDocumentUpload(empDocumentId);
	}

	/**
	* Returns a range of all the employee document uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee document uploads
	* @param end the upper bound of the range of employee document uploads (not inclusive)
	* @return the range of employee document uploads
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload> getEmployeeDocumentUploads(
		int start, int end) {
		return _employeeDocumentUploadLocalService.getEmployeeDocumentUploads(start,
			end);
	}

	/**
	* Returns the number of employee document uploads.
	*
	* @return the number of employee document uploads
	*/
	@Override
	public int getEmployeeDocumentUploadsCount() {
		return _employeeDocumentUploadLocalService.getEmployeeDocumentUploadsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _employeeDocumentUploadLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDocumentUploadLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDocumentUploadLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the employee document upload in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employeeDocumentUpload the employee document upload
	* @return the employee document upload that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload updateEmployeeDocumentUpload(
		com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload employeeDocumentUpload) {
		return _employeeDocumentUploadLocalService.updateEmployeeDocumentUpload(employeeDocumentUpload);
	}

	@Override
	public EmployeeDocumentUploadLocalService getWrappedService() {
		return _employeeDocumentUploadLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDocumentUploadLocalService employeeDocumentUploadLocalService) {
		_employeeDocumentUploadLocalService = employeeDocumentUploadLocalService;
	}

	private EmployeeDocumentUploadLocalService _employeeDocumentUploadLocalService;
}