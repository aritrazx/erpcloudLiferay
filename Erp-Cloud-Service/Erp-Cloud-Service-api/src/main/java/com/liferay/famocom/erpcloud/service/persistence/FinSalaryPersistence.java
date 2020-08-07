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

import com.liferay.famocom.erpcloud.exception.NoSuchFinSalaryException;
import com.liferay.famocom.erpcloud.model.FinSalary;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the fin salary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.FinSalaryPersistenceImpl
 * @see FinSalaryUtil
 * @generated
 */
@ProviderType
public interface FinSalaryPersistence extends BasePersistence<FinSalary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FinSalaryUtil} to access the fin salary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the fin salary where monthYear = &#63; or throws a {@link NoSuchFinSalaryException} if it could not be found.
	*
	* @param monthYear the month year
	* @return the matching fin salary
	* @throws NoSuchFinSalaryException if a matching fin salary could not be found
	*/
	public FinSalary findBymonthYear(long monthYear)
		throws NoSuchFinSalaryException;

	/**
	* Returns the fin salary where monthYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param monthYear the month year
	* @return the matching fin salary, or <code>null</code> if a matching fin salary could not be found
	*/
	public FinSalary fetchBymonthYear(long monthYear);

	/**
	* Returns the fin salary where monthYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param monthYear the month year
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching fin salary, or <code>null</code> if a matching fin salary could not be found
	*/
	public FinSalary fetchBymonthYear(long monthYear, boolean retrieveFromCache);

	/**
	* Removes the fin salary where monthYear = &#63; from the database.
	*
	* @param monthYear the month year
	* @return the fin salary that was removed
	*/
	public FinSalary removeBymonthYear(long monthYear)
		throws NoSuchFinSalaryException;

	/**
	* Returns the number of fin salaries where monthYear = &#63;.
	*
	* @param monthYear the month year
	* @return the number of matching fin salaries
	*/
	public int countBymonthYear(long monthYear);

	/**
	* Caches the fin salary in the entity cache if it is enabled.
	*
	* @param finSalary the fin salary
	*/
	public void cacheResult(FinSalary finSalary);

	/**
	* Caches the fin salaries in the entity cache if it is enabled.
	*
	* @param finSalaries the fin salaries
	*/
	public void cacheResult(java.util.List<FinSalary> finSalaries);

	/**
	* Creates a new fin salary with the primary key. Does not add the fin salary to the database.
	*
	* @param finSalaryId the primary key for the new fin salary
	* @return the new fin salary
	*/
	public FinSalary create(long finSalaryId);

	/**
	* Removes the fin salary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param finSalaryId the primary key of the fin salary
	* @return the fin salary that was removed
	* @throws NoSuchFinSalaryException if a fin salary with the primary key could not be found
	*/
	public FinSalary remove(long finSalaryId) throws NoSuchFinSalaryException;

	public FinSalary updateImpl(FinSalary finSalary);

	/**
	* Returns the fin salary with the primary key or throws a {@link NoSuchFinSalaryException} if it could not be found.
	*
	* @param finSalaryId the primary key of the fin salary
	* @return the fin salary
	* @throws NoSuchFinSalaryException if a fin salary with the primary key could not be found
	*/
	public FinSalary findByPrimaryKey(long finSalaryId)
		throws NoSuchFinSalaryException;

	/**
	* Returns the fin salary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param finSalaryId the primary key of the fin salary
	* @return the fin salary, or <code>null</code> if a fin salary with the primary key could not be found
	*/
	public FinSalary fetchByPrimaryKey(long finSalaryId);

	@Override
	public java.util.Map<java.io.Serializable, FinSalary> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the fin salaries.
	*
	* @return the fin salaries
	*/
	public java.util.List<FinSalary> findAll();

	/**
	* Returns a range of all the fin salaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fin salaries
	* @param end the upper bound of the range of fin salaries (not inclusive)
	* @return the range of fin salaries
	*/
	public java.util.List<FinSalary> findAll(int start, int end);

	/**
	* Returns an ordered range of all the fin salaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fin salaries
	* @param end the upper bound of the range of fin salaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fin salaries
	*/
	public java.util.List<FinSalary> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FinSalary> orderByComparator);

	/**
	* Returns an ordered range of all the fin salaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fin salaries
	* @param end the upper bound of the range of fin salaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of fin salaries
	*/
	public java.util.List<FinSalary> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FinSalary> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the fin salaries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of fin salaries.
	*
	* @return the number of fin salaries
	*/
	public int countAll();
}