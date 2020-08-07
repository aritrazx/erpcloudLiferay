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
 * Provides a wrapper for {@link AppraisalSetupLocalService}.
 *
 * @author Samaresh
 * @see AppraisalSetupLocalService
 * @generated
 */
@ProviderType
public class AppraisalSetupLocalServiceWrapper
	implements AppraisalSetupLocalService,
		ServiceWrapper<AppraisalSetupLocalService> {
	public AppraisalSetupLocalServiceWrapper(
		AppraisalSetupLocalService appraisalSetupLocalService) {
		_appraisalSetupLocalService = appraisalSetupLocalService;
	}

	/**
	* Adds the appraisal setup to the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalSetup the appraisal setup
	* @return the appraisal setup that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalSetup addAppraisalSetup(
		com.liferay.famocom.erpcloud.model.AppraisalSetup appraisalSetup) {
		return _appraisalSetupLocalService.addAppraisalSetup(appraisalSetup);
	}

	/**
	* Creates a new appraisal setup with the primary key. Does not add the appraisal setup to the database.
	*
	* @param appraisalSettingId the primary key for the new appraisal setup
	* @return the new appraisal setup
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalSetup createAppraisalSetup(
		long appraisalSettingId) {
		return _appraisalSetupLocalService.createAppraisalSetup(appraisalSettingId);
	}

	/**
	* Deletes the appraisal setup from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalSetup the appraisal setup
	* @return the appraisal setup that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalSetup deleteAppraisalSetup(
		com.liferay.famocom.erpcloud.model.AppraisalSetup appraisalSetup) {
		return _appraisalSetupLocalService.deleteAppraisalSetup(appraisalSetup);
	}

	/**
	* Deletes the appraisal setup with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalSettingId the primary key of the appraisal setup
	* @return the appraisal setup that was removed
	* @throws PortalException if a appraisal setup with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalSetup deleteAppraisalSetup(
		long appraisalSettingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalSetupLocalService.deleteAppraisalSetup(appraisalSettingId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalSetupLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalSetupLocalService.dynamicQuery();
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
		return _appraisalSetupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _appraisalSetupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _appraisalSetupLocalService.dynamicQuery(dynamicQuery, start,
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
		return _appraisalSetupLocalService.dynamicQueryCount(dynamicQuery);
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
		return _appraisalSetupLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalSetup fetchAppraisalSetup(
		long appraisalSettingId) {
		return _appraisalSetupLocalService.fetchAppraisalSetup(appraisalSettingId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalSetup findByFinancialYear(
		String financialYear, long isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appraisalSetupLocalService.findByFinancialYear(financialYear,
			isActive);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalSetup findByIsActive(
		long isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appraisalSetupLocalService.findByIsActive(isActive);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _appraisalSetupLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the appraisal setup with the primary key.
	*
	* @param appraisalSettingId the primary key of the appraisal setup
	* @return the appraisal setup
	* @throws PortalException if a appraisal setup with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalSetup getAppraisalSetup(
		long appraisalSettingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalSetupLocalService.getAppraisalSetup(appraisalSettingId);
	}

	/**
	* Returns a range of all the appraisal setups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal setups
	* @param end the upper bound of the range of appraisal setups (not inclusive)
	* @return the range of appraisal setups
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.AppraisalSetup> getAppraisalSetups(
		int start, int end) {
		return _appraisalSetupLocalService.getAppraisalSetups(start, end);
	}

	/**
	* Returns the number of appraisal setups.
	*
	* @return the number of appraisal setups
	*/
	@Override
	public int getAppraisalSetupsCount() {
		return _appraisalSetupLocalService.getAppraisalSetupsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _appraisalSetupLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalSetupLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _appraisalSetupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the appraisal setup in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appraisalSetup the appraisal setup
	* @return the appraisal setup that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.AppraisalSetup updateAppraisalSetup(
		com.liferay.famocom.erpcloud.model.AppraisalSetup appraisalSetup) {
		return _appraisalSetupLocalService.updateAppraisalSetup(appraisalSetup);
	}

	@Override
	public AppraisalSetupLocalService getWrappedService() {
		return _appraisalSetupLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalSetupLocalService appraisalSetupLocalService) {
		_appraisalSetupLocalService = appraisalSetupLocalService;
	}

	private AppraisalSetupLocalService _appraisalSetupLocalService;
}