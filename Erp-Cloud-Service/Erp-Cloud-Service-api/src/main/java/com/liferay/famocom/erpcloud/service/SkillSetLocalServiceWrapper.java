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
 * Provides a wrapper for {@link SkillSetLocalService}.
 *
 * @author Samaresh
 * @see SkillSetLocalService
 * @generated
 */
@ProviderType
public class SkillSetLocalServiceWrapper implements SkillSetLocalService,
	ServiceWrapper<SkillSetLocalService> {
	public SkillSetLocalServiceWrapper(
		SkillSetLocalService skillSetLocalService) {
		_skillSetLocalService = skillSetLocalService;
	}

	/**
	* Adds the skill set to the database. Also notifies the appropriate model listeners.
	*
	* @param skillSet the skill set
	* @return the skill set that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SkillSet addSkillSet(
		com.liferay.famocom.erpcloud.model.SkillSet skillSet) {
		return _skillSetLocalService.addSkillSet(skillSet);
	}

	/**
	* Creates a new skill set with the primary key. Does not add the skill set to the database.
	*
	* @param SkillId the primary key for the new skill set
	* @return the new skill set
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SkillSet createSkillSet(
		long SkillId) {
		return _skillSetLocalService.createSkillSet(SkillId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _skillSetLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the skill set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SkillId the primary key of the skill set
	* @return the skill set that was removed
	* @throws PortalException if a skill set with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SkillSet deleteSkillSet(
		long SkillId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _skillSetLocalService.deleteSkillSet(SkillId);
	}

	/**
	* Deletes the skill set from the database. Also notifies the appropriate model listeners.
	*
	* @param skillSet the skill set
	* @return the skill set that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SkillSet deleteSkillSet(
		com.liferay.famocom.erpcloud.model.SkillSet skillSet) {
		return _skillSetLocalService.deleteSkillSet(skillSet);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _skillSetLocalService.dynamicQuery();
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
		return _skillSetLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _skillSetLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _skillSetLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _skillSetLocalService.dynamicQueryCount(dynamicQuery);
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
		return _skillSetLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.SkillSet fetchSkillSet(
		long SkillId) {
		return _skillSetLocalService.fetchSkillSet(SkillId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _skillSetLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _skillSetLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _skillSetLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _skillSetLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the skill set with the primary key.
	*
	* @param SkillId the primary key of the skill set
	* @return the skill set
	* @throws PortalException if a skill set with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SkillSet getSkillSet(long SkillId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _skillSetLocalService.getSkillSet(SkillId);
	}

	/**
	* Returns a range of all the skill sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skill sets
	* @param end the upper bound of the range of skill sets (not inclusive)
	* @return the range of skill sets
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.SkillSet> getSkillSets(
		int start, int end) {
		return _skillSetLocalService.getSkillSets(start, end);
	}

	/**
	* Returns the number of skill sets.
	*
	* @return the number of skill sets
	*/
	@Override
	public int getSkillSetsCount() {
		return _skillSetLocalService.getSkillSetsCount();
	}

	/**
	* Updates the skill set in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param skillSet the skill set
	* @return the skill set that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.SkillSet updateSkillSet(
		com.liferay.famocom.erpcloud.model.SkillSet skillSet) {
		return _skillSetLocalService.updateSkillSet(skillSet);
	}

	@Override
	public SkillSetLocalService getWrappedService() {
		return _skillSetLocalService;
	}

	@Override
	public void setWrappedService(SkillSetLocalService skillSetLocalService) {
		_skillSetLocalService = skillSetLocalService;
	}

	private SkillSetLocalService _skillSetLocalService;
}