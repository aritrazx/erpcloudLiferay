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

import com.liferay.famocom.erpcloud.exception.NoSuchBankMasterException;
import com.liferay.famocom.erpcloud.model.BankMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the bank master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.BankMasterPersistenceImpl
 * @see BankMasterUtil
 * @generated
 */
@ProviderType
public interface BankMasterPersistence extends BasePersistence<BankMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BankMasterUtil} to access the bank master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the bank master in the entity cache if it is enabled.
	*
	* @param bankMaster the bank master
	*/
	public void cacheResult(BankMaster bankMaster);

	/**
	* Caches the bank masters in the entity cache if it is enabled.
	*
	* @param bankMasters the bank masters
	*/
	public void cacheResult(java.util.List<BankMaster> bankMasters);

	/**
	* Creates a new bank master with the primary key. Does not add the bank master to the database.
	*
	* @param bankId the primary key for the new bank master
	* @return the new bank master
	*/
	public BankMaster create(long bankId);

	/**
	* Removes the bank master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bankId the primary key of the bank master
	* @return the bank master that was removed
	* @throws NoSuchBankMasterException if a bank master with the primary key could not be found
	*/
	public BankMaster remove(long bankId) throws NoSuchBankMasterException;

	public BankMaster updateImpl(BankMaster bankMaster);

	/**
	* Returns the bank master with the primary key or throws a {@link NoSuchBankMasterException} if it could not be found.
	*
	* @param bankId the primary key of the bank master
	* @return the bank master
	* @throws NoSuchBankMasterException if a bank master with the primary key could not be found
	*/
	public BankMaster findByPrimaryKey(long bankId)
		throws NoSuchBankMasterException;

	/**
	* Returns the bank master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bankId the primary key of the bank master
	* @return the bank master, or <code>null</code> if a bank master with the primary key could not be found
	*/
	public BankMaster fetchByPrimaryKey(long bankId);

	@Override
	public java.util.Map<java.io.Serializable, BankMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the bank masters.
	*
	* @return the bank masters
	*/
	public java.util.List<BankMaster> findAll();

	/**
	* Returns a range of all the bank masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bank masters
	* @param end the upper bound of the range of bank masters (not inclusive)
	* @return the range of bank masters
	*/
	public java.util.List<BankMaster> findAll(int start, int end);

	/**
	* Returns an ordered range of all the bank masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bank masters
	* @param end the upper bound of the range of bank masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bank masters
	*/
	public java.util.List<BankMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankMaster> orderByComparator);

	/**
	* Returns an ordered range of all the bank masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bank masters
	* @param end the upper bound of the range of bank masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of bank masters
	*/
	public java.util.List<BankMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the bank masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of bank masters.
	*
	* @return the number of bank masters
	*/
	public int countAll();
}