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

import com.liferay.famocom.erpcloud.model.RecruitProcess;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the recruit process service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.RecruitProcessPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see RecruitProcessPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.RecruitProcessPersistenceImpl
 * @generated
 */
@ProviderType
public class RecruitProcessUtil {
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
	public static void clearCache(RecruitProcess recruitProcess) {
		getPersistence().clearCache(recruitProcess);
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
	public static List<RecruitProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RecruitProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RecruitProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RecruitProcess> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RecruitProcess update(RecruitProcess recruitProcess) {
		return getPersistence().update(recruitProcess);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RecruitProcess update(RecruitProcess recruitProcess,
		ServiceContext serviceContext) {
		return getPersistence().update(recruitProcess, serviceContext);
	}

	/**
	* Returns the recruit process where employeeId = &#63; or throws a {@link NoSuchRecruitProcessException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @return the matching recruit process
	* @throws NoSuchRecruitProcessException if a matching recruit process could not be found
	*/
	public static RecruitProcess findByrecruitProcess(long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return getPersistence().findByrecruitProcess(employeeId);
	}

	/**
	* Returns the recruit process where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @return the matching recruit process, or <code>null</code> if a matching recruit process could not be found
	*/
	public static RecruitProcess fetchByrecruitProcess(long employeeId) {
		return getPersistence().fetchByrecruitProcess(employeeId);
	}

	/**
	* Returns the recruit process where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching recruit process, or <code>null</code> if a matching recruit process could not be found
	*/
	public static RecruitProcess fetchByrecruitProcess(long employeeId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByrecruitProcess(employeeId, retrieveFromCache);
	}

	/**
	* Removes the recruit process where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @return the recruit process that was removed
	*/
	public static RecruitProcess removeByrecruitProcess(long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return getPersistence().removeByrecruitProcess(employeeId);
	}

	/**
	* Returns the number of recruit processes where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching recruit processes
	*/
	public static int countByrecruitProcess(long employeeId) {
		return getPersistence().countByrecruitProcess(employeeId);
	}

	/**
	* Returns all the recruit processes where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching recruit processes
	*/
	public static List<RecruitProcess> findByrecruitProcessCol(long employeeId) {
		return getPersistence().findByrecruitProcessCol(employeeId);
	}

	/**
	* Returns a range of all the recruit processes where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of recruit processes
	* @param end the upper bound of the range of recruit processes (not inclusive)
	* @return the range of matching recruit processes
	*/
	public static List<RecruitProcess> findByrecruitProcessCol(
		long employeeId, int start, int end) {
		return getPersistence().findByrecruitProcessCol(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the recruit processes where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of recruit processes
	* @param end the upper bound of the range of recruit processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching recruit processes
	*/
	public static List<RecruitProcess> findByrecruitProcessCol(
		long employeeId, int start, int end,
		OrderByComparator<RecruitProcess> orderByComparator) {
		return getPersistence()
				   .findByrecruitProcessCol(employeeId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the recruit processes where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of recruit processes
	* @param end the upper bound of the range of recruit processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching recruit processes
	*/
	public static List<RecruitProcess> findByrecruitProcessCol(
		long employeeId, int start, int end,
		OrderByComparator<RecruitProcess> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByrecruitProcessCol(employeeId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first recruit process in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching recruit process
	* @throws NoSuchRecruitProcessException if a matching recruit process could not be found
	*/
	public static RecruitProcess findByrecruitProcessCol_First(
		long employeeId, OrderByComparator<RecruitProcess> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return getPersistence()
				   .findByrecruitProcessCol_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first recruit process in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching recruit process, or <code>null</code> if a matching recruit process could not be found
	*/
	public static RecruitProcess fetchByrecruitProcessCol_First(
		long employeeId, OrderByComparator<RecruitProcess> orderByComparator) {
		return getPersistence()
				   .fetchByrecruitProcessCol_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last recruit process in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching recruit process
	* @throws NoSuchRecruitProcessException if a matching recruit process could not be found
	*/
	public static RecruitProcess findByrecruitProcessCol_Last(long employeeId,
		OrderByComparator<RecruitProcess> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return getPersistence()
				   .findByrecruitProcessCol_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last recruit process in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching recruit process, or <code>null</code> if a matching recruit process could not be found
	*/
	public static RecruitProcess fetchByrecruitProcessCol_Last(
		long employeeId, OrderByComparator<RecruitProcess> orderByComparator) {
		return getPersistence()
				   .fetchByrecruitProcessCol_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the recruit processes before and after the current recruit process in the ordered set where employeeId = &#63;.
	*
	* @param recruitProcessId the primary key of the current recruit process
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next recruit process
	* @throws NoSuchRecruitProcessException if a recruit process with the primary key could not be found
	*/
	public static RecruitProcess[] findByrecruitProcessCol_PrevAndNext(
		long recruitProcessId, long employeeId,
		OrderByComparator<RecruitProcess> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return getPersistence()
				   .findByrecruitProcessCol_PrevAndNext(recruitProcessId,
			employeeId, orderByComparator);
	}

	/**
	* Removes all the recruit processes where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeByrecruitProcessCol(long employeeId) {
		getPersistence().removeByrecruitProcessCol(employeeId);
	}

	/**
	* Returns the number of recruit processes where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching recruit processes
	*/
	public static int countByrecruitProcessCol(long employeeId) {
		return getPersistence().countByrecruitProcessCol(employeeId);
	}

	/**
	* Caches the recruit process in the entity cache if it is enabled.
	*
	* @param recruitProcess the recruit process
	*/
	public static void cacheResult(RecruitProcess recruitProcess) {
		getPersistence().cacheResult(recruitProcess);
	}

	/**
	* Caches the recruit processes in the entity cache if it is enabled.
	*
	* @param recruitProcesses the recruit processes
	*/
	public static void cacheResult(List<RecruitProcess> recruitProcesses) {
		getPersistence().cacheResult(recruitProcesses);
	}

	/**
	* Creates a new recruit process with the primary key. Does not add the recruit process to the database.
	*
	* @param recruitProcessId the primary key for the new recruit process
	* @return the new recruit process
	*/
	public static RecruitProcess create(long recruitProcessId) {
		return getPersistence().create(recruitProcessId);
	}

	/**
	* Removes the recruit process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitProcessId the primary key of the recruit process
	* @return the recruit process that was removed
	* @throws NoSuchRecruitProcessException if a recruit process with the primary key could not be found
	*/
	public static RecruitProcess remove(long recruitProcessId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return getPersistence().remove(recruitProcessId);
	}

	public static RecruitProcess updateImpl(RecruitProcess recruitProcess) {
		return getPersistence().updateImpl(recruitProcess);
	}

	/**
	* Returns the recruit process with the primary key or throws a {@link NoSuchRecruitProcessException} if it could not be found.
	*
	* @param recruitProcessId the primary key of the recruit process
	* @return the recruit process
	* @throws NoSuchRecruitProcessException if a recruit process with the primary key could not be found
	*/
	public static RecruitProcess findByPrimaryKey(long recruitProcessId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return getPersistence().findByPrimaryKey(recruitProcessId);
	}

	/**
	* Returns the recruit process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recruitProcessId the primary key of the recruit process
	* @return the recruit process, or <code>null</code> if a recruit process with the primary key could not be found
	*/
	public static RecruitProcess fetchByPrimaryKey(long recruitProcessId) {
		return getPersistence().fetchByPrimaryKey(recruitProcessId);
	}

	public static java.util.Map<java.io.Serializable, RecruitProcess> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the recruit processes.
	*
	* @return the recruit processes
	*/
	public static List<RecruitProcess> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the recruit processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of recruit processes
	* @param end the upper bound of the range of recruit processes (not inclusive)
	* @return the range of recruit processes
	*/
	public static List<RecruitProcess> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the recruit processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of recruit processes
	* @param end the upper bound of the range of recruit processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of recruit processes
	*/
	public static List<RecruitProcess> findAll(int start, int end,
		OrderByComparator<RecruitProcess> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the recruit processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of recruit processes
	* @param end the upper bound of the range of recruit processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of recruit processes
	*/
	public static List<RecruitProcess> findAll(int start, int end,
		OrderByComparator<RecruitProcess> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the recruit processes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of recruit processes.
	*
	* @return the number of recruit processes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RecruitProcessPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RecruitProcessPersistence, RecruitProcessPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RecruitProcessPersistence.class);

		ServiceTracker<RecruitProcessPersistence, RecruitProcessPersistence> serviceTracker =
			new ServiceTracker<RecruitProcessPersistence, RecruitProcessPersistence>(bundle.getBundleContext(),
				RecruitProcessPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}