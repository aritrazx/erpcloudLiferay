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
 * Provides a wrapper for {@link EmployeeTypeLocalService}.
 *
 * @author Samaresh
 * @see EmployeeTypeLocalService
 * @generated
 */
@ProviderType
public class EmployeeTypeLocalServiceWrapper implements EmployeeTypeLocalService,
	ServiceWrapper<EmployeeTypeLocalService> {
	public EmployeeTypeLocalServiceWrapper(
		EmployeeTypeLocalService employeeTypeLocalService) {
		_employeeTypeLocalService = employeeTypeLocalService;
	}

	/**
	* Adds the employee type to the database. Also notifies the appropriate model listeners.
	*
	* @param employeeType the employee type
	* @return the employee type that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeType addEmployeeType(
		com.liferay.famocom.erpcloud.model.EmployeeType employeeType) {
		return _employeeTypeLocalService.addEmployeeType(employeeType);
	}

	/**
	* Creates a new employee type with the primary key. Does not add the employee type to the database.
	*
	* @param employeetypeId the primary key for the new employee type
	* @return the new employee type
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeType createEmployeeType(
		long employeetypeId) {
		return _employeeTypeLocalService.createEmployeeType(employeetypeId);
	}

	/**
	* Deletes the employee type from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeType the employee type
	* @return the employee type that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeType deleteEmployeeType(
		com.liferay.famocom.erpcloud.model.EmployeeType employeeType) {
		return _employeeTypeLocalService.deleteEmployeeType(employeeType);
	}

	/**
	* Deletes the employee type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeetypeId the primary key of the employee type
	* @return the employee type that was removed
	* @throws PortalException if a employee type with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeType deleteEmployeeType(
		long employeetypeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeTypeLocalService.deleteEmployeeType(employeetypeId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeTypeLocalService.dynamicQuery();
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
		return _employeeTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmployeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _employeeTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmployeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _employeeTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _employeeTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _employeeTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeType fetchEmployeeType(
		long employeetypeId) {
		return _employeeTypeLocalService.fetchEmployeeType(employeetypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _employeeTypeLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the employee type with the primary key.
	*
	* @param employeetypeId the primary key of the employee type
	* @return the employee type
	* @throws PortalException if a employee type with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeType getEmployeeType(
		long employeetypeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeTypeLocalService.getEmployeeType(employeetypeId);
	}

	/**
	* Returns a range of all the employee types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmployeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee types
	* @param end the upper bound of the range of employee types (not inclusive)
	* @return the range of employee types
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.EmployeeType> getEmployeeTypes(
		int start, int end) {
		return _employeeTypeLocalService.getEmployeeTypes(start, end);
	}

	/**
	* Returns the number of employee types.
	*
	* @return the number of employee types
	*/
	@Override
	public int getEmployeeTypesCount() {
		return _employeeTypeLocalService.getEmployeeTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _employeeTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeTypeLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the employee type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employeeType the employee type
	* @return the employee type that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmployeeType updateEmployeeType(
		com.liferay.famocom.erpcloud.model.EmployeeType employeeType) {
		return _employeeTypeLocalService.updateEmployeeType(employeeType);
	}

	@Override
	public EmployeeTypeLocalService getWrappedService() {
		return _employeeTypeLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeTypeLocalService employeeTypeLocalService) {
		_employeeTypeLocalService = employeeTypeLocalService;
	}

	private EmployeeTypeLocalService _employeeTypeLocalService;
}