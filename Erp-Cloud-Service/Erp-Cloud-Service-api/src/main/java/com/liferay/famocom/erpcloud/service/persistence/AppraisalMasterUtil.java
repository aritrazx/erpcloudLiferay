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

import com.liferay.famocom.erpcloud.model.AppraisalMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the appraisal master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AppraisalMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class AppraisalMasterUtil {
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
	public static void clearCache(AppraisalMaster appraisalMaster) {
		getPersistence().clearCache(appraisalMaster);
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
	public static List<AppraisalMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppraisalMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppraisalMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppraisalMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppraisalMaster update(AppraisalMaster appraisalMaster) {
		return getPersistence().update(appraisalMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppraisalMaster update(AppraisalMaster appraisalMaster,
		ServiceContext serviceContext) {
		return getPersistence().update(appraisalMaster, serviceContext);
	}

	/**
	* Returns the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; or throws a {@link NoSuchAppraisalMasterException} if it could not be found.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the matching appraisal master
	* @throws NoSuchAppraisalMasterException if a matching appraisal master could not be found
	*/
	public static AppraisalMaster findBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalMasterException {
		return getPersistence()
				   .findBySettingIdAndEmployeeId(appraisalSettingId, employeeId);
	}

	/**
	* Returns the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	*/
	public static AppraisalMaster fetchBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId) {
		return getPersistence()
				   .fetchBySettingIdAndEmployeeId(appraisalSettingId, employeeId);
	}

	/**
	* Returns the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	*/
	public static AppraisalMaster fetchBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBySettingIdAndEmployeeId(appraisalSettingId,
			employeeId, retrieveFromCache);
	}

	/**
	* Removes the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the appraisal master that was removed
	*/
	public static AppraisalMaster removeBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalMasterException {
		return getPersistence()
				   .removeBySettingIdAndEmployeeId(appraisalSettingId,
			employeeId);
	}

	/**
	* Returns the number of appraisal masters where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the number of matching appraisal masters
	*/
	public static int countBySettingIdAndEmployeeId(long appraisalSettingId,
		long employeeId) {
		return getPersistence()
				   .countBySettingIdAndEmployeeId(appraisalSettingId, employeeId);
	}

	/**
	* Returns all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @return the matching appraisal masters
	*/
	public static List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep) {
		return getPersistence()
				   .findBySettingIdAndsubmitStep(appraisalSettingId, submitStep);
	}

	/**
	* Returns a range of all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @return the range of matching appraisal masters
	*/
	public static List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep, int start, int end) {
		return getPersistence()
				   .findBySettingIdAndsubmitStep(appraisalSettingId,
			submitStep, start, end);
	}

	/**
	* Returns an ordered range of all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching appraisal masters
	*/
	public static List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep, int start, int end,
		OrderByComparator<AppraisalMaster> orderByComparator) {
		return getPersistence()
				   .findBySettingIdAndsubmitStep(appraisalSettingId,
			submitStep, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching appraisal masters
	*/
	public static List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep, int start, int end,
		OrderByComparator<AppraisalMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySettingIdAndsubmitStep(appraisalSettingId,
			submitStep, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal master
	* @throws NoSuchAppraisalMasterException if a matching appraisal master could not be found
	*/
	public static AppraisalMaster findBySettingIdAndsubmitStep_First(
		long appraisalSettingId, long submitStep,
		OrderByComparator<AppraisalMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalMasterException {
		return getPersistence()
				   .findBySettingIdAndsubmitStep_First(appraisalSettingId,
			submitStep, orderByComparator);
	}

	/**
	* Returns the first appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	*/
	public static AppraisalMaster fetchBySettingIdAndsubmitStep_First(
		long appraisalSettingId, long submitStep,
		OrderByComparator<AppraisalMaster> orderByComparator) {
		return getPersistence()
				   .fetchBySettingIdAndsubmitStep_First(appraisalSettingId,
			submitStep, orderByComparator);
	}

	/**
	* Returns the last appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal master
	* @throws NoSuchAppraisalMasterException if a matching appraisal master could not be found
	*/
	public static AppraisalMaster findBySettingIdAndsubmitStep_Last(
		long appraisalSettingId, long submitStep,
		OrderByComparator<AppraisalMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalMasterException {
		return getPersistence()
				   .findBySettingIdAndsubmitStep_Last(appraisalSettingId,
			submitStep, orderByComparator);
	}

	/**
	* Returns the last appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	*/
	public static AppraisalMaster fetchBySettingIdAndsubmitStep_Last(
		long appraisalSettingId, long submitStep,
		OrderByComparator<AppraisalMaster> orderByComparator) {
		return getPersistence()
				   .fetchBySettingIdAndsubmitStep_Last(appraisalSettingId,
			submitStep, orderByComparator);
	}

	/**
	* Returns the appraisal masters before and after the current appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalId the primary key of the current appraisal master
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next appraisal master
	* @throws NoSuchAppraisalMasterException if a appraisal master with the primary key could not be found
	*/
	public static AppraisalMaster[] findBySettingIdAndsubmitStep_PrevAndNext(
		long appraisalId, long appraisalSettingId, long submitStep,
		OrderByComparator<AppraisalMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalMasterException {
		return getPersistence()
				   .findBySettingIdAndsubmitStep_PrevAndNext(appraisalId,
			appraisalSettingId, submitStep, orderByComparator);
	}

	/**
	* Removes all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	*/
	public static void removeBySettingIdAndsubmitStep(long appraisalSettingId,
		long submitStep) {
		getPersistence()
			.removeBySettingIdAndsubmitStep(appraisalSettingId, submitStep);
	}

	/**
	* Returns the number of appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @return the number of matching appraisal masters
	*/
	public static int countBySettingIdAndsubmitStep(long appraisalSettingId,
		long submitStep) {
		return getPersistence()
				   .countBySettingIdAndsubmitStep(appraisalSettingId, submitStep);
	}

	/**
	* Caches the appraisal master in the entity cache if it is enabled.
	*
	* @param appraisalMaster the appraisal master
	*/
	public static void cacheResult(AppraisalMaster appraisalMaster) {
		getPersistence().cacheResult(appraisalMaster);
	}

	/**
	* Caches the appraisal masters in the entity cache if it is enabled.
	*
	* @param appraisalMasters the appraisal masters
	*/
	public static void cacheResult(List<AppraisalMaster> appraisalMasters) {
		getPersistence().cacheResult(appraisalMasters);
	}

	/**
	* Creates a new appraisal master with the primary key. Does not add the appraisal master to the database.
	*
	* @param appraisalId the primary key for the new appraisal master
	* @return the new appraisal master
	*/
	public static AppraisalMaster create(long appraisalId) {
		return getPersistence().create(appraisalId);
	}

	/**
	* Removes the appraisal master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalId the primary key of the appraisal master
	* @return the appraisal master that was removed
	* @throws NoSuchAppraisalMasterException if a appraisal master with the primary key could not be found
	*/
	public static AppraisalMaster remove(long appraisalId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalMasterException {
		return getPersistence().remove(appraisalId);
	}

	public static AppraisalMaster updateImpl(AppraisalMaster appraisalMaster) {
		return getPersistence().updateImpl(appraisalMaster);
	}

	/**
	* Returns the appraisal master with the primary key or throws a {@link NoSuchAppraisalMasterException} if it could not be found.
	*
	* @param appraisalId the primary key of the appraisal master
	* @return the appraisal master
	* @throws NoSuchAppraisalMasterException if a appraisal master with the primary key could not be found
	*/
	public static AppraisalMaster findByPrimaryKey(long appraisalId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalMasterException {
		return getPersistence().findByPrimaryKey(appraisalId);
	}

	/**
	* Returns the appraisal master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appraisalId the primary key of the appraisal master
	* @return the appraisal master, or <code>null</code> if a appraisal master with the primary key could not be found
	*/
	public static AppraisalMaster fetchByPrimaryKey(long appraisalId) {
		return getPersistence().fetchByPrimaryKey(appraisalId);
	}

	public static java.util.Map<java.io.Serializable, AppraisalMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the appraisal masters.
	*
	* @return the appraisal masters
	*/
	public static List<AppraisalMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the appraisal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @return the range of appraisal masters
	*/
	public static List<AppraisalMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the appraisal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of appraisal masters
	*/
	public static List<AppraisalMaster> findAll(int start, int end,
		OrderByComparator<AppraisalMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the appraisal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of appraisal masters
	*/
	public static List<AppraisalMaster> findAll(int start, int end,
		OrderByComparator<AppraisalMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the appraisal masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of appraisal masters.
	*
	* @return the number of appraisal masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppraisalMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AppraisalMasterPersistence, AppraisalMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AppraisalMasterPersistence.class);

		ServiceTracker<AppraisalMasterPersistence, AppraisalMasterPersistence> serviceTracker =
			new ServiceTracker<AppraisalMasterPersistence, AppraisalMasterPersistence>(bundle.getBundleContext(),
				AppraisalMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}