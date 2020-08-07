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
 * Provides a wrapper for {@link ClientMasterLocalService}.
 *
 * @author Samaresh
 * @see ClientMasterLocalService
 * @generated
 */
@ProviderType
public class ClientMasterLocalServiceWrapper implements ClientMasterLocalService,
	ServiceWrapper<ClientMasterLocalService> {
	public ClientMasterLocalServiceWrapper(
		ClientMasterLocalService clientMasterLocalService) {
		_clientMasterLocalService = clientMasterLocalService;
	}

	/**
	* Adds the client master to the database. Also notifies the appropriate model listeners.
	*
	* @param clientMaster the client master
	* @return the client master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ClientMaster addClientMaster(
		com.liferay.famocom.erpcloud.model.ClientMaster clientMaster) {
		return _clientMasterLocalService.addClientMaster(clientMaster);
	}

	/**
	* Creates a new client master with the primary key. Does not add the client master to the database.
	*
	* @param clientId the primary key for the new client master
	* @return the new client master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ClientMaster createClientMaster(
		long clientId) {
		return _clientMasterLocalService.createClientMaster(clientId);
	}

	/**
	* Deletes the client master from the database. Also notifies the appropriate model listeners.
	*
	* @param clientMaster the client master
	* @return the client master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ClientMaster deleteClientMaster(
		com.liferay.famocom.erpcloud.model.ClientMaster clientMaster) {
		return _clientMasterLocalService.deleteClientMaster(clientMaster);
	}

	/**
	* Deletes the client master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clientId the primary key of the client master
	* @return the client master that was removed
	* @throws PortalException if a client master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ClientMaster deleteClientMaster(
		long clientId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _clientMasterLocalService.deleteClientMaster(clientId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _clientMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clientMasterLocalService.dynamicQuery();
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
		return _clientMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _clientMasterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _clientMasterLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _clientMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _clientMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.ClientMaster fetchClientMaster(
		long clientId) {
		return _clientMasterLocalService.fetchClientMaster(clientId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _clientMasterLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the client master with the primary key.
	*
	* @param clientId the primary key of the client master
	* @return the client master
	* @throws PortalException if a client master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ClientMaster getClientMaster(
		long clientId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _clientMasterLocalService.getClientMaster(clientId);
	}

	/**
	* Returns a range of all the client masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of client masters
	* @param end the upper bound of the range of client masters (not inclusive)
	* @return the range of client masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ClientMaster> getClientMasters(
		int start, int end) {
		return _clientMasterLocalService.getClientMasters(start, end);
	}

	/**
	* Returns the number of client masters.
	*
	* @return the number of client masters
	*/
	@Override
	public int getClientMastersCount() {
		return _clientMasterLocalService.getClientMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _clientMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _clientMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _clientMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the client master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param clientMaster the client master
	* @return the client master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ClientMaster updateClientMaster(
		com.liferay.famocom.erpcloud.model.ClientMaster clientMaster) {
		return _clientMasterLocalService.updateClientMaster(clientMaster);
	}

	@Override
	public ClientMasterLocalService getWrappedService() {
		return _clientMasterLocalService;
	}

	@Override
	public void setWrappedService(
		ClientMasterLocalService clientMasterLocalService) {
		_clientMasterLocalService = clientMasterLocalService;
	}

	private ClientMasterLocalService _clientMasterLocalService;
}