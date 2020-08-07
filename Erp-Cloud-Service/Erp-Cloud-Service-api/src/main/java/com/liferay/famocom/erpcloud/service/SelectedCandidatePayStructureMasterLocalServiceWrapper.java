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
 * Provides a wrapper for {@link SelectedCandidatePayStructureMasterLocalService}.
 *
 * @author Samaresh
 * @see SelectedCandidatePayStructureMasterLocalService
 * @generated
 */
@ProviderType
public class SelectedCandidatePayStructureMasterLocalServiceWrapper
	implements SelectedCandidatePayStructureMasterLocalService,
		ServiceWrapper<SelectedCandidatePayStructureMasterLocalService> {
	public SelectedCandidatePayStructureMasterLocalServiceWrapper(
		SelectedCandidatePayStructureMasterLocalService selectedCandidatePayStructureMasterLocalService) {
		_selectedCandidatePayStructureMasterLocalService = selectedCandidatePayStructureMasterLocalService;
	}

	/**
	* Adds the selected candidate pay structure master to the database. Also notifies the appropriate model listeners.
	*
	* @param selectedCandidatePayStructureMaster the selected candidate pay structure master
	* @return the selected candidate pay structure master that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster addSelectedCandidatePayStructureMaster(
		com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		return _selectedCandidatePayStructureMasterLocalService.addSelectedCandidatePayStructureMaster(selectedCandidatePayStructureMaster);
	}

	/**
	* Creates a new selected candidate pay structure master with the primary key. Does not add the selected candidate pay structure master to the database.
	*
	* @param candidatePayStructureMasterId the primary key for the new selected candidate pay structure master
	* @return the new selected candidate pay structure master
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster createSelectedCandidatePayStructureMaster(
		long candidatePayStructureMasterId) {
		return _selectedCandidatePayStructureMasterLocalService.createSelectedCandidatePayStructureMaster(candidatePayStructureMasterId);
	}

	/**
	* Deletes the selected candidate pay structure master from the database. Also notifies the appropriate model listeners.
	*
	* @param selectedCandidatePayStructureMaster the selected candidate pay structure master
	* @return the selected candidate pay structure master that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster deleteSelectedCandidatePayStructureMaster(
		com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		return _selectedCandidatePayStructureMasterLocalService.deleteSelectedCandidatePayStructureMaster(selectedCandidatePayStructureMaster);
	}

	/**
	* Deletes the selected candidate pay structure master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidatePayStructureMasterId the primary key of the selected candidate pay structure master
	* @return the selected candidate pay structure master that was removed
	* @throws PortalException if a selected candidate pay structure master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster deleteSelectedCandidatePayStructureMaster(
		long candidatePayStructureMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _selectedCandidatePayStructureMasterLocalService.deleteSelectedCandidatePayStructureMaster(candidatePayStructureMasterId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster fetchSelectedCandidatePayStructureMaster(
		long candidatePayStructureMasterId) {
		return _selectedCandidatePayStructureMasterLocalService.fetchSelectedCandidatePayStructureMaster(candidatePayStructureMasterId);
	}

	/**
	* Returns the selected candidate pay structure master with the primary key.
	*
	* @param candidatePayStructureMasterId the primary key of the selected candidate pay structure master
	* @return the selected candidate pay structure master
	* @throws PortalException if a selected candidate pay structure master with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster getSelectedCandidatePayStructureMaster(
		long candidatePayStructureMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _selectedCandidatePayStructureMasterLocalService.getSelectedCandidatePayStructureMaster(candidatePayStructureMasterId);
	}

	/**
	* Updates the selected candidate pay structure master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param selectedCandidatePayStructureMaster the selected candidate pay structure master
	* @return the selected candidate pay structure master that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster updateSelectedCandidatePayStructureMaster(
		com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		return _selectedCandidatePayStructureMasterLocalService.updateSelectedCandidatePayStructureMaster(selectedCandidatePayStructureMaster);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _selectedCandidatePayStructureMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _selectedCandidatePayStructureMasterLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _selectedCandidatePayStructureMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _selectedCandidatePayStructureMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _selectedCandidatePayStructureMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of selected candidate pay structure masters.
	*
	* @return the number of selected candidate pay structure masters
	*/
	@Override
	public int getSelectedCandidatePayStructureMastersCount() {
		return _selectedCandidatePayStructureMasterLocalService.getSelectedCandidatePayStructureMastersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _selectedCandidatePayStructureMasterLocalService.getOSGiServiceIdentifier();
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
		return _selectedCandidatePayStructureMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _selectedCandidatePayStructureMasterLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _selectedCandidatePayStructureMasterLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* find by recruitmentProcessId and payStatus
	*
	* @param recruitmentProcessId
	* @param payStatus
	* @return
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		return _selectedCandidatePayStructureMasterLocalService.findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus);
	}

	/**
	* Returns a range of all the selected candidate pay structure masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of selected candidate pay structure masters
	* @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	* @return the range of selected candidate pay structure masters
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster> getSelectedCandidatePayStructureMasters(
		int start, int end) {
		return _selectedCandidatePayStructureMasterLocalService.getSelectedCandidatePayStructureMasters(start,
			end);
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
		return _selectedCandidatePayStructureMasterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _selectedCandidatePayStructureMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public SelectedCandidatePayStructureMasterLocalService getWrappedService() {
		return _selectedCandidatePayStructureMasterLocalService;
	}

	@Override
	public void setWrappedService(
		SelectedCandidatePayStructureMasterLocalService selectedCandidatePayStructureMasterLocalService) {
		_selectedCandidatePayStructureMasterLocalService = selectedCandidatePayStructureMasterLocalService;
	}

	private SelectedCandidatePayStructureMasterLocalService _selectedCandidatePayStructureMasterLocalService;
}