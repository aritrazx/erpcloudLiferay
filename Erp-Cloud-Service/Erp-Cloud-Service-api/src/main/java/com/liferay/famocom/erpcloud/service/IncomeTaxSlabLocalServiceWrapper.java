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
 * Provides a wrapper for {@link IncomeTaxSlabLocalService}.
 *
 * @author Samaresh
 * @see IncomeTaxSlabLocalService
 * @generated
 */
@ProviderType
public class IncomeTaxSlabLocalServiceWrapper
	implements IncomeTaxSlabLocalService,
		ServiceWrapper<IncomeTaxSlabLocalService> {
	public IncomeTaxSlabLocalServiceWrapper(
		IncomeTaxSlabLocalService incomeTaxSlabLocalService) {
		_incomeTaxSlabLocalService = incomeTaxSlabLocalService;
	}

	/**
	* Adds the income tax slab to the database. Also notifies the appropriate model listeners.
	*
	* @param incomeTaxSlab the income tax slab
	* @return the income tax slab that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.IncomeTaxSlab addIncomeTaxSlab(
		com.liferay.famocom.erpcloud.model.IncomeTaxSlab incomeTaxSlab) {
		return _incomeTaxSlabLocalService.addIncomeTaxSlab(incomeTaxSlab);
	}

	/**
	* Creates a new income tax slab with the primary key. Does not add the income tax slab to the database.
	*
	* @param incomeTaxSlabId the primary key for the new income tax slab
	* @return the new income tax slab
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.IncomeTaxSlab createIncomeTaxSlab(
		long incomeTaxSlabId) {
		return _incomeTaxSlabLocalService.createIncomeTaxSlab(incomeTaxSlabId);
	}

	/**
	* Deletes the income tax slab from the database. Also notifies the appropriate model listeners.
	*
	* @param incomeTaxSlab the income tax slab
	* @return the income tax slab that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.IncomeTaxSlab deleteIncomeTaxSlab(
		com.liferay.famocom.erpcloud.model.IncomeTaxSlab incomeTaxSlab) {
		return _incomeTaxSlabLocalService.deleteIncomeTaxSlab(incomeTaxSlab);
	}

	/**
	* Deletes the income tax slab with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param incomeTaxSlabId the primary key of the income tax slab
	* @return the income tax slab that was removed
	* @throws PortalException if a income tax slab with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.IncomeTaxSlab deleteIncomeTaxSlab(
		long incomeTaxSlabId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _incomeTaxSlabLocalService.deleteIncomeTaxSlab(incomeTaxSlabId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _incomeTaxSlabLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _incomeTaxSlabLocalService.dynamicQuery();
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
		return _incomeTaxSlabLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.IncomeTaxSlabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _incomeTaxSlabLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.IncomeTaxSlabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _incomeTaxSlabLocalService.dynamicQuery(dynamicQuery, start,
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
		return _incomeTaxSlabLocalService.dynamicQueryCount(dynamicQuery);
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
		return _incomeTaxSlabLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.IncomeTaxSlab fetchIncomeTaxSlab(
		long incomeTaxSlabId) {
		return _incomeTaxSlabLocalService.fetchIncomeTaxSlab(incomeTaxSlabId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _incomeTaxSlabLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the income tax slab with the primary key.
	*
	* @param incomeTaxSlabId the primary key of the income tax slab
	* @return the income tax slab
	* @throws PortalException if a income tax slab with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.IncomeTaxSlab getIncomeTaxSlab(
		long incomeTaxSlabId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _incomeTaxSlabLocalService.getIncomeTaxSlab(incomeTaxSlabId);
	}

	/**
	* Returns a range of all the income tax slabs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.IncomeTaxSlabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of income tax slabs
	* @param end the upper bound of the range of income tax slabs (not inclusive)
	* @return the range of income tax slabs
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.IncomeTaxSlab> getIncomeTaxSlabs(
		int start, int end) {
		return _incomeTaxSlabLocalService.getIncomeTaxSlabs(start, end);
	}

	/**
	* Returns the number of income tax slabs.
	*
	* @return the number of income tax slabs
	*/
	@Override
	public int getIncomeTaxSlabsCount() {
		return _incomeTaxSlabLocalService.getIncomeTaxSlabsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _incomeTaxSlabLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _incomeTaxSlabLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _incomeTaxSlabLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the income tax slab in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param incomeTaxSlab the income tax slab
	* @return the income tax slab that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.IncomeTaxSlab updateIncomeTaxSlab(
		com.liferay.famocom.erpcloud.model.IncomeTaxSlab incomeTaxSlab) {
		return _incomeTaxSlabLocalService.updateIncomeTaxSlab(incomeTaxSlab);
	}

	@Override
	public IncomeTaxSlabLocalService getWrappedService() {
		return _incomeTaxSlabLocalService;
	}

	@Override
	public void setWrappedService(
		IncomeTaxSlabLocalService incomeTaxSlabLocalService) {
		_incomeTaxSlabLocalService = incomeTaxSlabLocalService;
	}

	private IncomeTaxSlabLocalService _incomeTaxSlabLocalService;
}