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

import com.liferay.famocom.erpcloud.exception.NoSuchTravelDeskDetailsException;
import com.liferay.famocom.erpcloud.model.TravelDeskDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the travel desk details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TravelDeskDetailsPersistenceImpl
 * @see TravelDeskDetailsUtil
 * @generated
 */
@ProviderType
public interface TravelDeskDetailsPersistence extends BasePersistence<TravelDeskDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelDeskDetailsUtil} to access the travel desk details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the travel desk detailses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching travel desk detailses
	*/
	public java.util.List<TravelDeskDetails> findBytravel(long employeeId);

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
	public java.util.List<TravelDeskDetails> findBytravel(long employeeId,
		int start, int end);

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
	public java.util.List<TravelDeskDetails> findBytravel(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator);

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
	public java.util.List<TravelDeskDetails> findBytravel(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first travel desk details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching travel desk details
	* @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	*/
	public TravelDeskDetails findBytravel_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException;

	/**
	* Returns the first travel desk details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	*/
	public TravelDeskDetails fetchBytravel_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator);

	/**
	* Returns the last travel desk details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching travel desk details
	* @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	*/
	public TravelDeskDetails findBytravel_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException;

	/**
	* Returns the last travel desk details in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	*/
	public TravelDeskDetails fetchBytravel_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator);

	/**
	* Returns the travel desk detailses before and after the current travel desk details in the ordered set where employeeId = &#63;.
	*
	* @param travelDetailsId the primary key of the current travel desk details
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next travel desk details
	* @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	*/
	public TravelDeskDetails[] findBytravel_PrevAndNext(long travelDetailsId,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException;

	/**
	* Removes all the travel desk detailses where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeBytravel(long employeeId);

	/**
	* Returns the number of travel desk detailses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching travel desk detailses
	*/
	public int countBytravel(long employeeId);

	/**
	* Returns all the travel desk detailses where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the matching travel desk detailses
	*/
	public java.util.List<TravelDeskDetails> findByprojectMemberList(
		long projectId);

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
	public java.util.List<TravelDeskDetails> findByprojectMemberList(
		long projectId, int start, int end);

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
	public java.util.List<TravelDeskDetails> findByprojectMemberList(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator);

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
	public java.util.List<TravelDeskDetails> findByprojectMemberList(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first travel desk details in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching travel desk details
	* @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	*/
	public TravelDeskDetails findByprojectMemberList_First(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException;

	/**
	* Returns the first travel desk details in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	*/
	public TravelDeskDetails fetchByprojectMemberList_First(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator);

	/**
	* Returns the last travel desk details in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching travel desk details
	* @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	*/
	public TravelDeskDetails findByprojectMemberList_Last(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException;

	/**
	* Returns the last travel desk details in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	*/
	public TravelDeskDetails fetchByprojectMemberList_Last(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator);

	/**
	* Returns the travel desk detailses before and after the current travel desk details in the ordered set where projectId = &#63;.
	*
	* @param travelDetailsId the primary key of the current travel desk details
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next travel desk details
	* @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	*/
	public TravelDeskDetails[] findByprojectMemberList_PrevAndNext(
		long travelDetailsId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException;

	/**
	* Removes all the travel desk detailses where projectId = &#63; from the database.
	*
	* @param projectId the project ID
	*/
	public void removeByprojectMemberList(long projectId);

	/**
	* Returns the number of travel desk detailses where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the number of matching travel desk detailses
	*/
	public int countByprojectMemberList(long projectId);

	/**
	* Caches the travel desk details in the entity cache if it is enabled.
	*
	* @param travelDeskDetails the travel desk details
	*/
	public void cacheResult(TravelDeskDetails travelDeskDetails);

	/**
	* Caches the travel desk detailses in the entity cache if it is enabled.
	*
	* @param travelDeskDetailses the travel desk detailses
	*/
	public void cacheResult(
		java.util.List<TravelDeskDetails> travelDeskDetailses);

	/**
	* Creates a new travel desk details with the primary key. Does not add the travel desk details to the database.
	*
	* @param travelDetailsId the primary key for the new travel desk details
	* @return the new travel desk details
	*/
	public TravelDeskDetails create(long travelDetailsId);

	/**
	* Removes the travel desk details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param travelDetailsId the primary key of the travel desk details
	* @return the travel desk details that was removed
	* @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	*/
	public TravelDeskDetails remove(long travelDetailsId)
		throws NoSuchTravelDeskDetailsException;

	public TravelDeskDetails updateImpl(TravelDeskDetails travelDeskDetails);

	/**
	* Returns the travel desk details with the primary key or throws a {@link NoSuchTravelDeskDetailsException} if it could not be found.
	*
	* @param travelDetailsId the primary key of the travel desk details
	* @return the travel desk details
	* @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	*/
	public TravelDeskDetails findByPrimaryKey(long travelDetailsId)
		throws NoSuchTravelDeskDetailsException;

	/**
	* Returns the travel desk details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param travelDetailsId the primary key of the travel desk details
	* @return the travel desk details, or <code>null</code> if a travel desk details with the primary key could not be found
	*/
	public TravelDeskDetails fetchByPrimaryKey(long travelDetailsId);

	@Override
	public java.util.Map<java.io.Serializable, TravelDeskDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the travel desk detailses.
	*
	* @return the travel desk detailses
	*/
	public java.util.List<TravelDeskDetails> findAll();

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
	public java.util.List<TravelDeskDetails> findAll(int start, int end);

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
	public java.util.List<TravelDeskDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator);

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
	public java.util.List<TravelDeskDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDeskDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the travel desk detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of travel desk detailses.
	*
	* @return the number of travel desk detailses
	*/
	public int countAll();
}