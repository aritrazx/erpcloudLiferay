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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalGoalMasterException;
import com.liferay.famocom.erpcloud.model.AppraisalGoalMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the appraisal goal master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalGoalMasterPersistenceImpl
 * @see AppraisalGoalMasterUtil
 * @generated
 */
@ProviderType
public interface AppraisalGoalMasterPersistence extends BasePersistence<AppraisalGoalMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalGoalMasterUtil} to access the appraisal goal master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the appraisal goal master where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; or throws a {@link NoSuchAppraisalGoalMasterException} if it could not be found.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @return the matching appraisal goal master
	* @throws NoSuchAppraisalGoalMasterException if a matching appraisal goal master could not be found
	*/
	public AppraisalGoalMaster findByApprIdEmpIdProjIdEvalId(long appraisalId,
		long employeeId, long projectId, long evaluationId)
		throws NoSuchAppraisalGoalMasterException;

	/**
	* Returns the appraisal goal master where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @return the matching appraisal goal master, or <code>null</code> if a matching appraisal goal master could not be found
	*/
	public AppraisalGoalMaster fetchByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId);

	/**
	* Returns the appraisal goal master where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal goal master, or <code>null</code> if a matching appraisal goal master could not be found
	*/
	public AppraisalGoalMaster fetchByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		boolean retrieveFromCache);

	/**
	* Removes the appraisal goal master where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; from the database.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @return the appraisal goal master that was removed
	*/
	public AppraisalGoalMaster removeByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId)
		throws NoSuchAppraisalGoalMasterException;

	/**
	* Returns the number of appraisal goal masters where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63;.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @return the number of matching appraisal goal masters
	*/
	public int countByApprIdEmpIdProjIdEvalId(long appraisalId,
		long employeeId, long projectId, long evaluationId);

	/**
	* Caches the appraisal goal master in the entity cache if it is enabled.
	*
	* @param appraisalGoalMaster the appraisal goal master
	*/
	public void cacheResult(AppraisalGoalMaster appraisalGoalMaster);

	/**
	* Caches the appraisal goal masters in the entity cache if it is enabled.
	*
	* @param appraisalGoalMasters the appraisal goal masters
	*/
	public void cacheResult(
		java.util.List<AppraisalGoalMaster> appraisalGoalMasters);

	/**
	* Creates a new appraisal goal master with the primary key. Does not add the appraisal goal master to the database.
	*
	* @param appraisalGoalMasterId the primary key for the new appraisal goal master
	* @return the new appraisal goal master
	*/
	public AppraisalGoalMaster create(long appraisalGoalMasterId);

	/**
	* Removes the appraisal goal master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalMasterId the primary key of the appraisal goal master
	* @return the appraisal goal master that was removed
	* @throws NoSuchAppraisalGoalMasterException if a appraisal goal master with the primary key could not be found
	*/
	public AppraisalGoalMaster remove(long appraisalGoalMasterId)
		throws NoSuchAppraisalGoalMasterException;

	public AppraisalGoalMaster updateImpl(
		AppraisalGoalMaster appraisalGoalMaster);

	/**
	* Returns the appraisal goal master with the primary key or throws a {@link NoSuchAppraisalGoalMasterException} if it could not be found.
	*
	* @param appraisalGoalMasterId the primary key of the appraisal goal master
	* @return the appraisal goal master
	* @throws NoSuchAppraisalGoalMasterException if a appraisal goal master with the primary key could not be found
	*/
	public AppraisalGoalMaster findByPrimaryKey(long appraisalGoalMasterId)
		throws NoSuchAppraisalGoalMasterException;

	/**
	* Returns the appraisal goal master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appraisalGoalMasterId the primary key of the appraisal goal master
	* @return the appraisal goal master, or <code>null</code> if a appraisal goal master with the primary key could not be found
	*/
	public AppraisalGoalMaster fetchByPrimaryKey(long appraisalGoalMasterId);

	@Override
	public java.util.Map<java.io.Serializable, AppraisalGoalMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the appraisal goal masters.
	*
	* @return the appraisal goal masters
	*/
	public java.util.List<AppraisalGoalMaster> findAll();

	/**
	* Returns a range of all the appraisal goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal goal masters
	* @param end the upper bound of the range of appraisal goal masters (not inclusive)
	* @return the range of appraisal goal masters
	*/
	public java.util.List<AppraisalGoalMaster> findAll(int start, int end);

	/**
	* Returns an ordered range of all the appraisal goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal goal masters
	* @param end the upper bound of the range of appraisal goal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of appraisal goal masters
	*/
	public java.util.List<AppraisalGoalMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalGoalMaster> orderByComparator);

	/**
	* Returns an ordered range of all the appraisal goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal goal masters
	* @param end the upper bound of the range of appraisal goal masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of appraisal goal masters
	*/
	public java.util.List<AppraisalGoalMaster> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalGoalMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the appraisal goal masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of appraisal goal masters.
	*
	* @return the number of appraisal goal masters
	*/
	public int countAll();
}