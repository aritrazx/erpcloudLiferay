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

import com.liferay.famocom.erpcloud.exception.NoSuchExpCategoryException;
import com.liferay.famocom.erpcloud.model.ExpCategory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the exp category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.ExpCategoryPersistenceImpl
 * @see ExpCategoryUtil
 * @generated
 */
@ProviderType
public interface ExpCategoryPersistence extends BasePersistence<ExpCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExpCategoryUtil} to access the exp category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the exp category in the entity cache if it is enabled.
	*
	* @param expCategory the exp category
	*/
	public void cacheResult(ExpCategory expCategory);

	/**
	* Caches the exp categories in the entity cache if it is enabled.
	*
	* @param expCategories the exp categories
	*/
	public void cacheResult(java.util.List<ExpCategory> expCategories);

	/**
	* Creates a new exp category with the primary key. Does not add the exp category to the database.
	*
	* @param catId the primary key for the new exp category
	* @return the new exp category
	*/
	public ExpCategory create(long catId);

	/**
	* Removes the exp category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catId the primary key of the exp category
	* @return the exp category that was removed
	* @throws NoSuchExpCategoryException if a exp category with the primary key could not be found
	*/
	public ExpCategory remove(long catId) throws NoSuchExpCategoryException;

	public ExpCategory updateImpl(ExpCategory expCategory);

	/**
	* Returns the exp category with the primary key or throws a {@link NoSuchExpCategoryException} if it could not be found.
	*
	* @param catId the primary key of the exp category
	* @return the exp category
	* @throws NoSuchExpCategoryException if a exp category with the primary key could not be found
	*/
	public ExpCategory findByPrimaryKey(long catId)
		throws NoSuchExpCategoryException;

	/**
	* Returns the exp category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param catId the primary key of the exp category
	* @return the exp category, or <code>null</code> if a exp category with the primary key could not be found
	*/
	public ExpCategory fetchByPrimaryKey(long catId);

	@Override
	public java.util.Map<java.io.Serializable, ExpCategory> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the exp categories.
	*
	* @return the exp categories
	*/
	public java.util.List<ExpCategory> findAll();

	/**
	* Returns a range of all the exp categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp categories
	* @param end the upper bound of the range of exp categories (not inclusive)
	* @return the range of exp categories
	*/
	public java.util.List<ExpCategory> findAll(int start, int end);

	/**
	* Returns an ordered range of all the exp categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp categories
	* @param end the upper bound of the range of exp categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of exp categories
	*/
	public java.util.List<ExpCategory> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpCategory> orderByComparator);

	/**
	* Returns an ordered range of all the exp categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp categories
	* @param end the upper bound of the range of exp categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of exp categories
	*/
	public java.util.List<ExpCategory> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpCategory> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the exp categories from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of exp categories.
	*
	* @return the number of exp categories
	*/
	public int countAll();
}