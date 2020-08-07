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

import com.liferay.famocom.erpcloud.model.ProjectMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ProjectMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ProjectMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ProjectMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectMasterUtil {
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
	public static void clearCache(ProjectMaster projectMaster) {
		getPersistence().clearCache(projectMaster);
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
	public static List<ProjectMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectMaster update(ProjectMaster projectMaster) {
		return getPersistence().update(projectMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectMaster update(ProjectMaster projectMaster,
		ServiceContext serviceContext) {
		return getPersistence().update(projectMaster, serviceContext);
	}

	/**
	* Returns all the project masters where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @return the matching project masters
	*/
	public static List<ProjectMaster> findByprojectId(long employeeId,
		long companyId) {
		return getPersistence().findByprojectId(employeeId, companyId);
	}

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
	public static List<ProjectMaster> findByprojectId(long employeeId,
		long companyId, int start, int end) {
		return getPersistence()
				   .findByprojectId(employeeId, companyId, start, end);
	}

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
	public static List<ProjectMaster> findByprojectId(long employeeId,
		long companyId, int start, int end,
		OrderByComparator<ProjectMaster> orderByComparator) {
		return getPersistence()
				   .findByprojectId(employeeId, companyId, start, end,
			orderByComparator);
	}

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
	public static List<ProjectMaster> findByprojectId(long employeeId,
		long companyId, int start, int end,
		OrderByComparator<ProjectMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByprojectId(employeeId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project master
	* @throws NoSuchProjectMasterException if a matching project master could not be found
	*/
	public static ProjectMaster findByprojectId_First(long employeeId,
		long companyId, OrderByComparator<ProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectMasterException {
		return getPersistence()
				   .findByprojectId_First(employeeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project master, or <code>null</code> if a matching project master could not be found
	*/
	public static ProjectMaster fetchByprojectId_First(long employeeId,
		long companyId, OrderByComparator<ProjectMaster> orderByComparator) {
		return getPersistence()
				   .fetchByprojectId_First(employeeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project master
	* @throws NoSuchProjectMasterException if a matching project master could not be found
	*/
	public static ProjectMaster findByprojectId_Last(long employeeId,
		long companyId, OrderByComparator<ProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectMasterException {
		return getPersistence()
				   .findByprojectId_Last(employeeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project master, or <code>null</code> if a matching project master could not be found
	*/
	public static ProjectMaster fetchByprojectId_Last(long employeeId,
		long companyId, OrderByComparator<ProjectMaster> orderByComparator) {
		return getPersistence()
				   .fetchByprojectId_Last(employeeId, companyId,
			orderByComparator);
	}

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
	public static ProjectMaster[] findByprojectId_PrevAndNext(long projectId,
		long employeeId, long companyId,
		OrderByComparator<ProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectMasterException {
		return getPersistence()
				   .findByprojectId_PrevAndNext(projectId, employeeId,
			companyId, orderByComparator);
	}

	/**
	* Removes all the project masters where employeeId = &#63; and companyId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	*/
	public static void removeByprojectId(long employeeId, long companyId) {
		getPersistence().removeByprojectId(employeeId, companyId);
	}

	/**
	* Returns the number of project masters where employeeId = &#63; and companyId = &#63;.
	*
	* @param employeeId the employee ID
	* @param companyId the company ID
	* @return the number of matching project masters
	*/
	public static int countByprojectId(long employeeId, long companyId) {
		return getPersistence().countByprojectId(employeeId, companyId);
	}

	/**
	* Returns all the project masters where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching project masters
	*/
	public static List<ProjectMaster> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

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
	public static List<ProjectMaster> findByEmployeeId(long employeeId,
		int start, int end) {
		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

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
	public static List<ProjectMaster> findByEmployeeId(long employeeId,
		int start, int end, OrderByComparator<ProjectMaster> orderByComparator) {
		return getPersistence()
				   .findByEmployeeId(employeeId, start, end, orderByComparator);
	}

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
	public static List<ProjectMaster> findByEmployeeId(long employeeId,
		int start, int end, OrderByComparator<ProjectMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByEmployeeId(employeeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project master in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project master
	* @throws NoSuchProjectMasterException if a matching project master could not be found
	*/
	public static ProjectMaster findByEmployeeId_First(long employeeId,
		OrderByComparator<ProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectMasterException {
		return getPersistence()
				   .findByEmployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first project master in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project master, or <code>null</code> if a matching project master could not be found
	*/
	public static ProjectMaster fetchByEmployeeId_First(long employeeId,
		OrderByComparator<ProjectMaster> orderByComparator) {
		return getPersistence()
				   .fetchByEmployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last project master in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project master
	* @throws NoSuchProjectMasterException if a matching project master could not be found
	*/
	public static ProjectMaster findByEmployeeId_Last(long employeeId,
		OrderByComparator<ProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectMasterException {
		return getPersistence()
				   .findByEmployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last project master in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project master, or <code>null</code> if a matching project master could not be found
	*/
	public static ProjectMaster fetchByEmployeeId_Last(long employeeId,
		OrderByComparator<ProjectMaster> orderByComparator) {
		return getPersistence()
				   .fetchByEmployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the project masters before and after the current project master in the ordered set where employeeId = &#63;.
	*
	* @param projectId the primary key of the current project master
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project master
	* @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	*/
	public static ProjectMaster[] findByEmployeeId_PrevAndNext(long projectId,
		long employeeId, OrderByComparator<ProjectMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectMasterException {
		return getPersistence()
				   .findByEmployeeId_PrevAndNext(projectId, employeeId,
			orderByComparator);
	}

	/**
	* Removes all the project masters where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	* Returns the number of project masters where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching project masters
	*/
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	* Caches the project master in the entity cache if it is enabled.
	*
	* @param projectMaster the project master
	*/
	public static void cacheResult(ProjectMaster projectMaster) {
		getPersistence().cacheResult(projectMaster);
	}

	/**
	* Caches the project masters in the entity cache if it is enabled.
	*
	* @param projectMasters the project masters
	*/
	public static void cacheResult(List<ProjectMaster> projectMasters) {
		getPersistence().cacheResult(projectMasters);
	}

	/**
	* Creates a new project master with the primary key. Does not add the project master to the database.
	*
	* @param projectId the primary key for the new project master
	* @return the new project master
	*/
	public static ProjectMaster create(long projectId) {
		return getPersistence().create(projectId);
	}

	/**
	* Removes the project master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the project master
	* @return the project master that was removed
	* @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	*/
	public static ProjectMaster remove(long projectId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectMasterException {
		return getPersistence().remove(projectId);
	}

	public static ProjectMaster updateImpl(ProjectMaster projectMaster) {
		return getPersistence().updateImpl(projectMaster);
	}

	/**
	* Returns the project master with the primary key or throws a {@link NoSuchProjectMasterException} if it could not be found.
	*
	* @param projectId the primary key of the project master
	* @return the project master
	* @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	*/
	public static ProjectMaster findByPrimaryKey(long projectId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectMasterException {
		return getPersistence().findByPrimaryKey(projectId);
	}

	/**
	* Returns the project master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectId the primary key of the project master
	* @return the project master, or <code>null</code> if a project master with the primary key could not be found
	*/
	public static ProjectMaster fetchByPrimaryKey(long projectId) {
		return getPersistence().fetchByPrimaryKey(projectId);
	}

	public static java.util.Map<java.io.Serializable, ProjectMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project masters.
	*
	* @return the project masters
	*/
	public static List<ProjectMaster> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProjectMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProjectMaster> findAll(int start, int end,
		OrderByComparator<ProjectMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProjectMaster> findAll(int start, int end,
		OrderByComparator<ProjectMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project masters.
	*
	* @return the number of project masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectMasterPersistence, ProjectMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectMasterPersistence.class);

		ServiceTracker<ProjectMasterPersistence, ProjectMasterPersistence> serviceTracker =
			new ServiceTracker<ProjectMasterPersistence, ProjectMasterPersistence>(bundle.getBundleContext(),
				ProjectMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}