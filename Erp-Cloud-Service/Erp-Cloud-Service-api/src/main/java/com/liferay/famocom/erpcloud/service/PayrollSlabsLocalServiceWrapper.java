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
 * Provides a wrapper for {@link PayrollSlabsLocalService}.
 *
 * @author Samaresh
 * @see PayrollSlabsLocalService
 * @generated
 */
@ProviderType
public class PayrollSlabsLocalServiceWrapper implements PayrollSlabsLocalService,
	ServiceWrapper<PayrollSlabsLocalService> {
	public PayrollSlabsLocalServiceWrapper(
		PayrollSlabsLocalService payrollSlabsLocalService) {
		_payrollSlabsLocalService = payrollSlabsLocalService;
	}

	/**
	* Adds the payroll slabs to the database. Also notifies the appropriate model listeners.
	*
	* @param payrollSlabs the payroll slabs
	* @return the payroll slabs that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayrollSlabs addPayrollSlabs(
		com.liferay.famocom.erpcloud.model.PayrollSlabs payrollSlabs) {
		return _payrollSlabsLocalService.addPayrollSlabs(payrollSlabs);
	}

	/**
	* Creates a new payroll slabs with the primary key. Does not add the payroll slabs to the database.
	*
	* @param payrollSlabsId the primary key for the new payroll slabs
	* @return the new payroll slabs
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayrollSlabs createPayrollSlabs(
		long payrollSlabsId) {
		return _payrollSlabsLocalService.createPayrollSlabs(payrollSlabsId);
	}

	/**
	* Deletes the payroll slabs with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param payrollSlabsId the primary key of the payroll slabs
	* @return the payroll slabs that was removed
	* @throws PortalException if a payroll slabs with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayrollSlabs deletePayrollSlabs(
		long payrollSlabsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payrollSlabsLocalService.deletePayrollSlabs(payrollSlabsId);
	}

	/**
	* Deletes the payroll slabs from the database. Also notifies the appropriate model listeners.
	*
	* @param payrollSlabs the payroll slabs
	* @return the payroll slabs that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayrollSlabs deletePayrollSlabs(
		com.liferay.famocom.erpcloud.model.PayrollSlabs payrollSlabs) {
		return _payrollSlabsLocalService.deletePayrollSlabs(payrollSlabs);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payrollSlabsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _payrollSlabsLocalService.dynamicQuery();
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
		return _payrollSlabsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PayrollSlabsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _payrollSlabsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PayrollSlabsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _payrollSlabsLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _payrollSlabsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _payrollSlabsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.PayrollSlabs fetchPayrollSlabs(
		long payrollSlabsId) {
		return _payrollSlabsLocalService.fetchPayrollSlabs(payrollSlabsId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.PayrollSlabs findByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payrollSlabsLocalService.findByAppraisalSettingIdRatingId(appraisalSettingId,
			ratingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _payrollSlabsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _payrollSlabsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _payrollSlabsLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Returns the payroll slabs with the primary key.
	*
	* @param payrollSlabsId the primary key of the payroll slabs
	* @return the payroll slabs
	* @throws PortalException if a payroll slabs with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayrollSlabs getPayrollSlabs(
		long payrollSlabsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payrollSlabsLocalService.getPayrollSlabs(payrollSlabsId);
	}

	/**
	* Returns a range of all the payroll slabses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.PayrollSlabsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payroll slabses
	* @param end the upper bound of the range of payroll slabses (not inclusive)
	* @return the range of payroll slabses
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.PayrollSlabs> getPayrollSlabses(
		int start, int end) {
		return _payrollSlabsLocalService.getPayrollSlabses(start, end);
	}

	/**
	* Returns the number of payroll slabses.
	*
	* @return the number of payroll slabses
	*/
	@Override
	public int getPayrollSlabsesCount() {
		return _payrollSlabsLocalService.getPayrollSlabsesCount();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payrollSlabsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the payroll slabs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param payrollSlabs the payroll slabs
	* @return the payroll slabs that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.PayrollSlabs updatePayrollSlabs(
		com.liferay.famocom.erpcloud.model.PayrollSlabs payrollSlabs) {
		return _payrollSlabsLocalService.updatePayrollSlabs(payrollSlabs);
	}

	@Override
	public PayrollSlabsLocalService getWrappedService() {
		return _payrollSlabsLocalService;
	}

	@Override
	public void setWrappedService(
		PayrollSlabsLocalService payrollSlabsLocalService) {
		_payrollSlabsLocalService = payrollSlabsLocalService;
	}

	private PayrollSlabsLocalService _payrollSlabsLocalService;
}