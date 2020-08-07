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

import com.liferay.famocom.erpcloud.model.LeaveApplyDtl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the leave apply dtl service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.LeaveApplyDtlPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveApplyDtlPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.LeaveApplyDtlPersistenceImpl
 * @generated
 */
@ProviderType
public class LeaveApplyDtlUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(LeaveApplyDtl leaveApplyDtl) {
		getPersistence().clearCache(leaveApplyDtl);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveApplyDtl> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveApplyDtl> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveApplyDtl> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveApplyDtl> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveApplyDtl update(LeaveApplyDtl leaveApplyDtl) {
		return getPersistence().update(leaveApplyDtl);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveApplyDtl update(LeaveApplyDtl leaveApplyDtl,
		ServiceContext serviceContext) {
		return getPersistence().update(leaveApplyDtl, serviceContext);
	}

	/**
	* Returns all the leave apply dtls where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching leave apply dtls
	*/
	public static List<LeaveApplyDtl> findByemployeeId(long employeeId) {
		return getPersistence().findByemployeeId(employeeId);
	}

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
	public static List<LeaveApplyDtl> findByemployeeId(long employeeId,
		int start, int end) {
		return getPersistence().findByemployeeId(employeeId, start, end);
	}

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
	public static List<LeaveApplyDtl> findByemployeeId(long employeeId,
		int start, int end, OrderByComparator<LeaveApplyDtl> orderByComparator) {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator);
	}

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
	public static List<LeaveApplyDtl> findByemployeeId(long employeeId,
		int start, int end, OrderByComparator<LeaveApplyDtl> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first leave apply dtl in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	*/
	public static LeaveApplyDtl findByemployeeId_First(long employeeId,
		OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException {
		return getPersistence()
				   .findByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first leave apply dtl in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public static LeaveApplyDtl fetchByemployeeId_First(long employeeId,
		OrderByComparator<LeaveApplyDtl> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last leave apply dtl in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	*/
	public static LeaveApplyDtl findByemployeeId_Last(long employeeId,
		OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException {
		return getPersistence()
				   .findByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last leave apply dtl in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public static LeaveApplyDtl fetchByemployeeId_Last(long employeeId,
		OrderByComparator<LeaveApplyDtl> orderByComparator) {
		return getPersistence()
				   .fetchByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the leave apply dtls before and after the current leave apply dtl in the ordered set where employeeId = &#63;.
	*
	* @param leaveApplyDtlId the primary key of the current leave apply dtl
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	*/
	public static LeaveApplyDtl[] findByemployeeId_PrevAndNext(
		long leaveApplyDtlId, long employeeId,
		OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException {
		return getPersistence()
				   .findByemployeeId_PrevAndNext(leaveApplyDtlId, employeeId,
			orderByComparator);
	}

	/**
	* Removes all the leave apply dtls where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeByemployeeId(long employeeId) {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	* Returns the number of leave apply dtls where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching leave apply dtls
	*/
	public static int countByemployeeId(long employeeId) {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	* Returns all the leave apply dtls where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @return the matching leave apply dtls
	*/
	public static List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate) {
		return getPersistence().findByleaveApplyId(leaveDate);
	}

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
	public static List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate,
		int start, int end) {
		return getPersistence().findByleaveApplyId(leaveDate, start, end);
	}

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
	public static List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate,
		int start, int end, OrderByComparator<LeaveApplyDtl> orderByComparator) {
		return getPersistence()
				   .findByleaveApplyId(leaveDate, start, end, orderByComparator);
	}

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
	public static List<LeaveApplyDtl> findByleaveApplyId(Date leaveDate,
		int start, int end, OrderByComparator<LeaveApplyDtl> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByleaveApplyId(leaveDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first leave apply dtl in the ordered set where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	*/
	public static LeaveApplyDtl findByleaveApplyId_First(Date leaveDate,
		OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException {
		return getPersistence()
				   .findByleaveApplyId_First(leaveDate, orderByComparator);
	}

	/**
	* Returns the first leave apply dtl in the ordered set where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public static LeaveApplyDtl fetchByleaveApplyId_First(Date leaveDate,
		OrderByComparator<LeaveApplyDtl> orderByComparator) {
		return getPersistence()
				   .fetchByleaveApplyId_First(leaveDate, orderByComparator);
	}

	/**
	* Returns the last leave apply dtl in the ordered set where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	*/
	public static LeaveApplyDtl findByleaveApplyId_Last(Date leaveDate,
		OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException {
		return getPersistence()
				   .findByleaveApplyId_Last(leaveDate, orderByComparator);
	}

	/**
	* Returns the last leave apply dtl in the ordered set where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public static LeaveApplyDtl fetchByleaveApplyId_Last(Date leaveDate,
		OrderByComparator<LeaveApplyDtl> orderByComparator) {
		return getPersistence()
				   .fetchByleaveApplyId_Last(leaveDate, orderByComparator);
	}

	/**
	* Returns the leave apply dtls before and after the current leave apply dtl in the ordered set where leaveDate = &#63;.
	*
	* @param leaveApplyDtlId the primary key of the current leave apply dtl
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	*/
	public static LeaveApplyDtl[] findByleaveApplyId_PrevAndNext(
		long leaveApplyDtlId, Date leaveDate,
		OrderByComparator<LeaveApplyDtl> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException {
		return getPersistence()
				   .findByleaveApplyId_PrevAndNext(leaveApplyDtlId, leaveDate,
			orderByComparator);
	}

	/**
	* Removes all the leave apply dtls where leaveDate = &#63; from the database.
	*
	* @param leaveDate the leave date
	*/
	public static void removeByleaveApplyId(Date leaveDate) {
		getPersistence().removeByleaveApplyId(leaveDate);
	}

	/**
	* Returns the number of leave apply dtls where leaveDate = &#63;.
	*
	* @param leaveDate the leave date
	* @return the number of matching leave apply dtls
	*/
	public static int countByleaveApplyId(Date leaveDate) {
		return getPersistence().countByleaveApplyId(leaveDate);
	}

	/**
	* Returns the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; or throws a {@link NoSuchLeaveApplyDtlException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @param leaveDate the leave date
	* @param isApprove the is approve
	* @return the matching leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a matching leave apply dtl could not be found
	*/
	public static LeaveApplyDtl findByempIdAndAttDate(long employeeId,
		Date leaveDate, int isApprove)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException {
		return getPersistence()
				   .findByempIdAndAttDate(employeeId, leaveDate, isApprove);
	}

	/**
	* Returns the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @param leaveDate the leave date
	* @param isApprove the is approve
	* @return the matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public static LeaveApplyDtl fetchByempIdAndAttDate(long employeeId,
		Date leaveDate, int isApprove) {
		return getPersistence()
				   .fetchByempIdAndAttDate(employeeId, leaveDate, isApprove);
	}

	/**
	* Returns the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param leaveDate the leave date
	* @param isApprove the is approve
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching leave apply dtl, or <code>null</code> if a matching leave apply dtl could not be found
	*/
	public static LeaveApplyDtl fetchByempIdAndAttDate(long employeeId,
		Date leaveDate, int isApprove, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByempIdAndAttDate(employeeId, leaveDate, isApprove,
			retrieveFromCache);
	}

	/**
	* Removes the leave apply dtl where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param leaveDate the leave date
	* @param isApprove the is approve
	* @return the leave apply dtl that was removed
	*/
	public static LeaveApplyDtl removeByempIdAndAttDate(long employeeId,
		Date leaveDate, int isApprove)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException {
		return getPersistence()
				   .removeByempIdAndAttDate(employeeId, leaveDate, isApprove);
	}

	/**
	* Returns the number of leave apply dtls where employeeId = &#63; and leaveDate = &#63; and isApprove = &#63;.
	*
	* @param employeeId the employee ID
	* @param leaveDate the leave date
	* @param isApprove the is approve
	* @return the number of matching leave apply dtls
	*/
	public static int countByempIdAndAttDate(long employeeId, Date leaveDate,
		int isApprove) {
		return getPersistence()
				   .countByempIdAndAttDate(employeeId, leaveDate, isApprove);
	}

	/**
	* Caches the leave apply dtl in the entity cache if it is enabled.
	*
	* @param leaveApplyDtl the leave apply dtl
	*/
	public static void cacheResult(LeaveApplyDtl leaveApplyDtl) {
		getPersistence().cacheResult(leaveApplyDtl);
	}

	/**
	* Caches the leave apply dtls in the entity cache if it is enabled.
	*
	* @param leaveApplyDtls the leave apply dtls
	*/
	public static void cacheResult(List<LeaveApplyDtl> leaveApplyDtls) {
		getPersistence().cacheResult(leaveApplyDtls);
	}

	/**
	* Creates a new leave apply dtl with the primary key. Does not add the leave apply dtl to the database.
	*
	* @param leaveApplyDtlId the primary key for the new leave apply dtl
	* @return the new leave apply dtl
	*/
	public static LeaveApplyDtl create(long leaveApplyDtlId) {
		return getPersistence().create(leaveApplyDtlId);
	}

	/**
	* Removes the leave apply dtl with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApplyDtlId the primary key of the leave apply dtl
	* @return the leave apply dtl that was removed
	* @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	*/
	public static LeaveApplyDtl remove(long leaveApplyDtlId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException {
		return getPersistence().remove(leaveApplyDtlId);
	}

	public static LeaveApplyDtl updateImpl(LeaveApplyDtl leaveApplyDtl) {
		return getPersistence().updateImpl(leaveApplyDtl);
	}

	/**
	* Returns the leave apply dtl with the primary key or throws a {@link NoSuchLeaveApplyDtlException} if it could not be found.
	*
	* @param leaveApplyDtlId the primary key of the leave apply dtl
	* @return the leave apply dtl
	* @throws NoSuchLeaveApplyDtlException if a leave apply dtl with the primary key could not be found
	*/
	public static LeaveApplyDtl findByPrimaryKey(long leaveApplyDtlId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException {
		return getPersistence().findByPrimaryKey(leaveApplyDtlId);
	}

	/**
	* Returns the leave apply dtl with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveApplyDtlId the primary key of the leave apply dtl
	* @return the leave apply dtl, or <code>null</code> if a leave apply dtl with the primary key could not be found
	*/
	public static LeaveApplyDtl fetchByPrimaryKey(long leaveApplyDtlId) {
		return getPersistence().fetchByPrimaryKey(leaveApplyDtlId);
	}

	public static java.util.Map<java.io.Serializable, LeaveApplyDtl> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the leave apply dtls.
	*
	* @return the leave apply dtls
	*/
	public static List<LeaveApplyDtl> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<LeaveApplyDtl> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<LeaveApplyDtl> findAll(int start, int end,
		OrderByComparator<LeaveApplyDtl> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<LeaveApplyDtl> findAll(int start, int end,
		OrderByComparator<LeaveApplyDtl> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the leave apply dtls from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave apply dtls.
	*
	* @return the number of leave apply dtls
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveApplyDtlPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LeaveApplyDtlPersistence, LeaveApplyDtlPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LeaveApplyDtlPersistence.class);

		ServiceTracker<LeaveApplyDtlPersistence, LeaveApplyDtlPersistence> serviceTracker =
			new ServiceTracker<LeaveApplyDtlPersistence, LeaveApplyDtlPersistence>(bundle.getBundleContext(),
				LeaveApplyDtlPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}