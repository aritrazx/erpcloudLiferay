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

import com.liferay.famocom.erpcloud.model.EmpPayStructure;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the emp pay structure service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.EmpPayStructurePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see EmpPayStructurePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EmpPayStructurePersistenceImpl
 * @generated
 */
@ProviderType
public class EmpPayStructureUtil {
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
	public static void clearCache(EmpPayStructure empPayStructure) {
		getPersistence().clearCache(empPayStructure);
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
	public static List<EmpPayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpPayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpPayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmpPayStructure update(EmpPayStructure empPayStructure) {
		return getPersistence().update(empPayStructure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmpPayStructure update(EmpPayStructure empPayStructure,
		ServiceContext serviceContext) {
		return getPersistence().update(empPayStructure, serviceContext);
	}

	/**
	* Returns all the emp pay structures where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching emp pay structures
	*/
	public static List<EmpPayStructure> findByemployeeId(long employeeId) {
		return getPersistence().findByemployeeId(employeeId);
	}

	/**
	* Returns a range of all the emp pay structures where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @return the range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findByemployeeId(long employeeId,
		int start, int end) {
		return getPersistence().findByemployeeId(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the emp pay structures where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findByemployeeId(long employeeId,
		int start, int end, OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the emp pay structures where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findByemployeeId(long employeeId,
		int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first emp pay structure in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure findByemployeeId_First(long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .findByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first emp pay structure in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure fetchByemployeeId_First(long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last emp pay structure in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure findByemployeeId_Last(long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .findByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last emp pay structure in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure fetchByemployeeId_Last(long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the emp pay structures before and after the current emp pay structure in the ordered set where employeeId = &#63;.
	*
	* @param empPayStructureId the primary key of the current emp pay structure
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp pay structure
	* @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	*/
	public static EmpPayStructure[] findByemployeeId_PrevAndNext(
		long empPayStructureId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .findByemployeeId_PrevAndNext(empPayStructureId, employeeId,
			orderByComparator);
	}

	/**
	* Removes all the emp pay structures where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeByemployeeId(long employeeId) {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	* Returns the number of emp pay structures where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching emp pay structures
	*/
	public static int countByemployeeId(long employeeId) {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	* Returns all the emp pay structures where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @return the matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentId(
		long payComponentId) {
		return getPersistence().findBypayComponentId(payComponentId);
	}

	/**
	* Returns a range of all the emp pay structures where payComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentId the pay component ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @return the range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentId(
		long payComponentId, int start, int end) {
		return getPersistence().findBypayComponentId(payComponentId, start, end);
	}

	/**
	* Returns an ordered range of all the emp pay structures where payComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentId the pay component ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentId(
		long payComponentId, int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence()
				   .findBypayComponentId(payComponentId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the emp pay structures where payComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentId the pay component ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentId(
		long payComponentId, int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBypayComponentId(payComponentId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first emp pay structure in the ordered set where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure findBypayComponentId_First(
		long payComponentId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .findBypayComponentId_First(payComponentId, orderByComparator);
	}

	/**
	* Returns the first emp pay structure in the ordered set where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure fetchBypayComponentId_First(
		long payComponentId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence()
				   .fetchBypayComponentId_First(payComponentId,
			orderByComparator);
	}

	/**
	* Returns the last emp pay structure in the ordered set where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure findBypayComponentId_Last(
		long payComponentId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .findBypayComponentId_Last(payComponentId, orderByComparator);
	}

	/**
	* Returns the last emp pay structure in the ordered set where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure fetchBypayComponentId_Last(
		long payComponentId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence()
				   .fetchBypayComponentId_Last(payComponentId, orderByComparator);
	}

	/**
	* Returns the emp pay structures before and after the current emp pay structure in the ordered set where payComponentId = &#63;.
	*
	* @param empPayStructureId the primary key of the current emp pay structure
	* @param payComponentId the pay component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp pay structure
	* @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	*/
	public static EmpPayStructure[] findBypayComponentId_PrevAndNext(
		long empPayStructureId, long payComponentId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .findBypayComponentId_PrevAndNext(empPayStructureId,
			payComponentId, orderByComparator);
	}

	/**
	* Removes all the emp pay structures where payComponentId = &#63; from the database.
	*
	* @param payComponentId the pay component ID
	*/
	public static void removeBypayComponentId(long payComponentId) {
		getPersistence().removeBypayComponentId(payComponentId);
	}

	/**
	* Returns the number of emp pay structures where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @return the number of matching emp pay structures
	*/
	public static int countBypayComponentId(long payComponentId) {
		return getPersistence().countBypayComponentId(payComponentId);
	}

	/**
	* Returns all the emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId) {
		return getPersistence()
				   .findBypayComponentIdsAndemployeeId(payComponentId,
			employeeId);
	}

	/**
	* Returns a range of all the emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @return the range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId, int start, int end) {
		return getPersistence()
				   .findBypayComponentIdsAndemployeeId(payComponentId,
			employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId, int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence()
				   .findBypayComponentIdsAndemployeeId(payComponentId,
			employeeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId, int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBypayComponentIdsAndemployeeId(payComponentId,
			employeeId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure findBypayComponentIdsAndemployeeId_First(
		long payComponentId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .findBypayComponentIdsAndemployeeId_First(payComponentId,
			employeeId, orderByComparator);
	}

	/**
	* Returns the first emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure fetchBypayComponentIdsAndemployeeId_First(
		long payComponentId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence()
				   .fetchBypayComponentIdsAndemployeeId_First(payComponentId,
			employeeId, orderByComparator);
	}

	/**
	* Returns the last emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure findBypayComponentIdsAndemployeeId_Last(
		long payComponentId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .findBypayComponentIdsAndemployeeId_Last(payComponentId,
			employeeId, orderByComparator);
	}

	/**
	* Returns the last emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure fetchBypayComponentIdsAndemployeeId_Last(
		long payComponentId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence()
				   .fetchBypayComponentIdsAndemployeeId_Last(payComponentId,
			employeeId, orderByComparator);
	}

	/**
	* Returns the emp pay structures before and after the current emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param empPayStructureId the primary key of the current emp pay structure
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp pay structure
	* @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	*/
	public static EmpPayStructure[] findBypayComponentIdsAndemployeeId_PrevAndNext(
		long empPayStructureId, long payComponentId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .findBypayComponentIdsAndemployeeId_PrevAndNext(empPayStructureId,
			payComponentId, employeeId, orderByComparator);
	}

	/**
	* Returns all the emp pay structures where payComponentId = any &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentIds the pay component IDs
	* @param employeeId the employee ID
	* @return the matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId) {
		return getPersistence()
				   .findBypayComponentIdsAndemployeeId(payComponentIds,
			employeeId);
	}

	/**
	* Returns a range of all the emp pay structures where payComponentId = any &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentIds the pay component IDs
	* @param employeeId the employee ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @return the range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId, int start, int end) {
		return getPersistence()
				   .findBypayComponentIdsAndemployeeId(payComponentIds,
			employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the emp pay structures where payComponentId = any &#63; and employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentIds the pay component IDs
	* @param employeeId the employee ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId, int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence()
				   .findBypayComponentIdsAndemployeeId(payComponentIds,
			employeeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the emp pay structures where payComponentId = &#63; and employeeId = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching emp pay structures
	*/
	public static List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId, int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBypayComponentIdsAndemployeeId(payComponentIds,
			employeeId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the emp pay structures where payComponentId = &#63; and employeeId = &#63; from the database.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	*/
	public static void removeBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId) {
		getPersistence()
			.removeBypayComponentIdsAndemployeeId(payComponentId, employeeId);
	}

	/**
	* Returns the number of emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the number of matching emp pay structures
	*/
	public static int countBypayComponentIdsAndemployeeId(long payComponentId,
		long employeeId) {
		return getPersistence()
				   .countBypayComponentIdsAndemployeeId(payComponentId,
			employeeId);
	}

	/**
	* Returns the number of emp pay structures where payComponentId = any &#63; and employeeId = &#63;.
	*
	* @param payComponentIds the pay component IDs
	* @param employeeId the employee ID
	* @return the number of matching emp pay structures
	*/
	public static int countBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId) {
		return getPersistence()
				   .countBypayComponentIdsAndemployeeId(payComponentIds,
			employeeId);
	}

	/**
	* Returns the emp pay structure where payComponentId = &#63; and employeeId = &#63; or throws a {@link NoSuchEmpPayStructureException} if it could not be found.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure findBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .findBypayComponentIdAndemployeeId(payComponentId, employeeId);
	}

	/**
	* Returns the emp pay structure where payComponentId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure fetchBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId) {
		return getPersistence()
				   .fetchBypayComponentIdAndemployeeId(payComponentId,
			employeeId);
	}

	/**
	* Returns the emp pay structure where payComponentId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure fetchBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBypayComponentIdAndemployeeId(payComponentId,
			employeeId, retrieveFromCache);
	}

	/**
	* Removes the emp pay structure where payComponentId = &#63; and employeeId = &#63; from the database.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the emp pay structure that was removed
	*/
	public static EmpPayStructure removeBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .removeBypayComponentIdAndemployeeId(payComponentId,
			employeeId);
	}

	/**
	* Returns the number of emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the number of matching emp pay structures
	*/
	public static int countBypayComponentIdAndemployeeId(long payComponentId,
		long employeeId) {
		return getPersistence()
				   .countBypayComponentIdAndemployeeId(payComponentId,
			employeeId);
	}

	/**
	* Returns the emp pay structure where employeeId = &#63; and payComponentId = &#63; or throws a {@link NoSuchEmpPayStructureException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure findByemployeeIdPayComponentId(
		long employeeId, long payComponentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .findByemployeeIdPayComponentId(employeeId, payComponentId);
	}

	/**
	* Returns the emp pay structure where employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure fetchByemployeeIdPayComponentId(
		long employeeId, long payComponentId) {
		return getPersistence()
				   .fetchByemployeeIdPayComponentId(employeeId, payComponentId);
	}

	/**
	* Returns the emp pay structure where employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public static EmpPayStructure fetchByemployeeIdPayComponentId(
		long employeeId, long payComponentId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByemployeeIdPayComponentId(employeeId, payComponentId,
			retrieveFromCache);
	}

	/**
	* Removes the emp pay structure where employeeId = &#63; and payComponentId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the emp pay structure that was removed
	*/
	public static EmpPayStructure removeByemployeeIdPayComponentId(
		long employeeId, long payComponentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence()
				   .removeByemployeeIdPayComponentId(employeeId, payComponentId);
	}

	/**
	* Returns the number of emp pay structures where employeeId = &#63; and payComponentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the number of matching emp pay structures
	*/
	public static int countByemployeeIdPayComponentId(long employeeId,
		long payComponentId) {
		return getPersistence()
				   .countByemployeeIdPayComponentId(employeeId, payComponentId);
	}

	/**
	* Caches the emp pay structure in the entity cache if it is enabled.
	*
	* @param empPayStructure the emp pay structure
	*/
	public static void cacheResult(EmpPayStructure empPayStructure) {
		getPersistence().cacheResult(empPayStructure);
	}

	/**
	* Caches the emp pay structures in the entity cache if it is enabled.
	*
	* @param empPayStructures the emp pay structures
	*/
	public static void cacheResult(List<EmpPayStructure> empPayStructures) {
		getPersistence().cacheResult(empPayStructures);
	}

	/**
	* Creates a new emp pay structure with the primary key. Does not add the emp pay structure to the database.
	*
	* @param empPayStructureId the primary key for the new emp pay structure
	* @return the new emp pay structure
	*/
	public static EmpPayStructure create(long empPayStructureId) {
		return getPersistence().create(empPayStructureId);
	}

	/**
	* Removes the emp pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empPayStructureId the primary key of the emp pay structure
	* @return the emp pay structure that was removed
	* @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	*/
	public static EmpPayStructure remove(long empPayStructureId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence().remove(empPayStructureId);
	}

	public static EmpPayStructure updateImpl(EmpPayStructure empPayStructure) {
		return getPersistence().updateImpl(empPayStructure);
	}

	/**
	* Returns the emp pay structure with the primary key or throws a {@link NoSuchEmpPayStructureException} if it could not be found.
	*
	* @param empPayStructureId the primary key of the emp pay structure
	* @return the emp pay structure
	* @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	*/
	public static EmpPayStructure findByPrimaryKey(long empPayStructureId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getPersistence().findByPrimaryKey(empPayStructureId);
	}

	/**
	* Returns the emp pay structure with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empPayStructureId the primary key of the emp pay structure
	* @return the emp pay structure, or <code>null</code> if a emp pay structure with the primary key could not be found
	*/
	public static EmpPayStructure fetchByPrimaryKey(long empPayStructureId) {
		return getPersistence().fetchByPrimaryKey(empPayStructureId);
	}

	public static java.util.Map<java.io.Serializable, EmpPayStructure> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the emp pay structures.
	*
	* @return the emp pay structures
	*/
	public static List<EmpPayStructure> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the emp pay structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @return the range of emp pay structures
	*/
	public static List<EmpPayStructure> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the emp pay structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emp pay structures
	*/
	public static List<EmpPayStructure> findAll(int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the emp pay structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of emp pay structures
	*/
	public static List<EmpPayStructure> findAll(int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the emp pay structures from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of emp pay structures.
	*
	* @return the number of emp pay structures
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmpPayStructurePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmpPayStructurePersistence, EmpPayStructurePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmpPayStructurePersistence.class);

		ServiceTracker<EmpPayStructurePersistence, EmpPayStructurePersistence> serviceTracker =
			new ServiceTracker<EmpPayStructurePersistence, EmpPayStructurePersistence>(bundle.getBundleContext(),
				EmpPayStructurePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}