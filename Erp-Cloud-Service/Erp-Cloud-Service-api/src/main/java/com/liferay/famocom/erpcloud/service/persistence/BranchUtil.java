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

import com.liferay.famocom.erpcloud.model.Branch;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the branch service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.BranchPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see BranchPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.BranchPersistenceImpl
 * @generated
 */
@ProviderType
public class BranchUtil {
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
	public static void clearCache(Branch branch) {
		getPersistence().clearCache(branch);
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
	public static List<Branch> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Branch> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Branch> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Branch> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Branch update(Branch branch) {
		return getPersistence().update(branch);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Branch update(Branch branch, ServiceContext serviceContext) {
		return getPersistence().update(branch, serviceContext);
	}

	/**
	* Caches the branch in the entity cache if it is enabled.
	*
	* @param branch the branch
	*/
	public static void cacheResult(Branch branch) {
		getPersistence().cacheResult(branch);
	}

	/**
	* Caches the branchs in the entity cache if it is enabled.
	*
	* @param branchs the branchs
	*/
	public static void cacheResult(List<Branch> branchs) {
		getPersistence().cacheResult(branchs);
	}

	/**
	* Creates a new branch with the primary key. Does not add the branch to the database.
	*
	* @param branchId the primary key for the new branch
	* @return the new branch
	*/
	public static Branch create(long branchId) {
		return getPersistence().create(branchId);
	}

	/**
	* Removes the branch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param branchId the primary key of the branch
	* @return the branch that was removed
	* @throws NoSuchBranchException if a branch with the primary key could not be found
	*/
	public static Branch remove(long branchId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchBranchException {
		return getPersistence().remove(branchId);
	}

	public static Branch updateImpl(Branch branch) {
		return getPersistence().updateImpl(branch);
	}

	/**
	* Returns the branch with the primary key or throws a {@link NoSuchBranchException} if it could not be found.
	*
	* @param branchId the primary key of the branch
	* @return the branch
	* @throws NoSuchBranchException if a branch with the primary key could not be found
	*/
	public static Branch findByPrimaryKey(long branchId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchBranchException {
		return getPersistence().findByPrimaryKey(branchId);
	}

	/**
	* Returns the branch with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param branchId the primary key of the branch
	* @return the branch, or <code>null</code> if a branch with the primary key could not be found
	*/
	public static Branch fetchByPrimaryKey(long branchId) {
		return getPersistence().fetchByPrimaryKey(branchId);
	}

	public static java.util.Map<java.io.Serializable, Branch> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the branchs.
	*
	* @return the branchs
	*/
	public static List<Branch> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the branchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BranchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of branchs
	* @param end the upper bound of the range of branchs (not inclusive)
	* @return the range of branchs
	*/
	public static List<Branch> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the branchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BranchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of branchs
	* @param end the upper bound of the range of branchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of branchs
	*/
	public static List<Branch> findAll(int start, int end,
		OrderByComparator<Branch> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the branchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BranchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of branchs
	* @param end the upper bound of the range of branchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of branchs
	*/
	public static List<Branch> findAll(int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the branchs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of branchs.
	*
	* @return the number of branchs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BranchPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BranchPersistence, BranchPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BranchPersistence.class);

		ServiceTracker<BranchPersistence, BranchPersistence> serviceTracker = new ServiceTracker<BranchPersistence, BranchPersistence>(bundle.getBundleContext(),
				BranchPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}