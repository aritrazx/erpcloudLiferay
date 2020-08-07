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

import com.liferay.famocom.erpcloud.model.PayrollSlabs;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the payroll slabs service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.PayrollSlabsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PayrollSlabsPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PayrollSlabsPersistenceImpl
 * @generated
 */
@ProviderType
public class PayrollSlabsUtil {
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
	public static void clearCache(PayrollSlabs payrollSlabs) {
		getPersistence().clearCache(payrollSlabs);
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
	public static List<PayrollSlabs> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PayrollSlabs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PayrollSlabs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PayrollSlabs> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PayrollSlabs update(PayrollSlabs payrollSlabs) {
		return getPersistence().update(payrollSlabs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PayrollSlabs update(PayrollSlabs payrollSlabs,
		ServiceContext serviceContext) {
		return getPersistence().update(payrollSlabs, serviceContext);
	}

	/**
	* Returns the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; or throws a {@link NoSuchPayrollSlabsException} if it could not be found.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param ratingId the rating ID
	* @return the matching payroll slabs
	* @throws NoSuchPayrollSlabsException if a matching payroll slabs could not be found
	*/
	public static PayrollSlabs findByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayrollSlabsException {
		return getPersistence()
				   .findByAppraisalSettingIdRatingId(appraisalSettingId,
			ratingId);
	}

	/**
	* Returns the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param ratingId the rating ID
	* @return the matching payroll slabs, or <code>null</code> if a matching payroll slabs could not be found
	*/
	public static PayrollSlabs fetchByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId) {
		return getPersistence()
				   .fetchByAppraisalSettingIdRatingId(appraisalSettingId,
			ratingId);
	}

	/**
	* Returns the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param ratingId the rating ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching payroll slabs, or <code>null</code> if a matching payroll slabs could not be found
	*/
	public static PayrollSlabs fetchByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByAppraisalSettingIdRatingId(appraisalSettingId,
			ratingId, retrieveFromCache);
	}

	/**
	* Removes the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param ratingId the rating ID
	* @return the payroll slabs that was removed
	*/
	public static PayrollSlabs removeByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayrollSlabsException {
		return getPersistence()
				   .removeByAppraisalSettingIdRatingId(appraisalSettingId,
			ratingId);
	}

	/**
	* Returns the number of payroll slabses where appraisalSettingId = &#63; and ratingId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param ratingId the rating ID
	* @return the number of matching payroll slabses
	*/
	public static int countByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId) {
		return getPersistence()
				   .countByAppraisalSettingIdRatingId(appraisalSettingId,
			ratingId);
	}

	/**
	* Caches the payroll slabs in the entity cache if it is enabled.
	*
	* @param payrollSlabs the payroll slabs
	*/
	public static void cacheResult(PayrollSlabs payrollSlabs) {
		getPersistence().cacheResult(payrollSlabs);
	}

	/**
	* Caches the payroll slabses in the entity cache if it is enabled.
	*
	* @param payrollSlabses the payroll slabses
	*/
	public static void cacheResult(List<PayrollSlabs> payrollSlabses) {
		getPersistence().cacheResult(payrollSlabses);
	}

	/**
	* Creates a new payroll slabs with the primary key. Does not add the payroll slabs to the database.
	*
	* @param payrollSlabsId the primary key for the new payroll slabs
	* @return the new payroll slabs
	*/
	public static PayrollSlabs create(long payrollSlabsId) {
		return getPersistence().create(payrollSlabsId);
	}

	/**
	* Removes the payroll slabs with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param payrollSlabsId the primary key of the payroll slabs
	* @return the payroll slabs that was removed
	* @throws NoSuchPayrollSlabsException if a payroll slabs with the primary key could not be found
	*/
	public static PayrollSlabs remove(long payrollSlabsId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayrollSlabsException {
		return getPersistence().remove(payrollSlabsId);
	}

	public static PayrollSlabs updateImpl(PayrollSlabs payrollSlabs) {
		return getPersistence().updateImpl(payrollSlabs);
	}

	/**
	* Returns the payroll slabs with the primary key or throws a {@link NoSuchPayrollSlabsException} if it could not be found.
	*
	* @param payrollSlabsId the primary key of the payroll slabs
	* @return the payroll slabs
	* @throws NoSuchPayrollSlabsException if a payroll slabs with the primary key could not be found
	*/
	public static PayrollSlabs findByPrimaryKey(long payrollSlabsId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayrollSlabsException {
		return getPersistence().findByPrimaryKey(payrollSlabsId);
	}

	/**
	* Returns the payroll slabs with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param payrollSlabsId the primary key of the payroll slabs
	* @return the payroll slabs, or <code>null</code> if a payroll slabs with the primary key could not be found
	*/
	public static PayrollSlabs fetchByPrimaryKey(long payrollSlabsId) {
		return getPersistence().fetchByPrimaryKey(payrollSlabsId);
	}

	public static java.util.Map<java.io.Serializable, PayrollSlabs> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the payroll slabses.
	*
	* @return the payroll slabses
	*/
	public static List<PayrollSlabs> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the payroll slabses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollSlabsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payroll slabses
	* @param end the upper bound of the range of payroll slabses (not inclusive)
	* @return the range of payroll slabses
	*/
	public static List<PayrollSlabs> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the payroll slabses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollSlabsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payroll slabses
	* @param end the upper bound of the range of payroll slabses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of payroll slabses
	*/
	public static List<PayrollSlabs> findAll(int start, int end,
		OrderByComparator<PayrollSlabs> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the payroll slabses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollSlabsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payroll slabses
	* @param end the upper bound of the range of payroll slabses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of payroll slabses
	*/
	public static List<PayrollSlabs> findAll(int start, int end,
		OrderByComparator<PayrollSlabs> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the payroll slabses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of payroll slabses.
	*
	* @return the number of payroll slabses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PayrollSlabsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PayrollSlabsPersistence, PayrollSlabsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PayrollSlabsPersistence.class);

		ServiceTracker<PayrollSlabsPersistence, PayrollSlabsPersistence> serviceTracker =
			new ServiceTracker<PayrollSlabsPersistence, PayrollSlabsPersistence>(bundle.getBundleContext(),
				PayrollSlabsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}