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
 * Provides the local service utility for ProjectMaster. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.ProjectMasterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see ProjectMasterLocalService
 * @see com.liferay.famocom.erpcloud.service.base.ProjectMasterLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.ProjectMasterLocalServiceImpl
 * @generated
 */
@ProviderType
public class ProjectMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.ProjectMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the project master to the database. Also notifies the appropriate model listeners.
	*
	* @param projectMaster the project master
	* @return the project master that was added
	*/
	public static com.liferay.famocom.erpcloud.model.ProjectMaster addProjectMaster(
		com.liferay.famocom.erpcloud.model.ProjectMaster projectMaster) {
		return getService().addProjectMaster(projectMaster);
	}

	/**
	* Creates a new project master with the primary key. Does not add the project master to the database.
	*
	* @param projectId the primary key for the new project master
	* @return the new project master
	*/
	public static com.liferay.famocom.erpcloud.model.ProjectMaster createProjectMaster(
		long projectId) {
		return getService().createProjectMaster(projectId);
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
	* Deletes the project master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the project master
	* @return the project master that was removed
	* @throws PortalException if a project master with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.ProjectMaster deleteProjectMaster(
		long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteProjectMaster(projectId);
	}

	/**
	* Deletes the project master from the database. Also notifies the appropriate model listeners.
	*
	* @param projectMaster the project master
	* @return the project master that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.ProjectMaster deleteProjectMaster(
		com.liferay.famocom.erpcloud.model.ProjectMaster projectMaster) {
		return getService().deleteProjectMaster(projectMaster);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.ProjectMaster fetchProjectMaster(
		long projectId) {
		return getService().fetchProjectMaster(projectId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.ProjectMaster> findByEmployeeId(
		long employeeId) {
		return getService().findByEmployeeId(employeeId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.ProjectMaster> findByprojectId(
		long employeeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException {
		return getService().findByprojectId(employeeId, companyId);
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
	* Returns the project master with the primary key.
	*
	* @param projectId the primary key of the project master
	* @return the project master
	* @throws PortalException if a project master with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.ProjectMaster getProjectMaster(
		long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProjectMaster(projectId);
	}

	/**
	* Returns a range of all the project masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project masters
	* @param end the upper bound of the range of project masters (not inclusive)
	* @return the range of project masters
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.ProjectMaster> getProjectMasters(
		int start, int end) {
		return getService().getProjectMasters(start, end);
	}

	/**
	* Returns the number of project masters.
	*
	* @return the number of project masters
	*/
	public static int getProjectMastersCount() {
		return getService().getProjectMastersCount();
	}

	/**
	* Updates the project master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectMaster the project master
	* @return the project master that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.ProjectMaster updateProjectMaster(
		com.liferay.famocom.erpcloud.model.ProjectMaster projectMaster) {
		return getService().updateProjectMaster(projectMaster);
	}

	public static ProjectMasterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectMasterLocalService, ProjectMasterLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectMasterLocalService.class);

		ServiceTracker<ProjectMasterLocalService, ProjectMasterLocalService> serviceTracker =
			new ServiceTracker<ProjectMasterLocalService, ProjectMasterLocalService>(bundle.getBundleContext(),
				ProjectMasterLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}