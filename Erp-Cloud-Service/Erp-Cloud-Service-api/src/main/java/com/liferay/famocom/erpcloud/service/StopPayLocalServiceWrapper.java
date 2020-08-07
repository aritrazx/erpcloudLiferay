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
 * Provides a wrapper for {@link StopPayLocalService}.
 *
 * @author Samaresh
 * @see StopPayLocalService
 * @generated
 */
@ProviderType
public class StopPayLocalServiceWrapper implements StopPayLocalService,
	ServiceWrapper<StopPayLocalService> {
	public StopPayLocalServiceWrapper(StopPayLocalService stopPayLocalService) {
		_stopPayLocalService = stopPayLocalService;
	}

	/**
	* Adds the stop pay to the database. Also notifies the appropriate model listeners.
	*
	* @param stopPay the stop pay
	* @return the stop pay that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.StopPay addStopPay(
		com.liferay.famocom.erpcloud.model.StopPay stopPay) {
		return _stopPayLocalService.addStopPay(stopPay);
	}

	/**
	* Creates a new stop pay with the primary key. Does not add the stop pay to the database.
	*
	* @param stopPayId the primary key for the new stop pay
	* @return the new stop pay
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.StopPay createStopPay(
		long stopPayId) {
		return _stopPayLocalService.createStopPay(stopPayId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _stopPayLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the stop pay with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stopPayId the primary key of the stop pay
	* @return the stop pay that was removed
	* @throws PortalException if a stop pay with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.StopPay deleteStopPay(
		long stopPayId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _stopPayLocalService.deleteStopPay(stopPayId);
	}

	/**
	* Deletes the stop pay from the database. Also notifies the appropriate model listeners.
	*
	* @param stopPay the stop pay
	* @return the stop pay that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.StopPay deleteStopPay(
		com.liferay.famocom.erpcloud.model.StopPay stopPay) {
		return _stopPayLocalService.deleteStopPay(stopPay);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stopPayLocalService.dynamicQuery();
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
		return _stopPayLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _stopPayLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _stopPayLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _stopPayLocalService.dynamicQueryCount(dynamicQuery);
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
		return _stopPayLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.StopPay fetchStopPay(
		long stopPayId) {
		return _stopPayLocalService.fetchStopPay(stopPayId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.StopPay> findStopPayByEmployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stopPayLocalService.findStopPayByEmployeeId(employeeId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.StopPay findStopPayByEmployeeIdAndMonthYear(
		long employeeId, long monthYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return _stopPayLocalService.findStopPayByEmployeeIdAndMonthYear(employeeId,
			monthYear);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.StopPay> findStopPayByMonthYear(
		long monthYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stopPayLocalService.findStopPayByMonthYear(monthYear);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.StopPay> findStopPayByMonthYearAndStatus(
		long monthYear, long status)
		throws com.liferay.famocom.erpcloud.exception.NoSuchStopPayException {
		return _stopPayLocalService.findStopPayByMonthYearAndStatus(monthYear,
			status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _stopPayLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _stopPayLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _stopPayLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _stopPayLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the stop paies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.StopPayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stop paies
	* @param end the upper bound of the range of stop paies (not inclusive)
	* @return the range of stop paies
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.StopPay> getStopPaies(
		int start, int end) {
		return _stopPayLocalService.getStopPaies(start, end);
	}

	/**
	* Returns the number of stop paies.
	*
	* @return the number of stop paies
	*/
	@Override
	public int getStopPaiesCount() {
		return _stopPayLocalService.getStopPaiesCount();
	}

	/**
	* Returns the stop pay with the primary key.
	*
	* @param stopPayId the primary key of the stop pay
	* @return the stop pay
	* @throws PortalException if a stop pay with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.StopPay getStopPay(long stopPayId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _stopPayLocalService.getStopPay(stopPayId);
	}

	/**
	* Updates the stop pay in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param stopPay the stop pay
	* @return the stop pay that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.StopPay updateStopPay(
		com.liferay.famocom.erpcloud.model.StopPay stopPay) {
		return _stopPayLocalService.updateStopPay(stopPay);
	}

	@Override
	public StopPayLocalService getWrappedService() {
		return _stopPayLocalService;
	}

	@Override
	public void setWrappedService(StopPayLocalService stopPayLocalService) {
		_stopPayLocalService = stopPayLocalService;
	}

	private StopPayLocalService _stopPayLocalService;
}