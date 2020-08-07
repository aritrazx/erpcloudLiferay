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
 * Provides a wrapper for {@link CandidateApplyLocalService}.
 *
 * @author Samaresh
 * @see CandidateApplyLocalService
 * @generated
 */
@ProviderType
public class CandidateApplyLocalServiceWrapper
	implements CandidateApplyLocalService,
		ServiceWrapper<CandidateApplyLocalService> {
	public CandidateApplyLocalServiceWrapper(
		CandidateApplyLocalService candidateApplyLocalService) {
		_candidateApplyLocalService = candidateApplyLocalService;
	}

	/**
	* Adds the candidate apply to the database. Also notifies the appropriate model listeners.
	*
	* @param candidateApply the candidate apply
	* @return the candidate apply that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidateApply addCandidateApply(
		com.liferay.famocom.erpcloud.model.CandidateApply candidateApply) {
		return _candidateApplyLocalService.addCandidateApply(candidateApply);
	}

	/**
	* Creates a new candidate apply with the primary key. Does not add the candidate apply to the database.
	*
	* @param applyCandidateId the primary key for the new candidate apply
	* @return the new candidate apply
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidateApply createCandidateApply(
		long applyCandidateId) {
		return _candidateApplyLocalService.createCandidateApply(applyCandidateId);
	}

	/**
	* Deletes the candidate apply from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateApply the candidate apply
	* @return the candidate apply that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidateApply deleteCandidateApply(
		com.liferay.famocom.erpcloud.model.CandidateApply candidateApply) {
		return _candidateApplyLocalService.deleteCandidateApply(candidateApply);
	}

	/**
	* Deletes the candidate apply with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applyCandidateId the primary key of the candidate apply
	* @return the candidate apply that was removed
	* @throws PortalException if a candidate apply with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidateApply deleteCandidateApply(
		long applyCandidateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateApplyLocalService.deleteCandidateApply(applyCandidateId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateApplyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateApplyLocalService.dynamicQuery();
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
		return _candidateApplyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.CandidateApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidateApplyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.CandidateApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidateApplyLocalService.dynamicQuery(dynamicQuery, start,
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
		return _candidateApplyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _candidateApplyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.CandidateApply fetchCandidateApply(
		long applyCandidateId) {
		return _candidateApplyLocalService.fetchCandidateApply(applyCandidateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _candidateApplyLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns a range of all the candidate applies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.CandidateApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate applies
	* @param end the upper bound of the range of candidate applies (not inclusive)
	* @return the range of candidate applies
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.CandidateApply> getCandidateApplies(
		int start, int end) {
		return _candidateApplyLocalService.getCandidateApplies(start, end);
	}

	/**
	* Returns the number of candidate applies.
	*
	* @return the number of candidate applies
	*/
	@Override
	public int getCandidateAppliesCount() {
		return _candidateApplyLocalService.getCandidateAppliesCount();
	}

	/**
	* Returns the candidate apply with the primary key.
	*
	* @param applyCandidateId the primary key of the candidate apply
	* @return the candidate apply
	* @throws PortalException if a candidate apply with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidateApply getCandidateApply(
		long applyCandidateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateApplyLocalService.getCandidateApply(applyCandidateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _candidateApplyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _candidateApplyLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateApplyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the candidate apply in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidateApply the candidate apply
	* @return the candidate apply that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidateApply updateCandidateApply(
		com.liferay.famocom.erpcloud.model.CandidateApply candidateApply) {
		return _candidateApplyLocalService.updateCandidateApply(candidateApply);
	}

	@Override
	public CandidateApplyLocalService getWrappedService() {
		return _candidateApplyLocalService;
	}

	@Override
	public void setWrappedService(
		CandidateApplyLocalService candidateApplyLocalService) {
		_candidateApplyLocalService = candidateApplyLocalService;
	}

	private CandidateApplyLocalService _candidateApplyLocalService;
}