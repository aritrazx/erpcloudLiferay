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

import com.liferay.famocom.erpcloud.exception.NoSuchCandidateApplyException;
import com.liferay.famocom.erpcloud.model.CandidateApply;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the candidate apply service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.CandidateApplyPersistenceImpl
 * @see CandidateApplyUtil
 * @generated
 */
@ProviderType
public interface CandidateApplyPersistence extends BasePersistence<CandidateApply> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateApplyUtil} to access the candidate apply persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the candidate apply in the entity cache if it is enabled.
	*
	* @param candidateApply the candidate apply
	*/
	public void cacheResult(CandidateApply candidateApply);

	/**
	* Caches the candidate applies in the entity cache if it is enabled.
	*
	* @param candidateApplies the candidate applies
	*/
	public void cacheResult(java.util.List<CandidateApply> candidateApplies);

	/**
	* Creates a new candidate apply with the primary key. Does not add the candidate apply to the database.
	*
	* @param applyCandidateId the primary key for the new candidate apply
	* @return the new candidate apply
	*/
	public CandidateApply create(long applyCandidateId);

	/**
	* Removes the candidate apply with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applyCandidateId the primary key of the candidate apply
	* @return the candidate apply that was removed
	* @throws NoSuchCandidateApplyException if a candidate apply with the primary key could not be found
	*/
	public CandidateApply remove(long applyCandidateId)
		throws NoSuchCandidateApplyException;

	public CandidateApply updateImpl(CandidateApply candidateApply);

	/**
	* Returns the candidate apply with the primary key or throws a {@link NoSuchCandidateApplyException} if it could not be found.
	*
	* @param applyCandidateId the primary key of the candidate apply
	* @return the candidate apply
	* @throws NoSuchCandidateApplyException if a candidate apply with the primary key could not be found
	*/
	public CandidateApply findByPrimaryKey(long applyCandidateId)
		throws NoSuchCandidateApplyException;

	/**
	* Returns the candidate apply with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applyCandidateId the primary key of the candidate apply
	* @return the candidate apply, or <code>null</code> if a candidate apply with the primary key could not be found
	*/
	public CandidateApply fetchByPrimaryKey(long applyCandidateId);

	@Override
	public java.util.Map<java.io.Serializable, CandidateApply> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the candidate applies.
	*
	* @return the candidate applies
	*/
	public java.util.List<CandidateApply> findAll();

	/**
	* Returns a range of all the candidate applies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate applies
	* @param end the upper bound of the range of candidate applies (not inclusive)
	* @return the range of candidate applies
	*/
	public java.util.List<CandidateApply> findAll(int start, int end);

	/**
	* Returns an ordered range of all the candidate applies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate applies
	* @param end the upper bound of the range of candidate applies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of candidate applies
	*/
	public java.util.List<CandidateApply> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateApply> orderByComparator);

	/**
	* Returns an ordered range of all the candidate applies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate applies
	* @param end the upper bound of the range of candidate applies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of candidate applies
	*/
	public java.util.List<CandidateApply> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateApply> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the candidate applies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of candidate applies.
	*
	* @return the number of candidate applies
	*/
	public int countAll();
}