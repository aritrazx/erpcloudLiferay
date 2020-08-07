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

import com.liferay.famocom.erpcloud.model.InterviewEvaluation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the interview evaluation service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.InterviewEvaluationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see InterviewEvaluationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.InterviewEvaluationPersistenceImpl
 * @generated
 */
@ProviderType
public class InterviewEvaluationUtil {
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
	public static void clearCache(InterviewEvaluation interviewEvaluation) {
		getPersistence().clearCache(interviewEvaluation);
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
	public static List<InterviewEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InterviewEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InterviewEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<InterviewEvaluation> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static InterviewEvaluation update(
		InterviewEvaluation interviewEvaluation) {
		return getPersistence().update(interviewEvaluation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static InterviewEvaluation update(
		InterviewEvaluation interviewEvaluation, ServiceContext serviceContext) {
		return getPersistence().update(interviewEvaluation, serviceContext);
	}

	/**
	* Caches the interview evaluation in the entity cache if it is enabled.
	*
	* @param interviewEvaluation the interview evaluation
	*/
	public static void cacheResult(InterviewEvaluation interviewEvaluation) {
		getPersistence().cacheResult(interviewEvaluation);
	}

	/**
	* Caches the interview evaluations in the entity cache if it is enabled.
	*
	* @param interviewEvaluations the interview evaluations
	*/
	public static void cacheResult(
		List<InterviewEvaluation> interviewEvaluations) {
		getPersistence().cacheResult(interviewEvaluations);
	}

	/**
	* Creates a new interview evaluation with the primary key. Does not add the interview evaluation to the database.
	*
	* @param evaluationId the primary key for the new interview evaluation
	* @return the new interview evaluation
	*/
	public static InterviewEvaluation create(long evaluationId) {
		return getPersistence().create(evaluationId);
	}

	/**
	* Removes the interview evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationId the primary key of the interview evaluation
	* @return the interview evaluation that was removed
	* @throws NoSuchInterviewEvaluationException if a interview evaluation with the primary key could not be found
	*/
	public static InterviewEvaluation remove(long evaluationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchInterviewEvaluationException {
		return getPersistence().remove(evaluationId);
	}

	public static InterviewEvaluation updateImpl(
		InterviewEvaluation interviewEvaluation) {
		return getPersistence().updateImpl(interviewEvaluation);
	}

	/**
	* Returns the interview evaluation with the primary key or throws a {@link NoSuchInterviewEvaluationException} if it could not be found.
	*
	* @param evaluationId the primary key of the interview evaluation
	* @return the interview evaluation
	* @throws NoSuchInterviewEvaluationException if a interview evaluation with the primary key could not be found
	*/
	public static InterviewEvaluation findByPrimaryKey(long evaluationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchInterviewEvaluationException {
		return getPersistence().findByPrimaryKey(evaluationId);
	}

	/**
	* Returns the interview evaluation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param evaluationId the primary key of the interview evaluation
	* @return the interview evaluation, or <code>null</code> if a interview evaluation with the primary key could not be found
	*/
	public static InterviewEvaluation fetchByPrimaryKey(long evaluationId) {
		return getPersistence().fetchByPrimaryKey(evaluationId);
	}

	public static java.util.Map<java.io.Serializable, InterviewEvaluation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the interview evaluations.
	*
	* @return the interview evaluations
	*/
	public static List<InterviewEvaluation> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<InterviewEvaluation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<InterviewEvaluation> findAll(int start, int end,
		OrderByComparator<InterviewEvaluation> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<InterviewEvaluation> findAll(int start, int end,
		OrderByComparator<InterviewEvaluation> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the interview evaluations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of interview evaluations.
	*
	* @return the number of interview evaluations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InterviewEvaluationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<InterviewEvaluationPersistence, InterviewEvaluationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(InterviewEvaluationPersistence.class);

		ServiceTracker<InterviewEvaluationPersistence, InterviewEvaluationPersistence> serviceTracker =
			new ServiceTracker<InterviewEvaluationPersistence, InterviewEvaluationPersistence>(bundle.getBundleContext(),
				InterviewEvaluationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}