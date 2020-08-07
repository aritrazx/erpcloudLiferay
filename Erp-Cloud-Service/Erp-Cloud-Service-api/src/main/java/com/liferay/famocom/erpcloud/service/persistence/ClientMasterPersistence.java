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

import com.liferay.famocom.erpcloud.exception.NoSuchClientMasterException;
import com.liferay.famocom.erpcloud.model.ClientMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the client master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ClientMasterPersistenceImpl
 * @see ClientMasterUtil
 * @generated
 */
@ProviderType
public interface ClientMasterPersistence extends BasePersistence<ClientMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClientMasterUtil} to access the client master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the client master in the entity cache if it is enabled.
	*
	* @param clientMaster the client master
	*/
	public void cacheResult(ClientMaster clientMaster);

	/**
	* Caches the client masters in the entity cache if it is enabled.
	*
	* @param clientMasters the client masters
	*/
	public void cacheResult(java.util.List<ClientMaster> clientMasters);

	/**
	* Creates a new client master with the primary key. Does not add the client master to the database.
	*
	* @param clientId the primary key for the new client master
	* @return the new client master
	*/
	public ClientMaster create(long clientId);

	/**
	* Removes the client master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clientId the primary key of the client master
	* @return the client master that was removed
	* @throws NoSuchClientMasterException if a client master with the primary key could not be found
	*/
	public ClientMaster remove(long clientId)
		throws NoSuchClientMasterException;

	public ClientMaster updateImpl(ClientMaster clientMaster);

	/**
	* Returns the client master with the primary key or throws a {@link NoSuchClientMasterException} if it could not be found.
	*
	* @param clientId the primary key of the client master
	* @return the client master
	* @throws NoSuchClientMasterException if a client master with the primary key could not be found
	*/
	public ClientMaster findByPrimaryKey(long clientId)
		throws NoSuchClientMasterException;

	/**
	* Returns the client master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clientId the primary key of the client master
	* @return the client master, or <code>null</code> if a client master with the primary key could not be found
	*/
	public ClientMaster fetchByPrimaryKey(long clientId);

	@Override
	public java.util.Map<java.io.Serializable, ClientMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the client masters.
	*
	* @return the client masters
	*/
	public java.util.List<ClientMaster> findAll();

	/**
	* Returns a range of all the client masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of client masters
	* @param end the upper bound of the range of client masters (not inclusive)
	* @return the range of client masters
	*/
	public java.util.List<ClientMaster> findAll(int start, int end);

	/**
	* Returns an ordered range of all the client masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of client masters
	* @param end the upper bound of the range of client masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of client masters
	*/
	public java.util.List<ClientMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientMaster> orderByComparator);

	/**
	* Returns an ordered range of all the client masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of client masters
	* @param end the upper bound of the range of client masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of client masters
	*/
	public java.util.List<ClientMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the client masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of client masters.
	*
	* @return the number of client masters
	*/
	public int countAll();
}