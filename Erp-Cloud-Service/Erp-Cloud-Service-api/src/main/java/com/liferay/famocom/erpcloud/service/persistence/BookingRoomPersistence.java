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

package com.liferay.famocom.erpcloud.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.exception.NoSuchBookingRoomException;
import com.liferay.famocom.erpcloud.model.BookingRoom;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the booking room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.BookingRoomPersistenceImpl
 * @see BookingRoomUtil
 * @generated
 */
@ProviderType
public interface BookingRoomPersistence extends BasePersistence<BookingRoom> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookingRoomUtil} to access the booking room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the booking room in the entity cache if it is enabled.
	*
	* @param bookingRoom the booking room
	*/
	public void cacheResult(BookingRoom bookingRoom);

	/**
	* Caches the booking rooms in the entity cache if it is enabled.
	*
	* @param bookingRooms the booking rooms
	*/
	public void cacheResult(java.util.List<BookingRoom> bookingRooms);

	/**
	* Creates a new booking room with the primary key. Does not add the booking room to the database.
	*
	* @param bookingId the primary key for the new booking room
	* @return the new booking room
	*/
	public BookingRoom create(long bookingId);

	/**
	* Removes the booking room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingId the primary key of the booking room
	* @return the booking room that was removed
	* @throws NoSuchBookingRoomException if a booking room with the primary key could not be found
	*/
	public BookingRoom remove(long bookingId) throws NoSuchBookingRoomException;

	public BookingRoom updateImpl(BookingRoom bookingRoom);

	/**
	* Returns the booking room with the primary key or throws a {@link NoSuchBookingRoomException} if it could not be found.
	*
	* @param bookingId the primary key of the booking room
	* @return the booking room
	* @throws NoSuchBookingRoomException if a booking room with the primary key could not be found
	*/
	public BookingRoom findByPrimaryKey(long bookingId)
		throws NoSuchBookingRoomException;

	/**
	* Returns the booking room with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookingId the primary key of the booking room
	* @return the booking room, or <code>null</code> if a booking room with the primary key could not be found
	*/
	public BookingRoom fetchByPrimaryKey(long bookingId);

	@Override
	public java.util.Map<java.io.Serializable, BookingRoom> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the booking rooms.
	*
	* @return the booking rooms
	*/
	public java.util.List<BookingRoom> findAll();

	/**
	* Returns a range of all the booking rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookingRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of booking rooms
	* @param end the upper bound of the range of booking rooms (not inclusive)
	* @return the range of booking rooms
	*/
	public java.util.List<BookingRoom> findAll(int start, int end);

	/**
	* Returns an ordered range of all the booking rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookingRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of booking rooms
	* @param end the upper bound of the range of booking rooms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of booking rooms
	*/
	public java.util.List<BookingRoom> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingRoom> orderByComparator);

	/**
	* Returns an ordered range of all the booking rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookingRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of booking rooms
	* @param end the upper bound of the range of booking rooms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of booking rooms
	*/
	public java.util.List<BookingRoom> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingRoom> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the booking rooms from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of booking rooms.
	*
	* @return the number of booking rooms
	*/
	public int countAll();
}