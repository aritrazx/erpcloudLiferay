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

import com.liferay.famocom.erpcloud.exception.NoSuchExpProofFilesException;
import com.liferay.famocom.erpcloud.model.ExpProofFiles;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the exp proof files service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ExpProofFilesPersistenceImpl
 * @see ExpProofFilesUtil
 * @generated
 */
@ProviderType
public interface ExpProofFilesPersistence extends BasePersistence<ExpProofFiles> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExpProofFilesUtil} to access the exp proof files persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the exp proof files where expenseId = &#63; or throws a {@link NoSuchExpProofFilesException} if it could not be found.
	*
	* @param expenseId the expense ID
	* @return the matching exp proof files
	* @throws NoSuchExpProofFilesException if a matching exp proof files could not be found
	*/
	public ExpProofFiles findByExpenceId(long expenseId)
		throws NoSuchExpProofFilesException;

	/**
	* Returns the exp proof files where expenseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param expenseId the expense ID
	* @return the matching exp proof files, or <code>null</code> if a matching exp proof files could not be found
	*/
	public ExpProofFiles fetchByExpenceId(long expenseId);

	/**
	* Returns the exp proof files where expenseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param expenseId the expense ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching exp proof files, or <code>null</code> if a matching exp proof files could not be found
	*/
	public ExpProofFiles fetchByExpenceId(long expenseId,
		boolean retrieveFromCache);

	/**
	* Removes the exp proof files where expenseId = &#63; from the database.
	*
	* @param expenseId the expense ID
	* @return the exp proof files that was removed
	*/
	public ExpProofFiles removeByExpenceId(long expenseId)
		throws NoSuchExpProofFilesException;

	/**
	* Returns the number of exp proof fileses where expenseId = &#63;.
	*
	* @param expenseId the expense ID
	* @return the number of matching exp proof fileses
	*/
	public int countByExpenceId(long expenseId);

	/**
	* Caches the exp proof files in the entity cache if it is enabled.
	*
	* @param expProofFiles the exp proof files
	*/
	public void cacheResult(ExpProofFiles expProofFiles);

	/**
	* Caches the exp proof fileses in the entity cache if it is enabled.
	*
	* @param expProofFileses the exp proof fileses
	*/
	public void cacheResult(java.util.List<ExpProofFiles> expProofFileses);

	/**
	* Creates a new exp proof files with the primary key. Does not add the exp proof files to the database.
	*
	* @param fileId the primary key for the new exp proof files
	* @return the new exp proof files
	*/
	public ExpProofFiles create(long fileId);

	/**
	* Removes the exp proof files with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileId the primary key of the exp proof files
	* @return the exp proof files that was removed
	* @throws NoSuchExpProofFilesException if a exp proof files with the primary key could not be found
	*/
	public ExpProofFiles remove(long fileId)
		throws NoSuchExpProofFilesException;

	public ExpProofFiles updateImpl(ExpProofFiles expProofFiles);

	/**
	* Returns the exp proof files with the primary key or throws a {@link NoSuchExpProofFilesException} if it could not be found.
	*
	* @param fileId the primary key of the exp proof files
	* @return the exp proof files
	* @throws NoSuchExpProofFilesException if a exp proof files with the primary key could not be found
	*/
	public ExpProofFiles findByPrimaryKey(long fileId)
		throws NoSuchExpProofFilesException;

	/**
	* Returns the exp proof files with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fileId the primary key of the exp proof files
	* @return the exp proof files, or <code>null</code> if a exp proof files with the primary key could not be found
	*/
	public ExpProofFiles fetchByPrimaryKey(long fileId);

	@Override
	public java.util.Map<java.io.Serializable, ExpProofFiles> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the exp proof fileses.
	*
	* @return the exp proof fileses
	*/
	public java.util.List<ExpProofFiles> findAll();

	/**
	* Returns a range of all the exp proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp proof fileses
	* @param end the upper bound of the range of exp proof fileses (not inclusive)
	* @return the range of exp proof fileses
	*/
	public java.util.List<ExpProofFiles> findAll(int start, int end);

	/**
	* Returns an ordered range of all the exp proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp proof fileses
	* @param end the upper bound of the range of exp proof fileses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of exp proof fileses
	*/
	public java.util.List<ExpProofFiles> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpProofFiles> orderByComparator);

	/**
	* Returns an ordered range of all the exp proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp proof fileses
	* @param end the upper bound of the range of exp proof fileses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of exp proof fileses
	*/
	public java.util.List<ExpProofFiles> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpProofFiles> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the exp proof fileses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of exp proof fileses.
	*
	* @return the number of exp proof fileses
	*/
	public int countAll();
}