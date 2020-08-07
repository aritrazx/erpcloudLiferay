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
 * Provides a wrapper for {@link PerformanceLocalService}.
 *
 * @author Samaresh
 * @see PerformanceLocalService
 * @generated
 */
@ProviderType
public class PerformanceLocalServiceWrapper implements PerformanceLocalService,
	ServiceWrapper<PerformanceLocalService> {
	public PerformanceLocalServiceWrapper(
		PerformanceLocalService performanceLocalService) {
		_performanceLocalService = performanceLocalService;
	}

	/**
	* Adds the performance to the database. Also notifies the appropriate model listeners.
	*
	* @param performance the performance
	* @return the performance that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Performance addPerformance(
		com.liferay.famocom.erpcloud.model.Performance performance) {
		return _performanceLocalService.addPerformance(performance);
	}

	/**
	* Creates a new performance with the primary key. Does not add the performance to the database.
	*
	* @param performanceId the primary key for the new performance
	* @return the new performance
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Performance createPerformance(
		long performanceId) {
		return _performanceLocalService.createPerformance(performanceId);
	}

	/**
	* Deletes the performance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param performanceId the primary key of the performance
	* @return the performance that was removed
	* @throws PortalException if a performance with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Performance deletePerformance(
		long performanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _performanceLocalService.deletePerformance(performanceId);
	}

	/**
	* Deletes the performance from the database. Also notifies the appropriate model listeners.
	*
	* @param performance the performance
	* @return the performance that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Performance deletePerformance(
		com.liferay.famocom.erpcloud.model.Performance performance) {
		return _performanceLocalService.deletePerformance(performance);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _performanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _performanceLocalService.dynamicQuery();
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
		return _performanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _performanceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _performanceLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _performanceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _performanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.Performance fetchPerformance(
		long performanceId) {
		return _performanceLocalService.fetchPerformance(performanceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _performanceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _performanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _performanceLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Returns the performance with the primary key.
	*
	* @param performanceId the primary key of the performance
	* @return the performance
	* @throws PortalException if a performance with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Performance getPerformance(
		long performanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _performanceLocalService.getPerformance(performanceId);
	}

	/**
	* Returns a range of all the performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performances
	* @param end the upper bound of the range of performances (not inclusive)
	* @return the range of performances
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.Performance> getPerformances(
		int start, int end) {
		return _performanceLocalService.getPerformances(start, end);
	}

	/**
	* Returns the number of performances.
	*
	* @return the number of performances
	*/
	@Override
	public int getPerformancesCount() {
		return _performanceLocalService.getPerformancesCount();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _performanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the performance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param performance the performance
	* @return the performance that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Performance updatePerformance(
		com.liferay.famocom.erpcloud.model.Performance performance) {
		return _performanceLocalService.updatePerformance(performance);
	}

	@Override
	public PerformanceLocalService getWrappedService() {
		return _performanceLocalService;
	}

	@Override
	public void setWrappedService(
		PerformanceLocalService performanceLocalService) {
		_performanceLocalService = performanceLocalService;
	}

	private PerformanceLocalService _performanceLocalService;
}