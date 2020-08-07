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
 * Provides a wrapper for {@link ExpProofFilesLocalService}.
 *
 * @author Samaresh
 * @see ExpProofFilesLocalService
 * @generated
 */
@ProviderType
public class ExpProofFilesLocalServiceWrapper
	implements ExpProofFilesLocalService,
		ServiceWrapper<ExpProofFilesLocalService> {
	public ExpProofFilesLocalServiceWrapper(
		ExpProofFilesLocalService expProofFilesLocalService) {
		_expProofFilesLocalService = expProofFilesLocalService;
	}

	/**
	* Adds the exp proof files to the database. Also notifies the appropriate model listeners.
	*
	* @param expProofFiles the exp proof files
	* @return the exp proof files that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpProofFiles addExpProofFiles(
		com.liferay.famocom.erpcloud.model.ExpProofFiles expProofFiles) {
		return _expProofFilesLocalService.addExpProofFiles(expProofFiles);
	}

	/**
	* Creates a new exp proof files with the primary key. Does not add the exp proof files to the database.
	*
	* @param fileId the primary key for the new exp proof files
	* @return the new exp proof files
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpProofFiles createExpProofFiles(
		long fileId) {
		return _expProofFilesLocalService.createExpProofFiles(fileId);
	}

	/**
	* Deletes the exp proof files from the database. Also notifies the appropriate model listeners.
	*
	* @param expProofFiles the exp proof files
	* @return the exp proof files that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpProofFiles deleteExpProofFiles(
		com.liferay.famocom.erpcloud.model.ExpProofFiles expProofFiles) {
		return _expProofFilesLocalService.deleteExpProofFiles(expProofFiles);
	}

	/**
	* Deletes the exp proof files with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileId the primary key of the exp proof files
	* @return the exp proof files that was removed
	* @throws PortalException if a exp proof files with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpProofFiles deleteExpProofFiles(
		long fileId) throws com.liferay.portal.kernel.exception.PortalException {
		return _expProofFilesLocalService.deleteExpProofFiles(fileId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expProofFilesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _expProofFilesLocalService.dynamicQuery();
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
		return _expProofFilesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _expProofFilesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _expProofFilesLocalService.dynamicQuery(dynamicQuery, start,
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
		return _expProofFilesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _expProofFilesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.ExpProofFiles fetchExpProofFiles(
		long fileId) {
		return _expProofFilesLocalService.fetchExpProofFiles(fileId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.ExpProofFiles findByExpenceId(
		long expenceId) {
		return _expProofFilesLocalService.findByExpenceId(expenceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _expProofFilesLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the exp proof files with the primary key.
	*
	* @param fileId the primary key of the exp proof files
	* @return the exp proof files
	* @throws PortalException if a exp proof files with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpProofFiles getExpProofFiles(
		long fileId) throws com.liferay.portal.kernel.exception.PortalException {
		return _expProofFilesLocalService.getExpProofFiles(fileId);
	}

	/**
	* Returns a range of all the exp proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp proof fileses
	* @param end the upper bound of the range of exp proof fileses (not inclusive)
	* @return the range of exp proof fileses
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ExpProofFiles> getExpProofFileses(
		int start, int end) {
		return _expProofFilesLocalService.getExpProofFileses(start, end);
	}

	/**
	* Returns the number of exp proof fileses.
	*
	* @return the number of exp proof fileses
	*/
	@Override
	public int getExpProofFilesesCount() {
		return _expProofFilesLocalService.getExpProofFilesesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _expProofFilesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _expProofFilesLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expProofFilesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the exp proof files in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param expProofFiles the exp proof files
	* @return the exp proof files that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpProofFiles updateExpProofFiles(
		com.liferay.famocom.erpcloud.model.ExpProofFiles expProofFiles) {
		return _expProofFilesLocalService.updateExpProofFiles(expProofFiles);
	}

	@Override
	public ExpProofFilesLocalService getWrappedService() {
		return _expProofFilesLocalService;
	}

	@Override
	public void setWrappedService(
		ExpProofFilesLocalService expProofFilesLocalService) {
		_expProofFilesLocalService = expProofFilesLocalService;
	}

	private ExpProofFilesLocalService _expProofFilesLocalService;
}