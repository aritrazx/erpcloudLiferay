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
 * Provides a wrapper for {@link GoalMasterLocalService}.
 *
 * @author Samaresh
 * @see GoalMasterLocalService
 * @generated
 */
@ProviderType
public class GoalMasterLocalServiceWrapper implements GoalMasterLocalService,
	ServiceWrapper<GoalMasterLocalService> {
	public GoalMasterLocalServiceWrapper(
		GoalMasterLocalService goalMasterLocalService) {
		_goalMasterLocalService = goalMasterLocalService;
	}

	/**
	* Adds the goal master to the database. Also notifies the appropriate model listeners.
	*
	* @param goalMaster the goal master
	* @return the goal master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GoalMaster addGoalMaster(
		com.liferay.famocom.erpcloud.model.GoalMaster goalMaster) {
		return _goalMasterLocalService.addGoalMaster(goalMaster);
	}

	/**
	* Creates a new goal master with the primary key. Does not add the goal master to the database.
	*
	* @param goalId the primary key for the new goal master
	* @return the new goal master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GoalMaster createGoalMaster(
		long goalId) {
		return _goalMasterLocalService.createGoalMaster(goalId);
	}

	/**
	* Deletes the goal master from the database. Also notifies the appropriate model listeners.
	*
	* @param goalMaster the goal master
	* @return the goal master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GoalMaster deleteGoalMaster(
		com.liferay.famocom.erpcloud.model.GoalMaster goalMaster) {
		return _goalMasterLocalService.deleteGoalMaster(goalMaster);
	}

	/**
	* Deletes the goal master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param goalId the primary key of the goal master
	* @return the goal master that was removed
	* @throws PortalException if a goal master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GoalMaster deleteGoalMaster(
		long goalId) throws com.liferay.portal.kernel.exception.PortalException {
		return _goalMasterLocalService.deleteGoalMaster(goalId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _goalMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _goalMasterLocalService.dynamicQuery();
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
		return _goalMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _goalMasterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _goalMasterLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _goalMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _goalMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.GoalMaster fetchGoalMaster(
		long goalId) {
		return _goalMasterLocalService.fetchGoalMaster(goalId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _goalMasterLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the goal master with the primary key.
	*
	* @param goalId the primary key of the goal master
	* @return the goal master
	* @throws PortalException if a goal master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GoalMaster getGoalMaster(
		long goalId) throws com.liferay.portal.kernel.exception.PortalException {
		return _goalMasterLocalService.getGoalMaster(goalId);
	}

	/**
	* Returns a range of all the goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goal masters
	* @param end the upper bound of the range of goal masters (not inclusive)
	* @return the range of goal masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.GoalMaster> getGoalMasters(
		int start, int end) {
		return _goalMasterLocalService.getGoalMasters(start, end);
	}

	/**
	* Returns the number of goal masters.
	*
	* @return the number of goal masters
	*/
	@Override
	public int getGoalMastersCount() {
		return _goalMasterLocalService.getGoalMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _goalMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _goalMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _goalMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the goal master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param goalMaster the goal master
	* @return the goal master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GoalMaster updateGoalMaster(
		com.liferay.famocom.erpcloud.model.GoalMaster goalMaster) {
		return _goalMasterLocalService.updateGoalMaster(goalMaster);
	}

	@Override
	public GoalMasterLocalService getWrappedService() {
		return _goalMasterLocalService;
	}

	@Override
	public void setWrappedService(GoalMasterLocalService goalMasterLocalService) {
		_goalMasterLocalService = goalMasterLocalService;
	}

	private GoalMasterLocalService _goalMasterLocalService;
}