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

import com.liferay.famocom.erpcloud.model.TaxProofFiles;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tax proof files service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.TaxProofFilesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaxProofFilesPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TaxProofFilesPersistenceImpl
 * @generated
 */
@ProviderType
public class TaxProofFilesUtil {
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
	public static void clearCache(TaxProofFiles taxProofFiles) {
		getPersistence().clearCache(taxProofFiles);
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
	public static List<TaxProofFiles> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaxProofFiles> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaxProofFiles> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaxProofFiles> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaxProofFiles update(TaxProofFiles taxProofFiles) {
		return getPersistence().update(taxProofFiles);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaxProofFiles update(TaxProofFiles taxProofFiles,
		ServiceContext serviceContext) {
		return getPersistence().update(taxProofFiles, serviceContext);
	}

	/**
	* Caches the tax proof files in the entity cache if it is enabled.
	*
	* @param taxProofFiles the tax proof files
	*/
	public static void cacheResult(TaxProofFiles taxProofFiles) {
		getPersistence().cacheResult(taxProofFiles);
	}

	/**
	* Caches the tax proof fileses in the entity cache if it is enabled.
	*
	* @param taxProofFileses the tax proof fileses
	*/
	public static void cacheResult(List<TaxProofFiles> taxProofFileses) {
		getPersistence().cacheResult(taxProofFileses);
	}

	/**
	* Creates a new tax proof files with the primary key. Does not add the tax proof files to the database.
	*
	* @param fileId the primary key for the new tax proof files
	* @return the new tax proof files
	*/
	public static TaxProofFiles create(long fileId) {
		return getPersistence().create(fileId);
	}

	/**
	* Removes the tax proof files with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileId the primary key of the tax proof files
	* @return the tax proof files that was removed
	* @throws NoSuchTaxProofFilesException if a tax proof files with the primary key could not be found
	*/
	public static TaxProofFiles remove(long fileId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxProofFilesException {
		return getPersistence().remove(fileId);
	}

	public static TaxProofFiles updateImpl(TaxProofFiles taxProofFiles) {
		return getPersistence().updateImpl(taxProofFiles);
	}

	/**
	* Returns the tax proof files with the primary key or throws a {@link NoSuchTaxProofFilesException} if it could not be found.
	*
	* @param fileId the primary key of the tax proof files
	* @return the tax proof files
	* @throws NoSuchTaxProofFilesException if a tax proof files with the primary key could not be found
	*/
	public static TaxProofFiles findByPrimaryKey(long fileId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTaxProofFilesException {
		return getPersistence().findByPrimaryKey(fileId);
	}

	/**
	* Returns the tax proof files with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fileId the primary key of the tax proof files
	* @return the tax proof files, or <code>null</code> if a tax proof files with the primary key could not be found
	*/
	public static TaxProofFiles fetchByPrimaryKey(long fileId) {
		return getPersistence().fetchByPrimaryKey(fileId);
	}

	public static java.util.Map<java.io.Serializable, TaxProofFiles> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tax proof fileses.
	*
	* @return the tax proof fileses
	*/
	public static List<TaxProofFiles> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tax proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax proof fileses
	* @param end the upper bound of the range of tax proof fileses (not inclusive)
	* @return the range of tax proof fileses
	*/
	public static List<TaxProofFiles> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tax proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax proof fileses
	* @param end the upper bound of the range of tax proof fileses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tax proof fileses
	*/
	public static List<TaxProofFiles> findAll(int start, int end,
		OrderByComparator<TaxProofFiles> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tax proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax proof fileses
	* @param end the upper bound of the range of tax proof fileses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tax proof fileses
	*/
	public static List<TaxProofFiles> findAll(int start, int end,
		OrderByComparator<TaxProofFiles> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tax proof fileses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tax proof fileses.
	*
	* @return the number of tax proof fileses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaxProofFilesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaxProofFilesPersistence, TaxProofFilesPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaxProofFilesPersistence.class);

		ServiceTracker<TaxProofFilesPersistence, TaxProofFilesPersistence> serviceTracker =
			new ServiceTracker<TaxProofFilesPersistence, TaxProofFilesPersistence>(bundle.getBundleContext(),
				TaxProofFilesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}