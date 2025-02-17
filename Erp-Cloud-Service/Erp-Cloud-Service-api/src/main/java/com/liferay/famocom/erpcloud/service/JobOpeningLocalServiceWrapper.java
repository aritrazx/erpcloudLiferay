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

package com.liferay.famocom.erpcloud.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobOpeningLocalService}.
 *
 * @author Samaresh
 * @see JobOpeningLocalService
 * @generated
 */
@ProviderType
public class JobOpeningLocalServiceWrapper implements JobOpeningLocalService,
	ServiceWrapper<JobOpeningLocalService> {
	public JobOpeningLocalServiceWrapper(
		JobOpeningLocalService jobOpeningLocalService) {
		_jobOpeningLocalService = jobOpeningLocalService;
	}

	/**
	* Adds the job opening to the database. Also notifies the appropriate model listeners.
	*
	* @param jobOpening the job opening
	* @return the job opening that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.JobOpening addJobOpening(
		com.liferay.famocom.erpcloud.model.JobOpening jobOpening) {
		return _jobOpeningLocalService.addJobOpening(jobOpening);
	}

	/**
	* Creates a new job opening with the primary key. Does not add the job opening to the database.
	*
	* @param jobOpeningId the primary key for the new job opening
	* @return the new job opening
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.JobOpening createJobOpening(
		long jobOpeningId) {
		return _jobOpeningLocalService.createJobOpening(jobOpeningId);
	}

	/**
	* Deletes the job opening from the database. Also notifies the appropriate model listeners.
	*
	* @param jobOpening the job opening
	* @return the job opening that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.JobOpening deleteJobOpening(
		com.liferay.famocom.erpcloud.model.JobOpening jobOpening) {
		return _jobOpeningLocalService.deleteJobOpening(jobOpening);
	}

	/**
	* Deletes the job opening with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobOpeningId the primary key of the job opening
	* @return the job opening that was removed
	* @throws PortalException if a job opening with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.JobOpening deleteJobOpening(
		long jobOpeningId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _jobOpeningLocalService.deleteJobOpening(jobOpeningId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _jobOpeningLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobOpeningLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _jobOpeningLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.JobOpeningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _jobOpeningLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.JobOpeningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _jobOpeningLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _jobOpeningLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _jobOpeningLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.JobOpening fetchJobOpening(
		long jobOpeningId) {
		return _jobOpeningLocalService.fetchJobOpening(jobOpeningId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _jobOpeningLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _jobOpeningLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the job opening with the primary key.
	*
	* @param jobOpeningId the primary key of the job opening
	* @return the job opening
	* @throws PortalException if a job opening with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.JobOpening getJobOpening(
		long jobOpeningId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _jobOpeningLocalService.getJobOpening(jobOpeningId);
	}

	/**
	* Returns a range of all the job openings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.JobOpeningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job openings
	* @param end the upper bound of the range of job openings (not inclusive)
	* @return the range of job openings
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.JobOpening> getJobOpenings(
		int start, int end) {
		return _jobOpeningLocalService.getJobOpenings(start, end);
	}

	/**
	* Returns the number of job openings.
	*
	* @return the number of job openings
	*/
	@Override
	public int getJobOpeningsCount() {
		return _jobOpeningLocalService.getJobOpeningsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobOpeningLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _jobOpeningLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the job opening in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jobOpening the job opening
	* @return the job opening that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.JobOpening updateJobOpening(
		com.liferay.famocom.erpcloud.model.JobOpening jobOpening) {
		return _jobOpeningLocalService.updateJobOpening(jobOpening);
	}

	@Override
	public JobOpeningLocalService getWrappedService() {
		return _jobOpeningLocalService;
	}

	@Override
	public void setWrappedService(JobOpeningLocalService jobOpeningLocalService) {
		_jobOpeningLocalService = jobOpeningLocalService;
	}

	private JobOpeningLocalService _jobOpeningLocalService;
}