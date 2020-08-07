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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException;
import com.liferay.famocom.erpcloud.model.LeaveApplyDtl;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the leave apply dtl service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveApplyDtlPersistenceImpl
 * @see LeaveApplyDtlUtil
 * @generated
 */
@ProviderType
public interface LeaveApplyDtlPersistence extends BasePersistence<LeaveApplyDtl> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveApplyDtlUtil} to access the leave apply dtl persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the leave apply dtls where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findByemployeeId(long employeeId);

	/**
	* Returns a range of all the leave apply dtls where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of leave apply dtls
	* @param end the upper bound of the range of leave apply dtls (not inclusive)
	* @return the range of matching leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findByemployeeId(long employeeId,
		int start, int end);

	/**
	* Returns an ordered range of all the leave apply dtls where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of leave apply dtls
	* @param end the upper bound of the range of leave apply dtls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findByemployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator);

	/**
	* Returns an ordered range of all the leave apply dtls where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of leave apply dtls
	* @param end the upper bound of the range of leave apply dtls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findByemployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first leave apply dtl in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	*/
	public LeaveApplyDtl findByemployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException;

	/**
	* Returns the first leave apply dtl in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public LeaveApplyDtl fetchByemployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator);

	/**
	* Returns the last leave apply dtl in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	*/
	public LeaveApplyDtl findByemployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException;

	/**
	* Returns the last leave apply dtl in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public LeaveApplyDtl fetchByemployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator);

	/**
	* Returns the leave apply dtls before and after the current leave apply dtl in the ordered set where employeeId = &#63;.
	*
	* @param leaveApplyDtlId the primary key of the current leave apply dtl
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	*/
	public LeaveApplyDtl[] findByemployeeId_PrevAndNext(long leaveApplyDtlId,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException;

	/**
	* Removes all the leave apply dtls where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeByemployeeId(long employeeId);

	/**
	* Returns the number of leave apply dtls where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching leave apply dtls
	*/
	public int countByemployeeId(long employeeId);

	/**
	* Returns all the leave apply dtls where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @return the matching leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate);

	/**
	* Returns a range of all the leave apply dtls where leaveDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param leaveDate the leave date
	* @param start the lower bound of the range of leave apply dtls
	* @param end the upper bound of the range of leave apply dtls (not inclusive)
	* @return the range of matching leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate,
		int start, int end);

	/**
	* Returns an ordered range of all the leave apply dtls where leaveDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param leaveDate the leave date
	* @param start the lower bound of the range of leave apply dtls
	* @param end the upper bound of the range of leave apply dtls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator);

	/**
	* Returns an ordered range of all the leave apply dtls where leaveDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param leaveDate the leave date
	* @param start the lower bound of the range of leave apply dtls
	* @param end the upper bound of the range of leave apply dtls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first leave apply dtl in the ordered set where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	*/
	public LeaveApplyDtl findByleaveApplyId_First(Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException;

	/**
	* Returns the first leave apply dtl in the ordered set where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public LeaveApplyDtl fetchByleaveApplyId_First(Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator);

	/**
	* Returns the last leave apply dtl in the ordered set where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	*/
	public LeaveApplyDtl findByleaveApplyId_Last(Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException;

	/**
	* Returns the last leave apply dtl in the ordered set where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public LeaveApplyDtl fetchByleaveApplyId_Last(Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator);

	/**
	* Returns the leave apply dtls before and after the current leave apply dtl in the ordered set where leaveDate = &#63;.
	*
	* @param leaveApplyDtlId the primary key of the current leave apply dtl
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	*/
	public LeaveApplyDtl[] findByleaveApplyId_PrevAndNext(
		long leaveApplyDtlId, Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws NoSuchLeaveApplyDtlException;

	/**
	* Removes all the leave apply dtls where leaveDate = &#63; from the database.
	*
	* @param leaveDate the leave date
	*/
	public void removeByleaveApplyId(Date leaveDate);

	/**
	* Returns the number of leave apply dtls where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @return the number of matching leave apply dtls
	*/
	public int countByleaveApplyId(Date leaveDate);

	/**
	* Returns the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; or throws a {@link NoSuchLeaveApplyDtlException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param leaveDate the leave date
	* @param isApprove the is approve
	* @return the matching leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	*/
	public LeaveApplyDtl findByempIdAndAttDate(long employeeId, Date leaveDate,
		int isApprove) throws NoSuchLeaveApplyDtlException;

	/**
	* Returns the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param leaveDate the leave date
	* @param isApprove the is approve
	* @return the matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public LeaveApplyDtl fetchByempIdAndAttDate(long employeeId,
		Date leaveDate, int isApprove);

	/**
	* Returns the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param leaveDate the leave date
	* @param isApprove the is approve
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public LeaveApplyDtl fetchByempIdAndAttDate(long employeeId,
		Date leaveDate, int isApprove, boolean retrieveFromCache);

	/**
	* Removes the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param leaveDate the leave date
	* @param isApprove the is approve
	* @return the leave apply dtl that was removed
	*/
	public LeaveApplyDtl removeByempIdAndAttDate(long employeeId,
		Date leaveDate, int isApprove) throws NoSuchLeaveApplyDtlException;

	/**
	* Returns the number of leave apply dtls where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63;.
	*
	* @param employeeId the employee ID
	* @param leaveDate the leave date
	* @param isApprove the is approve
	* @return the number of matching leave apply dtls
	*/
	public int countByempIdAndAttDate(long employeeId, Date leaveDate,
		int isApprove);

	/**
	* Caches the leave apply dtl in the entity cache if it is enabled.
	*
	* @param leaveApplyDtl the leave apply dtl
	*/
	public void cacheResult(LeaveApplyDtl leaveApplyDtl);

	/**
	* Caches the leave apply dtls in the entity cache if it is enabled.
	*
	* @param leaveApplyDtls the leave apply dtls
	*/
	public void cacheResult(java.util.List<LeaveApplyDtl> leaveApplyDtls);

	/**
	* Creates a new leave apply dtl with the primary key. Does not add the leave apply dtl to the database.
	*
	* @param leaveApplyDtlId the primary key for the new leave apply dtl
	* @return the new leave apply dtl
	*/
	public LeaveApplyDtl create(long leaveApplyDtlId);

	/**
	* Removes the leave apply dtl with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApplyDtlId the primary key of the leave apply dtl
	* @return the leave apply dtl that was removed
	* @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	*/
	public LeaveApplyDtl remove(long leaveApplyDtlId)
		throws NoSuchLeaveApplyDtlException;

	public LeaveApplyDtl updateImpl(LeaveApplyDtl leaveApplyDtl);

	/**
	* Returns the leave apply dtl with the primary key or throws a {@link NoSuchLeaveApplyDtlException} if it could not be found.
	*
	* @param leaveApplyDtlId the primary key of the leave apply dtl
	* @return the leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	*/
	public LeaveApplyDtl findByPrimaryKey(long leaveApplyDtlId)
		throws NoSuchLeaveApplyDtlException;

	/**
	* Returns the leave apply dtl with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveApplyDtlId the primary key of the leave apply dtl
	* @return the leave apply dtl, or <code>null</code> if a leave apply dtl with the primary key could not be found
	*/
	public LeaveApplyDtl fetchByPrimaryKey(long leaveApplyDtlId);

	@Override
	public java.util.Map<java.io.Serializable, LeaveApplyDtl> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the leave apply dtls.
	*
	* @return the leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findAll();

	/**
	* Returns a range of all the leave apply dtls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave apply dtls
	* @param end the upper bound of the range of leave apply dtls (not inclusive)
	* @return the range of leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findAll(int start, int end);

	/**
	* Returns an ordered range of all the leave apply dtls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave apply dtls
	* @param end the upper bound of the range of leave apply dtls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator);

	/**
	* Returns an ordered range of all the leave apply dtls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave apply dtls
	* @param end the upper bound of the range of leave apply dtls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leave apply dtls
	*/
	public java.util.List<LeaveApplyDtl> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveApplyDtl> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the leave apply dtls from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of leave apply dtls.
	*
	* @return the number of leave apply dtls
	*/
	public int countAll();
}