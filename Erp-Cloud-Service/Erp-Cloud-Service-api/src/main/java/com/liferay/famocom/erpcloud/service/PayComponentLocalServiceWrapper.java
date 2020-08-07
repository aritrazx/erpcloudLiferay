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
 * Provides a wrapper for {@link PayComponentLocalService}.
 *
 * @author Samaresh
 * @see PayComponentLocalService
 * @generated
 */
@ProviderType
public class PayComponentLocalServiceWrapper implements PayComponentLocalService,
	ServiceWrapper<PayComponentLocalService> {
	public PayComponentLocalServiceWrapper(
		PayComponentLocalService payComponentLocalService) {
		_payComponentLocalService = payComponentLocalService;
	}

	/**
	* Adds the pay component to the database. Also notifies the appropriate model listeners.
	*
	* @param payComponent the pay component
	* @return the pay component that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayComponent addPayComponent(
		com.liferay.famocom.erpcloud.model.PayComponent payComponent) {
		return _payComponentLocalService.addPayComponent(payComponent);
	}

	/**
	* Creates a new pay component with the primary key. Does not add the pay component to the database.
	*
	* @param componentId the primary key for the new pay component
	* @return the new pay component
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayComponent createPayComponent(
		long componentId) {
		return _payComponentLocalService.createPayComponent(componentId);
	}

	/**
	* Deletes the pay component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param componentId the primary key of the pay component
	* @return the pay component that was removed
	* @throws PortalException if a pay component with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayComponent deletePayComponent(
		long componentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payComponentLocalService.deletePayComponent(componentId);
	}

	/**
	* Deletes the pay component from the database. Also notifies the appropriate model listeners.
	*
	* @param payComponent the pay component
	* @return the pay component that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayComponent deletePayComponent(
		com.liferay.famocom.erpcloud.model.PayComponent payComponent) {
		return _payComponentLocalService.deletePayComponent(payComponent);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payComponentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _payComponentLocalService.dynamicQuery();
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
		return _payComponentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _payComponentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _payComponentLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _payComponentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _payComponentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.PayComponent fetchPayComponent(
		long componentId) {
		return _payComponentLocalService.fetchPayComponent(componentId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.PayComponent> findByPayType(
		String payType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payComponentLocalService.findByPayType(payType);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.PayComponent> findPayComponentByAbbreviationAndComponentId(
		String abbreviation, long payComponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payComponentLocalService.findPayComponentByAbbreviationAndComponentId(abbreviation,
			payComponentId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.PayComponent> findPayComponentByNameAndComponentId(
		String name, long payComponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payComponentLocalService.findPayComponentByNameAndComponentId(name,
			payComponentId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.PayComponent> findPayComponentByTaxStatusAndPayType(
		int taxStatus, String payType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payComponentLocalService.findPayComponentByTaxStatusAndPayType(taxStatus,
			payType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _payComponentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _payComponentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _payComponentLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Returns the pay component with the primary key.
	*
	* @param componentId the primary key of the pay component
	* @return the pay component
	* @throws PortalException if a pay component with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayComponent getPayComponent(
		long componentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payComponentLocalService.getPayComponent(componentId);
	}

	/**
	* Returns a range of all the pay components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @return the range of pay components
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.PayComponent> getPayComponents(
		int start, int end) {
		return _payComponentLocalService.getPayComponents(start, end);
	}

	/**
	* Returns the number of pay components.
	*
	* @return the number of pay components
	*/
	@Override
	public int getPayComponentsCount() {
		return _payComponentLocalService.getPayComponentsCount();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payComponentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the pay component in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param payComponent the pay component
	* @return the pay component that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayComponent updatePayComponent(
		com.liferay.famocom.erpcloud.model.PayComponent payComponent) {
		return _payComponentLocalService.updatePayComponent(payComponent);
	}

	@Override
	public PayComponentLocalService getWrappedService() {
		return _payComponentLocalService;
	}

	@Override
	public void setWrappedService(
		PayComponentLocalService payComponentLocalService) {
		_payComponentLocalService = payComponentLocalService;
	}

	private PayComponentLocalService _payComponentLocalService;
}