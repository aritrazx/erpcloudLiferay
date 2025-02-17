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

import com.liferay.famocom.erpcloud.exception.NoSuchRecruitmentProcessException;
import com.liferay.famocom.erpcloud.model.RecruitmentProcess;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the recruitment process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.RecruitmentProcessPersistenceImpl
 * @see RecruitmentProcessUtil
 * @generated
 */
@ProviderType
public interface RecruitmentProcessPersistence extends BasePersistence<RecruitmentProcess> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RecruitmentProcessUtil} to access the recruitment process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the recruitment processes where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching recruitment processes
	*/
	public java.util.List<RecruitmentProcess> findBystatus(long groupId,
		int status);

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
	public java.util.List<RecruitmentProcess> findBystatus(long groupId,
		int status, int start, int end);

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
	public java.util.List<RecruitmentProcess> findBystatus(long groupId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitmentProcess> orderByComparator);

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
	public java.util.List<RecruitmentProcess> findBystatus(long groupId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitmentProcess> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first recruitment process in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching recruitment process
	* @throws NoSuchRecruitmentProcessException if a matching recruitment process could not be found
	*/
	public RecruitmentProcess findBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitmentProcess> orderByComparator)
		throws NoSuchRecruitmentProcessException;

	/**
	* Returns the first recruitment process in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching recruitment process, or <code>null</code> if a matching recruitment process could not be found
	*/
	public RecruitmentProcess fetchBystatus_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitmentProcess> orderByComparator);

	/**
	* Returns the last recruitment process in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching recruitment process
	* @throws NoSuchRecruitmentProcessException if a matching recruitment process could not be found
	*/
	public RecruitmentProcess findBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitmentProcess> orderByComparator)
		throws NoSuchRecruitmentProcessException;

	/**
	* Returns the last recruitment process in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching recruitment process, or <code>null</code> if a matching recruitment process could not be found
	*/
	public RecruitmentProcess fetchBystatus_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitmentProcess> orderByComparator);

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
	public RecruitmentProcess[] findBystatus_PrevAndNext(
		long recruitmentProcessId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitmentProcess> orderByComparator)
		throws NoSuchRecruitmentProcessException;

	/**
	* Removes all the recruitment processes where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeBystatus(long groupId, int status);

	/**
	* Returns the number of recruitment processes where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching recruitment processes
	*/
	public int countBystatus(long groupId, int status);

	/**
	* Caches the recruitment process in the entity cache if it is enabled.
	*
	* @param recruitmentProcess the recruitment process
	*/
	public void cacheResult(RecruitmentProcess recruitmentProcess);

	/**
	* Caches the recruitment processes in the entity cache if it is enabled.
	*
	* @param recruitmentProcesses the recruitment processes
	*/
	public void cacheResult(
		java.util.List<RecruitmentProcess> recruitmentProcesses);

	/**
	* Creates a new recruitment process with the primary key. Does not add the recruitment process to the database.
	*
	* @param recruitmentProcessId the primary key for the new recruitment process
	* @return the new recruitment process
	*/
	public RecruitmentProcess create(long recruitmentProcessId);

	/**
	* Removes the recruitment process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProcessId the primary key of the recruitment process
	* @return the recruitment process that was removed
	* @throws NoSuchRecruitmentProcessException if a recruitment process with the primary key could not be found
	*/
	public RecruitmentProcess remove(long recruitmentProcessId)
		throws NoSuchRecruitmentProcessException;

	public RecruitmentProcess updateImpl(RecruitmentProcess recruitmentProcess);

	/**
	* Returns the recruitment process with the primary key or throws a {@link NoSuchRecruitmentProcessException} if it could not be found.
	*
	* @param recruitmentProcessId the primary key of the recruitment process
	* @return the recruitment process
	* @throws NoSuchRecruitmentProcessException if a recruitment process with the primary key could not be found
	*/
	public RecruitmentProcess findByPrimaryKey(long recruitmentProcessId)
		throws NoSuchRecruitmentProcessException;

	/**
	* Returns the recruitment process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recruitmentProcessId the primary key of the recruitment process
	* @return the recruitment process, or <code>null</code> if a recruitment process with the primary key could not be found
	*/
	public RecruitmentProcess fetchByPrimaryKey(long recruitmentProcessId);

	@Override
	public java.util.Map<java.io.Serializable, RecruitmentProcess> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the recruitment processes.
	*
	* @return the recruitment processes
	*/
	public java.util.List<RecruitmentProcess> findAll();

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
	public java.util.List<RecruitmentProcess> findAll(int start, int end);

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
	public java.util.List<RecruitmentProcess> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitmentProcess> orderByComparator);

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
	public java.util.List<RecruitmentProcess> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitmentProcess> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the recruitment processes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of recruitment processes.
	*
	* @return the number of recruitment processes
	*/
	public int countAll();
}