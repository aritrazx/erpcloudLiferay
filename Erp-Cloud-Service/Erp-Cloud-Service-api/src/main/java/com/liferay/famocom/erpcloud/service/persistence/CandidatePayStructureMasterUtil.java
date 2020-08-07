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

import com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the candidate pay structure master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.CandidatePayStructureMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see CandidatePayStructureMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.CandidatePayStructureMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class CandidatePayStructureMasterUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		CandidatePayStructureMaster candidatePayStructureMaster) {
		getPersistence().clearCache(candidatePayStructureMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CandidatePayStructureMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidatePayStructureMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidatePayStructureMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CandidatePayStructureMaster update(
		CandidatePayStructureMaster candidatePayStructureMaster) {
		return getPersistence().update(candidatePayStructureMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CandidatePayStructureMaster update(
		CandidatePayStructureMaster candidatePayStructureMaster,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(candidatePayStructureMaster, serviceContext);
	}

	/**
	* Returns all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @return the matching candidate pay structure masters
	*/
	public static List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus);
	}

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
	public static List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, start, end);
	}

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
	public static List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, start, end, orderByComparator);
	}

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
	public static List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate pay structure master
	* @throws NoSuchCandidatePayStructureMasterException if a matching candidate pay structure master could not be found
	*/
	public static CandidatePayStructureMaster findByrecruitmentProcessIdAndPayMasterStatus_First(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidatePayStructureMasterException {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus_First(recruitmentProcessId,
			payMasterStatus, orderByComparator);
	}

	/**
	* Returns the first candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate pay structure master, or <code>null</code> if a matching candidate pay structure master could not be found
	*/
	public static CandidatePayStructureMaster fetchByrecruitmentProcessIdAndPayMasterStatus_First(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator) {
		return getPersistence()
				   .fetchByrecruitmentProcessIdAndPayMasterStatus_First(recruitmentProcessId,
			payMasterStatus, orderByComparator);
	}

	/**
	* Returns the last candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate pay structure master
	* @throws NoSuchCandidatePayStructureMasterException if a matching candidate pay structure master could not be found
	*/
	public static CandidatePayStructureMaster findByrecruitmentProcessIdAndPayMasterStatus_Last(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidatePayStructureMasterException {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus_Last(recruitmentProcessId,
			payMasterStatus, orderByComparator);
	}

	/**
	* Returns the last candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate pay structure master, or <code>null</code> if a matching candidate pay structure master could not be found
	*/
	public static CandidatePayStructureMaster fetchByrecruitmentProcessIdAndPayMasterStatus_Last(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator) {
		return getPersistence()
				   .fetchByrecruitmentProcessIdAndPayMasterStatus_Last(recruitmentProcessId,
			payMasterStatus, orderByComparator);
	}

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
	public static CandidatePayStructureMaster[] findByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(
		long candidatePayStructureMasterId, long recruitmentProcessId,
		int payMasterStatus,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidatePayStructureMasterException {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(candidatePayStructureMasterId,
			recruitmentProcessId, payMasterStatus, orderByComparator);
	}

	/**
	* Removes all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63; from the database.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	*/
	public static void removeByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		getPersistence()
			.removeByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus);
	}

	/**
	* Returns the number of candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @return the number of matching candidate pay structure masters
	*/
	public static int countByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		return getPersistence()
				   .countByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus);
	}

	/**
	* Caches the candidate pay structure master in the entity cache if it is enabled.
	*
	* @param candidatePayStructureMaster the candidate pay structure master
	*/
	public static void cacheResult(
		CandidatePayStructureMaster candidatePayStructureMaster) {
		getPersistence().cacheResult(candidatePayStructureMaster);
	}

	/**
	* Caches the candidate pay structure masters in the entity cache if it is enabled.
	*
	* @param candidatePayStructureMasters the candidate pay structure masters
	*/
	public static void cacheResult(
		List<CandidatePayStructureMaster> candidatePayStructureMasters) {
		getPersistence().cacheResult(candidatePayStructureMasters);
	}

	/**
	* Creates a new candidate pay structure master with the primary key. Does not add the candidate pay structure master to the database.
	*
	* @param candidatePayStructureMasterId the primary key for the new candidate pay structure master
	* @return the new candidate pay structure master
	*/
	public static CandidatePayStructureMaster create(
		long candidatePayStructureMasterId) {
		return getPersistence().create(candidatePayStructureMasterId);
	}

	/**
	* Removes the candidate pay structure master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidatePayStructureMasterId the primary key of the candidate pay structure master
	* @return the candidate pay structure master that was removed
	* @throws NoSuchCandidatePayStructureMasterException if a candidate pay structure master with the primary key could not be found
	*/
	public static CandidatePayStructureMaster remove(
		long candidatePayStructureMasterId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidatePayStructureMasterException {
		return getPersistence().remove(candidatePayStructureMasterId);
	}

	public static CandidatePayStructureMaster updateImpl(
		CandidatePayStructureMaster candidatePayStructureMaster) {
		return getPersistence().updateImpl(candidatePayStructureMaster);
	}

	/**
	* Returns the candidate pay structure master with the primary key or throws a {@link NoSuchCandidatePayStructureMasterException} if it could not be found.
	*
	* @param candidatePayStructureMasterId the primary key of the candidate pay structure master
	* @return the candidate pay structure master
	* @throws NoSuchCandidatePayStructureMasterException if a candidate pay structure master with the primary key could not be found
	*/
	public static CandidatePayStructureMaster findByPrimaryKey(
		long candidatePayStructureMasterId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchCandidatePayStructureMasterException {
		return getPersistence().findByPrimaryKey(candidatePayStructureMasterId);
	}

	/**
	* Returns the candidate pay structure master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidatePayStructureMasterId the primary key of the candidate pay structure master
	* @return the candidate pay structure master, or <code>null</code> if a candidate pay structure master with the primary key could not be found
	*/
	public static CandidatePayStructureMaster fetchByPrimaryKey(
		long candidatePayStructureMasterId) {
		return getPersistence().fetchByPrimaryKey(candidatePayStructureMasterId);
	}

	public static java.util.Map<java.io.Serializable, CandidatePayStructureMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the candidate pay structure masters.
	*
	* @return the candidate pay structure masters
	*/
	public static List<CandidatePayStructureMaster> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<CandidatePayStructureMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<CandidatePayStructureMaster> findAll(int start, int end,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<CandidatePayStructureMaster> findAll(int start, int end,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the candidate pay structure masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of candidate pay structure masters.
	*
	* @return the number of candidate pay structure masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CandidatePayStructureMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CandidatePayStructureMasterPersistence, CandidatePayStructureMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CandidatePayStructureMasterPersistence.class);

		ServiceTracker<CandidatePayStructureMasterPersistence, CandidatePayStructureMasterPersistence> serviceTracker =
			new ServiceTracker<CandidatePayStructureMasterPersistence, CandidatePayStructureMasterPersistence>(bundle.getBundleContext(),
				CandidatePayStructureMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}