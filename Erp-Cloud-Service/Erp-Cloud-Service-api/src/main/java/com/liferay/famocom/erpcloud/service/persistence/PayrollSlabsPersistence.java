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

import com.liferay.famocom.erpcloud.exception.NoSuchPayrollSlabsException;
import com.liferay.famocom.erpcloud.model.PayrollSlabs;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the payroll slabs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PayrollSlabsPersistenceImpl
 * @see PayrollSlabsUtil
 * @generated
 */
@ProviderType
public interface PayrollSlabsPersistence extends BasePersistence<PayrollSlabs> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayrollSlabsUtil} to access the payroll slabs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; or throws a {@link NoSuchPayrollSlabsException} if it could not be found.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param ratingId the rating ID
	* @return the matching payroll slabs
	* @throws NoSuchPayrollSlabsException if a matching payroll slabs could not be found
	*/
	public PayrollSlabs findByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId)
		throws NoSuchPayrollSlabsException;

	/**
	* Returns the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param ratingId the rating ID
	* @return the matching payroll slabs, or <code>null</code> if a matching payroll slabs could not be found
	*/
	public PayrollSlabs fetchByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId);

	/**
	* Returns the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param ratingId the rating ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching payroll slabs, or <code>null</code> if a matching payroll slabs could not be found
	*/
	public PayrollSlabs fetchByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId, boolean retrieveFromCache);

	/**
	* Removes the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param ratingId the rating ID
	* @return the payroll slabs that was removed
	*/
	public PayrollSlabs removeByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId)
		throws NoSuchPayrollSlabsException;

	/**
	* Returns the number of payroll slabses where appraisalSettingId = &#63; and ratingId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param ratingId the rating ID
	* @return the number of matching payroll slabses
	*/
	public int countByAppraisalSettingIdRatingId(long appraisalSettingId,
		long ratingId);

	/**
	* Caches the payroll slabs in the entity cache if it is enabled.
	*
	* @param payrollSlabs the payroll slabs
	*/
	public void cacheResult(PayrollSlabs payrollSlabs);

	/**
	* Caches the payroll slabses in the entity cache if it is enabled.
	*
	* @param payrollSlabses the payroll slabses
	*/
	public void cacheResult(java.util.List<PayrollSlabs> payrollSlabses);

	/**
	* Creates a new payroll slabs with the primary key. Does not add the payroll slabs to the database.
	*
	* @param payrollSlabsId the primary key for the new payroll slabs
	* @return the new payroll slabs
	*/
	public PayrollSlabs create(long payrollSlabsId);

	/**
	* Removes the payroll slabs with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param payrollSlabsId the primary key of the payroll slabs
	* @return the payroll slabs that was removed
	* @throws NoSuchPayrollSlabsException if a payroll slabs with the primary key could not be found
	*/
	public PayrollSlabs remove(long payrollSlabsId)
		throws NoSuchPayrollSlabsException;

	public PayrollSlabs updateImpl(PayrollSlabs payrollSlabs);

	/**
	* Returns the payroll slabs with the primary key or throws a {@link NoSuchPayrollSlabsException} if it could not be found.
	*
	* @param payrollSlabsId the primary key of the payroll slabs
	* @return the payroll slabs
	* @throws NoSuchPayrollSlabsException if a payroll slabs with the primary key could not be found
	*/
	public PayrollSlabs findByPrimaryKey(long payrollSlabsId)
		throws NoSuchPayrollSlabsException;

	/**
	* Returns the payroll slabs with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param payrollSlabsId the primary key of the payroll slabs
	* @return the payroll slabs, or <code>null</code> if a payroll slabs with the primary key could not be found
	*/
	public PayrollSlabs fetchByPrimaryKey(long payrollSlabsId);

	@Override
	public java.util.Map<java.io.Serializable, PayrollSlabs> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the payroll slabses.
	*
	* @return the payroll slabses
	*/
	public java.util.List<PayrollSlabs> findAll();

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
	public java.util.List<PayrollSlabs> findAll(int start, int end);

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
	public java.util.List<PayrollSlabs> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayrollSlabs> orderByComparator);

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
	public java.util.List<PayrollSlabs> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayrollSlabs> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the payroll slabses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of payroll slabses.
	*
	* @return the number of payroll slabses
	*/
	public int countAll();
}