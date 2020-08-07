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

import com.liferay.famocom.erpcloud.exception.NoSuchJobEvaluationException;
import com.liferay.famocom.erpcloud.model.JobEvaluation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the job evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.JobEvaluationPersistenceImpl
 * @see JobEvaluationUtil
 * @generated
 */
@ProviderType
public interface JobEvaluationPersistence extends BasePersistence<JobEvaluation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobEvaluationUtil} to access the job evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the job evaluations where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @return the matching job evaluations
	*/
	public java.util.List<JobEvaluation> findByjobEvaluation(long jobPostId);

	/**
	* Returns a range of all the job evaluations where jobPostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobPostId the job post ID
	* @param start the lower bound of the range of job evaluations
	* @param end the upper bound of the range of job evaluations (not inclusive)
	* @return the range of matching job evaluations
	*/
	public java.util.List<JobEvaluation> findByjobEvaluation(long jobPostId,
		int start, int end);

	/**
	* Returns an ordered range of all the job evaluations where jobPostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobPostId the job post ID
	* @param start the lower bound of the range of job evaluations
	* @param end the upper bound of the range of job evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job evaluations
	*/
	public java.util.List<JobEvaluation> findByjobEvaluation(long jobPostId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobEvaluation> orderByComparator);

	/**
	* Returns an ordered range of all the job evaluations where jobPostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobPostId the job post ID
	* @param start the lower bound of the range of job evaluations
	* @param end the upper bound of the range of job evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching job evaluations
	*/
	public java.util.List<JobEvaluation> findByjobEvaluation(long jobPostId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobEvaluation> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first job evaluation in the ordered set where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job evaluation
	* @throws NoSuchJobEvaluationException if a matching job evaluation could not be found
	*/
	public JobEvaluation findByjobEvaluation_First(long jobPostId,
		com.liferay.portal.kernel.util.OrderByComparator<JobEvaluation> orderByComparator)
		throws NoSuchJobEvaluationException;

	/**
	* Returns the first job evaluation in the ordered set where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job evaluation, or <code>null</code> if a matching job evaluation could not be found
	*/
	public JobEvaluation fetchByjobEvaluation_First(long jobPostId,
		com.liferay.portal.kernel.util.OrderByComparator<JobEvaluation> orderByComparator);

	/**
	* Returns the last job evaluation in the ordered set where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job evaluation
	* @throws NoSuchJobEvaluationException if a matching job evaluation could not be found
	*/
	public JobEvaluation findByjobEvaluation_Last(long jobPostId,
		com.liferay.portal.kernel.util.OrderByComparator<JobEvaluation> orderByComparator)
		throws NoSuchJobEvaluationException;

	/**
	* Returns the last job evaluation in the ordered set where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job evaluation, or <code>null</code> if a matching job evaluation could not be found
	*/
	public JobEvaluation fetchByjobEvaluation_Last(long jobPostId,
		com.liferay.portal.kernel.util.OrderByComparator<JobEvaluation> orderByComparator);

	/**
	* Returns the job evaluations before and after the current job evaluation in the ordered set where jobPostId = &#63;.
	*
	* @param postEvaluationId the primary key of the current job evaluation
	* @param jobPostId the job post ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job evaluation
	* @throws NoSuchJobEvaluationException if a job evaluation with the primary key could not be found
	*/
	public JobEvaluation[] findByjobEvaluation_PrevAndNext(
		long postEvaluationId, long jobPostId,
		com.liferay.portal.kernel.util.OrderByComparator<JobEvaluation> orderByComparator)
		throws NoSuchJobEvaluationException;

	/**
	* Removes all the job evaluations where jobPostId = &#63; from the database.
	*
	* @param jobPostId the job post ID
	*/
	public void removeByjobEvaluation(long jobPostId);

	/**
	* Returns the number of job evaluations where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @return the number of matching job evaluations
	*/
	public int countByjobEvaluation(long jobPostId);

	/**
	* Caches the job evaluation in the entity cache if it is enabled.
	*
	* @param jobEvaluation the job evaluation
	*/
	public void cacheResult(JobEvaluation jobEvaluation);

	/**
	* Caches the job evaluations in the entity cache if it is enabled.
	*
	* @param jobEvaluations the job evaluations
	*/
	public void cacheResult(java.util.List<JobEvaluation> jobEvaluations);

	/**
	* Creates a new job evaluation with the primary key. Does not add the job evaluation to the database.
	*
	* @param postEvaluationId the primary key for the new job evaluation
	* @return the new job evaluation
	*/
	public JobEvaluation create(long postEvaluationId);

	/**
	* Removes the job evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param postEvaluationId the primary key of the job evaluation
	* @return the job evaluation that was removed
	* @throws NoSuchJobEvaluationException if a job evaluation with the primary key could not be found
	*/
	public JobEvaluation remove(long postEvaluationId)
		throws NoSuchJobEvaluationException;

	public JobEvaluation updateImpl(JobEvaluation jobEvaluation);

	/**
	* Returns the job evaluation with the primary key or throws a {@link NoSuchJobEvaluationException} if it could not be found.
	*
	* @param postEvaluationId the primary key of the job evaluation
	* @return the job evaluation
	* @throws NoSuchJobEvaluationException if a job evaluation with the primary key could not be found
	*/
	public JobEvaluation findByPrimaryKey(long postEvaluationId)
		throws NoSuchJobEvaluationException;

	/**
	* Returns the job evaluation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param postEvaluationId the primary key of the job evaluation
	* @return the job evaluation, or <code>null</code> if a job evaluation with the primary key could not be found
	*/
	public JobEvaluation fetchByPrimaryKey(long postEvaluationId);

	@Override
	public java.util.Map<java.io.Serializable, JobEvaluation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the job evaluations.
	*
	* @return the job evaluations
	*/
	public java.util.List<JobEvaluation> findAll();

	/**
	* Returns a range of all the job evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job evaluations
	* @param end the upper bound of the range of job evaluations (not inclusive)
	* @return the range of job evaluations
	*/
	public java.util.List<JobEvaluation> findAll(int start, int end);

	/**
	* Returns an ordered range of all the job evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job evaluations
	* @param end the upper bound of the range of job evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job evaluations
	*/
	public java.util.List<JobEvaluation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobEvaluation> orderByComparator);

	/**
	* Returns an ordered range of all the job evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job evaluations
	* @param end the upper bound of the range of job evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of job evaluations
	*/
	public java.util.List<JobEvaluation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobEvaluation> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the job evaluations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of job evaluations.
	*
	* @return the number of job evaluations
	*/
	public int countAll();
}