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

import com.liferay.famocom.erpcloud.model.CandidateEvaluation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the candidate evaluation service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.CandidateEvaluationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see CandidateEvaluationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.CandidateEvaluationPersistenceImpl
 * @generated
 */
@ProviderType
public class CandidateEvaluationUtil {
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
	public static void clearCache(CandidateEvaluation candidateEvaluation) {
		getPersistence().clearCache(candidateEvaluation);
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
	public static List<CandidateEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidateEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidateEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CandidateEvaluation> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CandidateEvaluation update(
		CandidateEvaluation candidateEvaluation) {
		return getPersistence().update(candidateEvaluation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CandidateEvaluation update(
		CandidateEvaluation candidateEvaluation, ServiceContext serviceContext) {
		return getPersistence().update(candidateEvaluation, serviceContext);
	}

	/**
	* Caches the candidate evaluation in the entity cache if it is enabled.
	*
	* @param candidateEvaluation the candidate evaluation
	*/
	public static void cacheResult(CandidateEvaluation candidateEvaluation) {
		getPersistence().cacheResult(candidateEvaluation);
	}

	/**
	* Caches the candidate evaluations in the entity cache if it is enabled.
	*
	* @param candidateEvaluations the candidate evaluations
	*/
	public static void cacheResult(
		List<CandidateEvaluation> candidateEvaluations) {
		getPersistence().cacheResult(candidateEvaluations);
	}

	/**
	* Creates a new candidate evaluation with the primary key. Does not add the candidate evaluation to the database.
	*
	* @param candidateEvaluationId the primary key for the new candidate evaluation
	* @return the new candidate evaluation
	*/
	public static CandidateEvaluation create(long candidateEvaluationId) {
		return getPersistence().create(candidateEvaluationId);
	}

	/**
	* Removes the candidate evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation that was removed
	* @throws NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	*/
	public static CandidateEvaluation remove(long candidateEvaluationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidateEvaluationException {
		return getPersistence().remove(candidateEvaluationId);
	}

	public static CandidateEvaluation updateImpl(
		CandidateEvaluation candidateEvaluation) {
		return getPersistence().updateImpl(candidateEvaluation);
	}

	/**
	* Returns the candidate evaluation with the primary key or throws a {@link NoSuchCandidateEvaluationException} if it could not be found.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation
	* @throws NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	*/
	public static CandidateEvaluation findByPrimaryKey(
		long candidateEvaluationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidateEvaluationException {
		return getPersistence().findByPrimaryKey(candidateEvaluationId);
	}

	/**
	* Returns the candidate evaluation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation, or <code>null</code> if a candidate evaluation with the primary key could not be found
	*/
	public static CandidateEvaluation fetchByPrimaryKey(
		long candidateEvaluationId) {
		return getPersistence().fetchByPrimaryKey(candidateEvaluationId);
	}

	public static java.util.Map<java.io.Serializable, CandidateEvaluation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the candidate evaluations.
	*
	* @return the candidate evaluations
	*/
	public static List<CandidateEvaluation> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<CandidateEvaluation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<CandidateEvaluation> findAll(int start, int end,
		OrderByComparator<CandidateEvaluation> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<CandidateEvaluation> findAll(int start, int end,
		OrderByComparator<CandidateEvaluation> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the candidate evaluations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of candidate evaluations.
	*
	* @return the number of candidate evaluations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CandidateEvaluationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CandidateEvaluationPersistence, CandidateEvaluationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CandidateEvaluationPersistence.class);

		ServiceTracker<CandidateEvaluationPersistence, CandidateEvaluationPersistence> serviceTracker =
			new ServiceTracker<CandidateEvaluationPersistence, CandidateEvaluationPersistence>(bundle.getBundleContext(),
				CandidateEvaluationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}