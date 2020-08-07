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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalSetupException;
import com.liferay.famocom.erpcloud.model.AppraisalSetup;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the appraisal setup service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalSetupPersistenceImpl
 * @see AppraisalSetupUtil
 * @generated
 */
@ProviderType
public interface AppraisalSetupPersistence extends BasePersistence<AppraisalSetup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalSetupUtil} to access the appraisal setup persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the appraisal setup where isActive = &#63; or throws a {@link NoSuchAppraisalSetupException} if it could not be found.
	*
	* @param isActive the is active
	* @return the matching appraisal setup
	* @throws NoSuchAppraisalSetupException if a matching appraisal setup could not be found
	*/
	public AppraisalSetup findByIsActive(long isActive)
		throws NoSuchAppraisalSetupException;

	/**
	* Returns the appraisal setup where isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param isActive the is active
	* @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	*/
	public AppraisalSetup fetchByIsActive(long isActive);

	/**
	* Returns the appraisal setup where isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param isActive the is active
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	*/
	public AppraisalSetup fetchByIsActive(long isActive,
		boolean retrieveFromCache);

	/**
	* Removes the appraisal setup where isActive = &#63; from the database.
	*
	* @param isActive the is active
	* @return the appraisal setup that was removed
	*/
	public AppraisalSetup removeByIsActive(long isActive)
		throws NoSuchAppraisalSetupException;

	/**
	* Returns the number of appraisal setups where isActive = &#63;.
	*
	* @param isActive the is active
	* @return the number of matching appraisal setups
	*/
	public int countByIsActive(long isActive);

	/**
	* Returns the appraisal setup where financialYear = &#63; and isActive = &#63; or throws a {@link NoSuchAppraisalSetupException} if it could not be found.
	*
	* @param financialYear the financial year
	* @param isActive the is active
	* @return the matching appraisal setup
	* @throws NoSuchAppraisalSetupException if a matching appraisal setup could not be found
	*/
	public AppraisalSetup findByFinancialYearAndIsActive(String financialYear,
		long isActive) throws NoSuchAppraisalSetupException;

	/**
	* Returns the appraisal setup where financialYear = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param financialYear the financial year
	* @param isActive the is active
	* @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	*/
	public AppraisalSetup fetchByFinancialYearAndIsActive(
		String financialYear, long isActive);

	/**
	* Returns the appraisal setup where financialYear = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param financialYear the financial year
	* @param isActive the is active
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	*/
	public AppraisalSetup fetchByFinancialYearAndIsActive(
		String financialYear, long isActive, boolean retrieveFromCache);

	/**
	* Removes the appraisal setup where financialYear = &#63; and isActive = &#63; from the database.
	*
	* @param financialYear the financial year
	* @param isActive the is active
	* @return the appraisal setup that was removed
	*/
	public AppraisalSetup removeByFinancialYearAndIsActive(
		String financialYear, long isActive)
		throws NoSuchAppraisalSetupException;

	/**
	* Returns the number of appraisal setups where financialYear = &#63; and isActive = &#63;.
	*
	* @param financialYear the financial year
	* @param isActive the is active
	* @return the number of matching appraisal setups
	*/
	public int countByFinancialYearAndIsActive(String financialYear,
		long isActive);

	/**
	* Caches the appraisal setup in the entity cache if it is enabled.
	*
	* @param appraisalSetup the appraisal setup
	*/
	public void cacheResult(AppraisalSetup appraisalSetup);

	/**
	* Caches the appraisal setups in the entity cache if it is enabled.
	*
	* @param appraisalSetups the appraisal setups
	*/
	public void cacheResult(java.util.List<AppraisalSetup> appraisalSetups);

	/**
	* Creates a new appraisal setup with the primary key. Does not add the appraisal setup to the database.
	*
	* @param appraisalSettingId the primary key for the new appraisal setup
	* @return the new appraisal setup
	*/
	public AppraisalSetup create(long appraisalSettingId);

	/**
	* Removes the appraisal setup with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalSettingId the primary key of the appraisal setup
	* @return the appraisal setup that was removed
	* @throws NoSuchAppraisalSetupException if a appraisal setup with the primary key could not be found
	*/
	public AppraisalSetup remove(long appraisalSettingId)
		throws NoSuchAppraisalSetupException;

	public AppraisalSetup updateImpl(AppraisalSetup appraisalSetup);

	/**
	* Returns the appraisal setup with the primary key or throws a {@link NoSuchAppraisalSetupException} if it could not be found.
	*
	* @param appraisalSettingId the primary key of the appraisal setup
	* @return the appraisal setup
	* @throws NoSuchAppraisalSetupException if a appraisal setup with the primary key could not be found
	*/
	public AppraisalSetup findByPrimaryKey(long appraisalSettingId)
		throws NoSuchAppraisalSetupException;

	/**
	* Returns the appraisal setup with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appraisalSettingId the primary key of the appraisal setup
	* @return the appraisal setup, or <code>null</code> if a appraisal setup with the primary key could not be found
	*/
	public AppraisalSetup fetchByPrimaryKey(long appraisalSettingId);

	@Override
	public java.util.Map<java.io.Serializable, AppraisalSetup> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the appraisal setups.
	*
	* @return the appraisal setups
	*/
	public java.util.List<AppraisalSetup> findAll();

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
	public java.util.List<AppraisalSetup> findAll(int start, int end);

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
	public java.util.List<AppraisalSetup> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalSetup> orderByComparator);

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
	public java.util.List<AppraisalSetup> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalSetup> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the appraisal setups from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of appraisal setups.
	*
	* @return the number of appraisal setups
	*/
	public int countAll();
}