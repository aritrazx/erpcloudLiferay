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

import com.liferay.famocom.erpcloud.exception.NoSuchCompanyPolicyException;
import com.liferay.famocom.erpcloud.model.CompanyPolicy;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the company policy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.CompanyPolicyPersistenceImpl
 * @see CompanyPolicyUtil
 * @generated
 */
@ProviderType
public interface CompanyPolicyPersistence extends BasePersistence<CompanyPolicy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CompanyPolicyUtil} to access the company policy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the company policy in the entity cache if it is enabled.
	*
	* @param companyPolicy the company policy
	*/
	public void cacheResult(CompanyPolicy companyPolicy);

	/**
	* Caches the company policies in the entity cache if it is enabled.
	*
	* @param companyPolicies the company policies
	*/
	public void cacheResult(java.util.List<CompanyPolicy> companyPolicies);

	/**
	* Creates a new company policy with the primary key. Does not add the company policy to the database.
	*
	* @param companyPolicyId the primary key for the new company policy
	* @return the new company policy
	*/
	public CompanyPolicy create(long companyPolicyId);

	/**
	* Removes the company policy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyPolicyId the primary key of the company policy
	* @return the company policy that was removed
	* @throws NoSuchCompanyPolicyException if a company policy with the primary key could not be found
	*/
	public CompanyPolicy remove(long companyPolicyId)
		throws NoSuchCompanyPolicyException;

	public CompanyPolicy updateImpl(CompanyPolicy companyPolicy);

	/**
	* Returns the company policy with the primary key or throws a {@link NoSuchCompanyPolicyException} if it could not be found.
	*
	* @param companyPolicyId the primary key of the company policy
	* @return the company policy
	* @throws NoSuchCompanyPolicyException if a company policy with the primary key could not be found
	*/
	public CompanyPolicy findByPrimaryKey(long companyPolicyId)
		throws NoSuchCompanyPolicyException;

	/**
	* Returns the company policy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param companyPolicyId the primary key of the company policy
	* @return the company policy, or <code>null</code> if a company policy with the primary key could not be found
	*/
	public CompanyPolicy fetchByPrimaryKey(long companyPolicyId);

	@Override
	public java.util.Map<java.io.Serializable, CompanyPolicy> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the company policies.
	*
	* @return the company policies
	*/
	public java.util.List<CompanyPolicy> findAll();

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
	public java.util.List<CompanyPolicy> findAll(int start, int end);

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
	public java.util.List<CompanyPolicy> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyPolicy> orderByComparator);

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
	public java.util.List<CompanyPolicy> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyPolicy> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the company policies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of company policies.
	*
	* @return the number of company policies
	*/
	public int countAll();
}