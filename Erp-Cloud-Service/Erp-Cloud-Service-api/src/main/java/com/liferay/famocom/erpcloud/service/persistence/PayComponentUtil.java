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

import com.liferay.famocom.erpcloud.model.PayComponent;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the pay component service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.PayComponentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PayComponentPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.PayComponentPersistenceImpl
 * @generated
 */
@ProviderType
public class PayComponentUtil {
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
	public static void clearCache(PayComponent payComponent) {
		getPersistence().clearCache(payComponent);
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
	public static List<PayComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PayComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PayComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PayComponent update(PayComponent payComponent) {
		return getPersistence().update(payComponent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PayComponent update(PayComponent payComponent,
		ServiceContext serviceContext) {
		return getPersistence().update(payComponent, serviceContext);
	}

	/**
	* Returns all the pay components where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @return the matching pay components
	*/
	public static List<PayComponent> findBynameAndcomponentId(String name,
		long componentId) {
		return getPersistence().findBynameAndcomponentId(name, componentId);
	}

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
	public static List<PayComponent> findBynameAndcomponentId(String name,
		long componentId, int start, int end) {
		return getPersistence()
				   .findBynameAndcomponentId(name, componentId, start, end);
	}

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
	public static List<PayComponent> findBynameAndcomponentId(String name,
		long componentId, int start, int end,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .findBynameAndcomponentId(name, componentId, start, end,
			orderByComparator);
	}

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
	public static List<PayComponent> findBynameAndcomponentId(String name,
		long componentId, int start, int end,
		OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBynameAndcomponentId(name, componentId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public static PayComponent findBynameAndcomponentId_First(String name,
		long componentId, OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence()
				   .findBynameAndcomponentId_First(name, componentId,
			orderByComparator);
	}

	/**
	* Returns the first pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public static PayComponent fetchBynameAndcomponentId_First(String name,
		long componentId, OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .fetchBynameAndcomponentId_First(name, componentId,
			orderByComparator);
	}

	/**
	* Returns the last pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public static PayComponent findBynameAndcomponentId_Last(String name,
		long componentId, OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence()
				   .findBynameAndcomponentId_Last(name, componentId,
			orderByComparator);
	}

	/**
	* Returns the last pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public static PayComponent fetchBynameAndcomponentId_Last(String name,
		long componentId, OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .fetchBynameAndcomponentId_Last(name, componentId,
			orderByComparator);
	}

	/**
	* Removes all the pay components where name = &#63; and componentId &ne; &#63; from the database.
	*
	* @param name the name
	* @param componentId the component ID
	*/
	public static void removeBynameAndcomponentId(String name, long componentId) {
		getPersistence().removeBynameAndcomponentId(name, componentId);
	}

	/**
	* Returns the number of pay components where name = &#63; and componentId &ne; &#63;.
	*
	* @param name the name
	* @param componentId the component ID
	* @return the number of matching pay components
	*/
	public static int countBynameAndcomponentId(String name, long componentId) {
		return getPersistence().countBynameAndcomponentId(name, componentId);
	}

	/**
	* Returns all the pay components where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @return the matching pay components
	*/
	public static List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId) {
		return getPersistence()
				   .findByabbreviationAndcomponentId(abbreviation, componentId);
	}

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
	public static List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId, int start, int end) {
		return getPersistence()
				   .findByabbreviationAndcomponentId(abbreviation, componentId,
			start, end);
	}

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
	public static List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId, int start, int end,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .findByabbreviationAndcomponentId(abbreviation, componentId,
			start, end, orderByComparator);
	}

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
	public static List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId, int start, int end,
		OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByabbreviationAndcomponentId(abbreviation, componentId,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public static PayComponent findByabbreviationAndcomponentId_First(
		String abbreviation, long componentId,
		OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence()
				   .findByabbreviationAndcomponentId_First(abbreviation,
			componentId, orderByComparator);
	}

	/**
	* Returns the first pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public static PayComponent fetchByabbreviationAndcomponentId_First(
		String abbreviation, long componentId,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .fetchByabbreviationAndcomponentId_First(abbreviation,
			componentId, orderByComparator);
	}

	/**
	* Returns the last pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public static PayComponent findByabbreviationAndcomponentId_Last(
		String abbreviation, long componentId,
		OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence()
				   .findByabbreviationAndcomponentId_Last(abbreviation,
			componentId, orderByComparator);
	}

	/**
	* Returns the last pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public static PayComponent fetchByabbreviationAndcomponentId_Last(
		String abbreviation, long componentId,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .fetchByabbreviationAndcomponentId_Last(abbreviation,
			componentId, orderByComparator);
	}

	/**
	* Removes all the pay components where abbreviation = &#63; and componentId &ne; &#63; from the database.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	*/
	public static void removeByabbreviationAndcomponentId(String abbreviation,
		long componentId) {
		getPersistence()
			.removeByabbreviationAndcomponentId(abbreviation, componentId);
	}

	/**
	* Returns the number of pay components where abbreviation = &#63; and componentId &ne; &#63;.
	*
	* @param abbreviation the abbreviation
	* @param componentId the component ID
	* @return the number of matching pay components
	*/
	public static int countByabbreviationAndcomponentId(String abbreviation,
		long componentId) {
		return getPersistence()
				   .countByabbreviationAndcomponentId(abbreviation, componentId);
	}

	/**
	* Returns all the pay components where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @return the matching pay components
	*/
	public static List<PayComponent> findBytaxStatusAndpayType(int taxStatus,
		String payType) {
		return getPersistence().findBytaxStatusAndpayType(taxStatus, payType);
	}

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
	public static List<PayComponent> findBytaxStatusAndpayType(int taxStatus,
		String payType, int start, int end) {
		return getPersistence()
				   .findBytaxStatusAndpayType(taxStatus, payType, start, end);
	}

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
	public static List<PayComponent> findBytaxStatusAndpayType(int taxStatus,
		String payType, int start, int end,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .findBytaxStatusAndpayType(taxStatus, payType, start, end,
			orderByComparator);
	}

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
	public static List<PayComponent> findBytaxStatusAndpayType(int taxStatus,
		String payType, int start, int end,
		OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBytaxStatusAndpayType(taxStatus, payType, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public static PayComponent findBytaxStatusAndpayType_First(int taxStatus,
		String payType, OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence()
				   .findBytaxStatusAndpayType_First(taxStatus, payType,
			orderByComparator);
	}

	/**
	* Returns the first pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public static PayComponent fetchBytaxStatusAndpayType_First(int taxStatus,
		String payType, OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .fetchBytaxStatusAndpayType_First(taxStatus, payType,
			orderByComparator);
	}

	/**
	* Returns the last pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public static PayComponent findBytaxStatusAndpayType_Last(int taxStatus,
		String payType, OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence()
				   .findBytaxStatusAndpayType_Last(taxStatus, payType,
			orderByComparator);
	}

	/**
	* Returns the last pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public static PayComponent fetchBytaxStatusAndpayType_Last(int taxStatus,
		String payType, OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .fetchBytaxStatusAndpayType_Last(taxStatus, payType,
			orderByComparator);
	}

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
	public static PayComponent[] findBytaxStatusAndpayType_PrevAndNext(
		long componentId, int taxStatus, String payType,
		OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence()
				   .findBytaxStatusAndpayType_PrevAndNext(componentId,
			taxStatus, payType, orderByComparator);
	}

	/**
	* Removes all the pay components where taxStatus = &#63; and payType = &#63; from the database.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	*/
	public static void removeBytaxStatusAndpayType(int taxStatus, String payType) {
		getPersistence().removeBytaxStatusAndpayType(taxStatus, payType);
	}

	/**
	* Returns the number of pay components where taxStatus = &#63; and payType = &#63;.
	*
	* @param taxStatus the tax status
	* @param payType the pay type
	* @return the number of matching pay components
	*/
	public static int countBytaxStatusAndpayType(int taxStatus, String payType) {
		return getPersistence().countBytaxStatusAndpayType(taxStatus, payType);
	}

	/**
	* Returns all the pay components where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @return the matching pay components
	*/
	public static List<PayComponent> findBypayComponentOrder(
		long payComponentOrder) {
		return getPersistence().findBypayComponentOrder(payComponentOrder);
	}

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
	public static List<PayComponent> findBypayComponentOrder(
		long payComponentOrder, int start, int end) {
		return getPersistence()
				   .findBypayComponentOrder(payComponentOrder, start, end);
	}

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
	public static List<PayComponent> findBypayComponentOrder(
		long payComponentOrder, int start, int end,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .findBypayComponentOrder(payComponentOrder, start, end,
			orderByComparator);
	}

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
	public static List<PayComponent> findBypayComponentOrder(
		long payComponentOrder, int start, int end,
		OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBypayComponentOrder(payComponentOrder, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first pay component in the ordered set where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public static PayComponent findBypayComponentOrder_First(
		long payComponentOrder,
		OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence()
				   .findBypayComponentOrder_First(payComponentOrder,
			orderByComparator);
	}

	/**
	* Returns the first pay component in the ordered set where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public static PayComponent fetchBypayComponentOrder_First(
		long payComponentOrder,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .fetchBypayComponentOrder_First(payComponentOrder,
			orderByComparator);
	}

	/**
	* Returns the last pay component in the ordered set where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public static PayComponent findBypayComponentOrder_Last(
		long payComponentOrder,
		OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence()
				   .findBypayComponentOrder_Last(payComponentOrder,
			orderByComparator);
	}

	/**
	* Returns the last pay component in the ordered set where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public static PayComponent fetchBypayComponentOrder_Last(
		long payComponentOrder,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .fetchBypayComponentOrder_Last(payComponentOrder,
			orderByComparator);
	}

	/**
	* Returns the pay components before and after the current pay component in the ordered set where payComponentOrder = &#63;.
	*
	* @param componentId the primary key of the current pay component
	* @param payComponentOrder the pay component order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pay component
	* @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	*/
	public static PayComponent[] findBypayComponentOrder_PrevAndNext(
		long componentId, long payComponentOrder,
		OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence()
				   .findBypayComponentOrder_PrevAndNext(componentId,
			payComponentOrder, orderByComparator);
	}

	/**
	* Removes all the pay components where payComponentOrder = &#63; from the database.
	*
	* @param payComponentOrder the pay component order
	*/
	public static void removeBypayComponentOrder(long payComponentOrder) {
		getPersistence().removeBypayComponentOrder(payComponentOrder);
	}

	/**
	* Returns the number of pay components where payComponentOrder = &#63;.
	*
	* @param payComponentOrder the pay component order
	* @return the number of matching pay components
	*/
	public static int countBypayComponentOrder(long payComponentOrder) {
		return getPersistence().countBypayComponentOrder(payComponentOrder);
	}

	/**
	* Returns all the pay components where payType = &#63;.
	*
	* @param payType the pay type
	* @return the matching pay components
	*/
	public static List<PayComponent> findBypayType(String payType) {
		return getPersistence().findBypayType(payType);
	}

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
	public static List<PayComponent> findBypayType(String payType, int start,
		int end) {
		return getPersistence().findBypayType(payType, start, end);
	}

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
	public static List<PayComponent> findBypayType(String payType, int start,
		int end, OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence()
				   .findBypayType(payType, start, end, orderByComparator);
	}

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
	public static List<PayComponent> findBypayType(String payType, int start,
		int end, OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBypayType(payType, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first pay component in the ordered set where payType = &#63;.
	*
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public static PayComponent findBypayType_First(String payType,
		OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence().findBypayType_First(payType, orderByComparator);
	}

	/**
	* Returns the first pay component in the ordered set where payType = &#63;.
	*
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public static PayComponent fetchBypayType_First(String payType,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence().fetchBypayType_First(payType, orderByComparator);
	}

	/**
	* Returns the last pay component in the ordered set where payType = &#63;.
	*
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component
	* @throws NoSuchPayComponentException if a matching pay component could not be found
	*/
	public static PayComponent findBypayType_Last(String payType,
		OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence().findBypayType_Last(payType, orderByComparator);
	}

	/**
	* Returns the last pay component in the ordered set where payType = &#63;.
	*
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	*/
	public static PayComponent fetchBypayType_Last(String payType,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence().fetchBypayType_Last(payType, orderByComparator);
	}

	/**
	* Returns the pay components before and after the current pay component in the ordered set where payType = &#63;.
	*
	* @param componentId the primary key of the current pay component
	* @param payType the pay type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pay component
	* @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	*/
	public static PayComponent[] findBypayType_PrevAndNext(long componentId,
		String payType, OrderByComparator<PayComponent> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence()
				   .findBypayType_PrevAndNext(componentId, payType,
			orderByComparator);
	}

	/**
	* Removes all the pay components where payType = &#63; from the database.
	*
	* @param payType the pay type
	*/
	public static void removeBypayType(String payType) {
		getPersistence().removeBypayType(payType);
	}

	/**
	* Returns the number of pay components where payType = &#63;.
	*
	* @param payType the pay type
	* @return the number of matching pay components
	*/
	public static int countBypayType(String payType) {
		return getPersistence().countBypayType(payType);
	}

	/**
	* Caches the pay component in the entity cache if it is enabled.
	*
	* @param payComponent the pay component
	*/
	public static void cacheResult(PayComponent payComponent) {
		getPersistence().cacheResult(payComponent);
	}

	/**
	* Caches the pay components in the entity cache if it is enabled.
	*
	* @param payComponents the pay components
	*/
	public static void cacheResult(List<PayComponent> payComponents) {
		getPersistence().cacheResult(payComponents);
	}

	/**
	* Creates a new pay component with the primary key. Does not add the pay component to the database.
	*
	* @param componentId the primary key for the new pay component
	* @return the new pay component
	*/
	public static PayComponent create(long componentId) {
		return getPersistence().create(componentId);
	}

	/**
	* Removes the pay component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param componentId the primary key of the pay component
	* @return the pay component that was removed
	* @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	*/
	public static PayComponent remove(long componentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence().remove(componentId);
	}

	public static PayComponent updateImpl(PayComponent payComponent) {
		return getPersistence().updateImpl(payComponent);
	}

	/**
	* Returns the pay component with the primary key or throws a {@link NoSuchPayComponentException} if it could not be found.
	*
	* @param componentId the primary key of the pay component
	* @return the pay component
	* @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	*/
	public static PayComponent findByPrimaryKey(long componentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException {
		return getPersistence().findByPrimaryKey(componentId);
	}

	/**
	* Returns the pay component with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param componentId the primary key of the pay component
	* @return the pay component, or <code>null</code> if a pay component with the primary key could not be found
	*/
	public static PayComponent fetchByPrimaryKey(long componentId) {
		return getPersistence().fetchByPrimaryKey(componentId);
	}

	public static java.util.Map<java.io.Serializable, PayComponent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the pay components.
	*
	* @return the pay components
	*/
	public static List<PayComponent> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PayComponent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PayComponent> findAll(int start, int end,
		OrderByComparator<PayComponent> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PayComponent> findAll(int start, int end,
		OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the pay components from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of pay components.
	*
	* @return the number of pay components
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PayComponentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PayComponentPersistence, PayComponentPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PayComponentPersistence.class);

		ServiceTracker<PayComponentPersistence, PayComponentPersistence> serviceTracker =
			new ServiceTracker<PayComponentPersistence, PayComponentPersistence>(bundle.getBundleContext(),
				PayComponentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}