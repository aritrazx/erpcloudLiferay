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
 * Provides a wrapper for {@link BankMasterLocalService}.
 *
 * @author Samaresh
 * @see BankMasterLocalService
 * @generated
 */
@ProviderType
public class BankMasterLocalServiceWrapper implements BankMasterLocalService,
	ServiceWrapper<BankMasterLocalService> {
	public BankMasterLocalServiceWrapper(
		BankMasterLocalService bankMasterLocalService) {
		_bankMasterLocalService = bankMasterLocalService;
	}

	/**
	* Adds the bank master to the database. Also notifies the appropriate model listeners.
	*
	* @param bankMaster the bank master
	* @return the bank master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BankMaster addBankMaster(
		com.liferay.famocom.erpcloud.model.BankMaster bankMaster) {
		return _bankMasterLocalService.addBankMaster(bankMaster);
	}

	/**
	* Creates a new bank master with the primary key. Does not add the bank master to the database.
	*
	* @param bankId the primary key for the new bank master
	* @return the new bank master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BankMaster createBankMaster(
		long bankId) {
		return _bankMasterLocalService.createBankMaster(bankId);
	}

	/**
	* Deletes the bank master from the database. Also notifies the appropriate model listeners.
	*
	* @param bankMaster the bank master
	* @return the bank master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BankMaster deleteBankMaster(
		com.liferay.famocom.erpcloud.model.BankMaster bankMaster) {
		return _bankMasterLocalService.deleteBankMaster(bankMaster);
	}

	/**
	* Deletes the bank master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bankId the primary key of the bank master
	* @return the bank master that was removed
	* @throws PortalException if a bank master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BankMaster deleteBankMaster(
		long bankId) throws com.liferay.portal.kernel.exception.PortalException {
		return _bankMasterLocalService.deleteBankMaster(bankId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bankMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bankMasterLocalService.dynamicQuery();
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
		return _bankMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bankMasterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bankMasterLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _bankMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _bankMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.BankMaster fetchBankMaster(
		long bankId) {
		return _bankMasterLocalService.fetchBankMaster(bankId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _bankMasterLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the bank master with the primary key.
	*
	* @param bankId the primary key of the bank master
	* @return the bank master
	* @throws PortalException if a bank master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BankMaster getBankMaster(
		long bankId) throws com.liferay.portal.kernel.exception.PortalException {
		return _bankMasterLocalService.getBankMaster(bankId);
	}

	/**
	* Returns a range of all the bank masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bank masters
	* @param end the upper bound of the range of bank masters (not inclusive)
	* @return the range of bank masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.BankMaster> getBankMasters(
		int start, int end) {
		return _bankMasterLocalService.getBankMasters(start, end);
	}

	/**
	* Returns the number of bank masters.
	*
	* @return the number of bank masters
	*/
	@Override
	public int getBankMastersCount() {
		return _bankMasterLocalService.getBankMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _bankMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _bankMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bankMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the bank master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bankMaster the bank master
	* @return the bank master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BankMaster updateBankMaster(
		com.liferay.famocom.erpcloud.model.BankMaster bankMaster) {
		return _bankMasterLocalService.updateBankMaster(bankMaster);
	}

	@Override
	public BankMasterLocalService getWrappedService() {
		return _bankMasterLocalService;
	}

	@Override
	public void setWrappedService(BankMasterLocalService bankMasterLocalService) {
		_bankMasterLocalService = bankMasterLocalService;
	}

	private BankMasterLocalService _bankMasterLocalService;
}