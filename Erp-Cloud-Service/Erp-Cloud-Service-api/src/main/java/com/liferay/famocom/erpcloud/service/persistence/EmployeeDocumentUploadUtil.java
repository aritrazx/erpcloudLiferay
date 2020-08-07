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

import com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the employee document upload service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.EmployeeDocumentUploadPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see EmployeeDocumentUploadPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EmployeeDocumentUploadPersistenceImpl
 * @generated
 */
@ProviderType
public class EmployeeDocumentUploadUtil {
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
	public static void clearCache(EmployeeDocumentUpload employeeDocumentUpload) {
		getPersistence().clearCache(employeeDocumentUpload);
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
	public static List<EmployeeDocumentUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDocumentUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDocumentUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDocumentUpload> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDocumentUpload update(
		EmployeeDocumentUpload employeeDocumentUpload) {
		return getPersistence().update(employeeDocumentUpload);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDocumentUpload update(
		EmployeeDocumentUpload employeeDocumentUpload,
		ServiceContext serviceContext) {
		return getPersistence().update(employeeDocumentUpload, serviceContext);
	}

	/**
	* Caches the employee document upload in the entity cache if it is enabled.
	*
	* @param employeeDocumentUpload the employee document upload
	*/
	public static void cacheResult(
		EmployeeDocumentUpload employeeDocumentUpload) {
		getPersistence().cacheResult(employeeDocumentUpload);
	}

	/**
	* Caches the employee document uploads in the entity cache if it is enabled.
	*
	* @param employeeDocumentUploads the employee document uploads
	*/
	public static void cacheResult(
		List<EmployeeDocumentUpload> employeeDocumentUploads) {
		getPersistence().cacheResult(employeeDocumentUploads);
	}

	/**
	* Creates a new employee document upload with the primary key. Does not add the employee document upload to the database.
	*
	* @param empDocumentId the primary key for the new employee document upload
	* @return the new employee document upload
	*/
	public static EmployeeDocumentUpload create(long empDocumentId) {
		return getPersistence().create(empDocumentId);
	}

	/**
	* Removes the employee document upload with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empDocumentId the primary key of the employee document upload
	* @return the employee document upload that was removed
	* @throws NoSuchEmployeeDocumentUploadException if a employee document upload with the primary key could not be found
	*/
	public static EmployeeDocumentUpload remove(long empDocumentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeDocumentUploadException {
		return getPersistence().remove(empDocumentId);
	}

	public static EmployeeDocumentUpload updateImpl(
		EmployeeDocumentUpload employeeDocumentUpload) {
		return getPersistence().updateImpl(employeeDocumentUpload);
	}

	/**
	* Returns the employee document upload with the primary key or throws a {@link NoSuchEmployeeDocumentUploadException} if it could not be found.
	*
	* @param empDocumentId the primary key of the employee document upload
	* @return the employee document upload
	* @throws NoSuchEmployeeDocumentUploadException if a employee document upload with the primary key could not be found
	*/
	public static EmployeeDocumentUpload findByPrimaryKey(long empDocumentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmployeeDocumentUploadException {
		return getPersistence().findByPrimaryKey(empDocumentId);
	}

	/**
	* Returns the employee document upload with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empDocumentId the primary key of the employee document upload
	* @return the employee document upload, or <code>null</code> if a employee document upload with the primary key could not be found
	*/
	public static EmployeeDocumentUpload fetchByPrimaryKey(long empDocumentId) {
		return getPersistence().fetchByPrimaryKey(empDocumentId);
	}

	public static java.util.Map<java.io.Serializable, EmployeeDocumentUpload> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the employee document uploads.
	*
	* @return the employee document uploads
	*/
	public static List<EmployeeDocumentUpload> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the employee document uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee document uploads
	* @param end the upper bound of the range of employee document uploads (not inclusive)
	* @return the range of employee document uploads
	*/
	public static List<EmployeeDocumentUpload> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the employee document uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee document uploads
	* @param end the upper bound of the range of employee document uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employee document uploads
	*/
	public static List<EmployeeDocumentUpload> findAll(int start, int end,
		OrderByComparator<EmployeeDocumentUpload> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employee document uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee document uploads
	* @param end the upper bound of the range of employee document uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of employee document uploads
	*/
	public static List<EmployeeDocumentUpload> findAll(int start, int end,
		OrderByComparator<EmployeeDocumentUpload> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the employee document uploads from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of employee document uploads.
	*
	* @return the number of employee document uploads
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDocumentUploadPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployeeDocumentUploadPersistence, EmployeeDocumentUploadPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeDocumentUploadPersistence.class);

		ServiceTracker<EmployeeDocumentUploadPersistence, EmployeeDocumentUploadPersistence> serviceTracker =
			new ServiceTracker<EmployeeDocumentUploadPersistence, EmployeeDocumentUploadPersistence>(bundle.getBundleContext(),
				EmployeeDocumentUploadPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}