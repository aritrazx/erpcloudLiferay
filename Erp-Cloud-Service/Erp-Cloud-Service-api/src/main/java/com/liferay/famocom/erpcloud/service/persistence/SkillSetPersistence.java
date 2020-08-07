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

import com.liferay.famocom.erpcloud.exception.NoSuchSkillSetException;
import com.liferay.famocom.erpcloud.model.SkillSet;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the skill set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.SkillSetPersistenceImpl
 * @see SkillSetUtil
 * @generated
 */
@ProviderType
public interface SkillSetPersistence extends BasePersistence<SkillSet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SkillSetUtil} to access the skill set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the skill set in the entity cache if it is enabled.
	*
	* @param skillSet the skill set
	*/
	public void cacheResult(SkillSet skillSet);

	/**
	* Caches the skill sets in the entity cache if it is enabled.
	*
	* @param skillSets the skill sets
	*/
	public void cacheResult(java.util.List<SkillSet> skillSets);

	/**
	* Creates a new skill set with the primary key. Does not add the skill set to the database.
	*
	* @param SkillId the primary key for the new skill set
	* @return the new skill set
	*/
	public SkillSet create(long SkillId);

	/**
	* Removes the skill set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SkillId the primary key of the skill set
	* @return the skill set that was removed
	* @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	*/
	public SkillSet remove(long SkillId) throws NoSuchSkillSetException;

	public SkillSet updateImpl(SkillSet skillSet);

	/**
	* Returns the skill set with the primary key or throws a {@link NoSuchSkillSetException} if it could not be found.
	*
	* @param SkillId the primary key of the skill set
	* @return the skill set
	* @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	*/
	public SkillSet findByPrimaryKey(long SkillId)
		throws NoSuchSkillSetException;

	/**
	* Returns the skill set with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SkillId the primary key of the skill set
	* @return the skill set, or <code>null</code> if a skill set with the primary key could not be found
	*/
	public SkillSet fetchByPrimaryKey(long SkillId);

	@Override
	public java.util.Map<java.io.Serializable, SkillSet> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the skill sets.
	*
	* @return the skill sets
	*/
	public java.util.List<SkillSet> findAll();

	/**
	* Returns a range of all the skill sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skill sets
	* @param end the upper bound of the range of skill sets (not inclusive)
	* @return the range of skill sets
	*/
	public java.util.List<SkillSet> findAll(int start, int end);

	/**
	* Returns an ordered range of all the skill sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skill sets
	* @param end the upper bound of the range of skill sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of skill sets
	*/
	public java.util.List<SkillSet> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkillSet> orderByComparator);

	/**
	* Returns an ordered range of all the skill sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skill sets
	* @param end the upper bound of the range of skill sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of skill sets
	*/
	public java.util.List<SkillSet> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkillSet> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the skill sets from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of skill sets.
	*
	* @return the number of skill sets
	*/
	public int countAll();
}