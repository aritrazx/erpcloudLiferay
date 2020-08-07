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

import com.liferay.famocom.erpcloud.model.ExpProofFiles;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the exp proof files service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.ExpProofFilesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ExpProofFilesPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ExpProofFilesPersistenceImpl
 * @generated
 */
@ProviderType
public class ExpProofFilesUtil {
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
	public static void clearCache(ExpProofFiles expProofFiles) {
		getPersistence().clearCache(expProofFiles);
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
	public static List<ExpProofFiles> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExpProofFiles> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExpProofFiles> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExpProofFiles> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExpProofFiles update(ExpProofFiles expProofFiles) {
		return getPersistence().update(expProofFiles);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExpProofFiles update(ExpProofFiles expProofFiles,
		ServiceContext serviceContext) {
		return getPersistence().update(expProofFiles, serviceContext);
	}

	/**
	* Returns the exp proof files where expenseId = &#63; or throws a {@link NoSuchExpProofFilesException} if it could not be found.
	*
	* @param expenseId the expense ID
	* @return the matching exp proof files
	* @throws NoSuchExpProofFilesException if a matching exp proof files could not be found
	*/
	public static ExpProofFiles findByExpenceId(long expenseId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpProofFilesException {
		return getPersistence().findByExpenceId(expenseId);
	}

	/**
	* Returns the exp proof files where expenseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param expenseId the expense ID
	* @return the matching exp proof files, or <code>null</code> if a matching exp proof files could not be found
	*/
	public static ExpProofFiles fetchByExpenceId(long expenseId) {
		return getPersistence().fetchByExpenceId(expenseId);
	}

	/**
	* Returns the exp proof files where expenseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param expenseId the expense ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching exp proof files, or <code>null</code> if a matching exp proof files could not be found
	*/
	public static ExpProofFiles fetchByExpenceId(long expenseId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByExpenceId(expenseId, retrieveFromCache);
	}

	/**
	* Removes the exp proof files where expenseId = &#63; from the database.
	*
	* @param expenseId the expense ID
	* @return the exp proof files that was removed
	*/
	public static ExpProofFiles removeByExpenceId(long expenseId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpProofFilesException {
		return getPersistence().removeByExpenceId(expenseId);
	}

	/**
	* Returns the number of exp proof fileses where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @return the number of matching exp proof fileses
	*/
	public static int countByExpenceId(long expenseId) {
		return getPersistence().countByExpenceId(expenseId);
	}

	/**
	* Caches the exp proof files in the entity cache if it is enabled.
	*
	* @param expProofFiles the exp proof files
	*/
	public static void cacheResult(ExpProofFiles expProofFiles) {
		getPersistence().cacheResult(expProofFiles);
	}

	/**
	* Caches the exp proof fileses in the entity cache if it is enabled.
	*
	* @param expProofFileses the exp proof fileses
	*/
	public static void cacheResult(List<ExpProofFiles> expProofFileses) {
		getPersistence().cacheResult(expProofFileses);
	}

	/**
	* Creates a new exp proof files with the primary key. Does not add the exp proof files to the database.
	*
	* @param fileId the primary key for the new exp proof files
	* @return the new exp proof files
	*/
	public static ExpProofFiles create(long fileId) {
		return getPersistence().create(fileId);
	}

	/**
	* Removes the exp proof files with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileId the primary key of the exp proof files
	* @return the exp proof files that was removed
	* @throws NoSuchExpProofFilesException if a exp proof files with the primary key could not be found
	*/
	public static ExpProofFiles remove(long fileId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpProofFilesException {
		return getPersistence().remove(fileId);
	}

	public static ExpProofFiles updateImpl(ExpProofFiles expProofFiles) {
		return getPersistence().updateImpl(expProofFiles);
	}

	/**
	* Returns the exp proof files with the primary key or throws a {@link NoSuchExpProofFilesException} if it could not be found.
	*
	* @param fileId the primary key of the exp proof files
	* @return the exp proof files
	* @throws NoSuchExpProofFilesException if a exp proof files with the primary key could not be found
	*/
	public static ExpProofFiles findByPrimaryKey(long fileId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchExpProofFilesException {
		return getPersistence().findByPrimaryKey(fileId);
	}

	/**
	* Returns the exp proof files with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fileId the primary key of the exp proof files
	* @return the exp proof files, or <code>null</code> if a exp proof files with the primary key could not be found
	*/
	public static ExpProofFiles fetchByPrimaryKey(long fileId) {
		return getPersistence().fetchByPrimaryKey(fileId);
	}

	public static java.util.Map<java.io.Serializable, ExpProofFiles> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the exp proof fileses.
	*
	* @return the exp proof fileses
	*/
	public static List<ExpProofFiles> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the exp proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp proof fileses
	* @param end the upper bound of the range of exp proof fileses (not inclusive)
	* @return the range of exp proof fileses
	*/
	public static List<ExpProofFiles> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the exp proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp proof fileses
	* @param end the upper bound of the range of exp proof fileses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of exp proof fileses
	*/
	public static List<ExpProofFiles> findAll(int start, int end,
		OrderByComparator<ExpProofFiles> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the exp proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp proof fileses
	* @param end the upper bound of the range of exp proof fileses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of exp proof fileses
	*/
	public static List<ExpProofFiles> findAll(int start, int end,
		OrderByComparator<ExpProofFiles> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the exp proof fileses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of exp proof fileses.
	*
	* @return the number of exp proof fileses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExpProofFilesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExpProofFilesPersistence, ExpProofFilesPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExpProofFilesPersistence.class);

		ServiceTracker<ExpProofFilesPersistence, ExpProofFilesPersistence> serviceTracker =
			new ServiceTracker<ExpProofFilesPersistence, ExpProofFilesPersistence>(bundle.getBundleContext(),
				ExpProofFilesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}