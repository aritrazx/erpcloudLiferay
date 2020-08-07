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

import com.liferay.famocom.erpcloud.exception.NoSuchJobOpeningException;
import com.liferay.famocom.erpcloud.model.JobOpening;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the job opening service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.JobOpeningPersistenceImpl
 * @see JobOpeningUtil
 * @generated
 */
@ProviderType
public interface JobOpeningPersistence extends BasePersistence<JobOpening> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobOpeningUtil} to access the job opening persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the job opening in the entity cache if it is enabled.
	*
	* @param jobOpening the job opening
	*/
	public void cacheResult(JobOpening jobOpening);

	/**
	* Caches the job openings in the entity cache if it is enabled.
	*
	* @param jobOpenings the job openings
	*/
	public void cacheResult(java.util.List<JobOpening> jobOpenings);

	/**
	* Creates a new job opening with the primary key. Does not add the job opening to the database.
	*
	* @param jobOpeningId the primary key for the new job opening
	* @return the new job opening
	*/
	public JobOpening create(long jobOpeningId);

	/**
	* Removes the job opening with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobOpeningId the primary key of the job opening
	* @return the job opening that was removed
	* @throws NoSuchJobOpeningException if a job opening with the primary key could not be found
	*/
	public JobOpening remove(long jobOpeningId)
		throws NoSuchJobOpeningException;

	public JobOpening updateImpl(JobOpening jobOpening);

	/**
	* Returns the job opening with the primary key or throws a {@link NoSuchJobOpeningException} if it could not be found.
	*
	* @param jobOpeningId the primary key of the job opening
	* @return the job opening
	* @throws NoSuchJobOpeningException if a job opening with the primary key could not be found
	*/
	public JobOpening findByPrimaryKey(long jobOpeningId)
		throws NoSuchJobOpeningException;

	/**
	* Returns the job opening with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobOpeningId the primary key of the job opening
	* @return the job opening, or <code>null</code> if a job opening with the primary key could not be found
	*/
	public JobOpening fetchByPrimaryKey(long jobOpeningId);

	@Override
	public java.util.Map<java.io.Serializable, JobOpening> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the job openings.
	*
	* @return the job openings
	*/
	public java.util.List<JobOpening> findAll();

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
	public java.util.List<JobOpening> findAll(int start, int end);

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
	public java.util.List<JobOpening> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobOpening> orderByComparator);

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
	public java.util.List<JobOpening> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobOpening> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the job openings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of job openings.
	*
	* @return the number of job openings
	*/
	public int countAll();
}