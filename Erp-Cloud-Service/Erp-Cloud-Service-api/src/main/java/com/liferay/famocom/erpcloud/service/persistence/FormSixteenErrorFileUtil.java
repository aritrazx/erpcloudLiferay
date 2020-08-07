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

import com.liferay.famocom.erpcloud.model.FormSixteenErrorFile;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the form sixteen error file service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.FormSixteenErrorFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see FormSixteenErrorFilePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.FormSixteenErrorFilePersistenceImpl
 * @generated
 */
@ProviderType
public class FormSixteenErrorFileUtil {
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
	public static void clearCache(FormSixteenErrorFile formSixteenErrorFile) {
		getPersistence().clearCache(formSixteenErrorFile);
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
	public static List<FormSixteenErrorFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FormSixteenErrorFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FormSixteenErrorFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FormSixteenErrorFile> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FormSixteenErrorFile update(
		FormSixteenErrorFile formSixteenErrorFile) {
		return getPersistence().update(formSixteenErrorFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FormSixteenErrorFile update(
		FormSixteenErrorFile formSixteenErrorFile, ServiceContext serviceContext) {
		return getPersistence().update(formSixteenErrorFile, serviceContext);
	}

	/**
	* Caches the form sixteen error file in the entity cache if it is enabled.
	*
	* @param formSixteenErrorFile the form sixteen error file
	*/
	public static void cacheResult(FormSixteenErrorFile formSixteenErrorFile) {
		getPersistence().cacheResult(formSixteenErrorFile);
	}

	/**
	* Caches the form sixteen error files in the entity cache if it is enabled.
	*
	* @param formSixteenErrorFiles the form sixteen error files
	*/
	public static void cacheResult(
		List<FormSixteenErrorFile> formSixteenErrorFiles) {
		getPersistence().cacheResult(formSixteenErrorFiles);
	}

	/**
	* Creates a new form sixteen error file with the primary key. Does not add the form sixteen error file to the database.
	*
	* @param errorId the primary key for the new form sixteen error file
	* @return the new form sixteen error file
	*/
	public static FormSixteenErrorFile create(long errorId) {
		return getPersistence().create(errorId);
	}

	/**
	* Removes the form sixteen error file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param errorId the primary key of the form sixteen error file
	* @return the form sixteen error file that was removed
	* @throws NoSuchFormSixteenErrorFileException if a form sixteen error file with the primary key could not be found
	*/
	public static FormSixteenErrorFile remove(long errorId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFormSixteenErrorFileException {
		return getPersistence().remove(errorId);
	}

	public static FormSixteenErrorFile updateImpl(
		FormSixteenErrorFile formSixteenErrorFile) {
		return getPersistence().updateImpl(formSixteenErrorFile);
	}

	/**
	* Returns the form sixteen error file with the primary key or throws a {@link NoSuchFormSixteenErrorFileException} if it could not be found.
	*
	* @param errorId the primary key of the form sixteen error file
	* @return the form sixteen error file
	* @throws NoSuchFormSixteenErrorFileException if a form sixteen error file with the primary key could not be found
	*/
	public static FormSixteenErrorFile findByPrimaryKey(long errorId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFormSixteenErrorFileException {
		return getPersistence().findByPrimaryKey(errorId);
	}

	/**
	* Returns the form sixteen error file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param errorId the primary key of the form sixteen error file
	* @return the form sixteen error file, or <code>null</code> if a form sixteen error file with the primary key could not be found
	*/
	public static FormSixteenErrorFile fetchByPrimaryKey(long errorId) {
		return getPersistence().fetchByPrimaryKey(errorId);
	}

	public static java.util.Map<java.io.Serializable, FormSixteenErrorFile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the form sixteen error files.
	*
	* @return the form sixteen error files
	*/
	public static List<FormSixteenErrorFile> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the form sixteen error files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenErrorFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form sixteen error files
	* @param end the upper bound of the range of form sixteen error files (not inclusive)
	* @return the range of form sixteen error files
	*/
	public static List<FormSixteenErrorFile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the form sixteen error files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenErrorFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form sixteen error files
	* @param end the upper bound of the range of form sixteen error files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of form sixteen error files
	*/
	public static List<FormSixteenErrorFile> findAll(int start, int end,
		OrderByComparator<FormSixteenErrorFile> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the form sixteen error files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenErrorFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form sixteen error files
	* @param end the upper bound of the range of form sixteen error files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of form sixteen error files
	*/
	public static List<FormSixteenErrorFile> findAll(int start, int end,
		OrderByComparator<FormSixteenErrorFile> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the form sixteen error files from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of form sixteen error files.
	*
	* @return the number of form sixteen error files
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FormSixteenErrorFilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FormSixteenErrorFilePersistence, FormSixteenErrorFilePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FormSixteenErrorFilePersistence.class);

		ServiceTracker<FormSixteenErrorFilePersistence, FormSixteenErrorFilePersistence> serviceTracker =
			new ServiceTracker<FormSixteenErrorFilePersistence, FormSixteenErrorFilePersistence>(bundle.getBundleContext(),
				FormSixteenErrorFilePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}