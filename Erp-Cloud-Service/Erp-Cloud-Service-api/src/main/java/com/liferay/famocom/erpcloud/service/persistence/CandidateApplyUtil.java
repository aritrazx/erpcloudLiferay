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

import com.liferay.famocom.erpcloud.model.CandidateApply;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the candidate apply service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.CandidateApplyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see CandidateApplyPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.CandidateApplyPersistenceImpl
 * @generated
 */
@ProviderType
public class CandidateApplyUtil {
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
	public static void clearCache(CandidateApply candidateApply) {
		getPersistence().clearCache(candidateApply);
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
	public static List<CandidateApply> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidateApply> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidateApply> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CandidateApply> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CandidateApply update(CandidateApply candidateApply) {
		return getPersistence().update(candidateApply);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CandidateApply update(CandidateApply candidateApply,
		ServiceContext serviceContext) {
		return getPersistence().update(candidateApply, serviceContext);
	}

	/**
	* Caches the candidate apply in the entity cache if it is enabled.
	*
	* @param candidateApply the candidate apply
	*/
	public static void cacheResult(CandidateApply candidateApply) {
		getPersistence().cacheResult(candidateApply);
	}

	/**
	* Caches the candidate applies in the entity cache if it is enabled.
	*
	* @param candidateApplies the candidate applies
	*/
	public static void cacheResult(List<CandidateApply> candidateApplies) {
		getPersistence().cacheResult(candidateApplies);
	}

	/**
	* Creates a new candidate apply with the primary key. Does not add the candidate apply to the database.
	*
	* @param applyCandidateId the primary key for the new candidate apply
	* @return the new candidate apply
	*/
	public static CandidateApply create(long applyCandidateId) {
		return getPersistence().create(applyCandidateId);
	}

	/**
	* Removes the candidate apply with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applyCandidateId the primary key of the candidate apply
	* @return the candidate apply that was removed
	* @throws NoSuchCandidateApplyException if a candidate apply with the primary key could not be found
	*/
	public static CandidateApply remove(long applyCandidateId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidateApplyException {
		return getPersistence().remove(applyCandidateId);
	}

	public static CandidateApply updateImpl(CandidateApply candidateApply) {
		return getPersistence().updateImpl(candidateApply);
	}

	/**
	* Returns the candidate apply with the primary key or throws a {@link NoSuchCandidateApplyException} if it could not be found.
	*
	* @param applyCandidateId the primary key of the candidate apply
	* @return the candidate apply
	* @throws NoSuchCandidateApplyException if a candidate apply with the primary key could not be found
	*/
	public static CandidateApply findByPrimaryKey(long applyCandidateId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidateApplyException {
		return getPersistence().findByPrimaryKey(applyCandidateId);
	}

	/**
	* Returns the candidate apply with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applyCandidateId the primary key of the candidate apply
	* @return the candidate apply, or <code>null</code> if a candidate apply with the primary key could not be found
	*/
	public static CandidateApply fetchByPrimaryKey(long applyCandidateId) {
		return getPersistence().fetchByPrimaryKey(applyCandidateId);
	}

	public static java.util.Map<java.io.Serializable, CandidateApply> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the candidate applies.
	*
	* @return the candidate applies
	*/
	public static List<CandidateApply> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<CandidateApply> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<CandidateApply> findAll(int start, int end,
		OrderByComparator<CandidateApply> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<CandidateApply> findAll(int start, int end,
		OrderByComparator<CandidateApply> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the candidate applies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of candidate applies.
	*
	* @return the number of candidate applies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CandidateApplyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CandidateApplyPersistence, CandidateApplyPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CandidateApplyPersistence.class);

		ServiceTracker<CandidateApplyPersistence, CandidateApplyPersistence> serviceTracker =
			new ServiceTracker<CandidateApplyPersistence, CandidateApplyPersistence>(bundle.getBundleContext(),
				CandidateApplyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}