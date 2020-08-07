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

import com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException;
import com.liferay.famocom.erpcloud.model.EmpPayStructure;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the emp pay structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EmpPayStructurePersistenceImpl
 * @see EmpPayStructureUtil
 * @generated
 */
@ProviderType
public interface EmpPayStructurePersistence extends BasePersistence<EmpPayStructure> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpPayStructureUtil} to access the emp pay structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the emp pay structures where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching emp pay structures
	*/
	public java.util.List<EmpPayStructure> findByemployeeId(long employeeId);

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
	public java.util.List<EmpPayStructure> findByemployeeId(long employeeId,
		int start, int end);

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
	public java.util.List<EmpPayStructure> findByemployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator);

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
	public java.util.List<EmpPayStructure> findByemployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first emp pay structure in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public EmpPayStructure findByemployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException;

	/**
	* Returns the first emp pay structure in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public EmpPayStructure fetchByemployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator);

	/**
	* Returns the last emp pay structure in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public EmpPayStructure findByemployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException;

	/**
	* Returns the last emp pay structure in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public EmpPayStructure fetchByemployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator);

	/**
	* Returns the emp pay structures before and after the current emp pay structure in the ordered set where employeeId = &#63;.
	*
	* @param empPayStructureId the primary key of the current emp pay structure
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp pay structure
	* @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	*/
	public EmpPayStructure[] findByemployeeId_PrevAndNext(
		long empPayStructureId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException;

	/**
	* Removes all the emp pay structures where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeByemployeeId(long employeeId);

	/**
	* Returns the number of emp pay structures where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching emp pay structures
	*/
	public int countByemployeeId(long employeeId);

	/**
	* Returns all the emp pay structures where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @return the matching emp pay structures
	*/
	public java.util.List<EmpPayStructure> findBypayComponentId(
		long payComponentId);

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
	public java.util.List<EmpPayStructure> findBypayComponentId(
		long payComponentId, int start, int end);

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
	public java.util.List<EmpPayStructure> findBypayComponentId(
		long payComponentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator);

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
	public java.util.List<EmpPayStructure> findBypayComponentId(
		long payComponentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first emp pay structure in the ordered set where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public EmpPayStructure findBypayComponentId_First(long payComponentId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException;

	/**
	* Returns the first emp pay structure in the ordered set where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public EmpPayStructure fetchBypayComponentId_First(long payComponentId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator);

	/**
	* Returns the last emp pay structure in the ordered set where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public EmpPayStructure findBypayComponentId_Last(long payComponentId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException;

	/**
	* Returns the last emp pay structure in the ordered set where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public EmpPayStructure fetchBypayComponentId_Last(long payComponentId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator);

	/**
	* Returns the emp pay structures before and after the current emp pay structure in the ordered set where payComponentId = &#63;.
	*
	* @param empPayStructureId the primary key of the current emp pay structure
	* @param payComponentId the pay component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp pay structure
	* @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	*/
	public EmpPayStructure[] findBypayComponentId_PrevAndNext(
		long empPayStructureId, long payComponentId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException;

	/**
	* Removes all the emp pay structures where payComponentId = &#63; from the database.
	*
	* @param payComponentId the pay component ID
	*/
	public void removeBypayComponentId(long payComponentId);

	/**
	* Returns the number of emp pay structures where payComponentId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @return the number of matching emp pay structures
	*/
	public int countBypayComponentId(long payComponentId);

	/**
	* Returns all the emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the matching emp pay structures
	*/
	public java.util.List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId);

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
	public java.util.List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId, int start, int end);

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
	public java.util.List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator);

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
	public java.util.List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public EmpPayStructure findBypayComponentIdsAndemployeeId_First(
		long payComponentId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException;

	/**
	* Returns the first emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public EmpPayStructure fetchBypayComponentIdsAndemployeeId_First(
		long payComponentId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator);

	/**
	* Returns the last emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public EmpPayStructure findBypayComponentIdsAndemployeeId_Last(
		long payComponentId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException;

	/**
	* Returns the last emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public EmpPayStructure fetchBypayComponentIdsAndemployeeId_Last(
		long payComponentId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator);

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
	public EmpPayStructure[] findBypayComponentIdsAndemployeeId_PrevAndNext(
		long empPayStructureId, long payComponentId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException;

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
	public java.util.List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId);

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
	public java.util.List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId, int start, int end);

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
	public java.util.List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator);

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
	public java.util.List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the emp pay structures where payComponentId = &#63; and employeeId = &#63; from the database.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	*/
	public void removeBypayComponentIdsAndemployeeId(long payComponentId,
		long employeeId);

	/**
	* Returns the number of emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the number of matching emp pay structures
	*/
	public int countBypayComponentIdsAndemployeeId(long payComponentId,
		long employeeId);

	/**
	* Returns the number of emp pay structures where payComponentId = any &#63; and employeeId = &#63;.
	*
	* @param payComponentIds the pay component IDs
	* @param employeeId the employee ID
	* @return the number of matching emp pay structures
	*/
	public int countBypayComponentIdsAndemployeeId(long[] payComponentIds,
		long employeeId);

	/**
	* Returns the emp pay structure where payComponentId = &#63; and employeeId = &#63; or throws a {@link NoSuchEmpPayStructureException} if it could not be found.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public EmpPayStructure findBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId)
		throws NoSuchEmpPayStructureException;

	/**
	* Returns the emp pay structure where payComponentId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public EmpPayStructure fetchBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId);

	/**
	* Returns the emp pay structure where payComponentId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public EmpPayStructure fetchBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId, boolean retrieveFromCache);

	/**
	* Removes the emp pay structure where payComponentId = &#63; and employeeId = &#63; from the database.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the emp pay structure that was removed
	*/
	public EmpPayStructure removeBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId)
		throws NoSuchEmpPayStructureException;

	/**
	* Returns the number of emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	*
	* @param payComponentId the pay component ID
	* @param employeeId the employee ID
	* @return the number of matching emp pay structures
	*/
	public int countBypayComponentIdAndemployeeId(long payComponentId,
		long employeeId);

	/**
	* Returns the emp pay structure where employeeId = &#63; and payComponentId = &#63; or throws a {@link NoSuchEmpPayStructureException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the matching emp pay structure
	* @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	*/
	public EmpPayStructure findByemployeeIdPayComponentId(long employeeId,
		long payComponentId) throws NoSuchEmpPayStructureException;

	/**
	* Returns the emp pay structure where employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public EmpPayStructure fetchByemployeeIdPayComponentId(long employeeId,
		long payComponentId);

	/**
	* Returns the emp pay structure where employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	*/
	public EmpPayStructure fetchByemployeeIdPayComponentId(long employeeId,
		long payComponentId, boolean retrieveFromCache);

	/**
	* Removes the emp pay structure where employeeId = &#63; and payComponentId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the emp pay structure that was removed
	*/
	public EmpPayStructure removeByemployeeIdPayComponentId(long employeeId,
		long payComponentId) throws NoSuchEmpPayStructureException;

	/**
	* Returns the number of emp pay structures where employeeId = &#63; and payComponentId = &#63;.
	*
	* @param employeeId the employee ID
	* @param payComponentId the pay component ID
	* @return the number of matching emp pay structures
	*/
	public int countByemployeeIdPayComponentId(long employeeId,
		long payComponentId);

	/**
	* Caches the emp pay structure in the entity cache if it is enabled.
	*
	* @param empPayStructure the emp pay structure
	*/
	public void cacheResult(EmpPayStructure empPayStructure);

	/**
	* Caches the emp pay structures in the entity cache if it is enabled.
	*
	* @param empPayStructures the emp pay structures
	*/
	public void cacheResult(java.util.List<EmpPayStructure> empPayStructures);

	/**
	* Creates a new emp pay structure with the primary key. Does not add the emp pay structure to the database.
	*
	* @param empPayStructureId the primary key for the new emp pay structure
	* @return the new emp pay structure
	*/
	public EmpPayStructure create(long empPayStructureId);

	/**
	* Removes the emp pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empPayStructureId the primary key of the emp pay structure
	* @return the emp pay structure that was removed
	* @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	*/
	public EmpPayStructure remove(long empPayStructureId)
		throws NoSuchEmpPayStructureException;

	public EmpPayStructure updateImpl(EmpPayStructure empPayStructure);

	/**
	* Returns the emp pay structure with the primary key or throws a {@link NoSuchEmpPayStructureException} if it could not be found.
	*
	* @param empPayStructureId the primary key of the emp pay structure
	* @return the emp pay structure
	* @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	*/
	public EmpPayStructure findByPrimaryKey(long empPayStructureId)
		throws NoSuchEmpPayStructureException;

	/**
	* Returns the emp pay structure with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empPayStructureId the primary key of the emp pay structure
	* @return the emp pay structure, or <code>null</code> if a emp pay structure with the primary key could not be found
	*/
	public EmpPayStructure fetchByPrimaryKey(long empPayStructureId);

	@Override
	public java.util.Map<java.io.Serializable, EmpPayStructure> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the emp pay structures.
	*
	* @return the emp pay structures
	*/
	public java.util.List<EmpPayStructure> findAll();

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
	public java.util.List<EmpPayStructure> findAll(int start, int end);

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
	public java.util.List<EmpPayStructure> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator);

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
	public java.util.List<EmpPayStructure> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the emp pay structures from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of emp pay structures.
	*
	* @return the number of emp pay structures
	*/
	public int countAll();
}