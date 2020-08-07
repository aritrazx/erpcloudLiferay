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

import com.liferay.famocom.erpcloud.exception.NoSuchEvaluationException;
import com.liferay.famocom.erpcloud.model.Evaluation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EvaluationPersistenceImpl
 * @see EvaluationUtil
 * @generated
 */
@ProviderType
public interface EvaluationPersistence extends BasePersistence<Evaluation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EvaluationUtil} to access the evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the evaluation in the entity cache if it is enabled.
	*
	* @param evaluation the evaluation
	*/
	public void cacheResult(Evaluation evaluation);

	/**
	* Caches the evaluations in the entity cache if it is enabled.
	*
	* @param evaluations the evaluations
	*/
	public void cacheResult(java.util.List<Evaluation> evaluations);

	/**
	* Creates a new evaluation with the primary key. Does not add the evaluation to the database.
	*
	* @param evaluationId the primary key for the new evaluation
	* @return the new evaluation
	*/
	public Evaluation create(long evaluationId);

	/**
	* Removes the evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationId the primary key of the evaluation
	* @return the evaluation that was removed
	* @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	*/
	public Evaluation remove(long evaluationId)
		throws NoSuchEvaluationException;

	public Evaluation updateImpl(Evaluation evaluation);

	/**
	* Returns the evaluation with the primary key or throws a {@link NoSuchEvaluationException} if it could not be found.
	*
	* @param evaluationId the primary key of the evaluation
	* @return the evaluation
	* @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	*/
	public Evaluation findByPrimaryKey(long evaluationId)
		throws NoSuchEvaluationException;

	/**
	* Returns the evaluation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param evaluationId the primary key of the evaluation
	* @return the evaluation, or <code>null</code> if a evaluation with the primary key could not be found
	*/
	public Evaluation fetchByPrimaryKey(long evaluationId);

	@Override
	public java.util.Map<java.io.Serializable, Evaluation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the evaluations.
	*
	* @return the evaluations
	*/
	public java.util.List<Evaluation> findAll();

	/**
	* Returns a range of all the evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evaluations
	* @param end the upper bound of the range of evaluations (not inclusive)
	* @return the range of evaluations
	*/
	public java.util.List<Evaluation> findAll(int start, int end);

	/**
	* Returns an ordered range of all the evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evaluations
	* @param end the upper bound of the range of evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of evaluations
	*/
	public java.util.List<Evaluation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation> orderByComparator);

	/**
	* Returns an ordered range of all the evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evaluations
	* @param end the upper bound of the range of evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of evaluations
	*/
	public java.util.List<Evaluation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the evaluations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of evaluations.
	*
	* @return the number of evaluations
	*/
	public int countAll();
}