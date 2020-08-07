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

import com.liferay.famocom.erpcloud.model.AppraisalPerformance;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the appraisal performance service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalPerformancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AppraisalPerformancePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalPerformancePersistenceImpl
 * @generated
 */
@ProviderType
public class AppraisalPerformanceUtil {
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
	public static void clearCache(AppraisalPerformance appraisalPerformance) {
		getPersistence().clearCache(appraisalPerformance);
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
	public static List<AppraisalPerformance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppraisalPerformance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppraisalPerformance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppraisalPerformance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppraisalPerformance update(
		AppraisalPerformance appraisalPerformance) {
		return getPersistence().update(appraisalPerformance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppraisalPerformance update(
		AppraisalPerformance appraisalPerformance, ServiceContext serviceContext) {
		return getPersistence().update(appraisalPerformance, serviceContext);
	}

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; or throws a {@link NoSuchAppraisalPerformanceException} if it could not be found.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the matching appraisal performance
	* @throws NoSuchAppraisalPerformanceException if a matching appraisal performance could not be found
	*/
	public static AppraisalPerformance findByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalPerformanceException {
		return getPersistence()
				   .findByApprIdSettingIdAndEmployeeIdPerformance(appraisalId,
			appraisalSettingId, employeeId);
	}

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	*/
	public static AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId) {
		return getPersistence()
				   .fetchByApprIdSettingIdAndEmployeeIdPerformance(appraisalId,
			appraisalSettingId, employeeId);
	}

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	*/
	public static AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByApprIdSettingIdAndEmployeeIdPerformance(appraisalId,
			appraisalSettingId, employeeId, retrieveFromCache);
	}

	/**
	* Removes the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; from the database.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the appraisal performance that was removed
	*/
	public static AppraisalPerformance removeByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalPerformanceException {
		return getPersistence()
				   .removeByApprIdSettingIdAndEmployeeIdPerformance(appraisalId,
			appraisalSettingId, employeeId);
	}

	/**
	* Returns the number of appraisal performances where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the number of matching appraisal performances
	*/
	public static int countByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId) {
		return getPersistence()
				   .countByApprIdSettingIdAndEmployeeIdPerformance(appraisalId,
			appraisalSettingId, employeeId);
	}

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; or throws a {@link NoSuchAppraisalPerformanceException} if it could not be found.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param performanceId the performance ID
	* @return the matching appraisal performance
	* @throws NoSuchAppraisalPerformanceException if a matching appraisal performance could not be found
	*/
	public static AppraisalPerformance findByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalPerformanceException {
		return getPersistence()
				   .findByApprIdSettingIdAndEmployeeIdPerformId(appraisalId,
			appraisalSettingId, employeeId, performanceId);
	}

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param performanceId the performance ID
	* @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	*/
	public static AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId) {
		return getPersistence()
				   .fetchByApprIdSettingIdAndEmployeeIdPerformId(appraisalId,
			appraisalSettingId, employeeId, performanceId);
	}

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param performanceId the performance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	*/
	public static AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByApprIdSettingIdAndEmployeeIdPerformId(appraisalId,
			appraisalSettingId, employeeId, performanceId, retrieveFromCache);
	}

	/**
	* Removes the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; from the database.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param performanceId the performance ID
	* @return the appraisal performance that was removed
	*/
	public static AppraisalPerformance removeByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalPerformanceException {
		return getPersistence()
				   .removeByApprIdSettingIdAndEmployeeIdPerformId(appraisalId,
			appraisalSettingId, employeeId, performanceId);
	}

	/**
	* Returns the number of appraisal performances where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63;.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param performanceId the performance ID
	* @return the number of matching appraisal performances
	*/
	public static int countByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId) {
		return getPersistence()
				   .countByApprIdSettingIdAndEmployeeIdPerformId(appraisalId,
			appraisalSettingId, employeeId, performanceId);
	}

	/**
	* Caches the appraisal performance in the entity cache if it is enabled.
	*
	* @param appraisalPerformance the appraisal performance
	*/
	public static void cacheResult(AppraisalPerformance appraisalPerformance) {
		getPersistence().cacheResult(appraisalPerformance);
	}

	/**
	* Caches the appraisal performances in the entity cache if it is enabled.
	*
	* @param appraisalPerformances the appraisal performances
	*/
	public static void cacheResult(
		List<AppraisalPerformance> appraisalPerformances) {
		getPersistence().cacheResult(appraisalPerformances);
	}

	/**
	* Creates a new appraisal performance with the primary key. Does not add the appraisal performance to the database.
	*
	* @param appraisalPerformanceId the primary key for the new appraisal performance
	* @return the new appraisal performance
	*/
	public static AppraisalPerformance create(long appraisalPerformanceId) {
		return getPersistence().create(appraisalPerformanceId);
	}

	/**
	* Removes the appraisal performance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalPerformanceId the primary key of the appraisal performance
	* @return the appraisal performance that was removed
	* @throws NoSuchAppraisalPerformanceException if a appraisal performance with the primary key could not be found
	*/
	public static AppraisalPerformance remove(long appraisalPerformanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalPerformanceException {
		return getPersistence().remove(appraisalPerformanceId);
	}

	public static AppraisalPerformance updateImpl(
		AppraisalPerformance appraisalPerformance) {
		return getPersistence().updateImpl(appraisalPerformance);
	}

	/**
	* Returns the appraisal performance with the primary key or throws a {@link NoSuchAppraisalPerformanceException} if it could not be found.
	*
	* @param appraisalPerformanceId the primary key of the appraisal performance
	* @return the appraisal performance
	* @throws NoSuchAppraisalPerformanceException if a appraisal performance with the primary key could not be found
	*/
	public static AppraisalPerformance findByPrimaryKey(
		long appraisalPerformanceId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalPerformanceException {
		return getPersistence().findByPrimaryKey(appraisalPerformanceId);
	}

	/**
	* Returns the appraisal performance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appraisalPerformanceId the primary key of the appraisal performance
	* @return the appraisal performance, or <code>null</code> if a appraisal performance with the primary key could not be found
	*/
	public static AppraisalPerformance fetchByPrimaryKey(
		long appraisalPerformanceId) {
		return getPersistence().fetchByPrimaryKey(appraisalPerformanceId);
	}

	public static java.util.Map<java.io.Serializable, AppraisalPerformance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the appraisal performances.
	*
	* @return the appraisal performances
	*/
	public static List<AppraisalPerformance> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the appraisal performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal performances
	* @param end the upper bound of the range of appraisal performances (not inclusive)
	* @return the range of appraisal performances
	*/
	public static List<AppraisalPerformance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the appraisal performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal performances
	* @param end the upper bound of the range of appraisal performances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of appraisal performances
	*/
	public static List<AppraisalPerformance> findAll(int start, int end,
		OrderByComparator<AppraisalPerformance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the appraisal performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal performances
	* @param end the upper bound of the range of appraisal performances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of appraisal performances
	*/
	public static List<AppraisalPerformance> findAll(int start, int end,
		OrderByComparator<AppraisalPerformance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the appraisal performances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of appraisal performances.
	*
	* @return the number of appraisal performances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppraisalPerformancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AppraisalPerformancePersistence, AppraisalPerformancePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AppraisalPerformancePersistence.class);

		ServiceTracker<AppraisalPerformancePersistence, AppraisalPerformancePersistence> serviceTracker =
			new ServiceTracker<AppraisalPerformancePersistence, AppraisalPerformancePersistence>(bundle.getBundleContext(),
				AppraisalPerformancePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}