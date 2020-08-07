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

import com.liferay.famocom.erpcloud.exception.NoSuchCandidateReviewException;
import com.liferay.famocom.erpcloud.model.CandidateReview;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the candidate review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.CandidateReviewPersistenceImpl
 * @see CandidateReviewUtil
 * @generated
 */
@ProviderType
public interface CandidateReviewPersistence extends BasePersistence<CandidateReview> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateReviewUtil} to access the candidate review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the candidate reviews where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @return the matching candidate reviews
	*/
	public java.util.List<CandidateReview> findBycandidateReview(
		long recruitProcessId);

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
	public java.util.List<CandidateReview> findBycandidateReview(
		long recruitProcessId, int start, int end);

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
	public java.util.List<CandidateReview> findBycandidateReview(
		long recruitProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateReview> orderByComparator);

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
	public java.util.List<CandidateReview> findBycandidateReview(
		long recruitProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateReview> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate review in the ordered set where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate review
	* @throws NoSuchCandidateReviewException if a matching candidate review could not be found
	*/
	public CandidateReview findBycandidateReview_First(long recruitProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateReview> orderByComparator)
		throws NoSuchCandidateReviewException;

	/**
	* Returns the first candidate review in the ordered set where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate review, or <code>null</code> if a matching candidate review could not be found
	*/
	public CandidateReview fetchBycandidateReview_First(long recruitProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateReview> orderByComparator);

	/**
	* Returns the last candidate review in the ordered set where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate review
	* @throws NoSuchCandidateReviewException if a matching candidate review could not be found
	*/
	public CandidateReview findBycandidateReview_Last(long recruitProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateReview> orderByComparator)
		throws NoSuchCandidateReviewException;

	/**
	* Returns the last candidate review in the ordered set where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate review, or <code>null</code> if a matching candidate review could not be found
	*/
	public CandidateReview fetchBycandidateReview_Last(long recruitProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateReview> orderByComparator);

	/**
	* Returns the candidate reviews before and after the current candidate review in the ordered set where recruitProcessId = &#63;.
	*
	* @param candidateReviewId the primary key of the current candidate review
	* @param recruitProcessId the recruit process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate review
	* @throws NoSuchCandidateReviewException if a candidate review with the primary key could not be found
	*/
	public CandidateReview[] findBycandidateReview_PrevAndNext(
		long candidateReviewId, long recruitProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateReview> orderByComparator)
		throws NoSuchCandidateReviewException;

	/**
	* Removes all the candidate reviews where recruitProcessId = &#63; from the database.
	*
	* @param recruitProcessId the recruit process ID
	*/
	public void removeBycandidateReview(long recruitProcessId);

	/**
	* Returns the number of candidate reviews where recruitProcessId = &#63;.
	*
	* @param recruitProcessId the recruit process ID
	* @return the number of matching candidate reviews
	*/
	public int countBycandidateReview(long recruitProcessId);

	/**
	* Caches the candidate review in the entity cache if it is enabled.
	*
	* @param candidateReview the candidate review
	*/
	public void cacheResult(CandidateReview candidateReview);

	/**
	* Caches the candidate reviews in the entity cache if it is enabled.
	*
	* @param candidateReviews the candidate reviews
	*/
	public void cacheResult(java.util.List<CandidateReview> candidateReviews);

	/**
	* Creates a new candidate review with the primary key. Does not add the candidate review to the database.
	*
	* @param candidateReviewId the primary key for the new candidate review
	* @return the new candidate review
	*/
	public CandidateReview create(long candidateReviewId);

	/**
	* Removes the candidate review with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateReviewId the primary key of the candidate review
	* @return the candidate review that was removed
	* @throws NoSuchCandidateReviewException if a candidate review with the primary key could not be found
	*/
	public CandidateReview remove(long candidateReviewId)
		throws NoSuchCandidateReviewException;

	public CandidateReview updateImpl(CandidateReview candidateReview);

	/**
	* Returns the candidate review with the primary key or throws a {@link NoSuchCandidateReviewException} if it could not be found.
	*
	* @param candidateReviewId the primary key of the candidate review
	* @return the candidate review
	* @throws NoSuchCandidateReviewException if a candidate review with the primary key could not be found
	*/
	public CandidateReview findByPrimaryKey(long candidateReviewId)
		throws NoSuchCandidateReviewException;

	/**
	* Returns the candidate review with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateReviewId the primary key of the candidate review
	* @return the candidate review, or <code>null</code> if a candidate review with the primary key could not be found
	*/
	public CandidateReview fetchByPrimaryKey(long candidateReviewId);

	@Override
	public java.util.Map<java.io.Serializable, CandidateReview> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the candidate reviews.
	*
	* @return the candidate reviews
	*/
	public java.util.List<CandidateReview> findAll();

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
	public java.util.List<CandidateReview> findAll(int start, int end);

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
	public java.util.List<CandidateReview> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateReview> orderByComparator);

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
	public java.util.List<CandidateReview> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateReview> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the candidate reviews from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of candidate reviews.
	*
	* @return the number of candidate reviews
	*/
	public int countAll();
}