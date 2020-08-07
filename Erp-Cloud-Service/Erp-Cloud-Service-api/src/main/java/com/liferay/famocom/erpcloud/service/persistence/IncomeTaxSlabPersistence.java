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

import com.liferay.famocom.erpcloud.exception.NoSuchIncomeTaxSlabException;
import com.liferay.famocom.erpcloud.model.IncomeTaxSlab;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the income tax slab service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.IncomeTaxSlabPersistenceImpl
 * @see IncomeTaxSlabUtil
 * @generated
 */
@ProviderType
public interface IncomeTaxSlabPersistence extends BasePersistence<IncomeTaxSlab> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IncomeTaxSlabUtil} to access the income tax slab persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the income tax slab in the entity cache if it is enabled.
	*
	* @param incomeTaxSlab the income tax slab
	*/
	public void cacheResult(IncomeTaxSlab incomeTaxSlab);

	/**
	* Caches the income tax slabs in the entity cache if it is enabled.
	*
	* @param incomeTaxSlabs the income tax slabs
	*/
	public void cacheResult(java.util.List<IncomeTaxSlab> incomeTaxSlabs);

	/**
	* Creates a new income tax slab with the primary key. Does not add the income tax slab to the database.
	*
	* @param incomeTaxSlabId the primary key for the new income tax slab
	* @return the new income tax slab
	*/
	public IncomeTaxSlab create(long incomeTaxSlabId);

	/**
	* Removes the income tax slab with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param incomeTaxSlabId the primary key of the income tax slab
	* @return the income tax slab that was removed
	* @throws NoSuchIncomeTaxSlabException if a income tax slab with the primary key could not be found
	*/
	public IncomeTaxSlab remove(long incomeTaxSlabId)
		throws NoSuchIncomeTaxSlabException;

	public IncomeTaxSlab updateImpl(IncomeTaxSlab incomeTaxSlab);

	/**
	* Returns the income tax slab with the primary key or throws a {@link NoSuchIncomeTaxSlabException} if it could not be found.
	*
	* @param incomeTaxSlabId the primary key of the income tax slab
	* @return the income tax slab
	* @throws NoSuchIncomeTaxSlabException if a income tax slab with the primary key could not be found
	*/
	public IncomeTaxSlab findByPrimaryKey(long incomeTaxSlabId)
		throws NoSuchIncomeTaxSlabException;

	/**
	* Returns the income tax slab with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param incomeTaxSlabId the primary key of the income tax slab
	* @return the income tax slab, or <code>null</code> if a income tax slab with the primary key could not be found
	*/
	public IncomeTaxSlab fetchByPrimaryKey(long incomeTaxSlabId);

	@Override
	public java.util.Map<java.io.Serializable, IncomeTaxSlab> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the income tax slabs.
	*
	* @return the income tax slabs
	*/
	public java.util.List<IncomeTaxSlab> findAll();

	/**
	* Returns a range of all the income tax slabs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IncomeTaxSlabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of income tax slabs
	* @param end the upper bound of the range of income tax slabs (not inclusive)
	* @return the range of income tax slabs
	*/
	public java.util.List<IncomeTaxSlab> findAll(int start, int end);

	/**
	* Returns an ordered range of all the income tax slabs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IncomeTaxSlabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of income tax slabs
	* @param end the upper bound of the range of income tax slabs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of income tax slabs
	*/
	public java.util.List<IncomeTaxSlab> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IncomeTaxSlab> orderByComparator);

	/**
	* Returns an ordered range of all the income tax slabs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IncomeTaxSlabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of income tax slabs
	* @param end the upper bound of the range of income tax slabs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of income tax slabs
	*/
	public java.util.List<IncomeTaxSlab> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IncomeTaxSlab> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the income tax slabs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of income tax slabs.
	*
	* @return the number of income tax slabs
	*/
	public int countAll();
}