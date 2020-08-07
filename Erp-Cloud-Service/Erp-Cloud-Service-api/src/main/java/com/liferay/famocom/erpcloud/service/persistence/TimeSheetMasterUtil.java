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

import com.liferay.famocom.erpcloud.model.TimeSheetMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the time sheet master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.TimeSheetMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TimeSheetMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TimeSheetMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class TimeSheetMasterUtil {
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
	public static void clearCache(TimeSheetMaster timeSheetMaster) {
		getPersistence().clearCache(timeSheetMaster);
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
	public static List<TimeSheetMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TimeSheetMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TimeSheetMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TimeSheetMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TimeSheetMaster update(TimeSheetMaster timeSheetMaster) {
		return getPersistence().update(timeSheetMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TimeSheetMaster update(TimeSheetMaster timeSheetMaster,
		ServiceContext serviceContext) {
		return getPersistence().update(timeSheetMaster, serviceContext);
	}

	/**
	* Returns all the time sheet masters where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching time sheet masters
	*/
	public static List<TimeSheetMaster> findBystatus(long groupId, int status) {
		return getPersistence().findBystatus(groupId, status);
	}

	/**
	* Returns a range of all the time sheet masters where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @return the range of matching time sheet masters
	*/
	public static List<TimeSheetMaster> findBystatus(long groupId, int status,
		int start, int end) {
		return getPersistence().findBystatus(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the time sheet masters where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching time sheet masters
	*/
	public static List<TimeSheetMaster> findBystatus(long groupId, int status,
		int start, int end, OrderByComparator<TimeSheetMaster> orderByComparator) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the time sheet masters where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching time sheet masters
	*/
	public static List<TimeSheetMaster> findBystatus(long groupId, int status,
		int start, int end,
		OrderByComparator<TimeSheetMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time sheet master
	* @throws NoSuchTimeSheetMasterException if a matching time sheet master could not be found
	*/
	public static TimeSheetMaster findBystatus_First(long groupId, int status,
		OrderByComparator<TimeSheetMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetMasterException {
		return getPersistence()
				   .findBystatus_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the first time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time sheet master, or <code>null</code> if a matching time sheet master could not be found
	*/
	public static TimeSheetMaster fetchBystatus_First(long groupId, int status,
		OrderByComparator<TimeSheetMaster> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the last time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time sheet master
	* @throws NoSuchTimeSheetMasterException if a matching time sheet master could not be found
	*/
	public static TimeSheetMaster findBystatus_Last(long groupId, int status,
		OrderByComparator<TimeSheetMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetMasterException {
		return getPersistence()
				   .findBystatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time sheet master, or <code>null</code> if a matching time sheet master could not be found
	*/
	public static TimeSheetMaster fetchBystatus_Last(long groupId, int status,
		OrderByComparator<TimeSheetMaster> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the time sheet masters before and after the current time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param timesheetParentId the primary key of the current time sheet master
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next time sheet master
	* @throws NoSuchTimeSheetMasterException if a time sheet master with the primary key could not be found
	*/
	public static TimeSheetMaster[] findBystatus_PrevAndNext(
		long timesheetParentId, long groupId, int status,
		OrderByComparator<TimeSheetMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetMasterException {
		return getPersistence()
				   .findBystatus_PrevAndNext(timesheetParentId, groupId,
			status, orderByComparator);
	}

	/**
	* Removes all the time sheet masters where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public static void removeBystatus(long groupId, int status) {
		getPersistence().removeBystatus(groupId, status);
	}

	/**
	* Returns the number of time sheet masters where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching time sheet masters
	*/
	public static int countBystatus(long groupId, int status) {
		return getPersistence().countBystatus(groupId, status);
	}

	/**
	* Caches the time sheet master in the entity cache if it is enabled.
	*
	* @param timeSheetMaster the time sheet master
	*/
	public static void cacheResult(TimeSheetMaster timeSheetMaster) {
		getPersistence().cacheResult(timeSheetMaster);
	}

	/**
	* Caches the time sheet masters in the entity cache if it is enabled.
	*
	* @param timeSheetMasters the time sheet masters
	*/
	public static void cacheResult(List<TimeSheetMaster> timeSheetMasters) {
		getPersistence().cacheResult(timeSheetMasters);
	}

	/**
	* Creates a new time sheet master with the primary key. Does not add the time sheet master to the database.
	*
	* @param timesheetParentId the primary key for the new time sheet master
	* @return the new time sheet master
	*/
	public static TimeSheetMaster create(long timesheetParentId) {
		return getPersistence().create(timesheetParentId);
	}

	/**
	* Removes the time sheet master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetParentId the primary key of the time sheet master
	* @return the time sheet master that was removed
	* @throws NoSuchTimeSheetMasterException if a time sheet master with the primary key could not be found
	*/
	public static TimeSheetMaster remove(long timesheetParentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetMasterException {
		return getPersistence().remove(timesheetParentId);
	}

	public static TimeSheetMaster updateImpl(TimeSheetMaster timeSheetMaster) {
		return getPersistence().updateImpl(timeSheetMaster);
	}

	/**
	* Returns the time sheet master with the primary key or throws a {@link NoSuchTimeSheetMasterException} if it could not be found.
	*
	* @param timesheetParentId the primary key of the time sheet master
	* @return the time sheet master
	* @throws NoSuchTimeSheetMasterException if a time sheet master with the primary key could not be found
	*/
	public static TimeSheetMaster findByPrimaryKey(long timesheetParentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetMasterException {
		return getPersistence().findByPrimaryKey(timesheetParentId);
	}

	/**
	* Returns the time sheet master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timesheetParentId the primary key of the time sheet master
	* @return the time sheet master, or <code>null</code> if a time sheet master with the primary key could not be found
	*/
	public static TimeSheetMaster fetchByPrimaryKey(long timesheetParentId) {
		return getPersistence().fetchByPrimaryKey(timesheetParentId);
	}

	public static java.util.Map<java.io.Serializable, TimeSheetMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the time sheet masters.
	*
	* @return the time sheet masters
	*/
	public static List<TimeSheetMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the time sheet masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @return the range of time sheet masters
	*/
	public static List<TimeSheetMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the time sheet masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of time sheet masters
	*/
	public static List<TimeSheetMaster> findAll(int start, int end,
		OrderByComparator<TimeSheetMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the time sheet masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time sheet masters
	* @param end the upper bound of the range of time sheet masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of time sheet masters
	*/
	public static List<TimeSheetMaster> findAll(int start, int end,
		OrderByComparator<TimeSheetMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the time sheet masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of time sheet masters.
	*
	* @return the number of time sheet masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TimeSheetMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TimeSheetMasterPersistence, TimeSheetMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TimeSheetMasterPersistence.class);

		ServiceTracker<TimeSheetMasterPersistence, TimeSheetMasterPersistence> serviceTracker =
			new ServiceTracker<TimeSheetMasterPersistence, TimeSheetMasterPersistence>(bundle.getBundleContext(),
				TimeSheetMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}