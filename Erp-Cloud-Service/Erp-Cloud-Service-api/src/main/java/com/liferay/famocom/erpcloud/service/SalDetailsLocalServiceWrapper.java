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
 * Provides a wrapper for {@link SalDetailsLocalService}.
 *
 * @author Samaresh
 * @see SalDetailsLocalService
 * @generated
 */
@ProviderType
public class SalDetailsLocalServiceWrapper implements SalDetailsLocalService,
	ServiceWrapper<SalDetailsLocalService> {
	public SalDetailsLocalServiceWrapper(
		SalDetailsLocalService salDetailsLocalService) {
		_salDetailsLocalService = salDetailsLocalService;
	}

	/**
	* Adds the sal details to the database. Also notifies the appropriate model listeners.
	*
	* @param salDetails the sal details
	* @return the sal details that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SalDetails addSalDetails(
		com.liferay.famocom.erpcloud.model.SalDetails salDetails) {
		return _salDetailsLocalService.addSalDetails(salDetails);
	}

	/**
	* Creates a new sal details with the primary key. Does not add the sal details to the database.
	*
	* @param SalDetailsId the primary key for the new sal details
	* @return the new sal details
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SalDetails createSalDetails(
		long SalDetailsId) {
		return _salDetailsLocalService.createSalDetails(SalDetailsId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _salDetailsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the sal details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SalDetailsId the primary key of the sal details
	* @return the sal details that was removed
	* @throws PortalException if a sal details with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SalDetails deleteSalDetails(
		long SalDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _salDetailsLocalService.deleteSalDetails(SalDetailsId);
	}

	/**
	* Deletes the sal details from the database. Also notifies the appropriate model listeners.
	*
	* @param salDetails the sal details
	* @return the sal details that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SalDetails deleteSalDetails(
		com.liferay.famocom.erpcloud.model.SalDetails salDetails) {
		return _salDetailsLocalService.deleteSalDetails(salDetails);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _salDetailsLocalService.dynamicQuery();
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
		return _salDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _salDetailsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _salDetailsLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _salDetailsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _salDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.SalDetails fetchSalDetails(
		long SalDetailsId) {
		return _salDetailsLocalService.fetchSalDetails(SalDetailsId);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByEmployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salDetailsLocalService.findSalDetailsByEmployeeId(employeeId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.SalDetails findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException {
		return _salDetailsLocalService.findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(employeeId,
			componentId, monthYear);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByEmployeeIdAndComponentIdAndmonthYears(
		long employeeId, long payComponentIds, long[] monthYears)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salDetailsLocalService.findSalDetailsByEmployeeIdAndComponentIdAndmonthYears(employeeId,
			payComponentIds, monthYears);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByEmployeeIdAndComponentIdsAndmonthYears(
		long employeeId, long[] payComponentIds, long[] monthYears)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salDetailsLocalService.findSalDetailsByEmployeeIdAndComponentIdsAndmonthYears(employeeId,
			payComponentIds, monthYears);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByEmployeeIdAndMonthYearAndComponentIds(
		long employeeId, long monthYear, long[] payComponentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salDetailsLocalService.findSalDetailsByEmployeeIdAndMonthYearAndComponentIds(employeeId,
			monthYear, payComponentIds);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByEmployeeIdAndMonthYears(
		long employeeId, long[] monthYears)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salDetailsLocalService.findSalDetailsByEmployeeIdAndMonthYears(employeeId,
			monthYears);
	}

	@Override
	public java.util.List<String[]> findSalDetailsByEmployeeIdAndYear(
		long employeeId, int year) {
		return _salDetailsLocalService.findSalDetailsByEmployeeIdAndYear(employeeId,
			year);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByMonthYear(
		long monthYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salDetailsLocalService.findSalDetailsByMonthYear(monthYear);
	}

	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> findSalDetailsByMonthYearAndEmployeeId(
		long monthYear, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salDetailsLocalService.findSalDetailsByMonthYearAndEmployeeId(monthYear,
			employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _salDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _salDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _salDetailsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _salDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the sal details with the primary key.
	*
	* @param SalDetailsId the primary key of the sal details
	* @return the sal details
	* @throws PortalException if a sal details with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SalDetails getSalDetails(
		long SalDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _salDetailsLocalService.getSalDetails(SalDetailsId);
	}

	/**
	* Returns a range of all the sal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sal detailses
	* @param end the upper bound of the range of sal detailses (not inclusive)
	* @return the range of sal detailses
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SalDetails> getSalDetailses(
		int start, int end) {
		return _salDetailsLocalService.getSalDetailses(start, end);
	}

	/**
	* Returns the number of sal detailses.
	*
	* @return the number of sal detailses
	*/
	@Override
	public int getSalDetailsesCount() {
		return _salDetailsLocalService.getSalDetailsesCount();
	}

	/**
	* Updates the sal details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param salDetails the sal details
	* @return the sal details that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SalDetails updateSalDetails(
		com.liferay.famocom.erpcloud.model.SalDetails salDetails) {
		return _salDetailsLocalService.updateSalDetails(salDetails);
	}

	@Override
	public SalDetailsLocalService getWrappedService() {
		return _salDetailsLocalService;
	}

	@Override
	public void setWrappedService(SalDetailsLocalService salDetailsLocalService) {
		_salDetailsLocalService = salDetailsLocalService;
	}

	private SalDetailsLocalService _salDetailsLocalService;
}