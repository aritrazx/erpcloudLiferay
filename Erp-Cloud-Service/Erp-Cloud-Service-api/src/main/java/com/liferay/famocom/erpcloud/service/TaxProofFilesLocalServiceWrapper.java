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
 * Provides a wrapper for {@link TaxProofFilesLocalService}.
 *
 * @author Samaresh
 * @see TaxProofFilesLocalService
 * @generated
 */
@ProviderType
public class TaxProofFilesLocalServiceWrapper
	implements TaxProofFilesLocalService,
		ServiceWrapper<TaxProofFilesLocalService> {
	public TaxProofFilesLocalServiceWrapper(
		TaxProofFilesLocalService taxProofFilesLocalService) {
		_taxProofFilesLocalService = taxProofFilesLocalService;
	}

	/**
	* Adds the tax proof files to the database. Also notifies the appropriate model listeners.
	*
	* @param taxProofFiles the tax proof files
	* @return the tax proof files that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxProofFiles addTaxProofFiles(
		com.liferay.famocom.erpcloud.model.TaxProofFiles taxProofFiles) {
		return _taxProofFilesLocalService.addTaxProofFiles(taxProofFiles);
	}

	/**
	* Creates a new tax proof files with the primary key. Does not add the tax proof files to the database.
	*
	* @param fileId the primary key for the new tax proof files
	* @return the new tax proof files
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxProofFiles createTaxProofFiles(
		long fileId) {
		return _taxProofFilesLocalService.createTaxProofFiles(fileId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taxProofFilesLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tax proof files with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileId the primary key of the tax proof files
	* @return the tax proof files that was removed
	* @throws PortalException if a tax proof files with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxProofFiles deleteTaxProofFiles(
		long fileId) throws com.liferay.portal.kernel.exception.PortalException {
		return _taxProofFilesLocalService.deleteTaxProofFiles(fileId);
	}

	/**
	* Deletes the tax proof files from the database. Also notifies the appropriate model listeners.
	*
	* @param taxProofFiles the tax proof files
	* @return the tax proof files that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxProofFiles deleteTaxProofFiles(
		com.liferay.famocom.erpcloud.model.TaxProofFiles taxProofFiles) {
		return _taxProofFilesLocalService.deleteTaxProofFiles(taxProofFiles);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taxProofFilesLocalService.dynamicQuery();
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
		return _taxProofFilesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taxProofFilesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taxProofFilesLocalService.dynamicQuery(dynamicQuery, start,
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
		return _taxProofFilesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _taxProofFilesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.TaxProofFiles fetchTaxProofFiles(
		long fileId) {
		return _taxProofFilesLocalService.fetchTaxProofFiles(fileId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _taxProofFilesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _taxProofFilesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _taxProofFilesLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taxProofFilesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tax proof files with the primary key.
	*
	* @param fileId the primary key of the tax proof files
	* @return the tax proof files
	* @throws PortalException if a tax proof files with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxProofFiles getTaxProofFiles(
		long fileId) throws com.liferay.portal.kernel.exception.PortalException {
		return _taxProofFilesLocalService.getTaxProofFiles(fileId);
	}

	/**
	* Returns a range of all the tax proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TaxProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax proof fileses
	* @param end the upper bound of the range of tax proof fileses (not inclusive)
	* @return the range of tax proof fileses
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.TaxProofFiles> getTaxProofFileses(
		int start, int end) {
		return _taxProofFilesLocalService.getTaxProofFileses(start, end);
	}

	/**
	* Returns the number of tax proof fileses.
	*
	* @return the number of tax proof fileses
	*/
	@Override
	public int getTaxProofFilesesCount() {
		return _taxProofFilesLocalService.getTaxProofFilesesCount();
	}

	/**
	* Updates the tax proof files in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taxProofFiles the tax proof files
	* @return the tax proof files that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TaxProofFiles updateTaxProofFiles(
		com.liferay.famocom.erpcloud.model.TaxProofFiles taxProofFiles) {
		return _taxProofFilesLocalService.updateTaxProofFiles(taxProofFiles);
	}

	@Override
	public TaxProofFilesLocalService getWrappedService() {
		return _taxProofFilesLocalService;
	}

	@Override
	public void setWrappedService(
		TaxProofFilesLocalService taxProofFilesLocalService) {
		_taxProofFilesLocalService = taxProofFilesLocalService;
	}

	private TaxProofFilesLocalService _taxProofFilesLocalService;
}