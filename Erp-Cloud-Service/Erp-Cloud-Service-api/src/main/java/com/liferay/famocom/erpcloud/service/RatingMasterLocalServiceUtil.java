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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for RatingMaster. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.RatingMasterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see RatingMasterLocalService
 * @see com.liferay.famocom.erpcloud.service.base.RatingMasterLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.RatingMasterLocalServiceImpl
 * @generated
 */
@ProviderType
public class RatingMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.RatingMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rating master to the database. Also notifies the appropriate model listeners.
	*
	* @param ratingMaster the rating master
	* @return the rating master that was added
	*/
	public static com.liferay.famocom.erpcloud.model.RatingMaster addRatingMaster(
		com.liferay.famocom.erpcloud.model.RatingMaster ratingMaster) {
		return getService().addRatingMaster(ratingMaster);
	}

	/**
	* Creates a new rating master with the primary key. Does not add the rating master to the database.
	*
	* @param ratingId the primary key for the new rating master
	* @return the new rating master
	*/
	public static com.liferay.famocom.erpcloud.model.RatingMaster createRatingMaster(
		long ratingId) {
		return getService().createRatingMaster(ratingId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the rating master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingId the primary key of the rating master
	* @return the rating master that was removed
	* @throws PortalException if a rating master with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.RatingMaster deleteRatingMaster(
		long ratingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRatingMaster(ratingId);
	}

	/**
	* Deletes the rating master from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingMaster the rating master
	* @return the rating master that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.RatingMaster deleteRatingMaster(
		com.liferay.famocom.erpcloud.model.RatingMaster ratingMaster) {
		return getService().deleteRatingMaster(ratingMaster);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.famocom.erpcloud.model.RatingMaster fetchRatingMaster(
		long ratingId) {
		return getService().fetchRatingMaster(ratingId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rating master with the primary key.
	*
	* @param ratingId the primary key of the rating master
	* @return the rating master
	* @throws PortalException if a rating master with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.RatingMaster getRatingMaster(
		long ratingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRatingMaster(ratingId);
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
	public static java.util.List<com.liferay.famocom.erpcloud.model.RatingMaster> getRatingMasters(
		int start, int end) {
		return getService().getRatingMasters(start, end);
	}

	/**
	* Returns the number of rating masters.
	*
	* @return the number of rating masters
	*/
	public static int getRatingMastersCount() {
		return getService().getRatingMastersCount();
	}

	/**
	* Updates the rating master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ratingMaster the rating master
	* @return the rating master that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.RatingMaster updateRatingMaster(
		com.liferay.famocom.erpcloud.model.RatingMaster ratingMaster) {
		return getService().updateRatingMaster(ratingMaster);
	}

	public static RatingMasterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RatingMasterLocalService, RatingMasterLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RatingMasterLocalService.class);

		ServiceTracker<RatingMasterLocalService, RatingMasterLocalService> serviceTracker =
			new ServiceTracker<RatingMasterLocalService, RatingMasterLocalService>(bundle.getBundleContext(),
				RatingMasterLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}