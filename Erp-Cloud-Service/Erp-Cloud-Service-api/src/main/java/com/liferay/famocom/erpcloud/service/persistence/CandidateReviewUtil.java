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

import com.liferay.famocom.erpcloud.model.CandidateReview;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the candidate review service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.CandidateReviewPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see CandidateReviewPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.CandidateReviewPersistenceImpl
 * @generated
 */
@ProviderType
public class CandidateReviewUtil {
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
	public static void clearCache(CandidateReview candidateReview) {
		getPersistence().clearCache(candidateReview);
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
	public static List<CandidateReview> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidateReview> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidateReview> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CandidateReview> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CandidateReview update(CandidateReview candidateReview) {
		return getPersistence().update(candidateReview);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CandidateReview update(CandidateReview candidateReview,
		ServiceContext serviceContext) {
		return getPersistence().update(candidateReview, serviceContext);
	}

	/**
	* Returns all the candidate reviews where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @return the matching candidate reviews
	*/
	public static List<CandidateReview> findBycandidateReview(
		long recruitProcessId) {
		return getPersistence().findBycandidateReview(recruitProcessId);
	}

	/**
	* Returns a range of all the candidate reviews where recruitProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitProcessId the recruit process ID
	* @param start the lower bound of the range of candidate reviews
	* @param end the upper bound of the range of candidate reviews (not inclusive)
	* @return the range of matching candidate reviews
	*/
	public static List<CandidateReview> findBycandidateReview(
		long recruitProcessId, int start, int end) {
		return getPersistence()
				   .findBycandidateReview(recruitProcessId, start, end);
	}

	/**
	* Returns an ordered range of all the candidate reviews where recruitProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitProcessId the recruit process ID
	* @param start the lower bound of the range of candidate reviews
	* @param end the upper bound of the range of candidate reviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate reviews
	*/
	public static List<CandidateReview> findBycandidateReview(
		long recruitProcessId, int start, int end,
		OrderByComparator<CandidateReview> orderByComparator) {
		return getPersistence()
				   .findBycandidateReview(recruitProcessId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate reviews where recruitProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitProcessId the recruit process ID
	* @param start the lower bound of the range of candidate reviews
	* @param end the upper bound of the range of candidate reviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate reviews
	*/
	public static List<CandidateReview> findBycandidateReview(
		long recruitProcessId, int start, int end,
		OrderByComparator<CandidateReview> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBycandidateReview(recruitProcessId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first candidate review in the ordered set where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate review
	* @throws NoSuchCandidateReviewException if a matching candidate review could not be found
	*/
	public static CandidateReview findBycandidateReview_First(
		long recruitProcessId,
		OrderByComparator<CandidateReview> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidateReviewException {
		return getPersistence()
				   .findBycandidateReview_First(recruitProcessId,
			orderByComparator);
	}

	/**
	* Returns the first candidate review in the ordered set where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate review, or <code>null</code> if a matching candidate review could not be found
	*/
	public static CandidateReview fetchBycandidateReview_First(
		long recruitProcessId,
		OrderByComparator<CandidateReview> orderByComparator) {
		return getPersistence()
				   .fetchBycandidateReview_First(recruitProcessId,
			orderByComparator);
	}

	/**
	* Returns the last candidate review in the ordered set where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate review
	* @throws NoSuchCandidateReviewException if a matching candidate review could not be found
	*/
	public static CandidateReview findBycandidateReview_Last(
		long recruitProcessId,
		OrderByComparator<CandidateReview> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidateReviewException {
		return getPersistence()
				   .findBycandidateReview_Last(recruitProcessId,
			orderByComparator);
	}

	/**
	* Returns the last candidate review in the ordered set where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate review, or <code>null</code> if a matching candidate review could not be found
	*/
	public static CandidateReview fetchBycandidateReview_Last(
		long recruitProcessId,
		OrderByComparator<CandidateReview> orderByComparator) {
		return getPersistence()
				   .fetchBycandidateReview_Last(recruitProcessId,
			orderByComparator);
	}

	/**
	* Returns the candidate reviews before and after the current candidate review in the ordered set where recruitProcessId = &#63;.
	*
	* @param candidateReviewId the primary key of the current candidate review
	* @param recruitProcessId the recruit process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate review
	* @throws NoSuchCandidateReviewException if a candidate review with the primary key could not be found
	*/
	public static CandidateReview[] findBycandidateReview_PrevAndNext(
		long candidateReviewId, long recruitProcessId,
		OrderByComparator<CandidateReview> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidateReviewException {
		return getPersistence()
				   .findBycandidateReview_PrevAndNext(candidateReviewId,
			recruitProcessId, orderByComparator);
	}

	/**
	* Removes all the candidate reviews where recruitProcessId = &#63; from the database.
	*
	* @param recruitProcessId the recruit process ID
	*/
	public static void removeBycandidateReview(long recruitProcessId) {
		getPersistence().removeBycandidateReview(recruitProcessId);
	}

	/**
	* Returns the number of candidate reviews where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @return the number of matching candidate reviews
	*/
	public static int countBycandidateReview(long recruitProcessId) {
		return getPersistence().countBycandidateReview(recruitProcessId);
	}

	/**
	* Caches the candidate review in the entity cache if it is enabled.
	*
	* @param candidateReview the candidate review
	*/
	public static void cacheResult(CandidateReview candidateReview) {
		getPersistence().cacheResult(candidateReview);
	}

	/**
	* Caches the candidate reviews in the entity cache if it is enabled.
	*
	* @param candidateReviews the candidate reviews
	*/
	public static void cacheResult(List<CandidateReview> candidateReviews) {
		getPersistence().cacheResult(candidateReviews);
	}

	/**
	* Creates a new candidate review with the primary key. Does not add the candidate review to the database.
	*
	* @param candidateReviewId the primary key for the new candidate review
	* @return the new candidate review
	*/
	public static CandidateReview create(long candidateReviewId) {
		return getPersistence().create(candidateReviewId);
	}

	/**
	* Removes the candidate review with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateReviewId the primary key of the candidate review
	* @return the candidate review that was removed
	* @throws NoSuchCandidateReviewException if a candidate review with the primary key could not be found
	*/
	public static CandidateReview remove(long candidateReviewId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidateReviewException {
		return getPersistence().remove(candidateReviewId);
	}

	public static CandidateReview updateImpl(CandidateReview candidateReview) {
		return getPersistence().updateImpl(candidateReview);
	}

	/**
	* Returns the candidate review with the primary key or throws a {@link NoSuchCandidateReviewException} if it could not be found.
	*
	* @param candidateReviewId the primary key of the candidate review
	* @return the candidate review
	* @throws NoSuchCandidateReviewException if a candidate review with the primary key could not be found
	*/
	public static CandidateReview findByPrimaryKey(long candidateReviewId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidateReviewException {
		return getPersistence().findByPrimaryKey(candidateReviewId);
	}

	/**
	* Returns the candidate review with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateReviewId the primary key of the candidate review
	* @return the candidate review, or <code>null</code> if a candidate review with the primary key could not be found
	*/
	public static CandidateReview fetchByPrimaryKey(long candidateReviewId) {
		return getPersistence().fetchByPrimaryKey(candidateReviewId);
	}

	public static java.util.Map<java.io.Serializable, CandidateReview> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the candidate reviews.
	*
	* @return the candidate reviews
	*/
	public static List<CandidateReview> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the candidate reviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate reviews
	* @param end the upper bound of the range of candidate reviews (not inclusive)
	* @return the range of candidate reviews
	*/
	public static List<CandidateReview> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the candidate reviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate reviews
	* @param end the upper bound of the range of candidate reviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of candidate reviews
	*/
	public static List<CandidateReview> findAll(int start, int end,
		OrderByComparator<CandidateReview> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate reviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate reviews
	* @param end the upper bound of the range of candidate reviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of candidate reviews
	*/
	public static List<CandidateReview> findAll(int start, int end,
		OrderByComparator<CandidateReview> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the candidate reviews from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of candidate reviews.
	*
	* @return the number of candidate reviews
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CandidateReviewPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CandidateReviewPersistence, CandidateReviewPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CandidateReviewPersistence.class);

		ServiceTracker<CandidateReviewPersistence, CandidateReviewPersistence> serviceTracker =
			new ServiceTracker<CandidateReviewPersistence, CandidateReviewPersistence>(bundle.getBundleContext(),
				CandidateReviewPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}