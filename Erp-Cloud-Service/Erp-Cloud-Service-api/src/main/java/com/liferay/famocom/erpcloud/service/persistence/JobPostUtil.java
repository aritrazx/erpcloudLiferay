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

import com.liferay.famocom.erpcloud.model.JobPost;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the job post service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.JobPostPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see JobPostPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.JobPostPersistenceImpl
 * @generated
 */
@ProviderType
public class JobPostUtil {
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
	public static void clearCache(JobPost jobPost) {
		getPersistence().clearCache(jobPost);
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
	public static List<JobPost> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JobPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JobPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<JobPost> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static JobPost update(JobPost jobPost) {
		return getPersistence().update(jobPost);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static JobPost update(JobPost jobPost, ServiceContext serviceContext) {
		return getPersistence().update(jobPost, serviceContext);
	}

	/**
	* Caches the job post in the entity cache if it is enabled.
	*
	* @param jobPost the job post
	*/
	public static void cacheResult(JobPost jobPost) {
		getPersistence().cacheResult(jobPost);
	}

	/**
	* Caches the job posts in the entity cache if it is enabled.
	*
	* @param jobPosts the job posts
	*/
	public static void cacheResult(List<JobPost> jobPosts) {
		getPersistence().cacheResult(jobPosts);
	}

	/**
	* Creates a new job post with the primary key. Does not add the job post to the database.
	*
	* @param jobPostId the primary key for the new job post
	* @return the new job post
	*/
	public static JobPost create(long jobPostId) {
		return getPersistence().create(jobPostId);
	}

	/**
	* Removes the job post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobPostId the primary key of the job post
	* @return the job post that was removed
	* @throws NoSuchJobPostException if a job post with the primary key could not be found
	*/
	public static JobPost remove(long jobPostId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchJobPostException {
		return getPersistence().remove(jobPostId);
	}

	public static JobPost updateImpl(JobPost jobPost) {
		return getPersistence().updateImpl(jobPost);
	}

	/**
	* Returns the job post with the primary key or throws a {@link NoSuchJobPostException} if it could not be found.
	*
	* @param jobPostId the primary key of the job post
	* @return the job post
	* @throws NoSuchJobPostException if a job post with the primary key could not be found
	*/
	public static JobPost findByPrimaryKey(long jobPostId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchJobPostException {
		return getPersistence().findByPrimaryKey(jobPostId);
	}

	/**
	* Returns the job post with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobPostId the primary key of the job post
	* @return the job post, or <code>null</code> if a job post with the primary key could not be found
	*/
	public static JobPost fetchByPrimaryKey(long jobPostId) {
		return getPersistence().fetchByPrimaryKey(jobPostId);
	}

	public static java.util.Map<java.io.Serializable, JobPost> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the job posts.
	*
	* @return the job posts
	*/
	public static List<JobPost> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<JobPost> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<JobPost> findAll(int start, int end,
		OrderByComparator<JobPost> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<JobPost> findAll(int start, int end,
		OrderByComparator<JobPost> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the job posts from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of job posts.
	*
	* @return the number of job posts
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JobPostPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<JobPostPersistence, JobPostPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(JobPostPersistence.class);

		ServiceTracker<JobPostPersistence, JobPostPersistence> serviceTracker = new ServiceTracker<JobPostPersistence, JobPostPersistence>(bundle.getBundleContext(),
				JobPostPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}