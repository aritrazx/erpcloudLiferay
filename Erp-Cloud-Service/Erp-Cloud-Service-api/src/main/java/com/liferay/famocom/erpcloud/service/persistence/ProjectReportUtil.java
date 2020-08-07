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

package com.liferay.famocom.erpcloud.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.ProjectReport;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project report service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ProjectReportPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ProjectReportPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ProjectReportPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectReportUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ProjectReport projectReport) {
		getPersistence().clearCache(projectReport);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProjectReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectReport> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectReport update(ProjectReport projectReport) {
		return getPersistence().update(projectReport);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectReport update(ProjectReport projectReport,
		ServiceContext serviceContext) {
		return getPersistence().update(projectReport, serviceContext);
	}

	/**
	* Caches the project report in the entity cache if it is enabled.
	*
	* @param projectReport the project report
	*/
	public static void cacheResult(ProjectReport projectReport) {
		getPersistence().cacheResult(projectReport);
	}

	/**
	* Caches the project reports in the entity cache if it is enabled.
	*
	* @param projectReports the project reports
	*/
	public static void cacheResult(List<ProjectReport> projectReports) {
		getPersistence().cacheResult(projectReports);
	}

	/**
	* Creates a new project report with the primary key. Does not add the project report to the database.
	*
	* @param reportTemplateId the primary key for the new project report
	* @return the new project report
	*/
	public static ProjectReport create(long reportTemplateId) {
		return getPersistence().create(reportTemplateId);
	}

	/**
	* Removes the project report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportTemplateId the primary key of the project report
	* @return the project report that was removed
	* @throws NoSuchProjectReportException if a project report with the primary key could not be found
	*/
	public static ProjectReport remove(long reportTemplateId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectReportException {
		return getPersistence().remove(reportTemplateId);
	}

	public static ProjectReport updateImpl(ProjectReport projectReport) {
		return getPersistence().updateImpl(projectReport);
	}

	/**
	* Returns the project report with the primary key or throws a {@link NoSuchProjectReportException} if it could not be found.
	*
	* @param reportTemplateId the primary key of the project report
	* @return the project report
	* @throws NoSuchProjectReportException if a project report with the primary key could not be found
	*/
	public static ProjectReport findByPrimaryKey(long reportTemplateId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchProjectReportException {
		return getPersistence().findByPrimaryKey(reportTemplateId);
	}

	/**
	* Returns the project report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportTemplateId the primary key of the project report
	* @return the project report, or <code>null</code> if a project report with the primary key could not be found
	*/
	public static ProjectReport fetchByPrimaryKey(long reportTemplateId) {
		return getPersistence().fetchByPrimaryKey(reportTemplateId);
	}

	public static java.util.Map<java.io.Serializable, ProjectReport> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project reports.
	*
	* @return the project reports
	*/
	public static List<ProjectReport> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project reports
	* @param end the upper bound of the range of project reports (not inclusive)
	* @return the range of project reports
	*/
	public static List<ProjectReport> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project reports
	* @param end the upper bound of the range of project reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project reports
	*/
	public static List<ProjectReport> findAll(int start, int end,
		OrderByComparator<ProjectReport> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project reports
	* @param end the upper bound of the range of project reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project reports
	*/
	public static List<ProjectReport> findAll(int start, int end,
		OrderByComparator<ProjectReport> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project reports from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project reports.
	*
	* @return the number of project reports
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectReportPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectReportPersistence, ProjectReportPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ProjectReportPersistence.class);
}