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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SelectedCandidatePayStructure. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.SelectedCandidatePayStructureLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see SelectedCandidatePayStructureLocalService
 * @see com.liferay.famocom.erpcloud.service.base.SelectedCandidatePayStructureLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.SelectedCandidatePayStructureLocalServiceImpl
 * @generated
 */
@ProviderType
public class SelectedCandidatePayStructureLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.SelectedCandidatePayStructureLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the selected candidate pay structure to the database. Also notifies the appropriate model listeners.
	*
	* @param selectedCandidatePayStructure the selected candidate pay structure
	* @return the selected candidate pay structure that was added
	*/
	public static com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure addSelectedCandidatePayStructure(
		com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure selectedCandidatePayStructure) {
		return getService()
				   .addSelectedCandidatePayStructure(selectedCandidatePayStructure);
	}

	/**
	* Creates a new selected candidate pay structure with the primary key. Does not add the selected candidate pay structure to the database.
	*
	* @param candidatePayStructureId the primary key for the new selected candidate pay structure
	* @return the new selected candidate pay structure
	*/
	public static com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure createSelectedCandidatePayStructure(
		long candidatePayStructureId) {
		return getService()
				   .createSelectedCandidatePayStructure(candidatePayStructureId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the selected candidate pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidatePayStructureId the primary key of the selected candidate pay structure
	* @return the selected candidate pay structure that was removed
	* @throws PortalException if a selected candidate pay structure with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure deleteSelectedCandidatePayStructure(
		long candidatePayStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteSelectedCandidatePayStructure(candidatePayStructureId);
	}

	/**
	* Deletes the selected candidate pay structure from the database. Also notifies the appropriate model listeners.
	*
	* @param selectedCandidatePayStructure the selected candidate pay structure
	* @return the selected candidate pay structure that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure deleteSelectedCandidatePayStructure(
		com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure selectedCandidatePayStructure) {
		return getService()
				   .deleteSelectedCandidatePayStructure(selectedCandidatePayStructure);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure fetchSelectedCandidatePayStructure(
		long candidatePayStructureId) {
		return getService()
				   .fetchSelectedCandidatePayStructure(candidatePayStructureId);
	}

	/**
	* find by recruitmentProcessId and payStatus
	*
	* @param recruitmentProcessId
	* @param payStatus
	* @return
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus) {
		return getService()
				   .findByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
			payStatus);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the selected candidate pay structure with the primary key.
	*
	* @param candidatePayStructureId the primary key of the selected candidate pay structure
	* @return the selected candidate pay structure
	* @throws PortalException if a selected candidate pay structure with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure getSelectedCandidatePayStructure(
		long candidatePayStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getSelectedCandidatePayStructure(candidatePayStructureId);
	}

	/**
	* Returns a range of all the selected candidate pay structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @return the range of selected candidate pay structures
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure> getSelectedCandidatePayStructures(
		int start, int end) {
		return getService().getSelectedCandidatePayStructures(start, end);
	}

	/**
	* Returns the number of selected candidate pay structures.
	*
	* @return the number of selected candidate pay structures
	*/
	public static int getSelectedCandidatePayStructuresCount() {
		return getService().getSelectedCandidatePayStructuresCount();
	}

	/**
	* Updates the selected candidate pay structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param selectedCandidatePayStructure the selected candidate pay structure
	* @return the selected candidate pay structure that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure updateSelectedCandidatePayStructure(
		com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure selectedCandidatePayStructure) {
		return getService()
				   .updateSelectedCandidatePayStructure(selectedCandidatePayStructure);
	}

	public static SelectedCandidatePayStructureLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SelectedCandidatePayStructureLocalService, SelectedCandidatePayStructureLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SelectedCandidatePayStructureLocalService.class);

		ServiceTracker<SelectedCandidatePayStructureLocalService, SelectedCandidatePayStructureLocalService> serviceTracker =
			new ServiceTracker<SelectedCandidatePayStructureLocalService, SelectedCandidatePayStructureLocalService>(bundle.getBundleContext(),
				SelectedCandidatePayStructureLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}