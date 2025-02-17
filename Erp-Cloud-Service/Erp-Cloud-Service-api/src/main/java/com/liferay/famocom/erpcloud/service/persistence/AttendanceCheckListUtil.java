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

import com.liferay.famocom.erpcloud.model.AttendanceCheckList;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the attendance check list service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.AttendanceCheckListPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AttendanceCheckListPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AttendanceCheckListPersistenceImpl
 * @generated
 */
@ProviderType
public class AttendanceCheckListUtil {
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
	public static void clearCache(AttendanceCheckList attendanceCheckList) {
		getPersistence().clearCache(attendanceCheckList);
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
	public static List<AttendanceCheckList> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AttendanceCheckList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AttendanceCheckList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AttendanceCheckList> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AttendanceCheckList update(
		AttendanceCheckList attendanceCheckList) {
		return getPersistence().update(attendanceCheckList);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AttendanceCheckList update(
		AttendanceCheckList attendanceCheckList, ServiceContext serviceContext) {
		return getPersistence().update(attendanceCheckList, serviceContext);
	}

	/**
	* Caches the attendance check list in the entity cache if it is enabled.
	*
	* @param attendanceCheckList the attendance check list
	*/
	public static void cacheResult(AttendanceCheckList attendanceCheckList) {
		getPersistence().cacheResult(attendanceCheckList);
	}

	/**
	* Caches the attendance check lists in the entity cache if it is enabled.
	*
	* @param attendanceCheckLists the attendance check lists
	*/
	public static void cacheResult(
		List<AttendanceCheckList> attendanceCheckLists) {
		getPersistence().cacheResult(attendanceCheckLists);
	}

	/**
	* Creates a new attendance check list with the primary key. Does not add the attendance check list to the database.
	*
	* @param attendanceCheckListId the primary key for the new attendance check list
	* @return the new attendance check list
	*/
	public static AttendanceCheckList create(long attendanceCheckListId) {
		return getPersistence().create(attendanceCheckListId);
	}

	/**
	* Removes the attendance check list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceCheckListId the primary key of the attendance check list
	* @return the attendance check list that was removed
	* @throws NoSuchAttendanceCheckListException if a attendance check list with the primary key could not be found
	*/
	public static AttendanceCheckList remove(long attendanceCheckListId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceCheckListException {
		return getPersistence().remove(attendanceCheckListId);
	}

	public static AttendanceCheckList updateImpl(
		AttendanceCheckList attendanceCheckList) {
		return getPersistence().updateImpl(attendanceCheckList);
	}

	/**
	* Returns the attendance check list with the primary key or throws a {@link NoSuchAttendanceCheckListException} if it could not be found.
	*
	* @param attendanceCheckListId the primary key of the attendance check list
	* @return the attendance check list
	* @throws NoSuchAttendanceCheckListException if a attendance check list with the primary key could not be found
	*/
	public static AttendanceCheckList findByPrimaryKey(
		long attendanceCheckListId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAttendanceCheckListException {
		return getPersistence().findByPrimaryKey(attendanceCheckListId);
	}

	/**
	* Returns the attendance check list with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attendanceCheckListId the primary key of the attendance check list
	* @return the attendance check list, or <code>null</code> if a attendance check list with the primary key could not be found
	*/
	public static AttendanceCheckList fetchByPrimaryKey(
		long attendanceCheckListId) {
		return getPersistence().fetchByPrimaryKey(attendanceCheckListId);
	}

	public static java.util.Map<java.io.Serializable, AttendanceCheckList> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the attendance check lists.
	*
	* @return the attendance check lists
	*/
	public static List<AttendanceCheckList> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the attendance check lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceCheckListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendance check lists
	* @param end the upper bound of the range of attendance check lists (not inclusive)
	* @return the range of attendance check lists
	*/
	public static List<AttendanceCheckList> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the attendance check lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceCheckListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendance check lists
	* @param end the upper bound of the range of attendance check lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of attendance check lists
	*/
	public static List<AttendanceCheckList> findAll(int start, int end,
		OrderByComparator<AttendanceCheckList> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the attendance check lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceCheckListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendance check lists
	* @param end the upper bound of the range of attendance check lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of attendance check lists
	*/
	public static List<AttendanceCheckList> findAll(int start, int end,
		OrderByComparator<AttendanceCheckList> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the attendance check lists from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of attendance check lists.
	*
	* @return the number of attendance check lists
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AttendanceCheckListPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AttendanceCheckListPersistence, AttendanceCheckListPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AttendanceCheckListPersistence.class);

		ServiceTracker<AttendanceCheckListPersistence, AttendanceCheckListPersistence> serviceTracker =
			new ServiceTracker<AttendanceCheckListPersistence, AttendanceCheckListPersistence>(bundle.getBundleContext(),
				AttendanceCheckListPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}