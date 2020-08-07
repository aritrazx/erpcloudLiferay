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

import com.liferay.famocom.erpcloud.exception.NoSuchProjectMasterException;
import com.liferay.famocom.erpcloud.model.ProjectMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ProjectMasterPersistenceImpl
 * @see ProjectMasterUtil
 * @generated
 */
@ProviderType
public interface ProjectMasterPersistence extends BasePersistence<ProjectMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectMasterUtil} to access the project master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project masters where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @return the matching project masters
	*/
	public java.util.List<ProjectMaster> findByprojectId(long employeeId,
		long companyId);

	/**
	* Returns a range of all the project masters where employeeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param start the lower bound of the range of project masters
	* @param end the upper bound of the range of project masters (not inclusive)
	* @return the range of matching project masters
	*/
	public java.util.List<ProjectMaster> findByprojectId(long employeeId,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the project masters where employeeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param start the lower bound of the range of project masters
	* @param end the upper bound of the range of project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project masters
	*/
	public java.util.List<ProjectMaster> findByprojectId(long employeeId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator);

	/**
	* Returns an ordered range of all the project masters where employeeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param start the lower bound of the range of project masters
	* @param end the upper bound of the range of project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project masters
	*/
	public java.util.List<ProjectMaster> findByprojectId(long employeeId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project master
	* @throws NoSuchProjectMasterException if a matching project master could not be found
	*/
	public ProjectMaster findByprojectId_First(long employeeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException;

	/**
	* Returns the first project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project master, or <code>null</code> if a matching project master could not be found
	*/
	public ProjectMaster fetchByprojectId_First(long employeeId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator);

	/**
	* Returns the last project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project master
	* @throws NoSuchProjectMasterException if a matching project master could not be found
	*/
	public ProjectMaster findByprojectId_Last(long employeeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException;

	/**
	* Returns the last project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project master, or <code>null</code> if a matching project master could not be found
	*/
	public ProjectMaster fetchByprojectId_Last(long employeeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator);

	/**
	* Returns the project masters before and after the current project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param projectId the primary key of the current project master
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project master
	* @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	*/
	public ProjectMaster[] findByprojectId_PrevAndNext(long projectId,
		long employeeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException;

	/**
	* Removes all the project masters where employeeId = &#63; and companyId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	*/
	public void removeByprojectId(long employeeId, long companyId);

	/**
	* Returns the number of project masters where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @return the number of matching project masters
	*/
	public int countByprojectId(long employeeId, long companyId);

	/**
	* Returns all the project masters where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching project masters
	*/
	public java.util.List<ProjectMaster> findByEmployeeId(long employeeId);

	/**
	* Returns a range of all the project masters where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of project masters
	* @param end the upper bound of the range of project masters (not inclusive)
	* @return the range of matching project masters
	*/
	public java.util.List<ProjectMaster> findByEmployeeId(long employeeId,
		int start, int end);

	/**
	* Returns an ordered range of all the project masters where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of project masters
	* @param end the upper bound of the range of project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project masters
	*/
	public java.util.List<ProjectMaster> findByEmployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator);

	/**
	* Returns an ordered range of all the project masters where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of project masters
	* @param end the upper bound of the range of project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project masters
	*/
	public java.util.List<ProjectMaster> findByEmployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project master in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project master
	* @throws NoSuchProjectMasterException if a matching project master could not be found
	*/
	public ProjectMaster findByEmployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException;

	/**
	* Returns the first project master in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project master, or <code>null</code> if a matching project master could not be found
	*/
	public ProjectMaster fetchByEmployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator);

	/**
	* Returns the last project master in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project master
	* @throws NoSuchProjectMasterException if a matching project master could not be found
	*/
	public ProjectMaster findByEmployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException;

	/**
	* Returns the last project master in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project master, or <code>null</code> if a matching project master could not be found
	*/
	public ProjectMaster fetchByEmployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator);

	/**
	* Returns the project masters before and after the current project master in the ordered set where employeeId = &#63;.
	*
	* @param projectId the primary key of the current project master
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project master
	* @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	*/
	public ProjectMaster[] findByEmployeeId_PrevAndNext(long projectId,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException;

	/**
	* Removes all the project masters where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeByEmployeeId(long employeeId);

	/**
	* Returns the number of project masters where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching project masters
	*/
	public int countByEmployeeId(long employeeId);

	/**
	* Caches the project master in the entity cache if it is enabled.
	*
	* @param projectMaster the project master
	*/
	public void cacheResult(ProjectMaster projectMaster);

	/**
	* Caches the project masters in the entity cache if it is enabled.
	*
	* @param projectMasters the project masters
	*/
	public void cacheResult(java.util.List<ProjectMaster> projectMasters);

	/**
	* Creates a new project master with the primary key. Does not add the project master to the database.
	*
	* @param projectId the primary key for the new project master
	* @return the new project master
	*/
	public ProjectMaster create(long projectId);

	/**
	* Removes the project master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the project master
	* @return the project master that was removed
	* @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	*/
	public ProjectMaster remove(long projectId)
		throws NoSuchProjectMasterException;

	public ProjectMaster updateImpl(ProjectMaster projectMaster);

	/**
	* Returns the project master with the primary key or throws a {@link NoSuchProjectMasterException} if it could not be found.
	*
	* @param projectId the primary key of the project master
	* @return the project master
	* @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	*/
	public ProjectMaster findByPrimaryKey(long projectId)
		throws NoSuchProjectMasterException;

	/**
	* Returns the project master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectId the primary key of the project master
	* @return the project master, or <code>null</code> if a project master with the primary key could not be found
	*/
	public ProjectMaster fetchByPrimaryKey(long projectId);

	@Override
	public java.util.Map<java.io.Serializable, ProjectMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project masters.
	*
	* @return the project masters
	*/
	public java.util.List<ProjectMaster> findAll();

	/**
	* Returns a range of all the project masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project masters
	* @param end the upper bound of the range of project masters (not inclusive)
	* @return the range of project masters
	*/
	public java.util.List<ProjectMaster> findAll(int start, int end);

	/**
	* Returns an ordered range of all the project masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project masters
	* @param end the upper bound of the range of project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project masters
	*/
	public java.util.List<ProjectMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator);

	/**
	* Returns an ordered range of all the project masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project masters
	* @param end the upper bound of the range of project masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project masters
	*/
	public java.util.List<ProjectMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project masters.
	*
	* @return the number of project masters
	*/
	public int countAll();
}