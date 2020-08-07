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
 * Provides a wrapper for {@link WorksSchedulesLocalService}.
 *
 * @author Samaresh
 * @see WorksSchedulesLocalService
 * @generated
 */
@ProviderType
public class WorksSchedulesLocalServiceWrapper
	implements WorksSchedulesLocalService,
		ServiceWrapper<WorksSchedulesLocalService> {
	public WorksSchedulesLocalServiceWrapper(
		WorksSchedulesLocalService worksSchedulesLocalService) {
		_worksSchedulesLocalService = worksSchedulesLocalService;
	}

	/**
	* Adds the works schedules to the database. Also notifies the appropriate model listeners.
	*
	* @param worksSchedules the works schedules
	* @return the works schedules that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.WorksSchedules addWorksSchedules(
		com.liferay.famocom.erpcloud.model.WorksSchedules worksSchedules) {
		return _worksSchedulesLocalService.addWorksSchedules(worksSchedules);
	}

	/**
	* Creates a new works schedules with the primary key. Does not add the works schedules to the database.
	*
	* @param worksSchedulesId the primary key for the new works schedules
	* @return the new works schedules
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.WorksSchedules createWorksSchedules(
		long worksSchedulesId) {
		return _worksSchedulesLocalService.createWorksSchedules(worksSchedulesId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _worksSchedulesLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the works schedules with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param worksSchedulesId the primary key of the works schedules
	* @return the works schedules that was removed
	* @throws PortalException if a works schedules with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.WorksSchedules deleteWorksSchedules(
		long worksSchedulesId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _worksSchedulesLocalService.deleteWorksSchedules(worksSchedulesId);
	}

	/**
	* Deletes the works schedules from the database. Also notifies the appropriate model listeners.
	*
	* @param worksSchedules the works schedules
	* @return the works schedules that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.WorksSchedules deleteWorksSchedules(
		com.liferay.famocom.erpcloud.model.WorksSchedules worksSchedules) {
		return _worksSchedulesLocalService.deleteWorksSchedules(worksSchedules);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _worksSchedulesLocalService.dynamicQuery();
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
		return _worksSchedulesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _worksSchedulesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _worksSchedulesLocalService.dynamicQuery(dynamicQuery, start,
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
		return _worksSchedulesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _worksSchedulesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.WorksSchedules fetchWorksSchedules(
		long worksSchedulesId) {
		return _worksSchedulesLocalService.fetchWorksSchedules(worksSchedulesId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.WorksSchedules> findbyfromToDate(
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _worksSchedulesLocalService.findbyfromToDate(fromDate, toDate);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.WorksSchedules> findbyschedulesId(
		long schedulesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _worksSchedulesLocalService.findbyschedulesId(schedulesId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.WorksSchedules> findbytoDate(
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _worksSchedulesLocalService.findbytoDate(toDate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _worksSchedulesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _worksSchedulesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _worksSchedulesLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _worksSchedulesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the works schedules with the primary key.
	*
	* @param worksSchedulesId the primary key of the works schedules
	* @return the works schedules
	* @throws PortalException if a works schedules with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.WorksSchedules getWorksSchedules(
		long worksSchedulesId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _worksSchedulesLocalService.getWorksSchedules(worksSchedulesId);
	}

	/**
	* Returns a range of all the works scheduleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of works scheduleses
	* @param end the upper bound of the range of works scheduleses (not inclusive)
	* @return the range of works scheduleses
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.WorksSchedules> getWorksScheduleses(
		int start, int end) {
		return _worksSchedulesLocalService.getWorksScheduleses(start, end);
	}

	/**
	* Returns the number of works scheduleses.
	*
	* @return the number of works scheduleses
	*/
	@Override
	public int getWorksSchedulesesCount() {
		return _worksSchedulesLocalService.getWorksSchedulesesCount();
	}

	/**
	* Updates the works schedules in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param worksSchedules the works schedules
	* @return the works schedules that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.WorksSchedules updateWorksSchedules(
		com.liferay.famocom.erpcloud.model.WorksSchedules worksSchedules) {
		return _worksSchedulesLocalService.updateWorksSchedules(worksSchedules);
	}

	@Override
	public WorksSchedulesLocalService getWrappedService() {
		return _worksSchedulesLocalService;
	}

	@Override
	public void setWrappedService(
		WorksSchedulesLocalService worksSchedulesLocalService) {
		_worksSchedulesLocalService = worksSchedulesLocalService;
	}

	private WorksSchedulesLocalService _worksSchedulesLocalService;
}