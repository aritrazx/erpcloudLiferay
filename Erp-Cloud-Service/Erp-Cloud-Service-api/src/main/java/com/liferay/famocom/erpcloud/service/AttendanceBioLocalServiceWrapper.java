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
 * Provides a wrapper for {@link AttendanceBioLocalService}.
 *
 * @author Samaresh
 * @see AttendanceBioLocalService
 * @generated
 */
@ProviderType
public class AttendanceBioLocalServiceWrapper
	implements AttendanceBioLocalService,
		ServiceWrapper<AttendanceBioLocalService> {
	public AttendanceBioLocalServiceWrapper(
		AttendanceBioLocalService attendanceBioLocalService) {
		_attendanceBioLocalService = attendanceBioLocalService;
	}

	/**
	* Adds the attendance bio to the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceBio the attendance bio
	* @return the attendance bio that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AttendanceBio addAttendanceBio(
		com.liferay.famocom.erpcloud.model.AttendanceBio attendanceBio) {
		return _attendanceBioLocalService.addAttendanceBio(attendanceBio);
	}

	/**
	* Creates a new attendance bio with the primary key. Does not add the attendance bio to the database.
	*
	* @param attendanceBioId the primary key for the new attendance bio
	* @return the new attendance bio
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AttendanceBio createAttendanceBio(
		long attendanceBioId) {
		return _attendanceBioLocalService.createAttendanceBio(attendanceBioId);
	}

	/**
	* Deletes the attendance bio from the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceBio the attendance bio
	* @return the attendance bio that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AttendanceBio deleteAttendanceBio(
		com.liferay.famocom.erpcloud.model.AttendanceBio attendanceBio) {
		return _attendanceBioLocalService.deleteAttendanceBio(attendanceBio);
	}

	/**
	* Deletes the attendance bio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendanceBioId the primary key of the attendance bio
	* @return the attendance bio that was removed
	* @throws PortalException if a attendance bio with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AttendanceBio deleteAttendanceBio(
		long attendanceBioId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _attendanceBioLocalService.deleteAttendanceBio(attendanceBioId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _attendanceBioLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _attendanceBioLocalService.dynamicQuery();
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
		return _attendanceBioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _attendanceBioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _attendanceBioLocalService.dynamicQuery(dynamicQuery, start,
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
		return _attendanceBioLocalService.dynamicQueryCount(dynamicQuery);
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
		return _attendanceBioLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AttendanceBio fetchAttendanceBio(
		long attendanceBioId) {
		return _attendanceBioLocalService.fetchAttendanceBio(attendanceBioId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.AttendanceBio> findbyempIdAndAttDateComId(
		long employeeId, long companyId, java.util.Date attDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attendanceBioLocalService.findbyempIdAndAttDateComId(employeeId,
			companyId, attDate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _attendanceBioLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the attendance bio with the primary key.
	*
	* @param attendanceBioId the primary key of the attendance bio
	* @return the attendance bio
	* @throws PortalException if a attendance bio with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AttendanceBio getAttendanceBio(
		long attendanceBioId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _attendanceBioLocalService.getAttendanceBio(attendanceBioId);
	}

	/**
	* Returns a range of all the attendance bios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AttendanceBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendance bios
	* @param end the upper bound of the range of attendance bios (not inclusive)
	* @return the range of attendance bios
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.AttendanceBio> getAttendanceBios(
		int start, int end) {
		return _attendanceBioLocalService.getAttendanceBios(start, end);
	}

	/**
	* Returns the number of attendance bios.
	*
	* @return the number of attendance bios
	*/
	@Override
	public int getAttendanceBiosCount() {
		return _attendanceBioLocalService.getAttendanceBiosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _attendanceBioLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _attendanceBioLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _attendanceBioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the attendance bio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param attendanceBio the attendance bio
	* @return the attendance bio that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AttendanceBio updateAttendanceBio(
		com.liferay.famocom.erpcloud.model.AttendanceBio attendanceBio) {
		return _attendanceBioLocalService.updateAttendanceBio(attendanceBio);
	}

	@Override
	public AttendanceBioLocalService getWrappedService() {
		return _attendanceBioLocalService;
	}

	@Override
	public void setWrappedService(
		AttendanceBioLocalService attendanceBioLocalService) {
		_attendanceBioLocalService = attendanceBioLocalService;
	}

	private AttendanceBioLocalService _attendanceBioLocalService;
}