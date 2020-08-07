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

import com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException;
import com.liferay.famocom.erpcloud.model.PayComponent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the pay component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PayComponentPersistenceImpl
 * @see PayComponentUtil
 * @generated
 */
@ProviderType
public interface PayComponentPersistence extends BasePersistence<PayComponent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayComponentUtil} to access the pay component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the pay components where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @return the matching pay components
	*/
	public java.util.List<PayComponent> findBynameAndcomponentId(String name,
		long componentId);

	/**
	* Returns a range of all the pay components where name = &#63; and componentId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param componentId the component ID
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @return the range of matching pay components
	*/
	public java.util.List<PayComponent> findBynameAndcomponentId(String name,
		long componentId, int start, int end);

	/**
	* Returns an ordered range of all the pay components where name = &#63; and componentId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param componentId the component ID
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pay components
	*/
	public java.util.List<PayComponent> findBynameAndcomponentId(String name,
		long componentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns an ordered range of all the pay components where name = &#63; and componentId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param componentId the component ID
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pay components
	*/
	public java.util.List<PayComponent> findBynameAndcomponentId(String name,
		long componentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public PayComponent findBynameAndcomponentId_First(String name,
		long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Returns the first pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public PayComponent fetchBynameAndcomponentId_First(String name,
		long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns the last pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public PayComponent findBynameAndcomponentId_Last(String name,
		long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Returns the last pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public PayComponent fetchBynameAndcomponentId_Last(String name,
		long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Removes all the pay components where name = &#63; and componentId &ne; &#63; from the database.
	*
	* @param name the name
	* @param componentId the component ID
	*/
	public void removeBynameAndcomponentId(String name, long componentId);

	/**
	* Returns the number of pay components where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @return the number of matching pay components
	*/
	public int countBynameAndcomponentId(String name, long componentId);

	/**
	* Returns all the pay components where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @return the matching pay components
	*/
	public java.util.List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId);

	/**
	* Returns a range of all the pay components where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @return the range of matching pay components
	*/
	public java.util.List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId, int start, int end);

	/**
	* Returns an ordered range of all the pay components where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pay components
	*/
	public java.util.List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns an ordered range of all the pay components where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pay components
	*/
	public java.util.List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public PayComponent findByabbreviationAndcomponentId_First(
		String abbreviation, long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Returns the first pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public PayComponent fetchByabbreviationAndcomponentId_First(
		String abbreviation, long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns the last pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public PayComponent findByabbreviationAndcomponentId_Last(
		String abbreviation, long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Returns the last pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public PayComponent fetchByabbreviationAndcomponentId_Last(
		String abbreviation, long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Removes all the pay components where abbreviation = &#63; and componentId &ne; &#63; from the database.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	*/
	public void removeByabbreviationAndcomponentId(String abbreviation,
		long componentId);

	/**
	* Returns the number of pay components where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @return the number of matching pay components
	*/
	public int countByabbreviationAndcomponentId(String abbreviation,
		long componentId);

	/**
	* Returns all the pay components where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @return the matching pay components
	*/
	public java.util.List<PayComponent> findBytaxStatusAndpayType(
		int taxStatus, String payType);

	/**
	* Returns a range of all the pay components where taxStatus = &#63; and payType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @return the range of matching pay components
	*/
	public java.util.List<PayComponent> findBytaxStatusAndpayType(
		int taxStatus, String payType, int start, int end);

	/**
	* Returns an ordered range of all the pay components where taxStatus = &#63; and payType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pay components
	*/
	public java.util.List<PayComponent> findBytaxStatusAndpayType(
		int taxStatus, String payType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns an ordered range of all the pay components where taxStatus = &#63; and payType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pay components
	*/
	public java.util.List<PayComponent> findBytaxStatusAndpayType(
		int taxStatus, String payType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public PayComponent findBytaxStatusAndpayType_First(int taxStatus,
		String payType,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Returns the first pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public PayComponent fetchBytaxStatusAndpayType_First(int taxStatus,
		String payType,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns the last pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public PayComponent findBytaxStatusAndpayType_Last(int taxStatus,
		String payType,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Returns the last pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public PayComponent fetchBytaxStatusAndpayType_Last(int taxStatus,
		String payType,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns the pay components before and after the current pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	*
	* @param componentId the primary key of the current pay component
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pay component
	* @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	*/
	public PayComponent[] findBytaxStatusAndpayType_PrevAndNext(
		long componentId, int taxStatus, String payType,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Removes all the pay components where taxStatus = &#63; and payType = &#63; from the database.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	*/
	public void removeBytaxStatusAndpayType(int taxStatus, String payType);

	/**
	* Returns the number of pay components where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @return the number of matching pay components
	*/
	public int countBytaxStatusAndpayType(int taxStatus, String payType);

	/**
	* Returns all the pay components where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @return the matching pay components
	*/
	public java.util.List<PayComponent> findBypayComponentOrder(
		long payComponentOrder);

	/**
	* Returns a range of all the pay components where payComponentOrder = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentOrder the pay component order
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @return the range of matching pay components
	*/
	public java.util.List<PayComponent> findBypayComponentOrder(
		long payComponentOrder, int start, int end);

	/**
	* Returns an ordered range of all the pay components where payComponentOrder = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentOrder the pay component order
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pay components
	*/
	public java.util.List<PayComponent> findBypayComponentOrder(
		long payComponentOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns an ordered range of all the pay components where payComponentOrder = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payComponentOrder the pay component order
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pay components
	*/
	public java.util.List<PayComponent> findBypayComponentOrder(
		long payComponentOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pay component in the ordered set where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public PayComponent findBypayComponentOrder_First(long payComponentOrder,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Returns the first pay component in the ordered set where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public PayComponent fetchBypayComponentOrder_First(long payComponentOrder,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns the last pay component in the ordered set where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public PayComponent findBypayComponentOrder_Last(long payComponentOrder,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Returns the last pay component in the ordered set where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public PayComponent fetchBypayComponentOrder_Last(long payComponentOrder,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns the pay components before and after the current pay component in the ordered set where payComponentOrder = &#63;.
	*
	* @param componentId the primary key of the current pay component
	* @param payComponentOrder the pay component order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pay component
	* @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	*/
	public PayComponent[] findBypayComponentOrder_PrevAndNext(
		long componentId, long payComponentOrder,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Removes all the pay components where payComponentOrder = &#63; from the database.
	*
	* @param payComponentOrder the pay component order
	*/
	public void removeBypayComponentOrder(long payComponentOrder);

	/**
	* Returns the number of pay components where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @return the number of matching pay components
	*/
	public int countBypayComponentOrder(long payComponentOrder);

	/**
	* Returns all the pay components where payType = &#63;.
	*
	* @param payType the pay type
	* @return the matching pay components
	*/
	public java.util.List<PayComponent> findBypayType(String payType);

	/**
	* Returns a range of all the pay components where payType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payType the pay type
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @return the range of matching pay components
	*/
	public java.util.List<PayComponent> findBypayType(String payType,
		int start, int end);

	/**
	* Returns an ordered range of all the pay components where payType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payType the pay type
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pay components
	*/
	public java.util.List<PayComponent> findBypayType(String payType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns an ordered range of all the pay components where payType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param payType the pay type
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pay components
	*/
	public java.util.List<PayComponent> findBypayType(String payType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pay component in the ordered set where payType = &#63;.
	*
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public PayComponent findBypayType_First(String payType,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Returns the first pay component in the ordered set where payType = &#63;.
	*
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public PayComponent fetchBypayType_First(String payType,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns the last pay component in the ordered set where payType = &#63;.
	*
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public PayComponent findBypayType_Last(String payType,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Returns the last pay component in the ordered set where payType = &#63;.
	*
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public PayComponent fetchBypayType_Last(String payType,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns the pay components before and after the current pay component in the ordered set where payType = &#63;.
	*
	* @param componentId the primary key of the current pay component
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pay component
	* @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	*/
	public PayComponent[] findBypayType_PrevAndNext(long componentId,
		String payType,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException;

	/**
	* Removes all the pay components where payType = &#63; from the database.
	*
	* @param payType the pay type
	*/
	public void removeBypayType(String payType);

	/**
	* Returns the number of pay components where payType = &#63;.
	*
	* @param payType the pay type
	* @return the number of matching pay components
	*/
	public int countBypayType(String payType);

	/**
	* Caches the pay component in the entity cache if it is enabled.
	*
	* @param payComponent the pay component
	*/
	public void cacheResult(PayComponent payComponent);

	/**
	* Caches the pay components in the entity cache if it is enabled.
	*
	* @param payComponents the pay components
	*/
	public void cacheResult(java.util.List<PayComponent> payComponents);

	/**
	* Creates a new pay component with the primary key. Does not add the pay component to the database.
	*
	* @param componentId the primary key for the new pay component
	* @return the new pay component
	*/
	public PayComponent create(long componentId);

	/**
	* Removes the pay component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param componentId the primary key of the pay component
	* @return the pay component that was removed
	* @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	*/
	public PayComponent remove(long componentId)
		throws NoSuchPayComponentException;

	public PayComponent updateImpl(PayComponent payComponent);

	/**
	* Returns the pay component with the primary key or throws a {@link NoSuchPayComponentException} if it could not be found.
	*
	* @param componentId the primary key of the pay component
	* @return the pay component
	* @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	*/
	public PayComponent findByPrimaryKey(long componentId)
		throws NoSuchPayComponentException;

	/**
	* Returns the pay component with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param componentId the primary key of the pay component
	* @return the pay component, or <code>null</code> if a pay component with the primary key could not be found
	*/
	public PayComponent fetchByPrimaryKey(long componentId);

	@Override
	public java.util.Map<java.io.Serializable, PayComponent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the pay components.
	*
	* @return the pay components
	*/
	public java.util.List<PayComponent> findAll();

	/**
	* Returns a range of all the pay components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @return the range of pay components
	*/
	public java.util.List<PayComponent> findAll(int start, int end);

	/**
	* Returns an ordered range of all the pay components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pay components
	*/
	public java.util.List<PayComponent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator);

	/**
	* Returns an ordered range of all the pay components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pay components
	* @param end the upper bound of the range of pay components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of pay components
	*/
	public java.util.List<PayComponent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the pay components from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of pay components.
	*
	* @return the number of pay components
	*/
	public int countAll();
}