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

import com.liferay.famocom.erpcloud.exception.NoSuchCandidateEvaluationException;
import com.liferay.famocom.erpcloud.model.CandidateEvaluation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the candidate evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.CandidateEvaluationPersistenceImpl
 * @see CandidateEvaluationUtil
 * @generated
 */
@ProviderType
public interface CandidateEvaluationPersistence extends BasePersistence<CandidateEvaluation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateEvaluationUtil} to access the candidate evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the candidate evaluation in the entity cache if it is enabled.
	*
	* @param candidateEvaluation the candidate evaluation
	*/
	public void cacheResult(CandidateEvaluation candidateEvaluation);

	/**
	* Caches the candidate evaluations in the entity cache if it is enabled.
	*
	* @param candidateEvaluations the candidate evaluations
	*/
	public void cacheResult(
		java.util.List<CandidateEvaluation> candidateEvaluations);

	/**
	* Creates a new candidate evaluation with the primary key. Does not add the candidate evaluation to the database.
	*
	* @param candidateEvaluationId the primary key for the new candidate evaluation
	* @return the new candidate evaluation
	*/
	public CandidateEvaluation create(long candidateEvaluationId);

	/**
	* Removes the candidate evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation that was removed
	* @throws NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	*/
	public CandidateEvaluation remove(long candidateEvaluationId)
		throws NoSuchCandidateEvaluationException;

	public CandidateEvaluation updateImpl(
		CandidateEvaluation candidateEvaluation);

	/**
	* Returns the candidate evaluation with the primary key or throws a {@link NoSuchCandidateEvaluationException} if it could not be found.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation
	* @throws NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	*/
	public CandidateEvaluation findByPrimaryKey(long candidateEvaluationId)
		throws NoSuchCandidateEvaluationException;

	/**
	* Returns the candidate evaluation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation, or <code>null</code> if a candidate evaluation with the primary key could not be found
	*/
	public CandidateEvaluation fetchByPrimaryKey(long candidateEvaluationId);

	@Override
	public java.util.Map<java.io.Serializable, CandidateEvaluation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the candidate evaluations.
	*
	* @return the candidate evaluations
	*/
	public java.util.List<CandidateEvaluation> findAll();

	/**
	* Returns a range of all the candidate evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate evaluations
	* @param end the upper bound of the range of candidate evaluations (not inclusive)
	* @return the range of candidate evaluations
	*/
	public java.util.List<CandidateEvaluation> findAll(int start, int end);

	/**
	* Returns an ordered range of all the candidate evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate evaluations
	* @param end the upper bound of the range of candidate evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of candidate evaluations
	*/
	public java.util.List<CandidateEvaluation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEvaluation> orderByComparator);

	/**
	* Returns an ordered range of all the candidate evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate evaluations
	* @param end the upper bound of the range of candidate evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of candidate evaluations
	*/
	public java.util.List<CandidateEvaluation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEvaluation> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the candidate evaluations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of candidate evaluations.
	*
	* @return the number of candidate evaluations
	*/
	public int countAll();
}