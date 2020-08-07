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

import com.liferay.famocom.erpcloud.exception.NoSuchJobPostException;
import com.liferay.famocom.erpcloud.model.JobPost;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the job post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.JobPostPersistenceImpl
 * @see JobPostUtil
 * @generated
 */
@ProviderType
public interface JobPostPersistence extends BasePersistence<JobPost> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobPostUtil} to access the job post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the job post in the entity cache if it is enabled.
	*
	* @param jobPost the job post
	*/
	public void cacheResult(JobPost jobPost);

	/**
	* Caches the job posts in the entity cache if it is enabled.
	*
	* @param jobPosts the job posts
	*/
	public void cacheResult(java.util.List<JobPost> jobPosts);

	/**
	* Creates a new job post with the primary key. Does not add the job post to the database.
	*
	* @param jobPostId the primary key for the new job post
	* @return the new job post
	*/
	public JobPost create(long jobPostId);

	/**
	* Removes the job post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobPostId the primary key of the job post
	* @return the job post that was removed
	* @throws NoSuchJobPostException if a job post with the primary key could not be found
	*/
	public JobPost remove(long jobPostId) throws NoSuchJobPostException;

	public JobPost updateImpl(JobPost jobPost);

	/**
	* Returns the job post with the primary key or throws a {@link NoSuchJobPostException} if it could not be found.
	*
	* @param jobPostId the primary key of the job post
	* @return the job post
	* @throws NoSuchJobPostException if a job post with the primary key could not be found
	*/
	public JobPost findByPrimaryKey(long jobPostId)
		throws NoSuchJobPostException;

	/**
	* Returns the job post with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobPostId the primary key of the job post
	* @return the job post, or <code>null</code> if a job post with the primary key could not be found
	*/
	public JobPost fetchByPrimaryKey(long jobPostId);

	@Override
	public java.util.Map<java.io.Serializable, JobPost> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the job posts.
	*
	* @return the job posts
	*/
	public java.util.List<JobPost> findAll();

	/**
	* Returns a range of all the job posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job posts
	* @param end the upper bound of the range of job posts (not inclusive)
	* @return the range of job posts
	*/
	public java.util.List<JobPost> findAll(int start, int end);

	/**
	* Returns an ordered range of all the job posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job posts
	* @param end the upper bound of the range of job posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job posts
	*/
	public java.util.List<JobPost> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost> orderByComparator);

	/**
	* Returns an ordered range of all the job posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job posts
	* @param end the upper bound of the range of job posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of job posts
	*/
	public java.util.List<JobPost> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the job posts from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of job posts.
	*
	* @return the number of job posts
	*/
	public int countAll();
}