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

import com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the selected candidate pay structure master service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.SelectedCandidatePayStructureMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SelectedCandidatePayStructureMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.SelectedCandidatePayStructureMasterPersistenceImpl
 * @generated
 */
@ProviderType
public class SelectedCandidatePayStructureMasterUtil {
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
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		getPersistence().clearCache(selectedCandidatePayStructureMaster);
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
	public static List<SelectedCandidatePayStructureMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SelectedCandidatePayStructureMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SelectedCandidatePayStructureMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SelectedCandidatePayStructureMaster update(
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		return getPersistence().update(selectedCandidatePayStructureMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SelectedCandidatePayStructureMaster update(
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(selectedCandidatePayStructureMaster, serviceContext);
	}

	/**
	* Returns all the selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @return the matching selected candidate pay structure masters
	*/
	public static List<SelectedCandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus);
	}

	/**
	* Returns a range of all the selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param start the lower bound of the range of selected candidate pay structure masters
	* @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	* @return the range of matching selected candidate pay structure masters
	*/
	public static List<SelectedCandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, start, end);
	}

	/**
	* Returns an ordered range of all the selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param start the lower bound of the range of selected candidate pay structure masters
	* @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching selected candidate pay structure masters
	*/
	public static List<SelectedCandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param start the lower bound of the range of selected candidate pay structure masters
	* @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching selected candidate pay structure masters
	*/
	public static List<SelectedCandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first selected candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching selected candidate pay structure master
	* @throws NoSuchSelectedCandidatePayStructureMasterException if a matching selected candidate pay structure master could not be found
	*/
	public static SelectedCandidatePayStructureMaster findByrecruitmentProcessIdAndPayMasterStatus_First(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureMasterException {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus_First(recruitmentProcessId,
			payMasterStatus, orderByComparator);
	}

	/**
	* Returns the first selected candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching selected candidate pay structure master, or <code>null</code> if a matching selected candidate pay structure master could not be found
	*/
	public static SelectedCandidatePayStructureMaster fetchByrecruitmentProcessIdAndPayMasterStatus_First(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator) {
		return getPersistence()
				   .fetchByrecruitmentProcessIdAndPayMasterStatus_First(recruitmentProcessId,
			payMasterStatus, orderByComparator);
	}

	/**
	* Returns the last selected candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching selected candidate pay structure master
	* @throws NoSuchSelectedCandidatePayStructureMasterException if a matching selected candidate pay structure master could not be found
	*/
	public static SelectedCandidatePayStructureMaster findByrecruitmentProcessIdAndPayMasterStatus_Last(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureMasterException {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus_Last(recruitmentProcessId,
			payMasterStatus, orderByComparator);
	}

	/**
	* Returns the last selected candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching selected candidate pay structure master, or <code>null</code> if a matching selected candidate pay structure master could not be found
	*/
	public static SelectedCandidatePayStructureMaster fetchByrecruitmentProcessIdAndPayMasterStatus_Last(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator) {
		return getPersistence()
				   .fetchByrecruitmentProcessIdAndPayMasterStatus_Last(recruitmentProcessId,
			payMasterStatus, orderByComparator);
	}

	/**
	* Returns the selected candidate pay structure masters before and after the current selected candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param candidatePayStructureMasterId the primary key of the current selected candidate pay structure master
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next selected candidate pay structure master
	* @throws NoSuchSelectedCandidatePayStructureMasterException if a selected candidate pay structure master with the primary key could not be found
	*/
	public static SelectedCandidatePayStructureMaster[] findByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(
		long candidatePayStructureMasterId, long recruitmentProcessId,
		int payMasterStatus,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureMasterException {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(candidatePayStructureMasterId,
			recruitmentProcessId, payMasterStatus, orderByComparator);
	}

	/**
	* Removes all the selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63; from the database.
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
	* Returns the number of selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payMasterStatus the pay master status
	* @return the number of matching selected candidate pay structure masters
	*/
	public static int countByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		return getPersistence()
				   .countByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus);
	}

	/**
	* Caches the selected candidate pay structure master in the entity cache if it is enabled.
	*
	* @param selectedCandidatePayStructureMaster the selected candidate pay structure master
	*/
	public static void cacheResult(
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		getPersistence().cacheResult(selectedCandidatePayStructureMaster);
	}

	/**
	* Caches the selected candidate pay structure masters in the entity cache if it is enabled.
	*
	* @param selectedCandidatePayStructureMasters the selected candidate pay structure masters
	*/
	public static void cacheResult(
		List<SelectedCandidatePayStructureMaster> selectedCandidatePayStructureMasters) {
		getPersistence().cacheResult(selectedCandidatePayStructureMasters);
	}

	/**
	* Creates a new selected candidate pay structure master with the primary key. Does not add the selected candidate pay structure master to the database.
	*
	* @param candidatePayStructureMasterId the primary key for the new selected candidate pay structure master
	* @return the new selected candidate pay structure master
	*/
	public static SelectedCandidatePayStructureMaster create(
		long candidatePayStructureMasterId) {
		return getPersistence().create(candidatePayStructureMasterId);
	}

	/**
	* Removes the selected candidate pay structure master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidatePayStructureMasterId the primary key of the selected candidate pay structure master
	* @return the selected candidate pay structure master that was removed
	* @throws NoSuchSelectedCandidatePayStructureMasterException if a selected candidate pay structure master with the primary key could not be found
	*/
	public static SelectedCandidatePayStructureMaster remove(
		long candidatePayStructureMasterId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureMasterException {
		return getPersistence().remove(candidatePayStructureMasterId);
	}

	public static SelectedCandidatePayStructureMaster updateImpl(
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		return getPersistence().updateImpl(selectedCandidatePayStructureMaster);
	}

	/**
	* Returns the selected candidate pay structure master with the primary key or throws a {@link NoSuchSelectedCandidatePayStructureMasterException} if it could not be found.
	*
	* @param candidatePayStructureMasterId the primary key of the selected candidate pay structure master
	* @return the selected candidate pay structure master
	* @throws NoSuchSelectedCandidatePayStructureMasterException if a selected candidate pay structure master with the primary key could not be found
	*/
	public static SelectedCandidatePayStructureMaster findByPrimaryKey(
		long candidatePayStructureMasterId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureMasterException {
		return getPersistence().findByPrimaryKey(candidatePayStructureMasterId);
	}

	/**
	* Returns the selected candidate pay structure master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidatePayStructureMasterId the primary key of the selected candidate pay structure master
	* @return the selected candidate pay structure master, or <code>null</code> if a selected candidate pay structure master with the primary key could not be found
	*/
	public static SelectedCandidatePayStructureMaster fetchByPrimaryKey(
		long candidatePayStructureMasterId) {
		return getPersistence().fetchByPrimaryKey(candidatePayStructureMasterId);
	}

	public static java.util.Map<java.io.Serializable, SelectedCandidatePayStructureMaster> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the selected candidate pay structure masters.
	*
	* @return the selected candidate pay structure masters
	*/
	public static List<SelectedCandidatePayStructureMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the selected candidate pay structure masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of selected candidate pay structure masters
	* @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	* @return the range of selected candidate pay structure masters
	*/
	public static List<SelectedCandidatePayStructureMaster> findAll(int start,
		int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the selected candidate pay structure masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of selected candidate pay structure masters
	* @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of selected candidate pay structure masters
	*/
	public static List<SelectedCandidatePayStructureMaster> findAll(int start,
		int end,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the selected candidate pay structure masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of selected candidate pay structure masters
	* @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of selected candidate pay structure masters
	*/
	public static List<SelectedCandidatePayStructureMaster> findAll(int start,
		int end,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the selected candidate pay structure masters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of selected candidate pay structure masters.
	*
	* @return the number of selected candidate pay structure masters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SelectedCandidatePayStructureMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SelectedCandidatePayStructureMasterPersistence, SelectedCandidatePayStructureMasterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SelectedCandidatePayStructureMasterPersistence.class);

		ServiceTracker<SelectedCandidatePayStructureMasterPersistence, SelectedCandidatePayStructureMasterPersistence> serviceTracker =
			new ServiceTracker<SelectedCandidatePayStructureMasterPersistence, SelectedCandidatePayStructureMasterPersistence>(bundle.getBundleContext(),
				SelectedCandidatePayStructureMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}