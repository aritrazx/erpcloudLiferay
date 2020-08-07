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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException;
import com.liferay.famocom.erpcloud.model.AppraisalProjectMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the appraisal project master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalProjectMasterPersistenceImpl
 * @see AppraisalProjectMasterUtil
 * @generated
 */
@ProviderType
public interface AppraisalProjectMasterPersistence extends BasePersistence<AppraisalProjectMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalProjectMasterUtil} to access the appraisal project master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; or throws a {@link NoSuchAppraisalProjectMasterException} if it could not be found.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the matching appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	*/
	public AppraisalProjectMaster findBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Returns the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public AppraisalProjectMaster fetchBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId);

	/**
	* Returns the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public AppraisalProjectMaster fetchBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId,
		boolean retrieveFromCache);

	/**
	* Removes the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the appraisal project master that was removed
	*/
	public AppraisalProjectMaster removeBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Returns the number of appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the number of matching appraisal project masters
	*/
	public int countBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId);

	/**
	* Returns all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @return the matching appraisal project masters
	*/
	public java.util.List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId);

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
	public java.util.List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId, int start,
		int end);

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
	public java.util.List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator);

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
	public java.util.List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean retrieveFromCache);

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
	public AppraisalProjectMaster findBySettingIdAndEmployeeIdAppraisalIdList_First(
		long appraisalSettingId, long employeeId, long appraisalId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public AppraisalProjectMaster fetchBySettingIdAndEmployeeIdAppraisalIdList_First(
		long appraisalSettingId, long employeeId, long appraisalId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator);

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
	public AppraisalProjectMaster findBySettingIdAndEmployeeIdAppraisalIdList_Last(
		long appraisalSettingId, long employeeId, long appraisalId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public AppraisalProjectMaster fetchBySettingIdAndEmployeeIdAppraisalIdList_Last(
		long appraisalSettingId, long employeeId, long appraisalId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator);

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
	public AppraisalProjectMaster[] findBySettingIdAndEmployeeIdAppraisalIdList_PrevAndNext(
		long appraisalProjectId, long appraisalSettingId, long employeeId,
		long appraisalId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Removes all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	*/
	public void removeBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId);

	/**
	* Returns the number of appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param appraisalId the appraisal ID
	* @return the number of matching appraisal project masters
	*/
	public int countBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId);

	/**
	* Returns all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @return the matching appraisal project masters
	*/
	public java.util.List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep);

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
	public java.util.List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep, int start,
		int end);

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
	public java.util.List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator);

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
	public java.util.List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean retrieveFromCache);

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
	public AppraisalProjectMaster findByemployeeListFromManager_First(
		long appraisalSettingId, long projectId, long submitStep,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public AppraisalProjectMaster fetchByemployeeListFromManager_First(
		long appraisalSettingId, long projectId, long submitStep,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator);

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
	public AppraisalProjectMaster findByemployeeListFromManager_Last(
		long appraisalSettingId, long projectId, long submitStep,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public AppraisalProjectMaster fetchByemployeeListFromManager_Last(
		long appraisalSettingId, long projectId, long submitStep,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator);

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
	public AppraisalProjectMaster[] findByemployeeListFromManager_PrevAndNext(
		long appraisalProjectId, long appraisalSettingId, long projectId,
		long submitStep,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Removes all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	*/
	public void removeByemployeeListFromManager(long appraisalSettingId,
		long projectId, long submitStep);

	/**
	* Returns the number of appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param projectId the project ID
	* @param submitStep the submit step
	* @return the number of matching appraisal project masters
	*/
	public int countByemployeeListFromManager(long appraisalSettingId,
		long projectId, long submitStep);

	/**
	* Returns all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the matching appraisal project masters
	*/
	public java.util.List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId);

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
	public java.util.List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, int start, int end);

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
	public java.util.List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator);

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
	public java.util.List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	*/
	public AppraisalProjectMaster findByappraisalSettingIdAndEmployeeId_First(
		long appraisalSettingId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public AppraisalProjectMaster fetchByappraisalSettingIdAndEmployeeId_First(
		long appraisalSettingId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator);

	/**
	* Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	*/
	public AppraisalProjectMaster findByappraisalSettingIdAndEmployeeId_Last(
		long appraisalSettingId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	*/
	public AppraisalProjectMaster fetchByappraisalSettingIdAndEmployeeId_Last(
		long appraisalSettingId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator);

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
	public AppraisalProjectMaster[] findByappraisalSettingIdAndEmployeeId_PrevAndNext(
		long appraisalProjectId, long appraisalSettingId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Removes all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	*/
	public void removeByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId);

	/**
	* Returns the number of appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the number of matching appraisal project masters
	*/
	public int countByappraisalSettingIdAndEmployeeId(long appraisalSettingId,
		long employeeId);

	/**
	* Caches the appraisal project master in the entity cache if it is enabled.
	*
	* @param appraisalProjectMaster the appraisal project master
	*/
	public void cacheResult(AppraisalProjectMaster appraisalProjectMaster);

	/**
	* Caches the appraisal project masters in the entity cache if it is enabled.
	*
	* @param appraisalProjectMasters the appraisal project masters
	*/
	public void cacheResult(
		java.util.List<AppraisalProjectMaster> appraisalProjectMasters);

	/**
	* Creates a new appraisal project master with the primary key. Does not add the appraisal project master to the database.
	*
	* @param appraisalProjectId the primary key for the new appraisal project master
	* @return the new appraisal project master
	*/
	public AppraisalProjectMaster create(long appraisalProjectId);

	/**
	* Removes the appraisal project master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalProjectId the primary key of the appraisal project master
	* @return the appraisal project master that was removed
	* @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	*/
	public AppraisalProjectMaster remove(long appraisalProjectId)
		throws NoSuchAppraisalProjectMasterException;

	public AppraisalProjectMaster updateImpl(
		AppraisalProjectMaster appraisalProjectMaster);

	/**
	* Returns the appraisal project master with the primary key or throws a {@link NoSuchAppraisalProjectMasterException} if it could not be found.
	*
	* @param appraisalProjectId the primary key of the appraisal project master
	* @return the appraisal project master
	* @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	*/
	public AppraisalProjectMaster findByPrimaryKey(long appraisalProjectId)
		throws NoSuchAppraisalProjectMasterException;

	/**
	* Returns the appraisal project master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appraisalProjectId the primary key of the appraisal project master
	* @return the appraisal project master, or <code>null</code> if a appraisal project master with the primary key could not be found
	*/
	public AppraisalProjectMaster fetchByPrimaryKey(long appraisalProjectId);

	@Override
	public java.util.Map<java.io.Serializable, AppraisalProjectMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the appraisal project masters.
	*
	* @return the appraisal project masters
	*/
	public java.util.List<AppraisalProjectMaster> findAll();

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
	public java.util.List<AppraisalProjectMaster> findAll(int start, int end);

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
	public java.util.List<AppraisalProjectMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator);

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
	public java.util.List<AppraisalProjectMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the appraisal project masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of appraisal project masters.
	*
	* @return the number of appraisal project masters
	*/
	public int countAll();
}