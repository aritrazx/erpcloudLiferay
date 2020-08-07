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
 * Provides a wrapper for {@link BookingRoomLocalService}.
 *
 * @author Samaresh
 * @see BookingRoomLocalService
 * @generated
 */
@ProviderType
public class BookingRoomLocalServiceWrapper implements BookingRoomLocalService,
	ServiceWrapper<BookingRoomLocalService> {
	public BookingRoomLocalServiceWrapper(
		BookingRoomLocalService bookingRoomLocalService) {
		_bookingRoomLocalService = bookingRoomLocalService;
	}

	/**
	* Adds the booking room to the database. Also notifies the appropriate model listeners.
	*
	* @param bookingRoom the booking room
	* @return the booking room that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BookingRoom addBookingRoom(
		com.liferay.famocom.erpcloud.model.BookingRoom bookingRoom) {
		return _bookingRoomLocalService.addBookingRoom(bookingRoom);
	}

	/**
	* Creates a new booking room with the primary key. Does not add the booking room to the database.
	*
	* @param bookingId the primary key for the new booking room
	* @return the new booking room
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BookingRoom createBookingRoom(
		long bookingId) {
		return _bookingRoomLocalService.createBookingRoom(bookingId);
	}

	/**
	* Deletes the booking room from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingRoom the booking room
	* @return the booking room that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BookingRoom deleteBookingRoom(
		com.liferay.famocom.erpcloud.model.BookingRoom bookingRoom) {
		return _bookingRoomLocalService.deleteBookingRoom(bookingRoom);
	}

	/**
	* Deletes the booking room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingId the primary key of the booking room
	* @return the booking room that was removed
	* @throws PortalException if a booking room with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BookingRoom deleteBookingRoom(
		long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookingRoomLocalService.deleteBookingRoom(bookingId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookingRoomLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookingRoomLocalService.dynamicQuery();
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
		return _bookingRoomLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BookingRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bookingRoomLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BookingRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bookingRoomLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _bookingRoomLocalService.dynamicQueryCount(dynamicQuery);
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
		return _bookingRoomLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.BookingRoom fetchBookingRoom(
		long bookingId) {
		return _bookingRoomLocalService.fetchBookingRoom(bookingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _bookingRoomLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the booking room with the primary key.
	*
	* @param bookingId the primary key of the booking room
	* @return the booking room
	* @throws PortalException if a booking room with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BookingRoom getBookingRoom(
		long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookingRoomLocalService.getBookingRoom(bookingId);
	}

	/**
	* Returns a range of all the booking rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BookingRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of booking rooms
	* @param end the upper bound of the range of booking rooms (not inclusive)
	* @return the range of booking rooms
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.BookingRoom> getBookingRooms(
		int start, int end) {
		return _bookingRoomLocalService.getBookingRooms(start, end);
	}

	/**
	* Returns the number of booking rooms.
	*
	* @return the number of booking rooms
	*/
	@Override
	public int getBookingRoomsCount() {
		return _bookingRoomLocalService.getBookingRoomsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _bookingRoomLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookingRoomLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookingRoomLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the booking room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookingRoom the booking room
	* @return the booking room that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.BookingRoom updateBookingRoom(
		com.liferay.famocom.erpcloud.model.BookingRoom bookingRoom) {
		return _bookingRoomLocalService.updateBookingRoom(bookingRoom);
	}

	@Override
	public BookingRoomLocalService getWrappedService() {
		return _bookingRoomLocalService;
	}

	@Override
	public void setWrappedService(
		BookingRoomLocalService bookingRoomLocalService) {
		_bookingRoomLocalService = bookingRoomLocalService;
	}

	private BookingRoomLocalService _bookingRoomLocalService;
}