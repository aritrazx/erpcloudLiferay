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
 * Provides a wrapper for {@link PerformanceMasterLocalService}.
 *
 * @author Samaresh
 * @see PerformanceMasterLocalService
 * @generated
 */
@ProviderType
public class PerformanceMasterLocalServiceWrapper
	implements PerformanceMasterLocalService,
		ServiceWrapper<PerformanceMasterLocalService> {
	public PerformanceMasterLocalServiceWrapper(
		PerformanceMasterLocalService performanceMasterLocalService) {
		_performanceMasterLocalService = performanceMasterLocalService;
	}

	/**
	* Adds the performance master to the database. Also notifies the appropriate model listeners.
	*
	* @param performanceMaster the performance master
	* @return the performance master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PerformanceMaster addPerformanceMaster(
		com.liferay.famocom.erpcloud.model.PerformanceMaster performanceMaster) {
		return _performanceMasterLocalService.addPerformanceMaster(performanceMaster);
	}

	/**
	* Creates a new performance master with the primary key. Does not add the performance master to the database.
	*
	* @param performanceId the primary key for the new performance master
	* @return the new performance master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PerformanceMaster createPerformanceMaster(
		long performanceId) {
		return _performanceMasterLocalService.createPerformanceMaster(performanceId);
	}

	/**
	* Deletes the performance master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param performanceId the primary key of the performance master
	* @return the performance master that was removed
	* @throws PortalException if a performance master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PerformanceMaster deletePerformanceMaster(
		long performanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _performanceMasterLocalService.deletePerformanceMaster(performanceId);
	}

	/**
	* Deletes the performance master from the database. Also notifies the appropriate model listeners.
	*
	* @param performanceMaster the performance master
	* @return the performance master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PerformanceMaster deletePerformanceMaster(
		com.liferay.famocom.erpcloud.model.PerformanceMaster performanceMaster) {
		return _performanceMasterLocalService.deletePerformanceMaster(performanceMaster);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _performanceMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _performanceMasterLocalService.dynamicQuery();
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
		return _performanceMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _performanceMasterLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _performanceMasterLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _performanceMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _performanceMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.PerformanceMaster fetchPerformanceMaster(
		long performanceId) {
		return _performanceMasterLocalService.fetchPerformanceMaster(performanceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _performanceMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _performanceMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _performanceMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Returns the performance master with the primary key.
	*
	* @param performanceId the primary key of the performance master
	* @return the performance master
	* @throws PortalException if a performance master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PerformanceMaster getPerformanceMaster(
		long performanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _performanceMasterLocalService.getPerformanceMaster(performanceId);
	}

	/**
	* Returns a range of all the performance masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of performance masters
	* @param end the upper bound of the range of performance masters (not inclusive)
	* @return the range of performance masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.PerformanceMaster> getPerformanceMasters(
		int start, int end) {
		return _performanceMasterLocalService.getPerformanceMasters(start, end);
	}

	/**
	* Returns the number of performance masters.
	*
	* @return the number of performance masters
	*/
	@Override
	public int getPerformanceMastersCount() {
		return _performanceMasterLocalService.getPerformanceMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _performanceMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the performance master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param performanceMaster the performance master
	* @return the performance master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PerformanceMaster updatePerformanceMaster(
		com.liferay.famocom.erpcloud.model.PerformanceMaster performanceMaster) {
		return _performanceMasterLocalService.updatePerformanceMaster(performanceMaster);
	}

	@Override
	public PerformanceMasterLocalService getWrappedService() {
		return _performanceMasterLocalService;
	}

	@Override
	public void setWrappedService(
		PerformanceMasterLocalService performanceMasterLocalService) {
		_performanceMasterLocalService = performanceMasterLocalService;
	}

	private PerformanceMasterLocalService _performanceMasterLocalService;
}