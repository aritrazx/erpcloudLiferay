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

import com.liferay.famocom.erpcloud.model.TravelDeskDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the travel desk details service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.TravelDeskDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TravelDeskDetailsPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TravelDeskDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class TravelDeskDetailsUtil {
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
	public static void clearCache(TravelDeskDetails travelDeskDetails) {
		getPersistence().clearCache(travelDeskDetails);
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
	public static List<TravelDeskDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelDeskDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelDeskDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelDeskDetails update(TravelDeskDetails travelDeskDetails) {
		return getPersistence().update(travelDeskDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelDeskDetails update(
		TravelDeskDetails travelDeskDetails, ServiceContext serviceContext) {
		return getPersistence().update(travelDeskDetails, serviceContext);
	}

	/**
	* Returns all the travel desk detailses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching travel desk detailses
	*/
	public static List<TravelDeskDetails> findBytravel(long employeeId) {
		return getPersistence().findBytravel(employeeId);
	}

	/**
	* Returns a range of all the travel desk detailses where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of travel desk detailses
	* @param end the upper bound of the range of travel desk detailses (not inclusive)
	* @return the range of matching travel desk detailses
	*/
	public static List<TravelDeskDetails> findBytravel(long employeeId,
		int start, int end) {
		return getPersistence().findBytravel(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the travel desk detailses where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of travel desk detailses
	* @param end the upper bound of the range of travel desk detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching travel desk detailses
	*/
	public static List<TravelDeskDetails> findBytravel(long employeeId,
		int start, int end,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		return getPersistence()
				   .findBytravel(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the travel desk detailses where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of travel desk detailses
	* @param end the upper bound of the range of travel desk detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching travel desk detailses
	*/
	public static List<TravelDeskDetails> findBytravel(long employeeId,
		int start, int end,
		OrderByComparator<TravelDeskDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBytravel(employeeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first travel desk details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching travel desk details
	* @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	*/
	public static TravelDeskDetails findBytravel_First(long employeeId,
		OrderByComparator<TravelDeskDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTravelDeskDetailsException {
		return getPersistence().findBytravel_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first travel desk details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	*/
	public static TravelDeskDetails fetchBytravel_First(long employeeId,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		return getPersistence()
				   .fetchBytravel_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last travel desk details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching travel desk details
	* @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	*/
	public static TravelDeskDetails findBytravel_Last(long employeeId,
		OrderByComparator<TravelDeskDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTravelDeskDetailsException {
		return getPersistence().findBytravel_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last travel desk details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	*/
	public static TravelDeskDetails fetchBytravel_Last(long employeeId,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		return getPersistence().fetchBytravel_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the travel desk detailses before and after the current travel desk details in the ordered set where employeeId = &#63;.
	*
	* @param travelDetailsId the primary key of the current travel desk details
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next travel desk details
	* @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	*/
	public static TravelDeskDetails[] findBytravel_PrevAndNext(
		long travelDetailsId, long employeeId,
		OrderByComparator<TravelDeskDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTravelDeskDetailsException {
		return getPersistence()
				   .findBytravel_PrevAndNext(travelDetailsId, employeeId,
			orderByComparator);
	}

	/**
	* Removes all the travel desk detailses where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeBytravel(long employeeId) {
		getPersistence().removeBytravel(employeeId);
	}

	/**
	* Returns the number of travel desk detailses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching travel desk detailses
	*/
	public static int countBytravel(long employeeId) {
		return getPersistence().countBytravel(employeeId);
	}

	/**
	* Returns all the travel desk detailses where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the matching travel desk detailses
	*/
	public static List<TravelDeskDetails> findByprojectMemberList(
		long projectId) {
		return getPersistence().findByprojectMemberList(projectId);
	}

	/**
	* Returns a range of all the travel desk detailses where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of travel desk detailses
	* @param end the upper bound of the range of travel desk detailses (not inclusive)
	* @return the range of matching travel desk detailses
	*/
	public static List<TravelDeskDetails> findByprojectMemberList(
		long projectId, int start, int end) {
		return getPersistence().findByprojectMemberList(projectId, start, end);
	}

	/**
	* Returns an ordered range of all the travel desk detailses where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of travel desk detailses
	* @param end the upper bound of the range of travel desk detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching travel desk detailses
	*/
	public static List<TravelDeskDetails> findByprojectMemberList(
		long projectId, int start, int end,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		return getPersistence()
				   .findByprojectMemberList(projectId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the travel desk detailses where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of travel desk detailses
	* @param end the upper bound of the range of travel desk detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching travel desk detailses
	*/
	public static List<TravelDeskDetails> findByprojectMemberList(
		long projectId, int start, int end,
		OrderByComparator<TravelDeskDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByprojectMemberList(projectId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first travel desk details in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching travel desk details
	* @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	*/
	public static TravelDeskDetails findByprojectMemberList_First(
		long projectId, OrderByComparator<TravelDeskDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTravelDeskDetailsException {
		return getPersistence()
				   .findByprojectMemberList_First(projectId, orderByComparator);
	}

	/**
	* Returns the first travel desk details in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	*/
	public static TravelDeskDetails fetchByprojectMemberList_First(
		long projectId, OrderByComparator<TravelDeskDetails> orderByComparator) {
		return getPersistence()
				   .fetchByprojectMemberList_First(projectId, orderByComparator);
	}

	/**
	* Returns the last travel desk details in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching travel desk details
	* @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	*/
	public static TravelDeskDetails findByprojectMemberList_Last(
		long projectId, OrderByComparator<TravelDeskDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTravelDeskDetailsException {
		return getPersistence()
				   .findByprojectMemberList_Last(projectId, orderByComparator);
	}

	/**
	* Returns the last travel desk details in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	*/
	public static TravelDeskDetails fetchByprojectMemberList_Last(
		long projectId, OrderByComparator<TravelDeskDetails> orderByComparator) {
		return getPersistence()
				   .fetchByprojectMemberList_Last(projectId, orderByComparator);
	}

	/**
	* Returns the travel desk detailses before and after the current travel desk details in the ordered set where projectId = &#63;.
	*
	* @param travelDetailsId the primary key of the current travel desk details
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next travel desk details
	* @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	*/
	public static TravelDeskDetails[] findByprojectMemberList_PrevAndNext(
		long travelDetailsId, long projectId,
		OrderByComparator<TravelDeskDetails> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTravelDeskDetailsException {
		return getPersistence()
				   .findByprojectMemberList_PrevAndNext(travelDetailsId,
			projectId, orderByComparator);
	}

	/**
	* Removes all the travel desk detailses where projectId = &#63; from the database.
	*
	* @param projectId the project ID
	*/
	public static void removeByprojectMemberList(long projectId) {
		getPersistence().removeByprojectMemberList(projectId);
	}

	/**
	* Returns the number of travel desk detailses where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the number of matching travel desk detailses
	*/
	public static int countByprojectMemberList(long projectId) {
		return getPersistence().countByprojectMemberList(projectId);
	}

	/**
	* Caches the travel desk details in the entity cache if it is enabled.
	*
	* @param travelDeskDetails the travel desk details
	*/
	public static void cacheResult(TravelDeskDetails travelDeskDetails) {
		getPersistence().cacheResult(travelDeskDetails);
	}

	/**
	* Caches the travel desk detailses in the entity cache if it is enabled.
	*
	* @param travelDeskDetailses the travel desk detailses
	*/
	public static void cacheResult(List<TravelDeskDetails> travelDeskDetailses) {
		getPersistence().cacheResult(travelDeskDetailses);
	}

	/**
	* Creates a new travel desk details with the primary key. Does not add the travel desk details to the database.
	*
	* @param travelDetailsId the primary key for the new travel desk details
	* @return the new travel desk details
	*/
	public static TravelDeskDetails create(long travelDetailsId) {
		return getPersistence().create(travelDetailsId);
	}

	/**
	* Removes the travel desk details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param travelDetailsId the primary key of the travel desk details
	* @return the travel desk details that was removed
	* @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	*/
	public static TravelDeskDetails remove(long travelDetailsId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTravelDeskDetailsException {
		return getPersistence().remove(travelDetailsId);
	}

	public static TravelDeskDetails updateImpl(
		TravelDeskDetails travelDeskDetails) {
		return getPersistence().updateImpl(travelDeskDetails);
	}

	/**
	* Returns the travel desk details with the primary key or throws a {@link NoSuchTravelDeskDetailsException} if it could not be found.
	*
	* @param travelDetailsId the primary key of the travel desk details
	* @return the travel desk details
	* @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	*/
	public static TravelDeskDetails findByPrimaryKey(long travelDetailsId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchTravelDeskDetailsException {
		return getPersistence().findByPrimaryKey(travelDetailsId);
	}

	/**
	* Returns the travel desk details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param travelDetailsId the primary key of the travel desk details
	* @return the travel desk details, or <code>null</code> if a travel desk details with the primary key could not be found
	*/
	public static TravelDeskDetails fetchByPrimaryKey(long travelDetailsId) {
		return getPersistence().fetchByPrimaryKey(travelDetailsId);
	}

	public static java.util.Map<java.io.Serializable, TravelDeskDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the travel desk detailses.
	*
	* @return the travel desk detailses
	*/
	public static List<TravelDeskDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the travel desk detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of travel desk detailses
	* @param end the upper bound of the range of travel desk detailses (not inclusive)
	* @return the range of travel desk detailses
	*/
	public static List<TravelDeskDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the travel desk detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of travel desk detailses
	* @param end the upper bound of the range of travel desk detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of travel desk detailses
	*/
	public static List<TravelDeskDetails> findAll(int start, int end,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the travel desk detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of travel desk detailses
	* @param end the upper bound of the range of travel desk detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of travel desk detailses
	*/
	public static List<TravelDeskDetails> findAll(int start, int end,
		OrderByComparator<TravelDeskDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the travel desk detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of travel desk detailses.
	*
	* @return the number of travel desk detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelDeskDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TravelDeskDetailsPersistence, TravelDeskDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TravelDeskDetailsPersistence.class);

		ServiceTracker<TravelDeskDetailsPersistence, TravelDeskDetailsPersistence> serviceTracker =
			new ServiceTracker<TravelDeskDetailsPersistence, TravelDeskDetailsPersistence>(bundle.getBundleContext(),
				TravelDeskDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}