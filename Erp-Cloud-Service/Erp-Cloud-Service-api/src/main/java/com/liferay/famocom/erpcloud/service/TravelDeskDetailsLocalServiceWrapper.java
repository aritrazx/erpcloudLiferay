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
 * Provides a wrapper for {@link TravelDeskDetailsLocalService}.
 *
 * @author Samaresh
 * @see TravelDeskDetailsLocalService
 * @generated
 */
@ProviderType
public class TravelDeskDetailsLocalServiceWrapper
	implements TravelDeskDetailsLocalService,
		ServiceWrapper<TravelDeskDetailsLocalService> {
	public TravelDeskDetailsLocalServiceWrapper(
		TravelDeskDetailsLocalService travelDeskDetailsLocalService) {
		_travelDeskDetailsLocalService = travelDeskDetailsLocalService;
	}

	/**
	* Adds the travel desk details to the database. Also notifies the appropriate model listeners.
	*
	* @param travelDeskDetails the travel desk details
	* @return the travel desk details that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TravelDeskDetails addTravelDeskDetails(
		com.liferay.famocom.erpcloud.model.TravelDeskDetails travelDeskDetails) {
		return _travelDeskDetailsLocalService.addTravelDeskDetails(travelDeskDetails);
	}

	/**
	* Creates a new travel desk details with the primary key. Does not add the travel desk details to the database.
	*
	* @param travelDetailsId the primary key for the new travel desk details
	* @return the new travel desk details
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TravelDeskDetails createTravelDeskDetails(
		long travelDetailsId) {
		return _travelDeskDetailsLocalService.createTravelDeskDetails(travelDetailsId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _travelDeskDetailsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the travel desk details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param travelDetailsId the primary key of the travel desk details
	* @return the travel desk details that was removed
	* @throws PortalException if a travel desk details with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TravelDeskDetails deleteTravelDeskDetails(
		long travelDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _travelDeskDetailsLocalService.deleteTravelDeskDetails(travelDetailsId);
	}

	/**
	* Deletes the travel desk details from the database. Also notifies the appropriate model listeners.
	*
	* @param travelDeskDetails the travel desk details
	* @return the travel desk details that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TravelDeskDetails deleteTravelDeskDetails(
		com.liferay.famocom.erpcloud.model.TravelDeskDetails travelDeskDetails) {
		return _travelDeskDetailsLocalService.deleteTravelDeskDetails(travelDeskDetails);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelDeskDetailsLocalService.dynamicQuery();
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
		return _travelDeskDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _travelDeskDetailsLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _travelDeskDetailsLocalService.dynamicQuery(dynamicQuery, start,
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
		return _travelDeskDetailsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _travelDeskDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.TravelDeskDetails fetchTravelDeskDetails(
		long travelDetailsId) {
		return _travelDeskDetailsLocalService.fetchTravelDeskDetails(travelDetailsId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.TravelDeskDetails> findByprojectMember(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return _travelDeskDetailsLocalService.findByprojectMember(projectId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.TravelDeskDetails> findBytravel(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return _travelDeskDetailsLocalService.findBytravel(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _travelDeskDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _travelDeskDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelDeskDetailsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _travelDeskDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the travel desk details with the primary key.
	*
	* @param travelDetailsId the primary key of the travel desk details
	* @return the travel desk details
	* @throws PortalException if a travel desk details with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TravelDeskDetails getTravelDeskDetails(
		long travelDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _travelDeskDetailsLocalService.getTravelDeskDetails(travelDetailsId);
	}

	/**
	* Returns a range of all the travel desk detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of travel desk detailses
	* @param end the upper bound of the range of travel desk detailses (not inclusive)
	* @return the range of travel desk detailses
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.TravelDeskDetails> getTravelDeskDetailses(
		int start, int end) {
		return _travelDeskDetailsLocalService.getTravelDeskDetailses(start, end);
	}

	/**
	* Returns the number of travel desk detailses.
	*
	* @return the number of travel desk detailses
	*/
	@Override
	public int getTravelDeskDetailsesCount() {
		return _travelDeskDetailsLocalService.getTravelDeskDetailsesCount();
	}

	/**
	* Updates the travel desk details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param travelDeskDetails the travel desk details
	* @return the travel desk details that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.TravelDeskDetails updateTravelDeskDetails(
		com.liferay.famocom.erpcloud.model.TravelDeskDetails travelDeskDetails) {
		return _travelDeskDetailsLocalService.updateTravelDeskDetails(travelDeskDetails);
	}

	@Override
	public TravelDeskDetailsLocalService getWrappedService() {
		return _travelDeskDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		TravelDeskDetailsLocalService travelDeskDetailsLocalService) {
		_travelDeskDetailsLocalService = travelDeskDetailsLocalService;
	}

	private TravelDeskDetailsLocalService _travelDeskDetailsLocalService;
}