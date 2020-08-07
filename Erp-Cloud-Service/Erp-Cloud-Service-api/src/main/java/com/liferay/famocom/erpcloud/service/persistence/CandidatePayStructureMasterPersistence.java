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

import com.liferay.famocom.erpcloud.exception.NoSuchCandidatePayStructureMasterException;
import com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the candidate pay structure master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.CandidatePayStructureMasterPersistenceImpl
 * @see CandidatePayStructureMasterUtil
 * @generated
 */
@ProviderType
public interface CandidatePayStructureMasterPersistence extends BasePersistence<CandidatePayStructureMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidatePayStructureMasterUtil} to access the candidate pay structure master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @return the matching candidate pay structure masters
	*/
	public java.util.List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus);

	/**
	* Returns a range of all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param start the lower bound of the range of candidate pay structure masters
	* @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	* @return the range of matching candidate pay structure masters
	*/
	public java.util.List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end);

	/**
	* Returns an ordered range of all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param start the lower bound of the range of candidate pay structure masters
	* @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate pay structure masters
	*/
	public java.util.List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidatePayStructureMaster> orderByComparator);

	/**
	* Returns an ordered range of all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param start the lower bound of the range of candidate pay structure masters
	* @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate pay structure masters
	*/
	public java.util.List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidatePayStructureMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate pay structure master
	* @throws NoSuchCandidatePayStructureMasterException if a matching candidate pay structure master could not be found
	*/
	public CandidatePayStructureMaster findByrecruitmentProcessIdAndPayMasterStatus_First(
		long recruitmentProcessId, int payMasterStatus,
		com.liferay.portal.kernel.util.OrderByComparator<CandidatePayStructureMaster> orderByComparator)
		throws NoSuchCandidatePayStructureMasterException;

	/**
	* Returns the first candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate pay structure master, or <code>null</code> if a matching candidate pay structure master could not be found
	*/
	public CandidatePayStructureMaster fetchByrecruitmentProcessIdAndPayMasterStatus_First(
		long recruitmentProcessId, int payMasterStatus,
		com.liferay.portal.kernel.util.OrderByComparator<CandidatePayStructureMaster> orderByComparator);

	/**
	* Returns the last candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate pay structure master
	* @throws NoSuchCandidatePayStructureMasterException if a matching candidate pay structure master could not be found
	*/
	public CandidatePayStructureMaster findByrecruitmentProcessIdAndPayMasterStatus_Last(
		long recruitmentProcessId, int payMasterStatus,
		com.liferay.portal.kernel.util.OrderByComparator<CandidatePayStructureMaster> orderByComparator)
		throws NoSuchCandidatePayStructureMasterException;

	/**
	* Returns the last candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate pay structure master, or <code>null</code> if a matching candidate pay structure master could not be found
	*/
	public CandidatePayStructureMaster fetchByrecruitmentProcessIdAndPayMasterStatus_Last(
		long recruitmentProcessId, int payMasterStatus,
		com.liferay.portal.kernel.util.OrderByComparator<CandidatePayStructureMaster> orderByComparator);

	/**
	* Returns the candidate pay structure masters before and after the current candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param candidatePayStructureMasterId the primary key of the current candidate pay structure master
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate pay structure master
	* @throws NoSuchCandidatePayStructureMasterException if a candidate pay structure master with the primary key could not be found
	*/
	public CandidatePayStructureMaster[] findByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(
		long candidatePayStructureMasterId, long recruitmentProcessId,
		int payMasterStatus,
		com.liferay.portal.kernel.util.OrderByComparator<CandidatePayStructureMaster> orderByComparator)
		throws NoSuchCandidatePayStructureMasterException;

	/**
	* Removes all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63; from the database.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	*/
	public void removeByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus);

	/**
	* Returns the number of candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @return the number of matching candidate pay structure masters
	*/
	public int countByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus);

	/**
	* Caches the candidate pay structure master in the entity cache if it is enabled.
	*
	* @param candidatePayStructureMaster the candidate pay structure master
	*/
	public void cacheResult(
		CandidatePayStructureMaster candidatePayStructureMaster);

	/**
	* Caches the candidate pay structure masters in the entity cache if it is enabled.
	*
	* @param candidatePayStructureMasters the candidate pay structure masters
	*/
	public void cacheResult(
		java.util.List<CandidatePayStructureMaster> candidatePayStructureMasters);

	/**
	* Creates a new candidate pay structure master with the primary key. Does not add the candidate pay structure master to the database.
	*
	* @param candidatePayStructureMasterId the primary key for the new candidate pay structure master
	* @return the new candidate pay structure master
	*/
	public CandidatePayStructureMaster create(
		long candidatePayStructureMasterId);

	/**
	* Removes the candidate pay structure master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidatePayStructureMasterId the primary key of the candidate pay structure master
	* @return the candidate pay structure master that was removed
	* @throws NoSuchCandidatePayStructureMasterException if a candidate pay structure master with the primary key could not be found
	*/
	public CandidatePayStructureMaster remove(
		long candidatePayStructureMasterId)
		throws NoSuchCandidatePayStructureMasterException;

	public CandidatePayStructureMaster updateImpl(
		CandidatePayStructureMaster candidatePayStructureMaster);

	/**
	* Returns the candidate pay structure master with the primary key or throws a {@link NoSuchCandidatePayStructureMasterException} if it could not be found.
	*
	* @param candidatePayStructureMasterId the primary key of the candidate pay structure master
	* @return the candidate pay structure master
	* @throws NoSuchCandidatePayStructureMasterException if a candidate pay structure master with the primary key could not be found
	*/
	public CandidatePayStructureMaster findByPrimaryKey(
		long candidatePayStructureMasterId)
		throws NoSuchCandidatePayStructureMasterException;

	/**
	* Returns the candidate pay structure master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidatePayStructureMasterId the primary key of the candidate pay structure master
	* @return the candidate pay structure master, or <code>null</code> if a candidate pay structure master with the primary key could not be found
	*/
	public CandidatePayStructureMaster fetchByPrimaryKey(
		long candidatePayStructureMasterId);

	@Override
	public java.util.Map<java.io.Serializable, CandidatePayStructureMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the candidate pay structure masters.
	*
	* @return the candidate pay structure masters
	*/
	public java.util.List<CandidatePayStructureMaster> findAll();

	/**
	* Returns a range of all the candidate pay structure masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate pay structure masters
	* @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	* @return the range of candidate pay structure masters
	*/
	public java.util.List<CandidatePayStructureMaster> findAll(int start,
		int end);

	/**
	* Returns an ordered range of all the candidate pay structure masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate pay structure masters
	* @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of candidate pay structure masters
	*/
	public java.util.List<CandidatePayStructureMaster> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidatePayStructureMaster> orderByComparator);

	/**
	* Returns an ordered range of all the candidate pay structure masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate pay structure masters
	* @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of candidate pay structure masters
	*/
	public java.util.List<CandidatePayStructureMaster> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidatePayStructureMaster> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the candidate pay structure masters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of candidate pay structure masters.
	*
	* @return the number of candidate pay structure masters
	*/
	public int countAll();
}