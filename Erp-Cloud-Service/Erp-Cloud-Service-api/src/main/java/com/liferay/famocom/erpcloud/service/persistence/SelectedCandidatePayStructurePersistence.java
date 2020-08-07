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

import com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureException;
import com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the selected candidate pay structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.SelectedCandidatePayStructurePersistenceImpl
 * @see SelectedCandidatePayStructureUtil
 * @generated
 */
@ProviderType
public interface SelectedCandidatePayStructurePersistence
	extends BasePersistence<SelectedCandidatePayStructure> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SelectedCandidatePayStructureUtil} to access the selected candidate pay structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @return the matching selected candidate pay structures
	*/
	public java.util.List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus);

	/**
	* Returns a range of all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @return the range of matching selected candidate pay structures
	*/
	public java.util.List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus, int start, int end);

	/**
	* Returns an ordered range of all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching selected candidate pay structures
	*/
	public java.util.List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelectedCandidatePayStructure> orderByComparator);

	/**
	* Returns an ordered range of all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching selected candidate pay structures
	*/
	public java.util.List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelectedCandidatePayStructure> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching selected candidate pay structure
	* @throws NoSuchSelectedCandidatePayStructureException if a matching selected candidate pay structure could not be found
	*/
	public SelectedCandidatePayStructure findByrecruitmentProcessIdAndPayStatus_First(
		long recruitmentProcessId, int payStatus,
		com.liferay.portal.kernel.util.OrderByComparator<SelectedCandidatePayStructure> orderByComparator)
		throws NoSuchSelectedCandidatePayStructureException;

	/**
	* Returns the first selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching selected candidate pay structure, or <code>null</code> if a matching selected candidate pay structure could not be found
	*/
	public SelectedCandidatePayStructure fetchByrecruitmentProcessIdAndPayStatus_First(
		long recruitmentProcessId, int payStatus,
		com.liferay.portal.kernel.util.OrderByComparator<SelectedCandidatePayStructure> orderByComparator);

	/**
	* Returns the last selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching selected candidate pay structure
	* @throws NoSuchSelectedCandidatePayStructureException if a matching selected candidate pay structure could not be found
	*/
	public SelectedCandidatePayStructure findByrecruitmentProcessIdAndPayStatus_Last(
		long recruitmentProcessId, int payStatus,
		com.liferay.portal.kernel.util.OrderByComparator<SelectedCandidatePayStructure> orderByComparator)
		throws NoSuchSelectedCandidatePayStructureException;

	/**
	* Returns the last selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching selected candidate pay structure, or <code>null</code> if a matching selected candidate pay structure could not be found
	*/
	public SelectedCandidatePayStructure fetchByrecruitmentProcessIdAndPayStatus_Last(
		long recruitmentProcessId, int payStatus,
		com.liferay.portal.kernel.util.OrderByComparator<SelectedCandidatePayStructure> orderByComparator);

	/**
	* Returns the selected candidate pay structures before and after the current selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param candidatePayStructureId the primary key of the current selected candidate pay structure
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next selected candidate pay structure
	* @throws NoSuchSelectedCandidatePayStructureException if a selected candidate pay structure with the primary key could not be found
	*/
	public SelectedCandidatePayStructure[] findByrecruitmentProcessIdAndPayStatus_PrevAndNext(
		long candidatePayStructureId, long recruitmentProcessId, int payStatus,
		com.liferay.portal.kernel.util.OrderByComparator<SelectedCandidatePayStructure> orderByComparator)
		throws NoSuchSelectedCandidatePayStructureException;

	/**
	* Removes all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63; from the database.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	*/
	public void removeByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus);

	/**
	* Returns the number of selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @return the number of matching selected candidate pay structures
	*/
	public int countByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus);

	/**
	* Caches the selected candidate pay structure in the entity cache if it is enabled.
	*
	* @param selectedCandidatePayStructure the selected candidate pay structure
	*/
	public void cacheResult(
		SelectedCandidatePayStructure selectedCandidatePayStructure);

	/**
	* Caches the selected candidate pay structures in the entity cache if it is enabled.
	*
	* @param selectedCandidatePayStructures the selected candidate pay structures
	*/
	public void cacheResult(
		java.util.List<SelectedCandidatePayStructure> selectedCandidatePayStructures);

	/**
	* Creates a new selected candidate pay structure with the primary key. Does not add the selected candidate pay structure to the database.
	*
	* @param candidatePayStructureId the primary key for the new selected candidate pay structure
	* @return the new selected candidate pay structure
	*/
	public SelectedCandidatePayStructure create(long candidatePayStructureId);

	/**
	* Removes the selected candidate pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidatePayStructureId the primary key of the selected candidate pay structure
	* @return the selected candidate pay structure that was removed
	* @throws NoSuchSelectedCandidatePayStructureException if a selected candidate pay structure with the primary key could not be found
	*/
	public SelectedCandidatePayStructure remove(long candidatePayStructureId)
		throws NoSuchSelectedCandidatePayStructureException;

	public SelectedCandidatePayStructure updateImpl(
		SelectedCandidatePayStructure selectedCandidatePayStructure);

	/**
	* Returns the selected candidate pay structure with the primary key or throws a {@link NoSuchSelectedCandidatePayStructureException} if it could not be found.
	*
	* @param candidatePayStructureId the primary key of the selected candidate pay structure
	* @return the selected candidate pay structure
	* @throws NoSuchSelectedCandidatePayStructureException if a selected candidate pay structure with the primary key could not be found
	*/
	public SelectedCandidatePayStructure findByPrimaryKey(
		long candidatePayStructureId)
		throws NoSuchSelectedCandidatePayStructureException;

	/**
	* Returns the selected candidate pay structure with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidatePayStructureId the primary key of the selected candidate pay structure
	* @return the selected candidate pay structure, or <code>null</code> if a selected candidate pay structure with the primary key could not be found
	*/
	public SelectedCandidatePayStructure fetchByPrimaryKey(
		long candidatePayStructureId);

	@Override
	public java.util.Map<java.io.Serializable, SelectedCandidatePayStructure> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the selected candidate pay structures.
	*
	* @return the selected candidate pay structures
	*/
	public java.util.List<SelectedCandidatePayStructure> findAll();

	/**
	* Returns a range of all the selected candidate pay structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @return the range of selected candidate pay structures
	*/
	public java.util.List<SelectedCandidatePayStructure> findAll(int start,
		int end);

	/**
	* Returns an ordered range of all the selected candidate pay structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of selected candidate pay structures
	*/
	public java.util.List<SelectedCandidatePayStructure> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelectedCandidatePayStructure> orderByComparator);

	/**
	* Returns an ordered range of all the selected candidate pay structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of selected candidate pay structures
	*/
	public java.util.List<SelectedCandidatePayStructure> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SelectedCandidatePayStructure> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the selected candidate pay structures from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of selected candidate pay structures.
	*
	* @return the number of selected candidate pay structures
	*/
	public int countAll();
}