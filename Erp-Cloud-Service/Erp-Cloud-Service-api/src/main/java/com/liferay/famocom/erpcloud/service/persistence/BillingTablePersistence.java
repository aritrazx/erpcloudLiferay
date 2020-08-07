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

import com.liferay.famocom.erpcloud.exception.NoSuchBillingTableException;
import com.liferay.famocom.erpcloud.model.BillingTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the billing table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.BillingTablePersistenceImpl
 * @see BillingTableUtil
 * @generated
 */
@ProviderType
public interface BillingTablePersistence extends BasePersistence<BillingTable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BillingTableUtil} to access the billing table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the billing table in the entity cache if it is enabled.
	*
	* @param billingTable the billing table
	*/
	public void cacheResult(BillingTable billingTable);

	/**
	* Caches the billing tables in the entity cache if it is enabled.
	*
	* @param billingTables the billing tables
	*/
	public void cacheResult(java.util.List<BillingTable> billingTables);

	/**
	* Creates a new billing table with the primary key. Does not add the billing table to the database.
	*
	* @param billingId the primary key for the new billing table
	* @return the new billing table
	*/
	public BillingTable create(long billingId);

	/**
	* Removes the billing table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billingId the primary key of the billing table
	* @return the billing table that was removed
	* @throws NoSuchBillingTableException if a billing table with the primary key could not be found
	*/
	public BillingTable remove(long billingId)
		throws NoSuchBillingTableException;

	public BillingTable updateImpl(BillingTable billingTable);

	/**
	* Returns the billing table with the primary key or throws a {@link NoSuchBillingTableException} if it could not be found.
	*
	* @param billingId the primary key of the billing table
	* @return the billing table
	* @throws NoSuchBillingTableException if a billing table with the primary key could not be found
	*/
	public BillingTable findByPrimaryKey(long billingId)
		throws NoSuchBillingTableException;

	/**
	* Returns the billing table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param billingId the primary key of the billing table
	* @return the billing table, or <code>null</code> if a billing table with the primary key could not be found
	*/
	public BillingTable fetchByPrimaryKey(long billingId);

	@Override
	public java.util.Map<java.io.Serializable, BillingTable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the billing tables.
	*
	* @return the billing tables
	*/
	public java.util.List<BillingTable> findAll();

	/**
	* Returns a range of all the billing tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing tables
	* @param end the upper bound of the range of billing tables (not inclusive)
	* @return the range of billing tables
	*/
	public java.util.List<BillingTable> findAll(int start, int end);

	/**
	* Returns an ordered range of all the billing tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing tables
	* @param end the upper bound of the range of billing tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of billing tables
	*/
	public java.util.List<BillingTable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BillingTable> orderByComparator);

	/**
	* Returns an ordered range of all the billing tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing tables
	* @param end the upper bound of the range of billing tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of billing tables
	*/
	public java.util.List<BillingTable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BillingTable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the billing tables from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of billing tables.
	*
	* @return the number of billing tables
	*/
	public int countAll();
}