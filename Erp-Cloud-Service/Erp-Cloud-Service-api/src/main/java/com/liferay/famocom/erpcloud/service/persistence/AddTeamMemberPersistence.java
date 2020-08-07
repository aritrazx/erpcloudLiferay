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

import com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException;
import com.liferay.famocom.erpcloud.model.AddTeamMember;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the add team member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AddTeamMemberPersistenceImpl
 * @see AddTeamMemberUtil
 * @generated
 */
@ProviderType
public interface AddTeamMemberPersistence extends BasePersistence<AddTeamMember> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddTeamMemberUtil} to access the add team member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the add team members where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @return the matching add team members
	*/
	public java.util.List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId);

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
	public java.util.List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId, int start, int end);

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
	public java.util.List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

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
	public java.util.List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public AddTeamMember findBygetProjectId_First(long employeeId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the first add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchBygetProjectId_First(long employeeId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

	/**
	* Returns the last add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public AddTeamMember findBygetProjectId_Last(long employeeId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the last add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchBygetProjectId_Last(long employeeId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

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
	public AddTeamMember[] findBygetProjectId_PrevAndNext(long projectTeamsId,
		long employeeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Removes all the add team members where employeeId = &#63; and companyId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	*/
	public void removeBygetProjectId(long employeeId, long companyId);

	/**
	* Returns the number of add team members where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @return the number of matching add team members
	*/
	public int countBygetProjectId(long employeeId, long companyId);

	/**
	* Returns all the add team members where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @return the matching add team members
	*/
	public java.util.List<AddTeamMember> findByprojectManager(
		boolean isProjectManager);

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
	public java.util.List<AddTeamMember> findByprojectManager(
		boolean isProjectManager, int start, int end);

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
	public java.util.List<AddTeamMember> findByprojectManager(
		boolean isProjectManager, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

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
	public java.util.List<AddTeamMember> findByprojectManager(
		boolean isProjectManager, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first add team member in the ordered set where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public AddTeamMember findByprojectManager_First(boolean isProjectManager,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the first add team member in the ordered set where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchByprojectManager_First(boolean isProjectManager,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

	/**
	* Returns the last add team member in the ordered set where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public AddTeamMember findByprojectManager_Last(boolean isProjectManager,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the last add team member in the ordered set where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchByprojectManager_Last(boolean isProjectManager,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

	/**
	* Returns the add team members before and after the current add team member in the ordered set where isProjectManager = &#63;.
	*
	* @param projectTeamsId the primary key of the current add team member
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next add team member
	* @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	*/
	public AddTeamMember[] findByprojectManager_PrevAndNext(
		long projectTeamsId, boolean isProjectManager,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Removes all the add team members where isProjectManager = &#63; from the database.
	*
	* @param isProjectManager the is project manager
	*/
	public void removeByprojectManager(boolean isProjectManager);

	/**
	* Returns the number of add team members where isProjectManager = &#63;.
	*
	* @param isProjectManager the is project manager
	* @return the number of matching add team members
	*/
	public int countByprojectManager(boolean isProjectManager);

	/**
	* Returns all the add team members where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the matching add team members
	*/
	public java.util.List<AddTeamMember> findByprojectMember(long projectId);

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
	public java.util.List<AddTeamMember> findByprojectMember(long projectId,
		int start, int end);

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
	public java.util.List<AddTeamMember> findByprojectMember(long projectId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

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
	public java.util.List<AddTeamMember> findByprojectMember(long projectId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first add team member in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public AddTeamMember findByprojectMember_First(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the first add team member in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchByprojectMember_First(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

	/**
	* Returns the last add team member in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public AddTeamMember findByprojectMember_Last(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the last add team member in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchByprojectMember_Last(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

	/**
	* Returns the add team members before and after the current add team member in the ordered set where projectId = &#63;.
	*
	* @param projectTeamsId the primary key of the current add team member
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next add team member
	* @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	*/
	public AddTeamMember[] findByprojectMember_PrevAndNext(
		long projectTeamsId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Removes all the add team members where projectId = &#63; from the database.
	*
	* @param projectId the project ID
	*/
	public void removeByprojectMember(long projectId);

	/**
	* Returns the number of add team members where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the number of matching add team members
	*/
	public int countByprojectMember(long projectId);

	/**
	* Returns the add team member where employeeId = &#63; and projectId = &#63; or throws a {@link NoSuchAddTeamMemberException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public AddTeamMember findBygetProjectManager(long employeeId, long projectId)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the add team member where employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchBygetProjectManager(long employeeId,
		long projectId);

	/**
	* Returns the add team member where employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchBygetProjectManager(long employeeId,
		long projectId, boolean retrieveFromCache);

	/**
	* Removes the add team member where employeeId = &#63; and projectId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the add team member that was removed
	*/
	public AddTeamMember removeBygetProjectManager(long employeeId,
		long projectId) throws NoSuchAddTeamMemberException;

	/**
	* Returns the number of add team members where employeeId = &#63; and projectId = &#63;.
	*
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @return the number of matching add team members
	*/
	public int countBygetProjectManager(long employeeId, long projectId);

	/**
	* Returns all the add team members where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the matching add team members
	*/
	public java.util.List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager);

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
	public java.util.List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager, int start, int end);

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
	public java.util.List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

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
	public java.util.List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public AddTeamMember findBygetProjectManagerProjectList_First(
		long employeeId, boolean isProjectManager,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the first add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchBygetProjectManagerProjectList_First(
		long employeeId, boolean isProjectManager,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

	/**
	* Returns the last add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public AddTeamMember findBygetProjectManagerProjectList_Last(
		long employeeId, boolean isProjectManager,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the last add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchBygetProjectManagerProjectList_Last(
		long employeeId, boolean isProjectManager,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

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
	public AddTeamMember[] findBygetProjectManagerProjectList_PrevAndNext(
		long projectTeamsId, long employeeId, boolean isProjectManager,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException;

	/**
	* Removes all the add team members where employeeId = &#63; and isProjectManager = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	*/
	public void removeBygetProjectManagerProjectList(long employeeId,
		boolean isProjectManager);

	/**
	* Returns the number of add team members where employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the number of matching add team members
	*/
	public int countBygetProjectManagerProjectList(long employeeId,
		boolean isProjectManager);

	/**
	* Returns the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; or throws a {@link NoSuchAddTeamMemberException} if it could not be found.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the matching add team member
	* @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	*/
	public AddTeamMember findBygetProjectManagerProject(long projectId,
		long employeeId, boolean isProjectManager)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchBygetProjectManagerProject(long projectId,
		long employeeId, boolean isProjectManager);

	/**
	* Returns the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	*/
	public AddTeamMember fetchBygetProjectManagerProject(long projectId,
		long employeeId, boolean isProjectManager, boolean retrieveFromCache);

	/**
	* Removes the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; from the database.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the add team member that was removed
	*/
	public AddTeamMember removeBygetProjectManagerProject(long projectId,
		long employeeId, boolean isProjectManager)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the number of add team members where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63;.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param isProjectManager the is project manager
	* @return the number of matching add team members
	*/
	public int countBygetProjectManagerProject(long projectId, long employeeId,
		boolean isProjectManager);

	/**
	* Caches the add team member in the entity cache if it is enabled.
	*
	* @param addTeamMember the add team member
	*/
	public void cacheResult(AddTeamMember addTeamMember);

	/**
	* Caches the add team members in the entity cache if it is enabled.
	*
	* @param addTeamMembers the add team members
	*/
	public void cacheResult(java.util.List<AddTeamMember> addTeamMembers);

	/**
	* Creates a new add team member with the primary key. Does not add the add team member to the database.
	*
	* @param projectTeamsId the primary key for the new add team member
	* @return the new add team member
	*/
	public AddTeamMember create(long projectTeamsId);

	/**
	* Removes the add team member with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectTeamsId the primary key of the add team member
	* @return the add team member that was removed
	* @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	*/
	public AddTeamMember remove(long projectTeamsId)
		throws NoSuchAddTeamMemberException;

	public AddTeamMember updateImpl(AddTeamMember addTeamMember);

	/**
	* Returns the add team member with the primary key or throws a {@link NoSuchAddTeamMemberException} if it could not be found.
	*
	* @param projectTeamsId the primary key of the add team member
	* @return the add team member
	* @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	*/
	public AddTeamMember findByPrimaryKey(long projectTeamsId)
		throws NoSuchAddTeamMemberException;

	/**
	* Returns the add team member with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectTeamsId the primary key of the add team member
	* @return the add team member, or <code>null</code> if a add team member with the primary key could not be found
	*/
	public AddTeamMember fetchByPrimaryKey(long projectTeamsId);

	@Override
	public java.util.Map<java.io.Serializable, AddTeamMember> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the add team members.
	*
	* @return the add team members
	*/
	public java.util.List<AddTeamMember> findAll();

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
	public java.util.List<AddTeamMember> findAll(int start, int end);

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
	public java.util.List<AddTeamMember> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator);

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
	public java.util.List<AddTeamMember> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the add team members from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of add team members.
	*
	* @return the number of add team members
	*/
	public int countAll();
}