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

import com.liferay.famocom.erpcloud.model.RecruitmentProcess;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the recruitment process service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.RecruitmentProcessPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see RecruitmentProcessPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.RecruitmentProcessPersistenceImpl
 * @generated
 */
@ProviderType
public class RecruitmentProcessUtil {
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
	public static void clearCache(RecruitmentProcess recruitmentProcess) {
		getPersistence().clearCache(recruitmentProcess);
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
	public static List<RecruitmentProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RecruitmentProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RecruitmentProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RecruitmentProcess> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RecruitmentProcess update(
		RecruitmentProcess recruitmentProcess) {
		return getPersistence().update(recruitmentProcess);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RecruitmentProcess update(
		RecruitmentProcess recruitmentProcess, ServiceContext serviceContext) {
		return getPersistence().update(recruitmentProcess, serviceContext);
	}

	/**
	* Returns all the recruitment processes where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching recruitment processes
	*/
	public static List<RecruitmentProcess> findBystatus(long groupId, int status) {
		return getPersistence().findBystatus(groupId, status);
	}

	/**
	* Returns a range of all the recruitment processes where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitmentProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of recruitment processes
	* @param end the upper bound of the range of recruitment processes (not inclusive)
	* @return the range of matching recruitment processes
	*/
	public static List<RecruitmentProcess> findBystatus(long groupId,
		int status, int start, int end) {
		return getPersistence().findBystatus(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the recruitment processes where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitmentProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of recruitment processes
	* @param end the upper bound of the range of recruitment processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching recruitment processes
	*/
	public static List<RecruitmentProcess> findBystatus(long groupId,
		int status, int start, int end,
		OrderByComparator<RecruitmentProcess> orderByComparator) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the recruitment processes where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitmentProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of recruitment processes
	* @param end the upper bound of the range of recruitment processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching recruitment processes
	*/
	public static List<RecruitmentProcess> findBystatus(long groupId,
		int status, int start, int end,
		OrderByComparator<RecruitmentProcess> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBystatus(groupId, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first recruitment process in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching recruitment process
	* @throws NoSuchRecruitmentProcessException if a matching recruitment process could not be found
	*/
	public static RecruitmentProcess findBystatus_First(long groupId,
		int status, OrderByComparator<RecruitmentProcess> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitmentProcessException {
		return getPersistence()
				   .findBystatus_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the first recruitment process in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching recruitment process, or <code>null</code> if a matching recruitment process could not be found
	*/
	public static RecruitmentProcess fetchBystatus_First(long groupId,
		int status, OrderByComparator<RecruitmentProcess> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the last recruitment process in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching recruitment process
	* @throws NoSuchRecruitmentProcessException if a matching recruitment process could not be found
	*/
	public static RecruitmentProcess findBystatus_Last(long groupId,
		int status, OrderByComparator<RecruitmentProcess> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitmentProcessException {
		return getPersistence()
				   .findBystatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last recruitment process in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching recruitment process, or <code>null</code> if a matching recruitment process could not be found
	*/
	public static RecruitmentProcess fetchBystatus_Last(long groupId,
		int status, OrderByComparator<RecruitmentProcess> orderByComparator) {
		return getPersistence()
				   .fetchBystatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the recruitment processes before and after the current recruitment process in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param recruitmentProcessId the primary key of the current recruitment process
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next recruitment process
	* @throws NoSuchRecruitmentProcessException if a recruitment process with the primary key could not be found
	*/
	public static RecruitmentProcess[] findBystatus_PrevAndNext(
		long recruitmentProcessId, long groupId, int status,
		OrderByComparator<RecruitmentProcess> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitmentProcessException {
		return getPersistence()
				   .findBystatus_PrevAndNext(recruitmentProcessId, groupId,
			status, orderByComparator);
	}

	/**
	* Removes all the recruitment processes where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public static void removeBystatus(long groupId, int status) {
		getPersistence().removeBystatus(groupId, status);
	}

	/**
	* Returns the number of recruitment processes where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching recruitment processes
	*/
	public static int countBystatus(long groupId, int status) {
		return getPersistence().countBystatus(groupId, status);
	}

	/**
	* Caches the recruitment process in the entity cache if it is enabled.
	*
	* @param recruitmentProcess the recruitment process
	*/
	public static void cacheResult(RecruitmentProcess recruitmentProcess) {
		getPersistence().cacheResult(recruitmentProcess);
	}

	/**
	* Caches the recruitment processes in the entity cache if it is enabled.
	*
	* @param recruitmentProcesses the recruitment processes
	*/
	public static void cacheResult(
		List<RecruitmentProcess> recruitmentProcesses) {
		getPersistence().cacheResult(recruitmentProcesses);
	}

	/**
	* Creates a new recruitment process with the primary key. Does not add the recruitment process to the database.
	*
	* @param recruitmentProcessId the primary key for the new recruitment process
	* @return the new recruitment process
	*/
	public static RecruitmentProcess create(long recruitmentProcessId) {
		return getPersistence().create(recruitmentProcessId);
	}

	/**
	* Removes the recruitment process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProcessId the primary key of the recruitment process
	* @return the recruitment process that was removed
	* @throws NoSuchRecruitmentProcessException if a recruitment process with the primary key could not be found
	*/
	public static RecruitmentProcess remove(long recruitmentProcessId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitmentProcessException {
		return getPersistence().remove(recruitmentProcessId);
	}

	public static RecruitmentProcess updateImpl(
		RecruitmentProcess recruitmentProcess) {
		return getPersistence().updateImpl(recruitmentProcess);
	}

	/**
	* Returns the recruitment process with the primary key or throws a {@link NoSuchRecruitmentProcessException} if it could not be found.
	*
	* @param recruitmentProcessId the primary key of the recruitment process
	* @return the recruitment process
	* @throws NoSuchRecruitmentProcessException if a recruitment process with the primary key could not be found
	*/
	public static RecruitmentProcess findByPrimaryKey(long recruitmentProcessId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitmentProcessException {
		return getPersistence().findByPrimaryKey(recruitmentProcessId);
	}

	/**
	* Returns the recruitment process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recruitmentProcessId the primary key of the recruitment process
	* @return the recruitment process, or <code>null</code> if a recruitment process with the primary key could not be found
	*/
	public static RecruitmentProcess fetchByPrimaryKey(
		long recruitmentProcessId) {
		return getPersistence().fetchByPrimaryKey(recruitmentProcessId);
	}

	public static java.util.Map<java.io.Serializable, RecruitmentProcess> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the recruitment processes.
	*
	* @return the recruitment processes
	*/
	public static List<RecruitmentProcess> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the recruitment processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitmentProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of recruitment processes
	* @param end the upper bound of the range of recruitment processes (not inclusive)
	* @return the range of recruitment processes
	*/
	public static List<RecruitmentProcess> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the recruitment processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitmentProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of recruitment processes
	* @param end the upper bound of the range of recruitment processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of recruitment processes
	*/
	public static List<RecruitmentProcess> findAll(int start, int end,
		OrderByComparator<RecruitmentProcess> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the recruitment processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitmentProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of recruitment processes
	* @param end the upper bound of the range of recruitment processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of recruitment processes
	*/
	public static List<RecruitmentProcess> findAll(int start, int end,
		OrderByComparator<RecruitmentProcess> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the recruitment processes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of recruitment processes.
	*
	* @return the number of recruitment processes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RecruitmentProcessPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RecruitmentProcessPersistence, RecruitmentProcessPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RecruitmentProcessPersistence.class);

		ServiceTracker<RecruitmentProcessPersistence, RecruitmentProcessPersistence> serviceTracker =
			new ServiceTracker<RecruitmentProcessPersistence, RecruitmentProcessPersistence>(bundle.getBundleContext(),
				RecruitmentProcessPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}