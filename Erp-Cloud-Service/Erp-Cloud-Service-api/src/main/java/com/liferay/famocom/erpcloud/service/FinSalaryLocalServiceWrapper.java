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
 * Provides a wrapper for {@link FinSalaryLocalService}.
 *
 * @author Samaresh
 * @see FinSalaryLocalService
 * @generated
 */
@ProviderType
public class FinSalaryLocalServiceWrapper implements FinSalaryLocalService,
	ServiceWrapper<FinSalaryLocalService> {
	public FinSalaryLocalServiceWrapper(
		FinSalaryLocalService finSalaryLocalService) {
		_finSalaryLocalService = finSalaryLocalService;
	}

	/**
	* Adds the fin salary to the database. Also notifies the appropriate model listeners.
	*
	* @param finSalary the fin salary
	* @return the fin salary that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FinSalary addFinSalary(
		com.liferay.famocom.erpcloud.model.FinSalary finSalary) {
		return _finSalaryLocalService.addFinSalary(finSalary);
	}

	/**
	* Creates a new fin salary with the primary key. Does not add the fin salary to the database.
	*
	* @param finSalaryId the primary key for the new fin salary
	* @return the new fin salary
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FinSalary createFinSalary(
		long finSalaryId) {
		return _finSalaryLocalService.createFinSalary(finSalaryId);
	}

	/**
	* Deletes the fin salary from the database. Also notifies the appropriate model listeners.
	*
	* @param finSalary the fin salary
	* @return the fin salary that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FinSalary deleteFinSalary(
		com.liferay.famocom.erpcloud.model.FinSalary finSalary) {
		return _finSalaryLocalService.deleteFinSalary(finSalary);
	}

	/**
	* Deletes the fin salary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param finSalaryId the primary key of the fin salary
	* @return the fin salary that was removed
	* @throws PortalException if a fin salary with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FinSalary deleteFinSalary(
		long finSalaryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _finSalaryLocalService.deleteFinSalary(finSalaryId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _finSalaryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _finSalaryLocalService.dynamicQuery();
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
		return _finSalaryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _finSalaryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _finSalaryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _finSalaryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _finSalaryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.FinSalary fetchFinSalary(
		long finSalaryId) {
		return _finSalaryLocalService.fetchFinSalary(finSalaryId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.FinSalary findFinSalaryByMonthYear(
		int monthYear)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFinSalaryException {
		return _finSalaryLocalService.findFinSalaryByMonthYear(monthYear);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _finSalaryLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns a range of all the fin salaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fin salaries
	* @param end the upper bound of the range of fin salaries (not inclusive)
	* @return the range of fin salaries
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.FinSalary> getFinSalaries(
		int start, int end) {
		return _finSalaryLocalService.getFinSalaries(start, end);
	}

	/**
	* Returns the number of fin salaries.
	*
	* @return the number of fin salaries
	*/
	@Override
	public int getFinSalariesCount() {
		return _finSalaryLocalService.getFinSalariesCount();
	}

	/**
	* Returns the fin salary with the primary key.
	*
	* @param finSalaryId the primary key of the fin salary
	* @return the fin salary
	* @throws PortalException if a fin salary with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FinSalary getFinSalary(
		long finSalaryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _finSalaryLocalService.getFinSalary(finSalaryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _finSalaryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _finSalaryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _finSalaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the fin salary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param finSalary the fin salary
	* @return the fin salary that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.FinSalary updateFinSalary(
		com.liferay.famocom.erpcloud.model.FinSalary finSalary) {
		return _finSalaryLocalService.updateFinSalary(finSalary);
	}

	@Override
	public FinSalaryLocalService getWrappedService() {
		return _finSalaryLocalService;
	}

	@Override
	public void setWrappedService(FinSalaryLocalService finSalaryLocalService) {
		_finSalaryLocalService = finSalaryLocalService;
	}

	private FinSalaryLocalService _finSalaryLocalService;
}