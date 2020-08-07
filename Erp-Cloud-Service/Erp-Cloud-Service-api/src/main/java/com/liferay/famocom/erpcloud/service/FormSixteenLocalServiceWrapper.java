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
 * Provides a wrapper for {@link FormSixteenLocalService}.
 *
 * @author Samaresh
 * @see FormSixteenLocalService
 * @generated
 */
@ProviderType
public class FormSixteenLocalServiceWrapper implements FormSixteenLocalService,
	ServiceWrapper<FormSixteenLocalService> {
	public FormSixteenLocalServiceWrapper(
		FormSixteenLocalService formSixteenLocalService) {
		_formSixteenLocalService = formSixteenLocalService;
	}

	/**
	* Adds the form sixteen to the database. Also notifies the appropriate model listeners.
	*
	* @param formSixteen the form sixteen
	* @return the form sixteen that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteen addFormSixteen(
		com.liferay.famocom.erpcloud.model.FormSixteen formSixteen) {
		return _formSixteenLocalService.addFormSixteen(formSixteen);
	}

	/**
	* Creates a new form sixteen with the primary key. Does not add the form sixteen to the database.
	*
	* @param id the primary key for the new form sixteen
	* @return the new form sixteen
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteen createFormSixteen(
		long id) {
		return _formSixteenLocalService.createFormSixteen(id);
	}

	/**
	* Deletes the form sixteen from the database. Also notifies the appropriate model listeners.
	*
	* @param formSixteen the form sixteen
	* @return the form sixteen that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteen deleteFormSixteen(
		com.liferay.famocom.erpcloud.model.FormSixteen formSixteen) {
		return _formSixteenLocalService.deleteFormSixteen(formSixteen);
	}

	/**
	* Deletes the form sixteen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the form sixteen
	* @return the form sixteen that was removed
	* @throws PortalException if a form sixteen with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteen deleteFormSixteen(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _formSixteenLocalService.deleteFormSixteen(id);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _formSixteenLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _formSixteenLocalService.dynamicQuery();
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
		return _formSixteenLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _formSixteenLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _formSixteenLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _formSixteenLocalService.dynamicQueryCount(dynamicQuery);
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
		return _formSixteenLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteen fetchFormSixteen(
		long id) {
		return _formSixteenLocalService.fetchFormSixteen(id);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.FormSixteen> findBygetForm(
		long employeeId, String financialYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formSixteenLocalService.findBygetForm(employeeId, financialYear);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _formSixteenLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the form sixteen with the primary key.
	*
	* @param id the primary key of the form sixteen
	* @return the form sixteen
	* @throws PortalException if a form sixteen with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteen getFormSixteen(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _formSixteenLocalService.getFormSixteen(id);
	}

	/**
	* Returns a range of all the form sixteens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form sixteens
	* @param end the upper bound of the range of form sixteens (not inclusive)
	* @return the range of form sixteens
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.FormSixteen> getFormSixteens(
		int start, int end) {
		return _formSixteenLocalService.getFormSixteens(start, end);
	}

	/**
	* Returns the number of form sixteens.
	*
	* @return the number of form sixteens
	*/
	@Override
	public int getFormSixteensCount() {
		return _formSixteenLocalService.getFormSixteensCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _formSixteenLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _formSixteenLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _formSixteenLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the form sixteen in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param formSixteen the form sixteen
	* @return the form sixteen that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FormSixteen updateFormSixteen(
		com.liferay.famocom.erpcloud.model.FormSixteen formSixteen) {
		return _formSixteenLocalService.updateFormSixteen(formSixteen);
	}

	@Override
	public FormSixteenLocalService getWrappedService() {
		return _formSixteenLocalService;
	}

	@Override
	public void setWrappedService(
		FormSixteenLocalService formSixteenLocalService) {
		_formSixteenLocalService = formSixteenLocalService;
	}

	private FormSixteenLocalService _formSixteenLocalService;
}