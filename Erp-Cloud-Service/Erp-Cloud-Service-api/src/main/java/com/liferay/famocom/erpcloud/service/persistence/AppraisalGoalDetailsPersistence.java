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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalGoalDetailsException;
import com.liferay.famocom.erpcloud.model.AppraisalGoalDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the appraisal goal details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalGoalDetailsPersistenceImpl
 * @see AppraisalGoalDetailsUtil
 * @generated
 */
@ProviderType
public interface AppraisalGoalDetailsPersistence extends BasePersistence<AppraisalGoalDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalGoalDetailsUtil} to access the appraisal goal details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the appraisal goal details where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; and goaldetailId = &#63; or throws a {@link NoSuchAppraisalGoalDetailsException} if it could not be found.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @param goaldetailId the goaldetail ID
	* @return the matching appraisal goal details
	* @throws NoSuchAppraisalGoalDetailsException if a matching appraisal goal details could not be found
	*/
	public AppraisalGoalDetails findByApprIdEmpIdProjIdEvalIdGoalDetId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		long goaldetailId) throws NoSuchAppraisalGoalDetailsException;

	/**
	* Returns the appraisal goal details where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; and goaldetailId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @param goaldetailId the goaldetail ID
	* @return the matching appraisal goal details, or <code>null</code> if a matching appraisal goal details could not be found
	*/
	public AppraisalGoalDetails fetchByApprIdEmpIdProjIdEvalIdGoalDetId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		long goaldetailId);

	/**
	* Returns the appraisal goal details where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; and goaldetailId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @param goaldetailId the goaldetail ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching appraisal goal details, or <code>null</code> if a matching appraisal goal details could not be found
	*/
	public AppraisalGoalDetails fetchByApprIdEmpIdProjIdEvalIdGoalDetId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		long goaldetailId, boolean retrieveFromCache);

	/**
	* Removes the appraisal goal details where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; and goaldetailId = &#63; from the database.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @param goaldetailId the goaldetail ID
	* @return the appraisal goal details that was removed
	*/
	public AppraisalGoalDetails removeByApprIdEmpIdProjIdEvalIdGoalDetId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		long goaldetailId) throws NoSuchAppraisalGoalDetailsException;

	/**
	* Returns the number of appraisal goal detailses where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; and goaldetailId = &#63;.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @param goaldetailId the goaldetail ID
	* @return the number of matching appraisal goal detailses
	*/
	public int countByApprIdEmpIdProjIdEvalIdGoalDetId(long appraisalId,
		long employeeId, long projectId, long evaluationId, long goaldetailId);

	/**
	* Caches the appraisal goal details in the entity cache if it is enabled.
	*
	* @param appraisalGoalDetails the appraisal goal details
	*/
	public void cacheResult(AppraisalGoalDetails appraisalGoalDetails);

	/**
	* Caches the appraisal goal detailses in the entity cache if it is enabled.
	*
	* @param appraisalGoalDetailses the appraisal goal detailses
	*/
	public void cacheResult(
		java.util.List<AppraisalGoalDetails> appraisalGoalDetailses);

	/**
	* Creates a new appraisal goal details with the primary key. Does not add the appraisal goal details to the database.
	*
	* @param appraisalGoalDetailsId the primary key for the new appraisal goal details
	* @return the new appraisal goal details
	*/
	public AppraisalGoalDetails create(long appraisalGoalDetailsId);

	/**
	* Removes the appraisal goal details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalDetailsId the primary key of the appraisal goal details
	* @return the appraisal goal details that was removed
	* @throws NoSuchAppraisalGoalDetailsException if a appraisal goal details with the primary key could not be found
	*/
	public AppraisalGoalDetails remove(long appraisalGoalDetailsId)
		throws NoSuchAppraisalGoalDetailsException;

	public AppraisalGoalDetails updateImpl(
		AppraisalGoalDetails appraisalGoalDetails);

	/**
	* Returns the appraisal goal details with the primary key or throws a {@link NoSuchAppraisalGoalDetailsException} if it could not be found.
	*
	* @param appraisalGoalDetailsId the primary key of the appraisal goal details
	* @return the appraisal goal details
	* @throws NoSuchAppraisalGoalDetailsException if a appraisal goal details with the primary key could not be found
	*/
	public AppraisalGoalDetails findByPrimaryKey(long appraisalGoalDetailsId)
		throws NoSuchAppraisalGoalDetailsException;

	/**
	* Returns the appraisal goal details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appraisalGoalDetailsId the primary key of the appraisal goal details
	* @return the appraisal goal details, or <code>null</code> if a appraisal goal details with the primary key could not be found
	*/
	public AppraisalGoalDetails fetchByPrimaryKey(long appraisalGoalDetailsId);

	@Override
	public java.util.Map<java.io.Serializable, AppraisalGoalDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the appraisal goal detailses.
	*
	* @return the appraisal goal detailses
	*/
	public java.util.List<AppraisalGoalDetails> findAll();

	/**
	* Returns a range of all the appraisal goal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal goal detailses
	* @param end the upper bound of the range of appraisal goal detailses (not inclusive)
	* @return the range of appraisal goal detailses
	*/
	public java.util.List<AppraisalGoalDetails> findAll(int start, int end);

	/**
	* Returns an ordered range of all the appraisal goal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal goal detailses
	* @param end the upper bound of the range of appraisal goal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of appraisal goal detailses
	*/
	public java.util.List<AppraisalGoalDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalGoalDetails> orderByComparator);

	/**
	* Returns an ordered range of all the appraisal goal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal goal detailses
	* @param end the upper bound of the range of appraisal goal detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of appraisal goal detailses
	*/
	public java.util.List<AppraisalGoalDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalGoalDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the appraisal goal detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of appraisal goal detailses.
	*
	* @return the number of appraisal goal detailses
	*/
	public int countAll();
}