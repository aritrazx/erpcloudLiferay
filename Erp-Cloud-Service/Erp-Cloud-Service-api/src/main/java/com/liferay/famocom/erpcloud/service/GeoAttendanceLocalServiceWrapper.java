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
 * Provides a wrapper for {@link GeoAttendanceLocalService}.
 *
 * @author Samaresh
 * @see GeoAttendanceLocalService
 * @generated
 */
@ProviderType
public class GeoAttendanceLocalServiceWrapper
	implements GeoAttendanceLocalService,
		ServiceWrapper<GeoAttendanceLocalService> {
	public GeoAttendanceLocalServiceWrapper(
		GeoAttendanceLocalService geoAttendanceLocalService) {
		_geoAttendanceLocalService = geoAttendanceLocalService;
	}

	/**
	* Adds the geo attendance to the database. Also notifies the appropriate model listeners.
	*
	* @param geoAttendance the geo attendance
	* @return the geo attendance that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GeoAttendance addGeoAttendance(
		com.liferay.famocom.erpcloud.model.GeoAttendance geoAttendance) {
		return _geoAttendanceLocalService.addGeoAttendance(geoAttendance);
	}

	/**
	* Creates a new geo attendance with the primary key. Does not add the geo attendance to the database.
	*
	* @param attendanceId the primary key for the new geo attendance
	* @return the new geo attendance
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GeoAttendance createGeoAttendance(
		long attendanceId) {
		return _geoAttendanceLocalService.createGeoAttendance(attendanceId);
	}

	/**
	* Deletes the geo attendance from the database. Also notifies the appropriate model listeners.
	*
	* @param geoAttendance the geo attendance
	* @return the geo attendance that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GeoAttendance deleteGeoAttendance(
		com.liferay.famocom.erpcloud.model.GeoAttendance geoAttendance) {
		return _geoAttendanceLocalService.deleteGeoAttendance(geoAttendance);
	}

	/**
	* Deletes the geo attendance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceId the primary key of the geo attendance
	* @return the geo attendance that was removed
	* @throws PortalException if a geo attendance with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GeoAttendance deleteGeoAttendance(
		long attendanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _geoAttendanceLocalService.deleteGeoAttendance(attendanceId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _geoAttendanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _geoAttendanceLocalService.dynamicQuery();
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
		return _geoAttendanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _geoAttendanceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _geoAttendanceLocalService.dynamicQuery(dynamicQuery, start,
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
		return _geoAttendanceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _geoAttendanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.GeoAttendance fetchGeoAttendance(
		long attendanceId) {
		return _geoAttendanceLocalService.fetchGeoAttendance(attendanceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _geoAttendanceLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the geo attendance with the primary key.
	*
	* @param attendanceId the primary key of the geo attendance
	* @return the geo attendance
	* @throws PortalException if a geo attendance with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GeoAttendance getGeoAttendance(
		long attendanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _geoAttendanceLocalService.getGeoAttendance(attendanceId);
	}

	/**
	* Returns a range of all the geo attendances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.GeoAttendanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geo attendances
	* @param end the upper bound of the range of geo attendances (not inclusive)
	* @return the range of geo attendances
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.GeoAttendance> getGeoAttendances(
		int start, int end) {
		return _geoAttendanceLocalService.getGeoAttendances(start, end);
	}

	/**
	* Returns the number of geo attendances.
	*
	* @return the number of geo attendances
	*/
	@Override
	public int getGeoAttendancesCount() {
		return _geoAttendanceLocalService.getGeoAttendancesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _geoAttendanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _geoAttendanceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _geoAttendanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the geo attendance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param geoAttendance the geo attendance
	* @return the geo attendance that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.GeoAttendance updateGeoAttendance(
		com.liferay.famocom.erpcloud.model.GeoAttendance geoAttendance) {
		return _geoAttendanceLocalService.updateGeoAttendance(geoAttendance);
	}

	@Override
	public GeoAttendanceLocalService getWrappedService() {
		return _geoAttendanceLocalService;
	}

	@Override
	public void setWrappedService(
		GeoAttendanceLocalService geoAttendanceLocalService) {
		_geoAttendanceLocalService = geoAttendanceLocalService;
	}

	private GeoAttendanceLocalService _geoAttendanceLocalService;
}