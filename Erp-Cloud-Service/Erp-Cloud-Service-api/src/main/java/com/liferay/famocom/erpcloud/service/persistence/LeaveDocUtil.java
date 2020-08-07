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

import com.liferay.famocom.erpcloud.model.LeaveDoc;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the leave doc service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.LeaveDocPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveDocPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveDocPersistenceImpl
 * @generated
 */
@ProviderType
public class LeaveDocUtil {
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
	public static void clearCache(LeaveDoc leaveDoc) {
		getPersistence().clearCache(leaveDoc);
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
	public static List<LeaveDoc> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveDoc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveDoc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveDoc> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveDoc update(LeaveDoc leaveDoc) {
		return getPersistence().update(leaveDoc);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveDoc update(LeaveDoc leaveDoc,
		ServiceContext serviceContext) {
		return getPersistence().update(leaveDoc, serviceContext);
	}

	/**
	* Caches the leave doc in the entity cache if it is enabled.
	*
	* @param leaveDoc the leave doc
	*/
	public static void cacheResult(LeaveDoc leaveDoc) {
		getPersistence().cacheResult(leaveDoc);
	}

	/**
	* Caches the leave docs in the entity cache if it is enabled.
	*
	* @param leaveDocs the leave docs
	*/
	public static void cacheResult(List<LeaveDoc> leaveDocs) {
		getPersistence().cacheResult(leaveDocs);
	}

	/**
	* Creates a new leave doc with the primary key. Does not add the leave doc to the database.
	*
	* @param leaveDocId the primary key for the new leave doc
	* @return the new leave doc
	*/
	public static LeaveDoc create(long leaveDocId) {
		return getPersistence().create(leaveDocId);
	}

	/**
	* Removes the leave doc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveDocId the primary key of the leave doc
	* @return the leave doc that was removed
	* @throws NoSuchLeaveDocException if a leave doc with the primary key could not be found
	*/
	public static LeaveDoc remove(long leaveDocId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveDocException {
		return getPersistence().remove(leaveDocId);
	}

	public static LeaveDoc updateImpl(LeaveDoc leaveDoc) {
		return getPersistence().updateImpl(leaveDoc);
	}

	/**
	* Returns the leave doc with the primary key or throws a {@link NoSuchLeaveDocException} if it could not be found.
	*
	* @param leaveDocId the primary key of the leave doc
	* @return the leave doc
	* @throws NoSuchLeaveDocException if a leave doc with the primary key could not be found
	*/
	public static LeaveDoc findByPrimaryKey(long leaveDocId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveDocException {
		return getPersistence().findByPrimaryKey(leaveDocId);
	}

	/**
	* Returns the leave doc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveDocId the primary key of the leave doc
	* @return the leave doc, or <code>null</code> if a leave doc with the primary key could not be found
	*/
	public static LeaveDoc fetchByPrimaryKey(long leaveDocId) {
		return getPersistence().fetchByPrimaryKey(leaveDocId);
	}

	public static java.util.Map<java.io.Serializable, LeaveDoc> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the leave docs.
	*
	* @return the leave docs
	*/
	public static List<LeaveDoc> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the leave docs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave docs
	* @param end the upper bound of the range of leave docs (not inclusive)
	* @return the range of leave docs
	*/
	public static List<LeaveDoc> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the leave docs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave docs
	* @param end the upper bound of the range of leave docs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave docs
	*/
	public static List<LeaveDoc> findAll(int start, int end,
		OrderByComparator<LeaveDoc> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the leave docs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave docs
	* @param end the upper bound of the range of leave docs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leave docs
	*/
	public static List<LeaveDoc> findAll(int start, int end,
		OrderByComparator<LeaveDoc> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the leave docs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave docs.
	*
	* @return the number of leave docs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveDocPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LeaveDocPersistence, LeaveDocPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LeaveDocPersistence.class);

		ServiceTracker<LeaveDocPersistence, LeaveDocPersistence> serviceTracker = new ServiceTracker<LeaveDocPersistence, LeaveDocPersistence>(bundle.getBundleContext(),
				LeaveDocPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}