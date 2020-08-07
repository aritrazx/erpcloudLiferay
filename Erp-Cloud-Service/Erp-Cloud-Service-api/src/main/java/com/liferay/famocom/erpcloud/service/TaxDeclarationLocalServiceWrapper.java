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
 * Provides a wrapper for {@link TaxDeclarationLocalService}.
 *
 * @author Samaresh
 * @see TaxDeclarationLocalService
 * @generated
 */
@ProviderType
public class TaxDeclarationLocalServiceWrapper
	implements TaxDeclarationLocalService,
		ServiceWrapper<TaxDeclarationLocalService> {
	public TaxDeclarationLocalServiceWrapper(
		TaxDeclarationLocalService taxDeclarationLocalService) {
		_taxDeclarationLocalService = taxDeclarationLocalService;
	}

	/**
	* Adds the tax declaration to the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclaration the tax declaration
	* @return the tax declaration that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxDeclaration addTaxDeclaration(
		com.liferay.famocom.erpcloud.model.TaxDeclaration taxDeclaration) {
		return _taxDeclarationLocalService.addTaxDeclaration(taxDeclaration);
	}

	/**
	* Creates a new tax declaration with the primary key. Does not add the tax declaration to the database.
	*
	* @param taxDeclarationId the primary key for the new tax declaration
	* @return the new tax declaration
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxDeclaration createTaxDeclaration(
		long taxDeclarationId) {
		return _taxDeclarationLocalService.createTaxDeclaration(taxDeclarationId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taxDeclarationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tax declaration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclarationId the primary key of the tax declaration
	* @return the tax declaration that was removed
	* @throws PortalException if a tax declaration with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxDeclaration deleteTaxDeclaration(
		long taxDeclarationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taxDeclarationLocalService.deleteTaxDeclaration(taxDeclarationId);
	}

	/**
	* Deletes the tax declaration from the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclaration the tax declaration
	* @return the tax declaration that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxDeclaration deleteTaxDeclaration(
		com.liferay.famocom.erpcloud.model.TaxDeclaration taxDeclaration) {
		return _taxDeclarationLocalService.deleteTaxDeclaration(taxDeclaration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taxDeclarationLocalService.dynamicQuery();
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
		return _taxDeclarationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taxDeclarationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taxDeclarationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _taxDeclarationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _taxDeclarationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.TaxDeclaration fetchTaxDeclaration(
		long taxDeclarationId) {
		return _taxDeclarationLocalService.fetchTaxDeclaration(taxDeclarationId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.TaxDeclaration findByemployeeIdAndFinancialYear(
		long employeeId, String financialYear) {
		return _taxDeclarationLocalService.findByemployeeIdAndFinancialYear(employeeId,
			financialYear);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _taxDeclarationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _taxDeclarationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _taxDeclarationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taxDeclarationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tax declaration with the primary key.
	*
	* @param taxDeclarationId the primary key of the tax declaration
	* @return the tax declaration
	* @throws PortalException if a tax declaration with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxDeclaration getTaxDeclaration(
		long taxDeclarationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taxDeclarationLocalService.getTaxDeclaration(taxDeclarationId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.TaxDeclaration getTaxDeclarationByEmployeeId(
		long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException {
		return _taxDeclarationLocalService.getTaxDeclarationByEmployeeId(employeeId);
	}

	/**
	* Returns a range of all the tax declarations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declarations
	* @param end the upper bound of the range of tax declarations (not inclusive)
	* @return the range of tax declarations
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.TaxDeclaration> getTaxDeclarations(
		int start, int end) {
		return _taxDeclarationLocalService.getTaxDeclarations(start, end);
	}

	/**
	* Returns the number of tax declarations.
	*
	* @return the number of tax declarations
	*/
	@Override
	public int getTaxDeclarationsCount() {
		return _taxDeclarationLocalService.getTaxDeclarationsCount();
	}

	/**
	* Updates the tax declaration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taxDeclaration the tax declaration
	* @return the tax declaration that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxDeclaration updateTaxDeclaration(
		com.liferay.famocom.erpcloud.model.TaxDeclaration taxDeclaration) {
		return _taxDeclarationLocalService.updateTaxDeclaration(taxDeclaration);
	}

	@Override
	public TaxDeclarationLocalService getWrappedService() {
		return _taxDeclarationLocalService;
	}

	@Override
	public void setWrappedService(
		TaxDeclarationLocalService taxDeclarationLocalService) {
		_taxDeclarationLocalService = taxDeclarationLocalService;
	}

	private TaxDeclarationLocalService _taxDeclarationLocalService;
}