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

import com.liferay.famocom.erpcloud.model.CompanyPolicy;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the company policy service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.CompanyPolicyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see CompanyPolicyPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.CompanyPolicyPersistenceImpl
 * @generated
 */
@ProviderType
public class CompanyPolicyUtil {
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
	public static void clearCache(CompanyPolicy companyPolicy) {
		getPersistence().clearCache(companyPolicy);
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
	public static List<CompanyPolicy> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CompanyPolicy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CompanyPolicy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CompanyPolicy> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CompanyPolicy update(CompanyPolicy companyPolicy) {
		return getPersistence().update(companyPolicy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CompanyPolicy update(CompanyPolicy companyPolicy,
		ServiceContext serviceContext) {
		return getPersistence().update(companyPolicy, serviceContext);
	}

	/**
	* Caches the company policy in the entity cache if it is enabled.
	*
	* @param companyPolicy the company policy
	*/
	public static void cacheResult(CompanyPolicy companyPolicy) {
		getPersistence().cacheResult(companyPolicy);
	}

	/**
	* Caches the company policies in the entity cache if it is enabled.
	*
	* @param companyPolicies the company policies
	*/
	public static void cacheResult(List<CompanyPolicy> companyPolicies) {
		getPersistence().cacheResult(companyPolicies);
	}

	/**
	* Creates a new company policy with the primary key. Does not add the company policy to the database.
	*
	* @param companyPolicyId the primary key for the new company policy
	* @return the new company policy
	*/
	public static CompanyPolicy create(long companyPolicyId) {
		return getPersistence().create(companyPolicyId);
	}

	/**
	* Removes the company policy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyPolicyId the primary key of the company policy
	* @return the company policy that was removed
	* @throws NoSuchCompanyPolicyException if a company policy with the primary key could not be found
	*/
	public static CompanyPolicy remove(long companyPolicyId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCompanyPolicyException {
		return getPersistence().remove(companyPolicyId);
	}

	public static CompanyPolicy updateImpl(CompanyPolicy companyPolicy) {
		return getPersistence().updateImpl(companyPolicy);
	}

	/**
	* Returns the company policy with the primary key or throws a {@link NoSuchCompanyPolicyException} if it could not be found.
	*
	* @param companyPolicyId the primary key of the company policy
	* @return the company policy
	* @throws NoSuchCompanyPolicyException if a company policy with the primary key could not be found
	*/
	public static CompanyPolicy findByPrimaryKey(long companyPolicyId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCompanyPolicyException {
		return getPersistence().findByPrimaryKey(companyPolicyId);
	}

	/**
	* Returns the company policy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param companyPolicyId the primary key of the company policy
	* @return the company policy, or <code>null</code> if a company policy with the primary key could not be found
	*/
	public static CompanyPolicy fetchByPrimaryKey(long companyPolicyId) {
		return getPersistence().fetchByPrimaryKey(companyPolicyId);
	}

	public static java.util.Map<java.io.Serializable, CompanyPolicy> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the company policies.
	*
	* @return the company policies
	*/
	public static List<CompanyPolicy> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the company policies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CompanyPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of company policies
	* @param end the upper bound of the range of company policies (not inclusive)
	* @return the range of company policies
	*/
	public static List<CompanyPolicy> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the company policies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CompanyPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of company policies
	* @param end the upper bound of the range of company policies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of company policies
	*/
	public static List<CompanyPolicy> findAll(int start, int end,
		OrderByComparator<CompanyPolicy> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the company policies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CompanyPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of company policies
	* @param end the upper bound of the range of company policies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of company policies
	*/
	public static List<CompanyPolicy> findAll(int start, int end,
		OrderByComparator<CompanyPolicy> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the company policies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of company policies.
	*
	* @return the number of company policies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CompanyPolicyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CompanyPolicyPersistence, CompanyPolicyPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CompanyPolicyPersistence.class);

		ServiceTracker<CompanyPolicyPersistence, CompanyPolicyPersistence> serviceTracker =
			new ServiceTracker<CompanyPolicyPersistence, CompanyPolicyPersistence>(bundle.getBundleContext(),
				CompanyPolicyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}