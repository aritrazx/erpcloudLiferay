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
 * Provides a wrapper for {@link RatingMasterLocalService}.
 *
 * @author Samaresh
 * @see RatingMasterLocalService
 * @generated
 */
@ProviderType
public class RatingMasterLocalServiceWrapper implements RatingMasterLocalService,
	ServiceWrapper<RatingMasterLocalService> {
	public RatingMasterLocalServiceWrapper(
		RatingMasterLocalService ratingMasterLocalService) {
		_ratingMasterLocalService = ratingMasterLocalService;
	}

	/**
	* Adds the rating master to the database. Also notifies the appropriate model listeners.
	*
	* @param ratingMaster the rating master
	* @return the rating master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RatingMaster addRatingMaster(
		com.liferay.famocom.erpcloud.model.RatingMaster ratingMaster) {
		return _ratingMasterLocalService.addRatingMaster(ratingMaster);
	}

	/**
	* Creates a new rating master with the primary key. Does not add the rating master to the database.
	*
	* @param ratingId the primary key for the new rating master
	* @return the new rating master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RatingMaster createRatingMaster(
		long ratingId) {
		return _ratingMasterLocalService.createRatingMaster(ratingId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ratingMasterLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the rating master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingId the primary key of the rating master
	* @return the rating master that was removed
	* @throws PortalException if a rating master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RatingMaster deleteRatingMaster(
		long ratingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ratingMasterLocalService.deleteRatingMaster(ratingId);
	}

	/**
	* Deletes the rating master from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingMaster the rating master
	* @return the rating master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RatingMaster deleteRatingMaster(
		com.liferay.famocom.erpcloud.model.RatingMaster ratingMaster) {
		return _ratingMasterLocalService.deleteRatingMaster(ratingMaster);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ratingMasterLocalService.dynamicQuery();
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
		return _ratingMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.RatingMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ratingMasterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.RatingMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ratingMasterLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _ratingMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ratingMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.RatingMaster fetchRatingMaster(
		long ratingId) {
		return _ratingMasterLocalService.fetchRatingMaster(ratingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ratingMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ratingMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _ratingMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ratingMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rating master with the primary key.
	*
	* @param ratingId the primary key of the rating master
	* @return the rating master
	* @throws PortalException if a rating master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RatingMaster getRatingMaster(
		long ratingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ratingMasterLocalService.getRatingMaster(ratingId);
	}

	/**
	* Returns a range of all the rating masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.RatingMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rating masters
	* @param end the upper bound of the range of rating masters (not inclusive)
	* @return the range of rating masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.RatingMaster> getRatingMasters(
		int start, int end) {
		return _ratingMasterLocalService.getRatingMasters(start, end);
	}

	/**
	* Returns the number of rating masters.
	*
	* @return the number of rating masters
	*/
	@Override
	public int getRatingMastersCount() {
		return _ratingMasterLocalService.getRatingMastersCount();
	}

	/**
	* Updates the rating master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ratingMaster the rating master
	* @return the rating master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.RatingMaster updateRatingMaster(
		com.liferay.famocom.erpcloud.model.RatingMaster ratingMaster) {
		return _ratingMasterLocalService.updateRatingMaster(ratingMaster);
	}

	@Override
	public RatingMasterLocalService getWrappedService() {
		return _ratingMasterLocalService;
	}

	@Override
	public void setWrappedService(
		RatingMasterLocalService ratingMasterLocalService) {
		_ratingMasterLocalService = ratingMasterLocalService;
	}

	private RatingMasterLocalService _ratingMasterLocalService;
}