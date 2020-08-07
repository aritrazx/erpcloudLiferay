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

import com.liferay.famocom.erpcloud.model.FormSixteen;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the form sixteen service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.FormSixteenPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see FormSixteenPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.FormSixteenPersistenceImpl
 * @generated
 */
@ProviderType
public class FormSixteenUtil {
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
	public static void clearCache(FormSixteen formSixteen) {
		getPersistence().clearCache(formSixteen);
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
	public static List<FormSixteen> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FormSixteen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FormSixteen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FormSixteen> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FormSixteen update(FormSixteen formSixteen) {
		return getPersistence().update(formSixteen);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FormSixteen update(FormSixteen formSixteen,
		ServiceContext serviceContext) {
		return getPersistence().update(formSixteen, serviceContext);
	}

	/**
	* Returns all the form sixteens where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the matching form sixteens
	*/
	public static List<FormSixteen> findBygetForm(long employeeId,
		String financialYear) {
		return getPersistence().findBygetForm(employeeId, financialYear);
	}

	/**
	* Returns a range of all the form sixteens where employeeId = &#63; and financialYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param start the lower bound of the range of form sixteens
	* @param end the upper bound of the range of form sixteens (not inclusive)
	* @return the range of matching form sixteens
	*/
	public static List<FormSixteen> findBygetForm(long employeeId,
		String financialYear, int start, int end) {
		return getPersistence()
				   .findBygetForm(employeeId, financialYear, start, end);
	}

	/**
	* Returns an ordered range of all the form sixteens where employeeId = &#63; and financialYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param start the lower bound of the range of form sixteens
	* @param end the upper bound of the range of form sixteens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching form sixteens
	*/
	public static List<FormSixteen> findBygetForm(long employeeId,
		String financialYear, int start, int end,
		OrderByComparator<FormSixteen> orderByComparator) {
		return getPersistence()
				   .findBygetForm(employeeId, financialYear, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the form sixteens where employeeId = &#63; and financialYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param start the lower bound of the range of form sixteens
	* @param end the upper bound of the range of form sixteens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching form sixteens
	*/
	public static List<FormSixteen> findBygetForm(long employeeId,
		String financialYear, int start, int end,
		OrderByComparator<FormSixteen> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBygetForm(employeeId, financialYear, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form sixteen
	* @throws NoSuchFormSixteenException if a matching form sixteen could not be found
	*/
	public static FormSixteen findBygetForm_First(long employeeId,
		String financialYear, OrderByComparator<FormSixteen> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFormSixteenException {
		return getPersistence()
				   .findBygetForm_First(employeeId, financialYear,
			orderByComparator);
	}

	/**
	* Returns the first form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form sixteen, or <code>null</code> if a matching form sixteen could not be found
	*/
	public static FormSixteen fetchBygetForm_First(long employeeId,
		String financialYear, OrderByComparator<FormSixteen> orderByComparator) {
		return getPersistence()
				   .fetchBygetForm_First(employeeId, financialYear,
			orderByComparator);
	}

	/**
	* Returns the last form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form sixteen
	* @throws NoSuchFormSixteenException if a matching form sixteen could not be found
	*/
	public static FormSixteen findBygetForm_Last(long employeeId,
		String financialYear, OrderByComparator<FormSixteen> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFormSixteenException {
		return getPersistence()
				   .findBygetForm_Last(employeeId, financialYear,
			orderByComparator);
	}

	/**
	* Returns the last form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form sixteen, or <code>null</code> if a matching form sixteen could not be found
	*/
	public static FormSixteen fetchBygetForm_Last(long employeeId,
		String financialYear, OrderByComparator<FormSixteen> orderByComparator) {
		return getPersistence()
				   .fetchBygetForm_Last(employeeId, financialYear,
			orderByComparator);
	}

	/**
	* Returns the form sixteens before and after the current form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	*
	* @param id the primary key of the current form sixteen
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next form sixteen
	* @throws NoSuchFormSixteenException if a form sixteen with the primary key could not be found
	*/
	public static FormSixteen[] findBygetForm_PrevAndNext(long id,
		long employeeId, String financialYear,
		OrderByComparator<FormSixteen> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFormSixteenException {
		return getPersistence()
				   .findBygetForm_PrevAndNext(id, employeeId, financialYear,
			orderByComparator);
	}

	/**
	* Removes all the form sixteens where employeeId = &#63; and financialYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	*/
	public static void removeBygetForm(long employeeId, String financialYear) {
		getPersistence().removeBygetForm(employeeId, financialYear);
	}

	/**
	* Returns the number of form sixteens where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the number of matching form sixteens
	*/
	public static int countBygetForm(long employeeId, String financialYear) {
		return getPersistence().countBygetForm(employeeId, financialYear);
	}

	/**
	* Caches the form sixteen in the entity cache if it is enabled.
	*
	* @param formSixteen the form sixteen
	*/
	public static void cacheResult(FormSixteen formSixteen) {
		getPersistence().cacheResult(formSixteen);
	}

	/**
	* Caches the form sixteens in the entity cache if it is enabled.
	*
	* @param formSixteens the form sixteens
	*/
	public static void cacheResult(List<FormSixteen> formSixteens) {
		getPersistence().cacheResult(formSixteens);
	}

	/**
	* Creates a new form sixteen with the primary key. Does not add the form sixteen to the database.
	*
	* @param id the primary key for the new form sixteen
	* @return the new form sixteen
	*/
	public static FormSixteen create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the form sixteen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the form sixteen
	* @return the form sixteen that was removed
	* @throws NoSuchFormSixteenException if a form sixteen with the primary key could not be found
	*/
	public static FormSixteen remove(long id)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFormSixteenException {
		return getPersistence().remove(id);
	}

	public static FormSixteen updateImpl(FormSixteen formSixteen) {
		return getPersistence().updateImpl(formSixteen);
	}

	/**
	* Returns the form sixteen with the primary key or throws a {@link NoSuchFormSixteenException} if it could not be found.
	*
	* @param id the primary key of the form sixteen
	* @return the form sixteen
	* @throws NoSuchFormSixteenException if a form sixteen with the primary key could not be found
	*/
	public static FormSixteen findByPrimaryKey(long id)
		throws com.liferay.famocom.erpcloud.exception.NoSuchFormSixteenException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the form sixteen with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the form sixteen
	* @return the form sixteen, or <code>null</code> if a form sixteen with the primary key could not be found
	*/
	public static FormSixteen fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, FormSixteen> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the form sixteens.
	*
	* @return the form sixteens
	*/
	public static List<FormSixteen> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the form sixteens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form sixteens
	* @param end the upper bound of the range of form sixteens (not inclusive)
	* @return the range of form sixteens
	*/
	public static List<FormSixteen> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the form sixteens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form sixteens
	* @param end the upper bound of the range of form sixteens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of form sixteens
	*/
	public static List<FormSixteen> findAll(int start, int end,
		OrderByComparator<FormSixteen> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the form sixteens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form sixteens
	* @param end the upper bound of the range of form sixteens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of form sixteens
	*/
	public static List<FormSixteen> findAll(int start, int end,
		OrderByComparator<FormSixteen> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the form sixteens from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of form sixteens.
	*
	* @return the number of form sixteens
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FormSixteenPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FormSixteenPersistence, FormSixteenPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FormSixteenPersistence.class);

		ServiceTracker<FormSixteenPersistence, FormSixteenPersistence> serviceTracker =
			new ServiceTracker<FormSixteenPersistence, FormSixteenPersistence>(bundle.getBundleContext(),
				FormSixteenPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}