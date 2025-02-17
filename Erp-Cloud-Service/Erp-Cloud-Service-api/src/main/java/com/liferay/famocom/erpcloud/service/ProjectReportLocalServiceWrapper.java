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
 * Provides a wrapper for {@link ProjectReportLocalService}.
 *
 * @author Samaresh
 * @see ProjectReportLocalService
 * @generated
 */
@ProviderType
public class ProjectReportLocalServiceWrapper
	implements ProjectReportLocalService,
		ServiceWrapper<ProjectReportLocalService> {
	public ProjectReportLocalServiceWrapper(
		ProjectReportLocalService projectReportLocalService) {
		_projectReportLocalService = projectReportLocalService;
	}

	/**
	* Adds the project report to the database. Also notifies the appropriate model listeners.
	*
	* @param projectReport the project report
	* @return the project report that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectReport addProjectReport(
		com.liferay.famocom.erpcloud.model.ProjectReport projectReport) {
		return _projectReportLocalService.addProjectReport(projectReport);
	}

	/**
	* Creates a new project report with the primary key. Does not add the project report to the database.
	*
	* @param reportTemplateId the primary key for the new project report
	* @return the new project report
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectReport createProjectReport(
		long reportTemplateId) {
		return _projectReportLocalService.createProjectReport(reportTemplateId);
	}

	/**
	* Deletes the project report from the database. Also notifies the appropriate model listeners.
	*
	* @param projectReport the project report
	* @return the project report that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectReport deleteProjectReport(
		com.liferay.famocom.erpcloud.model.ProjectReport projectReport) {
		return _projectReportLocalService.deleteProjectReport(projectReport);
	}

	/**
	* Deletes the project report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportTemplateId the primary key of the project report
	* @return the project report that was removed
	* @throws PortalException if a project report with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectReport deleteProjectReport(
		long reportTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectReportLocalService.deleteProjectReport(reportTemplateId);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.ProjectReport fetchProjectReport(
		long reportTemplateId) {
		return _projectReportLocalService.fetchProjectReport(reportTemplateId);
	}

	/**
	* Returns the project report with the primary key.
	*
	* @param reportTemplateId the primary key of the project report
	* @return the project report
	* @throws PortalException if a project report with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectReport getProjectReport(
		long reportTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectReportLocalService.getProjectReport(reportTemplateId);
	}

	/**
	* Updates the project report in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectReport the project report
	* @return the project report that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.ProjectReport updateProjectReport(
		com.liferay.famocom.erpcloud.model.ProjectReport projectReport) {
		return _projectReportLocalService.updateProjectReport(projectReport);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _projectReportLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectReportLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _projectReportLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectReportLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectReportLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of project reports.
	*
	* @return the number of project reports
	*/
	@Override
	public int getProjectReportsCount() {
		return _projectReportLocalService.getProjectReportsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _projectReportLocalService.getOSGiServiceIdentifier();
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
		return _projectReportLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectReportLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectReportLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the project reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ProjectReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project reports
	* @param end the upper bound of the range of project reports (not inclusive)
	* @return the range of project reports
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.ProjectReport> getProjectReports(
		int start, int end) {
		return _projectReportLocalService.getProjectReports(start, end);
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
		return _projectReportLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectReportLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ProjectReportLocalService getWrappedService() {
		return _projectReportLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectReportLocalService projectReportLocalService) {
		_projectReportLocalService = projectReportLocalService;
	}

	private ProjectReportLocalService _projectReportLocalService;
}