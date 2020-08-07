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

import com.liferay.famocom.erpcloud.model.AddTeamMember;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the add team member service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.AddTeamMemberPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AddTeamMemberPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AddTeamMemberPersistenceImpl
 * @generated
 */
@ProviderType
public class AddTeamMemberUtil {
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
	public static void clearCache(AddTeamMember addTeamMember) {
		getPersistence().clearCache(addTeamMember);
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
	public static List<AddTeamMember> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AddTeamMember> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AddTeamMember> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AddTeamMember update(AddTeamMember addTeamMember) {
		return getPersistence().update(addTeamMember);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AddTeamMember update(AddTeamMember addTeamMember,
		ServiceContext serviceContext) {
		return getPersistence().update(addTeamMember, serviceContext);
	}

	/**
	* Returns all the add team members where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @return the matching add team members
	*/
	public static List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId) {
		return getPersistence().findBygetProjectId(employeeId, companyId);
	}

	/**
	* Returns a range of all the add team members where employeeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @return the range of matching add team members
	*/
	public static List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId, int start, int end) {
		return getPersistence()
				   .findBygetProjectId(employeeId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the add team members where employeeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching add team members
	*/
	public static List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId, int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .findBygetProjectId(employeeId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the add team members where employeeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching add team members
	*/
	public static List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId, int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBygetProjectId(employeeId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public static AddTeamMember findBygetProjectId_First(long employeeId,
		long companyId, OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findBygetProjectId_First(employeeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchBygetProjectId_First(long employeeId,
		long companyId, OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .fetchBygetProjectId_First(employeeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public static AddTeamMember findBygetProjectId_Last(long employeeId,
		long companyId, OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findBygetProjectId_Last(employeeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchBygetProjectId_Last(long employeeId,
		long companyId, OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .fetchBygetProjectId_Last(employeeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the add team members before and after the current add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param projectTeamsId the primary key of the current add team member
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next add team member
	* @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	*/
	public static AddTeamMember[] findBygetProjectId_PrevAndNext(
		long projectTeamsId, long employeeId, long companyId,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findBygetProjectId_PrevAndNext(projectTeamsId, employeeId,
			companyId, orderByComparator);
	}

	/**
	* Removes all the add team members where employeeId = &#63; and companyId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	*/
	public static void removeBygetProjectId(long employeeId, long companyId) {
		getPersistence().removeBygetProjectId(employeeId, companyId);
	}

	/**
	* Returns the number of add team members where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @return the number of matching add team members
	*/
	public static int countBygetProjectId(long employeeId, long companyId) {
		return getPersistence().countBygetProjectId(employeeId, companyId);
	}

	/**
	* Returns all the add team members where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @return the matching add team members
	*/
	public static List<AddTeamMember> findByprojectManager(
		boolean isProjectManager) {
		return getPersistence().findByprojectManager(isProjectManager);
	}

	/**
	* Returns a range of all the add team members where isProjectManager = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isProjectManager the is project manager
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @return the range of matching add team members
	*/
	public static List<AddTeamMember> findByprojectManager(
		boolean isProjectManager, int start, int end) {
		return getPersistence()
				   .findByprojectManager(isProjectManager, start, end);
	}

	/**
	* Returns an ordered range of all the add team members where isProjectManager = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isProjectManager the is project manager
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching add team members
	*/
	public static List<AddTeamMember> findByprojectManager(
		boolean isProjectManager, int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .findByprojectManager(isProjectManager, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the add team members where isProjectManager = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isProjectManager the is project manager
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching add team members
	*/
	public static List<AddTeamMember> findByprojectManager(
		boolean isProjectManager, int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByprojectManager(isProjectManager, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first add team member in the ordered set where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public static AddTeamMember findByprojectManager_First(
		boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findByprojectManager_First(isProjectManager,
			orderByComparator);
	}

	/**
	* Returns the first add team member in the ordered set where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchByprojectManager_First(
		boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .fetchByprojectManager_First(isProjectManager,
			orderByComparator);
	}

	/**
	* Returns the last add team member in the ordered set where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public static AddTeamMember findByprojectManager_Last(
		boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findByprojectManager_Last(isProjectManager,
			orderByComparator);
	}

	/**
	* Returns the last add team member in the ordered set where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchByprojectManager_Last(
		boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .fetchByprojectManager_Last(isProjectManager,
			orderByComparator);
	}

	/**
	* Returns the add team members before and after the current add team member in the ordered set where isProjectManager = &#63;.
	*
	* @param projectTeamsId the primary key of the current add team member
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next add team member
	* @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	*/
	public static AddTeamMember[] findByprojectManager_PrevAndNext(
		long projectTeamsId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findByprojectManager_PrevAndNext(projectTeamsId,
			isProjectManager, orderByComparator);
	}

	/**
	* Removes all the add team members where isProjectManager = &#63; from the database.
	*
	* @param isProjectManager the is project manager
	*/
	public static void removeByprojectManager(boolean isProjectManager) {
		getPersistence().removeByprojectManager(isProjectManager);
	}

	/**
	* Returns the number of add team members where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @return the number of matching add team members
	*/
	public static int countByprojectManager(boolean isProjectManager) {
		return getPersistence().countByprojectManager(isProjectManager);
	}

	/**
	* Returns all the add team members where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the matching add team members
	*/
	public static List<AddTeamMember> findByprojectMember(long projectId) {
		return getPersistence().findByprojectMember(projectId);
	}

	/**
	* Returns a range of all the add team members where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @return the range of matching add team members
	*/
	public static List<AddTeamMember> findByprojectMember(long projectId,
		int start, int end) {
		return getPersistence().findByprojectMember(projectId, start, end);
	}

	/**
	* Returns an ordered range of all the add team members where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching add team members
	*/
	public static List<AddTeamMember> findByprojectMember(long projectId,
		int start, int end, OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .findByprojectMember(projectId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the add team members where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching add team members
	*/
	public static List<AddTeamMember> findByprojectMember(long projectId,
		int start, int end, OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByprojectMember(projectId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first add team member in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public static AddTeamMember findByprojectMember_First(long projectId,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findByprojectMember_First(projectId, orderByComparator);
	}

	/**
	* Returns the first add team member in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchByprojectMember_First(long projectId,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .fetchByprojectMember_First(projectId, orderByComparator);
	}

	/**
	* Returns the last add team member in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public static AddTeamMember findByprojectMember_Last(long projectId,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findByprojectMember_Last(projectId, orderByComparator);
	}

	/**
	* Returns the last add team member in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchByprojectMember_Last(long projectId,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .fetchByprojectMember_Last(projectId, orderByComparator);
	}

	/**
	* Returns the add team members before and after the current add team member in the ordered set where projectId = &#63;.
	*
	* @param projectTeamsId the primary key of the current add team member
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next add team member
	* @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	*/
	public static AddTeamMember[] findByprojectMember_PrevAndNext(
		long projectTeamsId, long projectId,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findByprojectMember_PrevAndNext(projectTeamsId, projectId,
			orderByComparator);
	}

	/**
	* Removes all the add team members where projectId = &#63; from the database.
	*
	* @param projectId the project ID
	*/
	public static void removeByprojectMember(long projectId) {
		getPersistence().removeByprojectMember(projectId);
	}

	/**
	* Returns the number of add team members where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the number of matching add team members
	*/
	public static int countByprojectMember(long projectId) {
		return getPersistence().countByprojectMember(projectId);
	}

	/**
	* Returns the add team member where employeeId = &#63; and projectId = &#63; or throws a {@link NoSuchAddTeamMemberException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public static AddTeamMember findBygetProjectManager(long employeeId,
		long projectId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence().findBygetProjectManager(employeeId, projectId);
	}

	/**
	* Returns the add team member where employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchBygetProjectManager(long employeeId,
		long projectId) {
		return getPersistence().fetchBygetProjectManager(employeeId, projectId);
	}

	/**
	* Returns the add team member where employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchBygetProjectManager(long employeeId,
		long projectId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBygetProjectManager(employeeId, projectId,
			retrieveFromCache);
	}

	/**
	* Removes the add team member where employeeId = &#63; and projectId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the add team member that was removed
	*/
	public static AddTeamMember removeBygetProjectManager(long employeeId,
		long projectId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence().removeBygetProjectManager(employeeId, projectId);
	}

	/**
	* Returns the number of add team members where employeeId = &#63; and projectId = &#63;.
	*
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the number of matching add team members
	*/
	public static int countBygetProjectManager(long employeeId, long projectId) {
		return getPersistence().countBygetProjectManager(employeeId, projectId);
	}

	/**
	* Returns all the add team members where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the matching add team members
	*/
	public static List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager) {
		return getPersistence()
				   .findBygetProjectManagerProjectList(employeeId,
			isProjectManager);
	}

	/**
	* Returns a range of all the add team members where employeeId = &#63; and isProjectManager = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @return the range of matching add team members
	*/
	public static List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager, int start, int end) {
		return getPersistence()
				   .findBygetProjectManagerProjectList(employeeId,
			isProjectManager, start, end);
	}

	/**
	* Returns an ordered range of all the add team members where employeeId = &#63; and isProjectManager = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching add team members
	*/
	public static List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager, int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .findBygetProjectManagerProjectList(employeeId,
			isProjectManager, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the add team members where employeeId = &#63; and isProjectManager = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching add team members
	*/
	public static List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager, int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBygetProjectManagerProjectList(employeeId,
			isProjectManager, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public static AddTeamMember findBygetProjectManagerProjectList_First(
		long employeeId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findBygetProjectManagerProjectList_First(employeeId,
			isProjectManager, orderByComparator);
	}

	/**
	* Returns the first add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchBygetProjectManagerProjectList_First(
		long employeeId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .fetchBygetProjectManagerProjectList_First(employeeId,
			isProjectManager, orderByComparator);
	}

	/**
	* Returns the last add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public static AddTeamMember findBygetProjectManagerProjectList_Last(
		long employeeId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findBygetProjectManagerProjectList_Last(employeeId,
			isProjectManager, orderByComparator);
	}

	/**
	* Returns the last add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchBygetProjectManagerProjectList_Last(
		long employeeId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence()
				   .fetchBygetProjectManagerProjectList_Last(employeeId,
			isProjectManager, orderByComparator);
	}

	/**
	* Returns the add team members before and after the current add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param projectTeamsId the primary key of the current add team member
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next add team member
	* @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	*/
	public static AddTeamMember[] findBygetProjectManagerProjectList_PrevAndNext(
		long projectTeamsId, long employeeId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findBygetProjectManagerProjectList_PrevAndNext(projectTeamsId,
			employeeId, isProjectManager, orderByComparator);
	}

	/**
	* Removes all the add team members where employeeId = &#63; and isProjectManager = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	*/
	public static void removeBygetProjectManagerProjectList(long employeeId,
		boolean isProjectManager) {
		getPersistence()
			.removeBygetProjectManagerProjectList(employeeId, isProjectManager);
	}

	/**
	* Returns the number of add team members where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the number of matching add team members
	*/
	public static int countBygetProjectManagerProjectList(long employeeId,
		boolean isProjectManager) {
		return getPersistence()
				   .countBygetProjectManagerProjectList(employeeId,
			isProjectManager);
	}

	/**
	* Returns the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; or throws a {@link NoSuchAddTeamMemberException} if it could not be found.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public static AddTeamMember findBygetProjectManagerProject(long projectId,
		long employeeId, boolean isProjectManager)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .findBygetProjectManagerProject(projectId, employeeId,
			isProjectManager);
	}

	/**
	* Returns the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchBygetProjectManagerProject(
		long projectId, long employeeId, boolean isProjectManager) {
		return getPersistence()
				   .fetchBygetProjectManagerProject(projectId, employeeId,
			isProjectManager);
	}

	/**
	* Returns the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public static AddTeamMember fetchBygetProjectManagerProject(
		long projectId, long employeeId, boolean isProjectManager,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBygetProjectManagerProject(projectId, employeeId,
			isProjectManager, retrieveFromCache);
	}

	/**
	* Removes the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; from the database.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the add team member that was removed
	*/
	public static AddTeamMember removeBygetProjectManagerProject(
		long projectId, long employeeId, boolean isProjectManager)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence()
				   .removeBygetProjectManagerProject(projectId, employeeId,
			isProjectManager);
	}

	/**
	* Returns the number of add team members where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the number of matching add team members
	*/
	public static int countBygetProjectManagerProject(long projectId,
		long employeeId, boolean isProjectManager) {
		return getPersistence()
				   .countBygetProjectManagerProject(projectId, employeeId,
			isProjectManager);
	}

	/**
	* Caches the add team member in the entity cache if it is enabled.
	*
	* @param addTeamMember the add team member
	*/
	public static void cacheResult(AddTeamMember addTeamMember) {
		getPersistence().cacheResult(addTeamMember);
	}

	/**
	* Caches the add team members in the entity cache if it is enabled.
	*
	* @param addTeamMembers the add team members
	*/
	public static void cacheResult(List<AddTeamMember> addTeamMembers) {
		getPersistence().cacheResult(addTeamMembers);
	}

	/**
	* Creates a new add team member with the primary key. Does not add the add team member to the database.
	*
	* @param projectTeamsId the primary key for the new add team member
	* @return the new add team member
	*/
	public static AddTeamMember create(long projectTeamsId) {
		return getPersistence().create(projectTeamsId);
	}

	/**
	* Removes the add team member with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectTeamsId the primary key of the add team member
	* @return the add team member that was removed
	* @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	*/
	public static AddTeamMember remove(long projectTeamsId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence().remove(projectTeamsId);
	}

	public static AddTeamMember updateImpl(AddTeamMember addTeamMember) {
		return getPersistence().updateImpl(addTeamMember);
	}

	/**
	* Returns the add team member with the primary key or throws a {@link NoSuchAddTeamMemberException} if it could not be found.
	*
	* @param projectTeamsId the primary key of the add team member
	* @return the add team member
	* @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	*/
	public static AddTeamMember findByPrimaryKey(long projectTeamsId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException {
		return getPersistence().findByPrimaryKey(projectTeamsId);
	}

	/**
	* Returns the add team member with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectTeamsId the primary key of the add team member
	* @return the add team member, or <code>null</code> if a add team member with the primary key could not be found
	*/
	public static AddTeamMember fetchByPrimaryKey(long projectTeamsId) {
		return getPersistence().fetchByPrimaryKey(projectTeamsId);
	}

	public static java.util.Map<java.io.Serializable, AddTeamMember> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the add team members.
	*
	* @return the add team members
	*/
	public static List<AddTeamMember> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the add team members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @return the range of add team members
	*/
	public static List<AddTeamMember> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the add team members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of add team members
	*/
	public static List<AddTeamMember> findAll(int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the add team members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of add team members
	* @param end the upper bound of the range of add team members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of add team members
	*/
	public static List<AddTeamMember> findAll(int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the add team members from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of add team members.
	*
	* @return the number of add team members
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AddTeamMemberPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AddTeamMemberPersistence, AddTeamMemberPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AddTeamMemberPersistence.class);

		ServiceTracker<AddTeamMemberPersistence, AddTeamMemberPersistence> serviceTracker =
			new ServiceTracker<AddTeamMemberPersistence, AddTeamMemberPersistence>(bundle.getBundleContext(),
				AddTeamMemberPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}