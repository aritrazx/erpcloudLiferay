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

import com.liferay.famocom.erpcloud.model.Evaluation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the evaluation service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.EvaluationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see EvaluationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EvaluationPersistenceImpl
 * @generated
 */
@ProviderType
public class EvaluationUtil {
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
	public static void clearCache(Evaluation evaluation) {
		getPersistence().clearCache(evaluation);
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
	public static List<Evaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Evaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Evaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Evaluation> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Evaluation update(Evaluation evaluation) {
		return getPersistence().update(evaluation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Evaluation update(Evaluation evaluation,
		ServiceContext serviceContext) {
		return getPersistence().update(evaluation, serviceContext);
	}

	/**
	* Caches the evaluation in the entity cache if it is enabled.
	*
	* @param evaluation the evaluation
	*/
	public static void cacheResult(Evaluation evaluation) {
		getPersistence().cacheResult(evaluation);
	}

	/**
	* Caches the evaluations in the entity cache if it is enabled.
	*
	* @param evaluations the evaluations
	*/
	public static void cacheResult(List<Evaluation> evaluations) {
		getPersistence().cacheResult(evaluations);
	}

	/**
	* Creates a new evaluation with the primary key. Does not add the evaluation to the database.
	*
	* @param evaluationId the primary key for the new evaluation
	* @return the new evaluation
	*/
	public static Evaluation create(long evaluationId) {
		return getPersistence().create(evaluationId);
	}

	/**
	* Removes the evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationId the primary key of the evaluation
	* @return the evaluation that was removed
	* @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	*/
	public static Evaluation remove(long evaluationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEvaluationException {
		return getPersistence().remove(evaluationId);
	}

	public static Evaluation updateImpl(Evaluation evaluation) {
		return getPersistence().updateImpl(evaluation);
	}

	/**
	* Returns the evaluation with the primary key or throws a {@link NoSuchEvaluationException} if it could not be found.
	*
	* @param evaluationId the primary key of the evaluation
	* @return the evaluation
	* @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	*/
	public static Evaluation findByPrimaryKey(long evaluationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEvaluationException {
		return getPersistence().findByPrimaryKey(evaluationId);
	}

	/**
	* Returns the evaluation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param evaluationId the primary key of the evaluation
	* @return the evaluation, or <code>null</code> if a evaluation with the primary key could not be found
	*/
	public static Evaluation fetchByPrimaryKey(long evaluationId) {
		return getPersistence().fetchByPrimaryKey(evaluationId);
	}

	public static java.util.Map<java.io.Serializable, Evaluation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the evaluations.
	*
	* @return the evaluations
	*/
	public static List<Evaluation> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Evaluation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Evaluation> findAll(int start, int end,
		OrderByComparator<Evaluation> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Evaluation> findAll(int start, int end,
		OrderByComparator<Evaluation> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the evaluations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of evaluations.
	*
	* @return the number of evaluations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EvaluationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EvaluationPersistence, EvaluationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EvaluationPersistence.class);

		ServiceTracker<EvaluationPersistence, EvaluationPersistence> serviceTracker =
			new ServiceTracker<EvaluationPersistence, EvaluationPersistence>(bundle.getBundleContext(),
				EvaluationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}