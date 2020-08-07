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

import com.liferay.famocom.erpcloud.exception.NoSuchProjectReportException;
import com.liferay.famocom.erpcloud.model.ProjectReport;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ProjectReportPersistenceImpl
 * @see ProjectReportUtil
 * @generated
 */
@ProviderType
public interface ProjectReportPersistence extends BasePersistence<ProjectReport> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectReportUtil} to access the project report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the project report in the entity cache if it is enabled.
	*
	* @param projectReport the project report
	*/
	public void cacheResult(ProjectReport projectReport);

	/**
	* Caches the project reports in the entity cache if it is enabled.
	*
	* @param projectReports the project reports
	*/
	public void cacheResult(java.util.List<ProjectReport> projectReports);

	/**
	* Creates a new project report with the primary key. Does not add the project report to the database.
	*
	* @param reportTemplateId the primary key for the new project report
	* @return the new project report
	*/
	public ProjectReport create(long reportTemplateId);

	/**
	* Removes the project report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportTemplateId the primary key of the project report
	* @return the project report that was removed
	* @throws NoSuchProjectReportException if a project report with the primary key could not be found
	*/
	public ProjectReport remove(long reportTemplateId)
		throws NoSuchProjectReportException;

	public ProjectReport updateImpl(ProjectReport projectReport);

	/**
	* Returns the project report with the primary key or throws a {@link NoSuchProjectReportException} if it could not be found.
	*
	* @param reportTemplateId the primary key of the project report
	* @return the project report
	* @throws NoSuchProjectReportException if a project report with the primary key could not be found
	*/
	public ProjectReport findByPrimaryKey(long reportTemplateId)
		throws NoSuchProjectReportException;

	/**
	* Returns the project report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportTemplateId the primary key of the project report
	* @return the project report, or <code>null</code> if a project report with the primary key could not be found
	*/
	public ProjectReport fetchByPrimaryKey(long reportTemplateId);

	@Override
	public java.util.Map<java.io.Serializable, ProjectReport> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project reports.
	*
	* @return the project reports
	*/
	public java.util.List<ProjectReport> findAll();

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
	public java.util.List<ProjectReport> findAll(int start, int end);

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
	public java.util.List<ProjectReport> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectReport> orderByComparator);

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
	public java.util.List<ProjectReport> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectReport> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project reports from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project reports.
	*
	* @return the number of project reports
	*/
	public int countAll();
}