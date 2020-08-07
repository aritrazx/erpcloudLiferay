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

import com.liferay.famocom.erpcloud.model.JobEvaluation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the job evaluation service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.JobEvaluationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see JobEvaluationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.JobEvaluationPersistenceImpl
 * @generated
 */
@ProviderType
public class JobEvaluationUtil {
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
	public static void clearCache(JobEvaluation jobEvaluation) {
		getPersistence().clearCache(jobEvaluation);
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
	public static List<JobEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JobEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JobEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<JobEvaluation> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static JobEvaluation update(JobEvaluation jobEvaluation) {
		return getPersistence().update(jobEvaluation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static JobEvaluation update(JobEvaluation jobEvaluation,
		ServiceContext serviceContext) {
		return getPersistence().update(jobEvaluation, serviceContext);
	}

	/**
	* Returns all the job evaluations where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @return the matching job evaluations
	*/
	public static List<JobEvaluation> findByjobEvaluation(long jobPostId) {
		return getPersistence().findByjobEvaluation(jobPostId);
	}

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
	public static List<JobEvaluation> findByjobEvaluation(long jobPostId,
		int start, int end) {
		return getPersistence().findByjobEvaluation(jobPostId, start, end);
	}

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
	public static List<JobEvaluation> findByjobEvaluation(long jobPostId,
		int start, int end, OrderByComparator<JobEvaluation> orderByComparator) {
		return getPersistence()
				   .findByjobEvaluation(jobPostId, start, end, orderByComparator);
	}

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
	public static List<JobEvaluation> findByjobEvaluation(long jobPostId,
		int start, int end, OrderByComparator<JobEvaluation> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByjobEvaluation(jobPostId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first job evaluation in the ordered set where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job evaluation
	* @throws NoSuchJobEvaluationException if a matching job evaluation could not be found
	*/
	public static JobEvaluation findByjobEvaluation_First(long jobPostId,
		OrderByComparator<JobEvaluation> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchJobEvaluationException {
		return getPersistence()
				   .findByjobEvaluation_First(jobPostId, orderByComparator);
	}

	/**
	* Returns the first job evaluation in the ordered set where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job evaluation, or <code>null</code> if a matching job evaluation could not be found
	*/
	public static JobEvaluation fetchByjobEvaluation_First(long jobPostId,
		OrderByComparator<JobEvaluation> orderByComparator) {
		return getPersistence()
				   .fetchByjobEvaluation_First(jobPostId, orderByComparator);
	}

	/**
	* Returns the last job evaluation in the ordered set where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job evaluation
	* @throws NoSuchJobEvaluationException if a matching job evaluation could not be found
	*/
	public static JobEvaluation findByjobEvaluation_Last(long jobPostId,
		OrderByComparator<JobEvaluation> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchJobEvaluationException {
		return getPersistence()
				   .findByjobEvaluation_Last(jobPostId, orderByComparator);
	}

	/**
	* Returns the last job evaluation in the ordered set where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job evaluation, or <code>null</code> if a matching job evaluation could not be found
	*/
	public static JobEvaluation fetchByjobEvaluation_Last(long jobPostId,
		OrderByComparator<JobEvaluation> orderByComparator) {
		return getPersistence()
				   .fetchByjobEvaluation_Last(jobPostId, orderByComparator);
	}

	/**
	* Returns the job evaluations before and after the current job evaluation in the ordered set where jobPostId = &#63;.
	*
	* @param postEvaluationId the primary key of the current job evaluation
	* @param jobPostId the job post ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job evaluation
	* @throws NoSuchJobEvaluationException if a job evaluation with the primary key could not be found
	*/
	public static JobEvaluation[] findByjobEvaluation_PrevAndNext(
		long postEvaluationId, long jobPostId,
		OrderByComparator<JobEvaluation> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchJobEvaluationException {
		return getPersistence()
				   .findByjobEvaluation_PrevAndNext(postEvaluationId,
			jobPostId, orderByComparator);
	}

	/**
	* Removes all the job evaluations where jobPostId = &#63; from the database.
	*
	* @param jobPostId the job post ID
	*/
	public static void removeByjobEvaluation(long jobPostId) {
		getPersistence().removeByjobEvaluation(jobPostId);
	}

	/**
	* Returns the number of job evaluations where jobPostId = &#63;.
	*
	* @param jobPostId the job post ID
	* @return the number of matching job evaluations
	*/
	public static int countByjobEvaluation(long jobPostId) {
		return getPersistence().countByjobEvaluation(jobPostId);
	}

	/**
	* Caches the job evaluation in the entity cache if it is enabled.
	*
	* @param jobEvaluation the job evaluation
	*/
	public static void cacheResult(JobEvaluation jobEvaluation) {
		getPersistence().cacheResult(jobEvaluation);
	}

	/**
	* Caches the job evaluations in the entity cache if it is enabled.
	*
	* @param jobEvaluations the job evaluations
	*/
	public static void cacheResult(List<JobEvaluation> jobEvaluations) {
		getPersistence().cacheResult(jobEvaluations);
	}

	/**
	* Creates a new job evaluation with the primary key. Does not add the job evaluation to the database.
	*
	* @param postEvaluationId the primary key for the new job evaluation
	* @return the new job evaluation
	*/
	public static JobEvaluation create(long postEvaluationId) {
		return getPersistence().create(postEvaluationId);
	}

	/**
	* Removes the job evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param postEvaluationId the primary key of the job evaluation
	* @return the job evaluation that was removed
	* @throws NoSuchJobEvaluationException if a job evaluation with the primary key could not be found
	*/
	public static JobEvaluation remove(long postEvaluationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchJobEvaluationException {
		return getPersistence().remove(postEvaluationId);
	}

	public static JobEvaluation updateImpl(JobEvaluation jobEvaluation) {
		return getPersistence().updateImpl(jobEvaluation);
	}

	/**
	* Returns the job evaluation with the primary key or throws a {@link NoSuchJobEvaluationException} if it could not be found.
	*
	* @param postEvaluationId the primary key of the job evaluation
	* @return the job evaluation
	* @throws NoSuchJobEvaluationException if a job evaluation with the primary key could not be found
	*/
	public static JobEvaluation findByPrimaryKey(long postEvaluationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchJobEvaluationException {
		return getPersistence().findByPrimaryKey(postEvaluationId);
	}

	/**
	* Returns the job evaluation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param postEvaluationId the primary key of the job evaluation
	* @return the job evaluation, or <code>null</code> if a job evaluation with the primary key could not be found
	*/
	public static JobEvaluation fetchByPrimaryKey(long postEvaluationId) {
		return getPersistence().fetchByPrimaryKey(postEvaluationId);
	}

	public static java.util.Map<java.io.Serializable, JobEvaluation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the job evaluations.
	*
	* @return the job evaluations
	*/
	public static List<JobEvaluation> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<JobEvaluation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<JobEvaluation> findAll(int start, int end,
		OrderByComparator<JobEvaluation> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<JobEvaluation> findAll(int start, int end,
		OrderByComparator<JobEvaluation> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the job evaluations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of job evaluations.
	*
	* @return the number of job evaluations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JobEvaluationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<JobEvaluationPersistence, JobEvaluationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(JobEvaluationPersistence.class);

		ServiceTracker<JobEvaluationPersistence, JobEvaluationPersistence> serviceTracker =
			new ServiceTracker<JobEvaluationPersistence, JobEvaluationPersistence>(bundle.getBundleContext(),
				JobEvaluationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}