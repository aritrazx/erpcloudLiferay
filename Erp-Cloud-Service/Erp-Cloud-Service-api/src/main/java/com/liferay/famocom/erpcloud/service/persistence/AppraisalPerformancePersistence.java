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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalPerformanceException;
import com.liferay.famocom.erpcloud.model.AppraisalPerformance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the appraisal performance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalPerformancePersistenceImpl
 * @see AppraisalPerformanceUtil
 * @generated
 */
@ProviderType
public interface AppraisalPerformancePersistence extends BasePersistence<AppraisalPerformance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalPerformanceUtil} to access the appraisal performance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; or throws a {@link NoSuchAppraisalPerformanceException} if it could not be found.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the matching appraisal performance
	* @throws NoSuchAppraisalPerformanceException if a matching appraisal performance could not be found
	*/
	public AppraisalPerformance findByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId)
		throws NoSuchAppraisalPerformanceException;

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	*/
	public AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId);

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	*/
	public AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId,
		boolean retrieveFromCache);

	/**
	* Removes the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; from the database.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the appraisal performance that was removed
	*/
	public AppraisalPerformance removeByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId)
		throws NoSuchAppraisalPerformanceException;

	/**
	* Returns the number of appraisal performances where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the number of matching appraisal performances
	*/
	public int countByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId);

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; or throws a {@link NoSuchAppraisalPerformanceException} if it could not be found.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param performanceId the performance ID
	* @return the matching appraisal performance
	* @throws NoSuchAppraisalPerformanceException if a matching appraisal performance could not be found
	*/
	public AppraisalPerformance findByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId) throws NoSuchAppraisalPerformanceException;

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param performanceId the performance ID
	* @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	*/
	public AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId);

	/**
	* Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param performanceId the performance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	*/
	public AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId, boolean retrieveFromCache);

	/**
	* Removes the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; from the database.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param performanceId the performance ID
	* @return the appraisal performance that was removed
	*/
	public AppraisalPerformance removeByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId) throws NoSuchAppraisalPerformanceException;

	/**
	* Returns the number of appraisal performances where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63;.
	*
	* @param appraisalId the appraisal ID
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param performanceId the performance ID
	* @return the number of matching appraisal performances
	*/
	public int countByApprIdSettingIdAndEmployeeIdPerformId(long appraisalId,
		long appraisalSettingId, long employeeId, long performanceId);

	/**
	* Caches the appraisal performance in the entity cache if it is enabled.
	*
	* @param appraisalPerformance the appraisal performance
	*/
	public void cacheResult(AppraisalPerformance appraisalPerformance);

	/**
	* Caches the appraisal performances in the entity cache if it is enabled.
	*
	* @param appraisalPerformances the appraisal performances
	*/
	public void cacheResult(
		java.util.List<AppraisalPerformance> appraisalPerformances);

	/**
	* Creates a new appraisal performance with the primary key. Does not add the appraisal performance to the database.
	*
	* @param appraisalPerformanceId the primary key for the new appraisal performance
	* @return the new appraisal performance
	*/
	public AppraisalPerformance create(long appraisalPerformanceId);

	/**
	* Removes the appraisal performance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalPerformanceId the primary key of the appraisal performance
	* @return the appraisal performance that was removed
	* @throws NoSuchAppraisalPerformanceException if a appraisal performance with the primary key could not be found
	*/
	public AppraisalPerformance remove(long appraisalPerformanceId)
		throws NoSuchAppraisalPerformanceException;

	public AppraisalPerformance updateImpl(
		AppraisalPerformance appraisalPerformance);

	/**
	* Returns the appraisal performance with the primary key or throws a {@link NoSuchAppraisalPerformanceException} if it could not be found.
	*
	* @param appraisalPerformanceId the primary key of the appraisal performance
	* @return the appraisal performance
	* @throws NoSuchAppraisalPerformanceException if a appraisal performance with the primary key could not be found
	*/
	public AppraisalPerformance findByPrimaryKey(long appraisalPerformanceId)
		throws NoSuchAppraisalPerformanceException;

	/**
	* Returns the appraisal performance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appraisalPerformanceId the primary key of the appraisal performance
	* @return the appraisal performance, or <code>null</code> if a appraisal performance with the primary key could not be found
	*/
	public AppraisalPerformance fetchByPrimaryKey(long appraisalPerformanceId);

	@Override
	public java.util.Map<java.io.Serializable, AppraisalPerformance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the appraisal performances.
	*
	* @return the appraisal performances
	*/
	public java.util.List<AppraisalPerformance> findAll();

	/**
	* Returns a range of all the appraisal performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal performances
	* @param end the upper bound of the range of appraisal performances (not inclusive)
	* @return the range of appraisal performances
	*/
	public java.util.List<AppraisalPerformance> findAll(int start, int end);

	/**
	* Returns an ordered range of all the appraisal performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal performances
	* @param end the upper bound of the range of appraisal performances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of appraisal performances
	*/
	public java.util.List<AppraisalPerformance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalPerformance> orderByComparator);

	/**
	* Returns an ordered range of all the appraisal performances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal performances
	* @param end the upper bound of the range of appraisal performances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of appraisal performances
	*/
	public java.util.List<AppraisalPerformance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalPerformance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the appraisal performances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of appraisal performances.
	*
	* @return the number of appraisal performances
	*/
	public int countAll();
}