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

import com.liferay.famocom.erpcloud.exception.NoSuchInterviewEvaluationException;
import com.liferay.famocom.erpcloud.model.InterviewEvaluation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the interview evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.InterviewEvaluationPersistenceImpl
 * @see InterviewEvaluationUtil
 * @generated
 */
@ProviderType
public interface InterviewEvaluationPersistence extends BasePersistence<InterviewEvaluation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InterviewEvaluationUtil} to access the interview evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the interview evaluation in the entity cache if it is enabled.
	*
	* @param interviewEvaluation the interview evaluation
	*/
	public void cacheResult(InterviewEvaluation interviewEvaluation);

	/**
	* Caches the interview evaluations in the entity cache if it is enabled.
	*
	* @param interviewEvaluations the interview evaluations
	*/
	public void cacheResult(
		java.util.List<InterviewEvaluation> interviewEvaluations);

	/**
	* Creates a new interview evaluation with the primary key. Does not add the interview evaluation to the database.
	*
	* @param evaluationId the primary key for the new interview evaluation
	* @return the new interview evaluation
	*/
	public InterviewEvaluation create(long evaluationId);

	/**
	* Removes the interview evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationId the primary key of the interview evaluation
	* @return the interview evaluation that was removed
	* @throws NoSuchInterviewEvaluationException if a interview evaluation with the primary key could not be found
	*/
	public InterviewEvaluation remove(long evaluationId)
		throws NoSuchInterviewEvaluationException;

	public InterviewEvaluation updateImpl(
		InterviewEvaluation interviewEvaluation);

	/**
	* Returns the interview evaluation with the primary key or throws a {@link NoSuchInterviewEvaluationException} if it could not be found.
	*
	* @param evaluationId the primary key of the interview evaluation
	* @return the interview evaluation
	* @throws NoSuchInterviewEvaluationException if a interview evaluation with the primary key could not be found
	*/
	public InterviewEvaluation findByPrimaryKey(long evaluationId)
		throws NoSuchInterviewEvaluationException;

	/**
	* Returns the interview evaluation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param evaluationId the primary key of the interview evaluation
	* @return the interview evaluation, or <code>null</code> if a interview evaluation with the primary key could not be found
	*/
	public InterviewEvaluation fetchByPrimaryKey(long evaluationId);

	@Override
	public java.util.Map<java.io.Serializable, InterviewEvaluation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the interview evaluations.
	*
	* @return the interview evaluations
	*/
	public java.util.List<InterviewEvaluation> findAll();

	/**
	* Returns a range of all the interview evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterviewEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interview evaluations
	* @param end the upper bound of the range of interview evaluations (not inclusive)
	* @return the range of interview evaluations
	*/
	public java.util.List<InterviewEvaluation> findAll(int start, int end);

	/**
	* Returns an ordered range of all the interview evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterviewEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interview evaluations
	* @param end the upper bound of the range of interview evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of interview evaluations
	*/
	public java.util.List<InterviewEvaluation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewEvaluation> orderByComparator);

	/**
	* Returns an ordered range of all the interview evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterviewEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interview evaluations
	* @param end the upper bound of the range of interview evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of interview evaluations
	*/
	public java.util.List<InterviewEvaluation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewEvaluation> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the interview evaluations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of interview evaluations.
	*
	* @return the number of interview evaluations
	*/
	public int countAll();
}