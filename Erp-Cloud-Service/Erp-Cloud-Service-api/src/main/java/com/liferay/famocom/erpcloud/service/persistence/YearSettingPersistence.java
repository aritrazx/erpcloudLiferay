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

import com.liferay.famocom.erpcloud.exception.NoSuchYearSettingException;
import com.liferay.famocom.erpcloud.model.YearSetting;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the year setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.YearSettingPersistenceImpl
 * @see YearSettingUtil
 * @generated
 */
@ProviderType
public interface YearSettingPersistence extends BasePersistence<YearSetting> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link YearSettingUtil} to access the year setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the year setting where isActive = &#63; or throws a {@link NoSuchYearSettingException} if it could not be found.
	*
	* @param isActive the is active
	* @return the matching year setting
	* @throws NoSuchYearSettingException if a matching year setting could not be found
	*/
	public YearSetting findByisActive(int isActive)
		throws NoSuchYearSettingException;

	/**
	* Returns the year setting where isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param isActive the is active
	* @return the matching year setting, or <code>null</code> if a matching year setting could not be found
	*/
	public YearSetting fetchByisActive(int isActive);

	/**
	* Returns the year setting where isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param isActive the is active
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching year setting, or <code>null</code> if a matching year setting could not be found
	*/
	public YearSetting fetchByisActive(int isActive, boolean retrieveFromCache);

	/**
	* Removes the year setting where isActive = &#63; from the database.
	*
	* @param isActive the is active
	* @return the year setting that was removed
	*/
	public YearSetting removeByisActive(int isActive)
		throws NoSuchYearSettingException;

	/**
	* Returns the number of year settings where isActive = &#63;.
	*
	* @param isActive the is active
	* @return the number of matching year settings
	*/
	public int countByisActive(int isActive);

	/**
	* Caches the year setting in the entity cache if it is enabled.
	*
	* @param yearSetting the year setting
	*/
	public void cacheResult(YearSetting yearSetting);

	/**
	* Caches the year settings in the entity cache if it is enabled.
	*
	* @param yearSettings the year settings
	*/
	public void cacheResult(java.util.List<YearSetting> yearSettings);

	/**
	* Creates a new year setting with the primary key. Does not add the year setting to the database.
	*
	* @param yearSettingId the primary key for the new year setting
	* @return the new year setting
	*/
	public YearSetting create(long yearSettingId);

	/**
	* Removes the year setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param yearSettingId the primary key of the year setting
	* @return the year setting that was removed
	* @throws NoSuchYearSettingException if a year setting with the primary key could not be found
	*/
	public YearSetting remove(long yearSettingId)
		throws NoSuchYearSettingException;

	public YearSetting updateImpl(YearSetting yearSetting);

	/**
	* Returns the year setting with the primary key or throws a {@link NoSuchYearSettingException} if it could not be found.
	*
	* @param yearSettingId the primary key of the year setting
	* @return the year setting
	* @throws NoSuchYearSettingException if a year setting with the primary key could not be found
	*/
	public YearSetting findByPrimaryKey(long yearSettingId)
		throws NoSuchYearSettingException;

	/**
	* Returns the year setting with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param yearSettingId the primary key of the year setting
	* @return the year setting, or <code>null</code> if a year setting with the primary key could not be found
	*/
	public YearSetting fetchByPrimaryKey(long yearSettingId);

	@Override
	public java.util.Map<java.io.Serializable, YearSetting> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the year settings.
	*
	* @return the year settings
	*/
	public java.util.List<YearSetting> findAll();

	/**
	* Returns a range of all the year settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of year settings
	* @param end the upper bound of the range of year settings (not inclusive)
	* @return the range of year settings
	*/
	public java.util.List<YearSetting> findAll(int start, int end);

	/**
	* Returns an ordered range of all the year settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of year settings
	* @param end the upper bound of the range of year settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of year settings
	*/
	public java.util.List<YearSetting> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<YearSetting> orderByComparator);

	/**
	* Returns an ordered range of all the year settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of year settings
	* @param end the upper bound of the range of year settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of year settings
	*/
	public java.util.List<YearSetting> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<YearSetting> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the year settings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of year settings.
	*
	* @return the number of year settings
	*/
	public int countAll();
}