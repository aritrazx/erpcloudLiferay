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

import com.liferay.famocom.erpcloud.model.ConferenceRoom;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the conference room service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ConferenceRoomPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ConferenceRoomPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ConferenceRoomPersistenceImpl
 * @generated
 */
@ProviderType
public class ConferenceRoomUtil {
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
	public static void clearCache(ConferenceRoom conferenceRoom) {
		getPersistence().clearCache(conferenceRoom);
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
	public static List<ConferenceRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConferenceRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConferenceRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ConferenceRoom> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ConferenceRoom update(ConferenceRoom conferenceRoom) {
		return getPersistence().update(conferenceRoom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ConferenceRoom update(ConferenceRoom conferenceRoom,
		ServiceContext serviceContext) {
		return getPersistence().update(conferenceRoom, serviceContext);
	}

	/**
	* Caches the conference room in the entity cache if it is enabled.
	*
	* @param conferenceRoom the conference room
	*/
	public static void cacheResult(ConferenceRoom conferenceRoom) {
		getPersistence().cacheResult(conferenceRoom);
	}

	/**
	* Caches the conference rooms in the entity cache if it is enabled.
	*
	* @param conferenceRooms the conference rooms
	*/
	public static void cacheResult(List<ConferenceRoom> conferenceRooms) {
		getPersistence().cacheResult(conferenceRooms);
	}

	/**
	* Creates a new conference room with the primary key. Does not add the conference room to the database.
	*
	* @param roomId the primary key for the new conference room
	* @return the new conference room
	*/
	public static ConferenceRoom create(long roomId) {
		return getPersistence().create(roomId);
	}

	/**
	* Removes the conference room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roomId the primary key of the conference room
	* @return the conference room that was removed
	* @throws NoSuchConferenceRoomException if a conference room with the primary key could not be found
	*/
	public static ConferenceRoom remove(long roomId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchConferenceRoomException {
		return getPersistence().remove(roomId);
	}

	public static ConferenceRoom updateImpl(ConferenceRoom conferenceRoom) {
		return getPersistence().updateImpl(conferenceRoom);
	}

	/**
	* Returns the conference room with the primary key or throws a {@link NoSuchConferenceRoomException} if it could not be found.
	*
	* @param roomId the primary key of the conference room
	* @return the conference room
	* @throws NoSuchConferenceRoomException if a conference room with the primary key could not be found
	*/
	public static ConferenceRoom findByPrimaryKey(long roomId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchConferenceRoomException {
		return getPersistence().findByPrimaryKey(roomId);
	}

	/**
	* Returns the conference room with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param roomId the primary key of the conference room
	* @return the conference room, or <code>null</code> if a conference room with the primary key could not be found
	*/
	public static ConferenceRoom fetchByPrimaryKey(long roomId) {
		return getPersistence().fetchByPrimaryKey(roomId);
	}

	public static java.util.Map<java.io.Serializable, ConferenceRoom> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the conference rooms.
	*
	* @return the conference rooms
	*/
	public static List<ConferenceRoom> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the conference rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ConferenceRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of conference rooms
	* @param end the upper bound of the range of conference rooms (not inclusive)
	* @return the range of conference rooms
	*/
	public static List<ConferenceRoom> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the conference rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ConferenceRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of conference rooms
	* @param end the upper bound of the range of conference rooms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of conference rooms
	*/
	public static List<ConferenceRoom> findAll(int start, int end,
		OrderByComparator<ConferenceRoom> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the conference rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ConferenceRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of conference rooms
	* @param end the upper bound of the range of conference rooms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of conference rooms
	*/
	public static List<ConferenceRoom> findAll(int start, int end,
		OrderByComparator<ConferenceRoom> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the conference rooms from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of conference rooms.
	*
	* @return the number of conference rooms
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ConferenceRoomPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ConferenceRoomPersistence, ConferenceRoomPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ConferenceRoomPersistence.class);

		ServiceTracker<ConferenceRoomPersistence, ConferenceRoomPersistence> serviceTracker =
			new ServiceTracker<ConferenceRoomPersistence, ConferenceRoomPersistence>(bundle.getBundleContext(),
				ConferenceRoomPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}