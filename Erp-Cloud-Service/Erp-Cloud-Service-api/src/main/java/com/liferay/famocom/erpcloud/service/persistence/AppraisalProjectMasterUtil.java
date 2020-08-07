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

import com.liferay.famocom.erpcloud.model.AppraisalProjectMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the appraisal project master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalProjectMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AppraisalProjectMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalProjectMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class AppraisalProjectMasterUtil {
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
	public static void clearCache(AppraisalProjectMaster appraisalProjectMaster) {
		getPersistence().clearCache(appraisalProjectMaster);
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
	public static List<AppraisalProjectMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppraisalProjectMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppraisalProjectMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppraisalProjectMaster update(
		AppraisalProjectMaster appraisalProjectMaster) {
		return getPersistence().update(appraisalProjectMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppraisalProjectMaster update(
		AppraisalProjectMaster appraisalProjectMaster,
		ServiceContext serviceContext) {
		return getPersistence().update(appraisalProjectMaster, serviceContext);
	}

	/**
	* Returns the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; or throws a {@link NoSuchAppraisalProjectMasterException} if it could not be found.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the matching appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster findBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence()
				   .findBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId,
			employeeId, projectId);
	}

	/**
	* Returns the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster fetchBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId) {
		return getPersistence()
				   .fetchBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId,
			employeeId, projectId);
	}

	/**
	* Returns the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster fetchBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId,
			employeeId, projectId, retrieveFromCache);
	}

	/**
	* Removes the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the appraisal project master that was removed
	*/
	public static AppraisalProjectMaster removeBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence()
				   .removeBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId,
			employeeId, projectId);
	}

	/**
	* Returns the number of appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the number of matching appraisal project masters
	*/
	public static int countBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId) {
		return getPersistence()
				   .countBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId,
			employeeId, projectId);
	}

	/**
	* Returns all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @return the matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId) {
		return getPersistence()
				   .findBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
			employeeId, appraisalId);
	}

	/**
	* Returns a range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @return the range of matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId, int start,
		int end) {
		return getPersistence()
				   .findBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
			employeeId, appraisalId, start, end);
	}

	/**
	* Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId, int start,
		int end, OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return getPersistence()
				   .findBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
			employeeId, appraisalId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId, int start,
		int end, OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
			employeeId, appraisalId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster findBySettingIdAndEmployeeIdAppraisalIdList_First(
		long appraisalSettingId, long employeeId, long appraisalId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence()
				   .findBySettingIdAndEmployeeIdAppraisalIdList_First(appraisalSettingId,
			employeeId, appraisalId, orderByComparator);
	}

	/**
	* Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster fetchBySettingIdAndEmployeeIdAppraisalIdList_First(
		long appraisalSettingId, long employeeId, long appraisalId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return getPersistence()
				   .fetchBySettingIdAndEmployeeIdAppraisalIdList_First(appraisalSettingId,
			employeeId, appraisalId, orderByComparator);
	}

	/**
	* Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster findBySettingIdAndEmployeeIdAppraisalIdList_Last(
		long appraisalSettingId, long employeeId, long appraisalId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence()
				   .findBySettingIdAndEmployeeIdAppraisalIdList_Last(appraisalSettingId,
			employeeId, appraisalId, orderByComparator);
	}

	/**
	* Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster fetchBySettingIdAndEmployeeIdAppraisalIdList_Last(
		long appraisalSettingId, long employeeId, long appraisalId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return getPersistence()
				   .fetchBySettingIdAndEmployeeIdAppraisalIdList_Last(appraisalSettingId,
			employeeId, appraisalId, orderByComparator);
	}

	/**
	* Returns the appraisal project masters before and after the current appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* @param appraisalProjectId the primary key of the current appraisal project master
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	*/
	public static AppraisalProjectMaster[] findBySettingIdAndEmployeeIdAppraisalIdList_PrevAndNext(
		long appraisalProjectId, long appraisalSettingId, long employeeId,
		long appraisalId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence()
				   .findBySettingIdAndEmployeeIdAppraisalIdList_PrevAndNext(appraisalProjectId,
			appraisalSettingId, employeeId, appraisalId, orderByComparator);
	}

	/**
	* Removes all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	*/
	public static void removeBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId) {
		getPersistence()
			.removeBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
			employeeId, appraisalId);
	}

	/**
	* Returns the number of appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @return the number of matching appraisal project masters
	*/
	public static int countBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId) {
		return getPersistence()
				   .countBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
			employeeId, appraisalId);
	}

	/**
	* Returns all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @return the matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep) {
		return getPersistence()
				   .findByemployeeListFromManager(appraisalSettingId,
			projectId, submitStep);
	}

	/**
	* Returns a range of all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @return the range of matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep, int start,
		int end) {
		return getPersistence()
				   .findByemployeeListFromManager(appraisalSettingId,
			projectId, submitStep, start, end);
	}

	/**
	* Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep, int start,
		int end, OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return getPersistence()
				   .findByemployeeListFromManager(appraisalSettingId,
			projectId, submitStep, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep, int start,
		int end, OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeListFromManager(appraisalSettingId,
			projectId, submitStep, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster findByemployeeListFromManager_First(
		long appraisalSettingId, long projectId, long submitStep,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence()
				   .findByemployeeListFromManager_First(appraisalSettingId,
			projectId, submitStep, orderByComparator);
	}

	/**
	* Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster fetchByemployeeListFromManager_First(
		long appraisalSettingId, long projectId, long submitStep,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeListFromManager_First(appraisalSettingId,
			projectId, submitStep, orderByComparator);
	}

	/**
	* Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster findByemployeeListFromManager_Last(
		long appraisalSettingId, long projectId, long submitStep,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence()
				   .findByemployeeListFromManager_Last(appraisalSettingId,
			projectId, submitStep, orderByComparator);
	}

	/**
	* Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster fetchByemployeeListFromManager_Last(
		long appraisalSettingId, long projectId, long submitStep,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeListFromManager_Last(appraisalSettingId,
			projectId, submitStep, orderByComparator);
	}

	/**
	* Returns the appraisal project masters before and after the current appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* @param appraisalProjectId the primary key of the current appraisal project master
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	*/
	public static AppraisalProjectMaster[] findByemployeeListFromManager_PrevAndNext(
		long appraisalProjectId, long appraisalSettingId, long projectId,
		long submitStep,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence()
				   .findByemployeeListFromManager_PrevAndNext(appraisalProjectId,
			appraisalSettingId, projectId, submitStep, orderByComparator);
	}

	/**
	* Removes all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	*/
	public static void removeByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep) {
		getPersistence()
			.removeByemployeeListFromManager(appraisalSettingId, projectId,
			submitStep);
	}

	/**
	* Returns the number of appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @return the number of matching appraisal project masters
	*/
	public static int countByemployeeListFromManager(long appraisalSettingId,
		long projectId, long submitStep) {
		return getPersistence()
				   .countByemployeeListFromManager(appraisalSettingId,
			projectId, submitStep);
	}

	/**
	* Returns all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId) {
		return getPersistence()
				   .findByappraisalSettingIdAndEmployeeId(appraisalSettingId,
			employeeId);
	}

	/**
	* Returns a range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @return the range of matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, int start, int end) {
		return getPersistence()
				   .findByappraisalSettingIdAndEmployeeId(appraisalSettingId,
			employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, int start, int end,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return getPersistence()
				   .findByappraisalSettingIdAndEmployeeId(appraisalSettingId,
			employeeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, int start, int end,
		OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByappraisalSettingIdAndEmployeeId(appraisalSettingId,
			employeeId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster findByappraisalSettingIdAndEmployeeId_First(
		long appraisalSettingId, long employeeId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence()
				   .findByappraisalSettingIdAndEmployeeId_First(appraisalSettingId,
			employeeId, orderByComparator);
	}

	/**
	* Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster fetchByappraisalSettingIdAndEmployeeId_First(
		long appraisalSettingId, long employeeId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return getPersistence()
				   .fetchByappraisalSettingIdAndEmployeeId_First(appraisalSettingId,
			employeeId, orderByComparator);
	}

	/**
	* Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster findByappraisalSettingIdAndEmployeeId_Last(
		long appraisalSettingId, long employeeId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence()
				   .findByappraisalSettingIdAndEmployeeId_Last(appraisalSettingId,
			employeeId, orderByComparator);
	}

	/**
	* Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public static AppraisalProjectMaster fetchByappraisalSettingIdAndEmployeeId_Last(
		long appraisalSettingId, long employeeId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return getPersistence()
				   .fetchByappraisalSettingIdAndEmployeeId_Last(appraisalSettingId,
			employeeId, orderByComparator);
	}

	/**
	* Returns the appraisal project masters before and after the current appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalProjectId the primary key of the current appraisal project master
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	*/
	public static AppraisalProjectMaster[] findByappraisalSettingIdAndEmployeeId_PrevAndNext(
		long appraisalProjectId, long appraisalSettingId, long employeeId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence()
				   .findByappraisalSettingIdAndEmployeeId_PrevAndNext(appraisalProjectId,
			appraisalSettingId, employeeId, orderByComparator);
	}

	/**
	* Removes all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	*/
	public static void removeByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId) {
		getPersistence()
			.removeByappraisalSettingIdAndEmployeeId(appraisalSettingId,
			employeeId);
	}

	/**
	* Returns the number of appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the number of matching appraisal project masters
	*/
	public static int countByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId) {
		return getPersistence()
				   .countByappraisalSettingIdAndEmployeeId(appraisalSettingId,
			employeeId);
	}

	/**
	* Caches the appraisal project master in the entity cache if it is enabled.
	*
	* @param appraisalProjectMaster the appraisal project master
	*/
	public static void cacheResult(
		AppraisalProjectMaster appraisalProjectMaster) {
		getPersistence().cacheResult(appraisalProjectMaster);
	}

	/**
	* Caches the appraisal project masters in the entity cache if it is enabled.
	*
	* @param appraisalProjectMasters the appraisal project masters
	*/
	public static void cacheResult(
		List<AppraisalProjectMaster> appraisalProjectMasters) {
		getPersistence().cacheResult(appraisalProjectMasters);
	}

	/**
	* Creates a new appraisal project master with the primary key. Does not add the appraisal project master to the database.
	*
	* @param appraisalProjectId the primary key for the new appraisal project master
	* @return the new appraisal project master
	*/
	public static AppraisalProjectMaster create(long appraisalProjectId) {
		return getPersistence().create(appraisalProjectId);
	}

	/**
	* Removes the appraisal project master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalProjectId the primary key of the appraisal project master
	* @return the appraisal project master that was removed
	* @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	*/
	public static AppraisalProjectMaster remove(long appraisalProjectId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence().remove(appraisalProjectId);
	}

	public static AppraisalProjectMaster updateImpl(
		AppraisalProjectMaster appraisalProjectMaster) {
		return getPersistence().updateImpl(appraisalProjectMaster);
	}

	/**
	* Returns the appraisal project master with the primary key or throws a {@link NoSuchAppraisalProjectMasterException} if it could not be found.
	*
	* @param appraisalProjectId the primary key of the appraisal project master
	* @return the appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	*/
	public static AppraisalProjectMaster findByPrimaryKey(
		long appraisalProjectId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException {
		return getPersistence().findByPrimaryKey(appraisalProjectId);
	}

	/**
	* Returns the appraisal project master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appraisalProjectId the primary key of the appraisal project master
	* @return the appraisal project master, or <code>null</code> if a appraisal project master with the primary key could not be found
	*/
	public static AppraisalProjectMaster fetchByPrimaryKey(
		long appraisalProjectId) {
		return getPersistence().fetchByPrimaryKey(appraisalProjectId);
	}

	public static java.util.Map<java.io.Serializable, AppraisalProjectMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the appraisal project masters.
	*
	* @return the appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the appraisal project masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @return the range of appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the appraisal project masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findAll(int start, int end,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the appraisal project masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of appraisal project masters
	*/
	public static List<AppraisalProjectMaster> findAll(int start, int end,
		OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the appraisal project masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of appraisal project masters.
	*
	* @return the number of appraisal project masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppraisalProjectMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AppraisalProjectMasterPersistence, AppraisalProjectMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AppraisalProjectMasterPersistence.class);

		ServiceTracker<AppraisalProjectMasterPersistence, AppraisalProjectMasterPersistence> serviceTracker =
			new ServiceTracker<AppraisalProjectMasterPersistence, AppraisalProjectMasterPersistence>(bundle.getBundleContext(),
				AppraisalProjectMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}