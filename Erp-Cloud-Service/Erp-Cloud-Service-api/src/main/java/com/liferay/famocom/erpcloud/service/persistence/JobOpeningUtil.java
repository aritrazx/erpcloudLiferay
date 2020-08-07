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

import com.liferay.famocom.erpcloud.model.JobOpening;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the job opening service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.JobOpeningPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see JobOpeningPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.JobOpeningPersistenceImpl
 * @generated
 */
@ProviderType
public class JobOpeningUtil {
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
	public static void clearCache(JobOpening jobOpening) {
		getPersistence().clearCache(jobOpening);
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
	public static List<JobOpening> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JobOpening> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JobOpening> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<JobOpening> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static JobOpening update(JobOpening jobOpening) {
		return getPersistence().update(jobOpening);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static JobOpening update(JobOpening jobOpening,
		ServiceContext serviceContext) {
		return getPersistence().update(jobOpening, serviceContext);
	}

	/**
	* Caches the job opening in the entity cache if it is enabled.
	*
	* @param jobOpening the job opening
	*/
	public static void cacheResult(JobOpening jobOpening) {
		getPersistence().cacheResult(jobOpening);
	}

	/**
	* Caches the job openings in the entity cache if it is enabled.
	*
	* @param jobOpenings the job openings
	*/
	public static void cacheResult(List<JobOpening> jobOpenings) {
		getPersistence().cacheResult(jobOpenings);
	}

	/**
	* Creates a new job opening with the primary key. Does not add the job opening to the database.
	*
	* @param jobOpeningId the primary key for the new job opening
	* @return the new job opening
	*/
	public static JobOpening create(long jobOpeningId) {
		return getPersistence().create(jobOpeningId);
	}

	/**
	* Removes the job opening with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobOpeningId the primary key of the job opening
	* @return the job opening that was removed
	* @throws NoSuchJobOpeningException if a job opening with the primary key could not be found
	*/
	public static JobOpening remove(long jobOpeningId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchJobOpeningException {
		return getPersistence().remove(jobOpeningId);
	}

	public static JobOpening updateImpl(JobOpening jobOpening) {
		return getPersistence().updateImpl(jobOpening);
	}

	/**
	* Returns the job opening with the primary key or throws a {@link NoSuchJobOpeningException} if it could not be found.
	*
	* @param jobOpeningId the primary key of the job opening
	* @return the job opening
	* @throws NoSuchJobOpeningException if a job opening with the primary key could not be found
	*/
	public static JobOpening findByPrimaryKey(long jobOpeningId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchJobOpeningException {
		return getPersistence().findByPrimaryKey(jobOpeningId);
	}

	/**
	* Returns the job opening with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobOpeningId the primary key of the job opening
	* @return the job opening, or <code>null</code> if a job opening with the primary key could not be found
	*/
	public static JobOpening fetchByPrimaryKey(long jobOpeningId) {
		return getPersistence().fetchByPrimaryKey(jobOpeningId);
	}

	public static java.util.Map<java.io.Serializable, JobOpening> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the job openings.
	*
	* @return the job openings
	*/
	public static List<JobOpening> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the job openings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobOpeningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job openings
	* @param end the upper bound of the range of job openings (not inclusive)
	* @return the range of job openings
	*/
	public static List<JobOpening> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the job openings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobOpeningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job openings
	* @param end the upper bound of the range of job openings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job openings
	*/
	public static List<JobOpening> findAll(int start, int end,
		OrderByComparator<JobOpening> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the job openings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobOpeningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job openings
	* @param end the upper bound of the range of job openings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of job openings
	*/
	public static List<JobOpening> findAll(int start, int end,
		OrderByComparator<JobOpening> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the job openings from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of job openings.
	*
	* @return the number of job openings
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JobOpeningPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<JobOpeningPersistence, JobOpeningPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(JobOpeningPersistence.class);

		ServiceTracker<JobOpeningPersistence, JobOpeningPersistence> serviceTracker =
			new ServiceTracker<JobOpeningPersistence, JobOpeningPersistence>(bundle.getBundleContext(),
				JobOpeningPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}