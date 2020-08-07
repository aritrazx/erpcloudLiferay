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

import com.liferay.famocom.erpcloud.exception.NoSuchBranchException;
import com.liferay.famocom.erpcloud.model.Branch;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the branch service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.BranchPersistenceImpl
 * @see BranchUtil
 * @generated
 */
@ProviderType
public interface BranchPersistence extends BasePersistence<Branch> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BranchUtil} to access the branch persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the branch in the entity cache if it is enabled.
	*
	* @param branch the branch
	*/
	public void cacheResult(Branch branch);

	/**
	* Caches the branchs in the entity cache if it is enabled.
	*
	* @param branchs the branchs
	*/
	public void cacheResult(java.util.List<Branch> branchs);

	/**
	* Creates a new branch with the primary key. Does not add the branch to the database.
	*
	* @param branchId the primary key for the new branch
	* @return the new branch
	*/
	public Branch create(long branchId);

	/**
	* Removes the branch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param branchId the primary key of the branch
	* @return the branch that was removed
	* @throws NoSuchBranchException if a branch with the primary key could not be found
	*/
	public Branch remove(long branchId) throws NoSuchBranchException;

	public Branch updateImpl(Branch branch);

	/**
	* Returns the branch with the primary key or throws a {@link NoSuchBranchException} if it could not be found.
	*
	* @param branchId the primary key of the branch
	* @return the branch
	* @throws NoSuchBranchException if a branch with the primary key could not be found
	*/
	public Branch findByPrimaryKey(long branchId) throws NoSuchBranchException;

	/**
	* Returns the branch with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param branchId the primary key of the branch
	* @return the branch, or <code>null</code> if a branch with the primary key could not be found
	*/
	public Branch fetchByPrimaryKey(long branchId);

	@Override
	public java.util.Map<java.io.Serializable, Branch> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the branchs.
	*
	* @return the branchs
	*/
	public java.util.List<Branch> findAll();

	/**
	* Returns a range of all the branchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BranchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of branchs
	* @param end the upper bound of the range of branchs (not inclusive)
	* @return the range of branchs
	*/
	public java.util.List<Branch> findAll(int start, int end);

	/**
	* Returns an ordered range of all the branchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BranchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of branchs
	* @param end the upper bound of the range of branchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of branchs
	*/
	public java.util.List<Branch> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch> orderByComparator);

	/**
	* Returns an ordered range of all the branchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BranchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of branchs
	* @param end the upper bound of the range of branchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of branchs
	*/
	public java.util.List<Branch> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the branchs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of branchs.
	*
	* @return the number of branchs
	*/
	public int countAll();
}