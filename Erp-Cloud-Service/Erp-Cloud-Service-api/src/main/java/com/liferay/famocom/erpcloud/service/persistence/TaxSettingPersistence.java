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

import com.liferay.famocom.erpcloud.exception.NoSuchTaxSettingException;
import com.liferay.famocom.erpcloud.model.TaxSetting;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the tax setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.TaxSettingPersistenceImpl
 * @see TaxSettingUtil
 * @generated
 */
@ProviderType
public interface TaxSettingPersistence extends BasePersistence<TaxSetting> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaxSettingUtil} to access the tax setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tax settings where componentId = &#63;.
	*
	* @param componentId the component ID
	* @return the matching tax settings
	*/
	public java.util.List<TaxSetting> findBycomponentId(long componentId);

	/**
	* Returns a range of all the tax settings where componentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentId the component ID
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @return the range of matching tax settings
	*/
	public java.util.List<TaxSetting> findBycomponentId(long componentId,
		int start, int end);

	/**
	* Returns an ordered range of all the tax settings where componentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentId the component ID
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tax settings
	*/
	public java.util.List<TaxSetting> findBycomponentId(long componentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxSetting> orderByComparator);

	/**
	* Returns an ordered range of all the tax settings where componentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentId the component ID
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tax settings
	*/
	public java.util.List<TaxSetting> findBycomponentId(long componentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxSetting> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tax setting in the ordered set where componentId = &#63;.
	*
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tax setting
	* @throws NoSuchTaxSettingException if a matching tax setting could not be found
	*/
	public TaxSetting findBycomponentId_First(long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<TaxSetting> orderByComparator)
		throws NoSuchTaxSettingException;

	/**
	* Returns the first tax setting in the ordered set where componentId = &#63;.
	*
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tax setting, or <code>null</code> if a matching tax setting could not be found
	*/
	public TaxSetting fetchBycomponentId_First(long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<TaxSetting> orderByComparator);

	/**
	* Returns the last tax setting in the ordered set where componentId = &#63;.
	*
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tax setting
	* @throws NoSuchTaxSettingException if a matching tax setting could not be found
	*/
	public TaxSetting findBycomponentId_Last(long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<TaxSetting> orderByComparator)
		throws NoSuchTaxSettingException;

	/**
	* Returns the last tax setting in the ordered set where componentId = &#63;.
	*
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tax setting, or <code>null</code> if a matching tax setting could not be found
	*/
	public TaxSetting fetchBycomponentId_Last(long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<TaxSetting> orderByComparator);

	/**
	* Returns the tax settings before and after the current tax setting in the ordered set where componentId = &#63;.
	*
	* @param taxSettingId the primary key of the current tax setting
	* @param componentId the component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tax setting
	* @throws NoSuchTaxSettingException if a tax setting with the primary key could not be found
	*/
	public TaxSetting[] findBycomponentId_PrevAndNext(long taxSettingId,
		long componentId,
		com.liferay.portal.kernel.util.OrderByComparator<TaxSetting> orderByComparator)
		throws NoSuchTaxSettingException;

	/**
	* Removes all the tax settings where componentId = &#63; from the database.
	*
	* @param componentId the component ID
	*/
	public void removeBycomponentId(long componentId);

	/**
	* Returns the number of tax settings where componentId = &#63;.
	*
	* @param componentId the component ID
	* @return the number of matching tax settings
	*/
	public int countBycomponentId(long componentId);

	/**
	* Caches the tax setting in the entity cache if it is enabled.
	*
	* @param taxSetting the tax setting
	*/
	public void cacheResult(TaxSetting taxSetting);

	/**
	* Caches the tax settings in the entity cache if it is enabled.
	*
	* @param taxSettings the tax settings
	*/
	public void cacheResult(java.util.List<TaxSetting> taxSettings);

	/**
	* Creates a new tax setting with the primary key. Does not add the tax setting to the database.
	*
	* @param taxSettingId the primary key for the new tax setting
	* @return the new tax setting
	*/
	public TaxSetting create(long taxSettingId);

	/**
	* Removes the tax setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxSettingId the primary key of the tax setting
	* @return the tax setting that was removed
	* @throws NoSuchTaxSettingException if a tax setting with the primary key could not be found
	*/
	public TaxSetting remove(long taxSettingId)
		throws NoSuchTaxSettingException;

	public TaxSetting updateImpl(TaxSetting taxSetting);

	/**
	* Returns the tax setting with the primary key or throws a {@link NoSuchTaxSettingException} if it could not be found.
	*
	* @param taxSettingId the primary key of the tax setting
	* @return the tax setting
	* @throws NoSuchTaxSettingException if a tax setting with the primary key could not be found
	*/
	public TaxSetting findByPrimaryKey(long taxSettingId)
		throws NoSuchTaxSettingException;

	/**
	* Returns the tax setting with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taxSettingId the primary key of the tax setting
	* @return the tax setting, or <code>null</code> if a tax setting with the primary key could not be found
	*/
	public TaxSetting fetchByPrimaryKey(long taxSettingId);

	@Override
	public java.util.Map<java.io.Serializable, TaxSetting> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tax settings.
	*
	* @return the tax settings
	*/
	public java.util.List<TaxSetting> findAll();

	/**
	* Returns a range of all the tax settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @return the range of tax settings
	*/
	public java.util.List<TaxSetting> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tax settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tax settings
	*/
	public java.util.List<TaxSetting> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxSetting> orderByComparator);

	/**
	* Returns an ordered range of all the tax settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tax settings
	* @param end the upper bound of the range of tax settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tax settings
	*/
	public java.util.List<TaxSetting> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaxSetting> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tax settings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tax settings.
	*
	* @return the number of tax settings
	*/
	public int countAll();
}