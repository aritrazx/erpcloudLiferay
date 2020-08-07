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
 * Provides a wrapper for {@link FormSixteenErrorFileLocalService}.
 *
 * @author Samaresh
 * @see FormSixteenErrorFileLocalService
 * @generated
 */
@ProviderType
public class FormSixteenErrorFileLocalServiceWrapper
	implements FormSixteenErrorFileLocalService,
		ServiceWrapper<FormSixteenErrorFileLocalService> {
	public FormSixteenErrorFileLocalServiceWrapper(
		FormSixteenErrorFileLocalService formSixteenErrorFileLocalService) {
		_formSixteenErrorFileLocalService = formSixteenErrorFileLocalService;
	}

	/**
	* Adds the form sixteen error file to the database. Also notifies the appropriate model listeners.
	*
	* @param formSixteenErrorFile the form sixteen error file
	* @return the form sixteen error file that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteenErrorFile addFormSixteenErrorFile(
		com.liferay.famocom.erpcloud.model.FormSixteenErrorFile formSixteenErrorFile) {
		return _formSixteenErrorFileLocalService.addFormSixteenErrorFile(formSixteenErrorFile);
	}

	/**
	* Creates a new form sixteen error file with the primary key. Does not add the form sixteen error file to the database.
	*
	* @param errorId the primary key for the new form sixteen error file
	* @return the new form sixteen error file
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteenErrorFile createFormSixteenErrorFile(
		long errorId) {
		return _formSixteenErrorFileLocalService.createFormSixteenErrorFile(errorId);
	}

	/**
	* Deletes the form sixteen error file from the database. Also notifies the appropriate model listeners.
	*
	* @param formSixteenErrorFile the form sixteen error file
	* @return the form sixteen error file that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteenErrorFile deleteFormSixteenErrorFile(
		com.liferay.famocom.erpcloud.model.FormSixteenErrorFile formSixteenErrorFile) {
		return _formSixteenErrorFileLocalService.deleteFormSixteenErrorFile(formSixteenErrorFile);
	}

	/**
	* Deletes the form sixteen error file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param errorId the primary key of the form sixteen error file
	* @return the form sixteen error file that was removed
	* @throws PortalException if a form sixteen error file with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteenErrorFile deleteFormSixteenErrorFile(
		long errorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _formSixteenErrorFileLocalService.deleteFormSixteenErrorFile(errorId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _formSixteenErrorFileLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _formSixteenErrorFileLocalService.dynamicQuery();
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
		return _formSixteenErrorFileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.FormSixteenErrorFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _formSixteenErrorFileLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.FormSixteenErrorFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _formSixteenErrorFileLocalService.dynamicQuery(dynamicQuery,
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
		return _formSixteenErrorFileLocalService.dynamicQueryCount(dynamicQuery);
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
		return _formSixteenErrorFileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteenErrorFile fetchFormSixteenErrorFile(
		long errorId) {
		return _formSixteenErrorFileLocalService.fetchFormSixteenErrorFile(errorId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _formSixteenErrorFileLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the form sixteen error file with the primary key.
	*
	* @param errorId the primary key of the form sixteen error file
	* @return the form sixteen error file
	* @throws PortalException if a form sixteen error file with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteenErrorFile getFormSixteenErrorFile(
		long errorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _formSixteenErrorFileLocalService.getFormSixteenErrorFile(errorId);
	}

	/**
	* Returns a range of all the form sixteen error files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.FormSixteenErrorFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form sixteen error files
	* @param end the upper bound of the range of form sixteen error files (not inclusive)
	* @return the range of form sixteen error files
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.FormSixteenErrorFile> getFormSixteenErrorFiles(
		int start, int end) {
		return _formSixteenErrorFileLocalService.getFormSixteenErrorFiles(start,
			end);
	}

	/**
	* Returns the number of form sixteen error files.
	*
	* @return the number of form sixteen error files
	*/
	@Override
	public int getFormSixteenErrorFilesCount() {
		return _formSixteenErrorFileLocalService.getFormSixteenErrorFilesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _formSixteenErrorFileLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _formSixteenErrorFileLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _formSixteenErrorFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the form sixteen error file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param formSixteenErrorFile the form sixteen error file
	* @return the form sixteen error file that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteenErrorFile updateFormSixteenErrorFile(
		com.liferay.famocom.erpcloud.model.FormSixteenErrorFile formSixteenErrorFile) {
		return _formSixteenErrorFileLocalService.updateFormSixteenErrorFile(formSixteenErrorFile);
	}

	@Override
	public FormSixteenErrorFileLocalService getWrappedService() {
		return _formSixteenErrorFileLocalService;
	}

	@Override
	public void setWrappedService(
		FormSixteenErrorFileLocalService formSixteenErrorFileLocalService) {
		_formSixteenErrorFileLocalService = formSixteenErrorFileLocalService;
	}

	private FormSixteenErrorFileLocalService _formSixteenErrorFileLocalService;
}