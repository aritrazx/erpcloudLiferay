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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalMasterException;
import com.liferay.famocom.erpcloud.model.AppraisalMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the appraisal master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalMasterPersistenceImpl
 * @see AppraisalMasterUtil
 * @generated
 */
@ProviderType
public interface AppraisalMasterPersistence extends BasePersistence<AppraisalMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalMasterUtil} to access the appraisal master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; or throws a {@link NoSuchAppraisalMasterException} if it could not be found.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the matching appraisal master
	* @throws NoSuchAppraisalMasterException if a matching appraisal master could not be found
	*/
	public AppraisalMaster findBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId)
		throws NoSuchAppraisalMasterException;

	/**
	* Returns the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	*/
	public AppraisalMaster fetchBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId);

	/**
	* Returns the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	*/
	public AppraisalMaster fetchBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, boolean retrieveFromCache);

	/**
	* Removes the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the appraisal master that was removed
	*/
	public AppraisalMaster removeBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId)
		throws NoSuchAppraisalMasterException;

	/**
	* Returns the number of appraisal masters where appraisalSettingId = &#63; and employeeId = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param employeeId the employee ID
	* @return the number of matching appraisal masters
	*/
	public int countBySettingIdAndEmployeeId(long appraisalSettingId,
		long employeeId);

	/**
	* Returns all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @return the matching appraisal masters
	*/
	public java.util.List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep);

	/**
	* Returns a range of all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @return the range of matching appraisal masters
	*/
	public java.util.List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep, int start, int end);

	/**
	* Returns an ordered range of all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching appraisal masters
	*/
	public java.util.List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMaster> orderByComparator);

	/**
	* Returns an ordered range of all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching appraisal masters
	*/
	public java.util.List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal master
	* @throws NoSuchAppraisalMasterException if a matching appraisal master could not be found
	*/
	public AppraisalMaster findBySettingIdAndsubmitStep_First(
		long appraisalSettingId, long submitStep,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMaster> orderByComparator)
		throws NoSuchAppraisalMasterException;

	/**
	* Returns the first appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	*/
	public AppraisalMaster fetchBySettingIdAndsubmitStep_First(
		long appraisalSettingId, long submitStep,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMaster> orderByComparator);

	/**
	* Returns the last appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal master
	* @throws NoSuchAppraisalMasterException if a matching appraisal master could not be found
	*/
	public AppraisalMaster findBySettingIdAndsubmitStep_Last(
		long appraisalSettingId, long submitStep,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMaster> orderByComparator)
		throws NoSuchAppraisalMasterException;

	/**
	* Returns the last appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	*/
	public AppraisalMaster fetchBySettingIdAndsubmitStep_Last(
		long appraisalSettingId, long submitStep,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMaster> orderByComparator);

	/**
	* Returns the appraisal masters before and after the current appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalId the primary key of the current appraisal master
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next appraisal master
	* @throws NoSuchAppraisalMasterException if a appraisal master with the primary key could not be found
	*/
	public AppraisalMaster[] findBySettingIdAndsubmitStep_PrevAndNext(
		long appraisalId, long appraisalSettingId, long submitStep,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMaster> orderByComparator)
		throws NoSuchAppraisalMasterException;

	/**
	* Removes all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63; from the database.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	*/
	public void removeBySettingIdAndsubmitStep(long appraisalSettingId,
		long submitStep);

	/**
	* Returns the number of appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	*
	* @param appraisalSettingId the appraisal setting ID
	* @param submitStep the submit step
	* @return the number of matching appraisal masters
	*/
	public int countBySettingIdAndsubmitStep(long appraisalSettingId,
		long submitStep);

	/**
	* Caches the appraisal master in the entity cache if it is enabled.
	*
	* @param appraisalMaster the appraisal master
	*/
	public void cacheResult(AppraisalMaster appraisalMaster);

	/**
	* Caches the appraisal masters in the entity cache if it is enabled.
	*
	* @param appraisalMasters the appraisal masters
	*/
	public void cacheResult(java.util.List<AppraisalMaster> appraisalMasters);

	/**
	* Creates a new appraisal master with the primary key. Does not add the appraisal master to the database.
	*
	* @param appraisalId the primary key for the new appraisal master
	* @return the new appraisal master
	*/
	public AppraisalMaster create(long appraisalId);

	/**
	* Removes the appraisal master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalId the primary key of the appraisal master
	* @return the appraisal master that was removed
	* @throws NoSuchAppraisalMasterException if a appraisal master with the primary key could not be found
	*/
	public AppraisalMaster remove(long appraisalId)
		throws NoSuchAppraisalMasterException;

	public AppraisalMaster updateImpl(AppraisalMaster appraisalMaster);

	/**
	* Returns the appraisal master with the primary key or throws a {@link NoSuchAppraisalMasterException} if it could not be found.
	*
	* @param appraisalId the primary key of the appraisal master
	* @return the appraisal master
	* @throws NoSuchAppraisalMasterException if a appraisal master with the primary key could not be found
	*/
	public AppraisalMaster findByPrimaryKey(long appraisalId)
		throws NoSuchAppraisalMasterException;

	/**
	* Returns the appraisal master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appraisalId the primary key of the appraisal master
	* @return the appraisal master, or <code>null</code> if a appraisal master with the primary key could not be found
	*/
	public AppraisalMaster fetchByPrimaryKey(long appraisalId);

	@Override
	public java.util.Map<java.io.Serializable, AppraisalMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the appraisal masters.
	*
	* @return the appraisal masters
	*/
	public java.util.List<AppraisalMaster> findAll();

	/**
	* Returns a range of all the appraisal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @return the range of appraisal masters
	*/
	public java.util.List<AppraisalMaster> findAll(int start, int end);

	/**
	* Returns an ordered range of all the appraisal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of appraisal masters
	*/
	public java.util.List<AppraisalMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMaster> orderByComparator);

	/**
	* Returns an ordered range of all the appraisal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal masters
	* @param end the upper bound of the range of appraisal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of appraisal masters
	*/
	public java.util.List<AppraisalMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the appraisal masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of appraisal masters.
	*
	* @return the number of appraisal masters
	*/
	public int countAll();
}