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

import com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException;
import com.liferay.famocom.erpcloud.model.TaxDeclaration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the tax declaration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TaxDeclarationPersistenceImpl
 * @see TaxDeclarationUtil
 * @generated
 */
@ProviderType
public interface TaxDeclarationPersistence extends BasePersistence<TaxDeclaration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaxDeclarationUtil} to access the tax declaration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the tax declaration where employeeId = &#63; or throws a {@link NoSuchTaxDeclarationException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @return the matching tax declaration
	* @throws NoSuchTaxDeclarationException if a matching tax declaration could not be found
	*/
	public TaxDeclaration findByemployeeId(long employeeId)
		throws NoSuchTaxDeclarationException;

	/**
	* Returns the tax declaration where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	*/
	public TaxDeclaration fetchByemployeeId(long employeeId);

	/**
	* Returns the tax declaration where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	*/
	public TaxDeclaration fetchByemployeeId(long employeeId,
		boolean retrieveFromCache);

	/**
	* Removes the tax declaration where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @return the tax declaration that was removed
	*/
	public TaxDeclaration removeByemployeeId(long employeeId)
		throws NoSuchTaxDeclarationException;

	/**
	* Returns the number of tax declarations where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching tax declarations
	*/
	public int countByemployeeId(long employeeId);

	/**
	* Returns the tax declaration where employeeId = &#63; and financialYear = &#63; or throws a {@link NoSuchTaxDeclarationException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the matching tax declaration
	* @throws NoSuchTaxDeclarationException if a matching tax declaration could not be found
	*/
	public TaxDeclaration findByemployeeIdAndFinancialYear(long employeeId,
		String financialYear) throws NoSuchTaxDeclarationException;

	/**
	* Returns the tax declaration where employeeId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	*/
	public TaxDeclaration fetchByemployeeIdAndFinancialYear(long employeeId,
		String financialYear);

	/**
	* Returns the tax declaration where employeeId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	*/
	public TaxDeclaration fetchByemployeeIdAndFinancialYear(long employeeId,
		String financialYear, boolean retrieveFromCache);

	/**
	* Removes the tax declaration where employeeId = &#63; and financialYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the tax declaration that was removed
	*/
	public TaxDeclaration removeByemployeeIdAndFinancialYear(long employeeId,
		String financialYear) throws NoSuchTaxDeclarationException;

	/**
	* Returns the number of tax declarations where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the number of matching tax declarations
	*/
	public int countByemployeeIdAndFinancialYear(long employeeId,
		String financialYear);

	/**
	* Caches the tax declaration in the entity cache if it is enabled.
	*
	* @param taxDeclaration the tax declaration
	*/
	public void cacheResult(TaxDeclaration taxDeclaration);

	/**
	* Caches the tax declarations in the entity cache if it is enabled.
	*
	* @param taxDeclarations the tax declarations
	*/
	public void cacheResult(java.util.List<TaxDeclaration> taxDeclarations);

	/**
	* Creates a new tax declaration with the primary key. Does not add the tax declaration to the database.
	*
	* @param taxDeclarationId the primary key for the new tax declaration
	* @return the new tax declaration
	*/
	public TaxDeclaration create(long taxDeclarationId);

	/**
	* Removes the tax declaration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxDeclarationId the primary key of the tax declaration
	* @return the tax declaration that was removed
	* @throws NoSuchTaxDeclarationException if a tax declaration with the primary key could not be found
	*/
	public TaxDeclaration remove(long taxDeclarationId)
		throws NoSuchTaxDeclarationException;

	public TaxDeclaration updateImpl(TaxDeclaration taxDeclaration);

	/**
	* Returns the tax declaration with the primary key or throws a {@link NoSuchTaxDeclarationException} if it could not be found.
	*
	* @param taxDeclarationId the primary key of the tax declaration
	* @return the tax declaration
	* @throws NoSuchTaxDeclarationException if a tax declaration with the primary key could not be found
	*/
	public TaxDeclaration findByPrimaryKey(long taxDeclarationId)
		throws NoSuchTaxDeclarationException;

	/**
	* Returns the tax declaration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taxDeclarationId the primary key of the tax declaration
	* @return the tax declaration, or <code>null</code> if a tax declaration with the primary key could not be found
	*/
	public TaxDeclaration fetchByPrimaryKey(long taxDeclarationId);

	@Override
	public java.util.Map<java.io.Serializable, TaxDeclaration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tax declarations.
	*
	* @return the tax declarations
	*/
	public java.util.List<TaxDeclaration> findAll();

	/**
	* Returns a range of all the tax declarations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declarations
	* @param end the upper bound of the range of tax declarations (not inclusive)
	* @return the range of tax declarations
	*/
	public java.util.List<TaxDeclaration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tax declarations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declarations
	* @param end the upper bound of the range of tax declarations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tax declarations
	*/
	public java.util.List<TaxDeclaration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclaration> orderByComparator);

	/**
	* Returns an ordered range of all the tax declarations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax declarations
	* @param end the upper bound of the range of tax declarations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tax declarations
	*/
	public java.util.List<TaxDeclaration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxDeclaration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tax declarations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tax declarations.
	*
	* @return the number of tax declarations
	*/
	public int countAll();
}