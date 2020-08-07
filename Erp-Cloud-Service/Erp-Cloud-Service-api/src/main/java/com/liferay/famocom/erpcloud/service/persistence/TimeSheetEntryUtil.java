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

import com.liferay.famocom.erpcloud.model.TimeSheetEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the time sheet entry service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.TimeSheetEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TimeSheetEntryPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TimeSheetEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class TimeSheetEntryUtil {
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
	public static void clearCache(TimeSheetEntry timeSheetEntry) {
		getPersistence().clearCache(timeSheetEntry);
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
	public static List<TimeSheetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TimeSheetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TimeSheetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TimeSheetEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TimeSheetEntry update(TimeSheetEntry timeSheetEntry) {
		return getPersistence().update(timeSheetEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TimeSheetEntry update(TimeSheetEntry timeSheetEntry,
		ServiceContext serviceContext) {
		return getPersistence().update(timeSheetEntry, serviceContext);
	}

	/**
	* Returns all the time sheet entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching time sheet entries
	*/
	public static List<TimeSheetEntry> findBystatus(long groupId, int status) {
		return getPersistence().findBystatus(groupId, status);
	}

	/**
	* Returns a range of all the time sheet entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @return the range of matching time sheet entries
	*/
	public static List<TimeSheetEntry> findBystatus(long groupId, int status,
		int start, int end) {
		return getPersistence().findBystatus(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the time sheet entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching time sheet entries
	*/
	public static List<TimeSheetEntry> findBystatus(long groupId, int status,
		int start, int end, OrderByComparator<TimeSheetEntry> orderByComparator) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the time sheet entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching time sheet entries
	*/
	public static List<TimeSheetEntry> findBystatus(long groupId, int status,
		int start, int end,
		OrderByComparator<TimeSheetEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time sheet entry
	* @throws NoSuchTimeSheetEntryException if a matching time sheet entry could not be found
	*/
	public static TimeSheetEntry findBystatus_First(long groupId, int status,
		OrderByComparator<TimeSheetEntry> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetEntryException {
		return getPersistence()
				   .findBystatus_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the first time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time sheet entry, or <code>null</code> if a matching time sheet entry could not be found
	*/
	public static TimeSheetEntry fetchBystatus_First(long groupId, int status,
		OrderByComparator<TimeSheetEntry> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the last time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time sheet entry
	* @throws NoSuchTimeSheetEntryException if a matching time sheet entry could not be found
	*/
	public static TimeSheetEntry findBystatus_Last(long groupId, int status,
		OrderByComparator<TimeSheetEntry> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetEntryException {
		return getPersistence()
				   .findBystatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time sheet entry, or <code>null</code> if a matching time sheet entry could not be found
	*/
	public static TimeSheetEntry fetchBystatus_Last(long groupId, int status,
		OrderByComparator<TimeSheetEntry> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the time sheet entries before and after the current time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param timesheetId the primary key of the current time sheet entry
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next time sheet entry
	* @throws NoSuchTimeSheetEntryException if a time sheet entry with the primary key could not be found
	*/
	public static TimeSheetEntry[] findBystatus_PrevAndNext(long timesheetId,
		long groupId, int status,
		OrderByComparator<TimeSheetEntry> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetEntryException {
		return getPersistence()
				   .findBystatus_PrevAndNext(timesheetId, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the time sheet entries where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public static void removeBystatus(long groupId, int status) {
		getPersistence().removeBystatus(groupId, status);
	}

	/**
	* Returns the number of time sheet entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching time sheet entries
	*/
	public static int countBystatus(long groupId, int status) {
		return getPersistence().countBystatus(groupId, status);
	}

	/**
	* Caches the time sheet entry in the entity cache if it is enabled.
	*
	* @param timeSheetEntry the time sheet entry
	*/
	public static void cacheResult(TimeSheetEntry timeSheetEntry) {
		getPersistence().cacheResult(timeSheetEntry);
	}

	/**
	* Caches the time sheet entries in the entity cache if it is enabled.
	*
	* @param timeSheetEntries the time sheet entries
	*/
	public static void cacheResult(List<TimeSheetEntry> timeSheetEntries) {
		getPersistence().cacheResult(timeSheetEntries);
	}

	/**
	* Creates a new time sheet entry with the primary key. Does not add the time sheet entry to the database.
	*
	* @param timesheetId the primary key for the new time sheet entry
	* @return the new time sheet entry
	*/
	public static TimeSheetEntry create(long timesheetId) {
		return getPersistence().create(timesheetId);
	}

	/**
	* Removes the time sheet entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetId the primary key of the time sheet entry
	* @return the time sheet entry that was removed
	* @throws NoSuchTimeSheetEntryException if a time sheet entry with the primary key could not be found
	*/
	public static TimeSheetEntry remove(long timesheetId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetEntryException {
		return getPersistence().remove(timesheetId);
	}

	public static TimeSheetEntry updateImpl(TimeSheetEntry timeSheetEntry) {
		return getPersistence().updateImpl(timeSheetEntry);
	}

	/**
	* Returns the time sheet entry with the primary key or throws a {@link NoSuchTimeSheetEntryException} if it could not be found.
	*
	* @param timesheetId the primary key of the time sheet entry
	* @return the time sheet entry
	* @throws NoSuchTimeSheetEntryException if a time sheet entry with the primary key could not be found
	*/
	public static TimeSheetEntry findByPrimaryKey(long timesheetId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetEntryException {
		return getPersistence().findByPrimaryKey(timesheetId);
	}

	/**
	* Returns the time sheet entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timesheetId the primary key of the time sheet entry
	* @return the time sheet entry, or <code>null</code> if a time sheet entry with the primary key could not be found
	*/
	public static TimeSheetEntry fetchByPrimaryKey(long timesheetId) {
		return getPersistence().fetchByPrimaryKey(timesheetId);
	}

	public static java.util.Map<java.io.Serializable, TimeSheetEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the time sheet entries.
	*
	* @return the time sheet entries
	*/
	public static List<TimeSheetEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the time sheet entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @return the range of time sheet entries
	*/
	public static List<TimeSheetEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the time sheet entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of time sheet entries
	*/
	public static List<TimeSheetEntry> findAll(int start, int end,
		OrderByComparator<TimeSheetEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the time sheet entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet entries
	* @param end the upper bound of the range of time sheet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of time sheet entries
	*/
	public static List<TimeSheetEntry> findAll(int start, int end,
		OrderByComparator<TimeSheetEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the time sheet entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of time sheet entries.
	*
	* @return the number of time sheet entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TimeSheetEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TimeSheetEntryPersistence, TimeSheetEntryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TimeSheetEntryPersistence.class);

		ServiceTracker<TimeSheetEntryPersistence, TimeSheetEntryPersistence> serviceTracker =
			new ServiceTracker<TimeSheetEntryPersistence, TimeSheetEntryPersistence>(bundle.getBundleContext(),
				TimeSheetEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}