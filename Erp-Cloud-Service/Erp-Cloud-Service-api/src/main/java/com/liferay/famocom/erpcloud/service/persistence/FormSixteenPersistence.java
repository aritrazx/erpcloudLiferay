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

import com.liferay.famocom.erpcloud.exception.NoSuchFormSixteenException;
import com.liferay.famocom.erpcloud.model.FormSixteen;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the form sixteen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.FormSixteenPersistenceImpl
 * @see FormSixteenUtil
 * @generated
 */
@ProviderType
public interface FormSixteenPersistence extends BasePersistence<FormSixteen> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FormSixteenUtil} to access the form sixteen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the form sixteens where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the matching form sixteens
	*/
	public java.util.List<FormSixteen> findBygetForm(long employeeId,
		String financialYear);

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
	public java.util.List<FormSixteen> findBygetForm(long employeeId,
		String financialYear, int start, int end);

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
	public java.util.List<FormSixteen> findBygetForm(long employeeId,
		String financialYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSixteen> orderByComparator);

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
	public java.util.List<FormSixteen> findBygetForm(long employeeId,
		String financialYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSixteen> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form sixteen
	* @throws NoSuchFormSixteenException if a matching form sixteen could not be found
	*/
	public FormSixteen findBygetForm_First(long employeeId,
		String financialYear,
		com.liferay.portal.kernel.util.OrderByComparator<FormSixteen> orderByComparator)
		throws NoSuchFormSixteenException;

	/**
	* Returns the first form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form sixteen, or <code>null</code> if a matching form sixteen could not be found
	*/
	public FormSixteen fetchBygetForm_First(long employeeId,
		String financialYear,
		com.liferay.portal.kernel.util.OrderByComparator<FormSixteen> orderByComparator);

	/**
	* Returns the last form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form sixteen
	* @throws NoSuchFormSixteenException if a matching form sixteen could not be found
	*/
	public FormSixteen findBygetForm_Last(long employeeId,
		String financialYear,
		com.liferay.portal.kernel.util.OrderByComparator<FormSixteen> orderByComparator)
		throws NoSuchFormSixteenException;

	/**
	* Returns the last form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form sixteen, or <code>null</code> if a matching form sixteen could not be found
	*/
	public FormSixteen fetchBygetForm_Last(long employeeId,
		String financialYear,
		com.liferay.portal.kernel.util.OrderByComparator<FormSixteen> orderByComparator);

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
	public FormSixteen[] findBygetForm_PrevAndNext(long id, long employeeId,
		String financialYear,
		com.liferay.portal.kernel.util.OrderByComparator<FormSixteen> orderByComparator)
		throws NoSuchFormSixteenException;

	/**
	* Removes all the form sixteens where employeeId = &#63; and financialYear = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	*/
	public void removeBygetForm(long employeeId, String financialYear);

	/**
	* Returns the number of form sixteens where employeeId = &#63; and financialYear = &#63;.
	*
	* @param employeeId the employee ID
	* @param financialYear the financial year
	* @return the number of matching form sixteens
	*/
	public int countBygetForm(long employeeId, String financialYear);

	/**
	* Caches the form sixteen in the entity cache if it is enabled.
	*
	* @param formSixteen the form sixteen
	*/
	public void cacheResult(FormSixteen formSixteen);

	/**
	* Caches the form sixteens in the entity cache if it is enabled.
	*
	* @param formSixteens the form sixteens
	*/
	public void cacheResult(java.util.List<FormSixteen> formSixteens);

	/**
	* Creates a new form sixteen with the primary key. Does not add the form sixteen to the database.
	*
	* @param id the primary key for the new form sixteen
	* @return the new form sixteen
	*/
	public FormSixteen create(long id);

	/**
	* Removes the form sixteen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the form sixteen
	* @return the form sixteen that was removed
	* @throws NoSuchFormSixteenException if a form sixteen with the primary key could not be found
	*/
	public FormSixteen remove(long id) throws NoSuchFormSixteenException;

	public FormSixteen updateImpl(FormSixteen formSixteen);

	/**
	* Returns the form sixteen with the primary key or throws a {@link NoSuchFormSixteenException} if it could not be found.
	*
	* @param id the primary key of the form sixteen
	* @return the form sixteen
	* @throws NoSuchFormSixteenException if a form sixteen with the primary key could not be found
	*/
	public FormSixteen findByPrimaryKey(long id)
		throws NoSuchFormSixteenException;

	/**
	* Returns the form sixteen with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the form sixteen
	* @return the form sixteen, or <code>null</code> if a form sixteen with the primary key could not be found
	*/
	public FormSixteen fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, FormSixteen> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the form sixteens.
	*
	* @return the form sixteens
	*/
	public java.util.List<FormSixteen> findAll();

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
	public java.util.List<FormSixteen> findAll(int start, int end);

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
	public java.util.List<FormSixteen> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSixteen> orderByComparator);

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
	public java.util.List<FormSixteen> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FormSixteen> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the form sixteens from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of form sixteens.
	*
	* @return the number of form sixteens
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}