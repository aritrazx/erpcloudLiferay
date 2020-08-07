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

import com.liferay.famocom.erpcloud.model.AppraisalSetup;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the appraisal setup service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalSetupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AppraisalSetupPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalSetupPersistenceImpl
 * @generated
 */
@ProviderType
public class AppraisalSetupUtil {
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
	public static void clearCache(AppraisalSetup appraisalSetup) {
		getPersistence().clearCache(appraisalSetup);
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
	public static List<AppraisalSetup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppraisalSetup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppraisalSetup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppraisalSetup> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppraisalSetup update(AppraisalSetup appraisalSetup) {
		return getPersistence().update(appraisalSetup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppraisalSetup update(AppraisalSetup appraisalSetup,
		ServiceContext serviceContext) {
		return getPersistence().update(appraisalSetup, serviceContext);
	}

	/**
	* Returns the appraisal setup where isActive = &#63; or throws a {@link NoSuchAppraisalSetupException} if it could not be found.
	*
	* @param isActive the is active
	* @return the matching appraisal setup
	* @throws NoSuchAppraisalSetupException if a matching appraisal setup could not be found
	*/
	public static AppraisalSetup findByIsActive(long isActive)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalSetupException {
		return getPersistence().findByIsActive(isActive);
	}

	/**
	* Returns the appraisal setup where isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param isActive the is active
	* @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	*/
	public static AppraisalSetup fetchByIsActive(long isActive) {
		return getPersistence().fetchByIsActive(isActive);
	}

	/**
	* Returns the appraisal setup where isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param isActive the is active
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	*/
	public static AppraisalSetup fetchByIsActive(long isActive,
		boolean retrieveFromCache) {
		return getPersistence().fetchByIsActive(isActive, retrieveFromCache);
	}

	/**
	* Removes the appraisal setup where isActive = &#63; from the database.
	*
	* @param isActive the is active
	* @return the appraisal setup that was removed
	*/
	public static AppraisalSetup removeByIsActive(long isActive)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalSetupException {
		return getPersistence().removeByIsActive(isActive);
	}

	/**
	* Returns the number of appraisal setups where isActive = &#63;.
	*
	* @param isActive the is active
	* @return the number of matching appraisal setups
	*/
	public static int countByIsActive(long isActive) {
		return getPersistence().countByIsActive(isActive);
	}

	/**
	* Returns the appraisal setup where financialYear = &#63; and isActive = &#63; or throws a {@link NoSuchAppraisalSetupException} if it could not be found.
	*
	* @param financialYear the financial year
	* @param isActive the is active
	* @return the matching appraisal setup
	* @throws NoSuchAppraisalSetupException if a matching appraisal setup could not be found
	*/
	public static AppraisalSetup findByFinancialYearAndIsActive(
		String financialYear, long isActive)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalSetupException {
		return getPersistence()
				   .findByFinancialYearAndIsActive(financialYear, isActive);
	}

	/**
	* Returns the appraisal setup where financialYear = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param financialYear the financial year
	* @param isActive the is active
	* @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	*/
	public static AppraisalSetup fetchByFinancialYearAndIsActive(
		String financialYear, long isActive) {
		return getPersistence()
				   .fetchByFinancialYearAndIsActive(financialYear, isActive);
	}

	/**
	* Returns the appraisal setup where financialYear = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param financialYear the financial year
	* @param isActive the is active
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	*/
	public static AppraisalSetup fetchByFinancialYearAndIsActive(
		String financialYear, long isActive, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByFinancialYearAndIsActive(financialYear, isActive,
			retrieveFromCache);
	}

	/**
	* Removes the appraisal setup where financialYear = &#63; and isActive = &#63; from the database.
	*
	* @param financialYear the financial year
	* @param isActive the is active
	* @return the appraisal setup that was removed
	*/
	public static AppraisalSetup removeByFinancialYearAndIsActive(
		String financialYear, long isActive)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalSetupException {
		return getPersistence()
				   .removeByFinancialYearAndIsActive(financialYear, isActive);
	}

	/**
	* Returns the number of appraisal setups where financialYear = &#63; and isActive = &#63;.
	*
	* @param financialYear the financial year
	* @param isActive the is active
	* @return the number of matching appraisal setups
	*/
	public static int countByFinancialYearAndIsActive(String financialYear,
		long isActive) {
		return getPersistence()
				   .countByFinancialYearAndIsActive(financialYear, isActive);
	}

	/**
	* Caches the appraisal setup in the entity cache if it is enabled.
	*
	* @param appraisalSetup the appraisal setup
	*/
	public static void cacheResult(AppraisalSetup appraisalSetup) {
		getPersistence().cacheResult(appraisalSetup);
	}

	/**
	* Caches the appraisal setups in the entity cache if it is enabled.
	*
	* @param appraisalSetups the appraisal setups
	*/
	public static void cacheResult(List<AppraisalSetup> appraisalSetups) {
		getPersistence().cacheResult(appraisalSetups);
	}

	/**
	* Creates a new appraisal setup with the primary key. Does not add the appraisal setup to the database.
	*
	* @param appraisalSettingId the primary key for the new appraisal setup
	* @return the new appraisal setup
	*/
	public static AppraisalSetup create(long appraisalSettingId) {
		return getPersistence().create(appraisalSettingId);
	}

	/**
	* Removes the appraisal setup with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalSettingId the primary key of the appraisal setup
	* @return the appraisal setup that was removed
	* @throws NoSuchAppraisalSetupException if a appraisal setup with the primary key could not be found
	*/
	public static AppraisalSetup remove(long appraisalSettingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalSetupException {
		return getPersistence().remove(appraisalSettingId);
	}

	public static AppraisalSetup updateImpl(AppraisalSetup appraisalSetup) {
		return getPersistence().updateImpl(appraisalSetup);
	}

	/**
	* Returns the appraisal setup with the primary key or throws a {@link NoSuchAppraisalSetupException} if it could not be found.
	*
	* @param appraisalSettingId the primary key of the appraisal setup
	* @return the appraisal setup
	* @throws NoSuchAppraisalSetupException if a appraisal setup with the primary key could not be found
	*/
	public static AppraisalSetup findByPrimaryKey(long appraisalSettingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalSetupException {
		return getPersistence().findByPrimaryKey(appraisalSettingId);
	}

	/**
	* Returns the appraisal setup with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appraisalSettingId the primary key of the appraisal setup
	* @return the appraisal setup, or <code>null</code> if a appraisal setup with the primary key could not be found
	*/
	public static AppraisalSetup fetchByPrimaryKey(long appraisalSettingId) {
		return getPersistence().fetchByPrimaryKey(appraisalSettingId);
	}

	public static java.util.Map<java.io.Serializable, AppraisalSetup> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the appraisal setups.
	*
	* @return the appraisal setups
	*/
	public static List<AppraisalSetup> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the appraisal setups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal setups
	* @param end the upper bound of the range of appraisal setups (not inclusive)
	* @return the range of appraisal setups
	*/
	public static List<AppraisalSetup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the appraisal setups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal setups
	* @param end the upper bound of the range of appraisal setups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of appraisal setups
	*/
	public static List<AppraisalSetup> findAll(int start, int end,
		OrderByComparator<AppraisalSetup> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the appraisal setups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal setups
	* @param end the upper bound of the range of appraisal setups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of appraisal setups
	*/
	public static List<AppraisalSetup> findAll(int start, int end,
		OrderByComparator<AppraisalSetup> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the appraisal setups from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of appraisal setups.
	*
	* @return the number of appraisal setups
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppraisalSetupPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AppraisalSetupPersistence, AppraisalSetupPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AppraisalSetupPersistence.class);

		ServiceTracker<AppraisalSetupPersistence, AppraisalSetupPersistence> serviceTracker =
			new ServiceTracker<AppraisalSetupPersistence, AppraisalSetupPersistence>(bundle.getBundleContext(),
				AppraisalSetupPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}