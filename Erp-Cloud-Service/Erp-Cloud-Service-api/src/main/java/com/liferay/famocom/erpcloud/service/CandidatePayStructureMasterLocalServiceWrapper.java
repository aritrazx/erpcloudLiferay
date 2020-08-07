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
 * Provides a wrapper for {@link CandidatePayStructureMasterLocalService}.
 *
 * @author Samaresh
 * @see CandidatePayStructureMasterLocalService
 * @generated
 */
@ProviderType
public class CandidatePayStructureMasterLocalServiceWrapper
	implements CandidatePayStructureMasterLocalService,
		ServiceWrapper<CandidatePayStructureMasterLocalService> {
	public CandidatePayStructureMasterLocalServiceWrapper(
		CandidatePayStructureMasterLocalService candidatePayStructureMasterLocalService) {
		_candidatePayStructureMasterLocalService = candidatePayStructureMasterLocalService;
	}

	/**
	* Adds the candidate pay structure master to the database. Also notifies the appropriate model listeners.
	*
	* @param candidatePayStructureMaster the candidate pay structure master
	* @return the candidate pay structure master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster addCandidatePayStructureMaster(
		com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster candidatePayStructureMaster) {
		return _candidatePayStructureMasterLocalService.addCandidatePayStructureMaster(candidatePayStructureMaster);
	}

	/**
	* Creates a new candidate pay structure master with the primary key. Does not add the candidate pay structure master to the database.
	*
	* @param candidatePayStructureMasterId the primary key for the new candidate pay structure master
	* @return the new candidate pay structure master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster createCandidatePayStructureMaster(
		long candidatePayStructureMasterId) {
		return _candidatePayStructureMasterLocalService.createCandidatePayStructureMaster(candidatePayStructureMasterId);
	}

	/**
	* Deletes the candidate pay structure master from the database. Also notifies the appropriate model listeners.
	*
	* @param candidatePayStructureMaster the candidate pay structure master
	* @return the candidate pay structure master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster deleteCandidatePayStructureMaster(
		com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster candidatePayStructureMaster) {
		return _candidatePayStructureMasterLocalService.deleteCandidatePayStructureMaster(candidatePayStructureMaster);
	}

	/**
	* Deletes the candidate pay structure master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidatePayStructureMasterId the primary key of the candidate pay structure master
	* @return the candidate pay structure master that was removed
	* @throws PortalException if a candidate pay structure master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster deleteCandidatePayStructureMaster(
		long candidatePayStructureMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidatePayStructureMasterLocalService.deleteCandidatePayStructureMaster(candidatePayStructureMasterId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidatePayStructureMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidatePayStructureMasterLocalService.dynamicQuery();
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
		return _candidatePayStructureMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidatePayStructureMasterLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidatePayStructureMasterLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _candidatePayStructureMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _candidatePayStructureMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster fetchCandidatePayStructureMaster(
		long candidatePayStructureMasterId) {
		return _candidatePayStructureMasterLocalService.fetchCandidatePayStructureMaster(candidatePayStructureMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _candidatePayStructureMasterLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the candidate pay structure master with the primary key.
	*
	* @param candidatePayStructureMasterId the primary key of the candidate pay structure master
	* @return the candidate pay structure master
	* @throws PortalException if a candidate pay structure master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster getCandidatePayStructureMaster(
		long candidatePayStructureMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidatePayStructureMasterLocalService.getCandidatePayStructureMaster(candidatePayStructureMasterId);
	}

	/**
	* Returns a range of all the candidate pay structure masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate pay structure masters
	* @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	* @return the range of candidate pay structure masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster> getCandidatePayStructureMasters(
		int start, int end) {
		return _candidatePayStructureMasterLocalService.getCandidatePayStructureMasters(start,
			end);
	}

	/**
	* Returns the number of candidate pay structure masters.
	*
	* @return the number of candidate pay structure masters
	*/
	@Override
	public int getCandidatePayStructureMastersCount() {
		return _candidatePayStructureMasterLocalService.getCandidatePayStructureMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _candidatePayStructureMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _candidatePayStructureMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidatePayStructureMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the candidate pay structure master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidatePayStructureMaster the candidate pay structure master
	* @return the candidate pay structure master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster updateCandidatePayStructureMaster(
		com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster candidatePayStructureMaster) {
		return _candidatePayStructureMasterLocalService.updateCandidatePayStructureMaster(candidatePayStructureMaster);
	}

	@Override
	public CandidatePayStructureMasterLocalService getWrappedService() {
		return _candidatePayStructureMasterLocalService;
	}

	@Override
	public void setWrappedService(
		CandidatePayStructureMasterLocalService candidatePayStructureMasterLocalService) {
		_candidatePayStructureMasterLocalService = candidatePayStructureMasterLocalService;
	}

	private CandidatePayStructureMasterLocalService _candidatePayStructureMasterLocalService;
}