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

import com.liferay.famocom.erpcloud.model.AppraisalGoalMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the appraisal goal master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalGoalMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AppraisalGoalMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.AppraisalGoalMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class AppraisalGoalMasterUtil {
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
	public static void clearCache(AppraisalGoalMaster appraisalGoalMaster) {
		getPersistence().clearCache(appraisalGoalMaster);
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
	public static List<AppraisalGoalMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppraisalGoalMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppraisalGoalMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppraisalGoalMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppraisalGoalMaster update(
		AppraisalGoalMaster appraisalGoalMaster) {
		return getPersistence().update(appraisalGoalMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppraisalGoalMaster update(
		AppraisalGoalMaster appraisalGoalMaster, ServiceContext serviceContext) {
		return getPersistence().update(appraisalGoalMaster, serviceContext);
	}

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
	public static AppraisalGoalMaster findByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalGoalMasterException {
		return getPersistence()
				   .findByApprIdEmpIdProjIdEvalId(appraisalId, employeeId,
			projectId, evaluationId);
	}

	/**
	* Returns the appraisal goal master where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @return the matching appraisal goal master, or <code>null</code> if a matching appraisal goal master could not be found
	*/
	public static AppraisalGoalMaster fetchByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId) {
		return getPersistence()
				   .fetchByApprIdEmpIdProjIdEvalId(appraisalId, employeeId,
			projectId, evaluationId);
	}

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
	public static AppraisalGoalMaster fetchByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByApprIdEmpIdProjIdEvalId(appraisalId, employeeId,
			projectId, evaluationId, retrieveFromCache);
	}

	/**
	* Removes the appraisal goal master where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; from the database.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @return the appraisal goal master that was removed
	*/
	public static AppraisalGoalMaster removeByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalGoalMasterException {
		return getPersistence()
				   .removeByApprIdEmpIdProjIdEvalId(appraisalId, employeeId,
			projectId, evaluationId);
	}

	/**
	* Returns the number of appraisal goal masters where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63;.
	*
	* @param appraisalId the appraisal ID
	* @param employeeId the employee ID
	* @param projectId the project ID
	* @param evaluationId the evaluation ID
	* @return the number of matching appraisal goal masters
	*/
	public static int countByApprIdEmpIdProjIdEvalId(long appraisalId,
		long employeeId, long projectId, long evaluationId) {
		return getPersistence()
				   .countByApprIdEmpIdProjIdEvalId(appraisalId, employeeId,
			projectId, evaluationId);
	}

	/**
	* Caches the appraisal goal master in the entity cache if it is enabled.
	*
	* @param appraisalGoalMaster the appraisal goal master
	*/
	public static void cacheResult(AppraisalGoalMaster appraisalGoalMaster) {
		getPersistence().cacheResult(appraisalGoalMaster);
	}

	/**
	* Caches the appraisal goal masters in the entity cache if it is enabled.
	*
	* @param appraisalGoalMasters the appraisal goal masters
	*/
	public static void cacheResult(
		List<AppraisalGoalMaster> appraisalGoalMasters) {
		getPersistence().cacheResult(appraisalGoalMasters);
	}

	/**
	* Creates a new appraisal goal master with the primary key. Does not add the appraisal goal master to the database.
	*
	* @param appraisalGoalMasterId the primary key for the new appraisal goal master
	* @return the new appraisal goal master
	*/
	public static AppraisalGoalMaster create(long appraisalGoalMasterId) {
		return getPersistence().create(appraisalGoalMasterId);
	}

	/**
	* Removes the appraisal goal master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalMasterId the primary key of the appraisal goal master
	* @return the appraisal goal master that was removed
	* @throws NoSuchAppraisalGoalMasterException if a appraisal goal master with the primary key could not be found
	*/
	public static AppraisalGoalMaster remove(long appraisalGoalMasterId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalGoalMasterException {
		return getPersistence().remove(appraisalGoalMasterId);
	}

	public static AppraisalGoalMaster updateImpl(
		AppraisalGoalMaster appraisalGoalMaster) {
		return getPersistence().updateImpl(appraisalGoalMaster);
	}

	/**
	* Returns the appraisal goal master with the primary key or throws a {@link NoSuchAppraisalGoalMasterException} if it could not be found.
	*
	* @param appraisalGoalMasterId the primary key of the appraisal goal master
	* @return the appraisal goal master
	* @throws NoSuchAppraisalGoalMasterException if a appraisal goal master with the primary key could not be found
	*/
	public static AppraisalGoalMaster findByPrimaryKey(
		long appraisalGoalMasterId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchAppraisalGoalMasterException {
		return getPersistence().findByPrimaryKey(appraisalGoalMasterId);
	}

	/**
	* Returns the appraisal goal master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param appraisalGoalMasterId the primary key of the appraisal goal master
	* @return the appraisal goal master, or <code>null</code> if a appraisal goal master with the primary key could not be found
	*/
	public static AppraisalGoalMaster fetchByPrimaryKey(
		long appraisalGoalMasterId) {
		return getPersistence().fetchByPrimaryKey(appraisalGoalMasterId);
	}

	public static java.util.Map<java.io.Serializable, AppraisalGoalMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the appraisal goal masters.
	*
	* @return the appraisal goal masters
	*/
	public static List<AppraisalGoalMaster> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AppraisalGoalMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AppraisalGoalMaster> findAll(int start, int end,
		OrderByComparator<AppraisalGoalMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AppraisalGoalMaster> findAll(int start, int end,
		OrderByComparator<AppraisalGoalMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the appraisal goal masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of appraisal goal masters.
	*
	* @return the number of appraisal goal masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppraisalGoalMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AppraisalGoalMasterPersistence, AppraisalGoalMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AppraisalGoalMasterPersistence.class);

		ServiceTracker<AppraisalGoalMasterPersistence, AppraisalGoalMasterPersistence> serviceTracker =
			new ServiceTracker<AppraisalGoalMasterPersistence, AppraisalGoalMasterPersistence>(bundle.getBundleContext(),
				AppraisalGoalMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}