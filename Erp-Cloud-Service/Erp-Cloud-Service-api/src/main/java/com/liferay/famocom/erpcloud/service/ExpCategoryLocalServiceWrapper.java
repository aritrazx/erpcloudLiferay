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
 * Provides a wrapper for {@link ExpCategoryLocalService}.
 *
 * @author Samaresh
 * @see ExpCategoryLocalService
 * @generated
 */
@ProviderType
public class ExpCategoryLocalServiceWrapper implements ExpCategoryLocalService,
	ServiceWrapper<ExpCategoryLocalService> {
	public ExpCategoryLocalServiceWrapper(
		ExpCategoryLocalService expCategoryLocalService) {
		_expCategoryLocalService = expCategoryLocalService;
	}

	/**
	* Adds the exp category to the database. Also notifies the appropriate model listeners.
	*
	* @param expCategory the exp category
	* @return the exp category that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpCategory addExpCategory(
		com.liferay.famocom.erpcloud.model.ExpCategory expCategory) {
		return _expCategoryLocalService.addExpCategory(expCategory);
	}

	/**
	* Creates a new exp category with the primary key. Does not add the exp category to the database.
	*
	* @param catId the primary key for the new exp category
	* @return the new exp category
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpCategory createExpCategory(
		long catId) {
		return _expCategoryLocalService.createExpCategory(catId);
	}

	/**
	* Deletes the exp category from the database. Also notifies the appropriate model listeners.
	*
	* @param expCategory the exp category
	* @return the exp category that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpCategory deleteExpCategory(
		com.liferay.famocom.erpcloud.model.ExpCategory expCategory) {
		return _expCategoryLocalService.deleteExpCategory(expCategory);
	}

	/**
	* Deletes the exp category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catId the primary key of the exp category
	* @return the exp category that was removed
	* @throws PortalException if a exp category with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpCategory deleteExpCategory(
		long catId) throws com.liferay.portal.kernel.exception.PortalException {
		return _expCategoryLocalService.deleteExpCategory(catId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expCategoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _expCategoryLocalService.dynamicQuery();
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
		return _expCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _expCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _expCategoryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _expCategoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _expCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.ExpCategory fetchExpCategory(
		long catId) {
		return _expCategoryLocalService.fetchExpCategory(catId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _expCategoryLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns a range of all the exp categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp categories
	* @param end the upper bound of the range of exp categories (not inclusive)
	* @return the range of exp categories
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ExpCategory> getExpCategories(
		int start, int end) {
		return _expCategoryLocalService.getExpCategories(start, end);
	}

	/**
	* Returns the number of exp categories.
	*
	* @return the number of exp categories
	*/
	@Override
	public int getExpCategoriesCount() {
		return _expCategoryLocalService.getExpCategoriesCount();
	}

	/**
	* Returns the exp category with the primary key.
	*
	* @param catId the primary key of the exp category
	* @return the exp category
	* @throws PortalException if a exp category with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpCategory getExpCategory(
		long catId) throws com.liferay.portal.kernel.exception.PortalException {
		return _expCategoryLocalService.getExpCategory(catId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _expCategoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _expCategoryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the exp category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param expCategory the exp category
	* @return the exp category that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ExpCategory updateExpCategory(
		com.liferay.famocom.erpcloud.model.ExpCategory expCategory) {
		return _expCategoryLocalService.updateExpCategory(expCategory);
	}

	@Override
	public ExpCategoryLocalService getWrappedService() {
		return _expCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		ExpCategoryLocalService expCategoryLocalService) {
		_expCategoryLocalService = expCategoryLocalService;
	}

	private ExpCategoryLocalService _expCategoryLocalService;
}