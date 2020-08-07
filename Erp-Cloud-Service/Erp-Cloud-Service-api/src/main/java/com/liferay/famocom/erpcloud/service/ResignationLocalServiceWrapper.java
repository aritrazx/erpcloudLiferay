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
 * Provides a wrapper for {@link ResignationLocalService}.
 *
 * @author Samaresh
 * @see ResignationLocalService
 * @generated
 */
@ProviderType
public class ResignationLocalServiceWrapper implements ResignationLocalService,
	ServiceWrapper<ResignationLocalService> {
	public ResignationLocalServiceWrapper(
		ResignationLocalService resignationLocalService) {
		_resignationLocalService = resignationLocalService;
	}

	/**
	* Adds the resignation to the database. Also notifies the appropriate model listeners.
	*
	* @param resignation the resignation
	* @return the resignation that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Resignation addResignation(
		com.liferay.famocom.erpcloud.model.Resignation resignation) {
		return _resignationLocalService.addResignation(resignation);
	}

	/**
	* Creates a new resignation with the primary key. Does not add the resignation to the database.
	*
	* @param ResignationId the primary key for the new resignation
	* @return the new resignation
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Resignation createResignation(
		long ResignationId) {
		return _resignationLocalService.createResignation(ResignationId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _resignationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the resignation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ResignationId the primary key of the resignation
	* @return the resignation that was removed
	* @throws PortalException if a resignation with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Resignation deleteResignation(
		long ResignationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _resignationLocalService.deleteResignation(ResignationId);
	}

	/**
	* Deletes the resignation from the database. Also notifies the appropriate model listeners.
	*
	* @param resignation the resignation
	* @return the resignation that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Resignation deleteResignation(
		com.liferay.famocom.erpcloud.model.Resignation resignation) {
		return _resignationLocalService.deleteResignation(resignation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _resignationLocalService.dynamicQuery();
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
		return _resignationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ResignationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _resignationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ResignationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _resignationLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _resignationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _resignationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.Resignation fetchResignation(
		long ResignationId) {
		return _resignationLocalService.fetchResignation(ResignationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _resignationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _resignationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _resignationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _resignationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the resignation with the primary key.
	*
	* @param ResignationId the primary key of the resignation
	* @return the resignation
	* @throws PortalException if a resignation with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Resignation getResignation(
		long ResignationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _resignationLocalService.getResignation(ResignationId);
	}

	/**
	* Returns a range of all the resignations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ResignationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of resignations
	* @param end the upper bound of the range of resignations (not inclusive)
	* @return the range of resignations
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.Resignation> getResignations(
		int start, int end) {
		return _resignationLocalService.getResignations(start, end);
	}

	/**
	* Returns the number of resignations.
	*
	* @return the number of resignations
	*/
	@Override
	public int getResignationsCount() {
		return _resignationLocalService.getResignationsCount();
	}

	/**
	* Updates the resignation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resignation the resignation
	* @return the resignation that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Resignation updateResignation(
		com.liferay.famocom.erpcloud.model.Resignation resignation) {
		return _resignationLocalService.updateResignation(resignation);
	}

	@Override
	public ResignationLocalService getWrappedService() {
		return _resignationLocalService;
	}

	@Override
	public void setWrappedService(
		ResignationLocalService resignationLocalService) {
		_resignationLocalService = resignationLocalService;
	}

	private ResignationLocalService _resignationLocalService;
}