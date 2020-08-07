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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveDocException;
import com.liferay.famocom.erpcloud.model.LeaveDoc;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the leave doc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveDocPersistenceImpl
 * @see LeaveDocUtil
 * @generated
 */
@ProviderType
public interface LeaveDocPersistence extends BasePersistence<LeaveDoc> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveDocUtil} to access the leave doc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the leave doc in the entity cache if it is enabled.
	*
	* @param leaveDoc the leave doc
	*/
	public void cacheResult(LeaveDoc leaveDoc);

	/**
	* Caches the leave docs in the entity cache if it is enabled.
	*
	* @param leaveDocs the leave docs
	*/
	public void cacheResult(java.util.List<LeaveDoc> leaveDocs);

	/**
	* Creates a new leave doc with the primary key. Does not add the leave doc to the database.
	*
	* @param leaveDocId the primary key for the new leave doc
	* @return the new leave doc
	*/
	public LeaveDoc create(long leaveDocId);

	/**
	* Removes the leave doc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveDocId the primary key of the leave doc
	* @return the leave doc that was removed
	* @throws NoSuchLeaveDocException if a leave doc with the primary key could not be found
	*/
	public LeaveDoc remove(long leaveDocId) throws NoSuchLeaveDocException;

	public LeaveDoc updateImpl(LeaveDoc leaveDoc);

	/**
	* Returns the leave doc with the primary key or throws a {@link NoSuchLeaveDocException} if it could not be found.
	*
	* @param leaveDocId the primary key of the leave doc
	* @return the leave doc
	* @throws NoSuchLeaveDocException if a leave doc with the primary key could not be found
	*/
	public LeaveDoc findByPrimaryKey(long leaveDocId)
		throws NoSuchLeaveDocException;

	/**
	* Returns the leave doc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveDocId the primary key of the leave doc
	* @return the leave doc, or <code>null</code> if a leave doc with the primary key could not be found
	*/
	public LeaveDoc fetchByPrimaryKey(long leaveDocId);

	@Override
	public java.util.Map<java.io.Serializable, LeaveDoc> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the leave docs.
	*
	* @return the leave docs
	*/
	public java.util.List<LeaveDoc> findAll();

	/**
	* Returns a range of all the leave docs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave docs
	* @param end the upper bound of the range of leave docs (not inclusive)
	* @return the range of leave docs
	*/
	public java.util.List<LeaveDoc> findAll(int start, int end);

	/**
	* Returns an ordered range of all the leave docs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave docs
	* @param end the upper bound of the range of leave docs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave docs
	*/
	public java.util.List<LeaveDoc> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDoc> orderByComparator);

	/**
	* Returns an ordered range of all the leave docs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave docs
	* @param end the upper bound of the range of leave docs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leave docs
	*/
	public java.util.List<LeaveDoc> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDoc> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the leave docs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of leave docs.
	*
	* @return the number of leave docs
	*/
	public int countAll();
}