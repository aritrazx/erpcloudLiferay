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
 * Provides a wrapper for {@link BranchLocalService}.
 *
 * @author Samaresh
 * @see BranchLocalService
 * @generated
 */
@ProviderType
public class BranchLocalServiceWrapper implements BranchLocalService,
	ServiceWrapper<BranchLocalService> {
	public BranchLocalServiceWrapper(BranchLocalService branchLocalService) {
		_branchLocalService = branchLocalService;
	}

	/**
	* Adds the branch to the database. Also notifies the appropriate model listeners.
	*
	* @param branch the branch
	* @return the branch that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Branch addBranch(
		com.liferay.famocom.erpcloud.model.Branch branch) {
		return _branchLocalService.addBranch(branch);
	}

	/**
	* Creates a new branch with the primary key. Does not add the branch to the database.
	*
	* @param branchId the primary key for the new branch
	* @return the new branch
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Branch createBranch(long branchId) {
		return _branchLocalService.createBranch(branchId);
	}

	/**
	* Deletes the branch from the database. Also notifies the appropriate model listeners.
	*
	* @param branch the branch
	* @return the branch that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Branch deleteBranch(
		com.liferay.famocom.erpcloud.model.Branch branch) {
		return _branchLocalService.deleteBranch(branch);
	}

	/**
	* Deletes the branch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param branchId the primary key of the branch
	* @return the branch that was removed
	* @throws PortalException if a branch with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Branch deleteBranch(long branchId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _branchLocalService.deleteBranch(branchId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _branchLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _branchLocalService.dynamicQuery();
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
		return _branchLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BranchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _branchLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BranchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _branchLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _branchLocalService.dynamicQueryCount(dynamicQuery);
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
		return _branchLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.Branch fetchBranch(long branchId) {
		return _branchLocalService.fetchBranch(branchId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _branchLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the branch with the primary key.
	*
	* @param branchId the primary key of the branch
	* @return the branch
	* @throws PortalException if a branch with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Branch getBranch(long branchId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _branchLocalService.getBranch(branchId);
	}

	/**
	* Returns a range of all the branchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BranchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of branchs
	* @param end the upper bound of the range of branchs (not inclusive)
	* @return the range of branchs
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.Branch> getBranchs(
		int start, int end) {
		return _branchLocalService.getBranchs(start, end);
	}

	/**
	* Returns the number of branchs.
	*
	* @return the number of branchs
	*/
	@Override
	public int getBranchsCount() {
		return _branchLocalService.getBranchsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _branchLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _branchLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _branchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the branch in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param branch the branch
	* @return the branch that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Branch updateBranch(
		com.liferay.famocom.erpcloud.model.Branch branch) {
		return _branchLocalService.updateBranch(branch);
	}

	@Override
	public BranchLocalService getWrappedService() {
		return _branchLocalService;
	}

	@Override
	public void setWrappedService(BranchLocalService branchLocalService) {
		_branchLocalService = branchLocalService;
	}

	private BranchLocalService _branchLocalService;
}