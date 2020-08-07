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

import com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException;
import com.liferay.famocom.erpcloud.model.RecruitProcess;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the recruit process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.RecruitProcessPersistenceImpl
 * @see RecruitProcessUtil
 * @generated
 */
@ProviderType
public interface RecruitProcessPersistence extends BasePersistence<RecruitProcess> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RecruitProcessUtil} to access the recruit process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the recruit process where employeeId = &#63; or throws a {@link NoSuchRecruitProcessException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @return the matching recruit process
	* @throws NoSuchRecruitProcessException if a matching recruit process could not be found
	*/
	public RecruitProcess findByrecruitProcess(long employeeId)
		throws NoSuchRecruitProcessException;

	/**
	* Returns the recruit process where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @return the matching recruit process, or <code>null</code> if a matching recruit process could not be found
	*/
	public RecruitProcess fetchByrecruitProcess(long employeeId);

	/**
	* Returns the recruit process where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching recruit process, or <code>null</code> if a matching recruit process could not be found
	*/
	public RecruitProcess fetchByrecruitProcess(long employeeId,
		boolean retrieveFromCache);

	/**
	* Removes the recruit process where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @return the recruit process that was removed
	*/
	public RecruitProcess removeByrecruitProcess(long employeeId)
		throws NoSuchRecruitProcessException;

	/**
	* Returns the number of recruit processes where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching recruit processes
	*/
	public int countByrecruitProcess(long employeeId);

	/**
	* Returns all the recruit processes where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching recruit processes
	*/
	public java.util.List<RecruitProcess> findByrecruitProcessCol(
		long employeeId);

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
	public java.util.List<RecruitProcess> findByrecruitProcessCol(
		long employeeId, int start, int end);

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
	public java.util.List<RecruitProcess> findByrecruitProcessCol(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitProcess> orderByComparator);

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
	public java.util.List<RecruitProcess> findByrecruitProcessCol(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitProcess> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first recruit process in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching recruit process
	* @throws NoSuchRecruitProcessException if a matching recruit process could not be found
	*/
	public RecruitProcess findByrecruitProcessCol_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitProcess> orderByComparator)
		throws NoSuchRecruitProcessException;

	/**
	* Returns the first recruit process in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching recruit process, or <code>null</code> if a matching recruit process could not be found
	*/
	public RecruitProcess fetchByrecruitProcessCol_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitProcess> orderByComparator);

	/**
	* Returns the last recruit process in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching recruit process
	* @throws NoSuchRecruitProcessException if a matching recruit process could not be found
	*/
	public RecruitProcess findByrecruitProcessCol_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitProcess> orderByComparator)
		throws NoSuchRecruitProcessException;

	/**
	* Returns the last recruit process in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching recruit process, or <code>null</code> if a matching recruit process could not be found
	*/
	public RecruitProcess fetchByrecruitProcessCol_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitProcess> orderByComparator);

	/**
	* Returns the recruit processes before and after the current recruit process in the ordered set where employeeId = &#63;.
	*
	* @param recruitProcessId the primary key of the current recruit process
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next recruit process
	* @throws NoSuchRecruitProcessException if a recruit process with the primary key could not be found
	*/
	public RecruitProcess[] findByrecruitProcessCol_PrevAndNext(
		long recruitProcessId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitProcess> orderByComparator)
		throws NoSuchRecruitProcessException;

	/**
	* Removes all the recruit processes where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeByrecruitProcessCol(long employeeId);

	/**
	* Returns the number of recruit processes where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching recruit processes
	*/
	public int countByrecruitProcessCol(long employeeId);

	/**
	* Caches the recruit process in the entity cache if it is enabled.
	*
	* @param recruitProcess the recruit process
	*/
	public void cacheResult(RecruitProcess recruitProcess);

	/**
	* Caches the recruit processes in the entity cache if it is enabled.
	*
	* @param recruitProcesses the recruit processes
	*/
	public void cacheResult(java.util.List<RecruitProcess> recruitProcesses);

	/**
	* Creates a new recruit process with the primary key. Does not add the recruit process to the database.
	*
	* @param recruitProcessId the primary key for the new recruit process
	* @return the new recruit process
	*/
	public RecruitProcess create(long recruitProcessId);

	/**
	* Removes the recruit process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitProcessId the primary key of the recruit process
	* @return the recruit process that was removed
	* @throws NoSuchRecruitProcessException if a recruit process with the primary key could not be found
	*/
	public RecruitProcess remove(long recruitProcessId)
		throws NoSuchRecruitProcessException;

	public RecruitProcess updateImpl(RecruitProcess recruitProcess);

	/**
	* Returns the recruit process with the primary key or throws a {@link NoSuchRecruitProcessException} if it could not be found.
	*
	* @param recruitProcessId the primary key of the recruit process
	* @return the recruit process
	* @throws NoSuchRecruitProcessException if a recruit process with the primary key could not be found
	*/
	public RecruitProcess findByPrimaryKey(long recruitProcessId)
		throws NoSuchRecruitProcessException;

	/**
	* Returns the recruit process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recruitProcessId the primary key of the recruit process
	* @return the recruit process, or <code>null</code> if a recruit process with the primary key could not be found
	*/
	public RecruitProcess fetchByPrimaryKey(long recruitProcessId);

	@Override
	public java.util.Map<java.io.Serializable, RecruitProcess> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the recruit processes.
	*
	* @return the recruit processes
	*/
	public java.util.List<RecruitProcess> findAll();

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
	public java.util.List<RecruitProcess> findAll(int start, int end);

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
	public java.util.List<RecruitProcess> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitProcess> orderByComparator);

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
	public java.util.List<RecruitProcess> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RecruitProcess> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the recruit processes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of recruit processes.
	*
	* @return the number of recruit processes
	*/
	public int countAll();
}