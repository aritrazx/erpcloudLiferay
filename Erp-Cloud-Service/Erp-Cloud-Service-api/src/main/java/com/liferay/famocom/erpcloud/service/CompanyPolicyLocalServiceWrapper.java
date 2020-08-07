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
 * Provides a wrapper for {@link CompanyPolicyLocalService}.
 *
 * @author Samaresh
 * @see CompanyPolicyLocalService
 * @generated
 */
@ProviderType
public class CompanyPolicyLocalServiceWrapper
	implements CompanyPolicyLocalService,
		ServiceWrapper<CompanyPolicyLocalService> {
	public CompanyPolicyLocalServiceWrapper(
		CompanyPolicyLocalService companyPolicyLocalService) {
		_companyPolicyLocalService = companyPolicyLocalService;
	}

	/**
	* Adds the company policy to the database. Also notifies the appropriate model listeners.
	*
	* @param companyPolicy the company policy
	* @return the company policy that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CompanyPolicy addCompanyPolicy(
		com.liferay.famocom.erpcloud.model.CompanyPolicy companyPolicy) {
		return _companyPolicyLocalService.addCompanyPolicy(companyPolicy);
	}

	/**
	* Creates a new company policy with the primary key. Does not add the company policy to the database.
	*
	* @param companyPolicyId the primary key for the new company policy
	* @return the new company policy
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CompanyPolicy createCompanyPolicy(
		long companyPolicyId) {
		return _companyPolicyLocalService.createCompanyPolicy(companyPolicyId);
	}

	/**
	* Deletes the company policy from the database. Also notifies the appropriate model listeners.
	*
	* @param companyPolicy the company policy
	* @return the company policy that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CompanyPolicy deleteCompanyPolicy(
		com.liferay.famocom.erpcloud.model.CompanyPolicy companyPolicy) {
		return _companyPolicyLocalService.deleteCompanyPolicy(companyPolicy);
	}

	/**
	* Deletes the company policy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyPolicyId the primary key of the company policy
	* @return the company policy that was removed
	* @throws PortalException if a company policy with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CompanyPolicy deleteCompanyPolicy(
		long companyPolicyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _companyPolicyLocalService.deleteCompanyPolicy(companyPolicyId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _companyPolicyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _companyPolicyLocalService.dynamicQuery();
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
		return _companyPolicyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.CompanyPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _companyPolicyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.CompanyPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _companyPolicyLocalService.dynamicQuery(dynamicQuery, start,
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
		return _companyPolicyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _companyPolicyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.CompanyPolicy fetchCompanyPolicy(
		long companyPolicyId) {
		return _companyPolicyLocalService.fetchCompanyPolicy(companyPolicyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _companyPolicyLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns a range of all the company policies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.CompanyPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of company policies
	* @param end the upper bound of the range of company policies (not inclusive)
	* @return the range of company policies
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.CompanyPolicy> getCompanyPolicies(
		int start, int end) {
		return _companyPolicyLocalService.getCompanyPolicies(start, end);
	}

	/**
	* Returns the number of company policies.
	*
	* @return the number of company policies
	*/
	@Override
	public int getCompanyPoliciesCount() {
		return _companyPolicyLocalService.getCompanyPoliciesCount();
	}

	/**
	* Returns the company policy with the primary key.
	*
	* @param companyPolicyId the primary key of the company policy
	* @return the company policy
	* @throws PortalException if a company policy with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CompanyPolicy getCompanyPolicy(
		long companyPolicyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _companyPolicyLocalService.getCompanyPolicy(companyPolicyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _companyPolicyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _companyPolicyLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _companyPolicyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the company policy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param companyPolicy the company policy
	* @return the company policy that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CompanyPolicy updateCompanyPolicy(
		com.liferay.famocom.erpcloud.model.CompanyPolicy companyPolicy) {
		return _companyPolicyLocalService.updateCompanyPolicy(companyPolicy);
	}

	@Override
	public CompanyPolicyLocalService getWrappedService() {
		return _companyPolicyLocalService;
	}

	@Override
	public void setWrappedService(
		CompanyPolicyLocalService companyPolicyLocalService) {
		_companyPolicyLocalService = companyPolicyLocalService;
	}

	private CompanyPolicyLocalService _companyPolicyLocalService;
}