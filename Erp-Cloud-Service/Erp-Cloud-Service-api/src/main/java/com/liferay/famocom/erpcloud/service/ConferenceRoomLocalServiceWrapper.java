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
 * Provides a wrapper for {@link ConferenceRoomLocalService}.
 *
 * @author Samaresh
 * @see ConferenceRoomLocalService
 * @generated
 */
@ProviderType
public class ConferenceRoomLocalServiceWrapper
	implements ConferenceRoomLocalService,
		ServiceWrapper<ConferenceRoomLocalService> {
	public ConferenceRoomLocalServiceWrapper(
		ConferenceRoomLocalService conferenceRoomLocalService) {
		_conferenceRoomLocalService = conferenceRoomLocalService;
	}

	/**
	* Adds the conference room to the database. Also notifies the appropriate model listeners.
	*
	* @param conferenceRoom the conference room
	* @return the conference room that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ConferenceRoom addConferenceRoom(
		com.liferay.famocom.erpcloud.model.ConferenceRoom conferenceRoom) {
		return _conferenceRoomLocalService.addConferenceRoom(conferenceRoom);
	}

	/**
	* Creates a new conference room with the primary key. Does not add the conference room to the database.
	*
	* @param roomId the primary key for the new conference room
	* @return the new conference room
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ConferenceRoom createConferenceRoom(
		long roomId) {
		return _conferenceRoomLocalService.createConferenceRoom(roomId);
	}

	/**
	* Deletes the conference room from the database. Also notifies the appropriate model listeners.
	*
	* @param conferenceRoom the conference room
	* @return the conference room that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ConferenceRoom deleteConferenceRoom(
		com.liferay.famocom.erpcloud.model.ConferenceRoom conferenceRoom) {
		return _conferenceRoomLocalService.deleteConferenceRoom(conferenceRoom);
	}

	/**
	* Deletes the conference room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roomId the primary key of the conference room
	* @return the conference room that was removed
	* @throws PortalException if a conference room with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ConferenceRoom deleteConferenceRoom(
		long roomId) throws com.liferay.portal.kernel.exception.PortalException {
		return _conferenceRoomLocalService.deleteConferenceRoom(roomId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _conferenceRoomLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _conferenceRoomLocalService.dynamicQuery();
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
		return _conferenceRoomLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ConferenceRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _conferenceRoomLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ConferenceRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _conferenceRoomLocalService.dynamicQuery(dynamicQuery, start,
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
		return _conferenceRoomLocalService.dynamicQueryCount(dynamicQuery);
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
		return _conferenceRoomLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.ConferenceRoom fetchConferenceRoom(
		long roomId) {
		return _conferenceRoomLocalService.fetchConferenceRoom(roomId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _conferenceRoomLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the conference room with the primary key.
	*
	* @param roomId the primary key of the conference room
	* @return the conference room
	* @throws PortalException if a conference room with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ConferenceRoom getConferenceRoom(
		long roomId) throws com.liferay.portal.kernel.exception.PortalException {
		return _conferenceRoomLocalService.getConferenceRoom(roomId);
	}

	/**
	* Returns a range of all the conference rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ConferenceRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of conference rooms
	* @param end the upper bound of the range of conference rooms (not inclusive)
	* @return the range of conference rooms
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ConferenceRoom> getConferenceRooms(
		int start, int end) {
		return _conferenceRoomLocalService.getConferenceRooms(start, end);
	}

	/**
	* Returns the number of conference rooms.
	*
	* @return the number of conference rooms
	*/
	@Override
	public int getConferenceRoomsCount() {
		return _conferenceRoomLocalService.getConferenceRoomsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _conferenceRoomLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _conferenceRoomLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _conferenceRoomLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the conference room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param conferenceRoom the conference room
	* @return the conference room that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ConferenceRoom updateConferenceRoom(
		com.liferay.famocom.erpcloud.model.ConferenceRoom conferenceRoom) {
		return _conferenceRoomLocalService.updateConferenceRoom(conferenceRoom);
	}

	@Override
	public ConferenceRoomLocalService getWrappedService() {
		return _conferenceRoomLocalService;
	}

	@Override
	public void setWrappedService(
		ConferenceRoomLocalService conferenceRoomLocalService) {
		_conferenceRoomLocalService = conferenceRoomLocalService;
	}

	private ConferenceRoomLocalService _conferenceRoomLocalService;
}