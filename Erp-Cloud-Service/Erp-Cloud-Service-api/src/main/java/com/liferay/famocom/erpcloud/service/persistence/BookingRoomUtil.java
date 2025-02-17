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

import com.liferay.famocom.erpcloud.model.BookingRoom;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the booking room service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.BookingRoomPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see BookingRoomPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.BookingRoomPersistenceImpl
 * @generated
 */
@ProviderType
public class BookingRoomUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(BookingRoom bookingRoom) {
		getPersistence().clearCache(bookingRoom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BookingRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BookingRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BookingRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BookingRoom> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BookingRoom update(BookingRoom bookingRoom) {
		return getPersistence().update(bookingRoom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BookingRoom update(BookingRoom bookingRoom,
		ServiceContext serviceContext) {
		return getPersistence().update(bookingRoom, serviceContext);
	}

	/**
	* Caches the booking room in the entity cache if it is enabled.
	*
	* @param bookingRoom the booking room
	*/
	public static void cacheResult(BookingRoom bookingRoom) {
		getPersistence().cacheResult(bookingRoom);
	}

	/**
	* Caches the booking rooms in the entity cache if it is enabled.
	*
	* @param bookingRooms the booking rooms
	*/
	public static void cacheResult(List<BookingRoom> bookingRooms) {
		getPersistence().cacheResult(bookingRooms);
	}

	/**
	* Creates a new booking room with the primary key. Does not add the booking room to the database.
	*
	* @param bookingId the primary key for the new booking room
	* @return the new booking room
	*/
	public static BookingRoom create(long bookingId) {
		return getPersistence().create(bookingId);
	}

	/**
	* Removes the booking room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingId the primary key of the booking room
	* @return the booking room that was removed
	* @throws NoSuchBookingRoomException if a booking room with the primary key could not be found
	*/
	public static BookingRoom remove(long bookingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchBookingRoomException {
		return getPersistence().remove(bookingId);
	}

	public static BookingRoom updateImpl(BookingRoom bookingRoom) {
		return getPersistence().updateImpl(bookingRoom);
	}

	/**
	* Returns the booking room with the primary key or throws a {@link NoSuchBookingRoomException} if it could not be found.
	*
	* @param bookingId the primary key of the booking room
	* @return the booking room
	* @throws NoSuchBookingRoomException if a booking room with the primary key could not be found
	*/
	public static BookingRoom findByPrimaryKey(long bookingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchBookingRoomException {
		return getPersistence().findByPrimaryKey(bookingId);
	}

	/**
	* Returns the booking room with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookingId the primary key of the booking room
	* @return the booking room, or <code>null</code> if a booking room with the primary key could not be found
	*/
	public static BookingRoom fetchByPrimaryKey(long bookingId) {
		return getPersistence().fetchByPrimaryKey(bookingId);
	}

	public static java.util.Map<java.io.Serializable, BookingRoom> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the booking rooms.
	*
	* @return the booking rooms
	*/
	public static List<BookingRoom> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<BookingRoom> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<BookingRoom> findAll(int start, int end,
		OrderByComparator<BookingRoom> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<BookingRoom> findAll(int start, int end,
		OrderByComparator<BookingRoom> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the booking rooms from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of booking rooms.
	*
	* @return the number of booking rooms
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BookingRoomPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BookingRoomPersistence, BookingRoomPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BookingRoomPersistence.class);

		ServiceTracker<BookingRoomPersistence, BookingRoomPersistence> serviceTracker =
			new ServiceTracker<BookingRoomPersistence, BookingRoomPersistence>(bundle.getBundleContext(),
				BookingRoomPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}